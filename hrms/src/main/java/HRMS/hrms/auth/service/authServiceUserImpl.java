package HRMS.hrms.auth.service;

import HRMS.hrms.auth.dto.authUserRequestDto;
import HRMS.hrms.auth.dto.loginDto;
import HRMS.hrms.auth.dto.sendOtpdto;
import HRMS.hrms.auth.mapper.authToDtoUserMapper;
import HRMS.hrms.config.JwtConfig;
import HRMS.hrms.auth.dto.authUserResponseDto;
import HRMS.hrms.auth.exception.userNotCreated;
import HRMS.hrms.auth.exception.userNotFOundException;
import HRMS.hrms.auth.mapper.authToEntityUserMapper;
import HRMS.hrms.auth.model.authModelUser;
import HRMS.hrms.auth.repository.authRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;


@Service
public class authServiceUserImpl implements authServiceUser {

    @Autowired
    private  sendOtp sendOtp;
    @Autowired
    private  authRepo userRepo;
    @Autowired
    private  JwtConfig jwtConfig;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private  authToEntityUserMapper authMapper;
    @Autowired
    private authToDtoUserMapper authToDtoUserMapper;

    private SecureRandom secureRandom = new SecureRandom();


    public authModelUser createUser(authModelUser user,HttpServletResponse response) throws userNotCreated {
        if (user == null || user.getEmail() == null || user.getEmail().isBlank()
                || user.getPassword() == null || user.getPassword().isBlank()) {
            throw new userNotCreated("Email and password are required");
        }

        authModelUser authUser = userRepo.findByEmail(user.getEmail())
                .orElseThrow(() -> new userNotFOundException(
                        "Complete email verification before setting a password"));
        authUser.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getCompanyId() != null) {
            authUser.setCompanyId(user.getCompanyId());
        }

        authModelUser savedUser = userRepo.save(authUser);
        addAccessTokenCookie(savedUser, response);
        return savedUser;
    }


//
//    public void createUserUsingEmail(
//            authUserRequestDto user,
//            HttpServletResponse response,
//            roles role
//    ) throws userNotCreated {
//
//        try {
//            if (user.getEmail() == null || user.getEmail().isBlank() || role == null) {
//                throw new userNotCreated("Please fill all the fields");
//            }
//
//            authModelUser authModel = new authModelUser();
//
//            authModel.setEmail(user.getEmail());
//            authModel.setRole(role);
//            long currentTime = System.currentTimeMillis();
//
//            authModel.setTokenCreatedAt(currentTime);
//            authModel.setTokenExpiresIn(30 * 60 * 1000L); // 30 minutes
//
//
//            userRepo.save(authModel);
//
//        } catch (userNotCreated e) {
//            throw e;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new userNotCreated(e.getMessage());
//        }
//    }
//




    public void sendOtp(sendOtpdto otpData) {
        if (otpData == null || otpData.getEmail() == null || otpData.getEmail().isBlank()
                || otpData.getRole() == null) {
            throw new IllegalArgumentException("Email and role are required");
        }

        Long num = secureRandom.nextLong(1_000_000);

        authModelUser user = userRepo.findByEmail(otpData.getEmail())
                .orElseGet(() -> {
                    authModelUser newUser = new authModelUser();
                    newUser.setEmail(otpData.getEmail());

                    return newUser;
                });

        user.setOtp(num);
        if (user.getRole() == null) {
            user.setRole(otpData.getRole());
        }
        userRepo.save(user);

        sendOtp.GenerateOtpAndSend(otpData.getEmail(), num);
    }

    public String validateOtp(String email, Long otp) throws userNotFOundException {
        if (email == null || email.isBlank() || otp == null) {
            throw new IllegalArgumentException("Email and OTP are required");
        }

        authModelUser user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new userNotFOundException(
                                "User not found with this email"));

        if (user.getOtp() == null || !user.getOtp().equals(otp)) {
            return "Invalid OTP";
        }

        user.setOtp(null);
        userRepo.save(user);
        return "OTP validated successfully,User Successfully Created";
    }

    @Override
    public void deleteUser(Long id) {
        authModelUser foundUser = userRepo.findById(id).orElseThrow(() ->
                new userNotFOundException("user not found with this id"));
        userRepo.delete(foundUser);
    }

    @Override
    public void updateUser(Long id, authUserResponseDto user) {
        if (user == null) {
            throw new IllegalArgumentException("User update cannot be null");
        }
        authModelUser existing = userRepo.findById(id)
                .orElseThrow(() ->
                        new userNotFOundException("User not found with this id"));
        if (user.getEmail() != null && !user.getEmail().isBlank()
                && !user.getEmail().equals(existing.getEmail())) {
            userRepo.findByEmail(user.getEmail()).ifPresent(duplicate -> {
                if (!duplicate.getId().equals(id)) {
                    throw new IllegalArgumentException("Email is already in use");
                }
            });
            existing.setEmail(user.getEmail());
        }
        if (user.getRole() != null && !user.getRole().isBlank()) {
            try {
                existing.setRole(HRMS.hrms.auth.enumRoles.roles.valueOf(user.getRole()));
            } catch (IllegalArgumentException exception) {
                throw new IllegalArgumentException("Invalid user role: " + user.getRole(), exception);
            }
        }
        userRepo.save(existing);
    }


    public authModelUser login(loginDto user, HttpServletResponse response) throws userNotFOundException {
        if (user == null || user.getEmail() == null || user.getPassword() == null) {
            throw new userNotFOundException("Invalid email or password");
        }

        authModelUser foundUser=userRepo.findByEmail(user.getEmail())
                .orElseThrow(() ->
                        new userNotFOundException("Invalid email or password"));

        if (!passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            throw new userNotFOundException("Invalid email or password");
        }

        addAccessTokenCookie(foundUser, response);
        return foundUser;

    }

    private void addAccessTokenCookie(authModelUser user, HttpServletResponse response) {
        String token = jwtConfig.generateAccessToken(user);
        Cookie cookie = new Cookie("accessToken", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
    }

    @Override
    public authUserResponseDto forgetPassword(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        authModelUser user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new userNotFOundException("User not found with this email"));
        Long otp = secureRandom.nextLong(1_000_000);
        user.setOtp(otp);
        userRepo.save(user);
        sendOtp.GenerateOtpAndSend(email, otp);
        return authToDtoUserMapper.toDto(user);
    }
}

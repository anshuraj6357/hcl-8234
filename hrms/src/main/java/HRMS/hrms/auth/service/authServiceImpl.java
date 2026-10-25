package HRMS.hrms.auth.service;

import HRMS.hrms.config.jwtConfig;
import HRMS.hrms.auth.dto.authDto;
import HRMS.hrms.auth.exception.userNotCreated;
import HRMS.hrms.auth.exception.userNotFOundException;
import HRMS.hrms.auth.mapper.authMapper;
import HRMS.hrms.auth.model.authModel;
import HRMS.hrms.auth.repository.authRepo;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;


@Service
public class authServiceImpl implements authService {

    @Autowired
    private sendOtp sendOtp;
    @Autowired
     private authRepo userRepo;
    @Autowired
    private authMapper userMapper;
    @Autowired
    private jwtConfig jwtConfig;

    private SecureRandom secureRandom = new SecureRandom();

    @Override
    public authDto createUser(authModel user, HttpServletResponse response) throws userNotCreated {
        try {
            if (user.getEmail() == null || user.getPassword() == null || user.getConfermPassword() == null || user.getRole() == null) {
                throw new userNotCreated("Please fill all the field");
            }
            if (!user.getPassword().equals(user.getConfermPassword())) {
                throw new userNotCreated("Passwords do not match");
            }


            authModel savedUser = userRepo.save(user);
            Long num=secureRandom.nextLong(1_000_000);
            savedUser.setOtp(num);

            authDto userdto = userMapper.toEntity(savedUser);


            String token = jwtConfig.generateAccessToken(savedUser);
            Cookie cookie = new Cookie("accessToken", token);

            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60); // 1 day


            response.addCookie(cookie);

            return userdto;

        } catch (Exception e) {
            e.printStackTrace();
            throw new userNotCreated(e.getMessage());
        }
    }

    public void sendOtp(String email)  {
        authModel user = userRepo.findByEmail(email).orElseThrow(()->
                new userNotFOundException("user not found with this email"));
        Long otp=user.getOtp();
        sendOtp.GenerateOtpAndSend(email,otp);
    }

    public String validateOtp(String email, Long otp) throws userNotFOundException {

        authModel user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new userNotFOundException(
                                "User not found with this email"));

        if (user.getOtp() == null || !user.getOtp().equals(otp)) {
            userRepo.delete(user);
            return "Invalid OTP";
        }

        return "OTP validated successfully,User Successfully Created";
    }

    @Override
    public void deleteUser(Integer id) {
        authModel foundUser=userRepo.findById(id).orElseThrow(()->
                new userNotFOundException("user not found with this id"));
        userRepo.delete(foundUser);
    }

    @Override
    public void updateUser(Integer id, authDto user) {

    }


    public void login(authDto user) throws userNotFOundException{
        userRepo.findByEmail(user.getEmail())
                .orElseThrow(()->
                        new userNotFOundException("user not found"));

    }

    @Override
    public authDto forgetPassword(String email) {
        return null;
    }
}

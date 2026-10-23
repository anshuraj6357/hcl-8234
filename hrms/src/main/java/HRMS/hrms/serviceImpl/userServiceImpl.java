package HRMS.hrms.serviceImpl;

import HRMS.hrms.config.jwtConfig;
import HRMS.hrms.dto.userDto;
import HRMS.hrms.exception.user.userNotCreated;
import HRMS.hrms.exception.user.userNotFOundException;
import HRMS.hrms.mapper.userMapper;
import HRMS.hrms.model.userModel;
import HRMS.hrms.repository.userRepo;
import HRMS.hrms.service.userService;
import HRMS.hrms.utils.sendOtp;
import jakarta.servlet.http.HttpServlet;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Map;




@Service
public class userServiceImpl implements userService {

    @Autowired
    private sendOtp sendOtp;
    @Autowired
     private userRepo userRepo;
    @Autowired
    private userMapper userMapper;
    @Autowired
    private jwtConfig jwtConfig;

    private SecureRandom secureRandom = new SecureRandom();

    @Override
    public userDto createUser(userModel user, HttpServletResponse response) throws userNotCreated {
        try {
            if (user.getEmail() == null || user.getPassword() == null || user.getConfermPassword() == null || user.getRole() == null) {
                throw new userNotCreated("Please fill all the field");
            }
            if (!user.getPassword().equals(user.getConfermPassword())) {
                throw new userNotCreated("Passwords do not match");
            }


            userModel savedUser = userRepo.save(user);
            Long num=secureRandom.nextLong(1_000_000);
            savedUser.setOtp(num);

            userDto userdto = userMapper.toEntity(savedUser);


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
        userModel user = userRepo.findByEmail(email).orElseThrow(()->
                new userNotFOundException("user not found with this email"));
        Long otp=user.getOtp();
        sendOtp.GenerateOtpAndSend(email,otp);
    }

    public String validateOtp(String email, Long otp) throws userNotFOundException {

        userModel user = userRepo.findByEmail(email)
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
        userModel foundUser=userRepo.findById(id).orElseThrow(()->
                new userNotFOundException("user not found with this id"));
        userRepo.delete(foundUser);
    }

    @Override
    public void updateUser(Integer id, userDto user) {

    }


    public void login(userDto user) throws userNotFOundException{
        userRepo.findByEmail(user.getEmail())
                .orElseThrow(()->
                        new userNotFOundException("user not found"));

    }

    @Override
    public userDto forgetPassword(String email) {
        return null;
    }
}

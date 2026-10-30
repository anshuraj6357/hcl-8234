package HRMS.hrms.auth.service;

import HRMS.hrms.auth.dto.authUserResponseDto;
import HRMS.hrms.auth.dto.authUserRequestDto;
import HRMS.hrms.auth.dto.loginDto;
import HRMS.hrms.auth.dto.sendOtpdto;
import HRMS.hrms.auth.enumRoles.roles;
import HRMS.hrms.auth.exception.userNotCreated;
import HRMS.hrms.auth.exception.userNotFOundException;
import HRMS.hrms.auth.model.authModelUser;
import jakarta.servlet.http.HttpServletResponse;


public interface authServiceUser {

     authModelUser createUser(authModelUser user, HttpServletResponse response) throws userNotCreated;

     void deleteUser(Long id);
     void updateUser(Long id, authUserResponseDto user);

     authUserResponseDto forgetPassword(String email);
    authModelUser login(loginDto user, HttpServletResponse response);
     void sendOtp(sendOtpdto email);
     String validateOtp(String email,Long otp) throws userNotFOundException;
//    void createUserUsingEmail(authUserRequestDto user,
//                                             HttpServletResponse response,
//                                             roles role ) throws userNotCreated;
}

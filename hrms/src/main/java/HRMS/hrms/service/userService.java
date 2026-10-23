package HRMS.hrms.service;

import HRMS.hrms.dto.userDto;
import HRMS.hrms.exception.user.userNotCreated;
import HRMS.hrms.exception.user.userNotFOundException;
import HRMS.hrms.model.userModel;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;



public interface userService {

    public userDto createUser(userModel user, HttpServletResponse response) throws userNotCreated;

    public void deleteUser(Integer id);
    public void updateUser(Integer id, userDto user);

    public userDto forgetPassword(String email);
    public void login(userDto user);
    public void sendOtp(String email);
    public String validateOtp(String email,Long otp) throws userNotFOundException;
}

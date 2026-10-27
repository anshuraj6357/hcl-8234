package HRMS.hrms.auth.service;

import HRMS.hrms.auth.dto.authDto;
import HRMS.hrms.auth.exception.userNotCreated;
import HRMS.hrms.auth.exception.userNotFOundException;
import HRMS.hrms.auth.model.authModel;
import jakarta.servlet.http.HttpServletResponse;


public interface authService {

    public authDto createUser(authModel user, HttpServletResponse response) throws userNotCreated;

    public void deleteUser(Integer id);
    public void updateUser(Integer id, authDto user);

    public authDto forgetPassword(String email);
    public void login(authDto user);
    public void sendOtp(String email);
    public String validateOtp(String email,Long otp) throws userNotFOundException;
}

package HRMS.hrms.service;

import HRMS.hrms.dto.userDto;
import HRMS.hrms.exception.user.userNotCreated;
import HRMS.hrms.model.userModel;

public interface userService {

    public userDto createUser(userModel user) throws userNotCreated;
    public userDto getUserById(Integer id);
    public void deleteUser(Integer id);
    public void updateUser(Integer id, userDto user);
    public userDto getUserByEmail(String email);
    public userDto forgetPassword(String email);

}

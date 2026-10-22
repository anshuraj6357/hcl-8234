package HRMS.hrms.serviceImpl;

import HRMS.hrms.dto.userDto;
import HRMS.hrms.exception.user.userNotCreated;
import HRMS.hrms.mapper.userMapper;
import HRMS.hrms.model.userModel;
import HRMS.hrms.service.userService;
import org.springframework.beans.factory.annotation.Autowired;

public class userServiceImpl implements userService {

    @Autowired
    private userService userService;
    @Autowired
    private userMapper userMapper;

    @Override
    public userDto createUser(userModel user) throws userNotCreated {
        if(user.getEmail() == null || user.getPassword() == null || user.getConfermPassword() == null || user.getRole() == null) {
            throw new userNotCreated("User not created");
        }
        if(!user.getPassword().equals(user.getConfermPassword())) {
            throw new userNotCreated("Passwords do not match");
        }

        userDto userdto= userMapper.toEntity(user);
        return userdto;
    }

    @Override
    public userDto getUserById(Integer id) {

        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public void updateUser(Integer id, userDto user) {

    }

    @Override
    public userDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public userDto forgetPassword(String email) {
        return null;
    }
}

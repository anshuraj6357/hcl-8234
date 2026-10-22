package HRMS.hrms.mapper;

import HRMS.hrms.dto.userDto;
import HRMS.hrms.model.userModel;

public class userMapper {
    public userDto toEntity(userModel user){
        userDto userdto = new userDto();
        userdto.setEmail(user.getEmail());
        userdto.setRole(user.getRole());
        return userdto;
    }
}

package HRMS.hrms.auth.mapper;

import HRMS.hrms.auth.dto.authDtoUser;
import HRMS.hrms.auth.model.authModel;
import org.springframework.stereotype.Component;


@Component
public class authMapper {
    public authDtoUser toEntity(authModel user){
        authDtoUser userdto = new authDtoUser();
        userdto.setEmail(user.getEmail());
        userdto.setRole(user.getRole());
        return userdto;
    }
}

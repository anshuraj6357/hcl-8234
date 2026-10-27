package HRMS.hrms.auth.mapper;

import HRMS.hrms.auth.dto.authDto;
import HRMS.hrms.auth.model.authModel;
import org.springframework.stereotype.Component;


@Component
public class authMapper {
    public authDto toEntity(authModel user){
        authDto userdto = new authDto();
        userdto.setEmail(user.getEmail());
        userdto.setRole(user.getRole());
        return userdto;
    }
}

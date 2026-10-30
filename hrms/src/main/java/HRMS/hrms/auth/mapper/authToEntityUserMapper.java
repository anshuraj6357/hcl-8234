package HRMS.hrms.auth.mapper;

import HRMS.hrms.auth.dto.authUserRequestDto;
import HRMS.hrms.auth.model.authModelUser;
import org.springframework.stereotype.Component;

@Component
public class authToEntityUserMapper {

    public authModelUser toEntity(authUserRequestDto user) {

        authModelUser authModel = new authModelUser();

        authModel.setEmail(user.getEmail());
        authModel.setPassword(user.getPassword());

        return authModel;
    }
}
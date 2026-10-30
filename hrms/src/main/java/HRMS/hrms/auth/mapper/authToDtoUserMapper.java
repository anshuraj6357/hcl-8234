package HRMS.hrms.auth.mapper;

import HRMS.hrms.auth.dto.authUserResponseDto;
import HRMS.hrms.auth.model.authModelUser;
import org.springframework.stereotype.Component;

@Component
public class authToDtoUserMapper {

    public authUserResponseDto toDto(authModelUser user) {

        authUserResponseDto dto = new authUserResponseDto();

        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole() == null ? null : user.getRole().name());

        return dto;
    }
}
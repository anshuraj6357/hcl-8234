
package HRMS.hrms.organisation.location.mapper;

import HRMS.hrms.organisation.location.model.locationModel;
import HRMS.hrms.organisation.location.dto.locationResponseDto;
import org.springframework.stereotype.Component;

@Component
public class locationToDtoMapper {

    public locationResponseDto toDto(locationModel location) {

        locationResponseDto response = new locationResponseDto();

        response.setLocation_Id(location.getLocation_Id());
        response.setLocation_Code(location.getLocation_Code());
        response.setLocation_Name(location.getLocation_Name());

        if (location.getCompany_Id() != null) {
            response.setCompany_Id(
                    location.getCompany_Id().getCompany_Id()
            );
        }

        response.setLocation_Address(location.getLocation_Address());
        response.setLocation_City(location.getLocation_City());
        response.setLocation_State(location.getLocation_State());
        response.setLocation_Country(location.getLocation_Country());
        response.setLocation_Pincode(location.getLocation_Pincode());
        response.setLocation_Latitude(location.getLocation_Latitude());
        response.setLocation_Longitude(location.getLocation_Longitude());
        response.setLocation_Active(location.getLocation_Active());
        response.setLocation_CreatedAt(location.getLocation_CreatedAt());
        response.setLocation_UpdatedAt(location.getLocation_UpdatedAt());

        return response;
    }
}

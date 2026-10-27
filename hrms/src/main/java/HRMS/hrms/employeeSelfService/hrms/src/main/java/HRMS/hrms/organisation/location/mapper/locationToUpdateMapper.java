
package HRMS.hrms.organisation.location.mapper;

import HRMS.hrms.organisation.location.dto.locationRequestDto;
import HRMS.hrms.organisation.location.model.locationModel;
import org.springframework.stereotype.Component;

@Component
public class locationToUpdateMapper {

    public locationModel toUpdateEntity(
            locationModel location,
            locationRequestDto request) {

        location.setLocation_Code(request.getLocation_Code());
        location.setLocation_Name(request.getLocation_Name());

        location.setLocation_Address(request.getLocation_Address());
        location.setLocation_City(request.getLocation_City());
        location.setLocation_State(request.getLocation_State());
        location.setLocation_Country(request.getLocation_Country());
        location.setLocation_Pincode(request.getLocation_Pincode());

        location.setLocation_Latitude(request.getLocation_Latitude());
        location.setLocation_Longitude(request.getLocation_Longitude());
        location.setLocation_Active(request.getLocation_Active());

        return location;
    }
}


package HRMS.hrms.organisation.location.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class locationRequestDto {

    private String location_Code;

    private String location_Name;

    private Long company_Id;

    private String location_Address;

    private String location_City;

    private String location_State;

    private String location_Country;

    private String location_Pincode;

    private Double location_Latitude;

    private Double location_Longitude;

    private Boolean location_Active = true;
}

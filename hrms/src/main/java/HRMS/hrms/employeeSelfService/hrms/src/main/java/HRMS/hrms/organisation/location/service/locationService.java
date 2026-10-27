package HRMS.hrms.organisation.location.service;

import HRMS.hrms.organisation.location.dto.locationRequestDto;
import HRMS.hrms.organisation.location.dto.locationResponseDto;
import HRMS.hrms.organisation.location.model.locationModel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface locationService {

    locationResponseDto createLocation(locationRequestDto location);

    List<locationResponseDto> getAllLocationsByCompanyId(Long companyId);

    locationResponseDto getLocationById(Long locationId);

    locationResponseDto updateLocation(Long locationId, locationRequestDto location);

    void deleteLocation(Long locationId);
}
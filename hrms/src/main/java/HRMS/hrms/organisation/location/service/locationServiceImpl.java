package HRMS.hrms.organisation.location.service;


import HRMS.hrms.organisation.location.Repository.locationRepo;
import HRMS.hrms.organisation.location.dto.locationRequestDto;
import HRMS.hrms.organisation.location.dto.locationResponseDto;
import HRMS.hrms.organisation.location.mapper.locationToDtoMapper;
import HRMS.hrms.organisation.location.mapper.locationToEntityMapper;
import HRMS.hrms.organisation.location.mapper.locationToUpdateMapper;
import HRMS.hrms.organisation.location.model.locationModel;
import HRMS.hrms.organisation.location.Repository.locationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class locationServiceImpl implements locationService {


    @Autowired
    private locationRepo locationRepo;
    private locationToDtoMapper locationToDtoMapper;
    private locationToEntityMapper locationToEntityMapper;
    private locationToUpdateMapper locationToUpdateMapper;

    public locationResponseDto createLocation(locationRequestDto location){
        locationModel newLocation = locationToEntityMapper.ToEntity(location);

        return null;
    }
    public List<locationResponseDto> getAllLocationsByCompanyId(Long companyId){



       List<locationModel>  allLocation=locationRepo.findAllByCompany_Id(companyId);

       return allLocation.stream()
               .map(locationToDtoMapper::toDto)
               .toList();
    }
    @Override
    public locationResponseDto getLocationById(Long locationId) {

        locationModel location = locationRepo.findById(locationId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Location not found with ID: " + locationId
                        ));

        return locationToDtoMapper.toDto(location);
    }

    @Override
    public locationResponseDto updateLocation(
            Long locationId,
            locationRequestDto location) {

        locationModel existingLocation = locationRepo.findById(locationId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Location not found with ID: " + locationId));

        locationToUpdateMapper.toUpdateEntity(existingLocation, location);

        locationModel updatedLocation = locationRepo.save(existingLocation);

        return locationToDtoMapper.toDto(updatedLocation);
    }

    @Override
    public void deleteLocation(Long locationId) {

        locationModel location = locationRepo.findById(locationId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Location not found with ID: " + locationId));

        locationRepo.delete(location);
    }
}

package HRMS.hrms.organisation.location.service;


import HRMS.hrms.organisation.company.Repository.companyRepository;
import HRMS.hrms.organisation.company.model.companyModel;
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
    @Autowired
    private locationToDtoMapper locationToDtoMapper;
    @Autowired
    private locationToEntityMapper locationToEntityMapper;
    @Autowired
    private locationToUpdateMapper locationToUpdateMapper;
    @Autowired
    private companyRepository companyRepository;


    public locationModel createLocation(locationRequestDto location) throws RuntimeException{
        if (location == null) {
            throw new RuntimeException("Location request cannot be null");
        }
        if (location.getCompany_Id() == null) {
            throw new RuntimeException("Company ID is required to create a location");
        }

        companyModel companyModel = companyRepository.findById(location.getCompany_Id())
                .orElseThrow(() -> new RuntimeException("company Not created"));

        locationModel newLocation = locationToEntityMapper.ToEntity(location);
        newLocation.setCompany_Id(companyModel);

        return locationRepo.save(newLocation);
    }
//    public List<locationResponseDto> getAllLocationsByCompanyId(Long companyId){
//
//
//
//       List<locationModel>  allLocation=locationRepo.findAllByCompany_Id(companyId);
//
//       return allLocation.stream()
//               .map(locationToDtoMapper::toDto)
//               .toList();
//    }
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

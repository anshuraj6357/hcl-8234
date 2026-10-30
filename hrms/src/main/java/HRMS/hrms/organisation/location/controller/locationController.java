package HRMS.hrms.organisation.location.controller;

import HRMS.hrms.organisation.location.dto.locationRequestDto;
import HRMS.hrms.organisation.location.dto.locationResponseDto;
import HRMS.hrms.organisation.location.mapper.locationToDtoMapper;
import HRMS.hrms.organisation.location.mapper.locationToEntityMapper;
import HRMS.hrms.organisation.location.mapper.locationToUpdateMapper;
import HRMS.hrms.organisation.location.model.locationModel;
import HRMS.hrms.organisation.location.service.locationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class locationController {

    @Autowired
    private  locationService locationService;
    @Autowired
    private  locationToEntityMapper locationToEntityMapper;
    @Autowired
    private  locationToDtoMapper locationToDtoMapper;
    @Autowired
    private  locationToUpdateMapper locationToUpdateMapper;



    // Create Location
    @PostMapping("/create")
    public ResponseEntity<locationModel> createLocation(
            @RequestBody locationRequestDto request) {

        locationModel savedLocation =
                locationService.createLocation(request);


        return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
    }

    // Get All Locations
//    @GetMapping("{companyId}")
//    public ResponseEntity<List<locationResponseDto>> getAllLocations(@PathVariable Long companyId) {
//
//        List<locationResponseDto> locations =
//                locationService.getAllLocationsByCompanyId(companyId);
//        return ResponseEntity.ok(locations);
//    }

    // Get Location By ID
    @GetMapping("/{locationId}")
    public ResponseEntity<locationResponseDto> getLocationById(
            @PathVariable Long locationId) {

        locationResponseDto location =
                locationService.getLocationById(locationId);

        return ResponseEntity.ok(location);
    }

    // Update Location
    @PutMapping("/{locationId}")
    public ResponseEntity<locationResponseDto> updateLocation(
            @PathVariable Long locationId,
            @RequestBody locationRequestDto request) {

        locationResponseDto updatedLocation =
                locationService.updateLocation(locationId, request);

        return ResponseEntity.ok(
             updatedLocation);
    }

    // Delete Location
    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> deleteLocation(
            @PathVariable Long locationId) {

        locationService.deleteLocation(locationId);

        return ResponseEntity.noContent().build();
    }
}
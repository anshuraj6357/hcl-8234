package HRMS.hrms.assets.maintenance.controller;

import HRMS.hrms.assets.maintenance.dto.maintenanceToRequestDto;
import HRMS.hrms.assets.maintenance.dto.maintenanceToResponseDto;
import HRMS.hrms.assets.maintenance.service.maintenanceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maintenance")
public class maintenanceController {

    @Autowired
    private maintenanceservice maintenanceService;

    // Create Maintenance
    @PostMapping
    public ResponseEntity<maintenanceToResponseDto> createMaintenance(
            @RequestBody maintenanceToRequestDto maintenance) {

        maintenanceToResponseDto response =
                maintenanceService.createMaintenance(maintenance);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Get All Maintenance
//    @GetMapping
//    public ResponseEntity<List<maintenanceToResponseDto>> getAllMaintenance() {
//
//        List<maintenanceToResponseDto> response =
//                maintenanceService.getAllMaintenance();
//
//        return ResponseEntity.ok(response);
//    }

    // Get Maintenance By ID
    @GetMapping("/{maintenanceId}")
    public ResponseEntity<maintenanceToResponseDto> getMaintenanceById(
            @PathVariable Long maintenanceId) {

        maintenanceToResponseDto response =
                maintenanceService.getMaintenanceById(maintenanceId);

        return ResponseEntity.ok(response);
    }

    // Update Maintenance
    @PutMapping("/{maintenanceId}")
    public ResponseEntity<maintenanceToResponseDto> updateMaintenance(
            @PathVariable Long maintenanceId,
            @RequestBody maintenanceToRequestDto maintenance) {

        maintenanceToResponseDto response =
                maintenanceService.updateMaintenance(maintenanceId, maintenance);

        return ResponseEntity.ok(response);
    }

    // Delete Maintenance
    @DeleteMapping("/{maintenanceId}")
    public ResponseEntity<Void> deleteMaintenance(
            @PathVariable Long maintenanceId) {

        maintenanceService.deleteMaintenance(maintenanceId);

        return ResponseEntity.noContent().build();
    }
}
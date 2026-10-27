package HRMS.hrms.assets.allocation.controller;

import HRMS.hrms.assets.allocation.dto.allocationRequestDto;
import HRMS.hrms.assets.allocation.dto.allocationResponseDto;
import HRMS.hrms.assets.allocation.service.allocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocations")
public class allocationController {

    @Autowired
    private allocationService allocationService;

    // Create Allocation
    @PostMapping
    public ResponseEntity<allocationResponseDto> createAllocation(
            @RequestBody allocationRequestDto allocation) {

        allocationResponseDto response =
                allocationService.createAllocation(allocation);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Get All Allocations
    @GetMapping
    public ResponseEntity<List<allocationResponseDto>> getAllAllocations() {

        List<allocationResponseDto> response =
                allocationService.getAllAllocations();

        return ResponseEntity.ok(response);
    }

    // Get Allocation By ID
    @GetMapping("/{allocationId}")
    public ResponseEntity<allocationResponseDto> getAllocationById(
            @PathVariable Long allocationId) {

        allocationResponseDto response =
                allocationService.getAllocationById(allocationId);

        return ResponseEntity.ok(response);
    }

    // Update Allocation
    @PutMapping("/{allocationId}")
    public ResponseEntity<allocationResponseDto> updateAllocation(
            @PathVariable Long allocationId,
            @RequestBody allocationRequestDto allocation) {

        allocationResponseDto response =
                allocationService.updateAllocation(allocationId, allocation);

        return ResponseEntity.ok(response);
    }

    // Delete Allocation
    @DeleteMapping("/{allocationId}")
    public ResponseEntity<Void> deleteAllocation(
            @PathVariable Long allocationId) {

        allocationService.deleteAllocation(allocationId);

        return ResponseEntity.noContent().build();
    }
}
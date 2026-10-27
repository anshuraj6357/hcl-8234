package HRMS.hrms.assets.allocation.service;

import HRMS.hrms.assets.allocation.dto.allocationRequestDto;
import HRMS.hrms.assets.allocation.dto.allocationResponseDto;

import java.util.List;

public interface allocationService {

    // Create Allocation
    allocationResponseDto createAllocation(
            allocationRequestDto allocation);

    // Get All Allocations
    List<allocationResponseDto> getAllAllocations();

    // Get Allocation By ID
    allocationResponseDto getAllocationById(Long allocationId);

    // Update Allocation
    allocationResponseDto updateAllocation(
            Long allocationId,
            allocationRequestDto allocation);

    // Delete Allocation
    void deleteAllocation(Long allocationId);
}
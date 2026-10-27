package HRMS.hrms.assets.allocation.service;

import HRMS.hrms.assets.allocation.dto.allocationRequestDto;
import HRMS.hrms.assets.allocation.dto.allocationResponseDto;
import HRMS.hrms.assets.allocation.mapper.allocationToDtoMapper;
import HRMS.hrms.assets.allocation.mapper.allocationToEntityMapper;
import HRMS.hrms.assets.allocation.mapper.allocationToUpdateMapper;
import HRMS.hrms.assets.allocation.model.allocationModel;
import HRMS.hrms.assets.allocation.repository.allocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class allocationServiceImpl implements allocationService {

    @Autowired
    private allocationRepository allocationRepository;

    @Autowired
    private allocationToEntityMapper allocationToEntityMapper;

    @Autowired
    private allocationToDtoMapper allocationToDtoMapper;

    @Autowired
    private allocationToUpdateMapper allocationToUpdateMapper;


    // Create Allocation
    @Override
    public allocationResponseDto createAllocation(
            allocationRequestDto allocation) {

        allocationModel allocationModel =
                allocationToEntityMapper.toEntity(allocation);

        allocationModel savedAllocation =
                allocationRepository.save(allocationModel);

        return allocationToDtoMapper.toDto(savedAllocation);
    }


    // Get All Allocations
    @Override
    public List<allocationResponseDto> getAllAllocations() {

        return allocationRepository.findAll()
                .stream()
                .map(allocationToDtoMapper::toDto)
                .collect(Collectors.toList());
    }


    // Get Allocation By ID
    @Override
    public allocationResponseDto getAllocationById(Long allocationId) {

        allocationModel allocation =
                allocationRepository.findById(allocationId)
                        .orElseThrow(() -> new RuntimeException(
                                "Allocation not found with ID: " + allocationId));

        return allocationToDtoMapper.toDto(allocation);
    }


    // Update Allocation
    @Override
    public allocationResponseDto updateAllocation(
            Long allocationId,
            allocationRequestDto allocation) {

        allocationModel existingAllocation =
                allocationRepository.findById(allocationId)
                        .orElseThrow(() -> new RuntimeException(
                                "Allocation not found with ID: " + allocationId));

        allocationModel updatedAllocation =
                allocationToUpdateMapper.toUpdateEntity(
                        existingAllocation, allocation);

        allocationModel savedAllocation =
                allocationRepository.save(updatedAllocation);

        return allocationToDtoMapper.toDto(savedAllocation);
    }


    // Delete Allocation
    @Override
    public void deleteAllocation(Long allocationId) {

        allocationModel allocation =
                allocationRepository.findById(allocationId)
                        .orElseThrow(() -> new RuntimeException(
                                "Allocation not found with ID: " + allocationId));

        allocationRepository.delete(allocation);
    }
}
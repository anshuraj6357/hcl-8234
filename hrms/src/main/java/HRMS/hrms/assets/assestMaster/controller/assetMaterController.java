package HRMS.hrms.assets.assestMaster.controller;

import java.util.List;

import HRMS.hrms.assets.assestMaster.service.assetMasterServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import HRMS.hrms.assets.assestMaster.dto.assetMasterRequestDto;
import HRMS.hrms.assets.assestMaster.dto.assetMasterResponseDto;
import HRMS.hrms.assets.assestMaster.service.assetMasterService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/asset-masters")
@RequiredArgsConstructor
public class assetMaterController {

    @Autowired
    private  assetMasterServiceImp assetMasterService;

    // Create Asset Master
    @PostMapping
    public ResponseEntity<assetMasterResponseDto> createAssetMaster(
            @RequestBody assetMasterRequestDto request) {

        assetMasterResponseDto response =
                assetMasterService.createAssetMaster(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get All Asset Masters
    @GetMapping
    public ResponseEntity<List<assetMasterResponseDto>> getAllAssetMasters() {

        List<assetMasterResponseDto> response =
                assetMasterService.getAllAssetMasters();

        return ResponseEntity.ok(response);
    }

    // Get Asset Master By ID
    @GetMapping("/{assetMaster_Id}")
    public ResponseEntity<assetMasterResponseDto> getAssetMasterById(
            @PathVariable Long assetMaster_Id) {

        assetMasterResponseDto response =
                assetMasterService.getAssetMasterById(assetMaster_Id);

        return ResponseEntity.ok(response);
    }

    // Update Asset Master
    @PutMapping("/{assetMaster_Id}")
    public ResponseEntity<assetMasterResponseDto> updateAssetMaster(
            @PathVariable Long assetMaster_Id,
            @RequestBody assetMasterRequestDto request) {

        assetMasterResponseDto response =
                assetMasterService.updateAssetMaster(assetMaster_Id, request);

        return ResponseEntity.ok(response);
    }

    // Delete Asset Master
    @DeleteMapping("/{assetMaster_Id}")
    public ResponseEntity<Void> deleteAssetMaster(
            @PathVariable Long assetMaster_Id) {

        assetMasterService.deleteAssetMaster(assetMaster_Id);

        return ResponseEntity.noContent().build();
    }
}
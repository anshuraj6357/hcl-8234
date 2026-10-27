package HRMS.hrms.assets.asset.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import HRMS.hrms.assets.asset.dto.assetToRequestDto;
import HRMS.hrms.assets.asset.dto.assetToResponseDto;
import HRMS.hrms.assets.asset.service.assetService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
public class assetController {

    private final assetService assetService;

    // Create Asset
    @PostMapping
    public ResponseEntity<assetToResponseDto> createAsset(
            @RequestBody assetToRequestDto request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(assetService.createAsset(request));
    }

    // Get All Assets
    @GetMapping
    public ResponseEntity<List<assetToResponseDto>> getAllAssets() {

        return ResponseEntity.ok(assetService.getAllAssets());
    }

    // Get Asset By ID
    @GetMapping("/{asset_Id}")
    public ResponseEntity<assetToResponseDto> getAssetById(
            @PathVariable Long asset_Id) {

        return ResponseEntity.ok(
                assetService.getAssetById(asset_Id));
    }

    // Update Asset
    @PutMapping("/{asset_Id}")
    public ResponseEntity<assetToResponseDto> updateAsset(
            @PathVariable Long asset_Id,
            @RequestBody assetToRequestDto request) {

        return ResponseEntity.ok(
                assetService.updateAsset(asset_Id, request));
    }

    // Delete Asset
    @DeleteMapping("/{asset_Id}")
    public ResponseEntity<Void> deleteAsset(
            @PathVariable Long asset_Id) {

        assetService.deleteAsset(asset_Id);

        return ResponseEntity.noContent().build();
    }
}

        package HRMS.hrms.organisation.branch.service;

import HRMS.hrms.organisation.branch.model.branchModel;

import java.util.List;

public interface branchService {

    // Create branch
    branchModel createBranch(branchModel branch);

    // Get all branches
    List<branchModel> getAllBranches();

    // Get branch by ID
    branchModel getBranchById(Long branchId);

    // Update branch
    branchModel updateBranch(Long branchId, branchModel branch);

    // Delete branch
    void deleteBranch(Long branchId);
}

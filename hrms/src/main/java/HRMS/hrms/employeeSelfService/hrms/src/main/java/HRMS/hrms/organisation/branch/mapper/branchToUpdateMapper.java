package HRMS.hrms.organisation.branch.mapper;
import HRMS.hrms.organisation.branch.dto.branchRequestDto;
import HRMS.hrms.organisation.branch.model.branchModel;
import org.springframework.stereotype.Component;

@Component
public class branchToUpdateMapper {

    public branchModel toUpdateEntity(
            branchModel branch,
            branchRequestDto request) {

        branch.setBranch_Code(request.getBranch_Code());
        branch.setBranch_Name(request.getBranch_Name());
        branch.setBranch_Pincode(request.getBranch_Pincode());
        branch.setBranch_Active(request.getBranch_Active());
        branch.setBranch_State(request.getBranch_State());
        branch.setBranch_Address(request.getBranch_Address());
        branch.setBranch_City(request.getBranch_City());

        return branch;
    }
}
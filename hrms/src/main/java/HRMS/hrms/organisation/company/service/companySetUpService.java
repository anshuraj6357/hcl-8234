package HRMS.hrms.organisation.company.service;


import HRMS.hrms.auth.service.authServiceUserImpl;
import HRMS.hrms.organisation.company.dto.companyRequestDto;
import HRMS.hrms.organisation.company.dto.companySetupRequestDto;
import HRMS.hrms.organisation.company.exception.companyNotCreatedException;
import HRMS.hrms.organisation.location.service.locationServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class companySetUpService {


    @Autowired
    private companyServiceImpl companyServiceImpl;
    @Autowired
    private locationServiceImpl locationServiceImpl;
    @Autowired
    private authServiceUserImpl authServiceUserImpl;


    @Transactional
    public Long createCompanySetup(companySetupRequestDto company, HttpServletResponse response) {
        if (company == null
                || company.getCompanyRequestDto() == null
                || company.getLocationRequestDto() == null
                || company.getAuthUserRequestDto() == null) {
            throw new companyNotCreatedException("company not created");
        }

        var companyCreate = companyServiceImpl.createCompany(company.getCompanyRequestDto());

        var locationRequest = company.getLocationRequestDto();
        locationRequest.setCompany_Id(companyCreate.getCompany_Id());

        var locationCreate = locationServiceImpl.createLocation(locationRequest);
        locationCreate.setCompany_Id(companyCreate);
        companyCreate.setLocation_id(locationCreate);

        var profileCreate = authServiceUserImpl.createUser(company.getAuthUserRequestDto(), response);
        profileCreate.setCompanyId(companyCreate);

        return  companyCreate.getCompany_Id();
    }



}




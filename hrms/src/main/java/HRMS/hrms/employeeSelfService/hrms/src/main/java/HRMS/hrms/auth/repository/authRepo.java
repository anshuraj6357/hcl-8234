package HRMS.hrms.auth.repository;

import HRMS.hrms.auth.model.authModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface authRepo extends JpaRepository<authModel,Integer>{

    Optional<authModel> findByEmail(String email);


}

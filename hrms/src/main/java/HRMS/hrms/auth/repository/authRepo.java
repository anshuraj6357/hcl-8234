package HRMS.hrms.auth.repository;

import HRMS.hrms.auth.model.authModelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface authRepo extends JpaRepository<authModelUser,Long>{

    Optional<authModelUser> findByEmail(String email);


}

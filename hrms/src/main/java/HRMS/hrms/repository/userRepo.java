package HRMS.hrms.repository;

import HRMS.hrms.model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface userRepo extends JpaRepository<userModel,Integer>{

    Optional<userModel> findByEmail(String email);


}

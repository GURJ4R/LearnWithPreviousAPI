package com.learnWithPrevious.portal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnWithPrevious.portal.entity.UserRegistrationEntity;



@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationEntity,Long>{
	UserRegistrationEntity findByRegistrationId(Long registrationId);
}

package com.learnWithPrevious.portal.entity;


import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trn_user_registration") // Specify the table name here
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long registrationId;
	String applicationNumber;
	String userName;
	String userPassword;
	String createdBy;
	Timestamp createdOn;
}

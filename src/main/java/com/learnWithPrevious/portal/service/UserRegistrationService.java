package com.learnWithPrevious.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.learnWithPrevious.portal.entity.UserRegistrationEntity;
import com.learnWithPrevious.portal.repository.UserRegistrationRepository;
import com.learnWithPrevious.portal.utility.PortalUtility;
import com.learnWithPrevious.portal.vo.RequestVo;
import com.learnWithPrevious.portal.vo.ResponseVo;

import lombok.RequiredArgsConstructor;

@Service
//@slf4j
@RequiredArgsConstructor
@EnableTransactionManagement
public class UserRegistrationService {
	
	private UserRegistrationRepository userRegistrationRepository;
	
	public ResponseVo userRegister(RequestVo requestVo) {
		ResponseVo responseVo=null;
		UserRegistrationEntity entity=null;
		try {
			responseVo=new ResponseVo();
			UserRegistrationEntity userRegistrationEntity=(UserRegistrationEntity)PortalUtility.ConvertJsonToEntity(requestVo, UserRegistrationEntity.class);
			userRegistrationEntity.setCreatedBy(userRegistrationEntity.getUserName());
			userRegistrationEntity.setApplicationNumber(PortalUtility.getTxnRefNo());
			userRegistrationEntity.setCreatedOn(PortalUtility.getCurrentDateTime());
			entity=userRegistrationRepository.save(userRegistrationEntity);
			responseVo.setData(userRegistrationEntity);
			PortalUtility.createSuccessResponse(responseVo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseVo;
	}

}

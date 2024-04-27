package com.learnWithPrevious.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnWithPrevious.portal.service.UserRegistrationService;
import com.learnWithPrevious.portal.vo.RequestVo;
import com.learnWithPrevious.portal.vo.ResponseVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@ControllerAdvice
@RequestMapping(path="/user-registration")

public class UserController {
	
	@Autowired
	private  UserRegistrationService userRegistrationService;
	
	@PostMapping("")
	public ResponseEntity<ResponseVo> userLogin(@RequestBody RequestVo requestVo){
		ResponseVo responseVo=null;
		try {
			responseVo=userRegistrationService.userRegister(requestVo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	   return new ResponseEntity<>(responseVo,HttpStatus.OK);
	}
}

package com.learnWithPrevious.portal.utility;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.learnWithPrevious.portal.vo.RequestVo;
import com.learnWithPrevious.portal.vo.ResponseVo;
import com.learnWithPrevious.portal.vo.SubResponseVo;

public class PortalUtility {
	private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Object ConvertJsonToEntity(Object  iObject, Class<?> entityType) {
    	Object result=null;
    	RequestVo requestVo=null;
    	ResponseVo responseVo=null;
        try {
        	ObjectMapper objectMapper=new ObjectMapper();
        	if(iObject instanceof RequestVo) {
        		requestVo=(RequestVo)iObject;
        		result=objectMapper.convertValue(requestVo.getData(),entityType);
        	}else if(iObject instanceof ResponseVo) {
        		responseVo=(ResponseVo)iObject;
        		result=objectMapper.convertValue(requestVo.getData(),entityType);
        	}else if(iObject instanceof String) {
        		String json=(String)iObject;
        		result=objectMapper.readValue(json,entityType);
        	}
        	
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
    
    public static Timestamp getCurrentDateTime() {
    	return new Timestamp(System.currentTimeMillis());
    }
    
    public static String getTxnRefNo() {
    	Date currentDate=new Date();
    	SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_TIME);
    	return simpleDateFormat.format(currentDate);
    }
    
    public static void createSuccessResponse(ResponseVo responseVo) {
        // Assuming ResponseVo is a class representing the response data
        // Create a success response with the provided responseVo
    	try {
    		 ObjectMapper successResponse = new ObjectMapper();
    	        List<SubResponseVo> subResponses=new ArrayList<>();
    	        SubResponseVo subResponse=new SubResponseVo(Constants.SUCCESS_CODE,Constants.SUCCESS);
    	        subResponses.add(subResponse);
    	        ArrayNode arrayNode=successResponse.valueToTree(subResponses);
    	        String jsonInString=successResponse.writeValueAsString(responseVo);
    	        JsonNode rootNode=successResponse.readTree(jsonInString);
    	        ((ObjectNode)rootNode).put(Constants.RESPONSE_CODE,Constants.SUCCESS_CODE);
    	        ((ObjectNode)rootNode).set(Constants.RESPONSE_MESSAGE, arrayNode);
    	        
    	        responseVo.setData(rootNode);

    	}catch(Exception e) {
    		e.printStackTrace();
    	}
       
    }
    
    
    
    
    
}

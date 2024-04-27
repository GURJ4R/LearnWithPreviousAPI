package com.learnWithPrevious.portal.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility=Visibility.ANY,getterVisibility=Visibility.NONE,setterVisibility=Visibility.NONE)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVo {
	@JsonProperty("data")
    private Object data;
	
	
}

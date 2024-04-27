package com.learnWithPrevious.portal.vo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility=Visibility.ANY,getterVisibility=Visibility.ANY,setterVisibility=Visibility.ANY)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubResponseVo {
	@JsonProperty("subResponseCode")
    private Object subResponseCode;
	
	@JsonProperty("subResponseMessage")
    private Object subResponseMessage;
}

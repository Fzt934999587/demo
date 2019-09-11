package com.cy.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JsonResult {
	private String result; //1:成功 	2:失败
	private String code;	//1000:成功 	2000:失败
	private String message;
	private Object data;
	
	public JsonResult(String result,String code,String message) {
		
		this.result=result;
		this.code=code;
		this.message=message;
	}
	
	public JsonResult(String result,String code,String message,Object data) {
		
		this.result=result;
		this.code=code;
		this.message=message;
		this.data=data;
	}
}

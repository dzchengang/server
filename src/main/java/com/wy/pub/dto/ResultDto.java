package com.wy.pub.dto;

import lombok.Data;

@Data
public class ResultDto {
   private Integer result;
   private String msg;
   
   public ResultDto(Integer result,String msg) {
	   this.result=result;
	   this.msg=msg;
   }
}

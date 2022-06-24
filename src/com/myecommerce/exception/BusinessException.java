package com.myecommerce.exception;

public class BusinessException extends Exception
{
	private String erroCode;
	private String erroMsg;
	
	public String getErroCode() {
		return erroCode;
	}
	public void setErroCode(String erroCode) {
		this.erroCode = erroCode;
	}
	public String getErroMsg() {
		return erroMsg;
	}
	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}
	public BusinessException(String msg)
	{
		super(msg);
	}
	public BusinessException()
	{
		
	}

}

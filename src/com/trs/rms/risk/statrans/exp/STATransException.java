package com.trs.rms.risk.statrans.exp;

/**
 * 
 * 
 * @author clinzy 2012-3-30
 *
 */
public class STATransException extends Exception {
	/**
	 * default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 异常code
	 */
	private int code;
	
	/**
	 * 异常信息
	 */
	private String errorMessage;

	/**
	 * 构造函数
	 * 
	 * @param _iCode
	 * 			  int 异常code
	 * @param _sErrorMessage
	 * 			  String 异常信息
	 */
	public STATransException(int _iCode, String _sErrorMessage) {
		super();
		code = _iCode;
		errorMessage = _sErrorMessage;
	}

	/**
	 * 返回异常code
	 * 
	 * @return
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * 设置异常code
	 * 
	 * @param value
	 */
	public void setCode(int value) {
		code = value;
	}
	
	/**
	 * 返回异常信息
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * 设置异常信息
	 * 
	 * @param value
	 */
	public void setErrorMessage(String value) {
		errorMessage = value;
	}
}

package com.trs.rms.risk.statrans.bean;

/**
 * 排重服务器信息
 *
 * @author clinzy 2012-4-20
 * @author zxh    2016-10-31
 */
public class RMSSIMServerInfo {
	/**
	 * 记录ID
	 */
	private Long id;

	/**
	 * 排重服务器地址
	 */
	private String host;

	/**
	 * 排重服务器端口
	 */
	private String port;
	/**
	 * 排重服务器状态信息
	 */
	private String stateDesc;

	/**
	 * 构造函数
	 */
	public RMSSIMServerInfo() {

	}

	/**
	 * 返回记录ID
	 *
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置记录ID
	 *
	 * @param value
	 */
	public void setId(Long value) {
		id = value;
	}

	/**
	 * 返回STA服务器地址
	 *
	 * @return
	 */
	public String getHost() {
		return host;
	}

	/**
	 * 设置STA服务器地址
	 *
	 * @param value
	 */
	public void setHost(String value) {
		host = value;
	}

	/**
	 * 返回STA服务器端口
	 *
	 * @return
	 */
	public String getPort() {
		return port;
	}

	/**
	 * 设置STA服务器端口
	 *
	 * @param value
	 */
	public void setPort(String value) {
		port = value;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}
}

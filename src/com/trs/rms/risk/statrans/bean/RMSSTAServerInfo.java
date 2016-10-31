package com.trs.rms.risk.statrans.bean;

/**
 * 服务器信息(STA或DAS)
 *
 * @author clinzy 2012-4-11
 * @author zxh    2016-10-31
 */
public class RMSSTAServerInfo {
	/**
	 * 记录ID
	 */
	private Long id;

	/**
	 * STA服务器名称
	 */
	private String name;

	/**
	 * STA服务器地址
	 */
	private String host;

	/**
	 * STA服务器端口
	 */
	private String port;

	/**
	 * STA服务器用户名
	 */
	private String user;

	/**
	 * STA服务器口令
	 */
	private String password;

	/**
	 * STA服务器状态（0--不可连接；1--可连接）
	 */
	private Integer state;

	/**
	 * STA服务器状态描述
	 */
	private String stateDesc;

	/**
	 * 构造函数
	 */
	public RMSSTAServerInfo() {

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
	 * 返回STA服务器名称
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置STA服务器名称
	 *
	 * @param value
	 */
	public void setName(String value) {
		name = value;
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

	/**
	 * 返回STA服务器用户名
	 *
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * 设置STA服务器用户名
	 *
	 * @param value
	 */
	public void setUser(String value) {
		user = value;
	}

	/**
	 * 返回STA服务器口令
	 *
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置STA服务器口令
	 *
	 * @param value
	 */
	public void setPassword(String value) {
		password = value;
	}

	/**
	 * 返回STA服务器状态（0--不可连接；1--可连接）
	 *
	 * @return
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 设置STA服务器口令（0--不可连接；1--可连接）
	 *
	 * @param value
	 */
	public void setState(Integer value) {
		state = value;
	}

	/**
	 * 返回STA服务器状态描述
	 *
	 * @return
	 */
	public String getStateDesc() {
		return stateDesc;
	}

	/**
	 * 设置STA服务器状态描述
	 *
	 * @param value
	 */
	public void setStateDesc(String value) {
		stateDesc = value;
	}
}

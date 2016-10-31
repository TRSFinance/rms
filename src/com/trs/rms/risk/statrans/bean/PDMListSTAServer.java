package com.trs.rms.risk.statrans.bean;

/**
 * 列出STA服务器列表页面数据模型
 * 
 * @author clinzy 2012-4-10
 *
 */
public class PDMListSTAServer {
	/**
	 * STA服务器列表
	 */
	private STAServerInfo[] staServerInfoList;
	
	/**
	 * 构造函数
	 */
	public PDMListSTAServer() {
		
	}
	
	/**
	 * 返回STA服务器列表
	 * 
	 * @return
	 */
	public STAServerInfo[] getStaServerInfoList() {
		return staServerInfoList;
	}
	
	/**
	 * 设置STA服务器列表
	 * 
	 * @param value
	 */
	public void setStaServerInfoList(STAServerInfo[] value) {
		staServerInfoList = value;
	}
}

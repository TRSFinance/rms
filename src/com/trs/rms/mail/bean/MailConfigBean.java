package com.trs.rms.mail.bean;

/**
 * 邮件发送配置
 * */
public class MailConfigBean {

	private Long id;

	/** 是否启用短信功能，只有在配置了短信接口且启用了该开关后，系统才能发送短信. */
	private boolean mailEnabled;

	/**
	 * SMTP服务器地址
	 * */
	private String host;

	/**
	 * SMTP服务器端口号
	 * */
	private int port;

	/**
	 * 邮件发送者地址
	 * */
	private String address;

	/**
	 * 邮件发送者密码
	 * */
	private String password;

	/**
	 * 邮件发送者名称
	 * */
	private String username;

	/**
	 * 邮件标题前缀
	 * */
	private String prefix;

	/**
	 * 邮件发送任务每次发送邮件数限制
	 * */
	private int maxmails;

	/**
	 * 最大重发次数
	 * */
	private int maxsendtimes;

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return host;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setMaxsendtimes(int maxsendtimes) {
		this.maxsendtimes = maxsendtimes;
	}

	public int getMaxsendtimes() {
		return maxsendtimes;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setMaxmails(int maxmails) {
		this.maxmails = maxmails;
	}

	public int getMaxmails() {
		return maxmails;
	}

	public boolean isMailEnabled() {
		return mailEnabled;
	}

	public void setMailEnabled(boolean mailEnabled) {
		this.mailEnabled = mailEnabled;
	}

}

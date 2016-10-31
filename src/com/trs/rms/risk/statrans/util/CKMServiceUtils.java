package com.trs.rms.risk.statrans.util;

import com.trs.ckm.client.data.ServerConInfo;
import com.trs.ckm.soap.CkmSoapException;
import com.trs.ckm.soap.SysParas;
import com.trs.ckm.soap.TrsCkmSoapClient;
import com.trs.rms.risk.statrans.exp.STATransException;

/**
 *
 *
 * @author clinzy 2012-5-21
 * @author zxh    2016-10-31
 */
public class CKMServiceUtils {
	/**
	 * 自身实例
	 */
	private static CKMServiceUtils instance;

	/**
	 * 构造函数
	 */
	public CKMServiceUtils() {

	}

	/**
	 * 返回自身默认实例
	 *
	 * @return
	 */
	public static CKMServiceUtils getDefaultInstance() {
		if (instance == null) {
			instance = new CKMServiceUtils();
		}
		return instance;
	}

	/**
	 * 获取CKM服务器系统参数
	 *
	 * @param _serverConInfo
	 * @return
	 * @throws STATransException
	 */
	public SysParas getSystemParameters(ServerConInfo _serverConInfo) throws STATransException {
		TrsCkmSoapClient _client = this.getCkmSoapClient(_serverConInfo);
		SysParas _sysParas = null;

		try {
			_sysParas = _client.GetSystemParameters(0);
		} catch (CkmSoapException e) {
			// TODO Auto-generated catch block
			throw new STATransException(-9999, "获取CKM服务器系统参数信息失败：\n" + e.toString());
		}

		return _sysParas;
	}

	/**
	 * 获取STA服务器连接句柄
	 *
	 * @param _serverConInfo
	 * @return
	 */
	public TrsCkmSoapClient getCkmSoapClient(ServerConInfo _serverConInfo) {
		String _sHost = _serverConInfo.getHost();
		String _sPort = _serverConInfo.getPort();
		String _sUser = _serverConInfo.getUser();
		String _sPassword = _serverConInfo.getPassword();
		TrsCkmSoapClient _client = new TrsCkmSoapClient("http://" + _sHost + ":" + _sPort, _sUser, _sPassword);
		return _client;
	}

	/**
	 * 获取STA服务器连接句柄
	 *
	 * @param _sHost
	 * @param _sPort
	 * @param _sUser
	 * @param _sPassword
	 * @return
	 */
	public TrsCkmSoapClient getCkmSoapClient(String _sHost, String _sPort, String _sUser,
			String _sPassword) {
		TrsCkmSoapClient _client = new TrsCkmSoapClient("http://" + _sHost + ":" + _sPort, _sUser, _sPassword);
		return _client;
	}
}

package com.trs.rms.risk.statrans.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trs.ckm.client.data.ServerConInfo;
import com.trs.ckm.common.SystemUtil;
import com.trs.ckm.soap.CkmSoapException;
import com.trs.ckm.soap.ThirdServerInfo;
import com.trs.ckm.soap.TransInfo;
import com.trs.ckm.soaptrans.Trans;
import com.trs.ckm.soaptrans.TrsSoapTransClient;
import com.trs.rms.risk.statrans.exp.STATransException;


/**
 *
 *
 * @author clinzy 2012-3-30
 * @author zxh    2016-10-31
 */
public class STAServiceUtils {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(STAServiceUtils.class);
//	/**
//	 * 自身实例
//	 */
//	private volatile static STAServiceUtils instance;

	/**
	 * 构造函数
	 */
	public STAServiceUtils() {

	}

	/**
	 * 返回自身默认实例
	 *
	 * @return
	 */
	public static STAServiceUtils getDefaultInstance() {
//		if (instance == null) {
//			synchronized(STAServiceUtils.class){
//				if (instance == null){
//					instance = new STAServiceUtils();
//				}
//			}
//		}
		return new  STAServiceUtils();//instance;
	}

	/**
	 * 提交任务
	 *
	 * @param _sTransName
	 * @param _sTransDefine
	 * @param _serverConInfo
	 * @return
	 * @throws STATransException
	 */
	public Trans submitTrans(String _sTransName, String _sTransDefine, ServerConInfo _serverConInfo) throws STATransException {
		Trans _trans = null;
		TrsSoapTransClient _client = null;
		String errorMessage = null;
		_client = this.getSoapTransClient(_serverConInfo);
		try {
			_trans = _client.ParseTransTimeMsg(_sTransDefine, _sTransName);
		} catch (CkmSoapException e) {
			// TODO Auto-generated catch block
			//throw new STATransException(-9999, "提交任务失败：\n" + e.toString());
			if(e.toString().indexOf("-116")!=-1){
				errorMessage = "已存在同名任务！";
			}else if(e.toString().indexOf("-19")!=-1){
				errorMessage = "任务不存在";
			}
			if(errorMessage==null){
				throw new STATransException(-9999, "提交任务失败：\n" + e.toString());
			}else{
				throw new STATransException(-9999, "提交任务失败：\n" + errorMessage);
			}
		}
		return _trans;
	}


	/**
	 * 修改任务
	 *
	 * @param _iID
	 * @param _sCheckCode
	 * @param _sTransName
	 * @param _sTransDefine
	 * @param _serverConInfo
	 * @throws STATransException
	 */
	public int modifyTrans(int _iID, String _sCheckCode, String _sTransName, String _sTransDefine, ServerConInfo _serverConInfo)
			throws STATransException {
		TrsSoapTransClient _client = null;
		int _iRetValue = -1;
		String errorMessage = null;
		_client = this.getSoapTransClient(_serverConInfo);
		try {
			_iRetValue = _client.ModifyTrans(_iID, _sTransName, _sCheckCode, _sTransDefine);
		} catch (CkmSoapException e) {
			// TODO Auto-generated catch block
			if(e.toString().indexOf("-116")!=-1){
				errorMessage = "任务重复，您未对任务做任何修改！";
			}else if(e.toString().indexOf("-19")!=-1){
				errorMessage = "任务不存在";
			}
			if(errorMessage==null){
				throw new STATransException(-9999, "修改任务失败：\n" + e.toString());
			}else{
				throw new STATransException(-9999, "修改任务失败：\n" + errorMessage);
			}
		}

		return _iRetValue;
	}

	/**
	 * 启动任务
	 *
	 * @param _iID
	 * @param _sCheckCode
	 * @param _serverConInfo
	 * @throws STATransException
	 */
	public int startTrans(int _iID, String _sCheckCode, ServerConInfo _serverConInfo) throws STATransException {
		TrsSoapTransClient _client = null;
		int _iRetValue = -1;

		_client = this.getSoapTransClient(_serverConInfo);
		try {
			_iRetValue = _client.StartTrans(_iID, _sCheckCode);
		} catch (CkmSoapException e) {
			// TODO Auto-generated catch block
			throw new STATransException(-9999, "启动任务失败：\n" + e.toString());
		}

		return _iRetValue;
	}

	/**
	 * 停止任务
	 *
	 * @param _iID
	 * @param _sCheckCode
	 * @param _serverConInfo
	 * @throws STATransException
	 */
	public int stopTrans(int _iID, String _sCheckCode, ServerConInfo _serverConInfo) throws STATransException {
		TrsSoapTransClient _client = null;
		int _iRetValue = -1;

		_client = this.getSoapTransClient(_serverConInfo);
		try {
			_iRetValue = _client.StopTrans(_iID, _sCheckCode);
		} catch (CkmSoapException e) {
			// TODO Auto-generated catch block
			throw new STATransException(-9999, "停止任务失败：\n" + e.toString());
		}

		return _iRetValue;
	}

	/**
	 * 删除任务
	 *
	 * @param _iID
	 * @param _sCheckCode
	 * @param _bDeleteCompletely
	 * @param _serverConInfo
	 * @throws STATransException
	 */
	public int deleteTrans(int _iID, String _sCheckCode, boolean _bDeleteCompletely, ServerConInfo _serverConInfo)
			throws STATransException {
		TrsSoapTransClient _client = null;
		int _iRetValue = -1;

		_client = this.getSoapTransClient(_serverConInfo);
		try {
			_iRetValue = _client.DelTTrans(_iID, _sCheckCode);
		} catch (CkmSoapException e) {
			// TODO Auto-generated catch block
			throw new STATransException(-9999, "删除任务失败：\n" + e.toString());
		}

		return _iRetValue;
	}

	/**
	 * 查询任务状态
	 *
	 * @param _iID
	 * @param _sCheckCode
	 * @param _serverConInfo
	 * @return
	 * @throws STATransException
	 */
	public int getTransState(int _iID, String _sCheckCode, ServerConInfo _serverConInfo) throws STATransException {
		TrsSoapTransClient _client = null;
		int _iRetValue = -1;

		_client = this.getSoapTransClient(_serverConInfo);
		try {
			_iRetValue = _client.GetTransState(_iID, null, _sCheckCode);
		} catch (CkmSoapException e) {
			// TODO Auto-generated catch block
			throw new STATransException(-9999, "查询任务状态失败：\n" + e.toString());
		}

		return _iRetValue;
	}

	/**
	 * 查询任务信息
	 *
	 * @param _iID
	 * @param _sCheckCode
	 * @param _serverConInfo
	 * @return
	 * @throws STATransException
	 */
	public TransInfo[] getTransInfo(int _iID, String _sCheckCode, ServerConInfo _serverConInfo) throws STATransException {
		TrsSoapTransClient _client = null;
		TransInfo[] _transInfo = null;
		STAServiceUtils t = new STAServiceUtils();
		_client = t.getSoapTransClient(_serverConInfo);
		try {
			_transInfo = _client.GetTransInfo(_iID);
		} catch (CkmSoapException e) {
			// TODO Auto-generated catch block
			throw new STATransException(-9999, "查询任务信息失败：\n" + e.toString());
		}

		return _transInfo;
	}

	/**
	 * 查询第三层服务器信息列表
	 *
	 * @param _serverConInfo
	 * @return
	 * @throws STATransException
	 */
	public ThirdServerInfo[] getThirdServerInfo(ServerConInfo _serverConInfo) throws STATransException {
		TrsSoapTransClient _client = null;
		ThirdServerInfo[] _thirdServerInfo = null;

		_client = this.getSoapTransClient(_serverConInfo);
		try {
			_thirdServerInfo = _client.GetServerList(null);
		} catch (CkmSoapException e) {
			// TODO Auto-generated catch block
			throw new STATransException(-9999, "查询第三层服务器信息列表失败：\n" + e.toString());
		}

		return _thirdServerInfo;
	}

	/**
	 * 获取STA服务器连接句柄
	 *
	 * @param _serverConInfo
	 * @return
	 */
	public TrsSoapTransClient getSoapTransClient(ServerConInfo _serverConInfo) {
		String _sHost = _serverConInfo.getHost();
		String _sPort = _serverConInfo.getPort();
		String _sUser = _serverConInfo.getUser();
		String _sPassword = _serverConInfo.getPassword();
		TrsSoapTransClient _client = new TrsSoapTransClient("http://" + _sHost + ":" + _sPort, _sUser, _sPassword);
		long timeout=10000;
		String value=SystemUtil.getPropertiesValue("STACLIENT_CONNECTION_TIMEOUT");
		try{
			timeout=Long.valueOf(value);
		}catch(Exception e){
			LOGGER.error("config.ini中的STACLIENT_CONNECTION_TIMEOUT参数配置错误["+value+"]，请设置一个大于0的整数："+e.getMessage(),e);
		}
		_client.SetTimeOut((int) timeout);
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
	public TrsSoapTransClient getSoapTransClient(String _sHost, String _sPort, String _sUser,
			String _sPassword) {
		TrsSoapTransClient _client = new TrsSoapTransClient("http://" + _sHost + ":" + _sPort, _sUser, _sPassword);
		return _client;
	}
}

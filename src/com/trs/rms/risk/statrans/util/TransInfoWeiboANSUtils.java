package com.trs.rms.risk.statrans.util;

import com.trs.ckm.client.data.DBConInfo;
import com.trs.ckm.client.data.sta.transinfo.CTransInfo;
import com.trs.ckm.client.data.sta.transinfo.ProcessInfo;
import com.trs.ckm.client.data.sta.transinfo.SourceInfo;
import com.trs.ckm.client.data.sta.transinfo.StorageInfo;
import com.trs.ckm.client.data.sta.transinfo.TimingInfo;
import com.trs.rms.mail.bean.MailConfigBean;
import com.trs.rms.risk.statrans.bean.PDMEditTrans;
import com.trs.rms.risk.statrans.exp.STATransException;
/**
 *
 *
 * @author clinzy 2012-4-1
 * @author zxh    2016-10-31
 *
 */
public class TransInfoWeiboANSUtils extends TransInfoUtils {
	/**
	 * 自身默认实例
	 */
	private static TransInfoWeiboANSUtils instance;

	/**
	 * 构造函数
	 */
	public TransInfoWeiboANSUtils() {

	}

	/**
	 * 返回自身默认实例
	 *
	 * @return
	 */
	public static TransInfoWeiboANSUtils getDefaultInstance() {
		if (instance == null) {
			instance = new TransInfoWeiboANSUtils();
		}
		return instance;
	}

	/**
	 * 解析数据来源表
	 *
	 * @param _sSourceSearchExpression
	 * @return
	 */
	private String parseSourceTable(String _sSourceSearchExpression) {
		String _sRetValue = null;
		int _iIndex1 = -1;
		int _iIndex2 = -1;
		int _iIndex3 = -1;

		_iIndex1 = _sSourceSearchExpression.indexOf(" from ");
		_iIndex2 = _sSourceSearchExpression.indexOf(".", _iIndex1);
		_iIndex3 = _sSourceSearchExpression.indexOf(" where ");

		_sRetValue = _sSourceSearchExpression.substring(_iIndex2 + 1, _iIndex3).trim();

		return _sRetValue;
	}

	/************************************************************
	 * 															*
	 * 			依据页面设置信息及配置信息生成任务					*
	 * 															*
	 ************************************************************/

	/**
	 * 生成任务
	 *
	 * @param _sTransModelDefine
	 * @param _pageDataModel
	 * @param _mailConfig
	 * @return
	 * @throws STATransException
	 */
	public CTransInfo generateCTransInfo(String _sTransModelDefine, PDMEditTrans _pageDataModel, MailConfigBean _mailConfig) throws STATransException {
		String _sSourceDBHost = null; // 页面信息
		String _sSourceDBPort = null;
		String _sSourceDBUser = null;
		String _sSourceDBPassword = null;
		String _sSourceDBService = null;
		String _sSourceDBTable = null;
		String _sStorageDBHost = null;
		String _sStorageDBPort = null;
		String _sStorageDBUser = null;
		String _sStorageDBPassword = null;
		String _sStorageDBService = null;
		String _sStorageDBTable = null;
		Integer _tiType = null;
		String _sTime = null;
		String _sPeriodTime = null;
		Integer _periodValue = null;
		String _sPeriodUnit = null;
		CTransInfo _cTransInfo = null; // 任务模板信息
		SourceInfo _sourceInfo = null;
		StorageInfo _storageInfo = null;
		ProcessInfo[][] _processInfoList = null;
		String[] _paramList = null;
		DBConInfo _sourceDBConInfo = null;
		String _sSourceSearchExpression = null;
		DBConInfo _storageDBConInfo = null;
		TimingInfo[] _timingInfoList = null; //
		String _sMailConfigHost = null; //
		int _iMailConfigPort = 25;
		String _sMailConfigAddr = null;
		String _sMailConfigPassword = null;

		// 页面信息
		_sSourceDBHost = _pageDataModel.getSourceDBHost();
		_sSourceDBPort = _pageDataModel.getSourceDBPort();
		_sSourceDBUser = _pageDataModel.getSourceDBUser();
		_sSourceDBPassword = _pageDataModel.getSourceDBPassword();
		_sSourceDBService = _pageDataModel.getSourceDBService();
		_sSourceDBTable = _pageDataModel.getSourceDBTable();
		_sStorageDBHost = _pageDataModel.getStorageDBHost();
		_sStorageDBPort = _pageDataModel.getStorageDBPort();
		_sStorageDBUser = _pageDataModel.getStorageDBUser();
		_sStorageDBPassword = _pageDataModel.getStorageDBPassword();
		_sStorageDBService = _pageDataModel.getStorageDBService();
		_sStorageDBTable = _pageDataModel.getStorageDBTable();
		_tiType = _pageDataModel.getTiType();
		_sTime = _pageDataModel.getTime();
		_sPeriodTime = _pageDataModel.getPeriodTime();
		_periodValue = _pageDataModel.getPeriodValue();
		_sPeriodUnit = _pageDataModel.getPeriodUnit();

		// 邮件发送信息
		if (_mailConfig == null) {
			throw new STATransException(-9999, "邮件发送信息为空。");
		}
		_sMailConfigHost = _mailConfig.getHost();
		_iMailConfigPort = _mailConfig.getPort();
		_sMailConfigAddr = _mailConfig.getAddress();
		_sMailConfigPassword = _mailConfig.getPassword();
		if (_sMailConfigHost == null) {
			throw new STATransException(-9999, "邮件发送信息，邮件服务器地址为空。");
		}
		if (_sMailConfigAddr == null) {
			throw new STATransException(-9999, "邮件发送信息，邮箱地址为空。");
		}
		if (_sMailConfigPassword == null) {
			throw new STATransException(-9999, "邮件发送信息，邮箱登入口令为空。");
		}

		// 解析任务模板
		_cTransInfo = super.parseCTransInfo(_sTransModelDefine, "解析任务模板失败：");
		_sourceInfo = _cTransInfo.getSourceInfo();
		_storageInfo = _cTransInfo.getStorageInfo();
		_processInfoList = _cTransInfo.getProcessInfos();
		_sourceDBConInfo = _sourceInfo.getDBConInfo();
		_sSourceSearchExpression = _sourceInfo.getSearchCondition();
		_storageDBConInfo = _storageInfo.getDBConInfo();
		_paramList = _processInfoList[0][0].getParams();

		// 修改任务模板的信息
		_sourceDBConInfo.setHost(_sSourceDBHost); // 数据来源信息
		_sourceDBConInfo.setPort(_sSourceDBPort);
		_sourceDBConInfo.setUser(_sSourceDBUser);
		_sourceDBConInfo.setPassword(_sSourceDBPassword);
		_sourceDBConInfo.setLsnSid(_sSourceDBService);
		_sourceInfo.setSearchCondition(_sSourceSearchExpression.replace("om3_baotou.weiboalarmnotification", _sSourceDBService + "." + _sSourceDBTable));
		_storageDBConInfo.setHost(_sStorageDBHost); // 数据存储信息
		_storageDBConInfo.setPort(_sStorageDBPort);
		_storageDBConInfo.setUser(_sStorageDBUser);
		_storageDBConInfo.setPassword(_sStorageDBPassword);
		_storageDBConInfo.setLsnSid(_sStorageDBService);
		_storageInfo.setTVName(_sStorageDBTable);
		_paramList[0] = _sSourceDBHost; // 数据处理参数列表
		_paramList[1] = _sSourceDBPort;
		_paramList[2] = _sSourceDBUser;
		_paramList[3] = _sSourceDBPassword;
		_paramList[4] = _sSourceDBService;
		_paramList[5] = _sMailConfigHost;
		_paramList[6] = String.valueOf(_iMailConfigPort);
		_paramList[7] = _sMailConfigAddr;
		_paramList[8] = _sMailConfigPassword;
		_processInfoList[0][0].setParams(_paramList);

		_timingInfoList = super.getTimingInfo(_tiType, _sTime, _sPeriodTime, _periodValue, _sPeriodUnit); // 定时
		_cTransInfo.setTimingInfos(_timingInfoList);

		return _cTransInfo;
	}
}
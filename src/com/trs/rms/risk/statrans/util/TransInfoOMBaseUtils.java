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
 * 舆情基本分析任务Utils
 *
 * @author clinzy 2012-3-31
 *
 */
public class TransInfoOMBaseUtils extends TransInfoUtils {
	/**
	 * 自身默认实例
	 */
	private static TransInfoOMBaseUtils instance;

	/**
	 * 构造函数
	 */
	public TransInfoOMBaseUtils() {

	}

	/**
	 * 返回自身默认实例
	 *
	 * @return
	 */
	public static TransInfoOMBaseUtils getDefaultInstance() {
		if (instance == null) {
			instance = new TransInfoOMBaseUtils();
		}
		return instance;
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
		String _sStorageDBHost = null;
		String _sStorageDBPort = null;
		String _sStorageDBUser = null;
		String _sStorageDBPassword = null;
		String _sStorageDBService = null;
		Integer _tiType = null;
		String _sTime = null;
		String _sPeriodTime = null;
		Integer _periodValue = null;
		String _sPeriodUnit = null;
		String _sSIMServerInfoList = null; // 排重服务器信息
		CTransInfo _cTransInfo = null; // 任务模板信息
		SourceInfo _sourceInfo = null;
		StorageInfo _storageInfo = null;
		ProcessInfo[][] _processInfoList = null;
		DBConInfo _sourceDBConInfo = null;
		DBConInfo _storageDBConInfo = null;
		String[] _paramList = null;
		TimingInfo[] _timingInfoList = null; //

		// 页面信息
		_sSourceDBHost = _pageDataModel.getSourceDBHost();
		_sSourceDBPort = _pageDataModel.getSourceDBPort();
		_sSourceDBUser = _pageDataModel.getSourceDBUser();
		_sSourceDBPassword = _pageDataModel.getSourceDBPassword();
		_sSourceDBService = _pageDataModel.getSourceDBService();
		_sStorageDBHost = _pageDataModel.getStorageDBHost();
		_sStorageDBPort = _pageDataModel.getStorageDBPort();
		_sStorageDBUser = _pageDataModel.getStorageDBUser();
		_sStorageDBPassword = _pageDataModel.getStorageDBPassword();
		_sStorageDBService = _pageDataModel.getStorageDBService();
		_tiType = _pageDataModel.getTiType();
		_sTime = _pageDataModel.getTime();
		_sPeriodTime = _pageDataModel.getPeriodTime();
		_periodValue = _pageDataModel.getPeriodValue();
		_sPeriodUnit = _pageDataModel.getPeriodUnit();

		// 排重服务器信息
		_sSIMServerInfoList = _pageDataModel.getSimServerInfoList();
		if (_sSIMServerInfoList == null) {
			throw new STATransException(-9999, "排重服务器信息为空。");
		}

		// 解析任务模板
		_cTransInfo = super.parseCTransInfo(_sTransModelDefine, "解析任务模板失败：");
		_sourceInfo = _cTransInfo.getSourceInfo();
		_storageInfo = _cTransInfo.getStorageInfo();
		_processInfoList = _cTransInfo.getProcessInfos();
		_sourceDBConInfo = _sourceInfo.getDBConInfo();
		_storageDBConInfo = _storageInfo.getDBConInfo();
		_paramList = _processInfoList[11][0].getParams();

		// 修改任务模板的信息
		_sourceDBConInfo.setHost(_sSourceDBHost); // 数据来源信息
		_sourceDBConInfo.setPort(_sSourceDBPort);
		_sourceDBConInfo.setUser(_sSourceDBUser);
		_sourceDBConInfo.setPassword(_sSourceDBPassword);
		_sourceDBConInfo.setLsnSid(_sSourceDBService);
		_storageDBConInfo.setHost(_sStorageDBHost); // 数据存储信息
		_storageDBConInfo.setPort(_sStorageDBPort);
		_storageDBConInfo.setUser(_sStorageDBUser);
		_storageDBConInfo.setPassword(_sStorageDBPassword);
		_storageDBConInfo.setLsnSid(_sStorageDBService);
		_paramList[0] = _sSIMServerInfoList; // 参数列表
		_processInfoList[11][0].setParams(_paramList);

		_timingInfoList = super.getTimingInfo(_tiType, _sTime, _sPeriodTime, _periodValue, _sPeriodUnit); // 定时
		_cTransInfo.setTimingInfos(_timingInfoList);

		return _cTransInfo;
	}
}

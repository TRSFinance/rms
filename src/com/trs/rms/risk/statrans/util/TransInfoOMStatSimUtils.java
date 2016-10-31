package com.trs.rms.risk.statrans.util;

import java.util.ArrayList;
import com.trs.ckm.client.data.DBConInfo;
import com.trs.ckm.client.data.sta.transinfo.CTransInfo;
import com.trs.ckm.client.data.sta.transinfo.ProcessInfo;
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
 */
public class TransInfoOMStatSimUtils extends TransInfoUtils {
	/**
	 * 自身默认实例
	 */
	private static TransInfoOMStatSimUtils instance;

	/**
	 * 构造函数
	 */
	public TransInfoOMStatSimUtils() {

	}

	/**
	 * 返回自身默认实例
	 *
	 * @return
	 */
	public static TransInfoOMStatSimUtils getDefaultInstance() {
		if (instance == null) {
			instance = new TransInfoOMStatSimUtils();
		}
		return instance;
	}

	/**
	 * 解析dateInter
	 *
	 * @param _cTransInfo
	 * @return
	 */
	private String parseDateInter(CTransInfo _cTransInfo) {
		StringBuffer _sb = new StringBuffer("");
		ProcessInfo[][] _processInfoList = _cTransInfo.getProcessInfos();
		String[] _paramList = _processInfoList[0][0].getParams();
		CTransInfo[] _childCTransInfoList = _cTransInfo.getChildCTransInfos();

		_sb.append(_paramList[6]);

		if (_childCTransInfoList != null && _childCTransInfoList.length > 0) {
			for (int i = 0; i < _childCTransInfoList.length; i++) {
				_sb.append(";");
				_sb.append(parseDateInter(_childCTransInfoList[i]));
			}
		}

		return _sb.toString();
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
		CTransInfo _cTransInfo = null;
		CTransInfo[] _childCTransInfoList = null;
		ArrayList<CTransInfo> _childCTransInfoArrayList = new ArrayList<CTransInfo>();
		int _iSize = 0;
		String _sDateInter = _pageDataModel.getDateInter();
		String[] _dateInterStrList = null;
		int[] _dateInterList = null;

		if (_sDateInter == null || _sDateInter.equals("")) {
			throw new STATransException(-9999, "页面“分析最近N天的数据 ”设置不能为空。");
		}

		_dateInterStrList = _sDateInter.split(";");

		_dateInterList = new int[_dateInterStrList.length];
		for (int i = 0; i < _dateInterStrList.length; i++) {
			try {
				_dateInterList[i] = Integer.parseInt(_dateInterStrList[i]);
			} catch (NumberFormatException e) {
				throw new STATransException(-9999, "页面“分析最近N天的数据 ”的值必须为大于0的整数，多个天数之间以英文半角分号“;”隔开。\n" + e.toString());
			}
		}

		for (int i = 0; i < _dateInterList.length; i++) {
			CTransInfo _tmp = this.generateCTransInfo(_sTransModelDefine, _pageDataModel, _dateInterList[i]);
			if (i == 0) {
				_cTransInfo = _tmp;
			} else {
				_tmp.setPri(null);
				_tmp.setTimingInfos(null);
				_tmp.setPlugs(null);
				_tmp.setResources(null);
				_tmp.setChild(true);
				_childCTransInfoArrayList.add(_tmp);
			}
		}

		_iSize = _childCTransInfoArrayList.size();
		if (_iSize > 0) {
			_childCTransInfoList = new CTransInfo[_iSize];
			_childCTransInfoList = _childCTransInfoArrayList.toArray(_childCTransInfoList);
			_cTransInfo.setChildCTransInfos(_childCTransInfoList);
		}

		return _cTransInfo;
	}

	/**
	 * 生成任务
	 *
	 * @param _sTransModelDefine
	 * @param _pageDataModel
	 * @param _iDateInter
	 * @return
	 * @throws STATransException
	 */
	private CTransInfo generateCTransInfo(String _sTransModelDefine, PDMEditTrans _pageDataModel, int _iDateInter) throws STATransException {
		String _sSourceDBHost = null; // 页面信息
		String _sSourceDBPort = null;
		String _sSourceDBUser = null;
		String _sSourceDBPassword = null;
		String _sSourceDBTable = null;
		String _sStorageDBHost = null;
		String _sStorageDBPort = null;
		String _sStorageDBUser = null;
		String _sStorageDBPassword = null;
		String _sStorageDBTable = null;
		String _sSourceSearchExpression = null;
		String _sTaskTag = null;
		Integer _tiType = null;
		String _sTime = null;
		String _sPeriodTime = null;
		Integer _periodValue = null;
		String _sPeriodUnit = null;
		CTransInfo _cTransInfo = null; // 任务模板信息
		StorageInfo _storageInfo = null;
		ProcessInfo[][] _processInfoList = null;
		TimingInfo[] _timingInfoList = null;
		DBConInfo _storageDBConInfo = null;
		String[] _paramList = null;

		// 页面信息
		_sSourceDBHost = _pageDataModel.getSourceDBHost();
		_sSourceDBPort = _pageDataModel.getSourceDBPort();
		_sSourceDBUser = _pageDataModel.getSourceDBUser();
		_sSourceDBPassword = _pageDataModel.getSourceDBPassword();
		_sSourceDBTable = _pageDataModel.getSourceDBTable();
		_sStorageDBHost = _pageDataModel.getStorageDBHost();
		_sStorageDBPort = _pageDataModel.getStorageDBPort();
		_sStorageDBUser = _pageDataModel.getStorageDBUser();
		_sStorageDBPassword = _pageDataModel.getStorageDBPassword();
		_sStorageDBTable = _pageDataModel.getStorageDBTable();
		_sSourceSearchExpression = _pageDataModel.getSearchExpression();
		_sTaskTag = _pageDataModel.getTaskTag();
		_tiType = _pageDataModel.getTiType();
		_sTime = _pageDataModel.getTime();
		_sPeriodTime = _pageDataModel.getPeriodTime();
		_periodValue = _pageDataModel.getPeriodValue();
		_sPeriodUnit = _pageDataModel.getPeriodUnit();

		// 替换taskTag和dateInter
		_sTransModelDefine = _sTransModelDefine.replaceAll("taskTag", _sTaskTag);
		_sTransModelDefine = _sTransModelDefine.replaceAll("dateInter", String.valueOf(_iDateInter));

		// 解析任务模板
		_cTransInfo = super.parseCTransInfo(_sTransModelDefine, "解析任务模板失败：");
		_storageInfo = _cTransInfo.getStorageInfo();
		_processInfoList = _cTransInfo.getProcessInfos();
		_storageDBConInfo = _storageInfo.getDBConInfo();
		_paramList = _processInfoList[0][0].getParams();

		// 修改任务模板的信息
		_storageDBConInfo.setHost(_sStorageDBHost); // 数据存储信息
		_storageDBConInfo.setPort(_sStorageDBPort);
		_storageDBConInfo.setUser(_sStorageDBUser);
		_storageDBConInfo.setPassword(_sStorageDBPassword);
		_storageInfo.setTVName(_sStorageDBTable);
		_paramList[0] = _sSourceDBHost; // 数据处理参数
		_paramList[1] = _sSourceDBPort;
		_paramList[2] = _sSourceDBUser;
		_paramList[3] = _sSourceDBPassword;
		_paramList[4] = _sSourceDBTable;
		_paramList[5] = _sSourceSearchExpression == null ? "" : _sSourceSearchExpression;
		_paramList[9] = _sStorageDBHost;
		_paramList[10] = _sStorageDBPort;
		_paramList[11] = _sStorageDBUser;
		_paramList[12] = _sStorageDBPassword;
		_paramList[13] = _sStorageDBTable;

		_timingInfoList = super.getTimingInfo(_tiType, _sTime, _sPeriodTime, _periodValue, _sPeriodUnit); // 定时
		_cTransInfo.setTimingInfos(_timingInfoList);

		return _cTransInfo;
	}
}
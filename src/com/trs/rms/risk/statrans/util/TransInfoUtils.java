package com.trs.rms.risk.statrans.util;

import java.io.IOException;
import java.io.StringWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;
import org.springframework.beans.BeanUtils;

import com.thoughtworks.xstream.XStream;
import com.trs.ckm.client.data.ServerConInfo;
import com.trs.ckm.client.data.sta.transinfo.AllowedResTypeList;
import com.trs.ckm.client.data.sta.transinfo.CTransInfo;
import com.trs.ckm.client.data.sta.transinfo.TimingInfo;
import com.trs.ckm.client.data.sta.transinfo.exp.TransInfoException;
import com.trs.ckm.client.data.sta.transinfo.pt.TransParser;
import com.trs.ckm.soap.TrsCkmSoapClient;
import com.trs.rms.mail.bean.MailConfigBean;
import com.trs.rms.risk.statrans.bean.PDMEditTrans;
import com.trs.rms.risk.statrans.bean.RMSSIMServerInfo;
import com.trs.rms.risk.statrans.bean.STATransConfInfo;
import com.trs.rms.risk.statrans.bean.STATransInfo;
import com.trs.rms.risk.statrans.exp.STATransException;


/**
 *
 *
 * @author clinzy 2012-3-16
 * @author zxh     2016-10-31
 *
 */
public class TransInfoUtils {
	/**
	 * 自身默认实例
	 */
	private static TransInfoUtils instance = null;

	/**
	 * 构造函数
	 */
	public TransInfoUtils() {

	}

	/**
	 * 返回自身默认实例
	 *
	 * @return
	 */
	public static TransInfoUtils getDefaultInstance() {
		if (instance == null) {
			instance = new TransInfoUtils();
		}
		return instance;
	}

	/**
	 * 根据任务类型获取TransInfoUtils
	 *
	 * @param _sTransType
	 * @return
	 */
	public static TransInfoUtils getTransInfoUtils(String _sTransType) {
		TransInfoUtils _transInfoUtils = null;

		if (_sTransType.equals("舆情基本分析任务")) {
			_transInfoUtils = TransInfoOMBaseUtils.getDefaultInstance();
		} else if (_sTransType.equals("热点新闻聚类任务")) {
			_transInfoUtils = TransInfoOMHotNewsUtils.getDefaultInstance();
		} else if (_sTransType.equals("热点博客聚类任务")) {
			_transInfoUtils = TransInfoOMHotBlogUtils.getDefaultInstance();
		} else if (_sTransType.equals("热点帖子分析任务")) {
			_transInfoUtils = TransInfoOMHotBbsUtils.getDefaultInstance();
		} else if (_sTransType.equals("热词分析任务")) {
			_transInfoUtils = TransInfoOMHotWordUtils.getDefaultInstance();
		} else if (_sTransType.equals("词群关系分析任务")) {
			_transInfoUtils = TransInfoOMLCluUtils.getDefaultInstance();
		} else if (_sTransType.equals("信息岛图分析任务")) {
			_transInfoUtils = TransInfoOMCluUtils.getDefaultInstance();
		} else if (_sTransType.equals("热点转载分析任务")) {
			_transInfoUtils = TransInfoOMStatSimUtils.getDefaultInstance();
		} else if (_sTransType.equals("微博关键词预警生成通知")) {
			_transInfoUtils = TransInfoWeiboANUtils.getDefaultInstance();
		} else if (_sTransType.equals("微博关注人物预警生成通知")) {
			_transInfoUtils = TransInfoWeiboANPUtils.getDefaultInstance();
		} else if (_sTransType.equals("微博预警发送通知")) {
			_transInfoUtils = TransInfoWeiboANSUtils.getDefaultInstance();
		} else if (_sTransType.equals("敏感人物发现任务集群版")) {
			_transInfoUtils = TransInfoWeiboACSPCUtils.getDefaultInstance();
		} else if (_sTransType.equals("热点预警分析任务集群版")) {
			_transInfoUtils = TransInfoWeiboACHCUtils.getDefaultInstance();
		} else if (_sTransType.equals("自定义任务")) {
			_transInfoUtils = TransInfoCustomUtils.getDefaultInstance();
		} else if (_sTransType.equals("QQ群聊天信息分析任务")) {
			_transInfoUtils = TransInfoOMQQUtils.getDefaultInstance();
		} else {
			_transInfoUtils=getDefaultInstance();
		}

		return _transInfoUtils;
	}

	/************************************************************
	 * 															*
	 * 						初始化页面数据模型					*
	 * 															*
	 ************************************************************/

	/**
	 * 初始化页面数据模型
	 * @param _staTransInfo
	 * @param _pageDataModel
	 * @throws STATransException
	 */
	public void initPageDataModel(STATransInfo _staTransInfo, PDMEditTrans _pageDataModel) throws STATransException {
		if(_staTransInfo!=null&&StringUtils.isNotBlank(_staTransInfo.getTransConfig())){
			// 将任务表的transConfig字段中的xml反序列化为PDMEditTrans
			XStream xstream = new XStream();
			xstream.alias("config", PDMEditTrans.class);
			PDMEditTrans model=(PDMEditTrans) xstream.fromXML(_staTransInfo.getTransConfig());
			BeanUtils.copyProperties(model, _pageDataModel);
		}
	}

	/************************************************************
	 * 															*
	 * 					初始化任务提交的STA服务器ID				*
	 * 															*
	 ************************************************************/

	/**
	 * 初始化任务提交的STA服务器ID
	 *
	 * @param _staTransInfo
	 * @param _staServerInfoList
	 * @throws STATransException
	 */
	public Long initStaServerId(STATransInfo _staTransInfo, STATransConfInfo[] _staServerInfoList) throws STATransException {
		Long _retValue = null;
		String _sTransSTAServerInfo = null;
		ServerConInfo _transSTAServerInfo = null;

		if (_staServerInfoList == null || _staServerInfoList.length == 0) {
			return _retValue;
		}

		if (_staTransInfo == null) {
			return _staServerInfoList[0].getId();
		}

		_retValue = _staServerInfoList[0].getId();

		_sTransSTAServerInfo = _staTransInfo.getTransSTAServerInfo();
		_transSTAServerInfo = this.getServerConInfo(_sTransSTAServerInfo);
		for (int i = 0; i < _staServerInfoList.length; i++) {
			ServerConInfo _tmp = this.getServerConInfo(_staServerInfoList[i]);
			if (_tmp.getHost().equals(_transSTAServerInfo.getHost())
					&& _tmp.getPort().equals(_transSTAServerInfo.getPort())) {
				_retValue = _staServerInfoList[i].getId();
				break;
			}
		}

		return _retValue;
	}

	/************************************************************
	 * 															*
	 * 			依据页面设置信息及配置信息生成任务					*
	 * 															*
	 ************************************************************/

	

	public String generateTransDefine(VelocityEngine velocityEngine,ToolManager toolManager, String vmTemplate,PDMEditTrans _pageDataModel, MailConfigBean _mailConfig){
		ToolContext tc=toolManager.createContext();
		tc.put("config",_pageDataModel);
		tc.put("mail",_mailConfig);
		Template template=velocityEngine.getTemplate(vmTemplate);
		StringWriter writer=new StringWriter();
		template.merge(tc, writer);
		return writer.toString();
	}

	/************************************************************
	 * 															*
	 * 							common							*
	 * 															*
	 ************************************************************/

	/**
	 *
	 *
	 */
	public synchronized String genTempFileName(String _sFileName, String _sTaskTag) {
		return null;
	}

	/**
	 * 解析任务
	 *
	 * @param _sTransDefine
	 * @param _sMsg
	 * @return
	 * @throws STATransException
	 */
	public CTransInfo parseCTransInfo(String _sTransDefine, String _sMsgPrefix) throws STATransException {
		CTransInfo _cTransInfo = null;
		TransParser _transParser = new TransParser();

		// 解析任务校验通过的资源类型
		String[] _allowedResType = {"RULECAT", "EXT", "SIM", "SEG", "ABS", "PLO", "AUTOCAT", "APPRAISE"};
		AllowedResTypeList.setAllowedResTypeList(_allowedResType);

		try {
			_transParser.parseTrans(_sTransDefine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new STATransException(-9999, _sMsgPrefix + "\n" + e.toString());
		} catch (TransInfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new STATransException(-9999, _sMsgPrefix + "\n" + e.getErrorMessage());
		}
		_cTransInfo = _transParser.getTransInfo();

		return _cTransInfo;
	}

	//------------------//

	/**
	 * 获取定时设置
	 * 返回Object[]
	 * Object[0] Integer 定时类型(0;1;2--手动触发执行;执行一次;周期执行)
	 * Object[1] String 任务执行一次的执行时间（yyyy-MM-dd HH:mm）
	 * Object[2] String 周期执行起始时刻(HH:mm)
	 * Object[3] Integer 周期执行周期值
	 * Object[4] String 周期执行周期单位
	 *
	 * @param _timingInfoList
	 * @param _bDefault
	 * @return
	 */
	public Object[] getTiSetInfo(TimingInfo[] _timingInfoList, boolean _bDefault) {
		Object[] _retValue = new Object[5];
		SimpleDateFormat _sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat _sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Calendar _calendar = Calendar.getInstance();
		Date _date = null;

		//
		_retValue[0] = new Integer(2); //
		_retValue[1] = null;
		_retValue[2] = "00:00";
		_retValue[3] = new Integer(1);
		_retValue[4] = "天";
		_date = new Date(); //
		_calendar.setTime(_date);
		_calendar.add(Calendar.MINUTE, 30);
		_date = _calendar.getTime();
		_retValue[1] = _sdf1.format(_date);

		if (!_bDefault) {
			if (_timingInfoList == null || _timingInfoList.length == 0) { // 手动触发支线
				_retValue[0] = new Integer(0);
			} else {
				String _sHour = _timingInfoList[0].getHour();
				String _sMin = _timingInfoList[0].getMin();
				String[] _dateAndWeekList = _timingInfoList[0].getDate();
				String _sPeriod = _timingInfoList[0].getPeriod();

				//
				if (_dateAndWeekList != null && _dateAndWeekList.length > 0) { // 执行一次
					String _sTime = _dateAndWeekList[0] + " " + _sHour + ":" + _sMin;
					try {
						_date = _sdf2.parse(_sTime);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//
					_retValue[0] = new Integer(1);
					_retValue[1] = _sdf1.format(_date);
				} else if (_sPeriod != null) { // 周期执行
					String _sPeriodValue = null;
					String _sPeriodUnit = null;
					int _iPeriodValue = 1;
					if (_sPeriod.endsWith("小时") || _sPeriod.endsWith("星期")) {
						_sPeriodValue = _sPeriod.substring(0, _sPeriod.length() - 2);
						_sPeriodUnit = _sPeriod.substring(_sPeriod.length() - 2);
					} else {
						_sPeriodValue = _sPeriod.substring(0, _sPeriod.length() - 1);
						_sPeriodUnit = _sPeriod.substring(_sPeriod.length() - 1);
					}
					_iPeriodValue = Integer.parseInt(_sPeriodValue);
					//
					_retValue[0] = new Integer(2);
					_retValue[2] = _sHour + ":" + _sMin;
					_retValue[3] = new Integer(_iPeriodValue);
					_retValue[4] = _sPeriodUnit;
				}
			}
		}

		return _retValue;
	}

	//------------------//

	/**
	 * 获取定时信息
	 *
	 * @param _tiType
	 * @param _sTime
	 * 			  String (yyyy-MM-dd HH:mm)
	 * @param _sPeriodTime
	 * @param _periodValue
	 * @param _sPeriodUnit
	 * @return
	 */
	public TimingInfo[] getTimingInfo(Integer _tiType, String _sTime, String _sPeriodTime, Integer _periodValue,
			String _sPeriodUnit) throws STATransException {
		TimingInfo[] _timingInfoList = null;
		SimpleDateFormat _sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date _time = null;

		if (_tiType == null || _tiType.intValue() == 0) {
			// do nothing
		} else if (_tiType.intValue() == 1) {
			try {
				_time = _sdf1.parse(_sTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				throw new STATransException(-9999, "任务执行一次，时刻设置不合法：\n" + e.toString());
			}

			int _iYear = -1;
			int _iMonth = -1;
			int _iDay = -1;
			int _iHour = -1;
			int _iMin = -1;
			Calendar _calendar = Calendar.getInstance();
			_calendar.setTime(_time);
			_iYear = _calendar.get(Calendar.YEAR);
			_iMonth = _calendar.get(Calendar.MONTH);
			_iDay = _calendar.get(Calendar.DAY_OF_MONTH);
			_iHour = _calendar.get(Calendar.HOUR_OF_DAY);
			_iMin = _calendar.get(Calendar.MINUTE);
			//
			String[] _dateAndWeekList = new String[1];
			_dateAndWeekList[0] = (_iMonth + 1) + "/" + _iDay + "/" + _iYear;
			//
			_timingInfoList = new TimingInfo[1];
			_timingInfoList[0] = new TimingInfo();
			_timingInfoList[0].setHour(_iHour < 10 ? "0" + _iHour : String.valueOf(_iHour));
			_timingInfoList[0].setMin(_iMin < 10 ? "0" + _iMin : String.valueOf(_iMin));
			_timingInfoList[0].setDate(_dateAndWeekList);
		} else if (_tiType.intValue() == 2) {
			String[] _array = _sPeriodTime.split(":");
			int _iHour = -1;
			int _iMin = -1;
			//
			_iHour = Integer.parseInt(_array[0]);
			_iMin = Integer.parseInt(_array[1]);
			//
			_timingInfoList = new TimingInfo[1];
			_timingInfoList[0] = new TimingInfo();
			_timingInfoList[0].setHour(_iHour < 10 ? "0" + _iHour : String.valueOf(_iHour));
			_timingInfoList[0].setMin(_iMin < 10 ? "0" + _iMin : String.valueOf(_iMin));
			_timingInfoList[0].setPeriod(_periodValue + _sPeriodUnit);
		}

		return _timingInfoList;
	}

	//------------------//
	public TrsCkmSoapClient getTrsCkmSoapClient(STATransConfInfo _staTransConfInfo) {
		ServerConInfo serverConfInfo=null;
		TrsCkmSoapClient _client = null;
		try {
			serverConfInfo=TransInfoUtils.getDefaultInstance().getServerConInfo(_staTransConfInfo);
		} catch (STATransException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(serverConfInfo!=null)
			_client = new TrsCkmSoapClient("http://"+serverConfInfo.getHost()+":"+serverConfInfo.getPort(), serverConfInfo.getUser(), serverConfInfo.getPassword());
		return _client;
	}

	/**
	 * 获取服务器连接信息
	 *
	 * @param _staTransConfInfo
	 * @return
	 * @throws STATransException
	 */
	public ServerConInfo getServerConInfo(STATransConfInfo _staTransConfInfo) throws STATransException {
		String _sServerConInfo = null;

		if (_staTransConfInfo == null) {
			throw new STATransException(-9999, "未获取到服务器信息。");
		} else {
			_sServerConInfo = _staTransConfInfo.getTransConfContent();
		}

		return this.getServerConInfo(_sServerConInfo);
	}

	/**
	 * 获取服务器连接信息
	 *
	 * @param _sServerConInfo
	 * @return
	 * @throws STATransException
	 */
	public ServerConInfo getServerConInfo(String _sServerConInfo) throws STATransException {
		String[] _serverConInfoList = null;

		if (_sServerConInfo == null) {
			throw new STATransException(-9999, "未获取到服务器信息。");
		} else {
			_serverConInfoList = _sServerConInfo.split("/");
		}
		if (_serverConInfoList.length != 4) {
			throw new STATransException(-9999, "获取到的服务器信息不合法。");
		}

		return this.getServerConInfo(_serverConInfoList);
	}

	/**
	 * 获取服务器连接信息
	 *
	 * @param _serverConInfoList
	 * @return
	 */
	public ServerConInfo getServerConInfo(String[] _serverConInfoList) {
		return new ServerConInfo(_serverConInfoList[0], _serverConInfoList[1], _serverConInfoList[2], _serverConInfoList[3]);
	}

	/**
	 * 获取排重服务器信息
	 *
	 * @param _staTransConfInfo
	 * @return
	 * @throws STATransException
	 */
	public RMSSIMServerInfo getSIMServerInfo(STATransConfInfo _staTransConfInfo) throws STATransException {
		RMSSIMServerInfo _RMSSIMServerInfo = null;
		String _sTransConfContent = null;
		String[] _RMSSIMServerInfoList = null;

		if (_staTransConfInfo == null) {
			throw new STATransException(-9999, "未获取到排重服务器信息。");
		} else {
			_sTransConfContent = _staTransConfInfo.getTransConfContent();
		}

		if (_sTransConfContent == null || _sTransConfContent.length() == 0) {
			throw new STATransException(-9999, "记录的排重服务器信息为空。");
		}

		_RMSSIMServerInfoList = _sTransConfContent.split(":");
		if (_RMSSIMServerInfoList.length != 2) {
			throw new STATransException(-9999, "获取到的排重服务器信息不合法。");
		}

		_RMSSIMServerInfo = new RMSSIMServerInfo();
		_RMSSIMServerInfo.setId(_staTransConfInfo.getId());
		_RMSSIMServerInfo.setHost(_RMSSIMServerInfoList[0]);
		_RMSSIMServerInfo.setPort(_RMSSIMServerInfoList[1]);
		Socket socket = null;
		try {
			 socket = new Socket(_RMSSIMServerInfoList[0],Integer.valueOf(_RMSSIMServerInfoList[1]));
		} catch (NumberFormatException e) {
			//throw new STATransException(-9999, "获取到的排重服务器信息不合法。");
		} catch (UnknownHostException e) {
			//throw new STATransException(-9999, "获取到的排重服务器信息不合法。");
		} catch (IOException e) {
			//_RMSSIMServerInfo.setStateDesc("不可连接");
		}
		if(socket!=null){
			_RMSSIMServerInfo.setStateDesc("可连接");
		}else{
			_RMSSIMServerInfo.setStateDesc("不可连接");
		}
		return _RMSSIMServerInfo;
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main(String[] args[]) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

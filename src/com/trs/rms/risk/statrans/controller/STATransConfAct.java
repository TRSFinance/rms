package com.trs.rms.risk.statrans.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trs.ckm.client.data.ServerConInfo;
import com.trs.ckm.client.utils.STAConstants;
import com.trs.ckm.soap.CkmSoapException;
import com.trs.ckm.soap.TrsCkmSoapClient;
import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.PDMListSTAServer;
import com.trs.rms.risk.statrans.bean.STAServerInfo;
import com.trs.rms.risk.statrans.bean.STATransConfInfo;
import com.trs.rms.risk.statrans.dao.criterion.STATransConfCriterion;
import com.trs.rms.risk.statrans.exp.STATransException;
import com.trs.rms.risk.statrans.service.STATransConfService;
import com.trs.rms.risk.statrans.service.STATransModelService;
import com.trs.rms.risk.statrans.service.STATransService;
import com.trs.rms.risk.statrans.util.TransInfoUtils;

@Controller
@RequestMapping("/dasService")
public class STATransConfAct {
	@Autowired
	private STATransConfService staTransConfService;
	@Autowired
	private STATransService staTransService;
	@Autowired
	private STATransModelService staTransModelService;

	/**
	 * 查询
	 */
	@RequestMapping("/listDASServe.do")
	public String query(STATransConfCriterion staTransConfCriterion,String dbPageStr,String pageSizeStr,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) {
		PDMListSTAServer   staServer=new PDMListSTAServer();
		int   dbPage=1;
		if(StringUtils.isNotBlank(dbPageStr)){
			dbPage=Integer.parseInt(dbPageStr);
		}
		int   pageSize=10;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		int _iSize = 0;
		STAServerInfo[] _STAServerInfoList = null;
		STATransConfInfo _staTransConfInfo = null;
		ServerConInfo _serverConInfo = null;
		int _iState = STAConstants.ServerState_Available;
		String _sStateDesc = "可连接";
		String errorTitle = "";
		String  errorMsg ="";
		if (staTransConfCriterion == null) {
			staTransConfCriterion = new STATransConfCriterion();
			staTransConfCriterion.setTransConfType("DAS服务器信息");
			staTransConfCriterion.setTransConfTag(new Integer(1));
		} else {
			staTransConfCriterion.setTransConfType("DAS服务器信息");
			staTransConfCriterion.setTransConfTag(new Integer(1));
		}

		PagedArrayList<STATransConfInfo> result = staTransConfService.pagedSTATransConfInfo(staTransConfCriterion, new OffsetLimit( (dbPage - 1) * pageSize, pageSize));

		_iSize = result.getSize();
		if (_iSize > 0) {
			_STAServerInfoList = new STAServerInfo[_iSize];
			for (int i = 0; i < _iSize; i++) {
				_STAServerInfoList[i] = new STAServerInfo();
				_staTransConfInfo = result.get(i);

				_iState = STAConstants.ServerState_Available;
				_sStateDesc = "可连接";

				try {
					_serverConInfo = TransInfoUtils.getDefaultInstance().getServerConInfo(_staTransConfInfo.getTransConfContent());
				} catch (STATransException e) {
					// TODO Auto-generated catch block
					errorTitle = "解析DAS服务器连接信息失败";
					errorMsg = "解析DAS服务器连接信息失败。" + e.getErrorMessage();
					return "error";
				}

				try {
					TrsCkmSoapClient _client = new TrsCkmSoapClient("http://"+_serverConInfo.getHost()+":"+_serverConInfo.getPort(),_serverConInfo.getUser(), _serverConInfo.getPassword());
					 _client.GetSystemParameters(0);
				} catch (CkmSoapException e) {
					// TODO Auto-generated catch block
					_iState = STAConstants.ServerState_Unavailable;
					_sStateDesc = "不可连接";
				}
				_STAServerInfoList[i].setId(_staTransConfInfo.getId());
				_STAServerInfoList[i].setName(_staTransConfInfo.getTransConfName());
				_STAServerInfoList[i].setHost(_serverConInfo.getHost());
				_STAServerInfoList[i].setPort(_serverConInfo.getPort());
				_STAServerInfoList[i].setUser(_serverConInfo.getUser());
				_STAServerInfoList[i].setPassword(_serverConInfo.getPassword());
				_STAServerInfoList[i].setState(_iState);
				_STAServerInfoList[i].setStateDesc(_sStateDesc);
			}
		}

		staServer.setStaServerInfoList(_STAServerInfoList);

		return "success";
	}
	
	
	
	/**
	 * DAS服务器  删除操作
	 * @param ids
	 *        DAS服务器记录ID列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/dasServerHandle.do")
	public String dasServerHandle(String ids,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) {
		String[] _idsArray = null;
		StringBuffer _errorMsgStrBuf = new StringBuffer("");
		int _iSuccessNum = 0;
		int _iFailedNum = 0;
		String _sHandleType = "删除";
		String errorTitle = "删除DAS服务器出错";

		String errorMsg;
		if(StringUtils.isBlank(ids)) {
			_errorMsgStrBuf.append("没有要" + _sHandleType + "的DAS服务器。\n");
			errorMsg = _errorMsgStrBuf.toString();
			model.addAttribute("errorTitle", errorTitle);
			model.addAttribute("errorMsg", errorMsg);
			return "error";
		}

		_idsArray = ids.split(","); // STA服务器记录ID列表
		for(int i = 0; i < _idsArray.length; i++) {
			Long _id = null;
			STATransConfInfo _staTransConfInfo = null;

			try { // ID类型转义
				_id = Long.valueOf(StringUtils.trim(_idsArray[i]));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				_errorMsgStrBuf.append(_sHandleType + "第" + (i + 1) + "个DAS服务器失败，DAS服务器记录ID不为Long类型。STA服务器记录ID：" + _idsArray[i] + "\n");
				_iFailedNum += 1;
				continue;
			}

			_staTransConfInfo = new STATransConfInfo();
			_staTransConfInfo.setId(_id);
			staTransConfService.deleteSTATransConfInfo(_staTransConfInfo);
		}

		errorMsg = _errorMsgStrBuf.toString();
		if (StringUtils.isNotBlank(errorMsg)) {
			errorMsg = _sHandleType + "DAS服务器。成功" + _iSuccessNum + "个，失败" + _iFailedNum + "个。\n" + errorMsg;
			model.addAttribute("errorTitle", errorTitle);
			model.addAttribute("errorMsg", errorMsg);
			return "error";
		}

		return "index";
	}
	/**
	 * 编辑页面
	 */
	@RequestMapping("/edit.do")
	public String edit( STAServerInfo staServer,HttpServletRequest request,HttpServletResponse response,
			ModelMap model) {
		STATransConfInfo _staTransConfInfo = null;
		String _sServerConInfo = null;
		ServerConInfo _serverConInfo = null;

		if (staServer == null) {
			staServer = new STAServerInfo();
		}

		String errorTitle = "添加DAS服务器出错";
		if (staServer.getId() != null) {
			errorTitle = "修改DAS服务器出错";
		}
		String errorMsg="";

		if (staServer.getId() != null) {
			_staTransConfInfo = staTransConfService.getSTATransConfInfo(staServer.getId());
			if (_staTransConfInfo == null) {
				errorMsg = "根据DAS服务器记录ID未获取到DAS服务器信息。";
				return "error";
			}

			_sServerConInfo = _staTransConfInfo.getTransConfContent();
			try {
				_serverConInfo = TransInfoUtils.getDefaultInstance().getServerConInfo(_sServerConInfo);
			} catch (STATransException e) {
				// TODO Auto-generated catch block
				errorMsg = "解析DAS服务器连接信息失败。" + e.getErrorMessage();
				return "error";
			}

			staServer.setName(_staTransConfInfo.getTransConfName());
			staServer.setHost(_serverConInfo.getHost());
			staServer.setPort(_serverConInfo.getPort());
			staServer.setUser(_serverConInfo.getUser());
			staServer.setPassword(_serverConInfo.getPassword());
		} else {
			staServer.setName("DAS服务器");
			staServer.setHost("127.0.0.1");
			staServer.setPort("8002");
			staServer.setUser("admin");
			staServer.setPassword("trsadmin");
		}

		return "edit";
	}
	/**
	 * 更新
	 */
	public String update(STAServerInfo staServer,HttpServletRequest request,HttpServletResponse response,
			ModelMap model) {
		
		String _sName = staServer.getName(); // 页面信息
		String _sHost = staServer.getHost();
		String _sPort = staServer.getPort();
		String _sUser = staServer.getUser();
		String _sPassword = staServer.getPassword();
		String _sTransSTAServerInfo = null;
		STATransConfInfo _staTransConfInfo = null;

		String errorTitle = "";
		if (staServer.getId() != null) {
			errorTitle = "修改DAS服务器出错";
		}

		String errorMsg="";
		// 参数校验
		if (_sName == null || _sName.equals("")) {
			errorMsg = "DAS服务器名称设置为空。";
			return "error";
		}
		if (_sHost == null || _sHost.equals("")) {
			errorMsg = "DAS服务器地址设置为空。";
			return "error";
		}
		if (_sPort == null || _sPort.equals("")) {
			errorMsg = "DAS服务器端口设置为空。";
			return "error";
		}
		if (_sUser == null || _sUser.equals("")) {
			errorMsg = "DAS服务器用户名设置为空。";
			return "error";
		}

		if (_sPassword == null) {
			_sPassword = "";
		}

		//校验服务器地址格式
		Pattern hostPattern = Pattern.compile("^((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))$");
		Matcher hostMatcher = hostPattern.matcher(_sHost);
		if (hostMatcher.matches()==false){
			errorMsg = "DAS服务器地址设置格式错误。";
			return "error";
		}
		//校验端口号地址格式
		Pattern portPattern = Pattern.compile("^([0-9]|[1-9]\\d|[1-9]\\d{2}|[1-9]\\d{3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])$");
		Matcher portMatcher = portPattern.matcher(_sPort);
		if (portMatcher.matches()==false){
			errorMsg = "DAS服务器端口设置格式错误。";
			return "error";
		}

		

		// 判断STA服务器名称是否已存在

		// STA服务器提交的STA服务器信息描述
		_sTransSTAServerInfo = _sHost + "/" + _sPort + "/" + _sUser + "/" + _sPassword;

		// 将STA服务器保存到MySQL
		_staTransConfInfo = new STATransConfInfo();
		_staTransConfInfo.setId(staServer.getId());
		_staTransConfInfo.setTransConfType("DAS服务器信息");
		_staTransConfInfo.setTransConfName(_sName);
		_staTransConfInfo.setTransConfContent(_sTransSTAServerInfo);
		_staTransConfInfo.setTransConfTag(new Integer(1));
		staTransConfService.saveSTATransConfInfo(_staTransConfInfo);
		return "index";
	}
	
	
	
	
	
	
	
	public STATransConfService getStaTransConfService() {
		return staTransConfService;
	}

	public void setStaTransConfService(STATransConfService staTransConfService) {
		this.staTransConfService = staTransConfService;
	}
	public STATransService getStaTransService() {
		return staTransService;
	}
	public void setStaTransService(STATransService staTransService) {
		this.staTransService = staTransService;
	}
	public STATransModelService getStaTransModelService() {
		return staTransModelService;
	}
	public void setStaTransModelService(STATransModelService staTransModelService) {
		this.staTransModelService = staTransModelService;
	}

	
	
	
}

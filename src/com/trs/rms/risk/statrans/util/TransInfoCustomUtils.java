package com.trs.rms.risk.statrans.util;

import com.trs.ckm.client.data.sta.transinfo.CTransInfo;
import com.trs.rms.mail.bean.MailConfigBean;
import com.trs.rms.risk.statrans.bean.PDMEditTrans;
import com.trs.rms.risk.statrans.exp.STATransException;


/**
 *
 *
 * @author clinzy 2012-4-3
 *
 */
public class TransInfoCustomUtils extends TransInfoUtils {
	/**
	 * 自身默认实例
	 */
	private static TransInfoCustomUtils instance;

	/**
	 * 构造函数
	 */
	public TransInfoCustomUtils() {

	}

	/**
	 * 返回自身默认实例
	 *
	 * @return
	 */
	public static TransInfoCustomUtils getDefaultInstance() {
		if (instance == null) {
			instance = new TransInfoCustomUtils();
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
		String _sTransDefine = null; // 页面信息
		CTransInfo _cTransInfo = null;

		// 页面信息
		_sTransDefine = _pageDataModel.getTransDefine();

		// 解析任务描述
		_cTransInfo = super.parseCTransInfo(_sTransDefine, "解析任务描述失败：");

		return _cTransInfo;
	}
}

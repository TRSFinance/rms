package com.trs.rms.company.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.trs.rms.base.service.BasicService;
import com.trs.rms.company.bean.RmsCorporateUser;

public interface RmsCompanyInfoService extends BasicService {

	boolean insertFiletoDb(HttpServletRequest request,String savepath,String uuidname,Long userId);

	void deleteRmsCorporateCust(Long custId, Long publicUserId);
	
}

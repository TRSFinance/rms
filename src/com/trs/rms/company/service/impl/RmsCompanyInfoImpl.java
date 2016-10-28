package com.trs.rms.company.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.page.Param;
import com.trs.rms.base.service.BasicServicveImpl;
import com.trs.rms.company.bean.RmsCompanyInfo;
import com.trs.rms.company.bean.RmsCorporateCust;
import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.company.service.RmsCompanyInfoService;
import com.trs.rms.usermgr.bean.RmsUser;
import com.trs.rms.usermgr.controller.RmsRoleAct;

@Service
@Transactional
public class RmsCompanyInfoImpl extends BasicServicveImpl implements RmsCompanyInfoService{
	
	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}

	@Override
	public boolean insertFiletoDb(HttpServletRequest request, String savepath,
			String uuidname,Long userId) {		
		if(userId==null){
			return false;
		}
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(request.getServletContext().getRealPath(savepath)+"\\"+uuidname);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}		
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(inputStream);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(0);
		//行数
		int rows=sheet.getRows();
		//列数
		int cols=sheet.getColumns();
		//将表格内容存放到list数组中
		for (int i = 1; i < rows; i++) {
			List<String> list = new ArrayList<String>();
			for(int j = 0; j < cols; j++){
				Cell cell = sheet.getCell(j, i);				
				String value = cell.getContents();
				if(value!=null&&!"".equals(value)){
					list.add(value);
				}else{
					list.add("");
				}					
			}			
			//判断是否已经存在于RmsCorporateCust表中了
			int z=0;
			Long custId = null;
			List<Param> Paramlist = new ArrayList<Param>();		
			Paramlist.add(new Param(Types.BIGINT,userId));
			Paramlist.add(new Param(Types.VARCHAR,list.get(0).trim()));
			@SuppressWarnings("unchecked")
			List<RmsCorporateCust> list3 = dao.query(" from com.trs.rms.company.bean.RmsCorporateCust rcu where rcu.corporateUser.userId=? and rcu.companyInfo.custCfname=?",Paramlist);
			//已存在RmsCorporateCust表中，结束本次流程，进入下一次循环。
			if(list3!=null&&list3.size()>0){
				continue;
			}							
			//不在RmsCorporateCust表中，判断是否在RmsCompanyInfo表中
			List<Param> Paramlist2 = new ArrayList<Param>();		
			Paramlist2.add(new Param(Types.VARCHAR,list.get(0).trim()));
			@SuppressWarnings("unchecked")
			List<RmsCompanyInfo> list2 = dao.query(" from com.trs.rms.company.bean.RmsCompanyInfo rci where rci.custCfname=?",Paramlist2);			
			if(list2!=null&&list2.size()>0){
				z++;
				custId = list2.get(0).getCustId();
			}
			//不在RmsCorporateCust表中，也不在RmsCompanyInfo表中
			if(z==0){
				RmsCompanyInfo rci = new RmsCompanyInfo();						
				rci.setCustCfname(list.get(0));
				rci.setCustCsname(list.get(1));			
				rci.setCustEfname(list.get(1));
				rci.setCustEsname(list.get(3));
				rci.setCustOrgid(list.get(4));
				rci.setCustIndustrycode(list.get(5));
				rci.setCustIndustry1(list.get(6));
				rci.setCustIndustry2(list.get(7));
				rci.setAreaCode(list.get(8));
				rci.setDistrictName(list.get(9));
				rci.setProvinceName(list.get(10));
				rci.setCityName(list.get(11));
				rci.setIcCode(list.get(12));
				rci.setTaxCode(list.get(13));
				rci.setStockCode(list.get(14));			
				rci.setState(1);
				rci.setDataSource(2);
				rci.setPinyin("");
				rci.setCreateTime(new Date());
				rci.setChangeTime(new Date()); 
				dao.save(rci);
				RmsCorporateCust rmsCorporateCust = new RmsCorporateCust();
				RmsCorporateUser rmsCorporateUser = (RmsCorporateUser) dao.queryById(RmsCorporateUser.class, userId);			
				rmsCorporateCust.setCompanyInfo(rci);
				rmsCorporateCust.setCorporateUser(rmsCorporateUser);
				rmsCorporateCust.setCreateTime(new Date());
				dao.save(rmsCorporateCust);			
			}else{
				//不在RmsCorporateCust表中，但是在RmsCompanyInfo表中
				RmsCompanyInfo rci = (RmsCompanyInfo) dao.queryById(RmsCompanyInfo.class, custId);
				RmsCorporateCust rmsCorporateCust = new RmsCorporateCust();
				RmsCorporateUser rmsCorporateUser = (RmsCorporateUser) dao.queryById(RmsCorporateUser.class, userId);			
				rmsCorporateCust.setCompanyInfo(rci);
				rmsCorporateCust.setCorporateUser(rmsCorporateUser);
				rmsCorporateCust.setCreateTime(new Date());
				dao.save(rmsCorporateCust);				
			}	
				
		}		
		try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;		
	}

	@Override
	public void deleteRmsCorporateCust(Long custId, Long publicUserId) {

		String sql = "delete from rms_corporate_cust where cust_id=? and user_id=?";
		List<Param> list = new ArrayList<Param>();		
		list.add(new Param(Types.BIGINT,custId));
		list.add(new Param(Types.BIGINT,publicUserId));
		dao.updateSql(sql, list);
	}


	
}

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
@Service
@Transactional
public class RmsCompanyInfoImpl extends BasicServicveImpl implements RmsCompanyInfoService{

	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}
	
	@Override
	public List<RmsCorporateUser> list(){

		List<RmsCorporateUser> list = (List<RmsCorporateUser>) dao.query("from RmsCorporateUser rcu where rcu.rmsUser.userType=2");
		
		return list;
		
	}

	
	
	@Override
	public long getUserId() {		
		System.out.println("查询用户的id");
		String username = "";
		List<RmsUser> list = dao.query("from rms_user where loginName="+username);
		return list.get(0).getUserId();		
	}

	@Override
	public void updateData(List list) {
		System.out.println("我来了");
		String sql = "update rms_company_info set CUST_CFNAME=?,CUST_CSNAME=?, "+
		"CUST_INDUSTRY1=?,CUST_INDUSTRY2=? where CUST_ID=?";
	
		dao.updateSql(sql, list);
		
	}

	@Override
	public void add(Collection c) {
		dao.save(c);		
	}

	@Override
	public boolean insertFiletoDb(HttpServletRequest request, String savepath,
			String uuidname,Long userId) {
		//System.out.println(("userid=")+userId);
		
		if(userId==null){
			return false;
		}
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(request.getServletContext().getRealPath(savepath)+"\\"+uuidname);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(inputStream);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(0);
		//行数
		int rows=sheet.getRows();
		//列数
		int cols=sheet.getColumns();

		List<RmsCompanyInfo> list = dao.query("from  com.trs.rms.company.bean.RmsCompanyInfo");
		long maxCustId = list.get(list.size()-1).getCustId();
		for (int i = 1; i < rows; i++) {
			List list2 = new ArrayList();
			for(int j = 0; j < cols; j++){
				Cell cell = sheet.getCell(j, i);
				
//				if(cell!=null){	
					String value = cell.getContents();
					if(value!=null&&!"".equals(value)){
						list2.add(value);
					}else{
						list2.add("");
					}					
//				}
		
			}

			RmsCompanyInfo rci = new RmsCompanyInfo();
			
			rci.setCustOrgid(list2.get(0).toString());
			rci.setCustCfname(list2.get(1).toString());
			rci.setCustCsname(list2.get(2).toString());			
			rci.setCustEfname(list2.get(3).toString());
			rci.setCustEsname(list2.get(4).toString());
			rci.setCustIndustrycode(list2.get(5).toString());
			rci.setCustIndustry1(list2.get(6).toString());
			rci.setCustIndustry2(list2.get(7).toString());
			rci.setAreaCode(list2.get(8).toString());
			rci.setDistrictName(list2.get(9).toString());
			rci.setProvinceName(list2.get(10).toString());
			rci.setCityName(list2.get(11).toString());
			rci.setIcCode(list2.get(12).toString());
			rci.setTaxCode(list2.get(13).toString());
			rci.setStockCode(list2.get(14).toString());
			
			rci.setState(1);
			rci.setDataSource(2);
			rci.setPinyin("");
			rci.setCreateTime(new Date());
			rci.setChangeTime(new Date()); 

			dao.save(rci);
			RmsCorporateCust rmsCorporateCust = new RmsCorporateCust();
			
			String sql="insert into rms_corporate_cust (CUST_ID,USER_ID,CREATE_TIME) values (?,?,?) ";
			List list3 = new ArrayList();	
			maxCustId=maxCustId+1;
			list3.add(new Param(Types.BIGINT,maxCustId));
			list3.add(new Param(Types.BIGINT,userId));
			list3.add(new Param(Types.TIMESTAMP,new Date()));
			dao.updateSql(sql, list3);	
		}
		
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	
}

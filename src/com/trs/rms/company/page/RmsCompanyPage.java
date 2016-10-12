package com.trs.rms.company.page;

import java.sql.Types;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.trs.rms.base.page.BasicPage;
import com.trs.rms.base.page.IBasicDao;
@Component
public class RmsCompanyPage extends BasicPage{
	
	
	private String searchword="";

	@Override
	public void addParameter() {
		String hql = "  from  com.trs.rms.company.bean.RmsCompanyInfo rci where 1=1   ";
		hql= hql+"  and rci.state=?";
		this.addParams(Types.INTEGER,1);
		if(searchword!=null &&  searchword.trim().length()>0){
			hql= hql+"  and (rci.custCfname like ?  or  rci.custCsname  like ?)";
			this.addParams(Types.VARCHAR,"%"+searchword+"%");
			this.addParams(Types.VARCHAR,searchword+"%");

		}
		
		this.setHQLString(hql);
		this.setHQLCountString("select count(*) "+hql);
	}

	@Override
	@Resource(name="publicDao")
	public void setMyPublicDao(IBasicDao publicDao) {
		super.setPublicDao(publicDao);
	}

	public String getSearchword() {
		return searchword;
	}

	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	
	
	
}



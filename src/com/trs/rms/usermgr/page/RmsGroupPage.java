package com.trs.rms.usermgr.page;

import java.sql.Types;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.trs.rms.base.page.IBasicDao;
import com.trs.rms.base.page.BasicPage;
@Component
public class RmsGroupPage   extends  BasicPage{
	private String searchword="";

	@Override
	public void addParameter() {
		String hql = "  from  com.trs.rms.usermgr.bean.RmsGroup rg where 1=1   ";

		if(searchword!=null &&  searchword.trim().length()>0){
			hql= hql+"  and rg.groupName like ?";
			this.addParams(Types.VARCHAR,"%"+searchword.trim()+"%");
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

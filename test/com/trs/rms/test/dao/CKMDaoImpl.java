package com.trs.rms.test.dao;


import org.springframework.stereotype.Repository;

import com.trs.rms.base.dao.hibernate3.GenericHibernateDAO;
import com.trs.rms.test.bean.RmsTest;
@Repository
public class CKMDaoImpl   extends  GenericHibernateDAO<RmsTest, Long>  implements  CKMDao{



}

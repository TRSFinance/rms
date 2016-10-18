package com.trs.rms.base.dao;



import org.apache.log4j.Logger;

import com.trs.hybase.client.TRSConnection;
import com.trs.hybase.client.params.ConnectParams;
import com.trs.rms.base.param.HBConnectionParam;
/**
 * HYBASE 连接工厂
 * @author 邹许红
 *
 */
public class HyBaseConnectionFactory{
	private static final Logger LOGGER = Logger.getLogger(HyBaseConnectionFactory.class);
	private  HBConnectionParam  hybasedataSource;
	private  TRSConnection     connection;
	
	//------------------SET GET方法----------------------
	public HBConnectionParam getHybasedataSource() {
		return hybasedataSource;
	}
	public void setHybasedataSource(HBConnectionParam hybasedataSource) {
		this.hybasedataSource = hybasedataSource;
	}
	public TRSConnection getConnection() {
		String host=hybasedataSource.getHost();
		String port=hybasedataSource.getPort();
		String user=hybasedataSource.getUser();
		String passwd=hybasedataSource.getPasswd();
		long timeout=Long.valueOf(hybasedataSource.getTimeout());		
		
		ConnectParams param = new ConnectParams();
		param.setTimeout(timeout);
		
		if(host!=null&&port!=null&&user!=null&&passwd!=null){
			LOGGER.debug("开始建立连接");
			String[]  hosts=host.split(";");
			String url="";
			for (int i = 0; i < hosts.length; i++) {
				if(i>0)
					url=url+";";
				url=url+"http://"+hosts[i]+":"+port;
				
			}
			connection = new TRSConnection(url, user, passwd, param);
		}else{
			LOGGER.error("连接参数有误，请仔细检查");
		}
		
		return connection;
	}
	public void setConnection(TRSConnection connection) {
		this.connection = connection;
	}
}

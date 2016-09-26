package com.trs.rms.ckm.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import com.trs.ckm.soap.*;

/**
 * 分类测试代码
 * */
public class CKMTest 
{
   private TrsCkmSoapClient soapclient=null;
   private String modelname=null;
   
   public CKMTest(TrsCkmSoapClient _client,String _name)
   {
	   soapclient=_client;
	   modelname=_name;
   }
   
   /**
	   * B方法追加文件：使用FileWriter
	   * @param fileName
	   * @param content
	   */
	public  void appendMethodB(String fileName, String content)
	{
	   try 
	   {
	    //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
	    FileWriter writer = new FileWriter(fileName, true);
	    writer.write(content);
	    writer.close();
	   } 
	   catch (Exception e) 
	   {
	     e.printStackTrace();
	   }
	}
	
	/**
	 * 解析xml文件返回document对象
	 * @param filename xml文件名称
	 * @return String 文档内容
	 * */
	public  String ParseXML(String filename)
	{
		String content=null;
		Document doc=null;
		try
		{
			File r=new File(filename);
			//SAXReader reader = new SAXReader();
			//doc=reader.read(r);
			SAXReader reader = new SAXReader();
			Map map = new HashMap();
			map.put("CNML","http://www.cnml.org.cn/2005/CNMLSchema");
			reader.getDocumentFactory().setXPathNamespaceURIs(map);
			//InputStream is = servletContext.getResourceAsStream("xxxx"); 
			doc = reader.read(r);

			//Namespace m = new Namespace(doc.);
		   // m.AddNamespace("ab"，

			if(doc!=null)
			{
				List ele=doc.selectNodes("//CNML:CNML/CNML:Items/CNML:Item/CNML:Contents/CNML:ContentItem/CNML:DataContent");
				//List ele=doc.selectNodes("relations/relationGroup");
				//System.out.println(ele.size());
				if(ele!=null && ele.size()>0)
				{
				    Element e=(Element)ele.get(0);
				    content=e.getTextTrim();
			     }
			}
		}
		catch(Exception e)
		{
			System.out.println("ParseXML Failed:"+e.getMessage());
		}
		return content;
	}
	/**
  * 获取文件内容
  * @param _sFilePath 文件路径
  * @param _sEncoding 内容编码
  * @return
  * @throws Exception
  */
 public  String getFileContent(String _sFilePath, String _sEncoding) throws Exception
 {
     FileInputStream fInputStream = null;
     InputStreamReader fInputStreamReader = null;
     BufferedReader fBufferedReader = null;

     String sContent = "";
     String sLine = null;

     fInputStream = new FileInputStream(new File(_sFilePath));
     fInputStreamReader = new InputStreamReader(fInputStream, _sEncoding);
     fBufferedReader = new BufferedReader(fInputStreamReader);
     while ((sLine = fBufferedReader.readLine()) != null)
     {
     	sContent+=sLine+"\r\n";
     }

     fBufferedReader.close();
     fInputStreamReader.close();
     fInputStream.close();
     return sContent;
 }
 public  int processDir(String path)  throws Exception
 {
 	int  result=0;
 	if(path==null || path.equals(""))
     {
     	return result;
     }
     
     LinkedList list = new LinkedList();
     File dir = new File(path);
     File file[] = dir.listFiles();
     for (int i = 0; i < file.length; i++) 
     {
     	if (file[i].isDirectory())
         {
     		System.out.println("*****************");
     		list.add(file[i]);
         }
         else
         {
            /* 文件内容处理 */
        	 String content=ParseXML(file[i].getAbsolutePath());
        	 String result1="";
        	 result1=file[i].getAbsolutePath();
        	 if(content!=null && !content.equals(""))
        	 {
        		 //System.out.println(content);
        		 CATRevDetail[] catRev=soapclient.CATClassifyText(modelname, content);
        		 if(catRev!=null)
        		 {
        			 result1+="\t";
        			 for(int j=0;j<catRev.length;j++)
        			 {
        				 result1+=catRev[j].getCATName()+";";
        			 }
        		 }
        	 }
        	 result1+="\n";
        	 appendMethodB("G:\\result.txt",result1);
         }
     }
     File tmp;
     while (!list.isEmpty()) 
     {
     	System.out.println("#########################");
     	tmp = (File)list.removeFirst();
         if (tmp.isDirectory()) 
         {
             file = tmp.listFiles();
             if (file == null)
                 continue;
             for (int i = 0; i < file.length; i++) 
             {
                 if (file[i].isDirectory())
                     list.add(file[i]);
                 else
                 {
                 	/* 文件内容处理 */
                	 String content=ParseXML(file[i].getAbsolutePath());
                	 String result1="";
                	 result1=file[i].getAbsolutePath();
                	 if(content!=null)
                	 {
                		 CATRevDetail[] catRev=soapclient.CATClassifyText(modelname, content);
                		 if(catRev!=null)
                		 {
                			 result1+="\t";
                			 for(int j=0;j<catRev.length;j++)
                			 {
                				 result1+=catRev[j].getCATName()+";";
                			 }
                		 }
                	 }
                	 appendMethodB("G:\\result.txt",result1);
                 }
             }
         } 
         else 
         {
         	/* 文件内容处理 */
        	 String content=ParseXML(tmp.getAbsolutePath());
        	 String result1="";
        	 result1=tmp.getAbsolutePath();
        	 if(content!=null)
        	 {
        		 CATRevDetail[] catRev=soapclient.CATClassifyText(modelname, content);
        		 if(catRev!=null)
        		 {
        			 result1+="\t";
        			 for(int j=0;j<catRev.length;j++)
        			 {
        				 result1+=catRev[j].getCATName()+";";
        			 }
        		 }
        	 }
        	 appendMethodB("G:\\result.txt",result1);
         }
     }
     return result;
 }
 /**
  * 规则分类接口测试
  * */
 public void RuleCatTest(String sContent) throws Exception
 { 
	 if(sContent==null || sContent.equals(""))
	 { 
		 return;
	 }
	 RuleCATField[] field=new RuleCATField[1];
	 field[0]=new RuleCATField(sContent,"正文");
	 String result =soapclient.RuleCATClassifyText("新建文件夹",field);
	 if(result!=null)
	 {
		 System.out.println(result);
	 }
	// 规则分类
     RuleCATField[] _RuleFields = new RuleCATField[1];
     //String content=getFileContent("G:\\2.txt","UTF-8");
     //System.out.println(content);
    _RuleFields[0] = new RuleCATField("计算机", "正文");
    //_RuleFields[1] = new RuleCATField("中国姚明入选美国NAB五佳球", "正文");
    String sResult=soapclient.RuleCATClassifyText("新建文件夹", _RuleFields);
    //System.out.println(System.currentTimeMillis());
    //sResult=soapclient.RuleCATClassifyText("demo", _RuleFields);
    //System.out.println(System.currentTimeMillis());
    if(sResult!=null)
    {
    	System.out.println(sResult);
    }
 }
 /**
  *自动分类测试 
  **/
 public void AutocatTestCase() throws Exception
 {
 	// 自动分类
     CATRevDetail[] _CatResult = soapclient.CATClassifyText(modelname, "体育");
     if (_CatResult != null)
     {
         for (int i = 0; i < _CatResult.length; i++)
         {
             System.out.println("置信度=" + _CatResult[i].getv() + ", 类名=" + _CatResult[i].getCATName());
         }
     }
 }
 
 /**
  * 模板上传下载测试接口
  * */
 public void ModelCaseTest(String dirPath) throws Exception
 {
	 /* 参数判空 */
	 if(dirPath==null || dirPath.equals(""))
	 {
		 return;
	 }
	 File file=new File(dirPath);
	 /* 目录不存在 */
	 if(!file.exists() || !file.isDirectory())
	 {
		 return;
	 }
	 /* 规则分类下载 */
	 int i=soapclient.RuleCATDownloadModel(modelname, Constants.MODEL_TYPE_RULE_CURRENT, dirPath+"RuleModel");
	 if(i<0)
	 {
		 System.out.println("规则模板下载失败");
	 }
	 else
	 {
		System.out.println("规则分类模板下载成功"); 
	 }
	 
	 /* 规则分类模板上传 */
	 i=soapclient.RuleCATUploadModel("test", 0, dirPath+"RuleModel");
	 if(i==0)
	 {
		 System.out.println("规则分类模板上传成功");
		 i=soapclient.RuleCATDropModel("test");
	 }
	 else
	 {
		 System.out.println("规则分类模板上传失败");
	 }
	 
	 /* 自动分类模板下载 */
	 i=soapclient.CATDownloadModel(modelname, Constants.MODEL_TYPE_AUTO_CURRENT, dirPath+"AutoCatModel");
	 if(i<0)
	 {
		 System.out.println("自动模板下载失败");
	 }
	 else
	 {
		System.out.println("自动分类模板下载成功"); 
	 }
	 
	 /* 自动分类模板上传 */
	 i=soapclient.CATUploadModel("test", 0, dirPath+"AutoCatModel");
	 if(i==0)
	 {
		 System.out.println("自动分类模板上传成功");
		 i=soapclient.CATDropModel("test");
	 }
	 else
	 {
		 System.out.println("自动分类模板上传失败");
	 }
	 
     CATModelInfo modinfo=soapclient.CATGetModelInfo(modelname, Constants.MODEL_TYPE_AUTO_CURRENT);
	 System.out.println(modinfo.getcreatedate()+"\r\n"+modinfo.gettype()+"\r\n"+
				modinfo.getxmlcatinfo()+"\r\n"+modinfo.getxmlcatinfo().length());
 }
 
/***
 * 
 * 混合分类接口测试
 * */
 public void BatchCatTest()throws Exception
 {
	 BatchCATModel[] model=new BatchCATModel[1];
     model[0]=new BatchCATModel();
	 model[0].setCATModelName("demo");
	 model[0].setnType(0xffff);//获取两种分类结果
	 model[0].setRuleCATModelName("555");
	 BatchCATField [] fields=new BatchCATField[1];
	 fields[0]=new BatchCATField();
	 fields[0].setfield("正文");
	 fields[0].setword("体育WCM52");
		//执行batchCAT
	 CATRevDetail[][] detail=soapclient.BatchCATClassifyText(fields, model);
	 for(int i=0;i<detail.length;i++)
	 {
		for(int j=0;j<detail[i].length;j++)
		{
			System.out.println(detail[i][j].getCATName()+" "+
			detail[i][j].getv());
		}
		System.out.println();
	}
 }
 public static void main(String[] args) throws Exception
 {
	System.out.println(System.getProperty("java.io.tmpdir"));
 }
}

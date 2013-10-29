package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TGSPutMainJava
{
  protected static String nl;
  public static synchronized TGSPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSPutMainJava result = new TGSPutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_4 = " = null;" + NL + "\ttry {";
  protected final String TEXT_5 = NL + "\t\tservice_";
  protected final String TEXT_6 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_9 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_12 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\tservice_";
  protected final String TEXT_15 = ".getAccountOwner();" + NL + "\t\torg.talend.gs.util.GSObjectUtil gsUtil_";
  protected final String TEXT_16 = "=new  org.talend.gs.util.GSObjectUtil();" + NL + "\t\tgsUtil_";
  protected final String TEXT_17 = ".initMimeTypes();" + NL + "\t\tjava.io.File dataDir_";
  protected final String TEXT_18 = "=new java.io.File(";
  protected final String TEXT_19 = ");" + NL + "\t\tjava.util.List<org.jets3t.service.model.GSObject>objects_";
  protected final String TEXT_20 = " =new java.util.ArrayList<org.jets3t.service.model.GSObject>();" + NL + "\t\tjava.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_21 = " = new java.util.ArrayList<java.util.Map<String,String>>();\t" + NL + "\t\t";
  protected final String TEXT_22 = "    " + NL + "\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_23 = "_";
  protected final String TEXT_24 = " = new java.util.HashMap<String,String>();" + NL + "\t\tmap_";
  protected final String TEXT_25 = "_";
  protected final String TEXT_26 = ".put(";
  protected final String TEXT_27 = ",";
  protected final String TEXT_28 = ");\t\t" + NL + "\t \tlist_";
  protected final String TEXT_29 = ".add(map_";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = ");       ";
  protected final String TEXT_32 = NL + "\t\tjava.util.Map<String,String> fileMap_";
  protected final String TEXT_33 = "=gsUtil_";
  protected final String TEXT_34 = ".genFileFilterList(list_";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ");" + NL + "\t\tobjects_";
  protected final String TEXT_38 = " = gsUtil_";
  protected final String TEXT_39 = ".genObjectByFileMap(fileMap_";
  protected final String TEXT_40 = ");\t";
  protected final String TEXT_41 = NL + "\t\tobjects_";
  protected final String TEXT_42 = "=gsUtil_";
  protected final String TEXT_43 = ".genGSObjectList(objects_";
  protected final String TEXT_44 = ", dataDir_";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ",true,false);";
  protected final String TEXT_47 = NL + "\t\tfor(org.jets3t.service.model.GSObject obj_";
  protected final String TEXT_48 = ":objects_";
  protected final String TEXT_49 = "){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_50 = " ++;" + NL + "\t\t\tservice_";
  protected final String TEXT_51 = ".putObject(";
  protected final String TEXT_52 = ", obj_";
  protected final String TEXT_53 = ");" + NL + "\t\t}" + NL + "\t" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_54 = ") {";
  protected final String TEXT_55 = NL + "\t\tthrow(e_";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_58 = ".getMessage());";
  protected final String TEXT_59 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_60 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_61 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_63 = "_NB_LINE\", nb_line_";
  protected final String TEXT_64 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	String secretKey = ElementParameterParser.getValue(node, "__SECRET_KEY__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String bucketName=ElementParameterParser.getValue(node,"__BUCKET__");
	
	String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	boolean isUseFilesList=("true").equals(ElementParameterParser.getValue(node, "__USE_FILES_LIST__"));
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    
	}else{

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(secretKey);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    		
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
		if(isUseFilesList && files!=null && files.size()>0){
			for (int i=0; i<files.size(); i++) {
    			Map<String, String> line = files.get(i);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_31);
    
			}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
		}else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_46);
    
		}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
		} else {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
		}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    return stringBuffer.toString();
  }
}

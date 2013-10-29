package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSBucketDeleteMainJava
{
  protected static String nl;
  public static synchronized TGSBucketDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSBucketDeleteMainJava result = new TGSBucketDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_3 = " = null;" + NL + "\ttry {";
  protected final String TEXT_4 = NL + "\t\tservice_";
  protected final String TEXT_5 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_8 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_11 = " =new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\tservice_";
  protected final String TEXT_14 = ".getAccountOwner();" + NL + "\t\tservice_";
  protected final String TEXT_15 = ".deleteBucket(";
  protected final String TEXT_16 = ");" + NL + "" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_17 = ") {";
  protected final String TEXT_18 = NL + "\t\tthrow(e_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_21 = ".getMessage());";
  protected final String TEXT_22 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_23 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_24 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t}" + NL + "\t";

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
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_6);
    
	}else{

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(secretKey);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    		
	}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		} else {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
		}

    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}

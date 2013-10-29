package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSBucketExistMainJava
{
  protected static String nl;
  public static synchronized TGSBucketExistMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSBucketExistMainJava result = new TGSBucketExistMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tboolean bucketExist_";
  protected final String TEXT_3 = "=false;" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
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
  protected final String TEXT_15 = ".getAccountOwner();\t" + NL + "\t\tif(service_";
  protected final String TEXT_16 = ".getBucket(";
  protected final String TEXT_17 = ")!=null){" + NL + "\t\t\tbucketExist_";
  protected final String TEXT_18 = "=true;" + NL + "\t\t}" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_19 = ") {";
  protected final String TEXT_20 = NL + "\t\tthrow(e_";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_23 = ".getMessage());";
  protected final String TEXT_24 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_25 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_26 = ".shutdown();" + NL + "\t\t}";
  protected final String TEXT_27 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_28 = "_BUCKET_NAME\", ";
  protected final String TEXT_29 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_30 = "_BUCKET_EXIST\", bucketExist_";
  protected final String TEXT_31 = ");";

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
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		} else {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}

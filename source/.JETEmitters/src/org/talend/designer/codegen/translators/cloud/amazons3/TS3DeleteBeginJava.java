package org.talend.designer.codegen.translators.cloud.amazons3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TS3DeleteBeginJava
{
  protected static String nl;
  public static synchronized TS3DeleteBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3DeleteBeginJava result = new TS3DeleteBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_4 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"";
  protected final String TEXT_5 = "\");";
  protected final String TEXT_6 = NL + "\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_7 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_8 = ",";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_11 = " = new com.amazonaws.ClientConfiguration();";
  protected final String TEXT_12 = NL + "\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_13 = " = 0;" + NL + "\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_14 = " = 0;";
  protected final String TEXT_15 = NL + "\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";";
  protected final String TEXT_18 = NL + "\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "\t\t\t\tcc_";
  protected final String TEXT_22 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\t\t\t\tcc_";
  protected final String TEXT_25 = ".set";
  protected final String TEXT_26 = "(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\t\tcc_";
  protected final String TEXT_29 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_30 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_33 = " = new com.amazonaws.services.s3.AmazonS3Client(credentials_";
  protected final String TEXT_34 = ",cc_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_37 = " = new com.amazonaws.services.s3.AmazonS3Client(credentials_";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\ttry{" + NL + "\t\tString key_";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";" + NL + "\t\tif(key_";
  protected final String TEXT_42 = "!=null && key_";
  protected final String TEXT_43 = ".trim().length()>0){" + NL + "\t\t\tconn_";
  protected final String TEXT_44 = ".deleteObject(";
  protected final String TEXT_45 = ", key_";
  protected final String TEXT_46 = ");" + NL + "\t\t}else{" + NL + "\t\t\tthrow(new RuntimeException(\"Please set key!\"));" + NL + "\t\t}" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_47 = "){";
  protected final String TEXT_48 = NL + "\t\tthrow(e_";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_51 = ".getMessage());";
  protected final String TEXT_52 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_53 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_54 = ".shutdown();" + NL + "\t\t}";
  protected final String TEXT_55 = NL + "\t}";
  protected final String TEXT_56 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
	String key = ElementParameterParser.getValue(node,"__KEY__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

    stringBuffer.append(TEXT_2);
    
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	String secretKey = ElementParameterParser.getValue(node, "__SECRET_KEY__");
	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
if(("true").equals(useExistingConn)) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;;
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    
}else{

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(secretKey);
    stringBuffer.append(TEXT_9);
    
	if(configClient && clientConfiguration.size()>0){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		boolean setBuffer = false;
		for(Map<String,String> map :clientConfiguration){
			String client_parameter = map.get("CLIENT_PARAMETER");
			String value = map.get("VALUE");
			if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
				setBuffer=true;

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
			if("SocketSendBufferSizeHints".equals(client_parameter)){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_17);
    
			}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_20);
    
			}else if("Protocol".equals(client_parameter)){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_23);
    
			}else{

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_27);
    
			}
		}
		if(setBuffer){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
		}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	}else{

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	}
}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
		} else {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
		}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.cloud.amazons3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TS3ListBeginJava
{
  protected static String nl;
  public static synchronized TS3ListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3ListBeginJava result = new TS3ListBeginJava();
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
  protected final String TEXT_39 = NL + NL + "\tint nb_bucket_";
  protected final String TEXT_40 = " = 0;" + NL + "\tint nb_bucket_object_";
  protected final String TEXT_41 = " = 0;" + NL + "\ttry{";
  protected final String TEXT_42 = NL + "\tjava.util.List<com.amazonaws.services.s3.model.Bucket> buckets_";
  protected final String TEXT_43 = " = conn_";
  protected final String TEXT_44 = ".listBuckets();" + NL + "\tfor (com.amazonaws.services.s3.model.Bucket bucket_";
  protected final String TEXT_45 = " : buckets_";
  protected final String TEXT_46 = ") {" + NL + "\t\tString currentBucketName_";
  protected final String TEXT_47 = " = bucket_";
  protected final String TEXT_48 = ".getName();" + NL + "\t\tcom.amazonaws.services.s3.model.ObjectListing objects_";
  protected final String TEXT_49 = " = conn_";
  protected final String TEXT_50 = ".listObjects(currentBucketName_";
  protected final String TEXT_51 = ",";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\tjava.util.List<java.util.Map<String,String>> buckets_map_list_";
  protected final String TEXT_54 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\tjava.util.Map<String,String> bucket_prefix_map_";
  protected final String TEXT_55 = " = null;" + NL + "\tString object_prefix_";
  protected final String TEXT_56 = " = \"\";";
  protected final String TEXT_57 = NL + "\t\t\tobject_prefix_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ";";
  protected final String TEXT_60 = NL + "\t\tbucket_prefix_map_";
  protected final String TEXT_61 = " = new java.util.HashMap<String,String>();" + NL + "\t\tbucket_prefix_map_";
  protected final String TEXT_62 = ".put(";
  protected final String TEXT_63 = ",object_prefix_";
  protected final String TEXT_64 = ");" + NL + "\t\tbuckets_map_list_";
  protected final String TEXT_65 = ".add(bucket_prefix_map_";
  protected final String TEXT_66 = ");" + NL + "\t\tobject_prefix_";
  protected final String TEXT_67 = " = \"\";";
  protected final String TEXT_68 = NL + "\tfor (java.util.Map<String,String> bucketMap_";
  protected final String TEXT_69 = ": buckets_map_list_";
  protected final String TEXT_70 = ") {" + NL + "\t\tString currentBucketName_";
  protected final String TEXT_71 = " = \"\";" + NL + "\t\tString currentPrefix_";
  protected final String TEXT_72 = " = \"\";" + NL + "\t\tfor(java.util.Map.Entry<String,String> entry_";
  protected final String TEXT_73 = ":bucketMap_";
  protected final String TEXT_74 = ".entrySet()){" + NL + "\t\t\tcurrentBucketName_";
  protected final String TEXT_75 = " = entry_";
  protected final String TEXT_76 = ".getKey();" + NL + "\t\t\tcurrentPrefix_";
  protected final String TEXT_77 = " = entry_";
  protected final String TEXT_78 = ".getValue();" + NL + "\t\t}" + NL + "\t\ttry{" + NL + "\t\tcom.amazonaws.services.s3.model.ObjectListing objects_";
  protected final String TEXT_79 = " = conn_";
  protected final String TEXT_80 = ".listObjects(currentBucketName_";
  protected final String TEXT_81 = ",currentPrefix_";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "\tdo {" + NL + "\t\tjava.util.List<com.amazonaws.services.s3.model.S3ObjectSummary> list_objects_";
  protected final String TEXT_84 = " = objects_";
  protected final String TEXT_85 = ".getObjectSummaries();" + NL + "\t\tif(list_objects_";
  protected final String TEXT_86 = ".size()>0){" + NL + "\t\t\tnb_bucket_";
  protected final String TEXT_87 = "++;" + NL + "\t\t}" + NL + "\t\tfor (com.amazonaws.services.s3.model.S3ObjectSummary objectSummary_";
  protected final String TEXT_88 = " : list_objects_";
  protected final String TEXT_89 = ") {" + NL + "\t\t\tnb_bucket_object_";
  protected final String TEXT_90 = "++;" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_91 = "_CURRENT_BUCKET\", currentBucketName_";
  protected final String TEXT_92 = ");" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_93 = "_CURRENT_KEY\", objectSummary_";
  protected final String TEXT_94 = ".getKey());";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
boolean listAll = "true".equals(ElementParameterParser.getValue(node,"__LISTALL__"));
if(listAll){
	String objects_prefix=ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(objects_prefix!=null && objects_prefix.trim().length()>0 ?objects_prefix:null);
    stringBuffer.append(TEXT_52);
    
} else if(buckets.size()>0){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
	for(Map<String, String> map: buckets){
		String bucket_name =map.get("BUCKET_NAME");
		String object_prefix =map.get("OBJECT_PREFIX");
		if(object_prefix!=null && object_prefix.trim().length()>0){

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(object_prefix);
    stringBuffer.append(TEXT_59);
    
		}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
	}

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
}
if(listAll || buckets.size()>0){

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
}

    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TGSListBeginJava
{
  protected static String nl;
  public static synchronized TGSListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSListBeginJava result = new TGSListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_line_";
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
  protected final String TEXT_15 = ".getAccountOwner();";
  protected final String TEXT_16 = NL + "\t\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_17 = "=service_";
  protected final String TEXT_18 = ".listAllBuckets(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_21 = "=service_";
  protected final String TEXT_22 = ".listAllBuckets();";
  protected final String TEXT_23 = NL + "\t\tfor (org.jets3t.service.model.GSBucket bucket_";
  protected final String TEXT_24 = " : buckets_";
  protected final String TEXT_25 = ") {" + NL + "\t\t\tString currentBucketName_";
  protected final String TEXT_26 = " = bucket_";
  protected final String TEXT_27 = ".getName();" + NL + "\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_28 = " = service_";
  protected final String TEXT_29 = ".listObjects(currentBucketName_";
  protected final String TEXT_30 = "," + NL + "\t\t\t";
  protected final String TEXT_31 = " null ";
  protected final String TEXT_32 = "," + NL + "\t\t\t";
  protected final String TEXT_33 = " null ";
  protected final String TEXT_34 = NL + "\t\t\t);";
  protected final String TEXT_35 = NL + "\t\t\tjava.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_36 = " = new java.util.ArrayList<java.util.Map<String,String>>();";
  protected final String TEXT_37 = NL + "\t\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap_";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = ".put(\"BUCKET_NAME\",";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t\t\tmap_";
  protected final String TEXT_44 = "_";
  protected final String TEXT_45 = ".put(\"OBJECT_PREFIX\",";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\t\tmap_";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = ".put(\"OBJECT_DELIMITER\",";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\t\t\tlist_";
  protected final String TEXT_52 = ".add(map_";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\t\tfor (java.util.Map<String, String> map_";
  protected final String TEXT_56 = ": list_";
  protected final String TEXT_57 = ") {" + NL + "\t\t\t\tString currentBucketName_";
  protected final String TEXT_58 = "=map_";
  protected final String TEXT_59 = ".get(\"BUCKET_NAME\");" + NL + "\t\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_60 = " =new org.jets3t.service.model.GSObject[0];" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tobjects_";
  protected final String TEXT_61 = " = service_";
  protected final String TEXT_62 = ".listObjects(currentBucketName_";
  protected final String TEXT_63 = ",map_";
  protected final String TEXT_64 = ".get(\"OBJECT_PREFIX\"),map_";
  protected final String TEXT_65 = ".get(\"OBJECT_DELIMITER\"));" + NL + "\t\t\t\t}catch(java.lang.Exception e_";
  protected final String TEXT_66 = "){";
  protected final String TEXT_67 = NL + "\t\t\t\t\tthrow(e_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_70 = ".getMessage());";
  protected final String TEXT_71 = NL + "\t\t\t\t}";
  protected final String TEXT_72 = NL + "\t\t\t\tfor (org.jets3t.service.model.GSObject objectSummary_";
  protected final String TEXT_73 = " : objects_";
  protected final String TEXT_74 = ") {" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_75 = "++;" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_76 = "_CURRENT_BUCKET\", currentBucketName_";
  protected final String TEXT_77 = ");" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_78 = "_CURRENT_KEY\", objectSummary_";
  protected final String TEXT_79 = ".getKey());";

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
	boolean isSpecifyprojectID=("true").equals(ElementParameterParser.getValue(node,"__SPECIFY_PROJECT__"));
	String projectID=ElementParameterParser.getValue(node,"__PROJECT_ID__");
	String delimiter=ElementParameterParser.getValue(node,"__DELIMITER__");
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
    
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	boolean listInBucketList = "true".equals(ElementParameterParser.getValue(node,"__LIST_IN_BUCKET_LIST__"));
	if(!listInBucketList){
		String objects_prefix=ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");
		if(isSpecifyprojectID){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(projectID);
    stringBuffer.append(TEXT_19);
    
		}else{

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    if(objects_prefix!=null && objects_prefix.trim().length()>0){
    stringBuffer.append(objects_prefix);
     }else{
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    if(delimiter!=null && delimiter.trim().length()>0){
    stringBuffer.append(delimiter);
     }else{
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    
	} else if(buckets.size()>0){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
		for(int i=0;i<buckets.size();i++){
			Map<String, String> map=buckets.get(i);
			String bucket_name =map.get("BUCKET_NAME");
			String object_prefix =map.get("OBJECT_PREFIX");
			String object_delimiter =map.get("OBJECT_DELIMITER");

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_42);
    
			if(object_prefix!=null && object_prefix.trim().length()>0){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(object_prefix);
    stringBuffer.append(TEXT_46);
    
			}
			if(object_delimiter!=null && object_delimiter.trim().length()>0){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(object_delimiter);
    stringBuffer.append(TEXT_50);
    
			}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_54);
    
		}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
		} else {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
		}

    stringBuffer.append(TEXT_71);
    
	}
	if(!listInBucketList || buckets.size()>0){

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
    
	}

    return stringBuffer.toString();
  }
}

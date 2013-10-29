package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSCopyMainJava
{
  protected static String nl;
  public static synchronized TGSCopyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSCopyMainJava result = new TGSCopyMainJava();
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
  protected final String TEXT_10 = ");" + NL + "\t\tservice_";
  protected final String TEXT_11 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\tservice_";
  protected final String TEXT_14 = ".getAccountOwner();" + NL + "\t\tString targetFolder_";
  protected final String TEXT_15 = "=";
  protected final String TEXT_16 = ";" + NL + "\t\tif(targetFolder_";
  protected final String TEXT_17 = ".length()>0 && !targetFolder_";
  protected final String TEXT_18 = ".endsWith(\"/\")){" + NL + "\t\t\ttargetFolder_";
  protected final String TEXT_19 = "=targetFolder_";
  protected final String TEXT_20 = "+\"/\";" + NL + "\t\t}";
  protected final String TEXT_21 = NL + "\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_22 = " = service_";
  protected final String TEXT_23 = ".listObjects(";
  protected final String TEXT_24 = ",";
  protected final String TEXT_25 = ",null);" + NL + "\t\tfor (org.jets3t.service.model.GSObject objectSummary_";
  protected final String TEXT_26 = " : objects_";
  protected final String TEXT_27 = ") {" + NL + "\t\t\tString srcObjectKey_";
  protected final String TEXT_28 = "=objectSummary_";
  protected final String TEXT_29 = ".getKey();" + NL + "\t\t\torg.jets3t.service.model.GSObject tarObj_";
  protected final String TEXT_30 = "=service_";
  protected final String TEXT_31 = ".getObject(";
  protected final String TEXT_32 = ", objectSummary_";
  protected final String TEXT_33 = ".getKey());" + NL + "\t\t\ttarObj_";
  protected final String TEXT_34 = ".setKey(targetFolder_";
  protected final String TEXT_35 = "+objectSummary_";
  protected final String TEXT_36 = ".getKey());";
  protected final String TEXT_37 = NL + "\t\t\tservice_";
  protected final String TEXT_38 = ".copyObject(";
  protected final String TEXT_39 = ", srcObjectKey_";
  protected final String TEXT_40 = ", ";
  protected final String TEXT_41 = ",tarObj_";
  protected final String TEXT_42 = " , false);";
  protected final String TEXT_43 = "\t\t" + NL + "\t\t\tservice_";
  protected final String TEXT_44 = ".moveObject(";
  protected final String TEXT_45 = ", srcObjectKey_";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ", tarObj_";
  protected final String TEXT_48 = ", false);";
  protected final String TEXT_49 = NL + "\t\t\ttarObj_";
  protected final String TEXT_50 = ".closeDataInputStream();" + NL + "\t\t}";
  protected final String TEXT_51 = NL + "\t\torg.jets3t.service.model.GSObject tarObj_";
  protected final String TEXT_52 = " = service_";
  protected final String TEXT_53 = ".getObject(";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\t\ttarObj_";
  protected final String TEXT_57 = ".setKey(targetFolder_";
  protected final String TEXT_58 = "+";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t\ttarObj_";
  protected final String TEXT_61 = ".setKey(targetFolder_";
  protected final String TEXT_62 = "+tarObj_";
  protected final String TEXT_63 = ".getKey());";
  protected final String TEXT_64 = NL + "\t\tservice_";
  protected final String TEXT_65 = ".copyObject(";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ",tarObj_";
  protected final String TEXT_69 = " , false);";
  protected final String TEXT_70 = NL + "\t\tservice_";
  protected final String TEXT_71 = ".moveObject(";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ", tarObj_";
  protected final String TEXT_75 = ", false);";
  protected final String TEXT_76 = NL + "\t\ttarObj_";
  protected final String TEXT_77 = ".closeDataInputStream();";
  protected final String TEXT_78 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_79 = "_SOURCE_BUCKET\",";
  protected final String TEXT_80 = "); " + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_81 = "_SOURCE_OBJECTKEY\",";
  protected final String TEXT_82 = "); " + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_83 = "_DESTINATION_BUCKETNAME\", ";
  protected final String TEXT_84 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_85 = "_DESTINATION_FOLDER\", ";
  protected final String TEXT_86 = ");" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_87 = ") {";
  protected final String TEXT_88 = NL + "\t\tthrow(e_";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_91 = ".getMessage());";
  protected final String TEXT_92 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_93 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_94 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_95 = NL + "\t}" + NL + "\t";

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
	boolean isSourceFolder=("true").equals(ElementParameterParser.getValue(node,"__IS_SOUCE_FOLDER__"));
	String srcBucketName=ElementParameterParser.getValue(node,"__SOURCE_BUCKET__");
	String sourceObjectKey = ElementParameterParser.getValue(node,"__SOURCE_OBJECTKEY__");
	String targetBucket=ElementParameterParser.getValue(node,"__TARGET_BUCKET__");
	String targetFolder=ElementParameterParser.getValue(node,"__TARGET_FOLDER__");
	String newObjectKey = ElementParameterParser.getValue(node,"__NEW_OBJECTKEY__");
	String actionType = ElementParameterParser.getValue(node,"__ACTION_TYPE__");
	boolean isRename = ("true").equals(ElementParameterParser.getValue(node,"__RENAME__"));
	
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
    stringBuffer.append(targetFolder);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
	if(isSourceFolder){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(sourceObjectKey);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
		if("COPY".equals(actionType) ){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
		}else{

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
		}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
	}else{

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_55);
    
		if(isRename){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(newObjectKey);
    stringBuffer.append(TEXT_59);
    
		}else{

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
		}
		if("COPY".equals(actionType) ){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		}else{

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
		}

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
	}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(srcBucketName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sourceObjectKey);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(targetBucket);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(targetFolder);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		} else {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
		}

    stringBuffer.append(TEXT_95);
    return stringBuffer.toString();
  }
}

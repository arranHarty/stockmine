package org.talend.designer.codegen.translators.databases.couchdb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TCouchDBConnectionBeginJava
{
  protected static String nl;
  public static synchronized TCouchDBConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchDBConnectionBeginJava result = new TCouchDBConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\torg.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);" + NL + "\torg.jcouchdb.db.Server server_";
  protected final String TEXT_2 = "=new org.jcouchdb.db.ServerImpl(";
  protected final String TEXT_3 = ",";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "\t\tjava.util.Map<String, Object> createParams_";
  protected final String TEXT_6 = "=new java.util.HashMap<String,Object>();" + NL + "\t\tjava.util.List<java.util.Map<String, Object>> replicates_";
  protected final String TEXT_7 = " = new java.util.ArrayList<java.util.Map<String, Object>>();" + NL + "\t\tjava.util.HashMap<String,Object> cancelParams_";
  protected final String TEXT_8 = " = null;" + NL + "\t\tcreateParams_";
  protected final String TEXT_9 = ".put(\"source\",";
  protected final String TEXT_10 = ");" + NL + "\t\torg.jcouchdb.db.Response reponse_";
  protected final String TEXT_11 = " = null;";
  protected final String TEXT_12 = NL + NL + "\t\t\tcreateParams_";
  protected final String TEXT_13 = ".put(\"target\",";
  protected final String TEXT_14 = ");" + NL + "\t\t\tcreateParams_";
  protected final String TEXT_15 = ".put(\"create_target\",";
  protected final String TEXT_16 = ");" + NL + "\t\t\tcreateParams_";
  protected final String TEXT_17 = ".put(\"continuous\",";
  protected final String TEXT_18 = ");" + NL + "\t\t\treponse_";
  protected final String TEXT_19 = " = server_";
  protected final String TEXT_20 = ".post(\"/_replicate\",org.svenson.JSON.defaultJSON().forValue(createParams_";
  protected final String TEXT_21 = "));" + NL + "\t\t\tif(!reponse_";
  protected final String TEXT_22 = ".isOk()){" + NL + "\t\t\t\tSystem.err.println(reponse_";
  protected final String TEXT_23 = ".getContentAsString());" + NL + "\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\tif(reponse_";
  protected final String TEXT_25 = ".isOk()){" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_26 = " = new java.util.HashMap<String,Object>();" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_27 = ".put(\"source\",";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_29 = ".put(\"target\",";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_31 = ".put(\"continuous\",true);" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_32 = ".put(\"create_target\",true);" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_33 = ".put(\"cancel\",true);" + NL + "\t\t\t\treplicates_";
  protected final String TEXT_34 = ".add(cancelParams_";
  protected final String TEXT_35 = ");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_36 = NL + "\tglobalMap.put(\"replicates_";
  protected final String TEXT_37 = "\", replicates_";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\torg.jcouchdb.db.Database db_";
  protected final String TEXT_40 = " = new org.jcouchdb.db.Database(server_";
  protected final String TEXT_41 = ",";
  protected final String TEXT_42 = ");" + NL + "\tglobalMap.put(\"server_";
  protected final String TEXT_43 = "\", server_";
  protected final String TEXT_44 = ");" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_45 = "\", db_";
  protected final String TEXT_46 = ");" + NL + "\t";
  protected final String TEXT_47 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbname = ElementParameterParser.getValue(node, "__DATABASE__");
    boolean useTriggerReplicate="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_TRIGGER_REPLICATE__"));
    String dbport  	= ElementParameterParser.getValue(node, "__PORT__");
    List<Map<String,String>> replicaTargetDB= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICATE_TARGET_DB__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_4);
    
	if(useTriggerReplicate){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		for(Map<String,String> targetDB:replicaTargetDB){
			String targetDBName=targetDB.get("TARGET_DB_NAME");
			boolean isCreateTargetDB = "true".equalsIgnoreCase(targetDB.get("CREATE_TARGET"));
			boolean isContinuous = "true".equalsIgnoreCase(targetDB.get("CONTINUOUS"));
			boolean isCancel = "true".equalsIgnoreCase(targetDB.get("CANCEL_REPLICATE"));

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(targetDBName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(isCreateTargetDB);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(isContinuous);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
			if(isContinuous && isCancel){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(targetDBName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
			}
		}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}

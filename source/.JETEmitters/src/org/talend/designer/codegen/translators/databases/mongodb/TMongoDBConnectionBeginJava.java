package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TMongoDBConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBConnectionBeginJava result = new TMongoDBConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tList<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_2 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_3 = NL + "\taddrs_";
  protected final String TEXT_4 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = "));";
  protected final String TEXT_7 = NL + "\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_8 = " = new com.mongodb.Mongo(addrs_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_11 = " = new com.mongodb.Mongo(";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\tcom.mongodb.DB db_";
  protected final String TEXT_15 = " = mongo_";
  protected final String TEXT_16 = ".getDB(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "    db_";
  protected final String TEXT_19 = ".authenticate(";
  protected final String TEXT_20 = ", new String(";
  protected final String TEXT_21 = ").toCharArray());";
  protected final String TEXT_22 = NL + "\tglobalMap.put(\"mongo_";
  protected final String TEXT_23 = "\", mongo_";
  protected final String TEXT_24 = ");" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_25 = "\", db_";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbname = ElementParameterParser.getValue(node, "__DATABASE__");
    String dbuser = ElementParameterParser.getValue(node, "__USERNAME__");
    String dbpass = ElementParameterParser.getValue(node, "__PASSWORD__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
    String dbport  	= ElementParameterParser.getValue(node, "__PORT__");
    List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");
    if(useReplicaSet){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
		for(Map<String,String> replicaAddr:replicaAddrs){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_6);
    
		}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	}else{

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_13);
    
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_17);
    
	if (authentication){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbpass);
    stringBuffer.append(TEXT_21);
    
	}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}

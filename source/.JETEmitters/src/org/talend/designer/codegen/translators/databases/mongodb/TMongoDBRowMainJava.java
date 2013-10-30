package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMongoDBRowMainJava
{
  protected static String nl;
  public static synchronized TMongoDBRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBRowMainJava result = new TMongoDBRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_3 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_4 = "=null;" + NL + "\t\t\ttry{";
  protected final String TEXT_5 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_6 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_7 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_8 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_9 = "\");";
  protected final String TEXT_10 = NL + "\t\t\t\tList<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_11 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_12 = NL + "\t\t\t\taddrs_";
  protected final String TEXT_13 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_14 = ",";
  protected final String TEXT_15 = "));";
  protected final String TEXT_16 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_17 = " = new com.mongodb.Mongo(addrs_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_20 = " = new com.mongodb.Mongo(";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t\t\tdb_";
  protected final String TEXT_24 = " = mongo_";
  protected final String TEXT_25 = ".getDB(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "    \t\t\tdb_";
  protected final String TEXT_28 = ".authenticate(";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = ".toCharArray());";
  protected final String TEXT_31 = NL + NL + "\t\t\t\tcom.mongodb.CommandResult  result_";
  protected final String TEXT_32 = "=null;";
  protected final String TEXT_33 = NL + "\t\t\t\tresult_";
  protected final String TEXT_34 = "=db_";
  protected final String TEXT_35 = ".command(";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\t\t\t\tresult_";
  protected final String TEXT_38 = "=db_";
  protected final String TEXT_39 = ".doEval(";
  protected final String TEXT_40 = ",";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\t\t\t\t\tif(result_";
  protected final String TEXT_43 = ".ok()){" + NL + "\t\t\t\t\t\tSystem.out.println(result_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tSystem.err.println(result_";
  protected final String TEXT_45 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}catch(Exception e_";
  protected final String TEXT_46 = "){";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\te_";
  protected final String TEXT_48 = ".printStackTrace();";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_50 = ".getMessage());";
  protected final String TEXT_51 = NL + "\t\t\t\t}";
  protected final String TEXT_52 = NL + "\t\t\t\tfinally{" + NL + "\t\t\t\t\tif(mongo_";
  protected final String TEXT_53 = " != null )" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tmongo_";
  protected final String TEXT_54 = ".close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
  	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();

    String dbhost   = ElementParameterParser.getValue(node, "__HOST__");
    String dbname   = ElementParameterParser.getValue(node, "__DATABASE__");
    String dbuser   = ElementParameterParser.getValue(node, "__USERNAME__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String dbpass   = ElementParameterParser.getValue(node, "__PASSWORD__");
    String dbport  	= ElementParameterParser.getValue(node, "__PORT__");
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    boolean isExecuteCommand = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__EXECUTE_COMMAND__"));
    String function = ElementParameterParser.getValue(node,"__FUNCTION__");
    function = function.replaceAll("\n"," ");
    function = function.replaceAll("\r"," ");
  	String command = ElementParameterParser.getValue(node,"__COMMAND__");
  	List<Map<String, String>> parameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FUNCTION_PARAMETERS__");
  	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
  	boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
  	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
      		if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_9);
    
			}else{
 				List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");
   				if(useReplicaSet){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
					for(Map<String,String> replicaAddr:replicaAddrs){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_15);
    
					}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
				}else{

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_22);
    
				}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_26);
    
				if (authentication){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbpass);
    stringBuffer.append(TEXT_30);
    
				}

    
			}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
				if(isExecuteCommand){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(command);
    stringBuffer.append(TEXT_36);
    
				}else{

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(function);
    for(Map<String, String> parameter:parameters){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(parameter.get("PARAMETER"));
    }
    stringBuffer.append(TEXT_41);
    
			}

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
					if(dieOnError){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
					}else{

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
					}

    stringBuffer.append(TEXT_51);
    
			if(!useExistingConnection){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
			}

    return stringBuffer.toString();
  }
}

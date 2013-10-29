package org.talend.designer.codegen.translators.databases.sybase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSybaseSPBeginJava
{
  protected static String nl;
  public static synchronized TSybaseSPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSybaseSPBeginJava result = new TSybaseSPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    java.sql.Connection connection_";
  protected final String TEXT_3 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "    String dbschema_";
  protected final String TEXT_5 = "= (String)globalMap.get(\"";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + "    java.lang.Class.forName(\"com.sybase.jdbc3.jdbc.SybDriver\");";
  protected final String TEXT_8 = NL + "\t\t String connectionString_";
  protected final String TEXT_9 = " = \"jdbc:sybase:Tds:\" + ";
  protected final String TEXT_10 = " + \":\" + ";
  protected final String TEXT_11 = " + \"/\" + ";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + "\t\t String connectionString_";
  protected final String TEXT_14 = " = \"jdbc:sybase:Tds:\" + ";
  protected final String TEXT_15 = " + \":\" + ";
  protected final String TEXT_16 = " + \"/\" + ";
  protected final String TEXT_17 = " + \"?\" + ";
  protected final String TEXT_18 = ";";
  protected final String TEXT_19 = NL + "    java.sql.Connection connection_";
  protected final String TEXT_20 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ");" + NL + "\tString dbschema_";
  protected final String TEXT_24 = "= ";
  protected final String TEXT_25 = "; ";
  protected final String TEXT_26 = NL + "String spName_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "if(dbschema_";
  protected final String TEXT_29 = " != null && dbschema_";
  protected final String TEXT_30 = ".trim().length() != 0) {" + NL + "\tspName_";
  protected final String TEXT_31 = " = dbschema_";
  protected final String TEXT_32 = " + \".\" + spName_";
  protected final String TEXT_33 = ";" + NL + "} ";
  protected final String TEXT_34 = NL + "java.sql.PreparedStatement statement_";
  protected final String TEXT_35 = " = connection_";
  protected final String TEXT_36 = ".prepareStatement(\"select \" + spName_";
  protected final String TEXT_37 = " + \"(";
  protected final String TEXT_38 = NL + "java.sql.CallableStatement statement_";
  protected final String TEXT_39 = " = connection_";
  protected final String TEXT_40 = ".prepareCall(\"{call \" + ";
  protected final String TEXT_41 = " + \"(";
  protected final String TEXT_42 = "?";
  protected final String TEXT_43 = ",?";
  protected final String TEXT_44 = ")";
  protected final String TEXT_45 = "}";
  protected final String TEXT_46 = "\");" + NL;
  protected final String TEXT_47 = NL + "    statement_";
  protected final String TEXT_48 = ".setQueryTimeout(";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + NL + "java.sql.Date tmpDate_";
  protected final String TEXT_51 = ";" + NL + "String tmpString_";
  protected final String TEXT_52 = ";";
  protected final String TEXT_53 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dbhost = ElementParameterParser.getValue(node, "__HOST__");
String dbport = ElementParameterParser.getValue(node, "__PORT__");
String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser = ElementParameterParser.getValue(node, "__USER__");
String dbpwd  = ElementParameterParser.getValue(node, "__PASS__");
String spName = ElementParameterParser.getValue(node, "__SP_NAME__");
String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
boolean isFunction = ("true").equals(ElementParameterParser.getValue(node, "__IS_FUNCTION__"));
List<Map<String, String>> spArgs = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SP_ARGS__");
boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
if(useExistingConn){
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;
	String schema = "dbschema_" + connection;
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(schema);
    stringBuffer.append(TEXT_6);
    
} else {       
    
    stringBuffer.append(TEXT_7);
    
	if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_12);
    
	} else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_18);
    
	}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_25);
    
}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(spName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
if(isFunction){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
}else{

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(spName);
    stringBuffer.append(TEXT_41);
    
}
boolean isFirstArg = true;
for (int i = 0; i < spArgs.size(); i++) {
	if(!("RECORDSET").equals(spArgs.get(i).get("TYPE"))){
		if(isFirstArg){
			
    stringBuffer.append(TEXT_42);
    
			isFirstArg=false;
		}else{
			
    stringBuffer.append(TEXT_43);
    
		}
	}
}

    stringBuffer.append(TEXT_44);
    if(!isFunction){
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
String timeoutInterval = ElementParameterParser.getValue(node, "__TIMEOUT_INTERVAL__");
if(timeoutInterval != null && !("0").equals(timeoutInterval) && !("").equals(timeoutInterval)) {
    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(timeoutInterval);
    stringBuffer.append(TEXT_49);
    
}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    return stringBuffer.toString();
  }
}

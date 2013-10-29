package org.talend.designer.codegen.translators.databases.db2;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TDB2SPBeginJava
{
  protected static String nl;
  public static synchronized TDB2SPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDB2SPBeginJava result = new TDB2SPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.sql.Connection connection_";
  protected final String TEXT_3 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = NL + "\t    String url_";
  protected final String TEXT_6 = " = \"jdbc:db2://\" + ";
  protected final String TEXT_7 = " + \":\" + ";
  protected final String TEXT_8 = " + \"/\" + ";
  protected final String TEXT_9 = ";    ";
  protected final String TEXT_10 = NL + "\t\tString url_";
  protected final String TEXT_11 = " = \"jdbc:db2://\" + ";
  protected final String TEXT_12 = " + \":\" + ";
  protected final String TEXT_13 = " + \"/\" + ";
  protected final String TEXT_14 = " + \":\" + ";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "java.lang.Class.forName(\"com.ibm.db2.jcc.DB2Driver\");" + NL + "java.sql.Connection connection_";
  protected final String TEXT_17 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ");" + NL + "        \t    ";
  protected final String TEXT_21 = NL + NL + "java.sql.CallableStatement statement_";
  protected final String TEXT_22 = " = connection_";
  protected final String TEXT_23 = ".prepareCall(\"{";
  protected final String TEXT_24 = "call \" + ";
  protected final String TEXT_25 = " + \"(";
  protected final String TEXT_26 = "?";
  protected final String TEXT_27 = ",?";
  protected final String TEXT_28 = ")}\");" + NL + "" + NL + "java.sql.Date tmpDate_";
  protected final String TEXT_29 = ";" + NL + "String tmpString_";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL;

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
boolean isFunction = ("true").equals(ElementParameterParser.getValue(node, "__IS_FUNCTION__"));
List<Map<String, String>> spArgs = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SP_ARGS__");


    
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(("true").equals(useExistingConn)) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_4);
    
} else {       
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_9);
    
	} else {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_15);
    
	}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_20);
    
			}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(isFunction ? "? = " : "");
    stringBuffer.append(TEXT_24);
    stringBuffer.append(spName);
    stringBuffer.append(TEXT_25);
    
boolean isFirstArg = true;
for (int i = 0; i < spArgs.size(); i++) {
	if(!("RECORDSET").equals(spArgs.get(i).get("TYPE"))){
		if(isFirstArg){
			
    stringBuffer.append(TEXT_26);
    
			isFirstArg=false;
		}else{
			
    stringBuffer.append(TEXT_27);
    
		}
	}
}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}

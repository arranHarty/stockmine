package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TJDBCRowBeginJava
{
  protected static String nl;
  public static synchronized TJDBCRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCRowBeginJava result = new TJDBCRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_3 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "\tif (null == connection_";
  protected final String TEXT_5 = ") {";
  protected final String TEXT_6 = " " + NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_7 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES); " + NL + "\t\tconnection_";
  protected final String TEXT_8 = " = dataSources_";
  protected final String TEXT_9 = ".get(";
  protected final String TEXT_10 = ").getConnection();" + NL + "\t}" + NL + "\t";
  protected final String TEXT_11 = NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_12 = " = null;" + NL + "\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_13 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\tif (null != dataSources_";
  protected final String TEXT_14 = ") {";
  protected final String TEXT_15 = NL + "\t\tconnection_";
  protected final String TEXT_16 = " = dataSources_";
  protected final String TEXT_17 = ".get(";
  protected final String TEXT_18 = ").getConnection();" + NL + "\t} else {" + NL + "\t\tjava.lang.Class.forName(";
  protected final String TEXT_19 = ");" + NL + "\t\tString connectionString_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "\t\tconnection_";
  protected final String TEXT_22 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ");" + NL + "\t}";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "        connection_";
  protected final String TEXT_28 = ".setAutoCommit(false);    \t" + NL + "    \tint commitEvery_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";" + NL + "    \tint commitCounter_";
  protected final String TEXT_31 = " = 0;" + NL + "    \t";
  protected final String TEXT_32 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_33 = " = connection_";
  protected final String TEXT_34 = ".prepareStatement(";
  protected final String TEXT_35 = ");\t";
  protected final String TEXT_36 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_37 = " = connection_";
  protected final String TEXT_38 = ".createStatement();";
  protected final String TEXT_39 = NL + "String query_";
  protected final String TEXT_40 = " = \"\";" + NL + "boolean whetherReject_";
  protected final String TEXT_41 = " = false;";
  protected final String TEXT_42 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String driverJar = ElementParameterParser.getValue(node, "__DRIVER_JAR__");
String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
String jdbcUrl = ElementParameterParser.getValue(node, "__URL__");
String dbuser = ElementParameterParser.getValue(node, "__USER__");
String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       dbquery = dbquery.replaceAll("\n"," ");
    	   dbquery = dbquery.replaceAll("\r"," ");
    
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));

    
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(("true").equals(useExistingConn)){
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    	
		INode connectionNode = null; 
		for (INode processNode : node.getProcess().getGeneratingNodes()) { 
			if(connection.equals(processNode.getUniqueName())) { 
				connectionNode = processNode; 
				break; 
			} 
		} 
		String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__"); 

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_10);
    
} else {       

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
		String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_18);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(jdbcUrl );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbuser );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbpwd );
    stringBuffer.append(TEXT_25);
    
}

    stringBuffer.append(TEXT_26);
    
if(!("true").equals(useExistingConn)) {
    if (!("").equals(commitEvery) && !("0").equals(commitEvery)) {
    	
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
    }
}

    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_35);
    
	} else {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}

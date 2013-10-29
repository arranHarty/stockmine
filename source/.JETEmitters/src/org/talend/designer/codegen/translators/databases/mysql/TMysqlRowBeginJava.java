package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMysqlRowBeginJava
{
  protected static String nl;
  public static synchronized TMysqlRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlRowBeginJava result = new TMysqlRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "\tconn_";
  protected final String TEXT_5 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_6 = "\");" + NL + "\tif (null == conn_";
  protected final String TEXT_7 = ") {";
  protected final String TEXT_8 = " " + NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_9 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES); " + NL + "\t\tconn_";
  protected final String TEXT_10 = " = dataSources_";
  protected final String TEXT_11 = ".get(";
  protected final String TEXT_12 = ").getConnection();" + NL + "\t}";
  protected final String TEXT_13 = NL + "\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_14 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\tif (null != dataSources_";
  protected final String TEXT_15 = ") {";
  protected final String TEXT_16 = NL + "\t\tconn_";
  protected final String TEXT_17 = " = dataSources_";
  protected final String TEXT_18 = ".get(";
  protected final String TEXT_19 = ").getConnection();" + NL + "\t} else {";
  protected final String TEXT_20 = NL + "\t\tString dbProperties_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";" + NL + "\t\tString url_";
  protected final String TEXT_23 = " = null;" + NL + "\t\tif(dbProperties_";
  protected final String TEXT_24 = " == null || dbProperties_";
  protected final String TEXT_25 = ".trim().length() == 0) {" + NL + "\t\t\turl_";
  protected final String TEXT_26 = " = \"jdbc:mysql://\" + ";
  protected final String TEXT_27 = " + \":\" + ";
  protected final String TEXT_28 = " + \"/\" + ";
  protected final String TEXT_29 = ";" + NL + "\t\t} else {" + NL + "\t\t\turl_";
  protected final String TEXT_30 = " = \"jdbc:mysql://\" + ";
  protected final String TEXT_31 = " + \":\" + ";
  protected final String TEXT_32 = " + \"/\" + ";
  protected final String TEXT_33 = " + \"?\" + ";
  protected final String TEXT_34 = ";" + NL + "\t\t}" + NL + "\t\tString dbUser_";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = ";" + NL + "\t\tString dbPwd_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ";    " + NL + "\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_39 = "\");" + NL + "\t\tconn_";
  protected final String TEXT_40 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_41 = ", dbUser_";
  protected final String TEXT_42 = ", dbPwd_";
  protected final String TEXT_43 = ");" + NL + "\t}";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL + "        if(conn_";
  protected final String TEXT_46 = ".getAutoCommit()) {" + NL + "            conn_";
  protected final String TEXT_47 = ".setAutoCommit(false);" + NL + "        }        " + NL + "        int commitEvery_";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = ";" + NL + "        int commitCounter_";
  protected final String TEXT_50 = " = 0;";
  protected final String TEXT_51 = NL;
  protected final String TEXT_52 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_53 = " = conn_";
  protected final String TEXT_54 = ".prepareStatement(";
  protected final String TEXT_55 = ");\t";
  protected final String TEXT_56 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_57 = " = conn_";
  protected final String TEXT_58 = ".createStatement();";
  protected final String TEXT_59 = NL + "String query_";
  protected final String TEXT_60 = " = \"\";" + NL + "boolean whetherReject_";
  protected final String TEXT_61 = " = false;";
  protected final String TEXT_62 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       dbquery = dbquery.replaceAll("\n"," ");
    	   dbquery = dbquery.replaceAll("\r"," ");
    
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(("true").equals(useExistingConn)) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;;
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    	
		INode connectionNode = null; 
		for (INode processNode : node.getProcess().getGeneratingNodes()) { 
			if(connection.equals(processNode.getUniqueName())) { 
				connectionNode = processNode; 
				break; 
			} 
		} 
		String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__"); 

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_12);
    
} else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
		String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_19);
    
		String javaDbDriver   = "org.gjt.mm.mysql.Driver";

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
}	

    stringBuffer.append(TEXT_44);
    
if(!("true").equals(useExistingConn)) {
    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
        
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
    }
}

    stringBuffer.append(TEXT_51);
    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_55);
    
	} else {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
	}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(TEXT_62);
    return stringBuffer.toString();
  }
}

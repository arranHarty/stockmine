package org.talend.designer.codegen.translators.databases.db_generic;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TDBSQLRowBeginJava
{
  protected static String nl;
  public static synchronized TDBSQLRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDBSQLRowBeginJava result = new TDBSQLRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.lang.Class.forName(\"sun.jdbc.odbc.JdbcOdbcDriver\");" + NL + "" + NL + "String url_";
  protected final String TEXT_3 = " = \"jdbc:odbc:\"+";
  protected final String TEXT_4 = ";" + NL + "" + NL + "String dbUser_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "String dbPwd_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "String dbProperties_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "java.sql.Connection conn_";
  protected final String TEXT_11 = " = null;" + NL + "if(dbProperties_";
  protected final String TEXT_12 = " == null || dbProperties_";
  protected final String TEXT_13 = ".trim().length() == 0) {" + NL + "\tconn_";
  protected final String TEXT_14 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_15 = ",dbUser_";
  protected final String TEXT_16 = ",dbPwd_";
  protected final String TEXT_17 = ");" + NL + "}else{" + NL + "\tdbProperties_";
  protected final String TEXT_18 = " = dbProperties_";
  protected final String TEXT_19 = ".replaceAll(\"&\", \"\\n\");" + NL + "\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_20 = " = new java.util.Properties();" + NL + "\tatnParamsPrope_";
  protected final String TEXT_21 = ".put(\"user\",dbUser_";
  protected final String TEXT_22 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_23 = ".put(\"password\",dbPwd_";
  protected final String TEXT_24 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_25 = ".load(new java.io.ByteArrayInputStream(dbProperties_";
  protected final String TEXT_26 = ".getBytes()));" + NL + "\tconn_";
  protected final String TEXT_27 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_28 = ", atnParamsPrope_";
  protected final String TEXT_29 = ");" + NL + "}" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_30 = " = false;" + NL;
  protected final String TEXT_31 = NL + NL + "int commitEvery_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_34 = " = 0;" + NL + "" + NL + "conn_";
  protected final String TEXT_35 = ".setAutoCommit(false);";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = NL + "\t\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_38 = " = conn_";
  protected final String TEXT_39 = ".prepareStatement(";
  protected final String TEXT_40 = ");\t";
  protected final String TEXT_41 = NL + "\t\tjava.sql.Statement stmt_";
  protected final String TEXT_42 = " = conn_";
  protected final String TEXT_43 = ".createStatement();";
  protected final String TEXT_44 = NL + "String query_";
  protected final String TEXT_45 = " = \"\";";
  protected final String TEXT_46 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       dbquery = dbquery.replaceAll("\n"," ");
    	   dbquery = dbquery.replaceAll("\r"," ");
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
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
    
if(!("").equals(commitEvery)&&!("0").equals(commitEvery)){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
}

    stringBuffer.append(TEXT_36);
    
	if(usePrepareStatement){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_40);
    
	}else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
	}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}

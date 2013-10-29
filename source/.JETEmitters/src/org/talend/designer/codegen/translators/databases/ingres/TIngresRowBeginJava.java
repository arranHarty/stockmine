package org.talend.designer.codegen.translators.databases.ingres;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TIngresRowBeginJava
{
  protected static String nl;
  public static synchronized TIngresRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TIngresRowBeginJava result = new TIngresRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "boolean whetherReject_";
  protected final String TEXT_3 = " = false;";
  protected final String TEXT_4 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_5 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_6 = "\");" + NL + "\t";
  protected final String TEXT_7 = NL + "   \tjava.lang.Class.forName(\"com.ingres.jdbc.IngresDriver\");" + NL + "" + NL + "\tString url_";
  protected final String TEXT_8 = " = \"jdbc:ingres://\"+";
  protected final String TEXT_9 = "+\":\"+";
  protected final String TEXT_10 = "+\"/\"+";
  protected final String TEXT_11 = ";" + NL + "" + NL + "\tString dbUser_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL + "\tString dbPwd_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "" + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_16 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_17 = ",dbUser_";
  protected final String TEXT_18 = ",dbPwd_";
  protected final String TEXT_19 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL + "\t" + NL + "\tint commitEvery_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";" + NL + "\t" + NL + "\tint commitCounter_";
  protected final String TEXT_24 = " = 0;" + NL + "\t" + NL + "\tconn_";
  protected final String TEXT_25 = ".setAutoCommit(false);";
  protected final String TEXT_26 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_27 = " = conn_";
  protected final String TEXT_28 = ".prepareStatement(";
  protected final String TEXT_29 = ");\t";
  protected final String TEXT_30 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_31 = " = conn_";
  protected final String TEXT_32 = ".createStatement();";
  protected final String TEXT_33 = NL + "String query_";
  protected final String TEXT_34 = " = \"\";";
  protected final String TEXT_35 = NL;

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
    
} else {
	
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
}	

    stringBuffer.append(TEXT_20);
    
if(!("true").equals(useExistingConn)) {
	if(!("").equals(commitEvery)&&!("0").equals(commitEvery)){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	}
}

    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_29);
    
	} else {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}

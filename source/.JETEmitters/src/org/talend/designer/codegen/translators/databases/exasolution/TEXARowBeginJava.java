package org.talend.designer.codegen.translators.databases.exasolution;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TEXARowBeginJava
{
  protected static String nl;
  public static synchronized TEXARowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TEXARowBeginJava result = new TEXARowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        String dbProperties_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "        String url_";
  protected final String TEXT_5 = " = null;" + NL + "        if(dbProperties_";
  protected final String TEXT_6 = " == null || dbProperties_";
  protected final String TEXT_7 = ".trim().length() == 0) {" + NL + "            url_";
  protected final String TEXT_8 = " = \"jdbc:exa:\" + ";
  protected final String TEXT_9 = " + \":\" + ";
  protected final String TEXT_10 = "+ \";schema=\" + ";
  protected final String TEXT_11 = "; " + NL + "        } else {" + NL + "            url_";
  protected final String TEXT_12 = " = \"jdbc:exa:\" + ";
  protected final String TEXT_13 = " + \":\" + ";
  protected final String TEXT_14 = " + \";schema=\" + ";
  protected final String TEXT_15 = " + \";\" + ";
  protected final String TEXT_16 = ";" + NL + "        }" + NL + "        String dbUser_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "        String dbPwd_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ";" + NL + "        java.lang.Class.forName(\"com.exasol.jdbc.EXADriver\");" + NL + "        java.sql.Connection conn_";
  protected final String TEXT_21 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_22 = ",dbUser_";
  protected final String TEXT_23 = ",dbPwd_";
  protected final String TEXT_24 = ");" + NL;
  protected final String TEXT_25 = NL + "            conn_";
  protected final String TEXT_26 = ".setAutoCommit(false);            " + NL + "            int commitEvery_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "            int commitCounter_";
  protected final String TEXT_29 = " = 0;";
  protected final String TEXT_30 = NL + "    java.sql.Statement stmt_";
  protected final String TEXT_31 = " = conn_";
  protected final String TEXT_32 = ".createStatement();    " + NL + "    String query_";
  protected final String TEXT_33 = " = \"\";" + NL + "    boolean whetherReject_";
  protected final String TEXT_34 = " = false;    ";
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
	String dbschema= ElementParameterParser.getValue(node, "__DB_SCHEMA__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
        if(!commitEvery.equals("") && !commitEvery.equals("0")) {
            
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
        }
    
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}

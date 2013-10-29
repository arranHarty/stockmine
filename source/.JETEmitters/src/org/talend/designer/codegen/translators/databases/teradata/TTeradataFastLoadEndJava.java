package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TTeradataFastLoadEndJava
{
  protected static String nl;
  public static synchronized TTeradataFastLoadEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastLoadEndJava result = new TTeradataFastLoadEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "if(pstmtUpdate_";
  protected final String TEXT_3 = " != null){" + NL + "" + NL + "        pstmtUpdate_";
  protected final String TEXT_4 = ".executeBatch();" + NL + "\t\tpstmtUpdate_";
  protected final String TEXT_5 = ".clearBatch();" + NL + "\t\tpstmtUpdate_";
  protected final String TEXT_6 = ".close();" + NL + "\t" + NL + "} " + NL + "if(pstmtInsert_";
  protected final String TEXT_7 = " != null){" + NL + "" + NL + "        pstmtInsert_";
  protected final String TEXT_8 = ".executeBatch();" + NL + "\t\tpstmtInsert_";
  protected final String TEXT_9 = ".clearBatch();" + NL + "\t\tpstmtInsert_";
  protected final String TEXT_10 = ".close();" + NL + "\t" + NL + "}" + NL + "if(pstmt_";
  protected final String TEXT_11 = " != null) {" + NL + "" + NL + "        pstmt_";
  protected final String TEXT_12 = ".executeBatch();" + NL + "\t\tpstmt_";
  protected final String TEXT_13 = ".clearBatch();" + NL + "\t\tpstmt_";
  protected final String TEXT_14 = ".close();" + NL + "\t" + NL + "}";
  protected final String TEXT_15 = NL + "\tlog.info(\"";
  protected final String TEXT_16 = " - Starting to commit.\");";
  protected final String TEXT_17 = NL + "conn_";
  protected final String TEXT_18 = ".commit();";
  protected final String TEXT_19 = NL + "\tlog.info(\"";
  protected final String TEXT_20 = " - Commit has succeeded.\");" + NL + "\tlog.info(\"";
  protected final String TEXT_21 = " - Closing the connection to the database.\");";
  protected final String TEXT_22 = NL + "conn_";
  protected final String TEXT_23 = " .close();";
  protected final String TEXT_24 = NL + "\tlog.info(\"";
  protected final String TEXT_25 = " - Connection to the database closed.\");";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "if (commitCounter_";
  protected final String TEXT_28 = " > 0) {" + NL + "\tpstmt_";
  protected final String TEXT_29 = ".executeBatch();" + NL + "\tpstmt_";
  protected final String TEXT_30 = ".clearBatch();" + NL + "\tcommitCounter_";
  protected final String TEXT_31 = "=0;" + NL + "}" + NL + "pstmt_";
  protected final String TEXT_32 = ".close();";
  protected final String TEXT_33 = NL + "\tlog.info(\"";
  protected final String TEXT_34 = " - Starting to commit.\");";
  protected final String TEXT_35 = NL + "conn_";
  protected final String TEXT_36 = ".commit();";
  protected final String TEXT_37 = NL + "\tlog.info(\"";
  protected final String TEXT_38 = " - Commit has succeeded.\");" + NL + "\tlog.info(\"";
  protected final String TEXT_39 = " - Closing the connection to the database.\");";
  protected final String TEXT_40 = NL + "conn_";
  protected final String TEXT_41 = " .close();";
  protected final String TEXT_42 = NL + "\tlog.info(\"";
  protected final String TEXT_43 = " - Connection to the database closed.\");";
  protected final String TEXT_44 = NL + "\tnb_line_inserted_";
  protected final String TEXT_45 = "=nb_line_inserted_";
  protected final String TEXT_46 = " + insertedCount_";
  protected final String TEXT_47 = ";" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_48 = "_NB_LINE\",nb_line_";
  protected final String TEXT_49 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_50 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_51 = ");" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\tlog.info(\"";
  protected final String TEXT_53 = " - Loaded records count:\" + nb_line_inserted_";
  protected final String TEXT_54 = " + \".\" );" + NL + "\tlog.info(\"";
  protected final String TEXT_55 = " - Has finished\");";
  protected final String TEXT_56 = NL;
  protected final String TEXT_57 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = "INSERT";
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	if(("INSERT_OR_UPDATE").equals(dataAction)||("UPDATE_OR_INSERT").equals(dataAction)){


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    	
	}else{

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    }
    
	}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    return stringBuffer.toString();
  }
}

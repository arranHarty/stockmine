package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TTeradataInputEndJava
{
  protected static String nl;
  public static synchronized TTeradataInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataInputEndJava result = new TTeradataInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "}" + NL + "stmt_";
  protected final String TEXT_3 = ".close();" + NL;
  protected final String TEXT_4 = NL + "\tlog.info(\"";
  protected final String TEXT_5 = " - Closing the connection to the database.\");";
  protected final String TEXT_6 = NL + "conn_";
  protected final String TEXT_7 = " .close();";
  protected final String TEXT_8 = NL + "\tlog.info(\"";
  protected final String TEXT_9 = " - Connection to the database closed.\");";
  protected final String TEXT_10 = NL + "globalMap.put(\"";
  protected final String TEXT_11 = "_NB_LINE\",nb_line_";
  protected final String TEXT_12 = ");" + NL;
  protected final String TEXT_13 = NL + "\tlog.info(\"";
  protected final String TEXT_14 = " - Retrieved records count: \"+nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\tlog.info(\"";
  protected final String TEXT_16 = " - Done.\");";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    	
	if(!useExistingConn){

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    
	}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}

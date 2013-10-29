package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IProcess;

public class TOracleInputEndJava
{
  protected static String nl;
  public static synchronized TOracleInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleInputEndJava result = new TOracleInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "}" + NL + "}finally{" + NL + "stmt_";
  protected final String TEXT_3 = ".close();" + NL;
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = NL + "\t\tlog.info(\"";
  protected final String TEXT_6 = " - Closing the connection to the database.\");" + NL + "\t";
  protected final String TEXT_7 = NL + "\tconn_";
  protected final String TEXT_8 = " .close();" + NL + "\t";
  protected final String TEXT_9 = NL + "\t\tlog.info(\"";
  protected final String TEXT_10 = " - Connection to the database closed.\");" + NL + "\t";
  protected final String TEXT_11 = NL + "\t";
  protected final String TEXT_12 = NL + "}" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_13 = "_NB_LINE\",nb_line_";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\tlog.info(\"";
  protected final String TEXT_16 = " - Retrieved records count: \"+nb_line_";
  protected final String TEXT_17 = " + \" .\");" + NL + "\tlog.info(\"";
  protected final String TEXT_18 = " - Done.\");";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	IProcess process = node.getProcess();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
if(!("true").equals(useExistingConn))
{
	
    stringBuffer.append(TEXT_4);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}

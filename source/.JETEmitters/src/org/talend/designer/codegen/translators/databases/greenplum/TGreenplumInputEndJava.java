package org.talend.designer.codegen.translators.databases.greenplum;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TGreenplumInputEndJava
{
  protected static String nl;
  public static synchronized TGreenplumInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGreenplumInputEndJava result = new TGreenplumInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_5 = " + \" \" + log4jSb_";
  protected final String TEXT_6 = ");" + NL + "\t\tlog4jSb_";
  protected final String TEXT_7 = ".delete(0,log4jSb_";
  protected final String TEXT_8 = ".length());" + NL + "\t";
  protected final String TEXT_9 = NL + "}" + NL + "stmt_";
  protected final String TEXT_10 = ".close();" + NL;
  protected final String TEXT_11 = NL + "\t";
  protected final String TEXT_12 = NL + "\t\tlog.info(\"";
  protected final String TEXT_13 = " - Starting to commit.\");" + NL + "\t";
  protected final String TEXT_14 = NL + "\tconn_";
  protected final String TEXT_15 = ".commit();" + NL + "\t";
  protected final String TEXT_16 = NL + "\t\tlog.info(\"";
  protected final String TEXT_17 = " - Commit has succeeded.\");";
  protected final String TEXT_18 = NL + "\t";
  protected final String TEXT_19 = NL + "\t";
  protected final String TEXT_20 = NL + "\t\tlog.info(\"";
  protected final String TEXT_21 = " - Closing the connection to the database.\");" + NL + "\t";
  protected final String TEXT_22 = NL + "\tconn_";
  protected final String TEXT_23 = " .close();" + NL + "\t";
  protected final String TEXT_24 = NL + "\t\tlog.info(\"";
  protected final String TEXT_25 = " - Connection to the database closed.\");" + NL + "\t";
  protected final String TEXT_26 = NL + "\t";
  protected final String TEXT_27 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_28 = "_NB_LINE\",nb_line_";
  protected final String TEXT_29 = ");" + NL;
  protected final String TEXT_30 = NL + "\tlog.info(\"";
  protected final String TEXT_31 = " - Retrieved records count: \"+nb_line_";
  protected final String TEXT_32 = " + \" .\");" + NL + "\tlog.info(\"";
  protected final String TEXT_33 = " - Has finished.\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
if(!("true").equals(useExistingConn))
{
	String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
	if(("true").equals(useCursor)) {
	
    stringBuffer.append(TEXT_11);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    
}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    }
    return stringBuffer.toString();
  }
}

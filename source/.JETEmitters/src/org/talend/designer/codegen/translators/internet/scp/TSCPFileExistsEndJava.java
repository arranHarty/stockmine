package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TSCPFileExistsEndJava
{
  protected static String nl;
  public static synchronized TSCPFileExistsEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPFileExistsEndJava result = new TSCPFileExistsEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "  \t" + NL + "            /* Close the connection */" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "            conn_";
  protected final String TEXT_6 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_9 = "            " + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Done.\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
            CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
            INode node = (INode)codeGenArgument.getArgument();
            boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
            String cid = node.getUniqueName();
            String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			
			if(!("true").equals(useExistingConn)){

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
              }
    stringBuffer.append(TEXT_9);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}

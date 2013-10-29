package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMRollbackMainJava
{
  protected static String nl;
  public static synchronized TMDMRollbackMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMRollbackMainJava result = new TMDMRollbackMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "org.talend.mdm.webservice.XtentisPort conn_";
  protected final String TEXT_3 = " = (org.talend.mdm.webservice.XtentisPort)globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "if(conn_";
  protected final String TEXT_5 = " != null)" + NL + "{" + NL + "\tcom.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_6 = " = (com.talend.mdm.transaction.client.MDMTransaction)globalMap.get(\"";
  protected final String TEXT_7 = "\");" + NL + "\tif(mdmTransaction_";
  protected final String TEXT_8 = "!=null) {" + NL + "\t\tmdmTransaction_";
  protected final String TEXT_9 = ".rollback();" + NL + "\t}";
  protected final String TEXT_10 = NL + "    conn_";
  protected final String TEXT_11 = ".logout(new org.talend.mdm.webservice.WSLogout());";
  protected final String TEXT_12 = NL + "}" + NL;
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    boolean close = ("true").equals(ElementParameterParser.getValue(node,"__CLOSE__"));

    String conn = "xtentisWS_" + connection;
	String mdmTransaction = "mdmTransaction_" + connection;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(mdmTransaction);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
      if(close){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
     }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMBulkLoadEndJava
{
  protected static String nl;
  public static synchronized TMDMBulkLoadEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMBulkLoadEndJava result = new TMDMBulkLoadEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "if (inputStreamMerger_";
  protected final String TEXT_2 = "!=null) {" + NL + "inputStreamMerger_";
  protected final String TEXT_3 = ".close();" + NL + "} " + NL + "bulkloadClient_";
  protected final String TEXT_4 = ".waitForEndOfQueue();" + NL + "bulkloadClient_";
  protected final String TEXT_5 = " = null;";
  protected final String TEXT_6 = NL + "if(inputStreamMerger_";
  protected final String TEXT_7 = "!=null && inputStreamMerger_";
  protected final String TEXT_8 = ".getLastReportedFailure()!=null){" + NL + "\t\tthrow new Exception(inputStreamMerger_";
  protected final String TEXT_9 = ".getLastReportedFailure());" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
//for bug TDI-22445

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    //TDI-26145
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}

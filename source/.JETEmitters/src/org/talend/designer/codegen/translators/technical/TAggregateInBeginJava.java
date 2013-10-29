package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TAggregateInBeginJava
{
  protected static String nl;
  public static synchronized TAggregateInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateInBeginJava result = new TAggregateInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + NL + "java.util.Collection<AggOperationStruct_";
  protected final String TEXT_3 = "> values_";
  protected final String TEXT_4 = " = hash_";
  protected final String TEXT_5 = ".values();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_6 = "_NB_LINE\", values_";
  protected final String TEXT_7 = ".size());" + NL;
  protected final String TEXT_8 = NL + "\tStringBuffer log4jSb_";
  protected final String TEXT_9 = " = new StringBuffer();" + NL + "\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieving records from the datasource.\");";
  protected final String TEXT_11 = NL + "for(AggOperationStruct_";
  protected final String TEXT_12 = " aggregated_row_";
  protected final String TEXT_13 = " : values_";
  protected final String TEXT_14 = ") { // G_AggR_600" + NL + NL;
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String origin = ElementParameterParser.getValue(node, "__ORIGIN__");
String cid = origin;
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}

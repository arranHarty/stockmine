package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TContextLoadBeginJava
{
  protected static String nl;
  public static synchronized TContextLoadBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TContextLoadBeginJava result = new TContextLoadBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tjava.util.List<String> assignList_";
  protected final String TEXT_2 = " = new java.util.ArrayList<String>();" + NL + "\tjava.util.List<String> newPropertyList_";
  protected final String TEXT_3 = " = new java.util.ArrayList<String>();" + NL + "\tjava.util.List<String> noAssignList_";
  protected final String TEXT_4 = " = new java.util.ArrayList<String>();" + NL + "\tint nb_line_";
  protected final String TEXT_5 = " = 0;" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tlog.info(\"";
  protected final String TEXT_7 = " - Start to work.\");" + NL + "\t\tStringBuffer log4jSb_";
  protected final String TEXT_8 = " = new StringBuffer();" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TLoopEndJava
{
  protected static String nl;
  public static synchronized TLoopEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLoopEndJava result = new TLoopEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL + "\t}";
  protected final String TEXT_3 = NL + NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = ";" + NL + "" + NL + "" + NL + "}";
  protected final String TEXT_6 = NL + NL + "\t";
  protected final String TEXT_7 = NL + "\t\tlog.info(\"";
  protected final String TEXT_8 = " - Has finished.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean forLoop = ("true").equals(ElementParameterParser.getValue(node,"__FORLOOP__"));

boolean whileLoop = ("true").equals(ElementParameterParser.getValue(node,"__WHILELOOP__"));

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

if (forLoop) {

    stringBuffer.append(TEXT_2);
    
}else{// While type

String iteration   = ElementParameterParser.getValue(node, "__ITERATION__");
//iteration = iteration.substring(1,iteration.length()-1);
if (iteration.startsWith("\"") && iteration.endsWith("\"")) {
    iteration = iteration.substring(1, iteration.length()-1);
}


    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(iteration);
    stringBuffer.append(TEXT_5);
    
}

    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    return stringBuffer.toString();
  }
}

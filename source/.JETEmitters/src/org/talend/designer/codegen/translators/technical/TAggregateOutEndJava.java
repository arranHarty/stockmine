package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TAggregateOutEndJava
{
  protected static String nl;
  public static synchronized TAggregateOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateOutEndJava result = new TAggregateOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t\t\t\t";
  protected final String TEXT_3 = NL + "        ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String origin = ElementParameterParser.getValue(node, "__DESTINATION__");
String cid = origin;

IConnection inputConn = null;
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");


    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TMicrosoftMQInputEndJava
{
  protected static String nl;
  public static synchronized TMicrosoftMQInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftMQInputEndJava result = new TMicrosoftMQInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    if (msgu_";
  protected final String TEXT_2 = ".isOpen()){" + NL + "      msgu_";
  protected final String TEXT_3 = ".close();" + NL + "    }" + NL + "  }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();  
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
    
if (outConns != null && outConns.size() > 0){
  
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
}

    return stringBuffer.toString();
  }
}

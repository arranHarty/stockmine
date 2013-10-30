package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TAdvancedHashPigMainJava
{
  protected static String nl;
  public static synchronized TAdvancedHashPigMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedHashPigMainJava result = new TAdvancedHashPigMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_3 = "\",pigScript_";
  protected final String TEXT_4 = ");" + NL + NL + NL;
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();

	String start_node="";
	String inputConnectionName = "";
	
    List<IConnection> inputConnections = (List<IConnection>) node.getIncomingConnections();
	if(inputConnections!=null && inputConnections.size()>0) {
		IConnection connection = inputConnections.get(0);
		inputConnectionName = connection.getName();
		start_node = node.getDesignSubjobStartNode().getUniqueName();
	}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(inputConnectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}

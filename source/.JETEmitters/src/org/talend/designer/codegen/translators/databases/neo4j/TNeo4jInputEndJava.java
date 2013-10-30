package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TNeo4jInputEndJava
{
  protected static String nl;
  public static synchronized TNeo4jInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jInputEndJava result = new TNeo4jInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "}" + NL;
  protected final String TEXT_2 = NL + "\t\tdatabaseService_";
  protected final String TEXT_3 = ".shutdown();" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\t\tdatabaseService_";
  protected final String TEXT_5 = ".shutdown();" + NL + "\t\t";
  protected final String TEXT_6 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_7 = "_NB_LINE\", nb_line_";
  protected final String TEXT_8 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_1);
    
	if (!useExistingConnection) {
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	} else {
		boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
		if (shutdownDb) {
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
		}
	}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}

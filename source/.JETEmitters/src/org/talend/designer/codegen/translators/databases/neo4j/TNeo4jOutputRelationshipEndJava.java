package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TNeo4jOutputRelationshipEndJava
{
  protected static String nl;
  public static synchronized TNeo4jOutputRelationshipEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jOutputRelationshipEndJava result = new TNeo4jOutputRelationshipEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\ttx_";
  protected final String TEXT_2 = ".success();" + NL + "\ttx_";
  protected final String TEXT_3 = ".finish();" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tdatabaseService_";
  protected final String TEXT_5 = ".shutdown();" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\t\tdatabaseService_";
  protected final String TEXT_7 = ".shutdown();" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tindexProvider_";
  protected final String TEXT_9 = ".shutdown();" + NL + "\t\tinserter_";
  protected final String TEXT_10 = ".shutdown();" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t\tdatabaseService_";
  protected final String TEXT_12 = " = new org.neo4j.kernel.EmbeddedGraphDatabase(storeDir_";
  protected final String TEXT_13 = ");" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_14 = "\", databaseService_";
  protected final String TEXT_15 = ");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "globalMap.put(\"";
  protected final String TEXT_17 = "_NB_LINE\", nb_line_";
  protected final String TEXT_18 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
    
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    boolean batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));		
	boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    String dbconn = "dbService_" + connection;

	if (!useExistingConnection) {
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	} else {
		if (shutdownDb) {
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
		}
	}
	if (batchImport) {
		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
		if (useExistingConnection && !shutdownDb) {
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbconn);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
		}
	}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}

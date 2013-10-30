package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TNeo4jRowBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jRowBeginJava result = new TNeo4jRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_2 = " = (org.neo4j.graphdb.GraphDatabaseService) globalMap.get(\"";
  protected final String TEXT_3 = "\");" + NL + "\t";
  protected final String TEXT_4 = NL + "    \t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_5 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_6 = ");" + NL + "    \t\t";
  protected final String TEXT_7 = NL + "\t\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_8 = " = new org.neo4j.kernel.EmbeddedGraphDatabase(";
  protected final String TEXT_9 = ");" + NL + "\t\t\t";
  protected final String TEXT_10 = "   " + NL + "org.neo4j.cypher.ExecutionEngine engine_";
  protected final String TEXT_11 = " = new org.neo4j.cypher.ExecutionEngine(databaseService_";
  protected final String TEXT_12 = ");" + NL + "org.neo4j.graphdb.Transaction tx_";
  protected final String TEXT_13 = " = databaseService_";
  protected final String TEXT_14 = ".beginTx();" + NL + "" + NL + "long counter_";
  protected final String TEXT_15 = " = 0;" + NL + "long nbNodeInserted_";
  protected final String TEXT_16 = " = 0;" + NL + "long nbRelationshipInserted_";
  protected final String TEXT_17 = " = 0;" + NL + "long nbPropertiesUpdated_";
  protected final String TEXT_18 = " = 0;" + NL + "long nbNodeDeleted_";
  protected final String TEXT_19 = " = 0;" + NL + "long nbRelationshipDeleted_";
  protected final String TEXT_20 = " = 0;";
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    if (useExistingConnection) {
    	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    	String dbconn = "dbService_" + connection;
		
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dbconn);
    stringBuffer.append(TEXT_3);
    
    } else {
    	boolean remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOTE_SERVER__"));
    	if (remoteServer) {
    		String serverUrl = ElementParameterParser.getValue(node, "__SERVER_URL__");
    		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_6);
    
    	} else {
	    	String databasePath = ElementParameterParser.getValue(node, "__DATABASE_PATH__");
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(databasePath);
    stringBuffer.append(TEXT_9);
    
		}
    }
    
    String userNbLine = ElementParameterParser.getValue(node, "__USE_NB_LINE__");

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}

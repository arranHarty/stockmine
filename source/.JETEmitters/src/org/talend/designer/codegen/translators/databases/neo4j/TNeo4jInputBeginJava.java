package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TNeo4jInputBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jInputBeginJava result = new TNeo4jInputBeginJava();
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
  protected final String TEXT_8 = " = new org.neo4j.kernel.EmbeddedReadOnlyGraphDatabase(";
  protected final String TEXT_9 = ");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + NL + "org.neo4j.cypher.ExecutionEngine engine = new org.neo4j.cypher.ExecutionEngine(databaseService_";
  protected final String TEXT_11 = ");" + NL + "org.neo4j.cypher.ExecutionResult result = engine.execute(";
  protected final String TEXT_12 = ");" + NL + "" + NL + "java.util.Iterator<java.util.Map<String, Object>> resultIterator_";
  protected final String TEXT_13 = " = result.javaIterator();" + NL + "" + NL + "int nb_line_";
  protected final String TEXT_14 = " = 0;" + NL + "String expression_";
  protected final String TEXT_15 = " = \"\";" + NL + "while (resultIterator_";
  protected final String TEXT_16 = ".hasNext()) {";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));        
    String query = ElementParameterParser.getValue(node, "__QUERY__");
    query = query.replaceAll("\n"," ");
    query = query.replaceAll("\r"," ");
    
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

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}

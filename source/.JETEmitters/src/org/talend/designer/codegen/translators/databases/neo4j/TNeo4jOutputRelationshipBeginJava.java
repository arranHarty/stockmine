package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TNeo4jOutputRelationshipBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jOutputRelationshipBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jOutputRelationshipBeginJava result = new TNeo4jOutputRelationshipBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    \torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_2 = " = (org.neo4j.graphdb.GraphDatabaseService) globalMap.get(\"";
  protected final String TEXT_3 = "\");" + NL + "    \t";
  protected final String TEXT_4 = NL + "    \t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_5 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_6 = ");" + NL + "    \t\t";
  protected final String TEXT_7 = NL + "\t    \torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_8 = " = new org.neo4j.kernel.EmbeddedGraphDatabase(";
  protected final String TEXT_9 = ");" + NL + "\t    \t";
  protected final String TEXT_10 = NL + "    \tjava.util.Map<String, String> importProperties_";
  protected final String TEXT_11 = " = new java.util.HashMap<String, String>();" + NL + "\t\timportProperties_";
  protected final String TEXT_12 = ".put(\"neostore.nodestore.db.mapped_memory\", \"0M\");" + NL + "\t\timportProperties_";
  protected final String TEXT_13 = ".put(\"neostore.relationshipstore.db.mapped_memory\", ";
  protected final String TEXT_14 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_15 = ".put(\"neostore.propertystore.db.mapped_memory\", ";
  protected final String TEXT_16 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_17 = ".put(\"neostore.propertystore.db.strings.mapped_memory\", ";
  protected final String TEXT_18 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_19 = ".put(\"neostore.propertystore.db.arrays.mapped_memory\", ";
  protected final String TEXT_20 = ");" + NL + "\t\tString storeDir_";
  protected final String TEXT_21 = " = \"\";" + NL + "\t\torg.neo4j.unsafe.batchinsert.BatchInserter inserter_";
  protected final String TEXT_22 = " = null;" + NL + "\t\tif (databaseService_";
  protected final String TEXT_23 = " instanceof org.neo4j.kernel.EmbeddedGraphDatabase) {" + NL + "\t\t\torg.neo4j.kernel.EmbeddedGraphDatabase db_";
  protected final String TEXT_24 = " = (org.neo4j.kernel.EmbeddedGraphDatabase) databaseService_";
  protected final String TEXT_25 = ";" + NL + "\t\t\tstoreDir_";
  protected final String TEXT_26 = " = db_";
  protected final String TEXT_27 = ".getStoreDir();" + NL + "\t\t\tdb_";
  protected final String TEXT_28 = ".shutdown();" + NL + "\t\t\tinserter_";
  protected final String TEXT_29 = " = org.neo4j.unsafe.batchinsert.BatchInserters.inserter(db_";
  protected final String TEXT_30 = ".getStoreDir(), importProperties_";
  protected final String TEXT_31 = ");" + NL + "\t\t} else {" + NL + "\t\t\tthrow new UnsupportedOperationException(\"Not supported yet\");" + NL + "\t\t}" + NL + "    \torg.neo4j.unsafe.batchinsert.BatchInserterIndexProvider indexProvider_";
  protected final String TEXT_32 = " = new org.neo4j.index.lucene.unsafe.batchinsert.LuceneBatchInserterIndexProvider(inserter_";
  protected final String TEXT_33 = ");" + NL + "    \torg.neo4j.unsafe.batchinsert.BatchInserterIndex startIndexInserter_";
  protected final String TEXT_34 = " = indexProvider_";
  protected final String TEXT_35 = ".nodeIndex(";
  protected final String TEXT_36 = ", org.neo4j.helpers.collection.MapUtil.stringMap(\"type\", \"exact\"));" + NL + "    \torg.neo4j.unsafe.batchinsert.BatchInserterIndex endIndexInserter_";
  protected final String TEXT_37 = " = indexProvider_";
  protected final String TEXT_38 = ".nodeIndex(";
  protected final String TEXT_39 = ", org.neo4j.helpers.collection.MapUtil.stringMap(\"type\", \"exact\"));" + NL + "    \t";
  protected final String TEXT_40 = NL + "    \torg.neo4j.graphdb.index.Index<org.neo4j.graphdb.Node> startIndexNode_";
  protected final String TEXT_41 = " = databaseService_";
  protected final String TEXT_42 = ".index().forNodes(";
  protected final String TEXT_43 = ");" + NL + "    \torg.neo4j.graphdb.index.Index<org.neo4j.graphdb.Node> endIndexNode_";
  protected final String TEXT_44 = " = databaseService_";
  protected final String TEXT_45 = ".index().forNodes(";
  protected final String TEXT_46 = ");" + NL + "    \t";
  protected final String TEXT_47 = NL + "    " + NL + "\torg.neo4j.graphdb.RelationshipType relationshipType_";
  protected final String TEXT_48 = " = org.neo4j.graphdb.DynamicRelationshipType.withName(";
  protected final String TEXT_49 = ");" + NL + "" + NL + "\torg.neo4j.graphdb.Transaction tx_";
  protected final String TEXT_50 = " = databaseService_";
  protected final String TEXT_51 = ".beginTx();" + NL + "\tint nb_line_";
  protected final String TEXT_52 = " = 0;" + NL + "\tlong counter_";
  protected final String TEXT_53 = " = 0;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    boolean batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
        
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
    String startIndexName = ElementParameterParser.getValue(node, "__START_INDEX_NAME__");
    String endIndexName = ElementParameterParser.getValue(node, "__END_INDEX_NAME__");
    
    String relationshipType = ElementParameterParser.getValue(node, "__RELATIONSHIP_TYPE__");
    if (batchImport) {
    	String relationshipMappedMemory = ElementParameterParser.getValue(node, "__RELATIONSHIP_MAPPED_MEMORY__");
		String propertyMappedMemory = ElementParameterParser.getValue(node, "__PROPERTY_MAPPED_MEMORY__");
		String stringsMappedMemory = ElementParameterParser.getValue(node, "__STRINGS_MAPPED_MEMORY__");
		String arraysMappedMemory = ElementParameterParser.getValue(node, "__ARRAYS_MAPPED_MEMORY__");
    	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(relationshipMappedMemory);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(propertyMappedMemory);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(stringsMappedMemory);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(arraysMappedMemory);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(startIndexName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(endIndexName);
    stringBuffer.append(TEXT_39);
    
    } else {
    	
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(startIndexName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(endIndexName);
    stringBuffer.append(TEXT_46);
    
    }
    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(relationshipType);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    return stringBuffer.toString();
  }
}

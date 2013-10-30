package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

public class TNeo4jOutputBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jOutputBeginJava result = new TNeo4jOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_2 = " = (org.neo4j.graphdb.GraphDatabaseService) globalMap.get(\"";
  protected final String TEXT_3 = "\");" + NL + "\t\t";
  protected final String TEXT_4 = NL + "    \t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_5 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_6 = ");" + NL + "    \t\t";
  protected final String TEXT_7 = NL + "\t\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_8 = " = new org.neo4j.kernel.EmbeddedGraphDatabase(";
  protected final String TEXT_9 = ");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "    \tjava.util.Map<String, String> importProperties_";
  protected final String TEXT_11 = " = new java.util.HashMap<String, String>();" + NL + "\t\timportProperties_";
  protected final String TEXT_12 = ".put(\"neostore.nodestore.db.mapped_memory\", ";
  protected final String TEXT_13 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_14 = ".put(\"neostore.relationshipstore.db.mapped_memory\", ";
  protected final String TEXT_15 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_16 = ".put(\"neostore.propertystore.db.mapped_memory\", ";
  protected final String TEXT_17 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_18 = ".put(\"neostore.propertystore.db.strings.mapped_memory\", ";
  protected final String TEXT_19 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_20 = ".put(\"neostore.propertystore.db.arrays.mapped_memory\", ";
  protected final String TEXT_21 = ");" + NL + "\t\tString storeDir_";
  protected final String TEXT_22 = " = \"\";" + NL + "\t\torg.neo4j.unsafe.batchinsert.BatchInserter inserter_";
  protected final String TEXT_23 = " = null;" + NL + "\t\tif (databaseService_";
  protected final String TEXT_24 = " instanceof org.neo4j.kernel.EmbeddedGraphDatabase) {" + NL + "\t\t\torg.neo4j.kernel.EmbeddedGraphDatabase db_";
  protected final String TEXT_25 = " = (org.neo4j.kernel.EmbeddedGraphDatabase) databaseService_";
  protected final String TEXT_26 = ";" + NL + "\t\t\tstoreDir_";
  protected final String TEXT_27 = " = db_";
  protected final String TEXT_28 = ".getStoreDir();" + NL + "\t\t\tdb_";
  protected final String TEXT_29 = ".shutdown();" + NL + "\t\t\tinserter_";
  protected final String TEXT_30 = " = org.neo4j.unsafe.batchinsert.BatchInserters.inserter(db_";
  protected final String TEXT_31 = ".getStoreDir(), importProperties_";
  protected final String TEXT_32 = ");" + NL + "\t\t} else {" + NL + "\t\t\tthrow new UnsupportedOperationException(\"Batch import is not supported with database server edition\");" + NL + "\t\t}" + NL + "    \torg.neo4j.unsafe.batchinsert.BatchInserterIndexProvider indexProvider_";
  protected final String TEXT_33 = " = new org.neo4j.index.lucene.unsafe.batchinsert.LuceneBatchInserterIndexProvider(inserter_";
  protected final String TEXT_34 = ");" + NL + "\t\tjava.util.Map<String, org.neo4j.unsafe.batchinsert.BatchInserterIndex> indexInserterMap_";
  protected final String TEXT_35 = " = new java.util.HashMap<String, org.neo4j.unsafe.batchinsert.BatchInserterIndex>();" + NL + "    \t";
  protected final String TEXT_36 = NL + "\t\t\tindexInserterMap_";
  protected final String TEXT_37 = ".put(";
  protected final String TEXT_38 = ", indexProvider_";
  protected final String TEXT_39 = ".nodeIndex(";
  protected final String TEXT_40 = ", org.neo4j.helpers.collection.MapUtil.stringMap(\"type\", \"exact\")));" + NL + "    \t\t";
  protected final String TEXT_41 = NL + "\t\tjava.util.Map<String, org.neo4j.graphdb.index.Index<org.neo4j.graphdb.Node>> indexNodeMap_";
  protected final String TEXT_42 = " = new java.util.HashMap<String,org.neo4j.graphdb.index.Index<org.neo4j.graphdb.Node>>();" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t    \tindexNodeMap_";
  protected final String TEXT_44 = ".put(";
  protected final String TEXT_45 = ", databaseService_";
  protected final String TEXT_46 = ".index().forNodes(";
  protected final String TEXT_47 = "));" + NL + "\t    \t";
  protected final String TEXT_48 = NL + "    \torg.neo4j.graphdb.index.AutoIndexer<org.neo4j.graphdb.Node> autoIndexer_";
  protected final String TEXT_49 = " = databaseService_";
  protected final String TEXT_50 = ".index().getNodeAutoIndexer();" + NL + "    \tautoIndexer_";
  protected final String TEXT_51 = ".setEnabled(true);" + NL + "    \t";
  protected final String TEXT_52 = NL + "\t\tautoIndexer_";
  protected final String TEXT_53 = ".startAutoIndexingProperty(\"";
  protected final String TEXT_54 = "\");" + NL + "\t\t";
  protected final String TEXT_55 = "\t" + NL + "org.neo4j.graphdb.Transaction tx_";
  protected final String TEXT_56 = " = databaseService_";
  protected final String TEXT_57 = ".beginTx();" + NL + "int nb_line_";
  protected final String TEXT_58 = " = 0;" + NL + "long counter_";
  protected final String TEXT_59 = " = 0;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    boolean batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
    List<Map<String, String>> values = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__VALUES__");
    
    List<String> autoIndexedColumns = new ArrayList<String>();
    Set<String> indexNames = new HashSet();
    for (Map<String, String> value : values) {
    	boolean autoIndexed = Boolean.valueOf(value.get("AUTO_INDEXED"));
   		if (autoIndexed) {
   			autoIndexedColumns.add(value.get("SCHEMA_COLUMN"));
   		}
   		
   		String strIndexNames = value.get("INDEX_NAMES");
   		if (strIndexNames != null && !strIndexNames.isEmpty()) {
   			indexNames.addAll(Arrays.asList(strIndexNames.split(",")));
   		}
    }
    
    // Add update/delete index
    String action = (String) ElementParameterParser.getObjectValue(node, "__DATA_ACTION__");
    if (!action.equals("INSERT")) {
    	indexNames.add((String) ElementParameterParser.getObjectValue(node, "__INDEX_NAME__"));
    }
    
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
    // Index configuration
    if (batchImport) {
		String nodeMappedMemory = ElementParameterParser.getValue(node, "__NODE_MAPPED_MEMORY__");
		String relationshipMappedMemory = ElementParameterParser.getValue(node, "__RELATIONSHIP_MAPPED_MEMORY__");
		String propertyMappedMemory = ElementParameterParser.getValue(node, "__PROPERTY_MAPPED_MEMORY__");
		String stringsMappedMemory = ElementParameterParser.getValue(node, "__STRINGS_MAPPED_MEMORY__");
		String arraysMappedMemory = ElementParameterParser.getValue(node, "__ARRAYS_MAPPED_MEMORY__");
    	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(nodeMappedMemory);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(relationshipMappedMemory);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(propertyMappedMemory);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(stringsMappedMemory);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(arraysMappedMemory);
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
    
    	for (String indexName : indexNames) {
    		
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_40);
    
    	}
    } else {
		
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	    for (String indexName : indexNames) {	    	
	    	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_47);
    
	    }
	}
    // Auto index configuration
    if (autoIndexedColumns.size() > 0) {
    	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
    }
    for (String autoIndexedColumn : autoIndexedColumns) {
		
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(autoIndexedColumn);
    stringBuffer.append(TEXT_54);
    
	}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    return stringBuffer.toString();
  }
}

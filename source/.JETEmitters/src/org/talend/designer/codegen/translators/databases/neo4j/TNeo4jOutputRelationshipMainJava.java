package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TNeo4jOutputRelationshipMainJava
{
  protected static String nl;
  public static synchronized TNeo4jOutputRelationshipMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jOutputRelationshipMainJava result = new TNeo4jOutputRelationshipMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\torg.neo4j.graphdb.Node startNode_";
  protected final String TEXT_2 = " = startIndexNode_";
  protected final String TEXT_3 = ".get(";
  protected final String TEXT_4 = ", ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ").getSingle();" + NL + "\t\t\torg.neo4j.graphdb.Node endNode_";
  protected final String TEXT_7 = " = endIndexNode_";
  protected final String TEXT_8 = ".get(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ").getSingle();" + NL + "\t\t\tif (startNode_";
  protected final String TEXT_12 = " == null) {" + NL + "\t\t\t\tthrow new RuntimeException(\"Start node looked up by index with \" + ";
  protected final String TEXT_13 = " + \" as key and \" + ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " + \" as value doesn't exist\");" + NL + "\t\t\t}" + NL + "\t\t\tif (endNode_";
  protected final String TEXT_16 = " == null) {" + NL + "\t\t\t\tthrow new RuntimeException(\"End node looked up by index with \" + ";
  protected final String TEXT_17 = " + \" as key and \" + ";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = " + \" as value doesn't exist\");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\torg.neo4j.graphdb.Relationship relationship_";
  protected final String TEXT_21 = " = startNode_";
  protected final String TEXT_22 = ".createRelationshipTo(endNode_";
  protected final String TEXT_23 = ", relationshipType_";
  protected final String TEXT_24 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\torg.neo4j.graphdb.Relationship relationship_";
  protected final String TEXT_26 = " = endNode_";
  protected final String TEXT_27 = ".createRelationshipTo(startNode_";
  protected final String TEXT_28 = ", relationshipType_";
  protected final String TEXT_29 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_31 = " != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t\trelationship_";
  protected final String TEXT_33 = ".setProperty(";
  protected final String TEXT_34 = ", value_";
  protected final String TEXT_35 = "); " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\trelationship_";
  protected final String TEXT_37 = ".setProperty(\"";
  protected final String TEXT_38 = "\", value_";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\tObject value_";
  protected final String TEXT_42 = " = null;" + NL + "\t\t\t\tif (";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " != null) {" + NL + "\t\t\t\t\tjava.util.Date date_";
  protected final String TEXT_45 = " = (java.util.Date) ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ";" + NL + "\t\t\t\t\tvalue_";
  protected final String TEXT_48 = " = date_";
  protected final String TEXT_49 = ".getTime();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tObject value_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_54 = NL + "    \t\tlong startNode_";
  protected final String TEXT_55 = " = startIndexInserter_";
  protected final String TEXT_56 = ".get(";
  protected final String TEXT_57 = ", ";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = ").getSingle();" + NL + "    \t\tlong endNode_";
  protected final String TEXT_60 = " = endIndexInserter_";
  protected final String TEXT_61 = ".get(";
  protected final String TEXT_62 = ", ";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = ").getSingle();" + NL + "    \t\tjava.util.Map<String, Object> properties_";
  protected final String TEXT_65 = " = new java.util.HashMap<String, Object>();" + NL + "    \t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_67 = " != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\tproperties_";
  protected final String TEXT_69 = ".put(";
  protected final String TEXT_70 = ", value_";
  protected final String TEXT_71 = "); " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t\tproperties_";
  protected final String TEXT_73 = ".put(\"";
  protected final String TEXT_74 = "\", value_";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\tinserter_";
  protected final String TEXT_78 = ".createRelationship(startNode_";
  protected final String TEXT_79 = ", endNode_";
  protected final String TEXT_80 = ", relationshipType_";
  protected final String TEXT_81 = ", properties_";
  protected final String TEXT_82 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\tinserter_";
  protected final String TEXT_84 = ".createRelationship(endNode_";
  protected final String TEXT_85 = ", startNode_";
  protected final String TEXT_86 = ", relationshipType_";
  protected final String TEXT_87 = ", properties_";
  protected final String TEXT_88 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_89 = NL + "    \t\tif (";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " != null) {" + NL + "    \t\t";
  protected final String TEXT_92 = NL + "    \t\tif (";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = " != null) {" + NL + "    \t\t";
  protected final String TEXT_95 = NL + "    \t\tif (";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = " != null && ";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " != null) {" + NL + "    \t\t";
  protected final String TEXT_100 = NL + "    \t\t{" + NL + "    \t\t";
  protected final String TEXT_101 = NL + "\t    \t}" + NL + "\t    \t";
  protected final String TEXT_102 = NL + "\t" + NL + "\tcounter_";
  protected final String TEXT_103 = "++;" + NL + "\t" + NL + "\tif (counter_";
  protected final String TEXT_104 = " % Long.parseLong(";
  protected final String TEXT_105 = ") == 0) {" + NL + "\t\ttx_";
  protected final String TEXT_106 = ".success();" + NL + "\t\ttx_";
  protected final String TEXT_107 = ".finish();" + NL + "\t\ttx_";
  protected final String TEXT_108 = " = databaseService_";
  protected final String TEXT_109 = ".beginTx();" + NL + "\t}" + NL + "" + NL + "\tnb_line_";
  protected final String TEXT_110 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();	
    
    List<IMetadataColumn> columnList = null;
    List<IMetadataTable> metadatas = node.getMetadataList();
    IMetadataTable metadata = null;
    
    if (metadatas != null && metadatas.size() > 0) {
    	metadata = metadatas.get(0);
    }	
    
    List<? extends IConnection> inputs = node.getIncomingConnections();
    List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
    String incomingConnName = null;
    String outgoingConnName = null;
    
    if (inputs.size() > 0) {
    	IConnection in = inputs.get(0);
    	incomingConnName = in.getName();
    }
    
    if (outputs.size() > 0) {
    	IConnection out = outputs.get(0);
    	outgoingConnName = out.getName();
    }
    
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    boolean batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
    
    final String startIndexKey = ElementParameterParser.getValue(node, "__START_INDEX_KEY__");
    final String startIndexValueColumn = ElementParameterParser.getValue(node, "__START_INDEX_VALUE__");
    
    final String endIndexKey = ElementParameterParser.getValue(node, "__END_INDEX_KEY__");
    final String endIndexValueColumn = ElementParameterParser.getValue(node, "__END_INDEX_VALUE__");
    
    final String relationshipDirection = ElementParameterParser.getValue(node, "__RELATIONSHIP_DIRECTION__");
    
    final List<Map<String, String>> mappingTable = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__MAPPING__");
    
    final IMetadataColumn startColumn = metadata.getColumn(startIndexValueColumn);
    final IMetadataColumn endColumn = metadata.getColumn(endIndexValueColumn);
    
    class Neo4jRelationshipInserter {
    
    	private String incomingConnName;
    	private IMetadataTable metadata;
    	
    	public Neo4jRelationshipInserter(String incomingConnName, IMetadataTable metadata) {
    		this.incomingConnName = incomingConnName;
			this.metadata = metadata;
    	} 
    
    	public void insert() {
    		
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(startIndexKey);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(startColumn);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(endIndexKey);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(endColumn);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(startIndexKey);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(startColumn);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(startIndexKey);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(startColumn);
    stringBuffer.append(TEXT_19);
    
			if (relationshipDirection.equals("OUTGOING")) {
				
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
			} else {
				
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
			}
			for (Map<String, String> row : mappingTable) {
				String columnName = row.get("INPUT_COLUMN");
				String propertyName = row.get("PROPERTY_NAME");
				if (columnName != null && !columnName.isEmpty()) {
					IMetadataColumn column = metadata.getColumn(columnName);
					computeValue(column);
					
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_31);
    
						if (propertyName != null && !propertyName.isEmpty()) {
							
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_35);
    
						} else {
							
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_39);
    
						}
						
    stringBuffer.append(TEXT_40);
    
				}
			}
    	}
    
    	public void computeValue(IMetadataColumn column) {
    		if (column.getTalendType().equals("id_Date")) {
				
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			} else {
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_53);
    
			}
    	}
    
    	public void batchInsert() {
    		
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(startIndexKey);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(startColumn);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(endIndexKey);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(endColumn);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
    		for (Map<String, String> row : mappingTable) {
				String columnName = row.get("INPUT_COLUMN");
				String propertyName = row.get("PROPERTY_NAME");
				if (columnName != null && !columnName.isEmpty()) {
					IMetadataColumn column = metadata.getColumn(columnName);
					computeValue(column);
					
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_67);
    
						if (propertyName != null && !propertyName.isEmpty()) {
							
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_71);
    
						} else {
							
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_75);
    
						}
						
    stringBuffer.append(TEXT_76);
    
				}
			}
			if (relationshipDirection.equals("OUTGOING")) {
				
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
			} else {
				
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
			}
    	}
    }
    
    Neo4jRelationshipInserter relationshipInserter = new Neo4jRelationshipInserter(incomingConnName, metadata);
    
    if (startColumn != null && endColumn != null) {
    	// Create dynamique condition according to start and end columns state
    	if (startColumn.isNullable() && !endColumn.isNullable()) {
    		
    stringBuffer.append(TEXT_89);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(startColumn);
    stringBuffer.append(TEXT_91);
    
    	} else if (!startColumn.isNullable() && endColumn.isNullable()) {
    		
    stringBuffer.append(TEXT_92);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(endColumn);
    stringBuffer.append(TEXT_94);
    
    	} else if (startColumn.isNullable() && endColumn.isNullable()) {
    		
    stringBuffer.append(TEXT_95);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(startColumn);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(endColumn);
    stringBuffer.append(TEXT_99);
    
    	} else {
    		
    stringBuffer.append(TEXT_100);
    
    	}
    			if (batchImport) {
	    			relationshipInserter.batchInsert();
	    		} else {
	    			relationshipInserter.insert();
	    		} 
    stringBuffer.append(TEXT_101);
    
    }
    
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    return stringBuffer.toString();
  }
}

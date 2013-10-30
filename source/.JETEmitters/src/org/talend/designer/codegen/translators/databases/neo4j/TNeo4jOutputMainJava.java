package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.neo4j.data.Neo4jData;
import org.talend.designer.neo4j.data.Index;
import org.talend.designer.neo4j.data.Relationship;
import org.talend.designer.neo4j.ui.editor.MetadataColumnExt;
import java.util.List;

public class TNeo4jOutputMainJava
{
  protected static String nl;
  public static synchronized TNeo4jOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jOutputMainJava result = new TNeo4jOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t    \t";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ";" + NL + "\t    \t";
  protected final String TEXT_7 = NL + "\t\t\torg.neo4j.graphdb.Node node_";
  protected final String TEXT_8 = " = databaseService_";
  protected final String TEXT_9 = ".createNode();" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\torg.neo4j.graphdb.Node node_";
  protected final String TEXT_11 = " = indexNodeMap_";
  protected final String TEXT_12 = ".get(";
  protected final String TEXT_13 = ").get(";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ").getSingle();" + NL + "\t\t\tif (node_";
  protected final String TEXT_17 = " == null) {" + NL + "\t\t\t\tnode_";
  protected final String TEXT_18 = " = databaseService_";
  protected final String TEXT_19 = ".createNode();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\torg.neo4j.graphdb.Node node_";
  protected final String TEXT_21 = " = indexNodeMap_";
  protected final String TEXT_22 = ".get(";
  protected final String TEXT_23 = ").get(";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ").getSingle();" + NL + "\t\t\tif (node_";
  protected final String TEXT_27 = " == null) {" + NL + "\t\t\t\tthrow new RuntimeException(\"Node not found\");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\torg.neo4j.graphdb.Node node_";
  protected final String TEXT_29 = " = indexNodeMap_";
  protected final String TEXT_30 = ".get(";
  protected final String TEXT_31 = ").get(";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ").getSingle();" + NL + "\t\t\tif (node_";
  protected final String TEXT_35 = " != null) {" + NL + "\t\t\t\tif (indexNodeMap_";
  protected final String TEXT_36 = ".get(";
  protected final String TEXT_37 = ").isWriteable()) {" + NL + "\t\t\t\t\tindexNodeMap_";
  protected final String TEXT_38 = ".get(";
  protected final String TEXT_39 = ").remove(node_";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (node_";
  protected final String TEXT_41 = ".hasRelationship()) {" + NL + "\t\t\t\t\tfor (org.neo4j.graphdb.Relationship relationship_";
  protected final String TEXT_42 = " : node_";
  protected final String TEXT_43 = ".getRelationships(org.neo4j.graphdb.Direction.BOTH)) {" + NL + "\t\t\t\t\t\trelationship_";
  protected final String TEXT_44 = ".delete();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tnode_";
  protected final String TEXT_45 = ".delete();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_46 = "\t\t\t\t\t" + NL + "\t\t\tjava.util.Map<String, org.neo4j.graphdb.Node> endNode_";
  protected final String TEXT_47 = " = new java.util.HashMap<String,org.neo4j.graphdb.Node>();";
  protected final String TEXT_48 = NL + "\t    \t\tif (";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " != null) {" + NL + "\t    \t\t\tjava.util.Date date_";
  protected final String TEXT_51 = " = (java.util.Date) ";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = ";" + NL + "\t    \t\t\tnode_";
  protected final String TEXT_54 = ".setProperty(\"";
  protected final String TEXT_55 = "\", date_";
  protected final String TEXT_56 = ".getTime());" + NL + "\t    \t\t}" + NL + "\t    \t\t";
  protected final String TEXT_57 = NL + "\t\t    \t\tif (";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = " != null) {" + NL + "\t\t    \t\t\tnode_";
  protected final String TEXT_60 = ".setProperty(\"";
  protected final String TEXT_61 = "\", ";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ");" + NL + "\t\t    \t\t}" + NL + "\t\t\t    \t";
  protected final String TEXT_64 = NL + "\t\t    \t\tnode_";
  protected final String TEXT_65 = ".setProperty(\"";
  protected final String TEXT_66 = "\", ";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ");" + NL + "\t    \t\t\t";
  protected final String TEXT_69 = "\t\t    \t\t\t\t" + NL + "\t\t\t\tindexNodeMap_";
  protected final String TEXT_70 = ".get(";
  protected final String TEXT_71 = ").add(node_";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = ");\t\t    \t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\tindexNodeMap_";
  protected final String TEXT_77 = ".get(";
  protected final String TEXT_78 = ").putIfAbsent(node_";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\tindexNodeMap_";
  protected final String TEXT_84 = ".get(";
  protected final String TEXT_85 = ").putIfAbsent(node_";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\tindexNodeMap_";
  protected final String TEXT_90 = ".get(";
  protected final String TEXT_91 = ").add(node_";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ");\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\tendNode_";
  protected final String TEXT_96 = ".put(";
  protected final String TEXT_97 = ", indexNodeMap_";
  protected final String TEXT_98 = ".get(";
  protected final String TEXT_99 = ").get(";
  protected final String TEXT_100 = ", ";
  protected final String TEXT_101 = ").getSingle());" + NL + "\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\tif (";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " != null) {" + NL + "\t\t\t\t\tendNode_";
  protected final String TEXT_105 = ".put(";
  protected final String TEXT_106 = ", indexNodeMap_";
  protected final String TEXT_107 = ".get(";
  protected final String TEXT_108 = ").get(";
  protected final String TEXT_109 = ", ";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = ").getSingle());" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\tendNode_";
  protected final String TEXT_113 = ".put(";
  protected final String TEXT_114 = ", indexNodeMap_";
  protected final String TEXT_115 = ".get(";
  protected final String TEXT_116 = ").get(";
  protected final String TEXT_117 = ", ";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = ").getSingle());" + NL + "\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\tif (endNode_";
  protected final String TEXT_121 = ".get(";
  protected final String TEXT_122 = ") != null) {";
  protected final String TEXT_123 = NL + "\t\t\t\t\tjava.util.Iterator<org.neo4j.graphdb.Relationship> relationShipIterator_";
  protected final String TEXT_124 = " = node_";
  protected final String TEXT_125 = ".getRelationships().iterator();" + NL + "\t\t\t\t\twhile(relationShipIterator_";
  protected final String TEXT_126 = ".hasNext()) {" + NL + "\t\t\t\t\t\torg.neo4j.graphdb.Relationship relation_";
  protected final String TEXT_127 = " = ((org.neo4j.graphdb.Relationship) relationShipIterator_";
  protected final String TEXT_128 = ".next());" + NL + "\t\t\t\t\t\tif(relation_";
  protected final String TEXT_129 = ".getOtherNode(node_";
  protected final String TEXT_130 = ").equals(endNode_";
  protected final String TEXT_131 = ".get(";
  protected final String TEXT_132 = "))) {" + NL + "\t\t\t\t\t\t\trelation_";
  protected final String TEXT_133 = ".delete();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_134 = "\t\t \t" + NL + "\t    \t\t\t\tnode_";
  protected final String TEXT_135 = ".createRelationshipTo(endNode_";
  protected final String TEXT_136 = ".get(";
  protected final String TEXT_137 = "), org.neo4j.graphdb.DynamicRelationshipType.withName(";
  protected final String TEXT_138 = "));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\tendNode_";
  protected final String TEXT_140 = ".get(";
  protected final String TEXT_141 = ").createRelationshipTo(node_";
  protected final String TEXT_142 = ", org.neo4j.graphdb.DynamicRelationshipType.withName(";
  protected final String TEXT_143 = "));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_144 = "\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\tjava.util.Map<String, Object> properties_";
  protected final String TEXT_146 = " = new java.util.HashMap<String, Object>();" + NL + "\t\t\t";
  protected final String TEXT_147 = NL + "\t    \t\tif (";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = " != null) {" + NL + "\t    \t\t\tjava.util.Date date_";
  protected final String TEXT_150 = " = (java.util.Date) ";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = ";" + NL + "\t    \t\t\tproperties_";
  protected final String TEXT_153 = ".put(\"";
  protected final String TEXT_154 = "\", date_";
  protected final String TEXT_155 = ".getTime());" + NL + "\t    \t\t}" + NL + "\t    \t\t";
  protected final String TEXT_156 = NL + "\t\t    \t\tif (";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = " != null) {" + NL + "\t\t    \t\t\tproperties_";
  protected final String TEXT_159 = ".put(\"";
  protected final String TEXT_160 = "\", ";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = ");" + NL + "\t\t    \t\t}" + NL + "\t\t\t    \t";
  protected final String TEXT_163 = NL + "\t\t    \t\tproperties_";
  protected final String TEXT_164 = ".put(\"";
  protected final String TEXT_165 = "\", ";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = ");" + NL + "\t\t    \t\t";
  protected final String TEXT_168 = NL + "\t\t\tlong node_";
  protected final String TEXT_169 = " = inserter_";
  protected final String TEXT_170 = ".createNode(properties_";
  protected final String TEXT_171 = ");" + NL + "\t\t\tjava.util.Map<String, Long> endNode_";
  protected final String TEXT_172 = " = new java.util.HashMap<String,Long>();" + NL + "\t\t\tjava.util.Map<String, Object> indexProperties_";
  protected final String TEXT_173 = " = new java.util.HashMap<String, Object>();" + NL + "\t\t\tjava.util.Map<String, java.util.Map<String, Object>> indexPropertiesMap_";
  protected final String TEXT_174 = " = new java.util.HashMap<String, java.util.Map<String, Object>>();" + NL + "\t\t\t";
  protected final String TEXT_175 = "\t    " + NL + "\t\t\t\tindexProperties_";
  protected final String TEXT_176 = ".put(";
  protected final String TEXT_177 = ", ";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_180 = "\t\t" + NL + "\t\t\t\tindexProperties_";
  protected final String TEXT_181 = ".put(";
  protected final String TEXT_182 = ", ";
  protected final String TEXT_183 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\tindexPropertiesMap_";
  protected final String TEXT_185 = ".put(";
  protected final String TEXT_186 = ", indexProperties_";
  protected final String TEXT_187 = ");" + NL + "\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\tindexInserterMap_";
  protected final String TEXT_189 = ".get(";
  protected final String TEXT_190 = ").updateOrAdd(node_";
  protected final String TEXT_191 = ", indexPropertiesMap_";
  protected final String TEXT_192 = ".get(";
  protected final String TEXT_193 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\tindexInserterMap_";
  protected final String TEXT_195 = ".get(";
  protected final String TEXT_196 = ").add(node_";
  protected final String TEXT_197 = ", indexPropertiesMap_";
  protected final String TEXT_198 = ".get(";
  protected final String TEXT_199 = "));\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\tendNode_";
  protected final String TEXT_201 = ".put(";
  protected final String TEXT_202 = ", 0L);" + NL + "\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\tendNode_";
  protected final String TEXT_204 = ".put(";
  protected final String TEXT_205 = ", indexInserterMap_";
  protected final String TEXT_206 = ".get(";
  protected final String TEXT_207 = ").get(";
  protected final String TEXT_208 = ", ";
  protected final String TEXT_209 = ").getSingle());" + NL + "\t\t\t";
  protected final String TEXT_210 = NL + "\t\t\t\tif (";
  protected final String TEXT_211 = ".";
  protected final String TEXT_212 = " != null) {" + NL + "\t\t\t\t\tendNode_";
  protected final String TEXT_213 = ".put(";
  protected final String TEXT_214 = ", indexInserterMap_";
  protected final String TEXT_215 = ".get(";
  protected final String TEXT_216 = ").get(";
  protected final String TEXT_217 = ", ";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = ").getSingle());" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\tendNode_";
  protected final String TEXT_221 = ".put(";
  protected final String TEXT_222 = ", indexInserterMap_";
  protected final String TEXT_223 = ".get(";
  protected final String TEXT_224 = ").get(";
  protected final String TEXT_225 = ", ";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = ").getSingle());" + NL + "\t\t\t\t";
  protected final String TEXT_228 = "\t\t \t" + NL + "    \t\t\t\tinserter_";
  protected final String TEXT_229 = ".createRelationship(node_";
  protected final String TEXT_230 = ", endNode_";
  protected final String TEXT_231 = ".get(";
  protected final String TEXT_232 = "), org.neo4j.graphdb.DynamicRelationshipType.withName(";
  protected final String TEXT_233 = "), null);" + NL + "\t\t\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\t\t\tinserter_";
  protected final String TEXT_235 = ".createRelationship(endNode_";
  protected final String TEXT_236 = ".get(";
  protected final String TEXT_237 = "), node_";
  protected final String TEXT_238 = ", org.neo4j.graphdb.DynamicRelationshipType.withName(";
  protected final String TEXT_239 = "), null);" + NL + "\t\t\t\t\t";
  protected final String TEXT_240 = NL + NL + "counter_";
  protected final String TEXT_241 = "++;" + NL + "" + NL + "if (counter_";
  protected final String TEXT_242 = " % Long.parseLong(";
  protected final String TEXT_243 = ") == 0) {" + NL + "\ttx_";
  protected final String TEXT_244 = ".success();" + NL + "\ttx_";
  protected final String TEXT_245 = ".finish();" + NL + "\ttx_";
  protected final String TEXT_246 = " = databaseService_";
  protected final String TEXT_247 = ".beginTx();" + NL + "}" + NL + "" + NL + "nb_line_";
  protected final String TEXT_248 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    final INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();
    final String dataAction = ElementParameterParser.getValue(node, "__DATA_ACTION__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    boolean batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
    
    List<IMetadataColumn> columnList = null;
    List<IMetadataTable> metadatas = node.getMetadataList();
    
    if (metadatas != null && metadatas.size() > 0) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata != null) {
    		columnList = metadata.getListColumns();
    	}
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
    for (IMetadataColumn column : columnList) {
	    if (outgoingConnName != null) {
	    	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_6);
    
		}
    }
    
    class Neo4jUtils {
		
		private List<IMetadataColumn> columnList;
		private String incomingConnName;
		
		public Neo4jUtils(String incomingConnName, List<IMetadataColumn> columnList) {
			this.incomingConnName = incomingConnName;
			this.columnList = columnList;
		}
		
		public void generateNodeInsert() {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			generateNode();
		}
		
		public void generateNodeInsertOrUpdate() {
			String indexName = ElementParameterParser.getValue(node, "__INDEX_NAME__");
			String indexKey = ElementParameterParser.getValue(node, "__INDEX_KEY__");
			String indexColumnValue = ElementParameterParser.getValue(node, "__INDEX_VALUE__");
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(indexKey);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(indexColumnValue);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			generateNode();
		}
		
		public void generateNodeUpdate() {
			String indexName = ElementParameterParser.getValue(node, "__INDEX_NAME__");
			String indexKey = ElementParameterParser.getValue(node, "__INDEX_KEY__");
			String indexColumnValue = ElementParameterParser.getValue(node, "__INDEX_VALUE__");
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(indexKey);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(indexColumnValue);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
			generateNode();
		}
		
		public void generateNodeDelete() {
			String indexName = ElementParameterParser.getValue(node, "__INDEX_NAME__");
			String indexKey = ElementParameterParser.getValue(node, "__INDEX_KEY__");
			String indexColumnValue = ElementParameterParser.getValue(node, "__INDEX_VALUE__");
			
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(indexKey);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(indexColumnValue);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
		}

		private void generateNode() {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			for (IMetadataColumn column : columnList) {		    	
		    	if (column instanceof MetadataColumnExt) {		    		
		    		MetadataColumnExt columnExt = (MetadataColumnExt) column;		    		
		    		Neo4jData data = columnExt.getData();
		    		generateNodePropertyInsert(column);
		    		for (Index index : data.getIndexes()) {
		    			generateIndexCreation(index, column);
		    		}
		    		for (Relationship relationship : data.getRelationships()) {
		    			generateRelationshipCreation(relationship, column);
		    		}
		    	}
		    }
		}
	
		private void generateNodePropertyInsert(IMetadataColumn column) {
			if (column.getTalendType().equals("id_Date")) {
	    		
    stringBuffer.append(TEXT_48);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
    		} else {
		    	if (column.isNullable()) {
			    	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_63);
    
		    	} else {
			    	
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_68);
    
		    	}
		    }
		}


		private void generateIndexCreation(Index index, IMetadataColumn column) {
			boolean fromValueColumn = index.getValue() == null || index.getValue().isEmpty();
			if (fromValueColumn) {
				
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(index.getName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(index.getKey());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_75);
    
			} else if (fromValueColumn && index.isUnique()){
				
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(index.getName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(index.getKey());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_82);
    
			} else if (index.isUnique()) {
				
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(index.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(index.getKey());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(index.getValue());
    stringBuffer.append(TEXT_88);
    
			} else {
				
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(index.getName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(index.getKey());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(index.getValue());
    stringBuffer.append(TEXT_94);
    
			}
		}
		
		private void generateRelationshipCreation(Relationship relationship, IMetadataColumn column) {
			if (relationship.getIndex().getValue() != null && !relationship.getIndex().getValue().isEmpty()) {
			
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(relationship.getIndex().getKey());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(relationship.getIndex().getValue());
    stringBuffer.append(TEXT_101);
    
			} else if (column.isNullable()) {
			
    stringBuffer.append(TEXT_102);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(relationship.getIndex().getKey());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_111);
    
			} else {
				
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(relationship.getIndex().getKey());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_119);
    
			}
			
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_122);
    
				if(dataAction.equals("UPDATE") || dataAction.equals("INSERT_OR_UPDATE")) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
				}
				switch (relationship.getDirection()) {
					case OUTGOING :
						
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(relationship.getType());
    stringBuffer.append(TEXT_138);
    
						break;
					case INCOMING :
						
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(relationship.getType());
    stringBuffer.append(TEXT_143);
    
						break;
				}
				
    stringBuffer.append(TEXT_144);
    
		}
	}
    
    class Neo4jBatchUtils {
    	private List<IMetadataColumn> columnList;
		private String incomingConnName;
		
		public Neo4jBatchUtils(String incomingConnName, List<IMetadataColumn> columnList) {
			this.incomingConnName = incomingConnName;
			this.columnList = columnList;
		}
		
		public void generateNodeBatchInsert() {
			
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
			for (IMetadataColumn column : columnList) {		
	    		putBatchPropertyInsertInMap(column);
		    }
		    // Must compute all properties before node creation for best performances
		    generateNode();
		    for (IMetadataColumn column : columnList) {
		    	if (column instanceof MetadataColumnExt) {		    		
		    		MetadataColumnExt columnExt = (MetadataColumnExt) column;		    		
		    		Neo4jData data = columnExt.getData();
		    		for (Index index : data.getIndexes()) {
		    			generateIndexCreation(index, column);
		    		}		    		
		    		for (Relationship relationship : data.getRelationships()) {
		    			generateRelationshipCreation(relationship, column);
		    		}
		    	}
	    	}
		}
		
		private void putBatchPropertyInsertInMap(IMetadataColumn column) {
			if (column.getTalendType().equals("id_Date")) {
	    		
    stringBuffer.append(TEXT_147);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
    		} else {
		    	if (column.isNullable()) {
			    	
    stringBuffer.append(TEXT_156);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_162);
    
		    	} else {
			    	
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_167);
    
		    	}
		    }
		}
		
		private void generateNode() {
			
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
		}
		
		private void generateIndexCreation(Index index, IMetadataColumn column) {
			boolean fromValueColumn = index.getValue() == null || index.getValue().isEmpty();
			if (fromValueColumn) {
				
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(index.getKey());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_179);
    
			} else {
				
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(index.getKey());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(index.getValue());
    stringBuffer.append(TEXT_183);
    
			}
			
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(index.getName());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
			
			if (index.isUnique()) {
				
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(index.getName());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(index.getName());
    stringBuffer.append(TEXT_193);
    
			} else {
				
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(index.getName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(index.getName());
    stringBuffer.append(TEXT_199);
    
			}
		}
		
		private void generateRelationshipCreation(Relationship relationship, IMetadataColumn column) {
			
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_202);
    
			if (relationship.getIndex().getValue() != null && !relationship.getIndex().getValue().isEmpty()) {
			
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_207);
    stringBuffer.append(relationship.getIndex().getKey());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(relationship.getIndex().getValue());
    stringBuffer.append(TEXT_209);
    
			} else if (column.isNullable()) {
			
    stringBuffer.append(TEXT_210);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(relationship.getIndex().getKey());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_219);
    
			} else {
				
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(relationship.getIndex().getKey());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_227);
    
			}
			switch (relationship.getDirection()) {
				case OUTGOING :
					
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(relationship.getType());
    stringBuffer.append(TEXT_233);
    
					break;
				case INCOMING :
					
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(relationship.getIndex().getName());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(relationship.getType());
    stringBuffer.append(TEXT_239);
    
					break;
			}
		}
    }
    
    if (batchImport) {
    	Neo4jBatchUtils neo4jBatchUtils = new Neo4jBatchUtils(incomingConnName, columnList);
    	neo4jBatchUtils.generateNodeBatchInsert();
    } else {
    	Neo4jUtils neo4jUtils = new Neo4jUtils(incomingConnName, columnList);
	    if (dataAction.equals("INSERT")) {
		    neo4jUtils.generateNodeInsert();
		} else if (dataAction.equals("INSERT_OR_UPDATE")) {
			neo4jUtils.generateNodeInsertOrUpdate();
		} else if (dataAction.equals("UPDATE")) {
			neo4jUtils.generateNodeUpdate();
		} else if (dataAction.equals("DELETE")) {
			neo4jUtils.generateNodeDelete();
		}
	}

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    return stringBuffer.toString();
  }
}

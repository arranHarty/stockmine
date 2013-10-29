package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IProcess;

public class TOracleOutputEndJava
{
  protected static String nl;
  public static synchronized TOracleOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleOutputEndJava result = new TOracleOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t     \t// TODO unable to parse integer: ";
  protected final String TEXT_3 = NL + "\t     \t// TODO error: ";
  protected final String TEXT_4 = NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\tjava.sql.Statement stmtCreateGeoColumns_";
  protected final String TEXT_6 = " = conn_";
  protected final String TEXT_7 = ".createStatement();" + NL + "\t\t" + NL + "\t\t// Delete geometry columns entry if already exists." + NL + "\t\tString deleteGeometryColumns_";
  protected final String TEXT_8 = " = \"DELETE FROM user_sdo_geom_metadata \"" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t+ \"WHERE TABLE_NAME='\" + ";
  protected final String TEXT_9 = " + \"'\";" + NL + "\t\tstmtCreateGeoColumns_";
  protected final String TEXT_10 = ".execute(deleteGeometryColumns_";
  protected final String TEXT_11 = ");" + NL + "" + NL + "\t\tfor (String column: geometryColumnToExtends.keySet()) {" + NL + "\t\t    com.vividsolutions.jts.geom.Envelope extend = geometryColumnToExtends.get(column);" + NL + "\t\t    " + NL + "\t\t\t// Create new entry in geometry columns table" + NL + "\t        String insertGeometryColumns_";
  protected final String TEXT_12 = " = \"INSERT INTO user_sdo_geom_metadata (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) VALUES ('\" " + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ ";
  protected final String TEXT_13 = " + \"','\" + column.toUpperCase(java.util.Locale.US) + \"', \"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ \"MDSYS.SDO_DIM_ARRAY(MDSYS.SDO_DIM_ELEMENT('x', \" + extend.getMinX() + \", \" + extend.getMaxX() + \", ";
  protected final String TEXT_14 = "), \"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ \"MDSYS.SDO_DIM_ELEMENT('y', \" + extend.getMinY() + \", \" + extend.getMaxY() + \", ";
  protected final String TEXT_15 = ")), \"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ ";
  protected final String TEXT_16 = " +\")\";" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_18 = " - Executing '\" +  insertGeometryColumns_";
  protected final String TEXT_19 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_20 = "\t\t\t\t\t\t\t\t\t\t" + NL + "\t    \tstmtCreateGeoColumns_";
  protected final String TEXT_21 = ".execute(insertGeometryColumns_";
  protected final String TEXT_22 = ");" + NL + "\t    \t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Execute '\" + insertGeometryColumns_";
  protected final String TEXT_25 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "    \t}" + NL + "        " + NL + "        stmtCreateGeoColumns_";
  protected final String TEXT_27 = ".close();" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t\tfor (String geometryColumnName: geometryColumnToExtends.keySet()) {" + NL + "" + NL + "\t\t\tString index_name = \"spatialidx_\"+";
  protected final String TEXT_29 = "+\"_\" + geometryColumnName;" + NL + "\t\t\tif (index_name.length() > 30) {" + NL + "\t\t\t\tindex_name = index_name.substring(0, 29);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t    \tjava.sql.Statement stmtCreateIndex_";
  protected final String TEXT_30 = " = conn_";
  protected final String TEXT_31 = ".createStatement();" + NL + "\t\t\t// Drop spatial index if exists" + NL + "\t\t\tString dropIndex_";
  protected final String TEXT_32 = " = \"DROP INDEX \"+index_name;" + NL + "\t        try {" + NL + "\t        \t";
  protected final String TEXT_33 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_34 = " - Executing '\" + dropIndex_";
  protected final String TEXT_35 = " + \"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\tstmtCreateIndex_";
  protected final String TEXT_37 = ".execute(dropIndex_";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_40 = " - Execute '\" + dropIndex_";
  protected final String TEXT_41 = " + \"' has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t}" + NL + "\t\t\tcatch (java.sql.SQLException e_";
  protected final String TEXT_43 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_45 = " - \" +  e_";
  protected final String TEXT_46 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t// Create spatial index using GIST on geometry columns" + NL + "\t\t\tString createIndex_";
  protected final String TEXT_48 = " = \"CREATE INDEX \"+index_name + \" \" " + NL + "\t\t\t\t\t\t+ \"ON \" + ";
  protected final String TEXT_49 = " + \"(\" + geometryColumnName + \") \"" + NL + "\t\t\t\t\t\t+ \"INDEXTYPE IS MDSYS.SPATIAL_INDEX\";" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_51 = " - Executing '\" + createIndex_";
  protected final String TEXT_52 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t        stmtCreateIndex_";
  protected final String TEXT_54 = ".execute(createIndex_";
  protected final String TEXT_55 = ");" + NL + "        \t";
  protected final String TEXT_56 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_57 = " - Execute \" + createIndex_";
  protected final String TEXT_58 = " + \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t        stmtCreateIndex_";
  protected final String TEXT_60 = ".close();" + NL + "\t    }" + NL + "\t\t";
  protected final String TEXT_61 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_62 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_63 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_64 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_65 = ".close();" + NL + "            " + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_66 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_67 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_68 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_69 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_70 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_71 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_72 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_73 = "                " + NL + "                try {" + NL + "                \tif (pstmt_";
  protected final String TEXT_74 = " != null) { " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_76 = " - Executing the ";
  protected final String TEXT_77 = " batch.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\tpstmt_";
  protected final String TEXT_79 = ".executeBatch();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_80 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_81 = " - The ";
  protected final String TEXT_82 = " batch execution has succeeded.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_83 = NL + "            \t    }          \t    " + NL + "                }catch (java.sql.BatchUpdateException e_";
  protected final String TEXT_84 = "){" + NL + "                \t";
  protected final String TEXT_85 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_87 = " - \" + e_";
  protected final String TEXT_88 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = NL + "                \t\tthrow(e_";
  protected final String TEXT_90 = ");" + NL + "                \t";
  protected final String TEXT_91 = NL + "\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_93 = " - \" + e_";
  protected final String TEXT_94 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_95 = NL + "                \tSystem.out.println(e_";
  protected final String TEXT_96 = ".getMessage());" + NL + "                \t";
  protected final String TEXT_97 = "                \t" + NL + "            \t}" + NL + "            \tif (pstmt_";
  protected final String TEXT_98 = " != null) { " + NL + "\t            \ttmp_batchUpdateCount_";
  protected final String TEXT_99 = " = pstmt_";
  protected final String TEXT_100 = ".getUpdateCount();            \t" + NL + "\t    \t    \t";
  protected final String TEXT_101 = NL + "\t    \t    \t\tinsertedCount_";
  protected final String TEXT_102 = " " + NL + "\t    \t    \t";
  protected final String TEXT_103 = NL + "\t    \t    \t\tupdatedCount_";
  protected final String TEXT_104 = NL + "\t    \t    \t";
  protected final String TEXT_105 = NL + "\t    \t    \t    deletedCount_";
  protected final String TEXT_106 = NL + "\t    \t    \t";
  protected final String TEXT_107 = NL + "\t    \t    \t+= (tmp_batchUpdateCount_";
  protected final String TEXT_108 = "!=-1?tmp_batchUpdateCount_";
  protected final String TEXT_109 = ":0);                                  " + NL + "                }";
  protected final String TEXT_110 = "        " + NL + "        if(pstmt_";
  protected final String TEXT_111 = " != null) {            " + NL + "\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_113 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\tSharedDBPreparedStatement.releasePreparedStatement(keyPsmt_";
  protected final String TEXT_115 = ");   " + NL + "\t\t\t";
  protected final String TEXT_116 = "                    " + NL + "        }        ";
  protected final String TEXT_117 = NL;
  protected final String TEXT_118 = NL + "\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_120 = " - Starting to commit \" + commitCounter_";
  protected final String TEXT_121 = "+ \" records.\");" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t    conn_";
  protected final String TEXT_123 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_125 = " - Commit has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_126 = NL + "\t\t    ";
  protected final String TEXT_127 = "\t" + NL + "\t\t";
  protected final String TEXT_128 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_129 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_130 = NL + "\t\tconn_";
  protected final String TEXT_131 = " .close();" + NL + "\t\t";
  protected final String TEXT_132 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_133 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_134 = NL + "    \t";
  protected final String TEXT_135 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_136 = "=nb_line_deleted_";
  protected final String TEXT_137 = "+ deletedCount_";
  protected final String TEXT_138 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_139 = "=nb_line_update_";
  protected final String TEXT_140 = " + updatedCount_";
  protected final String TEXT_141 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_142 = "=nb_line_inserted_";
  protected final String TEXT_143 = " + insertedCount_";
  protected final String TEXT_144 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_145 = "=nb_line_rejected_";
  protected final String TEXT_146 = " + rejectedCount_";
  protected final String TEXT_147 = ";" + NL + "" + NL + "    globalMap.put(\"";
  protected final String TEXT_148 = "_NB_LINE\",nb_line_";
  protected final String TEXT_149 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_150 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_151 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_152 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_153 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_154 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_155 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_156 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_157 = ");" + NL + "\t";
  protected final String TEXT_158 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_159 = " - Has inserted \"+nb_line_inserted_";
  protected final String TEXT_160 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_161 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_162 = " - Has updated \"+nb_line_update_";
  protected final String TEXT_163 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_164 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_165 = " - Has deleted \"+nb_line_deleted_";
  protected final String TEXT_166 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_167 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_168 = " - Has updated \"+nb_line_update_";
  protected final String TEXT_169 = " + \" records.\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_170 = " - Has inserted \"+nb_line_inserted_";
  protected final String TEXT_171 = " + \" records.\");";
  protected final String TEXT_172 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_173 = " - Has inserted \"+nb_line_inserted_";
  protected final String TEXT_174 = " + \" records.\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_175 = " - Has updated \"+nb_line_update_";
  protected final String TEXT_176 = " + \" records.\");" + NL + "    ";
  protected final String TEXT_177 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_178 = " - Has rejected \"+nb_line_rejected_";
  protected final String TEXT_179 = " + \" records.\");" + NL + "\t";
  protected final String TEXT_180 = NL + "\t\tlog.info(\"";
  protected final String TEXT_181 = " - Done.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	IProcess process = node.getProcess();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__"); 
	boolean isUseBatchByDBVersion = !"ORACLE_8".equalsIgnoreCase(dbVersion);	
	
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	
	String dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
	
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	
	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");	
	
	boolean useSpatialOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_SPATIAL_OPTIONS__"));
	
	boolean createSpatialIndex = ("true").equals(ElementParameterParser.getValue(node,"__SPATIAL_INDEX__"));
	
	String indexAccuracy = ElementParameterParser.getValue(node, "__SPATIAL_INDEX_ACCURACY__");
	
	String useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
    String batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
	
	List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();      
    }
	
    if (useSpatialOptions && (("DROP_CREATE").equals(tableAction) || ("CREATE").equals(tableAction) 
    		|| ("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction))) {

	    int targetSRID = -1;
	    try {
	      	targetSRID = Integer.parseInt(ElementParameterParser.getValue(node,"__SRID__"));
	    }
	    catch (NumberFormatException e) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ElementParameterParser.getValue(node,"__SRID__"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(e.getMessage());
    stringBuffer.append(TEXT_4);
    
	     	e.printStackTrace();
	    }
		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tableName.toUpperCase(java.util.Locale.US) );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tableName.toUpperCase(java.util.Locale.US) );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(indexAccuracy );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(indexAccuracy );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(targetSRID < 0 ? "\"NULL\"" : targetSRID );
    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
	}
	if (createSpatialIndex && useSpatialOptions) {
		
    stringBuffer.append(TEXT_28);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_49);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
	}
    
	
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }

	
    if(("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
    } else { // dataAction equals "INSERT" or "UPDATE" or "DELETE" 
        
    if ((rejectConnName==null && isUseBatchByDBVersion && !useExistingConnection) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
            
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    if (isLog4jEnabled && ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize)) {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    if (isLog4jEnabled && ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize)) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_85);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
                	}else {
                	
    stringBuffer.append(TEXT_91);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
                	}
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    if (("INSERT").equals(dataAction)) {
	    	    	
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
	    	    	}else if (("UPDATE").equals(dataAction)) {
	    	    	
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
	    	    	}else if (("DELETE").equals(dataAction)) {
	    	    	
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
	    	    	}
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
            }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    
			//to fixed: bug8422
			if(!(cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
			
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
			}else{
			
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
			}
			
    stringBuffer.append(TEXT_116);
    
    }   
    
    stringBuffer.append(TEXT_117);
    
	if(!useExistingConnection)
	{
		if(!("").equals(commitEvery) && !("0").equals(commitEvery))
		{
		    
    stringBuffer.append(TEXT_118);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    
		}
		
    stringBuffer.append(TEXT_127);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    }
    stringBuffer.append(TEXT_134);
    
	}
    
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
	if(isLog4jEnabled){
		if(("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) {
    		if (("INSERT").equals(dataAction)) {
	
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
    		}else if (("UPDATE").equals(dataAction)) {
	
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
    		}else if (("DELETE").equals(dataAction)) {
	
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
    		}
    	}else if("UPDATE_OR_INSERT".equals(dataAction)){
	
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
    	}else if("INSERT_OR_UPDATE".equals(dataAction)){
    
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
    	}
    	if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
	
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
		}
	
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
	}
	
    return stringBuffer.toString();
  }
}

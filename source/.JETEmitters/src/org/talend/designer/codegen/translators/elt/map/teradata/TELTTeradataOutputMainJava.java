package org.talend.designer.codegen.translators.elt.map.teradata;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.commons.utils.generation.CodeGenerationUtils;
import java.util.List;
import java.util.LinkedList;

public class TELTTeradataOutputMainJava
{
  protected static String nl;
  public static synchronized TELTTeradataOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTTeradataOutputMainJava result = new TELTTeradataOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");";
  protected final String TEXT_3 = NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_6 = " - Driver ClassName: ";
  protected final String TEXT_7 = ".\");";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.debug(log4jDebugParamters_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t\t\tString log4jDebugParamters_";
  protected final String TEXT_11 = " = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\tString dbproperties_log4j_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_15 = " = log4jDebugParamters_";
  protected final String TEXT_16 = " + \"PROPERTIES = \" + dbproperties_log4j_";
  protected final String TEXT_17 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\tString dbhost_log4j_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_22 = " = log4jDebugParamters_";
  protected final String TEXT_23 = " + \"HOST = \" + dbhost_log4j_";
  protected final String TEXT_24 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\tString dbport_log4j_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_29 = " = log4jDebugParamters_";
  protected final String TEXT_30 = " + \"PORT = \" + dbport_log4j_";
  protected final String TEXT_31 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\tString dbname_log4j_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_36 = " = log4jDebugParamters_";
  protected final String TEXT_37 = " + \"DBNAME = \" + dbname_log4j_";
  protected final String TEXT_38 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\tString dbuser_log4j_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_43 = " = log4jDebugParamters_";
  protected final String TEXT_44 = " + \"USERNAME = \" + dbuser_log4j_";
  protected final String TEXT_45 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_48 = " = log4jDebugParamters_";
  protected final String TEXT_49 = " + \"CONNECTION_TYPE = ";
  protected final String TEXT_50 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_53 = " = log4jDebugParamters_";
  protected final String TEXT_54 = " + \"DBVERSION = ";
  protected final String TEXT_55 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\tString dbSchema_log4j_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_60 = " = log4jDebugParamters_";
  protected final String TEXT_61 = " + \"DBSCHEMA = \" + dbSchema_log4j_";
  protected final String TEXT_62 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t";
  protected final String TEXT_64 = "\t" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_65 = " = log4jDebugParamters_";
  protected final String TEXT_66 = " + \"USE_CURSOR = ";
  protected final String TEXT_67 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_70 = " = log4jDebugParamters_";
  protected final String TEXT_71 = " + \"TRIM_ALL_COLUMN = ";
  protected final String TEXT_72 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_75 = " = log4jDebugParamters_";
  protected final String TEXT_76 = " + \"NO_NULL_VALUES = ";
  protected final String TEXT_77 = "\" + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\tString table_log4j_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_82 = " = log4jDebugParamters_";
  protected final String TEXT_83 = " + \"TABLE = \" + table_log4j_";
  protected final String TEXT_84 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\tString dbquery_log4j_";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ";" + NL + "\t\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_89 = " = log4jDebugParamters_";
  protected final String TEXT_90 = " + \"QUERY = \" + dbquery_log4j_";
  protected final String TEXT_91 = " + \" | \";" + NL + "\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\tlog4jDebugParamters_";
  protected final String TEXT_93 = " = \"";
  protected final String TEXT_94 = " - Parameters:\" + log4jDebugParamters_";
  protected final String TEXT_95 = ";";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL + "\tString select_query = null;" + NL + "\tString selectQueryColumnsName = null;" + NL + "\t";
  protected final String TEXT_98 = NL + "\t\tselect_query = (String) globalMap.get(\"";
  protected final String TEXT_99 = "\"+\"QUERY\"+\"";
  protected final String TEXT_100 = "\");" + NL + "\t\tselectQueryColumnsName = (String) globalMap.get(\"";
  protected final String TEXT_101 = "\"+\"QUERY_COLUMNS_NAME\"+\"";
  protected final String TEXT_102 = "\");" + NL + "\t\t";
  protected final String TEXT_103 = NL;
  protected final String TEXT_104 = NL;
  protected final String TEXT_105 = NL + "    java.sql.Connection conn_";
  protected final String TEXT_106 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_107 = "\");" + NL + "\t";
  protected final String TEXT_108 = " " + NL + "\t\tif(conn_";
  protected final String TEXT_109 = " != null) {" + NL + "\t\t\tif(conn_";
  protected final String TEXT_110 = ".getMetaData() != null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_111 = " - Uses an existing connection as \" + conn_";
  protected final String TEXT_112 = ".getMetaData().getUserName() + \". Connection URL: \" + conn_";
  protected final String TEXT_113 = ".getMetaData().getURL() + \".\"); " + NL + "\t\t\t} " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_114 = NL + "    java.lang.Class.forName(\"com.teradata.jdbc.TeraDriver\");" + NL + "    String url_";
  protected final String TEXT_115 = " = \"jdbc:teradata://\" + ";
  protected final String TEXT_116 = "+ \"/DATABASE=\" + ";
  protected final String TEXT_117 = ";" + NL + "    String dbUser_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = ";" + NL + "    String dbPwd_";
  protected final String TEXT_120 = " = ";
  protected final String TEXT_121 = ";" + NL + "\t";
  protected final String TEXT_122 = "\t " + NL + "\t";
  protected final String TEXT_123 = NL + "\t\tlog.info(\"";
  protected final String TEXT_124 = " - Connection attempt to '\" + url_";
  protected final String TEXT_125 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_126 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_127 = NL + "    java.sql.Connection conn_";
  protected final String TEXT_128 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_129 = ",dbUser_";
  protected final String TEXT_130 = ",dbPwd_";
  protected final String TEXT_131 = ");" + NL + "\t";
  protected final String TEXT_132 = NL + "\t\tlog.info(\"";
  protected final String TEXT_133 = " - Connection to '\" + url_";
  protected final String TEXT_134 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_135 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_136 = " =null;" + NL + "\t";
  protected final String TEXT_137 = NL + NL + "\tString tableName_";
  protected final String TEXT_138 = " = ";
  protected final String TEXT_139 = ";";
  protected final String TEXT_140 = "\t" + NL + "\t" + NL + "\t" + NL + "String insertQuery = \"INSERT INTO \"+tableName_";
  protected final String TEXT_141 = "+\" (";
  protected final String TEXT_142 = ") \"+select_query;" + NL + "pstmt_";
  protected final String TEXT_143 = " = conn_";
  protected final String TEXT_144 = ".prepareStatement(insertQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_145 = NL + NL + "String updateQuery = \"UPDATE \"+tableName_";
  protected final String TEXT_146 = "+\" FROM (\" + select_query + \") src SET ";
  protected final String TEXT_147 = " \"";
  protected final String TEXT_148 = NL + "+\"  WHERE \" + ";
  protected final String TEXT_149 = NL + ";" + NL + "pstmt_";
  protected final String TEXT_150 = " = conn_";
  protected final String TEXT_151 = ".prepareStatement(updateQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_152 = NL + "\t" + NL + "String deleteQuery = \"DELETE  FROM \"+ tableName_";
  protected final String TEXT_153 = "+\" WHERE EXISTS (\"+select_query+\") \" ";
  protected final String TEXT_154 = NL + "+\"  AND \" + ";
  protected final String TEXT_155 = NL + ";" + NL + "pstmt_";
  protected final String TEXT_156 = " = conn_";
  protected final String TEXT_157 = ".prepareStatement(deleteQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_158 = NL + "int nb_line_";
  protected final String TEXT_159 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_160 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_161 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_162 = " = 0;" + NL + "\t";
  protected final String TEXT_163 = NL + NL + "System.out.println(\"Inserting with : \\n\" + insertQuery + \"\\n\");";
  protected final String TEXT_164 = NL + "\tlog.info(\"";
  protected final String TEXT_165 = " - Executing the SQL query :'\" + insertQuery + \"'.\" );";
  protected final String TEXT_166 = NL + "nb_line_inserted_";
  protected final String TEXT_167 = " = pstmt_";
  protected final String TEXT_168 = ".executeUpdate();";
  protected final String TEXT_169 = NL + "\tlog.info(\"";
  protected final String TEXT_170 = " - The SQL query :'\" + insertQuery + \"' has been executed successfully.\");";
  protected final String TEXT_171 = NL + "System.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_172 = " + \" rows inserted. \\n\");" + NL + "" + NL + "\t";
  protected final String TEXT_173 = NL + "System.out.println(\"Updating with : \\n\" + updateQuery +\"\\n\");";
  protected final String TEXT_174 = NL + "\tlog.info(\"";
  protected final String TEXT_175 = " - Executing the SQL query :'\" + updateQuery + \"'.\");";
  protected final String TEXT_176 = NL + "nb_line_update_";
  protected final String TEXT_177 = " = pstmt_";
  protected final String TEXT_178 = ".executeUpdate();";
  protected final String TEXT_179 = NL + "\tlog.info(\"";
  protected final String TEXT_180 = " - The SQL query :'\" + updateQuery + \"' has been executed successfully.\");";
  protected final String TEXT_181 = NL + "\tSystem.out.println(\"--> \" + nb_line_update_";
  protected final String TEXT_182 = " + \" rows updated. \\n\");" + NL + "\t";
  protected final String TEXT_183 = NL + "\tSystem.out.println(\"Deleting with : \\n\" + deleteQuery +\"\\n\");" + NL + "\t\t";
  protected final String TEXT_184 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_185 = " - Executing the SQL query :'\" + deleteQuery +\"'.\");" + NL + "\t\t";
  protected final String TEXT_186 = NL + "\t\tnb_line_deleted_";
  protected final String TEXT_187 = " = pstmt_";
  protected final String TEXT_188 = ".executeUpdate();" + NL + "\t\t";
  protected final String TEXT_189 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_190 = " - The SQL query :'\" + deleteQuery + \"' has been executed successfully.\");" + NL + "\t\t";
  protected final String TEXT_191 = NL + "\tSystem.out.println(\"--> \" + nb_line_deleted_";
  protected final String TEXT_192 = " + \" rows deleted. \\n\");" + NL + "\t\t";
  protected final String TEXT_193 = NL + NL + "pstmt_";
  protected final String TEXT_194 = ".close();" + NL;
  protected final String TEXT_195 = NL + "    if(conn_";
  protected final String TEXT_196 = " != null && !conn_";
  protected final String TEXT_197 = ".isClosed()) {" + NL + "\t\t";
  protected final String TEXT_198 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_199 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_200 = NL + "        conn_";
  protected final String TEXT_201 = " .close();" + NL + "\t\t";
  protected final String TEXT_202 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_203 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_204 = NL + "    }";
  protected final String TEXT_205 = NL + "nb_line_";
  protected final String TEXT_206 = " = nb_line_update_";
  protected final String TEXT_207 = " + nb_line_inserted_";
  protected final String TEXT_208 = " + nb_line_deleted_";
  protected final String TEXT_209 = ";" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_210 = "_NB_LINE\",nb_line_";
  protected final String TEXT_211 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_212 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_213 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_214 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_215 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_216 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_217 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_218 = NL + "\t\tlog.info(\"";
  protected final String TEXT_219 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_220 = " + \". Inserted records count: \" + nb_line_inserted_";
  protected final String TEXT_221 = " + \". Updated records count: \" + nb_line_update_";
  protected final String TEXT_222 = " + \". Deleted records count: \" + nb_line_deleted_";
  protected final String TEXT_223 = " + \".\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_224 = " - Done.\");" + NL + "\t";
  protected final String TEXT_225 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jCodeGenerateUtil {
	
		INode node = null;
	    String cid = null;
		String dbproperties = null;
		String dbhost = null;
    	String dbport = null;
    	String dbname = null;
    	String dbuser = null;
 		String dbpwd = null;
		String connectionType = null;
 		String dbVersion =  null; 
 		String dbSchema = null;
 		String useCursor = null;
 		String trimAllColumn = null;
 		String noNullValues = null;
 		String dbquery= null;
 		String table = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");
			connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	 		dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
	 		dbSchema = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
	 		useCursor = ElementParameterParser.getValue(node,"__USE_CURSOR__");
	 		trimAllColumn = ElementParameterParser.getValue(node,"__TRIM_ALL_COLUMN__");
	 		noNullValues = ElementParameterParser.getValue(node,"__NO_NULL_VALUES__");
	 		dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			table= ElementParameterParser.getValue(node, "__TABLE__");
			isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void infoComponentStart(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void initDbDebugRowBuffer() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void debugDriverClassName(String driverClass) {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(driverClass );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		public void debugConnectionParams(INode node,String driverClass) {
			beforeComponentProcess(node);
			generateConnectionParams();
			debugDriverClassName(driverClass);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			}
		}
	
		public void dbConnectionParamsForELT(INode previousNode){
			cid = previousNode.getUniqueName();
			dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	    	dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
		}
		
		public void additionalParameter(INode node) {
			String needtoConvet2Upper= ElementParameterParser.getValue(node, "__Convert_to_UPPer__");
		}
		
		public void generateAdditionalParameters(INode node) {
			additionalParameter(node);
		}
		
		public void generateConnectionParams() {
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if(dbproperties != null && !("\"\"").equals(dbproperties) && !("").equals(dbproperties)){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    if(dbhost!= null && !("\"\"").equals(dbhost) && !("").equals(dbhost)){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    if(dbport!= null && !("\"\"").equals(dbport) && !("").equals(dbport)){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbport.replace("'", "\""));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    if(dbname!= null && !("\"\"").equals(dbname) && !("").equals(dbname)){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    if(dbuser!= null && !("\"\"").equals(dbuser) && !("").equals(dbuser)){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    if(connectionType!= null && !("\"\"").equals(connectionType) && !("").equals(connectionType)){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    if(dbVersion!= null && !("\"\"").equals(dbVersion) && !("").equals(dbVersion)){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dbVersion);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    if(dbSchema!= null && !("\"\"").equals(dbSchema) && !("").equals(dbSchema)){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(dbSchema);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    if(useCursor!= null && !("\"\"").equals(useCursor) && !("").equals(useCursor)){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(useCursor);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    if(trimAllColumn!= null && !("\"\"").equals(trimAllColumn) && !("").equals(trimAllColumn)){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(trimAllColumn);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    if(noNullValues!= null && !("\"\"").equals(noNullValues) && !("").equals(noNullValues)){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(noNullValues);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    if(table!= null && !("\"\"").equals(table) && !("").equals(table)){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    if(dbquery!= null && !("\"\"").equals(dbquery) && !("").equals(dbquery)){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    	
			}
	    }
	}
	
	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_96);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();

	String dbtable = null;
	String uniqueNameConnection = null;
	INode previousNode = null;

	String differenttable = ElementParameterParser.getValue(node, "__DIFFERENT_TABLE_NAME__");
	boolean useDifferentTable = "true".equals(ElementParameterParser.getValue(node, "__USE_DIFFERENT_TABLE__"));
	
	
    stringBuffer.append(TEXT_97);
    
	List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
	if(connections != null && connections.size() > 0 && connections.get(0) != null) {
	    IConnection connection = connections.get(0);
	    previousNode = connection.getSource();
	    String previousComponentName = previousNode.getUniqueName();
		dbtable = connection.getName();
		uniqueNameConnection = connection.getUniqueName();
		
    stringBuffer.append(TEXT_98);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_102);
    
	}
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

        String dbhost = null;
        String dbname = null;
        String dbuser = null;
        String dbpwd = null;
        boolean useExistingConn = false;
        if(previousNode != null) {
	        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	        dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
	        useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));
        }

        String whereClause = ElementParameterParser.getValue(node, "__WHERE_CLAUSE__");


    stringBuffer.append(TEXT_103);
    
List<IMetadataColumn> columnList = null;

List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas !=null && metadatas.size()>0){
	IMetadataTable metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_104);
    
if(useExistingConn) {
    String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
    String conn = "conn_" + connection;
    
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_107);
     if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    }
} else {
    
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_121);
    
   		log4jCodeGenerateUtil.debugConnectionParams(previousNode,"com.teradata.jdbc.TeraDriver");	
	
    stringBuffer.append(TEXT_122);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    }
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    }
    
}

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    

class Column{

	
	String name;
	
	String sqlStmt;
	
	String value;
	
	boolean addCol;
	
	public Column(IMetadataColumn column){
		String columname = column.getOriginalDbColumnName();
		if(columname!=null && columname.trim().length()>0){
			this.name = columname;
		}else{
			this.name = column.getLabel();
		}
		this.sqlStmt = "=?";
		this.value = "?";
		this.addCol =false;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean isAddCol(){
		return this.addCol;
	}
	
	public String getSqlStmt(){
		return this.sqlStmt;
	}
	
	public String getValue(){
		return this.value;
	}
}

if(columnList != null && columnList.size()>0){


StringBuilder insertColName = new StringBuilder();

StringBuilder insertValueStmt = new StringBuilder();

StringBuilder updateSetStmt = new StringBuilder();

List<Column> stmtStructure =  new LinkedList<Column>();

for(IMetadataColumn column:columnList){

	stmtStructure.add(new Column(column));

}

int counterOuter =0;

for(Column colStmt:stmtStructure){
	String suffix = ",";
	
		if(counterOuter==(stmtStructure.size()-1)){
			suffix = "";
		}
		if(colStmt.isAddCol()){
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getSqlStmt()+suffix);
			updateSetStmt.append(colStmt.getName());
			updateSetStmt.append(colStmt.getSqlStmt()+suffix);
		}else{
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getValue()+suffix);
			updateSetStmt.append(colStmt.getName()+"= src\"+ selectQueryColumnsName.split(\",\")[ "+ counterOuter + "].substring(selectQueryColumnsName.split(\",\")["+ counterOuter + "].indexOf(\".\"))+\"" +suffix);
		}
		counterOuter ++;
}

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_139);
    

	if(("INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
	}else if (("UPDATE").equals(dataAction)){
	
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_147);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_148);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    		
	}else if (("DELETE").equals(dataAction)){
	
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    		
	}
	
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
	
}

if(dbtable != null && columnList != null){
	if(("INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_163);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
	}else if(("UPDATE").equals(dataAction)){

	
    stringBuffer.append(TEXT_173);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
	}else if (("DELETE").equals(dataAction)){
		
    stringBuffer.append(TEXT_183);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
	}
}

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    
if(!useExistingConn) {
    
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    
}

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    }
    stringBuffer.append(TEXT_225);
    return stringBuffer.toString();
  }
}

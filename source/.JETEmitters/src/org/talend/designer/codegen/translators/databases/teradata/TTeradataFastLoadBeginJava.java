package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TTeradataFastLoadBeginJava
{
  protected static String nl;
  public static synchronized TTeradataFastLoadBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastLoadBeginJava result = new TTeradataFastLoadBeginJava();
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
  protected final String TEXT_97 = NL + NL + "int nb_line_";
  protected final String TEXT_98 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_99 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_100 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_101 = " = 0;" + NL + "" + NL + "int deletedCount_";
  protected final String TEXT_102 = "=0;" + NL + "int updatedCount_";
  protected final String TEXT_103 = "=0;" + NL + "int insertedCount_";
  protected final String TEXT_104 = "=0;" + NL + "" + NL + "" + NL + "java.lang.Class.forName(\"com.teradata.jdbc.TeraDriver\");" + NL + "String url_";
  protected final String TEXT_105 = " = \"jdbc:teradata://\" + ";
  protected final String TEXT_106 = "+\"/TYPE=FASTLOAD\";" + NL + "" + NL + "String dbProperties_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = ";" + NL + "if(dbProperties_";
  protected final String TEXT_109 = " != null && dbProperties_";
  protected final String TEXT_110 = ".trim().length() > 0) {" + NL + "\turl_";
  protected final String TEXT_111 = " +=\",\"+dbProperties_";
  protected final String TEXT_112 = ";" + NL + "}";
  protected final String TEXT_113 = NL;
  protected final String TEXT_114 = NL + "    int keyCount_";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = ";" + NL + "    if(keyCount_";
  protected final String TEXT_117 = " < 1)" + NL + "    {" + NL + "    \t";
  protected final String TEXT_118 = NL + "    \t\tlog.fatal(\"";
  protected final String TEXT_119 = " - For update or delete, Schema must have a key\");" + NL + "    \t";
  protected final String TEXT_120 = NL + "    \tthrow new RuntimeException(\"For update or delete, Schema must have a key\");" + NL + "    }";
  protected final String TEXT_121 = " " + NL + "" + NL + "String dbUser_";
  protected final String TEXT_122 = " = ";
  protected final String TEXT_123 = ";" + NL + "String dbPwd_";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = ";" + NL;
  protected final String TEXT_126 = "\t";
  protected final String TEXT_127 = NL + "\tlog.info(\"";
  protected final String TEXT_128 = " - Connection attempt to '\" +  url_";
  protected final String TEXT_129 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_130 = " + \"'.\");";
  protected final String TEXT_131 = NL + "java.sql.Connection conn_";
  protected final String TEXT_132 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_133 = ",dbUser_";
  protected final String TEXT_134 = ",dbPwd_";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL + "\tlog.info(\"";
  protected final String TEXT_137 = " - Connection to '\" + url_";
  protected final String TEXT_138 = " + \"' has succeeded.\");";
  protected final String TEXT_139 = NL;
  protected final String TEXT_140 = NL + "java.sql.Statement stmtClear_";
  protected final String TEXT_141 = " = conn_";
  protected final String TEXT_142 = ".createStatement();" + NL + "deletedCount_";
  protected final String TEXT_143 = " = deletedCount_";
  protected final String TEXT_144 = " + stmtClear_";
  protected final String TEXT_145 = ".executeUpdate(\"delete from \" + ";
  protected final String TEXT_146 = ");";
  protected final String TEXT_147 = NL;
  protected final String TEXT_148 = NL + NL + "java.sql.PreparedStatement pstmtInsert_";
  protected final String TEXT_149 = " =null;" + NL + "" + NL + "java.sql.PreparedStatement pstmtUpdate_";
  protected final String TEXT_150 = " =null;" + NL + "" + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_151 = " =null;" + NL;
  protected final String TEXT_152 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_153 = " =null;" + NL + "\t";
  protected final String TEXT_154 = NL + "\t String tableName_";
  protected final String TEXT_155 = " = ";
  protected final String TEXT_156 = ";" + NL + "\t String dbname_";
  protected final String TEXT_157 = " = ";
  protected final String TEXT_158 = ";" + NL + "\t " + NL + "\tif(dbname_";
  protected final String TEXT_159 = " == null || dbname_";
  protected final String TEXT_160 = ".trim().length() == 0) {" + NL + "    \ttableName_";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = ";" + NL + "\t} else {" + NL + "    \ttableName_";
  protected final String TEXT_163 = " = dbname_";
  protected final String TEXT_164 = " + \".\" + ";
  protected final String TEXT_165 = ";" + NL + "\t}";
  protected final String TEXT_166 = "\t" + NL + "\t" + NL + "pstmt_";
  protected final String TEXT_167 = " = conn_";
  protected final String TEXT_168 = ".prepareStatement(\"INSERT INTO \"+tableName_";
  protected final String TEXT_169 = "+\" (";
  protected final String TEXT_170 = ") VALUES (";
  protected final String TEXT_171 = ")\");" + NL + "" + NL + "\t";
  protected final String TEXT_172 = NL + "\t" + NL + "pstmt_";
  protected final String TEXT_173 = " = conn_";
  protected final String TEXT_174 = ".prepareStatement(\"UPDATE \"+tableName_";
  protected final String TEXT_175 = "+\" SET ";
  protected final String TEXT_176 = " WHERE ";
  protected final String TEXT_177 = "\");" + NL + "" + NL + "\t";
  protected final String TEXT_178 = NL + "pstmt_";
  protected final String TEXT_179 = " = conn_";
  protected final String TEXT_180 = ".prepareStatement(\"SELECT COUNT(1) FROM \" + tableName_";
  protected final String TEXT_181 = " + \" WHERE ";
  protected final String TEXT_182 = "\");\t" + NL + "" + NL + "pstmtInsert_";
  protected final String TEXT_183 = " = conn_";
  protected final String TEXT_184 = ".prepareStatement(\"INSERT INTO \"+tableName_";
  protected final String TEXT_185 = "+\" (";
  protected final String TEXT_186 = ") VALUES (";
  protected final String TEXT_187 = ")\");" + NL + "" + NL + "pstmtUpdate_";
  protected final String TEXT_188 = " = conn_";
  protected final String TEXT_189 = ".prepareStatement(\"UPDATE \"+tableName_";
  protected final String TEXT_190 = "+\" SET ";
  protected final String TEXT_191 = " WHERE ";
  protected final String TEXT_192 = "\");" + NL + "\t" + NL + "\t";
  protected final String TEXT_193 = NL + NL + "pstmtUpdate_";
  protected final String TEXT_194 = " = conn_";
  protected final String TEXT_195 = ".prepareStatement(\"UPDATE \"+tableName_";
  protected final String TEXT_196 = "+\" SET ";
  protected final String TEXT_197 = " WHERE ";
  protected final String TEXT_198 = "\");" + NL + "" + NL + "pstmtInsert_";
  protected final String TEXT_199 = " = conn_";
  protected final String TEXT_200 = ".prepareStatement(\"INSERT INTO \"+tableName_";
  protected final String TEXT_201 = "+\" (";
  protected final String TEXT_202 = ") VALUES (";
  protected final String TEXT_203 = ")\");" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_204 = NL + "\t" + NL + "pstmt_";
  protected final String TEXT_205 = " = conn_";
  protected final String TEXT_206 = ".prepareStatement(\"DELETE  FROM \"+tableName_";
  protected final String TEXT_207 = "+\" WHERE ";
  protected final String TEXT_208 = "\");" + NL + "" + NL + "\t";
  protected final String TEXT_209 = NL + "\tint commitCounter_";
  protected final String TEXT_210 = " = 0;";
  protected final String TEXT_211 = NL + NL + "int commitEvery_";
  protected final String TEXT_212 = " = ";
  protected final String TEXT_213 = ";" + NL + "" + NL + "conn_";
  protected final String TEXT_214 = ".setAutoCommit(false);";
  protected final String TEXT_215 = NL;
  protected final String TEXT_216 = NL;

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
	String cid = node.getUniqueName();
    
    String dbServer = ElementParameterParser.getValue(node, "__SERVER__");
    
    String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
    
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    	
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
	
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	
	String dataAction = "INSERT";
	
	String tableAction = "false";
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	log4jCodeGenerateUtil.infoComponentStart(node);
	log4jCodeGenerateUtil.initDbDebugRowBuffer();	

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
List<IMetadataColumn> columnList = null;

List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas !=null && metadatas.size()>0){
	IMetadataTable metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_113);
    
if(!("INSERT").equals(dataAction))
{
    int keyCount = 0;
    for(IMetadataColumn column:columnList)
    {
    	if(column.isKey())
    	{
    		keyCount++;
    	}
    }
    
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    
}

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_125);
    
  	log4jCodeGenerateUtil.debugConnectionParams(node,"com.teradata.jdbc.TeraDriver");	

    stringBuffer.append(TEXT_126);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    
if(("true").equals(tableAction))
{

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
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_146);
    	
}

    stringBuffer.append(TEXT_147);
    if(("INSERT_OR_UPDATE").equals(dataAction)||("UPDATE_OR_INSERT").equals(dataAction)){
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    }else{
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    
}

if(columnList != null && columnList.size()>0){

class Column{

	IMetadataColumn column;
	
	String name;
	
	String sqlStmt;
	
	String value;
	
	boolean addCol;
	
	List<Column> replacement = new ArrayList<Column>();
	
	public Column(String colName,String sqlStmt,boolean addCol){
		this.column = null;
		this.name = colName;
		this.sqlStmt = sqlStmt;
		this.value = "?";
		this.addCol =addCol;
	}
	
	public Column(IMetadataColumn column){
		this.column = column;
		this.name = column.getLabel();
		this.sqlStmt = "=?";
		this.value = "?";
		this.addCol =false;
	}
	
	public boolean isReplaced(){
		return replacement.size()>0;
	}
	
	public void replace(Column column){
		this.replacement.add(column);
	}
	
	public List<Column> getReplacement(){
		return this.replacement;
	}
	
	public void setColumn(IMetadataColumn column){
		this.column = column;
	}
	
	public IMetadataColumn getColumn(){
		return this.column;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
	
	public void setIsAddCol(boolean isadd){
		this.addCol = isadd;
	}
	
	public boolean isAddCol(){
		return this.addCol;
	}
	
	public void setSqlStmt(String sql){
		this.sqlStmt = sql;
	}
	
	public String getSqlStmt(){
		return this.sqlStmt;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}

StringBuilder insertColName = new StringBuilder();

StringBuilder insertValueStmt = new StringBuilder();

StringBuilder updateSetStmt = new StringBuilder();

StringBuilder updateWhereStmt = new StringBuilder();

List<Column> stmtStructure =  new LinkedList<Column>();

for(IMetadataColumn column:columnList){

	stmtStructure.add(new Column(column));

}

int counterOuter =0;
boolean firstKey = true;
boolean firstNoneKey = true;

for(Column colStmt:stmtStructure){
	String suffix = ",";
	
	if(colStmt.isReplaced()){		
		List<Column> replacedColumns = colStmt.getReplacement();
		int counterReplace = 0;
		if(counterOuter==(stmtStructure.size()-1) && counterReplace==(replacedColumns.size()-1) ){
			suffix = "";
		}
		for(Column replacement:replacedColumns){
			insertColName.append(replacement.getName()+suffix);
			insertValueStmt.append(replacement.getSqlStmt()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append(replacement.getName());
				updateSetStmt.append("=" + replacement.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append(replacement.getName());
				updateWhereStmt.append("=" + replacement.getSqlStmt());
			}
			counterReplace++;
		}
	}else{
		if(counterOuter==(stmtStructure.size()-1)){
			suffix = "";
		}
		if(colStmt.isAddCol()){
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getSqlStmt()+suffix);
			updateSetStmt.append(colStmt.getName());
			updateSetStmt.append("=" + colStmt.getSqlStmt()+suffix);
		}else{
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getValue()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append(colStmt.getName());
				updateSetStmt.append(colStmt.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append(colStmt.getName());
				updateWhereStmt.append(colStmt.getSqlStmt());
			}
		}
	}
	counterOuter ++;
}

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_165);
    

	if(("INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_171);
    
	}else if (("UPDATE").equals(dataAction)){
	
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_177);
    		
	}else if (("INSERT_OR_UPDATE").equals(dataAction)){
	
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_192);
    
	}else if (("UPDATE_OR_INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_203);
    
			
	}else if (("DELETE").equals(dataAction)){
	
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_208);
    		
	}

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
	if(!("").equals(commitEvery)&&!("0").equals(commitEvery)){

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
	}
}

    stringBuffer.append(TEXT_215);
    stringBuffer.append(TEXT_216);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TTeradataFastExportMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastExportMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastExportMainJava result = new TTeradataFastExportMainJava();
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
  protected final String TEXT_96 = NL + "\tString tableFullName_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = " + \".\" + ";
  protected final String TEXT_99 = ";";
  protected final String TEXT_100 = NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_101 = " = new java.io.FileWriter(";
  protected final String TEXT_102 = "+";
  protected final String TEXT_103 = "+\".script\");";
  protected final String TEXT_104 = NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_105 = " = new java.io.FileWriter(";
  protected final String TEXT_106 = "+";
  protected final String TEXT_107 = "+\".scr\");";
  protected final String TEXT_108 = NL + "\t" + NL + "\t";
  protected final String TEXT_109 = NL + "\t" + NL + "\tStringBuilder script_";
  protected final String TEXT_110 = " = new StringBuilder();" + NL + "\tfw_";
  protected final String TEXT_111 = ".write(\".LOGTABLE \"+";
  protected final String TEXT_112 = "+\".\"+";
  protected final String TEXT_113 = "+\";\" + \"";
  protected final String TEXT_114 = "\");" + NL + "\tfw_";
  protected final String TEXT_115 = ".write(\".LOGON \"+";
  protected final String TEXT_116 = "+\"/\"";
  protected final String TEXT_117 = " \"\" ";
  protected final String TEXT_118 = "+";
  protected final String TEXT_119 = "+\",\"+";
  protected final String TEXT_120 = "+\";\"+ \"";
  protected final String TEXT_121 = "\");" + NL + "\t" + NL + "\t";
  protected final String TEXT_122 = NL + "\tfw_";
  protected final String TEXT_123 = ".write(\".BEGIN EXPORT SESSIONS 8;\"+\"";
  protected final String TEXT_124 = "\");" + NL + "\t";
  protected final String TEXT_125 = NL + "\t\tfw_";
  protected final String TEXT_126 = ".write(\"SELECT ";
  protected final String TEXT_127 = "CAST(('' ||";
  protected final String TEXT_128 = "\"+\"";
  protected final String TEXT_129 = "\");" + NL + "\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t\tfw_";
  protected final String TEXT_131 = ".write(\"TRIM(COALESCE(CAST(";
  protected final String TEXT_132 = " AS CHAR(";
  protected final String TEXT_133 = ")),'')) || '\"+";
  protected final String TEXT_134 = "+\"' ||\"+\"";
  protected final String TEXT_135 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\t\t\tfw_";
  protected final String TEXT_137 = ".write(\"cast( ";
  protected final String TEXT_138 = " as CHAR(";
  protected final String TEXT_139 = ")),\"+\"";
  protected final String TEXT_140 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\t\tfw_";
  protected final String TEXT_143 = ".write(\"TRIM(COALESCE(CAST(";
  protected final String TEXT_144 = " AS VARCHAR(";
  protected final String TEXT_145 = ")),''))) AS CHAR(";
  protected final String TEXT_146 = "))\"+\"";
  protected final String TEXT_147 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\tfw_";
  protected final String TEXT_149 = ".write(\"cast( ";
  protected final String TEXT_150 = " as CHAR(";
  protected final String TEXT_151 = "))\"+\"";
  protected final String TEXT_152 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t";
  protected final String TEXT_154 = NL + "\t" + NL + "\t\tfw_";
  protected final String TEXT_155 = ".write(\"FROM \"+ ";
  protected final String TEXT_156 = " + \".\" + ";
  protected final String TEXT_157 = "+\";\"+\"";
  protected final String TEXT_158 = "\");" + NL + "\t";
  protected final String TEXT_159 = NL + "\t\tfw_";
  protected final String TEXT_160 = ".write(";
  protected final String TEXT_161 = " +\";\"+\"";
  protected final String TEXT_162 = "\");" + NL + "\t";
  protected final String TEXT_163 = NL + "\t" + NL + "\t";
  protected final String TEXT_164 = NL + "\tfw_";
  protected final String TEXT_165 = ".write(\".EXPORT OUTFILE \\\"\"+";
  protected final String TEXT_166 = "+\".data\\\" FORMAT TEXT mode record;\"+\"";
  protected final String TEXT_167 = "\");" + NL + "\tfw_";
  protected final String TEXT_168 = ".write(\".END EXPORT;\"+\"";
  protected final String TEXT_169 = "\");" + NL + "\tfw_";
  protected final String TEXT_170 = ".write(\".LOGOFF;\"+\"";
  protected final String TEXT_171 = "\");" + NL + "\t" + NL + "\t";
  protected final String TEXT_172 = NL + "\tfw_";
  protected final String TEXT_173 = ".close();" + NL + "\t" + NL + "\t";
  protected final String TEXT_174 = NL + "\tString sb__";
  protected final String TEXT_175 = " = null;" + NL + "\t";
  protected final String TEXT_176 = NL + "\tsb__";
  protected final String TEXT_177 = " = \"fexp < \\\"\"+";
  protected final String TEXT_178 = "+";
  protected final String TEXT_179 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_180 = "+\"\\\" 2>&1\";" + NL + "\tString[] sb_";
  protected final String TEXT_181 = " = {\"cmd\",\"/c\", sb__";
  protected final String TEXT_182 = "};" + NL + "\t";
  protected final String TEXT_183 = NL + "\tsb__";
  protected final String TEXT_184 = " = \"fexp < \"+";
  protected final String TEXT_185 = "+";
  protected final String TEXT_186 = "+\".scr\"+\" > \\\"\"+";
  protected final String TEXT_187 = "+\"\\\" 2>&1\";" + NL + "\tString[] sb_";
  protected final String TEXT_188 = " = {\"sh\",\"-c\",sb__";
  protected final String TEXT_189 = "};" + NL + "\t";
  protected final String TEXT_190 = NL + "\t";
  protected final String TEXT_191 = NL + "\t\tlog.info(\"";
  protected final String TEXT_192 = " - Execting '\" + sb__";
  protected final String TEXT_193 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_194 = NL + "\tfinal Process process_";
  protected final String TEXT_195 = " = Runtime.getRuntime().exec(sb_";
  protected final String TEXT_196 = ");" + NL + "\t" + NL + "\tThread normal_";
  protected final String TEXT_197 = " = new Thread() {" + NL + "\t    public void run() {" + NL + "\t    \ttry {" + NL + "\t    \t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_198 = ".getInputStream()));" + NL + "\t    \t\tString line = \"\";" + NL + "\t    \t\t" + NL + "\t    \t\ttry {" + NL + "\t    \t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t    \t\t\t\tSystem.out.println(line);" + NL + "\t    \t        }" + NL + "\t    \t    } finally {" + NL + "\t    \t         reader.close();" + NL + "\t    \t    }" + NL + "\t        }catch(java.io.IOException ioe) {" + NL + "\t\t\t\t";
  protected final String TEXT_199 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_200 = " - \" + ioe.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_201 = NL + "\t    \t\tioe.printStackTrace();" + NL + "\t    \t}" + NL + "\t    }" + NL + "\t};" + NL + "\tnormal_";
  protected final String TEXT_202 = ".start();" + NL + "\t" + NL + "\tThread error_";
  protected final String TEXT_203 = " = new Thread() {" + NL + "\t\tpublic void run() {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_204 = ".getErrorStream()));" + NL + "\t\t\t\tString line = \"\";" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\tSystem.err.println(line); " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} finally {" + NL + "\t\t\t\t\treader.close();" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_206 = " - \" + ioe.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\t   ioe.printStackTrace();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t};" + NL + "\terror_";
  protected final String TEXT_208 = ".start();" + NL + "\t" + NL + "\tprocess_";
  protected final String TEXT_209 = ".waitFor();" + NL + "\t" + NL + "\tnormal_";
  protected final String TEXT_210 = ".interrupt();" + NL + "\t" + NL + "\terror_";
  protected final String TEXT_211 = ".interrupt();" + NL + "\t" + NL + "\t";
  protected final String TEXT_212 = NL + "\t\tlog.info(\"";
  protected final String TEXT_213 = " - Excute '\" + sb__";
  protected final String TEXT_214 = " + \"' has succeeded.\");" + NL + "\t   \tlog.info(\"";
  protected final String TEXT_215 = " - Has finished.\");" + NL + "\t";
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

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String host = ElementParameterParser.getValue(node, "__HOST__");
String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");
String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
String table= ElementParameterParser.getValue(node, "__TABLE__");
String logDB = ElementParameterParser.getValue(node, "__LOG_DB__");
String logTable = ElementParameterParser.getValue(node, "__LOG_TABLE__");

boolean needHost = ("".equals(host) || "\"\"".equals(host)) ? false : true;
logDB = ("".equals(logDB) || "\"\"".equals(logDB)) ? dbname : logDB;
logTable = ("".equals(logTable) || "\"\"".equals(logTable)) ? table + "+\"_lt\"" : logTable;

boolean useQuery = "true".equals(ElementParameterParser.getValue(node, "__USE_QUERY__"));
String query = ElementParameterParser.getValue(node, "__QUERY__"); 
query = query.replaceAll("\n"," ").replaceAll("\r"," ");

String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String exportedFile= ElementParameterParser.getValue(node, "__EXPORTED_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

//windows line separator as default
String lineSeparator = "\\r\\n";

if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
if(exportedFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	exportedFile = exportedFile.replaceAll("/", "\\\\\\\\");
} else {
	//Unix line separator
	lineSeparator = "\\n";
}

List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		columnList = metadata.getListColumns();
	}
}
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__")); 
log4jCodeGenerateUtil.infoComponentStart(node);

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_99);
    
	if(("Windows").equals(execution)){

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_103);
    
	}else{

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_107);
    
	}

    stringBuffer.append(TEXT_108);
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(logDB);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(logTable);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    if(needHost) {
    stringBuffer.append(host);
    stringBuffer.append(TEXT_116);
    } else {
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_121);
    //Layout---------------------------------------------------------------
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_124);
    if(!useQuery) {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    if(separator.length()>0 && !"\"\"".equals(separator)){
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_129);
    
		if(columnList!=null){
			int counter = 1;
			int columnsLength = 0;
			for(IMetadataColumn column:columnList){	
				if( columnList.size() != counter){	
					if(separator.length()>0 && !"\"\"".equals(separator)){
						columnsLength+=(column.getLength()==null?0:column.getLength())+separator.length();
				
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_135);
    }else{
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    
				} else {
					if(separator.length()>0 && !"\"\"".equals(separator)){
						columnsLength+=(column.getLength()==null?0:column.getLength())+1;
			
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(columnsLength);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_147);
    }else{
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
     } 
				counter++;
			}
		}
		
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_158);
    } else {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    //Export file----------------------------------------------------------
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(exportedFile);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_171);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    //run fexp command----------------------------------------------------
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
	if("Windows".equals(execution)){
	
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    }else{
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    }
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_216);
    return stringBuffer.toString();
  }
}

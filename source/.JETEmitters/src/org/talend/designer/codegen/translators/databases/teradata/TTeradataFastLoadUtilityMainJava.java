package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.lang.StringBuilder;

public class TTeradataFastLoadUtilityMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastLoadUtilityMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastLoadUtilityMainJava result = new TTeradataFastLoadUtilityMainJava();
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
  protected final String TEXT_96 = NL + "String tableFullName_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = " + \".\" + ";
  protected final String TEXT_99 = ";" + NL + "java.io.FileWriter fw_";
  protected final String TEXT_100 = " = new java.io.FileWriter(";
  protected final String TEXT_101 = "+";
  protected final String TEXT_102 = "+\".script\");" + NL;
  protected final String TEXT_103 = NL + NL + "StringBuilder script_";
  protected final String TEXT_104 = " = new StringBuilder();" + NL + "fw_";
  protected final String TEXT_105 = ".write(\"SESSIONS 8;\"+ \"";
  protected final String TEXT_106 = "\");" + NL + "fw_";
  protected final String TEXT_107 = ".write(\"SET RECORD VARTEXT \\\"\"+";
  protected final String TEXT_108 = "+\"\\\";\"+ \"";
  protected final String TEXT_109 = "\");" + NL + "fw_";
  protected final String TEXT_110 = ".write(\"LOGON \"+";
  protected final String TEXT_111 = "+\"/\"+";
  protected final String TEXT_112 = "+\",\"+";
  protected final String TEXT_113 = "+\";\"+ \"";
  protected final String TEXT_114 = "\");";
  protected final String TEXT_115 = NL + "fw_";
  protected final String TEXT_116 = ".write(\"DELETE FROM \"+ ";
  protected final String TEXT_117 = " + \".\" + ";
  protected final String TEXT_118 = " + \" ALL;\"+ \"";
  protected final String TEXT_119 = "\");";
  protected final String TEXT_120 = NL + "fw_";
  protected final String TEXT_121 = ".write(\"DEFINE \"+ \"";
  protected final String TEXT_122 = "\");";
  protected final String TEXT_123 = NL + "\t\tfw_";
  protected final String TEXT_124 = ".write(\"";
  protected final String TEXT_125 = "\"+\" (VARCHAR(";
  protected final String TEXT_126 = ")),\"+ \"";
  protected final String TEXT_127 = "\");" + NL + "\t";
  protected final String TEXT_128 = NL + "\t\t\tfw_";
  protected final String TEXT_129 = ".write(\"";
  protected final String TEXT_130 = "\"+\" (VARCHAR(";
  protected final String TEXT_131 = "))\"+ \"";
  protected final String TEXT_132 = "\");" + NL + "\t";
  protected final String TEXT_133 = NL + "fw_";
  protected final String TEXT_134 = ".write(\"FILE=\"+";
  protected final String TEXT_135 = "+\";\"+ \"";
  protected final String TEXT_136 = "\");" + NL + "fw_";
  protected final String TEXT_137 = ".write(\"BEGIN LOADING \"+ ";
  protected final String TEXT_138 = " + \".\" + ";
  protected final String TEXT_139 = "+\" \"+";
  protected final String TEXT_140 = "+\" CHECKPOINT ";
  protected final String TEXT_141 = ";\"+ \"";
  protected final String TEXT_142 = "\");" + NL + "fw_";
  protected final String TEXT_143 = ".write(\"ERRLIMIT ";
  protected final String TEXT_144 = ";\"+ \"";
  protected final String TEXT_145 = "\");";
  protected final String TEXT_146 = NL + "fw_";
  protected final String TEXT_147 = ".write(\"INSERT INTO \"+ ";
  protected final String TEXT_148 = " + \".\" + ";
  protected final String TEXT_149 = "+\" (";
  protected final String TEXT_150 = ") VALUES (";
  protected final String TEXT_151 = ");\"+ \"";
  protected final String TEXT_152 = "\");";
  protected final String TEXT_153 = NL + "fw_";
  protected final String TEXT_154 = ".write(\"END LOADING;\"+ \"";
  protected final String TEXT_155 = "\");" + NL + "fw_";
  protected final String TEXT_156 = ".write(\"LOGOFF;\"+ \"";
  protected final String TEXT_157 = "\");" + NL;
  protected final String TEXT_158 = NL + "fw_";
  protected final String TEXT_159 = ".close();" + NL;
  protected final String TEXT_160 = NL + "String sb_";
  protected final String TEXT_161 = "= new String(\"fastload -c \"+";
  protected final String TEXT_162 = "+\" < \\\"\"+";
  protected final String TEXT_163 = "+";
  protected final String TEXT_164 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_165 = "+\"\\\" 2>&1\");";
  protected final String TEXT_166 = "\t" + NL + "String sb_";
  protected final String TEXT_167 = "= new String(\"fastload < \\\"\"+";
  protected final String TEXT_168 = "+";
  protected final String TEXT_169 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_170 = "+\"\\\" 2>&1\");";
  protected final String TEXT_171 = NL + "\tlog.info(\"";
  protected final String TEXT_172 = " - Executing '\" + sb_";
  protected final String TEXT_173 = " + \"'.\");";
  protected final String TEXT_174 = NL + "final Process process_";
  protected final String TEXT_175 = " = Runtime.getRuntime().exec(new String[]{\"cmd\",\"/c\",sb_";
  protected final String TEXT_176 = "}); ";
  protected final String TEXT_177 = NL + "final Process process_";
  protected final String TEXT_178 = " = Runtime.getRuntime().exec(new String[]{\"sh\",\"-c\",sb_";
  protected final String TEXT_179 = "});";
  protected final String TEXT_180 = NL + "Thread normal_";
  protected final String TEXT_181 = " = new Thread() {" + NL + "    public void run() {" + NL + "    \ttry {" + NL + "    \t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_182 = ".getInputStream()));" + NL + "    \t\tString line = \"\";" + NL + "    \t\ttry {" + NL + "    \t\t\twhile((line = reader.readLine()) != null) {" + NL + "    \t\t\t   System.out.println(line);" + NL + "    \t        }" + NL + "    \t    } finally {" + NL + "    \t         reader.close();" + NL + "    \t    }" + NL + "        }catch(java.io.IOException ioe) {" + NL + "\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_184 = " - \" + ioe.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_185 = NL + "    \t\tioe.printStackTrace();" + NL + "    \t}" + NL + "    }" + NL + "};" + NL + "normal_";
  protected final String TEXT_186 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_187 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_188 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\tSystem.err.println(line);" + NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t";
  protected final String TEXT_189 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_190 = " - \" + ioe.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_191 = NL + "\t\t   ioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_192 = ".start();" + NL + "" + NL + "process_";
  protected final String TEXT_193 = ".waitFor();" + NL + "" + NL + "normal_";
  protected final String TEXT_194 = ".interrupt();" + NL + "" + NL + "error_";
  protected final String TEXT_195 = ".interrupt();";
  protected final String TEXT_196 = NL + "\tlog.info(\"";
  protected final String TEXT_197 = " - Excute '\" + sb_";
  protected final String TEXT_198 = " + \"' has succeeded.\");";
  protected final String TEXT_199 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_200 = "_EXIT_VALUE\", process_";
  protected final String TEXT_201 = ".exitValue());" + NL;
  protected final String TEXT_202 = NL + "\tif(process_";
  protected final String TEXT_203 = ".exitValue()>=";
  protected final String TEXT_204 = ") {" + NL + "\t\t";
  protected final String TEXT_205 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_206 = " - Fastload returned exit code \"+process_";
  protected final String TEXT_207 = ".exitValue());" + NL + "\t\t";
  protected final String TEXT_208 = NL + "\t\tthrow new RuntimeException(\"Fastload returned exit code \"+process_";
  protected final String TEXT_209 = ".exitValue());" + NL + "\t}";
  protected final String TEXT_210 = NL;
  protected final String TEXT_211 = NL + "   \tlog.info(\"";
  protected final String TEXT_212 = " - Has finished.\");";
  protected final String TEXT_213 = NL;

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

String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");
String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
String table= ElementParameterParser.getValue(node, "__TABLE__");

String dbhost= ElementParameterParser.getValue(node, "__HOST__");
String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String loadFile= ElementParameterParser.getValue(node, "__LOAD_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

boolean returnCodeDie= ElementParameterParser.getValue(node, "__RETURN_CODE_DIE__").equals("true");
String returnCode= ElementParameterParser.getValue(node, "__RETURN_CODE__");

String checkPoint= ElementParameterParser.getValue(node, "__CHECK_POINT__");

String errorFiles= ElementParameterParser.getValue(node, "__ERRORFILES__");

String defineCharset = ElementParameterParser.getValue(node, "__DEFINE_CHARSET__");
String charset = ElementParameterParser.getValue(node, "__CHARSET__");

String errLimit = ElementParameterParser.getValue(node, "__ERRLIMIT__");

String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");

if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
//windows line separator as default
String lineSeparator = "\\r\\n";
if(loadFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	loadFile = loadFile.replaceAll("/", "\\\\\\\\");
}else {
	//Unix line separator
	lineSeparator = "\\n";
}
String dbmsId = "teradata_id";

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_102);
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    if(dbhost!=null && !"\"\"".equals(dbhost)){
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_114);
    
if(("CLEAR").equals(tableAction)){

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_119);
    
}

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_122);
    //Layout---------------------------------------------------------------
    
if(columnList!=null){
	int counter = 1;
	for(IMetadataColumn column:columnList){	
		if( columnList.size() != counter){	
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_127);
    
		} else {
	
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_132);
     	}
		counter++;
	}
}

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(loadFile);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(errorFiles);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(checkPoint);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(errLimit);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_145);
    //SQL statements-------------------------------------------------------
    
StringBuilder insertColSQL = new StringBuilder();
StringBuilder insertValueSQL = new StringBuilder();
if(columnList!=null){
	String columnName = "";
 	for(IMetadataColumn column:columnList){	
 		columnName= column.getOriginalDbColumnName();
 		if(insertColSQL.length()>0){
 			insertColSQL.append(",");
 		}
 		insertColSQL.append(columnName);
 		
 		if(insertValueSQL.length()>0){
 			insertValueSQL.append(",");
 		}
 		insertValueSQL.append(":").append(columnName);
	}
}

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(insertColSQL.toString());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(insertValueSQL.toString());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_152);
    //Import file----------------------------------------------------------
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_157);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    //run fastload command----------------------------------------------------
    if("true".equals(defineCharset)) {
	if(!("".equals(charset))) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_165);
    }} else {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_170);
    }
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    }
    if(("Windows").equals(execution)){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    }else{
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    }
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    
if(returnCodeDie) {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(returnCode);
    stringBuffer.append(TEXT_204);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    	
}

    stringBuffer.append(TEXT_210);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    }
    stringBuffer.append(TEXT_213);
    return stringBuffer.toString();
  }
}

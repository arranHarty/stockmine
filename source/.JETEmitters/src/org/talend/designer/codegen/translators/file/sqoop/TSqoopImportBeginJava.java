package org.talend.designer.codegen.translators.file.sqoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSqoopImportBeginJava
{
  protected static String nl;
  public static synchronized TSqoopImportBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSqoopImportBeginJava result = new TSqoopImportBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = " " + NL + "" + NL + "" + NL + "//call the cmd part" + NL + "Runtime runtime_";
  protected final String TEXT_5 = " = Runtime.getRuntime();" + NL + "" + NL + "String[] cmd_";
  protected final String TEXT_6 = " = new String[] {\"sqoop\", \"import\", \"--connect\", ";
  protected final String TEXT_7 = ", \"--username\", ";
  protected final String TEXT_8 = ", \"--password\", ";
  protected final String TEXT_9 = ",\"--connection-manager\",\"org.apache.sqoop.teradata.TeradataConnManager\"";
  protected final String TEXT_10 = ", \"--query\", ";
  protected final String TEXT_11 = NL + "\t, \"--table\", ";
  protected final String TEXT_12 = ", \"--columns\", \"";
  protected final String TEXT_13 = "\"";
  protected final String TEXT_14 = ", \"--where\", ";
  protected final String TEXT_15 = ", \"--verbose\"";
  protected final String TEXT_16 = ", \"--append\"";
  protected final String TEXT_17 = ", \"--direct\"";
  protected final String TEXT_18 = ", \"--compress\"";
  protected final String TEXT_19 = ", \"--target-dir\", ";
  protected final String TEXT_20 = ", \"--as-sequencefile\"";
  protected final String TEXT_21 = ", \"--mysql-delimiters\"";
  protected final String TEXT_22 = ", \"--num-mappers\", ";
  protected final String TEXT_23 = ", \"--split-by\", ";
  protected final String TEXT_24 = " " + NL + "\t\t\t,\"";
  protected final String TEXT_25 = "\", ";
  protected final String TEXT_26 = " ";
  protected final String TEXT_27 = " " + NL + "\t\t\t,\"";
  protected final String TEXT_28 = "\" ";
  protected final String TEXT_29 = NL + "\t\t\t,\"--\"";
  protected final String TEXT_30 = " " + NL + "\t\t\t,\"--";
  protected final String TEXT_31 = "\", \"\"+";
  protected final String TEXT_32 = " ";
  protected final String TEXT_33 = NL + NL + "};" + NL + "final Process ps_";
  protected final String TEXT_34 = " = runtime_";
  protected final String TEXT_35 = ".exec(cmd_";
  protected final String TEXT_36 = ");" + NL + "" + NL + "java.lang.StringBuilder sb_";
  protected final String TEXT_37 = " = null;" + NL + "byte[] byteArray_";
  protected final String TEXT_38 = " = new byte[1024];" + NL + "int len_";
  protected final String TEXT_39 = " = 0;" + NL + "" + NL + "java.io.InputStream errorStream_";
  protected final String TEXT_40 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_41 = ".getErrorStream());" + NL + "sb_";
  protected final String TEXT_42 = " = new java.lang.StringBuilder();" + NL + "while ((len_";
  protected final String TEXT_43 = " = errorStream_";
  protected final String TEXT_44 = ".read(byteArray_";
  protected final String TEXT_45 = ")) != -1) {" + NL + "\tString line_";
  protected final String TEXT_46 = " = new String(byteArray_";
  protected final String TEXT_47 = ", 0, len_";
  protected final String TEXT_48 = ", \"ISO-8859-1\");";
  protected final String TEXT_49 = NL + "\t    System.err.println(line_";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\tsb_";
  protected final String TEXT_52 = ".append(line_";
  protected final String TEXT_53 = ");" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_54 = "_ERROR_MESSAGE\", sb_";
  protected final String TEXT_55 = ".toString());" + NL + "" + NL + "byteArray_";
  protected final String TEXT_56 = " = new byte[1024];" + NL + "len_";
  protected final String TEXT_57 = " = 0;" + NL + "java.io.InputStream inputStream_";
  protected final String TEXT_58 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_59 = ".getInputStream());" + NL + "sb_";
  protected final String TEXT_60 = " = new java.lang.StringBuilder();" + NL + "while ((len_";
  protected final String TEXT_61 = " = inputStream_";
  protected final String TEXT_62 = ".read(byteArray_";
  protected final String TEXT_63 = ")) != -1) {" + NL + "\tString line_";
  protected final String TEXT_64 = " = new String(byteArray_";
  protected final String TEXT_65 = ", 0, len_";
  protected final String TEXT_66 = ", \"ISO-8859-1\");";
  protected final String TEXT_67 = NL + "\t    System.out.println(line_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\tsb_";
  protected final String TEXT_70 = ".append(line_";
  protected final String TEXT_71 = ");" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_72 = "_OUTPUT_MESSAGE\", sb_";
  protected final String TEXT_73 = ".toString());";
  protected final String TEXT_74 = NL + "\t\t";
  protected final String TEXT_75 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_76 = ");" + NL + "\t" + NL + "\tjava.util.List<String> lColumns_";
  protected final String TEXT_77 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_78 = NL + "\t\tlColumns_";
  protected final String TEXT_79 = ".add(";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\torg.apache.hadoop.conf.Configuration configuration_";
  protected final String TEXT_82 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\tconfiguration_";
  protected final String TEXT_83 = ".set(\"";
  protected final String TEXT_84 = "\", ";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "\t\tconfiguration_";
  protected final String TEXT_87 = ".set(\"mapreduce.framework.name\", \"yarn\");" + NL + "\t\tconfiguration_";
  protected final String TEXT_88 = ".set(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\t\tconfiguration_";
  protected final String TEXT_91 = ".set(\"mapred.job.tracker\", ";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "        configuration_";
  protected final String TEXT_94 = ".set(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_95 = ");" + NL + "        configuration_";
  protected final String TEXT_96 = ".set(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_99 = ".set(";
  protected final String TEXT_100 = " ,";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\tconfiguration_";
  protected final String TEXT_103 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_104 = ");" + NL + "\t\tconfiguration_";
  protected final String TEXT_105 = ".set(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + NL + "\torg.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_111 = " = org.apache.hadoop.fs.FileSystem.get(configuration_";
  protected final String TEXT_112 = ");" + NL + "\tcom.cloudera.sqoop.tool.SqoopTool sqoopTool_";
  protected final String TEXT_113 = " = com.cloudera.sqoop.tool.SqoopTool.getTool(\"import\");" + NL + "" + NL + "\tcom.cloudera.sqoop.SqoopOptions sqoopOptions_";
  protected final String TEXT_114 = " = new com.cloudera.sqoop.SqoopOptions(configuration_";
  protected final String TEXT_115 = ");" + NL + "\t" + NL + "\tsqoopOptions_";
  protected final String TEXT_116 = ".setConnectString(";
  protected final String TEXT_117 = "); // __CONNECTION__" + NL + "\tsqoopOptions_";
  protected final String TEXT_118 = ".setUsername(";
  protected final String TEXT_119 = "); // __USERNAME__" + NL + "\tsqoopOptions_";
  protected final String TEXT_120 = ".setPassword(";
  protected final String TEXT_121 = "); // __PASSWORD__" + NL + "\t" + NL + "\t";
  protected final String TEXT_122 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_123 = ".setSqlQuery(";
  protected final String TEXT_124 = ");" + NL + "\t";
  protected final String TEXT_125 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_126 = ".setTableName(";
  protected final String TEXT_127 = "); // __TABLE__" + NL + "\t\t";
  protected final String TEXT_128 = "sqoopOptions_";
  protected final String TEXT_129 = ".setColumns(lColumns_";
  protected final String TEXT_130 = ".toArray(new String[lColumns_";
  protected final String TEXT_131 = ".size()]));";
  protected final String TEXT_132 = NL + "\t\t";
  protected final String TEXT_133 = "sqoopOptions_";
  protected final String TEXT_134 = ".setWhereClause(";
  protected final String TEXT_135 = "); // __WHERE__";
  protected final String TEXT_136 = NL + "\t";
  protected final String TEXT_137 = NL + "\t\t\tsqoopOptions_";
  protected final String TEXT_138 = ".setVerbose(true);";
  protected final String TEXT_139 = NL + "\t";
  protected final String TEXT_140 = "sqoopOptions_";
  protected final String TEXT_141 = ".setAppendMode(true);";
  protected final String TEXT_142 = NL + "\t";
  protected final String TEXT_143 = "sqoopOptions_";
  protected final String TEXT_144 = ".setDirectMode(true);";
  protected final String TEXT_145 = NL + "\t";
  protected final String TEXT_146 = "sqoopOptions_";
  protected final String TEXT_147 = ".setUseCompression(true);";
  protected final String TEXT_148 = NL + "\t";
  protected final String TEXT_149 = "sqoopOptions_";
  protected final String TEXT_150 = ".setTargetDir(";
  protected final String TEXT_151 = ");";
  protected final String TEXT_152 = NL + "\t";
  protected final String TEXT_153 = "sqoopOptions_";
  protected final String TEXT_154 = ".setFileLayout(com.cloudera.sqoop.SqoopOptions.FileLayout.SequenceFile);";
  protected final String TEXT_155 = "sqoopOptions_";
  protected final String TEXT_156 = ".setFileLayout(com.cloudera.sqoop.SqoopOptions.FileLayout.TextFile);";
  protected final String TEXT_157 = NL + "\t";
  protected final String TEXT_158 = "sqoopOptions_";
  protected final String TEXT_159 = ".setNumMappers(Integer.valueOf(";
  protected final String TEXT_160 = "));";
  protected final String TEXT_161 = NL + "\t";
  protected final String TEXT_162 = "sqoopOptions_";
  protected final String TEXT_163 = ".setSplitByCol(";
  protected final String TEXT_164 = ");";
  protected final String TEXT_165 = NL + "\t" + NL + "\tjava.util.Properties additionalProperties_";
  protected final String TEXT_166 = " = new java.util.Properties();";
  protected final String TEXT_167 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_168 = ".put(";
  protected final String TEXT_169 = ", \"\"+";
  protected final String TEXT_170 = ".codePointAt(0)); ";
  protected final String TEXT_171 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_172 = ".put(";
  protected final String TEXT_173 = ", ";
  protected final String TEXT_174 = "); ";
  protected final String TEXT_175 = NL + "\tsqoopOptions_";
  protected final String TEXT_176 = ".loadProperties(additionalProperties_";
  protected final String TEXT_177 = ");";
  protected final String TEXT_178 = NL + "\t\tcom.cloudera.sqoop.Sqoop sqoop_";
  protected final String TEXT_179 = " = new com.cloudera.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_180 = ", configuration_";
  protected final String TEXT_181 = ", sqoopOptions_";
  protected final String TEXT_182 = ");";
  protected final String TEXT_183 = NL + "\t\torg.apache.sqoop.Sqoop sqoop_";
  protected final String TEXT_184 = " = new org.apache.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_185 = ", configuration_";
  protected final String TEXT_186 = ", sqoopOptions_";
  protected final String TEXT_187 = ");";
  protected final String TEXT_188 = NL + "\tint result_";
  protected final String TEXT_189 = " = sqoop_";
  protected final String TEXT_190 = ".run(null);" + NL + "\tif(result_";
  protected final String TEXT_191 = " != 0) {" + NL + "\t\tthrow new Exception(\"The Sqoop import job has failed\");" + NL + "\t}" + NL + "\t" + NL + "    String currentClientPathSeparator_";
  protected final String TEXT_192 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "    if(currentClientPathSeparator_";
  protected final String TEXT_193 = "!=null) {" + NL + "    \tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_194 = ");" + NL + "    \tglobalMap.put(\"current_client_path_separator\", null);" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	boolean useCommandLine = "true".equals(ElementParameterParser.getValue(node,"__USE_COMMANDLINE__"));
	
	if(useCommandLine) {

    stringBuffer.append(TEXT_2);
    
	boolean useColumns = "true".equals(ElementParameterParser.getValue(node,"__USE_COLUMNS__"));
	List<Map<String, String>> columns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__COLUMNS__");
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String username = ElementParameterParser.getValue(node,"__USERNAME__");
	String password = ElementParameterParser.getValue(node,"__PASSWORD__");
	boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
	boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
	boolean append = "true".equals(ElementParameterParser.getValue(node,"__APPEND__"));
	boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
	boolean compress = "true".equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
	boolean mysqlDelimiters = "true".equals(ElementParameterParser.getValue(node,"__MYSQL_DELIMITERS__"));
	String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
	boolean useTarget = "true".equals(ElementParameterParser.getValue(node,"__USE_TARGET__"));
	String target = ElementParameterParser.getValue(node,"__TARGET__");
	boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
	String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
	List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL__");
	boolean isUseSpeedParallel = "true".equals(ElementParameterParser.getValue(node,"__USE_SPEED_PARALLEL__"));
	List<Map<String,String>> specificParams= (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__SPECIFIC_PARAMS__");
	
	boolean useWhere = "true".equals(ElementParameterParser.getValue(node,"__USE_WHERE__"));
	String where = ElementParameterParser.getValue(node,"__WHERE__");
	where = where.substring(1, where.length()-1);
	where = "\"\\\""+where+"\\\"\"";
	
	boolean useQuery = "true".equals(ElementParameterParser.getValue(node,"__USE_QUERY__"));
	String query = ElementParameterParser.getValue(node,"__QUERY__");
	query = query.replaceAll("\n"," ");
	query = query.replaceAll("\r"," ");
	
	boolean useSplit = "true".equals(ElementParameterParser.getValue(node,"__USE_SPLIT__"));
	String split = ElementParameterParser.getValue(node,"__SPLIT__");

    stringBuffer.append(TEXT_3);
    
String sColumns = "\\\"";
int size = columns.size();
int current = 0;
for (Map<String, String> row : columns) {
    String column = row.get("COLUMN");
    column = column.substring(1, column.length()-1);
    if (size-1 == current) {
        sColumns += column;
    } else {
        sColumns += column + ",";
    }
    current++;
}
sColumns += "\\\"";

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(password);
    if(isUseSpeedParallel){
    stringBuffer.append(TEXT_9);
    }
    if(useQuery){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(query);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(table);
    if(useColumns){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sColumns);
    stringBuffer.append(TEXT_13);
    }
    if(useWhere){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(where);
    }
    }
    if(printLog && verbose){
    stringBuffer.append(TEXT_15);
    }
    if(append){
    stringBuffer.append(TEXT_16);
    }
    if(direct){
    stringBuffer.append(TEXT_17);
    }
    if(compress){
    stringBuffer.append(TEXT_18);
    }
    if(useTarget || useQuery){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(target);
    }
    if(fileFormat.equals("sequencefile")){
    stringBuffer.append(TEXT_20);
    }
    if(mysqlDelimiters){
    stringBuffer.append(TEXT_21);
    }
    if(useMappers){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(mappers);
    }
    if(useSplit){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(split);
    }
    
boolean isNull=false; 
if(additionalList != null){ 
	for(Map<String,String> additionalMap : additionalList){ 
		isNull=false; 
	 	if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
	 		isNull=true; 
	 	} 
	 	if(!isNull) { 

    stringBuffer.append(TEXT_24);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_26);
     
		} else { 

    stringBuffer.append(TEXT_27);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_28);
     
		} 
	} 
} 
if(isUseSpeedParallel && specificParams!=null){
	boolean isFirstParam=true;
	for(Map<String,String> specificArg : specificParams){ 
		isNull=false; 
	 	if(specificArg.get("SPECIFIC_PARAM_VALUE")==null || "".equals(specificArg.get("SPECIFIC_PARAM_VALUE"))) { 
	 		isNull=true; 
	 	} 
	 	if(!isNull) { 
	 		if(isFirstParam){

    stringBuffer.append(TEXT_29);
    
				isFirstParam=false;
			}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(specificArg.get("SPECIFIC_PARAM"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(specificArg.get("SPECIFIC_PARAM_VALUE"));
    stringBuffer.append(TEXT_32);
     
		} 
	} 
} 

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
	if(printLog){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
	}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
	if(printLog){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
	}

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
	} else {

    stringBuffer.append(TEXT_74);
    
	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	boolean isCustom = "CUSTOM".equals(distribution);
	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");
	
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
	
	String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String jobtracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean useColumns = "true".equals(ElementParameterParser.getValue(node,"__USE_COLUMNS__"));
	List<Map<String, String>> columns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__COLUMNS__");
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String username = ElementParameterParser.getValue(node,"__USERNAME__");
	String password = ElementParameterParser.getValue(node,"__PASSWORD__");
	boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
	boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
	boolean append = "true".equals(ElementParameterParser.getValue(node,"__APPEND__"));
	boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
	boolean compress = "true".equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
	String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
	boolean useTarget = "true".equals(ElementParameterParser.getValue(node,"__USE_TARGET__"));
	String target = ElementParameterParser.getValue(node,"__TARGET__");
	boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
	String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
	List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL_JAVA__");
	
	boolean useWhere = "true".equals(ElementParameterParser.getValue(node,"__USE_WHERE__"));
	String where = ElementParameterParser.getValue(node,"__WHERE__");
	//where = where.substring(1, where.length()-1);
	//where = "\"\\\""+where+"\\\"\"";
	
	boolean useQuery = "true".equals(ElementParameterParser.getValue(node,"__USE_QUERY__"));
	String query = ElementParameterParser.getValue(node,"__QUERY__");
	query = query.replaceAll("\n"," ");
	query = query.replaceAll("\r"," ");
	
	boolean useSplit = "true".equals(ElementParameterParser.getValue(node,"__USE_SPLIT__"));
	String split = ElementParameterParser.getValue(node,"__SPLIT__");
	
	String fsDefalutName = "fs.default.name";
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_75);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
	for (Map<String, String> row : columns) {
		String column = row.get("COLUMN");

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_80);
    
	}
	
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_85);
    
	if((isCustom && useYarn) || (!isCustom && ("PIVOTAL_HD_1_0_1".equals(version) || "HDP_2_0".equals(version) || "Cloudera_CDH4_YARN".equals(version)))) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_89);
    
	} else {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(jobtracker);
    stringBuffer.append(TEXT_92);
    
	}
    if(!isCustom && ("HDP_1_2".equals(version) || "HDP_1_3".equals(version))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_97);
    
    }

	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_101);
     
		}
	}
	if(("HDP_1_0".equals(version) || "HDP_1_2".equals(version) || "HDP_1_3".equals(version) || "Cloudera_CDH4".equals(version) || isCustom) && useKrb) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
		String jobTrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");
		boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
		String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
		String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(jobTrackerPrincipal);
    stringBuffer.append(TEXT_106);
    
		if(useKeytab) {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_109);
    
		}
	}

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_121);
    if(useQuery){
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_124);
    } else {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_127);
    if(useColumns){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    if(useWhere){
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(where);
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    }
    	
	if(!(("HDP_1_0".equals(version) || "Cloudera_CDH3".equals(version) || "MAPR1".equals(version)) && !isCustom)) {
		if(printLog && verbose){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
		}
	}

    stringBuffer.append(TEXT_139);
    if(append){
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    if(direct){
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    }
    stringBuffer.append(TEXT_145);
    if(compress){
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    if(useTarget || useQuery){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(target);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_152);
    if(fileFormat.equals("sequencefile")){
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    } else {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    if(useMappers){
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(mappers);
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    if(useSplit){
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(split);
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
	if(additionalList != null){ 
		for(Map<String,String> additionalMap : additionalList){
			if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
				break; 
			}
			if(additionalMap.get("ADDITIONAL_ARGUMENT").contains("delimiters")) {
				

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_170);
    
			} else {

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_174);
    
			}
		} 
	} 

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
	if(("Cloudera_CDH3".equals(version) || "MAPR1".equals(version)) && !isCustom) {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
	} else {

    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
	}

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
	}

    return stringBuffer.toString();
  }
}

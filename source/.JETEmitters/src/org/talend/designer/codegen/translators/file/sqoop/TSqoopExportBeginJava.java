package org.talend.designer.codegen.translators.file.sqoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSqoopExportBeginJava
{
  protected static String nl;
  public static synchronized TSqoopExportBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSqoopExportBeginJava result = new TSqoopExportBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "//call the cmd part" + NL + "Runtime runtime_";
  protected final String TEXT_4 = " = Runtime.getRuntime();" + NL + "" + NL + "String[] cmd_";
  protected final String TEXT_5 = " = new String[] {\"sqoop\", \"export\", \"--connect\", ";
  protected final String TEXT_6 = ", \"--table\", ";
  protected final String TEXT_7 = ", \"--username\", ";
  protected final String TEXT_8 = ", \"--password\", ";
  protected final String TEXT_9 = ", \"--export-dir\", ";
  protected final String TEXT_10 = ",\"--connection-manager\",\"org.apache.sqoop.teradata.TeradataConnManager\"";
  protected final String TEXT_11 = ", \"--verbose\"";
  protected final String TEXT_12 = ", \"--direct\"";
  protected final String TEXT_13 = ", \"--as-sequencefile\"";
  protected final String TEXT_14 = ", \"--mysql-delimiters\"";
  protected final String TEXT_15 = ", \"--num-mappers\", ";
  protected final String TEXT_16 = " " + NL + "            ,\"";
  protected final String TEXT_17 = "\", ";
  protected final String TEXT_18 = " ";
  protected final String TEXT_19 = " " + NL + "            ,\"";
  protected final String TEXT_20 = "\" ";
  protected final String TEXT_21 = NL + "\t\t\t,\"--\"";
  protected final String TEXT_22 = " " + NL + "\t\t\t,\"--";
  protected final String TEXT_23 = "\", \"\"+";
  protected final String TEXT_24 = " ";
  protected final String TEXT_25 = NL + "};" + NL + "" + NL + "final Process ps_";
  protected final String TEXT_26 = " = runtime_";
  protected final String TEXT_27 = ".exec(cmd_";
  protected final String TEXT_28 = ");" + NL + "" + NL + "java.lang.StringBuilder sb_";
  protected final String TEXT_29 = " = null;" + NL + "byte[] byteArray_";
  protected final String TEXT_30 = " = new byte[1024];" + NL + "int len_";
  protected final String TEXT_31 = " = 0;" + NL + "" + NL + "java.io.InputStream errorStream_";
  protected final String TEXT_32 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_33 = ".getErrorStream());" + NL + "sb_";
  protected final String TEXT_34 = " = new java.lang.StringBuilder();" + NL + "while ((len_";
  protected final String TEXT_35 = " = errorStream_";
  protected final String TEXT_36 = ".read(byteArray_";
  protected final String TEXT_37 = ")) != -1) {" + NL + "    String line_";
  protected final String TEXT_38 = " = new String(byteArray_";
  protected final String TEXT_39 = ", 0, len_";
  protected final String TEXT_40 = ", \"ISO-8859-1\");";
  protected final String TEXT_41 = NL + "        System.err.println(line_";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "    sb_";
  protected final String TEXT_44 = ".append(line_";
  protected final String TEXT_45 = ");" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_46 = "_ERROR_MESSAGE\", sb_";
  protected final String TEXT_47 = ".toString());" + NL + "" + NL + "byteArray_";
  protected final String TEXT_48 = " = new byte[1024];" + NL + "len_";
  protected final String TEXT_49 = " = 0;" + NL + "java.io.InputStream inputStream_";
  protected final String TEXT_50 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_51 = ".getInputStream());" + NL + "sb_";
  protected final String TEXT_52 = " = new java.lang.StringBuilder();" + NL + "while ((len_";
  protected final String TEXT_53 = " = inputStream_";
  protected final String TEXT_54 = ".read(byteArray_";
  protected final String TEXT_55 = ")) != -1) {" + NL + "    String line_";
  protected final String TEXT_56 = " = new String(byteArray_";
  protected final String TEXT_57 = ", 0, len_";
  protected final String TEXT_58 = ", \"ISO-8859-1\");";
  protected final String TEXT_59 = NL + "        System.out.println(line_";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "    sb_";
  protected final String TEXT_62 = ".append(line_";
  protected final String TEXT_63 = ");" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_64 = "_OUTPUT_MESSAGE\", sb_";
  protected final String TEXT_65 = ".toString());";
  protected final String TEXT_66 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_67 = ");" + NL + "\t" + NL + "\torg.apache.hadoop.conf.Configuration configuration_";
  protected final String TEXT_68 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\tconfiguration_";
  protected final String TEXT_69 = ".set(\"";
  protected final String TEXT_70 = "\", ";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "    \tconfiguration_";
  protected final String TEXT_73 = ".set(\"mapreduce.framework.name\", \"yarn\");" + NL + "    \tconfiguration_";
  protected final String TEXT_74 = ".set(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\t\tconfiguration_";
  protected final String TEXT_77 = ".set(\"mapred.job.tracker\", ";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "        configuration_";
  protected final String TEXT_80 = ".set(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_81 = ");" + NL + "        configuration_";
  protected final String TEXT_82 = ".set(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_85 = ".set(";
  protected final String TEXT_86 = " ,";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\t\tconfiguration_";
  protected final String TEXT_89 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_90 = ");" + NL + "\t\tconfiguration_";
  protected final String TEXT_91 = ".set(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_94 = ", ";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\torg.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_97 = " = org.apache.hadoop.fs.FileSystem.get(configuration_";
  protected final String TEXT_98 = ");" + NL + "\tcom.cloudera.sqoop.tool.SqoopTool sqoopTool_";
  protected final String TEXT_99 = " = com.cloudera.sqoop.tool.SqoopTool.getTool(\"export\");" + NL + "" + NL + "\tcom.cloudera.sqoop.SqoopOptions sqoopOptions_";
  protected final String TEXT_100 = " = new com.cloudera.sqoop.SqoopOptions(configuration_";
  protected final String TEXT_101 = ");" + NL + "\t" + NL + "\tsqoopOptions_";
  protected final String TEXT_102 = ".setConnectString(";
  protected final String TEXT_103 = "); // __CONNECTION__" + NL + "\tsqoopOptions_";
  protected final String TEXT_104 = ".setTableName(";
  protected final String TEXT_105 = ");" + NL + "\tsqoopOptions_";
  protected final String TEXT_106 = ".setExportDir(";
  protected final String TEXT_107 = ");" + NL + "\tsqoopOptions_";
  protected final String TEXT_108 = ".setUsername(";
  protected final String TEXT_109 = "); // __USERNAME__" + NL + "\tsqoopOptions_";
  protected final String TEXT_110 = ".setPassword(";
  protected final String TEXT_111 = "); // __PASSWORD__" + NL + "\t\t";
  protected final String TEXT_112 = NL + "\t\t\tsqoopOptions_";
  protected final String TEXT_113 = ".setVerbose(true);";
  protected final String TEXT_114 = NL + "\t";
  protected final String TEXT_115 = "sqoopOptions_";
  protected final String TEXT_116 = ".setDirectMode(true);";
  protected final String TEXT_117 = NL + "\t";
  protected final String TEXT_118 = "sqoopOptions_";
  protected final String TEXT_119 = ".setNumMappers(Integer.valueOf(";
  protected final String TEXT_120 = "));";
  protected final String TEXT_121 = NL + "\t" + NL + "\tjava.util.Properties additionalProperties_";
  protected final String TEXT_122 = " = new java.util.Properties();";
  protected final String TEXT_123 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_124 = ".put(";
  protected final String TEXT_125 = ", \"\"+";
  protected final String TEXT_126 = ".codePointAt(0)); ";
  protected final String TEXT_127 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_128 = ".put(";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = "); ";
  protected final String TEXT_131 = NL + "\tsqoopOptions_";
  protected final String TEXT_132 = ".loadProperties(additionalProperties_";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\t\tcom.cloudera.sqoop.Sqoop sqoop_";
  protected final String TEXT_135 = " = new com.cloudera.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_136 = ", configuration_";
  protected final String TEXT_137 = ", sqoopOptions_";
  protected final String TEXT_138 = ");";
  protected final String TEXT_139 = NL + "\t\torg.apache.sqoop.Sqoop sqoop_";
  protected final String TEXT_140 = " = new org.apache.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_141 = ", configuration_";
  protected final String TEXT_142 = ", sqoopOptions_";
  protected final String TEXT_143 = ");";
  protected final String TEXT_144 = NL + "\tint result_";
  protected final String TEXT_145 = " = sqoop_";
  protected final String TEXT_146 = ".run(null);" + NL + "\tif(result_";
  protected final String TEXT_147 = " != 0) {" + NL + "\t\tthrow new Exception(\"The Sqoop export job has failed\");" + NL + "\t}" + NL + "\t" + NL + "    String currentClientPathSeparator_";
  protected final String TEXT_148 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "    if(currentClientPathSeparator_";
  protected final String TEXT_149 = "!=null) {" + NL + "    \tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_150 = ");" + NL + "    \tglobalMap.put(\"current_client_path_separator\", null);" + NL + "    }";

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
    
    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
    String table = ElementParameterParser.getValue(node,"__TABLE__");
    String username = ElementParameterParser.getValue(node,"__USERNAME__");
    String password = ElementParameterParser.getValue(node,"__PASSWORD__");
    String exportDir = ElementParameterParser.getValue(node,"__EXPORT_DIR__");
    boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
    boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
    boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
    boolean mysqlDelimiters = "true".equals(ElementParameterParser.getValue(node,"__MYSQL_DELIMITERS__"));
    boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
    String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
    String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
    List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL__");
    boolean isUseSpeedParallel = "true".equals(ElementParameterParser.getValue(node,"__USE_SPEED_PARALLEL__"));
	List<Map<String,String>> specificParams= (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__SPECIFIC_PARAMS__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(exportDir);
    if(isUseSpeedParallel){
    stringBuffer.append(TEXT_10);
    }
    if(printLog && verbose){
    stringBuffer.append(TEXT_11);
    }
    if(direct){
    stringBuffer.append(TEXT_12);
    }
    if(fileFormat.equals("sequencefile")){
    stringBuffer.append(TEXT_13);
    }
    if(mysqlDelimiters){
    stringBuffer.append(TEXT_14);
    }
    if(useMappers){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(mappers);
    }
    
boolean isNull=false; 
if(additionalList != null){ 
    for(Map<String,String> additionalMap : additionalList){ 
        isNull=false; 
        if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
            isNull=true; 
        } 
        if(!isNull) { 

    stringBuffer.append(TEXT_16);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_18);
     
        } else { 

    stringBuffer.append(TEXT_19);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_20);
     
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

    stringBuffer.append(TEXT_21);
    
				isFirstParam=false;
			}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(specificArg.get("SPECIFIC_PARAM"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(specificArg.get("SPECIFIC_PARAM_VALUE"));
    stringBuffer.append(TEXT_24);
     
		} 
	} 
} 

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
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
    
    if(printLog){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
    }

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
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
    
    if(printLog){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
    }

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
    } else {

    
	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	boolean isCustom = "CUSTOM".equals(distribution);
	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");
	
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
	
	String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String jobtracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String username = ElementParameterParser.getValue(node,"__USERNAME__");
	String password = ElementParameterParser.getValue(node,"__PASSWORD__");
	String exportDir = ElementParameterParser.getValue(node,"__EXPORT_DIR__");
	boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
	boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
	boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
	boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
	String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
	List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL_JAVA__");
	String fsDefalutName = "fs.default.name";
	
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_66);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_71);
    
	if((isCustom && useYarn) || (!isCustom && ("PIVOTAL_HD_1_0_1".equals(version) || "HDP_2_0".equals(version) || "Cloudera_CDH4_YARN".equals(version)))) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_75);
    
	} else {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(jobtracker);
    stringBuffer.append(TEXT_78);
    
	}
	
    if(!isCustom && ("HDP_1_2".equals(version) || "HDP_1_3".equals(version))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_83);
    
    }
	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_87);
     
		}
	}
	if(("HDP_1_0".equals(version) || "HDP_1_2".equals(version) || "HDP_1_3".equals(version) || "Cloudera_CDH4".equals(version) || isCustom) && useKrb) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
		String jobTrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");
		boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
		String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
		String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(jobTrackerPrincipal);
    stringBuffer.append(TEXT_92);
    
		if(useKeytab) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_95);
    
		}
	}

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
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
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(exportDir);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_111);
    	
	if(!(("HDP_1_0".equals(version) || "Cloudera_CDH3".equals(version) || "MAPR1".equals(version)) && !isCustom)) {
		if(printLog && verbose){

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
		}
	}

    stringBuffer.append(TEXT_114);
    if(direct){
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    if(useMappers){
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(mappers);
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
	if(additionalList != null){ 
		for(Map<String,String> additionalMap : additionalList){
			if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
				break; 
			}
			if(additionalMap.get("ADDITIONAL_ARGUMENT").contains("delimiters")) {
				

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_126);
    
			} else {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_130);
    
			}
		} 
	} 

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
	if(("Cloudera_CDH3".equals(version) || "MAPR1".equals(version)) && !isCustom) {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
	} else {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
	}

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
    }

    return stringBuffer.toString();
  }
}

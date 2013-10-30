package org.talend.designer.codegen.translators.file.sqoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSqoopImportAllTablesBeginJava
{
  protected static String nl;
  public static synchronized TSqoopImportAllTablesBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSqoopImportAllTablesBeginJava result = new TSqoopImportAllTablesBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "//call the cmd part" + NL + "Runtime runtime_";
  protected final String TEXT_4 = " = Runtime.getRuntime();" + NL + "" + NL + "String[] cmd_";
  protected final String TEXT_5 = " = new String[] {\"sqoop\", \"import-all-tables\", \"--connect\", ";
  protected final String TEXT_6 = ", \"--username\", ";
  protected final String TEXT_7 = ", \"--password\", ";
  protected final String TEXT_8 = ", \"--verbose\"";
  protected final String TEXT_9 = ", \"--direct\"";
  protected final String TEXT_10 = ", \"--compress\"";
  protected final String TEXT_11 = ", \"--as-sequencefile\"";
  protected final String TEXT_12 = ", \"--mysql-delimiters\"";
  protected final String TEXT_13 = ", \"--num-mappers\", ";
  protected final String TEXT_14 = " " + NL + "            ,\"";
  protected final String TEXT_15 = "\", ";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = " " + NL + "            ,\"";
  protected final String TEXT_18 = "\" ";
  protected final String TEXT_19 = NL + "};" + NL + "final Process ps_";
  protected final String TEXT_20 = " = runtime_";
  protected final String TEXT_21 = ".exec(cmd_";
  protected final String TEXT_22 = ");" + NL + "" + NL + "java.lang.StringBuilder sb_";
  protected final String TEXT_23 = " = null;" + NL + "byte[] byteArray_";
  protected final String TEXT_24 = " = new byte[1024];" + NL + "int len_";
  protected final String TEXT_25 = " = 0;" + NL + "" + NL + "java.io.InputStream errorStream_";
  protected final String TEXT_26 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_27 = ".getErrorStream());" + NL + "sb_";
  protected final String TEXT_28 = " = new java.lang.StringBuilder();" + NL + "while ((len_";
  protected final String TEXT_29 = " = errorStream_";
  protected final String TEXT_30 = ".read(byteArray_";
  protected final String TEXT_31 = ")) != -1) {" + NL + "    String line_";
  protected final String TEXT_32 = " = new String(byteArray_";
  protected final String TEXT_33 = ", 0, len_";
  protected final String TEXT_34 = ", \"ISO-8859-1\");";
  protected final String TEXT_35 = NL + "        System.err.println(line_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "    sb_";
  protected final String TEXT_38 = ".append(line_";
  protected final String TEXT_39 = ");" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_40 = "_ERROR_MESSAGE\", sb_";
  protected final String TEXT_41 = ".toString());" + NL + "" + NL + "byteArray_";
  protected final String TEXT_42 = " = new byte[1024];" + NL + "len_";
  protected final String TEXT_43 = " = 0;" + NL + "java.io.InputStream inputStream_";
  protected final String TEXT_44 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_45 = ".getInputStream());" + NL + "sb_";
  protected final String TEXT_46 = " = new java.lang.StringBuilder();" + NL + "while ((len_";
  protected final String TEXT_47 = " = inputStream_";
  protected final String TEXT_48 = ".read(byteArray_";
  protected final String TEXT_49 = ")) != -1) {" + NL + "    String line_";
  protected final String TEXT_50 = " = new String(byteArray_";
  protected final String TEXT_51 = ", 0, len_";
  protected final String TEXT_52 = ", \"ISO-8859-1\");";
  protected final String TEXT_53 = NL + "        System.out.println(line_";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "    sb_";
  protected final String TEXT_56 = ".append(line_";
  protected final String TEXT_57 = ");" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_58 = "_OUTPUT_MESSAGE\", sb_";
  protected final String TEXT_59 = ".toString());";
  protected final String TEXT_60 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_61 = ");" + NL + "\t" + NL + "\torg.apache.hadoop.conf.Configuration configuration_";
  protected final String TEXT_62 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\tconfiguration_";
  protected final String TEXT_63 = ".set(\"";
  protected final String TEXT_64 = "\", ";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\t\tconfiguration_";
  protected final String TEXT_67 = ".set(\"mapreduce.framework.name\", \"yarn\");" + NL + "\t\tconfiguration_";
  protected final String TEXT_68 = ".set(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\t\tconfiguration_";
  protected final String TEXT_71 = ".set(\"mapred.job.tracker\", ";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "        configuration_";
  protected final String TEXT_74 = ".set(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_75 = ");" + NL + "        configuration_";
  protected final String TEXT_76 = ".set(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_79 = ".set(";
  protected final String TEXT_80 = " ,";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\t\tconfiguration_";
  protected final String TEXT_83 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_84 = ");" + NL + "\t\tconfiguration_";
  protected final String TEXT_85 = ".set(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\torg.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_91 = " = org.apache.hadoop.fs.FileSystem.get(configuration_";
  protected final String TEXT_92 = ");" + NL + "\tcom.cloudera.sqoop.tool.SqoopTool sqoopTool_";
  protected final String TEXT_93 = " = com.cloudera.sqoop.tool.SqoopTool.getTool(\"import-all-tables\");" + NL + "" + NL + "\tcom.cloudera.sqoop.SqoopOptions sqoopOptions_";
  protected final String TEXT_94 = " = new com.cloudera.sqoop.SqoopOptions(configuration_";
  protected final String TEXT_95 = ");" + NL + "\t" + NL + "\tsqoopOptions_";
  protected final String TEXT_96 = ".setConnectString(";
  protected final String TEXT_97 = "); // __CONNECTION__" + NL + "\tsqoopOptions_";
  protected final String TEXT_98 = ".setUsername(";
  protected final String TEXT_99 = "); // __USERNAME__" + NL + "\tsqoopOptions_";
  protected final String TEXT_100 = ".setPassword(";
  protected final String TEXT_101 = "); // __PASSWORD__" + NL + "\t";
  protected final String TEXT_102 = NL + "\t\t\tsqoopOptions_";
  protected final String TEXT_103 = ".setVerbose(true);";
  protected final String TEXT_104 = NL + "\t";
  protected final String TEXT_105 = "sqoopOptions_";
  protected final String TEXT_106 = ".setDirectMode(true);";
  protected final String TEXT_107 = NL + "\t";
  protected final String TEXT_108 = "sqoopOptions_";
  protected final String TEXT_109 = ".setUseCompression(true);";
  protected final String TEXT_110 = NL + "\t";
  protected final String TEXT_111 = "sqoopOptions_";
  protected final String TEXT_112 = ".setFileLayout(com.cloudera.sqoop.SqoopOptions.FileLayout.SequenceFile);";
  protected final String TEXT_113 = "sqoopOptions_";
  protected final String TEXT_114 = ".setFileLayout(com.cloudera.sqoop.SqoopOptions.FileLayout.TextFile);";
  protected final String TEXT_115 = NL + "\t";
  protected final String TEXT_116 = "sqoopOptions_";
  protected final String TEXT_117 = ".setNumMappers(Integer.valueOf(";
  protected final String TEXT_118 = "));";
  protected final String TEXT_119 = NL + "\t" + NL + "\tjava.util.Properties additionalProperties_";
  protected final String TEXT_120 = " = new java.util.Properties();";
  protected final String TEXT_121 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_122 = ".put(";
  protected final String TEXT_123 = ", \"\"+";
  protected final String TEXT_124 = ".codePointAt(0)); ";
  protected final String TEXT_125 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_126 = ".put(";
  protected final String TEXT_127 = ", ";
  protected final String TEXT_128 = "); ";
  protected final String TEXT_129 = NL + "\tsqoopOptions_";
  protected final String TEXT_130 = ".loadProperties(additionalProperties_";
  protected final String TEXT_131 = ");";
  protected final String TEXT_132 = NL + "\t\tcom.cloudera.sqoop.Sqoop sqoop_";
  protected final String TEXT_133 = " = new com.cloudera.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_134 = ", configuration_";
  protected final String TEXT_135 = ", sqoopOptions_";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "\t\torg.apache.sqoop.Sqoop sqoop_";
  protected final String TEXT_138 = " = new org.apache.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_139 = ", configuration_";
  protected final String TEXT_140 = ", sqoopOptions_";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "\tint result_";
  protected final String TEXT_143 = " = sqoop_";
  protected final String TEXT_144 = ".run(null);" + NL + "\tif(result_";
  protected final String TEXT_145 = " != 0) {" + NL + "\t\tthrow new Exception(\"The Sqoop import-all-tables job has failed\");" + NL + "\t}" + NL + "\t" + NL + "    String currentClientPathSeparator_";
  protected final String TEXT_146 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "    if(currentClientPathSeparator_";
  protected final String TEXT_147 = "!=null) {" + NL + "    \tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_148 = ");" + NL + "    \tglobalMap.put(\"current_client_path_separator\", null);" + NL + "    }";

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
    String username = ElementParameterParser.getValue(node,"__USERNAME__");
    String password = ElementParameterParser.getValue(node,"__PASSWORD__");
    boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
    boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
    boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
    boolean compress = "true".equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
    boolean mysqlDelimiters = "true".equals(ElementParameterParser.getValue(node,"__MYSQL_DELIMITERS__"));
    boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
    String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
    String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
    List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(password);
    if(printLog && verbose){
    stringBuffer.append(TEXT_8);
    }
    if(direct){
    stringBuffer.append(TEXT_9);
    }
    if(compress){
    stringBuffer.append(TEXT_10);
    }
    if(fileFormat.equals("sequencefile")){
    stringBuffer.append(TEXT_11);
    }
    if(mysqlDelimiters){
    stringBuffer.append(TEXT_12);
    }
    if(useMappers){
    stringBuffer.append(TEXT_13);
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

    stringBuffer.append(TEXT_14);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_16);
     
        } else { 

    stringBuffer.append(TEXT_17);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_18);
     
        } 
    } 
} 

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
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
    
    if(printLog){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
    }

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
    if(printLog){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
    }

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
    } else {

    
	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	boolean isCustom = "CUSTOM".equals(distribution);
	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");

	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

	String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String jobtracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String username = ElementParameterParser.getValue(node,"__USERNAME__");
	String password = ElementParameterParser.getValue(node,"__PASSWORD__");
	boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
	boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
	boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
	boolean compress = "true".equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
	String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
	boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
	String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
	List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL_JAVA__");

	String fsDefalutName = "fs.default.name";
	
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_60);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_65);
    
	if((isCustom && useYarn) || (!isCustom && ("PIVOTAL_HD_1_0_1".equals(version) || "HDP_2_0".equals(version) || "Cloudera_CDH4_YARN".equals(version)))) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_69);
    
	} else {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(jobtracker);
    stringBuffer.append(TEXT_72);
    
	}
    if(!isCustom && ("HDP_1_2".equals(version) || "HDP_1_3".equals(version))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_77);
    
    }
	
	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_81);
     
		}
	}
	if(("HDP_1_0".equals(version) || "HDP_1_2".equals(version) || "HDP_1_3".equals(version) || "Cloudera_CDH4".equals(version) || isCustom) && useKrb) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
		String jobTrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");
		boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
		String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
		String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(jobTrackerPrincipal);
    stringBuffer.append(TEXT_86);
    
		if(useKeytab) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_89);
    
		}
	}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_101);
    	
	if(!(("HDP_1_0".equals(version) || "Cloudera_CDH3".equals(version) || "MAPR1".equals(version)) && !isCustom)) {
		if(printLog && verbose){

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
		}
	}

    stringBuffer.append(TEXT_104);
    if(direct){
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    if(compress){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    if(fileFormat.equals("sequencefile")){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    } else {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    if(useMappers){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(mappers);
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
	if(additionalList != null){ 
		for(Map<String,String> additionalMap : additionalList){
			if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
				break; 
			}
			if(additionalMap.get("ADDITIONAL_ARGUMENT").contains("delimiters")) {
				

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_124);
    
			} else {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_128);
    
			}
		} 
	} 

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
	if(("Cloudera_CDH3".equals(version) || "MAPR1".equals(version)) && !isCustom) {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
	} else {

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
	}

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
    }

    return stringBuffer.toString();
  }
}

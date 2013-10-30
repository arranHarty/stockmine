package org.talend.designer.codegen.translators.file.sqoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSqoopMergeBeginJava
{
  protected static String nl;
  public static synchronized TSqoopMergeBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSqoopMergeBeginJava result = new TSqoopMergeBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "Runtime runtime_generateJar_";
  protected final String TEXT_5 = " = Runtime.getRuntime();" + NL + "String[] generateJar_cmd_";
  protected final String TEXT_6 = " = new String[] {\"sqoop\", \"codegen\", \"--connect\", ";
  protected final String TEXT_7 = ", \"--table\", ";
  protected final String TEXT_8 = ", \"--username\", ";
  protected final String TEXT_9 = ", \"--password\", ";
  protected final String TEXT_10 = ", \"--verbose\"";
  protected final String TEXT_11 = " " + NL + "            ,\"";
  protected final String TEXT_12 = "\", ";
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = " " + NL + "            ,\"";
  protected final String TEXT_15 = "\" ";
  protected final String TEXT_16 = NL + "};" + NL + "final Process generateJar_ps_";
  protected final String TEXT_17 = " = runtime_generateJar_";
  protected final String TEXT_18 = ".exec(generateJar_cmd_";
  protected final String TEXT_19 = ");" + NL + "" + NL + "java.lang.StringBuilder generateJar_sb_";
  protected final String TEXT_20 = " = null;" + NL + "byte[] generateJar_byteArray_";
  protected final String TEXT_21 = " = new byte[1024];" + NL + "int generateJar_len_";
  protected final String TEXT_22 = " = 0;" + NL + "" + NL + "java.io.InputStream generateJar_errorStream_";
  protected final String TEXT_23 = " = new java.io.BufferedInputStream(generateJar_ps_";
  protected final String TEXT_24 = ".getErrorStream());" + NL + "generateJar_sb_";
  protected final String TEXT_25 = " = new java.lang.StringBuilder();" + NL + "while ((generateJar_len_";
  protected final String TEXT_26 = " = generateJar_errorStream_";
  protected final String TEXT_27 = ".read(generateJar_byteArray_";
  protected final String TEXT_28 = ")) != -1) {" + NL + "    String generateJar_line_";
  protected final String TEXT_29 = " = new String(generateJar_byteArray_";
  protected final String TEXT_30 = ", 0, generateJar_len_";
  protected final String TEXT_31 = ", \"ISO-8859-1\");";
  protected final String TEXT_32 = NL + "        System.err.println(generateJar_line_";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "    generateJar_sb_";
  protected final String TEXT_35 = ".append(generateJar_line_";
  protected final String TEXT_36 = ");" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_37 = "_ERROR_MESSAGE\", generateJar_sb_";
  protected final String TEXT_38 = ".toString());" + NL + "generateJar_byteArray_";
  protected final String TEXT_39 = " = new byte[1024];" + NL + "generateJar_len_";
  protected final String TEXT_40 = " = 0;" + NL + "java.io.InputStream generateJar_inputStream_";
  protected final String TEXT_41 = " = new java.io.BufferedInputStream(generateJar_ps_";
  protected final String TEXT_42 = ".getInputStream());" + NL + "generateJar_sb_";
  protected final String TEXT_43 = " = new java.lang.StringBuilder();" + NL + "while ((generateJar_len_";
  protected final String TEXT_44 = " = generateJar_inputStream_";
  protected final String TEXT_45 = ".read(generateJar_byteArray_";
  protected final String TEXT_46 = ")) != -1) {" + NL + "    String generateJar_line_";
  protected final String TEXT_47 = " = new String(generateJar_byteArray_";
  protected final String TEXT_48 = ", 0, generateJar_len_";
  protected final String TEXT_49 = ", \"ISO-8859-1\");";
  protected final String TEXT_50 = NL + "        System.out.println(generateJar_line_";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "    generateJar_sb_";
  protected final String TEXT_53 = ".append(generateJar_line_";
  protected final String TEXT_54 = ");" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_55 = "_OUTPUT_MESSAGE\", generateJar_sb_";
  protected final String TEXT_56 = ".toString());";
  protected final String TEXT_57 = NL + NL + NL + "//call the cmd part" + NL + "Runtime runtime_";
  protected final String TEXT_58 = " = Runtime.getRuntime();" + NL + "String jar_file_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ";";
  protected final String TEXT_61 = NL + "\tjar_file_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = "+ \"/\" + ";
  protected final String TEXT_64 = "  + \".jar\";";
  protected final String TEXT_65 = NL + "String[] cmd_";
  protected final String TEXT_66 = " = new String[] {\"sqoop\", \"merge\", \"--new-data\", ";
  protected final String TEXT_67 = ", \"--onto\", ";
  protected final String TEXT_68 = ", \"--target-dir\", ";
  protected final String TEXT_69 = ", \"--jar-file\", jar_file_";
  protected final String TEXT_70 = ", \"--class-name\", ";
  protected final String TEXT_71 = ", \"--merge-key\", ";
  protected final String TEXT_72 = "};" + NL + "final Process ps_";
  protected final String TEXT_73 = " = runtime_";
  protected final String TEXT_74 = ".exec(cmd_";
  protected final String TEXT_75 = ");" + NL + "" + NL + "java.lang.StringBuilder sb_";
  protected final String TEXT_76 = " = null;" + NL + "byte[] byteArray_";
  protected final String TEXT_77 = " = new byte[1024];" + NL + "int len_";
  protected final String TEXT_78 = " = 0;" + NL + "" + NL + "java.io.InputStream errorStream_";
  protected final String TEXT_79 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_80 = ".getErrorStream());" + NL + "sb_";
  protected final String TEXT_81 = " = new java.lang.StringBuilder();" + NL + "while ((len_";
  protected final String TEXT_82 = " = errorStream_";
  protected final String TEXT_83 = ".read(byteArray_";
  protected final String TEXT_84 = ")) != -1) {" + NL + "    String line_";
  protected final String TEXT_85 = " = new String(byteArray_";
  protected final String TEXT_86 = ", 0, len_";
  protected final String TEXT_87 = ", \"ISO-8859-1\");";
  protected final String TEXT_88 = NL + "        System.err.println(line_";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "    sb_";
  protected final String TEXT_91 = ".append(line_";
  protected final String TEXT_92 = ");" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_93 = "_ERROR_MESSAGE\", sb_";
  protected final String TEXT_94 = ".toString());" + NL + "byteArray_";
  protected final String TEXT_95 = " = new byte[1024];" + NL + "len_";
  protected final String TEXT_96 = " = 0;" + NL + "java.io.InputStream inputStream_";
  protected final String TEXT_97 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_98 = ".getInputStream());" + NL + "sb_";
  protected final String TEXT_99 = " = new java.lang.StringBuilder();" + NL + "while ((len_";
  protected final String TEXT_100 = " = inputStream_";
  protected final String TEXT_101 = ".read(byteArray_";
  protected final String TEXT_102 = ")) != -1) {" + NL + "    String line_";
  protected final String TEXT_103 = " = new String(byteArray_";
  protected final String TEXT_104 = ", 0, len_";
  protected final String TEXT_105 = ", \"ISO-8859-1\");" + NL + "    sb_";
  protected final String TEXT_106 = ".append(line_";
  protected final String TEXT_107 = ");" + NL + "}";
  protected final String TEXT_108 = NL + "if (sb_";
  protected final String TEXT_109 = ".length() > 0 ) {" + NL + "\tSystem.out.println(sb_";
  protected final String TEXT_110 = ");" + NL + "}";
  protected final String TEXT_111 = NL + "globalMap.put(\"";
  protected final String TEXT_112 = "_OUTPUT_MESSAGE\", sb_";
  protected final String TEXT_113 = ".toString());";
  protected final String TEXT_114 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_115 = ");" + NL + "\t" + NL + "\torg.apache.hadoop.conf.Configuration configuration_";
  protected final String TEXT_116 = " = new org.apache.hadoop.conf.Configuration();" + NL + "    org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_117 = " = org.apache.hadoop.fs.FileSystem.get(configuration_";
  protected final String TEXT_118 = ");" + NL + "\tconfiguration_";
  protected final String TEXT_119 = ".set(\"";
  protected final String TEXT_120 = "\", ";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "\t\tconfiguration_";
  protected final String TEXT_123 = ".set(\"mapreduce.framework.name\", \"yarn\");" + NL + "\t\tconfiguration_";
  protected final String TEXT_124 = ".set(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\tconfiguration_";
  protected final String TEXT_127 = ".set(\"mapred.job.tracker\", ";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "        configuration_";
  protected final String TEXT_130 = ".set(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_131 = ");" + NL + "        configuration_";
  protected final String TEXT_132 = ".set(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\tString jarFileName_";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = ";";
  protected final String TEXT_137 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_138 = ".set(";
  protected final String TEXT_139 = " ,";
  protected final String TEXT_140 = ");";
  protected final String TEXT_141 = NL + "\t\tconfiguration_";
  protected final String TEXT_142 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_143 = ");" + NL + "\t\tconfiguration_";
  protected final String TEXT_144 = ".set(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_147 = ", ";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = NL + "        com.cloudera.sqoop.SqoopOptions needGenereateJarSqoopOptions_";
  protected final String TEXT_150 = " = new com.cloudera.sqoop.SqoopOptions(configuration_";
  protected final String TEXT_151 = ");" + NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_152 = ".setConnectString(";
  protected final String TEXT_153 = "); // __CONNECTION__" + NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_154 = ".setUsername(";
  protected final String TEXT_155 = ");" + NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_156 = ".setPassword(";
  protected final String TEXT_157 = ");" + NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_158 = ".setTableName(";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "            needGenereateJarSqoopOptions_";
  protected final String TEXT_161 = ".setClassName(";
  protected final String TEXT_162 = ");";
  protected final String TEXT_163 = NL + "            needGenereateJarSqoopOptions_";
  protected final String TEXT_164 = ".setClassName(\"SqoopMerge_";
  protected final String TEXT_165 = "\");";
  protected final String TEXT_166 = NL + NL + "        java.util.Properties generateJarAdditionalProperties_";
  protected final String TEXT_167 = " = new java.util.Properties();";
  protected final String TEXT_168 = " " + NL + "                    generateJarAdditionalProperties_";
  protected final String TEXT_169 = ".put(";
  protected final String TEXT_170 = ", \"\"+";
  protected final String TEXT_171 = ".codePointAt(0)); ";
  protected final String TEXT_172 = " " + NL + "                    generateJarAdditionalProperties_";
  protected final String TEXT_173 = ".put(";
  protected final String TEXT_174 = ", ";
  protected final String TEXT_175 = "); ";
  protected final String TEXT_176 = NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_177 = ".loadProperties(generateJarAdditionalProperties_";
  protected final String TEXT_178 = ");" + NL + "        " + NL + "        com.cloudera.sqoop.tool.CodeGenTool codeGen_";
  protected final String TEXT_179 = " = new com.cloudera.sqoop.tool.CodeGenTool();" + NL + "        com.cloudera.sqoop.Sqoop codeGenerator_";
  protected final String TEXT_180 = " = new com.cloudera.sqoop.Sqoop(codeGen_";
  protected final String TEXT_181 = ",configuration_";
  protected final String TEXT_182 = ", needGenereateJarSqoopOptions_";
  protected final String TEXT_183 = ");" + NL + "        int ret_";
  protected final String TEXT_184 = " = com.cloudera.sqoop.Sqoop.runSqoop(codeGenerator_";
  protected final String TEXT_185 = ", new String[0]);" + NL + "        if (0 != ret_";
  protected final String TEXT_186 = ") {" + NL + "            throw new Exception(\"codegen the jar failed with code:\" + ret_";
  protected final String TEXT_187 = ");" + NL + "        }" + NL + "        List<String> jars_";
  protected final String TEXT_188 = " = codeGen_";
  protected final String TEXT_189 = ".getGeneratedJarFiles();" + NL + "        jarFileName_";
  protected final String TEXT_190 = " = jars_";
  protected final String TEXT_191 = ".get(0);";
  protected final String TEXT_192 = NL + NL + "    java.net.URLClassLoader sysloader_";
  protected final String TEXT_193 = " = (java.net.URLClassLoader) ClassLoader.getSystemClassLoader();" + NL + "    java.lang.reflect.Method method_";
  protected final String TEXT_194 = " = java.net.URLClassLoader.class.getDeclaredMethod(\"addURL\", new Class[] { java.net.URL.class});" + NL + "    method_";
  protected final String TEXT_195 = ".setAccessible(true);" + NL + "    method_";
  protected final String TEXT_196 = ".invoke(sysloader_";
  protected final String TEXT_197 = ", new Object[] { new java.io.File(jarFileName_";
  protected final String TEXT_198 = ").toURL()});" + NL + "    " + NL + "    com.cloudera.sqoop.tool.SqoopTool sqoopTool_";
  protected final String TEXT_199 = " = com.cloudera.sqoop.tool.SqoopTool.getTool(\"merge\");" + NL + "" + NL + "    com.cloudera.sqoop.SqoopOptions sqoopOptions_";
  protected final String TEXT_200 = " = new com.cloudera.sqoop.SqoopOptions(configuration_";
  protected final String TEXT_201 = ");" + NL + "" + NL + "\tsqoopOptions_";
  protected final String TEXT_202 = ".setMergeOldPath(";
  protected final String TEXT_203 = ");" + NL + "\tsqoopOptions_";
  protected final String TEXT_204 = ".setMergeNewPath(";
  protected final String TEXT_205 = ");" + NL + "\tsqoopOptions_";
  protected final String TEXT_206 = ".setMergeKeyCol(";
  protected final String TEXT_207 = ");" + NL + "\tsqoopOptions_";
  protected final String TEXT_208 = ".setTargetDir(";
  protected final String TEXT_209 = "); ";
  protected final String TEXT_210 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_211 = ".setClassName(";
  protected final String TEXT_212 = ");";
  protected final String TEXT_213 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_214 = ".setClassName(\"SqoopMerge_";
  protected final String TEXT_215 = "\");";
  protected final String TEXT_216 = NL + "\t\t";
  protected final String TEXT_217 = NL + "\t\t\tsqoopOptions_";
  protected final String TEXT_218 = ".setVerbose(true);";
  protected final String TEXT_219 = NL + "\t\tcom.cloudera.sqoop.Sqoop sqoop_";
  protected final String TEXT_220 = " = new com.cloudera.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_221 = ", configuration_";
  protected final String TEXT_222 = ", sqoopOptions_";
  protected final String TEXT_223 = ");";
  protected final String TEXT_224 = NL + "\t\torg.apache.sqoop.Sqoop sqoop_";
  protected final String TEXT_225 = " = new org.apache.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_226 = ", configuration_";
  protected final String TEXT_227 = ", sqoopOptions_";
  protected final String TEXT_228 = ");";
  protected final String TEXT_229 = NL + "\tint result_";
  protected final String TEXT_230 = " = sqoop_";
  protected final String TEXT_231 = ".run(null);" + NL + "\tif(result_";
  protected final String TEXT_232 = " != 0) {" + NL + "\t\tthrow new Exception(\"The Sqoop merge job has failed\");" + NL + "\t}" + NL + "\t" + NL + "    String currentClientPathSeparator_";
  protected final String TEXT_233 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "    if(currentClientPathSeparator_";
  protected final String TEXT_234 = "!=null) {" + NL + "    \tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_235 = ");" + NL + "    \tglobalMap.put(\"current_client_path_separator\", null);" + NL + "    }";

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
    boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
    String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
    List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL__");
    boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
    boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
    String newDataDir = ElementParameterParser.getValue(node,"__NEWDATA__");
    String oldDataDir = ElementParameterParser.getValue(node,"__ONTO__");
    String targetDir = ElementParameterParser.getValue(node,"__TARGETDIR__");
    String jarFile = ElementParameterParser.getValue(node,"__JARFILE__");
    String className = ElementParameterParser.getValue(node,"__CLASSNAME__");
    String key = ElementParameterParser.getValue(node,"__MERGEKEY__");
    boolean needGenerateJar = "true".equals(ElementParameterParser.getValue(node,"__GENERATE__"));
    

    stringBuffer.append(TEXT_3);
    if(needGenerateJar){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(password);
    if(printLog && verbose){
    stringBuffer.append(TEXT_10);
    }
    
boolean isNull=false; 
if(additionalList != null){ 
    for(Map<String,String> additionalMap : additionalList){ 
        isNull=false; 
        if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
            isNull=true; 
        } 
        if(!isNull) { 

    stringBuffer.append(TEXT_11);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_13);
     
        } else { 

    stringBuffer.append(TEXT_14);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_15);
     
        } 
    } 
} 

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
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
    
    if(printLog){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
    }

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
    if(printLog){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
    }

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(jarFile);
    stringBuffer.append(TEXT_60);
    if(needGenerateJar){
String bin_Dir = null;
String class_Name = null;
	for(Map<String,String> additionalMap : additionalList){
		if("--bindir".equals(additionalMap.get("ADDITIONAL_ARGUMENT"))){
 			bin_Dir = additionalMap.get("ADDITIONAL_VALUE");
 			break;
 		}
 	}
 	for(Map<String,String> additionalMap : additionalList){
 		if("--class-name".equals(additionalMap.get("ADDITIONAL_ARGUMENT"))){
 			class_Name = additionalMap.get("ADDITIONAL_VALUE");
 			break;
 		}
	}
	if(class_Name==null){
		class_Name = table;
	}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(bin_Dir );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(class_Name);
    stringBuffer.append(TEXT_64);
    
}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(newDataDir);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(oldDataDir);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(targetDir);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
    if(printLog){

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
    if(printLog){

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
    }

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
    } else {

    
	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	boolean isCustom = "CUSTOM".equals(distribution);
	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");
	
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
	
	String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String jobtracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL_JAVA__");
	List<Map<String,String>> generateJarAdditionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__GENERATE_JAR_ADDITIONAL_JAVA__");
	boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
	boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
	String newDataDir = ElementParameterParser.getValue(node,"__NEWDATA__");
	String oldDataDir = ElementParameterParser.getValue(node,"__ONTO__");
	String targetDir = ElementParameterParser.getValue(node,"__TARGETDIR__");
	String jarFile = ElementParameterParser.getValue(node,"__JARFILE__");
	boolean customClassName = "true".equals(ElementParameterParser.getValue(node,"__CUSTOMCLASSNAME__"));
	String className = ElementParameterParser.getValue(node,"__CLASSNAME__");
	String key = ElementParameterParser.getValue(node,"__MERGEKEY__");
	boolean needGenerateJar = "true".equals(ElementParameterParser.getValue(node,"__GENERATE__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String username = ElementParameterParser.getValue(node,"__USERNAME__");
	String password = ElementParameterParser.getValue(node,"__PASSWORD__");
    
	String fsDefalutName = "fs.default.name";
	
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_114);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_121);
    
	if((isCustom && useYarn) || (!isCustom && ("PIVOTAL_HD_1_0_1".equals(version) || "HDP_2_0".equals(version) || "Cloudera_CDH4_YARN".equals(version)))) {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_125);
    
	} else {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(jobtracker);
    stringBuffer.append(TEXT_128);
    
	}
    if(!isCustom && ("HDP_1_2".equals(version) || "HDP_1_3".equals(version))) {
    	String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
	    String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_133);
    
    }

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(jarFile);
    stringBuffer.append(TEXT_136);
    
	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_140);
     
		}
	}
	if(("HDP_1_0".equals(version) || "HDP_1_2".equals(version) || "HDP_1_3".equals(version) || "Cloudera_CDH4".equals(version) || isCustom) && useKrb) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
		String jobTrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");
		boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
		String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
		String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(jobTrackerPrincipal);
    stringBuffer.append(TEXT_145);
    
		if(useKeytab) {

    stringBuffer.append(TEXT_146);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_148);
    
		}
	}

    if(needGenerateJar){

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_159);
    if(customClassName){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_162);
    }else{
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
        if(generateJarAdditionalList != null){ 
            for(Map<String,String> generateJarAdditionalMap : generateJarAdditionalList){
                if(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_VALUE")==null || "".equals(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_VALUE"))) { 
                    break; 
                }
                if(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_ARGUMENT").contains("delimiters")) {
                

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_171);
    
                } else {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_175);
    
                }
            } 
        } 

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
    }

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(oldDataDir);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(newDataDir);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(targetDir);
    stringBuffer.append(TEXT_209);
    if(customClassName){
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_212);
    }else{
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_216);
    	
	if(!(("HDP_1_0".equals(version) || "Cloudera_CDH3".equals(version) || "MAPR1".equals(version)) && !isCustom)) {
		if(printLog && verbose){

    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
		}
	}

    
	if(("Cloudera_CDH3".equals(version) || "MAPR1".equals(version)) && !isCustom) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    
	} else {

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
	}

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
    }

    return stringBuffer.toString();
  }
}

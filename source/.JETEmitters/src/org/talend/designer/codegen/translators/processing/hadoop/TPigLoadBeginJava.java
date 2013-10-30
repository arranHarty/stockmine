package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.Java2STLangTypesHelper;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import java.util.List;
import java.util.Map;

public class TPigLoadBeginJava
{
  protected static String nl;
  public static synchronized TPigLoadBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigLoadBeginJava result = new TPigLoadBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_3 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_4 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister(\"../../job.xml\");" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tpublic boolean setJarsToRegister(String filename) throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(filename).getCanonicalPath();" + NL + "\t\t\t\tif(isNeedAddLibsPath(jobXmlPath)) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "" + NL + "\t\tGetJarsToRegister_";
  protected final String TEXT_5 = " getJarsToRegister_";
  protected final String TEXT_6 = " = new GetJarsToRegister_";
  protected final String TEXT_7 = "();";
  protected final String TEXT_8 = NL + "\tjava.util.Properties props_";
  protected final String TEXT_9 = " = new java.util.Properties();";
  protected final String TEXT_10 = NL + "\tprops_";
  protected final String TEXT_11 = ".put(org.apache.pig.impl.PigContext.JOB_NAME, projectName + \"_\" + jobName + \"_\" + jobVersion + \"_\" + \"";
  protected final String TEXT_12 = "\");";
  protected final String TEXT_13 = NL + "\ttry {";
  protected final String TEXT_14 = NL + "\t\t\torg.apache.pig.impl.PigContext context_";
  protected final String TEXT_15 = " = new org.apache.pig.impl.PigContext(org.apache.pig.ExecType.LOCAL, props_";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\t\t\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\t\t\t\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t\tprops_";
  protected final String TEXT_20 = ".put(\"fs.default.name\", ";
  protected final String TEXT_21 = ");" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tprops_";
  protected final String TEXT_23 = ".put(\"mapreduce.framework.name\", \"yarn\");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_24 = ".put(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_27 = ".put(\"mapreduce.jobhistory.address\", ";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\t\tprops_";
  protected final String TEXT_30 = ".put(\"mapred.job.tracker\", ";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\t\t\t\tprops_";
  protected final String TEXT_33 = ".put(\"hcat.metastore.uri\", ";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\t\tprops_";
  protected final String TEXT_36 = ".put(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_38 = ".put(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\t\t\tprops_";
  protected final String TEXT_41 = ".put(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_43 = ".put(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "\t\t        props_";
  protected final String TEXT_49 = ".put(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_50 = ");" + NL + "\t\t        props_";
  protected final String TEXT_51 = ".put(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_54 = ".put(";
  protected final String TEXT_55 = " ,";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\t\t\torg.apache.pig.impl.PigContext context_";
  protected final String TEXT_58 = " = new org.apache.pig.impl.PigContext(org.apache.pig.ExecType.MAPREDUCE, props_";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t\torg.apache.pig.PigServer pigServer_";
  protected final String TEXT_61 = " = new org.apache.pig.PigServer(context_";
  protected final String TEXT_62 = ");" + NL + "\t\tpigServer_";
  protected final String TEXT_63 = ".setBatchOn();";
  protected final String TEXT_64 = NL + "\t\t//store the pig script in the lookup process" + NL + "\t\tObject[] pl_";
  protected final String TEXT_65 = " = null;" + NL + "\t\tjava.util.List<Object[]> pigScript_";
  protected final String TEXT_66 = " = new java.util.ArrayList<Object[]>();";
  protected final String TEXT_67 = NL + "\t\tStringBuilder script_";
  protected final String TEXT_68 = "=new StringBuilder();";
  protected final String TEXT_69 = NL + "\t\tscript_";
  protected final String TEXT_70 = ".append(\"SET \"+";
  protected final String TEXT_71 = "+\" \"+";
  protected final String TEXT_72 = "+\";\");";
  protected final String TEXT_73 = NL + "\t\tscript_";
  protected final String TEXT_74 = ".append(\"SET output.compression.enabled true;\");";
  protected final String TEXT_75 = NL + "\t\tscript_";
  protected final String TEXT_76 = ".append(\"SET output.compression.codec org.apache.hadoop.io.compress.GzipCodec;\");";
  protected final String TEXT_77 = NL + "\t\tscript_";
  protected final String TEXT_78 = ".append(\"SET output.compression.codec org.apache.hadoop.io.compress.BZip2Codec;\");";
  protected final String TEXT_79 = NL + "\t\tscript_";
  protected final String TEXT_80 = ".append(\"SET hbase.zookeeper.quorum \").append(";
  protected final String TEXT_81 = ").append(\";\");" + NL + "\t\tscript_";
  protected final String TEXT_82 = ".append(\"SET hbase.zookeeper.property.clientPort \").append(";
  protected final String TEXT_83 = ").append(\";\");";
  protected final String TEXT_84 = NL + "\t\tpigServer_";
  protected final String TEXT_85 = ".registerScript(new java.io.ByteArrayInputStream(script_";
  protected final String TEXT_86 = ".toString().getBytes()));";
  protected final String TEXT_87 = NL + "\t\tpl_";
  protected final String TEXT_88 = " = new Object[2];" + NL + "\t\tpl_";
  protected final String TEXT_89 = "[0] = \"script\";" + NL + "\t\tpl_";
  protected final String TEXT_90 = "[1] = new java.io.ByteArrayInputStream(script_";
  protected final String TEXT_91 = ".toString().getBytes());" + NL + "\t\tpigScript_";
  protected final String TEXT_92 = ".add(pl_";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + NL + "\t\tStringBuilder sb_";
  protected final String TEXT_95 = " = new StringBuilder();" + NL;
  protected final String TEXT_96 = NL + "\t\t\t\t\t\tpigServer_";
  protected final String TEXT_97 = ".registerJar(getJarsToRegister_";
  protected final String TEXT_98 = ".replaceJarPaths(\"";
  protected final String TEXT_99 = "\"));";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\tpl_";
  protected final String TEXT_101 = " = new Object[2];" + NL + "\t\t\t\t\t\tpl_";
  protected final String TEXT_102 = "[0] = \"jar\";" + NL + "\t\t\t\t\t\tpl_";
  protected final String TEXT_103 = "[1] = getJarsToRegister_";
  protected final String TEXT_104 = ".replaceJarPaths(\"";
  protected final String TEXT_105 = "\");" + NL + "\t\t\t\t\t\tpigScript_";
  protected final String TEXT_106 = ".add(pl_";
  protected final String TEXT_107 = ");\t\t\t\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\tpigServer_";
  protected final String TEXT_109 = ".registerJar(";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\tpl_";
  protected final String TEXT_112 = " = new Object[2];" + NL + "\t\t\t\t\t\tpl_";
  protected final String TEXT_113 = "[0] = \"jar\";" + NL + "\t\t\t\t\t\tpl_";
  protected final String TEXT_114 = "[1] = ";
  protected final String TEXT_115 = ";" + NL + "\t\t\t\t\t\tpigScript_";
  protected final String TEXT_116 = ".add(pl_";
  protected final String TEXT_117 = ");\t\t\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", ";
  protected final String TEXT_119 = ");" + NL + "\t\t\tsb_";
  protected final String TEXT_120 = ".append(\"";
  protected final String TEXT_121 = "_";
  protected final String TEXT_122 = "_RESULT";
  protected final String TEXT_123 = " = LOAD '\"+";
  protected final String TEXT_124 = "+\".\"+";
  protected final String TEXT_125 = "+\"' using org.apache.hcatalog.pig.";
  protected final String TEXT_126 = "()\");";
  protected final String TEXT_127 = NL + "\t\t\tsb_";
  protected final String TEXT_128 = ".append(\"";
  protected final String TEXT_129 = "_";
  protected final String TEXT_130 = "_RESULT = LOAD '\"+";
  protected final String TEXT_131 = "+" + NL + "\t\t\t\t\"' using com.twitter.elephantbird.pig.load.SequenceFileLoader('-c ";
  protected final String TEXT_132 = "','-c ";
  protected final String TEXT_133 = "')\");";
  protected final String TEXT_134 = NL + "\t\t\t\tsb_";
  protected final String TEXT_135 = ".append(\" AS (\");" + NL + "\t\t\t\tsb_";
  protected final String TEXT_136 = ".append(\"";
  protected final String TEXT_137 = ":";
  protected final String TEXT_138 = ", ";
  protected final String TEXT_139 = ":";
  protected final String TEXT_140 = "\");" + NL + "\t\t\t\tsb_";
  protected final String TEXT_141 = ".append(\")\");";
  protected final String TEXT_142 = NL + "\t\t\t\tsb_";
  protected final String TEXT_143 = ".append(\"";
  protected final String TEXT_144 = "_";
  protected final String TEXT_145 = "_RESULT = LOAD '\"+";
  protected final String TEXT_146 = "+\"' using \" + ";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_149 = ".append(\"";
  protected final String TEXT_150 = "_";
  protected final String TEXT_151 = "_RESULT = LOAD 'hbase://\").append(";
  protected final String TEXT_152 = ").append(\"' using org.apache.pig.backend.hadoop.hbase.HBaseStorage('\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_154 = ".append(";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_157 = ".append(\" \");";
  protected final String TEXT_158 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_159 = ".append(\"'\");";
  protected final String TEXT_160 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_161 = ".append(\",'-loadKey true\");";
  protected final String TEXT_162 = NL + "\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_163 = ".append(\",'\");";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_165 = ".append(\" \");";
  protected final String TEXT_166 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_167 = ".append(\"-";
  protected final String TEXT_168 = " \").append(";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_171 = ".append(\" \");";
  protected final String TEXT_172 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_173 = ".append(\"'\");";
  protected final String TEXT_174 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_175 = ".append(\"'\");";
  protected final String TEXT_176 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_177 = ".append(\")\");";
  protected final String TEXT_178 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_179 = ".append(\"";
  protected final String TEXT_180 = "_";
  protected final String TEXT_181 = "_RESULT = LOAD '\"+";
  protected final String TEXT_182 = "+\"' using ";
  protected final String TEXT_183 = "(";
  protected final String TEXT_184 = ")\");";
  protected final String TEXT_185 = NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_186 = ".append(\" AS (\");";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_188 = ".append(\"";
  protected final String TEXT_189 = ":";
  protected final String TEXT_190 = "\");";
  protected final String TEXT_191 = NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_192 = ".append(\")\");";
  protected final String TEXT_193 = NL + "\t\tsb_";
  protected final String TEXT_194 = ".append(\";\");";
  protected final String TEXT_195 = NL + "\t\tpigServer_";
  protected final String TEXT_196 = ".registerQuery(sb_";
  protected final String TEXT_197 = ".toString());";
  protected final String TEXT_198 = NL + "\t\tpl_";
  protected final String TEXT_199 = " = new Object[2];" + NL + "\t\tpl_";
  protected final String TEXT_200 = "[0] = \"query\";" + NL + "\t\tpl_";
  protected final String TEXT_201 = "[1] = sb_";
  protected final String TEXT_202 = ".toString();" + NL + "\t\tpigScript_";
  protected final String TEXT_203 = ".add(pl_";
  protected final String TEXT_204 = ");\t\t";
  protected final String TEXT_205 = NL + "\t\t\t\tsb_";
  protected final String TEXT_206 = " = new StringBuilder();" + NL + "\t\t\t\tsb_";
  protected final String TEXT_207 = ".append(\"";
  protected final String TEXT_208 = "_";
  protected final String TEXT_209 = "_RESULT = FILTER ";
  protected final String TEXT_210 = "_";
  protected final String TEXT_211 = "_RESULT_TEMP BY \");";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_213 = ".append(\" AND \");";
  protected final String TEXT_214 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_215 = ".append(\"(\" + ";
  protected final String TEXT_216 = ");" + NL + "\t\t\t\t\tsb_";
  protected final String TEXT_217 = ".append(\" == \");" + NL + "\t\t\t\t\tsb_";
  protected final String TEXT_218 = ".append(";
  protected final String TEXT_219 = " + \")\");";
  protected final String TEXT_220 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_221 = ".append(\";\");";
  protected final String TEXT_222 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_223 = ".registerQuery(sb_";
  protected final String TEXT_224 = ".toString());";
  protected final String TEXT_225 = NL + "\t\t\t\t\tpl_";
  protected final String TEXT_226 = " = new Object[2];" + NL + "\t\t\t\t\tpl_";
  protected final String TEXT_227 = "[0] = \"query\";" + NL + "\t\t\t\t\tpl_";
  protected final String TEXT_228 = "[1] = sb_";
  protected final String TEXT_229 = ".toString();" + NL + "\t\t\t\t\tpigScript_";
  protected final String TEXT_230 = ".add(pl_";
  protected final String TEXT_231 = ");\t\t\t\t\t";
  protected final String TEXT_232 = NL;
  protected final String TEXT_233 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String processId = node.getProcess().getId();
	
	String pigVersion = ElementParameterParser.getValue(node, "__PIG_VERSION__");
	boolean isLocal = "true".equals(ElementParameterParser.getValue(node, "__LOCAL__"));
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String inputFilename = ElementParameterParser.getValue(node, "__INPUT_FILENAME__");
	String databaseName = ElementParameterParser.getValue(node, "__DATABASE_NAME__");
	String tableName = ElementParameterParser.getValue(node, "__TABLE_NAME__");
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR_CHAR__");
	String function = ElementParameterParser.getValue(node, "__LOAD__");
	
	String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String mapredJobTracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
	String thriftServer = ElementParameterParser.getValue(node, "__THRIFT_SERVER__");
	
	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
	
	List<Map<String, String>> registerJarForHCatalog = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
	List<Map<String, String>> partitionFilter = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__PARTITION_FILTER__");
	
	boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
	String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
	
	String zookeeper_quorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeper_client_port = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");	
	
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
	
	boolean defineJarsToRegister = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__"));
	List<Map<String, String>> registerJar = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__DRIVER_JAR__");
	
	boolean generateRegisterJarCodeForHCatalog = (!isLocal && !isCustom && ("HDP_1_0".equals(pigVersion) || "HDP_1_2".equals(pigVersion) || "HDP_1_3".equals(pigVersion) || "HDP_2_0".equals(pigVersion)) && "HCatLoader".equals(function) && !defineJarsToRegister);
	boolean generateRegisterJarCode = registerJar.size() > 0;
	
	java.util.List<String> jarsToRegister = null;
	java.util.List<String> jars = null;
	
	boolean generateRegisterJarCodeForHBase = !isLocal && "HBaseStorage".equals(function);
	
	boolean generateRegisterJarCodeForSequenceFile = !isLocal && "SequenceFileStorage".equals(function);
	
	boolean generateRegisterJarCodeForRCFile = !isLocal && "RCFilePigStorage".equals(function);
	
	boolean generateRegisterJarCodeForAvroFile = !isLocal && "AvroStorage".equals(function);
	
	boolean generateRegisterJarCodeForAll = generateRegisterJarCodeForHCatalog || generateRegisterJarCode || generateRegisterJarCodeForHBase || generateRegisterJarCodeForSequenceFile || generateRegisterJarCodeForRCFile || generateRegisterJarCodeForAvroFile;

	if(generateRegisterJarCodeForAll) {
		String[] commandLine = new String[] {"<command>"};
		try {
			commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
		} catch (ProcessorException e) {
			e.printStackTrace();
		}

		jarsToRegister = new java.util.ArrayList();
		
		if(generateRegisterJarCode) {
			for(Map<String, String> jar : registerJar){
				jarsToRegister.add(jar.get("JAR_NAME"));
			}
		}
		
		if(generateRegisterJarCodeForHCatalog) {
			jarsToRegister.add("hcatalog");
			jarsToRegister.add("hive-exec");
			jarsToRegister.add("hive-metastore");
			jarsToRegister.add("jdo2-api");
			jarsToRegister.add("libfb303");
			jarsToRegister.add("libthrift");
		}
		
		if(generateRegisterJarCodeForHBase) {
			jarsToRegister.add("protobuf-java");
			jarsToRegister.add("hbase");
			jarsToRegister.add("zookeeper");
			jarsToRegister.add("guava");
		}
		
		if(generateRegisterJarCodeForSequenceFile) {
			jarsToRegister.add("elephant-bird-core");
			jarsToRegister.add("elephant-bird-hadoop-compat");
			jarsToRegister.add("pigutil");
		}
		
		if(generateRegisterJarCodeForRCFile) {
			jarsToRegister.add("elephant-bird-core");
			jarsToRegister.add("elephant-bird-hadoop-compat");
			jarsToRegister.add("hive-serde");
			jarsToRegister.add("hive-common");
			jarsToRegister.add("hive-exec");
		}
		
		if(generateRegisterJarCodeForAvroFile) {
			jarsToRegister.add("piggybank");
			jarsToRegister.add("avro");
			jarsToRegister.add("json_simple");
		}

		for (int j = 0; j < commandLine.length; j++) {
			if(commandLine[j].contains("jar")) {
				jars = java.util.Arrays.asList(commandLine[j].split(";"));
				break;
			}
		}
	}

	String start_node=cid;

	boolean inMain = true;

	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		INode loadNode = node.getDesignSubjobStartNode();
		inMain = loadNode.isSubtreeStart();
		start_node = loadNode.getUniqueName();
	}
	
	String outputConnectionName = "";
	List<IConnection> outputConnections = (List<IConnection>)node.getOutgoingConnections();
	if(outputConnections!=null && outputConnections.size()>0) {
		outputConnectionName = outputConnections.get(0).getName();
	}

	if(generateRegisterJarCodeForAll) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
      
	if(inMain) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
      
	}

    stringBuffer.append(TEXT_13);
    
		if(isLocal) { // LOCAL mode

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
		} else { // MAPREDUCE mode
			if(inMain) {
				String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_17);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_18);
    
			}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_21);
    if((isCustom && useYarn) || (!isCustom && ("PIVOTAL_HD_1_0_1".equals(pigVersion) || "HDP_2_0".equals(pigVersion) || "Cloudera_CDH4_YARN".equals(pigVersion)))) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_25);
    
				if(setJobHistoryAddress) {
					String jobHistoryAddress = ElementParameterParser.getValue(node, "__JOBHISTORY_ADDRESS__");

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_28);
    
				}
			} else {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(mapredJobTracker);
    stringBuffer.append(TEXT_31);
    
			}
			
			if("HCatLoader".equals(function)) { // If the HCatalog loader is used, we need to add the HCat metastore in the pig context

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(thriftServer);
    stringBuffer.append(TEXT_34);
    
			}
			
			if("HBaseStorage".equals(function)) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_39);
    
			}
			
			if(("HDP_1_0".equals(pigVersion) || "HDP_1_2".equals(pigVersion) || "HDP_1_3".equals(pigVersion) || "APACHE_1_0_0".equals(pigVersion) || "APACHE_1_0_3_EMR".equals(pigVersion) || "Cloudera_CDH4".equals(pigVersion) || isCustom) && useKrb) {
				String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
				String jobTrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(jobTrackerPrincipal);
    stringBuffer.append(TEXT_44);
    
				if(useKeytab) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_47);
    
				}
			}

		    if(!isCustom && ("HDP_1_2".equals(pigVersion) || "HDP_1_3".equals(pigVersion))) {
		        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
		        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_52);
    
    		}
			if(hadoopProps.size() > 0){
				for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_56);
     
				} 
			}

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		}
		
		if(inMain) {//only main process create the server object,lookup process use the one in main process

    stringBuffer.append(TEXT_60);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_63);
    
		} else {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_66);
    
		}
	if((advProps.size() > 0) || compress || (isLocal && "HBaseStorage".equals(function))){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_72);
     
		} 
		
		if(compress) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			if("GZIP".equals(compression)) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
			} else if("BZIP2".equals(compression)) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    		
			}
		}
		
		if(isLocal && "HBaseStorage".equals(function)) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_83);
    
		}
		
		if(inMain){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
		} else {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_93);
    
		}
	}

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    		
		if(generateRegisterJarCodeForAll) {
			for(int i=0; i<jarsToRegister.size(); i++) {
				String jarToRegister = jarsToRegister.get(i);
				for(int j=0; j<jars.size(); j++) {
					if(jars.get(j).contains(jarToRegister)) {
						if(inMain) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_99);
    
						} else {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_107);
    
						}
						break;
					}
				}
			}
		} 

		if(!isLocal && "HCatLoader".equals(function)) { // If the HCatalog loader is used, we don't need a filename anymore, but a database name and a table name.
			if(!generateRegisterJarCodeForHCatalog) {
				if(registerJarForHCatalog.size() > 0){
					for(Map<String, String> item : registerJarForHCatalog){
						if(inMain) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(item.get("JAR_PATH") );
    stringBuffer.append(TEXT_110);
     
						} else {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(item.get("JAR_PATH") );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_117);
    
						}
					} 
				}
			}

    stringBuffer.append(TEXT_118);
    stringBuffer.append(thriftServer);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(partitionFilter.size()>0?"_TEMP":"");
    stringBuffer.append(TEXT_123);
    stringBuffer.append(databaseName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_126);
    
		} else if(!isLocal && "SequenceFileStorage".equals(function)) {
			List<IMetadataTable> metadatas = node.getMetadataList();
			IMetadataTable metadata = null;
			if(metadatas != null && metadatas.size() > 0) {
				metadata = metadatas.get(0);
			}
			
			String keyColumn = ElementParameterParser.getValue(node,"__KEYCOLUMN__");
			String valueColumn = ElementParameterParser.getValue(node,"__VALUECOLUMN__");
			
			String talendKeyClass = "";
			String talendValueClass = "";
			
			if(metadata!=null) {
    			List<IMetadataColumn> listColumns = metadata.getListColumns();
    			
    			for (IMetadataColumn column : listColumns) {
    				if (column.getLabel().equals(keyColumn)) {
    					talendKeyClass = column.getTalendType();
    				}
    				if (column.getLabel().equals(valueColumn)) {
    					talendValueClass = column.getTalendType();
    				}
    			}
			}
			
			String keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendKeyClass.equals("id_Boolean")) keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendKeyClass.equals("id_Byte")) keyConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendKeyClass.equals("id_byte[]")) keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendKeyClass.equals("id_Double")) keyConverterClass="com.talend.pig.util.DoubleWritableConverter";
			if (talendKeyClass.equals("id_Float")) keyConverterClass="com.talend.pig.util.FloatWritableConverter";
			if (talendKeyClass.equals("id_Integer")) keyConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendKeyClass.equals("id_Long")) keyConverterClass="com.twitter.elephantbird.pig.util.LongWritableConverter";
			if (talendKeyClass.equals("id_Short")) keyConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendKeyClass.equals("id_String")) keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			
			String valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendValueClass.equals("id_Boolean")) valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendValueClass.equals("id_Byte")) valueConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendValueClass.equals("id_byte[]")) valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendValueClass.equals("id_Double")) valueConverterClass="com.talend.pig.util.DoubleWritableConverter";
			if (talendValueClass.equals("id_Float")) valueConverterClass="com.talend.pig.util.FloatWritableConverter";
			if (talendValueClass.equals("id_Integer")) valueConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendValueClass.equals("id_Long")) valueConverterClass="com.twitter.elephantbird.pig.util.LongWritableConverter";
			if (talendValueClass.equals("id_Short")) valueConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendValueClass.equals("id_String")) valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(inputFilename);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(keyConverterClass);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(valueConverterClass);
    stringBuffer.append(TEXT_133);
    
			if(metadata!=null) {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, keyColumn));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(valueColumn);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, valueColumn));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
			}
		} else {
			if("CustomLoader".equals(function)) {
				String customLoader = ElementParameterParser.getValue(node, "__CUSTOM_LOADER__");

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(inputFilename);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(customLoader);
    stringBuffer.append(TEXT_147);
    
			} else {
				List<IMetadataTable> metadatas = node.getMetadataList();
				IMetadataTable metadata = null;
				if(metadatas != null && metadatas.size() > 0) {
					metadata = metadatas.get(0);
				}
				
				if("HBaseStorage".equals(function)){
					String hbasetable = ElementParameterParser.getValue(node, "__HBASE_TABLE__");
					boolean loadkey = "true".equals(ElementParameterParser.getValue(node, "__LOAD_KEY__"));//if load key,the first column is hbase row key
					List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(hbasetable);
    stringBuffer.append(TEXT_152);
    
					if(metadata!=null && mapping!=null) {
						for(int i=0;i<mapping.size();i++){
							if(loadkey && (i == 0)) {
								continue;
							}
                			Map<String, String> map = mapping.get(i);
                			String family_column= map.get("FAMILY_COLUMN");

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_155);
    
							if(i < mapping.size()-1) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
							}
            			}
					}

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
					List<Map<String, String>> hbasestorageParams = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__HBASESTORAGE_PARAMETER__");
					
					if(loadkey) {

    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
					}
					
					if(hbasestorageParams!=null) {
						for(int i=0;i<hbasestorageParams.size();i++) {
							if(i == 0) {
								if(!loadkey) {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    							
								} else {

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
								}
							}
							Map<String, String> param = hbasestorageParams.get(i);
							String name = param.get("PARAM_NAME");
							String value = param.get("PARAM_VALUE");

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_169);
    							
							if(i < hbasestorageParams.size()-1) {

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    							
							} else if(!loadkey){

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    							
							}
						}
					}
					
					if(loadkey) {

    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
					}

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
				} else {
					if("RCFilePigStorage".equals(function)) {
						function = "com.twitter.elephantbird.pig.store.RCFilePigStorage";
					}
					
					if("AvroStorage".equals(function)) {
						function = "org.apache.pig.piggybank.storage.avro.AvroStorage";
					}

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(inputFilename);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_183);
    stringBuffer.append("PigStorage".equals(function)?"'\"+"+fieldSeparator+"+\"'":"");
    stringBuffer.append(TEXT_184);
    
				}
			
				if(metadata!=null) {
					if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
						for(int i=0; i<metadata.getListColumns().size(); i++) {

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(i!=0?", ":"");
    stringBuffer.append(metadata.getListColumns().get(i).getLabel());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, metadata.getListColumns().get(i).getLabel()));
    stringBuffer.append(TEXT_190);
    

						}

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
					}
				}
			}
		}

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
		if(inMain) {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
		} else {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_204);
    
		}
		
		if(!isLocal && "HCatLoader".equals(function)) { // If the HCatalog loader is used, we will have to consider the partition filter
			if(partitionFilter.size() > 0){
				int i = 0;

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_211);
    
				for(Map<String, String> item : partitionFilter){
					if(i++ != 0) {

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
					}

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(item.get("PART_NAME") );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(item.get("PART_VALUE") );
    stringBuffer.append(TEXT_219);
     
				}

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
				if(inMain) {

    stringBuffer.append(TEXT_222);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    				
				} else {

    stringBuffer.append(TEXT_225);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_231);
    
				}
			}
		}

    stringBuffer.append(TEXT_232);
    stringBuffer.append(TEXT_233);
    return stringBuffer.toString();
  }
}

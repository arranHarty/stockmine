package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.core.model.metadata.types.Java2STLangTypesHelper;
import org.talend.core.model.utils.NodeUtil;

public class TPigStoreResultMainJava
{
  protected static String nl;
  public static synchronized TPigStoreResultMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigStoreResultMainJava result = new TPigStoreResultMainJava();
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
  protected final String TEXT_8 = NL + "\t";
  protected final String TEXT_9 = NL + "\t\tif (pigServer_";
  protected final String TEXT_10 = ".existsFile(";
  protected final String TEXT_11 = ")) {" + NL + "            pigServer_";
  protected final String TEXT_12 = ".deleteFile(";
  protected final String TEXT_13 = ");" + NL + "        }" + NL + "\t";
  protected final String TEXT_14 = NL + NL + "\tStringBuilder sb_";
  protected final String TEXT_15 = " = new StringBuilder();";
  protected final String TEXT_16 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_17 = ".registerJar(getJarsToRegister_";
  protected final String TEXT_18 = ".replaceJarPaths(\"";
  protected final String TEXT_19 = "\"));";
  protected final String TEXT_20 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_21 = ".registerJar(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\tSystem.setProperty(\"hive.metastore.uris\", ";
  protected final String TEXT_24 = ");" + NL + "\t\tSystem.setProperty(\"hadoop.clientside.fs.operations\", \"true\");" + NL + "\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\tsb_";
  protected final String TEXT_25 = ".append(\"STORE ";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = "_RESULT INTO '\"+";
  protected final String TEXT_28 = "+\".\"+";
  protected final String TEXT_29 = "+\"' using org.apache.hcatalog.pig.";
  protected final String TEXT_30 = "('\"+";
  protected final String TEXT_31 = "+\"'\");";
  protected final String TEXT_32 = NL + "\t\t\t\tsb_";
  protected final String TEXT_33 = ".append(\" , '\");";
  protected final String TEXT_34 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_35 = ".append(\"";
  protected final String TEXT_36 = ":";
  protected final String TEXT_37 = "\");";
  protected final String TEXT_38 = NL + "\t\t\t\tsb_";
  protected final String TEXT_39 = ".append(\"'\");";
  protected final String TEXT_40 = NL + "\t\tsb_";
  protected final String TEXT_41 = ".append(\");\");";
  protected final String TEXT_42 = NL + "\t\tsb_";
  protected final String TEXT_43 = ".append(\"STORE ";
  protected final String TEXT_44 = "_";
  protected final String TEXT_45 = "_RESULT INTO '\"+";
  protected final String TEXT_46 = "+" + NL + "\t\t\t\"' using com.twitter.elephantbird.pig.store.SequenceFileStorage('-c ";
  protected final String TEXT_47 = "','-c ";
  protected final String TEXT_48 = "');\");";
  protected final String TEXT_49 = NL + "\t\t\tsb_";
  protected final String TEXT_50 = ".append(\"STORE ";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = "_RESULT INTO '\"+";
  protected final String TEXT_53 = "+\"' using \" + ";
  protected final String TEXT_54 = " + \";\");";
  protected final String TEXT_55 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_56 = "=new StringBuilder();" + NL + "\t\t\tscript_";
  protected final String TEXT_57 = ".append(\"SET hbase.zookeeper.quorum \"+";
  protected final String TEXT_58 = "+\";\");" + NL + "\t\t\tscript_";
  protected final String TEXT_59 = ".append(\"SET hbase.zookeeper.property.clientPort \"+";
  protected final String TEXT_60 = "+\";\");" + NL + "\t\t\tpigServer_";
  protected final String TEXT_61 = ".registerScript(new java.io.ByteArrayInputStream(script_";
  protected final String TEXT_62 = ".toString().getBytes()));";
  protected final String TEXT_63 = NL + "\t\t\t\tsb_";
  protected final String TEXT_64 = ".append(\"STORE ";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = "_RESULT INTO \");";
  protected final String TEXT_67 = NL + "\t\t\t\tsb_";
  protected final String TEXT_68 = ".append(\"";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = "_TMP_RESULT = FOREACH ";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = "_RESULT GENERATE \");";
  protected final String TEXT_73 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_74 = ".append(\"$";
  protected final String TEXT_75 = " as column";
  protected final String TEXT_76 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_78 = ".append(\",\");";
  protected final String TEXT_79 = NL + "\t\t\t\tsb_";
  protected final String TEXT_80 = ".append(\";\");" + NL + "\t\t\t\tsb_";
  protected final String TEXT_81 = ".append(\"STORE ";
  protected final String TEXT_82 = "_";
  protected final String TEXT_83 = "_TMP_RESULT INTO \"); ";
  protected final String TEXT_84 = NL + "\t\t\tsb_";
  protected final String TEXT_85 = ".append(\"'\").append(";
  protected final String TEXT_86 = ").append(\"' using org.apache.pig.backend.hadoop.hbase.HBaseStorage('\");;";
  protected final String TEXT_87 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_88 = ".append(";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_91 = ".append(\" \");";
  protected final String TEXT_92 = NL + "\t\t\tsb_";
  protected final String TEXT_93 = ".append(\"'\");";
  protected final String TEXT_94 = NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_95 = ".append(\",'\");";
  protected final String TEXT_96 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_97 = ".append(\"-";
  protected final String TEXT_98 = " \").append(";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_101 = ".append(\" \");";
  protected final String TEXT_102 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_103 = ".append(\"'\");";
  protected final String TEXT_104 = NL + "\t\t\tsb_";
  protected final String TEXT_105 = ".append(\");\");";
  protected final String TEXT_106 = NL + "\t\t\tsb_";
  protected final String TEXT_107 = ".append(\"STORE ";
  protected final String TEXT_108 = "_";
  protected final String TEXT_109 = "_RESULT INTO '\"+";
  protected final String TEXT_110 = "+\"' using ";
  protected final String TEXT_111 = "(";
  protected final String TEXT_112 = ");\");";
  protected final String TEXT_113 = NL + NL + "\tpigServer_";
  protected final String TEXT_114 = ".registerQuery(sb_";
  protected final String TEXT_115 = ".toString());";
  protected final String TEXT_116 = NL + "\tpigServer_";
  protected final String TEXT_117 = ".executeBatch();" + NL + "\tString currentClientPathSeparator_";
  protected final String TEXT_118 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "\tif(currentClientPathSeparator_";
  protected final String TEXT_119 = "!=null) {" + NL + "\t\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_120 = ");" + NL + "\t\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "\t}";
  protected final String TEXT_121 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String processId = node.getProcess().getId();

	String previous_node="";
	String start_node="";

	String previousOutputConnectionName = "";
	
	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		IConnection connection = node.getIncomingConnections().get(0);
		previous_node = connection.getSource().getUniqueName();
		start_node = node.getDesignSubjobStartNode().getUniqueName();
		previousOutputConnectionName = connection.getName();
	}
	
	String resultFile = ElementParameterParser.getValue(node, "__OUTPUT_FILENAME__");
	String function = ElementParameterParser.getValue(node, "__STORE__");
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR_CHAR__");
	boolean rmResultDir = "true".equals(ElementParameterParser.getValue(node, "__RM_OUTPUT__"));
	
	String database = ElementParameterParser.getValue(node, "__DATABASE_NAME__");
	String table = ElementParameterParser.getValue(node, "__TABLE_NAME__");
	String partitionFilter = ElementParameterParser.getValue(node, "__PARTITION_KEYVALUE__");
	
	String thriftServer = ElementParameterParser.getValue(node, "__THRIFT_SERVER__");
	
	List<Map<String, String>> registerJarForHCatalog = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
	
	boolean defineJarsToRegister = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__"));
	List<Map<String, String>> registerJar = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__DRIVER_JAR__");
	
	boolean generateRegisterJarCodeForHCatalog = ("HCatStorer".equals(function) && !defineJarsToRegister);
	boolean generateRegisterJarCode = registerJar.size() > 0;
	
	java.util.List<String> jarsToRegister = null;
	java.util.List<String> jars = null;
	
	boolean generateRegisterJarCodeForHBase = "HBaseStorage".equals(function);
	
	boolean generateRegisterJarCodeForSequenceFile = "SequenceFileStorage".equals(function);
	
	boolean generateRegisterJarCodeForRCFile = "RCFilePigStorage".equals(function);
	
	boolean generateRegisterJarCodeForAvroFile = "AvroStorage".equals(function);
	
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
			jarsToRegister.add("libfb303");
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
    if(rmResultDir && !("HCatStorer".equals(function)) && !("HBaseStorage".equals(function))){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    	
	if(generateRegisterJarCodeForAll) {
		for(int i=0; i<jarsToRegister.size(); i++) {
			String jarToRegister = jarsToRegister.get(i);
			for(int j=0; j<jars.size(); j++) {
				if(jars.get(j).contains(jarToRegister)) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_19);
    

					break;
				}
			}
		}
	}

	if("HCatStorer".equals(function)) {
		if(!generateRegisterJarCodeForHCatalog) {
			if(registerJarForHCatalog.size() > 0){
				for(Map<String, String> item : registerJarForHCatalog){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(item.get("JAR_PATH") );
    stringBuffer.append(TEXT_22);
     
				} 
			}
		}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(thriftServer);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(partitionFilter);
    stringBuffer.append(TEXT_31);
    
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if(metadatas != null && metadatas.size() > 0) {
			metadata = metadatas.get(0);
		}
		if(metadata!=null) {
			if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
				for(int i=0; i<metadata.getListColumns().size(); i++) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i!=0?", ":"");
    stringBuffer.append(metadata.getListColumns().get(i).getLabel());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, metadata.getListColumns().get(i).getLabel()));
    stringBuffer.append(TEXT_37);
    

				}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
			}
		}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
	} else if("SequenceFileStorage".equals(function)) {
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

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(keyConverterClass);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(valueConverterClass);
    stringBuffer.append(TEXT_48);
    
	} else {
		if("CustomStorer".equals(function)) {
			String customStorer = ElementParameterParser.getValue(node, "__CUSTOM_STORER__");

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(customStorer);
    stringBuffer.append(TEXT_54);
    
		} else if("HBaseStorage".equals(function)) {
			String zookeeper_quorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
			String zookeeper_client_port = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");			

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
			
			String hbasetable = ElementParameterParser.getValue(node, "__HBASE_TABLE__");
			String rowKeyColumn = ElementParameterParser.getValue(node, "__ROWKEY_COLUMN__");
			boolean storeRowKeyToColumn = "true".equals(ElementParameterParser.getValue(node, "__CONTAIN_ROW_KEY_COLUMN_IN_HBASE_COLUMN__"));
			
			List<Integer> columnOrders = new ArrayList<Integer>();
			int rowKeyIndex = 0;
			
			List<IMetadataTable> metadatas = node.getMetadataList();
    		IMetadataTable metadata = null;
    		if(metadatas != null && metadatas.size() > 0) {
    			metadata = metadatas.get(0);
    		}
    		if(metadata!=null) {
    			if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {
    				for(int i=0; i<metadata.getListColumns().size(); i++) {
    					String columnName = metadata.getListColumns().get(i).getLabel();
    					if(columnName!=null && columnName.equals(rowKeyColumn)) {
    						rowKeyIndex = i;
    						columnOrders.add(0,i);
    						if(storeRowKeyToColumn) {
    							columnOrders.add(i);
    						}
    					} else {
    						columnOrders.add(i);
    					}
    					
    				}
    			}
    		}
    		
    		if((rowKeyIndex == 0) && !storeRowKeyToColumn) {//the default action

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_66);
    
    		} else {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_72);
    
				for(int i=0;i<columnOrders.size();i++) {
					Integer index = columnOrders.get(i);

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_76);
    
					if(i<columnOrders.size()-1) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
					}
				}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_83);
    
    		}

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(hbasetable);
    stringBuffer.append(TEXT_86);
    
			List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
			if(metadata!=null && mapping!=null) {
				for(int i=0;i<mapping.size();i++){
    				Map<String, String> map = mapping.get(i);
        			String schema_column = map.get("SCHEMA_COLUMN");
        			String family_column= map.get("FAMILY_COLUMN");
        			if(!storeRowKeyToColumn && (schema_column!=null) && (schema_column.equals(rowKeyColumn))) {
        				continue;
        			}

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_89);
    
					if(i < mapping.size()-1) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
					}
    			}
			}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
			List<Map<String, String>> hbasestorageParams = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__HBASESTORAGE_PARAMETER__");
			if(hbasestorageParams!=null) {
				for(int i=0;i<hbasestorageParams.size();i++) {
					if(i == 0) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    					
					}
					Map<String, String> param = hbasestorageParams.get(i);
					String name = param.get("PARAM_NAME");
					String value = param.get("PARAM_VALUE");

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_99);
    							
					if(i < hbasestorageParams.size()-1) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    							
					} else {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    					
					}
				}
			}

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
		} else {
    		if("RCFilePigStorage".equals(function)) {
    			function = "com.twitter.elephantbird.pig.store.RCFilePigStorage";
    		}
    		
			if("AvroStorage".equals(function)) {
				function = "org.apache.pig.piggybank.storage.avro.AvroStorage";
			}

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_111);
    stringBuffer.append("PigStorage".equals(function)?"'\"+"+fieldSeparator+"+\"'":"");
    stringBuffer.append(TEXT_112);
    
		}
	}

    stringBuffer.append(TEXT_113);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
	if(NodeUtil.isSubTreeEnd(node)) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
	}

    stringBuffer.append(TEXT_121);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THDFSListBeginJava
{
  protected static String nl;
  public static synchronized THDFSListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSListBeginJava result = new THDFSListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "String username_";
  protected final String TEXT_4 = " = \"\";" + NL + "org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_5 = " = null;";
  protected final String TEXT_6 = NL + "\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_7 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\tconf_";
  protected final String TEXT_8 = ".set(\"";
  protected final String TEXT_9 = "\", ";
  protected final String TEXT_10 = ");" + NL + "\t";
  protected final String TEXT_11 = NL + "\t\t\tconf_";
  protected final String TEXT_12 = ".set(";
  protected final String TEXT_13 = " ,";
  protected final String TEXT_14 = ");" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\tconf_";
  protected final String TEXT_16 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "    \tconf_";
  protected final String TEXT_22 = ".set(\"hadoop.job.ugi\",";
  protected final String TEXT_23 = "+\",\"+";
  protected final String TEXT_24 = ");" + NL + "    \tfs_";
  protected final String TEXT_25 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_26 = ");" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\tusername_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ";" + NL + "\t\tif(username_";
  protected final String TEXT_30 = " == null || \"\".equals(username_";
  protected final String TEXT_31 = ")){" + NL + "\t\t\tfs_";
  protected final String TEXT_32 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_33 = ");" + NL + "\t\t}else{" + NL + "\t\t\tfs_";
  protected final String TEXT_34 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_35 = ".get(\"";
  protected final String TEXT_36 = "\")),conf_";
  protected final String TEXT_37 = ",username_";
  protected final String TEXT_38 = ");" + NL + "\t\t}\t" + NL + "\t";
  protected final String TEXT_39 = NL + "\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_40 = " = (org.apache.hadoop.conf.Configuration)globalMap.get(\"conn_";
  protected final String TEXT_41 = "\");" + NL + "\t";
  protected final String TEXT_42 = NL + "\t\t    \tfs_";
  protected final String TEXT_43 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\tconf_";
  protected final String TEXT_46 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "\t\t\t\tusername_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = ";" + NL + "\t\t\t\tif(username_";
  protected final String TEXT_51 = " == null || \"\".equals(username_";
  protected final String TEXT_52 = ")){" + NL + "\t\t\t\t\tfs_";
  protected final String TEXT_53 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_54 = ");" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tfs_";
  protected final String TEXT_55 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_56 = ".get(\"";
  protected final String TEXT_57 = "\")),conf_";
  protected final String TEXT_58 = ",username_";
  protected final String TEXT_59 = ");" + NL + "\t\t\t\t}\t\t\t  \t\t" + NL + "\t\t  \t";
  protected final String TEXT_60 = NL + "\t";
  protected final String TEXT_61 = NL + "\tjava.util.List<String> maskList_";
  protected final String TEXT_62 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_63 = NL + "\t    maskList_";
  protected final String TEXT_64 = ".add(\"*\");" + NL + "\t    ";
  protected final String TEXT_65 = NL + "\t    maskList_";
  protected final String TEXT_66 = ".add(\".*\");" + NL + "\t    ";
  protected final String TEXT_67 = " " + NL + "    \tmaskList_";
  protected final String TEXT_68 = ".add(";
  protected final String TEXT_69 = ");" + NL + "  \t";
  protected final String TEXT_70 = NL + "  \t" + NL + "  \tint NB_FILE";
  protected final String TEXT_71 = " = 0;" + NL + "  \t" + NL + "  \tfor (String filemask_";
  protected final String TEXT_72 = " : maskList_";
  protected final String TEXT_73 = ") {//TD1024" + NL + "\t";
  protected final String TEXT_74 = NL + "\t\tfilemask_";
  protected final String TEXT_75 = " = org.apache.oro.text.GlobCompiler.globToPerl5(filemask_";
  protected final String TEXT_76 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t";
  protected final String TEXT_77 = "   " + NL + "\t\tString excludefilemask_";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ";" + NL + "    \tList<java.util.regex.Pattern> excludefileNameEachPattern_";
  protected final String TEXT_80 = " = new java.util.ArrayList<java.util.regex.Pattern>();" + NL + "\t   \tif(excludefilemask_";
  protected final String TEXT_81 = "!=null && !\"\".equals(excludefilemask_";
  protected final String TEXT_82 = ")) {" + NL + "\t\t  \tfor(String excludefilemaskEach_";
  protected final String TEXT_83 = " : excludefilemask_";
  protected final String TEXT_84 = ".split(\",\")) {" + NL + "\t\t  \t";
  protected final String TEXT_85 = NL + "\t\t  \t\texcludefilemaskEach_";
  protected final String TEXT_86 = " = org.apache.oro.text.GlobCompiler.globToPerl5(excludefilemaskEach_";
  protected final String TEXT_87 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\t  \t";
  protected final String TEXT_88 = NL + "\t\t\t\texcludefileNameEachPattern_";
  protected final String TEXT_89 = ".add(java.util.regex.Pattern.compile(excludefilemaskEach_";
  protected final String TEXT_90 = ",java.util.regex.Pattern.CASE_INSENSITIVE));" + NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\texcludefileNameEachPattern_";
  protected final String TEXT_92 = ".add(java.util.regex.Pattern.compile(excludefilemaskEach_";
  protected final String TEXT_93 = "));" + NL + "\t\t\t";
  protected final String TEXT_94 = "\t  \t \t\t" + NL + "\t\t\t}" + NL + "\t  }";
  protected final String TEXT_95 = NL + "\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_96 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_97 = ");" + NL + "\t";
  protected final String TEXT_98 = NL + "\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_99 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_100 = ", java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "\t";
  protected final String TEXT_101 = NL + "\t" + NL + "\torg.apache.hadoop.fs.Path hdfsdir_";
  protected final String TEXT_102 = " = new org.apache.hadoop.fs.Path(";
  protected final String TEXT_103 = ");" + NL + "\tfinal java.util.List<org.apache.hadoop.fs.FileStatus> status_";
  protected final String TEXT_104 = " = new java.util.ArrayList<org.apache.hadoop.fs.FileStatus>();" + NL + "\tfinal org.apache.hadoop.fs.FileSystem filesystem_";
  protected final String TEXT_105 = " = fs_";
  protected final String TEXT_106 = ";" + NL + "\tfilesystem_";
  protected final String TEXT_107 = ".listStatus(hdfsdir_";
  protected final String TEXT_108 = ",new org.apache.hadoop.fs.PathFilter() {" + NL + "\t" + NL + "\t\tpublic boolean accept(org.apache.hadoop.fs.Path path) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\torg.apache.hadoop.fs.FileStatus statu = filesystem_";
  protected final String TEXT_109 = ".getFileStatus(path);" + NL + "\t\t\t\tif(statu.isDir()) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\tstatus_";
  protected final String TEXT_111 = ".add(statu);" + NL + "\t\t\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\tfilesystem_";
  protected final String TEXT_114 = ".listStatus(path, this);" + NL + "\t\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\tstatus_";
  protected final String TEXT_117 = ".add(statu);" + NL + "\t\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t}" + NL + "\t\t\t} catch (java.io.FileNotFoundException e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t} catch (java.io.IOException e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t});" + NL + "\t" + NL + "\t";
  protected final String TEXT_119 = NL + "\tjava.util.Collections.sort(status_";
  protected final String TEXT_120 = ");" + NL + "\t";
  protected final String TEXT_121 = NL + "\tjava.util.Collections.sort(status_";
  protected final String TEXT_122 = ",new java.util.Comparator<org.apache.hadoop.fs.FileStatus>() {" + NL + "\t" + NL + "\t\tpublic int compare(org.apache.hadoop.fs.FileStatus f1, org.apache.hadoop.fs.FileStatus f2) {" + NL + "\t\t\tint result = 0;" + NL + "\t\t\tboolean f1IsFile = !f1.isDir(); " + NL + "\t\t\tboolean f2IsFile = !f2.isDir();" + NL + "\t\t\t" + NL + "\t\t\tif((f1IsFile && f2IsFile) || (!f1IsFile && !f2IsFile)) {" + NL + "\t\t\t\tresult = f1.getPath().getName().compareTo(f2.getPath().getName());" + NL + "\t\t\t} else if(f1IsFile && !f2IsFile) {" + NL + "\t\t\t\tresult = 1;" + NL + "\t\t\t} else if(!f1IsFile && f2IsFile) {" + NL + "\t\t\t\tresult = -1;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_123 = "-";
  protected final String TEXT_124 = "result;" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t});" + NL + "\t";
  protected final String TEXT_125 = NL + "\tjava.util.Collections.sort(status_";
  protected final String TEXT_126 = ",new java.util.Comparator<org.apache.hadoop.fs.FileStatus>() {" + NL + "\t" + NL + "\t\tpublic int compare(org.apache.hadoop.fs.FileStatus f1, org.apache.hadoop.fs.FileStatus f2) {" + NL + "\t\t\tint result = 0;" + NL + "\t\t\tboolean f1IsFile = !f1.isDir(); " + NL + "\t\t\tboolean f2IsFile = !f2.isDir();" + NL + "\t\t\t" + NL + "\t\t\tif(f1IsFile && f2IsFile) {" + NL + "\t\t\t\tlong size_1 = f1.getLen();" + NL + "            \tlong size_2 = f2.getLen();" + NL + "                if (size_1 == size_2) {" + NL + "                    result = f1.getPath().getName().compareTo(f2.getPath().getName());" + NL + "                } else if (size_1 > size_2) {" + NL + "                    result = 1;" + NL + "                } else {" + NL + "                    result = -1;" + NL + "                }" + NL + "\t\t\t} else if(f1IsFile && !f2IsFile) {" + NL + "\t\t\t\tresult = 1;" + NL + "\t\t\t} else if(!f1IsFile && f2IsFile) {" + NL + "\t\t\t\tresult = -1;" + NL + "\t\t\t} else if(!f1IsFile && !f2IsFile) {" + NL + "\t\t\t\tresult = f1.getPath().getName().compareTo(f2.getPath().getName());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_127 = "-";
  protected final String TEXT_128 = "result;" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t});" + NL + "\t";
  protected final String TEXT_129 = NL + "\tjava.util.Collections.sort(status_";
  protected final String TEXT_130 = ",new java.util.Comparator<org.apache.hadoop.fs.FileStatus>() {" + NL + "\t" + NL + "\t\tpublic int compare(org.apache.hadoop.fs.FileStatus f1, org.apache.hadoop.fs.FileStatus f2) {" + NL + "\t\t\tint result = 0;" + NL + "\t\t\tboolean f1IsFile = !f1.isDir(); " + NL + "\t\t\tboolean f2IsFile = !f2.isDir();" + NL + "\t\t\t" + NL + "\t\t\tif((f1IsFile && f2IsFile) || (!f1IsFile && !f2IsFile)) {" + NL + "\t\t\t\tif(f1.getModificationTime() == f2.getModificationTime()) {" + NL + "\t\t\t\t\tresult = f1.getPath().getName().compareTo(f2.getPath().getName());" + NL + "\t\t\t\t} else if(f1.getModificationTime() > f2.getModificationTime()) {" + NL + "\t\t\t\t\tresult = 1;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tresult = -1;" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if(f1IsFile && !f2IsFile) {" + NL + "\t\t\t\tresult = 1;" + NL + "\t\t\t} else if(!f1IsFile && f2IsFile) {" + NL + "\t\t\t\tresult = -1;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_131 = "-";
  protected final String TEXT_132 = "result;" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t});" + NL + "\t";
  protected final String TEXT_133 = NL + "\t" + NL + "\tfor(int i_";
  protected final String TEXT_134 = "=0;i_";
  protected final String TEXT_135 = "<status_";
  protected final String TEXT_136 = ".size();i_";
  protected final String TEXT_137 = "++) {//TD512" + NL + "\t\torg.apache.hadoop.fs.FileStatus file_";
  protected final String TEXT_138 = " = status_";
  protected final String TEXT_139 = ".get(i_";
  protected final String TEXT_140 = ");" + NL + "\t\torg.apache.hadoop.fs.Path path_";
  protected final String TEXT_141 = " = file_";
  protected final String TEXT_142 = ".getPath();" + NL + "\t\tString fileName_";
  protected final String TEXT_143 = " = path_";
  protected final String TEXT_144 = ".getName();" + NL + "\t\t" + NL + "\t\tif (!fileNamePattern_";
  protected final String TEXT_145 = ".matcher(fileName_";
  protected final String TEXT_146 = ").matches()){" + NL + "          continue;" + NL + "        }" + NL + "        " + NL + "\t\t";
  protected final String TEXT_147 = " " + NL + "        boolean isExclude_";
  protected final String TEXT_148 = " = false;" + NL + "        for(java.util.regex.Pattern pattern : excludefileNameEachPattern_";
  protected final String TEXT_149 = ") {" + NL + "        \tif(pattern.matcher(fileName_";
  protected final String TEXT_150 = ").matches()) {" + NL + "        \t\tisExclude_";
  protected final String TEXT_151 = " = true;" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        }" + NL + "        if(isExclude_";
  protected final String TEXT_152 = ") {" + NL + "          continue;" + NL + "        }" + NL + "\t\t";
  protected final String TEXT_153 = NL + "\t\t" + NL + "\t\tString currentFileName_";
  protected final String TEXT_154 = " = fileName_";
  protected final String TEXT_155 = ";" + NL + "\t\tString currentFilePath_";
  protected final String TEXT_156 = " = path_";
  protected final String TEXT_157 = ".toString();" + NL + "\t\tString currentFileDirectory_";
  protected final String TEXT_158 = " = path_";
  protected final String TEXT_159 = ".getParent().toString();" + NL + "\t\tString currentFileExtension_";
  protected final String TEXT_160 = " = \"\";" + NL + "\t\tif(!file_";
  protected final String TEXT_161 = ".isDir() && fileName_";
  protected final String TEXT_162 = ".contains(\".\")) {" + NL + "\t\t\tcurrentFileExtension_";
  protected final String TEXT_163 = " = fileName_";
  protected final String TEXT_164 = ".substring(fileName_";
  protected final String TEXT_165 = ".lastIndexOf(\".\")+1);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tNB_FILE";
  protected final String TEXT_166 = " ++;" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_167 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_168 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_169 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_170 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_171 = "_CURRENT_FILEDIRECTORY\", currentFileDirectory_";
  protected final String TEXT_172 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_173 = "_CURRENT_FILEEXTENSION\", currentFileExtension_";
  protected final String TEXT_174 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_175 = "_NB_FILE\", NB_FILE";
  protected final String TEXT_176 = ");" + NL + "\t\t";
  protected final String TEXT_177 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
String user = null;

String fsDefalutName = "fs.default.name";

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
       
if(!useExistingConnection) { // if we don't use an existing connection, we create a new hadoop configuration
	String hadoopVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
	
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	String auth = ElementParameterParser.getValue(node, "__AUTHENTICATION_MODE__");
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_10);
    
	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){
		
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_14);
     
		}
	}
	
	if(!(((("HDP_1_0").equals(hadoopVersion) || ("HDP_1_2").equals(hadoopVersion) || ("HDP_1_3").equals(hadoopVersion) || ("HDP_2_0").equals(hadoopVersion) || ("APACHE_1_0_0").equals(hadoopVersion) || ("APACHE_1_0_3_EMR").equals(hadoopVersion) || ("Cloudera_CDH4").equals(hadoopVersion) || ("Cloudera_CDH4_YARN").equals(hadoopVersion)) && useKrb && !isCustom)
	   || (isCustom && "KRB".equals(auth)))) {
		user = ElementParameterParser.getValue(node, "__USERNAME__");
	} else {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_17);
    
		if(useKeytab) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_20);
    
		}
	}
	
	if(((("APACHE_0_20_2").equals(hadoopVersion) || ("MAPR1").equals(hadoopVersion) || ("MAPR2").equals(hadoopVersion) || ("MAPR212").equals(hadoopVersion) || ("MAPR213").equals(hadoopVersion) || ("MAPR301").equals(hadoopVersion) || ("MapR_EMR").equals(hadoopVersion)) && !isCustom) || (isCustom && "UGI".equals(auth))){
		String group = ElementParameterParser.getValue(node, "__GROUP__");
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
	}else{
	
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(user);
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
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	}
	
} else { // We re use the existing connection, coming from the component learned.
	String connectionSid = ElementParameterParser.getValue(node, "__CONNECTION__");
	
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(connectionSid);
    stringBuffer.append(TEXT_41);
    
	List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
		if (targetNode.getUniqueName().equals(connectionSid)) {
        	String hadoopVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__"); 
    		boolean useKrb = "true".equals(ElementParameterParser.getValue(targetNode, "__USE_KRB__"));
    		String kerberosPrincipal = ElementParameterParser.getValue(targetNode, "__NAMENODE_PRINCIPAL__");
    		
    		boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(targetNode, "__DISTRIBUTION__"));
    		String auth = ElementParameterParser.getValue(targetNode, "__AUTHENTICATION_MODE__");
		
	      	if(((("APACHE_0_20_2").equals(hadoopVersion) || ("MAPR1").equals(hadoopVersion) || ("MAPR2").equals(hadoopVersion) || ("MAPR212").equals(hadoopVersion) || ("MAPR213").equals(hadoopVersion) || ("MAPR301").equals(hadoopVersion) || ("MapR_EMR").equals(hadoopVersion)) && !isCustom) || (isCustom && "UGI".equals(auth))){
		    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
		  	}else{
				if(!(((("HDP_1_0").equals(hadoopVersion) || ("HDP_1_2").equals(hadoopVersion) || ("HDP_1_3").equals(hadoopVersion) || ("APACHE_1_0_0").equals(hadoopVersion) || ("APACHE_1_0_3_EMR").equals(hadoopVersion) || ("Cloudera_CDH4").equals(hadoopVersion) || ("Cloudera_CDH4_YARN").equals(hadoopVersion)) && !isCustom && useKrb) || (isCustom && "KRB".equals(auth)))) {
					user = ElementParameterParser.getValue(targetNode, "__USERNAME__");
				} else {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_47);
    
				}
			  	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(user);
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
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		  	}
	      	break;
	    }
    }
}

    stringBuffer.append(TEXT_60);
    
	String path = ElementParameterParser.getValue(node, "__PATH__");
	String hdfsdir = ElementParameterParser.getValue(node, "__DIRECTORY__");
	boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDSUBDIR__"));
  	boolean ifexclude = ("true").equals(ElementParameterParser.getValue(node, "__IFEXCLUDE__"));
  	String filelistType = ElementParameterParser.getValue(node, "__LIST_MODE__");
  	boolean useGlob = ("true").equals(ElementParameterParser.getValue(node, "__GLOBEXPRESSIONS__"));
  	List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
  	boolean caseSensitive = ("YES").equals(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__"));
  	String excludefilemask = ElementParameterParser.getValue(node, "__EXCLUDEFILEMASK__");
  	
	boolean bOrdByDefault = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_NOTHING__"));
    boolean bOrdByFileName = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILENAME__"));
    boolean bOrdByFileSize = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILESIZE__"));
    boolean bOrdByModifiedTime = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_MODIFIEDDATE__"));
    
    boolean bOrdASC = "true".equals(ElementParameterParser.getValue(node, "__ORDER_ACTION_ASC__"));

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
    if (files.size() == 0){
		if (useGlob){
    	
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
	    } else {
	    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
	    }
	}
  	
  	for (int i = 0; i < files.size(); i++) {
    	Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    if(useGlob) {
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    }
	
	if (ifexclude){
    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(excludefilemask);
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
    if (useGlob){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    }
  	 		if(!caseSensitive){
		  	
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    } else {
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    }
    
    if(caseSensitive) {
    
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    } else {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
     } 
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(hdfsdir);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    if(("DIRECTORIES OR BOTH").contains(filelistType)) {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    if(incldSubdir) {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    if(("FILES OR BOTH").contains(filelistType)) {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    if(bOrdByDefault){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    } else if(bOrdByFileName) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    if(!bOrdASC) {
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    } else if(bOrdByFileSize) {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    if(!bOrdASC) {
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    } else if(bOrdByModifiedTime) {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    if(!bOrdASC) {
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    if (ifexclude){
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(TEXT_177);
    return stringBuffer.toString();
  }
}

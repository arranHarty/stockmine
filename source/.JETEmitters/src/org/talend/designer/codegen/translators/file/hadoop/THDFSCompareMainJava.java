package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THDFSCompareMainJava
{
  protected static String nl;
  public static synchronized THDFSCompareMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSCompareMainJava result = new THDFSCompareMainJava();
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
  protected final String TEXT_61 = NL + "\tboolean result_";
  protected final String TEXT_62 = " = true;" + NL + "\t" + NL + "\torg.apache.hadoop.fs.Path path_";
  protected final String TEXT_63 = " = new org.apache.hadoop.fs.Path(";
  protected final String TEXT_64 = ");" + NL + "\torg.apache.hadoop.fs.Path ref_path_";
  protected final String TEXT_65 = " = new org.apache.hadoop.fs.Path(";
  protected final String TEXT_66 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_67 = NL + "\tlong fileLength_";
  protected final String TEXT_68 = " = fs_";
  protected final String TEXT_69 = ".getFileStatus(path_";
  protected final String TEXT_70 = ").getLen();" + NL + "\tlong fileRefLength_";
  protected final String TEXT_71 = " = fs_";
  protected final String TEXT_72 = ".getFileStatus(ref_path_";
  protected final String TEXT_73 = ").getLen();" + NL + "\tif(fileLength_";
  protected final String TEXT_74 = " != fileRefLength_";
  protected final String TEXT_75 = ")" + NL + "\t{" + NL + "\t\tresult_";
  protected final String TEXT_76 = " = false;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_77 = NL + "\tif (result_";
  protected final String TEXT_78 = ")" + NL + "\t{" + NL + "\t\torg.apache.hadoop.fs.FSDataInputStream file_is_";
  protected final String TEXT_79 = " = fs_";
  protected final String TEXT_80 = ".open(path_";
  protected final String TEXT_81 = ");" + NL + "\t\torg.apache.hadoop.fs.FSDataInputStream file_ref_is_";
  protected final String TEXT_82 = " = fs_";
  protected final String TEXT_83 = ".open(ref_path_";
  protected final String TEXT_84 = ");" + NL + "\t";
  protected final String TEXT_85 = NL + "\t\tjava.io.BufferedReader file_";
  protected final String TEXT_86 = " = new java.io.BufferedReader(new java.io.InputStreamReader(file_is_";
  protected final String TEXT_87 = ",";
  protected final String TEXT_88 = "));" + NL + "\t\tjava.io.BufferedReader fileRef_";
  protected final String TEXT_89 = " = new java.io.BufferedReader(new java.io.InputStreamReader(file_ref_is_";
  protected final String TEXT_90 = ",";
  protected final String TEXT_91 = "));" + NL + "\t\tString content_";
  protected final String TEXT_92 = " = null,contentRef_";
  protected final String TEXT_93 = " = null;" + NL + "\t\twhile((content_";
  protected final String TEXT_94 = " = file_";
  protected final String TEXT_95 = ".readLine()) != null && (contentRef_";
  protected final String TEXT_96 = " = fileRef_";
  protected final String TEXT_97 = ".readLine()) != null)" + NL + "\t\t{" + NL + "\t\t\tif(content_";
  protected final String TEXT_98 = ".compareTo(contentRef_";
  protected final String TEXT_99 = ") != 0)" + NL + "\t\t\t{" + NL + "\t\t\t\tresult_";
  protected final String TEXT_100 = " = false;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t// Check if files has a different number of lines:" + NL + "\t\tif(content_";
  protected final String TEXT_101 = " == null){" + NL + "\t\t    // This step is done in case of the while upper ignore second part:" + NL + "\t\t    contentRef_";
  protected final String TEXT_102 = " = fileRef_";
  protected final String TEXT_103 = ".readLine();" + NL + "\t\t}" + NL + "\t\tif(content_";
  protected final String TEXT_104 = " != null || contentRef_";
  protected final String TEXT_105 = " != null){" + NL + "\t\t    result_";
  protected final String TEXT_106 = " = false;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tfile_";
  protected final String TEXT_107 = ".close();" + NL + "\t\tfileRef_";
  protected final String TEXT_108 = ".close();" + NL + "\t\t";
  protected final String TEXT_109 = NL + "    \tjava.io.BufferedInputStream file_";
  protected final String TEXT_110 = " = new java.io.BufferedInputStream(file_is_";
  protected final String TEXT_111 = ");" + NL + "    \tjava.io.BufferedInputStream fileRef_";
  protected final String TEXT_112 = " = new java.io.BufferedInputStream(file_ref_is_";
  protected final String TEXT_113 = ");" + NL + "    \tint content_";
  protected final String TEXT_114 = " = -1,contentRef_";
  protected final String TEXT_115 = " = -1;" + NL + "    \twhile((content_";
  protected final String TEXT_116 = " = file_";
  protected final String TEXT_117 = ".read()) != -1 && (contentRef_";
  protected final String TEXT_118 = " = fileRef_";
  protected final String TEXT_119 = ".read()) != -1)" + NL + "    \t{" + NL + "    \t\tif(content_";
  protected final String TEXT_120 = " != contentRef_";
  protected final String TEXT_121 = ")" + NL + "    \t\t{" + NL + "    \t\t\tresult_";
  protected final String TEXT_122 = " = false;" + NL + "    \t\t\tbreak;" + NL + "    \t\t}" + NL + "    \t}" + NL + "    \tfile_";
  protected final String TEXT_123 = ".close();" + NL + "    \tfileRef_";
  protected final String TEXT_124 = ".close();\t\t\t" + NL + "\t\t";
  protected final String TEXT_125 = NL + "\t}" + NL + "" + NL + "\tString message";
  protected final String TEXT_126 = " = \"\";" + NL + "\tif (result_";
  protected final String TEXT_127 = ") {" + NL + "\t\tmessage";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = ";" + NL + "\t\t" + NL + "\t} else {" + NL + "\t\tmessage";
  protected final String TEXT_130 = " = ";
  protected final String TEXT_131 = ";" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_132 = "_DIFFERENCE\",result_";
  protected final String TEXT_133 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_134 = NL + "    System.out.println(message";
  protected final String TEXT_135 = ");" + NL + "\t";
  protected final String TEXT_136 = NL + "\t";
  protected final String TEXT_137 = ".file = ";
  protected final String TEXT_138 = ";" + NL + "\t";
  protected final String TEXT_139 = ".file_ref = ";
  protected final String TEXT_140 = ";\t" + NL + "\t";
  protected final String TEXT_141 = ".moment = java.util.Calendar.getInstance().getTime();" + NL + "\t";
  protected final String TEXT_142 = ".job = jobName;" + NL + "\t";
  protected final String TEXT_143 = ".component = currentComponent;" + NL + "\t";
  protected final String TEXT_144 = ".differ = (result_";
  protected final String TEXT_145 = ")?0:1;" + NL + "\t";
  protected final String TEXT_146 = ".message = message";
  protected final String TEXT_147 = ";" + NL + "\t";
  protected final String TEXT_148 = NL + "\t";
  protected final String TEXT_149 = NL;

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
    
	String file = ElementParameterParser.getValue(node, "__FILE__");
	Boolean print = new Boolean(ElementParameterParser.getValue(node, "__PRINT__"));
	String differMessage = ElementParameterParser.getValue(node, "__DIFFER_MESSAGE__");
	String noDifferMessage = ElementParameterParser.getValue(node, "__NO_DIFFER_MESSAGE__");
	String fileRef = ElementParameterParser.getValue(node, "__FILE_REF__");
	String cmpMode = ElementParameterParser.getValue(node, "__COMPARISON_MODE__");
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(fileRef);
    stringBuffer.append(TEXT_66);
    
	if(!("TEXT_CMP").equals(cmpMode))
	{
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    }
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
    
	if(("TEXT_CMP").equals(cmpMode))
	{
		
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(encoding );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
	}
	else
	{
		
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
	}
	
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(noDifferMessage);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(differMessage);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    
	if (print) {
	
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    
	}
	
	for (IConnection conn : node.getOutgoingConnections()) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	
    stringBuffer.append(TEXT_136);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(file );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(fileRef );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    
		}
	}
	
    stringBuffer.append(TEXT_148);
    stringBuffer.append(TEXT_149);
    return stringBuffer.toString();
  }
}

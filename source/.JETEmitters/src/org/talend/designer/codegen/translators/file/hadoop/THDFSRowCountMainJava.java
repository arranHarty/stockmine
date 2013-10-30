package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THDFSRowCountMainJava
{
  protected static String nl;
  public static synchronized THDFSRowCountMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSRowCountMainJava result = new THDFSRowCountMainJava();
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
  protected final String TEXT_60 = NL + "\t\t";
  protected final String TEXT_61 = NL + "\t  String filename_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = ";" + NL + "\t  int emptyLineCount_";
  protected final String TEXT_64 = " = 0;" + NL + "\t  org.apache.hadoop.fs.Path file_";
  protected final String TEXT_65 = " = new org.apache.hadoop.fs.Path(filename_";
  protected final String TEXT_66 = ");" + NL + "\t  org.apache.hadoop.fs.FSDataInputStream fsdis_";
  protected final String TEXT_67 = " = fs_";
  protected final String TEXT_68 = ".open(file_";
  protected final String TEXT_69 = ");" + NL + "\t" + NL + "\t  int lineCount_";
  protected final String TEXT_70 = " = 0;" + NL + "\t  " + NL + "\t  ";
  protected final String TEXT_71 = NL + "\t  \tjava.io.BufferedReader br_";
  protected final String TEXT_72 = " = new java.io.BufferedReader(new java.io.InputStreamReader(fsdis_";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = "));" + NL + "\t  ";
  protected final String TEXT_75 = NL + "\t    org.apache.hadoop.io.compress.GzipCodec codec_";
  protected final String TEXT_76 = " = new org.apache.hadoop.io.compress.GzipCodec();" + NL + "\t\tcodec_";
  protected final String TEXT_77 = ".setConf(conf_";
  protected final String TEXT_78 = ");\t" + NL + "\t  ";
  protected final String TEXT_79 = NL + "\t  \torg.apache.hadoop.io.compress.CompressionCodec codec_";
  protected final String TEXT_80 = " = org.apache.hadoop.util.ReflectionUtils.newInstance(org.apache.hadoop.io.compress.BZip2Codec.class, conf_";
  protected final String TEXT_81 = ");" + NL + "\t  ";
  protected final String TEXT_82 = NL + "\t  \torg.apache.hadoop.io.compress.CompressionInputStream in";
  protected final String TEXT_83 = " = codec_";
  protected final String TEXT_84 = ".createInputStream(fsdis_";
  protected final String TEXT_85 = ");" + NL + "\t  \tjava.io.BufferedReader br_";
  protected final String TEXT_86 = " = new java.io.BufferedReader(new java.io.InputStreamReader(in";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = "));" + NL + "\t  ";
  protected final String TEXT_89 = NL + "\t  " + NL + "\t  \t\t\t" + NL + "\t  String rowSeparator_";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = ";" + NL + "\t  byte[] bytes_";
  protected final String TEXT_92 = " = rowSeparator_";
  protected final String TEXT_93 = ".getBytes();" + NL + "\t  int index_";
  protected final String TEXT_94 = " = 0, oneChar_";
  protected final String TEXT_95 = " = 0, tipEmptyLineCount_";
  protected final String TEXT_96 = " = 0; " + NL + "\t  boolean bTipEmptyFlagOpen_";
  protected final String TEXT_97 = " = true, bReadyEOF_";
  protected final String TEXT_98 = " = false;" + NL + "\t\t\t" + NL + "\t  if(bytes_";
  protected final String TEXT_99 = ".length > 0) {" + NL + "\t    while ((oneChar_";
  protected final String TEXT_100 = " = br_";
  protected final String TEXT_101 = ".read()) != -1) {" + NL + "\t      if (oneChar_";
  protected final String TEXT_102 = " == bytes_";
  protected final String TEXT_103 = "[index_";
  protected final String TEXT_104 = "]) {" + NL + "\t      " + NL + "\t        if (index_";
  protected final String TEXT_105 = " < bytes_";
  protected final String TEXT_106 = ".length - 1){" + NL + "\t          index_";
  protected final String TEXT_107 = " ++ ;" + NL + "\t          continue; // match next char" + NL + "\t        }" + NL + "\t        " + NL + "\t        if (index_";
  protected final String TEXT_108 = " == bytes_";
  protected final String TEXT_109 = ".length - 1) {                  " + NL + "\t          lineCount_";
  protected final String TEXT_110 = "++;" + NL + "\t          if(bTipEmptyFlagOpen_";
  protected final String TEXT_111 = ") {" + NL + "\t            tipEmptyLineCount_";
  protected final String TEXT_112 = " ++;" + NL + "\t            emptyLineCount_";
  protected final String TEXT_113 = " ++;" + NL + "\t          }" + NL + "\t          bReadyEOF_";
  protected final String TEXT_114 = " = false; // next row must be have char(or EOF flag)" + NL + "\t          bTipEmptyFlagOpen_";
  protected final String TEXT_115 = " = true; " + NL + "\t          index_";
  protected final String TEXT_116 = " = 0;" + NL + "\t        }" + NL + "\t        " + NL + "\t      }else{      " + NL + "\t        bReadyEOF_";
  protected final String TEXT_117 = " = true;" + NL + "\t        bTipEmptyFlagOpen_";
  protected final String TEXT_118 = " = false;" + NL + "\t        tipEmptyLineCount_";
  protected final String TEXT_119 = " = 0;" + NL + "\t        index_";
  protected final String TEXT_120 = " = 0;        " + NL + "\t      }" + NL + "\t    }" + NL + "\t    " + NL + "\t    if (bReadyEOF_";
  protected final String TEXT_121 = ") lineCount_";
  protected final String TEXT_122 = " ++ ; // add last row if not end by row separator" + NL + "\t    " + NL + "\t    if (bTipEmptyFlagOpen_";
  protected final String TEXT_123 = ") {" + NL + "\t      lineCount_";
  protected final String TEXT_124 = " -= tipEmptyLineCount_";
  protected final String TEXT_125 = ";" + NL + "\t      emptyLineCount_";
  protected final String TEXT_126 = " -= tipEmptyLineCount_";
  protected final String TEXT_127 = ";" + NL + "\t    }          " + NL + "\t  }" + NL + "\t  br_";
  protected final String TEXT_128 = ".close();" + NL + "\t";
  protected final String TEXT_129 = NL + "  \tlineCount_";
  protected final String TEXT_130 = " -= emptyLineCount_";
  protected final String TEXT_131 = ";" + NL + "\t";
  protected final String TEXT_132 = "   " + NL + "  \tglobalMap.put(\"";
  protected final String TEXT_133 = "_COUNT\",lineCount_";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = NL;

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
    	
	 String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	 String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
	 String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	 boolean ignoreEmptyRow = "true".equals(ElementParameterParser.getValue(node, "__IGNORE_EMPTY_ROW__"));
	
	 boolean uncompress = "true".equals(ElementParameterParser.getValue(node, "__UNCOMPRESS__"));
	 String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
	  if(!uncompress) {
	  
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_74);
    
	  } else {
	  	if("GZIP".equals(compression)) {
	  
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
	  	} else if("BZIP2".equals(compression)) {
	  
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
	  	}
	  
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_88);
    
	  }
	  
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
  	if (ignoreEmptyRow){
	
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(TEXT_135);
    return stringBuffer.toString();
  }
}

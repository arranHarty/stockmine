package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THDFSOutputBeginJava
{
  protected static String nl;
  public static synchronized THDFSOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSOutputBeginJava result = new THDFSOutputBeginJava();
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
  protected final String TEXT_60 = NL;
  protected final String TEXT_61 = NL + "\t\torg.apache.hadoop.fs.Path path_";
  protected final String TEXT_62 = " = new org.apache.hadoop.fs.Path(";
  protected final String TEXT_63 = ");" + NL;
  protected final String TEXT_64 = "\t\t\t" + NL + "\t\torg.apache.hadoop.fs.FSDataOutputStream fsDataOutputStream_";
  protected final String TEXT_65 = " = null;" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\t\tfsDataOutputStream_";
  protected final String TEXT_67 = " = fs_";
  protected final String TEXT_68 = ".append(path_";
  protected final String TEXT_69 = ");" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t\tfsDataOutputStream_";
  protected final String TEXT_71 = " = fs_";
  protected final String TEXT_72 = ".create(path_";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ");" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\t\tjava.io.Writer out";
  protected final String TEXT_76 = " = null;" + NL + "\t\t\tout";
  protected final String TEXT_77 = "=new java.io.BufferedWriter(new java.io.OutputStreamWriter(fsDataOutputStream_";
  protected final String TEXT_78 = ",";
  protected final String TEXT_79 = "));" + NL + "\t";
  protected final String TEXT_80 = NL + "\t\t\t\torg.apache.hadoop.io.compress.GzipCodec codec_";
  protected final String TEXT_81 = " = new org.apache.hadoop.io.compress.GzipCodec();" + NL + "\t\t\t\tcodec_";
  protected final String TEXT_82 = ".setConf(conf_";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "\t\t\t\torg.apache.hadoop.io.compress.CompressionCodec codec_";
  protected final String TEXT_85 = " = org.apache.hadoop.util.ReflectionUtils.newInstance(org.apache.hadoop.io.compress.BZip2Codec.class, conf_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\t\torg.apache.hadoop.io.compress.CompressionOutputStream out";
  protected final String TEXT_88 = " = codec_";
  protected final String TEXT_89 = ".createOutputStream(fsDataOutputStream_";
  protected final String TEXT_90 = ");";
  protected final String TEXT_91 = NL + "\t\t\tboolean fileExistAndHasContent_";
  protected final String TEXT_92 = " = false;" + NL + "\t\t\tif(fs_";
  protected final String TEXT_93 = ".exists(path_";
  protected final String TEXT_94 = ")) {" + NL + "\t\t\t\torg.apache.hadoop.fs.FileStatus statu_";
  protected final String TEXT_95 = " = fs_";
  protected final String TEXT_96 = ".getFileStatus(path_";
  protected final String TEXT_97 = ");" + NL + "\t\t\t\tfileExistAndHasContent_";
  protected final String TEXT_98 = " = (!statu_";
  protected final String TEXT_99 = ".isDir()) && (statu_";
  protected final String TEXT_100 = ".getLen() != 0);" + NL + "\t\t\t}" + NL + "\t\t\tif(!fileExistAndHasContent_";
  protected final String TEXT_101 = ") {";
  protected final String TEXT_102 = NL + "\t\t\tStringBuilder header_";
  protected final String TEXT_103 = " = new StringBuilder();";
  protected final String TEXT_104 = NL + "\t\t\t\theader_";
  protected final String TEXT_105 = ".append(\"";
  protected final String TEXT_106 = "\");";
  protected final String TEXT_107 = NL + "                header_";
  protected final String TEXT_108 = ".append(";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\t\t\theader_";
  protected final String TEXT_111 = ".append(";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "\t\t\tout";
  protected final String TEXT_114 = ".write(header_";
  protected final String TEXT_115 = ".toString());";
  protected final String TEXT_116 = NL + "\t\t\tout";
  protected final String TEXT_117 = ".write(header_";
  protected final String TEXT_118 = ".toString().getBytes(";
  protected final String TEXT_119 = "));";
  protected final String TEXT_120 = NL + "\t\t\t}";
  protected final String TEXT_121 = NL + "\torg.apache.hadoop.io.SequenceFile.Writer writer_";
  protected final String TEXT_122 = " = new org.apache.hadoop.io.SequenceFile.Writer(fs_";
  protected final String TEXT_123 = ", conf_";
  protected final String TEXT_124 = ", path_";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ".class, ";
  protected final String TEXT_127 = ".class);" + NL + "\t";
  protected final String TEXT_128 = NL + "\torg.apache.hadoop.io.SequenceFile.Writer writer_";
  protected final String TEXT_129 = " = org.apache.hadoop.io.SequenceFile.createWriter(fs_";
  protected final String TEXT_130 = ", conf_";
  protected final String TEXT_131 = ", path_";
  protected final String TEXT_132 = ", ";
  protected final String TEXT_133 = ".class, ";
  protected final String TEXT_134 = ".class, org.apache.hadoop.io.SequenceFile.CompressionType.BLOCK, new org.apache.hadoop.io.compress.GzipCodec());";
  protected final String TEXT_135 = NL + "\torg.apache.hadoop.io.SequenceFile.Writer writer_";
  protected final String TEXT_136 = " = org.apache.hadoop.io.SequenceFile.createWriter(fs_";
  protected final String TEXT_137 = ", conf_";
  protected final String TEXT_138 = ", path_";
  protected final String TEXT_139 = ", ";
  protected final String TEXT_140 = ".class, ";
  protected final String TEXT_141 = ".class, org.apache.hadoop.io.SequenceFile.CompressionType.BLOCK, new org.apache.hadoop.io.compress.BZip2Codec());";
  protected final String TEXT_142 = NL + "\t\t\tList<";
  protected final String TEXT_143 = "Struct> ";
  protected final String TEXT_144 = "_list_";
  protected final String TEXT_145 = "= new java.util.ArrayList<";
  protected final String TEXT_146 = "Struct>();";
  protected final String TEXT_147 = NL;

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
    
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	IConnection inConn = null;
	IMetadataTable metadata = null;
	
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}
	
	if (metadata == null) {
		return stringBuffer.toString();
	}
	
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
	
	//boolean fileAction = "true".equals(ElementParameterParser.getValue(node, "__FILE_ACTION__"));
	String fileAction = ElementParameterParser.getValue(node, "__FILE_ACTION__");
	
	boolean customEncoding="true".equals( ElementParameterParser.getValue(node,"__CUSTOM_ENCODING__"));
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	
	String typeFile = ElementParameterParser.getValue(node,"__TYPEFILE__");
	
	boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
	String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
	
	boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_63);
    
	if (typeFile.equals("TEXT")) {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    if("APPEND".equals(fileAction)){
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    }else{//Create and Overwrite
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append("CREATE".equals(fileAction)?false:true);
    stringBuffer.append(TEXT_74);
    }
    
		if(!compress) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    if(customEncoding){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(encoding);
    }
    stringBuffer.append(TEXT_79);
    
		} else {
			if("GZIP".equals(compression)) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
			} else if("BZIP2".equals(compression)) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
			}

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
		}
		
		if(isIncludeHeader) {
			String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
        	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        	
			if("APPEND".equals(fileAction)){

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
    
			}

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    
    		List<IMetadataColumn> columns = metadata.getListColumns();
	        int sizeColumns = columns.size();
	        for (int i = 0; i < sizeColumns; i++) {
	        	IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    
	            if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_109);
    
	            }
	        }

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_112);
    
			if(!compress) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    
			} else {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(customEncoding?encoding:"");
    stringBuffer.append(TEXT_119);
    
			}
			if("APPEND".equals(fileAction)){

    stringBuffer.append(TEXT_120);
    
			}
		}
	} else {
		String keyColumn = ElementParameterParser.getValue(node,"__KEYCOLUMN__");
		String valueColumn = ElementParameterParser.getValue(node,"__VALUECOLUMN__");
			
		List<IMetadataColumn> listColumns = metadata.getListColumns();
		String talendKeyClass = "";
		String talendValueClass = "";
		for (IMetadataColumn column : listColumns) {
			if (column.getLabel().equals(keyColumn)) {
				talendKeyClass = column.getTalendType();
			}
			if (column.getLabel().equals(valueColumn)) {
				talendValueClass = column.getTalendType();
			}
		}
			
		String keyClass="org.apache.hadoop.io.Text";
		if (talendKeyClass.equals("id_Boolean")) keyClass="org.apache.hadoop.io.BooleanWritable";
		if (talendKeyClass.equals("id_Byte")) keyClass="org.apache.hadoop.io.ByteWritable";
		if (talendKeyClass.equals("id_byte[]")) keyClass="org.apache.hadoop.io.BytesWritable";
		if (talendKeyClass.equals("id_Double")) keyClass="org.apache.hadoop.io.DoubleWritable";
		if (talendKeyClass.equals("id_Float")) keyClass="org.apache.hadoop.io.FloatWritable";
		if (talendKeyClass.equals("id_Integer")) keyClass="org.apache.hadoop.io.IntWritable";
		if (talendKeyClass.equals("id_Long")) keyClass="org.apache.hadoop.io.LongWritable";
		if (talendKeyClass.equals("id_Short")) keyClass="org.apache.hadoop.io.ShortWritable";
		if (talendKeyClass.equals("id_String")) keyClass="org.apache.hadoop.io.Text";
			
		String valueClass="org.apache.hadoop.io.Text";
		if (talendValueClass.equals("id_Boolean")) valueClass="org.apache.hadoop.io.BooleanWritable";
		if (talendValueClass.equals("id_Byte")) valueClass="org.apache.hadoop.io.ByteWritable";
		if (talendValueClass.equals("id_byte[]")) valueClass="org.apache.hadoop.io.BytesWritable";
		if (talendValueClass.equals("id_Double")) valueClass="org.apache.hadoop.io.DoubleWritable";
		if (talendValueClass.equals("id_Float")) valueClass="org.apache.hadoop.io.FloatWritable";
		if (talendValueClass.equals("id_Integer")) valueClass="org.apache.hadoop.io.IntWritable";
		if (talendValueClass.equals("id_Long")) valueClass="org.apache.hadoop.io.LongWritable";
		if (talendValueClass.equals("id_Short")) valueClass="org.apache.hadoop.io.ShortWritable";
		if (talendValueClass.equals("id_String")) valueClass="org.apache.hadoop.io.Text";
		
		if(!compress) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_127);
    
		} else {
			if("GZIP".equals(compression)) {

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_134);
    
			} else if("BZIP2".equals(compression)) {

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_141);
    
			}
		}
	}
	
	if(node.isVirtualGenerateNode() && metadata!=null){
		if (inConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			String origin = ElementParameterParser.getValue(node, "__DESTINATION__");
			cid = origin;
			String con_name = org.talend.core.model.utils.NodeUtil.getPrivateConnClassName(inConn);

    stringBuffer.append(TEXT_142);
    stringBuffer.append(con_name);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(con_name);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(con_name);
    stringBuffer.append(TEXT_146);
    
		}
	}

    stringBuffer.append(TEXT_147);
    return stringBuffer.toString();
  }
}

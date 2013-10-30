package org.talend.designer.codegen.translators.databases.hbase;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THBaseOutputBeginJava
{
  protected static String nl;
  public static synchronized THBaseOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseOutputBeginJava result = new THBaseOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\torg.apache.hadoop.hbase.HTableDescriptor tableDes_";
  protected final String TEXT_2 = " = new org.apache.hadoop.hbase.HTableDescriptor(";
  protected final String TEXT_3 = ");" + NL + "\t\t\torg.apache.hadoop.hbase.HColumnDescriptor family_";
  protected final String TEXT_4 = " = null;";
  protected final String TEXT_5 = NL + "\t\t\t\tfamily_";
  protected final String TEXT_6 = " = new org.apache.hadoop.hbase.HColumnDescriptor(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\t\t\t\t\tfamily_";
  protected final String TEXT_9 = ".setInMemory(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\t\t\t\tfamily_";
  protected final String TEXT_12 = ".setBlockCacheEnabled(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t\t\t\tfamily_";
  protected final String TEXT_15 = ".setBloomFilterType(" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\torg.apache.hadoop.hbase.regionserver.BloomType.";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\torg.apache.hadoop.hbase.regionserver.StoreFile.BloomType.";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t);";
  protected final String TEXT_21 = NL + "\t\t\t\t\tfamily_";
  protected final String TEXT_22 = ".setBlocksize(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\t\t\t\t\tfamily_";
  protected final String TEXT_25 = ".setCompactionCompressionType(" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\torg.apache.hadoop.hbase.io.compress.Compression.Algorithm.";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\torg.apache.hadoop.hbase.io.hfile.Compression.Algorithm.";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t);";
  protected final String TEXT_31 = NL + "\t\t\t\t\tfamily_";
  protected final String TEXT_32 = ".setCompressionType(" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\torg.apache.hadoop.hbase.io.compress.Compression.Algorithm.";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\torg.apache.hadoop.hbase.io.hfile.Compression.Algorithm.";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\t);";
  protected final String TEXT_38 = NL + "\t\t\t\t\tfamily_";
  protected final String TEXT_39 = ".setMaxVersions(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t\t\t\tfamily_";
  protected final String TEXT_42 = ".setScope(";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\t\t\t\t\tfamily_";
  protected final String TEXT_45 = ".setTimeToLive(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\t\t\ttableDes_";
  protected final String TEXT_48 = ".addFamily(family_";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\tadmin_";
  protected final String TEXT_51 = ".createTable(tableDes_";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\tif(!admin_";
  protected final String TEXT_54 = ".isTableDisabled(";
  protected final String TEXT_55 = ")){" + NL + "\t\t\tadmin_";
  protected final String TEXT_56 = ".disableTable(";
  protected final String TEXT_57 = ");" + NL + "\t\t}" + NL + "\t\t\tadmin_";
  protected final String TEXT_58 = ".deleteTable(";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "int nb_line_";
  protected final String TEXT_61 = " = 0;" + NL + "org.apache.hadoop.conf.Configuration conn_";
  protected final String TEXT_62 = "=null;" + NL + "try{";
  protected final String TEXT_63 = NL + "\tconn_";
  protected final String TEXT_64 = " = org.apache.hadoop.hbase.HBaseConfiguration.create();" + NL + "\tconn_";
  protected final String TEXT_65 = ".clear();" + NL + "\tconn_";
  protected final String TEXT_66 = ".set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_67 = "); " + NL + "\tconn_";
  protected final String TEXT_68 = ".set(\"hbase.zookeeper.property.clientPort\",";
  protected final String TEXT_69 = "); " + NL + "\tconn_";
  protected final String TEXT_70 = ".set(\"hbase.cluster.distributed\",\"true\"); ";
  protected final String TEXT_71 = NL + "\t\tconn_";
  protected final String TEXT_72 = ".set(";
  protected final String TEXT_73 = ",";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\tconn_";
  protected final String TEXT_76 = " = (org.apache.hadoop.conf.Configuration)globalMap.get(\"";
  protected final String TEXT_77 = "\");" + NL + "\tif(conn_";
  protected final String TEXT_78 = " == null){" + NL + "\t\tthrow new RuntimeException(\"";
  protected final String TEXT_79 = "'s connection is null!\");" + NL + "\t}";
  protected final String TEXT_80 = NL + "\torg.apache.hadoop.hbase.client.HBaseAdmin admin_";
  protected final String TEXT_81 = " = new org.apache.hadoop.hbase.client.HBaseAdmin(conn_";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "\tboolean tableExist_";
  protected final String TEXT_84 = " = admin_";
  protected final String TEXT_85 = ".tableExists(";
  protected final String TEXT_86 = ");" + NL + "\tif(!tableExist_";
  protected final String TEXT_87 = "){";
  protected final String TEXT_88 = NL + "\t}";
  protected final String TEXT_89 = NL + "\tboolean tableExist_";
  protected final String TEXT_90 = " = admin_";
  protected final String TEXT_91 = ".tableExists(";
  protected final String TEXT_92 = ");" + NL + "\tif(tableExist_";
  protected final String TEXT_93 = "){";
  protected final String TEXT_94 = NL + "\t}";
  protected final String TEXT_95 = NL + "org.apache.hadoop.hbase.client.HTable table_";
  protected final String TEXT_96 = " = null;" + NL + "table_";
  protected final String TEXT_97 = " = new org.apache.hadoop.hbase.client.HTable(conn_";
  protected final String TEXT_98 = ",";
  protected final String TEXT_99 = ");" + NL + "byte[] temp_";
  protected final String TEXT_100 = " = null;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String zookeeper_quorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeper_client_port = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
	String table_name = ElementParameterParser.getValue(node, "__TABLE__");
	
	String version = null;
	String custom = null;
	
	if(!"true".equals(useExistingConn)) {
		version = ElementParameterParser.getValue(node, "__HBASE_VERSION__");
		custom =  ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	} else {
		String connectionSid = ElementParameterParser.getValue(node, "__CONNECTION__");
		List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
		for(INode targetNode : nodes){
			if (targetNode.getUniqueName().equals(connectionSid)) {
				version = ElementParameterParser.getValue(targetNode, "__HBASE_VERSION__");
				custom =  ElementParameterParser.getValue(targetNode, "__DISTRIBUTION__");
				break;
			}
		}
	}
	
	final String hbaseVersion = version;
	final boolean isCustom = "CUSTOM".equals(custom);
	
	class GenerateCode {
		
		public void generateCreateTable(INode node) {
			List<Map<String,String>> familyParameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FAMILY_PARAMETERS__");
			String table_name = ElementParameterParser.getValue(node, "__TABLE__");
			String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			for(int familyParamNum=0;familyParamNum<familyParameters.size();familyParamNum++){
				Map<String,String> mapParamLine = familyParameters.get(familyParamNum);
				String family_name = mapParamLine.get("FAMILY_NAME");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(family_name);
    stringBuffer.append(TEXT_7);
    
				String family_inmemory = mapParamLine.get("FAMILY_INMEMORY");
				String family_blockcacheenabled = mapParamLine.get("FAMILY_BLOCKCACHEENABLED");
				String family_bloomfiltertype = mapParamLine.get("FAMILY_BLOOMFILTERTYPE");
				String family_blocksize = mapParamLine.get("FAMILY_BLOCKSIZE");
				String family_compactioncompressiontype = mapParamLine.get("FAMILY_COMPACTIONCOMPRESSIONTYPE");
				String family_compressiontype = mapParamLine.get("FAMILY_COMPRESSIONTYPE");
				String family_maxversions = mapParamLine.get("FAMILY_MAXVERSIONS");
				String family_scope = mapParamLine.get("FAMILY_SCOPE");
				String family_timetolive = mapParamLine.get("FAMILY_TIMETOLIVE");
				if(family_inmemory!=null&&!"".equals(family_inmemory)){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(family_inmemory);
    stringBuffer.append(TEXT_10);
    
				}
				if(family_blockcacheenabled!=null&&!"".equals(family_blockcacheenabled)){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(family_blockcacheenabled);
    stringBuffer.append(TEXT_13);
    
				}
				if(family_bloomfiltertype!=null&&!"".equals(family_bloomfiltertype)){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    if(!isCustom && "HDP_2_0".equals(hbaseVersion)) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(family_bloomfiltertype);
    stringBuffer.append(TEXT_17);
    } else {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(family_bloomfiltertype);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    
				}
				if(family_blocksize!=null&&!"".equals(family_blocksize)){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(family_blocksize);
    stringBuffer.append(TEXT_23);
    
				}
				if(family_compactioncompressiontype!=null&&!"".equals(family_compactioncompressiontype)){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    if(!isCustom && "HDP_2_0".equals(hbaseVersion)) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(family_compactioncompressiontype);
    stringBuffer.append(TEXT_27);
    } else {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(family_compactioncompressiontype);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    
				}
				if(family_compressiontype!=null&&!"".equals(family_compressiontype)){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if(!isCustom && "HDP_2_0".equals(hbaseVersion)) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(family_compressiontype);
    stringBuffer.append(TEXT_34);
    } else {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(family_compressiontype);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
				}
				if(family_maxversions!=null&&!"".equals(family_maxversions)){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(family_maxversions);
    stringBuffer.append(TEXT_40);
    
				}
				if(family_scope!=null&&!"".equals(family_scope)){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(family_scope);
    stringBuffer.append(TEXT_43);
    
				}
				if(family_timetolive!=null&&!"".equals(family_timetolive)){

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(family_timetolive);
    stringBuffer.append(TEXT_46);
    
				}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			}//for(int familyParamNum=0;familyParamNum<familyParameters.size();familyParamNum++)

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
		}
		public void generateDropTable(INode node){
			String cid = node.getUniqueName();
			String table_name = ElementParameterParser.getValue(node, "__TABLE__");

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_59);
    
		}
	}
	GenerateCode generateCode = new GenerateCode();

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
     
// not use existing connection
if(!"true".equals(useExistingConn)){

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
	List<Map<String, String>> properties =
        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HBASE_PARAMETERS__");
   	for(int i=0;i<properties.size();i++){
   		Map<String, String> map = properties.get(i);
   		String property = map.get("PROPERTY");
   		String value= map.get("VALUE");

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(property);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_74);
    
   }
}else{// use existing connection
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
}

String table_action = ElementParameterParser.getValue(node, "__TABLE_ACTION__");
if(!"NONE".equals(table_action)){

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
}
if("NONE".equals(table_action)){
}else if("CREATE".equals(table_action)){
	generateCode.generateCreateTable(node);
}else if("DROP_CREATE".equals(table_action)){
	generateCode.generateDropTable(node);
	generateCode.generateCreateTable(node);
}else if("CREATE_IF_NOT_EXISTS".equals(table_action)){

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
		generateCode.generateCreateTable(node);

    stringBuffer.append(TEXT_88);
    
}else if("DROP_IF_EXISTS_AND_CREATE".equals(table_action)){

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
		generateCode.generateDropTable(node); 

    stringBuffer.append(TEXT_94);
    
	generateCode.generateCreateTable(node);
}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    return stringBuffer.toString();
  }
}

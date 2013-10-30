package org.talend.designer.codegen.translators.databases.hbase;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class THBaseInputBeginJava
{
  protected static String nl;
  public static synchronized THBaseInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseInputBeginJava result = new THBaseInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "org.apache.hadoop.conf.Configuration conn_";
  protected final String TEXT_3 = "=null;";
  protected final String TEXT_4 = NL + "try{" + NL + "\tconn_";
  protected final String TEXT_5 = " = org.apache.hadoop.hbase.HBaseConfiguration.create();" + NL + "\tconn_";
  protected final String TEXT_6 = ".clear();" + NL + "\tconn_";
  protected final String TEXT_7 = ".set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_8 = "); " + NL + "\tconn_";
  protected final String TEXT_9 = ".set(\"hbase.zookeeper.property.clientPort\",";
  protected final String TEXT_10 = "); " + NL + "\tconn_";
  protected final String TEXT_11 = ".set(\"hbase.cluster.distributed\",\"true\"); ";
  protected final String TEXT_12 = NL + "\t\tconn_";
  protected final String TEXT_13 = ".set(";
  protected final String TEXT_14 = ",";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tconn_";
  protected final String TEXT_17 = " = (org.apache.hadoop.conf.Configuration)globalMap.get(\"";
  protected final String TEXT_18 = "\");" + NL + "\tif(conn_";
  protected final String TEXT_19 = " == null){" + NL + "\t\tthrow new RuntimeException(\"";
  protected final String TEXT_20 = "'s connection is null!\");" + NL + "\t}";
  protected final String TEXT_21 = NL + "org.apache.hadoop.hbase.client.Scan scan_";
  protected final String TEXT_22 = " = new org.apache.hadoop.hbase.client.Scan();";
  protected final String TEXT_23 = NL + "\t\t\t\tscan_";
  protected final String TEXT_24 = ".addColumn(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_25 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_26 = "\"));";
  protected final String TEXT_27 = NL + "\t\t\t\tString [] multipleValues_";
  protected final String TEXT_28 = " = null;" + NL + "\t\t\t\tbyte [][] multipleBytesValues_";
  protected final String TEXT_29 = " = null;";
  protected final String TEXT_30 = "\t\t\t" + NL + "\t\t\torg.apache.hadoop.hbase.filter.FilterList filterList_";
  protected final String TEXT_31 = " = new org.apache.hadoop.hbase.filter.FilterList(org.apache.hadoop.hbase.filter.FilterList.Operator.";
  protected final String TEXT_32 = ");" + NL + "\t\t\torg.apache.hadoop.hbase.filter.Filter filter_";
  protected final String TEXT_33 = " = null;";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_35 = " = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_36 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_37 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_38 = ", org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_39 = "));";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_41 = " = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_42 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_43 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_44 = ", new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_45 = "));";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_47 = " = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_48 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_49 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_50 = ", new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_51 = "));";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_53 = " = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_54 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_55 = ")));";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_57 = " = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_58 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_59 = "));";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_61 = " = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_62 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_63 = "));";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_65 = " = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_66 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_67 = ")));";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_69 = " = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_70 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_71 = "));";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_73 = " = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_74 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_75 = "));";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\tscan_";
  protected final String TEXT_77 = ".addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_78 = "));";
  protected final String TEXT_79 = NL + "\t\t\t\t\tfilter_";
  protected final String TEXT_80 = " = new org.apache.hadoop.hbase.filter.ColumnPrefixFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_81 = "));";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\tscan_";
  protected final String TEXT_83 = ".addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_84 = "));";
  protected final String TEXT_85 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_86 = "!=null && !\"\".equals(";
  protected final String TEXT_87 = ")){" + NL + "\t\t\t\t\t\tmultipleValues_";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = ".split(\",\");" + NL + "\t\t\t\t\t\tmultipleBytesValues_";
  protected final String TEXT_90 = " = new byte [multipleValues_";
  protected final String TEXT_91 = ".length] [];" + NL + "\t\t\t\t\t\tfor(int i=0;i< multipleValues_";
  protected final String TEXT_92 = ".length;i++){" + NL + "\t\t\t\t\t\t\tmultipleBytesValues_";
  protected final String TEXT_93 = "[i] = org.apache.hadoop.hbase.util.Bytes.toBytes(multipleValues_";
  protected final String TEXT_94 = "[i]);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_95 = " =  new org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter(multipleBytesValues_";
  protected final String TEXT_96 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_97 = NL + "\t\t\t\t\t\tscan_";
  protected final String TEXT_98 = ".addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_99 = "));";
  protected final String TEXT_100 = NL + "\t\t\t\t\tfilter_";
  protected final String TEXT_101 = " = new org.apache.hadoop.hbase.filter.ColumnRangeFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_102 = ".split(\",\")[0]),true,org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_103 = ".split(\",\")[1]),true);";
  protected final String TEXT_104 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_105 = " = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_106 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_107 = ")));";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_109 = " = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_110 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_111 = "));";
  protected final String TEXT_112 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_113 = " = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_114 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_115 = "));";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_117 = " = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_118 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_119 = ")));";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_121 = " = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_122 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_123 = "));";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\tfilter_";
  protected final String TEXT_125 = " = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_126 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_127 = "));";
  protected final String TEXT_128 = NL + "\t\t\t\t\tfilterList_";
  protected final String TEXT_129 = ".addFilter(filter_";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "\t\t\tscan_";
  protected final String TEXT_132 = ".setFilter(filterList_";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = "\t\t" + NL + "\t\torg.apache.hadoop.hbase.client.HTable table_";
  protected final String TEXT_135 = " = new org.apache.hadoop.hbase.client.HTable(conn_";
  protected final String TEXT_136 = ", ";
  protected final String TEXT_137 = ");" + NL + "\t\tString temp_";
  protected final String TEXT_138 = "=null;" + NL + "\t\tbyte[] rowResult_";
  protected final String TEXT_139 = " = null;" + NL + "\t\torg.apache.hadoop.hbase.client.ResultScanner scanner_";
  protected final String TEXT_140 = " = table_";
  protected final String TEXT_141 = ".getScanner(scan_";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL + "\t\t\t\tfor (org.apache.hadoop.hbase.client.Result rr_";
  protected final String TEXT_144 = " = scanner_";
  protected final String TEXT_145 = ".next(); rr_";
  protected final String TEXT_146 = " != null; rr_";
  protected final String TEXT_147 = " = scanner_";
  protected final String TEXT_148 = ".next()) {";
  protected final String TEXT_149 = NL + "\t\t\t\t\t\t\t\trowResult_";
  protected final String TEXT_150 = " = rr_";
  protected final String TEXT_151 = ".getValue(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_152 = "),org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_153 = "\"));" + NL + "\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_154 = " = org.apache.hadoop.hbase.util.Bytes.toString(rowResult_";
  protected final String TEXT_155 = ");" + NL + "\t\t\t\t\t\t\t\tif(temp_";
  protected final String TEXT_156 = "!=null && temp_";
  protected final String TEXT_157 = ".length() > 0) {";
  protected final String TEXT_158 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_159 = ".";
  protected final String TEXT_160 = "=temp_";
  protected final String TEXT_161 = ".toString();";
  protected final String TEXT_162 = " " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_163 = ".";
  protected final String TEXT_164 = "=temp_";
  protected final String TEXT_165 = ".getBytes();";
  protected final String TEXT_166 = " " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = "=ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_169 = ", ";
  protected final String TEXT_170 = ");";
  protected final String TEXT_171 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = "=ParserUtils.parseTo_";
  protected final String TEXT_174 = "(temp_";
  protected final String TEXT_175 = ");";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = " = ";
  protected final String TEXT_180 = ";";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = " = null;";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_185 = "' in '";
  protected final String TEXT_186 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t\t\t}";

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
    boolean isByFilter = ("true").equals(ElementParameterParser.getValue(node, "__IS_BY_FILTER__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
     
// not use existing connection
if(!"true".equals(useExistingConn)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
	List<Map<String, String>> properties =
        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HBASE_PARAMETERS__");
   	for(int i=0;i<properties.size();i++){
   		Map<String, String> map = properties.get(i);
   		String property = map.get("PROPERTY");
   		String value= map.get("VALUE");

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(property);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_15);
    
   }
}else{// use existing connection
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    
}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
List<IMetadataTable> metadatas = node.getMetadataList();

    
if ((metadatas!=null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
		List<IMetadataColumn> columns = metadata.getListColumns();
		List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
		for(int i=0;i<mapping.size();i++){
			Map<String, String> map = mapping.get(i);
			IMetadataColumn column = columns.get(i);
			String schema_column = map.get("SCHEMA_COLUMN");
			String family_column= map.get("FAMILY_COLUMN");

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_26);
    
		}
		if(isByFilter){
			List<Map<String, String>> filterMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILTER__");
			String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
			boolean hasMultipleColumnPrefixFilterType = false;
			for(int i=0;i<filterMapping.size();i++){
				Map<String, String> filterMap = filterMapping.get(i);
				String filterType = filterMap.get("FILTER_TYPE");
				if("MultipleColumnPrefixFilter".equals(filterType)){
					hasMultipleColumnPrefixFilterType = true;
					break;
				} 
			}
			if(hasMultipleColumnPrefixFilterType){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
			}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    		
			for(int j=0;j<filterMapping.size();j++){
				Map<String, String> filterMap = filterMapping.get(j);
				String filterType = filterMap.get("FILTER_TYPE");//"SingleColumnValueFilter","FamilyFilter","QualifierFilter","ColumnPrefixFilter","MultipleColumnPrefixFilter","MultipleColumnPrefixFilter","RowFilter"
				String filterColumn = filterMap.get("FILTER_COLUMN");
				String filterFamily = filterMap.get("FILTER_FAMILY");
				String filterOperation = filterMap.get("FILTER_OPERATOR");//"EQUAL","GREATER","GREATER_OR_EQUAL","LESS","LESS_OR_EQUAL","NO_OP","NOT_EQUAL",
				String filterValue = filterMap.get("FILTER_VALUE");
				String filterComparatorType = filterMap.get("FILTER_COMPARATOR_TYPE");//"BinaryComparator" ,"RegexStringComparator" ,"SubstringComparator"
				if("SingleColumnValueFilter".equals(filterType)){//"filterValue" is column value,like: "1" ,"2" ... ，return whole row (all columns) value 
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_39);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_45);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_51);
    
					}
				}else if("FamilyFilter".equals(filterType)){//"Filter Family" is family name ,like: "id_family","name_family"....， return columns which mapping in "Filter Family",filter other columns
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_55);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_59);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_63);
    
					}
				}else if("QualifierFilter".equals(filterType)){ //"Filter Column" is column name,like:"id" or "name" .... then you will get meet codition column value ,filter other columns
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_67);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_71);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_75);
    
					}
				}else if("ColumnPrefixFilter".equals(filterType)){//"Filter Column" value is column name,like:"id" or "name" ....,return column value,filter other columns
					if(filterFamily!=null && !"".equals(filterFamily)){ 

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_78);
    
					}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_81);
    
				}else if("MultipleColumnPrefixFilter".equals(filterType)){ //"Filter Column" value is for column name ,like:"id,name" ,"id,name,sex".... , return column value,filter other columns
					if(filterFamily!=null && !"".equals(filterFamily)){ 

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_84);
    
					}

    stringBuffer.append(TEXT_85);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
				}else if("ColumnRangeFilter".equals(filterType)){//"Filter Column" value is tow columns name,like: "id,name" ,"id,sex" ....,return columns value ,filter other columns
					if(filterFamily!=null && !"".equals(filterFamily)){ 

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_99);
    
					}

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_103);
    
				}else if("RowFilter".equals(filterType)){//"Filter Value" is rowkey value,like "1" ,"car"....,return whole row (all columns)
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_107);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_111);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_115);
    
					}
				}else if("ValueFilter".equals(filterType)){//"Filter Value" is any columns value,like "1" ,"car" .... ,return only the meet codition value,filter other columns
					if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_119);
    
					}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_123);
    
					}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_127);
    
					}
				}

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
			}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
		}

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    

    	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if (conns != null){
			if (conns.size()>0){

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    
					IConnection conn =conns.get(0);
					String connName = conn.getName();
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
						for(int i=0;i<mapping.size();i++){
							Map<String, String> map = mapping.get(i);
							String schema_column = map.get("SCHEMA_COLUMN");
							String family_column= map.get("FAMILY_COLUMN");
							IMetadataColumn column = columns.get(i);
							String columnName = column.getLabel();
							String defaultValue = column.getDefault();
							if(columnName.equals(schema_column)) {//
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    									if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_158);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    									}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_162);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    									}else if(javaType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_166);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_170);
    									}else{

    stringBuffer.append(TEXT_171);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    									}

    stringBuffer.append(TEXT_176);
    
									String default_Value = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, defaultValue);
									if(default_Value != null && !"null".equals(default_Value)) {

    stringBuffer.append(TEXT_177);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(default_Value );
    stringBuffer.append(TEXT_180);
    
									} else if(!JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {

    stringBuffer.append(TEXT_181);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_183);
    
									} else {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_186);
    
									}

    stringBuffer.append(TEXT_187);
    
							} //if(columnName.equals(schema_column))
						} //for(int i=0;i<mapping.size();i++)
					}//if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			}//if (conns.size()>0)
		}//if (conns != null)
	}//if (metadata != null)
}//if ((metadatas!=null) && (metadatas.size() > 0))

    return stringBuffer.toString();
  }
}

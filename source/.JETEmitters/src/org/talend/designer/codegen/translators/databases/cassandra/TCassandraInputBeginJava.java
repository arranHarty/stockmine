package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TCassandraInputBeginJava
{
  protected static String nl;
  public static synchronized TCassandraInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraInputBeginJava result = new TCassandraInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\t\tme.prettyprint.hector.api.Serializer keySerializer_";
  protected final String TEXT_5 = " =me.prettyprint.cassandra.serializers.";
  protected final String TEXT_6 = ".get();" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tme.prettyprint.hector.api.Serializer sNameSerializer_";
  protected final String TEXT_8 = " =me.prettyprint.cassandra.serializers.";
  protected final String TEXT_9 = ".get();" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\tme.prettyprint.hector.api.Cluster cluster_";
  protected final String TEXT_11 = " =null;" + NL + "\t\t\tme.prettyprint.hector.api.Keyspace keyspace_";
  protected final String TEXT_12 = " =null;" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tcluster_";
  protected final String TEXT_14 = "=(me.prettyprint.hector.api.Cluster)globalMap.get(\"cluster_";
  protected final String TEXT_15 = "\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\ttry{" + NL + "\t\t\t    \tString hostIps_";
  protected final String TEXT_17 = "=";
  protected final String TEXT_18 = "+\":\"+";
  protected final String TEXT_19 = ";" + NL + "\t\t\t\t    me.prettyprint.cassandra.service.CassandraHostConfigurator hosts_";
  protected final String TEXT_20 = " = new me.prettyprint.cassandra.service.CassandraHostConfigurator(hostIps_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t    java.util.Map<String, String> credentials_";
  protected final String TEXT_22 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t    credentials_";
  protected final String TEXT_24 = ".put(\"username\",";
  protected final String TEXT_25 = ");" + NL + "\t\t\t\t\t    credentials_";
  protected final String TEXT_26 = ".put(\"password\",";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t   \t \t\t\tcluster_";
  protected final String TEXT_29 = " = me.prettyprint.hector.api.factory.HFactory.getOrCreateCluster(\"cluster_";
  protected final String TEXT_30 = "_\"+pid,hosts_";
  protected final String TEXT_31 = ",credentials_";
  protected final String TEXT_32 = ");" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\tme.prettyprint.cassandra.model.ConfigurableConsistencyLevel clpolicy_";
  protected final String TEXT_34 = " = new me.prettyprint.cassandra.model.ConfigurableConsistencyLevel();" + NL + "\t\t\tme.prettyprint.hector.api.HConsistencyLevel consistencyLevel_";
  protected final String TEXT_35 = " = me.prettyprint.hector.api.HConsistencyLevel.ONE;" + NL + "\t\t\tclpolicy_";
  protected final String TEXT_36 = ".setDefaultWriteConsistencyLevel(consistencyLevel_";
  protected final String TEXT_37 = ");" + NL + "\t\t    keyspace_";
  protected final String TEXT_38 = " = me.prettyprint.hector.api.factory.HFactory.createKeyspace(";
  protected final String TEXT_39 = ", cluster_";
  protected final String TEXT_40 = ",clpolicy_";
  protected final String TEXT_41 = ");" + NL + "\t\t    " + NL + "\t\t    me.prettyprint.cassandra.serializers.StringSerializer serializer_";
  protected final String TEXT_42 = " = me.prettyprint.cassandra.serializers.StringSerializer.get();" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.MultigetSliceQuery<";
  protected final String TEXT_44 = ", String, String> sliceQuery_";
  protected final String TEXT_45 = " = me.prettyprint.hector.api.factory.HFactory.createMultigetSliceQuery(" + NL + "\t\t\t\t\t\tkeyspace_";
  protected final String TEXT_46 = " , keySerializer_";
  protected final String TEXT_47 = ",serializer_";
  protected final String TEXT_48 = ", serializer_";
  protected final String TEXT_49 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.RangeSlicesQuery<";
  protected final String TEXT_51 = ", String, String> sliceQuery_";
  protected final String TEXT_52 = " =" + NL + "\t\t\t\t\t\tme.prettyprint.hector.api.factory.HFactory.createRangeSlicesQuery(keyspace_";
  protected final String TEXT_53 = " , keySerializer_";
  protected final String TEXT_54 = ",serializer_";
  protected final String TEXT_55 = ", serializer_";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_58 = ".setColumnNames(";
  protected final String TEXT_59 = ");" + NL + "\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.MultigetSuperSliceQuery<";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ", String, String> sliceQuery_";
  protected final String TEXT_63 = " = me.prettyprint.hector.api.factory.HFactory.createMultigetSuperSliceQuery(" + NL + "\t\t\t\t\t\tkeyspace_";
  protected final String TEXT_64 = " , keySerializer_";
  protected final String TEXT_65 = ",sNameSerializer_";
  protected final String TEXT_66 = ", serializer_";
  protected final String TEXT_67 = ", serializer_";
  protected final String TEXT_68 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.RangeSuperSlicesQuery<";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ", String, String> sliceQuery_";
  protected final String TEXT_72 = " = " + NL + "\t\t\t\t\t\tme.prettyprint.hector.api.factory.HFactory.createRangeSuperSlicesQuery(keyspace_";
  protected final String TEXT_73 = " , keySerializer_";
  protected final String TEXT_74 = ",sNameSerializer_";
  protected final String TEXT_75 = ", serializer_";
  protected final String TEXT_76 = ", serializer_";
  protected final String TEXT_77 = ");\t" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\tsliceQuery_";
  protected final String TEXT_79 = ".setColumnFamily(";
  protected final String TEXT_80 = ");" + NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_82 = ".setKeys(";
  protected final String TEXT_83 = ");" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_85 = ".setKeys(";
  protected final String TEXT_86 = ",";
  protected final String TEXT_87 = ");" + NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_88 = ".setRowCount(";
  protected final String TEXT_89 = ");" + NL + "\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_91 = ".setColumnNames(";
  protected final String TEXT_92 = ");" + NL + "\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_94 = ".setRange(";
  protected final String TEXT_95 = ",";
  protected final String TEXT_96 = ", false, ";
  protected final String TEXT_97 = ");" + NL + "\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.QueryResult<me.prettyprint.hector.api.beans.Rows<";
  protected final String TEXT_99 = ",String, String>> result_";
  protected final String TEXT_100 = " = sliceQuery_";
  protected final String TEXT_101 = ".execute();" + NL + "\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.QueryResult<me.prettyprint.hector.api.beans.OrderedRows<";
  protected final String TEXT_103 = ",String, String>> result_";
  protected final String TEXT_104 = " = sliceQuery_";
  protected final String TEXT_105 = ".execute();" + NL + "\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\tjava.util.Iterator rows_";
  protected final String TEXT_107 = " = result_";
  protected final String TEXT_108 = ".get().iterator();" + NL + "\t\t\t\twhile(rows_";
  protected final String TEXT_109 = ".hasNext()){" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_110 = "++;" + NL + "\t\t\t\t\tme.prettyprint.hector.api.beans.Row row_";
  protected final String TEXT_111 = "=(me.prettyprint.hector.api.beans.Row)rows_";
  protected final String TEXT_112 = ".next();" + NL + "\t\t\t\t\tme.prettyprint.hector.api.beans.ColumnSlice slice_";
  protected final String TEXT_113 = "=row_";
  protected final String TEXT_114 = ".getColumnSlice();" + NL + "\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.QueryResult<me.prettyprint.hector.api.beans.SuperRows<";
  protected final String TEXT_116 = ",";
  protected final String TEXT_117 = ",String, String>> result_";
  protected final String TEXT_118 = " = sliceQuery_";
  protected final String TEXT_119 = ".execute();" + NL + "\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.QueryResult<me.prettyprint.hector.api.beans.OrderedSuperRows<";
  protected final String TEXT_121 = ",";
  protected final String TEXT_122 = ",String, String>> result_";
  protected final String TEXT_123 = " = sliceQuery_";
  protected final String TEXT_124 = ".execute();" + NL + "\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\tjava.util.Iterator superRows_";
  protected final String TEXT_126 = " = result_";
  protected final String TEXT_127 = ".get().iterator();" + NL + "\t\t\t\twhile(superRows_";
  protected final String TEXT_128 = ".hasNext()){" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_129 = "++;" + NL + "\t\t\t\t\tme.prettyprint.hector.api.beans.SuperRow superRow_";
  protected final String TEXT_130 = "=(me.prettyprint.hector.api.beans.SuperRow)superRows_";
  protected final String TEXT_131 = ".next();" + NL + "\t\t\t\t\tme.prettyprint.hector.api.beans.SuperSlice slice_";
  protected final String TEXT_132 = "=superRow_";
  protected final String TEXT_133 = ".getSuperSlice();" + NL + "\t\t\t\t\tjava.util.List<me.prettyprint.hector.api.beans.HSuperColumn> superColumns_";
  protected final String TEXT_134 = "=slice_";
  protected final String TEXT_135 = ".getSuperColumns();" + NL + "\t\t\t\t\tfor (me.prettyprint.hector.api.beans.HSuperColumn superColumn_";
  protected final String TEXT_136 = " : superColumns_";
  protected final String TEXT_137 = ") {" + NL + "\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\tme.prettyprint.hector.api.beans.HColumn<String,String> column_";
  protected final String TEXT_139 = "=null;" + NL + "" + NL + "\t\t\tjava.nio.ByteBuffer columnValue_";
  protected final String TEXT_140 = "=null;" + NL + "\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t\t\tif(row_";
  protected final String TEXT_142 = ".getKey()!=null){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = "=ParserUtils.parseTo_Date((java.util.Date)(row_";
  protected final String TEXT_146 = ".getKey()), ";
  protected final String TEXT_147 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = "=String.valueOf(row_";
  protected final String TEXT_151 = ".getKey()).getBytes(utf8Charset);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_153 = ".";
  protected final String TEXT_154 = "=ParserUtils.parseTo_";
  protected final String TEXT_155 = "(String.valueOf(row_";
  protected final String TEXT_156 = ".getKey()));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\t\t\t\t\t\t}\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\t\t\t\tif(superRow_";
  protected final String TEXT_159 = ".getKey()!=null){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = "=ParserUtils.parseTo_Date((java.util.Date)(superRow_";
  protected final String TEXT_163 = ".getKey()), ";
  protected final String TEXT_164 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_165 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = "=String.valueOf(superRow_";
  protected final String TEXT_168 = ".getKey()).getBytes(utf8Charset);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = "=ParserUtils.parseTo_";
  protected final String TEXT_172 = "(String.valueOf(superRow_";
  protected final String TEXT_173 = ".getKey()));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t\t\t\t\tcolumnValue_";
  protected final String TEXT_176 = "=superColumn_";
  protected final String TEXT_177 = ".getNameByteBuffer();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_179 = "=slice_";
  protected final String TEXT_180 = ".getColumnByName(\"";
  protected final String TEXT_181 = "\");" + NL + "\t\t\t\t\t\t\t\t\tcolumnValue_";
  protected final String TEXT_182 = "=(column_";
  protected final String TEXT_183 = "==null?null:column_";
  protected final String TEXT_184 = ".getValueBytes());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_186 = "=superColumn_";
  protected final String TEXT_187 = ".getSubColumnByName(\"";
  protected final String TEXT_188 = "\");" + NL + "\t\t\t\t\t\t\t\t\tcolumnValue_";
  protected final String TEXT_189 = "=(column_";
  protected final String TEXT_190 = "==null?null:column_";
  protected final String TEXT_191 = ".getValueBytes());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\tif(columnValue_";
  protected final String TEXT_193 = "!=null){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\t\t\t\tLong dateValue_";
  protected final String TEXT_195 = "=columnValue_";
  protected final String TEXT_196 = ".getLong();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = " = ParserUtils.parseTo_Date(new java.util.Date(dateValue_";
  protected final String TEXT_199 = "), ";
  protected final String TEXT_200 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = "=columnValue_";
  protected final String TEXT_204 = ".getFloat();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = "=columnValue_";
  protected final String TEXT_208 = ".getChar();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = "=columnValue_";
  protected final String TEXT_212 = ".getInt();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_214 = ".";
  protected final String TEXT_215 = "=columnValue_";
  protected final String TEXT_216 = ".getShort();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = "=columnValue_";
  protected final String TEXT_220 = ".getLong();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = "=columnValue_";
  protected final String TEXT_224 = ".getDouble();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_225 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\t\t\t\t\t\t\t\t(";
  protected final String TEXT_229 = ")" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\t\t\t\t\tme.prettyprint.cassandra.serializers.";
  protected final String TEXT_231 = ".get().fromByteBuffer(columnValue_";
  protected final String TEXT_232 = ")" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t\t\t\t\t\t.toString()" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\t\t\t\t\t\t\t\t;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = ".";
  protected final String TEXT_237 = " = ";
  protected final String TEXT_238 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_239 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
	String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    //String cluster= ElementParameterParser.getValue(node, "__CLUSTER__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getValue(node, "__PASSWORD__");
	String keySpace = ElementParameterParser.getValue(node,"__KEY_SPACE__");
	boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String columnFamily = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");
    String keyColumn = ElementParameterParser.getValue(node,"__KEY_COLUMN__");
    boolean incKey = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__INC_KEY__"));
    String superKeyColumn = ElementParameterParser.getValue(node,"__SUPER_KEY_COLUMN__");
    boolean incSuperKey = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__INC_SUPER_KEY__"));
    String rowKeys=ElementParameterParser.getValue(node,"__ROW_KEYS__");
    String searchColumns=ElementParameterParser.getValue(node,"__COLUMNS__");
 	String keyStart = ElementParameterParser.getValue(node,"__KEY_START__");
 	String keyEnd = ElementParameterParser.getValue(node,"__KEY_END__");
 	String keyLimit= ElementParameterParser.getValue(node,"__KEY_LIMIT__");
 	String columnStart = ElementParameterParser.getValue(node,"__COLUMN_START__");
 	String columnEnd = ElementParameterParser.getValue(node,"__COLUMN_END__");
 	String columnLimit = ElementParameterParser.getValue(node,"__COLUMN_LIMIT__");
 	
 	boolean isSpecifyKeys = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__SPECIFY_KEYS__"));
 	boolean isSpecifyColumns = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__SPECIFY_COLUMNS__"));
 	
 	String columnFamilyType = ElementParameterParser.getValue(node,"__COLUMN_FAMILY_TYPE__");
 	String rowKeyType = ElementParameterParser.getValue(node,"__ROW_KEY_TYPE__");
 	String sNameType = ElementParameterParser.getValue(node,"__SUPER_COLUMN_TYPE__");
 	String rowKeyCType = ElementParameterParser.getValue(node,"__ROW_KEY_C_TYPE__");
 	String sNameCType = ElementParameterParser.getValue(node,"__SUPER_COLUMN_C_TYPE__");
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	List<IMetadataColumn> columnList = null;
  	List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
  	String firstConnName = "";
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	columnList = metadata.getListColumns();
		int sizeColumns = columnList.size();
      	if(metadata != null){
      		
      		class TypeMap{
      			Map<String,String> typeMap=new java.util.HashMap<String,String>();
      			
      			public TypeMap(){
					typeMap.put("Boolean","BooleanSerializer");
					typeMap.put("byte[]","BytesArraySerializer");
					typeMap.put("java.util.Date","DateSerializer");
					typeMap.put("Double","DoubleSerializer");
					typeMap.put("Float","FloatSerializer");
					typeMap.put("Integer","IntegerSerializer");
					typeMap.put("Long","LongSerializer");
					typeMap.put("Object","ObjectSerializer");
					typeMap.put("Short","ShortSerializer");
					typeMap.put("String","StringSerializer");
					typeMap.put("Character","CharSerializer");
					typeMap.put("BigDecimal","BigDecimalSerializer");
      			}
      			public String get(String tType, String cType){
      				if("".equals(cType) || "Default".equals(cType)){
      					return typeMap.get(tType);
      				}else if("CounterColumnType".equals(cType)){
      					return "LongSerializer";
      				}else if("IntegerType".equals(cType)){
      					return "BigIntegerSerializer";
      				}else if("AsciiType".equals(cType)){
      					return "AsciiSerializer";
      				}else if("UUIDType".equals(cType)){
      					return "UUIDSerializer";
      				}else if("TimeUUIDType".equals(cType)){
      					return "TimeUUIDSerializer";
      				}else{
      					return typeMap.get(tType) == null ? "ObjectSerializer" : typeMap.get(tType);
      				}
      			}
      		}
     		TypeMap typeMap = new TypeMap();
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(typeMap.get(rowKeyType, rowKeyCType));
    stringBuffer.append(TEXT_6);
    
			if("SUPER".equals(columnFamilyType)){
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(typeMap.get(sNameType, sNameCType));
    stringBuffer.append(TEXT_9);
    
			}
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			if(useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_15);
    
			}else{
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
					if (authentication){
					
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(passWord);
    stringBuffer.append(TEXT_27);
    
					}
					
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
			}
			
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
			if("STANDARD".equals(columnFamilyType)){
				StringBuilder columns=new StringBuilder();
		        boolean isfirstColumn=true;
				for(int i = 0; i < sizeColumns; i++){
					IMetadataColumn column = columnList.get(i);
		        	if(!isfirstColumn){
		        		columns.append(",");
		        	}else{
		        		isfirstColumn=false;
		        	}
					columns.append("\""+column.getOriginalDbColumnName()+"\"");
	            }
				if(isSpecifyKeys){
				
    stringBuffer.append(TEXT_43);
    stringBuffer.append(rowKeyType);
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
    
				}else{
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(rowKeyType);
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
    
				}
				
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(columns.toString());
    stringBuffer.append(TEXT_59);
    
			}else{
				if(isSpecifyKeys){
				
    stringBuffer.append(TEXT_60);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(sNameType);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
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
    
				}else{
				
    stringBuffer.append(TEXT_69);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(sNameType);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
				}
			}
			
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_80);
    			
			if(isSpecifyKeys){
			
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(rowKeys);
    stringBuffer.append(TEXT_83);
    
			}else{
			
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(("".equals(keyStart) || "\"\"".equals(keyStart)?"null":keyStart));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(("".equals(keyEnd) || "\"\"".equals(keyEnd)?"null":keyEnd));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(keyLimit);
    stringBuffer.append(TEXT_89);
    
			}
			if(isSpecifyColumns){
			
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(searchColumns);
    stringBuffer.append(TEXT_92);
    
			}else{
			
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(("".equals(columnStart) || "\"\"".equals(columnStart)?"null":columnStart));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(("".equals(columnEnd) || "\"\"".equals(columnEnd)?"null":columnEnd));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(columnLimit);
    stringBuffer.append(TEXT_97);
    
			}
			if("STANDARD".equals(columnFamilyType)){
				if(isSpecifyKeys){
				
    stringBuffer.append(TEXT_98);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
				}else{
				
    stringBuffer.append(TEXT_102);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
				}
				
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
			}else{
				if(isSpecifyKeys){
				
    stringBuffer.append(TEXT_115);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(sNameType);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
				}else{
				
    stringBuffer.append(TEXT_120);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(sNameType);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
				}
				
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
			}
			
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
			if(outputs!=null && outputs.size() > 0){
		    	IConnection out = outputs.get(0);
      			firstConnName = out.getName();
		  		if(out.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				
					for(int i = 0; i < sizeColumns; i++){
						IMetadataColumn column = columnList.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(incKey && column.getLabel().equals(keyColumn)){
							if("STANDARD".equals(columnFamilyType)){
							
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
									if(javaType == JavaTypesManager.DATE){
									
    stringBuffer.append(TEXT_143);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_147);
    
									}else if(javaType == JavaTypesManager.BYTE_ARRAY){
									
    stringBuffer.append(TEXT_148);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
									}else{
									
    stringBuffer.append(TEXT_152);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
									}
									
    stringBuffer.append(TEXT_157);
    
							}else{
							
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
									if(javaType == JavaTypesManager.DATE){
									
    stringBuffer.append(TEXT_160);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_164);
    
									}else if(javaType == JavaTypesManager.BYTE_ARRAY){
									
    stringBuffer.append(TEXT_165);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
									}else{
									
    stringBuffer.append(TEXT_169);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
									}
									
    stringBuffer.append(TEXT_174);
    
							}
						}else{
							if("SUPER".equals(columnFamilyType) && incSuperKey && column.getLabel().equals(superKeyColumn)){
							
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
							}else{
								if("STANDARD".equals(columnFamilyType)){
								
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
								}else{
								
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
								}
							}
							
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
								if(javaType == JavaTypesManager.DATE) {
								
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_200);
    
								}else if(javaType == JavaTypesManager.FLOAT){
								
    stringBuffer.append(TEXT_201);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
								}else if(javaType == JavaTypesManager.CHARACTER){
								
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
								}else if(javaType == JavaTypesManager.INTEGER){
								
    stringBuffer.append(TEXT_209);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
								}else if(javaType == JavaTypesManager.SHORT){
								
    stringBuffer.append(TEXT_213);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    
								}else if(javaType == JavaTypesManager.LONG){
								
    stringBuffer.append(TEXT_217);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
								}else if(javaType == JavaTypesManager.DOUBLE){
								
    stringBuffer.append(TEXT_221);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    
								}else{
									String columnType=JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
									String cType = column.getType();
									
    stringBuffer.append(TEXT_225);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_227);
    
										if(typeMap.get(columnType, cType)=="ObjectSerializer"){
										
    stringBuffer.append(TEXT_228);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_229);
    
										}
										
    stringBuffer.append(TEXT_230);
    stringBuffer.append(typeMap.get(columnType, cType));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
										if(typeMap.get(columnType, cType)=="UUIDSerializer" || typeMap.get(columnType, cType)=="TimeUUIDSerializer"){
										
    stringBuffer.append(TEXT_233);
    
										}
										
    stringBuffer.append(TEXT_234);
    
								}
								
    stringBuffer.append(TEXT_235);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_238);
    
						}
			   		}
	     		}
			}
      	}
    }
	
    stringBuffer.append(TEXT_239);
    return stringBuffer.toString();
  }
}

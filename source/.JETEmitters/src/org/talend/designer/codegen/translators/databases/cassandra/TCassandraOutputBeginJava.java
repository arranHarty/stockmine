package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.Map;

public class TCassandraOutputBeginJava
{
  protected static String nl;
  public static synchronized TCassandraOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraOutputBeginJava result = new TCassandraOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tme.prettyprint.hector.api.Cluster cluster_";
  protected final String TEXT_2 = " =null;" + NL + "\t\tme.prettyprint.hector.api.Keyspace keyspace_";
  protected final String TEXT_3 = " =null;" + NL + "\t\tint batchCounter_";
  protected final String TEXT_4 = " = 0;" + NL + "\t\tint nb_line_";
  protected final String TEXT_5 = " = 0;" + NL + "\t\ttry{";
  protected final String TEXT_6 = NL + "\t\tcluster_";
  protected final String TEXT_7 = "=(me.prettyprint.hector.api.Cluster)globalMap.get(\"cluster_";
  protected final String TEXT_8 = "\");";
  protected final String TEXT_9 = NL + "\t\t    String hostIps_";
  protected final String TEXT_10 = "=";
  protected final String TEXT_11 = "+\":\"+";
  protected final String TEXT_12 = ";" + NL + "\t\t    me.prettyprint.cassandra.service.CassandraHostConfigurator hosts_";
  protected final String TEXT_13 = " = new me.prettyprint.cassandra.service.CassandraHostConfigurator(hostIps_";
  protected final String TEXT_14 = ");" + NL + "\t\t    java.util.Map<String, String> credentials_";
  protected final String TEXT_15 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_16 = NL + "\t\t    credentials_";
  protected final String TEXT_17 = ".put(\"username\",";
  protected final String TEXT_18 = ");" + NL + "\t\t    credentials_";
  protected final String TEXT_19 = ".put(\"password\",";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t    \tcluster_";
  protected final String TEXT_22 = " = me.prettyprint.hector.api.factory.HFactory.getOrCreateCluster(\"cluster_";
  protected final String TEXT_23 = "_\"+pid,hosts_";
  protected final String TEXT_24 = ",credentials_";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\t\tme.prettyprint.cassandra.model.ConfigurableConsistencyLevel clpolicy_";
  protected final String TEXT_27 = " = new me.prettyprint.cassandra.model.ConfigurableConsistencyLevel();" + NL + "\t\t\tme.prettyprint.hector.api.HConsistencyLevel consistencyLevel_";
  protected final String TEXT_28 = " = me.prettyprint.hector.api.HConsistencyLevel.ONE;" + NL + "\t\t\t  clpolicy_";
  protected final String TEXT_29 = ".setDefaultWriteConsistencyLevel(consistencyLevel_";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\t\tcluster_";
  protected final String TEXT_32 = ".dropKeyspace(";
  protected final String TEXT_33 = ", true);" + NL + "\t\t\tcluster_";
  protected final String TEXT_34 = ".addKeyspace(new me.prettyprint.cassandra.service.ThriftKsDef(";
  protected final String TEXT_35 = "), true);";
  protected final String TEXT_36 = NL + "\t\t\tcluster_";
  protected final String TEXT_37 = ".addKeyspace(new me.prettyprint.cassandra.service.ThriftKsDef(";
  protected final String TEXT_38 = "), true);";
  protected final String TEXT_39 = NL + "\t\t\tif (cluster_";
  protected final String TEXT_40 = ".describeKeyspace(";
  protected final String TEXT_41 = ") != null) {" + NL + "\t      \t\tcluster_";
  protected final String TEXT_42 = ".dropKeyspace(";
  protected final String TEXT_43 = ", true);" + NL + "\t   \t\t}" + NL + "\t   \t\tcluster_";
  protected final String TEXT_44 = ".addKeyspace(new me.prettyprint.cassandra.service.ThriftKsDef(";
  protected final String TEXT_45 = "), true);";
  protected final String TEXT_46 = NL + "\t\t\tif (cluster_";
  protected final String TEXT_47 = ".describeKeyspace(";
  protected final String TEXT_48 = ") == null) {" + NL + "\t      \t\tcluster_";
  protected final String TEXT_49 = ".addKeyspace(new me.prettyprint.cassandra.service.ThriftKsDef(";
  protected final String TEXT_50 = "), true);" + NL + "\t   \t\t}";
  protected final String TEXT_51 = NL + "\t    \tkeyspace_";
  protected final String TEXT_52 = " = me.prettyprint.hector.api.factory.HFactory.createKeyspace(";
  protected final String TEXT_53 = ", cluster_";
  protected final String TEXT_54 = ",clpolicy_";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\t\t\tcluster_";
  protected final String TEXT_57 = ".dropColumnFamily(";
  protected final String TEXT_58 = ",";
  protected final String TEXT_59 = ", true);";
  protected final String TEXT_60 = NL + "\t\t\ttry {";
  protected final String TEXT_61 = NL + "\t\t\t\tcluster_";
  protected final String TEXT_62 = ".dropColumnFamily(";
  protected final String TEXT_63 = ",";
  protected final String TEXT_64 = ", true);";
  protected final String TEXT_65 = NL + "\t\t\t\tme.prettyprint.hector.api.ddl.ColumnFamilyDefinition cfDefinition_";
  protected final String TEXT_66 = " = me.prettyprint.hector.api.factory.HFactory.createColumnFamilyDefinition(";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = "); " + NL + "\t\t\t\tcfDefinition_";
  protected final String TEXT_69 = ".setColumnType(me.prettyprint.hector.api.ddl.ColumnType.";
  protected final String TEXT_70 = ");" + NL + "\t\t\t\tcluster_";
  protected final String TEXT_71 = ".addColumnFamily(cfDefinition_";
  protected final String TEXT_72 = ", true);";
  protected final String TEXT_73 = NL + "\t\t\t} catch (Exception e_";
  protected final String TEXT_74 = ") {";
  protected final String TEXT_75 = NL + "\t\t\t}finally{" + NL + "\t\t\t\tme.prettyprint.hector.api.ddl.ColumnFamilyDefinition cfDefinition_";
  protected final String TEXT_76 = " = me.prettyprint.hector.api.factory.HFactory.createColumnFamilyDefinition(";
  protected final String TEXT_77 = ",";
  protected final String TEXT_78 = "); " + NL + "\t\t\t\tcfDefinition_";
  protected final String TEXT_79 = ".setColumnType(me.prettyprint.hector.api.ddl.ColumnType.";
  protected final String TEXT_80 = ");" + NL + "\t\t\t\tcluster_";
  protected final String TEXT_81 = ".addColumnFamily(cfDefinition_";
  protected final String TEXT_82 = ", true);" + NL + "\t\t\t}";
  protected final String TEXT_83 = NL + "\t\t\t}";
  protected final String TEXT_84 = NL + "\t\t\tme.prettyprint.hector.api.ddl.ColumnFamilyDefinition cfDefinition_";
  protected final String TEXT_85 = " = me.prettyprint.hector.api.factory.HFactory.createColumnFamilyDefinition(";
  protected final String TEXT_86 = ",";
  protected final String TEXT_87 = "); " + NL + "\t\t\tcfDefinition_";
  protected final String TEXT_88 = ".setColumnType(me.prettyprint.hector.api.ddl.ColumnType.";
  protected final String TEXT_89 = ");" + NL + "\t\t\tcluster_";
  protected final String TEXT_90 = ".addColumnFamily(cfDefinition_";
  protected final String TEXT_91 = ", true);";
  protected final String TEXT_92 = NL + "\t\t\tme.prettyprint.hector.api.mutation.Mutator mutator_";
  protected final String TEXT_93 = " = null;";
  protected final String TEXT_94 = NL + "\t\t\tme.prettyprint.hector.api.Serializer keySerializer_";
  protected final String TEXT_95 = " =me.prettyprint.cassandra.serializers.";
  protected final String TEXT_96 = ".get();";
  protected final String TEXT_97 = NL + "\t\t\tme.prettyprint.hector.api.Serializer sNameSerializer_";
  protected final String TEXT_98 = " =me.prettyprint.cassandra.serializers.";
  protected final String TEXT_99 = ".get();";
  protected final String TEXT_100 = NL + "\t     \tme.prettyprint.cassandra.serializers.StringSerializer serializer_";
  protected final String TEXT_101 = " = me.prettyprint.cassandra.serializers.StringSerializer.get();" + NL + "\t    \tmutator_";
  protected final String TEXT_102 = " = me.prettyprint.hector.api.factory.HFactory.createMutator(keyspace_";
  protected final String TEXT_103 = ", keySerializer_";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
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
    String actionOnKeyspace= ElementParameterParser.getValue(node,"__ACTION_ON_KEYSPACE__");
    String actionOnColumnFamily= ElementParameterParser.getValue(node,"__ACTION_ON_COLUMN_FAMILY__");
    String columnFamily = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");
	String columnFamilyType =ElementParameterParser.getValue(node,"__COLUMN_FAMILY_TYPE__");
	
	String superKeyColumn = ElementParameterParser.getValue(node,"__SUPER_KEY_COLUMN__");
	String keyColumn = ElementParameterParser.getValue(node,"__KEY_COLUMN__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
	if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
	}else{

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
		if (authentication){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(passWord);
    stringBuffer.append(TEXT_20);
    
		}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
		if("DROP_CREATE".equals(actionOnKeyspace)){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_35);
    
		}if("CREATE".equals(actionOnKeyspace)){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_38);
    
		}if("DROP_IF_EXISTS_AND_CREATE".equals(actionOnKeyspace)){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_45);
    
		}if("CREATE_IF_NOT_EXISTS".equals(actionOnKeyspace)){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_50);
    
		}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		if("DROP_CREATE".equals(actionOnColumnFamily)){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_59);
    
		}
		if("DROP_IF_EXISTS_AND_CREATE".equals(actionOnColumnFamily) || "CREATE_IF_NOT_EXISTS".equals(actionOnColumnFamily)){

    stringBuffer.append(TEXT_60);
    
			if("DROP_IF_EXISTS_AND_CREATE".equals(actionOnColumnFamily)){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_64);
    
			}else{

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(columnFamilyType);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
 			}

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			if("DROP_IF_EXISTS_AND_CREATE".equals(actionOnColumnFamily)){

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columnFamilyType);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
			}else{

    stringBuffer.append(TEXT_83);
    
			}
		}
		if("CREATE".equals(actionOnColumnFamily) || "DROP_CREATE".equals(actionOnColumnFamily)){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(columnFamilyType);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
		}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
		if (node.getIncomingConnections() != null) {
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
			boolean rowKeyFlag=false;
			boolean superColFlag=false;
			for (IConnection incomingConn : node.getIncomingConnections()) {
				if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
					for (IMetadataColumn column : inputMetadataTable.getListColumns()) {
	    				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	    				String columnType=JavaTypesManager.getTypeToGenerate(column.getTalendType(),true);
						String cType = column.getType();
	    				if(column.getLabel().equals(keyColumn)){
	    					rowKeyFlag=true;
	    					

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(typeMap.get(columnType, cType));
    stringBuffer.append(TEXT_96);
    
						}
						if("SUPER".equals(columnFamilyType) && column.getLabel().equals(superKeyColumn)){
						superColFlag=true;

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(typeMap.get(columnType, cType));
    stringBuffer.append(TEXT_99);
    
						}
						if(("STANDARD".equals(columnFamilyType) && rowKeyFlag)||("SUPER".equals(columnFamilyType) && rowKeyFlag && superColFlag)){
						 break;
						}
					}

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
				}
			}
		}

    stringBuffer.append(TEXT_105);
    return stringBuffer.toString();
  }
}

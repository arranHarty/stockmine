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
import java.util.List;

public class TCassandraOutputMainJava
{
  protected static String nl;
  public static synchronized TCassandraOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraOutputMainJava result = new TCassandraOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tif (";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = " != null) {";
  protected final String TEXT_4 = NL + NL + "\t\t\t\tjava.util.List<me.prettyprint.hector.api.beans.HColumn<me.prettyprint.hector.api.Serializer,me.prettyprint.hector.api.Serializer>> innerColumn_";
  protected final String TEXT_5 = "=new " + NL + "\t    \t\t\tjava.util.ArrayList<me.prettyprint.hector.api.beans.HColumn<me.prettyprint.hector.api.Serializer,me.prettyprint.hector.api.Serializer>>();";
  protected final String TEXT_6 = "if(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "!=null) { ";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\t\tmutator_";
  protected final String TEXT_10 = ".addInsertion(";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = "," + NL + "\t\t\t\t\t\t\t\tme.prettyprint.hector.api.factory.HFactory.createColumn(" + NL + "\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_14 = "\"," + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\t\t\t(java.math.BigInteger)";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t\t\t\tjava.util.UUID.fromString(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ")" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\t\t\t\tnew com.eaio.uuid.UUID(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ")" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t\t," + NL + "\t\t\t\t\t\t\t\tserializer_";
  protected final String TEXT_28 = "," + NL + "\t\t\t\t\t\t\t\tme.prettyprint.cassandra.serializers.";
  protected final String TEXT_29 = ".get()" + NL + "\t\t\t\t\t\t\t\t)" + NL + "\t\t\t\t\t\t\t);";
  protected final String TEXT_30 = "} ";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\tmutator_";
  protected final String TEXT_32 = ".addDeletion(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ",\"";
  protected final String TEXT_36 = "\",serializer_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = "if(";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = "!=null){ ";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t\tme.prettyprint.hector.api.beans.HColumn column_";
  protected final String TEXT_42 = "=" + NL + "\t\t\t\t\t\t\t\tme.prettyprint.hector.api.factory.HFactory.createColumn(" + NL + "\t\t\t\t\t\t\t\t\t\"";
  protected final String TEXT_43 = "\"," + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\t\t\t\t\t(java.math.BigInteger)";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t\t\t\t\tjava.util.UUID.fromString(";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ")" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\t\t\t\tnew com.eaio.uuid.UUID(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ")" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t\t\t\t," + NL + "\t\t\t\t\t\t\t\t\tserializer_";
  protected final String TEXT_57 = "," + NL + "\t\t\t\t\t\t\t\t\tme.prettyprint.cassandra.serializers.";
  protected final String TEXT_58 = ".get()" + NL + "\t\t\t\t\t\t\t\t);" + NL + "\t\t\t\t\t\t\tinnerColumn_";
  protected final String TEXT_59 = ".add( column_";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = "} ";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\tmutator_";
  protected final String TEXT_63 = ".addSubDelete(";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ",";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ",\"";
  protected final String TEXT_69 = "\",sNameSerializer_";
  protected final String TEXT_70 = ",serializer_";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = "if(";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = "!=null){ ";
  protected final String TEXT_75 = NL + "\t\t\t\tmutator_";
  protected final String TEXT_76 = ".addInsertion(";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ",new me.prettyprint.cassandra.model.HSuperColumnImpl(";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ",innerColumn_";
  protected final String TEXT_82 = "," + NL + "\t\t\t\t\tme.prettyprint.hector.api.factory.HFactory.createClock(),sNameSerializer_";
  protected final String TEXT_83 = ",serializer_";
  protected final String TEXT_84 = ",serializer_";
  protected final String TEXT_85 = "));";
  protected final String TEXT_86 = "} ";
  protected final String TEXT_87 = NL + "\t\t\t\t\tmutator_";
  protected final String TEXT_88 = ".addDeletion(";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\tmutator_";
  protected final String TEXT_93 = ".addDeletion(";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = ", ";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "\t\t\t\t\t\tmutator_";
  protected final String TEXT_98 = ".addSuperDelete(";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ", ";
  protected final String TEXT_101 = ",";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = ",sNameSerializer_";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = "} ";
  protected final String TEXT_106 = NL + "\t\t\tnb_line_";
  protected final String TEXT_107 = "++;" + NL + "\t\t\tif (batchCounter_";
  protected final String TEXT_108 = "++ == ";
  protected final String TEXT_109 = ") {" + NL + "\t\t\t\tmutator_";
  protected final String TEXT_110 = ".execute();" + NL + "\t\t\t\tbatchCounter_";
  protected final String TEXT_111 = " = 0;" + NL + "\t\t\t}";
  protected final String TEXT_112 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String batchSize = ElementParameterParser.getValue(node,"__BATCH_SIZE__");
	String columnFamilyType = ElementParameterParser.getValue(node,"__COLUMN_FAMILY_TYPE__");
	String superKeyColumn = ElementParameterParser.getValue(node,"__SUPER_KEY_COLUMN__");
    boolean incSuperKey = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__INC_SUPER_KEY__"));
    String keyColumn = ElementParameterParser.getValue(node,"__KEY_COLUMN__");
	String columnFamily = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");
    boolean incKey = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__INC_KEY__"));
    String actionOnData = ElementParameterParser.getValue(node,"__ACTION_ON_DATA__");
    List<Map<String, String>> listDeleteCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DELETE_COLUMNS__");
    boolean deleteRow = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__DELETE_ROW__"));
    boolean delSuperColumn = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__DELETE_SUPER_COLUMN__"));
    Map<String,String> deleteColumns=new java.util.HashMap<String,String>();
    for(Map<String,String> delColumn:listDeleteCols){
    	deleteColumns.put(delColumn.get("DELETE_COLUMN"),delColumn.get("DELETE_COLUMN"));
    }
	
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
		for (IConnection incomingConn : node.getIncomingConnections()) {
			String conName = incomingConn.getName();
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				IMetadataColumn metaKeyColumn = inputMetadataTable.getColumn(keyColumn);
				boolean isKeyColumnJavaPrimitive = false;
				if (metaKeyColumn != null) {
					isKeyColumnJavaPrimitive = JavaTypesManager.isJavaPrimitiveType(metaKeyColumn.getTalendType(), metaKeyColumn.isNullable());
				}
				if (!isKeyColumnJavaPrimitive) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_3);
    
				}
			if("SUPER".equals(columnFamilyType)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
    		for (IMetadataColumn column : inputMetadataTable.getListColumns()) {
    			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    			String columnType=JavaTypesManager.getTypeToGenerate(column.getTalendType(),true);
				String cType = column.getType();
    			boolean isJavaPrimitiveType = JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
    			if("STANDARD".equals(columnFamilyType)){
					if (incKey || !column.getLabel().equals(keyColumn)) {
						if("UPSERT".equals(actionOnData)){

    if (!isJavaPrimitiveType) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_14);
    if("BigIntegerSerializer".equals(typeMap.get(columnType, cType))){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_17);
    }else if("UUIDSerializer".equals(typeMap.get(columnType, cType))){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_20);
    }else if("TimeUUIDSerializer".equals(typeMap.get(columnType, cType))){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    }else{
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(typeMap.get(columnType, cType));
    stringBuffer.append(TEXT_29);
    if (!isJavaPrimitiveType) {
    stringBuffer.append(TEXT_30);
    }
    
						}else{
							if(!deleteRow && listDeleteCols.size()>0 && deleteColumns.get(column.getLabel())!=null){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
							}
						}
					}
				}else{
					if (!((!incKey && column.getLabel().equals(keyColumn))|| (!incSuperKey && column.getLabel().equals(superKeyColumn)))) {
						if("UPSERT".equals(actionOnData)){

    if (!isJavaPrimitiveType) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_43);
    if("BigIntegerSerializer".equals(typeMap.get(columnType, cType))){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_46);
    }else if("UUIDSerializer".equals(typeMap.get(columnType, cType))){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_49);
    }else if("TimeUUIDSerializer".equals(typeMap.get(columnType, cType))){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_52);
    }else{
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(typeMap.get(columnType, cType));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_60);
    if (!isJavaPrimitiveType) {
    stringBuffer.append(TEXT_61);
    }
    
						}else{
							if(!deleteRow && listDeleteCols.size()>0 && deleteColumns.get(column.getLabel())!=null){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(superKeyColumn);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
							}
						}
					}
				}
			}
           	if("SUPER".equals(columnFamilyType) && "UPSERT".equals(actionOnData)){
				IMetadataColumn metaSuperKeyColumn = inputMetadataTable.getColumn(superKeyColumn);
				boolean isSuperKeyColumnJavaPrimitive = false;
				if (metaSuperKeyColumn != null) {
					isSuperKeyColumnJavaPrimitive = JavaTypesManager.isJavaPrimitiveType(metaSuperKeyColumn.getTalendType(), metaSuperKeyColumn.isNullable());
				}

    if (!isSuperKeyColumnJavaPrimitive) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(superKeyColumn);
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(superKeyColumn);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    if (!isSuperKeyColumnJavaPrimitive) {
    stringBuffer.append(TEXT_86);
    }
    
			}
			if("DELETE".equals(actionOnData)){
				if(deleteRow || listDeleteCols.size()<1){
					if("STANDARD".equals(columnFamilyType)){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_91);
                 		
					}else{
						if(deleteRow && !delSuperColumn){

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_96);
    
						}else{

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(conName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(superKeyColumn);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
						}
					}
				}
             }

    if (!isKeyColumnJavaPrimitive) {
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
			}
      	}
    }

    stringBuffer.append(TEXT_112);
    return stringBuffer.toString();
  }
}

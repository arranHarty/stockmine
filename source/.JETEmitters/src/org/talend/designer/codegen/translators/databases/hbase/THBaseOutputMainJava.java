package org.talend.designer.codegen.translators.databases.hbase;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class THBaseOutputMainJava
{
  protected static String nl;
  public static synchronized THBaseOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseOutputMainJava result = new THBaseOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\torg.apache.hadoop.hbase.client.Put p_";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "\t\t\t\t\t\tbyte[] rowKey_";
  protected final String TEXT_5 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\tbyte[] rowKey_";
  protected final String TEXT_8 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(\"myRow_\"+";
  protected final String TEXT_9 = ".toString());";
  protected final String TEXT_10 = NL + "\t\t\t\t\tp_";
  protected final String TEXT_11 = " = new org.apache.hadoop.hbase.client.Put(rowKey_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "!=null){";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\ttemp_";
  protected final String TEXT_17 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(FormatterUtils.format_Date(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = "));";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\ttemp_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\ttemp_";
  protected final String TEXT_26 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = "+\"\");";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\ttemp_";
  protected final String TEXT_30 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\ttemp_";
  protected final String TEXT_34 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ".toString());";
  protected final String TEXT_37 = NL + "\t\t\t\t\t}";
  protected final String TEXT_38 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tp_";
  protected final String TEXT_39 = ".add(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_40 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_41 = "\"), temp_";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t\t\ttemp_";
  protected final String TEXT_43 = " = null;";
  protected final String TEXT_44 = NL + "\t\t\t\t\ttable_";
  protected final String TEXT_45 = ".put(p_";
  protected final String TEXT_46 = ");" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_47 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument)argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<Map<String,String>> families = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FAMILIES__");
String customUseRowKey = ElementParameterParser.getValue(node, "__CUSTOM_ROW_KEY__");
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		if (conns != null){
			if (conns.size()>0){
				IConnection conn = conns.get(0);
				String connName = conn.getName();
				List<IMetadataColumn> columns = metadata.getListColumns();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
					if("true".equals(customUseRowKey)){
						String rowKey = ElementParameterParser.getValue(node, "__ROW_KEY__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(rowKey);
    stringBuffer.append(TEXT_6);
    
					}else{

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_9);
    
					}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
					for(int familyNum=0;familyNum<families.size();familyNum++){
						IMetadataColumn column = columns.get(familyNum);
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						Map<String,String> mapLine = families.get(familyNum);
						String schema_column = mapLine.get("SCHEMA_COLUMN");
						String family_column = mapLine.get("FAMILY_COLUMN");
						if(family_column==null||family_column.trim().length()==0){
							continue;
						}
						boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
						if(!isPrimitive){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    
						}
						if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_20);
    
						}
						else if (javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    
						}
						else if (javaType == JavaTypesManager.BYTE) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_28);
    
						}
						else if(JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_32);
    
						}
						else{

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_36);
    
						}
						if(!isPrimitive){

    stringBuffer.append(TEXT_37);
    
						}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
					}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			}//if (conns.size()>0)
		}//if (conns != null)
	}//if (metadata != null)
}//if ((metadatas!=null) && (metadatas.size() > 0))

    return stringBuffer.toString();
  }
}

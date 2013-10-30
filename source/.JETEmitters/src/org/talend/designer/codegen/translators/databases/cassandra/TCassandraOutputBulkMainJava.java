package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TCassandraOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TCassandraOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraOutputBulkMainJava result = new TCassandraOutputBulkMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tjava.nio.ByteBuffer.wrap(";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = ")" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t\torg.apache.cassandra.utils.ByteBufferUtil.bytes(";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ".getTime())" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\tjava.nio.ByteBuffer.wrap(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = "?bTrue_";
  protected final String TEXT_10 = ":bFalse_";
  protected final String TEXT_11 = ")" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\t    objectSerializer_";
  protected final String TEXT_13 = ".toByteBuffer(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ")" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t\t\tjava.nio.ByteBuffer.wrap(((java.math.BigInteger)";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ").toByteArray())" + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\torg.apache.cassandra.db.marshal.DecimalType.instance.decompose(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ")" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tjava.nio.ByteBuffer.wrap(org.apache.cassandra.utils.UUIDGen.decompose(java.util.UUID.fromString(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ")))" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\torg.apache.cassandra.utils.ByteBufferUtil.bytes(java.util.UUID.fromString(";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = "))" + NL + "\t\t\t";
  protected final String TEXT_28 = NL + "\t    \torg.apache.cassandra.utils.ByteBufferUtil.bytes(";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ")" + NL + "\t\t";
  protected final String TEXT_31 = NL + "\twriter_";
  protected final String TEXT_32 = ".newRow(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "long timestamp_";
  protected final String TEXT_35 = " = System.currentTimeMillis() * 1000;";
  protected final String TEXT_36 = NL + "\twriter_";
  protected final String TEXT_37 = ".addColumn(org.apache.cassandra.utils.ByteBufferUtil.bytes(\"";
  protected final String TEXT_38 = "\"),";
  protected final String TEXT_39 = ",timestamp_";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = " \t" + NL;
  protected final String TEXT_42 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

IMetadataTable metadata = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if((metadatas!=null) && (metadatas.size()>0)){
    metadata = metadatas.get(0);
}

String inConnName = null;
List<? extends IConnection> conns = node.getIncomingConnections();
if(conns!=null){
	if(conns.size()>0){
	    IConnection conn = conns.get(0);
		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    		inConnName = conn.getName();
    	}
    }
}
List<IMetadataColumn> columns = null;
int sizeColumns = 0;
if(metadata != null){
	columns = metadata.getListColumns();
	sizeColumns = columns.size();
}
if(sizeColumns == 0 || inConnName == null){
	return "";
}
String version = ElementParameterParser.getValue(node,"__DB_VERSION__");
class ConvertTypeUtil{
	String version = null;
	String cid = null;
	public void setCID(String cid){
		this.cid = cid;
	}
	public void setVersion(String version){
		this.version = version;
	}
	public void convert(String cType, String inConnName, String columnName){
		if("BytesType".equals(cType)){
		
    stringBuffer.append(TEXT_1);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_3);
    
		}else if("DateType".equals(cType)){
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_6);
    
		}else if("BooleanType".equals(cType)){
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}else if("ObjectType".equals(cType)){
		
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_15);
    
		}else if("IntegerType".equals(cType)){
		
    stringBuffer.append(TEXT_16);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_18);
    
		}else if("DecimalType".equals(cType)){
		
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_21);
    
		}else if("UUIDType".equals(cType) || "TimeUUIDType".equals(cType)){
			if("CASSANDRA_1_1_2".equals(version)){
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_24);
    
			}else{
			
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_27);
    
			}
		}else{
	    
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    
		}
	}
}
ConvertTypeUtil convertUtil = new ConvertTypeUtil();
convertUtil.setCID(cid);
convertUtil.setVersion(version);
String keyColumn = null;
String keyCType = null;
for(int i = 0; i < sizeColumns; i++){
	IMetadataColumn column = columns.get(i);
	if(column.isKey()){
		keyColumn = column.getLabel();
		keyCType = column.getType();
		break;
	}
}
if(keyColumn != null){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    convertUtil.convert(keyCType, inConnName, keyColumn);
    stringBuffer.append(TEXT_33);
    
}

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
for(int i = 0; i < sizeColumns; i++){
	IMetadataColumn column = columns.get(i);
	JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
	String columnName = column.getLabel();
	String cType = column.getType();
	if(column.isKey()){
		continue;
	}
	
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    convertUtil.convert(cType, inConnName, columnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
} 

    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}

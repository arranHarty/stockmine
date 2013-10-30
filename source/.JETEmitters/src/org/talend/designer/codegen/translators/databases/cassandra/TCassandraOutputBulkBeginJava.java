package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TCassandraOutputBulkBeginJava
{
  protected static String nl;
  public static synchronized TCassandraOutputBulkBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraOutputBulkBeginJava result = new TCassandraOutputBulkBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "byte[] bTrue_";
  protected final String TEXT_2 = " = new byte[1];" + NL + "byte[] bFalse_";
  protected final String TEXT_3 = " = new byte[1];" + NL + "bTrue_";
  protected final String TEXT_4 = "[0] = (byte)1;" + NL + "bFalse_";
  protected final String TEXT_5 = "[0] = (byte)0;" + NL + "java.io.File file_";
  protected final String TEXT_6 = " = new java.io.File(";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = "+\"/\"+";
  protected final String TEXT_9 = ");\t\t" + NL + "file_";
  protected final String TEXT_10 = ".mkdirs();" + NL + "" + NL + "class ObjectSerializer_";
  protected final String TEXT_11 = "{" + NL + "\tpublic java.nio.ByteBuffer toByteBuffer(Object obj){" + NL + "\t    try{" + NL + "\t      \tByteArrayOutputStream baos = new ByteArrayOutputStream();" + NL + "\t      \tObjectOutputStream oos = new ObjectOutputStream(baos);" + NL + "\t      \toos.writeObject(obj);" + NL + "\t      \toos.close();" + NL + "\t      \treturn java.nio.ByteBuffer.wrap(baos.toByteArray());" + NL + "\t    }catch (IOException ex){" + NL + "\t      \tthrow new RuntimeException(ex);" + NL + "\t    }" + NL + "\t}" + NL + "}" + NL + "ObjectSerializer_";
  protected final String TEXT_12 = " objectSerializer_";
  protected final String TEXT_13 = " = new ObjectSerializer_";
  protected final String TEXT_14 = "();" + NL + "" + NL + "org.apache.cassandra.dht.IPartitioner partitioner_";
  protected final String TEXT_15 = " = new org.apache.cassandra.dht.";
  protected final String TEXT_16 = "();" + NL + "" + NL + "org.apache.cassandra.io.sstable.SSTableSimpleUnsortedWriter writer_";
  protected final String TEXT_17 = " = new org.apache.cassandra.io.sstable.SSTableSimpleUnsortedWriter(file_";
  protected final String TEXT_18 = ", partitioner_";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ", " + NL + "\torg.apache.cassandra.db.marshal.";
  protected final String TEXT_22 = ".instance" + NL + "\t," + NL + "\t";
  protected final String TEXT_23 = NL + "\tnull" + NL + "\t";
  protected final String TEXT_24 = NL + "\torg.apache.cassandra.db.marshal.AsciiType.instance" + NL + "\t";
  protected final String TEXT_25 = NL + "\t,";
  protected final String TEXT_26 = NL + "\t);      ";

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

String sstablePath = ElementParameterParser.getValue(node,"__SSTABLE_STORE_PATH__");
String keySpace = ElementParameterParser.getValue(node,"__KEY_SPACE__");
String columnFamily = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");
String partitioner = ElementParameterParser.getValue(node,"__PARTITIONER__");
String comparator = ElementParameterParser.getValue(node,"__COMPARATOR__");
String sub_comparator = ElementParameterParser.getValue(node,"__SUBCOMPARATOR__");

String buffer_size = ElementParameterParser.getValue(node,"__BUFFER_SIZE__");


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(sstablePath);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(partitioner);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(comparator);
    stringBuffer.append(TEXT_22);
    
	sub_comparator = "NONE";
	if("NONE".equals(sub_comparator)){
	
    stringBuffer.append(TEXT_23);
    
	}else if("ASCIITYPE".equals(comparator)){
	
    stringBuffer.append(TEXT_24);
    
	}
	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(buffer_size);
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}

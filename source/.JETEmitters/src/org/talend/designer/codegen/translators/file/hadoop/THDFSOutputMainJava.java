package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class THDFSOutputMainJava
{
  protected static String nl;
  public static synchronized THDFSOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSOutputMainJava result = new THDFSOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\twriter_";
  protected final String TEXT_3 = ".append(new ";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "),new ";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = "));";
  protected final String TEXT_10 = NL + "\t\t\t\tStringBuilder sb_";
  protected final String TEXT_11 = " = new StringBuilder();";
  protected final String TEXT_12 = NL + "\t\t\t\tif(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " != null) {";
  protected final String TEXT_15 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_16 = ".append(";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ")";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_22 = ".toPlainString()";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_24 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ")).toString()";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t\t\t\t\t);";
  protected final String TEXT_30 = NL + "\t\t\t\t}";
  protected final String TEXT_31 = "\t\t\t\t\t" + NL + "\t\t\t\t\tsb_";
  protected final String TEXT_32 = ".append(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t\t\t\t";
  protected final String TEXT_35 = "_list_";
  protected final String TEXT_36 = ".add(";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t\t\t\tsb_";
  protected final String TEXT_39 = ".append(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t\t\tout";
  protected final String TEXT_42 = ".write(sb_";
  protected final String TEXT_43 = ".toString());";
  protected final String TEXT_44 = NL + "\t\t\t\t\tout";
  protected final String TEXT_45 = ".write(sb_";
  protected final String TEXT_46 = ".toString().getBytes(";
  protected final String TEXT_47 = "));";
  protected final String TEXT_48 = NL + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
	boolean customEncoding="true".equals( ElementParameterParser.getValue(node,"__CUSTOM_ENCODING__"));
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	
	boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
	String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
	
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	IConnection inConn = null;
	IMetadataTable metadata = null;
	
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}

String typeFile = ElementParameterParser.getValue(node,"__TYPEFILE__");

if (metadata!=null) {
	List< ? extends IConnection> conns = node.getIncomingConnections();
		for (IConnection conn : conns) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				if (typeFile.equals("SEQUENCE")) {
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(keyClass );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(keyColumn );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(valueClass );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(valueColumn );
    stringBuffer.append(TEXT_9);
    
				} else {
					List<IMetadataColumn> columnList = metadata.getListColumns();
					int sizeColumns = columnList.size();

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
					for (int i = 0; i < sizeColumns; i++) {
						IMetadataColumn column = columnList.get(i);
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
						if(!isPrimitive) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_14);
    
						}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
						String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_20);
    	
						} else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_22);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_23);
    stringBuffer.append((customEncoding?encoding:"utf8Charset"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    
						} else {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    				
						}

    stringBuffer.append(TEXT_29);
    
						if(!isPrimitive) {

    stringBuffer.append(TEXT_30);
    
						}
						
						if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_33);
    
										}
				}
				if(node.isVirtualGenerateNode()){
					String origin = ElementParameterParser.getValue(node, "__DESTINATION__");
					String con_name = org.talend.core.model.utils.NodeUtil.getPrivateConnClassName(conn);

    stringBuffer.append(TEXT_34);
    stringBuffer.append(con_name);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(origin);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    
				}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_40);
    
				if(!compress) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
				} else {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(customEncoding?encoding:"");
    stringBuffer.append(TEXT_47);
    
				}
			}
		}
	}
}

    stringBuffer.append(TEXT_48);
    return stringBuffer.toString();
  }
}

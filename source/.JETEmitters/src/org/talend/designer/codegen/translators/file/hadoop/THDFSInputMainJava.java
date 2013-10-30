package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class THDFSInputMainJava
{
  protected static String nl;
  public static synchronized THDFSInputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSInputMainJava result = new THDFSInputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " = new ";
  protected final String TEXT_3 = "Struct();";
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = " = key_";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ";" + NL + "\t\t";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " = value_";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " = fid_";
  protected final String TEXT_16 = ".get(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "if(fid_";
  protected final String TEXT_19 = ".get(";
  protected final String TEXT_20 = ")!=null && fid_";
  protected final String TEXT_21 = ".get(";
  protected final String TEXT_22 = ").length() > 0) {";
  protected final String TEXT_23 = NL + "\t\t";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = " = ParserUtils.parseTo_Date(fid_";
  protected final String TEXT_26 = ".get(";
  protected final String TEXT_27 = "), ";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = " = fid_";
  protected final String TEXT_32 = ".get(";
  protected final String TEXT_33 = ").getBytes(";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = " = ParserUtils.parseTo_";
  protected final String TEXT_38 = "(fid_";
  protected final String TEXT_39 = ".get(";
  protected final String TEXT_40 = "));";
  protected final String TEXT_41 = NL + "}else{" + NL + "\t";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ";" + NL + "}";
  protected final String TEXT_45 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean customEncoding="true".equals( ElementParameterParser.getValue(node,"__CUSTOM_ENCODING__"));
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
if (conns!=null) {
	if (conns.size()>0) {
		IConnection conn = conns.get(0);
		if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			firstConnName = conn.getName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
    
			}
		}
	}
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0) && firstConnName.length()>0) {
		IMetadataTable metadata = metadatas.get(0);
	
		String typeFile = ElementParameterParser.getValue(node,"__TYPEFILE__");
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
		

    stringBuffer.append(TEXT_4);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(keyColumn );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(((keyClass.equals("org.apache.hadoop.io.Text"))?"toString()":"get()") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(valueColumn );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(((valueClass.equals("org.apache.hadoop.io.Text"))?"toString()":"get()") );
    stringBuffer.append(TEXT_12);
    
		} else {
			if (metadata!=null) {
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				for (int valueN = 0; valueN < listColumns.size(); valueN++) {
					IMetadataColumn column = listColumns.get(valueN);

					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_17);
    
					} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_22);
    
						if (javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_28);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_33);
    stringBuffer.append((customEncoding?encoding:"utf8Charset"));
    stringBuffer.append(TEXT_34);
    
						} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_40);
    
						}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_44);
    
					}
				} // for
			}
		}
	}

    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}

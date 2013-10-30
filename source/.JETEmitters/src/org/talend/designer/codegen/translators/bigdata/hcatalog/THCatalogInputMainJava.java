package org.talend.designer.codegen.translators.bigdata.hcatalog;

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

public class THCatalogInputMainJava
{
  protected static String nl;
  public static synchronized THCatalogInputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THCatalogInputMainJava result = new THCatalogInputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " = new ";
  protected final String TEXT_3 = "Struct();";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = " = fid_";
  protected final String TEXT_7 = ".get(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "if(fid_";
  protected final String TEXT_10 = ".get(";
  protected final String TEXT_11 = ")!=null && fid_";
  protected final String TEXT_12 = ".get(";
  protected final String TEXT_13 = ").length() > 0) {";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = " = ParserUtils.parseTo_Date(fid_";
  protected final String TEXT_17 = ".get(";
  protected final String TEXT_18 = "), ";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = " = fid_";
  protected final String TEXT_23 = ".get(";
  protected final String TEXT_24 = ").getBytes(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\t";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = " = ParserUtils.parseTo_";
  protected final String TEXT_29 = "(fid_";
  protected final String TEXT_30 = ".get(";
  protected final String TEXT_31 = "));";
  protected final String TEXT_32 = NL + "}else{" + NL + "\t";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "}";
  protected final String TEXT_36 = NL;

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
if ((metadatas!=null)&&(metadatas.size()>0)&& firstConnName.length()>0) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List<IMetadataColumn> listColumns = metadata.getListColumns();
		for (int valueN = 0; valueN < listColumns.size(); valueN++) {
			IMetadataColumn column = listColumns.get(valueN);
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_8);
    
			} else {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_13);
    
					if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_19);
    
					}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_24);
    stringBuffer.append((customEncoding?encoding:"utf8Charset"));
    stringBuffer.append(TEXT_25);
    
					} else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_31);
    
					}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_35);
    
			}

    
		} // for
	}
}

    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}

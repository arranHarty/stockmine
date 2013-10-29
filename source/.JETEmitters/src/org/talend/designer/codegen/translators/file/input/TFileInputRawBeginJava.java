package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TFileInputRawBeginJava
{
  protected static String nl;
  public static synchronized TFileInputRawBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputRawBeginJava result = new TFileInputRawBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\tjava.io.FileInputStream fis_";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + NL + "\t\t\t\ttry {";
  protected final String TEXT_5 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\tString content_";
  protected final String TEXT_6 = " = org.apache.commons.io.FileUtils.readFileToString(new java.io.File(";
  protected final String TEXT_7 = "), ";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " = content_";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\tfis_";
  protected final String TEXT_13 = " = org.apache.commons.io.FileUtils.openInputStream(new java.io.File(";
  protected final String TEXT_14 = "));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = " = fis_";
  protected final String TEXT_17 = ";";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\tbyte[] content_";
  protected final String TEXT_19 = " = org.apache.commons.io.FileUtils.readFileToByteArray(new java.io.File(";
  protected final String TEXT_20 = "));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = " = content_";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = "\t\t\t\t\t" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_25 = "_FILENAME_PATH\", ";
  protected final String TEXT_26 = ");" + NL + "\t\t\t\t} catch (java.io.IOException e_";
  protected final String TEXT_27 = ") {";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\tthrow e_";
  protected final String TEXT_29 = ";";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\t\t\t\t}";
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String filename = ElementParameterParser.getValue(node, "__FILENAME__");
	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
	
	boolean asString = "true".equals(ElementParameterParser.getValue(node, "__AS_STRING__"));
	boolean asBytearray = "true".equals(ElementParameterParser.getValue(node, "__AS_BYTEARRAY__"));
	boolean asInputstream = "true".equals(ElementParameterParser.getValue(node, "__AS_INPUTSTREAM__"));
	
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	
	java.util.List<IMetadataColumn> columnList = null;
	java.util.List<IMetadataTable> metadatas = node.getMetadataList();
	if(metadatas != null && metadatas.size() > 0) {
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null) {
		    columnList = metadata.getListColumns();
		}
	}
	java.util.List< ? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
	if(columnList!=null && outgoingConns!=null && outgoingConns.size()>0) {
		for(IConnection outgoingConn : outgoingConns) {
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				if(asInputstream) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
				}

    stringBuffer.append(TEXT_4);
    
					if(asString) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnList.get(0).getLabel());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
					} else if(asInputstream) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnList.get(0).getLabel());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
					} else if(asBytearray) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(columnList.get(0).getLabel());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
					}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
					if(dieOnError) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
					} else {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
					}

    stringBuffer.append(TEXT_32);
    
			}
		}
	}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}

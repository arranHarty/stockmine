package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TFileInputRawEndJava
{
  protected static String nl;
  public static synchronized TFileInputRawEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputRawEndJava result = new TFileInputRawEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tif(fis_";
  protected final String TEXT_3 = "!=null)" + NL + "\t\t\t\t\t\t\tfis_";
  protected final String TEXT_4 = ".close();" + NL + "\t\t\t\t\t} catch (java.io.IOException e_";
  protected final String TEXT_5 = ") {";
  protected final String TEXT_6 = NL + "\t\t\t\t\t\t\tthrow e_";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t\t\t\t}";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL;

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
						if(dieOnError) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
						} else {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
						}

    stringBuffer.append(TEXT_10);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}

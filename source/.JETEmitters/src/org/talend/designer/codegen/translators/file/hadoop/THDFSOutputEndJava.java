package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class THDFSOutputEndJava
{
  protected static String nl;
  public static synchronized THDFSOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSOutputEndJava result = new THDFSOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\twriter_";
  protected final String TEXT_3 = ".close();";
  protected final String TEXT_4 = NL + "\t\tif(out";
  protected final String TEXT_5 = "!=null){" + NL + "\t\t\tout";
  protected final String TEXT_6 = ".close();" + NL + "\t\t}";
  protected final String TEXT_7 = NL + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	IConnection inConn = null;
	IMetadataTable metadata = null;
	
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}
	
	if (metadata!=null) {
		String typeFile = ElementParameterParser.getValue(node,"__TYPEFILE__");
		if (typeFile.equals("SEQUENCE")) {	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		} else {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
		}
	}

    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TSystemEndJava
{
  protected static String nl;
  public static synchronized TSystemEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSystemEndJava result = new TSystemEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t\tif(log4jSb_";
  protected final String TEXT_4 = "!=null && log4jSb_";
  protected final String TEXT_5 = ".toString().length()>0){ " + NL + "\t\t\t\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_6 = " - Content of the output sent to the schema: \" + log4jSb_";
  protected final String TEXT_7 = ");" + NL + "\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_8 = ".delete(0,log4jSb_";
  protected final String TEXT_9 = ".length());" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_10 = NL + "}\t\t\t";
  protected final String TEXT_11 = NL + "globalMap.put(\"";
  protected final String TEXT_12 = "_EXIT_VALUE\", ps_";
  protected final String TEXT_13 = ".exitValue());";
  protected final String TEXT_14 = NL + "\tlog.info(\"";
  protected final String TEXT_15 = " - Done.\");";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	String outputAction  = ElementParameterParser.getValue(node, "__OUTPUT__");
	String errorOutput  = ElementParameterParser.getValue(node, "__ERROROUTPUT__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	if(("NORMAL_OUTPUT").equals(outputAction)||("NORMAL_OUTPUT").equals(errorOutput)){
    	List<IMetadataTable> metadatas = node.getMetadataList();
        if ((metadatas!=null)&&(metadatas.size()>0)) {
        	IMetadataTable metadata = metadatas.get(0);
        	if (metadata!=null) {
        		List<IMetadataColumn> columns=metadata.getListColumns();
        		List<? extends IConnection> conns = node.getOutgoingSortedConnections();
        		if (conns!=null && conns.size()>0) {
        			IConnection conn = conns.get(0);  
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
					}
				}
			}
		}
	}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}

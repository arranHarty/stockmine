package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;

public class TContextDumpEndJava
{
  protected static String nl;
  public static synchronized TContextDumpEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TContextDumpEndJava result = new TContextDumpEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Dumping the context \" + nb_line_";
  protected final String TEXT_5 = " + \": \" + log4jSb_";
  protected final String TEXT_6 = ");" + NL + "\t\t\tlog4jSb_";
  protected final String TEXT_7 = ".delete(0,log4jSb_";
  protected final String TEXT_8 = ".length());" + NL + "\t\t";
  protected final String TEXT_9 = NL + "        }" + NL + "        globalMap.put(\"";
  protected final String TEXT_10 = "_NB_LINE\",nb_line_";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "        \tlog.info(\"";
  protected final String TEXT_13 = " - Dumped contexts count: \" + nb_line_";
  protected final String TEXT_14 = " + \".\");" + NL + "        \tlog.info(\"";
  protected final String TEXT_15 = " - Done.\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    List<IMetadataColumn> columnList = null;
    List<IMetadataTable> metadatas = node.getMetadataList();
    if(metadatas != null && metadatas.size() > 0) {
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null) {
            columnList = metadata.getListColumns();
        }
    }
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    List< ? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    if(columnList != null && columnList.size() > 0 && outgoingConns != null && outgoingConns.size() > 0) {
        
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
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    
    }

    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.databases.hbase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class THBaseCloseMainJava
{
  protected static String nl;
  public static synchronized THBaseCloseMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseCloseMainJava result = new THBaseCloseMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\torg.apache.hadoop.conf.Configuration conn_";
  protected final String TEXT_3 = " = (org.apache.hadoop.conf.Configuration)globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "\tif(conn_";
  protected final String TEXT_5 = " != null )" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "\t\torg.apache.hadoop.hbase.client.HConnectionManager.deleteConnection(conn_";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t\torg.apache.hadoop.hbase.client.HConnectionManager.deleteConnection(conn_";
  protected final String TEXT_10 = ",true);";
  protected final String TEXT_11 = NL + "\t\tglobalMap.remove(\"";
  protected final String TEXT_12 = "\");" + NL + "\t}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    String conn = "conn_" + connection;
    
    String hbaseVersion = null;
    boolean isCustom = false;
	List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
		if (targetNode.getUniqueName().equals(connection)) {
        	hbaseVersion = ElementParameterParser.getValue(targetNode, "__HBASE_VERSION__");
        	isCustom = "CUSTOM".equals(ElementParameterParser.getValue(targetNode, "__DISTRIBUTION__"));
        	break;
	    }
    }

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    if(!isCustom && "HDP_2_0".equals(hbaseVersion)) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}

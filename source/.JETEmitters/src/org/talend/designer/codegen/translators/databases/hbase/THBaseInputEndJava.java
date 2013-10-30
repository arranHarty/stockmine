package org.talend.designer.codegen.translators.databases.hbase;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class THBaseInputEndJava
{
  protected static String nl;
  public static synchronized THBaseInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseInputEndJava result = new THBaseInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tnb_line_";
  protected final String TEXT_2 = "++;" + NL + "}";
  protected final String TEXT_3 = NL + "\tif(table_";
  protected final String TEXT_4 = "!=null){" + NL + "\t\ttable_";
  protected final String TEXT_5 = ".close();" + NL + "\t}" + NL + "\tif(scanner_";
  protected final String TEXT_6 = "!=null){" + NL + "\t\tscanner_";
  protected final String TEXT_7 = ".close();" + NL + "\t}";
  protected final String TEXT_8 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_9 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t\torg.apache.hadoop.hbase.client.HConnectionManager.deleteConnection(conn_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\torg.apache.hadoop.hbase.client.HConnectionManager.deleteConnection(conn_";
  protected final String TEXT_14 = ",true);";
  protected final String TEXT_15 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_16 = NL + "globalMap.put(\"";
  protected final String TEXT_17 = "_NB_LINE\",nb_line_";
  protected final String TEXT_18 = "); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata != null) {
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if (conns != null){
			if (conns.size()>0){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
//use existing connection
if(!"true".equals(useExistingConn)){
	String hbaseVersion = ElementParameterParser.getValue(node,"__HBASE_VERSION__");
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    if(!isCustom && "HDP_2_0".equals(hbaseVersion)) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    } else {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}

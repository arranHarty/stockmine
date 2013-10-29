package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;

public class THashEndJava
{
  protected static String nl;
  public static synchronized THashEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashEndJava result = new THashEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "if (isMultiThreaded_";
  protected final String TEXT_2 = ") {" + NL + "java.util.List<java.util.concurrent.ConcurrentHashMap<String,Object>> mapsList_";
  protected final String TEXT_3 = " = " + NL + "\t(java.util.List<java.util.concurrent.ConcurrentHashMap<String,Object>>)globalMap.get(\"THREAD_MAPS_\"+jobName);" + NL + "\tif (mapsList_";
  protected final String TEXT_4 = " != null) {" + NL + "\t\tfor (java.util.concurrent.ConcurrentHashMap<String,Object> map : mapsList_";
  protected final String TEXT_5 = ") {" + NL + "\t\t\tif (globalMap != map) {\t\t" + NL + "\t\t\t\tmap.put(\"tHash_Lookup_";
  protected final String TEXT_6 = "\",tHash_";
  protected final String TEXT_7 = ");" + NL + "\t\t\t} //gm" + NL + "\t\t}//for" + NL + "\t}//null" + NL + "}//is threaded" + NL + "}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
    boolean includeParallelComps = false;
	List<? extends INode> listPartitions= node.getProcess().getNodesOfType("tPartitioner");
	if (listPartitions!=null && listPartitions.size() > 0 ) {
		includeParallelComps = true;
	}
	if (connections != null && connections.size() > 0) {
        for (IConnection connection : connections) {
        	String connectionName = connection.getName();

            IMetadataTable metadataTable = connection.getMetadataTable();
            
			if (includeParallelComps) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_7);
      		}
  		}
  	}

    return stringBuffer.toString();
  }
}

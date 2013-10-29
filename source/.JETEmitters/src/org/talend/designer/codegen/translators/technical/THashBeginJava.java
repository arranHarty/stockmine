package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class THashBeginJava
{
  protected static String nl;
  public static synchronized THashBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashBeginJava result = new THashBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "synchronized (this) {" + NL + "\tif (globalMap.get(\"tHash_";
  protected final String TEXT_3 = "\") == null) {" + NL + "            java.util.Map<";
  protected final String TEXT_4 = "Struct, ";
  protected final String TEXT_5 = "Struct> tHash_";
  protected final String TEXT_6 = " = null;" + NL + "            boolean isMultiThreaded_";
  protected final String TEXT_7 = " = false;" + NL + "            if (globalMap.get(\"MULTI_THREADED_JOB_\"+jobName) == null || !((Boolean)globalMap.get(\"MULTI_THREADED_JOB_\"+jobName))) {" + NL + "            \ttHash_";
  protected final String TEXT_8 = " = new java.util.concurrent.ConcurrentHashMap<";
  protected final String TEXT_9 = "Struct,";
  protected final String TEXT_10 = "Struct>();" + NL + "            \tisMultiThreaded_";
  protected final String TEXT_11 = " = true;" + NL + "            } else {" + NL + "              \ttHash_";
  protected final String TEXT_12 = " = new java.util.LinkedHashMap<";
  protected final String TEXT_13 = "Struct, ";
  protected final String TEXT_14 = "Struct>();" + NL + "            }" + NL + "            globalMap.put(\"tHash_";
  protected final String TEXT_15 = "\", tHash_";
  protected final String TEXT_16 = ");" + NL;
  protected final String TEXT_17 = NL + "\t\tjava.util.Map<";
  protected final String TEXT_18 = "Struct, ";
  protected final String TEXT_19 = "Struct> tHash_";
  protected final String TEXT_20 = " = new java.util.LinkedHashMap<";
  protected final String TEXT_21 = "Struct, ";
  protected final String TEXT_22 = "Struct>();" + NL + "            globalMap.put(\"tHash_";
  protected final String TEXT_23 = "\", tHash_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "            ";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
        	

if (includeParallelComps) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_16);
    	} else {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_24);
    
	}
		}
	}


    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}

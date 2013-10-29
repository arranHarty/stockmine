package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.process.IHashableInputConnections;
import org.talend.core.model.process.IHashConfiguration;
import org.talend.core.model.process.IDataConnection;

public class TAdvancedHashEndJava
{
  protected static String nl;
  public static synchronized TAdvancedHashEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedHashEndJava result = new TAdvancedHashEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "tHash_Lookup_";
  protected final String TEXT_3 = ".endPut();";
  protected final String TEXT_4 = NL + "java.util.List<java.util.concurrent.ConcurrentHashMap<String,Object>> mapsList_";
  protected final String TEXT_5 = " = " + NL + "\t(java.util.List<java.util.concurrent.ConcurrentHashMap<String,Object>>)globalMap.get(\"THREAD_MAPS_\"+jobName);" + NL + "\tif (mapsList_";
  protected final String TEXT_6 = " != null) {" + NL + "\t" + NL + "" + NL + "\t\t\tfor (java.util.concurrent.ConcurrentHashMap<String,Object> map : mapsList_";
  protected final String TEXT_7 = ") {" + NL + "\t\t\t\t\torg.talend.designer.components.lookup.memory.ConcurrentAdvancedMemoryLookup" + NL + "\t\t\t   \t\t\t\t\t\t\t<";
  protected final String TEXT_8 = "Struct> tmp = (org.talend.designer.components.lookup.memory.ConcurrentAdvancedMemoryLookup" + NL + "\t\t\t   \t\t\t\t\t\t\t<";
  protected final String TEXT_9 = "Struct>)tHash_Lookup_";
  protected final String TEXT_10 = ";" + NL + "\t\t\t\tif (globalMap != map) {" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t//map.put(\"MAP_POPULATED_";
  protected final String TEXT_11 = "\",Boolean.TRUE);\t\t\t   \t\t\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tmap.put(\"tHash_Lookup_";
  protected final String TEXT_12 = "\",new org.talend.designer.components.lookup.memory.ConcurrentAdvancedMemoryLookup" + NL + "\t\t\t   \t\t\t\t\t\t\t<";
  protected final String TEXT_13 = "Struct>(tmp));\t\t\t   \t\t\t\t\t\t\t" + NL + "\t\t\t   \t\twhile (map.get(\"tHash_Lookup_";
  protected final String TEXT_14 = "\") == null) {" + NL + "\t\t\t   \t\t\tThread.sleep(1);" + NL + "\t\t\t   \t\t}" + NL + "\t\t\t   \t" + NL + "\t\t\t\t} " + NL + "\t\t\t}" + NL + "" + NL + "\t}" + NL + "" + NL + "} " + NL + "} catch (java.lang.Exception ex) {" + NL + "\tglobalMap.put(\"THREADS_HAVE_ERROR\",ex);" + NL + "\tthrow ex;" + NL + "} catch (Error er) {" + NL + "\tglobalMap.put(\"THREADS_HAVE_ERROR\",er);" + NL + "\tthrow er;" + NL + "}" + NL + "" + NL + "}//end synchronized" + NL + NL;
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

	if (connections != null && connections.size() > 0) {
        for (IConnection connection : connections) {
        	String connectionName = connection.getName();
			INode validTarget = ((IDataConnection) connection).getLinkNodeForHash();
			boolean memoryStorage = true;
			if(validTarget != null) {
				IHashConfiguration hashConfiguration = null;				
				boolean bSortOnDisk = "true".equals(ElementParameterParser.getValue(node, "__SORT_ON_DISK__")); 
				
			    if (validTarget instanceof IHashableInputConnections){
					IHashableInputConnections target = (IHashableInputConnections) validTarget;
					hashConfiguration = target.getHashConfiguration(connection.getName());
				} 
				memoryStorage = !(hashConfiguration != null && hashConfiguration.isPersistent() || bSortOnDisk);
			}
            
			boolean includeParallelComps = false;
			List<? extends INode> listPartitions= node.getProcess().getNodesOfType("tPartitioner");
			if (listPartitions!=null && listPartitions.size() > 0 ) {
				includeParallelComps = true;
			}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    
			if (includeParallelComps && memoryStorage) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_14);
    
			
			}
		}
	}

    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}

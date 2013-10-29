package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.EConnectionType;

public class TWriteJSONFieldInEndJava
{
  protected static String nl;
  public static synchronized TWriteJSONFieldInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteJSONFieldInEndJava result = new TWriteJSONFieldInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (globalMap.containsKey(\"";
  protected final String TEXT_3 = "_FINISH\") ) {" + NL + "\t\t\t\t\t\tif (queue_";
  protected final String TEXT_4 = ".isEmpty()) {" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\ttxf_";
  protected final String TEXT_6 = ".join();" + NL + "\t\t\t\t\tif(txf_";
  protected final String TEXT_7 = ".getLastException()!=null) {" + NL + "\t\t\t\t\t\tcurrentComponent = txf_";
  protected final String TEXT_8 = ".getCurrentComponent();" + NL + "\t\t\t\t\t\tthrow txf_";
  protected final String TEXT_9 = ".getLastException();" + NL + "\t\t\t\t\t}" + NL + "    \t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tglobalMap.remove(\"";
  protected final String TEXT_11 = "_FINISH\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "globalMap.put(\"";
  protected final String TEXT_13 = "_NB_LINE\",nb_line_";
  protected final String TEXT_14 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if(conns!=null && conns.size()>0){
			if (conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
				INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
				String virtualSourceCid = sourceNode.getUniqueName();
				INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
				String startNodeCid = null; 
				if(startNode != null){
					startNodeCid = startNode.getUniqueName();
				} 
				IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
				if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){
	   			
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
	}
}

String strJobCid="";
if(destination !=null && !("").equals(destination.trim()))
	strJobCid=destination;
else{
	strJobCid= cid.substring(0,cid.length()-3);
}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(strJobCid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}

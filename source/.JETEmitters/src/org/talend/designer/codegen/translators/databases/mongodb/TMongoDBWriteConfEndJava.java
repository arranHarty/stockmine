package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.EConnectionType;

public class TMongoDBWriteConfEndJava
{
  protected static String nl;
  public static synchronized TMongoDBWriteConfEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBWriteConfEndJava result = new TMongoDBWriteConfEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (globalMap.containsKey(\"";
  protected final String TEXT_2 = "_FINISH\") ) {" + NL + "\t\t\t\t\t\tif (queue_";
  protected final String TEXT_3 = ".isEmpty()) {" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\t\ttxf_";
  protected final String TEXT_5 = ".join();" + NL + "\t\t\t\t\tif(txf_";
  protected final String TEXT_6 = ".getLastException()!=null) {" + NL + "\t\t\t\t\t\tcurrentComponent = txf_";
  protected final String TEXT_7 = ".getCurrentComponent();" + NL + "\t\t\t\t\t\tthrow txf_";
  protected final String TEXT_8 = ".getLastException();" + NL + "\t\t\t\t\t}" + NL + "    \t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t}finally{" + NL + "\t\t\t\tif(mongo_";
  protected final String TEXT_10 = " != null ){" + NL + "\t\t\t\t\tmongo_";
  protected final String TEXT_11 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_12 = NL + "\t\t\tglobalMap.remove(\"";
  protected final String TEXT_13 = "_FINISH\");";
  protected final String TEXT_14 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_15 = "_NB_LINE\",nb_line_";
  protected final String TEXT_16 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String strJobCid=cid.replace("_Out","");
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
    	IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
				INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
				String virtualSourceCid = sourceNode.getUniqueName();
				INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
				String startNodeCid = null; 
				if(startNode != null){
					startNodeCid = startNode.getUniqueName();
				} 
				IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
				if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){
	   			
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
				
    
				if(!"true".equals(useExistingConn)){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
				}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
		}
	}


    stringBuffer.append(TEXT_14);
    stringBuffer.append(strJobCid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}

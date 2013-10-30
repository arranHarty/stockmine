package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TPigReplicateMainJava
{
  protected static String nl;
  public static synchronized TPigReplicateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigReplicateMainJava result = new TPigReplicateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "           pigServer_";
  protected final String TEXT_3 = ".registerQuery(\"";
  protected final String TEXT_4 = "_";
  protected final String TEXT_5 = "_RESULT = FOREACH ";
  protected final String TEXT_6 = "_";
  protected final String TEXT_7 = "_RESULT GENERATE *;\"); ";
  protected final String TEXT_8 = NL + "    \t   pl_";
  protected final String TEXT_9 = " = new Object[2];" + NL + "    \t   pl_";
  protected final String TEXT_10 = "[0] = \"query\";" + NL + "    \t   pl_";
  protected final String TEXT_11 = "[1] = \"";
  protected final String TEXT_12 = "_";
  protected final String TEXT_13 = "_RESULT = FOREACH ";
  protected final String TEXT_14 = "_";
  protected final String TEXT_15 = "_RESULT GENERATE *;\";" + NL + "\t       pigScript_";
  protected final String TEXT_16 = ".add(pl_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();	
    String cid = node.getUniqueName();
    
    List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {//a
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {//b	
        String previous_node = "";
        String start_node = "";
        
        boolean inMain = true;
        
		String previousOutputConnectionName = "";
		
      	List<? extends IConnection> inputConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
      	if ((inputConns!=null)&&(inputConns.size()>0)) {
      		IConnection incomingConn = inputConns.get(0); 
      		previous_node = incomingConn.getSource().getUniqueName();
			INode loadNode = node.getDesignSubjobStartNode();
    		start_node = loadNode.getUniqueName();
    		inMain = loadNode.isSubtreeStart();
      		
      		previousOutputConnectionName = incomingConn.getName();
      	}else{
      		return "";
      	}
	
	
    	List< ? extends IConnection> outConns = node.getOutgoingConnections();
    	for (IConnection conn : outConns) {	
    		if(conn.getLineStyle().equals(EConnectionType.FLOW_MAIN)||conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)){
    			if(inMain) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_7);
    		
				} else {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_17);
    
				}
    		}
    	}
  	}//b
 }//a	

    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}

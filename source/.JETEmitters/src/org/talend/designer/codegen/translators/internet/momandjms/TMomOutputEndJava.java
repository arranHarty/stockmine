package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomOutputEndJava
{
  protected static String nl;
  public static synchronized TMomOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputEndJava result = new TMomOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tsession_";
  protected final String TEXT_3 = ".commit();" + NL + "\t\t";
  protected final String TEXT_4 = " // if no commmit or rollback component exists - close session" + NL + " \t\tSystem.out.println(\"Closing connection\");" + NL + "\t\tproducer_";
  protected final String TEXT_5 = ".close();" + NL + "                session_";
  protected final String TEXT_6 = ".close();" + NL + "                connection_";
  protected final String TEXT_7 = ".close();" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t}catch(java.lang.Exception ex){" + NL + "\t\t\tSystem.out.println(\"A Active MQ error occurred :\" + ex);" + NL + "\t                ex.printStackTrace();" + NL + "\t\t\tsession_";
  protected final String TEXT_10 = ".rollback();";
  protected final String TEXT_11 = NL + "\t\t\tproducer_";
  protected final String TEXT_12 = ".close();" + NL + "                        session_";
  protected final String TEXT_13 = ".close();" + NL + "                        connection_";
  protected final String TEXT_14 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL + "\t\tglobalMap.put(\"remoteQ_";
  protected final String TEXT_18 = "\",remoteQ_";
  protected final String TEXT_19 = ");" + NL + "\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_20 = "\",qMgr_";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\tSystem.out.println(\"Closing connection\");" + NL + "\tremoteQ_";
  protected final String TEXT_23 = ".close();" + NL + "    qMgr_";
  protected final String TEXT_24 = ".disconnect();" + NL;
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
String cid = node.getUniqueName();
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

boolean isCommitRollback = (!node.getProcess().getNodesOfType("tMomCommit").isEmpty()
	|| !node.getProcess().getNodesOfType("tMomRollback").isEmpty());
 

if (isUseSharedConnection) {
	for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
		if (pNode.getUniqueName().equals(connectionComponentName)) {
			transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
			serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
		}	
	}
}

if(("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType) || isUseSharedConnection){
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
		if( ("JBoss").equals(serverType) || ( ("ActiveMQ").equals(serverType) && !isCommitRollback) ){
		// if no commmit or rollback component exists and set transacted - commit session
		if(transacted){
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	
		}
                if (!isUseSharedConnection) {
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    	
		}
		}
		
    stringBuffer.append(TEXT_8);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    if (!isUseSharedConnection) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
		}
		
    stringBuffer.append(TEXT_16);
    
}else{//server judgement   /***WebSphere MQ*****/
	if (transacted) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
	} else {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
	}
}

    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}

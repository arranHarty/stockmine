package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomInputLoopEndJava
{
  protected static String nl;
  public static synchronized TMomInputLoopEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputLoopEndJava result = new TMomInputLoopEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\tmessage_";
  protected final String TEXT_3 = ".acknowledge();" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\tThread.sleep(";
  protected final String TEXT_6 = "*1000);" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tbreak;" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\tif (session_";
  protected final String TEXT_10 = " != null && connection_";
  protected final String TEXT_11 = " != null) session_";
  protected final String TEXT_12 = ".commit();" + NL + "\t\t}catch(java.lang.Exception ex){" + NL + "\t\t\tSystem.out.println(\"A Active MQ error occurred :\" + ex);" + NL + "\t                ex.printStackTrace();" + NL + "\t\t\tif (session_";
  protected final String TEXT_13 = " != null  && connection_";
  protected final String TEXT_14 = " != null) session_";
  protected final String TEXT_15 = ".rollback();" + NL + "\t\t}";
  protected final String TEXT_16 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_17 = NL + " \t\t if (session_";
  protected final String TEXT_18 = " != null  && connection_";
  protected final String TEXT_19 = " != null) session_";
  protected final String TEXT_20 = ".close();" + NL + "                 if (connection_";
  protected final String TEXT_21 = " != null) connection_";
  protected final String TEXT_22 = ".close();" + NL + "\t\t";
  protected final String TEXT_23 = NL + NL + "\t\t";
  protected final String TEXT_24 = NL + " \t\tSystem.out.println(\"Closing connection\");" + NL + "                consumer_";
  protected final String TEXT_25 = ".close();" + NL + "                session_";
  protected final String TEXT_26 = ".close();" + NL + "                connection_";
  protected final String TEXT_27 = ".close();" + NL + "\t\t";
  protected final String TEXT_28 = NL + NL + "\t";
  protected final String TEXT_29 = NL + "\t\t" + NL + "\t\t\t}\t" + NL + "\t\t\tSystem.out.println(\"Closing connection\");" + NL + "\t\t\tremoteQ";
  protected final String TEXT_30 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\tqMgr";
  protected final String TEXT_32 = ".backout();" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\tqMgr";
  protected final String TEXT_34 = ".disconnect();" + NL + "\t\t" + NL + "\t\t}catch(com.ibm.mq.MQException ex){" + NL + "\t\t\tSystem.out.println(\"A WebSphere MQ error occurred : Completion code \" + ex.completionCode + \" Reason code \" + ex.reasonCode);" + NL + "\t\t\tremoteQ";
  protected final String TEXT_35 = ".close();" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_36 = NL + NL + "} finally {" + NL + "//        System.out.println(\"close connection after loop!\");" + NL + "\t\t";
  protected final String TEXT_37 = NL + "                 if (connection_";
  protected final String TEXT_38 = " != null) connection_";
  protected final String TEXT_39 = ".close();" + NL + "\t\t";
  protected final String TEXT_40 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
        boolean isUseConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
	String timeOut=ElementParameterParser.getValue(node, "__TIMEOUT__");
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));	
        String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

        boolean isCommitRollback = (!node.getProcess().getNodesOfType("tMomCommit").isEmpty()
	|| !node.getProcess().getNodesOfType("tMomRollback").isEmpty());
 

        if (isUseConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
				serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
			}	
		}


	}
	
	if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType) || isUseConnection) {
		if ("CLIENT_ACKNOWLEDGE".equals(acknowledgmentMode)) {
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	
		}
		if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
		
    stringBuffer.append(TEXT_4);
    
		}
		if(("JBoss").equals(serverType)){
			if("true".equals(kListen)){
			
    stringBuffer.append(TEXT_5);
    stringBuffer.append(timeOut);
    stringBuffer.append(TEXT_6);
    		
			}else{
			
    stringBuffer.append(TEXT_7);
    			
			}
		}else if(("ActiveMQ").equals(serverType) || isUseConnection) {
			if (("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"))) {
			
    stringBuffer.append(TEXT_8);
    
			}
		}
               if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    if( ("ActiveMQ").equals(serverType) && !isCommitRollback && !isUseConnection){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    if( ("JBoss").equals(serverType) ){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    		
	}else{
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		isRollback = isRollback && ("false".equals(kListen)) && !isCommit && !isBrowse;
		
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
			if(isRollback){
			
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
			}
			
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	}
	
    stringBuffer.append(TEXT_36);
    if( ("ActiveMQ").equals(serverType) && !isUseConnection){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.core.GlobalServiceRegister;
import org.talend.designer.codegen.ITalendSynchronizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import org.talend.designer.codegen.config.NodesSubTree;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;

public class Camel_speciallinksJava
{
  protected static String nl;
  public static synchronized Camel_speciallinksJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Camel_speciallinksJava result = new Camel_speciallinksJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t.when(";
  protected final String TEXT_3 = ")";
  protected final String TEXT_4 = NL + "\t\t\t\t.endChoice()";
  protected final String TEXT_5 = NL + "\t\t\t.when().";
  protected final String TEXT_6 = NL + "\t\t\t\t.endChoice()";
  protected final String TEXT_7 = NL + "\t\t.otherwise()";
  protected final String TEXT_8 = NL + "\t\t.doTry()";
  protected final String TEXT_9 = NL + "\t\t.doCatch(";
  protected final String TEXT_10 = ")";
  protected final String TEXT_11 = NL + "\t\t.doFinally()";
  protected final String TEXT_12 = NL + "\t\t\t\t.endChoice()";
  protected final String TEXT_13 = NL + "\t\t.end()";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

INode node = (INode) codeGenArgument.getArgument();

List< ? extends IConnection> connsIf = node.getIncomingConnections();
if(connsIf.size()>0) {
	if(connsIf.get(0).getLineStyle()==EConnectionType.ROUTE_WHEN) {
		IConnection currentConnection = connsIf.get(0);
		INode sourceNode = currentConnection.getSource();
		String languageType = currentConnection.getRouteConnectionType();
		String condition = currentConnection.getCondition();
		String expression = "none".equals(languageType)?condition:languageType+"("+condition+")";
		if("cIntercept".equals(sourceNode.getComponent().getName())){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_3);
    		
		}else if("cMessageRouter".equals(sourceNode.getComponent().getName())){
			/*
			* if is cMessageRouter, we have to know the endChoice() is necessary or not
			* according to the setting of very previous when connection setting
			*/
			int currentOrder = currentConnection.getOutputId();
			int previousOrder = -1;
			IConnection previousCon = null;
			List<? extends IConnection> allWhenConnections = sourceNode.getOutgoingConnections(EConnectionType.ROUTE_WHEN);
			for(IConnection c:allWhenConnections){
				int tmp = c.getOutputId();
				if(tmp < currentOrder && tmp >previousOrder){
					previousCon = c;
					previousOrder = tmp;
				}
			} 
			if(previousCon != null && "true".equals(previousCon.getEndChoice())){

    stringBuffer.append(TEXT_4);
    
			}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(expression);
    
		}
	} else if(connsIf.get(0).getLineStyle()==EConnectionType.ROUTE_OTHER) {
			IConnection currentConnection = connsIf.get(0);
			INode sourceNode = currentConnection.getSource();
			if("cMessageRouter".equals(sourceNode.getComponent().getName())){
				/*
				* if is cMessageRouter, we have to know the endChoice() is necessary or not
				* according to the setting of latest when connection setting
				*/
				int previousOrder = -1;
				IConnection previousCon = null;
				List<? extends IConnection> allWhenConnections = sourceNode.getOutgoingConnections(EConnectionType.ROUTE_WHEN);
				int whenConnectionsSize = allWhenConnections.size();
				if(whenConnectionsSize == 1){
					previousCon = allWhenConnections.get(0);
				}else if(whenConnectionsSize >1){
					for(IConnection c:allWhenConnections){
						int tmp = c.getOutputId();
						if(tmp >previousOrder){
							previousCon = c;
							previousOrder = tmp;
						}
					} 
				}
				if(previousCon != null && "true".equals(previousCon.getEndChoice())){

    stringBuffer.append(TEXT_6);
    
				}
			}

    stringBuffer.append(TEXT_7);
    
	} else if(connsIf.get(0).getLineStyle()==EConnectionType.ROUTE_TRY) {

    stringBuffer.append(TEXT_8);
    
	} else if(connsIf.get(0).getLineStyle()==EConnectionType.ROUTE_CATCH) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(connsIf.get(0).getExceptionList());
    stringBuffer.append(TEXT_10);
    
	} else if(connsIf.get(0).getLineStyle()==EConnectionType.ROUTE_FINALLY) {

    stringBuffer.append(TEXT_11);
    
	} else if(connsIf.get(0).getLineStyle()==EConnectionType.ROUTE_ENDBLOCK) {
		IConnection currentConnection = connsIf.get(0);
		INode sourceNode = currentConnection.getSource();
		if("cMessageRouter".equals(sourceNode.getComponent().getName())){
			/*
			* if is cMessageRouter, we have to know the endChoice() is necessary or not
			* according to the setting of latest when connection setting (if no otherwise)
			*/
			List<? extends IConnection> allOtherCons = sourceNode.getOutgoingConnections(EConnectionType.ROUTE_OTHER);
			if(allOtherCons == null || allOtherCons.size() == 0){
				int previousOrder = -1;
				IConnection previousCon = null;
				List<? extends IConnection> allWhenConnections = sourceNode.getOutgoingConnections(EConnectionType.ROUTE_WHEN);
				for(IConnection c:allWhenConnections){
					int tmp = c.getOutputId();
					if(tmp >previousOrder){
						previousCon = c;
						previousOrder = tmp;
					}
				} 
				if(previousCon != null && "true".equals(previousCon.getEndChoice())){

    stringBuffer.append(TEXT_12);
    
				}
			}	
		}

    stringBuffer.append(TEXT_13);
    
	}
}	

    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}

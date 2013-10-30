package org.talend.designer.codegen.translators.databases.riak;

import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TRiakOutputEndJava
{
  protected static String nl;
  public static synchronized TRiakOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRiakOutputEndJava result = new TRiakOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t}catch (java.lang.Exception e_";
  protected final String TEXT_3 = "){";
  protected final String TEXT_4 = NL + "        throw(e_";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_7 = ".getMessage());";
  protected final String TEXT_8 = NL + "\t}finally{" + NL + "\t\tif(client_";
  protected final String TEXT_9 = " !=null){" + NL + "\t\t\tclient_";
  protected final String TEXT_10 = ".shutdown();" + NL + "\t\t}";
  protected final String TEXT_11 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_12 = "_UPSERT_NB_LINE\", upsert_nb_line_";
  protected final String TEXT_13 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_14 = "_DELETE_NB_LINE\", delete_nb_line_";
  protected final String TEXT_15 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
	boolean useExistingConn = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
    IConnection inConn = null;
	IMetadataTable metadata = null;
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}
  	List< ? extends IConnection> conns = node.getIncomingConnections();
	for (IConnection conn : conns) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	      	if(metadata != null){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
				if(dieOnError) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
				}else {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
				}
				if(!useExistingConn){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
				}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
			}
		}
	}

    return stringBuffer.toString();
  }
}

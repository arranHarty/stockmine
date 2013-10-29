package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;

public class TAggregateSortedRowEndJava
{
  protected static String nl;
  public static synchronized TAggregateSortedRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateSortedRowEndJava result = new TAggregateSortedRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "globalMap.put(\"";
  protected final String TEXT_3 = "_NB_LINE\", nb_line_";
  protected final String TEXT_4 = ");" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_6 = " - Has finished.\");" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    List< ? extends IConnection> conns = node.getIncomingConnections();
    IMetadataTable inMetadata = null;
    if(conns != null){
    	for (IConnection conn : conns) { 
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
				inMetadata = conn.getMetadataTable();
    			break;
			}
		}
    	if (metadata != null && inMetadata != null) { 

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    }
    		}
	}
}

    return stringBuffer.toString();
  }
}

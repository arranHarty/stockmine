package org.talend.designer.codegen.translators.bigdata.couchbase;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TCouchbaseInEndJava
{
  protected static String nl;
  public static synchronized TCouchbaseInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchbaseInEndJava result = new TCouchbaseInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "}";
  protected final String TEXT_3 = NL + "    client_";
  protected final String TEXT_4 = ".shutdown();";
  protected final String TEXT_5 = NL + "    globalMap.put(\"";
  protected final String TEXT_6 = "_NB_LINE\",nb_line_";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null) && (metadatas.size() > 0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata != null) {
            List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
            if (conns != null){
                if (conns.size()>0){
                    IConnection conn =conns.get(0);
                    if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                        int nbColumns = metadata.getListColumns().size();
                        if(nbColumns>0){

    stringBuffer.append(TEXT_2);
    
                        }
                    }
                }
            }
        }
    }
if(!("true").equals(useExistingConn))
{
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
}
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
if(destination==null || ("").equals(destination.trim())){
    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.bigdata.hcatalog;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class THCatalogLoadMainJava
{
  protected static String nl;
  public static synchronized THCatalogLoadMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THCatalogLoadMainJava result = new THCatalogLoadMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\t\t\t";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = " =row_";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	if(node.isVirtualGenerateNode()){
		List<IMetadataTable> mestadataTableListOut = node.getMetadataList();
		if (mestadataTableListOut!=null && mestadataTableListOut.size()>0) {
		    IMetadataTable metadataTableOutput = mestadataTableListOut.get(0);
		    if (metadataTableOutput!=null) { 
				IConnection outputConn = null;
				List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
				if (outConns!=null) {
					if (outConns.size()>0) {
						IConnection conn = outConns.get(0);
						if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							outputConn = conn;
							String conn_name = outputConn.getName();
							List<IMetadataColumn> outputColumns = metadataTableOutput.getListColumns();
							String cid = ElementParameterParser.getValue(node, "__DESTINATION__");
							for(IMetadataColumn column :outputColumns){
								String columnName = column.getLabel();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_5);
    
							}
						}
					}
				}
		    }
		}
	}

    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}

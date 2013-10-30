package org.talend.designer.codegen.translators.bigdata.hcatalog;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class THCatalogLoadEndJava
{
  protected static String nl;
  public static synchronized THCatalogLoadEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THCatalogLoadEndJava result = new THCatalogLoadEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t}";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
if(node.isVirtualGenerateNode()){
	List<? extends IConnection> outConns = node.getOutgoingSortedConnections();
	if(outConns.size()>0){
		List<IMetadataTable> mestadataTableListOut = node.getMetadataList();
		if (mestadataTableListOut!=null && mestadataTableListOut.size()>0) {
		    IMetadataTable metadataTableOutput = mestadataTableListOut.get(0);
		    if (metadataTableOutput!=null) { 
				if (outConns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    
				}
			}
		}
	}
}

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.bigdata.hcatalog;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;

public class THCatalogInputEndJava
{
  protected static String nl;
  public static synchronized THCatalogInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THCatalogInputEndJava result = new THCatalogInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t} // while" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(fid_";
  protected final String TEXT_2 = "!=null ) {" + NL + "\t\t\t\t\tfid_";
  protected final String TEXT_3 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List<IMetadataColumn> listColumns = metadata.getListColumns();
			if(listColumns!=null && listColumns.size() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
			}
		}
	}

    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}

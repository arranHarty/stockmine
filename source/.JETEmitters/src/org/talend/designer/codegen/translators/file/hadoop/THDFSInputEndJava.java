package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class THDFSInputEndJava
{
  protected static String nl;
  public static synchronized THDFSInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSInputEndJava result = new THDFSInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t} // while";
  protected final String TEXT_2 = NL + "\t\t\t\treader_";
  protected final String TEXT_3 = ".close();";
  protected final String TEXT_4 = "\t\t\t\t" + NL + "\t\t\t\tif(fid_";
  protected final String TEXT_5 = " !=null ) {" + NL + "\t\t\t\t\tfid_";
  protected final String TEXT_6 = ".close();" + NL + "\t\t\t\t}";
  protected final String TEXT_7 = NL + "\t\t\t}// for";
  protected final String TEXT_8 = NL;

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
    
				String typeFile = ElementParameterParser.getValue(node,"__TYPEFILE__");
				if (typeFile.equals("SEQUENCE")) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
				} else {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
				}

    stringBuffer.append(TEXT_7);
    
			}
		}
	}

    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}

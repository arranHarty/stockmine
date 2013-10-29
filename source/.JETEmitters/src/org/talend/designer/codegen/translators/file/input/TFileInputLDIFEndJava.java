package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFileInputLDIFEndJava
{
  protected static String nl;
  public static synchronized TFileInputLDIFEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputLDIFEndJava result = new TFileInputLDIFEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " \t}" + NL + "   }finally{" + NL + "   \tif(dis_";
  protected final String TEXT_2 = "!=null){" + NL + "   \t\tdis_";
  protected final String TEXT_3 = ".close();" + NL + "   \t}" + NL + "   }" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE\", nb_line_";
  protected final String TEXT_5 = ");" + NL + "        ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        // component id
        String cid = node.getUniqueName();
 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
  }
}  
 
    return stringBuffer.toString();
  }
}

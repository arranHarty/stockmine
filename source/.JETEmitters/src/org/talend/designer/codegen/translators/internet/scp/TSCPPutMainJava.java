package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPPutMainJava
{
  protected static String nl;
  public static synchronized TSCPPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPPutMainJava result = new TSCPPutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\ttry{" + NL + "        if(sourceFileNames_";
  protected final String TEXT_3 = "!=null && sourceFileNames_";
  protected final String TEXT_4 = ".length!=0){" + NL + "            scp_";
  protected final String TEXT_5 = ".put(sourceFileNames_";
  protected final String TEXT_6 = " , ";
  protected final String TEXT_7 = ", \"0644\"); " + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_9 = " - Uploaded file '\" + sourceList_";
  protected final String TEXT_10 = ".toString() + \"' to remote directory '\" + ";
  protected final String TEXT_11 = "+ \"' successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "            nb_file_";
  protected final String TEXT_13 = " = sourceFileNames_";
  protected final String TEXT_14 = ".length;" + NL + "            globalMap.put(\"";
  protected final String TEXT_15 = "_STATUS\", \"File put OK.\");" + NL + "        }else{" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_16 = "_STATUS\", \"No file transfered.\");" + NL + "        }" + NL + "    }catch(java.lang.Exception e){" + NL + "    \t\te.printStackTrace();" + NL + "    \t\t";
  protected final String TEXT_17 = NL + "    \t\t\tlog.warn(\"";
  protected final String TEXT_18 = " - File uploading has failed.\");" + NL + "    \t\t";
  protected final String TEXT_19 = NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_20 = "_STATUS\", \"File put fail.\");" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
        CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
        INode node = (INode)codeGenArgument.getArgument();
        boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
        String cid = node.getUniqueName();      

        String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_7);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}

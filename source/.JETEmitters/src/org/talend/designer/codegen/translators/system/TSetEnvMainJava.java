package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.Map;
import java.util.List;

public class TSetEnvMainJava
{
  protected static String nl;
  public static synchronized TSetEnvMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSetEnvMainJava result = new TSetEnvMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work.\");" + NL + "\t\t        \tlog.info(\"";
  protected final String TEXT_4 = " - Setting environment variables.\");" + NL + "    \t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_5 = " = new StringBuffer();" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "                        if(System.getProperty(";
  protected final String TEXT_7 = ")!=null){" + NL + "                            System.setProperty(";
  protected final String TEXT_8 = ", System.getProperty(";
  protected final String TEXT_9 = ")+System.getProperty(\"path.separator\")+";
  protected final String TEXT_10 = ");" + NL + "                        }else{" + NL + "                           System.setProperty(";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = ");                         " + NL + "                        }";
  protected final String TEXT_13 = NL + "                        System.setProperty(";
  protected final String TEXT_14 = ",";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Set environment variable: Key='\" + ";
  protected final String TEXT_19 = " + \"',Value='\" + System.getProperty(";
  protected final String TEXT_20 = ") + \"'.\");" + NL + "\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_21 = ".delete(0,log4jSb_";
  protected final String TEXT_22 = ".length());" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Done.\");" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
            // component id
            String cid = node.getUniqueName();
            boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__")); 
            List<Map<String, String>> params = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__PARAMS__");
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    }
        	    for (int i = 0; i < params.size(); i++) {
    	            Map<String, String> line = params.get(i);
	                if(("true").equals(line.get("APPEND"))==true){

    stringBuffer.append(TEXT_6);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_12);
    
               		}else{
                        
 
    stringBuffer.append(TEXT_13);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_15);
    
                    }

    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(line.get("NAME"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    }
    
                }
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
        }
    }
   
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}

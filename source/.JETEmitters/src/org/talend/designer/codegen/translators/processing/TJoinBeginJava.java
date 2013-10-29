package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;
import org.talend.core.model.utils.NodeUtil;

public class TJoinBeginJava
{
  protected static String nl;
  public static synchronized TJoinBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJoinBeginJava result = new TJoinBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work.\");" + NL + "\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_3 = " = new StringBuffer();";
  protected final String TEXT_4 = NL + "    final java.util.Map<";
  protected final String TEXT_5 = "Struct, ";
  protected final String TEXT_6 = "Struct> tHash_";
  protected final String TEXT_7 = " = (java.util.Map<";
  protected final String TEXT_8 = "Struct, ";
  protected final String TEXT_9 = "Struct>) globalMap.get(\"tHash_";
  protected final String TEXT_10 = "\");" + NL + "    " + NL + "    class Util_";
  protected final String TEXT_11 = NL + "    {";
  protected final String TEXT_12 = NL + "        ";
  protected final String TEXT_13 = "Struct lookupValue = null;";
  protected final String TEXT_14 = NL + "        ";
  protected final String TEXT_15 = "Struct ";
  protected final String TEXT_16 = "HashKey = new ";
  protected final String TEXT_17 = "Struct(); " + NL + "        " + NL + "        public boolean isJoined(";
  protected final String TEXT_18 = "Struct mainRow) {            ";
  protected final String TEXT_19 = "            ";
  protected final String TEXT_20 = NL + "           ";
  protected final String TEXT_21 = "HashKey.";
  protected final String TEXT_22 = " = mainRow.";
  protected final String TEXT_23 = ";" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_25 = ".append(\" && \");" + NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t        \tlog4jSb_";
  protected final String TEXT_27 = ".append(\"";
  protected final String TEXT_28 = " = \" + mainRow.";
  protected final String TEXT_29 = ");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t";
  protected final String TEXT_31 = "HashKey.hashCodeDirty = true;";
  protected final String TEXT_32 = "\t\t\t             " + NL + "            lookupValue = tHash_";
  protected final String TEXT_33 = ".get(";
  protected final String TEXT_34 = "HashKey);            " + NL + "            if(lookupValue != null){" + NL + "\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_36 = " - The record with the key '\" + log4jSb_";
  protected final String TEXT_37 = " + \"' joined a lookup record.\");" + NL + "\t\t\t\t\tlog4jSb_";
  protected final String TEXT_38 = ".delete(0,log4jSb_";
  protected final String TEXT_39 = ".length());" + NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "            \treturn true;" + NL + "            }else{" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_42 = " - The record with the key '\" + log4jSb_";
  protected final String TEXT_43 = " + \"' didn't join a lookup record.\");" + NL + "\t\t\t\t\tlog4jSb_";
  protected final String TEXT_44 = ".delete(0,log4jSb_";
  protected final String TEXT_45 = ".length());" + NL + "\t\t\t\t";
  protected final String TEXT_46 = NL + "            }  " + NL + "            return false;" + NL + "        }" + NL + "    }" + NL + "        " + NL + "\tUtil_";
  protected final String TEXT_47 = " util_";
  protected final String TEXT_48 = " = new Util_";
  protected final String TEXT_49 = "();" + NL + "        " + NL + "    int nb_line_";
  protected final String TEXT_50 = " = 0; ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    String lookupConName = "";
    if (metadata!=null) {//2
    
        String cid = node.getUniqueName();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
        String hashName = "";

        //get the input Main and Lookup connection
        IConnection inMainCon = null;
        IConnection inRefCon = null;   
        List< ? extends IConnection> connsIn = node.getIncomingConnections();     
        for (IConnection conn : connsIn) {//3
        	if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN)) {
        		inMainCon = NodeUtil.getRealConnectionTypeBased(conn);
        	}
        	else if(conn.getLineStyle().equals(EConnectionType.FLOW_REF))
        	{
        		inRefCon = conn;
        		lookupConName = inRefCon.getName();
        		hashName = lookupConName;
        		if (conn.getSource().getComponent().isHashComponent()) {
        			hashName = ElementParameterParser.getValue(conn.getSource(), "__LIST__");
        			lookupConName = "row2";
        		}
        	}
        }//3 
        
        if(inMainCon == null || inRefCon == null){
        	return "";
        }
        
        String incomingName = inMainCon.getName();
        
        List<Map<String, String>> joinKeys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");
		if(isLog4jEnabled){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(hashName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_18);
                
		boolean hasHashableKey = false;
		int curCount = 0;
		for(Map<String, String> joinKeyLine : joinKeys){
			String inputKey = joinKeyLine.get("INPUT_COLUMN");
			String lookupKey = joinKeyLine.get("LOOKUP_COLUMN");
			hasHashableKey = true;            

    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(lookupKey );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inputKey );
    stringBuffer.append(TEXT_23);
    if(isLog4jEnabled){
				if(curCount!=0){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(inputKey );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inputKey );
    stringBuffer.append(TEXT_29);
    }
    
           curCount ++ ;
		}
		
		if(hasHashableKey) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_31);
    
		}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(lookupConName );
    stringBuffer.append(TEXT_34);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_50);
    
    }//2
}//1

    return stringBuffer.toString();
  }
}

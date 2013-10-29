package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TJoinMainJava
{
  protected static String nl;
  public static synchronized TJoinMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJoinMainJava result = new TJoinMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t";
  protected final String TEXT_3 = " = null;\t";
  protected final String TEXT_4 = NL + "\t\t\tStringBuffer log4jSbMain_";
  protected final String TEXT_5 = " = new StringBuffer();" + NL + "\t\t\tStringBuffer log4jSbReject_";
  protected final String TEXT_6 = " = new StringBuffer();" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_8 = " = new ";
  protected final String TEXT_9 = "Struct();\t";
  protected final String TEXT_10 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\tlog4jSbMain_";
  protected final String TEXT_16 = ".append(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ");" + NL + "\t\t\t\t\t\t\tlog4jSbReject_";
  protected final String TEXT_19 = ".append(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t\t\tlog4jSbMain_";
  protected final String TEXT_23 = ".append(\"|\");" + NL + "\t\t\t\t\t\t\t\tlog4jSbReject_";
  protected final String TEXT_24 = ".append(\"|\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_25 = NL + NL + "\t\t\tif(util_";
  protected final String TEXT_26 = ".isJoined(";
  protected final String TEXT_27 = ")){ ";
  protected final String TEXT_28 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " = util_";
  protected final String TEXT_31 = ".lookupValue.";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t\t\t\tlog4jSbMain_";
  protected final String TEXT_34 = ".append(\"|\" + ";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_38 = " - Output record :\" + log4jSbMain_";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t\tlog4jSbMain_";
  protected final String TEXT_40 = ".delete(0,log4jSbMain_";
  protected final String TEXT_41 = ".length());" + NL + "\t\t\t\t";
  protected final String TEXT_42 = " " + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = " = null; ";
  protected final String TEXT_44 = NL + "\t\t\t} " + NL + "\t";
  protected final String TEXT_45 = "\t" + NL + "\t\t\t\telse{";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_47 = " - Rejected record :\" + log4jSbReject_";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t\t\t\tlog4jSbReject_";
  protected final String TEXT_49 = ".delete(0,log4jSbReject_";
  protected final String TEXT_50 = ".length());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_51 = " " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_52 = " = null; ";
  protected final String TEXT_53 = NL + "\t\t\t\t}";
  protected final String TEXT_54 = " " + NL + "\t\t\t\t\t";
  protected final String TEXT_55 = " = null;";
  protected final String TEXT_56 = NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_57 = " = new ";
  protected final String TEXT_58 = "Struct();\t";
  protected final String TEXT_59 = "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ";\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\tlog4jSb2_";
  protected final String TEXT_65 = ".append(";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\tlog4jSb2_";
  protected final String TEXT_69 = ".append(\"|\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_71 = " - Output records :\" + log4jSb2_";
  protected final String TEXT_72 = ");" + NL + "\t\t\t\t\tlog4jSb2_";
  protected final String TEXT_73 = ".delete(0,log4jSb_";
  protected final String TEXT_74 = ".length());" + NL + "\t\t\t\t";
  protected final String TEXT_75 = "\t\t" + NL + "///////////////////////    \t\t\t";
  protected final String TEXT_76 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//11
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//22

    stringBuffer.append(TEXT_1);
        
        String cid = node.getUniqueName();
        boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
            	
    	//get the input Main and Lookup connection
    	IConnection inMainCon = null;
    	IConnection inRefCon = null;   
    	List< ? extends IConnection> connsIn = node.getIncomingConnections();     
    	for (IConnection conn : connsIn) {//3
    		if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN)) {
    			inMainCon = conn;
    		}
    		else if(conn.getLineStyle().equals(EConnectionType.FLOW_REF))
    		{
    			inRefCon = conn;
    		}
        }//3
        
        if(inMainCon == null){
        	return "";
        }
        
        IMetadataTable preMetadata = inMainCon.getMetadataTable();
        String incomingName = inMainCon.getName();
        
    	List<IMetadataColumn> columns = metadata.getListColumns();
    	int columnSize = columns.size();
    	List<IMetadataColumn> preColumns = preMetadata.getListColumns();
    	int preColumnSize = preColumns.size();
    	int minSize = Math.min(columnSize, preColumnSize);
        
        List<Map<String, String>> lookupCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOKUP_COLS__");
        boolean useLookup = ("true").equals(ElementParameterParser.getValue(node, "__USE_LOOKUP_COLS__"));
        boolean useReject = ("true").equals(ElementParameterParser.getValue(node, "__USE_INNER_JOIN__"));
        
    	List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
		List<? extends IConnection> connsFilter = node.getOutgoingConnections("FLOW");
		List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");
    	
    	for (IConnection conn : outConns) {
    		if(!conn.isActivate()) continue;
    		if(!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) continue;
    		String outputConnName = conn.getName();    		

    stringBuffer.append(TEXT_2);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_3);
    		
		}
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    }
		if(inRefCon != null){//exist lookup	
			int firstConn = 0;
			for (IConnection conn : outConns) {
				if(!conn.isActivate()) continue;
				if(!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) continue;
				String outputConnName = conn.getName();

    stringBuffer.append(TEXT_7);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_9);
    
				//first, iterate with minSize
				for (int i = 0; i < minSize; i++) {//4
					IMetadataColumn column = columns.get(i);
					IMetadataColumn preColumn = preColumns.get(i);
					boolean isLookup = false;

					if(useLookup) {
						//find the lookup column
						for (int j = 0; j < lookupCols.size(); j++) {
							Map<String, String> lineValue = lookupCols.get(j);
							if (column.getLabel().equals(lineValue.get("OUTPUT_COLUMN"))) {
								isLookup = true;
								break;
							}
						}
					}
            
					if(!isLookup) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preColumn.getLabel() );
    stringBuffer.append(TEXT_14);
    
						if(isLog4jEnabled && firstConn==0){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_21);
    if(i < minSize-1){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
						}
					}
				} //4
				firstConn++;
			}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_27);
    
				if(useLookup) {
					for (IConnection conn : connsFilter) {
						if(!conn.isActivate()) continue;
						String outputConnName = conn.getName();
						//second, iterate with columnSize
						for (int i = 0; i < columnSize; i++) {//4
							IMetadataColumn column = columns.get(i);
							
							//find the lookup column
							boolean isLookup = false;			
							String lookupName = null;
							for (int j = 0; j < lookupCols.size(); j++) {
								 Map<String, String> lineValue = lookupCols.get(j);
								 if (column.getLabel().equals(lineValue.get("OUTPUT_COLUMN"))) {
									isLookup = true;
									lookupName = lineValue.get("LOOKUP_COLUMN");
									break;
								 }
							}
				
							if(isLookup) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(lookupName );
    stringBuffer.append(TEXT_32);
    
								if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_36);
    }
							}
						} //4
					}
				}
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }				

				for (IConnection conn : connsReject) { 
					if(!conn.isActivate()) continue;

    stringBuffer.append(TEXT_42);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_43);
    
				}

    stringBuffer.append(TEXT_44);
    
			if(useReject){

    stringBuffer.append(TEXT_45);
    
					for (IConnection conn : connsFilter) { 
						if(!conn.isActivate()) continue;
						if(isLog4jEnabled){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    }

    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_52);
    
					}

    stringBuffer.append(TEXT_53);
    
			}else{
				for (IConnection conn : connsReject) { 
					if(!conn.isActivate()) continue;

    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_55);
    
				}
			}
		} else {//exist lookup    	

			for (IConnection conn : connsFilter) {
				if(!conn.isActivate()) continue;
				String outputConnName = conn.getName();

    stringBuffer.append(TEXT_56);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_58);
    
				//first, iterate with minSize
				for (int i = 0; i < minSize; i++) {//4
					IMetadataColumn column = columns.get(i);
					IMetadataColumn preColumn = preColumns.get(i);

    stringBuffer.append(TEXT_59);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(preColumn.getLabel() );
    stringBuffer.append(TEXT_63);
    
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_67);
    if(i < minSize-1){
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    }
					}
				} //4
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
			}
		}

    stringBuffer.append(TEXT_75);
    
    }//22
}//11

    stringBuffer.append(TEXT_76);
    return stringBuffer.toString();
  }
}

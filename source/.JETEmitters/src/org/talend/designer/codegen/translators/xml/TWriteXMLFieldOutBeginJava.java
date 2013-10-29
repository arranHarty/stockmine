package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TWriteXMLFieldOutBeginJava
{
  protected static String nl;
  public static synchronized TWriteXMLFieldOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldOutBeginJava result = new TWriteXMLFieldOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//tWriteXMLFieldOut_begin";
  protected final String TEXT_2 = NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t\t\t\tboolean needRoot_";
  protected final String TEXT_4 = "  = true;" + NL + "\t\t\t\t" + NL + "\t\t\t\tString  strCompCache_";
  protected final String TEXT_5 = "= null;\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t            java.util.Map map_";
  protected final String TEXT_7 = " = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t        java.util.Queue<java.util.Map> listGroupby_";
  protected final String TEXT_9 = " = new java.util.concurrent.ConcurrentLinkedQueue<java.util.Map>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t        java.util.Queue<String> listGroupby_";
  protected final String TEXT_11 = " = new java.util.concurrent.ConcurrentLinkedQueue<String>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\tjava.util.List<java.util.Map<String,String>> flows_";
  protected final String TEXT_13 = " = java.util.Collections.synchronizedList(new java.util.ArrayList<java.util.Map<String,String>>());" + NL + "\t\t\t\t\t\tjava.util.Map<String,String> flowValues_";
  protected final String TEXT_14 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t" + NL + "\t\t\t\t\tclass ThreadXMLField_";
  protected final String TEXT_16 = " extends Thread {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\tjava.util.Queue<java.util.Map> queue;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t    java.util.Queue<String> queue;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\tjava.util.List<java.util.Map<String,String>> flows;" + NL + "\t\t\t\t\t\tjava.lang.Exception lastException;" + NL + "\t\t\t\t\t\tString currentComponent;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_20 = "(java.util.Queue q) {" + NL + "\t\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_21 = "\", queue);" + NL + "\t\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_22 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "\t\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\t\tthis.flows = l;" + NL + "\t\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_23 = "\", queue);" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"flows_";
  protected final String TEXT_24 = "\", flows);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tpublic java.lang.Exception getLastException() {" + NL + "\t\t\t\t\t\t\treturn this.lastException;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tpublic String getCurrentComponent() {" + NL + "\t\t\t\t\t\t\treturn this.currentComponent;" + NL + "\t\t\t\t\t\t}" + NL + "\t" + NL + "\t\t\t\t\t\t@Override" + NL + "\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_25 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t} catch (TalendException te) {" + NL + "\t\t\t\t\t\t\t\tthis.lastException = te.getException();" + NL + "\t\t\t\t\t\t\t\tthis.currentComponent = te.getCurrentComponent();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_27 = " txf_";
  protected final String TEXT_28 = " = new ThreadXMLField_";
  protected final String TEXT_29 = "(listGroupby_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_32 = " txf_";
  protected final String TEXT_33 = " = new ThreadXMLField_";
  protected final String TEXT_34 = "(listGroupby_";
  protected final String TEXT_35 = ", flows_";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\ttxf_";
  protected final String TEXT_38 = ".start();" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t        java.util.Queue<java.util.Map> listGroupby_";
  protected final String TEXT_40 = " = (java.util.Queue<java.util.Map>) globalMap.get(\"queue_";
  protected final String TEXT_41 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\tjava.util.Queue<String> listGroupby_";
  protected final String TEXT_43 = " = (java.util.Queue<String>) globalMap.get(\"queue_";
  protected final String TEXT_44 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\tjava.util.List<java.util.Map<String,String>> flows_";
  protected final String TEXT_46 = " = (java.util.List<java.util.Map<String,String>>)globalMap.get(\"flows_";
  protected final String TEXT_47 = "\");" + NL + "\t\t\t\t\t\tjava.util.Map<String,String> flowValues_";
  protected final String TEXT_48 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + NL + "java.util.List<java.util.List<String>> groupbyList_";
  protected final String TEXT_51 = " = new java.util.ArrayList<java.util.List<String>>();" + NL + "java.util.Map<String,String> valueMap_";
  protected final String TEXT_52 = " = new java.util.HashMap<String,String>();" + NL;
  protected final String TEXT_53 = NL + NL + "class NestXMLTool_";
  protected final String TEXT_54 = "{" + NL + "\tpublic void parseAndAdd(org.dom4j.Element nestRoot, String value){" + NL + "\t\ttry {" + NL + "            org.dom4j.Document doc4Str = org.dom4j.DocumentHelper.parseText(\"<root>\"+ value + \"</root>\");" + NL + "    \t\tnestRoot.setContent(doc4Str.getRootElement().content());" + NL + "    \t} catch (java.lang.Exception e) {" + NL + "    \t\te.printStackTrace();" + NL + "    \t\tnestRoot.setText(value);" + NL + "        }" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setText(org.dom4j.Element element, String value){" + NL + "\t\tif (value.startsWith(\"<![CDATA[\") && value.endsWith(\"]]>\")) {" + NL + "\t\t\tString text = value.substring(9, value.length()-3);" + NL + "\t\t\telement.addCDATA(text);" + NL + "\t\t}else{" + NL + "\t\t\telement.setText(value);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void replaceDefaultNameSpace(org.dom4j.Element nestRoot){" + NL + "\t\tif (nestRoot!=null) {" + NL + "\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) nestRoot.elements()) {" + NL + "        \t\tif ((\"\").equals(tmp.getQName().getNamespace().getURI()) && (\"\").equals(tmp.getQName().getNamespace().getPrefix())){" + NL + "        \t\t\ttmp.setQName(org.dom4j.DocumentHelper.createQName(tmp.getName(), nestRoot.getQName().getNamespace()));" + NL + "\t        \t}" + NL + "    \t    \treplaceDefaultNameSpace(tmp);" + NL + "       \t\t}" + NL + "       \t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void removeEmptyElement(org.dom4j.Element root){" + NL + "\t\tif (root!=null) {" + NL + "\t\t\tfor (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) root.elements()) {" + NL + "\t\t\t\tremoveEmptyElement(tmp);" + NL + "\t\t\t}" + NL + "\t\t\tif (root.content().size() == 0 " + NL + "    \t\t\t&& root.attributes().size() == 0 " + NL + "    \t\t\t&& root.declaredNamespaces().size() == 0) {" + NL + "    \t\t\tif(root.getParent()!=null){" + NL + "                \troot.getParent().remove(root);" + NL + "                }" + NL + "            }" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "NestXMLTool_";
  protected final String TEXT_55 = " nestXMLTool_";
  protected final String TEXT_56 = " = new NestXMLTool_";
  protected final String TEXT_57 = "();" + NL + "" + NL + "// sort group root element for judgement of group" + NL + "java.util.List<org.dom4j.Element> groupElementList_";
  protected final String TEXT_58 = " = new java.util.ArrayList<org.dom4j.Element>();" + NL + "org.dom4j.Element root4Group_";
  protected final String TEXT_59 = " = null;" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_60 = "  = org.dom4j.DocumentHelper.createDocument();";
  protected final String TEXT_61 = NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_62 = " = org.dom4j.io.OutputFormat.createCompactFormat();" + NL + "format_";
  protected final String TEXT_63 = ".setNewLineAfterDeclaration(false);";
  protected final String TEXT_64 = NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_65 = " = org.dom4j.io.OutputFormat.createPrettyPrint();";
  protected final String TEXT_66 = NL + "format_";
  protected final String TEXT_67 = ".setTrimText(false);" + NL + "format_";
  protected final String TEXT_68 = ".setEncoding(";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = "format_";
  protected final String TEXT_71 = ".setExpandEmptyElements(true);";
  protected final String TEXT_72 = NL + "int[] orders_";
  protected final String TEXT_73 = " = new int[";
  protected final String TEXT_74 = "];";
  protected final String TEXT_75 = NL + "java.util.List<String> endTabStrs_";
  protected final String TEXT_76 = " = new java.util.ArrayList<String>();" + NL + "java.util.List<String> startTabStrs_";
  protected final String TEXT_77 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_78 = NL + "endTabStrs_";
  protected final String TEXT_79 = ".add(\"";
  protected final String TEXT_80 = "</";
  protected final String TEXT_81 = ">\");" + NL + "startTabStrs_";
  protected final String TEXT_82 = ".add(\"";
  protected final String TEXT_83 = "<";
  protected final String TEXT_84 = ">\");";
  protected final String TEXT_85 = NL + "int preUnNullMaxIndex_";
  protected final String TEXT_86 = " = -1;" + NL + "int preNewTabIndex_";
  protected final String TEXT_87 = " = -1;" + NL + "String[] startTabs_";
  protected final String TEXT_88 = " = new String[endTabStrs_";
  protected final String TEXT_89 = ".size()];" + NL + "String[] endTabs_";
  protected final String TEXT_90 = " = new String[endTabStrs_";
  protected final String TEXT_91 = ".size()];" + NL + "java.io.StringWriter strWriter_";
  protected final String TEXT_92 = " = new java.io.StringWriter();" + NL + "java.io.BufferedWriter out_";
  protected final String TEXT_93 = " = new java.io.BufferedWriter(strWriter_";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "out_";
  protected final String TEXT_96 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_97 = "+\"\\\"?>\");" + NL + "out_";
  protected final String TEXT_98 = ".write(\"";
  protected final String TEXT_99 = "\");";
  protected final String TEXT_100 = NL;
  protected final String TEXT_101 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();


String virtualTargetCid = node.getOutgoingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getTarget().getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
		if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
    			String removeHeader = ElementParameterParser.getValue(node, "__REMOVE_HEADER__"); // add for feature7788
        		String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
				boolean isAllowEmpty = ("true").equals(ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__"));
                boolean expandEmptyElm = ("true").equals(ElementParameterParser.getValue(node, "__EXPAND_EMPTY_ELM__"));
        		String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
        		List<Map<String, String>> rootTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
                List<Map<String, String>> groupTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
                List<Map<String, String>> loopTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
                boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));
                boolean isCompactFormat = ("true").equals(ElementParameterParser.getValue(node, "__COMPACT_FORMAT__"));
				
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
				String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
				if(destination.indexOf("tCouchbaseOutput_")==0 || destination.indexOf("tCouchDBOutput_")==0){
				    INode previousNode = conn.getSource();
				    List<IMetadataTable> previous_metadatas = previousNode.getMetadataList();
				    if ((previous_metadatas!=null)&&(previous_metadatas.size()>0)) {
				        IMetadataTable previous_metadata = previous_metadatas.get(0);
				        if (previous_metadata!=null) {
						
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
				        }
				    }
				}
				IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
				if(nextMergeConn == null || nextMergeConn.getInputId()==1){
				    if(destination.indexOf("tCouchbaseOutput_")==0 || destination.indexOf("tCouchDBOutput_")==0){
					
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
				    }else{
					
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
				    }
					if(storeFlow){
					
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
					}
					
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
						if(destination.indexOf("tCouchbaseOutput_")==0 || destination.indexOf("tCouchDBOutput_")==0){
						
    stringBuffer.append(TEXT_17);
    
						}else{
						
    stringBuffer.append(TEXT_18);
    
						}
						
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_25);
    if(!storeFlow){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    } else {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
				}else{
					if(destination.indexOf("tCouchbaseOutput_")==0 || destination.indexOf("tCouchDBOutput_")==0){
					
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
				    }else{
					
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
				    }
					if(storeFlow){
					
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
					}
					
    stringBuffer.append(TEXT_49);
    
				}
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
				// *** generation mode init ***
				if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    if(isCompactFormat) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_69);
    if(isAllowEmpty && expandEmptyElm){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    }
    
					int groupSize = 0;
					if(groupTable!=null && groupTable.size()>0){
						for(java.util.Map<String, String> tmpMap : groupTable){
							if(tmpMap.get("ATTRIBUTE").equals("main")){
								groupSize++;
							}
						}
					}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(groupSize + 1);
    stringBuffer.append(TEXT_74);
    
				}else if(("Null").equals(mode)){
				    String whiteSpace = "";
        			String rowSeparator = "";
        			if(!isCompactFormat) { // pretty format
        				whiteSpace = "  ";
        				rowSeparator = "\\n";
        			}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
            		if(loopTable.size()>0){
            			String emptyspace = "";
        				String endPath = loopTable.get(0).get("PATH");
        				String[] endTabs = endPath.split("/");
        				for(int len = 1; len<endTabs.length-1;len++){

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(endTabs[len]);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(endTabs[len]);
    stringBuffer.append(TEXT_84);
    
	         				emptyspace += whiteSpace;
            			}
        			}

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
					if(!("true").equals(removeHeader)){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_99);
    
					}

    stringBuffer.append(TEXT_100);
    
				}
			}
		}
	}
}

    stringBuffer.append(TEXT_101);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.utils.TalendQuoteUtils;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.metadata.IMetadataTable;

public class TFileOutputXMLEndJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLEndJava result = new TFileOutputXMLEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");" + NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_3 = " = new StringBuffer();";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Has finished.\");";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieving records from the datasource.\");";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_10 = " + \" .\");";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_12 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_13 = " + \" \" + log4jSb_";
  protected final String TEXT_14 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_15 = ".delete(0,log4jSb_";
  protected final String TEXT_16 = ".length());";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Writing the record \" + nb_line_";
  protected final String TEXT_19 = " + \" \" + log4jSb_";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_21 = ".delete(0,log4jSb_";
  protected final String TEXT_22 = ".length());";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Written records count: \" + nb_line_";
  protected final String TEXT_25 = " + \" .\");";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = "out_";
  protected final String TEXT_28 = ".write(\"</\"+";
  protected final String TEXT_29 = "+\">\");" + NL + "" + NL + "out_";
  protected final String TEXT_30 = ".newLine();" + NL;
  protected final String TEXT_31 = "\tout_";
  protected final String TEXT_32 = ".write(footers_";
  protected final String TEXT_33 = "[";
  protected final String TEXT_34 = "]);" + NL + "" + NL + "\tout_";
  protected final String TEXT_35 = ".newLine();" + NL + "\t";
  protected final String TEXT_36 = "out_";
  protected final String TEXT_37 = ".close();" + NL;
  protected final String TEXT_38 = NL + "\tif(currentRowCount_";
  protected final String TEXT_39 = " == 0){\t\t" + NL + "\t\tfile_";
  protected final String TEXT_40 = ".delete();" + NL + "\t}";
  protected final String TEXT_41 = "globalMap.put(\"";
  protected final String TEXT_42 = "_NB_LINE\",nb_line_";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\twriter_";
  protected final String TEXT_45 = ".close();";
  protected final String TEXT_46 = NL + "\t";
  protected final String TEXT_47 = NL + "\tif(nb_line_";
  protected final String TEXT_48 = " == 0){" + NL + "\t\tfile_";
  protected final String TEXT_49 = ".delete();" + NL + "\t}\t\t";
  protected final String TEXT_50 = "\t";
  protected final String TEXT_51 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void componentStartInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void componentFinishInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}

		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//for all tFileinput* components		
		public void debugRetriveData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    		
			}
		}
		
		//for all tFileinput* components		
		public void debugWriteData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    		
			}
		}
		
		//for all tFileoutput* components
		public void writeDataFinishInfo(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    		
			}
		}
	}
	
	DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil();

    stringBuffer.append(TEXT_26);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String filename = ElementParameterParser.getValue(node, "__FILENAME__");		
boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));		

boolean inputIsDocument = "true".equals(ElementParameterParser.getValue(node, "__INPUT_IS_DOCUMENT__"));

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(!inputIsDocument) {
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
String split = ElementParameterParser.getValue(node, "__SPLIT__");
String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
List rootTags = (List)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
if (rootTags.size()==0) {
    Map<String, String> defaultRootNode = new HashMap<String, String>();
    defaultRootNode.put("TAG","\"root\"");
    rootTags.add(defaultRootNode);
}
    int footers = rootTags.size();
String useDynamicGrouping = ElementParameterParser.getValue(
            node,
            "__USE_DYNAMIC_GROUPING__"
        );
List<Map<String, String>> columnMapping = 
    		(List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__MAPPING__"
            );
List<Map<String, String>> groupBys =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__GROUP_BY__"
            );
if (("false").equals(useDynamicGrouping)) {
    groupBys.clear();
}


String groupby[][] = new String[groupBys.size()][3];
for(int i = 0; i < groupBys.size(); i++){
    groupby[i][0] = groupBys.get(i).get("COLUMN");
    groupby[i][1] = groupBys.get(i).get("LABEL");
}
for(int i = 0; i < groupby.length; i++){
	for(int j = 0; j < columnMapping.size(); j++){
		Map<String, String> map = columnMapping.get(j);
		String col = metadata.getListColumns().get(j).getLabel();
		if(groupby[i][0].equals(col)){
			if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    			groupby[i][2] = col;
    			groupby[i][2] = TalendQuoteUtils.addQuotes(groupby[i][2]);
    		}else{
    			groupby[i][2] = map.get("LABEL");
    		}
    		break;
		}
	}
}

    
for(int i = groupby.length -1; i >= 0; i--){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(groupby[i][2] );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
}
	for(int i = footers - 1; i >= 0;i--){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
if(("true").equals(split)){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
}
log4jFileUtil.writeDataFinishInfo(node);

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
	}
}
} else {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
}
	
    stringBuffer.append(TEXT_46);
    if(isDeleteEmptyFile){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    log4jFileUtil.componentFinishInfo(node);
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}

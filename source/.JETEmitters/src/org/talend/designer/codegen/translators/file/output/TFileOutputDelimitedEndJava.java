package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.process.IProcess;

public class TFileOutputDelimitedEndJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedEndJava result = new TFileOutputDelimitedEndJava();
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
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + "} finally {";
  protected final String TEXT_29 = NL + "   \tsynchronized (multiThreadLockWrite) {";
  protected final String TEXT_30 = NL + "\tsynchronized (lockWrite) {";
  protected final String TEXT_31 = NL + "\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\tsynchronized (pLockWrite) {";
  protected final String TEXT_32 = NL + "if(out";
  protected final String TEXT_33 = "!=null) {" + NL + "\tout";
  protected final String TEXT_34 = ".flush();" + NL + "\tout";
  protected final String TEXT_35 = ".close();" + NL + "}";
  protected final String TEXT_36 = NL + "if(out";
  protected final String TEXT_37 = "!=null) {" + NL + "\tout";
  protected final String TEXT_38 = ".flush();" + NL + "\twriter_";
  protected final String TEXT_39 = ".flush();" + NL + "\tout";
  protected final String TEXT_40 = " = null;" + NL + "}";
  protected final String TEXT_41 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_42 = "_NB_LINE\",nb_line_";
  protected final String TEXT_43 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_44 = "_FILE_NAME\",fileName_";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = NL + "\tif(CsvWriter";
  protected final String TEXT_48 = "!=null) {" + NL + "    \tCsvWriter";
  protected final String TEXT_49 = ".close();" + NL + "    }";
  protected final String TEXT_50 = NL + "if(out";
  protected final String TEXT_51 = "!=null) {" + NL + "\tout";
  protected final String TEXT_52 = ".flush();" + NL + "\tout";
  protected final String TEXT_53 = ".close();" + NL + "}";
  protected final String TEXT_54 = NL + "\tif(CsvWriter";
  protected final String TEXT_55 = "!=null) {" + NL + "\t\tCsvWriter";
  protected final String TEXT_56 = ".close();" + NL + "\t}" + NL + "\tif(out";
  protected final String TEXT_57 = "!=null) {" + NL + "\t\tout";
  protected final String TEXT_58 = ".flush();" + NL + "\t}" + NL + "\tif(outWriter_";
  protected final String TEXT_59 = "!=null) {" + NL + "\t\toutWriter_";
  protected final String TEXT_60 = ".flush();" + NL + "\t}";
  protected final String TEXT_61 = NL + "\tif(CsvWriter";
  protected final String TEXT_62 = "!=null) {" + NL + "\t\tCsvWriter";
  protected final String TEXT_63 = ".flush();" + NL + "\t}" + NL + "\tif(bufferWriter_";
  protected final String TEXT_64 = "!=null) {" + NL + "\t\tbufferWriter_";
  protected final String TEXT_65 = ".flush();" + NL + "\t}" + NL + "\tif(outWriter_";
  protected final String TEXT_66 = "!=null) {" + NL + "\t\toutWriter_";
  protected final String TEXT_67 = ".flush();" + NL + "\t}" + NL + "\tCsvWriter";
  protected final String TEXT_68 = " = null;";
  protected final String TEXT_69 = NL + "    globalMap.put(\"";
  protected final String TEXT_70 = "_NB_LINE\",nb_line_";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "}";
  protected final String TEXT_73 = NL + "}";
  protected final String TEXT_74 = NL + "}";
  protected final String TEXT_75 = NL + "\tif(isFileGenerated_";
  protected final String TEXT_76 = " && nb_line_";
  protected final String TEXT_77 = " == 0){" + NL + "\t";
  protected final String TEXT_78 = NL + "\t\tfile_";
  protected final String TEXT_79 = ".delete();" + NL + "\t";
  protected final String TEXT_80 = NL + "\t\tfile";
  protected final String TEXT_81 = ".delete();" + NL + "\t";
  protected final String TEXT_82 = NL + "\t}\t\t";
  protected final String TEXT_83 = NL + "} // finally";
  protected final String TEXT_84 = NL;

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
    boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
    boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    
    String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__")); 
	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
	
	boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
	
	String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
	boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
	
	boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
	IProcess process = node.getProcess();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_27);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {

    stringBuffer.append(TEXT_28);
     
    if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_29);
    
	}
	if (codeGenArgument.subTreeContainsParallelIterate()) {

    stringBuffer.append(TEXT_30);
     
	}
	
	if (isParallelize) {

    stringBuffer.append(TEXT_31);
     
	}

    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(!useStream){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
			}else{

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
			}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}else{//the following is the tFileOutputCSV component
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_46);
    
			if(!useStream){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
				if(isInRowMode){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
				}
			}else{
				if(isInRowMode){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
				}else{

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
				}
			}

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
		}

     
	if (isParallelize) {

    stringBuffer.append(TEXT_72);
    
	}
	if (codeGenArgument.subTreeContainsParallelIterate()) {

    stringBuffer.append(TEXT_73);
     
	}
	if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_74);
    
	}

    if(!useStream && isDeleteEmptyFile){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    if(compress && !isAppend && !split){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    }else{
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    
	}
}

    
log4jFileUtil.writeDataFinishInfo(node);
log4jFileUtil.componentFinishInfo(node);

    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}

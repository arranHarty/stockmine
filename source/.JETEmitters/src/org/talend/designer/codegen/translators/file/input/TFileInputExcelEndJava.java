package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileInputExcelEndJava
{
  protected static String nl;
  public static synchronized TFileInputExcelEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelEndJava result = new TFileInputExcelEndJava();
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
  protected final String TEXT_26 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_27 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\ttry {" + NL + "\t\t\t\tif(excelReader_";
  protected final String TEXT_30 = "!=null) {" + NL + "\t\t\t\t\texcelReader_";
  protected final String TEXT_31 = ".handleException();" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch(java.lang.Exception e_";
  protected final String TEXT_32 = ") {" + NL + "\t\t\t\tif(!(e_";
  protected final String TEXT_33 = ".getCause() instanceof com.talend.excel.xssf.event.EnoughDataException))" + NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_36 = " - \" + e_";
  protected final String TEXT_37 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\tthrow(e_";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_42 = " - \" + e_";
  protected final String TEXT_43 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_45 = ".getMessage());\t" + NL + "\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_49 = "_NB_LINE\",nb_line_";
  protected final String TEXT_50 = ");" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t} finally { " + NL + "\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\tif(!(source_";
  protected final String TEXT_54 = " instanceof java.io.InputStream)){" + NL + "\t\t\t\t\t\tworkbook_";
  protected final String TEXT_55 = ".close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "  \t\t\t\tif(!(source_";
  protected final String TEXT_57 = " instanceof java.io.InputStream)){" + NL + "  \t\t\t\t\tworkbook_";
  protected final String TEXT_58 = ".getPackage().revert();" + NL + "  \t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t}\t" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t";

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

    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
	boolean eventMode = "EVENT_MODE".equals(mode);
	
	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    log4jFileUtil.debugRetriveData(node);
    stringBuffer.append(TEXT_28);
    if(version07 && eventMode) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
     if(dieOnError) { 
    stringBuffer.append(TEXT_34);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
     } else { 
    stringBuffer.append(TEXT_40);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
     } 
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    log4jFileUtil.retrievedDataNumberInfo();
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    if((version07 && !eventMode) || !version07) {
    stringBuffer.append(TEXT_51);
    }//Bug TDI-25655
    stringBuffer.append(TEXT_52);
    if(!version07){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    }else if(!eventMode){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    } else {//TODO event mode
				
				}
    stringBuffer.append(TEXT_59);
    log4jFileUtil.componentFinishInfo(node);
    stringBuffer.append(TEXT_60);
    return stringBuffer.toString();
  }
}

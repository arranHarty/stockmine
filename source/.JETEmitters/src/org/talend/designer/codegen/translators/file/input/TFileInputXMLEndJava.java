package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileInputXMLEndJava
{
  protected static String nl;
  public static synchronized TFileInputXMLEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputXMLEndJava result = new TFileInputXMLEndJava();
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
  protected final String TEXT_27 = NL + "}";
  protected final String TEXT_28 = NL + "\t}";
  protected final String TEXT_29 = NL + "\ttry {" + NL + "\t\tlooper_";
  protected final String TEXT_30 = ".handleTaskResponse();" + NL + "\t} catch(java.lang.Exception e) {" + NL + "\t\tif(!(e.getCause() instanceof org.talend.xml.sax.exception.EnoughDataException))" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_33 = " - \" +  e.getMessage());" + NL + "\t\t";
  protected final String TEXT_34 = NL + "\t\tthrow(e);" + NL + "\t";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_37 = " - \" +  e.getMessage());" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\tSystem.err.println(e.getMessage());\t" + NL + "\t";
  protected final String TEXT_39 = NL + "\t}";
  protected final String TEXT_40 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_41 = "_NB_LINE\",nb_line_";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + NL + "\t";

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

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
log4jFileUtil.debugRetriveData(node);
if(("Xerces").equals(mode) || ("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    if(("SAX").equals(mode)){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
     if(dieOnError) { 
    stringBuffer.append(TEXT_31);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
     } else { 
    stringBuffer.append(TEXT_35);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
     } 
    stringBuffer.append(TEXT_39);
     } 
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
	log4jFileUtil.retrievedDataNumberInfo();
	log4jFileUtil.componentFinishInfo(node);

    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}

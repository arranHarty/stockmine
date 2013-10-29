package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileOutputLDIFBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputLDIFBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputLDIFBeginJava result = new TFileOutputLDIFBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "java.io.File file_";
  protected final String TEXT_2 = " = new java.io.File(";
  protected final String TEXT_3 = "); " + NL + "boolean isFileGenerated_";
  protected final String TEXT_4 = " = true;";
  protected final String TEXT_5 = NL + "if(file_";
  protected final String TEXT_6 = ".exists()){" + NL + "\tisFileGenerated_";
  protected final String TEXT_7 = " = false;" + NL + "}";
  protected final String TEXT_8 = NL + "//create directory only if not exists" + NL + " java.io.File parentFile_";
  protected final String TEXT_9 = " = file_";
  protected final String TEXT_10 = ".getParentFile();  " + NL + " \tif(parentFile_";
  protected final String TEXT_11 = " != null && !parentFile_";
  protected final String TEXT_12 = ".exists()) {  " + NL + " \t   parentFile_";
  protected final String TEXT_13 = ".mkdirs();" + NL + " \t} ";
  protected final String TEXT_14 = "\t" + NL + "\t\t    class Util_";
  protected final String TEXT_15 = NL + "            {" + NL + "                public void breakString( StringBuilder pw, String value, int max) {" + NL + "                    int leftToGo = value.length();" + NL + "                    int written = 0;" + NL + "                    int maxChars = max;" + NL + "                    while( leftToGo > 0 ) {" + NL + "                        int toWrite = Math.min( maxChars, leftToGo );" + NL + "                        String s = value.substring( written, written+toWrite);" + NL + "                        if ( written != 0 ) {" + NL + "                        \tpw.append( \" \" + s );" + NL + "                        } else {" + NL + "                        \tpw.append( s );" + NL + "                            maxChars -= 1;" + NL + "                        }" + NL + "                        written += toWrite;" + NL + "                        leftToGo -= toWrite;" + NL + "                        pw.append( '\\n' );" + NL + "                    }" + NL + "                }" + NL + "                " + NL + "                public String getBase64StringOrNot(boolean encodingBase64,String srcData,String encoding){" + NL + "                \tString returnValue = \"\";" + NL + "                \ttry {" + NL + "\t\t\t\t\t\tif(encodingBase64 && !netscape.ldap.util.LDIF.isPrintable(srcData.getBytes(encoding))){" + NL + "\t\t\t\t\t\t\treturnValue = org.apache.commons.codec.binary.Base64.encodeBase64String(srcData.getBytes(encoding));" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\treturnValue = srcData; " + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t}\t" + NL + "\t\t\t\t\treturn returnValue;" + NL + "                } " + NL + "            } " + NL + "            " + NL + "\t\tUtil_";
  protected final String TEXT_16 = " util_";
  protected final String TEXT_17 = " = new Util_";
  protected final String TEXT_18 = "();" + NL + "\t\t" + NL + "\t\tint nb_line_";
  protected final String TEXT_19 = " = 0;" + NL + "\t\tfinal String dn_";
  protected final String TEXT_20 = " = \"dn: \";" + NL + "\t\tfinal String changetype_";
  protected final String TEXT_21 = " = \"changetype: \";" + NL + "\t\tfinal int wrap_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "       \tjava.io.PrintWriter pw_";
  protected final String TEXT_25 = " = new java.io.PrintWriter(file_";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\tjava.io.PrintWriter pw_";
  protected final String TEXT_29 = " = new java.io.PrintWriter" + NL + "\t\t\t\t\t\t\t\t\t\t(new java.io.BufferedWriter" + NL + "\t\t\t\t\t\t\t\t\t\t(new java.io.OutputStreamWriter" + NL + "\t\t\t\t\t\t\t\t\t\t(new java.io.FileOutputStream" + NL + "\t\t\t\t\t\t\t\t\t\t(file_";
  protected final String TEXT_30 = ",true),";
  protected final String TEXT_31 = ")),false);";
  protected final String TEXT_32 = NL + NL + "if(file_";
  protected final String TEXT_33 = ".length()==0){" + NL + "\tpw_";
  protected final String TEXT_34 = ".write(\"version: 1\\n\");" + NL + "}";
  protected final String TEXT_35 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();

        // component id        
        String cid = node.getUniqueName();
        String wrap = ElementParameterParser.getValue(node, "__WRAP__");
        String filename = ElementParameterParser.getValue(node, "__FILENAME__");
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");       
        boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
		if(isAppend){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
		}
if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(wrap );
    stringBuffer.append(TEXT_23);
    if(!isAppend){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_27);
    }else{
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}

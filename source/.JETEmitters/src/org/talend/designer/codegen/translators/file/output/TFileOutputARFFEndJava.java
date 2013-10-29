package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileOutputARFFEndJava
{
  protected static String nl;
  public static synchronized TFileOutputARFFEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputARFFEndJava result = new TFileOutputARFFEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.io.FileOutputStream out";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "\tjava.io.BufferedReader buf_Check_";
  protected final String TEXT_5 = " =null;";
  protected final String TEXT_6 = NL + "try {" + NL + "    out";
  protected final String TEXT_7 = " = new java.io.FileOutputStream(fileNewName_";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "    try{" + NL + "        //to check if the file-to-write is an existing-valid ARFF file" + NL + "       buf_Check_";
  protected final String TEXT_11 = "=new java.io.BufferedReader(new java.io.FileReader(fileNewName_";
  protected final String TEXT_12 = "));" + NL + "       new weka.core.Instances(buf_Check_";
  protected final String TEXT_13 = ");" + NL + "       StringBuilder sb";
  protected final String TEXT_14 = " = new StringBuilder();" + NL + "       for (int i = oldInsNum";
  protected final String TEXT_15 = "; i < m_Data";
  protected final String TEXT_16 = ".numInstances(); i++) {" + NL + "           sb";
  protected final String TEXT_17 = ".append(\"\\n\");" + NL + "           sb";
  protected final String TEXT_18 = ".append(m_Data";
  protected final String TEXT_19 = ".instance(i).toString());" + NL + "       }" + NL + "       out";
  protected final String TEXT_20 = ".write(sb";
  protected final String TEXT_21 = ".toString().getBytes(), 0, sb";
  protected final String TEXT_22 = ".toString().getBytes().length);" + NL + "    }catch(java.lang.Exception e){" + NL + "       out";
  protected final String TEXT_23 = ".write(m_Data";
  protected final String TEXT_24 = ".toString().getBytes(),0,m_Data";
  protected final String TEXT_25 = ".toString().getBytes().length);" + NL + "    }   ";
  protected final String TEXT_26 = "   " + NL + "    out";
  protected final String TEXT_27 = ".write(m_Data";
  protected final String TEXT_28 = ".toString().getBytes(),0,m_Data";
  protected final String TEXT_29 = ".toString().getBytes().length);";
  protected final String TEXT_30 = NL + "} catch (java.io.IOException e) {" + NL + "    // TODO Auto-generated catch block" + NL + "    e.printStackTrace();" + NL + "}finally{";
  protected final String TEXT_31 = NL + "\tif(buf_Read_";
  protected final String TEXT_32 = "!=null){" + NL + "\t\tbuf_Read_";
  protected final String TEXT_33 = ".close();" + NL + "\t}" + NL + "\tif(buf_Check_";
  protected final String TEXT_34 = "!=null){" + NL + "\t\tbuf_Check_";
  protected final String TEXT_35 = ".close();" + NL + "\t}";
  protected final String TEXT_36 = NL + "\tout";
  protected final String TEXT_37 = ".close();" + NL + "\tout";
  protected final String TEXT_38 = " = null;" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_39 = "_NB_LINE\",nb_line_";
  protected final String TEXT_40 = ");" + NL;
  protected final String TEXT_41 = NL + "\tif(isFileGenerated_";
  protected final String TEXT_42 = " && nb_line_";
  protected final String TEXT_43 = " == 0){" + NL + "\t\tcreateFile";
  protected final String TEXT_44 = ".delete();" + NL + "\t}\t\t";
  protected final String TEXT_45 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));

boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
     if(isAppend){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_9);
     if(isAppend){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }else{
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    
	if(isAppend){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    if(isDeleteEmptyFile){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}

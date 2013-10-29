package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TContextLoadEndJava
{
  protected static String nl;
  public static synchronized TContextLoadEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TContextLoadEndJava result = new TContextLoadEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t" + NL + "\tjava.util.Enumeration<?> enu_";
  protected final String TEXT_3 = " = context.propertyNames();" + NL + "    while(enu_";
  protected final String TEXT_4 = ".hasMoreElements())" + NL + "    {           " + NL + "    \tString key_";
  protected final String TEXT_5 = " = (String)enu_";
  protected final String TEXT_6 = ".nextElement();" + NL + "        if(!assignList_";
  protected final String TEXT_7 = ".contains(key_";
  protected final String TEXT_8 = ") && !newPropertyList_";
  protected final String TEXT_9 = ".contains(key_";
  protected final String TEXT_10 = "))" + NL + "        {" + NL + "            noAssignList_";
  protected final String TEXT_11 = ".add(key_";
  protected final String TEXT_12 = ");" + NL + "        }          " + NL + "    }";
  protected final String TEXT_13 = NL + "\tfor(Object obj_";
  protected final String TEXT_14 = " :newPropertyList_";
  protected final String TEXT_15 = "){" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t\t\tlog.";
  protected final String TEXT_17 = "\"";
  protected final String TEXT_18 = " - ";
  protected final String TEXT_19 = ": Parameter \\\"\" + obj_";
  protected final String TEXT_20 = " + \"\\\" is a new parameter of ";
  protected final String TEXT_21 = "\");" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\tSystem.";
  protected final String TEXT_23 = ".println(\"";
  protected final String TEXT_24 = ": Parameter \\\"\" + obj_";
  protected final String TEXT_25 = " + \"\\\" is a new parameter of ";
  protected final String TEXT_26 = "\");";
  protected final String TEXT_27 = NL + "\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_29 = " - ";
  protected final String TEXT_30 = ": Parameter \\\"\" + obj_";
  protected final String TEXT_31 = " + \"\\\" is a new parameter of ";
  protected final String TEXT_32 = "\");" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t  throw new RuntimeException(\"";
  protected final String TEXT_34 = ": Parameter \\\"\" + obj_";
  protected final String TEXT_35 = " + \"\\\" is a new parameter of ";
  protected final String TEXT_36 = "\");" + NL + "\t\t";
  protected final String TEXT_37 = "        " + NL + "\t}";
  protected final String TEXT_38 = NL + "\tfor(Object obj_";
  protected final String TEXT_39 = " :noAssignList_";
  protected final String TEXT_40 = "){" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t\tlog.";
  protected final String TEXT_42 = "\"";
  protected final String TEXT_43 = " - ";
  protected final String TEXT_44 = ": Parameter \\\"\" + obj_";
  protected final String TEXT_45 = " + \"\\\" has not been set by ";
  protected final String TEXT_46 = "\");" + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t\tSystem.";
  protected final String TEXT_48 = ".println(\"";
  protected final String TEXT_49 = ": Parameter \\\"\" + obj_";
  protected final String TEXT_50 = " + \"\\\" has not been set by ";
  protected final String TEXT_51 = "\");" + NL + "\t\t";
  protected final String TEXT_52 = NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_54 = " - ";
  protected final String TEXT_55 = ": Parameter \\\"\" + obj_";
  protected final String TEXT_56 = " + \"\\\" has not been set by ";
  protected final String TEXT_57 = "\");" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t  throw new RuntimeException(\"";
  protected final String TEXT_59 = ": Parameter \\\"\" + obj_";
  protected final String TEXT_60 = " + \"\\\" has not been set by ";
  protected final String TEXT_61 = "\");" + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t}";
  protected final String TEXT_63 = " " + NL + "" + NL + "    String newPropertyStr_";
  protected final String TEXT_64 = " = newPropertyList_";
  protected final String TEXT_65 = ".toString();" + NL + "    String newProperty_";
  protected final String TEXT_66 = " = newPropertyStr_";
  protected final String TEXT_67 = ".substring(1, newPropertyStr_";
  protected final String TEXT_68 = ".length() - 1);" + NL + "    " + NL + "    String noAssignStr_";
  protected final String TEXT_69 = " = noAssignList_";
  protected final String TEXT_70 = ".toString();" + NL + "    String noAssign_";
  protected final String TEXT_71 = " = noAssignStr_";
  protected final String TEXT_72 = ".substring(1, noAssignStr_";
  protected final String TEXT_73 = ".length() - 1);" + NL + "    " + NL + "    globalMap.put(\"";
  protected final String TEXT_74 = "_KEY_NOT_INCONTEXT\", newProperty_";
  protected final String TEXT_75 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_76 = "_KEY_NOT_LOADED\", noAssign_";
  protected final String TEXT_77 = ");" + NL + "" + NL + "    globalMap.put(\"";
  protected final String TEXT_78 = "_NB_LINE\",nb_line_";
  protected final String TEXT_79 = ");" + NL + "    " + NL + "\tresumeUtil.addLog(\"NODE\", \"NODE:";
  protected final String TEXT_80 = "\", \"\", Thread.currentThread().getId() + \"\", \"\",\"\",\"\",\"\",resumeUtil.convertToJsonText(context));    ";
  protected final String TEXT_81 = NL + "    \tlog.info(\"";
  protected final String TEXT_82 = " - Loaded contexts count: \" + nb_line_";
  protected final String TEXT_83 = " + \".\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_84 = " - Done.\");";
  protected final String TEXT_85 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    boolean disError=ElementParameterParser.getValue(node, "__DISABLE_ERROR__").equals("true");
    boolean disWarning=ElementParameterParser.getValue(node, "__DISABLE_WARNINGS__").equals("true");
    boolean bDieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIEONERROR__"));
    boolean disInfo=ElementParameterParser.getValue(node, "__DISABLE_INFO__").equals("true");
    String newVariable = ElementParameterParser.getValue(node, "__LOAD_NEW_VARIABLE__");
    String oldVariable = ElementParameterParser.getValue(node, "__NOT_LOAD_OLD_VARIABLE__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
	if( (newVariable.equals("Error") && disError==false) 
		|| (newVariable.equals("Warning") && disWarning==false)
		|| (newVariable.equals("Info") && disInfo==false) ){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_16);
    stringBuffer.append("Error".equals(newVariable)?"error(":"info(");
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(newVariable);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append("Error".equals(newVariable)?"err":"out");
    stringBuffer.append(TEXT_23);
    stringBuffer.append(newVariable);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    if (bDieOnError && newVariable.equals("Error")){
    stringBuffer.append(TEXT_27);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(newVariable);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(newVariable);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
	}
	if( (oldVariable.equals("Error") && disError==false) 
		|| (oldVariable.equals("Warning") && disWarning==false)
		|| (oldVariable.equals("Info") && disInfo==false) ){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(oldVariable.equals("Error")?"error(":"info(");
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(oldVariable.equals("Error")?"err":"out");
    stringBuffer.append(TEXT_48);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    if (bDieOnError && oldVariable.equals("Error")){
    stringBuffer.append(TEXT_52);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    
	}

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    return stringBuffer.toString();
  }
}

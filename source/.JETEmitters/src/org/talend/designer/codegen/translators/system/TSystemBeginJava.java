package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TSystemBeginJava
{
  protected static String nl;
  public static synchronized TSystemBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSystemBeginJava result = new TSystemBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work.\");" + NL + "\t\tStringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tString commandArrayForLog_";
  protected final String TEXT_7 = " =\"\";" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tString[] command_";
  protected final String TEXT_9 = " = new String[";
  protected final String TEXT_10 = "];" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t\tcommand_";
  protected final String TEXT_12 = "[";
  protected final String TEXT_13 = "] = ";
  protected final String TEXT_14 = ";" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tif(";
  protected final String TEXT_16 = ".contains(\" \"))" + NL + "\t\t\t\t\tcommandArrayForLog_";
  protected final String TEXT_17 = "+=\"\\\"\" + ";
  protected final String TEXT_18 = " + \"\\\" \";" + NL + "\t\t\t\telse" + NL + "\t\t\t\t\tcommandArrayForLog_";
  protected final String TEXT_19 = "+=";
  protected final String TEXT_20 = " + \" \";" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "final java.util.Vector<String> output_";
  protected final String TEXT_22 = " = new java.util.Vector<String>();";
  protected final String TEXT_23 = NL + "Runtime runtime_";
  protected final String TEXT_24 = " = Runtime.getRuntime();" + NL + "" + NL + "String[] env_";
  protected final String TEXT_25 = "= null;" + NL + "java.util.Map<String,String> envMap_";
  protected final String TEXT_26 = "= System.getenv();" + NL + "java.util.Map<String,String> envMapClone_";
  protected final String TEXT_27 = "= new java.util.HashMap();" + NL + "envMapClone_";
  protected final String TEXT_28 = ".putAll(envMap_";
  protected final String TEXT_29 = ");" + NL;
  protected final String TEXT_30 = NL + "\tlog.info(\"";
  protected final String TEXT_31 = " - Setting the parameters.\");";
  protected final String TEXT_32 = NL + "\tlog.debug(\"";
  protected final String TEXT_33 = " - Parameter \" + (";
  protected final String TEXT_34 = ") + \": Key='\" + ";
  protected final String TEXT_35 = " + \"', Value='\" + ";
  protected final String TEXT_36 = " + \"'.\");";
  protected final String TEXT_37 = NL + "envMapClone_";
  protected final String TEXT_38 = ".put(";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "env_";
  protected final String TEXT_42 = "= new String[envMapClone_";
  protected final String TEXT_43 = ".size()];" + NL + "int i_";
  protected final String TEXT_44 = "= 0;" + NL + "for (String envKey : (java.util.Set<String>) envMapClone_";
  protected final String TEXT_45 = ".keySet()) {" + NL + "    env_";
  protected final String TEXT_46 = "[i_";
  protected final String TEXT_47 = "++]= envKey + \"=\" + envMapClone_";
  protected final String TEXT_48 = ".get(envKey);" + NL + "}";
  protected final String TEXT_49 = NL + "\t";
  protected final String TEXT_50 = NL + "\t\tlog.info(\"";
  protected final String TEXT_51 = " - Root directory: '\" + ";
  protected final String TEXT_52 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_53 = NL + "final Process ps_";
  protected final String TEXT_54 = " = runtime_";
  protected final String TEXT_55 = ".exec(";
  protected final String TEXT_56 = " ";
  protected final String TEXT_57 = " ";
  protected final String TEXT_58 = "command_";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = ",env_";
  protected final String TEXT_61 = ",new java.io.File(";
  protected final String TEXT_62 = "));";
  protected final String TEXT_63 = NL + "final Process ps_";
  protected final String TEXT_64 = " = runtime_";
  protected final String TEXT_65 = ".exec(";
  protected final String TEXT_66 = " ";
  protected final String TEXT_67 = " ";
  protected final String TEXT_68 = "command_";
  protected final String TEXT_69 = " ";
  protected final String TEXT_70 = ",env_";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + NL + "globalMap.remove(\"";
  protected final String TEXT_73 = "_OUTPUT\");" + NL + "globalMap.remove(\"";
  protected final String TEXT_74 = "_ERROROUTPUT\");" + NL + "" + NL + "Thread normal_";
  protected final String TEXT_75 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_76 = ".getInputStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {";
  protected final String TEXT_77 = NL + "\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_79 = " - Sending the standard output to the console.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\tSystem.out.println(line);";
  protected final String TEXT_81 = NL + "\t\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_83 = " - Sending the standard output to the global variable '";
  protected final String TEXT_84 = "_OUTPUT'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\tif (globalMap.get(\"";
  protected final String TEXT_86 = "_OUTPUT\") != null) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_87 = "_OUTPUT\", (String)globalMap.get(\"";
  protected final String TEXT_88 = "_OUTPUT\")+\"\\n\"+line);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_89 = "_OUTPUT\", line);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_90 = NL + "\t\t";
  protected final String TEXT_91 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_92 = " - Sending the standard output to both the console and the global variable '";
  protected final String TEXT_93 = "_OUTPUT'.\");" + NL + "\t\t";
  protected final String TEXT_94 = NL + "        System.out.println(line);" + NL + "        " + NL + "        \tif (globalMap.get(\"";
  protected final String TEXT_95 = "_OUTPUT\") != null) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_96 = "_OUTPUT\", (String)globalMap.get(\"";
  protected final String TEXT_97 = "_OUTPUT\")+\"\\n\"+line);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_98 = "_OUTPUT\", line);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "    \t ";
  protected final String TEXT_99 = NL + "\t\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_101 = " - Sending the standard output to a column of the schema.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\toutput_";
  protected final String TEXT_103 = ".add(line);";
  protected final String TEXT_104 = NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_106 = " - \"  + ioe.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\tioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};";
  protected final String TEXT_108 = NL + "\tlog.info(\"";
  protected final String TEXT_109 = " - Executing the command.\");" + NL + "\tlog.info(\"";
  protected final String TEXT_110 = " - Command to execute: '\" + ";
  protected final String TEXT_111 = " ";
  protected final String TEXT_112 = " ";
  protected final String TEXT_113 = "commandArrayForLog_";
  protected final String TEXT_114 = " ";
  protected final String TEXT_115 = " + \"'.\");";
  protected final String TEXT_116 = NL + "normal_";
  protected final String TEXT_117 = ".start();";
  protected final String TEXT_118 = NL + "\tlog.info(\"";
  protected final String TEXT_119 = " - The command has been executed successfully.\");";
  protected final String TEXT_120 = NL + NL + "Thread error_";
  protected final String TEXT_121 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_122 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {";
  protected final String TEXT_123 = NL + "\t\t\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_125 = " - Sending the error output to the console.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\tSystem.err.println(line);";
  protected final String TEXT_127 = NL + "\t\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_129 = " - Sending the error output to the global variable '";
  protected final String TEXT_130 = "_ERROROUTPUT'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\t\tif (globalMap.get(\"";
  protected final String TEXT_132 = "_ERROROUTPUT\") != null) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_133 = "_ERROROUTPUT\", (String)globalMap.get(\"";
  protected final String TEXT_134 = "_ERROROUTPUT\")+\"\\n\"+line);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_135 = "_ERROROUTPUT\", line);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_136 = NL + "\t\t";
  protected final String TEXT_137 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_138 = " - Sending the error output to both the console and the global variable '";
  protected final String TEXT_139 = "_ERROROUTPUT'.\");" + NL + "\t\t";
  protected final String TEXT_140 = NL + "        System.err.println(line);" + NL + "        " + NL + "        \tif (globalMap.get(\"";
  protected final String TEXT_141 = "_ERROROUTPUT\") != null) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_142 = "_ERROROUTPUT\", (String)globalMap.get(\"";
  protected final String TEXT_143 = "_ERROROUTPUT\")+\"\\n\"+line);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_144 = "_ERROROUTPUT\", line);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "    \t ";
  protected final String TEXT_145 = NL + "\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_147 = " - Sending the error output to a column of the schema.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\toutput_";
  protected final String TEXT_149 = ".add(line);";
  protected final String TEXT_150 = NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_152 = " - \"  + ioe.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\tioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_154 = ".start();";
  protected final String TEXT_155 = NL + "if(ps_";
  protected final String TEXT_156 = ".getOutputStream()!=null){" + NL + "    ps_";
  protected final String TEXT_157 = ".getOutputStream().close();" + NL + "}" + NL + "ps_";
  protected final String TEXT_158 = ".waitFor();" + NL + "normal_";
  protected final String TEXT_159 = ".join(10000);" + NL + "error_";
  protected final String TEXT_160 = ".join(10000);" + NL;
  protected final String TEXT_161 = NL + "\t\t\t\tfor(String tmp_";
  protected final String TEXT_162 = ":output_";
  protected final String TEXT_163 = "){";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_165 = ".";
  protected final String TEXT_166 = " = tmp_";
  protected final String TEXT_167 = ";\t\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_169 = ".append(";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = ");";
  protected final String TEXT_172 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String command = ElementParameterParser.getValue(node, "__COMMAND__");
	
	String outputAction  = ElementParameterParser.getValue(node, "__OUTPUT__");
	
	String errorOuput  = ElementParameterParser.getValue(node, "__ERROROUTPUT__");
	
	
	boolean ifDir = ("true").equals(ElementParameterParser.getValue(node, "__ROOTDIR__"));
	
	String rootDir  = ElementParameterParser.getValue(node, "__DIRECTORY__").replace("\\","/");
	
	List<Map<String, String>> params = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__PARAMS__");
	boolean single_command = ("true").equals(ElementParameterParser.getValue(node, "__USE_SINGLE_COMMAND__"));
	
	boolean array_command = ("true").equals(ElementParameterParser.getValue(node, "__USE_ARRAY_COMMAND__"));
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	if(isLog4jEnabled){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	} 
	
	if(array_command){
		List<Map<String,String>> list_data = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ARRAY_COMMAND__");

    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(list_data.size());
    stringBuffer.append(TEXT_10);
    
		int command_array_index = 0;
		for(Map<String,String> map : list_data){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(command_array_index++);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_20);
    }
    
		}
	}
	
		
	// To launch an internal command to cmd.exe (XP), you have to call :
	// cmd.exe /c dir (for example)

	if (("NORMAL_OUTPUT").equals(outputAction)||("NORMAL_OUTPUT").equals(errorOuput)) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
	}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    
    for (int i = 0; i < params.size(); i++) {
        Map<String, String> line = params.get(i);

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_34);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_40);
    
    }

    if (params.size() > 0) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
    }

if(ifDir){
    stringBuffer.append(TEXT_49);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(rootDir);
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
     if(single_command) { 
    stringBuffer.append(TEXT_56);
    stringBuffer.append( command);
    stringBuffer.append(TEXT_57);
     } else { 
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
     } 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(rootDir);
    stringBuffer.append(TEXT_62);
      }else{
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
     if(single_command) { 
    stringBuffer.append(TEXT_66);
    stringBuffer.append( command);
    stringBuffer.append(TEXT_67);
     } else { 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
     } 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
      }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
	if (("OUTPUT_TO_CONSOLE").equals(outputAction)) {

    stringBuffer.append(TEXT_77);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    
	} else if (("RETRIEVE_OUTPUT").equals(outputAction)) {

    stringBuffer.append(TEXT_81);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    
	} else if(("OUTPUT_TO_CONSOLE_AND_RETRIVE_OUTPUT").equals(outputAction)){

    stringBuffer.append(TEXT_90);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
   } else if (("NORMAL_OUTPUT").equals(outputAction)) {

    stringBuffer.append(TEXT_99);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
	}

    stringBuffer.append(TEXT_104);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
     if(single_command) { 
    stringBuffer.append(TEXT_111);
    stringBuffer.append( command);
    stringBuffer.append(TEXT_112);
     } else { 
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
     } 
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    
	if (("OUTPUT_TO_CONSOLE").equals(errorOuput)) {

    stringBuffer.append(TEXT_123);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    
	} else if (("RETRIEVE_OUTPUT").equals(errorOuput)) {

    stringBuffer.append(TEXT_127);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    
	}else if(("OUTPUT_TO_CONSOLE_AND_RETRIVE_OUTPUT").equals(errorOuput)){

    stringBuffer.append(TEXT_136);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
     
	}else if (("NORMAL_OUTPUT").equals(errorOuput)) {

    stringBuffer.append(TEXT_145);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
	}

    stringBuffer.append(TEXT_150);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    //for bug TDI-22281
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    
if(("NORMAL_OUTPUT").equals(outputAction)||("NORMAL_OUTPUT").equals(errorOuput)){
	List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata!=null) {
    		List<IMetadataColumn> columns=metadata.getListColumns();
    		List<? extends IConnection> conns = node.getOutgoingSortedConnections();
    		if (conns!=null && conns.size()>0) {
				IConnection conn = conns.get(0);  
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
					for(IMetadataColumn column:columns) {
						if("outputline".equals(column.getLabel())){

    stringBuffer.append(TEXT_164);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    
			                if(isLog4jEnabled){
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_171);
    
							}
						}
					}
				}
			}
		}
	}
}

    stringBuffer.append(TEXT_172);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSCPGetMainJava
{
  protected static String nl;
  public static synchronized TSCPGetMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPGetMainJava result = new TSCPGetMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "        String[] sourceFileNames_";
  protected final String TEXT_3 = " = new String[]{";
  protected final String TEXT_4 = NL + "\t\t\t\t";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = NL + "\t\t};" + NL + "\t\t" + NL + "java.io.File dir_";
  protected final String TEXT_7 = " = null;" + NL + "java.io.File file_";
  protected final String TEXT_8 = " = null;" + NL + "java.io.FileOutputStream out_";
  protected final String TEXT_9 = " = null;" + NL + "try{";
  protected final String TEXT_10 = NL + "\tfor (String sourceFile_";
  protected final String TEXT_11 = " : sourceFileNames_";
  protected final String TEXT_12 = ") {" + NL + "\t\tif (sourceFile_";
  protected final String TEXT_13 = " != null&& sourceFile_";
  protected final String TEXT_14 = ".length() != 0) {" + NL + "\t\t\tsourceFile_";
  protected final String TEXT_15 = " = \"\\\"\" + sourceFile_";
  protected final String TEXT_16 = " + \"\\\"\";" + NL + "\t\t\tsourceFile_";
  protected final String TEXT_17 = "=sourceFile_";
  protected final String TEXT_18 = ".replaceAll(\"\\\\\\\\\",\"/\"); " + NL + "\t\t\tint index_";
  protected final String TEXT_19 = "=sourceFile_";
  protected final String TEXT_20 = ".lastIndexOf(\"/\");" + NL + "\t\t\tif(index_";
  protected final String TEXT_21 = " >0){" + NL + "\t\t\t\tdir_";
  protected final String TEXT_22 = " = new java.io.File(";
  protected final String TEXT_23 = ");" + NL + "\t\t\t\tString extension_";
  protected final String TEXT_24 = "=\tsourceFile_";
  protected final String TEXT_25 = ".substring(index_";
  protected final String TEXT_26 = ",sourceFile_";
  protected final String TEXT_27 = ".length()-1);\t" + NL + "\t\t\t\tfile_";
  protected final String TEXT_28 = " = new java.io.File(dir_";
  protected final String TEXT_29 = ", extension_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\tif(!file_";
  protected final String TEXT_31 = ".exists()){" + NL + "\t\t\t\t  file_";
  protected final String TEXT_32 = ".getParentFile().mkdirs();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tout_";
  protected final String TEXT_33 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_34 = ", true);" + NL + "\t\t\t\tscp_";
  protected final String TEXT_35 = ".get(sourceFile_";
  protected final String TEXT_36 = ", out_";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\tnb_file_";
  protected final String TEXT_38 = " ++ ;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\tif(nb_file_";
  protected final String TEXT_39 = ">0){" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_40 = "_STATUS\", \"File get OK.\");" + NL + "\t}else{" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_41 = "_STATUS\", \"No file transfered.\");" + NL + "\t}";
  protected final String TEXT_42 = "        " + NL + "        String parentPath_";
  protected final String TEXT_43 = " = new java.io.File(";
  protected final String TEXT_44 = ").getPath();" + NL + "        java.util.List<String> list_";
  protected final String TEXT_45 = " = new java.util.ArrayList<String>();" + NL + "        for (int i_";
  protected final String TEXT_46 = " = 0; i_";
  protected final String TEXT_47 = " < sourceFileNames_";
  protected final String TEXT_48 = ".length; i_";
  protected final String TEXT_49 = "++) {" + NL + "            String fileName_";
  protected final String TEXT_50 = " = sourceFileNames_";
  protected final String TEXT_51 = "[i_";
  protected final String TEXT_52 = "];" + NL + "            if (!new java.io.File((parentPath_";
  protected final String TEXT_53 = "), (fileName_";
  protected final String TEXT_54 = ")).exists()) {" + NL + "                list_";
  protected final String TEXT_55 = ".add(fileName_";
  protected final String TEXT_56 = ");" + NL + "            }" + NL + "        }" + NL + "        sourceFileNames_";
  protected final String TEXT_57 = " = (String[]) list_";
  protected final String TEXT_58 = ".toArray(new String[0]);";
  protected final String TEXT_59 = NL + "\tif(sourceFileNames_";
  protected final String TEXT_60 = "!=null && sourceFileNames_";
  protected final String TEXT_61 = ".length!=0){" + NL + "\t\tfor (String sourceFile_";
  protected final String TEXT_62 = " : sourceFileNames_";
  protected final String TEXT_63 = ") {" + NL + "\t\t\tif (sourceFile_";
  protected final String TEXT_64 = " != null&& sourceFile_";
  protected final String TEXT_65 = ".length() != 0) {" + NL + "\t\t\t\tsourceFile_";
  protected final String TEXT_66 = " = \"\\\"\" + sourceFile_";
  protected final String TEXT_67 = " + \"\\\"\";" + NL + "\t\t\t\tsourceFile_";
  protected final String TEXT_68 = "=sourceFile_";
  protected final String TEXT_69 = ".replaceAll(\"\\\\\\\\\",\"/\"); " + NL + "\t\t\t    int index_";
  protected final String TEXT_70 = "=sourceFile_";
  protected final String TEXT_71 = ".lastIndexOf(\"/\");" + NL + "\t\t\t    if(index_";
  protected final String TEXT_72 = " >0){" + NL + "\t\t\t\t\tdir_";
  protected final String TEXT_73 = " = new java.io.File(";
  protected final String TEXT_74 = ");" + NL + "\t\t\t\t\tString extension_";
  protected final String TEXT_75 = "=\tsourceFile_";
  protected final String TEXT_76 = ".substring(index_";
  protected final String TEXT_77 = ",sourceFile_";
  protected final String TEXT_78 = ".length()-1);" + NL + "\t\t\t\t\tfile_";
  protected final String TEXT_79 = " = new java.io.File(dir_";
  protected final String TEXT_80 = ", extension_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t\t\tif(!file_";
  protected final String TEXT_82 = ".exists()){" + NL + "\t\t\t\t  \t\tfile_";
  protected final String TEXT_83 = ".getParentFile().mkdirs();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tout_";
  protected final String TEXT_84 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_85 = ", false);" + NL + "\t\t\t\t\tscp_";
  protected final String TEXT_86 = ".get(sourceFile_";
  protected final String TEXT_87 = ", out_";
  protected final String TEXT_88 = ");" + NL + "\t\t\t\t\tnb_file_";
  protected final String TEXT_89 = " ++ ;" + NL + "\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_91 = " - Downloaded file \" + nb_file_";
  protected final String TEXT_92 = " +  \": \" + sourceFile_";
  protected final String TEXT_93 = " + \" successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif(nb_file_";
  protected final String TEXT_95 = ">0){" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_96 = "_STATUS\", \"File get OK.\");" + NL + "\t\t}else{" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_97 = "_STATUS\", \"No file transfered.\");" + NL + "\t\t}" + NL + "\t}" + NL + "        ";
  protected final String TEXT_98 = NL + NL + "}catch(java.lang.Exception e){" + NL + "\t\tif(out_";
  protected final String TEXT_99 = " != null){" + NL + "\t\t\tout_";
  protected final String TEXT_100 = ".close();" + NL + "\t\t}" + NL + "\t\tif(file_";
  protected final String TEXT_101 = ".length() == 0){" + NL + "\t\t\tfile_";
  protected final String TEXT_102 = ".delete();" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_103 = "_STATUS\", \"File get fail.\");" + NL + "\t\t";
  protected final String TEXT_104 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_105 = " - \"  + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\tthrow e;" + NL + "}finally{" + NL + "\tif(out_";
  protected final String TEXT_107 = " != null){" + NL + "\t\tout_";
  protected final String TEXT_108 = ".close();" + NL + "\t}" + NL + "}";
  protected final String TEXT_109 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
        CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
        INode node = (INode)codeGenArgument.getArgument();
        String cid = node.getUniqueName();      

        String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
        String replaceOption = ElementParameterParser.getValue(node,"__REPLACEOPTION__");
        List<Map<String, String>> filelist = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILELIST__");
        boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			for (Map<String, String> file : filelist) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(file.get("SOURCE"));
    stringBuffer.append(TEXT_5);
              
            }

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
if(("append").equals(replaceOption)){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
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
    stringBuffer.append(localdir );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
}else{
	if(!("overwrite").equals(replaceOption)) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(localdir );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
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
    
	}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
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
    stringBuffer.append(localdir );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
}

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    return stringBuffer.toString();
  }
}

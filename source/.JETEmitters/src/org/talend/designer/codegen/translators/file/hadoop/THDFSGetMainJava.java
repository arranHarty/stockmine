package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THDFSGetMainJava
{
  protected static String nl;
  public static synchronized THDFSGetMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSGetMainJava result = new THDFSGetMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.Set<String> keySet_";
  protected final String TEXT_3 = " = map_";
  protected final String TEXT_4 = ".keySet();" + NL + "    for (String key_";
  protected final String TEXT_5 = " : keySet_";
  protected final String TEXT_6 = "){     " + NL + "\t\tString tempdir_";
  protected final String TEXT_7 = " =  ";
  protected final String TEXT_8 = ";" + NL + "\t\tString filemask_";
  protected final String TEXT_9 = " = key_";
  protected final String TEXT_10 = "; " + NL + "\t\tString dir_";
  protected final String TEXT_11 = " = null;\t" + NL + "\t\tString mask_";
  protected final String TEXT_12 = " = filemask_";
  protected final String TEXT_13 = ".replaceAll(\"\\\\\\\\\", \"/\") ;\t" + NL + "\t\tint i_";
  protected final String TEXT_14 = " = mask_";
  protected final String TEXT_15 = ".lastIndexOf('/');" + NL + "  \t\tif (i_";
  protected final String TEXT_16 = "!=-1){" + NL + "\t\t\tdir_";
  protected final String TEXT_17 = " = mask_";
  protected final String TEXT_18 = ".substring(0, i_";
  protected final String TEXT_19 = "); " + NL + "\t\t\tmask_";
  protected final String TEXT_20 = " = mask_";
  protected final String TEXT_21 = ".substring(i_";
  protected final String TEXT_22 = "+1);\t " + NL + "    \t}" + NL + "    \tif (dir_";
  protected final String TEXT_23 = "!=null && !\"\".equals(dir_";
  protected final String TEXT_24 = ")) tempdir_";
  protected final String TEXT_25 = " = tempdir_";
  protected final String TEXT_26 = " + \"/\" + dir_";
  protected final String TEXT_27 = ";  " + NL + "    \tmask_";
  protected final String TEXT_28 = " = mask_";
  protected final String TEXT_29 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\");" + NL + "    \tfinal String finalMask_";
  protected final String TEXT_30 = " = mask_";
  protected final String TEXT_31 = ";" + NL + "\t\t" + NL + "\t\torg.apache.hadoop.fs.FileStatus[] fileStatusList_";
  protected final String TEXT_32 = " = fs_";
  protected final String TEXT_33 = ".listStatus(new org.apache.hadoop.fs.Path(tempdir_";
  protected final String TEXT_34 = "));" + NL + "\t\torg.apache.hadoop.fs.Path[] filePathList_";
  protected final String TEXT_35 = " = org.apache.hadoop.fs.FileUtil.stat2Paths(fileStatusList_";
  protected final String TEXT_36 = ");" + NL + "\t\tif(filePathList_";
  protected final String TEXT_37 = "==null){" + NL + "\t\t\tSystem.err.println(\"No match file(\"+key_";
  protected final String TEXT_38 = "+\") exist!\");" + NL + "\t\t}else{" + NL + "\t\t\tString localFilePath_";
  protected final String TEXT_39 = " = \"\";" + NL + "\t    \tfor(org.apache.hadoop.fs.Path path_";
  protected final String TEXT_40 = ":filePathList_";
  protected final String TEXT_41 = "){" + NL + "\t\t\t\tif(path_";
  protected final String TEXT_42 = ".getName().matches(finalMask_";
  protected final String TEXT_43 = ")){" + NL + "\t\t\t\t\tif(\"\".equals(map_";
  protected final String TEXT_44 = ".get(key_";
  protected final String TEXT_45 = "))){" + NL + "\t\t\t\t\t\tlocalFilePath_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = "+\"/\"+path_";
  protected final String TEXT_48 = ".getName();" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tlocalFilePath_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = "+\"/\"+map_";
  protected final String TEXT_51 = ".get(key_";
  protected final String TEXT_52 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tFileUtil_";
  protected final String TEXT_53 = " fileutil_";
  protected final String TEXT_54 = " = new FileUtil_";
  protected final String TEXT_55 = "();" + NL + "\t\t\t\t\t\tboolean success_";
  protected final String TEXT_56 = " = fileutil_";
  protected final String TEXT_57 = ".copyToLocal(fs_";
  protected final String TEXT_58 = ", path_";
  protected final String TEXT_59 = ", new java.io.File(localFilePath_";
  protected final String TEXT_60 = ")," + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ", ";
  protected final String TEXT_63 = ");" + NL + "\t\t\t\t\t\tif(success_";
  protected final String TEXT_64 = ") {" + NL + "\t\t\t\t\t\t\tmsg_";
  protected final String TEXT_65 = ".add(\"file: \" + path_";
  protected final String TEXT_66 = ".toString() + \", size: \"" + NL + "\t\t                    \t+ fileutil_";
  protected final String TEXT_67 = ".getSize() + \" bytes download successfully\");" + NL + "\t\t                    nb_success_";
  protected final String TEXT_68 = "++;" + NL + "\t\t                }" + NL + "\t\t\t\t\t}catch(java.io.IOException e){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "            \t\t\tthrow(e);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\tSystem.err.print(e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tnb_file_";
  protected final String TEXT_72 = "++;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean overwrite = ("true").equals(ElementParameterParser.getValue(node, "__OVERWRITE__"));
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	boolean append = ("true").equals(ElementParameterParser.getValue(node, "__APPEND__"));
	boolean includeSubDir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDSUBDIR__"));

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
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(append);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(includeSubDir);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
  							if(("true").equals(dieOnError)){
						
    stringBuffer.append(TEXT_69);
    
							}else{
						
    stringBuffer.append(TEXT_70);
    	
							} 
						
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    return stringBuffer.toString();
  }
}

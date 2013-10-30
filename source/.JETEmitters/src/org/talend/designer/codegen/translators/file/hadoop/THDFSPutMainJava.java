package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THDFSPutMainJava
{
  protected static String nl;
  public static synchronized THDFSPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSPutMainJava result = new THDFSPutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t      \t\t\t\t" + NL + "   \t\tjava.util.Set<String> keySet_";
  protected final String TEXT_3 = " = map_";
  protected final String TEXT_4 = ".keySet();" + NL + "      \tfor (String key_";
  protected final String TEXT_5 = " : keySet_";
  protected final String TEXT_6 = "){     " + NL + "\t\t\tString tempdir_";
  protected final String TEXT_7 = " =  localdir_";
  protected final String TEXT_8 = ";" + NL + "\t\t\tString filemask_";
  protected final String TEXT_9 = " = key_";
  protected final String TEXT_10 = "; " + NL + "\t\t\tString dir_";
  protected final String TEXT_11 = " = null;\t" + NL + "\t\t\tString mask_";
  protected final String TEXT_12 = " = filemask_";
  protected final String TEXT_13 = ".replaceAll(\"\\\\\\\\\", \"/\") ;\t" + NL + "\t\t\tint i_";
  protected final String TEXT_14 = " = mask_";
  protected final String TEXT_15 = ".lastIndexOf('/');" + NL + "  \t\t\tif (i_";
  protected final String TEXT_16 = "!=-1){" + NL + "\t\t\t\tdir_";
  protected final String TEXT_17 = " = mask_";
  protected final String TEXT_18 = ".substring(0, i_";
  protected final String TEXT_19 = "); " + NL + "\t\t\t\tmask_";
  protected final String TEXT_20 = " = mask_";
  protected final String TEXT_21 = ".substring(i_";
  protected final String TEXT_22 = "+1);\t " + NL + "    \t\t}" + NL + "    \t\tif (dir_";
  protected final String TEXT_23 = "!=null && !\"\".equals(dir_";
  protected final String TEXT_24 = ")) tempdir_";
  protected final String TEXT_25 = " = tempdir_";
  protected final String TEXT_26 = " + \"/\" + dir_";
  protected final String TEXT_27 = ";  " + NL + "    \t\tmask_";
  protected final String TEXT_28 = " = mask_";
  protected final String TEXT_29 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\");" + NL + "    \t\tfinal String finalMask_";
  protected final String TEXT_30 = " = mask_";
  protected final String TEXT_31 = ";" + NL + "    \t\tjava.io.File[] listings_";
  protected final String TEXT_32 = " = null;       " + NL + "        \tjava.io.File file_";
  protected final String TEXT_33 = " = new java.io.File(tempdir_";
  protected final String TEXT_34 = ");" + NL + "        \tif (file_";
  protected final String TEXT_35 = ".isDirectory()) {" + NL + "\t            listings_";
  protected final String TEXT_36 = " = file_";
  protected final String TEXT_37 = ".listFiles(new java.io.FileFilter() {" + NL + "\t                public boolean accept(java.io.File pathname) {" + NL + "\t                    boolean result = false;" + NL + "\t                    if (pathname != null && pathname.isFile()) {                      " + NL + "\t                            result = java.util.regex.Pattern.compile(finalMask_";
  protected final String TEXT_38 = ").matcher(pathname.getName()).find(); " + NL + "\t                    \t}" + NL + "\t                    return result;" + NL + "\t                }" + NL + "\t            });" + NL + "        \t} " + NL + "\t    \tif(listings_";
  protected final String TEXT_39 = " == null || listings_";
  protected final String TEXT_40 = ".length <= 0){" + NL + "\t    \t\tSystem.err.println(\"No match file(\"+key_";
  protected final String TEXT_41 = "+\") exist!\");" + NL + "\t    \t}else{" + NL + "\t    \t\tString localFilePath_";
  protected final String TEXT_42 = " = \"\";" + NL + "\t    \t\tString hdfsFilePath_";
  protected final String TEXT_43 = " = \"\";" + NL + "\t    \t\tfor (int m_";
  protected final String TEXT_44 = " = 0; m_";
  protected final String TEXT_45 = " < listings_";
  protected final String TEXT_46 = ".length; m_";
  protected final String TEXT_47 = "++){ " + NL + "\t     \t\t\tif (listings_";
  protected final String TEXT_48 = "[m_";
  protected final String TEXT_49 = "].getName().matches(mask_";
  protected final String TEXT_50 = ")){    " + NL + "\t     \t\t\t\tlocalFilePath_";
  protected final String TEXT_51 = " = listings_";
  protected final String TEXT_52 = "[m_";
  protected final String TEXT_53 = "].getAbsolutePath();" + NL + "\t\t\t\t\t\thdfsFilePath_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = "+\"/\"+map_";
  protected final String TEXT_56 = ".get(key_";
  protected final String TEXT_57 = "); " + NL + "\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\tfs_";
  protected final String TEXT_58 = ".copyFromLocalFile(false, ";
  protected final String TEXT_59 = ", new org.apache.hadoop.fs.Path(localFilePath_";
  protected final String TEXT_60 = "), new org.apache.hadoop.fs.Path(hdfsFilePath_";
  protected final String TEXT_61 = "));" + NL + "\t\t    \t\t\t\t// add info to list will return" + NL + "\t\t    \t\t\t\tmsg_";
  protected final String TEXT_62 = ".add(\"file: \" + listings_";
  protected final String TEXT_63 = "[m_";
  protected final String TEXT_64 = "].getAbsolutePath() + \", size: \"" + NL + "\t\t                    \t+ listings_";
  protected final String TEXT_65 = "[m_";
  protected final String TEXT_66 = "].length() + \" bytes upload successfully\");" + NL + "\t\t                   " + NL + "\t\t    \t\t\t\tnb_success_";
  protected final String TEXT_67 = "++;" + NL + "\t\t    \t\t\t}catch(java.io.IOException e) {" + NL + "\t\t                \t";
  protected final String TEXT_68 = NL + "            \t\t\t\tthrow(e);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\t\tSystem.err.print(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t                }" + NL + "\t\t\t\t\t\tnb_file_";
  protected final String TEXT_71 = "++;" + NL + "\t      \t\t\t}" + NL + "\t    \t\t}\t" + NL + "\t    \t}" + NL + "\t    }";
  protected final String TEXT_72 = NL;

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
  						      	if(("true").equals(dieOnError)){
							
    stringBuffer.append(TEXT_68);
    
								}else{
							
    stringBuffer.append(TEXT_69);
    	
								} 
						    
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(TEXT_72);
    return stringBuffer.toString();
  }
}

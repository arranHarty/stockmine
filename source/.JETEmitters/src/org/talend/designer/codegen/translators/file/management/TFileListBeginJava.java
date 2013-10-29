package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileListBeginJava
{
  protected static String nl;
  public static synchronized TFileListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileListBeginJava result = new TFileListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  " + NL + "        Comparator<java.io.File> fileNameASC_";
  protected final String TEXT_2 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                return (o1.getName()).compareTo(o2.getName());" + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return -1;" + NL + "            } else if (!bO1IsFile && !bO2IsFile) {" + NL + "                return (o1.getName()).compareTo(o2.getName());" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_3 = NL + "        Comparator<java.io.File> fileNameDESC_";
  protected final String TEXT_4 = " = new Comparator<java.io.File>() {" + NL + "" + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                return (o2.getName()).compareTo(o1.getName());" + NL + "            } else if (bO1IsFile && !bO2IsFile) {" + NL + "                return -1;" + NL + "            } else if (!bO1IsFile && bO2IsFile) {" + NL + "                return 1;" + NL + "            } else if (!bO1IsFile && !bO2IsFile) {" + NL + "                return (o2.getName()).compareTo(o1.getName());" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_5 = NL + "        Comparator<java.io.File> lastModifiedASC_";
  protected final String TEXT_6 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if ((bO1IsFile && bO2IsFile) || (!bO1IsFile && !bO2IsFile)) {" + NL + "                if (o1.lastModified() == o2.lastModified()) {" + NL + "                    return (o1.getName()).compareTo(o2.getName());" + NL + "                } else if (o1.lastModified() > o2.lastModified()) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }" + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return -1;" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_7 = NL + "        Comparator<java.io.File> lastModifiedDESC_";
  protected final String TEXT_8 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if ((bO1IsFile && bO2IsFile) || (!bO1IsFile && !bO2IsFile)) {" + NL + "                if (o1.lastModified() == o2.lastModified()) {" + NL + "                    return (o2.getName()).compareTo(o1.getName());" + NL + "                } else if (o1.lastModified() < o2.lastModified()) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }" + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return -1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return 1;            " + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_9 = NL + "        Comparator<java.io.File> filseSizeASC_";
  protected final String TEXT_10 = " = new Comparator<java.io.File>() {" + NL + "" + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "                      " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                long size_1 = o1.length();" + NL + "                long size_2 = o2.length();                " + NL + "       " + NL + "                if (size_1 == size_2) {" + NL + "                    return (o1.getName()).compareTo(o2.getName());" + NL + "                } else if (size_1 > size_2) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }                " + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return -1;" + NL + "            } else if ((!bO1IsFile) && (!bO2IsFile)){" + NL + "                return (o1.getName()).compareTo(o2.getName());" + NL + "            } else{" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_11 = NL + "        Comparator<java.io.File> filseSizeDESC_";
  protected final String TEXT_12 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                " + NL + "                long size_1 = o1.length();" + NL + "                long size_2 = o2.length();" + NL + "              " + NL + "                if (size_1 == size_2) {" + NL + "                    return (o2.getName()).compareTo(o1.getName());" + NL + "                } else if (size_1 < size_2) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }" + NL + "                " + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return -1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && (!bO2IsFile)){" + NL + "                return (o2.getName()).compareTo(o1.getName());" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_13 = NL + "    \tString fileName_";
  protected final String TEXT_14 = " = file.getName();" + NL + "\t\tfor (final java.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_15 = " : patternList_";
  protected final String TEXT_16 = ") {" + NL + "          \tif (fileNamePattern_";
  protected final String TEXT_17 = ".matcher(fileName_";
  protected final String TEXT_18 = ").matches()){";
  protected final String TEXT_19 = NL + "\t\t\t \t\tboolean isExclude_";
  protected final String TEXT_20 = " = false;" + NL + "\t\t\t        for(java.util.regex.Pattern pattern : excludefileNameEachPattern_";
  protected final String TEXT_21 = ") {" + NL + "\t\t\t        \tif(pattern.matcher(fileName_";
  protected final String TEXT_22 = ").matches()) {" + NL + "\t\t\t        \t\tisExclude_";
  protected final String TEXT_23 = " = true;" + NL + "\t\t\t        \t\tbreak;" + NL + "\t\t\t        \t}" + NL + "\t\t\t        }" + NL + "\t\t\t        if(!isExclude_";
  protected final String TEXT_24 = " && !filePath_";
  protected final String TEXT_25 = ".contains(file.getAbsolutePath())) {" + NL + "\t\t\t          list_";
  protected final String TEXT_26 = ".add(file);" + NL + "\t\t\t          filePath_";
  protected final String TEXT_27 = ".add(file.getAbsolutePath());" + NL + "\t\t\t        }";
  protected final String TEXT_28 = NL + "\t\t\t\t\tif(!filePath_";
  protected final String TEXT_29 = ".contains(file.getAbsolutePath())) {" + NL + "\t\t\t          list_";
  protected final String TEXT_30 = ".add(file);" + NL + "\t\t\t          filePath_";
  protected final String TEXT_31 = ".add(file.getAbsolutePath());" + NL + "\t\t\t        }";
  protected final String TEXT_32 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_33 = "   " + NL + "    " + NL + "  String directory_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "  final java.util.List<String> maskList_";
  protected final String TEXT_36 = " = new java.util.ArrayList<String>();" + NL + "  final java.util.List<java.util.regex.Pattern> patternList_";
  protected final String TEXT_37 = " = new java.util.ArrayList<java.util.regex.Pattern>();";
  protected final String TEXT_38 = NL + "      maskList_";
  protected final String TEXT_39 = ".add(\"*\");";
  protected final String TEXT_40 = NL + "      maskList_";
  protected final String TEXT_41 = ".add(\".*\");";
  protected final String TEXT_42 = " " + NL + "    maskList_";
  protected final String TEXT_43 = ".add(";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = "  " + NL + "  for (final String filemask_";
  protected final String TEXT_46 = " : maskList_";
  protected final String TEXT_47 = ") {" + NL + "\tString filemask_compile_";
  protected final String TEXT_48 = " = filemask_";
  protected final String TEXT_49 = ";" + NL + "\t";
  protected final String TEXT_50 = NL + "\t\tfilemask_compile_";
  protected final String TEXT_51 = " = org.apache.oro.text.GlobCompiler.globToPerl5(filemask_";
  protected final String TEXT_52 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t";
  protected final String TEXT_53 = NL + "\t\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_54 = " = java.util.regex.Pattern.compile(filemask_compile_";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\t\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_57 = " = java.util.regex.Pattern.compile(filemask_compile_";
  protected final String TEXT_58 = ", java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "\t";
  protected final String TEXT_59 = NL + "\tpatternList_";
  protected final String TEXT_60 = ".add(fileNamePattern_";
  protected final String TEXT_61 = ");" + NL + "  }" + NL + "  int NB_FILE";
  protected final String TEXT_62 = " = 0;" + NL + "" + NL + "  final boolean case_sensitive_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";";
  protected final String TEXT_65 = "   " + NL + "      String excludefilemask_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ";" + NL + "\t  final List<java.util.regex.Pattern> excludefileNameEachPattern_";
  protected final String TEXT_68 = " = new java.util.ArrayList<java.util.regex.Pattern>();" + NL + "\t  if(excludefilemask_";
  protected final String TEXT_69 = "!=null && !\"\".equals(excludefilemask_";
  protected final String TEXT_70 = ")) {" + NL + "\t  \tfor(String excludefilemaskEach_";
  protected final String TEXT_71 = " : excludefilemask_";
  protected final String TEXT_72 = ".split(\",\")) {" + NL + "\t  \t ";
  protected final String TEXT_73 = NL + "\t  \t\texcludefilemaskEach_";
  protected final String TEXT_74 = " = org.apache.oro.text.GlobCompiler.globToPerl5(excludefilemaskEach_";
  protected final String TEXT_75 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t  \t ";
  protected final String TEXT_76 = NL + "\t\t\t\texcludefileNameEachPattern_";
  protected final String TEXT_77 = ".add(java.util.regex.Pattern.compile(excludefilemaskEach_";
  protected final String TEXT_78 = ",java.util.regex.Pattern.CASE_INSENSITIVE));" + NL + "\t\t ";
  protected final String TEXT_79 = NL + "\t\t\t\texcludefileNameEachPattern_";
  protected final String TEXT_80 = ".add(java.util.regex.Pattern.compile(excludefilemaskEach_";
  protected final String TEXT_81 = "));" + NL + "\t\t ";
  protected final String TEXT_82 = "\t  \t \t\t" + NL + "\t  \t}" + NL + "\t  }";
  protected final String TEXT_83 = NL + "    final java.util.List<java.io.File> list_";
  protected final String TEXT_84 = " = new java.util.ArrayList<java.io.File>();" + NL + "    final java.util.List<String> filePath_";
  protected final String TEXT_85 = " = new java.util.ArrayList<String>();" + NL + "\tjava.io.File file_";
  protected final String TEXT_86 = " = new java.io.File(directory_";
  protected final String TEXT_87 = ");" + NL + "    ";
  protected final String TEXT_88 = NL + "\t\tfile_";
  protected final String TEXT_89 = ".listFiles(new java.io.FilenameFilter() {" + NL + "\t\t\tpublic boolean accept(java.io.File dir, String name) {" + NL + "\t\t\t\tjava.io.File file = new java.io.File(dir, name);" + NL + "\t\t\t\t";
  protected final String TEXT_90 = NL + "\t                if (!file.isDirectory()) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_91 = NL + "\t                \treturn true;" + NL + "\t                } else {" + NL + "\t                  file.listFiles(this);" + NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_92 = NL + "\t                if (!file.isDirectory()) {" + NL + "\t                  return true;" + NL + "\t                } else {" + NL + "\t                \t";
  protected final String TEXT_93 = NL + "\t                  \tfile.listFiles(this);" + NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t                 ";
  protected final String TEXT_95 = NL + "\t\t            if (file.isDirectory()) {" + NL + "\t\t              file.listFiles(this);" + NL + "\t\t            }" + NL + "\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t);";
  protected final String TEXT_97 = " " + NL + "\t\tfile_";
  protected final String TEXT_98 = ".listFiles(new java.io.FilenameFilter() {" + NL + "\t\t\tpublic boolean accept(java.io.File dir, String name) {" + NL + "\t\t\t\tjava.io.File file = new java.io.File(dir, name);";
  protected final String TEXT_99 = NL + "                if (!file.isDirectory()) {" + NL + "                \t";
  protected final String TEXT_100 = NL + "                }";
  protected final String TEXT_101 = NL + "                if (file.isDirectory()) {" + NL + "                \t";
  protected final String TEXT_102 = NL + "                }";
  protected final String TEXT_103 = NL + "                \t";
  protected final String TEXT_104 = NL + "              return true;" + NL + "            }" + NL + "          }" + NL + "      );";
  protected final String TEXT_105 = " ";
  protected final String TEXT_106 = NL + "      java.util.Collections.sort(list_";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "      java.util.Collections.sort(list_";
  protected final String TEXT_109 = ", fileName";
  protected final String TEXT_110 = "_";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "      java.util.Collections.sort(list_";
  protected final String TEXT_113 = ", filseSize";
  protected final String TEXT_114 = "_";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "      java.util.Collections.sort(list_";
  protected final String TEXT_117 = ", lastModified";
  protected final String TEXT_118 = "_";
  protected final String TEXT_119 = ");";
  protected final String TEXT_120 = NL + "    " + NL + "    for (int i_";
  protected final String TEXT_121 = " = 0; i_";
  protected final String TEXT_122 = " < list_";
  protected final String TEXT_123 = ".size(); i_";
  protected final String TEXT_124 = "++){" + NL + "      java.io.File files_";
  protected final String TEXT_125 = " = list_";
  protected final String TEXT_126 = ".get(i_";
  protected final String TEXT_127 = ");" + NL + "      String fileName_";
  protected final String TEXT_128 = " = files_";
  protected final String TEXT_129 = ".getName();" + NL + "      " + NL + "      String currentFileName_";
  protected final String TEXT_130 = " = files_";
  protected final String TEXT_131 = ".getName(); " + NL + "      String currentFilePath_";
  protected final String TEXT_132 = " = files_";
  protected final String TEXT_133 = ".getAbsolutePath();" + NL + "      String currentFileDirectory_";
  protected final String TEXT_134 = " = files_";
  protected final String TEXT_135 = ".getParent();" + NL + "      String currentFileExtension_";
  protected final String TEXT_136 = " = null;" + NL + "      " + NL + "      if (files_";
  protected final String TEXT_137 = ".getName().contains(\".\") && files_";
  protected final String TEXT_138 = ".isFile()){" + NL + "        currentFileExtension_";
  protected final String TEXT_139 = " = files_";
  protected final String TEXT_140 = ".getName().substring(files_";
  protected final String TEXT_141 = ".getName().lastIndexOf(\".\") + 1);" + NL + "      } else{" + NL + "        currentFileExtension_";
  protected final String TEXT_142 = " = \"\";" + NL + "      }";
  protected final String TEXT_143 = NL + "        currentFilePath_";
  protected final String TEXT_144 = " = currentFilePath_";
  protected final String TEXT_145 = ".replaceAll(\"\\\\\\\\\", \"/\");" + NL + "        currentFileDirectory_";
  protected final String TEXT_146 = " = currentFileDirectory_";
  protected final String TEXT_147 = ".replaceAll(\"\\\\\\\\\", \"/\");";
  protected final String TEXT_148 = NL + "      " + NL + "      NB_FILE";
  protected final String TEXT_149 = " ++;" + NL + "      globalMap.put(\"";
  protected final String TEXT_150 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_151 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_152 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_153 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_154 = "_CURRENT_FILEDIRECTORY\", currentFileDirectory_";
  protected final String TEXT_155 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_156 = "_CURRENT_FILEEXTENSION\", currentFileExtension_";
  protected final String TEXT_157 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_158 = "_NB_FILE\", NB_FILE";
  protected final String TEXT_159 = "); ";
  protected final String TEXT_160 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
  CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  INode node = (INode)codeGenArgument.getArgument();
  String cid = node.getUniqueName();
  boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDSUBDIR__"));
  boolean ifexclude = ("true").equals(ElementParameterParser.getValue(node, "__IFEXCLUDE__"));
  String filelistType = ElementParameterParser.getValue(node, "__LIST_MODE__");
  boolean useGlob = ("true").equals(ElementParameterParser.getValue(node, "__GLOBEXPRESSIONS__"));
  List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
  boolean toSlash = ("true").equals(ElementParameterParser.getValue(node, "__FORMAT_FILEPATH_TO_SLASH__"));
  boolean caseSensitive = ("YES").equals(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__"));
  
  class codeGenerater{
    public void genFileNameOder(String _cid, String _suffix){
      if ("ASC".equals(_suffix)){
      
    stringBuffer.append(TEXT_1);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_2);
    
      } else if ("DESC".equals(_suffix)){
      
    stringBuffer.append(TEXT_3);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_4);
    
      }
    }
    
    public void genLastModifiedOder(String _cid, String _suffix){
      if ("ASC".equals(_suffix)){
      
    stringBuffer.append(TEXT_5);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_6);
    
      } else if ("DESC".equals(_suffix)){
      
    stringBuffer.append(TEXT_7);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_8);
    
      }
    }
    
    public void genFileSizeOder(String _cid, String _suffix){
      if ("ASC".equals(_suffix)){
      
    stringBuffer.append(TEXT_9);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_10);
    
      } else if ("DESC".equals(_suffix)){
      
    stringBuffer.append(TEXT_11);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_12);
    
      }
    }
    public void addFiles(String cid,boolean useGlob,boolean caseSensitive,boolean ifexclude){
    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if (ifexclude){
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }else{
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    
    }
  }  
  
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIRECTORY__") );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
  if (files.size() == 0){
    if (useGlob){
    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
    } else{
    
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
    }
  }
  
  for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    if (useGlob){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
	}
	if (caseSensitive){
	
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
    }else{
    
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
 	}
	
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(caseSensitive );
    stringBuffer.append(TEXT_64);
    
    if (ifexclude){
    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getValue(node, "__EXCLUDEFILEMASK__"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    if (useGlob){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    }
	  	 	if (!caseSensitive){
	  	 
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
			} else {
		 
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
			}
		 
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
    codeGenerater cg = new codeGenerater();
    if (incldSubdir) {
    
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
				if (("FILES").equals(filelistType)) {
				
    stringBuffer.append(TEXT_90);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_91);
    
				} else if(("DIRECTORIES").equals(filelistType)) {
				
    stringBuffer.append(TEXT_92);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_93);
    
				} else if(("BOTH").equals(filelistType)) {
				
    stringBuffer.append(TEXT_94);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_95);
    
				}
				
    stringBuffer.append(TEXT_96);
    
    } else {
    
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
              if (("FILES").equals(filelistType)) {
              
    stringBuffer.append(TEXT_99);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_100);
    
              } else if (("DIRECTORIES").equals(filelistType)) {
              
    stringBuffer.append(TEXT_101);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_102);
    
              } else if (("BOTH").equals(filelistType)) {
              
    stringBuffer.append(TEXT_103);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    
              }
              
    stringBuffer.append(TEXT_104);
    
    }
    
    stringBuffer.append(TEXT_105);
    
    boolean bOrdByDefault = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_NOTHING__"));
    boolean bOrdByFileName = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILENAME__"));
    boolean bOrdByFileSize = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILESIZE__"));
    boolean bOrdByModifiedTime = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_MODIFIEDDATE__"));
    
    boolean bOrdASC = "true".equals(ElementParameterParser.getValue(node, "__ORDER_ACTION_ASC__"));
    //boolean bOrdDESC = "true".equals(ElementParameterParser.getValue(node, "__ORDER_ACTION_DESC__"));
    
    String suffix = bOrdASC ? "ASC" : "DESC";
    
    if (bOrdByDefault){
    
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    
    } else if (bOrdByFileName){
      cg.genFileNameOder(cid, suffix);
      
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(suffix);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
    } else if (bOrdByFileSize){
      cg.genFileSizeOder(cid, suffix);
      
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(suffix);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
    } else if (bOrdByModifiedTime){
      cg.genLastModifiedOder(cid, suffix);
      
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(suffix);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
    }
    
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    if (toSlash){
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    return stringBuffer.toString();
  }
}

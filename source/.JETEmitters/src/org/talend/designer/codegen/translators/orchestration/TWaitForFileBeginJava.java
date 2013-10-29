package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TWaitForFileBeginJava
{
  protected static String nl;
  public static synchronized TWaitForFileBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWaitForFileBeginJava result = new TWaitForFileBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work.\");" + NL + "\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Start to scan the folder '\" + ";
  protected final String TEXT_4 = " + \"'\" + ";
  protected final String TEXT_5 = ");" + NL + "\t\tlog.debug(\"";
  protected final String TEXT_6 = " - Filemask : '\" + ";
  protected final String TEXT_7 = " + \"'.\" + ";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "       " + NL + "        class Util_";
  protected final String TEXT_10 = " {" + NL + "" + NL + "            private boolean flagt = false;" + NL + "" + NL + "            private java.util.regex.Pattern fileNamePatternt = null;" + NL + "        \tprivate java.util.List<String> list;" + NL + "\t\t\tpublic java.util.List<String> getFiles(){" + NL + "\t\t\t\tsetFiles();" + NL + "\t\t\t\treturn list;" + NL + "\t\t\t}";
  protected final String TEXT_11 = NL + "\t\t\tprivate java.util.Map<String, Long> originalTimeMap;" + NL + "\t\t\tprivate java.util.Map<String, String> originalContentMap;" + NL + "\t\t\tprivate boolean initMap = false;" + NL + "\t\t\tpublic Util_";
  protected final String TEXT_12 = "(){" + NL + "\t\t\t}" + NL + "\t\t\tpublic Util_";
  protected final String TEXT_13 = "(boolean iniMap){" + NL + "\t\t\t\tlist = new java.util.ArrayList<String>();" + NL + "\t\t\t\tif(iniMap){" + NL + "\t\t\t\t\tthis.initMap = true;" + NL + "\t\t\t\t\toriginalTimeMap = new java.util.HashMap<String, Long>();" + NL + "\t\t\t\t\toriginalContentMap = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tpublic void addFile(java.io.File file){" + NL + "\t\t\t\tlist.add(file.getPath());" + NL + "\t\t\t\tif(initMap){" + NL + "\t\t\t\t\toriginalTimeMap.put(file.getPath(), file.lastModified());" + NL + "\t\t\t\t\toriginalContentMap.put(file.getPath(),getFileChecksum(file));" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tpublic java.util.Map<String, Long> getTimeMap(){" + NL + "\t\t\t\treturn originalTimeMap;" + NL + "\t\t\t}" + NL + "\t\t\tpublic java.util.Map<String, String> getContentMap(){" + NL + "\t\t\t\treturn originalContentMap;" + NL + "\t\t\t}" + NL + "\t\t\tpublic String getFileChecksum(java.io.File file) {" + NL + "            \tString strMD5 = \"\";" + NL + "            \tjava.security.MessageDigest complete = null;" + NL + "            \tjava.io.InputStream fis = null;" + NL + "            \ttry{" + NL + "                    fis =  new java.io.FileInputStream(file);" + NL + "                    byte[] buffer = new byte[1024];" + NL + "                    complete = java.security.MessageDigest.getInstance(\"MD5\");" + NL + "                    int numRead;" + NL + "                    while((numRead = fis.read(buffer))!= -1){" + NL + "                      \tif (numRead > 0) {" + NL + "                        \tcomplete.update(buffer, 0, numRead);" + NL + "                        }" + NL + "                    }" + NL + "                } catch(java.lang.Exception ex) {" + NL + "                \t";
  protected final String TEXT_14 = NL + "                \t\tlog.warn(\"";
  protected final String TEXT_15 = " - \" + ex.getMessage());" + NL + "                \t";
  protected final String TEXT_16 = NL + "                } finally {" + NL + "                \tif(fis != null) {" + NL + "                \t\ttry {" + NL + "                \t\t\tfis.close();" + NL + "                \t\t} catch(java.lang.Exception ex) {" + NL + "                \t\t";
  protected final String TEXT_17 = NL + "                \t\t\tlog.warn(\"";
  protected final String TEXT_18 = " - \" + ex.getMessage());" + NL + "                \t\t";
  protected final String TEXT_19 = NL + "                \t\t}" + NL + "                \t}" + NL + "                }" + NL + "               \t" + NL + "               \tif(complete != null){" + NL + "        \t\t\tbyte[] b = complete.digest();" + NL + "         \t\t\tfor (int i = 0; i < b.length; i++) {" + NL + "          \t\t\t\tstrMD5 += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );" + NL + "          \t\t\t}" + NL + "      \t\t\t}" + NL + "        \t\treturn strMD5;" + NL + "            }";
  protected final String TEXT_20 = NL + "        \tpublic Util_";
  protected final String TEXT_21 = "(){" + NL + "\t\t\t\tthis.list = new java.util.ArrayList<String>();" + NL + "\t\t\t}" + NL + "\t\t\tpublic void addFile(java.io.File file){" + NL + "\t\t\t\tthis.list.add(file.getPath());" + NL + "\t\t\t}";
  protected final String TEXT_22 = NL + "            void setFiles() {" + NL + "                String directoryt = ";
  protected final String TEXT_23 = ";" + NL + "                String filemaskt = ";
  protected final String TEXT_24 = "+\"$\";" + NL + "" + NL + "                if (filemaskt.indexOf(\"^\") == -1) {" + NL + "                    filemaskt = \"^\" + filemaskt;" + NL + "                }" + NL + "                if (!(filemaskt.lastIndexOf(\".*$\") == -1) && filemaskt.lastIndexOf(\"*.*$\") == -1) {" + NL + "                    filemaskt = filemaskt.substring(0, filemaskt.length() - 3) + \"$\";" + NL + "                    flagt = true;" + NL + "                } else {" + NL + "                    filemaskt = java.util.regex.Pattern.compile(\"[*]\").matcher(filemaskt).replaceAll(\".*\");" + NL + "                }" + NL + "" + NL + "                boolean case_sensitivet = ";
  protected final String TEXT_25 = ";" + NL + "                fileNamePatternt = java.util.regex.Pattern.compile(filemaskt);" + NL + "                if (!case_sensitivet) {" + NL + "                    fileNamePatternt = java.util.regex.Pattern.compile(filemaskt, java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "                }" + NL + "                java.io.File filet = new java.io.File(directoryt);" + NL + "                filet.listFiles(new java.io.FilenameFilter() {" + NL + "" + NL + "                    public boolean accept(java.io.File dir, String name) {" + NL + "                        java.io.File file = new java.io.File(dir, name);" + NL + "                        if (file.isFile()) {" + NL + "                            String fileNamet = name;" + NL + "                            if (flagt == true) {" + NL + "                                if (!(fileNamet.indexOf(\".\") == -1)) {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet.substring(0, fileNamet.indexOf(\".\"))).find()) {" + NL + "                                        addFile(file);" + NL + "" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                        addFile(file);" + NL + "                                    }" + NL + "                                }" + NL + "                            } else {" + NL + "                                if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                    addFile(file);" + NL + "                                }" + NL + "                            }" + NL + "" + NL + "                            return true;" + NL + "                        } ";
  protected final String TEXT_26 = "                          " + NL + "                            else {" + NL + "" + NL + "                                file.listFiles(this);" + NL + "                            }" + NL + "                      ";
  protected final String TEXT_27 = "                        " + NL + "                        return false;" + NL + "                    }" + NL + "" + NL + "                });" + NL + "" + NL + "            }";
  protected final String TEXT_28 = NL + "\t\t\tjava.util.List<java.io.File> getCreatedFiles(java.util.List<String> originalFiles, java.util.List<String> fetchOneTimeFiles) {" + NL + "\t\t\t\tjava.util.List<java.io.File> newCreatedFiles = new java.util.ArrayList<java.io.File>();" + NL + "\t\t\t\tString [] array = originalFiles.toArray(new String[]{});" + NL + "\t\t\t\tfor(String file: fetchOneTimeFiles){" + NL + "\t\t\t\t\tint index = java.util.Arrays.binarySearch(array, file);" + NL + "\t\t\t\t\tif(index<0){" + NL + "\t\t\t\t\t\tnewCreatedFiles.add(new java.io.File(file));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn newCreatedFiles;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "        }" + NL + "            " + NL + "        Util_";
  protected final String TEXT_30 = " util_";
  protected final String TEXT_31 = " = new Util_";
  protected final String TEXT_32 = "(";
  protected final String TEXT_33 = "true";
  protected final String TEXT_34 = ");" + NL + "        java.util.List<String> originalFiles_";
  protected final String TEXT_35 = " = util_";
  protected final String TEXT_36 = ".getFiles();            ";
  protected final String TEXT_37 = NL + "            java.util.Map<String,Long> originalMap_";
  protected final String TEXT_38 = " = util_";
  protected final String TEXT_39 = ".getTimeMap();" + NL + "            java.util.Map<String,String> originalContentMap_";
  protected final String TEXT_40 = " = util_";
  protected final String TEXT_41 = ".getContentMap();";
  protected final String TEXT_42 = NL + "      " + NL + "        int count_";
  protected final String TEXT_43 = " = 0;" + NL + "        ";
  protected final String TEXT_44 = NL + "        String osName_";
  protected final String TEXT_45 = " = System.getProperty(\"os.name\");" + NL + "        boolean isWindows_";
  protected final String TEXT_46 = " = osName_";
  protected final String TEXT_47 = " != null && osName_";
  protected final String TEXT_48 = ".toLowerCase().startsWith(\"win\");";
  protected final String TEXT_49 = NL + "        " + NL + "        while (true) {";
  protected final String TEXT_50 = "                " + NL + "                if (count_";
  protected final String TEXT_51 = " == ";
  protected final String TEXT_52 = " ) {";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_54 = " - The maximum iteration number has been reached. Breaking the loop.\");";
  protected final String TEXT_55 = NL + "                    break;" + NL + "                }";
  protected final String TEXT_56 = "                " + NL + "            boolean found_";
  protected final String TEXT_57 = " = false;";
  protected final String TEXT_58 = "              " + NL + "    \t\t\tif( count_";
  protected final String TEXT_59 = " < originalFiles_";
  protected final String TEXT_60 = ".size()) {" + NL + "                    java.io.File file_";
  protected final String TEXT_61 = " = new java.io.File(originalFiles_";
  protected final String TEXT_62 = ".get(count_";
  protected final String TEXT_63 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_65 = " - File '\" + file_";
  protected final String TEXT_66 = ".getName() + \"' already exists in the listen folders.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_67 = NL + "                    globalMap.put(\"";
  protected final String TEXT_68 = "_FILENAME\", file_";
  protected final String TEXT_69 = ".getName());" + NL + "                    globalMap.put(\"";
  protected final String TEXT_70 = "_PRESENT_FILE\", file_";
  protected final String TEXT_71 = ".getAbsolutePath());" + NL + "                    found_";
  protected final String TEXT_72 = " = true;" + NL + "    \t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_73 = NL + "\t\t\tutil_";
  protected final String TEXT_74 = " = new Util_";
  protected final String TEXT_75 = "(";
  protected final String TEXT_76 = "false";
  protected final String TEXT_77 = ");" + NL + "\t\t\t" + NL + "            java.util.List<String> fetchFilesOneTime_";
  protected final String TEXT_78 = " = util_";
  protected final String TEXT_79 = ".getFiles();" + NL + "            util_";
  protected final String TEXT_80 = " = new Util_";
  protected final String TEXT_81 = "();";
  protected final String TEXT_82 = NL + "\t\t\t\tjava.util.Collections.sort(originalFiles_";
  protected final String TEXT_83 = ");" + NL + "                java.util.List<java.io.File> newCreatedFiles_";
  protected final String TEXT_84 = " = util_";
  protected final String TEXT_85 = ".getCreatedFiles(originalFiles_";
  protected final String TEXT_86 = ",fetchFilesOneTime_";
  protected final String TEXT_87 = ");" + NL + "" + NL + "               \tfor ( int i=0; i< newCreatedFiles_";
  protected final String TEXT_88 = ".size(); i++) {" + NL + "\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_89 = " = newCreatedFiles_";
  protected final String TEXT_90 = ".get(i);" + NL + "           \t\t\t";
  protected final String TEXT_91 = NL + "\t  \t\t\t\tif (isWindows_";
  protected final String TEXT_92 = "){" + NL + "\t  \t\t\t\t\tjava.io.File tempfile_";
  protected final String TEXT_93 = " =new java.io.File(file_";
  protected final String TEXT_94 = ".getAbsolutePath()+\".talendTempfile\"); " + NL + "\t  \t\t\t\t\tThread.sleep(";
  protected final String TEXT_95 = ");" + NL + "\t  \t\t\t\t\tif(file_";
  protected final String TEXT_96 = ".renameTo(tempfile_";
  protected final String TEXT_97 = ")) {" + NL + "\t  \t\t\t\t\t\ttempfile_";
  protected final String TEXT_98 = ".renameTo(file_";
  protected final String TEXT_99 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t  \t\t\t\t} else { " + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_100 = " = file_";
  protected final String TEXT_101 = ".lastModified();" + NL + "\t" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_102 = ");" + NL + "\t" + NL + "\t                \tif(file_";
  protected final String TEXT_103 = ".lastModified() != timestamp_";
  protected final String TEXT_104 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t                }" + NL + "            \t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_107 = " - File '\" + file_";
  protected final String TEXT_108 = ".getName() + \"' has been created.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_109 = NL + "                    globalMap.put(\"";
  protected final String TEXT_110 = "_FILENAME\", file_";
  protected final String TEXT_111 = ".getName());" + NL + "                    globalMap.put(\"";
  protected final String TEXT_112 = "_CREATED_FILE\", file_";
  protected final String TEXT_113 = ".getAbsolutePath());" + NL + "                    found_";
  protected final String TEXT_114 = " = true;" + NL + "                    originalFiles_";
  protected final String TEXT_115 = ".add(file_";
  protected final String TEXT_116 = ".getPath());              " + NL + "                    break;" + NL + "            \t}" + NL + "\t\t\t";
  protected final String TEXT_117 = NL + "            \tjava.util.Collections.sort(fetchFilesOneTime_";
  protected final String TEXT_118 = ");" + NL + "            \tString [] arrayFetchFilesOneTime_";
  protected final String TEXT_119 = " = fetchFilesOneTime_";
  protected final String TEXT_120 = ".toArray(new String[]{});" + NL + "            \tfor(String str_";
  protected final String TEXT_121 = " : originalFiles_";
  protected final String TEXT_122 = ") {" + NL + "            \t\tint index_delete_";
  protected final String TEXT_123 = " = java.util.Arrays.binarySearch(arrayFetchFilesOneTime_";
  protected final String TEXT_124 = ",str_";
  protected final String TEXT_125 = ");" + NL + "                    if(index_delete_";
  protected final String TEXT_126 = " < 0) {" + NL + "\t            \t\tjava.io.File file_";
  protected final String TEXT_127 = " = new java.io.File(str_";
  protected final String TEXT_128 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_130 = " - File '\" + file_";
  protected final String TEXT_131 = ".getName() + \"' has been deleted.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_132 = NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_133 = "_FILENAME\", file_";
  protected final String TEXT_134 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_135 = "_DELETED_FILE\", file_";
  protected final String TEXT_136 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_137 = " = true;  " + NL + "                        originalFiles_";
  protected final String TEXT_138 = ".remove(str_";
  protected final String TEXT_139 = ");                  " + NL + "                        break;" + NL + "                    }" + NL + "                }";
  protected final String TEXT_140 = NL + "                for(String str_";
  protected final String TEXT_141 = " : fetchFilesOneTime_";
  protected final String TEXT_142 = ") {" + NL + "                \tjava.io.File file_";
  protected final String TEXT_143 = " = new java.io.File(str_";
  protected final String TEXT_144 = ");" + NL + "                \t" + NL + "            \t";
  protected final String TEXT_145 = NL + "\t\t\t\t\tif (isWindows_";
  protected final String TEXT_146 = "){" + NL + "\t\t\t\t\t\tjava.io.File tempfile_";
  protected final String TEXT_147 = " =new java.io.File(file_";
  protected final String TEXT_148 = ".getAbsolutePath()+\".talendTempfile\");" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_149 = ");" + NL + "\t\t\t\t\t\tif(file_";
  protected final String TEXT_150 = ".renameTo(tempfile_";
  protected final String TEXT_151 = ")) {" + NL + "\t  \t\t\t\t\t\ttempfile_";
  protected final String TEXT_152 = ".renameTo(file_";
  protected final String TEXT_153 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_154 = " = file_";
  protected final String TEXT_155 = ".lastModified();" + NL + "\t" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_156 = ");" + NL + "\t" + NL + "\t                \tif(file_";
  protected final String TEXT_157 = ".lastModified() != timestamp_";
  protected final String TEXT_158 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_159 = NL + "\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\t\tif(originalMap_";
  protected final String TEXT_161 = ".get(str_";
  protected final String TEXT_162 = ")==null ){" + NL + "                    \toriginalMap_";
  protected final String TEXT_163 = ".put(str_";
  protected final String TEXT_164 = ",file_";
  protected final String TEXT_165 = ".lastModified());" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_166 = ".put(str_";
  protected final String TEXT_167 = ",util_";
  protected final String TEXT_168 = ".getFileChecksum(file_";
  protected final String TEXT_169 = "));" + NL + "\t\t\t\t\t} else if(originalMap_";
  protected final String TEXT_170 = ".get(str_";
  protected final String TEXT_171 = ")!=file_";
  protected final String TEXT_172 = ".lastModified()) {" + NL + "                        originalMap_";
  protected final String TEXT_173 = ".put(str_";
  protected final String TEXT_174 = ",file_";
  protected final String TEXT_175 = ".lastModified());" + NL + "                        String fileMD5_";
  protected final String TEXT_176 = " = util_";
  protected final String TEXT_177 = ".getFileChecksum(file_";
  protected final String TEXT_178 = ");" + NL + "\t\t\t\t\t\tif(!fileMD5_";
  protected final String TEXT_179 = ".equals(originalContentMap_";
  protected final String TEXT_180 = ".get(str_";
  protected final String TEXT_181 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_183 = " - File '\" + file_";
  protected final String TEXT_184 = ".getName() + \"' has been updated.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_185 = NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_186 = "_FILENAME\", file_";
  protected final String TEXT_187 = ".getName());" + NL + "\t                        globalMap.put(\"";
  protected final String TEXT_188 = "_UPDATED_FILE\", file_";
  protected final String TEXT_189 = ".getAbsolutePath());" + NL + "\t                       \tfound_";
  protected final String TEXT_190 = " = true;" + NL + "\t                        originalContentMap_";
  protected final String TEXT_191 = ".put(str_";
  protected final String TEXT_192 = ",fileMD5_";
  protected final String TEXT_193 = ");" + NL + "\t                        break;" + NL + "\t\t\t\t\t\t}" + NL + "                    }" + NL + "            \t";
  protected final String TEXT_194 = NL + "\t\t\t\t\tif(originalMap_";
  protected final String TEXT_195 = ".get(str_";
  protected final String TEXT_196 = ")==null ){" + NL + "                    \toriginalMap_";
  protected final String TEXT_197 = ".put(str_";
  protected final String TEXT_198 = ",file_";
  protected final String TEXT_199 = ".lastModified());" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_200 = ".put(str_";
  protected final String TEXT_201 = ",util_";
  protected final String TEXT_202 = ".getFileChecksum(file_";
  protected final String TEXT_203 = "));" + NL + "\t\t\t\t\t} else if(originalMap_";
  protected final String TEXT_204 = ".get(str_";
  protected final String TEXT_205 = ")!=file_";
  protected final String TEXT_206 = ".lastModified()) {" + NL + "            \t\t\toriginalMap_";
  protected final String TEXT_207 = ".put(str_";
  protected final String TEXT_208 = ",file_";
  protected final String TEXT_209 = ".lastModified());" + NL + "\t            \t\tString fileMD5_";
  protected final String TEXT_210 = " = util_";
  protected final String TEXT_211 = ".getFileChecksum(file_";
  protected final String TEXT_212 = ");" + NL + "            \t\t\tif(!fileMD5_";
  protected final String TEXT_213 = ".equals(originalContentMap_";
  protected final String TEXT_214 = ".get(str_";
  protected final String TEXT_215 = "))){" + NL + "\t\t\t\t\t\t\toriginalContentMap_";
  protected final String TEXT_216 = ".put(str_";
  protected final String TEXT_217 = ",fileMD5_";
  protected final String TEXT_218 = ");" + NL + "\t            \t\t\tglobalMap.put(\"";
  protected final String TEXT_219 = "_NOT_UPDATED_FILE\", null);" + NL + "\t            \t\t\tfound_";
  protected final String TEXT_220 = " = false;" + NL + "            \t\t\t}else{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_222 = " - File '\" + file_";
  protected final String TEXT_223 = ".getName() + \"' has been updated.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_224 = NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_225 = "_FILENAME\", file_";
  protected final String TEXT_226 = ".getName());" + NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_227 = "_NOT_UPDATED_FILE\", file_";
  protected final String TEXT_228 = ".getAbsolutePath());" + NL + "\t                    \tfound_";
  protected final String TEXT_229 = " = true;" + NL + "\t                    \tbreak;" + NL + "                    \t}" + NL + "                   \t}else{                   " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_231 = " - File '\" + file_";
  protected final String TEXT_232 = ".getName() + \"' has been updated.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_233 = NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_234 = "_FILENAME\", file_";
  protected final String TEXT_235 = ".getName());" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_236 = "_NOT_UPDATED_FILE\", file_";
  protected final String TEXT_237 = ".getAbsolutePath());" + NL + "                    \tfound_";
  protected final String TEXT_238 = " = true;" + NL + "                    \tbreak;" + NL + "                    }";
  protected final String TEXT_239 = NL + "                }    " + NL + "                ";
  protected final String TEXT_240 = NL + "                java.util.Collections.sort(originalFiles_";
  protected final String TEXT_241 = ");" + NL + "                java.util.Collections.sort(fetchFilesOneTime_";
  protected final String TEXT_242 = ");" + NL + "                String [] arrayFetchFilesOneTime_";
  protected final String TEXT_243 = " = fetchFilesOneTime_";
  protected final String TEXT_244 = ".toArray(new String[]{});" + NL + "                for(String str_";
  protected final String TEXT_245 = " : originalFiles_";
  protected final String TEXT_246 = ") {" + NL + "                \tint index_fileall_";
  protected final String TEXT_247 = " = java.util.Arrays.binarySearch(arrayFetchFilesOneTime_";
  protected final String TEXT_248 = ",str_";
  protected final String TEXT_249 = ");" + NL + "                    if(index_fileall_";
  protected final String TEXT_250 = " < 0 ) {" + NL + "\t                \tjava.io.File file_";
  protected final String TEXT_251 = " = new java.io.File(str_";
  protected final String TEXT_252 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_253 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_254 = " - File '\" + file_";
  protected final String TEXT_255 = ".getName() + \"' has been deleted.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_256 = NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_257 = "_FILENAME\", file_";
  protected final String TEXT_258 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_259 = "_DELETED_FILE\", file_";
  protected final String TEXT_260 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_261 = " = true;" + NL + "                        originalFiles_";
  protected final String TEXT_262 = ".remove(str_";
  protected final String TEXT_263 = ");" + NL + "                        originalMap_";
  protected final String TEXT_264 = ".remove(str_";
  protected final String TEXT_265 = ");" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_266 = ".remove(str_";
  protected final String TEXT_267 = ");" + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "                java.util.List<java.io.File> newCreatedFiles_";
  protected final String TEXT_268 = " = util_";
  protected final String TEXT_269 = ".getCreatedFiles(originalFiles_";
  protected final String TEXT_270 = ",fetchFilesOneTime_";
  protected final String TEXT_271 = ");" + NL + "                for ( int i=0; i< newCreatedFiles_";
  protected final String TEXT_272 = ".size(); i++) {" + NL + "\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_273 = " = newCreatedFiles_";
  protected final String TEXT_274 = ".get(i);" + NL + "           \t\t\t";
  protected final String TEXT_275 = NL + "\t  \t\t\t\tif (isWindows_";
  protected final String TEXT_276 = "){" + NL + "\t  \t\t\t\t\tjava.io.File tempfile=new java.io.File(file_";
  protected final String TEXT_277 = ".getAbsolutePath()+\".talendTempfile\"); " + NL + "\t  \t\t\t\t\tThread.sleep(";
  protected final String TEXT_278 = ");" + NL + "\t  \t\t\t\t\tif(file_";
  protected final String TEXT_279 = ".renameTo(tempfile)) {" + NL + "\t  \t\t\t\t\t\ttempfile.renameTo(file_";
  protected final String TEXT_280 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t  \t\t\t\t} else { " + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_281 = " = file_";
  protected final String TEXT_282 = ".lastModified();" + NL + "\t" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_283 = ");" + NL + "\t" + NL + "\t                \tif(file_";
  protected final String TEXT_284 = ".lastModified() != timestamp_";
  protected final String TEXT_285 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t                }";
  protected final String TEXT_286 = NL + "\t\t\t\t\t";
  protected final String TEXT_287 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_288 = " - File '\" + file_";
  protected final String TEXT_289 = ".getName() + \"' has been created.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_290 = NL + "                    globalMap.put(\"";
  protected final String TEXT_291 = "_FILENAME\", file_";
  protected final String TEXT_292 = ".getName());" + NL + "                    globalMap.put(\"";
  protected final String TEXT_293 = "_CREATED_FILE\", file_";
  protected final String TEXT_294 = ".getAbsolutePath());" + NL + "                    found_";
  protected final String TEXT_295 = " = true;" + NL + "                    originalFiles_";
  protected final String TEXT_296 = ".add(file_";
  protected final String TEXT_297 = ".getPath());           " + NL + "                    originalMap_";
  protected final String TEXT_298 = ".put(file_";
  protected final String TEXT_299 = ".getPath(),file_";
  protected final String TEXT_300 = ".lastModified());" + NL + "                    originalContentMap_";
  protected final String TEXT_301 = ".put(file_";
  protected final String TEXT_302 = ".getPath(),util_";
  protected final String TEXT_303 = ".getFileChecksum(file_";
  protected final String TEXT_304 = "));" + NL + "                    break;" + NL + "\t\t\t\t}" + NL + "                for(String str_";
  protected final String TEXT_305 = " : fetchFilesOneTime_";
  protected final String TEXT_306 = ") {" + NL + "                \tjava.io.File file_";
  protected final String TEXT_307 = " = new java.io.File(str_";
  protected final String TEXT_308 = ");" + NL + "                \t" + NL + "\t\t\t\t\t";
  protected final String TEXT_309 = NL + "\t\t\t\t\tif (isWindows_";
  protected final String TEXT_310 = "){" + NL + "\t\t\t\t\t\tjava.io.File tempfile_";
  protected final String TEXT_311 = " =new java.io.File(file_";
  protected final String TEXT_312 = ".getAbsolutePath()+\".talendTempfile\");" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_313 = ");" + NL + "\t\t\t\t\t\tif(file_";
  protected final String TEXT_314 = ".renameTo(tempfile_";
  protected final String TEXT_315 = ")) {" + NL + "\t  \t\t\t\t\t\ttempfile_";
  protected final String TEXT_316 = ".renameTo(file_";
  protected final String TEXT_317 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_318 = " = file_";
  protected final String TEXT_319 = ".lastModified();" + NL + "\t" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_320 = ");" + NL + "\t" + NL + "\t                \tif(file_";
  protected final String TEXT_321 = ".lastModified() != timestamp_";
  protected final String TEXT_322 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_323 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(originalMap_";
  protected final String TEXT_324 = ".get(str_";
  protected final String TEXT_325 = ")==null ){" + NL + "                    \toriginalMap_";
  protected final String TEXT_326 = ".put(str_";
  protected final String TEXT_327 = ",file_";
  protected final String TEXT_328 = ".lastModified());" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_329 = ".put(str_";
  protected final String TEXT_330 = ",util_";
  protected final String TEXT_331 = ".getFileChecksum(file_";
  protected final String TEXT_332 = "));" + NL + "\t\t\t\t\t} else if(originalMap_";
  protected final String TEXT_333 = ".get(str_";
  protected final String TEXT_334 = ")!=file_";
  protected final String TEXT_335 = ".lastModified()) {" + NL + "                        originalMap_";
  protected final String TEXT_336 = ".put(str_";
  protected final String TEXT_337 = ",file_";
  protected final String TEXT_338 = ".lastModified());//occur repeat value              " + NL + "                        String fileMD5_";
  protected final String TEXT_339 = " = util_";
  protected final String TEXT_340 = ".getFileChecksum(file_";
  protected final String TEXT_341 = ");" + NL + "                        if(!fileMD5_";
  protected final String TEXT_342 = ".equals(originalContentMap_";
  protected final String TEXT_343 = ".get(str_";
  protected final String TEXT_344 = "))){" + NL + "                        \toriginalContentMap_";
  protected final String TEXT_345 = ".put(str_";
  protected final String TEXT_346 = ",fileMD5_";
  protected final String TEXT_347 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_348 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_349 = " - File '\" + file_";
  protected final String TEXT_350 = ".getName() + \"' has been updated.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_351 = NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_352 = "_FILENAME\", file_";
  protected final String TEXT_353 = ".getName());" + NL + "\t                        globalMap.put(\"";
  protected final String TEXT_354 = "_UPDATED_FILE\", file_";
  protected final String TEXT_355 = ".getAbsolutePath());" + NL + "\t                        found_";
  protected final String TEXT_356 = " = true;" + NL + "\t                        break;" + NL + "                        }" + NL + "                    }" + NL + "                }               ";
  protected final String TEXT_357 = NL;
  protected final String TEXT_358 = "   " + NL + "                }";
  protected final String TEXT_359 = NL + "            count_";
  protected final String TEXT_360 = "++;" + NL + "            " + NL + "            globalMap.put(\"";
  protected final String TEXT_361 = "_CURRENT_ITERATION\", count_";
  protected final String TEXT_362 = ");" + NL + "            " + NL + "            if (!found_";
  protected final String TEXT_363 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_364 = NL + "\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_365 = " - Nothing appened. Waiting for ";
  protected final String TEXT_366 = " seconds and continue to loop.\");" + NL + "\t\t\t\t";
  protected final String TEXT_367 = NL + "            \tThread.sleep(";
  protected final String TEXT_368 = " * 1000);" + NL + "                continue;" + NL + "            }            " + NL;
  protected final String TEXT_369 = "\t" + NL + "\t\t";
  protected final String TEXT_370 = ".";
  protected final String TEXT_371 = " = ((";
  protected final String TEXT_372 = ")globalMap.get(\"";
  protected final String TEXT_373 = "_";
  protected final String TEXT_374 = "\"));";
  protected final String TEXT_375 = "            ";
  protected final String TEXT_376 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDE_SUBDIR__"));
    boolean present = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDE_PRESENT__"));
    String triggerAction = ElementParameterParser.getValue(node, "__ACTION_ON__");
    boolean waitRelease = ("true").equals(ElementParameterParser.getValue(node, "__WAIT_RELEASE__"));
    boolean nonUpdate = "true".equals(ElementParameterParser.getValue(node, "__NON_UPDATE__"));
    String interval = ElementParameterParser.getValue(node, "__INTERVAL_CHECK__");
	String directoryToScan = ElementParameterParser.getValue(node, "__DIRECTORY__");
	String usedFileMask = ElementParameterParser.getValue(node, "__FILEMASK__");
	boolean isCaseSensitive = "true".equals(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__"));
	
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    if(isLog4jEnabled){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(directoryToScan);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(incldSubdir?"\" including subdirectories.\"":"\".\"");
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(usedFileMask);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(isCaseSensitive?"\" The filemask is case sensitive.\"":"\"\"");
    stringBuffer.append(TEXT_8);
    
	}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
        if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    
        }else{
        
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
        }
        
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIRECTORY__") );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILEMASK__"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__") );
    stringBuffer.append(TEXT_25);
    
                        if(incldSubdir==true)  {
                            
    stringBuffer.append(TEXT_26);
    
                        }   
                        
    stringBuffer.append(TEXT_27);
    
			if(("filecreated").equals(triggerAction) || ("fileall").equals(triggerAction)) {

    stringBuffer.append(TEXT_28);
    
			}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
        if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
        }
        
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    if(waitRelease) {
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
    stringBuffer.append(TEXT_49);
    
            if(!("").equals(ElementParameterParser.getValue(node,"__MAX_ITERATIONS__"))){
                
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAX_ITERATIONS__") );
    stringBuffer.append(TEXT_52);
    
					if(isLog4jEnabled){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
					}

    stringBuffer.append(TEXT_55);
    
            } 
            
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    
            if(present){
                
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    }
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
    
    			}
			
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
            if(("filecreated").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    	
   					//fix bug 22123,if we can rename the filename,that means no other program is using the file.
           			if(waitRelease){
           			
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
            		}
            		
    stringBuffer.append(TEXT_105);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    
            } else if(("filedeleted").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
            } else if(("fileupdated").equals(triggerAction)) {
                
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    if(waitRelease) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    if(!nonUpdate){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    }else{
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    }
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    }
    stringBuffer.append(TEXT_239);
    
            } else if(("fileall").equals(triggerAction)) {
                
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    }
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    	
   					//fix bug 22123,if we can rename the filename,that means no other program is using the file.
           			if(waitRelease) {
           			
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
        	    	}
            		
    stringBuffer.append(TEXT_286);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    if(waitRelease) {
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    }
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    }
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    
            }
            
    stringBuffer.append(TEXT_357);
    
            if(present) {
                
    stringBuffer.append(TEXT_358);
    
            }
            
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WAIT__"));
    stringBuffer.append(TEXT_366);
    }
    stringBuffer.append(TEXT_367);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WAIT__"));
    stringBuffer.append(TEXT_368);
    	
	//*************************************************************//	
	//The following part will extract data from globalMap to schema in order to support the MAIN link simply.
	//step 1:
	
	IConnection firstDataConn = null;
	List<IMetadataColumn> firstColumnList = null;

	//1. get first DATA Link
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();	
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				firstDataConn = conn;
				break;
			}
		}
	}

	//2. get first columnList (with real columns data) 	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ( metadatas != null && metadatas.size() > 0 ) {
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			firstColumnList = metadata.getListColumns(); 
			if ( firstColumnList == null || firstColumnList.size() == 0 ) {
				firstColumnList = null;
			}
		}
	}
	
	//3. check the config Link and Schema
	if(firstDataConn != null && firstColumnList != null)
	{
    	//step 2:
    
        String firstDataConnName = firstDataConn.getName();
        for (IMetadataColumn column: firstColumnList) {
        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

    stringBuffer.append(TEXT_369);
    stringBuffer.append(firstDataConnName );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_374);
    
	    }
 	}

    stringBuffer.append(TEXT_375);
    stringBuffer.append(TEXT_376);
    return stringBuffer.toString();
  }
}

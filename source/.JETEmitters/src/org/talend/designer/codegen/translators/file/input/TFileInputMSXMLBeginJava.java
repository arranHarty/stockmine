package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputMSXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileInputMSXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputMSXMLBeginJava result = new TFileInputMSXMLBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "class NameSpaceTool_";
  protected final String TEXT_5 = " {" + NL + "" + NL + "    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "    public void countNSMap(org.dom4j.Element el) {" + NL + "        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "            if (ns.getPrefix().trim().length() == 0) {" + NL + "                xmlNameSpaceMap.put(\"pre\"+defualtNSPath.size(), ns.getURI());" + NL + "                String path = \"\";" + NL + "                org.dom4j.Element elTmp = el;" + NL + "                while (elTmp != null) {" + NL + "                \tif (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                        path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                    } else {" + NL + "                        path = \"/\" + elTmp.getName() + path;" + NL + "                    }" + NL + "                    elTmp = elTmp.getParent();" + NL + "                }" + NL + "                defualtNSPath.add(path);" + NL + "            } else {" + NL + "                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "            }" + NL + "" + NL + "        }" + NL + "        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "            countNSMap(e);" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    public String addDefaultNSPrefix(String path, String loopPath) {" + NL + "        if (defualtNSPath.size() > 0) {" + NL + "        \tString fullPath = loopPath;" + NL + "        \tif(!path.equals(fullPath)){" + NL + "            \tfor (String tmp : path.split(\"/\")) {" + NL + "            \t\tif ((\"..\").equals(tmp)) {" + NL + "                        fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                    } else {" + NL + "                        fullPath += \"/\" + tmp;" + NL + "                    }" + NL + "            \t}" + NL + "            }" + NL + "        \tint[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "            java.util.Arrays.fill(indexs, -1);" + NL + "            int length = 0;" + NL + "            for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "                if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                    java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                    length = defualtNSPath.get(i).length();" + NL + "                }" + NL + "            }" + NL + "" + NL + "            StringBuilder newPath = new StringBuilder();" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }" + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "    " + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_6 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}";
  protected final String TEXT_7 = NL + "class IgnoreDTDEntityResolver_";
  protected final String TEXT_8 = " implements org.xml.sax.EntityResolver {" + NL + "" + NL + " public org.xml.sax.InputSource resolveEntity(String publicId, String systemId)" + NL + "   throws org.xml.sax.SAXException, java.io.IOException {" + NL + "        return new org.xml.sax.InputSource(new java.io.ByteArrayInputStream(\"<?xml version='1.0' encoding='UTF-8'?>\".getBytes()));" + NL + " }" + NL + "" + NL + "}";
  protected final String TEXT_9 = NL + "String rootpath_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";" + NL + "if(rootpath_";
  protected final String TEXT_12 = ".endsWith(\"/\")){" + NL + "\trootpath_";
  protected final String TEXT_13 = " = rootpath_";
  protected final String TEXT_14 = ".substring(0,rootpath_";
  protected final String TEXT_15 = ".length()-1);" + NL + "}" + NL + NL;
  protected final String TEXT_16 = NL + "\tString query_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "\tif(query_";
  protected final String TEXT_19 = ".startsWith(\"/\")){" + NL + "\t\tquery_";
  protected final String TEXT_20 = " = query_";
  protected final String TEXT_21 = ".substring(1);" + NL + "\t}" + NL + "\tString subLoop_";
  protected final String TEXT_22 = " = rootpath_";
  protected final String TEXT_23 = " + \"/\" + query_";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + NL + "org.dom4j.io.SAXReader reader_";
  protected final String TEXT_26 = " = new org.dom4j.io.SAXReader();";
  protected final String TEXT_27 = NL + "reader_";
  protected final String TEXT_28 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_29 = "());";
  protected final String TEXT_30 = NL + "org.dom4j.Document doc_";
  protected final String TEXT_31 = "= reader_";
  protected final String TEXT_32 = ".read(new java.io.File(";
  protected final String TEXT_33 = ").toURI().toString());" + NL + "" + NL + "NameSpaceTool_";
  protected final String TEXT_34 = " nsTool_";
  protected final String TEXT_35 = " = new NameSpaceTool_";
  protected final String TEXT_36 = "();" + NL + "nsTool_";
  protected final String TEXT_37 = ".countNSMap(doc_";
  protected final String TEXT_38 = ".getRootElement());" + NL + "java.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_39 = " = nsTool_";
  protected final String TEXT_40 = ".xmlNameSpaceMap;  " + NL + "" + NL + "org.dom4j.XPath x_";
  protected final String TEXT_41 = " = doc_";
  protected final String TEXT_42 = ".createXPath(nsTool_";
  protected final String TEXT_43 = ".addDefaultNSPrefix(rootpath_";
  protected final String TEXT_44 = ",rootpath_";
  protected final String TEXT_45 = "));  " + NL + "x_";
  protected final String TEXT_46 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_47 = ");" + NL + "" + NL + "java.util.List<org.dom4j.Element> nodeList_";
  protected final String TEXT_48 = " = (java.util.List<org.dom4j.Element>)x_";
  protected final String TEXT_49 = ".selectNodes(doc_";
  protected final String TEXT_50 = ");\t" + NL + "XML_API_";
  protected final String TEXT_51 = " xml_api_";
  protected final String TEXT_52 = " = new XML_API_";
  protected final String TEXT_53 = "();" + NL + "String str_";
  protected final String TEXT_54 = " = \"\";" + NL + "org.dom4j.Node node_";
  protected final String TEXT_55 = " = null;" + NL + "boolean isSingleNode_";
  protected final String TEXT_56 = " = true;" + NL + "Object obj_";
  protected final String TEXT_57 = " = null;" + NL + "" + NL + "for (org.dom4j.Element loop_";
  protected final String TEXT_58 = ": nodeList_";
  protected final String TEXT_59 = ") {" + NL;
  protected final String TEXT_60 = NL + "\tjava.util.Iterator<org.dom4j.Element> it_";
  protected final String TEXT_61 = " = loop_";
  protected final String TEXT_62 = ".elementIterator();" + NL + "\t" + NL + "\twhile(it_";
  protected final String TEXT_63 = ".hasNext()){" + NL + "\t\tnb_line_";
  protected final String TEXT_64 = "++;" + NL + "\t\torg.dom4j.Element temp_";
  protected final String TEXT_65 = " = it_";
  protected final String TEXT_66 = ".next();";
  protected final String TEXT_67 = NL + "\tjava.util.List<java.util.Map<String,org.dom4j.Element>> resultList_";
  protected final String TEXT_68 = " = new java.util.ArrayList<java.util.Map<String,org.dom4j.Element>>();";
  protected final String TEXT_69 = NL + "\torg.dom4j.XPath groupPath_";
  protected final String TEXT_70 = " = loop_";
  protected final String TEXT_71 = ".createXPath(nsTool_";
  protected final String TEXT_72 = ".addDefaultNSPrefix(query_";
  protected final String TEXT_73 = ",rootpath_";
  protected final String TEXT_74 = "));" + NL + "\tgroupPath_";
  protected final String TEXT_75 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_76 = ");" + NL + "\tjava.util.List<org.dom4j.Element> groupList_";
  protected final String TEXT_77 = " = (java.util.List<org.dom4j.Element>)groupPath_";
  protected final String TEXT_78 = ".selectNodes(loop_";
  protected final String TEXT_79 = ");" + NL + "\tif(groupList_";
  protected final String TEXT_80 = "!=null && groupList_";
  protected final String TEXT_81 = ".size()>0){" + NL + "\t\tfor(org.dom4j.Element ele_";
  protected final String TEXT_82 = " : groupList_";
  protected final String TEXT_83 = "){" + NL + "\t\t\tjava.util.Map<String, org.dom4j.Element> map = new java.util.HashMap<String,org.dom4j.Element>();" + NL + "\t\t\tmap.put(\"";
  protected final String TEXT_84 = "\", ele_";
  protected final String TEXT_85 = ");" + NL + "\t\t\tresultList_";
  protected final String TEXT_86 = ".add(map);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_87 = NL + "\tfor(java.util.Map<String,org.dom4j.Element> tempMap_";
  protected final String TEXT_88 = " : resultList_";
  protected final String TEXT_89 = " ){";
  protected final String TEXT_90 = NL + "class XML_API_";
  protected final String TEXT_91 = "{" + NL + "\tpublic boolean isDefNull(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0] != null && node[1]!=null && (\"true\").equals(node[1])){" + NL + "        \treturn true;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        return node[0] == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0]!=null ){" + NL + "        \treturn node[0].length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL + "XML_API_";
  protected final String TEXT_92 = " xml_api_";
  protected final String TEXT_93 = " = new XML_API_";
  protected final String TEXT_94 = "();" + NL;
  protected final String TEXT_95 = NL + NL + "String[] arrLoop_";
  protected final String TEXT_96 = " = new String[]{";
  protected final String TEXT_97 = "};" + NL + "String[][] arrQuery_";
  protected final String TEXT_98 = " =new String[][]{";
  protected final String TEXT_99 = "};" + NL + "String str_";
  protected final String TEXT_100 = " = \"\";" + NL + "String[] node_";
  protected final String TEXT_101 = " = null;" + NL + "boolean isSingleNode_";
  protected final String TEXT_102 = " = true;" + NL + "org.talend.xml.sax.SAXLooper looper_";
  protected final String TEXT_103 = " = new org.talend.xml.sax.SAXLooper(";
  protected final String TEXT_104 = ",arrLoop_";
  protected final String TEXT_105 = ",arrQuery_";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "looper_";
  protected final String TEXT_108 = ".setIgnoreDTD(true);";
  protected final String TEXT_109 = NL + "looper_";
  protected final String TEXT_110 = ".setEncoding(";
  protected final String TEXT_111 = ");" + NL + "looper_";
  protected final String TEXT_112 = ".parse(";
  protected final String TEXT_113 = ");" + NL + "\tjava.util.Iterator<java.util.Map<String, java.util.Map<String,String>>> it_";
  protected final String TEXT_114 = "  = looper_";
  protected final String TEXT_115 = ".multiIterator();" + NL + "\twhile (it_";
  protected final String TEXT_116 = ".hasNext()) {" + NL + "\t" + NL + "\t\tnb_line_";
  protected final String TEXT_117 = "++;" + NL + "\t\t" + NL + "\t\tjava.util.Map<String, java.util.Map<String,String>> tmp_";
  protected final String TEXT_118 = " = it_";
  protected final String TEXT_119 = ".next();";
  protected final String TEXT_120 = NL + NL + "\t\ttry{";
  protected final String TEXT_121 = NL + "\t";
  protected final String TEXT_122 = " = null;";
  protected final String TEXT_123 = NL + "\tString tmp_";
  protected final String TEXT_124 = " = temp_";
  protected final String TEXT_125 = ".getName();" + NL + "\tif(temp_";
  protected final String TEXT_126 = ".getNamespacePrefix() !=null &&" + NL + "\t\t\t!temp_";
  protected final String TEXT_127 = ".getNamespacePrefix().equals(\"\")){" + NL + "\t\ttmp_";
  protected final String TEXT_128 = " = temp_";
  protected final String TEXT_129 = ".getNamespacePrefix() + \":\" + tmp_";
  protected final String TEXT_130 = ";" + NL + "\t}" + NL + "\tif(tmp_";
  protected final String TEXT_131 = ".equals(query_";
  protected final String TEXT_132 = ")){";
  protected final String TEXT_133 = NL + "\tif(tempMap_";
  protected final String TEXT_134 = ".get(\"";
  protected final String TEXT_135 = "\") != null){" + NL + "\t\torg.dom4j.Element temp_";
  protected final String TEXT_136 = " = tempMap_";
  protected final String TEXT_137 = ".get(\"";
  protected final String TEXT_138 = "\");";
  protected final String TEXT_139 = NL + "\tif(tmp_";
  protected final String TEXT_140 = ".get(";
  protected final String TEXT_141 = ")!=null){" + NL + "\t\t" + NL + "\t\tjava.util.Map<String, String> row_";
  protected final String TEXT_142 = " = (java.util.Map<String, String>)tmp_";
  protected final String TEXT_143 = ".get(";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = "\t" + NL + "\t\t";
  protected final String TEXT_146 = "=new ";
  protected final String TEXT_147 = "Struct();";
  protected final String TEXT_148 = NL + "\t\tboolean hasEmptyRow_";
  protected final String TEXT_149 = " = true;";
  protected final String TEXT_150 = NL + "\t\torg.dom4j.XPath xTmp";
  protected final String TEXT_151 = "_";
  protected final String TEXT_152 = " = temp_";
  protected final String TEXT_153 = ".createXPath(nsTool_";
  protected final String TEXT_154 = ".addDefaultNSPrefix(";
  protected final String TEXT_155 = ", subLoop_";
  protected final String TEXT_156 = "));" + NL + "\t    xTmp";
  protected final String TEXT_157 = "_";
  protected final String TEXT_158 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_159 = "); " + NL + "\t    obj_";
  protected final String TEXT_160 = " = xTmp";
  protected final String TEXT_161 = "_";
  protected final String TEXT_162 = ".evaluate(temp_";
  protected final String TEXT_163 = ");" + NL + "\t    if(obj_";
  protected final String TEXT_164 = " instanceof org.dom4j.Node) {" + NL + "\t    \tnode_";
  protected final String TEXT_165 = " = (org.dom4j.Node)obj_";
  protected final String TEXT_166 = ";" + NL + "\t    \tisSingleNode_";
  protected final String TEXT_167 = " = true;" + NL + "\t    } else {" + NL + "\t    \tisSingleNode_";
  protected final String TEXT_168 = " = false;" + NL + "\t    }" + NL + "\t    str_";
  protected final String TEXT_169 = " = xTmp";
  protected final String TEXT_170 = "_";
  protected final String TEXT_171 = ".valueOf(temp_";
  protected final String TEXT_172 = ")";
  protected final String TEXT_173 = ";";
  protected final String TEXT_174 = NL + "\tstr_";
  protected final String TEXT_175 = " = row_";
  protected final String TEXT_176 = ".get(";
  protected final String TEXT_177 = ")";
  protected final String TEXT_178 = ";";
  protected final String TEXT_179 = NL + "\tnode_";
  protected final String TEXT_180 = " = new String[]{str_";
  protected final String TEXT_181 = ",row_";
  protected final String TEXT_182 = ".get(";
  protected final String TEXT_183 = "+\"/@xsi:nil\")};";
  protected final String TEXT_184 = NL + "\tnode_";
  protected final String TEXT_185 = " = new String[]{str_";
  protected final String TEXT_186 = ",null};";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t\t\t\tif(isSingleNode_";
  protected final String TEXT_188 = " && xml_api_";
  protected final String TEXT_189 = ".isDefNull(node_";
  protected final String TEXT_190 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(isSingleNode_";
  protected final String TEXT_193 = " && xml_api_";
  protected final String TEXT_194 = ".isEmpty(node_";
  protected final String TEXT_195 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(isSingleNode_";
  protected final String TEXT_198 = " && xml_api_";
  protected final String TEXT_199 = ".isMissing(node_";
  protected final String TEXT_200 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = " =";
  protected final String TEXT_203 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\t\t\tif(isSingleNode_";
  protected final String TEXT_205 = " && xml_api_";
  protected final String TEXT_206 = ".isEmpty(node_";
  protected final String TEXT_207 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(isSingleNode_";
  protected final String TEXT_210 = " && xml_api_";
  protected final String TEXT_211 = ".isMissing(node_";
  protected final String TEXT_212 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = " =";
  protected final String TEXT_215 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_216 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(isSingleNode_";
  protected final String TEXT_217 = " && xml_api_";
  protected final String TEXT_218 = ".isDefNull(node_";
  protected final String TEXT_219 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(isSingleNode_";
  protected final String TEXT_222 = " && (xml_api_";
  protected final String TEXT_223 = ".isEmpty(node_";
  protected final String TEXT_224 = ") || xml_api_";
  protected final String TEXT_225 = ".isMissing(node_";
  protected final String TEXT_226 = "))){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_227 = ".";
  protected final String TEXT_228 = "=";
  protected final String TEXT_229 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\t\t\t\t\tif(isSingleNode_";
  protected final String TEXT_231 = " && (xml_api_";
  protected final String TEXT_232 = ".isMissing(node_";
  protected final String TEXT_233 = ") || xml_api_";
  protected final String TEXT_234 = ".isEmpty(node_";
  protected final String TEXT_235 = "))){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = ".";
  protected final String TEXT_237 = " =";
  protected final String TEXT_238 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_239 = NL + "\t\t";
  protected final String TEXT_240 = ".";
  protected final String TEXT_241 = " = str_";
  protected final String TEXT_242 = ";";
  protected final String TEXT_243 = NL + "\t\t";
  protected final String TEXT_244 = ".";
  protected final String TEXT_245 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_246 = ", ";
  protected final String TEXT_247 = ",false);";
  protected final String TEXT_248 = "\t\t\t" + NL + "\t\t";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_251 = ", ";
  protected final String TEXT_252 = ");";
  protected final String TEXT_253 = "\t\t\t\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = " = str_";
  protected final String TEXT_256 = ".getBytes(";
  protected final String TEXT_257 = ");";
  protected final String TEXT_258 = NL + "\t\t";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = " = ParserUtils.parseTo_";
  protected final String TEXT_261 = "(ParserUtils.parseTo_Number(str_";
  protected final String TEXT_262 = ", ";
  protected final String TEXT_263 = ", ";
  protected final String TEXT_264 = "));";
  protected final String TEXT_265 = NL + "\t\t";
  protected final String TEXT_266 = ".";
  protected final String TEXT_267 = " = ParserUtils.parseTo_";
  protected final String TEXT_268 = "(str_";
  protected final String TEXT_269 = ");";
  protected final String TEXT_270 = NL + "\t\thasEmptyRow_";
  protected final String TEXT_271 = " = false;";
  protected final String TEXT_272 = NL + "\t}";
  protected final String TEXT_273 = NL + "\t\tif(hasEmptyRow_";
  protected final String TEXT_274 = " == true){" + NL + "\t\t\t";
  protected final String TEXT_275 = " = null;" + NL + "\t\t}";
  protected final String TEXT_276 = NL + "\t}";
  protected final String TEXT_277 = NL + "\t} catch (java.lang.Exception e) {";
  protected final String TEXT_278 = NL + "            throw(e);";
  protected final String TEXT_279 = NL + "        System.err.println(e.getMessage());";
  protected final String TEXT_280 = NL + "\t\t";
  protected final String TEXT_281 = " = null;";
  protected final String TEXT_282 = NL + "\t}";
  protected final String TEXT_283 = NL + "\t\t\t";
  protected final String TEXT_284 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();


//List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
//String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String rootpath = ElementParameterParser.getValue(node, "__ROOT_LOOP_QUERY__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
List<Map<String, String>> schemas = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");

String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");

boolean ignoreDTD="true".equals(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false; 

String ignoreOrderStr = ElementParameterParser.getValue(node, "__IGNORE_ORDER__");
boolean ignoreOrder = (ignoreOrderStr!=null&&!("").equals(ignoreOrderStr))?("true").equals(ignoreOrderStr):false;

boolean trimAll = ("true").equals(ElementParameterParser.getValue(node,"__TRIMALL__"));

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;

List< ? extends IConnection> connections = node.getOutgoingSortedConnections();

class XpathUtil {

	public  String[]  toXpathStringArray(String xpathList) {
		List<String> result = new java.util.ArrayList<String>();
		char[] charValues = xpathList.toCharArray();
		int inx = -1;
		int beginInx = 0;
		int leftInx = -1;
		int rightInx = -1;
		for (int i = 0; i < charValues.length; i++) {
			char ch = charValues[i];
			if ('[' == ch) {
				leftInx = i;
			} else if (']' == ch) {
				rightInx = i;
			} else if (',' == ch) {
				inx = i;
				if ((leftInx != -1 && rightInx != -1 && inx > leftInx && inx > rightInx)
						|| leftInx == -1
						|| (leftInx != -1 && xpathList
								.indexOf("]") == -1)) {
					result.add(addQuotesIfNotExist(xpathList.substring(beginInx, inx)));
					beginInx = inx + 1;
					leftInx = -1;
					rightInx = -1;
				}
			}
		}
		if (beginInx != 0) {
			result.add(addQuotesIfNotExist(xpathList.substring(beginInx)));
		}
		if (result.size() > 0) {
			return result.toArray(new String[0]);
		} else {
			return new String[] { xpathList };
		}
	}
	
	private  String addQuotesIfNotExist(String text) {
        if (text == null) {
            return null;
        }
        if (!text.startsWith("\"")) {
            text = "\"" + text;
        }
        if (!text.endsWith("\"")) {
            text = text + "\"";
        }
        return text;
    }
}

XpathUtil xpathUtil = new XpathUtil();

if(connections!=null && connections.size()>0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
// *** dom4j begin *** //
if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
      }

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(rootpath );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
	//get all the children collections of the loop node.
	for(IConnection conn : connections){
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			String query = null;
			for(Map<String, String> schemaMap : schemas){
				if(schemaMap.get("SCHEMA").equals(conn.getName())){
					query = schemaMap.get("LOOP_PATH");
				}
			}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(query );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_24);
    
		}
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
      }

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(filename );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    	if(!ignoreOrder){//order 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    	}else{ // out of order
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
		for(IConnection conn : connections){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    
			}
		}

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    
	}
// ***dom4j end and sax begin*** //
}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
	//get all the children collections of the loop node.
	StringBuilder builderLoops = new StringBuilder();
	StringBuilder builderQueries = new StringBuilder();
	boolean isFirstArr = true;
	for(IConnection conn : connections){
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			String loopPath = null;
			String strQuery = null;
			for(Map<String, String> schemaMap : schemas){
				if(schemaMap.get("SCHEMA").equals(conn.getName())){
					loopPath = schemaMap.get("LOOP_PATH");
					strQuery = (String)schemaMap.get("MAPPING");
				}
			}
			
			if(isFirstArr == false){
				builderQueries.append(",");
				builderLoops.append(",");
			}
			builderLoops.append(loopPath);
			
			String[] arrQuery = xpathUtil.toXpathStringArray(strQuery);
			builderQueries.append("{");
			for(int i = 0; i < arrQuery.length; i++){
				if(arrQuery[i]!=null && !("").equals(arrQuery[i])){
					if(i == 0){
						builderQueries.append(arrQuery[i]);
					}else{
						builderQueries.append("," + arrQuery[i]);
					}
					
					if(arrQuery[i].indexOf("@")<0){
						builderQueries.append("," + arrQuery[i] + "+\"/@xsi:nil\"");
					}
				}
			}
			builderQueries.append("}");
			
			isFirstArr = false;
		}
	}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(builderLoops.toString() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(builderQueries.toString() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(rootpath);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    if(ignoreDTD){
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
}
// *** sax end *** //

    stringBuffer.append(TEXT_120);
    
	for(IConnection conn : connections){
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			boolean hasEmptyRow = false;
			Map<String, String> mapping = null;
			String tmpQuery = null;
			for(Map<String, String> schemaMap : schemas){
				if(schemaMap.get("SCHEMA").equals(conn.getName())){
					hasEmptyRow = ("true").equals(schemaMap.get("CREATE_EMPTY_ROW"));
					mapping = schemaMap;
					tmpQuery = schemaMap.get("LOOP_PATH");
				}
			}
			IMetadataTable metadata = conn.getMetadataTable();
			if(metadata!=null){

    stringBuffer.append(TEXT_121);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_122);
    
				if(("Dom4j").equals(mode)){
					if(!ignoreOrder){ //order

    stringBuffer.append(TEXT_123);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_132);
    
					}else{ //out of order

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_138);
    
					}
				}else{

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(tmpQuery );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(tmpQuery );
    stringBuffer.append(TEXT_144);
    
				}

    stringBuffer.append(TEXT_145);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_147);
    
				if(hasEmptyRow==false){

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    
				}
				List<IMetadataColumn> columns = metadata.getListColumns();
				String[] arrXpath = xpathUtil.toXpathStringArray(((String)mapping.get("MAPPING")));
				for (int i=0;i < arrXpath.length;i++) {
					String query = arrXpath[i];
					if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_150);
    stringBuffer.append(conn.getName() + i );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(query );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(conn.getName() + i );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(conn.getName() + i );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(conn.getName() + i );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(trimAll?".trim()":"");
    stringBuffer.append(TEXT_173);
    
					}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(query );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(trimAll?".trim()":"");
    stringBuffer.append(TEXT_178);
    
						if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(query );
    stringBuffer.append(TEXT_183);
    
						}else{

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    
						}
					}
 					int j = 0;
					for(IMetadataColumn column:columns) {
						if (i == j) {
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
							boolean isNotSetDefault = false;
							String defaultValue=column.getDefault();
							if(defaultValue!=null){
								isNotSetDefault = defaultValue.length()==0;
							}else{
								isNotSetDefault=true;
							}
							
							if(javaType == JavaTypesManager.STRING){
								if(column.isNullable()){

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(isNotSetDefault?null:column.getDefault() );
    stringBuffer.append(TEXT_203);
     
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault() );
    stringBuffer.append(TEXT_215);
     
								}
							}else{ // other type
								if(column.isNullable()){

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_229);
    
							  	}else{ // column.isNullable()

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault() );
    stringBuffer.append(TEXT_238);
    
								}
							}
							if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_239);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
     
							} else if (javaType == JavaTypesManager.DATE) {
								if(checkDate) {

    stringBuffer.append(TEXT_243);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_247);
      
								} else {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_252);
    
								}
							} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_253);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_257);
    
							} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_258);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_260);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_263);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_264);
    
							} else {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    
							}

    
							if(hasEmptyRow==false){

    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    
							}

    stringBuffer.append(TEXT_272);
    
							break;//jump out of the for loop
						}
						j++;
					}				//for(IMetadataColumn column:columns)
				}				//for (int i=0;i<mapping.size();i++)

    
				if(hasEmptyRow==false){

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_275);
    
				}

    stringBuffer.append(TEXT_276);
    
			}	//if(metadata!=null)	
		}//if(conn) 
	}	//for(IConnection)

    stringBuffer.append(TEXT_277);
    
    if (dieOnError) {

    stringBuffer.append(TEXT_278);
    
	} else {

    stringBuffer.append(TEXT_279);
    
    	for(IConnection conn : connections){
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){

    stringBuffer.append(TEXT_280);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_281);
    
			}
		}
	}

    stringBuffer.append(TEXT_282);
    
}	//if(conns!=null)

    stringBuffer.append(TEXT_283);
    stringBuffer.append(TEXT_284);
    return stringBuffer.toString();
  }
}

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

public class TFileInputXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileInputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputXMLBeginJava result = new TFileInputXMLBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work\");" + NL + "\t\t\t\tStringBuffer log4jSb_";
  protected final String TEXT_3 = " = new StringBuffer();";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Has finished.\");";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieving records from the datasource.\");";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_10 = " + \" .\");";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_12 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_13 = " + \" \" + log4jSb_";
  protected final String TEXT_14 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_15 = ".delete(0,log4jSb_";
  protected final String TEXT_16 = ".length());";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Writing the record \" + nb_line_";
  protected final String TEXT_19 = " + \" \" + log4jSb_";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_21 = ".delete(0,log4jSb_";
  protected final String TEXT_22 = ".length());";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Written records count: \" + nb_line_";
  protected final String TEXT_25 = " + \" .\");";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "int nb_line_";
  protected final String TEXT_28 = " = 0;" + NL;
  protected final String TEXT_29 = NL + "class IgnoreDTDEntityResolver_";
  protected final String TEXT_30 = " implements org.xml.sax.EntityResolver {" + NL + "" + NL + " public org.xml.sax.InputSource resolveEntity(String publicId, String systemId)" + NL + "   throws org.xml.sax.SAXException, java.io.IOException {" + NL + "        return new org.xml.sax.InputSource(new java.io.ByteArrayInputStream(\"<?xml version='1.0' encoding='UTF-8'?>\".getBytes()));" + NL + " }" + NL + "" + NL + "}";
  protected final String TEXT_31 = NL + "\tString os_";
  protected final String TEXT_32 = " = System.getProperty(\"os.name\").toLowerCase();" + NL + "\tboolean isWindows_";
  protected final String TEXT_33 = "=false;" + NL + "\tif(os_";
  protected final String TEXT_34 = ".indexOf(\"windows\") > -1 || os_";
  protected final String TEXT_35 = ".indexOf(\"nt\") > -1){" + NL + "\t\tisWindows_";
  protected final String TEXT_36 = "=true;" + NL + "\t}";
  protected final String TEXT_37 = NL + "class TalendPrefixResolver_";
  protected final String TEXT_38 = " implements org.apache.xml.utils.PrefixResolver {" + NL + "" + NL + "    private java.util.Map<String, String> map = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "\t" + NL + "    public String getBaseIdentifier() {" + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix) {" + NL + "        if ((\"xml\").equals(prefix)) {" + NL + "            return org.apache.xml.utils.Constants.S_XMLNAMESPACEURI;" + NL + "        } else {" + NL + "            return map.get(prefix);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix, org.w3c.dom.Node context) {" + NL + "        return getNamespaceForPrefix(prefix);" + NL + "    }" + NL + "" + NL + "    public boolean handlesNullPrefixes() {" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean countNSMap(org.w3c.dom.Node el) {" + NL + "    \tboolean hasDefaultPrefix = false;" + NL + "        if (el.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            org.w3c.dom.NamedNodeMap attris = el.getAttributes();" + NL + "            for (int i = 0; i < attris.getLength(); i++) {" + NL + "                org.w3c.dom.Node attr = attris.item(i);" + NL + "                String aname = attr.getNodeName();" + NL + "                if (aname.startsWith(\"xmlns\")) {" + NL + "                    int index = aname.indexOf(\":\");" + NL + "                    if(index > 0){" + NL + "                    \taname = aname.substring(index + 1);" + NL + "                    }else{" + NL + "                    \taname = \"pre\"+defualtNSPath.size();" + NL + "                    \thasDefaultPrefix = true;" + NL + "                    \tString path = \"\";" + NL + "                    \torg.w3c.dom.Node elTmp = el;" + NL + "                    \twhile(elTmp!=null && !(elTmp instanceof org.w3c.dom.Document)){" + NL + "\t\t\t\t\t\t\tpath = \"/\"+elTmp.getNodeName()+path;" + NL + "                    \t\telTmp = elTmp.getParentNode();" + NL + "                    \t}" + NL + "                        defualtNSPath.add(path);" + NL + "                    }" + NL + "                    map.put(aname, attr.getNodeValue());" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        org.w3c.dom.NodeList nodeList = el.getChildNodes();" + NL + "        for (int i = 0; i < nodeList.getLength(); i++) {" + NL + "            hasDefaultPrefix = hasDefaultPrefix | countNSMap(nodeList.item(i));" + NL + "        }" + NL + "        return hasDefaultPrefix;" + NL + "    }" + NL + "    " + NL + "    public int[] getDefaulNSIndex(String path, String loopPath){" + NL + "\t\tString fullPath = loopPath;" + NL + "    \tif(!path.equals(fullPath)){" + NL + "        \tfor (String tmp : path.split(\"/\")) {" + NL + "        \t\tif ((\"..\").equals(tmp)) {" + NL + "                    fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                } else {" + NL + "                    fullPath += \"/\" + tmp;" + NL + "                }" + NL + "        \t}" + NL + "        }" + NL + "    \tint[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "        java.util.Arrays.fill(indexs, -1);" + NL + "        int length = 0;" + NL + "        for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "            if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                length = defualtNSPath.get(i).length();" + NL + "            }" + NL + "        }" + NL + "    \treturn indexs;" + NL + "    }" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_39 = "{" + NL + "" + NL + "\tString loopPath = null;" + NL + "\tboolean hasDefaultNS = false;" + NL + "\tTalendPrefixResolver_";
  protected final String TEXT_40 = " pr = null;" + NL + "\t" + NL + "\tpublic boolean isDefNull(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            return ((org.apache.xerces.xs.ElementPSVI) node).getNil();" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getTextContent().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "\tpublic void initXPath(org.w3c.dom.Node root){" + NL + "\t\tpr= new TalendPrefixResolver_";
  protected final String TEXT_41 = "();" + NL + "    \thasDefaultNS = pr.countNSMap(root);" + NL + "\t}" + NL + "" + NL + "//==============add for feature 10753 start================================" + NL + "\torg.apache.xpath.objects.XObject obj = null;" + NL + "\t" + NL + "\tpublic int getNodeType(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tobj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "\t\treturn obj.getType();" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getNodeString(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tif(obj==null){" + NL + "\t\t\tobj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "\t\t}" + NL + "\t\treturn obj.str();" + NL + "\t}" + NL + "" + NL + "    public org.w3c.dom.Node getSingleNode(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "    \tif(obj==null){" + NL + "        \tobj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "        }" + NL + "        return obj.nodelist().item(0);" + NL + "    }" + NL + "//=====================end=================================================" + NL + "" + NL + "    public org.w3c.dom.NodeList getNodeList(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "        org.apache.xpath.objects.XObject obj = org.apache.xpath.XPathAPI.eval(node, addDefaultNSPrefix(xpath), pr);" + NL + "        return obj.nodelist();" + NL + "    }" + NL + "    " + NL + "    private String addDefaultNSPrefix(String path) {" + NL + "        if (hasDefaultNS) {" + NL + "            StringBuffer newPath = new StringBuffer();" + NL + "            int[] indexs= pr.getDefaulNSIndex(path,loopPath);" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }                    " + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "" + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "" + NL + "}" + NL;
  protected final String TEXT_42 = NL + "class ContentTool_";
  protected final String TEXT_43 = "{" + NL + "\tpublic String field_separator=\",\";//default value" + NL + "\t" + NL + "\tpublic String getNodeContent(org.w3c.dom.Node node){" + NL + "\t\tString result=getSubNodeContent(node);" + NL + "\t\tif(result.equals(\"\")) return \"\";" + NL + "\t\telse return result.substring(1);" + NL + "\t}" + NL + "\t" + NL + "\tprivate String getSubNodeContent(org.w3c.dom.Node node){" + NL + "\t\tif(node==null) return \"\";" + NL + "\t\t" + NL + "\t\tString tmp=node.getNodeValue();" + NL + "\t\t" + NL + "\t\tif(tmp==null){" + NL + "\t\t\ttmp=\"\";" + NL + "\t\t}else{" + NL + "\t\t\ttmp=field_separator+tmp;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(node.hasChildNodes()){" + NL + "\t\t\torg.w3c.dom.NodeList nodeList = node.getChildNodes();" + NL + "\t\t\tfor(int i=0;i<nodeList.getLength();i++){" + NL + "\t\t\t\torg.w3c.dom.Node tmpNode= nodeList.item(i);\t" + NL + "\t\t\t\ttmp=tmp+getSubNodeContent(tmpNode);" + NL + "" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn tmp;" + NL + "\t}" + NL + "}" + NL + "ContentTool_";
  protected final String TEXT_44 = " contentTool_";
  protected final String TEXT_45 = " = new ContentTool_";
  protected final String TEXT_46 = "();" + NL + "contentTool_";
  protected final String TEXT_47 = ".field_separator=";
  protected final String TEXT_48 = ";";
  protected final String TEXT_49 = NL + NL + "XML_API_";
  protected final String TEXT_50 = " xml_api_";
  protected final String TEXT_51 = " = new XML_API_";
  protected final String TEXT_52 = "();" + NL + "xml_api_";
  protected final String TEXT_53 = ".loopPath=";
  protected final String TEXT_54 = ";" + NL + "org.apache.xerces.parsers.DOMParser parser_";
  protected final String TEXT_55 = " = new org.apache.xerces.parsers.DOMParser();";
  protected final String TEXT_56 = NL + "parser_";
  protected final String TEXT_57 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_58 = "());";
  protected final String TEXT_59 = NL + "parser_";
  protected final String TEXT_60 = ".setProperty(\"http://apache.org/xml/properties/dom/document-class-name\"," + NL + "        \"org.apache.xerces.dom.PSVIDocumentImpl\");" + NL + "parser_";
  protected final String TEXT_61 = ".setFeature(\"http://xml.org/sax/features/validation\", true);" + NL + "parser_";
  protected final String TEXT_62 = ".setFeature(\"http://apache.org/xml/features/validation/schema\", true);" + NL + "parser_";
  protected final String TEXT_63 = ".setFeature(\"http://apache.org/xml/features/validation/schema-full-checking\", true);" + NL + "parser_";
  protected final String TEXT_64 = ".setFeature(\"http://xml.org/sax/features/namespaces\", true);" + NL + "parser_";
  protected final String TEXT_65 = ".setErrorHandler(null);" + NL + "Object filename_";
  protected final String TEXT_66 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_69 = NL + "\t";
  protected final String TEXT_70 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_71 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_72 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_73 = NL + "\t";
  protected final String TEXT_74 = NL + "\t\tlog.error(\"";
  protected final String TEXT_75 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_76 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_77 = NL + "}" + NL + "" + NL + "boolean isValidFile_";
  protected final String TEXT_78 = " = true;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_79 = " = null;" + NL + "try{" + NL + "    if(filename_";
  protected final String TEXT_80 = " != null && filename_";
  protected final String TEXT_81 = " instanceof String && filename_";
  protected final String TEXT_82 = ".toString().startsWith(\"//\")){" + NL + "\t\tif (!isWindows_";
  protected final String TEXT_83 = "){" + NL + "\t\t\tfilename_";
  protected final String TEXT_84 = " = filename_";
  protected final String TEXT_85 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t\t}" + NL + "    }" + NL + "    if(filename_";
  protected final String TEXT_86 = " instanceof java.io.InputStream){" + NL + "    \tjava.io.InputStream inputStream_";
  protected final String TEXT_87 = " = (java.io.InputStream)filename_";
  protected final String TEXT_88 = ";" + NL + "    \ttoClose_";
  protected final String TEXT_89 = " = inputStream_";
  protected final String TEXT_90 = ";" + NL + "    \tparser_";
  protected final String TEXT_91 = ".parse(new org.xml.sax.InputSource(inputStream_";
  protected final String TEXT_92 = "));" + NL + "    }else{" + NL + "    \tjava.io.InputStream in_";
  protected final String TEXT_93 = "= new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_94 = "));" + NL + "    \tjava.io.Reader unicodeReader_";
  protected final String TEXT_95 = " = new UnicodeReader(in_";
  protected final String TEXT_96 = ",";
  protected final String TEXT_97 = ");" + NL + "    \ttoClose_";
  protected final String TEXT_98 = " = unicodeReader_";
  protected final String TEXT_99 = ";" + NL + "    \torg.xml.sax.InputSource xmlInputSource_";
  protected final String TEXT_100 = " = new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_101 = ");" + NL + "    \tparser_";
  protected final String TEXT_102 = ".parse(xmlInputSource_";
  protected final String TEXT_103 = ");" + NL + "    }" + NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_104 = NL + "\t";
  protected final String TEXT_105 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_106 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_107 = NL + "\tthrow(e);";
  protected final String TEXT_108 = NL + "\t";
  protected final String TEXT_109 = NL + "\t\tlog.error(\"";
  protected final String TEXT_110 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_111 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_112 = " = false;";
  protected final String TEXT_113 = NL + "}finally {" + NL + "\tif(toClose_";
  protected final String TEXT_114 = "!=null) {" + NL + "\t\ttoClose_";
  protected final String TEXT_115 = ".close();" + NL + "\t}" + NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_116 = "){" + NL + "org.w3c.dom.Document doc_";
  protected final String TEXT_117 = " = parser_";
  protected final String TEXT_118 = ".getDocument();" + NL + "" + NL + "xml_api_";
  protected final String TEXT_119 = ".initXPath(doc_";
  protected final String TEXT_120 = ");" + NL + "org.w3c.dom.NodeList nodelist_";
  protected final String TEXT_121 = " = xml_api_";
  protected final String TEXT_122 = ".getNodeList(doc_";
  protected final String TEXT_123 = ",";
  protected final String TEXT_124 = ");" + NL + "" + NL + "org.w3c.dom.Node node_";
  protected final String TEXT_125 = "  = null;" + NL + "String str_";
  protected final String TEXT_126 = " = null;";
  protected final String TEXT_127 = NL + "for (int i_";
  protected final String TEXT_128 = " = 0; i_";
  protected final String TEXT_129 = " < nodelist_";
  protected final String TEXT_130 = ".getLength(); i_";
  protected final String TEXT_131 = "++) {" + NL + "\torg.w3c.dom.Node tmp_";
  protected final String TEXT_132 = " = nodelist_";
  protected final String TEXT_133 = ".item(i_";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = NL + "class NameSpaceTool_";
  protected final String TEXT_136 = " {" + NL + "" + NL + "    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "    public void countNSMap(org.dom4j.Element el) {" + NL + "        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "            if (ns.getPrefix().trim().length() == 0) {" + NL + "                xmlNameSpaceMap.put(\"pre\"+defualtNSPath.size(), ns.getURI());" + NL + "                String path = \"\";" + NL + "                org.dom4j.Element elTmp = el;" + NL + "                while (elTmp != null) {" + NL + "                \tif (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                        path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                    } else {" + NL + "                        path = \"/\" + elTmp.getName() + path;" + NL + "                    }" + NL + "                    elTmp = elTmp.getParent();" + NL + "                }" + NL + "                defualtNSPath.add(path);" + NL + "            } else {" + NL + "                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "            }" + NL + "" + NL + "        }" + NL + "        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "            countNSMap(e);" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    public String addDefaultNSPrefix(String path, String loopPath) {" + NL + "        if (defualtNSPath.size() > 0) {" + NL + "        \tString fullPath = loopPath;" + NL + "        \tif(!path.equals(fullPath)){" + NL + "            \tfor (String tmp : path.split(\"/\")) {" + NL + "            \t\tif ((\"..\").equals(tmp)) {" + NL + "                        fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                    } else {" + NL + "                        fullPath += \"/\" + tmp;" + NL + "                    }" + NL + "            \t}" + NL + "            }" + NL + "            int size = fullPath.split(\"/\").length - 1;" + NL + "            if(size<0) {" + NL + "            \treturn fullPath;" + NL + "            }" + NL + "        \tint[] indexs = new int[size];" + NL + "            java.util.Arrays.fill(indexs, -1);" + NL + "            int length = 0;" + NL + "            for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "                if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                    java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                    length = defualtNSPath.get(i).length();" + NL + "                }" + NL + "            }" + NL + "" + NL + "            StringBuilder newPath = new StringBuilder();" + NL + "            String[] pathStrs = path.split(\"/\");" + NL + "            for (int i = 0; i < pathStrs.length; i++) {" + NL + "                String tmp = pathStrs[i];" + NL + "                if (newPath.length() > 0) {" + NL + "                    newPath.append(\"/\");" + NL + "                }" + NL + "                if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                    int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                    if (index >= 0) {" + NL + "                    \t//==== add by wliu to support both filter and functions==" + NL + "\t\t\t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "\t\t\t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "\t\t\t\t\t\t\tnewPath.append(tmpStr);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "\t\t\t\t\t\t\t\tnewPath.append(tmp);" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t//==add end=======\t" + NL + "                        \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                        \t}" + NL + "                        }                    " + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            }" + NL + "            return newPath.toString();" + NL + "        }" + NL + "        return path;" + NL + "    }" + NL + "" + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}    " + NL + "" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_137 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_138 = NL + "\tclass XML_NS_RMV_";
  protected final String TEXT_139 = "{\t" + NL + "" + NL + "\t\tpublic void removeNamespace(org.dom4j.Document reader," + NL + "\t\t\t\torg.dom4j.Document writer) {" + NL + "\t\t\torg.dom4j.Element elemReader = reader.getRootElement();" + NL + "\t\t\torg.dom4j.Element elemTo = writer.addElement(elemReader" + NL + "\t\t\t\t\t.getName());" + NL + "\t\t\tif(elemReader!=null && elemReader.getText()!=null && !\"\".equals(elemReader.getText())){" + NL + "\t\t\t\telemTo.setText(elemReader.getText());" + NL + "\t\t\t}" + NL + "\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) elemReader" + NL + "\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\telemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t}" + NL + "\t\t\tremoveSubNamespace(elemReader, elemTo);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void removeSubNamespace(org.dom4j.Element elemFrom," + NL + "\t\t\t\torg.dom4j.Element elemTo) {" + NL + "\t\t\tfor (org.dom4j.Element subFrom : (List<org.dom4j.Element>) elemFrom" + NL + "\t\t\t\t\t.elements()) {" + NL + "\t\t\t\torg.dom4j.Element tmpElemTo = elemTo.addElement(subFrom" + NL + "\t\t\t\t\t\t.getName());" + NL + "\t\t\t\tif(subFrom!=null && subFrom.getText()!=null && !\"\".equals(subFrom.getText())){" + NL + "\t\t\t\t\ttmpElemTo.setText(subFrom.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) subFrom" + NL + "\t\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\t\ttmpElemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tremoveSubNamespace(subFrom, tmpElemTo);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_140 = NL + NL + "org.dom4j.io.SAXReader reader_";
  protected final String TEXT_141 = " = new org.dom4j.io.SAXReader();";
  protected final String TEXT_142 = NL + "reader_";
  protected final String TEXT_143 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_144 = "());";
  protected final String TEXT_145 = NL + "Object filename_";
  protected final String TEXT_146 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_147 = " = ";
  protected final String TEXT_148 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_149 = NL + "\t";
  protected final String TEXT_150 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_151 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_152 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_153 = NL + "\t";
  protected final String TEXT_154 = NL + "\t\tlog.error(\"";
  protected final String TEXT_155 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_156 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_157 = NL + "}" + NL + "if(filename_";
  protected final String TEXT_158 = " != null && filename_";
  protected final String TEXT_159 = " instanceof String && filename_";
  protected final String TEXT_160 = ".toString().startsWith(\"//\")){" + NL + "\tif (!isWindows_";
  protected final String TEXT_161 = "){" + NL + "\t\tfilename_";
  protected final String TEXT_162 = " = filename_";
  protected final String TEXT_163 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_164 = NL + "org.dom4j.Document doc_reader_";
  protected final String TEXT_165 = " = null;" + NL + "org.dom4j.Document doc_tmp_";
  protected final String TEXT_166 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_167 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "try {" + NL + "\tif(filename_";
  protected final String TEXT_168 = " instanceof java.io.InputStream){" + NL + "\t\tdoc_reader_";
  protected final String TEXT_169 = " = reader_";
  protected final String TEXT_170 = ".read((java.io.InputStream)filename_";
  protected final String TEXT_171 = ");" + NL + "\t}else{" + NL + "\t\tdoc_reader_";
  protected final String TEXT_172 = " = reader_";
  protected final String TEXT_173 = ".read(new java.io.File(String.valueOf(filename_";
  protected final String TEXT_174 = ")).toURI().toString());" + NL + "\t}" + NL + "\tformat_";
  protected final String TEXT_175 = ".setTrimText(false);" + NL + "\tformat_";
  protected final String TEXT_176 = ".setEncoding(";
  protected final String TEXT_177 = ");" + NL + "\tnew XML_NS_RMV_";
  protected final String TEXT_178 = "().removeNamespace(doc_reader_";
  protected final String TEXT_179 = ",doc_tmp_";
  protected final String TEXT_180 = ");" + NL + "\tdoc_reader_";
  protected final String TEXT_181 = ".clearContent();" + NL + "\tdoc_reader_";
  protected final String TEXT_182 = " = null;" + NL + "\tjava.io.FileOutputStream stream_";
  protected final String TEXT_183 = " = new java.io.FileOutputStream(";
  protected final String TEXT_184 = ");" + NL + "\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_185 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_186 = ", format_";
  protected final String TEXT_187 = ");" + NL + "\toutput_";
  protected final String TEXT_188 = ".write(doc_tmp_";
  protected final String TEXT_189 = ");" + NL + "\toutput_";
  protected final String TEXT_190 = ".close();" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_191 = NL + "\t";
  protected final String TEXT_192 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_193 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_194 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_195 = NL + "\t";
  protected final String TEXT_196 = NL + "\t\tlog.error(\"";
  protected final String TEXT_197 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_198 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_199 = NL + "} finally {" + NL + "\tif(filename_";
  protected final String TEXT_200 = " instanceof java.io.InputStream && filename_";
  protected final String TEXT_201 = "!=null){" + NL + "\t\t((java.io.InputStream)filename_";
  protected final String TEXT_202 = ").close();" + NL + "\t}" + NL + "}" + NL + "filename_";
  protected final String TEXT_203 = " = ";
  protected final String TEXT_204 = ";";
  protected final String TEXT_205 = NL + "boolean isValidFile_";
  protected final String TEXT_206 = " = true;" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_207 = " = null;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_208 = " = null;" + NL + "try{" + NL + "\tif(filename_";
  protected final String TEXT_209 = " instanceof java.io.InputStream){" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_210 = " = (java.io.InputStream)filename_";
  protected final String TEXT_211 = ";" + NL + "\t\ttoClose_";
  protected final String TEXT_212 = " = inputStream_";
  protected final String TEXT_213 = ";" + NL + "\t\tdoc_";
  protected final String TEXT_214 = " = reader_";
  protected final String TEXT_215 = ".read(inputStream_";
  protected final String TEXT_216 = ");" + NL + "\t}else{" + NL + "\t\tjava.io.Reader unicodeReader_";
  protected final String TEXT_217 = " = new UnicodeReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_218 = ")),";
  protected final String TEXT_219 = ");" + NL + "\t\ttoClose_";
  protected final String TEXT_220 = " = unicodeReader_";
  protected final String TEXT_221 = ";" + NL + "\t\torg.xml.sax.InputSource in_";
  protected final String TEXT_222 = "= new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_223 = ");" + NL + "\t\tdoc_";
  protected final String TEXT_224 = " = reader_";
  protected final String TEXT_225 = ".read(in_";
  protected final String TEXT_226 = ");" + NL + "\t}" + NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_227 = NL + "\t";
  protected final String TEXT_228 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_229 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_230 = NL + "\tthrow(e);";
  protected final String TEXT_231 = NL + "\t";
  protected final String TEXT_232 = NL + "\t\tlog.error(\"";
  protected final String TEXT_233 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_234 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_235 = " = false;";
  protected final String TEXT_236 = NL + "} finally {" + NL + "\tif(toClose_";
  protected final String TEXT_237 = "!=null) {" + NL + "\t\ttoClose_";
  protected final String TEXT_238 = ".close();" + NL + "\t}" + NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_239 = "){" + NL + "NameSpaceTool_";
  protected final String TEXT_240 = " nsTool_";
  protected final String TEXT_241 = " = new NameSpaceTool_";
  protected final String TEXT_242 = "();" + NL + "nsTool_";
  protected final String TEXT_243 = ".countNSMap(doc_";
  protected final String TEXT_244 = ".getRootElement());" + NL + "java.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_245 = " = nsTool_";
  protected final String TEXT_246 = ".xmlNameSpaceMap;  " + NL + "" + NL + "org.dom4j.XPath x_";
  protected final String TEXT_247 = " = doc_";
  protected final String TEXT_248 = ".createXPath(nsTool_";
  protected final String TEXT_249 = ".addDefaultNSPrefix(";
  protected final String TEXT_250 = ",";
  protected final String TEXT_251 = "));  " + NL + "x_";
  protected final String TEXT_252 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_253 = "); ";
  protected final String TEXT_254 = NL + "org.jaxen.NamespaceContext namespaceContext_";
  protected final String TEXT_255 = " = new org.jaxen.NamespaceContext() {" + NL + "" + NL + "\tpublic String translateNamespacePrefixToUri(String prefix) { " + NL + "\t\treturn \"\";//ignore prefix in xpath when evaluate" + NL + "\t}" + NL + "\t" + NL + "};" + NL + "x_";
  protected final String TEXT_256 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_257 = ");";
  protected final String TEXT_258 = NL + NL + "java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_259 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_260 = ".selectNodes(doc_";
  protected final String TEXT_261 = ");\t" + NL + "XML_API_";
  protected final String TEXT_262 = " xml_api_";
  protected final String TEXT_263 = " = new XML_API_";
  protected final String TEXT_264 = "();" + NL + "String str_";
  protected final String TEXT_265 = " = \"\";" + NL + "org.dom4j.Node node_";
  protected final String TEXT_266 = " = null;" + NL + "" + NL + "//init all mapping xpaths";
  protected final String TEXT_267 = NL + "org.dom4j.XPath xTmp";
  protected final String TEXT_268 = "_";
  protected final String TEXT_269 = " = org.dom4j.DocumentHelper.createXPath(nsTool_";
  protected final String TEXT_270 = ".addDefaultNSPrefix(";
  protected final String TEXT_271 = ",";
  protected final String TEXT_272 = "));" + NL + "xTmp";
  protected final String TEXT_273 = "_";
  protected final String TEXT_274 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_275 = ");";
  protected final String TEXT_276 = NL + "xTmp";
  protected final String TEXT_277 = "_";
  protected final String TEXT_278 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_279 = ");";
  protected final String TEXT_280 = NL + "for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_281 = ": nodeList_";
  protected final String TEXT_282 = ") {";
  protected final String TEXT_283 = NL + "class XML_API_";
  protected final String TEXT_284 = "{" + NL + "\tpublic boolean isDefNull(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0] != null && node[1]!=null && (\"true\").equals(node[1])){" + NL + "        \treturn true;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        return node[0] == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0]!=null ){" + NL + "        \treturn node[0].length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL + "XML_API_";
  protected final String TEXT_285 = " xml_api_";
  protected final String TEXT_286 = " = new XML_API_";
  protected final String TEXT_287 = "();" + NL + "" + NL + "String[] queryPaths_";
  protected final String TEXT_288 = " = new String[]{";
  protected final String TEXT_289 = "\t" + NL + "\t";
  protected final String TEXT_290 = "\t\t" + NL + "\t,";
  protected final String TEXT_291 = "+\"/@xsi:nil\"";
  protected final String TEXT_292 = NL + "};" + NL + "" + NL + "boolean[] asXMLs_";
  protected final String TEXT_293 = " = new boolean[]{";
  protected final String TEXT_294 = "\t" + NL + "\t";
  protected final String TEXT_295 = "\t\t" + NL + "\t,false";
  protected final String TEXT_296 = NL + "};" + NL + "" + NL + "String str_";
  protected final String TEXT_297 = " = \"\";" + NL + "String[] node_";
  protected final String TEXT_298 = " = null;" + NL + "org.talend.xml.sax.SAXLooper looper_";
  protected final String TEXT_299 = " = new org.talend.xml.sax.SAXLooper(";
  protected final String TEXT_300 = ",queryPaths_";
  protected final String TEXT_301 = ",asXMLs_";
  protected final String TEXT_302 = ");";
  protected final String TEXT_303 = NL + "looper_";
  protected final String TEXT_304 = ".setIgnoreDTD(true);";
  protected final String TEXT_305 = NL + "looper_";
  protected final String TEXT_306 = ".setEncoding(";
  protected final String TEXT_307 = ");" + NL + "Object filename_";
  protected final String TEXT_308 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_309 = " = ";
  protected final String TEXT_310 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_311 = NL + "\t";
  protected final String TEXT_312 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_313 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_314 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_315 = NL + "\t\tlog.error(\"";
  protected final String TEXT_316 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_317 = NL + "\t";
  protected final String TEXT_318 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_319 = NL + "}" + NL + "if(filename_";
  protected final String TEXT_320 = " != null && filename_";
  protected final String TEXT_321 = " instanceof String && filename_";
  protected final String TEXT_322 = ".toString().startsWith(\"//\")){" + NL + "\tif (!isWindows_";
  protected final String TEXT_323 = "){" + NL + "\t\tfilename_";
  protected final String TEXT_324 = " = filename_";
  protected final String TEXT_325 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL + "if(filename_";
  protected final String TEXT_326 = " instanceof java.io.InputStream){" + NL + "\tlooper_";
  protected final String TEXT_327 = ".parse((java.io.InputStream)filename_";
  protected final String TEXT_328 = ");" + NL + "}else{" + NL + "\tlooper_";
  protected final String TEXT_329 = ".parse(String.valueOf(filename_";
  protected final String TEXT_330 = "));" + NL + "}" + NL + "java.util.Iterator<java.util.Map<String, String>> it_";
  protected final String TEXT_331 = "  = looper_";
  protected final String TEXT_332 = ".iterator();";
  protected final String TEXT_333 = NL + "while (it_";
  protected final String TEXT_334 = ".hasNext()) {" + NL + "\tjava.util.Map<String, String> row_";
  protected final String TEXT_335 = " = it_";
  protected final String TEXT_336 = ".next();";
  protected final String TEXT_337 = NL + "\tnb_line_";
  protected final String TEXT_338 = "++;";
  protected final String TEXT_339 = NL + "\t";
  protected final String TEXT_340 = " = null;\t\t\t";
  protected final String TEXT_341 = NL + "\tboolean whetherReject_";
  protected final String TEXT_342 = " = false;" + NL + "\t";
  protected final String TEXT_343 = " = new ";
  protected final String TEXT_344 = "Struct();" + NL + "\ttry{";
  protected final String TEXT_345 = NL + "\tif(xml_api_";
  protected final String TEXT_346 = ".getNodeType(tmp_";
  protected final String TEXT_347 = ",";
  protected final String TEXT_348 = ")==org.apache.xpath.objects.XObject.CLASS_NODESET){" + NL + "\t\tnode_";
  protected final String TEXT_349 = " = xml_api_";
  protected final String TEXT_350 = ".getSingleNode(tmp_";
  protected final String TEXT_351 = ",";
  protected final String TEXT_352 = ");";
  protected final String TEXT_353 = NL + "    \tif(node_";
  protected final String TEXT_354 = "!=null && node_";
  protected final String TEXT_355 = ".getNodeType()==org.w3c.dom.Node.ELEMENT_NODE && node_";
  protected final String TEXT_356 = ".hasChildNodes()){" + NL + "    \t\tstr_";
  protected final String TEXT_357 = " = contentTool_";
  protected final String TEXT_358 = ".getNodeContent(node_";
  protected final String TEXT_359 = ");" + NL + "    \t}else{" + NL + "    \t\tstr_";
  protected final String TEXT_360 = " = node_";
  protected final String TEXT_361 = "!=null?node_";
  protected final String TEXT_362 = ".getTextContent():\"\";" + NL + "    \t}";
  protected final String TEXT_363 = NL + "\t\tstr_";
  protected final String TEXT_364 = " = node_";
  protected final String TEXT_365 = "!=null?node_";
  protected final String TEXT_366 = ".getTextContent():\"\";";
  protected final String TEXT_367 = NL + "\t}else{" + NL + "\t\tnode_";
  protected final String TEXT_368 = " = tmp_";
  protected final String TEXT_369 = ";" + NL + "\t\tstr_";
  protected final String TEXT_370 = " = xml_api_";
  protected final String TEXT_371 = ".getNodeString(tmp_";
  protected final String TEXT_372 = ",";
  protected final String TEXT_373 = ");" + NL + "\t}";
  protected final String TEXT_374 = NL + "\tif(true) {" + NL + "\t\t";
  protected final String TEXT_375 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_376 = " - Error Config: \\\"Get Nodes\\\" should be checked when type is \\\"Document\\\"\");" + NL + "\t\t";
  protected final String TEXT_377 = NL + "\t\tthrow new RuntimeException(\"Error Config: \\\"Get Nodes\\\" should be checked when type is \\\"Document\\\"\");" + NL + "\t}";
  protected final String TEXT_378 = NL + "    Object obj";
  protected final String TEXT_379 = "_";
  protected final String TEXT_380 = " = xTmp";
  protected final String TEXT_381 = "_";
  protected final String TEXT_382 = ".evaluate(temp_";
  protected final String TEXT_383 = ");" + NL + "    if(obj";
  protected final String TEXT_384 = "_";
  protected final String TEXT_385 = " == null) {" + NL + "    \tnode_";
  protected final String TEXT_386 = " = null;";
  protected final String TEXT_387 = NL + "\t\tstr_";
  protected final String TEXT_388 = " = null;";
  protected final String TEXT_389 = NL + "    \tstr_";
  protected final String TEXT_390 = " = \"\";";
  protected final String TEXT_391 = NL + "    \t" + NL + "    } else if(obj";
  protected final String TEXT_392 = "_";
  protected final String TEXT_393 = " instanceof org.dom4j.Node) {" + NL + "    \tnode_";
  protected final String TEXT_394 = " = (org.dom4j.Node)obj";
  protected final String TEXT_395 = "_";
  protected final String TEXT_396 = ";";
  protected final String TEXT_397 = NL + "\t\tstr_";
  protected final String TEXT_398 = " = node_";
  protected final String TEXT_399 = ".asXML();";
  protected final String TEXT_400 = NL + "    \tstr_";
  protected final String TEXT_401 = " = org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_402 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_403 = NL + "    } else if(obj";
  protected final String TEXT_404 = "_";
  protected final String TEXT_405 = " instanceof String || obj";
  protected final String TEXT_406 = "_";
  protected final String TEXT_407 = " instanceof Number){" + NL + "    \tnode_";
  protected final String TEXT_408 = " = temp_";
  protected final String TEXT_409 = ";" + NL + "    \tstr_";
  protected final String TEXT_410 = " = String.valueOf(obj";
  protected final String TEXT_411 = "_";
  protected final String TEXT_412 = ");" + NL + "    } else if(obj";
  protected final String TEXT_413 = "_";
  protected final String TEXT_414 = " instanceof java.util.List){" + NL + "    \tjava.util.List<org.dom4j.Node> nodes_";
  protected final String TEXT_415 = " = (java.util.List<org.dom4j.Node>)obj";
  protected final String TEXT_416 = "_";
  protected final String TEXT_417 = ";" + NL + "    \tnode_";
  protected final String TEXT_418 = " = nodes_";
  protected final String TEXT_419 = ".size()>0 ? nodes_";
  protected final String TEXT_420 = ".get(0) : null;";
  protected final String TEXT_421 = NL + "\t\tstr_";
  protected final String TEXT_422 = " = node_";
  protected final String TEXT_423 = "==null?null:node_";
  protected final String TEXT_424 = ".asXML();";
  protected final String TEXT_425 = NL + "    \tstr_";
  protected final String TEXT_426 = " = node_";
  protected final String TEXT_427 = "==null?\"\":org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_428 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_429 = NL + "\t}";
  protected final String TEXT_430 = NL + "\tstr_";
  protected final String TEXT_431 = " = row_";
  protected final String TEXT_432 = ".get(";
  protected final String TEXT_433 = ");";
  protected final String TEXT_434 = NL + "\tnode_";
  protected final String TEXT_435 = " = new String[]{str_";
  protected final String TEXT_436 = ",row_";
  protected final String TEXT_437 = ".get(";
  protected final String TEXT_438 = "+\"/@xsi:nil\")};";
  protected final String TEXT_439 = NL + "\tnode_";
  protected final String TEXT_440 = " = new String[]{str_";
  protected final String TEXT_441 = ",null};";
  protected final String TEXT_442 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_443 = ".";
  protected final String TEXT_444 = " = ParserUtils.parseTo_Document(str_";
  protected final String TEXT_445 = ",";
  protected final String TEXT_446 = ",";
  protected final String TEXT_447 = ");";
  protected final String TEXT_448 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_449 = ".";
  protected final String TEXT_450 = " = str_";
  protected final String TEXT_451 = ";";
  protected final String TEXT_452 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_453 = ".isDefNull(node_";
  protected final String TEXT_454 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_455 = ".";
  protected final String TEXT_456 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_457 = ".isEmpty(node_";
  protected final String TEXT_458 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_459 = ".";
  protected final String TEXT_460 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_461 = ".isMissing(node_";
  protected final String TEXT_462 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_463 = ".";
  protected final String TEXT_464 = " =";
  protected final String TEXT_465 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_466 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_467 = ".isEmpty(node_";
  protected final String TEXT_468 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_469 = ".";
  protected final String TEXT_470 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_471 = ".isMissing(node_";
  protected final String TEXT_472 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_473 = ".";
  protected final String TEXT_474 = " =";
  protected final String TEXT_475 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_476 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_477 = ".isDefNull(node_";
  protected final String TEXT_478 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_479 = ".";
  protected final String TEXT_480 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_481 = ".isEmpty(node_";
  protected final String TEXT_482 = ") || xml_api_";
  protected final String TEXT_483 = ".isMissing(node_";
  protected final String TEXT_484 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_485 = ".";
  protected final String TEXT_486 = "=";
  protected final String TEXT_487 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_488 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_489 = ".isMissing(node_";
  protected final String TEXT_490 = ") || xml_api_";
  protected final String TEXT_491 = ".isEmpty(node_";
  protected final String TEXT_492 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = " =";
  protected final String TEXT_495 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_496 = NL + "\t\t";
  protected final String TEXT_497 = ".";
  protected final String TEXT_498 = " = str_";
  protected final String TEXT_499 = ";";
  protected final String TEXT_500 = NL + "\t\t";
  protected final String TEXT_501 = ".";
  protected final String TEXT_502 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_503 = ", ";
  protected final String TEXT_504 = ",false);";
  protected final String TEXT_505 = NL + "\t\t";
  protected final String TEXT_506 = ".";
  protected final String TEXT_507 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_508 = ", ";
  protected final String TEXT_509 = ");";
  protected final String TEXT_510 = "\t\t\t\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_511 = ".";
  protected final String TEXT_512 = " = str_";
  protected final String TEXT_513 = ".getBytes(";
  protected final String TEXT_514 = ");";
  protected final String TEXT_515 = NL + "\t\t";
  protected final String TEXT_516 = ".";
  protected final String TEXT_517 = " = ParserUtils.parseTo_";
  protected final String TEXT_518 = "(ParserUtils.parseTo_Number(str_";
  protected final String TEXT_519 = ", ";
  protected final String TEXT_520 = ", ";
  protected final String TEXT_521 = "));";
  protected final String TEXT_522 = NL + "\t\t";
  protected final String TEXT_523 = ".";
  protected final String TEXT_524 = " = ParserUtils.parseTo_";
  protected final String TEXT_525 = "(str_";
  protected final String TEXT_526 = ");";
  protected final String TEXT_527 = NL + "\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_528 = ".append(";
  protected final String TEXT_529 = ".";
  protected final String TEXT_530 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_531 = NL + "\t\t\t\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_532 = ".append(\"|\");" + NL + "\t\t\t\t\t\t\t       ";
  protected final String TEXT_533 = NL + "\t}";
  protected final String TEXT_534 = " ";
  protected final String TEXT_535 = " = null; ";
  protected final String TEXT_536 = NL + "\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_537 = " = true;";
  protected final String TEXT_538 = NL + "\t\t\t";
  protected final String TEXT_539 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_540 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_541 = NL + "            throw(e);";
  protected final String TEXT_542 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_543 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_544 = NL + "                    ";
  protected final String TEXT_545 = " = new ";
  protected final String TEXT_546 = "Struct();";
  protected final String TEXT_547 = NL + "                    ";
  protected final String TEXT_548 = ".";
  protected final String TEXT_549 = " = ";
  protected final String TEXT_550 = ".";
  protected final String TEXT_551 = ";";
  protected final String TEXT_552 = NL + "                ";
  protected final String TEXT_553 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_554 = ";";
  protected final String TEXT_555 = NL + "                ";
  protected final String TEXT_556 = " = null;";
  protected final String TEXT_557 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_558 = NL + "                ";
  protected final String TEXT_559 = " = null;";
  protected final String TEXT_560 = NL + "            \t";
  protected final String TEXT_561 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_562 = ";";
  protected final String TEXT_563 = NL + "    }";
  protected final String TEXT_564 = NL + "\t\t";
  protected final String TEXT_565 = "if(!whetherReject_";
  protected final String TEXT_566 = ") { ";
  protected final String TEXT_567 = "      " + NL + "             if(";
  protected final String TEXT_568 = " == null){ " + NL + "            \t ";
  protected final String TEXT_569 = " = new ";
  protected final String TEXT_570 = "Struct();" + NL + "             }";
  protected final String TEXT_571 = NL + "\t    \t ";
  protected final String TEXT_572 = ".";
  protected final String TEXT_573 = " = ";
  protected final String TEXT_574 = ".";
  protected final String TEXT_575 = ";    \t\t\t\t";
  protected final String TEXT_576 = NL + "\t\t";
  protected final String TEXT_577 = " } ";
  protected final String TEXT_578 = "\t";
  protected final String TEXT_579 = NL + "\t" + NL + "\tif (nb_line_";
  protected final String TEXT_580 = ">";
  protected final String TEXT_581 = ") {" + NL + "\t";
  protected final String TEXT_582 = NL + "\t\t\tlooper_";
  protected final String TEXT_583 = ".stopRead();" + NL + "\t";
  protected final String TEXT_584 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_585 = NL + "\t\t\t";
  protected final String TEXT_586 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		
	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }
	    
		private void init() {
	    	cid = node.getUniqueName();
			isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public void componentStartInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void componentFinishInfo(INode node) {
			beforeComponentProcess(node);
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}

		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//for all tFileinput* components		
		public void debugRetriveData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

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
    		
			}
		}
		
		//for all tFileinput* components		
		public void debugWriteData(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    		
			}
		}
		
		//for all tFileoutput* components
		public void writeDataFinishInfo(INode node) {
			beforeComponentProcess(node);
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    		
			}
		}
	}
	
	DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil();

    stringBuffer.append(TEXT_26);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
        
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 

String filename = ElementParameterParser.getValue(node, "__FILENAME__");

String ignore_NS_Str = ElementParameterParser.getValue(node, "__IGNORE_NS__");
String tmp_filename = ElementParameterParser.getValue(node, "__TMP_FILENAME__");

String useSeparator = ElementParameterParser.getValue(node, "__USE_SEPARATOR__");
String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");

String limit = ElementParameterParser.getValue(node, "__LIMIT__");
if (("").equals(limit)) {
	limit = "-1";
}

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
boolean ignoreDTD="true".equals(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));

String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
	}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
// *** Xerces *** //
if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    if("true".equals(useSeparator)){
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
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
      if(ignoreDTD){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_68);
    if (dieOnError) {
    stringBuffer.append(TEXT_69);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    }else{
    stringBuffer.append(TEXT_73);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    if (dieOnError) {
    stringBuffer.append(TEXT_104);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    }else{
    stringBuffer.append(TEXT_108);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    
// *** Dom4j *** //
}else if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
	if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
	}

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
      }

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_148);
    if (dieOnError) {
    stringBuffer.append(TEXT_149);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_152);
    }else{
    stringBuffer.append(TEXT_153);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    
	if(("true").equals(ignore_NS_Str)){

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
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
    if (dieOnError) {
    stringBuffer.append(TEXT_191);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    }else{
    stringBuffer.append(TEXT_195);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    }
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_204);
    
	}

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    if (dieOnError) {
    stringBuffer.append(TEXT_227);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    }
    stringBuffer.append(TEXT_230);
    }else{
    stringBuffer.append(TEXT_231);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    }
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    }
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    if(("true").equals(ignore_NS_Str)){
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    }
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    
	for (int i=0;i<mapping.size();i++) {
		String query = mapping.get(i).get("QUERY");

    stringBuffer.append(TEXT_267);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    
		if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_276);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
		}
	}

    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
// *** SAX *** //
}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    
	boolean first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_289);
    stringBuffer.append(first?"":",");
    stringBuffer.append(path.get("QUERY"));
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_290);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_291);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
	first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_294);
    stringBuffer.append(first?"":",");
    stringBuffer.append("true".equals(path.get("NODECHECK"))? "true":"false" );
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_295);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    if(ignoreDTD){
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    }
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_310);
    if (dieOnError) {
    stringBuffer.append(TEXT_311);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    }
    stringBuffer.append(TEXT_314);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    }
    stringBuffer.append(TEXT_317);
    }else{
    stringBuffer.append(TEXT_318);
    }
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    
}

    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List<IMetadataColumn> columns=metadata.getListColumns();
		if (conns!=null) {
//************ add for reject start*****************
		    String rejectConnName = "";
		    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
		    if(rejectConns != null && rejectConns.size() > 0) {
		        IConnection rejectConn = rejectConns.get(0);
		        rejectConnName = rejectConn.getName();
		    }
		    List<IMetadataColumn> rejectColumnList = null;
		    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
		    if(metadataTable != null) {
		        rejectColumnList = metadataTable.getListColumns();      
		    }
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_339);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_340);
    
				}
    		}
//***************************end********************
			if (conns.size()>0) { // S_if_a_0_0		
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for reject

    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_344);
    
				
				for (int i=0;i<mapping.size();i++) { // S_for_a_1_0
					String query = mapping.get(i).get("QUERY");
					String nodeCheck = mapping.get(i).get("NODECHECK");
					if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_352);
    
						if("true".equals(useSeparator)){

    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    
						}else{

    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    
						}

    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_373);
    
					}else if(("Dom4j").equals(mode)){
						//TDI-18498
						boolean isWrongConfig = false;
						
						for(IMetadataColumn column:columns) {
							if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
								if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
									if("id_Document".equals(column.getTalendType()) && "false".equals(nodeCheck)) {
										isWrongConfig = true;
										break;
									}
								}
							}
						}
						
						if(isWrongConfig) {

    stringBuffer.append(TEXT_374);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    }
    stringBuffer.append(TEXT_377);
    
						}

    stringBuffer.append(TEXT_378);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    
						if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    
							
						}else{

    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    
						}

    stringBuffer.append(TEXT_391);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    
						if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    
							
						}else{

    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    
						}

    stringBuffer.append(TEXT_403);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    
						if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    
							
						}else{

    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    
						}

    stringBuffer.append(TEXT_429);
    
					}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_433);
    
						if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_438);
    
						}else{

    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    
						}
					}
					for(IMetadataColumn column:columns) {  // S_for_0_1
						if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // S_if_0_2
							if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { // S_if_0_3
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
								

								if(("Dom4j").equals(mode) && ("true").equals(nodeCheck)){
									if("id_Document".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_442);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(ignoreDTD);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_447);
    
									} else {

    stringBuffer.append(TEXT_448);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    
									}
									continue;
								}
								if(javaType == JavaTypesManager.STRING){
									if(column.isNullable()){

    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_463);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_465);
    
									}else{ // column.isNullable()

    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_475);
    
									}
								}else{ // other type
									if(column.isNullable()){

    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_487);
    
								  	}else{ // column.isNullable()

    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_495);
    
									}
								}
								
								if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_496);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    
								} else if (javaType == JavaTypesManager.DATE) {
									if(checkDate) {

    stringBuffer.append(TEXT_500);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_504);
      
									} else {

    stringBuffer.append(TEXT_505);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_509);
    										
									}
								} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_510);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_514);
    
								} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_515);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_517);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_520);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_521);
    
								} else {

    stringBuffer.append(TEXT_522);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_524);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    
								}
								if(isLog4jEnabled){
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_530);
    if(i < mapping.size()-1){
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    }
								}

    stringBuffer.append(TEXT_533);
    
							} //S_if_1_2
						} // S_if_1_1
					} // S_for_1_0
				} // S_for_a_0_1

    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_534);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_535);
    }
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_538);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    }
    stringBuffer.append(TEXT_541);
    
        } else {
			if(isLog4jEnabled){
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    }
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_544);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_546);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_547);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_549);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_551);
    
                }
                
    stringBuffer.append(TEXT_552);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_556);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_557);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_559);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_560);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_562);
    }
		}
        
    stringBuffer.append(TEXT_563);
    
				} //if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			} // S_if_a_1_1

//***********************************
			if (conns.size()>0) {	
				boolean isFirstEnter = true;
				for (int i=0;i<conns.size();i++) {
					IConnection tmpconn = conns.get(i);
					if ((tmpconn.getName().compareTo(firstConnName)!=0)&&(tmpconn.getName().compareTo(rejectConnName)!=0)&&(tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_564);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_567);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_570);
    
			    	 	for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_571);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_575);
    
				 		}
					}
				}

    stringBuffer.append(TEXT_576);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_577);
     } 
    stringBuffer.append(TEXT_578);
    
			}
//***********************************

		} // if(conn!=null)
		
		// limit
		if (limit.compareTo("-1")!=0) {

    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_581);
    if(("SAX").equals(mode)) {
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    }
    stringBuffer.append(TEXT_584);
     
		}
	}// if (metadata!=null)
} //if ((metadatas!=null)&&(metadatas.size()>0))

    stringBuffer.append(TEXT_585);
    stringBuffer.append(TEXT_586);
    return stringBuffer.toString();
  }
}

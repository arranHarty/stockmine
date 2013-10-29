package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TExtractJSONFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractJSONFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractJSONFieldsMainJava result = new TExtractJSONFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            if(";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "!=null){" + NL + "                jsonStr_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ".toString();" + NL + "            }";
  protected final String TEXT_8 = NL + "   ";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = " = null;";
  protected final String TEXT_11 = NL + "    org.dom4j.io.SAXReader reader_";
  protected final String TEXT_12 = " = new org.dom4j.io.SAXReader();" + NL + "    org.dom4j.Document doc_";
  protected final String TEXT_13 = " = null;" + NL + "    java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_14 = " = new java.util.HashMap<String, String>();" + NL + "    org.dom4j.XPath x_";
  protected final String TEXT_15 = " = null;" + NL + "    java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_16 = " = null;" + NL + "    boolean isStructError_";
  protected final String TEXT_17 = " = true;" + NL + "" + NL + "    String loopQuery_";
  protected final String TEXT_18 = " =  ";
  protected final String TEXT_19 = " ;" + NL + "    String oraginalJsonStr_";
  protected final String TEXT_20 = " = jsonStr_";
  protected final String TEXT_21 = ";" + NL + "    cjs_";
  protected final String TEXT_22 = ".setJsonString(jsonStr_";
  protected final String TEXT_23 = ");" + NL + "    cjs_";
  protected final String TEXT_24 = ".setLoopString(loopQuery_";
  protected final String TEXT_25 = ");" + NL + "    java.io.ByteArrayInputStream bais_";
  protected final String TEXT_26 = " = null;" + NL + "    java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_27 = " = new java.io.ByteArrayOutputStream();" + NL + "    try {" + NL + "        cjs_";
  protected final String TEXT_28 = ".generate();" + NL + "        jsonStr_";
  protected final String TEXT_29 = " = cjs_";
  protected final String TEXT_30 = ".getJsonString4XML();" + NL + "        loopQuery_";
  protected final String TEXT_31 = " = cjs_";
  protected final String TEXT_32 = ".getLoopString4XML();" + NL + "        bais_";
  protected final String TEXT_33 = " = new ByteArrayInputStream(jsonStr_";
  protected final String TEXT_34 = ".getBytes(";
  protected final String TEXT_35 = "));" + NL + "        javax.xml.stream.XMLEventReader xmlEventReader_";
  protected final String TEXT_36 = " = jsonXMLInputFactory_";
  protected final String TEXT_37 = ".createXMLEventReader(bais_";
  protected final String TEXT_38 = ");" + NL + "        javax.xml.stream.XMLEventWriter xmLEventWriter_";
  protected final String TEXT_39 = " = xmlOutputFactory_";
  protected final String TEXT_40 = ".createXMLEventWriter(baos_";
  protected final String TEXT_41 = ",";
  protected final String TEXT_42 = ");" + NL + "        xmLEventWriter_";
  protected final String TEXT_43 = ".add(xmlEventReader_";
  protected final String TEXT_44 = ");" + NL + "        //convert json string to xml" + NL + "        xmlStr_";
  protected final String TEXT_45 = " = baos_";
  protected final String TEXT_46 = ".toString();  " + NL + "        xmLEventWriter_";
  protected final String TEXT_47 = ".close();" + NL + "        xmlEventReader_";
  protected final String TEXT_48 = ".close();" + NL + "    " + NL + "        doc_";
  protected final String TEXT_49 = "= reader_";
  protected final String TEXT_50 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_51 = "));" + NL + "        x_";
  protected final String TEXT_52 = " = doc_";
  protected final String TEXT_53 = ".createXPath(loopQuery_";
  protected final String TEXT_54 = ");" + NL + "        x_";
  protected final String TEXT_55 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_56 = "); " + NL + "        nodeList_";
  protected final String TEXT_57 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_58 = ".selectNodes(doc_";
  protected final String TEXT_59 = ");" + NL + "        isStructError_";
  protected final String TEXT_60 = " = false;" + NL + "        " + NL + "    }catch(java.lang.Exception ex_";
  protected final String TEXT_61 = "){";
  protected final String TEXT_62 = NL + "        throw(ex_";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "    ";
  protected final String TEXT_65 = " = new ";
  protected final String TEXT_66 = "Struct();";
  protected final String TEXT_67 = NL + "            xml_api_";
  protected final String TEXT_68 = ".putRejectValueBeforeExtract_";
  protected final String TEXT_69 = "(";
  protected final String TEXT_70 = ",";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "    ";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = ";";
  protected final String TEXT_77 = NL + "    ";
  protected final String TEXT_78 = ".errorJSONField = oraginalJsonStr_";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL + "    ";
  protected final String TEXT_81 = ".errorMessage = ex_";
  protected final String TEXT_82 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_83 = ";";
  protected final String TEXT_84 = NL + "    System.err.println(ex_";
  protected final String TEXT_85 = ".getMessage());";
  protected final String TEXT_86 = NL + "    }finally {" + NL + "        baos_";
  protected final String TEXT_87 = ".close();" + NL + "        if(bais_";
  protected final String TEXT_88 = "!=null){" + NL + "            bais_";
  protected final String TEXT_89 = ".close();" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    org.dom4j.Node node_";
  protected final String TEXT_90 = " = null;" + NL + "    String str_";
  protected final String TEXT_91 = " = \"\";" + NL + "    for(int i_";
  protected final String TEXT_92 = "=0; isStructError_";
  protected final String TEXT_93 = " || (nodeList_";
  protected final String TEXT_94 = "!=null && i_";
  protected final String TEXT_95 = " < nodeList_";
  protected final String TEXT_96 = ".size());i_";
  protected final String TEXT_97 = "++){" + NL + "        " + NL + "        if(!isStructError_";
  protected final String TEXT_98 = "){";
  protected final String TEXT_99 = NL + "            ";
  protected final String TEXT_100 = " = null;";
  protected final String TEXT_101 = NL + "            ";
  protected final String TEXT_102 = " = new ";
  protected final String TEXT_103 = "Struct();" + NL + "        " + NL + "            org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_104 = " = nodeList_";
  protected final String TEXT_105 = ".get(i_";
  protected final String TEXT_106 = ");" + NL + "    " + NL + "            nb_line_";
  protected final String TEXT_107 = "++; " + NL + "            try{";
  protected final String TEXT_108 = NL + "            xml_api_";
  protected final String TEXT_109 = ".putUnExtractValue_";
  protected final String TEXT_110 = "(";
  protected final String TEXT_111 = ",";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "            ";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = ";";
  protected final String TEXT_118 = NL + "            xml_api_";
  protected final String TEXT_119 = ".putExtractValue_";
  protected final String TEXT_120 = "(";
  protected final String TEXT_121 = ",";
  protected final String TEXT_122 = ",";
  protected final String TEXT_123 = "xmlStr_";
  protected final String TEXT_124 = ",temp_";
  protected final String TEXT_125 = ",loopQuery_";
  protected final String TEXT_126 = ",xmlNameSpaceMap_";
  protected final String TEXT_127 = ",node_";
  protected final String TEXT_128 = ",str_";
  protected final String TEXT_129 = ",xml_api_";
  protected final String TEXT_130 = ",originalJSONString_";
  protected final String TEXT_131 = ",cjs_";
  protected final String TEXT_132 = ",isGetWholeJson_";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_135 = "  = true;";
  protected final String TEXT_136 = NL + "                org.dom4j.XPath xTmp";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = " = temp_";
  protected final String TEXT_139 = ".createXPath(";
  protected final String TEXT_140 = ");" + NL + "                xTmp";
  protected final String TEXT_141 = "_";
  protected final String TEXT_142 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_143 = ");" + NL + "                Object obj";
  protected final String TEXT_144 = "_";
  protected final String TEXT_145 = " = xTmp";
  protected final String TEXT_146 = "_";
  protected final String TEXT_147 = ".evaluate(temp_";
  protected final String TEXT_148 = ");" + NL + "                if(obj";
  protected final String TEXT_149 = "_";
  protected final String TEXT_150 = " instanceof String || obj";
  protected final String TEXT_151 = "_";
  protected final String TEXT_152 = " instanceof Number){" + NL + "                    node_";
  protected final String TEXT_153 = " = temp_";
  protected final String TEXT_154 = ";" + NL + "                    str_";
  protected final String TEXT_155 = " = String.valueOf(obj";
  protected final String TEXT_156 = "_";
  protected final String TEXT_157 = ");" + NL + "                }else{" + NL + "                    node_";
  protected final String TEXT_158 = " = xTmp";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = ".selectSingleNode(temp_";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "\t\t\t\t\t\tif(node_";
  protected final String TEXT_163 = "==null){" + NL + "\t \t\t\t\t\t\tstr_";
  protected final String TEXT_164 = " = null;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_165 = " = originalJSONString_";
  protected final String TEXT_166 = ".getOriginalJSONString(node_";
  protected final String TEXT_167 = ".asXML(),cjs_";
  protected final String TEXT_168 = ".getAdditionRoot(),";
  protected final String TEXT_169 = ",isGetWholeJson_";
  protected final String TEXT_170 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_171 = " = false;";
  protected final String TEXT_172 = NL + "                        str_";
  protected final String TEXT_173 = " = xTmp";
  protected final String TEXT_174 = "_";
  protected final String TEXT_175 = ".valueOf(temp_";
  protected final String TEXT_176 = ");";
  protected final String TEXT_177 = NL + "                }";
  protected final String TEXT_178 = NL + "                                    ";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = " = str_";
  protected final String TEXT_181 = ";";
  protected final String TEXT_182 = NL + "                                    if(xml_api_";
  protected final String TEXT_183 = ".isDefNull(node_";
  protected final String TEXT_184 = ")){";
  protected final String TEXT_185 = NL + "                                        ";
  protected final String TEXT_186 = ".";
  protected final String TEXT_187 = " = null;" + NL + "                                    }else if(xml_api_";
  protected final String TEXT_188 = ".isEmpty(node_";
  protected final String TEXT_189 = ")){";
  protected final String TEXT_190 = NL + "                                        ";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = \"\";" + NL + "                                    }else if(xml_api_";
  protected final String TEXT_193 = ".isMissing(node_";
  protected final String TEXT_194 = " )){ ";
  protected final String TEXT_195 = NL + "                                        ";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ";" + NL + "                                    }else{";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_200 = ".isEmpty(node_";
  protected final String TEXT_201 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_204 = ".isMissing(node_";
  protected final String TEXT_205 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = " =";
  protected final String TEXT_208 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_209 = "  " + NL + "                                \tif(xml_api_";
  protected final String TEXT_210 = ".isDefNull(node_";
  protected final String TEXT_211 = ")){" + NL + "                                    \t";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = null;" + NL + "                                \t}else if(xml_api_";
  protected final String TEXT_214 = ".isEmpty(node_";
  protected final String TEXT_215 = ") || xml_api_";
  protected final String TEXT_216 = ".isMissing(node_";
  protected final String TEXT_217 = ")){" + NL + "                                    \t";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = " = ";
  protected final String TEXT_220 = ";" + NL + "                                \t}else{";
  protected final String TEXT_221 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_222 = ".isMissing(node_";
  protected final String TEXT_223 = ") || xml_api_";
  protected final String TEXT_224 = ".isEmpty(node_";
  protected final String TEXT_225 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " =";
  protected final String TEXT_228 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_229 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_230 = ".";
  protected final String TEXT_231 = " = str_";
  protected final String TEXT_232 = ";";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_234 = ".";
  protected final String TEXT_235 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_236 = ", ";
  protected final String TEXT_237 = ");";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = " = ParserUtils.parseTo_";
  protected final String TEXT_241 = "(str_";
  protected final String TEXT_242 = ");";
  protected final String TEXT_243 = NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_244 = NL + "    ";
  protected final String TEXT_245 = " = null;";
  protected final String TEXT_246 = NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_247 = "){";
  protected final String TEXT_248 = NL + "    throw(ex_";
  protected final String TEXT_249 = ");";
  protected final String TEXT_250 = NL + "    ";
  protected final String TEXT_251 = " = new ";
  protected final String TEXT_252 = "Struct();";
  protected final String TEXT_253 = NL + "            xml_api_";
  protected final String TEXT_254 = ".putRejectValueAfterExtract_";
  protected final String TEXT_255 = "(";
  protected final String TEXT_256 = ",";
  protected final String TEXT_257 = ");";
  protected final String TEXT_258 = NL + "     ";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = " = ";
  protected final String TEXT_261 = ".";
  protected final String TEXT_262 = ";";
  protected final String TEXT_263 = NL + "    ";
  protected final String TEXT_264 = ".errorJSONField = oraginalJsonStr_";
  protected final String TEXT_265 = ";";
  protected final String TEXT_266 = NL + "    ";
  protected final String TEXT_267 = ".errorMessage = ex_";
  protected final String TEXT_268 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_269 = ";";
  protected final String TEXT_270 = NL + "    ";
  protected final String TEXT_271 = " = null;";
  protected final String TEXT_272 = NL + "    System.err.println(ex_";
  protected final String TEXT_273 = ".getMessage());";
  protected final String TEXT_274 = NL + "    ";
  protected final String TEXT_275 = " = null;";
  protected final String TEXT_276 = NL + "    ";
  protected final String TEXT_277 = ".errorJSONField = oraginalJsonStr_";
  protected final String TEXT_278 = ";";
  protected final String TEXT_279 = NL + "    ";
  protected final String TEXT_280 = ".errorMessage = ex_";
  protected final String TEXT_281 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_282 = ";";
  protected final String TEXT_283 = NL + "        }" + NL + "    }" + NL + "    " + NL + "    isStructError_";
  protected final String TEXT_284 = " = false;" + NL;
  protected final String TEXT_285 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

String jsonField = ElementParameterParser.getValue(node, "__JSONFIELD__");
String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");

List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 
int schemaOptNum=1;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
    schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
//get JSON field content
IConnection inConn = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
List<IMetadataColumn> inColumns = null;
if (inConns!=null) {
    for (IConnection incomingConn : inConns) {
        if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            inConn = incomingConn;
            inColumns = inConn.getMetadataTable().getListColumns();
            break;
        }
    }
}
if (inConn!=null) {
    for (IMetadataColumn inputCol : inColumns) {
        if(inputCol.getLabel().equals(jsonField))
        {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(jsonField);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(jsonField);
    stringBuffer.append(TEXT_7);
    
            break;
        }
    }
}

    stringBuffer.append(TEXT_8);
    

String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName(); 
}

IConnection outConn = null;
String firstConnName = "";
List< ? extends IConnection> outConns = node.getOutgoingConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            outConn = conn;
            firstConnName = outConn.getName();
            break;
        }
    }
}

if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    
        }
    }
}

if (outConn!=null) {

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(encoding);
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
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
    if(dieOnError){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
    }else{
        if(!("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_66);
    
            if(inConn!=null){
                int columnNo=0;
                for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                    if(!jsonField.equals(column.getLabel())){
                        for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
                            if(inColumn.getLabel().equals(column.getLabel())){
                                if(schemaOptNum < mapping.size()){
                                    if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_71);
    
                                    }
                                    columnNo++;
                                }else{

    stringBuffer.append(TEXT_72);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_76);
    
                                }
                                break;
                            }
                        }
                    }
                }
            }

    stringBuffer.append(TEXT_77);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_83);
    
        } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    
        }
    }

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_100);
    
        }
    }
}

    stringBuffer.append(TEXT_101);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
        if(inConn!=null){
            int unExtractColNo=0;
            for (int i=0;i<mapping.size();i++) {
                if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
                    String query = mapping.get(i).get("QUERY");
                    if(query==null || query.trim().length() < 1 ){
                        for(IMetadataColumn inColumn:inColumns) {
                            if (inColumn.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
                                if(schemaOptNum < mapping.size()){
                                    if(unExtractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(unExtractColNo/schemaOptNum);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_112);
    
                                    }
                                    unExtractColNo++;
                                }else{

    stringBuffer.append(TEXT_113);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_117);
    
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        //get the mapping column 
        int extractColNo=0;
        for (int i=0;i<mapping.size();i++) {  //for S_0
            String query = mapping.get(i).get("QUERY");
            String nodeCheck = mapping.get(i).get("NODECHECK");
            if(schemaOptNum < mapping.size()){
                if(query!=null && query.trim().length()>0){  // if S_0_0
                    if(extractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(extractColNo/schemaOptNum);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_121);
    if(inConn!=null){
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    
                    }
                    extractColNo++;
                }
            }else{
              if(query!=null && query.trim().length()>0){  // if S_0_0
            		if("true".equals(nodeCheck)){
						if((".").equals(query.substring(1,query.length()-1)) && ("/").equals(loopQuery.substring(1,loopQuery.length()-1))){

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    
						}
					}

    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
                    if(("true").equals(nodeCheck)){

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
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
                    }else{

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    
                    }

    stringBuffer.append(TEXT_177);
    
                for(IMetadataColumn column:outConn.getMetadataTable().getListColumns()) { // for S_0_0_0
                    if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // if S_0_0_0_0
                        if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { //if S_0_0_0_0_0
                            
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
                            
                            if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_178);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    
                                continue;
                            }
                            if(javaType == JavaTypesManager.STRING){
								if(column.isNullable()){

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_198);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_208);
    
								}
                            }else{ // other type
								if(column.isNullable()){

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_220);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_228);
    
								}
							}
							if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_229);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_231);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_232);
    
							} else {
								if (javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_233);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_235);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_237);
    
								} else {

    stringBuffer.append(TEXT_238);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_240);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_241);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_242);
    
								}
							}

    stringBuffer.append(TEXT_243);
    
                            break;
                        } // if S_0_0_0_0_1
                    } // if S_0_0_0_1
                } // for S_0_0_1
              }// if S_0_1
            }
        } // for S_1
        if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_244);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_245);
    
        }

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    
    if(dieOnError){

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    
    }else{
        if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_250);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_252);
    
            int columnNo=0;
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                if(schemaOptNum < mapping.size()){
                    if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_257);
    
                    }
                    columnNo++;
                }else{

    stringBuffer.append(TEXT_258);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_260);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_262);
    
                }
            }

    stringBuffer.append(TEXT_263);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_271);
    
        } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_275);
    
        } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_276);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_282);
    
        }
    }

    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    
}

    stringBuffer.append(TEXT_285);
    return stringBuffer.toString();
  }
}

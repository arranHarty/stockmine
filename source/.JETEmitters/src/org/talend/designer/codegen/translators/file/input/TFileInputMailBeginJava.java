package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TFileInputMailBeginJava
{
  protected static String nl;
  public static synchronized TFileInputMailBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputMailBeginJava result = new TFileInputMailBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " " + NL + "\tif(!(";
  protected final String TEXT_3 = ").endsWith(\"/\")){" + NL + "           globalMap.put(\"";
  protected final String TEXT_4 = "_EXPORTED_FILE_PATH\",";
  protected final String TEXT_5 = " + \"/\");" + NL + "        \t\t}else" + NL + "        \t\t{" + NL + "        globalMap.put(\"";
  protected final String TEXT_6 = "_EXPORTED_FILE_PATH\",";
  protected final String TEXT_7 = ");" + NL + "        \t\t}" + NL + "" + NL + "///////////////////////////////////     " + NL + "   String [] mailParts_";
  protected final String TEXT_8 = " = new String [] {";
  protected final String TEXT_9 = NL + "\t \t";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = NL + "\t};" + NL + "   String [] mailChecked_";
  protected final String TEXT_12 = " = new String [] {";
  protected final String TEXT_13 = NL + "\t \t\"";
  protected final String TEXT_14 = "\",";
  protected final String TEXT_15 = NL + "\t};" + NL + "\t   String [] mailSeparator_";
  protected final String TEXT_16 = " = new String [] {";
  protected final String TEXT_17 = NL + "\t\t\t";
  protected final String TEXT_18 = ",";
  protected final String TEXT_19 = NL + "\t \t\t";
  protected final String TEXT_20 = ",";
  protected final String TEXT_21 = NL + "\t};" + NL + "java.io.FileInputStream fileInput";
  protected final String TEXT_22 = "=null;\t" + NL + "\t" + NL + "class DecodeString_";
  protected final String TEXT_23 = " {" + NL + "\t";
  protected final String TEXT_24 = NL + "\tpublic String decode(String str){" + NL + "\t\tif(str==null){" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tString res = \"\";" + NL + "\t\tint first = str.indexOf(\"=?\");" + NL + "\t    int last = str.indexOf(\"?=\");" + NL + "\t\tif(first!=-1 && last!=-1){" + NL + "\t\t\ttry {" + NL + "\t\t\t\tres = str.substring(0,first)+javax.mail.internet.MimeUtility.decodeWord(str.substring(first,last+2))+str.substring(last+2);" + NL + "\t\t\t\tif(res.equals(str)){" + NL + "\t\t\t\t\treturn res;" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\treturn decode(res);" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\treturn str;" + NL + "\t\t\t}" + NL + "\t\t}else{" + NL + "\t\t\treturn str;" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "DecodeString_";
  protected final String TEXT_25 = " decode_";
  protected final String TEXT_26 = " = new DecodeString_";
  protected final String TEXT_27 = "();" + NL + "try{" + NL + "\tfileInput";
  protected final String TEXT_28 = " = new java.io.FileInputStream(";
  protected final String TEXT_29 = ");" + NL + "\tjavax.mail.Session session_";
  protected final String TEXT_30 = " = javax.mail.Session.getInstance(System.getProperties(), null);" + NL + "    javax.mail.internet.MimeMessage msg_";
  protected final String TEXT_31 = " = new javax.mail.internet.MimeMessage(session_";
  protected final String TEXT_32 = ", fileInput";
  protected final String TEXT_33 = ");" + NL + "\tjava.util.List<String> list_";
  protected final String TEXT_34 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "\tfor (int i_";
  protected final String TEXT_35 = " =0;i_";
  protected final String TEXT_36 = " < mailParts_";
  protected final String TEXT_37 = ".length;i_";
  protected final String TEXT_38 = "++)" + NL + "\t{\t\t\t\t" + NL + "\t\tString part_";
  protected final String TEXT_39 = " = mailParts_";
  protected final String TEXT_40 = "[i_";
  protected final String TEXT_41 = "];" + NL + "       \tString sep_";
  protected final String TEXT_42 = "= mailSeparator_";
  protected final String TEXT_43 = "[i_";
  protected final String TEXT_44 = "];" + NL + "        if(part_";
  protected final String TEXT_45 = ".equalsIgnoreCase(\"body\"))" + NL + "        {        " + NL + "             if(msg_";
  protected final String TEXT_46 = ".isMimeType(\"multipart/*\")) {" + NL + "                 javax.mail.Multipart mp";
  protected final String TEXT_47 = " = (javax.mail.Multipart) msg_";
  protected final String TEXT_48 = ".getContent();" + NL + "                 for (int i = 0; i < mp";
  protected final String TEXT_49 = ".getCount(); i++) {" + NL + "                     javax.mail.BodyPart mpart";
  protected final String TEXT_50 = " = mp";
  protected final String TEXT_51 = ".getBodyPart(i);" + NL + "                     String disposition";
  protected final String TEXT_52 = " = mpart";
  protected final String TEXT_53 = ".getDisposition();" + NL + "                     if (!((disposition";
  protected final String TEXT_54 = " != null) && ((disposition";
  protected final String TEXT_55 = NL + "                                .equals(javax.mail.Part.ATTACHMENT)) || (disposition";
  protected final String TEXT_56 = ".equals(javax.mail.Part.INLINE)))))" + NL + "                     {   " + NL + "                        \t// the following extract the body part(text/plain + text/html)" + NL + "                        try{" + NL + "    \t\t\t\t\t\tObject content_";
  protected final String TEXT_57 = " = mpart";
  protected final String TEXT_58 = ".getContent();" + NL + "    \t\t\t\t\t\tif (content_";
  protected final String TEXT_59 = " instanceof javax.mail.internet.MimeMultipart) {" + NL + "    \t\t\t\t\t\t\tjavax.mail.internet.MimeMultipart mimeMultipart_";
  protected final String TEXT_60 = " = (javax.mail.internet.MimeMultipart) content_";
  protected final String TEXT_61 = ";" + NL + "    \t\t\t\t\t\t\tfor (int j_";
  protected final String TEXT_62 = " = 0; j_";
  protected final String TEXT_63 = " < mimeMultipart_";
  protected final String TEXT_64 = " .getCount(); j_";
  protected final String TEXT_65 = "++) {" + NL + "    \t\t\t\t\t\t\t\tjavax.mail.BodyPart bodyPart_";
  protected final String TEXT_66 = " = mimeMultipart_";
  protected final String TEXT_67 = " .getBodyPart(j_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = "    \t\t\t\t\t\t\t\t" + NL + "    \t\t\t\t\t\t\t\tObject content_";
  protected final String TEXT_70 = "_body = bodyPart_";
  protected final String TEXT_71 = ".getContent();" + NL + "    \t\t\t\t\t\t\t\tif (content_";
  protected final String TEXT_72 = "_body instanceof javax.mail.internet.MimeMultipart) {" + NL + "    \t\t\t\t\t\t\t\t\tjavax.mail.internet.MimeMultipart mimeMultipart_";
  protected final String TEXT_73 = "_body = (javax.mail.internet.MimeMultipart) content_";
  protected final String TEXT_74 = "_body;" + NL + "    \t\t\t\t\t\t\t\t\tfor(int j_";
  protected final String TEXT_75 = "_body = 0; j_";
  protected final String TEXT_76 = "_body < mimeMultipart_";
  protected final String TEXT_77 = "_body.getCount(); j_";
  protected final String TEXT_78 = "_body++){" + NL + "    \t\t\t\t\t\t\t\t\t\tjavax.mail.BodyPart bodyPart_";
  protected final String TEXT_79 = "_body = mimeMultipart_";
  protected final String TEXT_80 = "_body.getBodyPart(j_";
  protected final String TEXT_81 = "_body);" + NL + "    \t\t\t\t\t\t\t\t\t\tif (bodyPart_";
  protected final String TEXT_82 = "_body.isMimeType(\"text/*\")) {" + NL + "    \t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_83 = ".add(bodyPart_";
  protected final String TEXT_84 = "_body.getContent().toString());" + NL + "    \t\t\t\t\t\t\t\t\t\t} else {" + NL + "    \t\t\t\t\t\t\t\t\t\t\tSystem.out.println(\"Ignore the part \" + bodyPart_";
  protected final String TEXT_85 = "_body.getContentType());" + NL + "    \t\t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\telse{" + NL + "    \t\t\t\t\t\t\t\t\tif (bodyPart_";
  protected final String TEXT_86 = ".isMimeType(\"text/*\")) {" + NL + "    \t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_87 = ".add(bodyPart_";
  protected final String TEXT_88 = ".getContent().toString());" + NL + "    \t\t\t\t\t\t\t\t\t} else {" + NL + "    \t\t\t\t\t\t\t\t\t\tSystem.out.println(\"Ignore the part \" + bodyPart_";
  protected final String TEXT_89 = ".getContentType());" + NL + "    \t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t} else {    " + NL + "    \t\t\t\t\t\t\tlist_";
  protected final String TEXT_90 = ".add(mpart";
  protected final String TEXT_91 = ".getContent().toString());" + NL + "    \t\t\t\t\t\t}    " + NL + "    \t\t\t\t\t}catch (java.io.UnsupportedEncodingException e){" + NL + "\t\t\t\t\t\t\tjava.io.ByteArrayOutputStream bao_";
  protected final String TEXT_92 = " = new java.io.ByteArrayOutputStream();" + NL + "\t\t\t\t\t\t\tmpart";
  protected final String TEXT_93 = ".writeTo(bao_";
  protected final String TEXT_94 = ");" + NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_95 = ".add(bao_";
  protected final String TEXT_96 = ".toString());" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_97 = NL + "                     }else if(disposition";
  protected final String TEXT_98 = " != null && disposition";
  protected final String TEXT_99 = ".equals(javax.mail.Part.INLINE)){" + NL + "    \t\t\t\t\tlist_";
  protected final String TEXT_100 = ".add(mpart";
  protected final String TEXT_101 = ".getContent().toString());" + NL + "    \t\t\t\t }" + NL + "                 }" + NL + "     \t\t } else {" + NL + "     \t\t    java.io.InputStream in_";
  protected final String TEXT_102 = " = msg_";
  protected final String TEXT_103 = ".getInputStream();" + NL + "     \t\t    byte[] buffer_";
  protected final String TEXT_104 = " = new byte[1024];" + NL + "     \t\t    int length_";
  protected final String TEXT_105 = " = 0;" + NL + "     \t\t    java.io.ByteArrayOutputStream baos_";
  protected final String TEXT_106 = " =  new java.io.ByteArrayOutputStream();" + NL + "     \t\t    while ((length_";
  protected final String TEXT_107 = " = in_";
  protected final String TEXT_108 = ".read(buffer_";
  protected final String TEXT_109 = ", 0, 1024)) != -1) {" + NL + "     \t\t        baos_";
  protected final String TEXT_110 = ".write(buffer_";
  protected final String TEXT_111 = ", 0, length_";
  protected final String TEXT_112 = ");" + NL + "     \t\t    }" + NL + "     \t\t    String contentType_";
  protected final String TEXT_113 = " = msg_";
  protected final String TEXT_114 = ".getContentType();" + NL + "     \t\t    String charsetName_";
  protected final String TEXT_115 = " = \"\";" + NL + "     \t\t    if(contentType_";
  protected final String TEXT_116 = "!=null && contentType_";
  protected final String TEXT_117 = ".trim().length()>0){" + NL + "     \t\t    \tjavax.mail.internet.ContentType cy_";
  protected final String TEXT_118 = "  = new javax.mail.internet.ContentType(contentType_";
  protected final String TEXT_119 = ");" + NL + "     \t\t    \tcharsetName_";
  protected final String TEXT_120 = " = cy_";
  protected final String TEXT_121 = ".getParameter(\"charset\");" + NL + "     \t\t    }" + NL + "     \t\t    if(charsetName_";
  protected final String TEXT_122 = "!=null && charsetName_";
  protected final String TEXT_123 = ".length()>0){" + NL + "     \t\t    \tlist_";
  protected final String TEXT_124 = ".add(baos_";
  protected final String TEXT_125 = ".toString(charsetName_";
  protected final String TEXT_126 = "));" + NL + "     \t\t    }else{" + NL + "     \t\t    \tlist_";
  protected final String TEXT_127 = ".add(baos_";
  protected final String TEXT_128 = ".toString());" + NL + "     \t\t    }" + NL + "     \t\t    in_";
  protected final String TEXT_129 = ".close();" + NL + "     \t\t    baos_";
  protected final String TEXT_130 = ".close();" + NL + "     \t\t }" + NL + "        }else if(part_";
  protected final String TEXT_131 = ".equalsIgnoreCase(\"header\")){" + NL + "            java.util.Enumeration em = msg_";
  protected final String TEXT_132 = ".getAllHeaderLines();" + NL + "            int em_count=0;" + NL + "            " + NL + "            String tempStr_";
  protected final String TEXT_133 = "=\"\";" + NL + "            " + NL + "\t\t\twhile (em.hasMoreElements()) {" + NL + "\t\t\t\ttempStr_";
  protected final String TEXT_134 = " = tempStr_";
  protected final String TEXT_135 = " + (String) em.nextElement() + sep_";
  protected final String TEXT_136 = " ;" + NL + "\t\t\t}" + NL + "\t\t\tlist_";
  protected final String TEXT_137 = ".add(decode_";
  protected final String TEXT_138 = ".decode(tempStr_";
  protected final String TEXT_139 = "));" + NL + "        }else{" + NL + "        \tif((\"true\").equals(mailChecked_";
  protected final String TEXT_140 = "[i_";
  protected final String TEXT_141 = "])){   " + NL + "\t\t\t\tString[] sa_";
  protected final String TEXT_142 = " = msg_";
  protected final String TEXT_143 = ".getHeader(part_";
  protected final String TEXT_144 = ");" + NL + "\t\t\t\tString tempStr_";
  protected final String TEXT_145 = "=\"\";" + NL + "\t\t\t\tfor(int i=0;i<sa_";
  protected final String TEXT_146 = ".length;i++){" + NL + "\t\t\t\t\ttempStr_";
  protected final String TEXT_147 = "=tempStr_";
  protected final String TEXT_148 = "+sa_";
  protected final String TEXT_149 = "[i] + sep_";
  protected final String TEXT_150 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t\tlist_";
  protected final String TEXT_151 = ".add(decode_";
  protected final String TEXT_152 = ".decode(tempStr_";
  protected final String TEXT_153 = "));" + NL + "        \t}else{ " + NL + "\t           String content_";
  protected final String TEXT_154 = " = msg_";
  protected final String TEXT_155 = ".getHeader(part_";
  protected final String TEXT_156 = ", null);" + NL + "\t           list_";
  protected final String TEXT_157 = ".add(decode_";
  protected final String TEXT_158 = ".decode(content_";
  protected final String TEXT_159 = "));" + NL + "           \t}    " + NL + "        }   " + NL + " \t}   " + NL + "\t" + NL + "" + NL + "\t" + NL + " \t//attachment Deal" + NL + " \tif(msg_";
  protected final String TEXT_160 = ".isMimeType(\"multipart/*\")){" + NL + " \t      javax.mail.Multipart mp";
  protected final String TEXT_161 = " = (javax.mail.Multipart) msg_";
  protected final String TEXT_162 = ".getContent();" + NL + " \t      String attachfileName";
  protected final String TEXT_163 = " = \"\";" + NL + " \t      String path";
  protected final String TEXT_164 = " = \"\";" + NL + " \t      java.io.BufferedOutputStream out";
  protected final String TEXT_165 = " = null;" + NL + " \t      java.io.BufferedInputStream in";
  protected final String TEXT_166 = " = null;" + NL + "            for (int i = 0; i < mp";
  protected final String TEXT_167 = ".getCount(); i++) {" + NL + "                javax.mail.BodyPart mpart";
  protected final String TEXT_168 = " = mp";
  protected final String TEXT_169 = ".getBodyPart(i);" + NL + "                String disposition";
  protected final String TEXT_170 = " = mpart";
  protected final String TEXT_171 = ".getDisposition();";
  protected final String TEXT_172 = "                " + NL + "                if ((disposition";
  protected final String TEXT_173 = " != null) && mpart";
  protected final String TEXT_174 = ".getFileName()!=null" + NL + "                        && ((disposition";
  protected final String TEXT_175 = ".equals(javax.mail.Part.ATTACHMENT)) ||" + NL + "                        (disposition";
  protected final String TEXT_176 = ".equals(javax.mail.Part.INLINE)))) {" + NL + "                    attachfileName";
  protected final String TEXT_177 = " = mpart";
  protected final String TEXT_178 = ".getFileName();" + NL + "                    " + NL + "                    if (attachfileName";
  protected final String TEXT_179 = ".indexOf(\"=?\") != -1){" + NL + "                      int m_";
  protected final String TEXT_180 = " = 2, n_";
  protected final String TEXT_181 = ";" + NL + "                      n_";
  protected final String TEXT_182 = " = attachfileName";
  protected final String TEXT_183 = ".indexOf(63, m_";
  protected final String TEXT_184 = "); // the first ? location " + NL + "                      String sCharSet_";
  protected final String TEXT_185 = " = attachfileName";
  protected final String TEXT_186 = ".substring(attachfileName";
  protected final String TEXT_187 = ".indexOf(\"=?\") + 2, n_";
  protected final String TEXT_188 = "); // the character set value         " + NL + "                      m_";
  protected final String TEXT_189 = " = n_";
  protected final String TEXT_190 = " + 1;                      " + NL + "                      n_";
  protected final String TEXT_191 = " = attachfileName";
  protected final String TEXT_192 = ".indexOf(63, m_";
  protected final String TEXT_193 = "); // the second ? location                      " + NL + "                      String flag_";
  protected final String TEXT_194 = " = attachfileName";
  protected final String TEXT_195 = ".substring(m_";
  protected final String TEXT_196 = ", n_";
  protected final String TEXT_197 = ");" + NL + "                      m_";
  protected final String TEXT_198 = " = n_";
  protected final String TEXT_199 = " + 1;" + NL + "                      n_";
  protected final String TEXT_200 = " = attachfileName";
  protected final String TEXT_201 = ".indexOf(\"?=\", m_";
  protected final String TEXT_202 = ");                      " + NL + "                      String sNameCode_";
  protected final String TEXT_203 = " = attachfileName";
  protected final String TEXT_204 = ".substring(m_";
  protected final String TEXT_205 = ", n_";
  protected final String TEXT_206 = ");                  " + NL + "                      java.io.ByteArrayInputStream byteArrIS_";
  protected final String TEXT_207 = " = new java.io.ByteArrayInputStream(sNameCode_";
  protected final String TEXT_208 = ".getBytes());                      " + NL + "                      Object obj_";
  protected final String TEXT_209 = " = null;" + NL + "                      " + NL + "                      if (flag_";
  protected final String TEXT_210 = ".equalsIgnoreCase(\"B\")) {" + NL + "                        obj_";
  protected final String TEXT_211 = " = new com.sun.mail.util.BASE64DecoderStream(byteArrIS_";
  protected final String TEXT_212 = ");                    " + NL + "                      } else if (flag_";
  protected final String TEXT_213 = ".equalsIgnoreCase(\"Q\")) {" + NL + "                        obj_";
  protected final String TEXT_214 = " = new com.sun.mail.util.QDecoderStream(byteArrIS_";
  protected final String TEXT_215 = ");" + NL + "                      }" + NL + "                      " + NL + "                      if (obj_";
  protected final String TEXT_216 = " != null){" + NL + "                        int k_";
  protected final String TEXT_217 = " = byteArrIS_";
  protected final String TEXT_218 = ".available();" + NL + "                        byte[] arrByte_";
  protected final String TEXT_219 = " = new byte[k_";
  protected final String TEXT_220 = "];" + NL + "                        k_";
  protected final String TEXT_221 = " = ((java.io.InputStream) (obj_";
  protected final String TEXT_222 = ")).read(arrByte_";
  protected final String TEXT_223 = ", 0, k_";
  protected final String TEXT_224 = ");" + NL + "                        attachfileName";
  protected final String TEXT_225 = " = new String(arrByte_";
  protected final String TEXT_226 = ", 0, k_";
  protected final String TEXT_227 = ", sCharSet_";
  protected final String TEXT_228 = ");" + NL + "                      }" + NL + "                    }" + NL + "                    " + NL + "                     if(!(";
  protected final String TEXT_229 = ").endsWith(\"/\")){" + NL + "           \t\t\t\t path";
  protected final String TEXT_230 = " = ";
  protected final String TEXT_231 = " + \"/\";" + NL + "        \t\t\t\t}else" + NL + "        \t\t\t\t{" + NL + "        \t\t\t\t\tpath";
  protected final String TEXT_232 = " =";
  protected final String TEXT_233 = ";" + NL + "        \t\t\t\t}" + NL + "                    path";
  protected final String TEXT_234 = " = path";
  protected final String TEXT_235 = " + attachfileName";
  protected final String TEXT_236 = ";" + NL + "                    java.io.File attachFile  = new java.io.File(path";
  protected final String TEXT_237 = ");" + NL + "                    out";
  protected final String TEXT_238 = " = new java.io.BufferedOutputStream(new java.io.FileOutputStream(attachFile));" + NL + "                    in";
  protected final String TEXT_239 = " = new java.io.BufferedInputStream(mpart";
  protected final String TEXT_240 = ".getInputStream());" + NL + "                    int buffer";
  protected final String TEXT_241 = " = 0;" + NL + "                    while ((buffer";
  protected final String TEXT_242 = " = in";
  protected final String TEXT_243 = ".read()) != -1) {" + NL + "                           out";
  protected final String TEXT_244 = ".write(buffer";
  protected final String TEXT_245 = ");" + NL + "                           out";
  protected final String TEXT_246 = ".flush();" + NL + "                         }   " + NL + "                        out";
  protected final String TEXT_247 = ".close();" + NL + "                        in";
  protected final String TEXT_248 = ".close();    " + NL + "                }" + NL + "            }" + NL + " \t}" + NL + " \t         " + NL + " \t          " + NL + "// for output";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_250 = " < list_";
  protected final String TEXT_251 = ".size() && list_";
  protected final String TEXT_252 = ".get(";
  protected final String TEXT_253 = ")!=null){\t\t\t\t";
  protected final String TEXT_254 = NL + "\t\t\t\t\t";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = " = (String)list_";
  protected final String TEXT_257 = ".get(";
  protected final String TEXT_258 = ");";
  protected final String TEXT_259 = NL + "\t\t\t\t\t";
  protected final String TEXT_260 = ".";
  protected final String TEXT_261 = " = ParserUtils.parseTo_Date(list_";
  protected final String TEXT_262 = ".get(";
  protected final String TEXT_263 = "), ";
  protected final String TEXT_264 = ");";
  protected final String TEXT_265 = NL + "\t\t\t\t\t";
  protected final String TEXT_266 = ".";
  protected final String TEXT_267 = " = list_";
  protected final String TEXT_268 = ".get(";
  protected final String TEXT_269 = ").getBytes();";
  protected final String TEXT_270 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = " = ParserUtils.parseTo_";
  protected final String TEXT_273 = "(list_";
  protected final String TEXT_274 = ".get(";
  protected final String TEXT_275 = "));";
  protected final String TEXT_276 = NL + "\t\t\t" + NL + "\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_277 = ".";
  protected final String TEXT_278 = " = ";
  protected final String TEXT_279 = ";" + NL + "\t\t\t}" + NL;
  protected final String TEXT_280 = NL + "      \t\t\t";
  protected final String TEXT_281 = ".";
  protected final String TEXT_282 = " = ";
  protected final String TEXT_283 = ".";
  protected final String TEXT_284 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_285 = NL + "}" + NL;
  protected final String TEXT_286 = NL + "catch (java.lang.Exception e){" + NL + "//nothing to do, ignore the exception if don't die on error" + NL + "System.err.println(\"Exception in component ";
  protected final String TEXT_287 = ": \" + e.getMessage());" + NL + "}";
  protected final String TEXT_288 = NL + NL + "finally{" + NL + "\tif(fileInput";
  protected final String TEXT_289 = "!=null)" + NL + "\t\t\tfileInput";
  protected final String TEXT_290 = ".close();" + NL + "} " + NL + "////////////////////////////";
  protected final String TEXT_291 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        // component id
        String cid = node.getUniqueName();
        String filename = ElementParameterParser.getValue(node,"__FILENAME__");
        String directory = ElementParameterParser.getValue(node,"__ATTACHMENT_PATH__");
        List<Map<String, String>> mailParts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAIL_PARTS__");
        
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
	for (int i=0; i<mailParts.size(); i++) {
	   Map<String, String> lineValue = mailParts.get(i);

    stringBuffer.append(TEXT_9);
    stringBuffer.append( lineValue.get("MAIL_PART") );
    stringBuffer.append(TEXT_10);
    
	}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
	for (int i=0; i<mailParts.size(); i++) {
	   Map<String, String> lineValue = mailParts.get(i);

    stringBuffer.append(TEXT_13);
    stringBuffer.append( lineValue.get("MULTI_VALUE") );
    stringBuffer.append(TEXT_14);
    
	}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
	for (int i=0; i<mailParts.size(); i++) {
	   Map<String, String> lineValue = mailParts.get(i);
	   if(("").equals(lineValue.get("PART_SEPARATOR"))){

    stringBuffer.append(TEXT_17);
    stringBuffer.append("\"\"");
    stringBuffer.append(TEXT_18);
    		}else{
    stringBuffer.append(TEXT_19);
    stringBuffer.append( lineValue.get("PART_SEPARATOR") );
    stringBuffer.append(TEXT_20);
    
		}
	}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    //str is sth like : To:"=?ISO8859-1?B?**code**?=" <sb@company.com> , "=?ISO8859-1?B?**code**?=" <sb@company.com>
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
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
    
    								//both picture and message context in the email body part, TDI-8651

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
					 //both attachment and message context in the email,bug TDI-19065

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
			    // fixed bug TDI-8586,to deal with attachments download

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
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
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

			List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_249);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_253);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String and Object

    stringBuffer.append(TEXT_254);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_258);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_259);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_263);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_264);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_265);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_269);
    
					}else  { //other

    stringBuffer.append(TEXT_270);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_275);
    
					}

    stringBuffer.append(TEXT_276);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_279);
    			
			} //4
		}//3
		
		
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_280);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_284);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1


    stringBuffer.append(TEXT_285);
     if(!dieOnError){ 
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    
  }

    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    
  }
}  
 
    stringBuffer.append(TEXT_291);
    return stringBuffer.toString();
  }
}

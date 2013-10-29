package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomInputLoopBeginJava
{
  protected static String nl;
  public static synchronized TMomInputLoopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputLoopBeginJava result = new TMomInputLoopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "javax.jms.Connection connection_";
  protected final String TEXT_3 = " = null;" + NL + "try {" + NL;
  protected final String TEXT_4 = NL + "\t    connection_";
  protected final String TEXT_5 = " = null;" + NL + "\t    javax.jms.Session session_";
  protected final String TEXT_6 = " = null;" + NL + "            try {" + NL + "\t        connection_";
  protected final String TEXT_7 = " = (javax.jms.Connection) globalMap.get(\"connection_";
  protected final String TEXT_8 = "\");" + NL + "                connection_";
  protected final String TEXT_9 = ".start();" + NL + "\t\tsession_";
  protected final String TEXT_10 = " = (javax.jms.Session) globalMap.get(\"session_";
  protected final String TEXT_11 = "\");" + NL + "\t    } catch (NullPointerException npe) {" + NL + "\t    throw new RuntimeException(\"";
  protected final String TEXT_12 = " still not initialized. Try to redesign job.\");" + NL + "\t    }" + NL + "\t    javax.jms.Destination des_";
  protected final String TEXT_13 = " = null;" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t\tdes_";
  protected final String TEXT_15 = " = session_";
  protected final String TEXT_16 = ".createQueue(";
  protected final String TEXT_17 = ");" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t    \tdes_";
  protected final String TEXT_19 = " = session_";
  protected final String TEXT_20 = ".createTopic(";
  protected final String TEXT_21 = ");" + NL + "\t\t";
  protected final String TEXT_22 = NL + NL + "\t\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_23 = " = session_";
  protected final String TEXT_24 = ".createProducer(null);" + NL + "\t\treplyProducer_";
  protected final String TEXT_25 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_26 = " = session_";
  protected final String TEXT_27 = ".createConsumer(des_";
  protected final String TEXT_28 = ");" + NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_29 = " = null;" + NL + "" + NL + "\t\tglobalMap.put(\"producer_";
  protected final String TEXT_30 = "\",producer_";
  protected final String TEXT_31 = ");" + NL + "\t\tglobalMap.put(\"session_";
  protected final String TEXT_32 = "\",session_";
  protected final String TEXT_33 = ");" + NL + "\t\tglobalMap.put(\"connection_";
  protected final String TEXT_34 = "\",connection_";
  protected final String TEXT_35 = ");" + NL + "\t\t" + NL + "\t\t// Receive message" + NL + "\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\tSystem.out.println(\"We will consume messages while they continue to be delivered \");" + NL + "\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_37 = ";" + NL + "\t\t\t\twhile ((message_";
  protected final String TEXT_38 = " = consumer_";
  protected final String TEXT_39 = ".receive()) != null) {" + NL + "" + NL + "" + NL + "\t\t";
  protected final String TEXT_40 = NL + "        \ttry {   // For rollback" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\tint maxMsg_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ";" + NL + "\t\t\t\tSystem.out.println(\"We are about to wait until we consume: \" + maxMsg_";
  protected final String TEXT_45 = " + \" message(s) then we will shutdown\");" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_46 = " = 0; i_";
  protected final String TEXT_47 = " < maxMsg_";
  protected final String TEXT_48 = " ;) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_49 = NL + "        \ttry {   // For rollback" + NL + "" + NL + "\t\t";
  protected final String TEXT_50 = NL + "\t\t\t        javax.jms.Message message_";
  protected final String TEXT_51 = " = consumer_";
  protected final String TEXT_52 = ".receive();" + NL + "\t\t\t        if (message_";
  protected final String TEXT_53 = " != null) {" + NL + "\t\t            \ti_";
  protected final String TEXT_54 = "++;" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t    System.out.println(\"We will wait for messages within: \" + ";
  protected final String TEXT_56 = "*1000 + \" ms, and then we will shutdown\");" + NL + "\t\t\t    javax.jms.Message message_";
  protected final String TEXT_57 = ";" + NL + "\t\t\t    while ((message_";
  protected final String TEXT_58 = " = consumer_";
  protected final String TEXT_59 = ".receive(";
  protected final String TEXT_60 = "*1000)) != null) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_61 = NL + "        \ttry {   // For rollback" + NL + "" + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t    " + NL + "\t\t/*-----------------------------------------------------------4.judge message body type---------------------------------------*/" + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\t\tif (message_";
  protected final String TEXT_65 = " instanceof javax.jms.MapMessage) {" + NL + "\t\t\t\tjavax.jms.MapMessage txtMsg_";
  protected final String TEXT_66 = " = (javax.jms.MapMessage) message_";
  protected final String TEXT_67 = ";" + NL + "\t\t\t\tString msg_";
  protected final String TEXT_68 = " = txtMsg_";
  protected final String TEXT_69 = ".getString(";
  protected final String TEXT_70 = ");" + NL + "\t\t\t\tif(msg_";
  protected final String TEXT_71 = " !=null){" + NL + "" + NL + "\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\tjavax.jms.TextMessage txtMsg_";
  protected final String TEXT_73 = " = (javax.jms.TextMessage) message_";
  protected final String TEXT_74 = ";" + NL + "\t\t\t\tString msg_";
  protected final String TEXT_75 = " = txtMsg_";
  protected final String TEXT_76 = ".getText();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\tjavax.jms.BytesMessage bytesMsg_";
  protected final String TEXT_78 = " = (javax.jms.BytesMessage) message_";
  protected final String TEXT_79 = ";" + NL + "\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_80 = " = new byte[(int)bytesMsg_";
  protected final String TEXT_81 = ".getBodyLength()];" + NL + "\t\t\t\tbytesMsg_";
  protected final String TEXT_82 = ".readBytes(bytesMsgBody_";
  protected final String TEXT_83 = ");" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\tString msg_";
  protected final String TEXT_85 = " = new String(bytesMsgBody_";
  protected final String TEXT_86 = ");" + NL + "\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\tjavax.jms.MapMessage  msg_";
  protected final String TEXT_88 = "  = (javax.jms.MapMessage) message_";
  protected final String TEXT_89 = ";" + NL + "\t\t\t";
  protected final String TEXT_90 = NL + NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\tjava.util.Hashtable props_";
  protected final String TEXT_92 = "=new java.util.Hashtable();" + NL + "\t\t\tprops_";
  protected final String TEXT_93 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\tprops_";
  protected final String TEXT_94 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_95 = "+\":\"+";
  protected final String TEXT_96 = ");" + NL + "\t\t\tprops_";
  protected final String TEXT_97 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\tprops_";
  protected final String TEXT_98 = ".put(javax.naming.Context.URL_PKG_PREFIXES, \"org.jboss.naming\");" + NL + "\t\t\tprops_";
  protected final String TEXT_99 = ".put(\"java.naming.factory.url.pkgs\",\"org.jboss.naming:org.jnp.interfaces\");\t" + NL + "\t\t\t" + NL + "\t\t\tjavax.naming.Context context_";
  protected final String TEXT_100 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_101 = ");" + NL + "\t\t\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_102 = "=(javax.jms.ConnectionFactory)context_";
  protected final String TEXT_103 = ".lookup(\"ConnectionFactory\");\t" + NL + "\t\t";
  protected final String TEXT_104 = NL + "\t\t\tString url_";
  protected final String TEXT_105 = " =\"\";";
  protected final String TEXT_106 = NL + "\t\t\turl_";
  protected final String TEXT_107 = " = \"failover:(\";" + NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_109 = " = url_";
  protected final String TEXT_110 = " +\",\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_112 = " = url_";
  protected final String TEXT_113 = " +\"tcp://\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_114 = " = url_";
  protected final String TEXT_115 = " +";
  protected final String TEXT_116 = ";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_117 = " = url_";
  protected final String TEXT_118 = " +\":\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_119 = " = url_";
  protected final String TEXT_120 = " +";
  protected final String TEXT_121 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\turl_";
  protected final String TEXT_123 = " = url_";
  protected final String TEXT_124 = " +\")?randomize=false\";" + NL + "\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\turl_";
  protected final String TEXT_126 = " = \"tcp://\"+";
  protected final String TEXT_127 = "+\":\"+";
  protected final String TEXT_128 = ";" + NL + "\t\t\t";
  protected final String TEXT_129 = "\t\t\t" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\torg.apache.activemq.broker.BrokerService broker_";
  protected final String TEXT_131 = " = new org.apache.activemq.broker.BrokerService();" + NL + "\t\t\t\tbroker_";
  protected final String TEXT_132 = ".setUseJmx(true);" + NL + "\t\t\t\tbroker_";
  protected final String TEXT_133 = ".addConnector(url_";
  protected final String TEXT_134 = ");" + NL + "\t\t\t\tbroker_";
  protected final String TEXT_135 = ".start();" + NL + "\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_137 = ");" + NL + "\t\t\tSystem.out.println(\"Consuming \" + (";
  protected final String TEXT_138 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_139 = ");" + NL + "\t\t\t" + NL + "\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_140 = " = new org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_141 = ");" + NL + "\t\t";
  protected final String TEXT_142 = "\t\t" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t\t\tconnection_";
  protected final String TEXT_144 = " = factory_";
  protected final String TEXT_145 = ".createConnection();" + NL + "\t\t";
  protected final String TEXT_146 = NL + "\t\t\tconnection_";
  protected final String TEXT_147 = " = factory_";
  protected final String TEXT_148 = ".createConnection(";
  protected final String TEXT_149 = ",";
  protected final String TEXT_150 = ");" + NL + "\t\t";
  protected final String TEXT_151 = NL + "\t\tconnection_";
  protected final String TEXT_152 = ".start();" + NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_153 = " = connection_";
  protected final String TEXT_154 = ".createSession(";
  protected final String TEXT_155 = ", javax.jms.Session.";
  protected final String TEXT_156 = ");" + NL + "\t\tjavax.jms.Destination des_";
  protected final String TEXT_157 = " = null;" + NL + "" + NL + "" + NL + "" + NL + "\t\t";
  protected final String TEXT_158 = NL + "\t\t\tdes_";
  protected final String TEXT_159 = " = session_";
  protected final String TEXT_160 = ".createQueue(";
  protected final String TEXT_161 = ");" + NL + "\t\t";
  protected final String TEXT_162 = NL + "\t    \tdes_";
  protected final String TEXT_163 = " = session_";
  protected final String TEXT_164 = ".createTopic(";
  protected final String TEXT_165 = ");" + NL + "\t\t";
  protected final String TEXT_166 = NL + "\t\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_167 = " = session_";
  protected final String TEXT_168 = ".createProducer(null);" + NL + "\t\treplyProducer_";
  protected final String TEXT_169 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t\t" + NL + "\t\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_170 = " = session_";
  protected final String TEXT_171 = ".createConsumer(des_";
  protected final String TEXT_172 = ");" + NL + "\t\t" + NL + "\t\t// BS" + NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_173 = " = null;" + NL + "" + NL + "\t\t";
  protected final String TEXT_174 = NL + "    \t\tglobalMap.put(\"producer_";
  protected final String TEXT_175 = "\",producer_";
  protected final String TEXT_176 = ");" + NL + "\t\tglobalMap.put(\"session_";
  protected final String TEXT_177 = "\",session_";
  protected final String TEXT_178 = ");" + NL + "\t\tglobalMap.put(\"connection_";
  protected final String TEXT_179 = "\",connection_";
  protected final String TEXT_180 = ");";
  protected final String TEXT_181 = NL + NL + "\t\t";
  protected final String TEXT_182 = "\t\t\t\t\t" + NL + "\t\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\tjavax.jms.Message message_";
  protected final String TEXT_183 = ";" + NL + "\t\t" + NL + "\t\t\twhile((message_";
  protected final String TEXT_184 = "=consumer_";
  protected final String TEXT_185 = ".receive())!=null){" + NL + "" + NL + "\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\tSystem.out.println(\"We will consume messages while they continue to be delivered \");" + NL + "\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_187 = ";" + NL + "\t\t\t\twhile ((message_";
  protected final String TEXT_188 = " = consumer_";
  protected final String TEXT_189 = ".receive()) != null) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_190 = NL + "        \ttry {   // For rollback" + NL + "" + NL + "\t\t";
  protected final String TEXT_191 = NL + "\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\tint maxMsg_";
  protected final String TEXT_193 = " = ";
  protected final String TEXT_194 = ";" + NL + "\t\t\t\tSystem.out.println(\"We are about to wait until we consume: \" + maxMsg_";
  protected final String TEXT_195 = " + \" message(s) then we will shutdown\");" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_196 = " = 0; i_";
  protected final String TEXT_197 = " < maxMsg_";
  protected final String TEXT_198 = " ;) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_199 = NL + "        \ttry {   // For rollback" + NL + "" + NL + "\t\t";
  protected final String TEXT_200 = NL + "\t\t\t        javax.jms.Message message_";
  protected final String TEXT_201 = " = consumer_";
  protected final String TEXT_202 = ".receive();" + NL + "\t\t\t        if (message_";
  protected final String TEXT_203 = " != null) {" + NL + "\t\t            \ti_";
  protected final String TEXT_204 = "++;" + NL + "\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t    System.out.println(\"We will wait for messages within: \" + ";
  protected final String TEXT_206 = "*1000 + \" ms, and then we will shutdown\");" + NL + "\t\t\t    javax.jms.Message message_";
  protected final String TEXT_207 = ";" + NL + "\t\t\t    while ((message_";
  protected final String TEXT_208 = " = consumer_";
  protected final String TEXT_209 = ".receive(";
  protected final String TEXT_210 = "*1000)) != null) {" + NL + "" + NL + "\t\t";
  protected final String TEXT_211 = NL + "        \ttry {   // For rollback" + NL + "\t\t";
  protected final String TEXT_212 = NL + "\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\tif (message_";
  protected final String TEXT_214 = " instanceof javax.jms.MapMessage) {" + NL + "\t\t\t\tjavax.jms.MapMessage txtMsg_";
  protected final String TEXT_215 = " = (javax.jms.MapMessage) message_";
  protected final String TEXT_216 = ";" + NL + "\t\t\t\tString msg_";
  protected final String TEXT_217 = " = txtMsg_";
  protected final String TEXT_218 = ".getString(";
  protected final String TEXT_219 = ");" + NL + "\t\t\t\tif(msg_";
  protected final String TEXT_220 = " !=null){" + NL + "" + NL + "\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\tjavax.jms.TextMessage txtMsg_";
  protected final String TEXT_222 = " = (javax.jms.TextMessage) message_";
  protected final String TEXT_223 = ";" + NL + "\t\t\t\tString msg_";
  protected final String TEXT_224 = " = txtMsg_";
  protected final String TEXT_225 = ".getText();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_226 = NL + "\t\t\t\tjavax.jms.BytesMessage bytesMsg_";
  protected final String TEXT_227 = " = (javax.jms.BytesMessage) message_";
  protected final String TEXT_228 = ";" + NL + "\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_229 = " = new byte[(int)bytesMsg_";
  protected final String TEXT_230 = ".getBodyLength()];" + NL + "\t\t\t\tbytesMsg_";
  protected final String TEXT_231 = ".readBytes(bytesMsgBody_";
  protected final String TEXT_232 = ");" + NL + "\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\tString msg_";
  protected final String TEXT_234 = " = new String(bytesMsgBody_";
  protected final String TEXT_235 = ");" + NL + "\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\tjavax.jms.MapMessage  msg_";
  protected final String TEXT_237 = "  = (javax.jms.MapMessage) message_";
  protected final String TEXT_238 = ";" + NL + "\t\t\t";
  protected final String TEXT_239 = NL + "\t" + NL + "\t";
  protected final String TEXT_240 = NL + "\t\tjava.util.Hashtable properties";
  protected final String TEXT_241 = "=new java.util.Hashtable();" + NL + "\t\tproperties";
  protected final String TEXT_242 = ".put(\"hostname\", ";
  protected final String TEXT_243 = ");" + NL + "\t\tproperties";
  protected final String TEXT_244 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_245 = "));" + NL + "\t\tproperties";
  protected final String TEXT_246 = ".put(\"channel\", ";
  protected final String TEXT_247 = ");" + NL + "\t\tproperties";
  protected final String TEXT_248 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\tproperties";
  protected final String TEXT_249 = ".put(\"transport\",\"MQSeries\");" + NL + "\t\t";
  protected final String TEXT_250 = NL + "\t\t\tcom.ibm.mq.MQEnvironment.sslCipherSuite = \"";
  protected final String TEXT_251 = "\";" + NL + "\t\t";
  protected final String TEXT_252 = NL + "\t\t\tproperties";
  protected final String TEXT_253 = ".put(\"userID\",";
  protected final String TEXT_254 = ");" + NL + "\t\t\tproperties";
  protected final String TEXT_255 = ".put(\"password\",";
  protected final String TEXT_256 = ");" + NL + "\t\t";
  protected final String TEXT_257 = NL + NL + "\t\tcom.ibm.mq.MQQueueManager qMgr";
  protected final String TEXT_258 = "=null;" + NL + "\t\tcom.ibm.mq.MQQueue remoteQ";
  protected final String TEXT_259 = "=null;" + NL + "\t\t";
  protected final String TEXT_260 = NL + "\t\t\tString msgId_";
  protected final String TEXT_261 = " = ";
  protected final String TEXT_262 = ";" + NL + "\t    \tif (msgId_";
  protected final String TEXT_263 = " != null & !(\"\").equals(msgId_";
  protected final String TEXT_264 = ")) {" + NL + "\t\t\t\tString padding_";
  protected final String TEXT_265 = " = new String();" + NL + "\t\t       \tint padlen_";
  protected final String TEXT_266 = " = 24;" + NL + "\t\t " + NL + "\t\t       \tint len_";
  protected final String TEXT_267 = " = Math.abs(padlen_";
  protected final String TEXT_268 = ") - msgId_";
  protected final String TEXT_269 = ".toString().length();" + NL + "\t\t       \tif (len_";
  protected final String TEXT_270 = " > 0) {" + NL + "\t\t        \tfor (int i = 0 ; i < len_";
  protected final String TEXT_271 = " ; i++) {" + NL + "\t\t           \t\tpadding_";
  protected final String TEXT_272 = " = padding_";
  protected final String TEXT_273 = " + \" \";" + NL + "\t\t         \t}" + NL + "\t\t        \tmsgId_";
  protected final String TEXT_274 = " = msgId_";
  protected final String TEXT_275 = " + padding_";
  protected final String TEXT_276 = ";" + NL + "\t\t        }" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_277 = NL + "\t\ttry{" + NL + "\t" + NL + "\t\t\tint openOptions";
  protected final String TEXT_278 = "=com.ibm.mq.MQC.MQOO_INPUT_SHARED | com.ibm.mq.MQC.MQOO_FAIL_IF_QUIESCING | com.ibm.mq.MQC.MQOO_INQUIRE";
  protected final String TEXT_279 = " | com.ibm.mq.MQC.MQOO_BROWSE";
  protected final String TEXT_280 = ";" + NL + "\t\t" + NL + "\t\t\tcom.ibm.mq.MQGetMessageOptions gmo";
  protected final String TEXT_281 = "=new com.ibm.mq.MQGetMessageOptions();" + NL + "\t\t\t";
  protected final String TEXT_282 = NL + "\t\t\t\tgmo";
  protected final String TEXT_283 = ".options=gmo";
  protected final String TEXT_284 = ".options+com.ibm.mq.MQC.MQGMO_BROWSE_FIRST;" + NL + "\t\t\t\tint browseCursor_";
  protected final String TEXT_285 = " = 0;" + NL + "\t\t\t";
  protected final String TEXT_286 = NL + "\t\t\t\tgmo";
  protected final String TEXT_287 = ".options=gmo";
  protected final String TEXT_288 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t\t\t";
  protected final String TEXT_289 = NL + "\t\t\tgmo";
  protected final String TEXT_290 = ".options=gmo";
  protected final String TEXT_291 = ".options+com.ibm.mq.MQC.";
  protected final String TEXT_292 = "MQGMO_NO_WAIT";
  protected final String TEXT_293 = "MQGMO_WAIT";
  protected final String TEXT_294 = ";" + NL + "\t\t\tgmo";
  protected final String TEXT_295 = ".options=gmo";
  protected final String TEXT_296 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\tgmo";
  protected final String TEXT_297 = ".waitInterval=com.ibm.mq.MQC.MQWI_UNLIMITED;" + NL + "\t\t\tcom.ibm.mq.MQException.log = null;" + NL + "\t\t\tboolean flag";
  protected final String TEXT_298 = "=true;" + NL + "\t\t" + NL + "\t\t\tqMgr";
  protected final String TEXT_299 = "=new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_300 = ",properties";
  protected final String TEXT_301 = ");" + NL + "\t\t\tremoteQ";
  protected final String TEXT_302 = "=qMgr";
  protected final String TEXT_303 = ".accessQueue(";
  protected final String TEXT_304 = ",openOptions";
  protected final String TEXT_305 = ");" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_306 = NL + "\t\t\t\tif(Integer.valueOf(remoteQ";
  protected final String TEXT_307 = ".getCurrentDepth()).equals(0))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tflag";
  protected final String TEXT_308 = "= false;" + NL + "\t\t\t\t} \t" + NL + "\t\t\t";
  protected final String TEXT_309 = "\t" + NL + "\t\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\twhile(flag";
  protected final String TEXT_310 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_311 = NL + "\t\t\t\t\tif(Integer.valueOf(remoteQ";
  protected final String TEXT_312 = ".getCurrentDepth()).equals(1))" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tflag";
  protected final String TEXT_313 = "= false;" + NL + "\t\t\t\t\t} \t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_314 = NL + "\t\t\t\t";
  protected final String TEXT_315 = NL + "\t\t\t\t\tif(browseCursor_";
  protected final String TEXT_316 = " > 0){" + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_317 = ".options=com.ibm.mq.MQC.MQGMO_BROWSE_NEXT; " + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_318 = ".options=gmo";
  protected final String TEXT_319 = ".options+com.ibm.mq.MQC.";
  protected final String TEXT_320 = "MQGMO_NO_WAIT";
  protected final String TEXT_321 = "MQGMO_WAIT";
  protected final String TEXT_322 = ";" + NL + "\t\t\t\t\t\tgmo";
  protected final String TEXT_323 = ".options=gmo";
  protected final String TEXT_324 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tbrowseCursor_";
  protected final String TEXT_325 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_326 = NL + "\t\t\t\tcom.ibm.mq.MQMessage inMessage";
  protected final String TEXT_327 = "=new com.ibm.mq.MQMessage();" + NL + "\t\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\t\t\tinMessage";
  protected final String TEXT_329 = ".messageId = msgId_";
  protected final String TEXT_330 = ".getBytes(\"ISO-8859-15\");" + NL + "\t\t\t\t";
  protected final String TEXT_331 = "\t\t" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tremoteQ";
  protected final String TEXT_332 = ".get(inMessage";
  protected final String TEXT_333 = ",gmo";
  protected final String TEXT_334 = ");" + NL + "\t\t\t\t\t}catch (com.ibm.mq.MQException me_";
  protected final String TEXT_335 = ") {   " + NL + "\t\t\t            if (me_";
  protected final String TEXT_336 = ".reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t\t\t            \tbreak;   " + NL + "\t\t\t            }else{" + NL + "\t\t\t            \tthrow me_";
  protected final String TEXT_337 = ";" + NL + "\t\t\t            }   " + NL + "\t     \t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_338 = NL + "\t\t\t\t\tremoteQ";
  protected final String TEXT_339 = ".get(inMessage";
  protected final String TEXT_340 = ",gmo";
  protected final String TEXT_341 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_342 = NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_343 = "\t\t\t\t" + NL + "\t\t\t\torg.talend.mq.headers.rfh2.MQRFH2 mqrfh2_";
  protected final String TEXT_344 = " = new org.talend.mq.headers.rfh2.MQRFH2(inMessage";
  protected final String TEXT_345 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_346 = NL + NL + "\t\t\t\t";
  protected final String TEXT_347 = NL + "\t\t    \t\tString msg_";
  protected final String TEXT_348 = "=inMessage";
  protected final String TEXT_349 = ".readStringOfByteLength(inMessage";
  protected final String TEXT_350 = ".getDataLength());" + NL + "\t\t\t\t";
  protected final String TEXT_351 = NL + "\t\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_352 = " = new byte[inMessage";
  protected final String TEXT_353 = ".getDataLength()];" + NL + "\t\t\t\t\tinMessage";
  protected final String TEXT_354 = ".readFully(bytesMsgBody_";
  protected final String TEXT_355 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_356 = NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_357 = " = new String(bytesMsgBody_";
  protected final String TEXT_358 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_359 = NL + "\t\t\t\t\tjava.util.Map msg_";
  protected final String TEXT_360 = " = (java.util.Map)inMessage";
  protected final String TEXT_361 = ".readObject();\t\t\t  " + NL + "\t\t\t\t";
  protected final String TEXT_362 = NL + "\t\t\t\t\tqMgr";
  protected final String TEXT_363 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_364 = NL + NL + NL + "\t\t";
  protected final String TEXT_365 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
        boolean isUseConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
        String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	String msgId=ElementParameterParser.getValue(node, "__MSG_ID__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	String from=ElementParameterParser.getValue(node, "__FROM__");
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");
	
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");

	String strHost = null;
	String strPort = null;
	
	boolean useMqHeader = "true".equals(ElementParameterParser.getValue(node, "__USE_MQ_HEADER__"));

        boolean isCommitRollback = (!node.getProcess().getNodesOfType("tMomCommit").isEmpty()
	|| !node.getProcess().getNodesOfType("tMomRollback").isEmpty());
    	
        if (isUseConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
				serverType = ElementParameterParser.getValue(pNode, "__SERVER__");
                           	failover =  ("true").equals(ElementParameterParser.getValue(pNode, "__FAILOVER__"));
			}	
		}
	}

	IMetadataTable metadata=null;
	List<IMetadataColumn> columns = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		columns = metadata.getListColumns();
	} 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
     if (isUseConnection) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
		if (("Queue").equals(msgType)) {
		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_17);
    
		} else {
		
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_21);
    
		}
		
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
    stringBuffer.append(cid);
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
     boolean useMax = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"));
			String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
			String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");
			if(("true").equals(kListen)){
			
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_40);
    
		}
		
    stringBuffer.append(TEXT_41);
    
			}else if (useMax) {
			
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_49);
    
		}
		
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
			}else {
			
    stringBuffer.append(TEXT_55);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_60);
    if(("ActiveMQ").equals(serverType) /*&& !isUseConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_61);
    
		}
		
    stringBuffer.append(TEXT_62);
    
			} 
    stringBuffer.append(TEXT_63);
    
		if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
		
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
		}else{
			if ("Text".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
			} else if ("Bytes".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
			    if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
			
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
			    }
			} else if ("Map".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
			}
	}
		
    stringBuffer.append(TEXT_90);
          } else if (("JBoss").equals(serverType)||("ActiveMQ").equals(serverType)) {
	
		/*---------------------------------------1.initial jms connection factry---------------------------------*/ 
		if(("JBoss").equals(serverType) ){ // server judgement
		
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
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
    		
		}else if(("ActiveMQ").equals(serverType)){
			boolean startServer = ("true").equals(ElementParameterParser.getValue(node, "__STARTSERVER__"));
			
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    if(failover){
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    
				int i=0;
				for(Map<String, String> serversMap : servers) {
					strHost = serversMap.get("SERVERS_HOST");
					strPort = serversMap.get("SERVERS_PORT");

					if(i>0) {
					
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
					}
					
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_121);
    
					i++;
				}
				
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    }else{
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    
			if(startServer){
			
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
    
			}
			
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append("Topic".equals(msgType));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
		}
		
		/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 
		
    stringBuffer.append(TEXT_142);
    	
		if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) {
		
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
		} else {
		
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_150);
    
		}
		
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
		if (("Queue").equals(msgType)) {
		
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_161);
    
		} else {
		
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_165);
    
		}
		
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    	//put session to global map
		if( ("ActiveMQ").equals(serverType)) {
		
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    
		}
		
    stringBuffer.append(TEXT_181);
    		
		/*---------------------------------------3.recevice message form server ---------------------------------*/ 	
		if(("JBoss").equals(serverType) ){ 
		
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    		
		}else if(("ActiveMQ").equals(serverType)){
			boolean useMax = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"));
			String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
			String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");
			if(("true").equals(kListen)){
			
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    if(("ActiveMQ").equals(serverType) /*&& !isUseConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_190);
    
		}
		
    stringBuffer.append(TEXT_191);
    
			}else if (useMax) {
			
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_199);
    
		}
		
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    
			}else {
			
    stringBuffer.append(TEXT_205);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_210);
    if(("ActiveMQ").equals(serverType) /*&& !isUseConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_211);
    
		}
		
    stringBuffer.append(TEXT_212);
    
			}
		}
		/*-----------------------------------------------------------4.judge message body type---------------------------------------*/
		if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
		
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    
		}else{
			if ("Text".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
			} else if ("Bytes".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
			    if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
			
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
			    }
			} else if ("Map".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    
			}
		}
		
    stringBuffer.append(TEXT_239);
    
	} else { //server judgement   /***WebSphere MQ*****/
		String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
		String qm=ElementParameterParser.getValue(node, "__QM__");
		String queue = ElementParameterParser.getValue(node, "__QUEUE__");
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		boolean needSSLCipher = ("true").equals(ElementParameterParser.getValue(node,"__SET_MQ_SSL_CIPHER__"));
		String sslCipher = ElementParameterParser.getValue(node, "__MQ_SSL_CIPHER__");
		isCommit = isCommit && !isBrowse;
		isBrowse = isBrowse && !isRollback && !isCommit;
		
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
		if(needSSLCipher){
		
    stringBuffer.append(TEXT_250);
    stringBuffer.append(sslCipher);
    stringBuffer.append(TEXT_251);
    
		}
		if(!(dbuser == null) && !("\"\"").equals(dbuser) && !("").equals(dbuser)) {
		
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_256);
    
		}
		
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
		if(("true").equals(useMsgId)){
		
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    
		}
		
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    if(isBrowse){
    stringBuffer.append(TEXT_279);
    }
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    if(isBrowse){
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    }else{
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    }
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    if(("false").equals(kListen)){
    stringBuffer.append(TEXT_292);
    }else{
    stringBuffer.append(TEXT_293);
    }
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
			if(("false").equals(kListen)) {
			
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    
			}	
			
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    
				if(("false").equals(kListen)){
				
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    
				}
				
    stringBuffer.append(TEXT_314);
    
				if(isBrowse){
				
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    if(("false").equals(kListen)){
    stringBuffer.append(TEXT_320);
    }else{
    stringBuffer.append(TEXT_321);
    }
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    
				}
				
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    
				if(("true").equals(useMsgId)&& !"Map".equals(msgBobyType)){
				
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    
				}
				if(("false").equals(kListen) && ("true").equals(useMsgId) && !"Map".equals(msgBobyType) ){
				
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    
				} else {
				
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
				}
				
    stringBuffer.append(TEXT_342);
    
				if (useMqHeader) {
				
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    		
				if ("Text".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    
				} else if ("Bytes".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    
			    	if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    
			    	}
				} else if ("Map".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    
				}
				if(isCommit){
				
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    
				}
				
	}
	
    stringBuffer.append(TEXT_364);
    stringBuffer.append(TEXT_365);
    return stringBuffer.toString();
  }
}

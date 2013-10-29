package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFTPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TFTPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPConnectionBeginJava result = new TFTPConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work.\");" + NL + "\t";
  protected final String TEXT_3 = "  " + NL + "  java.util.Properties props_";
  protected final String TEXT_4 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_5 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_6 = ");" + NL + "  props_";
  protected final String TEXT_7 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_8 = ");" + NL + "  props_";
  protected final String TEXT_9 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_10 = ");" + NL + "  props_";
  protected final String TEXT_11 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_14 = " - \" + ";
  protected final String TEXT_15 = ");" + NL + "\t";
  protected final String TEXT_16 = NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_17 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "  ftp_";
  protected final String TEXT_18 = ".setRemoteHost(";
  protected final String TEXT_19 = ");" + NL + "  ftp_";
  protected final String TEXT_20 = ".setRemotePort(";
  protected final String TEXT_21 = ");" + NL;
  protected final String TEXT_22 = NL + "    ftp_";
  protected final String TEXT_23 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_24 = NL + "    ftp_";
  protected final String TEXT_25 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_26 = NL + "  ftp_";
  protected final String TEXT_27 = ".setControlEncoding(";
  protected final String TEXT_28 = ");" + NL + "\t";
  protected final String TEXT_29 = NL + "\t\tlog.info(\"";
  protected final String TEXT_30 = " - Authentication using a password.\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_31 = " - Connection attempt to '\" + ";
  protected final String TEXT_32 = " + \"' as '\" +";
  protected final String TEXT_33 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_34 = NL + "  ftp_";
  protected final String TEXT_35 = ".connect();  " + NL + "  ftp_";
  protected final String TEXT_36 = ".login(";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ");  " + NL + "  \t";
  protected final String TEXT_39 = NL + "\t\tlog.info(\"";
  protected final String TEXT_40 = " - Connection to '\" + ";
  protected final String TEXT_41 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_42 = NL + "  globalMap.put(\"conn_";
  protected final String TEXT_43 = "\",ftp_";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "  class MyUserInfo implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "" + NL + "    String passphrase_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ";" + NL + "" + NL + "    public String getPassphrase() { return passphrase_";
  protected final String TEXT_48 = "; }" + NL + "" + NL + "    public String getPassword() { return null; } " + NL + "" + NL + "    public boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "    public boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "    public boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "    public void showMessage(String arg0) { } " + NL + "" + NL + "    public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "    boolean[] echo) {" + NL + "      String[] password_";
  protected final String TEXT_49 = " = {";
  protected final String TEXT_50 = "};" + NL + "      return password_";
  protected final String TEXT_51 = ";" + NL + "    }" + NL + "  };" + NL + "  final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_52 = " = new MyUserInfo();" + NL + "  com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_53 = " = new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_54 = NL + "\t";
  protected final String TEXT_55 = NL + "\t\tlog.info(\"";
  protected final String TEXT_56 = " - SFTP authentication using a public key.\");" + NL + "\t\tlog.debug(\"Private key: '\" + ";
  protected final String TEXT_57 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_58 = NL + "    jsch_";
  protected final String TEXT_59 = ".addIdentity(";
  protected final String TEXT_60 = ", defaultUserInfo_";
  protected final String TEXT_61 = ".getPassphrase());";
  protected final String TEXT_62 = NL + "  com.jcraft.jsch.Session session_";
  protected final String TEXT_63 = " = jsch_";
  protected final String TEXT_64 = ".getSession(";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ");" + NL;
  protected final String TEXT_68 = " " + NL + "\t";
  protected final String TEXT_69 = NL + "\t\tlog.info(\"";
  protected final String TEXT_70 = " - SFTP authentication using a password.\");" + NL + "\t";
  protected final String TEXT_71 = NL + "    session_";
  protected final String TEXT_72 = ".setPassword(";
  protected final String TEXT_73 = "); ";
  protected final String TEXT_74 = NL + NL + "  session_";
  protected final String TEXT_75 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_76 = "); " + NL + "\t";
  protected final String TEXT_77 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_78 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_79 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_80 = ".setProxy(proxy_";
  protected final String TEXT_81 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_82 = NL + "  \t";
  protected final String TEXT_83 = NL + "\t\tlog.info(\"";
  protected final String TEXT_84 = " - Connection attempt to '\" + ";
  protected final String TEXT_85 = " + \"' as '\" + ";
  protected final String TEXT_86 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_87 = NL + "  session_";
  protected final String TEXT_88 = ".connect();" + NL + "  com.jcraft.jsch. Channel channel_";
  protected final String TEXT_89 = " = session_";
  protected final String TEXT_90 = ".openChannel(\"sftp\"); " + NL + "  channel_";
  protected final String TEXT_91 = ".connect();" + NL + "  \t";
  protected final String TEXT_92 = NL + "\t\tlog.info(\"";
  protected final String TEXT_93 = " - Connection to '\" + ";
  protected final String TEXT_94 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_95 = NL + "  com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_96 = " = (com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_97 = ";" + NL + "  c_";
  protected final String TEXT_98 = ".setFilenameEncoding(";
  protected final String TEXT_99 = ");" + NL + "  globalMap.put(\"conn_";
  protected final String TEXT_100 = "\", c_";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "  class MyTrust_";
  protected final String TEXT_103 = "{" + NL + "" + NL + "    private javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "      throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "      java.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "      java.io.FileNotFoundException, java.io.IOException{" + NL + "      java.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL + "      ks.load(new java.io.FileInputStream(";
  protected final String TEXT_104 = "), ";
  protected final String TEXT_105 = ".toCharArray());" + NL + "      javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "      tmf.init(ks);" + NL + "      return tmf.getTrustManagers();" + NL + "    }" + NL + "  }" + NL + "  javax.net.ssl.SSLContext sslContext = null;" + NL + "  javax.net.ssl.TrustManager[] trustManager = null;" + NL + "  javax.net.ssl.SSLSocketFactory sslSocketFactory = null;" + NL + "  it.sauronsoftware.ftp4j.FTPClient ftp_";
  protected final String TEXT_106 = " =null;" + NL + "  MyTrust_";
  protected final String TEXT_107 = " myTrust_";
  protected final String TEXT_108 = " = null;" + NL + "" + NL + "  try {" + NL + "    sslContext = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "    myTrust_";
  protected final String TEXT_109 = " = new MyTrust_";
  protected final String TEXT_110 = "();" + NL + "    trustManager = myTrust_";
  protected final String TEXT_111 = ".getTrustManagers();" + NL + "    sslContext.init(null, trustManager, new java.security.SecureRandom());" + NL + "    sslSocketFactory = sslContext.getSocketFactory();" + NL + "    ftp_";
  protected final String TEXT_112 = " = new it.sauronsoftware.ftp4j.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_113 = ".setSSLSocketFactory(sslSocketFactory);";
  protected final String TEXT_114 = NL + "    \tftp_";
  protected final String TEXT_115 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPS);";
  protected final String TEXT_116 = NL + "    \tftp_";
  protected final String TEXT_117 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPES);";
  protected final String TEXT_118 = NL + "  \t";
  protected final String TEXT_119 = NL + "\t\tlog.info(\"";
  protected final String TEXT_120 = " - FTPS authentication (";
  protected final String TEXT_121 = ").\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_122 = " - Connection attempt to '\" + ";
  protected final String TEXT_123 = " + \"' as '\" + ";
  protected final String TEXT_124 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_125 = NL + "    ftp_";
  protected final String TEXT_126 = ".connect(";
  protected final String TEXT_127 = ",";
  protected final String TEXT_128 = ");" + NL + "  \t";
  protected final String TEXT_129 = NL + "\t\tlog.info(\"";
  protected final String TEXT_130 = " - Connection to '\" + ";
  protected final String TEXT_131 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_132 = NL + "    ftp_";
  protected final String TEXT_133 = ".login(";
  protected final String TEXT_134 = ", ";
  protected final String TEXT_135 = ");" + NL + "  } catch (java.lang.IllegalStateException e) {" + NL + "\t";
  protected final String TEXT_136 = NL + "\t\tlog.error(\"";
  protected final String TEXT_137 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_138 = NL + "    e.printStackTrace();" + NL + "  } catch (java.io.IOException e) {" + NL + "\t";
  protected final String TEXT_139 = NL + "\t\tlog.error(\"";
  protected final String TEXT_140 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_141 = NL + "    e.printStackTrace();" + NL + "  } catch (it.sauronsoftware.ftp4j.FTPIllegalReplyException e) {" + NL + "\t";
  protected final String TEXT_142 = NL + "\t\tlog.error(\"";
  protected final String TEXT_143 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_144 = NL + "    e.printStackTrace();" + NL + "  } catch (it.sauronsoftware.ftp4j.FTPException e) {" + NL + "\t";
  protected final String TEXT_145 = NL + "\t\tlog.error(\"";
  protected final String TEXT_146 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_147 = NL + "    e.printStackTrace();" + NL + "  }" + NL + "  globalMap.put(\"conn_";
  protected final String TEXT_148 = "\", ftp_";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "\tlog.info(\"";
  protected final String TEXT_151 = " - Done.\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USER__");
String pass = ElementParameterParser.getValue(node, "__PASS__");
String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node, "__PROXY_PASSWORD__");
boolean sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");
String passPhrase = ElementParameterParser.getValue(node, "__PASSPHRASE__");
boolean ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
String keystoreFile = ElementParameterParser.getValue(node, "__KEYSTORE_FILE__");
String keystorePass = ElementParameterParser.getValue(node, "__KEYSTORE_PASS__");
String sEncoding = ElementParameterParser.getValue(node, "__ENCODING__");
String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	if(isLog4jEnabled){
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    }
if (useProxy) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(proxyPassword );
    stringBuffer.append(TEXT_12);
    
}

if (!sftp && !ftps) { // *** ftp *** //
  	if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_21);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    } else {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(sEncoding);
    stringBuffer.append(TEXT_28);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(pass );
    stringBuffer.append(TEXT_38);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
} else if (!ftps) { // *** sftp *** //

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(passPhrase );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    if (("PUBLICKEY").equals(authMethod)){
    stringBuffer.append(TEXT_54);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_67);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_68);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    if (!useProxy) {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(sEncoding);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
} else {  // *** ftps *** //

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(keystorePass);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
    if("IMPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    
    }else if("EXPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
    }

    stringBuffer.append(TEXT_118);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_128);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(pass );
    stringBuffer.append(TEXT_135);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    }
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    
}

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    }
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPFilePropertiesBeginJava
{
  protected static String nl;
  public static synchronized TFTPFilePropertiesBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFilePropertiesBeginJava result = new TFTPFilePropertiesBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  java.util.Properties props_";
  protected final String TEXT_2 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_3 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_4 = ");" + NL + "  props_";
  protected final String TEXT_5 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_6 = ");" + NL + "  props_";
  protected final String TEXT_7 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_8 = ");" + NL + "  props_";
  protected final String TEXT_9 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_10 = ");    ";
  protected final String TEXT_11 = NL + "    class MyUserInfo_";
  protected final String TEXT_12 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "      String passphrase_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_15 = "; }" + NL + "      public String getPassword() { return null; } " + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "      public void showMessage(String arg0) { } " + NL + "" + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        boolean[] echo) {" + NL + "        String[] password_";
  protected final String TEXT_16 = " = {";
  protected final String TEXT_17 = "};" + NL + "        return password_";
  protected final String TEXT_18 = ";" + NL + "      }" + NL + "    }; " + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_19 = " = new MyUserInfo_";
  protected final String TEXT_20 = "();" + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_21 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_22 = NL + "      jsch_";
  protected final String TEXT_23 = ".addIdentity(";
  protected final String TEXT_24 = ", defaultUserInfo_";
  protected final String TEXT_25 = ".getPassphrase());";
  protected final String TEXT_26 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_27 = "=jsch_";
  protected final String TEXT_28 = ".getSession(";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ");" + NL;
  protected final String TEXT_32 = " " + NL + "      session_";
  protected final String TEXT_33 = ".setPassword(";
  protected final String TEXT_34 = "); ";
  protected final String TEXT_35 = NL + "    session_";
  protected final String TEXT_36 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_37 = "); " + NL + "\t";
  protected final String TEXT_38 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_39 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_40 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_41 = ".setProxy(proxy_";
  protected final String TEXT_42 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_43 = NL + "    session_";
  protected final String TEXT_44 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_45 = "=session_";
  protected final String TEXT_46 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_47 = ".connect();" + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_48 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_49 = ";" + NL + "    c_";
  protected final String TEXT_50 = ".setFilenameEncoding(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = "    " + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_53 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_54 = "\");" + NL + "    if(c_";
  protected final String TEXT_55 = ".getHome()!=null && !c_";
  protected final String TEXT_56 = ".getHome().equals(c_";
  protected final String TEXT_57 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_58 = ".cd(c_";
  protected final String TEXT_59 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_60 = " " + NL + "  String remoteDir_";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = ".replaceAll(\"\\\\\\\\\", \"/\");";
  protected final String TEXT_63 = NL + "  ";
  protected final String TEXT_64 = " = new ";
  protected final String TEXT_65 = "Struct();" + NL + "  String remoteFile_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = " + \"/\" + ";
  protected final String TEXT_68 = ";" + NL + "  com.jcraft.jsch.SftpATTRS lstat_";
  protected final String TEXT_69 = " = c_";
  protected final String TEXT_70 = ".lstat(remoteFile_";
  protected final String TEXT_71 = ");" + NL + "" + NL + "  if (lstat_";
  protected final String TEXT_72 = " != null) {";
  protected final String TEXT_73 = NL + "    ";
  protected final String TEXT_74 = ".abs_path = (remoteFile_";
  protected final String TEXT_75 = ").replaceAll(\"//\", \"/\");";
  protected final String TEXT_76 = NL + "    ";
  protected final String TEXT_77 = ".dirname = ";
  protected final String TEXT_78 = ";";
  protected final String TEXT_79 = NL + "    ";
  protected final String TEXT_80 = ".basename = ";
  protected final String TEXT_81 = ";";
  protected final String TEXT_82 = NL + "    ";
  protected final String TEXT_83 = ".size = lstat_";
  protected final String TEXT_84 = ".getSize();";
  protected final String TEXT_85 = NL + "    ";
  protected final String TEXT_86 = ".mtime = (long)lstat_";
  protected final String TEXT_87 = ".getMTime();";
  protected final String TEXT_88 = NL + "    ";
  protected final String TEXT_89 = ".mtime_string = lstat_";
  protected final String TEXT_90 = ".getMtimeString();" + NL;
  protected final String TEXT_91 = NL + "      // Calculation of the Message Digest MD5" + NL + "      java.io.InputStream is_";
  protected final String TEXT_92 = " = c_";
  protected final String TEXT_93 = ".get(remoteFile_";
  protected final String TEXT_94 = ");" + NL + "      byte[] buffer_";
  protected final String TEXT_95 = " = new byte[8192];" + NL + "      int read_";
  protected final String TEXT_96 = " = 0;" + NL + "      java.security.MessageDigest dgs_";
  protected final String TEXT_97 = " = java.security.MessageDigest.getInstance(\"MD5\");" + NL + "" + NL + "      while ( (read_";
  protected final String TEXT_98 = " = is_";
  protected final String TEXT_99 = ".read(buffer_";
  protected final String TEXT_100 = ")) > 0) {" + NL + "        dgs_";
  protected final String TEXT_101 = ".update(buffer_";
  protected final String TEXT_102 = ", 0, read_";
  protected final String TEXT_103 = ");" + NL + "      }";
  protected final String TEXT_104 = NL + "      ";
  protected final String TEXT_105 = ".md5 =String.format(\"%032x\", new java.math.BigInteger(1, dgs_";
  protected final String TEXT_106 = ".digest()));" + NL + "      is_";
  protected final String TEXT_107 = ".close();";
  protected final String TEXT_108 = NL + "  }  ";
  protected final String TEXT_109 = NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_110 = " =null;" + NL;
  protected final String TEXT_111 = NL + "    ftp_";
  protected final String TEXT_112 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_113 = "\");";
  protected final String TEXT_114 = NL + "    ftp_";
  protected final String TEXT_115 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_116 = ".setRemoteHost(";
  protected final String TEXT_117 = ");" + NL + "    ftp_";
  protected final String TEXT_118 = ".setRemotePort(";
  protected final String TEXT_119 = ");" + NL;
  protected final String TEXT_120 = NL + "      ftp_";
  protected final String TEXT_121 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_122 = NL + "      ftp_";
  protected final String TEXT_123 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_124 = NL + "    ftp_";
  protected final String TEXT_125 = ".setControlEncoding(";
  protected final String TEXT_126 = ");" + NL + "    ftp_";
  protected final String TEXT_127 = ".connect();" + NL + "    ftp_";
  protected final String TEXT_128 = ".login(";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "  \tftp_";
  protected final String TEXT_132 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);";
  protected final String TEXT_133 = NL + "  String remoteDir_";
  protected final String TEXT_134 = " = ";
  protected final String TEXT_135 = ".replaceAll(\"\\\\\\\\\", \"/\");";
  protected final String TEXT_136 = NL + "  ";
  protected final String TEXT_137 = " = new ";
  protected final String TEXT_138 = "Struct();" + NL + "  String remoteFile_";
  protected final String TEXT_139 = " = ";
  protected final String TEXT_140 = " + \"/\" + ";
  protected final String TEXT_141 = ";" + NL + "" + NL + "  if (ftp_";
  protected final String TEXT_142 = ".exists(remoteFile_";
  protected final String TEXT_143 = ")) {";
  protected final String TEXT_144 = NL + "    ";
  protected final String TEXT_145 = ".abs_path = (remoteFile_";
  protected final String TEXT_146 = ").replaceAll(\"//\", \"/\");";
  protected final String TEXT_147 = NL + "    ";
  protected final String TEXT_148 = ".dirname = ";
  protected final String TEXT_149 = ";";
  protected final String TEXT_150 = NL + "    ";
  protected final String TEXT_151 = ".basename = ";
  protected final String TEXT_152 = ";";
  protected final String TEXT_153 = NL + "    ";
  protected final String TEXT_154 = ".size = ftp_";
  protected final String TEXT_155 = ".size(remoteFile_";
  protected final String TEXT_156 = ");";
  protected final String TEXT_157 = NL + "    ";
  protected final String TEXT_158 = ".mtime = ftp_";
  protected final String TEXT_159 = ".modtime(remoteFile_";
  protected final String TEXT_160 = ").getTime();";
  protected final String TEXT_161 = NL + "    ";
  protected final String TEXT_162 = ".mtime_string =ftp_";
  protected final String TEXT_163 = ".modtime(remoteFile_";
  protected final String TEXT_164 = ").toString();" + NL;
  protected final String TEXT_165 = NL + "      // Calculation of the Message Digest MD5" + NL + "      java.security.MessageDigest dgs_";
  protected final String TEXT_166 = " = java.security.MessageDigest.getInstance(\"MD5\");" + NL + "      dgs_";
  protected final String TEXT_167 = ".update(ftp_";
  protected final String TEXT_168 = ".get(remoteFile_";
  protected final String TEXT_169 = "));";
  protected final String TEXT_170 = NL + "      ";
  protected final String TEXT_171 = ".md5 =String.format(\"%032x\", new java.math.BigInteger(1, dgs_";
  protected final String TEXT_172 = ".digest()));";
  protected final String TEXT_173 = NL + "  }";
  protected final String TEXT_174 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String username = ElementParameterParser.getValue(node, "__USERNAME__");
String password = ElementParameterParser.getValue(node, "__PASSWORD__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String remoteDir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");
String pass = ElementParameterParser.getValue(node, "__PASSWORD__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");
String passPhrase = ElementParameterParser.getValue(node, "__PASSPHRASE__");  
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node, "__PROXY_PASSWORD__");
String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String conn= "conn_" + connection;
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
String mode = ElementParameterParser.getValue(node, "__MODE__");
boolean MD5 = new Boolean(ElementParameterParser.getValue(node, "__MD5__"));
boolean sftp = false;

if (("true").equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for (INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
}

if (useProxy) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(proxyPassword );
    stringBuffer.append(TEXT_10);
    
}
String outputConnName = null;
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

if (conns != null) {
  if (conns.size() > 0) {
    for (int i = 0; i < conns.size(); i++) {
      IConnection connTemp = conns.get(i);
      if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        outputConnName = connTemp.getName();
        break;
      }
    }
  }
}

if (outputConnName == null) {
  return "";
}

//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (sftp) {

  if (("false").equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(passPhrase );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_31);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    if (!useProxy) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_51);
    } else {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn );
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
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    if (MD5) {
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    
} else {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_113);
    } else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_119);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    } else {
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_130);
    }
    
  //add feature 19709,add the "Transfer mode" option,
  //the default transfer mode is ASCII,we don't change the mode when ascii is choosed.
  if("binary".equalsIgnoreCase(mode)){
  
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    
  }
  
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    if (MD5) {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    
}

    stringBuffer.append(TEXT_174);
    return stringBuffer.toString();
  }
}

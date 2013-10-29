package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPFileListBeginJava
{
  protected static String nl;
  public static synchronized TFTPFileListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileListBeginJava result = new TFTPFileListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "java.util.List<String> maskList_";
  protected final String TEXT_2 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_3 = NL + "  maskList_";
  protected final String TEXT_4 = ".add(\"*\");";
  protected final String TEXT_5 = " " + NL + "    maskList_";
  protected final String TEXT_6 = ".add(";
  protected final String TEXT_7 = "); ";
  protected final String TEXT_8 = NL + "  java.util.Properties props_";
  protected final String TEXT_9 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_10 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_11 = ");" + NL + "  props_";
  protected final String TEXT_12 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_13 = ");" + NL + "  props_";
  protected final String TEXT_14 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_15 = ");" + NL + "  props_";
  protected final String TEXT_16 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_17 = ");        ";
  protected final String TEXT_18 = NL + "    class MyUserInfo_";
  protected final String TEXT_19 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "      String passphrase_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_22 = "; }" + NL + "" + NL + "      public String getPassword() { return null; } " + NL + "" + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "      public void showMessage(String arg0) { } " + NL + "" + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        boolean[] echo) {" + NL + "        String[] password_";
  protected final String TEXT_23 = " = {";
  protected final String TEXT_24 = "};" + NL + "        return password_";
  protected final String TEXT_25 = ";" + NL + "      }" + NL + "    }; " + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_26 = " = new MyUserInfo_";
  protected final String TEXT_27 = "();" + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_28 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_29 = NL + "      jsch_";
  protected final String TEXT_30 = ".addIdentity(";
  protected final String TEXT_31 = ", defaultUserInfo_";
  protected final String TEXT_32 = ".getPassphrase());";
  protected final String TEXT_33 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_34 = "=jsch_";
  protected final String TEXT_35 = ".getSession(";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ");" + NL;
  protected final String TEXT_39 = " " + NL + "      session_";
  protected final String TEXT_40 = ".setPassword(";
  protected final String TEXT_41 = "); ";
  protected final String TEXT_42 = NL + "    session_";
  protected final String TEXT_43 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_44 = "); " + NL + "\t";
  protected final String TEXT_45 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_46 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_47 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_48 = ".setProxy(proxy_";
  protected final String TEXT_49 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_50 = NL + "    session_";
  protected final String TEXT_51 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_52 = "=session_";
  protected final String TEXT_53 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_54 = ".connect();" + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_55 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_56 = ";" + NL + "    c_";
  protected final String TEXT_57 = ".setFilenameEncoding(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = "    " + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_60 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_61 = "\");" + NL + "    if(c_";
  protected final String TEXT_62 = ".getHome()!=null && !c_";
  protected final String TEXT_63 = ".getHome().equals(c_";
  protected final String TEXT_64 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_65 = ".cd(c_";
  protected final String TEXT_66 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_67 = NL + "  String remotedir_";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = ".replaceAll(\"\\\\\\\\\", \"/\");" + NL + "  java.util.Vector<com.jcraft.jsch.ChannelSftp.LsEntry> vector_";
  protected final String TEXT_70 = " = c_";
  protected final String TEXT_71 = ".ls(remotedir_";
  protected final String TEXT_72 = ");" + NL + "  com.jcraft.jsch.ChannelSftp.LsEntry[] sftpFiles_";
  protected final String TEXT_73 = " = vector_";
  protected final String TEXT_74 = ".toArray(new com.jcraft.jsch.ChannelSftp.LsEntry[0]);" + NL + "  int nb_file_";
  protected final String TEXT_75 = " = 0;  " + NL + "  List<String> fileListTemp_";
  protected final String TEXT_76 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "  for (String filemask_";
  protected final String TEXT_77 = " : maskList_";
  protected final String TEXT_78 = ") {" + NL + "    java.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_79 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_80 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "    " + NL + "    for (com.jcraft.jsch.ChannelSftp.LsEntry filemaskTemp_";
  protected final String TEXT_81 = " : sftpFiles_";
  protected final String TEXT_82 = ") {" + NL + "      if (fileNamePattern_";
  protected final String TEXT_83 = ".matcher(filemaskTemp_";
  protected final String TEXT_84 = ".getFilename()).matches()) {" + NL + "        fileListTemp_";
  protected final String TEXT_85 = ".add(filemaskTemp_";
  protected final String TEXT_86 = ".getFilename());" + NL + "      }" + NL + "    }" + NL + "  }    " + NL + "" + NL + "  for (String sftpFile_";
  protected final String TEXT_87 = " : fileListTemp_";
  protected final String TEXT_88 = ") {" + NL + "" + NL + "    if ((\".\").equals(sftpFile_";
  protected final String TEXT_89 = ") || (\"..\").equals(sftpFile_";
  protected final String TEXT_90 = ")) {" + NL + "      continue;" + NL + "    }" + NL + "    String currentFileName_";
  protected final String TEXT_91 = " = sftpFile_";
  protected final String TEXT_92 = "; " + NL + "    String currentFilePath_";
  protected final String TEXT_93 = " = remotedir_";
  protected final String TEXT_94 = " + \"/\" + sftpFile_";
  protected final String TEXT_95 = ";" + NL + "    globalMap.put(\"";
  protected final String TEXT_96 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_97 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_98 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_99 = ");" + NL + "    nb_file_";
  protected final String TEXT_100 = "++;" + NL;
  protected final String TEXT_101 = NL + "  int nb_file_";
  protected final String TEXT_102 = " = 0;" + NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_103 = " =null;" + NL;
  protected final String TEXT_104 = NL + "    ftp_";
  protected final String TEXT_105 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_106 = "\");";
  protected final String TEXT_107 = "    " + NL + "    ftp_";
  protected final String TEXT_108 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_109 = ".setRemoteHost(";
  protected final String TEXT_110 = ");" + NL + "    ftp_";
  protected final String TEXT_111 = ".setRemotePort(";
  protected final String TEXT_112 = ");" + NL;
  protected final String TEXT_113 = NL + "      ftp_";
  protected final String TEXT_114 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_115 = NL + "      ftp_";
  protected final String TEXT_116 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_117 = NL + "    ftp_";
  protected final String TEXT_118 = ".setControlEncoding(";
  protected final String TEXT_119 = ");" + NL + "    ftp_";
  protected final String TEXT_120 = ".connect();  " + NL + "    ftp_";
  protected final String TEXT_121 = ".login(";
  protected final String TEXT_122 = ", ";
  protected final String TEXT_123 = "); ";
  protected final String TEXT_124 = "      " + NL + "  String remotedir_";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = ";" + NL + "  ftp_";
  protected final String TEXT_127 = ".chdir(remotedir_";
  protected final String TEXT_128 = ");" + NL + "  String[] fileList_";
  protected final String TEXT_129 = ";" + NL + "" + NL + "  if (";
  protected final String TEXT_130 = ") {" + NL + "    fileList_";
  protected final String TEXT_131 = " = ftp_";
  protected final String TEXT_132 = ".dir(null, true);" + NL + "  } else {" + NL + "    fileList_";
  protected final String TEXT_133 = " = ftp_";
  protected final String TEXT_134 = ".dir(null, false);" + NL + "  }" + NL + "  List<String> fileListTemp_";
  protected final String TEXT_135 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "  for (String filemask_";
  protected final String TEXT_136 = " : maskList_";
  protected final String TEXT_137 = ") {" + NL + "    java.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_138 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_139 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "" + NL + "    for (String filemaskTemp_";
  protected final String TEXT_140 = " : fileList_";
  protected final String TEXT_141 = ") {" + NL + "      if (fileNamePattern_";
  protected final String TEXT_142 = ".matcher(filemaskTemp_";
  protected final String TEXT_143 = ").matches()) {" + NL + "        fileListTemp_";
  protected final String TEXT_144 = ".add(filemaskTemp_";
  protected final String TEXT_145 = ");" + NL + "      }" + NL + "    }" + NL + "  }    " + NL + "  int i_";
  protected final String TEXT_146 = " = -1;" + NL + "" + NL + "  while (++i_";
  protected final String TEXT_147 = " < fileListTemp_";
  protected final String TEXT_148 = ".size()) {" + NL + "    String currentFileName_";
  protected final String TEXT_149 = " = fileListTemp_";
  protected final String TEXT_150 = ".get(i_";
  protected final String TEXT_151 = "); " + NL + "    String currentFilePath_";
  protected final String TEXT_152 = " = remotedir_";
  protected final String TEXT_153 = " + \"/\" + fileListTemp_";
  protected final String TEXT_154 = ".get(i_";
  protected final String TEXT_155 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_156 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_157 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_158 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_159 = ");" + NL + "    nb_file_";
  protected final String TEXT_160 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();  
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");
String pass = ElementParameterParser.getValue(node, "__PASSWORD__");
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
boolean dirFull = ("true").equals(ElementParameterParser.getValue(node, "__DIR_FULL__"));
String cid = node.getUniqueName();
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");
String passPhrase = ElementParameterParser.getValue(node, "__PASSPHRASE__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node, "__PROXY_PASSWORD__");    
String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");  
List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String conn= "conn_" + connection;
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
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

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
if (files.size() == 0) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
} else {
  for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_7);
    
  }
}

//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (useProxy) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(proxyPassword );
    stringBuffer.append(TEXT_17);
    
}

if (sftp) {

  if (("false").equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(passPhrase );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_38);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    if (!useProxy) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    }
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_58);
    
  } else {
  
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
  }
  
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    } else {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_106);
    } else {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_112);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    } else {
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(pass );
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(dirFull );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    }
    return stringBuffer.toString();
  }
}

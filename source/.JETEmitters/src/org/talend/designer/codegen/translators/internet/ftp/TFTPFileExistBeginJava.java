package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPFileExistBeginJava
{
  protected static String nl;
  public static synchronized TFTPFileExistBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileExistBeginJava result = new TFTPFileExistBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tlog.info(\"";
  protected final String TEXT_2 = " - Start to work.\");";
  protected final String TEXT_3 = NL + "  java.util.Properties props_";
  protected final String TEXT_4 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_5 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_6 = ");" + NL + "  props_";
  protected final String TEXT_7 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_8 = ");" + NL + "  props_";
  protected final String TEXT_9 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_10 = ");" + NL + "  props_";
  protected final String TEXT_11 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_12 = ");        ";
  protected final String TEXT_13 = NL + "    class MyUserInfo_";
  protected final String TEXT_14 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "" + NL + "      String passphrase_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";" + NL + "" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_17 = "; }" + NL + "" + NL + "      public String getPassword() { return null; } " + NL + "" + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "      public void showMessage(String arg0) { } " + NL + "" + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        boolean[] echo) {" + NL + "        String[] password_";
  protected final String TEXT_18 = " = {";
  protected final String TEXT_19 = "};" + NL + "        return password_";
  protected final String TEXT_20 = ";" + NL + "      }" + NL + "    }; " + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_21 = " = new MyUserInfo_";
  protected final String TEXT_22 = "();" + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_23 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_24 = NL + "\t  ";
  protected final String TEXT_25 = NL + "\t\tlog.info(\"";
  protected final String TEXT_26 = " - SFTP authentication using a public key.\");" + NL + "\t\tlog.debug(\"Private key: '\" + ";
  protected final String TEXT_27 = " + \"'.\");" + NL + "\t  ";
  protected final String TEXT_28 = NL + "      jsch_";
  protected final String TEXT_29 = ".addIdentity(";
  protected final String TEXT_30 = ", defaultUserInfo_";
  protected final String TEXT_31 = ".getPassphrase());";
  protected final String TEXT_32 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_33 = "=jsch_";
  protected final String TEXT_34 = ".getSession(";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ");" + NL;
  protected final String TEXT_38 = " " + NL + "\t  ";
  protected final String TEXT_39 = NL + "\t\tlog.info(\"";
  protected final String TEXT_40 = " - SFTP authentication using a password.\");" + NL + "\t  ";
  protected final String TEXT_41 = NL + "      session_";
  protected final String TEXT_42 = ".setPassword(";
  protected final String TEXT_43 = "); ";
  protected final String TEXT_44 = NL + "    session_";
  protected final String TEXT_45 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_46 = "); " + NL + "\t";
  protected final String TEXT_47 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_48 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_49 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_50 = ".setProxy(proxy_";
  protected final String TEXT_51 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_52 = NL + "\t";
  protected final String TEXT_53 = NL + "\t\tlog.info(\"";
  protected final String TEXT_54 = " - Connection attempt to '\" + ";
  protected final String TEXT_55 = " + \"' as '\" + ";
  protected final String TEXT_56 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_57 = NL + "    session_";
  protected final String TEXT_58 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_59 = "=session_";
  protected final String TEXT_60 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_61 = ".connect();" + NL + "\t";
  protected final String TEXT_62 = NL + "\t\tlog.info(\"";
  protected final String TEXT_63 = " - Connection to '\" + ";
  protected final String TEXT_64 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_65 = NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_66 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_67 = ";" + NL + "    c_";
  protected final String TEXT_68 = ".setFilenameEncoding(";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = "    " + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_71 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_72 = "\");" + NL + "\t";
  protected final String TEXT_73 = NL + "\t\tif(c_";
  protected final String TEXT_74 = "!=null && c_";
  protected final String TEXT_75 = ".getSession()!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_76 = " - Uses an existing connection as \" + c_";
  protected final String TEXT_77 = ".getSession().getUserName() + \". Connection hostname: \" + c_";
  protected final String TEXT_78 = ".getSession().getHost() + \". Connection port: \" + c_";
  protected final String TEXT_79 = ".getSession().getPort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_80 = NL + "    if(c_";
  protected final String TEXT_81 = ".getHome()!=null && !c_";
  protected final String TEXT_82 = ".getHome().equals(c_";
  protected final String TEXT_83 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_84 = ".cd(c_";
  protected final String TEXT_85 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_86 = NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_87 = " = null;" + NL;
  protected final String TEXT_88 = NL + "    ftp_";
  protected final String TEXT_89 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_90 = "\");";
  protected final String TEXT_91 = NL + "\t\tif(ftp_";
  protected final String TEXT_92 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_93 = " - Uses an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_94 = ".getRemoteHost() + \". Connection port: \" + ftp_";
  protected final String TEXT_95 = ".getRemotePort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_96 = "    " + NL + "    ftp_";
  protected final String TEXT_97 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_98 = ".setRemoteHost(";
  protected final String TEXT_99 = ");" + NL + "    ftp_";
  protected final String TEXT_100 = ".setRemotePort(";
  protected final String TEXT_101 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_102 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_103 = " - \" + ";
  protected final String TEXT_104 = ");" + NL + "\t";
  protected final String TEXT_105 = NL;
  protected final String TEXT_106 = NL + "      ftp_";
  protected final String TEXT_107 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_108 = NL + "      ftp_";
  protected final String TEXT_109 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_110 = NL + "    ftp_";
  protected final String TEXT_111 = ".setControlEncoding(";
  protected final String TEXT_112 = ");" + NL + "\t";
  protected final String TEXT_113 = NL + "\t\tlog.info(\"";
  protected final String TEXT_114 = " - Authentication using a password.\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_115 = " - Connection attempt to '\" + ";
  protected final String TEXT_116 = " + \"' as '\" +";
  protected final String TEXT_117 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_118 = NL + "    ftp_";
  protected final String TEXT_119 = ".connect();  " + NL + "    ftp_";
  protected final String TEXT_120 = ".login(";
  protected final String TEXT_121 = ", ";
  protected final String TEXT_122 = ");" + NL + "\t";
  protected final String TEXT_123 = NL + "\t\tlog.info(\"";
  protected final String TEXT_124 = " - Connection to '\" + ";
  protected final String TEXT_125 = "  + \"' has succeeded.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host=ElementParameterParser.getValue(node, "__HOST__");
String port=ElementParameterParser.getValue(node, "__PORT__");
String username=ElementParameterParser.getValue(node, "__USERNAME__");
String password=ElementParameterParser.getValue(node, "__PASSWORD__");
String remoteDir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");
String proxyPass = ElementParameterParser.getValue(node, "__PROXY_PASSWORD__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");
String pass = ElementParameterParser.getValue(node, "__PASSWORD__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");
String passPhrase = ElementParameterParser.getValue(node, "__PASSPHRASE__");    
String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String conn= "conn_" + connection;
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean sftp = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
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
	if(isLog4jEnabled){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
	}
//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
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
    stringBuffer.append(proxyPass );
    stringBuffer.append(TEXT_12);
    
}

if (sftp) {
  if (("false").equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(passPhrase );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_24);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_37);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_38);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    if (!useProxy) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_69);
    
  } else {
  
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_72);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
  }
} else {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
     if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_90);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    }
    } else {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_101);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    } else {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_112);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_122);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_125);
    }
      
  }
}
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPGetBeginJava
{
  protected static String nl;
  public static synchronized TFTPGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPGetBeginJava result = new TFTPGetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work.\");" + NL + "\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_4 = " = new StringBuffer();" + NL + "\t";
  protected final String TEXT_5 = NL + "int nb_file_";
  protected final String TEXT_6 = " = 0;";
  protected final String TEXT_7 = NL + "  java.util.Properties props_";
  protected final String TEXT_8 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_9 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_10 = ");" + NL + "  props_";
  protected final String TEXT_11 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_12 = ");" + NL + "  props_";
  protected final String TEXT_13 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_14 = ");" + NL + "  props_";
  protected final String TEXT_15 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_16 = ");        ";
  protected final String TEXT_17 = "  " + NL + "  final java.util.List<String> msg_";
  protected final String TEXT_18 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_19 = NL + "    class MyUserInfo_";
  protected final String TEXT_20 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "      String passphrase_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";" + NL + "" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_23 = "; }" + NL + "" + NL + "      public String getPassword() { return null; } " + NL + "" + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "      public void showMessage(String arg0) { } " + NL + "" + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "      boolean[] echo) {" + NL + "        String[] password_";
  protected final String TEXT_24 = " = {";
  protected final String TEXT_25 = "};" + NL + "        return password_";
  protected final String TEXT_26 = ";" + NL + "      }" + NL + "    }; " + NL + "" + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_27 = " = new MyUserInfo_";
  protected final String TEXT_28 = "();";
  protected final String TEXT_29 = NL + NL + "  class MyProgressMonitor_";
  protected final String TEXT_30 = " implements com.jcraft.jsch.SftpProgressMonitor {" + NL + "" + NL + "    private long percent = -1;" + NL + "" + NL + "    public void init(int op, String src, String dest, long max) {}" + NL + "" + NL + "    public boolean count(long count) {return true;}" + NL + "" + NL + "    public void end() {}" + NL + "  } " + NL + "" + NL + "  class SFTPGetter_";
  protected final String TEXT_31 = " {" + NL + "" + NL + "    private com.jcraft.jsch.ChannelSftp cnlSFTP = null;" + NL + "" + NL + "    private com.jcraft.jsch.SftpProgressMonitor monitor = null;" + NL + "" + NL + "    private int count = 0;" + NL + "" + NL + "    public void getAllFiles(String remoteDirectory, String localDirectory) throws com.jcraft.jsch.SftpException {" + NL + "      " + NL + "      cnlSFTP.cd(remoteDirectory);" + NL + "      java.util.Vector sftpFiles = cnlSFTP.ls(\".\");" + NL + "" + NL + "      for (Object sftpFile : sftpFiles) {" + NL + "        com.jcraft.jsch.ChannelSftp.LsEntry lsEntry = (com.jcraft.jsch.ChannelSftp.LsEntry) sftpFile;" + NL + "        com.jcraft.jsch.SftpATTRS attrs = lsEntry.getAttrs();" + NL + "" + NL + "        if ((\".\").equals(lsEntry.getFilename()) || (\"..\").equals(lsEntry.getFilename())) {" + NL + "          continue;" + NL + "        }" + NL + "" + NL + "        if (attrs.isDir()) {" + NL + "          java.io.File localFile = new java.io.File(localDirectory + \"/\" + lsEntry.getFilename());" + NL + "" + NL + "          if (!localFile.exists()) {" + NL + "            localFile.mkdir();" + NL + "          }" + NL + "          getAllFiles(remoteDirectory + \"/\" + lsEntry.getFilename(), localDirectory + \"/\" + lsEntry.getFilename());" + NL + "          cnlSFTP.cd(remoteDirectory);" + NL + "        } else if (!attrs.isLink()) {" + NL + "          downloadFile(localDirectory, lsEntry.getFilename());" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void getFiles(String remoteDirectory, String localDirectory, String maskStr) throws com.jcraft.jsch.SftpException {" + NL + "      " + NL + "      cnlSFTP.cd(remoteDirectory);" + NL + "      java.util.Vector sftpFiles = cnlSFTP.ls(\".\");" + NL + "" + NL + "      for (Object sftpFile : sftpFiles) {" + NL + "        com.jcraft.jsch.ChannelSftp.LsEntry lsEntry = (com.jcraft.jsch.ChannelSftp.LsEntry) sftpFile;" + NL + "        com.jcraft.jsch.SftpATTRS attrs = lsEntry.getAttrs();" + NL + "" + NL + "        if ((\".\").equals(lsEntry.getFilename()) || (\"..\").equals(lsEntry.getFilename())) {" + NL + "          continue;" + NL + "        }" + NL + "" + NL + "        if (!attrs.isDir() && !attrs.isLink()) {" + NL + "" + NL + "          if (lsEntry.getFilename().matches(maskStr)) {" + NL + "            downloadFile(localDirectory, lsEntry.getFilename());" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void chdir(String path) throws com.jcraft.jsch.SftpException{" + NL + "      cnlSFTP.cd(path);" + NL + "    }" + NL + "" + NL + "    public String pwd() throws com.jcraft.jsch.SftpException{" + NL + "      return cnlSFTP.pwd();" + NL + "    }" + NL + "" + NL + "    private void downloadFile(String localFileName, String remoteFileName) throws com.jcraft.jsch.SftpException {" + NL + "" + NL + "      try {" + NL + "        cnlSFTP.get(remoteFileName, localFileName, monitor,";
  protected final String TEXT_32 = "          " + NL + "            com.jcraft.jsch.ChannelSftp.OVERWRITE";
  protected final String TEXT_33 = NL + "            com.jcraft.jsch.ChannelSftp.APPEND";
  protected final String TEXT_34 = NL + "            com.jcraft.jsch.ChannelSftp.RESUME";
  protected final String TEXT_35 = NL + "        );" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_37 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\tlog4jSb_";
  protected final String TEXT_38 = ".delete(0,log4jSb_";
  protected final String TEXT_39 = ".length());" + NL + "\t\t";
  protected final String TEXT_40 = NL + "        msg_";
  protected final String TEXT_41 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_42 = NL + "          System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_43 = NL + "        globalMap.put(\"";
  protected final String TEXT_44 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "      } catch (com.jcraft.jsch.SftpException e){" + NL + "" + NL + "        if (e.id == com.jcraft.jsch.ChannelSftp.SSH_FX_FAILURE || e.id == com.jcraft.jsch.ChannelSftp.SSH_FX_BAD_MESSAGE) {" + NL + "          msg_";
  protected final String TEXT_45 = ".add(\"file [\" + remoteFileName + \"] downloaded unsuccessfully.\");" + NL + "          globalMap.put(\"";
  protected final String TEXT_46 = "_CURRENT_STATUS\", \"File transfer fail.\");" + NL + "        }" + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_48 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_49 = NL + "        throw e;" + NL + "      }" + NL + "      count++;" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_50 = NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_51 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_52 = "\");" + NL + "\t";
  protected final String TEXT_53 = NL + "\t\tif(c_";
  protected final String TEXT_54 = "!=null && c_";
  protected final String TEXT_55 = ".getSession()!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_56 = " - Uses an existing connection as \" + c_";
  protected final String TEXT_57 = ".getSession().getUserName() + \". Connection hostname: \" + c_";
  protected final String TEXT_58 = ".getSession().getHost() + \". Connection port: \" + c_";
  protected final String TEXT_59 = ".getSession().getPort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_60 = NL + "    if(c_";
  protected final String TEXT_61 = ".getHome()!=null && !c_";
  protected final String TEXT_62 = ".getHome().equals(c_";
  protected final String TEXT_63 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_64 = ".cd(c_";
  protected final String TEXT_65 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_66 = "    " + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_67 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_68 = NL + "\t  ";
  protected final String TEXT_69 = NL + "\t\tlog.info(\"";
  protected final String TEXT_70 = " - SFTP authentication using a public key.\");" + NL + "\t\tlog.debug(\"Private key: '\" + ";
  protected final String TEXT_71 = " + \"'.\");" + NL + "\t  ";
  protected final String TEXT_72 = NL + "      jsch_";
  protected final String TEXT_73 = ".addIdentity(";
  protected final String TEXT_74 = ", defaultUserInfo_";
  protected final String TEXT_75 = ".getPassphrase());";
  protected final String TEXT_76 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_77 = "=jsch_";
  protected final String TEXT_78 = ".getSession(";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ");" + NL;
  protected final String TEXT_82 = NL + "\t  ";
  protected final String TEXT_83 = NL + "\t\tlog.info(\"";
  protected final String TEXT_84 = " - SFTP authentication using a password.\");" + NL + "\t  ";
  protected final String TEXT_85 = NL + "      session_";
  protected final String TEXT_86 = ".setPassword(";
  protected final String TEXT_87 = "); ";
  protected final String TEXT_88 = NL + NL + "    session_";
  protected final String TEXT_89 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_90 = "); " + NL + "\t";
  protected final String TEXT_91 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_92 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_93 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_94 = ".setProxy(proxy_";
  protected final String TEXT_95 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_96 = NL + "\t";
  protected final String TEXT_97 = NL + "\t\tlog.info(\"";
  protected final String TEXT_98 = " - Connection attempt to '\" + ";
  protected final String TEXT_99 = " + \"' as '\" + ";
  protected final String TEXT_100 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_101 = NL + "    session_";
  protected final String TEXT_102 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_103 = "=session_";
  protected final String TEXT_104 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_105 = ".connect();" + NL + "\t";
  protected final String TEXT_106 = NL + "\t\tlog.info(\"";
  protected final String TEXT_107 = " - Connection to '\" + ";
  protected final String TEXT_108 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_109 = NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_110 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_111 = ";" + NL + "    c_";
  protected final String TEXT_112 = ".setFilenameEncoding(";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "  com.jcraft.jsch.SftpProgressMonitor monitor_";
  protected final String TEXT_115 = " = new MyProgressMonitor_";
  protected final String TEXT_116 = "();" + NL + "  SFTPGetter_";
  protected final String TEXT_117 = " getter_";
  protected final String TEXT_118 = " = new SFTPGetter_";
  protected final String TEXT_119 = "();" + NL + "  getter_";
  protected final String TEXT_120 = ".cnlSFTP = c_";
  protected final String TEXT_121 = ";" + NL + "  getter_";
  protected final String TEXT_122 = ".monitor = monitor_";
  protected final String TEXT_123 = ";" + NL + "  String remotedir_";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = ";" + NL + "  c_";
  protected final String TEXT_126 = ".cd(remotedir_";
  protected final String TEXT_127 = ");";
  protected final String TEXT_128 = "  " + NL + "  final com.enterprisedt.net.ftp.TransferCompleteStrings msg_";
  protected final String TEXT_129 = " = new com.enterprisedt.net.ftp.TransferCompleteStrings();" + NL + "" + NL + "  class FTPGetter_";
  protected final String TEXT_130 = " {" + NL + "    private com.enterprisedt.net.ftp.FTPClient ftpClient = null;" + NL + "    private int count = 0;" + NL + "" + NL + "    public void getAllFiles(String remoteDirectory, String localDirectory) throws java.io.IOException, " + NL + "      com.enterprisedt.net.ftp.FTPException, java.text.ParseException {" + NL + "" + NL + "      ftpClient.chdir(remoteDirectory);" + NL + "      String path = ftpClient.pwd();" + NL + "      String[] ftpFileNames = null;" + NL + "      com.enterprisedt.net.ftp.FTPFile[] ftpFiles = null;" + NL + "" + NL + "      try{" + NL + "        //use dir() for Bug9562 with FTP server in AS400" + NL + "        ftpFileNames = ftpClient.dir(null, false);" + NL + "        //Bug 13272, the same as getFiles()." + NL + "      } catch (com.enterprisedt.net.ftp.FTPException e){" + NL + "\t\t";
  protected final String TEXT_131 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_132 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_133 = NL + "        ftpFileNames = null;" + NL + "        ftpFiles = ftpClient.dirDetails(\".\");" + NL + "      }" + NL + "" + NL + "      //if dirDetails(...) doesn't work, then use dir(...), distinguish file type by FTPException" + NL + "" + NL + "      if ((ftpFiles == null) && (ftpFileNames != null)){" + NL + "        //if the file is folder, catch the FTPException and recur" + NL + "        for (String ftpFileName : ftpFileNames){" + NL + "          try {" + NL + "            downloadFile(localDirectory + \"/\" + ftpFileName,ftpFileName);" + NL + "          } catch (com.enterprisedt.net.ftp.FTPException e) {" + NL + "\t\t\t";
  protected final String TEXT_134 = NL + "\t\t\t\tlog.warn(\"";
  protected final String TEXT_135 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_136 = NL + "            java.io.File localFile = new java.io.File(localDirectory + \"/\" + ftpFileName);" + NL + "            " + NL + "            if (!localFile.exists()) {" + NL + "              localFile.mkdir();" + NL + "            }" + NL + "            getAllFiles(path + \"/\" + ftpFileName, localDirectory + \"/\" + ftpFileName);" + NL + "            ftpClient.chdir(path);" + NL + "          }" + NL + "        }" + NL + "      } else {" + NL + "        for (com.enterprisedt.net.ftp.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "          if (ftpFile.isDir()) {" + NL + "            if ((!(\".\").equals(ftpFile.getName())) && (!(\"..\").equals(ftpFile.getName()))) {" + NL + "              java.io.File localFile = new java.io.File(localDirectory + \"/\" + ftpFile.getName());" + NL + "" + NL + "              if (!localFile.exists()) {" + NL + "                localFile.mkdir();" + NL + "              }" + NL + "              getAllFiles(path + \"/\" + ftpFile.getName(), localDirectory + \"/\" + ftpFile.getName());" + NL + "              ftpClient.chdir(path);" + NL + "            }" + NL + "          } else if (!ftpFile.isLink()) {" + NL + "            downloadFile(localDirectory + \"/\" + ftpFile.getName(),ftpFile.getName());" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void getFiles(String remoteDirectory, String localDirectory, String maskStr) throws java.io.IOException," + NL + "      com.enterprisedt.net.ftp.FTPException, java.text.ParseException {" + NL + "      ftpClient.chdir(remoteDirectory);" + NL + "      String[] ftpFileNames = null;" + NL + "      com.enterprisedt.net.ftp.FTPFile[] ftpFiles = null;" + NL + "" + NL + "      try {" + NL + "        //use dir() for Bug9562 with FTP server in AS400 (the same way as getAllFiles())" + NL + "        ftpFileNames = ftpClient.dir(null, false);" + NL + "        //Bug 13272, if dir() throw exception, use dirDetails()." + NL + "      } catch (com.enterprisedt.net.ftp.FTPException e){" + NL + "\t\t";
  protected final String TEXT_137 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_138 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_139 = NL + "        ftpFileNames = null;" + NL + "        ftpFiles = ftpClient.dirDetails(\".\");" + NL + "      }" + NL + "      //if dirDetails(...) doesn't work, then use dir(...), but can not distinguish file type" + NL + "" + NL + "      if ((ftpFiles == null) && (ftpFileNames != null)){" + NL + "        for (String ftpFileName : ftpFileNames) {" + NL + "          if (ftpFileName.matches(maskStr)) {" + NL + "            downloadFile(localDirectory + \"/\" + ftpFileName,ftpFileName);" + NL + "          }" + NL + "        }" + NL + "      } else{" + NL + "" + NL + "        for (com.enterprisedt.net.ftp.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "          if (!ftpFile.isDir() && !ftpFile.isLink()) {" + NL + "            String fileName = ftpFile.getName();" + NL + "" + NL + "            if (fileName.matches(maskStr)) {" + NL + "              downloadFile(localDirectory + \"/\" + fileName,fileName);" + NL + "            }" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void chdir(String path) throws java.io.IOException,  com.enterprisedt.net.ftp.FTPException{" + NL + "      ftpClient.chdir(path);" + NL + "    }" + NL + "" + NL + "    public String pwd() throws java.io.IOException,  com.enterprisedt.net.ftp.FTPException{" + NL + "      return ftpClient.pwd();" + NL + "    }" + NL + "" + NL + "    private void downloadFile(String localFileName, String remoteFileName) throws java.io.IOException, com.enterprisedt.net.ftp.FTPException {" + NL + "      java.io.File localFile = new java.io.File(localFileName);" + NL + "" + NL + "      try {";
  protected final String TEXT_140 = NL + "          java.io.FileOutputStream fout = new java.io.FileOutputStream(localFile, true);" + NL + "          ftpClient.get(fout, remoteFileName);" + NL + "\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_142 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_143 = ".delete(0,log4jSb_";
  protected final String TEXT_144 = ".length());" + NL + "\t\t\t";
  protected final String TEXT_145 = NL + "          msg_";
  protected final String TEXT_146 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_147 = NL + "            System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_148 = NL + "          globalMap.put(\"";
  protected final String TEXT_149 = "_CURRENT_STATUS\", \"File transfer OK.\");";
  protected final String TEXT_150 = NL + "          if (!localFile.exists()) {" + NL + "            ftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_152 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_153 = ".delete(0,log4jSb_";
  protected final String TEXT_154 = ".length());" + NL + "\t\t\t";
  protected final String TEXT_155 = NL + "            msg_";
  protected final String TEXT_156 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_157 = NL + "              System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_158 = NL + "            globalMap.put(\"";
  protected final String TEXT_159 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "          } else { " + NL + "            msg_";
  protected final String TEXT_160 = ".add(\"file [\"+ remoteFileName +\"] exit transmission.\");" + NL + "            globalMap.put(\"";
  protected final String TEXT_161 = "_CURRENT_STATUS\", \"No file transfered.\");" + NL + "          }";
  protected final String TEXT_162 = NL + "          ftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_164 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_165 = ".delete(0,log4jSb_";
  protected final String TEXT_166 = ".length());" + NL + "\t\t\t";
  protected final String TEXT_167 = NL + "          msg_";
  protected final String TEXT_168 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_169 = NL + "            System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_170 = NL + "          if (localFile.exists()) {" + NL + "            long ftpSize = ftpClient.size(remoteFileName);" + NL + "            long localSize = localFile.length();" + NL + "" + NL + "            if (ftpSize != localSize) {" + NL + "              ftpClient.get(localFileName, remoteFileName);" + NL + "\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_172 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\t\t\tlog4jSb_";
  protected final String TEXT_173 = ".delete(0,log4jSb_";
  protected final String TEXT_174 = ".length());" + NL + "\t\t\t\t";
  protected final String TEXT_175 = NL + "              msg_";
  protected final String TEXT_176 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_177 = NL + "              \tSystem.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_178 = NL + "              globalMap.put(\"";
  protected final String TEXT_179 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "            } else {" + NL + "              msg_";
  protected final String TEXT_180 = ".add(\"file [\"+ remoteFileName +\"] exit transmission.\");" + NL + "              globalMap.put(\"";
  protected final String TEXT_181 = "_CURRENT_STATUS\", \"No file transfered.\");" + NL + "            }" + NL + "          } else {" + NL + "            ftpClient.get(localFileName, remoteFileName);" + NL + "            msg_";
  protected final String TEXT_182 = ".add(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_183 = NL + "              System.out.println(\"file [\" + remoteFileName + \"] downloaded successfully.\");";
  protected final String TEXT_184 = NL + "            globalMap.put(\"";
  protected final String TEXT_185 = "_CURRENT_STATUS\", \"File transfer OK.\");" + NL + "          }";
  protected final String TEXT_186 = NL + "      } catch (com.enterprisedt.net.ftp.FTPException e) {" + NL + "        msg_";
  protected final String TEXT_187 = ".add(\"file [\" + remoteFileName + \"] downloaded unsuccessfully.\");" + NL + "        globalMap.put(\"";
  protected final String TEXT_188 = "_CURRENT_STATUS\", \"File transfer fail.\");" + NL + "\t\t";
  protected final String TEXT_189 = NL + "\t\t\tlog.fatal(\"";
  protected final String TEXT_190 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_191 = NL + "        throw e;" + NL + "      }" + NL + "      count++;" + NL + "    }" + NL + "  }" + NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_192 = " = null;" + NL;
  protected final String TEXT_193 = NL + "    ftp_";
  protected final String TEXT_194 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_195 = "\");" + NL + "\t";
  protected final String TEXT_196 = NL + "\t\tif(ftp_";
  protected final String TEXT_197 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_198 = " - Uses an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_199 = ".getRemoteHost() + \". Connection port: \" + ftp_";
  protected final String TEXT_200 = ".getRemotePort() + \".\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_201 = "    " + NL + "    ftp_";
  protected final String TEXT_202 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_203 = ".setRemoteHost(";
  protected final String TEXT_204 = ");" + NL + "    ftp_";
  protected final String TEXT_205 = ".setRemotePort(";
  protected final String TEXT_206 = ");" + NL;
  protected final String TEXT_207 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_208 = " - \" + ";
  protected final String TEXT_209 = ");" + NL + "\t";
  protected final String TEXT_210 = NL + "      ftp_";
  protected final String TEXT_211 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_212 = NL + "      ftp_";
  protected final String TEXT_213 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_214 = NL + "    ftp_";
  protected final String TEXT_215 = ".setControlEncoding(";
  protected final String TEXT_216 = ");" + NL + "\t";
  protected final String TEXT_217 = NL + "\t\tlog.info(\"";
  protected final String TEXT_218 = " - Authentication using a password.\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_219 = " - Connection attempt to '\" + ";
  protected final String TEXT_220 = " + \"' as '\" +";
  protected final String TEXT_221 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_222 = NL + "    ftp_";
  protected final String TEXT_223 = ".connect();" + NL + "    ftp_";
  protected final String TEXT_224 = ".login(";
  protected final String TEXT_225 = ", ";
  protected final String TEXT_226 = ");  " + NL + "\t";
  protected final String TEXT_227 = NL + "\t\tlog.info(\"";
  protected final String TEXT_228 = " - Connection to '\" + ";
  protected final String TEXT_229 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_230 = "  ";
  protected final String TEXT_231 = NL + "  msg_";
  protected final String TEXT_232 = ".clearAll();" + NL + "  FTPGetter_";
  protected final String TEXT_233 = " getter_";
  protected final String TEXT_234 = " = new FTPGetter_";
  protected final String TEXT_235 = "();" + NL + "  getter_";
  protected final String TEXT_236 = ".ftpClient = ftp_";
  protected final String TEXT_237 = ";" + NL + "  String remotedir_";
  protected final String TEXT_238 = " = ";
  protected final String TEXT_239 = ";" + NL + "  ftp_";
  protected final String TEXT_240 = ".chdir(remotedir_";
  protected final String TEXT_241 = ");";
  protected final String TEXT_242 = NL + "  class FTPSGetter_";
  protected final String TEXT_243 = " {" + NL + "    private it.sauronsoftware.ftp4j.FTPClient ftpClient = null;" + NL + "    private int count = 0;" + NL + "" + NL + "    public void getAllFiles(String remoteDirectory, String localDirectory)" + NL + "      throws IllegalStateException, IOException, java.io.FileNotFoundException," + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException, " + NL + "      it.sauronsoftware.ftp4j.FTPDataTransferException, it.sauronsoftware.ftp4j.FTPAbortedException, " + NL + "      it.sauronsoftware.ftp4j.FTPListParseException {" + NL + "" + NL + "      ftpClient.changeDirectory(remoteDirectory);" + NL + "      String path = ftpClient.currentDirectory();" + NL + "      it.sauronsoftware.ftp4j.FTPFile[] ftpFiles = null;" + NL + "      ftpFiles = ftpClient.list();" + NL + "" + NL + "      for (it.sauronsoftware.ftp4j.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "        if (ftpFile.getType() == it.sauronsoftware.ftp4j.FTPFile.TYPE_DIRECTORY) {" + NL + "" + NL + "          if ((!(\".\").equals(ftpFile.getName())) && (!(\"..\").equals(ftpFile.getName()))) {" + NL + "            java.io.File localFile = new java.io.File(localDirectory + \"/\" + ftpFile.getName());" + NL + "" + NL + "            if (!localFile.exists()) {" + NL + "              localFile.mkdir();" + NL + "            }" + NL + "            getAllFiles(path + \"/\" + ftpFile.getName(), localDirectory + \"/\" + ftpFile.getName());" + NL + "            ftpClient.changeDirectory(path);" + NL + "          }" + NL + "        } else if (ftpFile.getType() != it.sauronsoftware.ftp4j.FTPFile.TYPE_LINK) {" + NL + "          downloadFile(localDirectory + \"/\" + ftpFile.getName(),ftpFile.getName());" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void getFiles(String remoteDirectory, String localDirectory, String maskStr) " + NL + "      throws IllegalStateException, IOException, java.io.FileNotFoundException," + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException, " + NL + "      it.sauronsoftware.ftp4j.FTPDataTransferException, it.sauronsoftware.ftp4j.FTPAbortedException, " + NL + "      it.sauronsoftware.ftp4j.FTPListParseException {" + NL + "" + NL + "      ftpClient.changeDirectory(remoteDirectory);" + NL + "      it.sauronsoftware.ftp4j.FTPFile[] ftpFiles = null;" + NL + "      ftpFiles = ftpClient.list(\".\");" + NL + "" + NL + "      for(it.sauronsoftware.ftp4j.FTPFile ftpFile : ftpFiles) {" + NL + "" + NL + "        if ((ftpFile.getType() != it.sauronsoftware.ftp4j.FTPFile.TYPE_DIRECTORY) && (ftpFile.getType() != it.sauronsoftware.ftp4j.FTPFile.TYPE_LINK)) {" + NL + "          String fileName = ftpFile.getName();" + NL + "" + NL + "          if (fileName.matches(maskStr)) {" + NL + "            downloadFile(localDirectory + \"/\" + fileName,fileName);" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "" + NL + "    public void chdir(String path) " + NL + "      throws IllegalStateException, IOException, " + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException {" + NL + "      ftpClient.changeDirectory(path);" + NL + "    }" + NL + "" + NL + "    public String pwd() " + NL + "      throws IllegalStateException, IOException, " + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException {" + NL + "      return ftpClient.currentDirectory();" + NL + "    }" + NL + "" + NL + "    private void downloadFile(String localFileName, String remoteFileName) " + NL + "      throws IllegalStateException, java.io.FileNotFoundException, IOException, " + NL + "      it.sauronsoftware.ftp4j.FTPIllegalReplyException, it.sauronsoftware.ftp4j.FTPException, " + NL + "      it.sauronsoftware.ftp4j.FTPDataTransferException, it.sauronsoftware.ftp4j.FTPAbortedException {" + NL + "      " + NL + "      java.io.File localFile = new java.io.File(localFileName);" + NL + "      ftpClient.download(remoteFileName, localFile);" + NL + "\t\t";
  protected final String TEXT_244 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_245 = " - Downloaded file \" + (count +1) +  \" : '\" + remoteFileName + \"' successfully.\");" + NL + "\t\t\tlog4jSb_";
  protected final String TEXT_246 = ".delete(0,log4jSb_";
  protected final String TEXT_247 = ".length());" + NL + "\t\t";
  protected final String TEXT_248 = NL + "      count++;" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_249 = NL + NL + "    class MyTrust_";
  protected final String TEXT_250 = "{" + NL + "      private javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "        throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "        java.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "        java.io.FileNotFoundException, java.io.IOException {" + NL + "" + NL + "        java.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL + "        ks.load(new java.io.FileInputStream(";
  protected final String TEXT_251 = "), ";
  protected final String TEXT_252 = ".toCharArray());" + NL + "        javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "        tmf.init(ks);" + NL + "        return tmf.getTrustManagers();" + NL + "      }" + NL + "    }" + NL + "    MyTrust_";
  protected final String TEXT_253 = " myTrust_";
  protected final String TEXT_254 = "= null;";
  protected final String TEXT_255 = NL + "  javax.net.ssl.SSLContext sslContext = null;" + NL + "  javax.net.ssl.TrustManager[] trustManager = null;" + NL + "  javax.net.ssl.SSLSocketFactory sslSocketFactory = null;" + NL + "  it.sauronsoftware.ftp4j.FTPClient ftp_";
  protected final String TEXT_256 = " =null;" + NL + "  FTPSGetter_";
  protected final String TEXT_257 = " getter_";
  protected final String TEXT_258 = " = null;" + NL + "  String remotedir_";
  protected final String TEXT_259 = " = null;" + NL + "" + NL + "  try {";
  protected final String TEXT_260 = NL + "      sslContext = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "      myTrust_";
  protected final String TEXT_261 = " = new MyTrust_";
  protected final String TEXT_262 = "();" + NL + "      trustManager = myTrust_";
  protected final String TEXT_263 = ".getTrustManagers();" + NL + "      sslContext.init(null, trustManager, new java.security.SecureRandom());" + NL + "      sslSocketFactory = sslContext.getSocketFactory();" + NL + "      ftp_";
  protected final String TEXT_264 = " = new it.sauronsoftware.ftp4j.FTPClient();" + NL + "      ftp_";
  protected final String TEXT_265 = ".setSSLSocketFactory(sslSocketFactory);";
  protected final String TEXT_266 = NL + "\t\tftp_";
  protected final String TEXT_267 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPS);";
  protected final String TEXT_268 = NL + "    \tftp_";
  protected final String TEXT_269 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPES);";
  protected final String TEXT_270 = NL + "\t  ";
  protected final String TEXT_271 = NL + "\t\tlog.info(\"";
  protected final String TEXT_272 = " - FTPS authentication (";
  protected final String TEXT_273 = ").\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_274 = " - Connection attempt to '\" + ";
  protected final String TEXT_275 = " + \"' as '\" + ";
  protected final String TEXT_276 = "+ \"'.\");" + NL + "\t  ";
  protected final String TEXT_277 = NL + "      ftp_";
  protected final String TEXT_278 = ".connect(";
  protected final String TEXT_279 = ",";
  protected final String TEXT_280 = ");" + NL + "      ftp_";
  protected final String TEXT_281 = ".login(";
  protected final String TEXT_282 = ", ";
  protected final String TEXT_283 = ");" + NL + "\t  \t";
  protected final String TEXT_284 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_285 = " - Connection to '\" + ";
  protected final String TEXT_286 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_287 = NL + "      ftp_";
  protected final String TEXT_288 = " = (it.sauronsoftware.ftp4j.FTPClient)globalMap.get(\"";
  protected final String TEXT_289 = "\");" + NL + "\t  ";
  protected final String TEXT_290 = NL + "\t\tif(ftp_";
  protected final String TEXT_291 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_292 = " - Uses an existing connection as \" + ftp_";
  protected final String TEXT_293 = ".getUsername() + \". Connection hostname: \" + ftp_";
  protected final String TEXT_294 = ".getHost() + \". Connection port: \" + ftp_";
  protected final String TEXT_295 = ".getPort() + \".\"); " + NL + "\t\t}" + NL + "\t  ";
  protected final String TEXT_296 = NL + "    getter_";
  protected final String TEXT_297 = " = new FTPSGetter_";
  protected final String TEXT_298 = "();" + NL + "    getter_";
  protected final String TEXT_299 = ".ftpClient = ftp_";
  protected final String TEXT_300 = ";" + NL + "    remotedir_";
  protected final String TEXT_301 = " = ";
  protected final String TEXT_302 = ";" + NL + "    ftp_";
  protected final String TEXT_303 = ".changeDirectory(remotedir_";
  protected final String TEXT_304 = ");" + NL + "  } catch (java.lang.IllegalStateException e) {" + NL + "\t";
  protected final String TEXT_305 = NL + "\t\tlog.error(\"";
  protected final String TEXT_306 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_307 = NL + "    e.printStackTrace();" + NL + "  } catch (java.io.IOException e) {" + NL + "\t";
  protected final String TEXT_308 = NL + "\t\tlog.error(\"";
  protected final String TEXT_309 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_310 = NL + "    e.printStackTrace();" + NL + "  } catch (it.sauronsoftware.ftp4j.FTPIllegalReplyException e) {" + NL + "\t";
  protected final String TEXT_311 = NL + "\t\tlog.error(\"";
  protected final String TEXT_312 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_313 = NL + "    e.printStackTrace();" + NL + "  } catch (it.sauronsoftware.ftp4j.FTPException e) {" + NL + "\t";
  protected final String TEXT_314 = NL + "\t\tlog.error(\"";
  protected final String TEXT_315 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_316 = NL + "    e.printStackTrace();" + NL + "  }";
  protected final String TEXT_317 = NL + "java.util.List<String> maskList_";
  protected final String TEXT_318 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_319 = "    " + NL + "  maskList_";
  protected final String TEXT_320 = ".add(";
  protected final String TEXT_321 = ");       ";
  protected final String TEXT_322 = "  " + NL + "    ftp_";
  protected final String TEXT_323 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);";
  protected final String TEXT_324 = "  " + NL + "    ftp_";
  protected final String TEXT_325 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.ASCII);";
  protected final String TEXT_326 = NL + "String localdir_";
  protected final String TEXT_327 = "  = ";
  protected final String TEXT_328 = ";  " + NL + "//create folder if local direcotry (assigned by property) not exists" + NL + "java.io.File dirHandle_";
  protected final String TEXT_329 = " = new java.io.File(localdir_";
  protected final String TEXT_330 = ");" + NL + "" + NL + "if (!dirHandle_";
  protected final String TEXT_331 = ".exists()) {" + NL + "  dirHandle_";
  protected final String TEXT_332 = ".mkdirs();" + NL + "}" + NL + "String root_";
  protected final String TEXT_333 = " = getter_";
  protected final String TEXT_334 = ".pwd();" + NL;
  protected final String TEXT_335 = NL + "\tlog.info(\"";
  protected final String TEXT_336 = " - Downloading files from the server.\");";
  protected final String TEXT_337 = NL + "for (String maskStr_";
  protected final String TEXT_338 = " : maskList_";
  protected final String TEXT_339 = ") { ";
  protected final String TEXT_340 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");
String pass = ElementParameterParser.getValue(node, "__PASSWORD__");
String overwrite = ElementParameterParser.getValue(node, "__OVERWRITE__");
String sftpoverwrite =ElementParameterParser.getValue(node, "__SFTPOVERWRITE__");
String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");  
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node,"__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node,"__PRIVATEKEY__");
String passPhrase = ElementParameterParser.getValue(node,"__PASSPHRASE__");
List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
String keystoreFile = ElementParameterParser.getValue(node,"__KEYSTORE_FILE__");
String keystorePass = ElementParameterParser.getValue(node,"__KEYSTORE_PASS__");
boolean append = "true".equals(ElementParameterParser.getValue(node, "__APPEND__"));
String connectMode = ElementParameterParser.getValue(node,"__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean bPrintMsg = "true".equals(ElementParameterParser.getValue(node, "__PRINT_MESSAGE__"));
String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");
boolean sftp = false;
boolean ftps = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if ("true".equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for(INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
      ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
  ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
}

    stringBuffer.append(TEXT_1);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.

if (useProxy){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(proxyPassword );
    stringBuffer.append(TEXT_16);
    
} 

if (sftp) { // *** sftp *** //

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
  if ("false".equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(passPhrase );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
  }
  
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
          if (("overwrite").equals(sftpoverwrite)){
          
    stringBuffer.append(TEXT_32);
    
          } else if (("append").equals(sftpoverwrite)){
          
    stringBuffer.append(TEXT_33);
    
          } else if (("resume").equals(sftpoverwrite)){
          
    stringBuffer.append(TEXT_34);
    
          }
          
    stringBuffer.append(TEXT_35);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    
  if ("true".equals(useExistingConn)){
    String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_52);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
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
    
  } else{
  
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    if ("PUBLICKEY".equals(authMethod)){
    stringBuffer.append(TEXT_68);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_81);
    if("PASSWORD".equals(authMethod)){
    stringBuffer.append(TEXT_82);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    if (!useProxy) {
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_113);
    
  }
  
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
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    
} else if (!ftps) { // *** ftp *** //

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    if (append) {
    stringBuffer.append(TEXT_140);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    }
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    
        } else if ("never".equals(overwrite)){
        
    stringBuffer.append(TEXT_150);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    }
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    
        } else if ("always".equals(overwrite)){
        
    stringBuffer.append(TEXT_162);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    }
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_169);
    }
    
        } else if ("size_differ".equals(overwrite)) {
        
    stringBuffer.append(TEXT_170);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    if (bPrintMsg) {
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    
        }
        
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
      
  if ("true".equals(useExistingConn)){
    String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_195);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    }
    } else {
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_206);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_209);
    }
    if (("ACTIVE").equals(connectMode)){
    
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    
    }else{
    
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    
    }
    
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_216);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_221);
    }
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(pass );
    stringBuffer.append(TEXT_226);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_229);
    }
    stringBuffer.append(TEXT_230);
    } 
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    
} else { // *** ftps *** //

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    }
    stringBuffer.append(TEXT_248);
      
  if ("false".equals(useExistingConn)){
  
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(keystorePass);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
  }
  
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
      
    if ("false".equals(useExistingConn)){
    
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    
	if("IMPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    
	}else if("EXPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    
    }

    stringBuffer.append(TEXT_270);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_276);
    }
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(pass );
    stringBuffer.append(TEXT_283);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_286);
    }
      
    } else {
      String conn= "conn_" + connection;
      
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_289);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    }
      
    }
    
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    }
    stringBuffer.append(TEXT_307);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    }
    stringBuffer.append(TEXT_310);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    }
    stringBuffer.append(TEXT_313);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    }
    stringBuffer.append(TEXT_316);
    
}
// *** share code *** //

    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    
for (int i = 0; i < files.size(); i++) {
  Map<String, String> line = files.get(i);

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_321);
    
}

if (!sftp && !ftps) { // *** ftp *** //
  if ("binary".equalsIgnoreCase(ElementParameterParser.getValue(node, "__MODE__"))) {
  
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    
  }else {  
  
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    
  }
}

    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    }
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(TEXT_340);
    return stringBuffer.toString();
  }
}

package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPGetEndJava
{
  protected static String nl;
  public static synchronized TFTPGetEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPGetEndJava result = new TFTPGetEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "}" + NL + "nb_file_";
  protected final String TEXT_2 = " = getter_";
  protected final String TEXT_3 = ".count;" + NL;
  protected final String TEXT_4 = NL + "  msg_";
  protected final String TEXT_5 = ".add(getter_";
  protected final String TEXT_6 = ".count + \" files have been downloaded.\");" + NL + "  StringBuffer sb_";
  protected final String TEXT_7 = " = new StringBuffer();" + NL + "" + NL + "  for (String item_";
  protected final String TEXT_8 = " : msg_";
  protected final String TEXT_9 = ") {" + NL + "    sb_";
  protected final String TEXT_10 = ".append(item_";
  protected final String TEXT_11 = ").append(\"\\n\");" + NL + "  }" + NL + "  globalMap.put(\"";
  protected final String TEXT_12 = "_TRANSFER_MESSAGES\", sb_";
  protected final String TEXT_13 = ".toString());" + NL;
  protected final String TEXT_14 = NL + "\t";
  protected final String TEXT_15 = NL + "\t\tlog.info(\"";
  protected final String TEXT_16 = " - Closing the connection to the server.\");" + NL + "\t";
  protected final String TEXT_17 = NL + "    session_";
  protected final String TEXT_18 = ".disconnect(); " + NL + "\t";
  protected final String TEXT_19 = NL + "\t\tlog.info(\"";
  protected final String TEXT_20 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_21 = "    ";
  protected final String TEXT_22 = NL + "  msg_";
  protected final String TEXT_23 = ".add(ftp_";
  protected final String TEXT_24 = ".getDownloadCount() + \" files have been downloaded.\");" + NL + "  String[] msgAll_";
  protected final String TEXT_25 = " = msg_";
  protected final String TEXT_26 = ".getAll();" + NL + "  StringBuffer sb_";
  protected final String TEXT_27 = " = new StringBuffer();" + NL + "" + NL + "  if (msgAll_";
  protected final String TEXT_28 = " != null) {" + NL + "    for (String item_";
  protected final String TEXT_29 = " : msgAll_";
  protected final String TEXT_30 = ") {" + NL + "      sb_";
  protected final String TEXT_31 = ".append(item_";
  protected final String TEXT_32 = ").append(\"\\n\");" + NL + "    }" + NL + "  }" + NL + "  globalMap.put(\"";
  protected final String TEXT_33 = "_TRANSFER_MESSAGES\", sb_";
  protected final String TEXT_34 = ".toString());" + NL;
  protected final String TEXT_35 = NL + "      try {" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_37 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_38 = NL + "        ftp_";
  protected final String TEXT_39 = ".quit();" + NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_41 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_42 = NL + "      } catch(java.net.SocketException se_";
  protected final String TEXT_43 = ") {" + NL + "\t\t";
  protected final String TEXT_44 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_45 = " - \" + se_";
  protected final String TEXT_46 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_47 = NL + "        //ignore failure" + NL + "      }";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_50 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_51 = NL + "      ftp_";
  protected final String TEXT_52 = ".quit();" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_54 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t";
  protected final String TEXT_56 = NL + "\t\tlog.info(\"";
  protected final String TEXT_57 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_58 = NL + "    ftp_";
  protected final String TEXT_59 = ".disconnect(true);" + NL + "\t";
  protected final String TEXT_60 = NL + "\t\tlog.info(\"";
  protected final String TEXT_61 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_62 = NL + "globalMap.put(\"";
  protected final String TEXT_63 = "_NB_FILE\",nb_file_";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\tlog.info(\"";
  protected final String TEXT_66 = " - Downloaded files count: \" + nb_file_";
  protected final String TEXT_67 = "  + \".\");" + NL + "\tlog.info(\"";
  protected final String TEXT_68 = " - Done.\");";
  protected final String TEXT_69 = NL;
  protected final String TEXT_70 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String ignoreFailureAtQuit= ElementParameterParser.getValue(node,"__IGNORE_FAILURE_AT_QUIT__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean sftp = false;
boolean ftps = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if (("true").equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for(INode n : nodeList){
    if(n.getUniqueName().equals(connection)){
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
      ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
  ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    if (sftp) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    if (!("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    }
    }
    stringBuffer.append(TEXT_21);
    } else if (!ftps) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
  if (!("true").equals(useExistingConn)) {
  
    if(("true").equals(ignoreFailureAtQuit)){
    
    stringBuffer.append(TEXT_35);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    
    } else {
    
    stringBuffer.append(TEXT_48);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    }
    
    }
  }
} else {

  if (!("true").equals(useExistingConn)){
  
    stringBuffer.append(TEXT_55);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    }
    
  }
}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    return stringBuffer.toString();
  }
}

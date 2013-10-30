package org.talend.designer.codegen.translators.bigdata.hcatalog;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THCatalogInputBeginJava
{
  protected static String nl;
  public static synchronized THCatalogInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THCatalogInputBeginJava result = new THCatalogInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tclass KerberosPolicyConfig_";
  protected final String TEXT_3 = " extends javax.security.auth.login.Configuration {" + NL + "\t\t\tprivate java.util.Map<String, String> properties;" + NL + "" + NL + "\t\t\tpublic KerberosPolicyConfig_";
  protected final String TEXT_4 = "() {" + NL + "\t\t\t\tproperties = java.util.Collections" + NL + "\t\t\t\t\t\t.<String, String> emptyMap();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic KerberosPolicyConfig_";
  protected final String TEXT_5 = "(" + NL + "\t\t\t\t\tjava.util.Map<String, String> properties) {" + NL + "\t\t\t\tthis.properties = properties;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic javax.security.auth.login.AppConfigurationEntry[] getAppConfigurationEntry(" + NL + "\t\t\t\t\tString name) {" + NL + "\t\t\t\treturn new javax.security.auth.login.AppConfigurationEntry[] { new javax.security.auth.login.AppConfigurationEntry(" + NL + "\t\t\t\t\t\tcom.sun.security.auth.module.Krb5LoginModule.class" + NL + "\t\t\t\t\t\t\t\t.getName()," + NL + "\t\t\t\t\t\tjavax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag.REQUIRED," + NL + "\t\t\t\t\t\tproperties) };" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\torg.apache.cxf.jaxrs.security.KerberosAuthOutInterceptor kbInterceptor_";
  protected final String TEXT_6 = " = new org.apache.cxf.jaxrs.security.KerberosAuthOutInterceptor();" + NL + "" + NL + "\t\torg.apache.cxf.configuration.security.AuthorizationPolicy policy_";
  protected final String TEXT_7 = " = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\tpolicy_";
  protected final String TEXT_8 = ".setAuthorizationType(org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_NEGOTIATE);" + NL + "" + NL + "\t\tkbInterceptor_";
  protected final String TEXT_9 = ".setPolicy(policy_";
  protected final String TEXT_10 = ");" + NL + "\t\tjava.util.Map<String, String> properties_";
  protected final String TEXT_11 = " = new java.util.HashMap<String, String>();" + NL + "\t\tkbInterceptor_";
  protected final String TEXT_12 = ".setServicePrincipalName(";
  protected final String TEXT_13 = ");" + NL + "\t\tkbInterceptor_";
  protected final String TEXT_14 = ".setRealm(";
  protected final String TEXT_15 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_16 = ".put(\"useTicketCache\", \"true\");" + NL + "\t\tproperties_";
  protected final String TEXT_17 = ".put(\"refreshKrb5Config\", \"true\");" + NL + "\t\tproperties_";
  protected final String TEXT_18 = ".put(\"renewTGT\", \"true\");";
  protected final String TEXT_19 = NL + "\t\t\t\tproperties_";
  protected final String TEXT_20 = ".put(\"useKeyTab\", \"true\");" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_21 = ".put(\"keyTab\", ";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_23 = ".put(\"principal\", ";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\tkbInterceptor_";
  protected final String TEXT_26 = ".setLoginConfig(new KerberosPolicyConfig_";
  protected final String TEXT_27 = "(properties_";
  protected final String TEXT_28 = "));";
  protected final String TEXT_29 = "\t" + NL + "\torg.apache.cxf.jaxrs.client.WebClient client_";
  protected final String TEXT_30 = " = org.apache.cxf.jaxrs.client.WebClient.create(\"http://\" + ";
  protected final String TEXT_31 = " + \":\" + ";
  protected final String TEXT_32 = " + \"?user.name=\" + ";
  protected final String TEXT_33 = ");" + NL;
  protected final String TEXT_34 = NL + "\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(client_";
  protected final String TEXT_35 = ").getOutInterceptors().add(kbInterceptor_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\t" + NL + "\tString pathEndpoint_";
  protected final String TEXT_38 = " = \"templeton/v1/ddl/database/\" + ";
  protected final String TEXT_39 = " + \"/table/\" + ";
  protected final String TEXT_40 = " + \"/partition/\" + ";
  protected final String TEXT_41 = ";" + NL + "\tString location_";
  protected final String TEXT_42 = " = \"\";" + NL + "\t";
  protected final String TEXT_43 = NL + "\t\t\tString err_";
  protected final String TEXT_44 = " = \"\";" + NL + "\t\t\torg.json.simple.JSONObject jsonRow_";
  protected final String TEXT_45 = " = new org.json.simple.JSONObject();" + NL + "\t\t\tjava.io.InputStream is_";
  protected final String TEXT_46 = ";" + NL + "\t\t\tObject obj_";
  protected final String TEXT_47 = ";" + NL + "\t\t\torg.json.simple.JSONObject object_";
  protected final String TEXT_48 = ";" + NL + "\t\t\tObject error_";
  protected final String TEXT_49 = ";";
  protected final String TEXT_50 = NL + "\t\t\tis_";
  protected final String TEXT_51 = " = (java.io.InputStream) response_";
  protected final String TEXT_52 = ".getEntity();" + NL + "\t\t\tString result_";
  protected final String TEXT_53 = " = org.apache.cxf.helpers.IOUtils.toString(is_";
  protected final String TEXT_54 = ");" + NL + "\t\t\tobj_";
  protected final String TEXT_55 = "=org.json.simple.JSONValue.parse(result_";
  protected final String TEXT_56 = ");" + NL + "\t\t\tobject_";
  protected final String TEXT_57 = "=(org.json.simple.JSONObject)obj_";
  protected final String TEXT_58 = ";";
  protected final String TEXT_59 = NL + "\t\t\terror_";
  protected final String TEXT_60 = " = object_";
  protected final String TEXT_61 = ".get(\"error\");" + NL + "\t\t\tif(error_";
  protected final String TEXT_62 = "!=null) {" + NL + "\t\t\t\terr_";
  protected final String TEXT_63 = " = error_";
  protected final String TEXT_64 = ".toString();" + NL + "\t\t\t}";
  protected final String TEXT_65 = NL + "\t\t\t\tif(((org.json.simple.JSONObject)object_";
  protected final String TEXT_66 = ".get(\"exec\"))!=null) {" + NL + "\t\t\t\t\tString time_";
  protected final String TEXT_67 = " = TalendDate.formatDate(\"yyyyMMddHHmmss\", TalendDate.getCurrentDate());" + NL + "\t\t\t\t\tObject stdout_";
  protected final String TEXT_68 = " = ((org.json.simple.JSONObject)object_";
  protected final String TEXT_69 = ".get(\"exec\")).get(\"stdout\");" + NL + "\t\t\t\t\tObject stderr_";
  protected final String TEXT_70 = " = ((org.json.simple.JSONObject)object_";
  protected final String TEXT_71 = ".get(\"exec\")).get(\"stderr\");" + NL + "\t\t\t\t\tString stdout_filename_";
  protected final String TEXT_72 = " = \"/\" + projectName + \"_\" + jobName + \"_\" + jobVersion + \"_\" + time_";
  protected final String TEXT_73 = " + \"_\" + \"";
  protected final String TEXT_74 = "\" + \"_stdout.log\";" + NL + "\t\t\t\t\tString stderr_filename_";
  protected final String TEXT_75 = " = \"/\" + projectName + \"_\" + jobName + \"_\" + jobVersion + \"_\" + time_";
  protected final String TEXT_76 = " + \"_\" + \"";
  protected final String TEXT_77 = "\" + \"_stderr.log\";" + NL + "\t\t\t\t\tjava.io.FileWriter fw_out_";
  protected final String TEXT_78 = " = new java.io.FileWriter(new java.io.File(";
  protected final String TEXT_79 = "+stdout_filename_";
  protected final String TEXT_80 = "));" + NL + "\t\t\t\t\tjava.io.FileWriter fw_err_";
  protected final String TEXT_81 = " = new java.io.FileWriter(new java.io.File(";
  protected final String TEXT_82 = "+stderr_filename_";
  protected final String TEXT_83 = "));" + NL + "\t\t\t\t\tfw_out_";
  protected final String TEXT_84 = ".write(stdout_";
  protected final String TEXT_85 = "!=null?stdout_";
  protected final String TEXT_86 = ".toString():\"\");" + NL + "\t\t\t\t\tfw_err_";
  protected final String TEXT_87 = ".write(stderr_";
  protected final String TEXT_88 = "!=null?stderr_";
  protected final String TEXT_89 = ".toString():\"\");" + NL + "\t\t\t\t\tfw_out_";
  protected final String TEXT_90 = ".close();" + NL + "\t\t\t\t\tfw_err_";
  protected final String TEXT_91 = ".close();" + NL + "\t\t\t\t}";
  protected final String TEXT_92 = NL + "\t\t\tif(response_";
  protected final String TEXT_93 = ".getStatus()!=200) {" + NL + "\t\t\t\tif(response_";
  protected final String TEXT_94 = ".getStatus()==400) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 400 (Bad request): The request was invalid.\\n--->\" + err_";
  protected final String TEXT_95 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_96 = ".getStatus()==401) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 401 (Unauthorized): Credentials were missing or incorrect.\\n--->\" + err_";
  protected final String TEXT_97 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_98 = ".getStatus()==404) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 404 (Not found): The URI requested is invalid or the resource requested does not exist.\\n--->\" + err_";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_100 = ".getStatus()==500) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 500 (Internal Server Error): We received an unexpected result.\\n--->\" + err_";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_102 = ".getStatus()==503) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 503 (Busy, please retry): The server is busy.\\n--->\" + err_";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tthrow new Exception(object_";
  protected final String TEXT_104 = ".get(\"errorCode\") + \":\" + object_";
  protected final String TEXT_105 = ".get(\"error\") + object_";
  protected final String TEXT_106 = ".get(\"errorDetail\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_107 = NL + "\ttry {" + NL + "\t\tclient_";
  protected final String TEXT_108 = ".path(pathEndpoint_";
  protected final String TEXT_109 = ");" + NL + "\t\tclient_";
  protected final String TEXT_110 = ".accept(\"application/json\");" + NL + "\t\t" + NL + "\t\tjavax.ws.rs.core.Response response_";
  protected final String TEXT_111 = " = client_";
  protected final String TEXT_112 = ".get();" + NL;
  protected final String TEXT_113 = "\t\t" + NL + "\t\tObject loc_";
  protected final String TEXT_114 = " = object_";
  protected final String TEXT_115 = ".get(\"location\");" + NL + "\t\tif(loc_";
  protected final String TEXT_116 = "!=null) {" + NL + "\t\t\tlocation_";
  protected final String TEXT_117 = " = loc_";
  protected final String TEXT_118 = ".toString();" + NL + "\t\t}" + NL + "\t} catch (Exception e_";
  protected final String TEXT_119 = ") {";
  protected final String TEXT_120 = NL + "\t\t\tthrow e_";
  protected final String TEXT_121 = ";";
  protected final String TEXT_122 = NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_123 = ".getMessage());";
  protected final String TEXT_124 = NL + "\t}" + NL + "\t" + NL + "\tif(location_";
  protected final String TEXT_125 = " == null || \"\".equals(location_";
  protected final String TEXT_126 = ") || location_";
  protected final String TEXT_127 = ".length() <= 0) {";
  protected final String TEXT_128 = NL + "\t\t\tthrow new Exception(\"Error during the response parsing. The Templeton server has returned a bad value or the location isn't available\");";
  protected final String TEXT_129 = NL + "\t\t\tSystem.err.println(\"Error during the response parsing. The Templeton server has returned a bad value or the location isn't available\");";
  protected final String TEXT_130 = NL + "\t}" + NL + "\t\t" + NL + "\tString pathHDFS_";
  protected final String TEXT_131 = " = \"\";" + NL + "\tString namenode_";
  protected final String TEXT_132 = " = \"\";" + NL + "\t" + NL + "\tif(location_";
  protected final String TEXT_133 = ".contains(\":\")) {" + NL + "\t\tpathHDFS_";
  protected final String TEXT_134 = " = \"/\" + (location_";
  protected final String TEXT_135 = ".split(\":\")[2]).split(\"/\", 2)[1];" + NL + "\t\tnamenode_";
  protected final String TEXT_136 = " = location_";
  protected final String TEXT_137 = ".substring(0, location_";
  protected final String TEXT_138 = ".length()- pathHDFS_";
  protected final String TEXT_139 = ".length());" + NL + "\t}";
  protected final String TEXT_140 = NL + "\t\tString username_";
  protected final String TEXT_141 = " = \"\";" + NL + "\t\torg.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_142 = " = null;";
  protected final String TEXT_143 = NL + "\t\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_144 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\t\tconf_";
  protected final String TEXT_145 = ".set(\"fs.default.name\", namenode_";
  protected final String TEXT_146 = ");";
  protected final String TEXT_147 = NL + "\t\t\tconf_";
  protected final String TEXT_148 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "\t\t\tusername_";
  protected final String TEXT_154 = " = ";
  protected final String TEXT_155 = ";";
  protected final String TEXT_156 = NL + "\t\t\t\tconf_";
  protected final String TEXT_157 = ".set(";
  protected final String TEXT_158 = " ,";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "\t\tif(username_";
  protected final String TEXT_161 = " == null || \"\".equals(username_";
  protected final String TEXT_162 = ")){" + NL + "\t\t\tfs_";
  protected final String TEXT_163 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_164 = ");" + NL + "\t\t}else{" + NL + "\t\t\tfs_";
  protected final String TEXT_165 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_166 = ".get(\"fs.default.name\")),conf_";
  protected final String TEXT_167 = ",username_";
  protected final String TEXT_168 = ");" + NL + "\t\t}\t" + NL + "" + NL + "\t\torg.apache.hadoop.fs.FileStatus [] fileStatus_";
  protected final String TEXT_169 = "= fs_";
  protected final String TEXT_170 = ".listStatus(new org.apache.hadoop.fs.Path(pathHDFS_";
  protected final String TEXT_171 = "));" + NL + "\t\tfor(int i_";
  protected final String TEXT_172 = "=0; i_";
  protected final String TEXT_173 = "<fileStatus_";
  protected final String TEXT_174 = ".length; i_";
  protected final String TEXT_175 = "++) {" + NL + "\t\t\torg.apache.hadoop.fs.Path path_";
  protected final String TEXT_176 = " = fileStatus_";
  protected final String TEXT_177 = "[i_";
  protected final String TEXT_178 = "].getPath();" + NL + "\t\t\torg.apache.hadoop.fs.FSDataInputStream fsDataInputStream_";
  protected final String TEXT_179 = " = fs_";
  protected final String TEXT_180 = ".open(path_";
  protected final String TEXT_181 = ");" + NL + "\t\t\torg.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_182 = " = new org.talend.fileprocess.FileInputDelimited(fsDataInputStream_";
  protected final String TEXT_183 = ", ";
  protected final String TEXT_184 = ",";
  protected final String TEXT_185 = ",";
  protected final String TEXT_186 = ",false,0,0,-1,-1, false);" + NL + "\t\t\twhile (fid_";
  protected final String TEXT_187 = ".nextRecord()) {";
  protected final String TEXT_188 = NL + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
	boolean customEncoding="true".equals( ElementParameterParser.getValue(node,"__CUSTOM_ENCODING__"));
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	
	String templetonHost = ElementParameterParser.getValue(node, "__TEMPLETON_HOST__");
	String templetonPort = ElementParameterParser.getValue(node, "__TEMPLETON_PORT__");
	String database = ElementParameterParser.getValue(node, "__DATABASE_NAME__");
	String table = ElementParameterParser.getValue(node, "__TABLE_NAME__");
	String partition = ElementParameterParser.getValue(node, "__PARTITION_NAME__");
	String user = ElementParameterParser.getValue(node, "__USERNAME__");
	
	String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
		
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
	
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	boolean activateLog = "true".equals(ElementParameterParser.getValue(node, "__ACTIVATE_LOG__"));
	
	String stdout = ElementParameterParser.getValue(node, "__STDOUT__");
	String stderr = ElementParameterParser.getValue(node, "__STDERR__");
	
	IConnection outConn = null;
	IMetadataTable metadata = null;
	
	boolean useKerberos = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String krb_realm = ElementParameterParser.getValue(node, "__KRB_REALM__");
	String krb_princ = ElementParameterParser.getValue(node, "__KRB_PRINC__");
	String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
	
	if(useKerberos) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(krb_princ);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(krb_realm);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_24);
    
			}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
	}	

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(templetonHost);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(templetonPort);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_33);
    
	if(useKerberos) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
	}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	class ParseRestResult {
	
		protected String cid;
		protected boolean activateLog;
		protected String stdout;
		protected String stderr;
	
	
		public void declareVariable(INode node) {
			this.cid = node.getUniqueName();

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
    
		}
	
		public void getJSONObject(INode node, String context) {
			this.cid = node.getUniqueName();

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
		}
		
		public void manageError(INode node, boolean activateLog) {
			this.cid = node.getUniqueName();
			this.activateLog = activateLog;

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
    
			if(this.activateLog) {
				this.stdout = ElementParameterParser.getValue(node, "__STDOUT__");
				this.stderr = ElementParameterParser.getValue(node, "__STDERR__");

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
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
    stringBuffer.append(this.stdout);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(this.stderr);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
			}
		}
		
		public void manageResponseStatus(INode node, String context) {
			this.cid = node.getUniqueName();

    stringBuffer.append(TEXT_92);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
		}
	}

    
		ParseRestResult parserResult = new ParseRestResult();
		parserResult.declareVariable(node);

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
			parserResult.getJSONObject(node, null);
			parserResult.manageError(node, activateLog);
			parserResult.manageResponseStatus(node, null);

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
    
		if(dieOnError) {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
		} else {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
		}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
		if(dieOnError) {

    stringBuffer.append(TEXT_128);
    
		} else {

    stringBuffer.append(TEXT_129);
    
		}

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		if (metadata!=null) { 

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
       
		String hadoopVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
		if(useKerberos) {

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_149);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_152);
    
			}
		} else {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_155);
    
		}
		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_159);
     
			} 
		}

    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append((customEncoding?encoding:null) );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    
		}
	}

    stringBuffer.append(TEXT_188);
    return stringBuffer.toString();
  }
}

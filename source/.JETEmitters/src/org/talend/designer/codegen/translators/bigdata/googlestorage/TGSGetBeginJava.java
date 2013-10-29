package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TGSGetBeginJava
{
  protected static String nl;
  public static synchronized TGSGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSGetBeginJava result = new TGSGetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_4 = " = null;" + NL + "\ttry {";
  protected final String TEXT_5 = NL + "\t\tservice_";
  protected final String TEXT_6 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_9 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_12 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\tservice_";
  protected final String TEXT_15 = ".getAccountOwner();";
  protected final String TEXT_16 = NL + "\t\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_17 = "=service_";
  protected final String TEXT_18 = ".listAllBuckets(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_21 = "=service_";
  protected final String TEXT_22 = ".listAllBuckets();";
  protected final String TEXT_23 = NL + "\t\tfor (org.jets3t.service.model.GSBucket bucket_";
  protected final String TEXT_24 = " : buckets_";
  protected final String TEXT_25 = ") {" + NL + "\t\t\tString currentBucketName_";
  protected final String TEXT_26 = " = bucket_";
  protected final String TEXT_27 = ".getName();" + NL + "\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_28 = " = service_";
  protected final String TEXT_29 = ".listObjects(currentBucketName_";
  protected final String TEXT_30 = "," + NL + "\t\t\t";
  protected final String TEXT_31 = " null ";
  protected final String TEXT_32 = "," + NL + "\t\t\t";
  protected final String TEXT_33 = " null ";
  protected final String TEXT_34 = NL + "\t\t\t);";
  protected final String TEXT_35 = NL + "\t\tjava.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_36 = " = new java.util.ArrayList<java.util.Map<String,String>>();";
  protected final String TEXT_37 = NL + "\t\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap_";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = ".put(\"BUCKET_NAME\",";
  protected final String TEXT_42 = ");" + NL + "\t\t\tmap_";
  protected final String TEXT_43 = "_";
  protected final String TEXT_44 = ".put(\"OBJECT_KEY\",";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "\t\t\tmap_";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = ".put(\"OBJECT_NEWNAME\",";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\t\tmap_";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = ".put(\"OBJECT_NEWNAME\",";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\t\t\tlist_";
  protected final String TEXT_55 = ".add(map_";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\t\tjava.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_59 = " = new java.util.ArrayList<java.util.Map<String,String>>();";
  protected final String TEXT_60 = NL + "\t\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap_";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = ".put(\"BUCKET_NAME\",";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\t\t\tmap_";
  protected final String TEXT_67 = "_";
  protected final String TEXT_68 = ".put(\"OBJECT_PREFIX\",";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\t\t\tmap_";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = ".put(\"OBJECT_DELIMITER\",";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\t\tlist_";
  protected final String TEXT_75 = ".add(map_";
  protected final String TEXT_76 = "_";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "\t\t\tfor (java.util.Map<String, String> map_";
  protected final String TEXT_79 = ": list_";
  protected final String TEXT_80 = ") {" + NL + "\t\t\t\tString currentBucketName_";
  protected final String TEXT_81 = "=map_";
  protected final String TEXT_82 = ".get(\"BUCKET_NAME\");" + NL + "\t\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_83 = " =new org.jets3t.service.model.GSObject[0];" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tobjects_";
  protected final String TEXT_84 = " = service_";
  protected final String TEXT_85 = ".listObjects(currentBucketName_";
  protected final String TEXT_86 = ",map_";
  protected final String TEXT_87 = ".get(\"OBJECT_PREFIX\"),map_";
  protected final String TEXT_88 = ".get(\"OBJECT_DELIMITER\"));" + NL + "\t\t\t\t}catch(java.lang.Exception e_";
  protected final String TEXT_89 = "){";
  protected final String TEXT_90 = NL + "\t\t\t\t\tthrow(e_";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_93 = ".getMessage());";
  protected final String TEXT_94 = NL + "\t\t\t\t}";
  protected final String TEXT_95 = NL + "\t\t\t\tfor (org.jets3t.service.model.GSObject objectSummary_";
  protected final String TEXT_96 = " : objects_";
  protected final String TEXT_97 = ") {" + NL + "\t\t\t\t\tString objkey_";
  protected final String TEXT_98 = " = objectSummary_";
  protected final String TEXT_99 = ".getKey();" + NL + "\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_100 = " = new java.io.File(";
  protected final String TEXT_101 = "+objkey_";
  protected final String TEXT_102 = ");" + NL + "\t\t\t\t\torg.jets3t.service.model.GSObject obj_";
  protected final String TEXT_103 = " = service_";
  protected final String TEXT_104 = ".getObject(currentBucketName_";
  protected final String TEXT_105 = ", objkey_";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\t\t\t\tfor (java.util.Map<String, String> map_";
  protected final String TEXT_108 = ": list_";
  protected final String TEXT_109 = ") {" + NL + "\t\t\t\t\tString currentBucketName_";
  protected final String TEXT_110 = "=map_";
  protected final String TEXT_111 = ".get(\"BUCKET_NAME\");" + NL + "\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_112 = " = new java.io.File(";
  protected final String TEXT_113 = "+map_";
  protected final String TEXT_114 = ".get(\"OBJECT_NEWNAME\"));" + NL + "\t\t\t\t\torg.jets3t.service.model.GSObject obj_";
  protected final String TEXT_115 = " =null;" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tobj_";
  protected final String TEXT_116 = " = service_";
  protected final String TEXT_117 = ".getObject(currentBucketName_";
  protected final String TEXT_118 = ", map_";
  protected final String TEXT_119 = ".get(\"OBJECT_KEY\"));" + NL + "\t\t\t\t\t}catch(java.lang.Exception e_";
  protected final String TEXT_120 = "){";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\tthrow(e_";
  protected final String TEXT_122 = ");";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_124 = ".getMessage());";
  protected final String TEXT_125 = NL + "\t\t\t\t\t}";
  protected final String TEXT_126 = NL + "\t\t\t\t\tif(obj_";
  protected final String TEXT_127 = "!=null){" + NL + "\t\t\t\t\t\tnb_line_";
  protected final String TEXT_128 = "++;" + NL + "\t\t\t\t\t\tboolean isDirectory_";
  protected final String TEXT_129 = "=false;" + NL + "\t\t\t\t\t\tString fileName_";
  protected final String TEXT_130 = " =file_";
  protected final String TEXT_131 = " .getAbsolutePath();" + NL + "\t\t\t\t\t\tfileName_";
  protected final String TEXT_132 = " =fileName_";
  protected final String TEXT_133 = " .replace(\"\\\\\", \"/\");" + NL + "\t\t\t\t\t\tString createDir_";
  protected final String TEXT_134 = "=\"\";" + NL + "\t\t\t\t\t\tif(obj_";
  protected final String TEXT_135 = ".isDirectoryPlaceholder()){" + NL + "\t\t\t\t\t\t\tcreateDir_";
  protected final String TEXT_136 = " = fileName_";
  protected final String TEXT_137 = ";" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tcreateDir_";
  protected final String TEXT_138 = "=\tfileName_";
  protected final String TEXT_139 = ".substring(0,fileName_";
  protected final String TEXT_140 = ".indexOf(\"/\"));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif (!\"\".equals(createDir_";
  protected final String TEXT_141 = ")) {" + NL + "\t\t\t\t\t\t\tjava.io.File parentDir_";
  protected final String TEXT_142 = "=new java.io.File(createDir_";
  protected final String TEXT_143 = ");" + NL + "\t\t\t\t\t\t\tif(!parentDir_";
  protected final String TEXT_144 = ".exists()){" + NL + "\t\t\t\t\t\t\t\tparentDir_";
  protected final String TEXT_145 = ".mkdirs();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(!obj_";
  protected final String TEXT_146 = ".isDirectoryPlaceholder()){" + NL + "\t\t\t\t\t\t\tjava.io.File parentDir_";
  protected final String TEXT_147 = "=new java.io.File(file_";
  protected final String TEXT_148 = ".getParent());" + NL + "\t\t\t\t\t\t\tif(!parentDir_";
  protected final String TEXT_149 = ".exists()){" + NL + "\t\t\t\t\t\t\t\tparentDir_";
  protected final String TEXT_150 = ".mkdirs();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tjava.io.InputStream input_";
  protected final String TEXT_151 = " = obj_";
  protected final String TEXT_152 = ".getDataInputStream();" + NL + "\t\t\t\t\t\t\tbyte bytes_";
  protected final String TEXT_153 = "[] = new byte[4 * 1024];" + NL + "\t\t\t\t\t\t\tint len_";
  protected final String TEXT_154 = " = -1;" + NL + "\t\t\t\t\t\t\tjava.io.FileOutputStream out_";
  protected final String TEXT_155 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_156 = ");" + NL + "\t" + NL + "\t\t\t\t\t\t\twhile ((len_";
  protected final String TEXT_157 = " = input_";
  protected final String TEXT_158 = ".read(bytes_";
  protected final String TEXT_159 = ")) != -1) {" + NL + "\t\t\t\t\t\t\t\tout_";
  protected final String TEXT_160 = ".write(bytes_";
  protected final String TEXT_161 = ", 0, len_";
  protected final String TEXT_162 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tout_";
  protected final String TEXT_163 = ".flush();" + NL + "\t\t\t\t\t\t\tinput_";
  protected final String TEXT_164 = ".close(); " + NL + "\t\t\t\t\t\t\tout_";
  protected final String TEXT_165 = ".close(); " + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tobj_";
  protected final String TEXT_166 = ".closeDataInputStream();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	String secretKey = ElementParameterParser.getValue(node, "__SECRET_KEY__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isSpecifyprojectID=("true").equals(ElementParameterParser.getValue(node,"__SPECIFY_PROJECT__"));
	String projectID=ElementParameterParser.getValue(node,"__PROJECT_ID__");
	List<Map<String, String>> keys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__KEYS__");
	String objects_prefix=ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");
	String delimiter=ElementParameterParser.getValue(node,"__DELIMITER__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	
	String outputsDir = ElementParameterParser.getValue(node, "__DIRECTORY__");
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    
	}else{

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(secretKey);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    		
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
	boolean getList = "true".equals(ElementParameterParser.getValue(node,"__GETLIST__"));
	boolean useKeysList = "true".equals(ElementParameterParser.getValue(node,"__USE_KEYS_LIST__"));
	if(!getList && !useKeysList){
		if(isSpecifyprojectID){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(projectID);
    stringBuffer.append(TEXT_19);
    
		}else{

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    if(objects_prefix!=null && objects_prefix.trim().length()>0){
    stringBuffer.append(objects_prefix);
     }else{
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    if(delimiter!=null && delimiter.trim().length()>0){
    stringBuffer.append(delimiter);
     }else{
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    
	}else if(useKeysList && keys.size()>0){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
		for(int i=0;i<keys.size();i++){
			Map<String, String> objKey=keys.get(i);
			String bucket_name =objKey.get("BUCKET_NAME");
			String key =objKey.get("KEY");
			String newName =objKey.get("NEW_NAME");
			if(key!=null && key.trim().length()>0){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_45);
    
				if(newName!=null && !"".equals(newName.trim()) && !"\"\"".equals(newName.trim())){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(newName);
    stringBuffer.append(TEXT_49);
    
				}else{

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_53);
    					
				}
			}

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_57);
    
		}
	} else if(getList && buckets.size()>0){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		for(int i=0;i<buckets.size();i++){
			Map<String, String> map=buckets.get(i);
			String bucket_name =map.get("BUCKET_NAME");
			String object_prefix =map.get("OBJECT_PREFIX");
			String object_delimiter =map.get("OBJECT_DELIMITER");

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_65);
    
			if(object_prefix!=null && object_prefix.trim().length()>0){

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(object_prefix);
    stringBuffer.append(TEXT_69);
    
			}
			if(object_delimiter!=null && object_delimiter.trim().length()>0){

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(object_delimiter);
    stringBuffer.append(TEXT_73);
    
			}

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_77);
    
		}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
		} else {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
		}

    stringBuffer.append(TEXT_94);
    
	}
	if((!getList && !useKeysList) || (useKeysList && keys.size()>0) || (getList && buckets.size()>0)){
		if(!useKeysList){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(outputsDir);
    stringBuffer.append(TEXT_101);
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
    
		}else{

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(outputsDir);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
			if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
			} else {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
			}

    stringBuffer.append(TEXT_125);
    
		}

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
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
    
	}

    return stringBuffer.toString();
  }
}

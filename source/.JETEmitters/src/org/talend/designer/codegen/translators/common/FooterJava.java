package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.CorePlugin;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.model.process.ElementParameterParser;

public class FooterJava
{
  protected static String nl;
  public static synchronized FooterJava create(String lineSeparator)
  {
    nl = lineSeparator;
    FooterJava result = new FooterJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    public String resuming_logs_dir_path = null;" + NL + "    public String resuming_checkpoint_path = null;" + NL + "    public String parent_part_launcher = null;" + NL + "    private String resumeEntryMethodName = null;" + NL + "    private boolean globalResumeTicket = false;" + NL + "" + NL + "    public boolean watch = false;" + NL + "    // portStats is null, it means don't execute the statistics" + NL + "    public Integer portStats = null;" + NL + "    public int portTraces = 4334;" + NL + "    public String clientHost;" + NL + "    public String defaultClientHost = \"localhost\";" + NL + "    public String contextStr = \"";
  protected final String TEXT_2 = "\";" + NL + "    public boolean isDefaultContext = true;" + NL + "    public String pid = \"0\";" + NL + "    public String rootPid = null;" + NL + "    public String fatherPid = null;" + NL + "    public String fatherNode = null;" + NL + "    public long startTime = 0;" + NL + "    public boolean isChildJob = false;" + NL + "    public String log4jLevel = null;" + NL + "" + NL + "    private boolean execStat = true;" + NL + "" + NL + "    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {" + NL + "        protected java.util.Map<String, String> initialValue() {" + NL + "            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();" + NL + "            threadRunResultMap.put(\"errorCode\", null);" + NL + "            threadRunResultMap.put(\"status\", \"\");" + NL + "            return threadRunResultMap;" + NL + "        };" + NL + "    };" + NL;
  protected final String TEXT_3 = NL + "    // ESB Service Activity Monitor Feature" + NL + "    private org.apache.cxf.feature.Feature eventFeature;" + NL + "" + NL + "    public void setEventFeature(org.apache.cxf.feature.Feature eventFeature) {" + NL + "        this.eventFeature = eventFeature;" + NL + "    }";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "    private SyncInt runningThreadCount =new SyncInt();" + NL + "" + NL + "    private class SyncInt" + NL + "    {" + NL + "        private int count = 0;" + NL + "        public synchronized void add(int i)" + NL + "        {" + NL + "            count +=i;" + NL + "        }" + NL + "" + NL + "        public synchronized int getCount()" + NL + "        {" + NL + "            return count;" + NL + "        }" + NL + "    }";
  protected final String TEXT_6 = NL + NL + "    private java.util.Properties context_param = new java.util.Properties();" + NL + "    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();" + NL + "" + NL + "    public String status= \"\";" + NL + "" + NL + "    public static void main(String[] args){" + NL + "        final ";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = "Class = new ";
  protected final String TEXT_9 = "();" + NL + "" + NL + "        int exitCode = ";
  protected final String TEXT_10 = "Class.runJobInTOS(args);";
  protected final String TEXT_11 = NL + "\t        if(exitCode==0){" + NL + "\t\t        log.info(\"TalendJob: '";
  protected final String TEXT_12 = "' - Done.\");" + NL + "\t        }";
  protected final String TEXT_13 = NL + NL + "        System.exit(exitCode);" + NL + "    }" + NL + "" + NL + "" + NL + "    public String[][] runJob(String[] args) {" + NL + "" + NL + "        int exitCode = runJobInTOS(args);";
  protected final String TEXT_14 = NL + "        String[][] bufferValue = (String[][])globalBuffer.toArray(new String[globalBuffer.size()][]);";
  protected final String TEXT_15 = NL + "        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };";
  protected final String TEXT_16 = NL + NL + "        return bufferValue;" + NL + "    }" + NL + "" + NL + "" + NL + "    public int runJobInTOS(String[] args) {" + NL + "\t   \t// reset status" + NL + "\t   \tstatus = \"\";" + NL + "" + NL + "        String lastStr = \"\";" + NL + "        for (String arg : args) {" + NL + "            if (arg.equalsIgnoreCase(\"--context_param\")) {" + NL + "                lastStr = arg;" + NL + "            } else if (lastStr.equals(\"\")) {" + NL + "                evalParam(arg);" + NL + "            } else {" + NL + "                evalParam(lastStr + \" \" + arg);" + NL + "                lastStr = \"\";" + NL + "            }" + NL + "        }" + NL;
  protected final String TEXT_17 = NL + "\t        if(log4jLevel!=null){" + NL + "\t\t\t\tif(\"trace\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.TRACE);" + NL + "\t\t\t\t}else if(\"debug\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.DEBUG);" + NL + "\t\t\t\t}else if(\"info\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.INFO);" + NL + "\t\t\t\t}else if(\"warn\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.WARN);" + NL + "\t\t\t\t}else if(\"error\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.ERROR);" + NL + "\t\t\t\t}else if(\"fatal\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.FATAL);" + NL + "\t\t\t\t}else if (\"off\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.OFF);" + NL + "\t\t\t\t}" + NL + "\t\t\t\torg.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());" + NL + "    \t    }" + NL + "        \tlog.info(\"TalendJob: '";
  protected final String TEXT_18 = "' - Start.\");" + NL + "    \t";
  protected final String TEXT_19 = NL + NL + "        if(clientHost == null) {" + NL + "            clientHost = defaultClientHost;" + NL + "        }" + NL + "" + NL + "        if(pid == null || \"0\".equals(pid)) {" + NL + "            pid = TalendString.getAsciiRandomString(6);" + NL + "        }" + NL + "" + NL + "        if (rootPid==null) {" + NL + "            rootPid = pid;" + NL + "        }" + NL + "        if (fatherPid==null) {" + NL + "            fatherPid = pid;" + NL + "        }else{" + NL + "            isChildJob = true;" + NL + "        }" + NL;
  protected final String TEXT_20 = NL + "        if (portStats != null) {" + NL + "            // portStats = -1; //for testing" + NL + "            if (portStats < 0 || portStats > 65535) {" + NL + "                // issue:10869, the portStats is invalid, so this client socket can't open" + NL + "                System.err.println(\"The statistics socket port \" + portStats + \" is invalid.\");" + NL + "                execStat = false;" + NL + "            }" + NL + "        } else {" + NL + "            execStat = false;" + NL + "        }";
  protected final String TEXT_21 = NL + NL + "        try {" + NL + "            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "            java.io.InputStream inContext = ";
  protected final String TEXT_22 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_23 = "/";
  protected final String TEXT_24 = "/contexts/\"+contextStr+\".properties\");" + NL + "            if(isDefaultContext && inContext ==null) {" + NL + "" + NL + "            } else {" + NL + "                if (inContext!=null) {" + NL + "                    //defaultProps is in order to keep the original context value" + NL + "                    defaultProps.load(inContext);" + NL + "                    inContext.close();" + NL + "                    context = new ContextProperties(defaultProps);" + NL + "                }else{" + NL + "                    //print info and job continue to run, for case: context_param is not empty." + NL + "                    System.err.println(\"Could not find the context \" + contextStr);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            if(!context_param.isEmpty()) {" + NL + "                context.putAll(context_param);" + NL + "            }";
  protected final String TEXT_25 = NL + "            try{" + NL + "                String context_";
  protected final String TEXT_26 = "_value = context.getProperty(\"";
  protected final String TEXT_27 = "\");" + NL + "                if (context_";
  protected final String TEXT_28 = "_value == null){" + NL + "                    context_";
  protected final String TEXT_29 = "_value = \"\";" + NL + "                }" + NL + "                int context_";
  protected final String TEXT_30 = "_pos = context_";
  protected final String TEXT_31 = "_value.indexOf(\";\");" + NL + "                String context_";
  protected final String TEXT_32 = "_pattern =  \"yyyy-MM-dd HH:mm:ss\";" + NL + "                if(context_";
  protected final String TEXT_33 = "_pos > -1){" + NL + "                    context_";
  protected final String TEXT_34 = "_pattern = context_";
  protected final String TEXT_35 = "_value.substring(0, context_";
  protected final String TEXT_36 = "_pos);" + NL + "                    context_";
  protected final String TEXT_37 = "_value = context_";
  protected final String TEXT_38 = "_value.substring(context_";
  protected final String TEXT_39 = "_pos + 1);" + NL + "                }" + NL + "" + NL + "                context.";
  protected final String TEXT_40 = "=(java.util.Date)(new java.text.SimpleDateFormat(context_";
  protected final String TEXT_41 = "_pattern).parse(context_";
  protected final String TEXT_42 = "_value));" + NL + "" + NL + "            }catch(ParseException e)" + NL + "            {" + NL + "                context.";
  protected final String TEXT_43 = "=null;" + NL + "            }";
  protected final String TEXT_44 = NL + "                context.";
  protected final String TEXT_45 = "=(";
  protected final String TEXT_46 = ") context.getProperty(\"";
  protected final String TEXT_47 = "\");";
  protected final String TEXT_48 = NL + "             context.";
  protected final String TEXT_49 = "= new java.text.StringCharacterIterator(context.getProperty(\"";
  protected final String TEXT_50 = "\")).first();";
  protected final String TEXT_51 = NL + "             try{" + NL + "                 context.";
  protected final String TEXT_52 = "=routines.system.ParserUtils.parseTo_";
  protected final String TEXT_53 = " (context.getProperty(\"";
  protected final String TEXT_54 = "\"));" + NL + "             }catch(NumberFormatException e){" + NL + "                 context.";
  protected final String TEXT_55 = "=null;" + NL + "              }";
  protected final String TEXT_56 = NL + "        } catch (java.io.IOException ie) {" + NL + "            System.err.println(\"Could not load context \"+contextStr);" + NL + "            ie.printStackTrace();" + NL + "        }" + NL + "" + NL + "" + NL + "        // get context value from parent directly" + NL + "        if (parentContextMap != null && !parentContextMap.isEmpty()) {";
  protected final String TEXT_57 = "if (parentContextMap.containsKey(\"";
  protected final String TEXT_58 = "\")) {" + NL + "                context.";
  protected final String TEXT_59 = " = (";
  protected final String TEXT_60 = ") parentContextMap.get(\"";
  protected final String TEXT_61 = "\");" + NL + "            }";
  protected final String TEXT_62 = NL + "        }" + NL + "" + NL + "        //Resume: init the resumeUtil" + NL + "        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);" + NL + "        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);" + NL + "        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);" + NL + "" + NL + "        //Resume: jobStart" + NL + "        resumeUtil.addLog(\"JOB_STARTED\", \"JOB:\" + jobName, parent_part_launcher, Thread.currentThread().getId() + \"\", \"\",\"\",\"\",\"\",resumeUtil.convertToJsonText(context));" + NL;
  protected final String TEXT_63 = NL + "if(execStat) {" + NL + "    try {" + NL + "        runStat.openSocket(!isChildJob);" + NL + "        runStat.setAllPID(rootPid, fatherPid, pid, jobName);" + NL + "        runStat.startThreadStat(clientHost, portStats);" + NL + "        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);" + NL + "    } catch (java.io.IOException ioException) {" + NL + "        ioException.printStackTrace();" + NL + "    }" + NL + "}";
  protected final String TEXT_64 = NL;
  protected final String TEXT_65 = NL + "    try {" + NL + "        runTrace.openSocket(!isChildJob);" + NL + "        runTrace.startThreadTrace(clientHost, portTraces);" + NL + "    } catch (java.io.IOException ioException) {" + NL + "        ioException.printStackTrace();" + NL + "    }";
  protected final String TEXT_66 = NL;
  protected final String TEXT_67 = NL;
  protected final String TEXT_68 = NL + NL + "    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();" + NL + "    globalMap.put(\"concurrentHashMap\", concurrentHashMap);" + NL + "" + NL + "    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();" + NL + "    long endUsedMemory = 0;" + NL + "    long end = 0;" + NL + "" + NL + "    startTime = System.currentTimeMillis();";
  protected final String TEXT_69 = NL + "        ";
  protected final String TEXT_70 = ".addMessage(\"begin\");";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = NL;
  protected final String TEXT_73 = NL + NL + "this.globalResumeTicket = true;//to run tPreJob" + NL;
  protected final String TEXT_74 = NL;
  protected final String TEXT_75 = NL + NL;
  protected final String TEXT_76 = NL + "        try {";
  protected final String TEXT_77 = NL + "            ";
  protected final String TEXT_78 = "Process(globalMap);" + NL + "        } catch (java.lang.Exception e) {" + NL + "            e.printStackTrace();" + NL + "        }";
  protected final String TEXT_79 = NL + NL + "this.globalResumeTicket = false;//to run others jobs" + NL;
  protected final String TEXT_80 = NL + "        runningThreadCount.add(1);" + NL + "        new Thread(){" + NL + "            public void run() {" + NL + "                java.util.Map threadRunResultMap = new java.util.HashMap();" + NL + "                threadRunResultMap.put(\"errorCode\", null);" + NL + "                threadRunResultMap.put(\"status\", \"\");" + NL + "                threadLocal.set(threadRunResultMap);" + NL;
  protected final String TEXT_81 = NL + "                ";
  protected final String TEXT_82 = NL + "                finally {" + NL + "                    Integer localErrorCode = (Integer)(((java.util.Map)threadLocal.get()).get(\"errorCode\"));" + NL + "                    String localStatus = (String)(((java.util.Map)threadLocal.get()).get(\"status\"));" + NL + "                    if (localErrorCode != null) {" + NL + "                        if (errorCode == null || localErrorCode.compareTo(errorCode) > 0) {" + NL + "                           errorCode = localErrorCode;" + NL + "                        }" + NL + "                    }" + NL + "                    if (!status.equals(\"failure\")){" + NL + "                        status = localStatus;" + NL + "                    }" + NL + "" + NL + "                    runningThreadCount.add(-1);" + NL + "                }" + NL + "            }" + NL + "        }.start();" + NL;
  protected final String TEXT_83 = NL + "    while (runningThreadCount.getCount() > 0) {" + NL + "        try {" + NL + "            Thread.sleep(10);" + NL + "        } catch (java.lang.Exception e) {" + NL + "            e.printStackTrace();" + NL + "        }" + NL + "    }";
  protected final String TEXT_84 = NL;
  protected final String TEXT_85 = NL + NL + "this.globalResumeTicket = true;//to run tPostJob" + NL;
  protected final String TEXT_86 = NL;
  protected final String TEXT_87 = NL;
  protected final String TEXT_88 = NL;
  protected final String TEXT_89 = NL + NL + "        end = System.currentTimeMillis();" + NL + "" + NL + "        if (watch) {" + NL + "            System.out.println((end-startTime)+\" milliseconds\");" + NL + "        }" + NL + "" + NL + "        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();" + NL + "        if (false) {" + NL + "            System.out.println((endUsedMemory - startUsedMemory) + \" bytes memory increase when running : ";
  protected final String TEXT_90 = "\");" + NL + "        }";
  protected final String TEXT_91 = NL + "        ";
  protected final String TEXT_92 = ".addMessage(status==\"\"?\"end\":status, (end-startTime));" + NL + "        try {";
  protected final String TEXT_93 = NL + "            ";
  protected final String TEXT_94 = "Process(globalMap);" + NL + "        } catch (java.lang.Exception e) {" + NL + "            e.printStackTrace();" + NL + "        }";
  protected final String TEXT_95 = NL;
  protected final String TEXT_96 = NL + "    closeJmsConnections();";
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = NL + "    closeScpConnections();";
  protected final String TEXT_99 = NL;
  protected final String TEXT_100 = NL + "    if (false";
  protected final String TEXT_101 = " || null == eventFeature";
  protected final String TEXT_102 = " || null == registry";
  protected final String TEXT_103 = ") { // TESB-8574: Fix SAM timeout issue in Studio" + NL + "        try {" + NL + "            Thread.sleep(5000);" + NL + "        } catch (InterruptedException e) {" + NL + "        }" + NL + "    }";
  protected final String TEXT_104 = NL + NL;
  protected final String TEXT_105 = NL + "if (execStat) {" + NL + "    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);" + NL + "    runStat.stopThreadStat();" + NL + "}";
  protected final String TEXT_106 = NL + "        runTrace.stopThreadTrace();";
  protected final String TEXT_107 = NL + "    int returnCode = 0;" + NL + "    if(errorCode == null) {" + NL + "         returnCode = status != null && status.equals(\"failure\") ? 1 : 0;" + NL + "    } else {" + NL + "         returnCode = errorCode.intValue();" + NL + "    }" + NL + "    resumeUtil.addLog(\"JOB_ENDED\", \"JOB:\" + jobName, parent_part_launcher, Thread.currentThread().getId() + \"\", \"\",\"\" + returnCode,\"\",\"\",\"\");" + NL + "" + NL + "    return returnCode;" + NL + "" + NL + "  }" + NL + "" + NL + "    public void destroy() {";
  protected final String TEXT_108 = NL + "    closeJmsConnections();";
  protected final String TEXT_109 = NL;
  protected final String TEXT_110 = NL + "    closeScpConnections();";
  protected final String TEXT_111 = NL + "    }" + NL;
  protected final String TEXT_112 = NL + "    private void closeJmsConnections() {" + NL + "        try {" + NL + "            Object obj_conn;";
  protected final String TEXT_113 = NL + "            obj_conn = globalMap.remove(\"connection_";
  protected final String TEXT_114 = "\");" + NL + "            if (null != obj_conn) {" + NL + "                ((javax.jms.Connection) obj_conn).close();" + NL + "            }";
  protected final String TEXT_115 = NL + "        } catch (java.lang.Exception e) {" + NL + "        }" + NL + "    }";
  protected final String TEXT_116 = NL;
  protected final String TEXT_117 = NL + "    private void closeScpConnections() {" + NL + "        try {" + NL + "            Object obj_conn;";
  protected final String TEXT_118 = NL + "            obj_conn = globalMap.remove(\"conn_";
  protected final String TEXT_119 = "\");" + NL + "            if (null != obj_conn) {" + NL + "                ((ch.ethz.ssh2.Connection) obj_conn).close();" + NL + "            }";
  protected final String TEXT_120 = NL + "        } catch (java.lang.Exception e) {" + NL + "        }" + NL + "    }";
  protected final String TEXT_121 = NL + NL + "    private java.util.Map<String, Object> getSharedConnections4REST() {" + NL + "        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();";
  protected final String TEXT_122 = NL + "            connections.put(\"connection_";
  protected final String TEXT_123 = "\", globalMap.get(\"connection_";
  protected final String TEXT_124 = "\"));" + NL + "            connections.put(\"session_";
  protected final String TEXT_125 = "\", globalMap.get(\"session_";
  protected final String TEXT_126 = "\"));";
  protected final String TEXT_127 = NL + "            connections.put(\"conn_";
  protected final String TEXT_128 = "\", globalMap.get(\"conn_";
  protected final String TEXT_129 = "\"));";
  protected final String TEXT_130 = NL + "        return connections;" + NL + "    }" + NL + "" + NL + "    private void evalParam(String arg) {" + NL + "        if (arg.startsWith(\"--resuming_logs_dir_path\")) {" + NL + "            resuming_logs_dir_path = arg.substring(25);" + NL + "        } else if (arg.startsWith(\"--resuming_checkpoint_path\")) {" + NL + "            resuming_checkpoint_path = arg.substring(27);" + NL + "        } else if (arg.startsWith(\"--parent_part_launcher\")) {" + NL + "            parent_part_launcher = arg.substring(23);" + NL + "        } else if (arg.startsWith(\"--watch\")) {" + NL + "            watch = true;" + NL + "        } else if (arg.startsWith(\"--stat_port=\")) {" + NL + "            String portStatsStr = arg.substring(12);" + NL + "            if (portStatsStr != null && !portStatsStr.equals(\"null\")) {" + NL + "                portStats = Integer.parseInt(portStatsStr);" + NL + "            }" + NL + "        } else if (arg.startsWith(\"--trace_port=\")) {" + NL + "            portTraces = Integer.parseInt(arg.substring(13));" + NL + "        } else if (arg.startsWith(\"--client_host=\")) {" + NL + "            clientHost = arg.substring(14);" + NL + "        } else if (arg.startsWith(\"--context=\")) {" + NL + "            contextStr = arg.substring(10);" + NL + "            isDefaultContext = false;" + NL + "        } else if (arg.startsWith(\"--father_pid=\")) {" + NL + "            fatherPid = arg.substring(13);" + NL + "        } else if (arg.startsWith(\"--root_pid=\")) {" + NL + "            rootPid = arg.substring(11);" + NL + "        } else if (arg.startsWith(\"--father_node=\")) {" + NL + "            fatherNode = arg.substring(14);" + NL + "        } else if (arg.startsWith(\"--pid=\")) {" + NL + "            pid = arg.substring(6);" + NL + "        } else if (arg.startsWith(\"--context_param\")) {" + NL + "            String keyValue = arg.substring(16);" + NL + "            int index = -1;" + NL + "            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {" + NL + "                if (fatherPid==null) {" + NL + "                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));" + NL + "                } else { // the subjob won't escape the especial chars" + NL + "                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );" + NL + "                }" + NL + "            }" + NL + "        }else if (arg.startsWith(\"--log4jLevel=\")) {" + NL + "            log4jLevel = arg.substring(13);" + NL + "\t\t}" + NL + "" + NL + "    }" + NL + "" + NL + "    private final String[][] escapeChars = {" + NL + "        {\"\\\\n\",\"\\n\"},{\"\\\\'\",\"\\'\"},{\"\\\\r\",\"\\r\"}," + NL + "        {\"\\\\f\",\"\\f\"},{\"\\\\b\",\"\\b\"},{\"\\\\t\",\"\\t\"}," + NL + "        {\"\\\\\\\\\",\"\\\\\"}" + NL + "        };" + NL + "    private String replaceEscapeChars (String keyValue) {" + NL + "        if(keyValue==null || (\"\").equals(keyValue.trim())) {" + NL + "            return keyValue;" + NL + "        }" + NL + "        for(String[] strArray: escapeChars) {" + NL + "            keyValue = keyValue.replace(strArray[0], strArray[1]);" + NL + "        }" + NL + "        return keyValue;" + NL + "    }" + NL + "" + NL + "    public Integer getErrorCode() {" + NL + "        return errorCode;" + NL + "    }" + NL + "" + NL + "" + NL + "    public String getStatus() {" + NL + "        return status;" + NL + "    }" + NL + "" + NL + "    ResumeUtil resumeUtil = null;" + NL + "}";

    private static String end_multiThread = "if ( !\"failure\".equals(((java.util.Map)threadLocal.get()).get(\"status\")) ) {\n((java.util.Map) threadLocal.get()).put(\"status\", \"end\");\n}";
    private static String end_singleThread = "if(!\"failure\".equals(status)) { status = \"end\"; }";
    private static String failure_multiThread = "((java.util.Map) threadLocal.get()).put(\"status\", \"failure\");";
    private static String failure_singleThread = "status = \"failure\";";
    private static String errorCode_multiThread = "((java.util.Map) threadLocal.get()).put(\"errorCode\", null);";
    private static String errorCode_singleThread = "errorCode = null;";
    
    // add the list of the connection names to avoid to declare two times the same name.
    public String createCallProcess(INode rootNode, String className, boolean isMultiThread) {
        String toReturn = "";
        toReturn =  "try {\n";
        if(isMultiThread) {
            toReturn +=  errorCode_multiThread;
        }else{
            toReturn +=  errorCode_singleThread;
        }        
        
        toReturn += rootNode.getUniqueName() + "Process(globalMap);\n";
        
        if(isMultiThread) {
            toReturn +=  end_multiThread;
        }else{
            toReturn +=  end_singleThread;
        }
        
        toReturn += "\n}catch (TalendException e_" + rootNode.getUniqueName() + ") {\n";
        
//        if(isMultiThread) {
//            toReturn +=  failure_multiThread;
//        }else{
//            toReturn +=  failure_singleThread;
//        }
        
        toReturn += "\ne_" + rootNode.getUniqueName() + ".printStackTrace();\n";
        
        toReturn += "globalMap.put(\""+rootNode.getUniqueName()+ "_SUBPROCESS_STATE\", -1);\n";
      
       //List< ? extends IConnection> onSubJobErrorConns = rootNode.getOutgoingConnections(EConnectionType.ON_SUBJOB_ERROR);
       //if(onSubJobErrorConns!=null){
       //    for(IConnection conn : onSubJobErrorConns) {               
       //        toReturn += createCallProcess(conn.getTarget(),  className, isMultiThread);
       //    }
       //}            
        if(isMultiThread){
            toReturn += "\n}catch (Error e_" + rootNode.getUniqueName() + ") {\n";
            toReturn += "\ne_" + rootNode.getUniqueName() + ".printStackTrace();\n";
            toReturn += "globalMap.put(\""+rootNode.getUniqueName()+ "_SUBPROCESS_STATE\", -1);\n";
        }
       toReturn += "\n}"; 
       return toReturn;
    }
		 
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);
    List<INode> rootNodes = (List<INode>)v.get(1);

    boolean stats = codeGenArgument.isStatistics();
    boolean trace = codeGenArgument.isTrace();
    boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
    List<IContextParameter> params = new ArrayList<IContextParameter>();
    params=process.getContextManager().getDefaultContext().getContextParameterList();
    String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));

    boolean exist_tParallelize = false;
    List<? extends INode> tParallelizeList = process.getNodesOfType("tParallelize");
    if(tParallelizeList != null && tParallelizeList.size() > 0){
        exist_tParallelize = true;
    }

    boolean exist_tMOM = false;
    List<INode> momComponentsList = (List<INode>)process.getNodesOfType("tMomConnection");
    momComponentsList.addAll((List<INode>)process.getNodesOfType("tMomInput"));
    momComponentsList.addAll((List<INode>)process.getNodesOfType("tMomOutput"));
    if (momComponentsList.size() > 0) {
        exist_tMOM = true;
    }

    boolean exist_tSCP = false;
    List<INode> scpComponentsList = (List<INode>)process.getNodesOfType("tSCPConnection");
    if (scpComponentsList.size() > 0) {
        exist_tSCP = true;
    }

    boolean hasSAM4RS = false;
    for (INode node : process.getNodesOfType("tRESTClient")) {
        if (Boolean.valueOf(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
            hasSAM4RS = true;
            break;
        }
    }
    boolean hasSAM4WS = false;
    for (INode node : process.getNodesOfType("tESBConsumer")) {
        if (Boolean.valueOf(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
            hasSAM4WS = true;
            break;
        }
    }


    stringBuffer.append(TEXT_1);
    stringBuffer.append(codeGenArgument.getContextName() );
    stringBuffer.append(TEXT_2);
     if (hasSAM4RS) { 
    stringBuffer.append(TEXT_3);
     } 
    stringBuffer.append(TEXT_4);
    
    if(isRunInMultiThread || exist_tParallelize){

    stringBuffer.append(TEXT_5);
    
    }

    stringBuffer.append(TEXT_6);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_10);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    
        List<INode> tBufferNodes = (List<INode>)process.getNodesOfType("tBufferOutput");
        if(tBufferNodes != null && tBufferNodes.size() > 0) {
    
    stringBuffer.append(TEXT_14);
    
        } else {
    
    stringBuffer.append(TEXT_15);
    
        }
    
    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    
        if (stats) {

    stringBuffer.append(TEXT_20);
    
        }

    stringBuffer.append(TEXT_21);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(jobFolderName );
    stringBuffer.append(TEXT_24);
     for (IContextParameter ctxParam :params)
            {
                String typeToGenerate ="String";
                if( !(ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory") ||ctxParam.getType().equals("id_List Of Value")))
                {
                   typeToGenerate=JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
                }
                if(typeToGenerate.equals("java.util.Date"))
                {

            
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_43);
    
                }else if(typeToGenerate.equals("Object")||typeToGenerate.equals("String")||typeToGenerate.equals("java.lang.String") )
                {
                
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_47);
    
                }else if(typeToGenerate.equals("Character")&&ctxParam.getName()!=null)
                {
             
    stringBuffer.append(TEXT_48);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_50);
    
                } else {
             
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_55);
    
                }
            }
            
    stringBuffer.append(TEXT_56);
     for (IContextParameter ctxParam :params){
            //about the type, they are same as header.javajet
            String typeToGenerate = "String";
            if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
                typeToGenerate = "String";
            }else{
                typeToGenerate = JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
            }
        
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    
        if (stats) {

    stringBuffer.append(TEXT_63);
    
    }

    stringBuffer.append(TEXT_64);
    
    if (trace) {

    stringBuffer.append(TEXT_65);
    
    }

    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append( ElementParameterParser.getValue(process, "__HEADER_CODE__"));
    stringBuffer.append(TEXT_68);
    
        //1. send the begin msg

        for (INode statCatcherNode : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_70);
    
        }

        List<INode> prejobNodes = new ArrayList<INode>();

        List<INode> postjobNodes = new ArrayList<INode>();

        INode implicit_Context = null;

        for (INode rootNode : rootNodes) {
            String componentName = rootNode.getComponent().getName();
            String uniqueName = rootNode.getUniqueName();

            if (componentName.equals("tPrejob")) {
                prejobNodes.add(rootNode);
                continue;
            }

            if (componentName.equals("tPostjob")) {
                postjobNodes.add(rootNode);
                continue;
            }

            if (uniqueName.startsWith("Implicit_Context_")) {
                implicit_Context = rootNode;
                continue;
            }
        }

    stringBuffer.append(TEXT_71);
    
//2. load implicit contextload
 if(implicit_Context != null) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(createCallProcess(implicit_Context, process.getName(), false) );
    
 }

    stringBuffer.append(TEXT_73);
    
//3. run pre-job
 if(!prejobNodes.isEmpty()) {
    for(INode preNode:prejobNodes) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(createCallProcess(preNode, process.getName(), false) );
    
    }
 }

    stringBuffer.append(TEXT_75);
    
        //4. flush the begin msg
        for (INode statCatcherNode : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(statCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_78);
    
        }

    stringBuffer.append(TEXT_79);
    

    //5. all others sub-job (MultiThread mode)
    if(isRunInMultiThread){
        for (INode rootNode : rootNodes) {
            String componentName = rootNode.getComponent().getName();
            String uniqueName = rootNode.getUniqueName();

            //filter the special subjob
            if("tPrejob".equals(componentName)) continue;
            if("tPostjob".equals(componentName)) continue;

            //bug16808 when use parallel option at Output components, that will multi thread
            if(componentName.startsWith("tAsyncIn")) continue;
            //end bug16808

            if(implicit_Context!=null && implicit_Context.getUniqueName().equals(uniqueName)) continue;

            if (!componentName.equals("tLogCatcher") && !componentName.equals("tFlowMeterCatcher") && !componentName.equals("tAssertCatcher") && !componentName.equals("tStatCatcher")) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(createCallProcess(rootNode, process.getName(), true) );
    stringBuffer.append(TEXT_82);
    
            }
        }

    stringBuffer.append(TEXT_83);
    
    } else { // isRunInMultiThread  //5. all others sub-job (SingleThread  mode)
        for (INode rootNode : rootNodes) {
            String componentName = rootNode.getComponent().getName();
            String uniqueName = rootNode.getUniqueName();

            //filter the special subjob
            if("tPrejob".equals(componentName)) continue;
            if("tPostjob".equals(componentName)) continue;
            if(implicit_Context!=null && implicit_Context.getUniqueName().equals(uniqueName)) continue;

            if (!componentName.equals("tLogCatcher") && !componentName.equals("tFlowMeterCatcher") && !componentName.equals("tAssertCatcher") && !componentName.equals("tStatCatcher") && !componentName.equals("tAsyncIn")) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(createCallProcess(rootNode, process.getName(), false) );
        }
    }
}// end if(isRunInMultiThread)

    stringBuffer.append(TEXT_85);
    
//6. run the post-job
 if(!postjobNodes.isEmpty()){
    for(INode postNode:postjobNodes){

    stringBuffer.append(TEXT_86);
    stringBuffer.append(createCallProcess(postNode, process.getName(), false) );
    
    }
 }

    stringBuffer.append(TEXT_87);
    stringBuffer.append(TEXT_88);
    stringBuffer.append( ElementParameterParser.getValue(process, "__FOOTER_CODE__"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_90);
    
    //7. send & flush the end msg to statcatcher
    for (INode statCatcherNode : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(statCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_94);
    
    }

    stringBuffer.append(TEXT_95);
     if (exist_tMOM) { 
    stringBuffer.append(TEXT_96);
     } 
    stringBuffer.append(TEXT_97);
     if (exist_tSCP) { 
    stringBuffer.append(TEXT_98);
     } 
    stringBuffer.append(TEXT_99);
    
    if (hasSAM4RS || hasSAM4WS) {

    stringBuffer.append(TEXT_100);
     if (hasSAM4RS) { 
    stringBuffer.append(TEXT_101);
     } 
     if (hasSAM4WS) { 
    stringBuffer.append(TEXT_102);
     } 
    stringBuffer.append(TEXT_103);
    
    }

    stringBuffer.append(TEXT_104);
    
    if (stats) {

    stringBuffer.append(TEXT_105);
    
    }

    if (trace) {

    stringBuffer.append(TEXT_106);
    
    }

    stringBuffer.append(TEXT_107);
     if(exist_tMOM) { 
    stringBuffer.append(TEXT_108);
     } 
    stringBuffer.append(TEXT_109);
     if(exist_tSCP) { 
    stringBuffer.append(TEXT_110);
     } 
    stringBuffer.append(TEXT_111);
    
    if(exist_tMOM) {

    stringBuffer.append(TEXT_112);
    
            for (INode momNode : momComponentsList) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_114);
    
            }

    stringBuffer.append(TEXT_115);
    
    }

    stringBuffer.append(TEXT_116);
    
    if(exist_tSCP) {

    stringBuffer.append(TEXT_117);
    
            for (INode scpNode : scpComponentsList) {

    stringBuffer.append(TEXT_118);
    stringBuffer.append(scpNode.getUniqueName() );
    stringBuffer.append(TEXT_119);
    
            }

    stringBuffer.append(TEXT_120);
    
    }

    stringBuffer.append(TEXT_121);
    
        for (INode momNode : momComponentsList) {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_126);
    
        }

    
        for (INode scpNode : scpComponentsList) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(scpNode.getUniqueName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(scpNode.getUniqueName() );
    stringBuffer.append(TEXT_129);
    
        }

    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}
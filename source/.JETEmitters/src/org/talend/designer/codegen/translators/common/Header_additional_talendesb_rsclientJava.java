package org.talend.designer.codegen.translators.common;

import java.util.Vector;
import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Header_additional_talendesb_rsclientJava
{
  protected static String nl;
  public static synchronized Header_additional_talendesb_rsclientJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Header_additional_talendesb_rsclientJava result = new Header_additional_talendesb_rsclientJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "private java.util.Map<String, String> stsProps;" + NL + "" + NL + "public void setStsProps(java.util.Map<String, String> stsProps) {" + NL + "    this.stsProps = stsProps;" + NL + "}" + NL + "" + NL + "public static class STSRESTOutInterceptor" + NL + "        extends org.apache.cxf.phase.AbstractPhaseInterceptor<org.apache.cxf.message.Message> {" + NL + "" + NL + "    private org.apache.cxf.ws.security.trust.STSClient stsClient;" + NL + "    private org.apache.cxf.ws.security.tokenstore.SecurityToken securityToken;" + NL + "" + NL + "    public STSRESTOutInterceptor() {" + NL + "        super(org.apache.cxf.phase.Phase.WRITE);" + NL + "        addBefore(org.apache.cxf.rs.security.saml.SamlFormOutInterceptor.class.getName());" + NL + "        addBefore(org.apache.cxf.rs.security.saml.SamlHeaderOutInterceptor.class.getName());" + NL + "    }" + NL + "" + NL + "    public void handleMessage(org.apache.cxf.message.Message message)" + NL + "            throws org.apache.cxf.interceptor.Fault {" + NL + "        if (!isRequestor(message)) {" + NL + "            return;" + NL + "        }" + NL + "" + NL + "        if (null != securityToken && !securityToken.isExpired() && null != securityToken.getToken()) {" + NL + "            message.setContextualProperty(" + NL + "                    org.apache.cxf.rs.security.saml.SAMLConstants.SAML_TOKEN_ELEMENT," + NL + "                    securityToken.getToken());" + NL + "            return;" + NL + "        }" + NL + "" + NL + "        if (stsClient == null) {" + NL + "            return;" + NL + "        }" + NL + "" + NL + "        try {" + NL + "            // Transpose ActAs/OnBehalfOf info from original request to the STS client." + NL + "            Object token = message.getContextualProperty(org.apache.cxf.ws.security.SecurityConstants.STS_TOKEN_ACT_AS);" + NL + "            if (null != token) {" + NL + "                stsClient.setActAs(token);" + NL + "            }" + NL + "            token = message.getContextualProperty(org.apache.cxf.ws.security.SecurityConstants.STS_TOKEN_ON_BEHALF_OF);" + NL + "            if (null != token) {" + NL + "                stsClient.setOnBehalfOf(token);" + NL + "            }" + NL + "" + NL + "            Object o = message.getContextualProperty(org.apache.cxf.ws.security.SecurityConstants.STS_APPLIES_TO);" + NL + "            String appliesTo = o == null ? null : o.toString();" + NL + "            appliesTo = appliesTo == null ? message.getContextualProperty(" + NL + "                    org.apache.cxf.message.Message.ENDPOINT_ADDRESS).toString() : appliesTo;" + NL + "" + NL + "            stsClient.setMessage(message);" + NL + "" + NL + "            org.apache.cxf.ws.security.tokenstore.SecurityToken tok = null;" + NL + "            if (securityToken == null) {" + NL + "                tok = stsClient.requestSecurityToken(appliesTo);" + NL + "            } else {" + NL + "                tok = stsClient.renewSecurityToken(securityToken);" + NL + "            }" + NL + "            securityToken = tok;" + NL + "" + NL + "            if (null != securityToken && !securityToken.isExpired() && null != securityToken.getToken()) {" + NL + "                message.setContextualProperty(" + NL + "                        org.apache.cxf.rs.security.saml.SAMLConstants.SAML_TOKEN_ELEMENT," + NL + "                        securityToken.getToken());" + NL + "                return;" + NL + "            }" + NL + "        } catch (RuntimeException ex) {" + NL + "            // ex.printStackTrace();" + NL + "            throw new org.apache.cxf.interceptor.Fault(ex);" + NL + "        } catch (Exception ex) {" + NL + "            java.io.StringWriter sw = new java.io.StringWriter();" + NL + "            ex.printStackTrace(new java.io.PrintWriter(sw));" + NL + "            throw new org.apache.cxf.interceptor.Fault(" + NL + "                    new RuntimeException(ex.getMessage() + \", stacktrace: \" + sw.toString()));" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public org.apache.cxf.ws.security.trust.STSClient getStsClient() {" + NL + "        return stsClient;" + NL + "    }" + NL + "" + NL + "    /**" + NL + "     * Set the STSClient object. This does the heavy lifting to get a (SAML) Token from the STS." + NL + "     * @param stsClient the STSClient object." + NL + "     */" + NL + "    public void setStsClient(org.apache.cxf.ws.security.trust.STSClient stsClient) {" + NL + "        this.stsClient = stsClient;" + NL + "    }" + NL + "}" + NL + "" + NL + "public static org.apache.cxf.ws.security.trust.STSClient createStsClient(" + NL + "        org.apache.cxf.Bus bus, java.util.Map<String, String> stsProps, String username, String password) {" + NL + "" + NL + "    final org.apache.cxf.ws.security.trust.STSClient stsClient =" + NL + "            new org.apache.cxf.ws.security.trust.STSClient(bus);" + NL + "" + NL + "    stsClient.setWsdlLocation(stsProps.get(\"sts.wsdl.location\"));" + NL + "    stsClient.setServiceQName(new javax.xml.namespace.QName(" + NL + "            stsProps.get(\"sts.namespace\"), stsProps.get(\"sts.service.name\")));" + NL + "    stsClient.setEndpointQName(new javax.xml.namespace.QName(" + NL + "            stsProps.get(\"sts.namespace\"), stsProps.get(\"sts.endpoint.name\")));" + NL + "" + NL + "    java.util.Map<String, Object> props = new java.util.HashMap<String, Object>();" + NL + "" + NL + "    for (java.util.Map.Entry<String, String> entry : stsProps.entrySet()) {" + NL + "        if (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES.contains(entry.getKey())) {" + NL + "            String value = entry.getValue();" + NL + "            value = value.startsWith(\"file:\") ? value.replaceAll(\"\\\\\\\\\", \"/\") : value;" + NL + "            props.put(entry.getKey(), value);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    props.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME, username);" + NL + "    props.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD, password);" + NL + "    stsClient.setProperties(props);" + NL + "" + NL + "    stsClient.setAllowRenewingAfterExpiry(true);" + NL + "    stsClient.setEnableLifetime(true);" + NL + "    stsClient.setTokenType(\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0\");" + NL + "    stsClient.setKeyType(\"http://docs.oasis-open.org/ws-sx/ws-trust/200512/Bearer\");" + NL + "" + NL + "    return stsClient;" + NL + "}";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
Vector v = (Vector) codeGenArgument.getArgument();
IProcess process = (IProcess) v.get(0);

boolean useSAML = false;

List<? extends INode> restClients = process.getNodesOfType("tRESTClient");
for (INode restClient : restClients) {
	boolean useAuth = Boolean.valueOf(ElementParameterParser.getValue(restClient, "__NEED_AUTH__"));
	String authType = ElementParameterParser.getValue(restClient, "__AUTH_TYPE__");
	if (useAuth && "SAML".equals(authType)) {
		useSAML = true;
		break;
	}
}

if (useSAML) { 
    stringBuffer.append(TEXT_1);
     } 
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}

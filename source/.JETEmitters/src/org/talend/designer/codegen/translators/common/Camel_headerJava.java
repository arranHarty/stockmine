package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Map;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.designer.codegen.ITalendSynchronizer;

public class Camel_headerJava
{
  protected static String nl;
  public static synchronized Camel_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Camel_headerJava result = new Camel_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tprivate String propertyToString(Object obj){" + NL + "\t\t\t\tif(obj!=null && obj instanceof java.util.Date){" + NL + "\t\t\t\t\treturn String.format(\"yyyy-MM-dd HH:mm:ss;%tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\",obj);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\treturn String.valueOf(obj);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL;
  protected final String TEXT_2 = NL + "\t\t\t\tprivate org.apache.camel.component.mail.MailEndpoint getMailEndpoint(" + NL + "\t\t\t\t\t\tString uri, String username, String password, String subject, " + NL + "\t\t\t\t\t\tString from, String to, String cc, String bcc) {" + NL + "\t\t\t\t\torg.apache.camel.component.mail.MailEndpoint endpoint = (org.apache.camel.component.mail.MailEndpoint) endpoint(uri);" + NL + "\t\t\t\t\torg.apache.camel.component.mail.MailConfiguration configuration = endpoint.getConfiguration();" + NL + "\t\t\t\t\tconfiguration.setUsername(username);" + NL + "\t\t\t\t\tconfiguration.setPassword(password);" + NL + "\t\t\t\t\tconfiguration.setSubject(subject);" + NL + "\t\t\t\t\tif(null != from && !\"\".equals(from)){" + NL + "\t\t\t\t\t\tconfiguration.setFrom(from);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(null != to && !\"\".equals(to)){" + NL + "\t\t\t\t\t\tconfiguration.setTo(to);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(null != cc && !\"\".equals(cc)){" + NL + "\t\t\t\t\t\tconfiguration.setCC(cc);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(null != bcc && !\"\".equals(bcc)){" + NL + "\t\t\t\t\t\tconfiguration.setBCC(bcc);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn endpoint;" + NL + "\t\t\t\t}";
  protected final String TEXT_3 = NL + "\t\t\tprivate org.apache.camel.component.file.remote.RemoteFileEndpoint<?> getFtpEndpoint(" + NL + "\t\t\t\t\tString uri, String server, String username, String password," + NL + "\t\t\t\t\tString directory) {" + NL + "\t\t\t\torg.apache.camel.component.file.remote.RemoteFileEndpoint<?> endpoint;" + NL + "\t\t\t\tendpoint = (org.apache.camel.component.file.remote.RemoteFileEndpoint<?>) endpoint(uri);" + NL + "\t\t\t\torg.apache.camel.component.file.remote.RemoteFileConfiguration configuration = endpoint" + NL + "\t\t\t\t\t\t.getConfiguration();" + NL + "\t\t\t\tconfiguration.setUsername(username);" + NL + "\t\t\t\tconfiguration.setPassword(password);" + NL + "\t\t\t\tconfiguration.setHost(server);" + NL + "\t\t\t\tconfiguration.setDirectory(directory);" + NL + "\t\t\t\treturn endpoint;" + NL + "\t\t\t}";
  protected final String TEXT_4 = NL + "\t\t\tclass CXFConsumerBinding extends org.apache.camel.component.cxf.DefaultCxfBinding {" + NL + "\t\t\t\tprivate org.apache.camel.component.cxf.CxfEndpoint endpoint;" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic CXFConsumerBinding(org.apache.camel.component.cxf.CxfEndpoint endpoint){" + NL + "\t\t\t\t\tthis.endpoint = endpoint;" + NL + "\t\t\t\t\tsetHeaderFilterStrategy(consumerSoapHeaderFilter);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tprotected void propagateHeadersFromCamelToCxf(org.apache.camel.Exchange camelExchange," + NL + "\t\t\t\t\t\tMap<String, Object> camelHeaders, org.apache.cxf.message.Exchange cxfExchange," + NL + "\t\t\t\t\t\tMap<String, Object> cxfContext) {" + NL + "\t\t\t\t\tsuper.propagateHeadersFromCamelToCxf(camelExchange, camelHeaders, cxfExchange, cxfContext);" + NL + "\t\t\t\t\tObject samlToken = camelHeaders.get(\"samlToken\");" + NL + "\t\t\t\t\tif(samlToken == null){" + NL + "\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tMap<String, Object> properties = endpoint.getProperties();" + NL + "\t\t\t\t\tif(properties == null){" + NL + "\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tObject object = properties.get(org.apache.cxf.ws.security.SecurityConstants.STS_CLIENT);" + NL + "\t\t\t\t\tif(object == null || !(object instanceof org.apache.cxf.ws.security.trust.STSClient)){" + NL + "\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\torg.apache.cxf.ws.security.trust.STSClient stsClient = (org.apache.cxf.ws.security.trust.STSClient) object;" + NL + "\t\t\t\t\tstsClient.setOnBehalfOf(samlToken);" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_5 = NL + "\t\t\t\tclass CXFProviderBinding extends org.apache.camel.component.cxf.DefaultCxfBinding{\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t@Override" + NL + "\t\t\t\t\tprotected void propagateHeadersFromCxfToCamel( org.apache.cxf.message.Message cxfMessage," + NL + "\t\t\t\t\t\t\torg.apache.camel.Message camelMessage, org.apache.camel.Exchange camelExchange) {" + NL + "\t\t\t\t\t\tsuper.propagateHeadersFromCxfToCamel(cxfMessage, camelMessage, camelExchange);" + NL + "\t\t\t\t\t\tcamelExchange.getIn().removeHeader(\"samlToken\");" + NL + "\t\t\t\t\t\torg.apache.cxf.security.SecurityContext securityContext = cxfMessage.get(org.apache.cxf.security.SecurityContext.class);" + NL + "\t\t\t\t\t\tif(securityContext != null && securityContext instanceof org.apache.cxf.interceptor.security.SAMLSecurityContext){" + NL + "\t\t\t\t\t\t\torg.apache.cxf.interceptor.security.SAMLSecurityContext ssc = (org.apache.cxf.interceptor.security.SAMLSecurityContext) securityContext;" + NL + "\t\t\t\t\t\t\torg.w3c.dom.Element assertionElement = ssc.getAssertionElement();" + NL + "\t\t\t\t\t\t\tif(assertionElement != null){" + NL + "\t\t\t\t\t\t\t\tcamelExchange.getIn().setHeader(\"samlToken\", assertionElement);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_6 = NL + "\t\t\t" + NL + "\t\t\tprivate org.apache.camel.component.cxf.CxfEndpoint getCxfEndpoint(String uri, boolean isProvider, boolean useAuthorization, boolean usePropagateSamlAP, String... token){" + NL + "\t\t\t\torg.apache.camel.component.cxf.CxfEndpoint cxfEndpoint = (org.apache.camel.component.cxf.CxfEndpoint)endpoint(uri);" + NL;
  protected final String TEXT_7 = NL + "\t\t\t\tif( null != bundleContext ){" + NL + "\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\torg.apache.cxf.Bus bus = cxfEndpoint.getBus();";
  protected final String TEXT_9 = "\t\t\t        " + NL + "\t\t\t\t        if(isProvider&&token!=null&&\"UsernameToken\".equals(token[0])){" + NL + "\t\t\t\t        \taddUsernameToken(cxfEndpoint,bus, true);" + NL + "\t\t\t\t        } ";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\tif(isProvider&&token!=null &&" + NL + "\t\t\t\t\t\t\t(org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC.equals(token[0])" + NL + "\t\t\t\t\t\t\t\t||org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST.equals(token[0]))){" + NL + "\t\t\t\t\t\t\taddHttpAuth(cxfEndpoint, isProvider, token);" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_11 = NL + "\t\t\t        if(token!=null&&\"SAMLToken\".equals(token[0])){" + NL + "\t\t\t        \taddSAMLToken(cxfEndpoint, bus, isProvider, useAuthorization, usePropagateSamlAP, token);" + NL + "\t\t\t        }";
  protected final String TEXT_12 = NL + "\t\t\t        if(token!=null&&\"Registry\".equals(token[0])){" + NL + "\t\t\t        \taddRegistry(cxfEndpoint, bus, isProvider, usePropagateSamlAP, token);" + NL + "\t\t\t        }";
  protected final String TEXT_13 = NL + "\t\t\t\t}";
  protected final String TEXT_14 = NL + "\t\t\t\tif(!isProvider&&token!=null&&token.length>=3&&\"UsernameToken\".equals(token[0])){" + NL + "\t\t        \taddUsernameToken(cxfEndpoint, null, false, token[1], token[2]);" + NL + "\t\t        }";
  protected final String TEXT_15 = NL + "\t\t\t\t\tif(!isProvider&&token!=null &&" + NL + "\t\t\t\t\t\t\t(org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC.equals(token[0])" + NL + "\t\t\t\t\t\t\t\t\t||org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST.equals(token[0]))){" + NL + "\t\t\t\t\t\taddHttpAuth(cxfEndpoint, isProvider, token);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_16 = NL + "\t\t\t\t" + NL + "\t\t\t\treturn cxfEndpoint;" + NL + "\t\t\t}";
  protected final String TEXT_17 = NL + "\t\t\tprivate void addHttpAuth(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, boolean isProvider, final String... userInfo){";
  protected final String TEXT_18 = NL + "\t\t\t\t\tif(!isProvider){" + NL + "\t\t\t\t\t\tMap <String, Object> myProperties = new HashMap<String, Object> ();" + NL + "\t\t\t\t\t\torg.apache.cxf.configuration.security.AuthorizationPolicy authorizationPolicy = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\t\t\t\t\tauthorizationPolicy.setUserName(userInfo[1]);" + NL + "\t\t\t\t\t\tauthorizationPolicy.setPassword(userInfo[2]);" + NL + "\t\t\t\t\t\tauthorizationPolicy.setAuthorizationType(userInfo[0]);" + NL + "\t\t\t\t\t\tmyProperties.put(org.apache.cxf.configuration.security.AuthorizationPolicy.class.getName(), authorizationPolicy); " + NL + "\t\t\t\t\t\tcxfEndpoint.setProperties(myProperties);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_19 = NL + "\t\t\t\t\tif(isProvider){" + NL + "\t\t\t\t\t\torg.apache.cxf.interceptor.security.JAASLoginInterceptor jaasLoginInterceptor = new org.apache.cxf.interceptor.security.JAASLoginInterceptor();" + NL + "\t\t\t\t\t\tjaasLoginInterceptor.setContextName(\"karaf\");" + NL + "\t\t\t\t\t\tcxfEndpoint.getInInterceptors().add(jaasLoginInterceptor);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_20 = NL + "\t\t\t}";
  protected final String TEXT_21 = "\t\t\t" + NL + "\t\t\tprivate void addUsernameToken(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, " + NL + "\t\t\t\t\torg.apache.cxf.Bus bus, boolean isProvider, final String... userInfo){";
  protected final String TEXT_22 = NL + "\t\t\t\tif(isProvider){" + NL + "\t\t\t        Map<String, Object> props = new HashMap<String, Object>();" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.ACTION, org.apache.ws.security.handler.WSHandlerConstants.USERNAME_TOKEN);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.cxf.ws.security.wss4j.WSS4JInInterceptor wss4jInInterceptor = new org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor();" + NL + "\t\t\t\t\twss4jInInterceptor.setProperties(props);" + NL + "\t\t\t\t\tcxfEndpoint.getInInterceptors().add(wss4jInInterceptor);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.ws.security.validate.JAASUsernameTokenValidator validator = new org.apache.ws.security.validate.JAASUsernameTokenValidator();" + NL + "\t\t\t\t\tvalidator.setContextName(\"karaf\");" + NL + "\t\t\t\t\tMap<String,Object> map = new HashMap<String, Object>();" + NL + "\t\t\t\t\tmap.put(\"ws-security.ut.validator\", validator);" + NL + "\t\t\t\t\tcxfEndpoint.setProperties(map);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.neethi.PolicyReference policyReference = new org.apache.neethi.PolicyReference();" + NL + "\t\t\t\t\tpolicyReference.setURI(\"org.talend.esb.job.token.policy\");" + NL + "\t\t\t\t\torg.apache.neethi.Policy policy = new org.apache.neethi.Policy();" + NL + "\t\t\t\t\tpolicy.addPolicyComponent(policyReference);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.cxf.ws.policy.WSPolicyFeature wsPolicyFeature = new org.apache.cxf.ws.policy.WSPolicyFeature();" + NL + "\t\t\t\t\twsPolicyFeature.getPolicies().add(policy);" + NL + "\t\t\t\t\tbus.getFeatures().add(wsPolicyFeature);" + NL + "\t\t\t\t}";
  protected final String TEXT_23 = NL + "\t\t\t\tif(!isProvider){" + NL + "\t\t\t\t\tjavax.security.auth.callback.CallbackHandler c = new javax.security.auth.callback.CallbackHandler() {" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tpublic void handle(javax.security.auth.callback.Callback[] arg0) throws java.io.IOException," + NL + "\t\t\t\t\t\tjavax.security.auth.callback.UnsupportedCallbackException {" + NL + "\t\t\t\t\t\t\torg.apache.ws.security.WSPasswordCallback callback = (org.apache.ws.security.WSPasswordCallback) arg0[0];" + NL + "\t\t\t\t\t\t\tcallback.setPassword(userInfo[1]);" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t};" + NL + "" + NL + "\t\t\t\t\tMap<String, Object> props = new HashMap<String, Object>();" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.ACTION, org.apache.ws.security.handler.WSHandlerConstants.USERNAME_TOKEN);" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.USER, userInfo[0]);" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.PASSWORD_TYPE, org.apache.ws.security.WSConstants.PW_TEXT);" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.PW_CALLBACK_REF, c);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor wss4jOutInterceptor = new org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor();" + NL + "\t\t\t\t\twss4jOutInterceptor.setProperties(props);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tcxfEndpoint.getOutInterceptors().add(wss4jOutInterceptor);" + NL + "\t\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\t}";
  protected final String TEXT_25 = NL + NL + "private Map<String, String> clientProperties;" + NL + "" + NL + "private Map<String, String> stsProperties;" + NL + "\t" + NL + "public void setClientProperties(Map<String, String> clientProperties) {" + NL + "        this.clientProperties = clientProperties;" + NL + "}" + NL + "" + NL + "public void setStsProperties(Map<String, String> stsProperties) {" + NL + "        this.stsProperties = stsProperties;" + NL + "}" + NL + "" + NL + "" + NL + "class WSPasswordCallbackHandler implements javax.security.auth.callback.CallbackHandler {" + NL + "" + NL + "    private final String user;" + NL + "    private final String pass;" + NL + "" + NL + "    public WSPasswordCallbackHandler(String username, String password) {" + NL + "        user = username;" + NL + "        pass = password;" + NL + "    }" + NL + "" + NL + "    public void handle(javax.security.auth.callback.Callback[] callbacks) throws java.io.IOException," + NL + "    javax.security.auth.callback.UnsupportedCallbackException {" + NL + "        for (javax.security.auth.callback.Callback callback : callbacks) {" + NL + "            if (callback instanceof org.apache.ws.security.WSPasswordCallback) {" + NL + "            \torg.apache.ws.security.WSPasswordCallback pc = (org.apache.ws.security.WSPasswordCallback) callback;" + NL + "                if (user.equals(pc.getIdentifier())) {" + NL + "                    pc.setPassword(pass);" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "" + NL + "} " + NL;
  protected final String TEXT_26 = NL + "org.apache.camel.component.cxf.common.header.CxfHeaderFilterStrategy consumerSoapHeaderFilter = new org.apache.camel.component.cxf.common.header.CxfHeaderFilterStrategy(){" + NL + "\tpublic boolean applyFilterToCamelHeaders(String headerName," + NL + "\t\t\tObject headerValue, org.apache.camel.Exchange exchange) {" + NL + "\t\t//filter propagated cxf header" + NL + "\t\tif(org.apache.cxf.headers.Header.HEADER_LIST.equals(headerName)){" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t//remove correlationID header, if it's null or empty" + NL + "\t\tif(\"CorrelationID\".equals(headerName)" + NL + "\t\t\t\t&& (headerValue == null || \"\".equals(headerValue.toString()))){" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn super.applyFilterToCamelHeaders(headerName, headerValue, exchange);" + NL + "\t}" + NL + "" + NL + "\tpublic boolean applyFilterToExternalHeaders(String headerName," + NL + "\t\t\tObject headerValue, org.apache.camel.Exchange exchange) {" + NL + "\t\tif(org.apache.cxf.headers.Header.HEADER_LIST.equals(headerName)){" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn super.applyFilterToExternalHeaders(headerName, headerValue, exchange);" + NL + "\t}" + NL + "};";
  protected final String TEXT_27 = NL + "private void addRegistry(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, org.apache.cxf.Bus bus," + NL + "\t\tboolean isProvider, boolean usePropagateSamlAP, final String... token) {";
  protected final String TEXT_28 = NL + NL + "\tif(!isProvider){" + NL + "\t\t\tif(usePropagateSamlAP && (token[4] == null)){" + NL + "\t\t\t\tusePropagateSamlAP = false ;" + NL + "\t\t\t}" + NL + "\t\t\torg.apache.cxf.ws.security.trust.STSClient stsClient = new org.apache.cxf.ws.security.trust.STSClient(" + NL + "\t\t\t\t\tbus);" + NL + "\t\t\tstsClient.setServiceQName(new javax.xml.namespace.QName(" + NL + "\t\t\t\t\tstsProperties.get(\"sts.namespace\"), stsProperties" + NL + "\t\t\t\t\t.get(\"sts.service.name\")));" + NL + "" + NL + "\t\t\tMap<String, Object> stsProps = new HashMap<String, Object>();" + NL + "" + NL + "\t\t\tfor (Map.Entry<String, String> entry : stsProperties.entrySet()) {" + NL + "\t\t\t\tif (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "\t\t\t\t\t\t.contains(entry.getKey())) {" + NL + "\t\t\t\t\tstsProps.put(entry.getKey(), entry.getValue());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tif(usePropagateSamlAP) {" + NL + "\t\t\t\tstsClient.setWsdlLocation(stsProperties.get(\"sts.x509.wsdl.location\"));" + NL + "\t\t\t\tstsClient.setEndpointQName(new javax.xml.namespace.QName(" + NL + "\t\t\t\t\t\tstsProperties.get(\"sts.namespace\"), stsProperties" + NL + "\t\t\t\t\t\t.get(\"sts.x509.endpoint.name\")));" + NL + "\t\t\t\tstsProps.put(org.apache.cxf.ws.security.SecurityConstants.STS_TOKEN_USERNAME," + NL + "\t\t\t\t\t\ttoken[4]);" + NL + "\t\t\t}else {" + NL + "\t\t\t\tstsClient.setWsdlLocation(stsProperties.get(\"sts.wsdl.location\"));" + NL + "\t\t\t\tstsClient.setEndpointQName(new javax.xml.namespace.QName(" + NL + "\t\t\t\t\t\tstsProperties.get(\"sts.namespace\"), stsProperties" + NL + "\t\t\t\t\t\t.get(\"sts.endpoint.name\")));" + NL + "\t\t\t\tstsProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME," + NL + "\t\t\t\t\t\ttoken[1]);" + NL + "\t\t\t\tstsProps.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD," + NL + "\t\t\t\t\t\ttoken[2]);" + NL + "\t\t\t}" + NL + "\t\t\tstsClient.setProperties(stsProps);" + NL + "            if (token[3]/*Role*/ != null && !(\"\".equals(token[3]))) {" + NL + "                ClaimValueCallbackHandler roleCallbackHandler = new ClaimValueCallbackHandler();" + NL + "                roleCallbackHandler.setClaimValue(token[3]);" + NL + "                stsClient.setClaimsCallbackHandler(roleCallbackHandler);" + NL + "            }" + NL + "" + NL + "\t\t\tMap<String, Object> clientProps = new HashMap<String, Object>();" + NL + "\t\t\tclientProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME," + NL + "                    token[1]);" + NL + "            clientProps.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD," + NL + "            \t\ttoken[2]);" + NL + "" + NL + "\t\t\tclientProps.put(" + NL + "\t\t\t\t\torg.apache.cxf.ws.security.SecurityConstants.STS_CLIENT," + NL + "\t\t\t\t\tstsClient);" + NL + "" + NL + "\t\t\tfor (Map.Entry<String, String> entry : clientProperties.entrySet()) {" + NL + "\t\t\t\tif (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "\t\t\t\t\t\t.contains(entry.getKey())) {" + NL + "\t\t\t\t\tclientProps.put(entry.getKey(), entry.getValue());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tif(usePropagateSamlAP) {" + NL + "\t\t\t\tclientProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, token[4]);" + NL + "\t\t\t\tclientProps" + NL + "\t\t\t\t.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "\t\t\t\t\t\tnew WSPasswordCallbackHandler(token[4], token[2]));" + NL + "\t\t\t}else {" + NL + "\t\t\t\tclientProps" + NL + "\t\t\t\t.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "\t\t\t\t\t\tnew WSPasswordCallbackHandler(" + NL + "\t\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t\t.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME)," + NL + "\t\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t\t.get(\"ws-security.signature.password\")));" + NL + "\t\t\t}" + NL + "\t\t\tclientProps.put(\"soap.no.validate.parts\", Boolean.TRUE);" + NL + "\t\t\tclientProps.put(\"use.service.registry\", \"true\");" + NL + "\t\t\t// set the cxfEndpoint Properties" + NL + "\t\t\tcxfEndpoint.setProperties(clientProps);" + NL + "\t\t\t}";
  protected final String TEXT_29 = NL + "\tif (isProvider) {" + NL + "\t\tString userName = (String) securityProps.get(\"ws-security.signature.username\");" + NL + "\t\tString password = (String) securityProps.get(\"ws-security.signature.password\");" + NL + "\t\tString properties = (String) securityProps.get(\"ws-security.signature.properties\");" + NL + "\t\tString pdpAddress = (String) securityProps.get(\"tesb.pdp.address\");" + NL + "" + NL + "\t\torg.apache.ws.security.validate.JAASUsernameTokenValidator jaasUTValidator=" + NL + "\t\tnew org.apache.ws.security.validate.JAASUsernameTokenValidator();" + NL + "\t\tjaasUTValidator.setContextName(\"karaf\");" + NL + "\t\t// set endpoint properties" + NL + "\t\torg.apache.cxf.interceptor.security.NamePasswordCallbackHandler callbackHandler = new org.apache.cxf.interceptor.security.NamePasswordCallbackHandler(" + NL + "\t\t\t\tuserName, password, \"setPassword\");" + NL + "\t\tMap<String, Object> endpointProps = new HashMap<String, Object>();" + NL + "\t\tendpointProps.put(\"ws-security.signature.username\", userName);" + NL + "\t\tendpointProps.put(\"ws-security.signature.properties\", properties);" + NL + "\t\tendpointProps.put(\"ws-security.callback-handler\", callbackHandler);" + NL + "\t\tendpointProps.put(\"ws-security.ut.validator\", jaasUTValidator);" + NL + "\t\tendpointProps.put(\"tesb.pdp.address\", pdpAddress);" + NL + "\t\tendpointProps.put(\"use.service.registry\", \"true\");" + NL + "\t\tcxfEndpoint.setProperties(endpointProps);" + NL + "\t\t" + NL + " " + NL + "\t}\t";
  protected final String TEXT_30 = "\t" + NL + "}";
  protected final String TEXT_31 = NL + "private Map<String, String> securityProps;" + NL + "" + NL + "public void setSecurityProps(Map<String, String> securityProps){" + NL + "\tthis.securityProps = securityProps;" + NL + "}";
  protected final String TEXT_32 = NL + NL + NL + "private Map<String, String> policies;" + NL + "" + NL + "public void setPolicies(Map<String, String> policies){" + NL + "\tthis.policies = policies;" + NL + "}" + NL + "" + NL + "private org.apache.neethi.Policy loadPolicy(String location, org.apache.cxf.Bus bus) {" + NL + "    java.io.InputStream is = null;" + NL + "    try {" + NL + "        is = new java.io.FileInputStream(location);" + NL + "        return bus.getExtension(org.apache.cxf.ws.policy.PolicyBuilder.class).getPolicy(is);" + NL + "    } catch (Exception e) {" + NL + "        throw new RuntimeException(\"Cannot load policy\", e);" + NL + "    } finally {" + NL + "        if (null != is) {" + NL + "            try {" + NL + "                is.close();" + NL + "            } catch (java.io.IOException e) {" + NL + "                // just ignore" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "}" + NL + "public void registerPolicies(org.apache.cxf.Bus bus) {" + NL + "\tif(policies != null){" + NL + "        org.apache.neethi.PolicyRegistry policyRegistry =" + NL + "                bus.getExtension(org.apache.cxf.ws.policy.PolicyEngine.class).getRegistry();" + NL + "        policyRegistry.register(\"org.talend.esb.job.token.policy\"," + NL + "        \t\tloadPolicy(policies.get(\"policy.username\"), bus));" + NL + "        policyRegistry.register(\"org.talend.esb.job.saml.policy\"," + NL + "        \t\tloadPolicy(policies.get(\"policy.saml\"), bus));" + NL + "        " + NL + "        policyRegistry.register(\"org.talend.esb.job.saml.authz.policy\"," + NL + "        \t\tloadPolicy(policies.get(\"policy.saml.authz\"), bus));" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_33 = NL + "class ClaimValueCallbackHandler implements javax.security.auth.callback.CallbackHandler {" + NL + "" + NL + "    private String claimValue;" + NL + "" + NL + "    public void handle(javax.security.auth.callback.Callback[] callbacks)" + NL + "        throws java.io.IOException, javax.security.auth.callback.UnsupportedCallbackException {" + NL + "        for (int i = 0; i < callbacks.length; i++) {" + NL + "            if (callbacks[i] instanceof org.apache.cxf.ws.security.trust.claims.ClaimsCallback) {" + NL + "            \torg.apache.cxf.ws.security.trust.claims.ClaimsCallback callback = (org.apache.cxf.ws.security.trust.claims.ClaimsCallback) callbacks[i];" + NL + "                callback.setClaims(createClaims());" + NL + "                " + NL + "            } else {" + NL + "                throw new javax.security.auth.callback.UnsupportedCallbackException(callbacks[i], \"Unrecognized Callback\");" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "" + NL + "    /**" + NL + "     * Create a Claims Element for a \"role\"" + NL + "     */" + NL + "    private org.w3c.dom.Element createClaims() {" + NL + "    \torg.w3c.dom.Document doc = org.apache.cxf.helpers.DOMUtils.createDocument();" + NL + "    \torg.w3c.dom.Element claimsElement =" + NL + "            doc.createElementNS(\"http://docs.oasis-open.org/ws-sx/ws-trust/200512\", \"Claims\");" + NL + "        claimsElement.setAttributeNS(null, \"Dialect\", \"http://schemas.xmlsoap.org/ws/2005/05/identity\");" + NL + "" + NL + "        org.w3c.dom.Element claimValueElement =" + NL + "            doc.createElementNS(\"http://schemas.xmlsoap.org/ws/2005/05/identity\", \"ClaimValue\");" + NL + "        claimValueElement.setAttributeNS(null, \"Uri\", \"http://schemas.xmlsoap.org/ws/2005/05/identity/claims/role\");" + NL + "        org.w3c.dom.Element value = doc.createElementNS(\"http://schemas.xmlsoap.org/ws/2005/05/identity\", \"Value\");" + NL + "        value.setTextContent(claimValue);" + NL + "        claimValueElement.appendChild(value);" + NL + "" + NL + "        claimsElement.appendChild(claimValueElement);" + NL + "" + NL + "        return claimsElement;" + NL + "    }" + NL + "" + NL + "    public String getClaimValue() {" + NL + "        return claimValue;" + NL + "    }" + NL + "" + NL + "    public void setClaimValue(String claimValue) {" + NL + "        this.claimValue = claimValue;" + NL + "    }" + NL + "" + NL + "}\t";
  protected final String TEXT_34 = NL + NL + "private void addSAMLToken(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, org.apache.cxf.Bus bus," + NL + "\t\tboolean isProvider, boolean useAuthorization, boolean usePropagateSamlAP, String... token) {";
  protected final String TEXT_35 = NL + "\tif (!isProvider) {" + NL + "\t\torg.apache.cxf.ws.security.trust.STSClient stsClient = new org.apache.cxf.ws.security.trust.STSClient(" + NL + "\t\t\t\tbus);" + NL + "\t\tstsClient.setServiceQName(new javax.xml.namespace.QName(" + NL + "\t\t\t\tstsProperties.get(\"sts.namespace\"), stsProperties" + NL + "\t\t\t\t.get(\"sts.service.name\")));" + NL + "" + NL + "" + NL + "\t\tMap<String, Object> stsProps = new HashMap<String, Object>();" + NL + "" + NL + "\t\tfor (Map.Entry<String, String> entry : stsProperties.entrySet()) {" + NL + "\t\t\tif (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "\t\t\t\t\t.contains(entry.getKey())) {" + NL + "\t\t\t\tstsProps.put(entry.getKey(), entry.getValue());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tif(usePropagateSamlAP) {" + NL + "\t\t\tstsClient.setWsdlLocation(stsProperties.get(\"sts.x509.wsdl.location\"));" + NL + "\t\t\tstsClient.setEndpointQName(new javax.xml.namespace.QName(" + NL + "\t\t\t\t\tstsProperties.get(\"sts.namespace\"), stsProperties" + NL + "\t\t\t\t\t.get(\"sts.x509.endpoint.name\")));" + NL + "\t\t\tstsProps.put(org.apache.cxf.ws.security.SecurityConstants.STS_TOKEN_USERNAME," + NL + "\t\t\t\t\ttoken[4]);" + NL + "\t\t}else {" + NL + "\t\t\tstsClient.setWsdlLocation(stsProperties.get(\"sts.wsdl.location\"));" + NL + "\t\t\tstsClient.setEndpointQName(new javax.xml.namespace.QName(" + NL + "\t\t\t\t\tstsProperties.get(\"sts.namespace\"), stsProperties" + NL + "\t\t\t\t\t.get(\"sts.endpoint.name\")));" + NL + "\t\t\tstsProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME," + NL + "\t\t\t\t\ttoken[1]);" + NL + "\t\t\tstsProps.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD," + NL + "\t\t\t\t\ttoken[2]);" + NL + "\t\t}" + NL + "\t\tstsClient.setProperties(stsProps);";
  protected final String TEXT_36 = NL + "        if (token[3] != null && !(\"\".equals(token[3]))) {" + NL + "            ClaimValueCallbackHandler roleCallbackHandler = new ClaimValueCallbackHandler();" + NL + "            roleCallbackHandler.setClaimValue(token[3]);" + NL + "            stsClient.setClaimsCallbackHandler(roleCallbackHandler);" + NL + "        }";
  protected final String TEXT_37 = NL + "\t\tMap<String, Object> clientProps = new HashMap<String, Object>();" + NL + "\t\tclientProps.put(" + NL + "\t\t\t\torg.apache.cxf.ws.security.SecurityConstants.STS_CLIENT," + NL + "\t\t\t\tstsClient);" + NL + "" + NL + "\t\tfor (Map.Entry<String, String> entry : clientProperties.entrySet()) {" + NL + "\t\t\tif (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "\t\t\t\t\t.contains(entry.getKey())) {" + NL + "\t\t\t\tclientProps.put(entry.getKey(), entry.getValue());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif(usePropagateSamlAP) {" + NL + "\t\t\tclientProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, token[4]);" + NL + "\t\t\tclientProps" + NL + "\t\t\t.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "\t\t\t\t\tnew WSPasswordCallbackHandler(token[4], token[2]));" + NL + "\t\t}else {" + NL + "\t\t\tclientProps" + NL + "\t\t\t.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "\t\t\t\t\tnew WSPasswordCallbackHandler(" + NL + "\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME)," + NL + "\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t.get(\"ws-security.signature.password\")));" + NL + "\t\t}" + NL + "\t\t// set the cxfEndpoint Properties" + NL + "\t\tcxfEndpoint.setProperties(clientProps);" + NL + "" + NL + "\t\t// add policy" + NL + "\t\torg.apache.neethi.PolicyReference policyReference = new org.apache.neethi.PolicyReference();" + NL + "\t\tif(useAuthorization){" + NL + "\t\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.authz.policy\");" + NL + "\t\t}else{" + NL + "\t\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.policy\");" + NL + "\t\t}" + NL + "\t\torg.apache.neethi.Policy policy = new org.apache.neethi.Policy();" + NL + "\t\tpolicy.addPolicyComponent(policyReference);" + NL + "" + NL + "\t\torg.apache.cxf.ws.policy.WSPolicyFeature wsPolicyFeature = new org.apache.cxf.ws.policy.WSPolicyFeature();" + NL + "\t\twsPolicyFeature.getPolicies().add(policy);" + NL + "\t\tcxfEndpoint.getFeatures().add(wsPolicyFeature);" + NL + "\t\t// register bus with policy" + NL + "\t\tregisterPolicies(bus);" + NL + "\t}";
  protected final String TEXT_38 = NL + "if (isProvider) {" + NL + "\t\t// get saml properties" + NL + "\t\tString userName = (String) securityProps" + NL + "\t\t\t\t.get(\"ws-security.signature.username\");" + NL + "\t\tString password = (String) securityProps" + NL + "\t\t\t\t.get(\"ws-security.signature.password\");" + NL + "\t\tString properties = (String) securityProps" + NL + "\t\t\t\t.get(\"ws-security.signature.properties\");" + NL + "\t\t// add in intercept" + NL + "\t\tMap<String, Object> props = new HashMap<String, Object>();" + NL + "\t\tprops.put(" + NL + "\t\t\t\torg.apache.ws.security.handler.WSHandlerConstants.ACTION," + NL + "\t\t\t\torg.apache.ws.security.handler.WSHandlerConstants.ENCRYPT+\" \"" + NL + "\t\t\t\t\t\t+org.apache.ws.security.handler.WSHandlerConstants.SAML_TOKEN_SIGNED+\" \"" + NL + "\t\t\t\t\t\t+org.apache.ws.security.handler.WSHandlerConstants.SIGNATURE);" + NL + "\t\tprops.put(" + NL + "\t\t\t\torg.apache.ws.security.handler.WSHandlerConstants.SIG_PROP_FILE," + NL + "\t\t\t\tproperties);" + NL + "" + NL + "\t\torg.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JInInterceptor wss4jInInterceptor = org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JInInterceptor.INSTANCE;" + NL + "\t\twss4jInInterceptor.setProperties(props);" + NL + "\t\tcxfEndpoint.getInInterceptors().add(wss4jInInterceptor);" + NL + "" + NL + "\t\t// set endpoint properties" + NL + "\t\torg.apache.cxf.interceptor.security.NamePasswordCallbackHandler callbackHandler = new org.apache.cxf.interceptor.security.NamePasswordCallbackHandler(" + NL + "\t\t\t\tuserName, password, \"setPassword\");" + NL + "\t\tMap<String, Object> endpointProps = new HashMap<String, Object>();" + NL + "\t\tendpointProps.put(\"ws-security.signature.username\", userName);" + NL + "\t\tendpointProps.put(\"ws-security.signature.properties\"," + NL + "\t\t\t\tproperties);" + NL + "\t\tendpointProps.put(\"ws-security.callback-handler\"," + NL + "\t\t\t\tcallbackHandler);" + NL + "\t\tendpointProps.put(\"use.service.registry\"," + NL + "\t\t\t\t\"false\");" + NL + "\t\tif(useAuthorization){" + NL + "\t\t\tendpointProps.put(\"tesb.pdp.address\",  (String)securityProps" + NL + "\t\t\t\t\t.get(\"tesb.pdp.address\"));" + NL + "\t\t}" + NL + "\t\tcxfEndpoint.setProperties(endpointProps);" + NL + "\t\t// add policy" + NL + "\t\torg.apache.neethi.PolicyReference policyReference = new org.apache.neethi.PolicyReference();" + NL + "\t\tif(!useAuthorization){" + NL + "\t\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.policy\");" + NL + "\t\t}else{" + NL + "\t\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.authz.policy\");" + NL + "\t\t}" + NL + "\t\torg.apache.neethi.Policy policy = new org.apache.neethi.Policy();" + NL + "\t\tpolicy.addPolicyComponent(policyReference);" + NL + "" + NL + "\t\torg.apache.cxf.ws.policy.WSPolicyFeature wsPolicyFeature = new org.apache.cxf.ws.policy.WSPolicyFeature();" + NL + "\t\twsPolicyFeature.getPolicies().add(policy);" + NL + "\t\tcxfEndpoint.getFeatures().add(wsPolicyFeature);" + NL + "\t\t// register policy on bus" + NL + "\t\tregisterPolicies(bus);" + NL + "}\t";
  protected final String TEXT_39 = NL + "}";
  protected final String TEXT_40 = NL + "\t\t\t/**" + NL + "\t\t\t* please initial uri map " + NL + "\t\t\t*/" + NL + "\t\t\tpublic void configure() throws java.lang.Exception {";
  protected final String TEXT_41 = NL + "\t\t\t\t// CXF endpoint for ";
  protected final String TEXT_42 = NL + "\t\t\t\torg.apache.camel.component.cxf.CxfEndpoint ";
  protected final String TEXT_43 = " = getCxfEndpoint(";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ", ";
  protected final String TEXT_48 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\t,";
  protected final String TEXT_49 = ",";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = ", ";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t);";
  protected final String TEXT_53 = NL + "\t\t\t\t";
  protected final String TEXT_54 = ".setCxfBinding(new CXFConsumerBinding(";
  protected final String TEXT_55 = "));";
  protected final String TEXT_56 = NL + "\t\t\t\t";
  protected final String TEXT_57 = ".getFeatures().add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());";
  protected final String TEXT_58 = NL + "\t\t\t\t// Add Service Locator Service to ";
  protected final String TEXT_59 = NL + "\t\t\t\tif (null != bundleContext) {" + NL + "\t\t\t\t\torg.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature = new org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\tjava.util.Map<String, String> slCustomProps_";
  protected final String TEXT_61 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\tslCustomProps_";
  protected final String TEXT_63 = ".put(";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t\t\t\tlocatorFeature.setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_68 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\t\tlocatorFeature.setAvailableEndpointProperties(slCustomProps_";
  protected final String TEXT_70 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\t";
  protected final String TEXT_72 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = ".getFeatures().add(locatorFeature);" + NL + "\t\t\t\t}";
  protected final String TEXT_74 = NL + "\t\t\t\t// Add Service Activity Monitor Service to ";
  protected final String TEXT_75 = NL + "\t\t\t\tif (eventFeature != null) {" + NL + "\t\t\t\t\t((org.apache.camel.component.cxf.CxfEndpoint)";
  protected final String TEXT_76 = ").getFeatures().add(new FeatureWrapper(eventFeature));" + NL + "\t\t\t\t}";
  protected final String TEXT_77 = NL + "\t\t\torg.apache.camel.component.file.remote.RemoteFileEndpoint<?> ";
  protected final String TEXT_78 = " =  getFtpEndpoint(";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = ", ";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "\t\t\torg.apache.camel.component.mail.MailEndpoint ";
  protected final String TEXT_85 = " =  getMailEndpoint(";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ", ";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = ", ";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + "\t\t\t\t\t\torg.apache.camel.spi.AggregationRepository repo_";
  protected final String TEXT_95 = " = new ";
  protected final String TEXT_96 = ";";
  protected final String TEXT_97 = NL + "\t\t\t\t\t\torg.apache.camel.spi.RecoverableAggregationRepository repo_";
  protected final String TEXT_98 = " = new ";
  protected final String TEXT_99 = ";";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_101 = ".setUseRecovery(true);" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_102 = ".setMaximumRedeliveries(";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_104 = ".setDeadLetterUri(";
  protected final String TEXT_105 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_106 = ".setRecoveryInterval(";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\t\torg.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_109 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_110 = "\", ";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\t\t\t\t\t\t\torg.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_113 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_114 = "\");";
  protected final String TEXT_115 = NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_116 = ".setUseRecovery(true);" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_117 = ".setMaximumRedeliveries(";
  protected final String TEXT_118 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_119 = ".setDeadLetterUri(";
  protected final String TEXT_120 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_121 = ".setRecoveryInterval(";
  protected final String TEXT_122 = ");";
  protected final String TEXT_123 = NL + "\t\t\t\tMap<String, String> ";
  protected final String TEXT_124 = "NSMap = new HashMap<String, String>();" + NL + "\t\t\t\t{";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = "NSMap.put(";
  protected final String TEXT_127 = ", ";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t\t\t\t}";
  protected final String TEXT_130 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_131 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_132 = NL + "\t\t\t\t";
  protected final String TEXT_133 = "NSMap.put(";
  protected final String TEXT_134 = ", ";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL + "\t\t}";
  protected final String TEXT_137 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_138 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_139 = NL + "\t\t\t\t";
  protected final String TEXT_140 = "NSMap.put(";
  protected final String TEXT_141 = ", ";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL + "\t\t}";
  protected final String TEXT_144 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_145 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_146 = NL + "\t\t\t\t";
  protected final String TEXT_147 = "NSMap.put(";
  protected final String TEXT_148 = ", ";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "\t\t}";
  protected final String TEXT_151 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_152 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_153 = NL + "\t\t\t\t";
  protected final String TEXT_154 = "NSMap.put(";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = ");";
  protected final String TEXT_157 = NL + "\t\t}";
  protected final String TEXT_158 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_159 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_160 = NL + "\t\t\t\t";
  protected final String TEXT_161 = "NSMap.put(";
  protected final String TEXT_162 = ", ";
  protected final String TEXT_163 = ");";
  protected final String TEXT_164 = NL + "\t\t}";
  protected final String TEXT_165 = NL + "\t\torg.apache.camel.Endpoint endpoint_";
  protected final String TEXT_166 = " = endpoint(\"talend:\"+ ";
  protected final String TEXT_167 = "+ \"?context=\" + ";
  protected final String TEXT_168 = "+\"&propagateHeader=";
  protected final String TEXT_169 = "\");";
  protected final String TEXT_170 = NL + "\t\t\torg.apache.camel.Endpoint endpoint_";
  protected final String TEXT_171 = " = endpoint(\"talend:\"+";
  protected final String TEXT_172 = ".class.getName()+\"?context=\"+\"";
  protected final String TEXT_173 = "&propagateHeader=";
  protected final String TEXT_174 = "\");";
  protected final String TEXT_175 = NL + "{" + NL + "        Map <String, String> propertiesMap = new HashMap<String, String>();  ";
  protected final String TEXT_176 = NL + "\t\t\t\tpropertiesMap.put(";
  protected final String TEXT_177 = ", propertyToString(";
  protected final String TEXT_178 = "));";
  protected final String TEXT_179 = NL + "        endpoint_";
  protected final String TEXT_180 = ".getCamelContext().setProperties(propertiesMap);" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess) v.get(0);
	String version = (String) v.get(1);

/*
	boolean startable = false;
	for (INode node : (List< ? extends INode>)process.getGraphicalNodes()) {
		Object value = node.getPropertyValue("STARTABLE");
		startable = value == null? false:(Boolean)value;
		if(startable){
			break;
		}
	}
*/
	boolean stats = codeGenArgument.isStatistics();


    stringBuffer.append(TEXT_1);
    
			List<? extends INode> cMailNodes = process.getNodesOfType("cMail");
			if(cMailNodes.size() > 0){

    stringBuffer.append(TEXT_2);
    
			}
			
			List<? extends INode> cFtpNodes = process.getNodesOfType("cFtp");
			if(cFtpNodes.size() > 0){

    stringBuffer.append(TEXT_3);
    
			}
			
			boolean hasCXFComponent = false;
			boolean hasCXFSamlTokenProvider = false;
			boolean hasCXFSamlTokenConsumer = false;
			boolean hasCXFSamlTokenAuthorizationConsumer = false;
			boolean hasCXFUsernameTokenProvider = false;
			boolean hasCXFUsernameTokenConsumer = false;
			boolean hasCXFHTTPAuthConsumer = false;
			boolean hasCXFHTTPAuthProvider = false;
			boolean hasCXFComponentConsumer = false;
			boolean hasCXFRegistryProvider = false;
			boolean hasCXFRegistryConsumer = false;
			boolean hasCXFCorrelationConsumer = false;
			boolean hasCXFSAMLPropagateConsumer = false;
			boolean isStudioEEVersion = org.talend.core.PluginChecker.isTIS();
			List<? extends INode> cxfNodes = process.getNodesOfType("cCXF");
			if( null != cxfNodes && cxfNodes.size() >0 ){
				hasCXFComponent = true;
				for(INode n: cxfNodes){
					String useRegistry = "false";
					if(isStudioEEVersion){
						useRegistry = ElementParameterParser.getValue(n, "__ENABLE_REGISTRY__");
					}
					String useSecurity = ElementParameterParser.getValue(n, "__ENABLE_SECURITY__");
					String formatType = ElementParameterParser.getValue(n, "__DATAFORMAT__");
					if("RAW".equals(formatType) || "CXF_MESSAGE".equals(formatType)){
						useRegistry = "false";
						useSecurity = "false";
					}
					String securityType = ElementParameterParser.getValue(n, "__SECURITY_TYPE__");
					int incomingConnections = n.getIncomingConnections().size();
					if(!hasCXFComponentConsumer && incomingConnections>0){
						hasCXFComponentConsumer = true;
					}
					String useCorrelation = ElementParameterParser.getValue(n, "__ENABLE_CORRELATION__");
					if("RAW".equals(formatType)){
						useCorrelation = "false";
					}
					if("false".equals(useCorrelation)){
						useCorrelation = useRegistry;
					}
					if("true".equals(useCorrelation) && incomingConnections>0 ){
						hasCXFCorrelationConsumer = true;
					}
					if("true".equals(useRegistry)){
						useSecurity = "false";
						if(incomingConnections == 0){
								hasCXFRegistryProvider = true;
						}else{
							hasCXFRegistryConsumer = true;
							if(!hasCXFSAMLPropagateConsumer && Boolean.parseBoolean(ElementParameterParser.getValue(n, "__USE_PROPAGATE_CREDENTIAL__"))){
								hasCXFSAMLPropagateConsumer = true;
							}
						}
					}
					if("true".equals(useSecurity)){
						if("SAML".equals(securityType) && (!hasCXFSamlTokenProvider || !hasCXFSamlTokenConsumer || !hasCXFSAMLPropagateConsumer)){
							if(incomingConnections == 0){
								hasCXFSamlTokenProvider = true;
							}else{
								hasCXFSamlTokenConsumer = true;
								if(!hasCXFSamlTokenAuthorizationConsumer && isStudioEEVersion){
									if("true".equals(ElementParameterParser.getValue(n, "__USE_AUTHORIZATION__"))){
										hasCXFSamlTokenAuthorizationConsumer = true;
									}
								}
								if(!hasCXFSAMLPropagateConsumer){
									String samlSecurityType = ElementParameterParser.getValue(n, "__SAML_SECURITY_TYPES__");
									if("PROPAGATE_UP".equals(samlSecurityType) || "PROPAGATE_AP".equals(samlSecurityType)){
									   hasCXFSAMLPropagateConsumer = true;
									}
								}
							}
						}else if("USER".equals(securityType) && (!hasCXFUsernameTokenProvider || !hasCXFUsernameTokenConsumer)){
							if(incomingConnections == 0){
								hasCXFUsernameTokenProvider = true;
							}else{
								hasCXFUsernameTokenConsumer = true;
							}
						}else if(("BASIC".equals(securityType)||"DIGEST".equals(securityType)) && (!hasCXFHTTPAuthProvider || !hasCXFHTTPAuthConsumer)){
							if(incomingConnections == 0){
								hasCXFHTTPAuthProvider = true;
							}else{
								hasCXFHTTPAuthConsumer = true;
							}
						}
					}
				}
			}
			
			
		if(hasCXFSAMLPropagateConsumer){

    stringBuffer.append(TEXT_4);
    		}
		if(hasCXFRegistryProvider || hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_5);
    
			}

			
			if(hasCXFComponent){

    stringBuffer.append(TEXT_6);
    if(hasCXFUsernameTokenProvider || hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer || hasCXFHTTPAuthProvider || hasCXFRegistryProvider || hasCXFRegistryConsumer){
    stringBuffer.append(TEXT_7);
    if(hasCXFUsernameTokenProvider || hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer || hasCXFRegistryProvider || hasCXFRegistryConsumer){
    stringBuffer.append(TEXT_8);
    
					}
					if(hasCXFUsernameTokenProvider){

    stringBuffer.append(TEXT_9);
    
					}
					if(hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_10);
    
					}
					if(hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer){


    stringBuffer.append(TEXT_11);
    					}
					if(hasCXFRegistryProvider || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    
}
				if(hasCXFUsernameTokenConsumer){

    stringBuffer.append(TEXT_14);
    
				}
				if(hasCXFHTTPAuthConsumer){

    stringBuffer.append(TEXT_15);
    
				}

    stringBuffer.append(TEXT_16);
    
			if(hasCXFHTTPAuthConsumer || hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_17);
    
				if(hasCXFHTTPAuthConsumer){

    stringBuffer.append(TEXT_18);
    
				}
				if(hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_19);
    
				}

    stringBuffer.append(TEXT_20);
    
			}
			if(hasCXFUsernameTokenConsumer || hasCXFUsernameTokenProvider){

    stringBuffer.append(TEXT_21);
    if(hasCXFUsernameTokenProvider){
    stringBuffer.append(TEXT_22);
    
}
if(hasCXFUsernameTokenConsumer){				

    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    
			}
			}
if(hasCXFSamlTokenConsumer || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_25);
    
}

if(hasCXFComponentConsumer){

    stringBuffer.append(TEXT_26);
    
}
if(hasCXFRegistryProvider || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_27);
    if(hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_28);
    
}
if(hasCXFRegistryProvider){

    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    
}

if(hasCXFSamlTokenProvider || hasCXFRegistryProvider){

    stringBuffer.append(TEXT_31);
    
}

if(hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer
	||hasCXFRegistryProvider || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_32);
    if(hasCXFSamlTokenAuthorizationConsumer || hasCXFRegistryConsumer){
    stringBuffer.append(TEXT_33);
    }
if(hasCXFSamlTokenConsumer || hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_34);
    
if(hasCXFSamlTokenConsumer){

    stringBuffer.append(TEXT_35);
    if(hasCXFSamlTokenAuthorizationConsumer){
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
}
if(hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_38);
    
}//end if(hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_39);
    
}//end if(hasCXFSamlTokenConsumer || hasCXFSamlTokenProvider){
}//end if(hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer
//||hasCXFRegistryProvider || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_40);
    
	List< ? extends INode> processNodes = (List< ? extends INode>)process.getGraphicalNodes();
	for (INode node : processNodes) {
			if (!node.isActivate()) {
				continue;
			}
			String nodeComponentName = node.getComponent().getName();
	if("cCXF".equals(nodeComponentName)){
			IElementParameter param = node.getElementParameter("LABEL");
		   	String cid = node.getUniqueName();
		//  http://jira.talendforge.org/browse/TESB-5241
			/*
		   	 * change to use label + unique to make it unique but readable
		   	 */
			if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
				cid = (String)param.getValue()+"_"+cid;	
			}
			String endpointVar = "endpoint_" + node.getUniqueName();
			String uriRef = "uriMap.get(\"" + cid + "\")";
			String formatType = ElementParameterParser.getValue(node, "__DATAFORMAT__");
			
			boolean useRegistry = false;
			boolean useSecurity = false;
			if(!"RAW".equals(formatType) && !"CXF_MESSAGE".equals(formatType)){
				if(isStudioEEVersion){
					useRegistry = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_REGISTRY__"));
				}
				if(!useRegistry){
					useSecurity = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_SECURITY__"));
				}
			}
			
			String role = ElementParameterParser.getValue(node, "__ROLE_NAME__");
			
			String securityType = ElementParameterParser.getValue(node, "__SECURITY_TYPE__");
			String username = ElementParameterParser.getValue(node, "__USERNAME__");
			String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			String roleName = "\"\"";
			String alias = ElementParameterParser.getValue(node, "__ALIASNAME__").trim();
			boolean isProvider = node.getIncomingConnections().size()>0?false:true;
			boolean isUseAuthorization = false;
			String securityToken = "(String[])null";
			boolean isUsePropagateSamlUP = false;
			boolean isUsePropagateSamlAP = false;
			if(useRegistry){
				securityToken = "\"Registry\"";
					String usePropagate = ElementParameterParser.getValue(node, "__USE_PROPAGATE_CREDENTIAL__");
					if("true".equals(usePropagate)){
					    if(alias == null || alias.matches("\"?\\s*\"?")) {
					    	//no alias.
					    	isUsePropagateSamlUP = true;
					    }else {
					    	isUsePropagateSamlUP = false;
						}
					    isUsePropagateSamlAP = !isUsePropagateSamlUP;
					}
			}else if(useSecurity){
				if("USER".equals(securityType)){
					securityToken = "\"UsernameToken\"";
				}else if("SAML".equals(securityType)){
					securityToken = "\"SAMLToken\"";
					String samlSecurityType = ElementParameterParser.getValue(node, "__SAML_SECURITY_TYPES__");
					if("PROPAGATE_UP".equals(samlSecurityType)) {
							isUsePropagateSamlUP = true;
					}else if ("PROPAGATE_AP".equals(samlSecurityType)) {
						isUsePropagateSamlAP = true;
						username = "null";
					}
					if(isStudioEEVersion){
						isUseAuthorization = "true".equals(ElementParameterParser.getValue(node, "__USE_AUTHORIZATION__"));
					}
				}else if("BASIC".equals(securityType)){
					securityToken = "org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC";
				}else if("DIGEST".equals(securityType)){
					securityToken = "org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST";
				}
			}
			if(!isProvider && (useRegistry || isUseAuthorization)) {
				roleName = ElementParameterParser.getValue(node, "__ROLE_NAME__");
				if(null == roleName || "".equals(roleName)){
					roleName = "\"\"";
				}
			}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(isProvider);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(isUseAuthorization);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(isUsePropagateSamlAP);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(securityToken);
    
				if((useSecurity || useRegistry) && !isProvider){

    stringBuffer.append(TEXT_48);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(roleName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(alias);
    
				}

    stringBuffer.append(TEXT_52);
    			

			if((isUsePropagateSamlUP || isUsePropagateSamlAP) && !isProvider){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_55);
    
			}
			String useSL = ElementParameterParser.getValue(node, "__ENABLE_SL__");
			String useSAM = ElementParameterParser.getValue(node, "__ENABLE_SAM__");
			String useCorrelation = ElementParameterParser.getValue(node, "__ENABLE_CORRELATION__");
			if("RAW".equals(formatType)){
				useCorrelation = "false";
			}
			String correlationValue = ElementParameterParser.getValue(node, "__CORRELATION_VALUE__");
			if(correlationValue != null && "".equals(correlationValue.trim())){
				correlationValue = null;
			}
			
			if ("true".equals(useCorrelation) && !useRegistry) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_57);
    			}
			if ("true".equals(useSL) && (isProvider || !useRegistry)) {
				List<Map<String, String>> customProperties = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SL_META_DATA__");

    stringBuffer.append(TEXT_58);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_59);
     if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
     for (Map<String, String> custProp : customProperties) { 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(custProp.get("NAME"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(custProp.get("VALUE"));
    stringBuffer.append(TEXT_65);
     } 
    
							boolean actAsConsumer = false;
							List<? extends IConnection> conns = node.getIncomingConnections();
							if (!conns.isEmpty()) {
								INode source = conns.get(0).getSource();
								if (!("cErrorHandler".equals(source.getComponent().getName())
										&& source.getIncomingConnections().isEmpty())) {
									actAsConsumer = true;
								}
							}

    stringBuffer.append(TEXT_66);
     if (actAsConsumer) { 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
     } else { 
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
     } 
    stringBuffer.append(TEXT_71);
     } 
    stringBuffer.append(TEXT_72);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_73);
    
			}
			//http://jira.talendforge.org/browse/TESB-3850
            // !"true".equals(useRegistry) - https://jira.talendforge.org/browse/TESB-10725
            			
			if ("true".equals(useSAM) && !"RAW".equals(formatType)  && !useRegistry) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_76);
    
			}
	}else if("cFtp".equals(nodeComponentName)){
			String ftpEndpointVar = "ftp_" + node.getUniqueName();
			String cid = node.getUniqueName();
			IElementParameter labelParam = node.getElementParameter("LABEL");
			if(labelParam != null && !"__UNIQUE_NAME__".equals(labelParam.getValue())){
				cid = (String)labelParam.getValue()+"_"+cid;	
			}
			String uriRef = "uriMap.get(\"" + cid + "\")";
			
			String userName = ElementParameterParser.getValue(node, "__USERNAME__");
			if("".trim().equals(userName)){
				userName = null;
			}
			String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			if("".trim().equals(password)){
				password = null;
			}
			String ftpServer = ElementParameterParser.getValue(node, "__SERVER__");
			String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");
			if("".trim().equals(directory)){
				directory = null;
			}

    stringBuffer.append(TEXT_77);
    stringBuffer.append(ftpEndpointVar);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ftpServer);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_83);
    	
	
	}else if("cMail".equals(nodeComponentName)){
			String mailEndpointVar = "mail_" + node.getUniqueName();
			String cid = node.getUniqueName();
			IElementParameter labelParam = node.getElementParameter("LABEL");
			if(labelParam != null && !"__UNIQUE_NAME__".equals(labelParam.getValue())){
				cid = (String)labelParam.getValue()+"_"+cid;	
			}
			String uriRef = "uriMap.get(\"" + cid + "\")";
			
			String userName = ElementParameterParser.getValue(node, "__USERNAME__");
			String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			String subject = ElementParameterParser.getValue(node, "__SUBJECT__");
			String from = ElementParameterParser.getValue(node, "__FROM__");
			String to = ElementParameterParser.getValue(node, "__TO__");
			String cc = ElementParameterParser.getValue(node, "__CC__");
			String bcc = ElementParameterParser.getValue(node, "__BCC__");
		

    stringBuffer.append(TEXT_84);
    stringBuffer.append(mailEndpointVar);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(subject);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cc);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(bcc);
    stringBuffer.append(TEXT_93);
    	}else if("cAggregate".equals(nodeComponentName)){
				boolean usePersistence = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENCE__"));
				String repository = ElementParameterParser.getValue(node, "__REPOSITORY__");
				if (usePersistence) {
					boolean useRecovery = "true".equals(ElementParameterParser.getValue(node, "__USE_RECOVERY__"));
					String recoveryInterval = ElementParameterParser.getValue(node, "__RECOVERY_INTERVAL__");
					String deadLetterUri = ElementParameterParser.getValue(node, "__DEAD_LETTER_URI__");
					String maximumRedeliveries = ElementParameterParser.getValue(node, "__MAXIMUM_REDELIVERIES__");

					if ("AGGREGATION".equals(repository)) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_96);
    
					} else if ("RECOVERABLE".equals(repository)) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_99);
    
						if (useRecovery) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_107);
    
						}
					} else if ("HAWTDB".equals(repository)) {
						boolean usePersistentFile = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENT_FILE__"));
						String persistentFile = ElementParameterParser.getValue(node, "__PERSISTENT_FILENAME__");
						if (usePersistentFile) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(persistentFile);
    stringBuffer.append(TEXT_111);
    
						} else {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_114);
    
						}
						if (useRecovery) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_122);
    
						}
					}
				}
				
				String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
				String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
				List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");
				if("xpath".equals(language)&&"true".equals(useNamespaces)){
					String cid = node.getUniqueName();
				

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
					for(Map<String, String> m: namespaceValues){
						String pre = m.get("PREFIX");
						String uri = m.get("URI");

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_128);
    
					}

    stringBuffer.append(TEXT_129);
    
				}
	}else if("cLoop".equals(nodeComponentName)){
		String type = ElementParameterParser.getValue(node, "__LOOP_TYPE__");
		if(!"EXPRESSION_TYPE".equals(type)){
			continue;
		}
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_135);
    
			}

    stringBuffer.append(TEXT_136);
    
		
	}else if("cMessageFilter".equals(nodeComponentName)){
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_142);
    
			}

    stringBuffer.append(TEXT_143);
    
	}else if("cRecipientList".equals(nodeComponentName)||"cSplitter".equals(nodeComponentName)){
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_149);
    
			}

    stringBuffer.append(TEXT_150);
    
	}else if("cSetBody".equals(nodeComponentName)){
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_156);
    
			}

    stringBuffer.append(TEXT_157);
    
	}else if("cSetHeader".equals(nodeComponentName)){
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_163);
    
			}

    stringBuffer.append(TEXT_164);
    
	}else if("cTalendJob".equals(nodeComponentName)){
    List< ? extends IConnection> conns = node.getIncomingConnections();
  	String cid = node.getUniqueName();
	List<Map<String, String>> contextParams = null;
    if(conns.size()>0) {
        String useJar = ElementParameterParser.getValue(node, "__FROM_EXTERNAL_JAR__");
        // when propagateHeader parameter will be removed the https://github.com/Talend/tesb-rt-se/blob/master/camel-talendjob/src/main/java/org/talend/camel/TalendProducer.java
        // have to be changed - remove populateTalendContextParamsWithCamelHeaders(exchange, args); 
        String propagateHeader = ElementParameterParser.getValue(node, "__PROPAGATE_HEADER__");
        if("true".equals(useJar)){
            String typeName = ElementParameterParser.getValue(node, "__JOB__");
            String context = ElementParameterParser.getValue(node, "__CONTEXT__");
            contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXTERNAL_JAR_CONTEXTPARAMS__");

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_169);
    
        }else{
           String typeName = "";
           contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
           String context = (String) node.getElementParameter("PROCESS_TYPE_CONTEXT").getValue();
           String id = (String) node.getElementParameter("PROCESS_TYPE_PROCESS").getValue();
           if(id != null){
        	   String useSelectedContext = ElementParameterParser.getValue(node, "__USE_SELECTED_CONTEXT__");
        	   String useRouteContext = ElementParameterParser.getValue(node, "__USE_ROUTE_CONTEXT__");
        	   String useJobContext = ElementParameterParser.getValue(node, "__USE_JOB_CONTEXT__");
        	   if("true".equals(useRouteContext)){
        		   context = ElementParameterParser.getProcessSelectedContext(process.getId()); // route context
        		   boolean found = ElementParameterParser.checkIfContextExisted(id, context); // check the same context exist or not in job
            	   if(!found){
            		   context = ElementParameterParser.getProcessSelectedContext(id); // if not found, then use default job context
            	   }
            	   
        	   }else if("true".equals(useJobContext)){
        		   context = ElementParameterParser.getProcessSelectedContext(id);
        	   }
        	   
	           String jobName = ElementParameterParser.getStringElementParameterValue(node.getElementParameter("SELECTED_JOB_NAME"));
//	           String jobName = (String) node.getElementParameter("SELECTED_JOB_NAME").getValue();
	           String jobVersion = ElementParameterParser.getStringElementParameterValue(node.getElementParameter("PROCESS_TYPE_VERSION"));
	           String jobFolderName = JavaResourcesHelper.getJobFolderName(jobName, jobVersion);
	           typeName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName + "." + jobName;
	        }

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_174);
    
        }
        int contextParamsSize = contextParams.size();
        if(contextParamsSize > 0){

    stringBuffer.append(TEXT_175);
    
		for (int i=0; i<contextParamsSize; i++) {
				Map<String, String> contextParam = contextParams.get(i);
				String paramName;
				String paramValue;
		        if("true".equals(useJar)){
					paramName = contextParam.get("EXTERNAL_JAR_PARAM_NAME_COLUMN");
					paramValue = contextParam.get("EXTERNAL_JAR_PARAM_VALUE_COLUMN");
					
				} else {
					paramName = "\"" + contextParam.get("PARAM_NAME_COLUMN") + "\"";
					paramValue = contextParam.get("PARAM_VALUE_COLUMN");
				}

    stringBuffer.append(TEXT_176);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(paramValue);
    stringBuffer.append(TEXT_178);
    
		}

    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
    }
	}
	}
}

    return stringBuffer.toString();
  }
}

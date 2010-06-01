<%--
  Created by IntelliJ IDEA.
  User: krobinson6
  Date: May 31, 2010
  Time: 10:29:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="org.kar.StackOverflowAPIConstants" contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Simple GSP page</title></head>
<body>
<g:form action="show" id="myForm" controller="stackApps">
    <g:each var="domain" in="${StackOverflowAPIConstants.domains}">
        <div style="border:2px solid black;padding:5px;margin:5px;">
            <h2>${domain}</h2>
            <g:each var="method" in="${StackOverflowAPIConstants.api}">
                <div style="border:2px solid black;padding:5px;margin:5px;">
                    <p>${method.key} = ${method.value}</p>
                    <g:if test="${method.key.contains('{id}')}">
                        <g:textField name="ident" required="true"/>
                    </g:if>
                    <g:else>
                        <g:textField name="ident" style="display:none;"/>
                    </g:else>
                    <g:actionSubmit value="${domain}_${method.key}" action="show"></g:actionSubmit>
                </div>
            </g:each>
        </div>
    </g:each>
</g:form>
</body>
</html>
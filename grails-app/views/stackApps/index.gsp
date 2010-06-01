%{--
  - Copyright (c) 2010.
  --}%

<%@ page import="org.kar.StackOverflowAPIConstants" contentType="text/html;charset=UTF-8" %>
<html>
<head><title>StackApps Demo</title></head>
<body>
<g:form id="myForm">
    <div style="border:2px solid black;padding:5px;margin:5px;">
        <g:each var="method" in="${StackOverflowAPIConstants.api}">
            <div style="border:2px solid black;padding:5px;margin:5px;">
                <p><g:link url="http://api.stackoverflow.com/0.8/help/method?method=${method.key[1..-1]}">${method.key}</g:link> = ${method.value}</p>
                <g:if test="${method.key.contains('{id}')}">
                    <g:textField name="ident" required="true"/>
                </g:if>
                <g:else>
                    <g:textField name="ident" style="display:none;"/>
                </g:else>
                <g:each var="domain" in="${StackOverflowAPIConstants.domains}">
                    <g:actionSubmit value="${domain}_${method.key}" action="show" name="${domain}_${method.key}"/>
                </g:each>
            </div>
        </g:each>
    </div>
</g:form>
</body>
</html>
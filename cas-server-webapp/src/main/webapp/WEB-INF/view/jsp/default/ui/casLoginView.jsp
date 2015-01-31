<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page session="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% 
	String bossUrl = com.appleframework.config.core.PropertyConfigurer.getValue("boss.url");
 %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>广联赛讯运营平台</title>
	<link href='<c:url value="css/login.css" />' rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src='<c:url value="js/jquery-1.8.3.min.js" />' /></script>
	<script type="text/javascript" src='<c:url value="js/login.js" />' /></script>
	
	<script type="text/javascript">

	if (window.frames.length != parent.frames.length) {
		top.location = "<%=bossUrl%>";
	}

	</script>
</head>

<body>
<!-- start of login_warp -->
<div class="login_warp">
    <!-- start of 登录 -->
    <div class="login_con">
        <div class="login_top"><h1 class="login_tit">广联支撑平台</h1></div>
        <div class="login_mod">
            <form:form method="post" id="fm1" cssClass="fm-v clearfix login_form" commandName="${commandName}" htmlEscape="true">
                <p>
                	<c:if test="${not empty sessionScope.openIdLocalId}">
						<strong>${sessionScope.openIdLocalId}</strong>
						<input type="hidden" id="username" name="username" value="${sessionScope.openIdLocalId}" />
					</c:if>
	
					<c:if test="${empty sessionScope.openIdLocalId}">
						<spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
						<form:input name="username" id="username" cssClass="required in_text auto_hint" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="false" htmlEscape="true" value="${credentials.username}" />
					</c:if>
                </p>
                <p>
              		<spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
					<form:password name="password" id="password" path="password" size="25" tabindex="2" cssClass="in_text" accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
                </p>
                <p>
                    <input name="j_captcha_response" class="in_text auto_hint" type="text" style="width:211px;">
                    <span class="code"><img src="captcha.htm"></span>
                    <span class="tips clearfix"><em class="right"><a href="#" onclick="javascript:window.location.reload();">看不清楚？换一个</a></em>按右图填写，不区分大小写</span>
                </p>
                <p class="loginMsg" id="loginMsg">
                	<form:errors path="*" id="msg" cssClass="errors" element="span" value="请输入用户名和密码" />
                </p>
                <p>
                	<input type="hidden" name="lt" value="${loginTicket}" />
					<input type="hidden" name="execution" value="${flowExecutionKey}" />
					<input type="hidden" name="_eventId" value="submit" />
                	<input class="btn_login" name="" type="submit" value="立即登录">
                </p>
            </form:form>
        </div>
        <div class="login_bottom"></div>
    </div>
    <!-- end of 登录 -->
</div>
<!-- end of login_warp -->

</body>
</html>


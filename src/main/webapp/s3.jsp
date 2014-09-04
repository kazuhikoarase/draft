<%@page import="s3.app.MessagePrinter" %>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%
ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
MessagePrinter printer = context.getBean(MessagePrinter.class);
printer.printMessage();
%>

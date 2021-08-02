<%@ page isELIgnored="false"  %>
<%@page import="org.springframework.security.core.context.*, org.springframework.security.core.*" %>

<%
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
String name = auth.getName();
%>

  <h1 style="color:red;text-align:center"> The user <%=name%>  ::: Access defined</h1>
   <br>
  <a  href="welcome">home</a>
  <br>
  <a  href="./logout">Logout</a>
  
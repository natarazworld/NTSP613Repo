<%@ page isELIgnored="false" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<head>
  <title><tiles:insertAttribute name="title" /> </title>
</head>
<table border="0" width="100%"  height="100%"  rows="3" cols="2"  bgcolor="pink">
  <tr height="30%" bgcolor="cyan">
     <td colspan="2"><tiles:insertAttribute name="header"/>  </td>
  </tr>
  <tr height="60%"  bgcolor="skyblue">
     <td width="30%"><tiles:insertAttribute name="menu"/>  </td>
     <td width="70%"><tiles:insertAttribute name="body"/>  </td>
  </tr>
  <tr height="10%" bgcolor="grey">
     <td colspan="2"><tiles:insertAttribute name="footer"/>  </td>
  </tr>
</table>
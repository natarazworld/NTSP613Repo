<%@ page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
  <b>list_countries.jsp</b> <br>
<c:choose>   <%--- it is switch --%>
   <c:when test="${!empty countriesInfo}">  <%--  if condition1 /case1 --%>
   
     <h1 style="color:red;text-align:center">All countries  are on date :: ${sysDate} </h1>
       <c:forEach var="country"  items="${countriesInfo}">    <%-- enhanced for loop --%>
               <li><b>${country}</b> </li>
       </c:forEach>
       
   </c:when>
   
   <c:otherwise>   <%--  else condition or default --%>
       <h1 style="color:red;text-align:center">Not able to retrieve the countries </h1>
   </c:otherwise>
   
</c:choose>

<br>  Model data ::  <b>${sysDate }</b> &nbsp;&nbsp;&nbsp; <b>${requestScope.sysDate }</b> &nbsp;&nbsp;&nbsp;
<%=request.getAttribute("sysDate") %>

<br>
<a href="welcome">home</a>
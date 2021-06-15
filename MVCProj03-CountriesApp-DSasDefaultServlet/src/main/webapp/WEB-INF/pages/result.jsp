<%@ page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:choose>   <%--- it is switch --%>
   <c:when test="${!empty countriesInfo}">  <%--  if condition1 /case1 --%>
   
     <h1 style="color:red;text-align:center">All countries  are </h1>
       <c:forEach var="country"  items="${countriesInfo}">    <%-- enhanced for loop --%>
               <li><b>${country}</b> </li>
       </c:forEach>
       
   </c:when>
   
   <c:otherwise>   <%--  else condition or default --%>
       <h1 style="color:red;text-align:center">Not able to retrieve the countries </h1>
   </c:otherwise>
   
</c:choose>

<br>
<a href="welcome">home</a>
<%@ page isELIgnored="false" %>
 <%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%@taglib  uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
 
  <c:choose>
     <c:when test="${!empty listFiles}">
       <table border="1"  align="center">
         <c:forEach var="fname" items="${listFiles}">
             <tr>
               <td> ${fn:substringAfter(fname,"E:\\store\\")}</td>
               <td><a href='download?fileName=${fn:replace(fname,"\\","/")}'>download</a> </td>
             </tr> 
         </c:forEach>
     </table>
     </c:when>
      <c:otherwise>
            <h1 style="color:red;text-align:center">No files are found </h1>
      </c:otherwise>
  </c:choose>


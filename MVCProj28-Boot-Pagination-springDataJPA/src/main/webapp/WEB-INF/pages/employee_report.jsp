<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:choose>
   <c:when test="${!empty pageData}">
      <h1 style="color:green;text-align:center">Emp Details --- page Number ${pageData.getNumber()+1} of ${pageData.getTotalPages() } pages.   </h1>
      <table border="1"  align="center"  bgcolor="pink">
       <tr  bgcolor="cyan"><th>empno</th><th>emp name </th><th>Desg </th><th>salary </th><th>DeptNo </th> </tr>
       <tr>
         <c:forEach var="emp" items="${pageData.getContent()}">
             <tr>
                <td>${emp.empno } </td>
                <td>${emp.ename } </td>
                <td>${emp.job } </td>
                <td>${emp.sal } </td>
                <td>${emp.deptno } </td>
             </tr>
         </c:forEach>
       </tr>
      </table>
      <center>
       <c:if test="${!pageData.isFirst()}">
        <a href="report?page=0&size=${psize}">first</a> &nbsp;&nbsp;
       </c:if>
       <c:if test="${!pageData.isLast()}">
        <a href="report?page=${pageData.getNumber()+1}&size=${psize}">next</a> &nbsp;&nbsp;
        </c:if>
        <c:forEach var="i"  begin="0" end="${pageData.getTotalPages()-1}"  step="1">
               [<a href="report?page=${i}&size=${psize}">${i+1}</a>]   
        </c:forEach>
         <c:if test="${!pageData.isFirst()}">
        <a href="report?page=${pageData.getNumber()-1}&size=${psize}">previous</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${!pageData.isLast()}">
         <a href="report?page=${pageData.getTotalPages()-1}&size=${psize}">last</a>
         </c:if> 
        </center>
   </c:when>
   
    <c:otherwise>
              <h1 style="color:red;text-align:center"> No records found </h1>
    </c:otherwise>
</c:choose>
<br><br>
 <a href="./">home</a>


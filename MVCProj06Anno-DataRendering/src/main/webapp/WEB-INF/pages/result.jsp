<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

  <b>Data1:: ${data1}</b> <br>
  <b>Data2(array):: </b> <br>
     <c:forEach var="e"  items="${data2}">
             ${e},  
     </c:forEach>
     <br>
  <b>Data3(list):: ${data3}</b> <br>
  <b>Data4(set):: ${data4}</b> <br>
  <b>Data5(map):: ${data5}</b> <br>
     <c:forEach var="map"  items="${data5}">
          ${map.key}  --->  ${map.value} ,
     </c:forEach>
   <br>
  <b>Data 6 (ListDTO)</b> <br>
   <table border="1"  align="left" bgcolor="cyan">
   <tr> <th>sno</th><th>sname</th> <th>sadd </th> <th>avg </th>
      <c:if test="${!empty  data6}">
         <c:forEach var="dto"  items="${data6}">
          <tr>
             <td>${dto.sno } </td>
             <td>${dto.sname } </td>
             <td>${dto.sadd } </td>
             <td>${dto.avg } </td>
          </tr>
          </c:forEach>
      </c:if>
   
   </table>
  
  
  
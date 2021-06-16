<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"/>

 <div class="container  col-sm-4" style="background:pink">
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
   <table class="table table-hover " border="1">
   <tr  class="bg-danger"> <th>sno</th><th>sname</th> <th>sadd </th> <th>avg </th> </tr>
      <c:if test="${!empty  data6}">
         <c:forEach var="dto"  items="${data6}">
          <tr class="bg-success">
             <td>${dto.sno } </td>
             <td>${dto.sname } </td>
             <td>${dto.sadd } </td>
             <td>${dto.avg } </td>
          </tr>
          </c:forEach>
      </c:if>
   
   </table>
  
  </div>
  
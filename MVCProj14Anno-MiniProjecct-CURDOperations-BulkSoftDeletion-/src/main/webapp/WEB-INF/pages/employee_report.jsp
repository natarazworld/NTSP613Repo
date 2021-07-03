<%@ page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<h1 style="color:red;text-align:center">Employees Report</h1>
<script language="JavaScript">
 function sendRequest(){
	 var flag=confirm('are u sure that u want to delete?');
	  if(flag){
		  frm.submit();
	  }
	  return flag;
 }

</script>

<blink></blink><h1 style="Color:pink;text-align:center">${resultMsg} </h1></blink> <br><br>
<c:choose>
    <c:when test="${!empty empsList }">
       <table align="center" border="1"  bgcolor="cyan" >
         <form  name="frm" action="employee_delete"  onsubmit="return sendRequest()">
          <tr bgcolor="red" ><th>empNo </th><th>empName </th><th>job </th>
          <th>salary </th><th>operation1 </th><th><input  type="submit" value="delete">  </th></tr>
      
          <c:forEach var="emp" items="${empsList}">
              <tr>
                <td> ${emp.empNo} </td>
                <td> ${emp.ename} </td>
                <td> ${emp.job} </td>
                <td> ${emp.sal} </td>
                <td> <a href="employee_edit?eno=${emp.empNo}"> <img src="resources/images/edit.png" width="50" height="50"></a>  </td>
                 <td> <input type="checkbox" name="delEno" value="${emp.empNo}"/> </td> 
              </tr>
          </c:forEach>
          </form>
       </table>
       </c:when>
      <c:otherwise>
           <h1 style="color:red;text-align:center">Records not found </h1>
      </c:otherwise>
    </c:choose>
    
    <br><bR>
     <blink> <h1 style="Color:pink;text-align:center">${resultMsg} </h1> </blink>





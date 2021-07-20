<%@ page isELIgnored="false"  %>
<%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1 style="color:red;text-align:center"> Login Page</h1>

 <form:form  modelAttribute="userForm">
     <table border="1" align="center"  bgcolor="cyan">
        <tr>
           <td>Username::   </td>
           <td><form:input path="username"/> </td>
        </tr>
          <tr>
           <td>Password::   </td>
           <td><form:input path="password"/> </td>
        </tr>
         <tr>
           <td colspan="2"><input type="Submit" value="login"/> </td>
        </tr>
     </table>
 </form:form>
  <c:if test="${!empty resultMsg}">
     <h1 style="color:red;text-align:center">${resultMsg} </h1>
  </c:if>


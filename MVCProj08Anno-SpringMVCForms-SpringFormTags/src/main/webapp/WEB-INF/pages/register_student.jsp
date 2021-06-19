<%@page isELIgnored="false"   %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<h1 style="color:red;text-align:center">Student registration form</h1>
<table border="1" align="center" bgcolor="cyan">
   <form:form modelAttribute="stud">
      <tr>
        <td>Student id::  </td>
        <td><form:input path="sno"/> </td>
      </tr>
      <tr>
        <td>Student name::  </td>
        <td> <form:input path="sname"/></td>
      </tr>
      <tr>
        <td>Student avg::  </td>
        <td><form:input path="avg"/> </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit"  value="register">  </td>
      </tr>
</form:form>
</table>
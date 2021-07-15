<%@ page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>


<h1 style="color:red;text-align:center">Edit Employee details</h1>

<table border="1"  align="center" bgcolor="cyan">
   <form:form modelAttribute="emp">
      <tr>
        <td> Employee number::  </td>
        <td> <form:input path="empNo" readonly="true" cssStyle="color:red;background-color:lightgrey"/> </td>
      </tr>
      <tr>
        <td> Employee name::  </td>
        <td> <form:input path="ename" /> </td>
      </tr>
      <tr>
        <td> Employee Desg::  </td>
        <td> <form:input path="job" /> </td>
      </tr>
      <tr>
        <td> Employee salary::  </td>
        <td> <form:input path="sal" /> </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="Edit Employee"></td>
      </tr>
   </form:form>
</table>


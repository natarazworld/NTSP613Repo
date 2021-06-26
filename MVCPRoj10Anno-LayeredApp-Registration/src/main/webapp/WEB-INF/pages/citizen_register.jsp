<%@ page  isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color:red;text-align=center">Citizen Registration form for Vaccination </h1>
 <form:form   method="POST" modelAttribute="citizen">
   
   <table  border="1"  align="center" bgcolor="cyan">
      <tr>
         <td> Name::  </td>
         <td> <form:input path="name"/>  </td>
      </tr>
      <tr>
         <td> Addrs::  </td>
         <td> <form:input path="addrs"/>  </td>
      </tr>
      <tr>
         <td> aadharNo::  </td>
         <td> <form:input path="aadharNo"/>  </td>
      </tr>
      <tr>
         <td> Vacine name::  </td>
         <td> <form:select path="vaccineName">
                     <form:option value="">--select a value----</form:option>
                      <form:option value="COVAXINE">COVAXINE-INDIA</form:option>
                      <form:option value="COVISHIELD">COVISHIELD-BRITAN</form:option>
                      <form:option value="SPUTNIK">SPUTNIK-RUSSIA</form:option>
                      <form:option value="PYZER">PYZER-USA</form:option>
               </form:select> </td>
      </tr>
      <tr>
         <td> Income of the Year::  </td>
         <td> <form:input path="income"/>   </td>
      </tr>
      <tr>
         <td colspan="2" align="center"> <input type="submit"  value="register">   </td>
      </tr>
      </table>
 </form:form>
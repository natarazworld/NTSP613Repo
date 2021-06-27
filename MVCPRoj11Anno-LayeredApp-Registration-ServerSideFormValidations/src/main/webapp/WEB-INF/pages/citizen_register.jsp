<%@ page  isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

 <script type="text/javascript"  src="resources/js/validation.js">
      
</script>

<h1 style="color:red;text-align=center">Citizen Registration form for Vaccination </h1>
 <form:form   method="POST" modelAttribute="citizen"  onsubmit="return validate(this)">
  <%-- <p style="color:red;text-align:center">
          <form:errors  path="*"/>
    </p> --%>
   <table  border="1"  align="center" bgcolor="cyan">
      <tr>
         <td> Name::  </td>
         <td> <form:input path="name"/> <form:errors path="name"  cssStyle="color:red"  /><span id="nameErr" style="color:red"></span> </td>
      </tr>
      <tr>
         <td> Addrs::  </td>
         <td> <form:input path="addrs"/>  <form:errors path="addrs"  cssStyle="color:red"/> <span id="addrsErr" style="color:red"></span> </td>
      </tr>
      <tr>
         <td> aadharNo::  </td>
         <td> <form:input path="aadharNo"/> <form:errors path="aadharNo"  cssStyle="color:red"/> <span id="aadharNoErr" style="color:red"></span> </td>
      </tr>
      <tr>
         <td> Vacine name::  </td>
         <td> <form:select path="vaccineName">
                     <form:option value="">--select a value----</form:option>
                      <form:option value="COVAXINE">COVAXINE-INDIA</form:option>
                      <form:option value="COVISHIELD">COVISHIELD-BRITAN</form:option>
                      <form:option value="SPUTNIK">SPUTNIK-RUSSIA</form:option>
                      <form:option value="PYZER">PYZER-USA</form:option>
               </form:select> <form:errors path="vaccineName"  cssStyle="color:red"/> <span id="vaccineNameErr" style="color:red"></span>  </td>
      </tr>
      <tr>
         <td> Income of the Year::  </td>
         <td> <form:input path="income"/> <form:errors path="income"  cssStyle="color:red"/> <span id="incomeErr" style="color:red"></span>  </td>
      </tr>
      <tr>
         <td colspan="2" align="center"> <input type="submit"  value="register">   </td>
      </tr>
      </table>
 </form:form>
<%@ page  isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<link rel="stylesheet" href="resources/css/styles.css">
 <script type="text/javascript"  src="resources/js/validation.js">
</script>

<body>
<h1 style="text-align:center">Citizen Registration form for Vaccination </h1>
 <form:form name="frm"  method="POST" modelAttribute="citizen"  onsubmit="return validate(this)">
  <%-- <p style="color:red;text-align:center">
          <form:errors  path="*"/>
    </p> --%>
   <table  border="1"  align="center" bgcolor="cyan">
      <tr>
         <td> Name::  </td>
         <td> <form:input path="name"/> <form:errors path="name"    /><span id="nameErr" ></span> </td>
      </tr>
      <tr>
         <td> Addrs::  </td>
         <td> <form:input path="addrs"/>  <form:errors path="addrs"  /> <span id="addrsErr" ></span> </td>
      </tr>
      <tr>
         <td> aadharNo::  </td>
         <td> <form:input path="aadharNo"/> <form:errors path="aadharNo"  /> <span id="aadharNoErr" ></span> </td>
      </tr>
      <tr>
         <td> Vacine name::  </td>
         <td> <form:select path="vaccineName"  >
                       <form:option value="">--select a value--</form:option>
                    <form:options items="${vaccinesBunch}"/>
               </form:select> <form:errors path="vaccineName"  /> <span id="vaccineNameErr" ></span>  </td>
      </tr>
     
         <td> Income of the Year::  </td>
         <td> <form:input path="income"/> <form:errors path="income"  /> <span id="incomeErr" ></span>  </td>
      </tr>
      
       <td>DOB::  </td>
         <td> <form:input path="dob"/> <form:errors path="*" />(yyyy-MM-dd) <span id="dobErr" ></span>  </td>
      </tr>
      
       <td>DOV::  </td>
         <td> <form:input  path="dov"/> <form:errors path="*" />(yyyy-MM-dd) <span id="dovErr" ></span>  </td>
      </tr>
      
      <td>DOM::  </td>
         <td> <form:input type="date"  path="dom"/> (internally yyyy-MM-dd) <form:errors path="*" /> <span id="dovErr" ></span>  </td>
      </tr>
        
      
        <tr>
         <td colspan="2" align="center"> <form:input type="hidden" path="vflag"/>   </td>
      </tr>
      <tr>
         <td colspan="2" align="center"> <input type="submit"  value="register">   </td>
      </tr>
    
      </table>
 </form:form>
 </body>
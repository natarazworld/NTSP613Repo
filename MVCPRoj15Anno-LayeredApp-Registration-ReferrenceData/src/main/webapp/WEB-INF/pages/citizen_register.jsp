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
      
        <script  language="JavaScript">
           function sendRequest(){
        	   frm.action="states";
        	   frm.submit();   
           }
        
        </script>
      <tr>
         <td> Select Country::  </td>
         <td> <form:select path="country"  onchange="sendRequest()" >
                       <form:option value="">--select a value--</form:option>
                    <form:options items="${countriesInfo}"/>
               </form:select> <form:errors path="country"  /> <span id="countryErr" ></span>  </td>
      </tr>
      
      <tr>
         <td> Select state::  </td>
         <td> <form:select path="state">
                       <form:option value="">--select a value--</form:option>
                    <form:options items="${statesInfo}"/>
               </form:select> <form:errors path="state"  /> <span id="stateErr" ></span>  </td>
      </tr>
      
      <tr>
         <td> Select Languages::  </td>
         <td> <form:select path="languages"  multiple="multiple" >
                       <form:option value="">--select a value--</form:option>
                    <form:options items="${languagesInfo}"/>
               </form:select> <form:errors path="languages"  /> <span id="languagesErr" ></span>  </td>
      </tr>
       <tr>
         <td> Select hobies::  </td>
         <td><form:checkboxes items="${hobiesInfo}" path="hobies"/>   <form:errors path="languages"  /> <span id="languagesErr" ></span>  </td>
      </tr>
      <tr>
         <td> Income of the Year::  </td>
         <td> <form:input path="income"/> <form:errors path="income"  /> <span id="incomeErr" ></span>  </td>
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
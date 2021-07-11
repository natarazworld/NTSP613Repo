<%@ page  isELIgnored="false"  contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<h1 style="color:red;text-align=center"><spring:message code="regPage.title"/> </h1>
 <form:form   method="POST" modelAttribute="citizen">
   
   <table  border="1"  align="center" bgcolor="cyan">
      <tr>
         <td> <spring:message code="regPage.name"/>  </td>
         <td> <form:input path="name"/>  </td>
      </tr>
      <tr>
         <td> <spring:message code="regPage.addrs"/>  </td>
         <td> <form:input path="addrs"/>  </td>
      </tr>
      <tr>
         <td> <spring:message code="regPage.aadharNo"/>  </td>
         <td> <form:input path="aadharNo"/>  </td>
      </tr>
      <tr>
         <td> <spring:message code="regPage.vaccineName"/>  </td>
         <td> <form:select path="vaccineName">
                     <form:option value="">--select a value----</form:option>
                      <form:option value="COVAXINE">COVAXINE-INDIA</form:option>
                      <form:option value="COVISHIELD">COVISHIELD-BRITAN</form:option>
                      <form:option value="SPUTNIK">SPUTNIK-RUSSIA</form:option>
                      <form:option value="PYZER">PYZER-USA</form:option>
               </form:select> </td>
      </tr>
      <tr>
         <td> <spring:message code="regPage.income"/>  </td>
         <td> <form:input path="income"/>   </td>
      </tr>
      <tr>
         <td colspan="2" align="center"> <input type="submit"  value="<spring:message code="regPage.submit"/>">   </td>
      </tr>
      </table>
 </form:form>
 <br><br>
  <p style="text-align: center">
     <a href="?lang=en">english</a>  &nbsp;&nbsp;&nbsp;
     <a href="?lang=de_DE">German</a>  &nbsp;&nbsp;&nbsp;
     <a href="?lang=fr_FR"> French</a>  &nbsp;&nbsp;&nbsp;
     <a href="?lang=hi_IN"> Hindi</a>  &nbsp;&nbsp;&nbsp;
  </p>
 
 
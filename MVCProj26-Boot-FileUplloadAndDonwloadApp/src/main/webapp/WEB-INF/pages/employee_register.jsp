<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color:blue;text-align:center"> File Uploading Activity </h1>
<form:form modelAttribute="empForm"  enctype="multipart/form-data">
   <table boder="1" bgcolor="cyan"  align="center"> 
          <tr> 
              <td> employee name:: </td>
              <td><form:input  path="ename"/></td>
           </tr>
           <tr> 
              <td> employee address:: </td>
              <td><form:input  path="addrs"/></td>
           </tr>
           <tr> 
              <td> Select  resume file:: </td>
              <td><form:input type="file"  path="resume"/></td>
           </tr>
           <tr> 
              <td> Select  photo file:: </td>
              <td><form:input type="file"  path="photo"/></td>
           </tr>
               <tr> 
              <td colspan="2"> <input type="submit"  value="upload"> </td>
           </tr>
   </table>
</form:form>


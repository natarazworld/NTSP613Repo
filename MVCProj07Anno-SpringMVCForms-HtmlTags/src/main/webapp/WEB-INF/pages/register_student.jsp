<%@page isELIgnored="false"   %>

<h1 style="color:red;text-align:center">Student registration form</h1>
<table border="1" align="center" bgcolor="cyan">
   <form  method="POST">
      <tr>
        <td>Student id::  </td>
        <td><input type="text" name="sno"> </td>
      </tr>
      <tr>
        <td>Student name::  </td>
        <td><input type="text" name="sname"> </td>
      </tr>
      <tr>
        <td>Student avg::  </td>
        <td><input type="text" name="avg"> </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit"  value="register">  </td>
      </tr>
</form>
</table>
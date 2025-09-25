<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>

<form:form  action="saveEmployee"  method="post"  modelAttribute="empModel">
 <table>
   <tr>
     <td> TASK NO </td> <td> <form:input path="empno"/> </td>
   </tr>
   <tr>
     <td> TASK NAME  </td> <td> <form:input path="ename"/> </td>
   </tr>
   <tr>
     <td> DATE   </td> <td> <form:input path="sal"/> </td>
   </tr>
   <tr>
     <td> ASSIGN TO  </td> <td> <form:input path="deptno"/> </td>
   </tr>     
   <tr>
      <td  colspan="2"> <input type="submit"  value="SUBMIT"> </td>
   </tr>
 </table>

</form:form>
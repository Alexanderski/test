<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Marks</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  </head>
  <body>
  <jsp:useBean id="obj" class="com.example.demo.dto.MarkDto" scope="page"/>
    <h1>View All Marks</h1>
<br/><br/>
    <div>
      <table border="5">
        <tr>
          <th>Marks</th>
          <th>Functions</th>
        </tr>
        <c:forEach  items="${marks}" var ="mark">
        <tr>
          <td>${mark.name}</td>
          <td>
          <select>
              <c:forEach var="model" items="${mark.models}">
               <option>${model.name}</option>
              </c:forEach>
          </select>
          <a href="http://localhost:8080/get-mark-with-models?id=${mark.id}"><input type="button" value="Models"><a></a>
          </td>
          <td>
          <a href="http://localhost:8080/get-all-stores"><input type="button" value="Stores"><a></a>
          </td>
          <td>
          <a href="http://localhost:8080/add-new-mark"><input type="button" value="Add"><a></a>
          </td>
          <td>
          <a href="http://localhost:8080/update-mark?id=${mark.id}"><input type="button" value="Update"><a></a>
          </td>
           <td>
           <a href="http://localhost:8080/delete?id=${mark.id}"><input type="button" value="Delete"><a></a>
           </td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </body>

</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Models</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  </head>
  <body>
    <h1>View All Marks</h1>
<br/><br/>
    <div>
      <table border="1">
        <tr>
          <th>Models</th>
        </tr>
        <c:forEach  items="${mark.models}" var ="model">
        <tr>
          <td>${model.name}</td>

          <td>
          <a href="http://localhost:8080/update-model?id=${model.id}"><input type="button" value="Update"><a></a>
          </td>
          <td>
          <a href="http://localhost:8080/delete-model?id=${model.id}"><input type="button" value="Delete"><a></a>
          </td>

        </tr>
        </c:forEach>
        <td>
        <a href="http://localhost:8080/get-all-marks"><input type="button" value="Back"><a></a>
        <a href="http://localhost:8080/add-new-model"><input type="button" value="Add"><a></a>
        </td>
      </table>
    </div>
  </body>

</html>
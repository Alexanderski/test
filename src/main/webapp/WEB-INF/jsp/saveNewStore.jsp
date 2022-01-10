<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Mark</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  </head>
  <body>
      <%--@elvariable id="store" type="java"--%>
      <form:form method="POST" action="/save-store"
        modelAttribute="store">
        <table>
        <tr>
          <td><form:label path="name">Name</form:label></td>
          <td><form:input path="name" /></td>
          <td><form:label path="id" cssStyle="display:none">Id</form:label></td>
          <td><form:input path="id" cssStyle="display:none" /></td>

          <td><form:label path="mark_id" >mark_id</form:label></td>
          <td><form:input path="mark_id" value="${store.mark_id}"/></td>
        </tr>
        <tr>
          <td><input type="submit" value="Submit" /></td>
        </tr>
        </table>
        </form:form>
  <body>
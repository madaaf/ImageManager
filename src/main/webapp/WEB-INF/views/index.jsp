<%--
  Created by IntelliJ IDEA.
  User: excilys
  Date: 06/08/15
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thumbnail Generator</title>
</head>
<body>
  <h1>Thumbnail Generator</h1>
  <sf:form id="thumbnailRequestForm" action="/" method="post" modelAttribute="thumbnailDto">
    <label for="widthId">Width* </label><sf:input id="widthId" type="number" path="width"/><br />
    <label for="heightId">Height* </label><sf:input id="heightId" type="number" path="height"/><br />
    <label for="limitId">Limit </label><sf:input id="limitId" type="number" path="limit"/><br />
    <input type="submit" value="Process Thumbnails"/>
  </sf:form>
  <c:if test="${errors}"><div>Width and Height should be greater than 5.</div></c:if>
</body>
</html>

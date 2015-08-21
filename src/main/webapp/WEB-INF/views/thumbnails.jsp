<%--
  Created by IntelliJ IDEA.
  User: excilys
  Date: 06/08/15
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thumbnail Generator</title>
</head>
<body>
  <h1>Thumbnail Generator processed ${response.processed} items.</h1>
  <table>
    <thead>
      <tr>
        <th>Thumbnail</th>
        <th>File name</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="thumbnail" items="${response.thumbnails}">
        <tr>
          <td><img src="/thumbnails/${thumbnail}" alt="Super Hero"/></td>
          <td>${thumbnail}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>

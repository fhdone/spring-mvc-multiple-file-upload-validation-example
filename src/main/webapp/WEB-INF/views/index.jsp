<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC Upload Multiple Files</title>

    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

    <h1>Spring MVC Upload Multiple Files</h1>
    <form:form method="post" modelAttribute="multiFileModel" enctype="multipart/form-data" action="upload">

        <c:forEach var="f" varStatus="fi" items="${multiFileModel.files}">
            <c:set var="file" value="files[${fi.index}].file"/>
            Upload file: <form:input type="file" path="${file}" id="${file}"/>
            <form:errors path="${file}" cssClass="error"/>
            <br/>
        </c:forEach>
        <br/>

        <input type="submit" value="upload"/>

    </form:form>

    <a href="<c:url value='/'/>">Home</a>

</body>
</html>
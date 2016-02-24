<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Phonebook</title>

    <link rel="stylesheet" href="<c:url context="/" value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>">
    <link rel="stylesheet"
          href="<c:url context="/" value="/webjars/bootstrap-3-datepicker/1.5.0/dist/css/bootstrap-datepicker3.min.css"/>"/>
    <link rel="stylesheet" href="<c:url context="/" value="/resources/css/style.css"/>">

    <script src="<c:url context="/" value="/webjars/jquery/1.12.0/jquery.min.js"/>"></script>
    <script src="<c:url context="/" value="/webjars/bootstrap/3.3.6/js/bootstrap.js"/>"></script>

    <script src="<c:url context="/" value="/webjars/bootstrap-3-datepicker/1.5.0/dist/js/bootstrap-datepicker.min.js"/>"></script>
    <script src="<c:url context="/" value="/webjars/bootstrap-3-datepicker/1.5.0/dist/locales/bootstrap-datepicker.ru.min.js"/>"></script>

    <script src="<c:url context="/" value="/webjars/bootstrap3-typeahead/3.1.1/bootstrap3-typeahead.js"/>"></script>

    <script src="<c:url context="/" value="/webjars/bootbox/4.4.0/bootbox.js"/>"></script>
    <script src="<c:url context="/" value="/resources/js/phonebook.js"/>"></script>

</head>
<body>
<%@include file="/WEB-INF/views/include/menu.jsp" %>

<div class="container head">
    <div class="row">
        <form action="<c:url context="/" value="/employee/insert"/>" method="post">
            <input type="text">
        </form>
    </div>

    <hr>
    <%@include file="/WEB-INF/views/include/footer.jsp" %>
</div> <!-- /container -->

</body>
</html>
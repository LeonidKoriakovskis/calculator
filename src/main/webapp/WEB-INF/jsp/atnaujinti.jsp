<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Skaičiaus atnaujinimas</title>
    <jsp:include page="header.jsp"/>
    <style>
        form {
            margin-left: 20px;
        }
    </style>
</head>
<body>
    <form:form name="skaicius" action="/atnaujintiSkaiciu" method="post">
        <!-- id butina pateikti formoje, kitaip i back end nueis null. Todel darome hidden, kad neredaguotu -->
        <input type="hidden" name="id" value="${skaicius.id}" />

        Pirmas skaičius:<br>
        <input type="number" name="num1" value="${skaicius.num1}" /><br>

        Ženklas:<br>
        <input type="text" name="operation" value="${skaicius.operation}" /><br>

        Antras skaičius:<br>
        <input type="number" name="num2" value="${skaicius.num2}" /><br>

        Rezultatas:<br>
        <input type="number" name="result" value="${skaicius.result}" /><br>

        <input type="submit" value="Atnaujinti">
    </form:form>
</body>
</html>

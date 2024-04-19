<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
     <title>Skaičiai</title>
     <jsp:include page="header.jsp"/>
</head>
<body class="container">
    <div class="table-responsive">
        <table class="table table-striped">
            <tr>
                <th>Pirmas skaičius</th>
                <th>Ženklas</th>
                <th>Antras skaičius</th>
                <th>Rezultatas</th>
                <th>Veiksmas</th>
            </tr>

            <!-- iteruoja per visa skaiciu sarasa -->
            <c:forEach var="skaicius" items="${skaiciai}">

                 <!-- konstruoja iraso atnaujinimo adresa su skaiciais id -->
                 <c:url var="atnaujinti" value="/atnaujinti">
                      <c:param name="id" value="${skaicius.id}" />
                 </c:url>

                 <!-- konstruoja iraso trynimo adresa su skaiciais id -->
                 <c:url var="trinti" value="/trinti">
                      <c:param name="id" value="${skaicius.id}" />
                 </c:url>

                 <!-- konstruoja iraso perziuros adresa su skaiciaus id -->
                 <c:url var="rodyti" value="/rodyti">
                      <c:param name="id" value="${skaicius.id}" />
                 </c:url>

                 <tr>
                     <td>${skaicius.num1}</td>
                     <td>${skaicius.operation}</td>
                     <td>${skaicius.num2}</td>
                     <td>${skaicius.result}</td>

                     <td>
                         <!-- atvaizduoti atnaujinimo adresa --> <a href="${atnaujinti}">Keisti</a>
                         |  <a href="${trinti}"
                              onclick="if (!(confirm('Ar tikrai norite ištrinti šį įrašą?'))) return false">Trinti</a>
                         |  <!-- atvaizduoti rodymo adresa -->  <a href="${rodyti}">Rodyti</a>
                     </td>

                 </tr>

               </c:forEach>

              </table>
        </div>
</body>
</html>




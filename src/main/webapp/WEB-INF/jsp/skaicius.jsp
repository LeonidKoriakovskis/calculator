<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
     <head>
           <title>Skaičius</title>
           <jsp:include page="header.jsp"/>
     </head>
     <body class="container">
          <div class="table-responsive">
               <caption>Skaičiaus informacija</caption>
               <table class="table table-striped">
                    <tr>
                           <td><b>Id:</b></td>
                           <td>${skaicius.id}</td>
                    </tr>
                    <tr>
                           <td><b>Pirmas skaičius:</b></td>
                           <td>${skaicius.num1}</td>
                    </tr>
                    <tr>
                           <td><b>ženklas:</b></td>
                           <td>${skaicius.operation}</td>
                    </tr>
                    <tr>
                           <td><b>Antras skaičius:</b></td>
                           <td>${skaicius.num2}</td>
                    <tr>
                           <td><b>Rezultatas:</b></td>
                           <td>${skaicius.result}</td>
                    </tr>
               </table>
          </div>
          <br>
          <a type="button" href="${pageContext.request.contextPath}/skaiciai" class="button">Atgal</a>
     </body>
</html>
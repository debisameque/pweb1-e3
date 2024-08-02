<%@ page import="modelo.categoria.Categoria" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt">

<head>
    <meta charset="UTF-8">
    <title>Buscar Categoria</title>
</head>
<body>
<%  
    List<Categoria> categorias = (List<Categoria>)request.getAttribute("categorias");
    for (int i = 0; i < categorias.size(); i++) {
             Categoria categoria = categorias.get(i); %>
             <div class="mensagem">
                <%= categoria.getNome()%>
            </div>
            <% } 
     %>
        <button onclick="location.href='index.jsp'">Voltar</button>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Página Principal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        button {
            margin: 10px;
            padding: 15px 30px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <h1>Página Principal</h1>
    <button onclick="location.href='inserirCat.jsp'">Inserir Categoria</button>
    <button onclick="location.href='obterCat.jsp'">Buscar Categoria</button>
    <button onclick="location.href='atualizarCat.jsp'">Editar Categoria</button>
    <button onclick="location.href='removerCat.jsp'">Remover Categoria</button>
    <button onclick="location.href='obterTodasCat.jsp'">Mostrar Todas</button>
</body>
</html>

<%@include file="rodape.jsp" %>

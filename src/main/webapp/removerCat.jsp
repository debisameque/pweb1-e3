<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Remover Categoria</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        form {
            display: flex;
            flex-direction: column;
            width: 300px;
        }
        label, input {
            margin-bottom: 10px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <h1>Remover Categoria</h1>
    <form action="RemoverCategoria" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required>

        <button type="submit">Remover</button>
    </form>
    <button onclick="location.href='index.jsp'">Voltar</button>
</body>
<% if (request.getParameter("removendoCategoria") !=null) { %>
    <div class="mensagem">
        <%= (Boolean.parseBoolean(request.getParameter("removendoCategoria")) ? "Categoria removida com sucesso"
            : "Não foi possível remover a categoria" )%>
    </div>
    <% } %>
</html>

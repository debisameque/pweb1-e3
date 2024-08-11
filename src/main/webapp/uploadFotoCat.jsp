<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload de Fotos da Categoria</title>
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
<form method="post" enctype="multipart/form-data"
action="UploadFotoCategoria">
<label for="id">ID da Categoria:</label>
<input type="text" id="id" name="id" required>
Foto da Categoria: <input type="file" name="foto" /><br/>
<input type="submit" value="Enviar" />
</form>
</body>
<% if (request.getParameter("nome") !=null) { %>
    <div class="mensagem">
        <%= request.getParameter("nome")%>
    </div>
    <% } %>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buscar Categoria</title>
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
    <h1>Consultar Categoria</h1>
    <form action="ObterCategoria" method="post">
        <label for="id">ID da Categoria:</label>
        <input type="text" id="id" name="id" required>
        <button type="submit">Consultar</button>
    </form>
</body>
</html>

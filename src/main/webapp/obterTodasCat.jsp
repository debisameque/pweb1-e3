<!DOCTYPE html>
<html lang="pt">

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

        label,
        input {
            margin-bottom: 10px;
        }

        button {
            padding: 10px 20px;
            font-size: 16px;
        }
    </style>
</head>

<body>
    <h1>Obter Todas as Categorias</h1>
    <form action="ObterTodasCategoria" method="post">
        <button type="submit">Consultar</button>
    </form>
    <button onclick="location.href='index.jsp'">Voltar</button>
</body>

</html>
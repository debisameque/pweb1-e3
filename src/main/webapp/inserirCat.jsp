<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@include file="cabecalho.jsp" %>

        <head>
            <meta charset="UTF-8">
            <title>Inserir Categoria</title>
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
            <h1>Cadastrar Categoria</h1>
            <form action="InserirCategoria" method="post">
                    <label for="exampleFormControlInput1">Nome</label>
                    <input type="text" name="nome" id="exampleFormControlInput1">
                    <label for="exampleFormControlInput2">Descrição</label>
                    <input type="text" name="descricao" id="exampleFormControlInput2">
                <button type="submit">Cadastrar</button>
            </form>
        </body>
        <% if (request.getParameter("sucesso") !=null) { %>
            <div class="mensagem">
                <%= (Boolean.parseBoolean(request.getParameter("sucesso")) ? "Categoria cadastrada com sucesso"
                    : "Não foi possível cadastrar a categoria" )%>
            </div>
            <% } %>
                <%@include file="rodape.jsp" %>
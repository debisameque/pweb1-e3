
<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@include file="cabecalho.jsp" %>
    <!DOCTYPE html>
    <html lang="pt">
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
            <h1>Atualizar Categoria</h1>
            <form action="AtualizarCategoria" method="post">
                <label for="exampleFormControlInput0">id</label>
                <input type="text" name="id" id="exampleFormControlInput0">
                <label for="exampleFormControlInput1">Nome</label>
                <input type="text" name="nome" id="exampleFormControlInput1">
                <label for="exampleFormControlInput2">Descrição</label>
                <input type="text" name="descricao" id="exampleFormControlInput2">
                <button type="submit">Cadastrar</button>
            </form>
            <button onclick="location.href='index.jsp'">Voltar</button>
        </body>
        <% if (request.getParameter("sucesso") !=null) { %>
            <div class="mensagem">
                <%= (Boolean.parseBoolean(request.getParameter("sucesso")) ? "Categoria atualizada com sucesso"
                    : "Não foi possível atualizar a categoria" )%>
            </div>
            <% } %>
    </html>
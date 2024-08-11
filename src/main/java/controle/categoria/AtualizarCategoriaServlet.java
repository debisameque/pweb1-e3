package controle.categoria;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.categoria.CategoriaDAO;

public class AtualizarCategoriaServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //entrada
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        //processamento
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        int newId = Integer.parseInt(id);
        boolean sucesso = categoriaDAO.atualizarCategoria(newId, nome, descricao);
        //saída
        response.sendRedirect("atualizarCat.jsp?sucesso=" + sucesso);
        System.out.println("Categoria do id " + id + " foi atualizada com sucesso.");
    }
}

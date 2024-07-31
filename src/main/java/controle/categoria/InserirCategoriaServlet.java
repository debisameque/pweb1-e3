package controle.categoria;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.categoria.CategoriaDAO;


public class InserirCategoriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //entrada
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        //processamento
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        boolean sucesso = categoriaDAO.inserirCategoria(nome, descricao);
        //saída
        response.sendRedirect("inserirCat.jsp?sucesso=" + sucesso);
    }

}
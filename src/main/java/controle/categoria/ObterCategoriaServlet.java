package controle.categoria;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.categoria.Categoria;
import modelo.categoria.CategoriaDAO;

public class ObterCategoriaServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //entrada
        String id = request.getParameter("id");
        //processamento
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        int newId = Integer.parseInt(id);
        Categoria categoria = categoriaDAO.obterCategoria(newId);
        //saída
        //response.sendRedirect("obterCat.jsp?categoriaNome=" + categoria.getNome());
        System.out.println("A categoria do id "+ id + " é essa: " + categoria.getNome());
    }
}

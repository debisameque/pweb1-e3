package controle.categoria;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.categoria.CategoriaDAO;

public class RemoverCategoriaServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //entrada
        String id = request.getParameter("id");
        //processamento
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        int newId = Integer.parseInt(id);
        boolean removendoCategoria = categoriaDAO.removerCategoria(newId);
        //saída
        response.sendRedirect("removerCat.jsp?removendoCategoria=" + removendoCategoria);
        System.out.println("A categoria do id "+ id + " foi removida. ");
    }
}
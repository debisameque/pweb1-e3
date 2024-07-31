package controle.categoria;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.categoria.Categoria;
import modelo.categoria.CategoriaDAO;

public class ObterTodasCategoriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processamento
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ArrayList<Categoria> categorias = categoriaDAO.obterTodas();
        //saída
        //response.sendRedirect("obterCat.jsp?categoriaNome=" + categoria.getNome());
        System.out.println(categorias.size());
        System.out.println(categorias.get(0).getNome());
        System.out.println(categorias.get(1).getNome());
        System.out.println(categorias.get(2).getNome());
        System.out.println(categorias.get(3).getNome());
        for (int i = 0; i < categorias.size()-1; i++) {
            Categoria categoria = categorias.get(i);
            System.out.println(categoria.getNome());
    }
}
}

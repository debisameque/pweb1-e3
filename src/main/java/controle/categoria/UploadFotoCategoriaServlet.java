package controle.categoria;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import modelo.categoria.CategoriaDAO;

public class UploadFotoCategoriaServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = -1;
        FileItem foto = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            boolean uploadSucesso = false;
            String mensagem = "";
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setRepository(new File("/Users/debisameque/Desktop/Upload" + File.separator + "temp"));
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
                Iterator<FileItem> iter = items.iterator();

                CategoriaDAO categoria = new CategoriaDAO();

                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (item.isFormField() && item.getFieldName().equals("id")) {
                        id = Integer.parseInt(item.getString());
                        System.out.println(id);
                    }
                    if (!item.isFormField() && item.getFieldName().equals("foto")
                            && item.getContentType().startsWith("image/")) {
                        foto = item;
                        System.out.println(foto);
                    }
                }

                if (id != -1 && foto != null) {
                    foto.write(new File("/Users/debisameque/Desktop/Upload" + File.separator + id
                            + foto.getName().substring(foto.getName().lastIndexOf("."))));
                    categoria.alterarFoto(id, id + foto.getName().substring(foto.getName().lastIndexOf(".")));
                    uploadSucesso = true;
                    System.out.println(uploadSucesso);
                }
                
                if (!uploadSucesso) {
                    mensagem = "Não foi possível fazer o upload da foto dessa categoria.";
                } else {
                    mensagem = "O upload da foto dessa categoria foi feito com sucesso.";
                }
            } catch (Exception ex) {
                mensagem = "Não foi possível fazer o upload da foto dessa categoria.";
            }
            response.sendRedirect("uploadFotoCat.jsp?nome=" + mensagem);
        }

    }
}
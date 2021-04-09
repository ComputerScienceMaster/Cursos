package Views;

import Controlers.PessoaJpaController;
import Models.Pessoa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CriarPessoa", urlPatterns = {"/CriarPessoa"})
public class CriarPessoa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          request.getRequestDispatcher("/CriarPessoa.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("nome");
        PessoaJpaController control = new PessoaJpaController(EmProvider.getInstance().getEntityManagerFactory());
        Pessoa p = new Pessoa();
        p.setName(name);
        control.create(p);
        request.getRequestDispatcher("/sucesso.html").forward(request, response);
    }
}

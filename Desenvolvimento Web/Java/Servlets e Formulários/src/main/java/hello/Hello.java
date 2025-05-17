package hello;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processar")
public class Hello extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Captura o valor do parâmetro "nome" enviado pelo formulário
        String nome = request.getParameter("nome");
        
        // Configura a resposta para ser HTML
        response.setContentType("text/html");
        
        // Escreve a resposta no navegador
        response.getWriter().println("<h1>Olá, " + nome + "!</h1>");
        response.getWriter().println("<p>Seu nome foi recebido com sucesso.</p>");
    }
}

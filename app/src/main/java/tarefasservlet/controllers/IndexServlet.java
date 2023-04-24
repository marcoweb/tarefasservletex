package tarefasservlet.controllers;

import java.util.Hashtable;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import tarefasservlet.models.Tarefa;
import tarefasservlet.models.TarefaRepository;

@WebServlet(name = "IndexServlet", urlPatterns= "/")
public class IndexServlet extends HttpServlet {
    private Hashtable<Integer, Tarefa> tarefas = new Hashtable<Integer, Tarefa>();

    private TarefaRepository repo = new TarefaRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            // Tarefa tarefa = new Tarefa();
            // tarefa.setId(1);
            // tarefa.setDescricao("Fazer a Tarefa");
            // tarefas.put(tarefa.getId(), tarefa);
            // request.setAttribute("tarefas", tarefas);
            // request.setAttribute("mensagem", "Olá Servlet!!!");
            request.setAttribute("tarefas", repo.fetchAll());
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            Tarefa tarefa = new Tarefa();
            //tarefa.setId(tarefas.size() + 1);
            tarefa.setDescricao(request.getParameter("descricao"));
            //tarefas.put(tarefa.getId(), tarefa);
            repo.save(tarefa);
            //request.getRequestDispatcher("/").forward(request, response);
            response.sendRedirect("/");
    }
}

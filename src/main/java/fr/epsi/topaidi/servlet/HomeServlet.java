package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.entite.Utilisateur;
import fr.epsi.topaidi.service.IdeesService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "homeServlet", value = "/")
public class HomeServlet extends HttpServlet {

    @EJB
    private IdeesService ideesService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Utilisateur currentUser = session.getAttribute("currentUser") != null ? (Utilisateur)session.getAttribute("currentUser") : null;

        request.setAttribute("idees", ideesService.getAll(currentUser));
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}

package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.service.UtilisateursService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "listeUtilisateursServlet", value = "/utilisateurs")
public class ListeUtilisateursServlet extends HttpServlet {

    @EJB
    private UtilisateursService utilisateursService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("utilisateurs", utilisateursService.getAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateur/index.jsp").forward(request, response);
    }
}

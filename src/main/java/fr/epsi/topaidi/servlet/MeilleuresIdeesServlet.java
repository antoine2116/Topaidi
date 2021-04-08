package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.service.IdeesService;
import fr.epsi.topaidi.service.UtilisateursService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "meilleuresIdeesServlet", value = "/meilleuresIdees")
public class MeilleuresIdeesServlet extends HttpServlet {

    @EJB
    private IdeesService ideesService;

    @EJB
    private UtilisateursService utilisateursService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("ideesTop", ideesService.getTop());
        request.setAttribute("utilisateursBrains", utilisateursService.getBrains());
        request.setAttribute("ideesBuzz", ideesService.getBuzz());
        this.getServletContext().getRequestDispatcher("/WEB-INF/meilleuresIdees/index.jsp").forward(request, response);
    }
}

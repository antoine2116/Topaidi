package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.dto.IdeeDto;
import fr.epsi.topaidi.dto.UtilisateurDto;
import fr.epsi.topaidi.entite.Categorie;
import fr.epsi.topaidi.entite.Utilisateur;
import fr.epsi.topaidi.service.UtilisateursService;
import fr.epsi.topaidi.tools.Authentification;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "deconnexionServlet", value = "/deconnexion")
public class DeconnexionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("currentUser");

        response.sendRedirect(request.getContextPath() + "/topaidi-1.0-SNAPSHOT");
    }

}

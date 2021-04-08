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

@WebServlet(name = "connexionService", value = "/connexion")
public class ConnexionServlet extends HttpServlet {

    @EJB
    private UtilisateursService utilisateursService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateur/connexion.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String motdepasse = request.getParameter("motdepasse");

        Utilisateur utilisateur = utilisateursService.getByEmail(email);

        if (utilisateur == null) {
            request.setAttribute("erreurMessage", "Email invalide");
        }
        else {
            if (Authentification.checkMotdepasse(motdepasse, utilisateur.getHash())) { // Mdp Ok
                if (!utilisateur.isValide()) { // Si l'utilisateur n'est pas validé
                    request.setAttribute("erreurMessage", "Votre compte n'est pas validé");

                }
                else if (utilisateur.isDesactive()) { // Si l'utilisateur est désactivé
                    request.setAttribute("erreurMessage", "Votre compte est désactivé");
                }
                else { // Sinon, connexion
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("currentUser", utilisateur);
                    response.sendRedirect(request.getContextPath() + "/topaidi-1.0-SNAPSHOT");
                }
            }
            else { // Mdp pas Ok => Erreur
                request.setAttribute("erreurMessage", "Mot de passe invalide");
            }
        }

        request.setAttribute("email", email);
        this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateur/connexion.jsp").forward(request, response);
    }
}

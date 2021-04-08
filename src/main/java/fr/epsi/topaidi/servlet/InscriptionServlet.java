package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.dto.UtilisateurDto;
import fr.epsi.topaidi.service.UtilisateursService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "inscriptionServlet", value = "/inscription")
public class InscriptionServlet extends HttpServlet {

    @EJB
    private UtilisateursService utilisateursService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateur/inscription.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setPrenom(req.getParameter("prenom"));
        utilisateurDto.setNom(req.getParameter("nom"));
        utilisateurDto.setEmail(req.getParameter("email"));
        utilisateurDto.setMotdepasse(req.getParameter("motdepasse"));
        utilisateursService.create(utilisateurDto);

        resp.sendRedirect(req.getContextPath() + "/connexion");
    }
}

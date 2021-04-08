package fr.epsi.topaidi.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.epsi.topaidi.dto.CommentaireDto;
import fr.epsi.topaidi.entite.Commentaire;
import fr.epsi.topaidi.entite.Idee;
import fr.epsi.topaidi.entite.Utilisateur;
import fr.epsi.topaidi.service.CommentairesService;
import fr.epsi.topaidi.service.IdeesService;
import fr.epsi.topaidi.viewmodel.CommentaireVM;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "createCommentaireServlet", value = "/createCommentaire")
public class CreateCommentaireServlet extends HttpServlet {

    @EJB
    private IdeesService ideesService;

    @EJB
    private CommentairesService commentairesService;


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CommentaireDto commentaireDto = new CommentaireDto();

        // Idée
        Idee idee = ideesService.getById(Integer.parseInt(request.getParameter("idIdee")));
        commentaireDto.setIdee(idee);

        // Utilisateur
        HttpSession session = request.getSession();
        Utilisateur currentUser = (Utilisateur)session.getAttribute("currentUser");
        commentaireDto.setUtilisateur(currentUser);

        // Texte
        commentaireDto.setTexte(request.getParameter("texte"));

        commentairesService.create(commentaireDto);

        response.sendRedirect(request.getContextPath() + "/topaidi-1.0-SNAPSHOT");
    }
}


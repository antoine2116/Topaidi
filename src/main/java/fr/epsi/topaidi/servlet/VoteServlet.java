package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.dto.VoteDto;
import fr.epsi.topaidi.entite.Idee;
import fr.epsi.topaidi.entite.Utilisateur;
import fr.epsi.topaidi.service.IdeesService;
import fr.epsi.topaidi.service.VotesService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "voteServlet", value = "/vote")
public class VoteServlet extends HttpServlet {

    @EJB
    private VotesService votesService;

    @EJB
    private IdeesService ideesService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VoteDto voteDto = new VoteDto();

        // Utilisateur
        HttpSession httpSession = request.getSession();
        Utilisateur currentUser = httpSession.getAttribute("currentUser") != null ? (Utilisateur)httpSession.getAttribute("currentUser") : null;
        voteDto.setUtilisateur(currentUser);

        // Idee
        String a = request.getParameter("id");
        Idee idee = ideesService.getById(Integer.parseInt(request.getParameter("id")));
        voteDto.setIdee(idee);

        // Top
        voteDto.setTop(Boolean.parseBoolean(request.getParameter("top")));

        votesService.create(voteDto);

        response.sendRedirect(request.getContextPath() + "/topaidi-1.0-SNAPSHOT");
    }
}

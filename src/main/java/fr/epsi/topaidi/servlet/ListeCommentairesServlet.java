package fr.epsi.topaidi.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.epsi.topaidi.service.CommentairesService;
import fr.epsi.topaidi.viewmodel.CommentaireVM;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listeCommentairesServlet", value = "/commentaires")
public class ListeCommentairesServlet extends HttpServlet {

    @EJB
    private CommentairesService commentairesService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idIdee = Integer.parseInt(request.getParameter("idIdee"));
        List<CommentaireVM> commentaires  = commentairesService.getAllByIdee(idIdee);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(commentaires);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}


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

@WebServlet(name = "editUtilisateurServlet", value = "/utilisateurs/edit")
public class EditUtilisateurServlet extends HttpServlet {

    @EJB
    private UtilisateursService utilisateursService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("utilisateur", utilisateursService.getById(id));
        this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateur/edit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean valide = Boolean.parseBoolean(request.getParameter("valide"));
        boolean desactive = Boolean.parseBoolean(request.getParameter("desactive"));

        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(id);
        utilisateurDto.setValide(valide);
        utilisateurDto.setDesactive(desactive);

        utilisateursService.update(utilisateurDto);

        response.sendRedirect(request.getContextPath() + "/utilisateurs");
    }
}

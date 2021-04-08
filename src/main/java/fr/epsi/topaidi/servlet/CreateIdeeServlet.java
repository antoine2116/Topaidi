package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.dto.IdeeDto;
import fr.epsi.topaidi.entite.Categorie;
import fr.epsi.topaidi.entite.Utilisateur;
import fr.epsi.topaidi.service.CategoriesService;
import fr.epsi.topaidi.service.IdeesService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "createIdeeServlet", value = "/createIdee")
@MultipartConfig
public class CreateIdeeServlet extends HttpServlet {

    @EJB
    private IdeesService ideesService;

    @EJB
    private CategoriesService categoriesService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("categories", categoriesService.getAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/idees/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IdeeDto ideeDto = new IdeeDto();
        // Titre et description
        ideeDto.setTitre(request.getParameter("titre"));
        ideeDto.setDescription(request.getParameter("description"));

        // Catégorie
        Categorie categorie = categoriesService.getById(Integer.parseInt(request.getParameter("categorie_id")));
        ideeDto.setCategorie(categorie);

        // Image
        Part filePart = request.getPart("image");
        InputStream inputStream = filePart.getInputStream();
        ideeDto.setImage(inputStream.readAllBytes());

        // Utilisateur
        HttpSession session = request.getSession();
        Utilisateur currentUser = session.getAttribute("currentUser") != null ? (Utilisateur)session.getAttribute("currentUser") : null;
        ideeDto.setUtilisateur(currentUser);

        ideesService.create(ideeDto);

        response.sendRedirect(request.getContextPath() + "/topaidi-1.0-SNAPSHOT");
    }
}

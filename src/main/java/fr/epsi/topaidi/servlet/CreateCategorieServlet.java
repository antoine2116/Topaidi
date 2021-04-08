package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.dto.CategorieDto;
import fr.epsi.topaidi.entite.Categorie;
import fr.epsi.topaidi.service.CategoriesService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createCategorieServlet", value = "/categories/create")
public class CreateCategorieServlet extends HttpServlet {

    @EJB
    private CategoriesService articleService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/categories/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setLibelle(req.getParameter("libelle"));
        articleService.create(categorieDto);
        resp.sendRedirect(req.getContextPath() + "/categories");
    }
}

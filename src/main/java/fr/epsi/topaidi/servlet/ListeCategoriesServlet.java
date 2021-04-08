package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.service.CategoriesService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "listeCategoriesServlet", value = "/categories")
public class ListeCategoriesServlet extends HttpServlet {

    @EJB
    private CategoriesService categoriesService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("categories", categoriesService.getAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/categories/index.jsp").forward(request, response);
    }
}

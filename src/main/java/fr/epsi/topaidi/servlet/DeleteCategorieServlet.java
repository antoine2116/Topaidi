package fr.epsi.topaidi.servlet;

import fr.epsi.topaidi.service.CategoriesService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteCategorieServlet", value = "/categories/delete")
public class DeleteCategorieServlet extends HttpServlet {

    @EJB
    private CategoriesService categoriesService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoriesService.delete(id);
        response.sendRedirect(request.getContextPath() + "/categories");
    }
}

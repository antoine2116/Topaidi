package fr.epsi.topaidi.service;

import fr.epsi.topaidi.dao.CategoriesDao;
import fr.epsi.topaidi.dao.CategoriesDaoImpl;
import fr.epsi.topaidi.dto.CategorieDto;
import fr.epsi.topaidi.entite.Categorie;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CategoriesServiceImpl implements  CategoriesService {

    @PersistenceContext(name = "topaidi")
    EntityManager em;

    @Resource
    UserTransaction utx;

    @Override
    public List<Categorie> getAll() {
        CategoriesDao categoriesDao = new CategoriesDaoImpl(em, utx);
        return categoriesDao.getAll();
    }

    @Override
    public Categorie getById(int id) {
        CategoriesDao categoriesDao = new CategoriesDaoImpl(em, utx);
        return categoriesDao.getById(id);
    }

    @Override
    public void create(CategorieDto categorieDto) {
        Categorie categorie = new Categorie();
        categorie.setLibelle(categorieDto.getLibelle());

        CategoriesDao categoriesDao = new CategoriesDaoImpl(em, utx);
        categoriesDao.create(categorie);
    }

    @Override
    public void delete(int id) {
        CategoriesDao categoriesDao = new CategoriesDaoImpl(em, utx);
        categoriesDao.delete(id);
    }
}

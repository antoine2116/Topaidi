package fr.epsi.topaidi.dao;

import fr.epsi.topaidi.entite.Categorie;

import java.util.List;

public interface CategoriesDao {
    List<Categorie> getAll();
    Categorie getById(int id);
    void create(Categorie categorie);
    void delete(int id);
}

package fr.epsi.topaidi.service;

import fr.epsi.topaidi.dto.CategorieDto;
import fr.epsi.topaidi.entite.Categorie;

import javax.transaction.*;
import java.util.List;

public interface CategoriesService {
    List<Categorie> getAll();
    Categorie getById(int id);
    void create(CategorieDto categorieDto);
    void delete(int id);
}

package fr.epsi.topaidi.dao;

import fr.epsi.topaidi.entite.Commentaire;

import java.util.List;

public interface CommentairesDao {
    List<Commentaire> getAllByIdee(int idIdee);
    void create(Commentaire commentaire);
}

package fr.epsi.topaidi.dao;

import fr.epsi.topaidi.entite.Utilisateur;

import java.util.List;

public interface UtilisateursDao {
    List<Utilisateur> getAll();
    List<Utilisateur> getBrains();
    Utilisateur getById(int id);
    Utilisateur getByEmail(String email);
    void create(Utilisateur utilisateur);
    void update(Utilisateur utilisateur);
}

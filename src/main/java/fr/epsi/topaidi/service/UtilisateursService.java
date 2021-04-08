package fr.epsi.topaidi.service;

import fr.epsi.topaidi.dto.UtilisateurDto;
import fr.epsi.topaidi.entite.Utilisateur;
import fr.epsi.topaidi.viewmodel.UtilisateurBrainVM;

import java.util.List;

public interface UtilisateursService {
    List<Utilisateur> getAll();
    List<UtilisateurBrainVM> getBrains();
    Utilisateur getById(int id);
    Utilisateur getByEmail(String email);
    void create(UtilisateurDto utilisateurDto);
    void update(UtilisateurDto utilisateurDto);
}

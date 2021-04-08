package fr.epsi.topaidi.service;

import fr.epsi.topaidi.dto.IdeeDto;
import fr.epsi.topaidi.entite.Idee;
import fr.epsi.topaidi.entite.Utilisateur;
import fr.epsi.topaidi.viewmodel.IdeeVM;

import java.util.List;

public interface IdeesService {
    List<IdeeVM> getAll(Utilisateur currentUser);
    List<IdeeVM> getTop();
    List<IdeeVM> getBuzz();
    Idee getById(int id);
    void create(IdeeDto ideeDto);
}

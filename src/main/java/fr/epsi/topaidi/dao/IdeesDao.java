package fr.epsi.topaidi.dao;

import fr.epsi.topaidi.entite.Idee;

import java.util.List;

public interface IdeesDao {
    List<Idee> getAll();
    List<Idee> getTop();
    List<Idee> getBuzz();
    Idee getById(int id);
    void create(Idee idee);
}

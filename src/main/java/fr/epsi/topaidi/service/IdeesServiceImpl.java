package fr.epsi.topaidi.service;

import fr.epsi.topaidi.dao.IdeesDao;
import fr.epsi.topaidi.dao.IdeesDaoImpl;
import fr.epsi.topaidi.dto.IdeeDto;
import fr.epsi.topaidi.entite.Idee;
import fr.epsi.topaidi.entite.Utilisateur;
import fr.epsi.topaidi.viewmodel.IdeeVM;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeesServiceImpl implements  IdeesService {

    @PersistenceContext(name = "topaidi")
    EntityManager em;

    @Resource
    UserTransaction utx;

    @Override
    public List<IdeeVM> getAll(Utilisateur currentUser) {
        IdeesDao ideesDao = new IdeesDaoImpl(em, utx);
        return ideesDao.getAll().stream().map(i -> new IdeeVM(i, currentUser)).collect(Collectors.toList());
    }

    @Override
    public List<IdeeVM> getTop() {
        IdeesDao ideesDao = new IdeesDaoImpl(em, utx);
        return ideesDao.getTop().stream().map(i -> new IdeeVM(i)).collect(Collectors.toList());
    }

    @Override
    public List<IdeeVM> getBuzz() {
        IdeesDao ideesDao = new IdeesDaoImpl(em, utx);
        return ideesDao.getBuzz().stream().map(i -> new IdeeVM(i)).collect(Collectors.toList());
    }

    @Override
    public Idee getById(int id) {
        IdeesDao ideesDao = new IdeesDaoImpl(em, utx);
        return ideesDao.getById(id);
    }

    @Override
    public void create(IdeeDto ideeDto) {
        Idee idee = new Idee();
        idee.setTitre(ideeDto.getTitre());
        idee.setDescription(ideeDto.getDescription());
        idee.setCategorie(ideeDto.getCategorie());
        idee.setImage(ideeDto.getImage());
        idee.setUtilisateur(ideeDto.getUtilisateur());
        idee.setDateCreation(new Date());

        IdeesDao ideesDao = new IdeesDaoImpl(em, utx);
        ideesDao.create(idee);
    }
}

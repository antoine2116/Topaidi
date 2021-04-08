package fr.epsi.topaidi.service;

import fr.epsi.topaidi.dao.*;
import fr.epsi.topaidi.dto.UtilisateurDto;
import fr.epsi.topaidi.entite.Utilisateur;
import fr.epsi.topaidi.tools.Authentification;
import fr.epsi.topaidi.viewmodel.UtilisateurBrainVM;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UtilisateursServiceImpl implements UtilisateursService {

    @PersistenceContext(name = "topaidi")
    EntityManager em;

    @Resource
    UserTransaction utx;

    @Override
    public List<Utilisateur> getAll() {
        UtilisateursDao utilisateursDao = new UtilisateursDaoImpl(em, utx);
        return utilisateursDao.getAll();
    }

    @Override
    public List<UtilisateurBrainVM> getBrains() {
        UtilisateursDao utilisateursDao = new UtilisateursDaoImpl(em, utx);
        List<UtilisateurBrainVM> utilisateurBrains = utilisateursDao.getBrains()
                .stream().map(u -> new UtilisateurBrainVM(u)).collect(Collectors.toList());
        
        return utilisateurBrains;
    }

    @Override
    public Utilisateur getById(int id) {
        UtilisateursDao utilisateursDao = new UtilisateursDaoImpl(em, utx);
        return utilisateursDao.getById(id);
    }

    @Override
    public Utilisateur getByEmail(String email) {
        UtilisateursDao utilisateursDao = new UtilisateursDaoImpl(em, utx);
        return utilisateursDao.getByEmail(email);
    }

    @Override
    public void create(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        String hash = Authentification.hash(utilisateurDto.getMotdepasse());
        utilisateur.setHash(hash);

        UtilisateursDao utilisateursDao = new UtilisateursDaoImpl(em, utx);
        utilisateursDao.create(utilisateur);
    }

    @Override
    public void update(UtilisateurDto utilisateurDto) {
        UtilisateursDao utilisateursDao = new UtilisateursDaoImpl(em, utx);

        Utilisateur utilisateur = utilisateursDao.getById(utilisateurDto.getId());
        utilisateur.setValide(utilisateurDto.isValide());
        utilisateur.setDesactive(utilisateurDto.isDesactive());

        utilisateursDao.update(utilisateur);
    }
}

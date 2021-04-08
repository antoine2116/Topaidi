package fr.epsi.topaidi.service;

import fr.epsi.topaidi.dao.CommentairesDao;
import fr.epsi.topaidi.dao.CommentairesDaoImpl;
import fr.epsi.topaidi.dto.CommentaireDto;
import fr.epsi.topaidi.entite.Commentaire;
import fr.epsi.topaidi.viewmodel.CommentaireVM;
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
public class CommentairesServiceImpl implements CommentairesService {

    @PersistenceContext(name = "topaidi")
    EntityManager em;

    @Resource
    UserTransaction utx;

    @Override
    public List<CommentaireVM> getAllByIdee(int idIdee) {
        CommentairesDao commentairesDao = new CommentairesDaoImpl(em, utx);
        return commentairesDao.getAllByIdee(idIdee).stream().map(c -> new CommentaireVM(c)).collect(Collectors.toList());
    }

    @Override
    public void create(CommentaireDto commentaireDto) {
        Commentaire commentaire = new Commentaire();
        commentaire.setIdee(commentaireDto.getIdee());
        commentaire.setUtilisateur(commentaireDto.getUtilisateur());
        commentaire.setTexte(commentaireDto.getTexte());
        commentaire.setDateCreation(new Date());

        CommentairesDao commentairesDao = new CommentairesDaoImpl(em, utx);
        commentairesDao.create(commentaire);
    }
}

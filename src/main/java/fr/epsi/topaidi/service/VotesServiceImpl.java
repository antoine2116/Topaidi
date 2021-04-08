package fr.epsi.topaidi.service;

import fr.epsi.topaidi.dao.VotesDao;
import fr.epsi.topaidi.dao.VotesDaoImpl;
import fr.epsi.topaidi.dto.VoteDto;
import fr.epsi.topaidi.entite.Vote;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class VotesServiceImpl implements  VotesService {

    @PersistenceContext(name = "topaidi")
    EntityManager em;

    @Resource
    UserTransaction utx;

    @Override
    public void create(VoteDto voteDto) {
        Vote vote = new Vote();

        vote.setIdee(voteDto.getIdee());
        vote.setUtilisateur(voteDto.getUtilisateur());
        vote.setTop(voteDto.isTop());

        VotesDao votesDao = new VotesDaoImpl(em, utx);
        votesDao.create(vote);
    }
}

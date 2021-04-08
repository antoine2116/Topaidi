package fr.epsi.topaidi.dao;

import fr.epsi.topaidi.entite.Vote;

import javax.persistence.EntityManager;
import javax.transaction.*;

public class VotesDaoImpl implements VotesDao {

    EntityManager em;
    UserTransaction utx;

    public VotesDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    @Override
    public void create(Vote vote) {
        try {
            utx.begin();
            em.persist(vote);
            utx.commit();
        } catch (NotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RollbackException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

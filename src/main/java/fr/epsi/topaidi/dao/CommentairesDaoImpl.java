package fr.epsi.topaidi.dao;

import fr.epsi.topaidi.entite.Commentaire;

import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

public class CommentairesDaoImpl implements CommentairesDao {

    EntityManager em;
    UserTransaction utx;

    public CommentairesDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    @Override
    public List<Commentaire> getAllByIdee(int idIdee) {
        return em.createQuery("select c from Commentaire c where c.idee.id = :idIdee")
                .setParameter("idIdee", idIdee)
                .getResultList();
    }

    @Override
    public void create(Commentaire commentaire) {
        try {
            utx.begin();
            em.persist(commentaire);
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

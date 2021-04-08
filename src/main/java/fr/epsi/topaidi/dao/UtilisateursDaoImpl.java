package fr.epsi.topaidi.dao;

import fr.epsi.topaidi.dto.UtilisateurDto;
import fr.epsi.topaidi.entite.Utilisateur;

import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

public class UtilisateursDaoImpl implements UtilisateursDao {

    EntityManager em;
    UserTransaction utx;

    public UtilisateursDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    @Override
    public List<Utilisateur> getAll() {
        return em.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
    }

    @Override
    public List<Utilisateur> getBrains() {
        return em.createQuery("select u from Utilisateur u order by u.idees.size desc", Utilisateur.class)
                .setMaxResults(3)
                .getResultList();
    }

    @Override
    public Utilisateur getById(int id) {
        return em.find(Utilisateur.class, id);
    }

    @Override
    public Utilisateur getByEmail(String email) {
        List<Utilisateur> utilisateurs =  em.createQuery("select u from Utilisateur u where u.email = :email", Utilisateur.class)
                                            .setParameter("email", email)
                                            .getResultList();

        if (utilisateurs.isEmpty()) {
            return null;
        }
        else {
            return utilisateurs.get(0);
        }
    }

    @Override
    public void create(Utilisateur utilisateur) {
        try {
            utx.begin();
            em.persist(utilisateur);
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

    @Override
    public void update(Utilisateur utilisateur) {
        try {
            utx.begin();
            em.merge(utilisateur);
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

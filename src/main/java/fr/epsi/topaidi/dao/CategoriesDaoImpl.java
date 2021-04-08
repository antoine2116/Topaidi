package fr.epsi.topaidi.dao;

import fr.epsi.topaidi.entite.Categorie;

import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

public class CategoriesDaoImpl implements CategoriesDao {
    EntityManager em;
    UserTransaction utx;

    public CategoriesDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    @Override
    public List<Categorie> getAll() {
        return em.createQuery("select a from Categorie a", Categorie.class).getResultList();
    }

    @Override
    public Categorie getById(int id) {
        return em.find(Categorie.class, id);
    }

    @Override
    public void create(Categorie categorie) {
        try {
            utx.begin();
            em.persist(categorie);
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
    public void delete(int id) {
        try {
            utx.begin();
            Categorie categorie = em.find(Categorie.class, id);
            em.remove(categorie);
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

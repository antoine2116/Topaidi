package fr.epsi.topaidi.dao;

import fr.epsi.topaidi.entite.Categorie;
import fr.epsi.topaidi.entite.Idee;
import fr.epsi.topaidi.entite.Vote;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.*;
import java.util.List;

public class IdeesDaoImpl implements IdeesDao {
    EntityManager em;
    UserTransaction utx;

    public IdeesDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    @Override
    public List<Idee> getAll() {
        return em.createQuery("select i from Idee i order by i.dateCreation desc", Idee.class).getResultList();
    }

    @Override
    public List<Idee> getTop() {
        return em.createNativeQuery(
                    "select *,\n" +
                    "count(vote.id) as nbvotes,\n" +
                    "(sum(vote.top = 1) / if(sum(vote.top = 0) = 0, 1, sum(vote.top = 0))) as ratio\n" +
                    "from idee\n" +
                    "inner join vote on vote.idee_id = idee.id\n" +
                    "group by idee.id\n" +
                    "order by ratio desc, nbvotes desc, idee.dateCreation desc", Idee.class)
                .setMaxResults(3)
                .getResultList();
    }

    @Override
    public List<Idee> getBuzz() {
        return em.createNativeQuery(
                "select *,\n" +
                        "count(vote.id) as nbvotes\n" +
                        "from idee\n" +
                        "inner join vote on vote.idee_id = idee.id\n" +
                        "group by idee.id\n" +
                        "order by nbvotes desc", Idee.class)
                .setMaxResults(3)
                .getResultList();
    }

    @Override
    public Idee getById(int id) {
        return em.find(Idee.class, id);
    }

    @Override
    public void create(Idee idee) {
        try {
            utx.begin();
            em.persist(idee);
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

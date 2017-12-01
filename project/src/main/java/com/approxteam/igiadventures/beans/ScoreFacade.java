/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.approxteam.igiadventures.beans;

import com.approxteam.igiadventures.entities.Score;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author razikus
 */
@Stateless
public class ScoreFacade extends AbstractFacade<Score> implements ScoreFacadeLocal
{

    

    @PersistenceContext(unitName = "igiscoresPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public ScoreFacade()
    {
        super(Score.class);
    }
    
    @Override
    public List<Score> getXBest(int howmuch)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Score> cq = cb.createQuery(Score.class);
        Root<Score> score = cq.from(Score.class);
        cq.select(score);
        cq.orderBy(cb.asc(score.get("score")));
        TypedQuery<Score> q = em.createQuery(cq);
        q.setMaxResults(howmuch);
        return q.getResultList();
    }
    
}

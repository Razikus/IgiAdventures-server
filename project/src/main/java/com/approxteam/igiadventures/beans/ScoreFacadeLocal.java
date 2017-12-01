/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.approxteam.igiadventures.beans;

import com.approxteam.igiadventures.entities.Score;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author razikus
 */
@Local
public interface ScoreFacadeLocal
{
    
    void create(Score score);

    void edit(Score score);

    void remove(Score score);

    Score find(Object id);

    List<Score> findAll();

    List<Score> findRange(int[] range);

    int count();
    
    List<Score> getXBest(int howmuch);
    
}

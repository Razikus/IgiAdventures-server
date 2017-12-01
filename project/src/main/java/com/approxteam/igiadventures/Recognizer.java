/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.approxteam.igiadventures;

import com.approxteam.igiadventures.actions.Action;
import com.approxteam.igiadventures.actions.Status;
import com.approxteam.igiadventures.actions.Views;
import com.approxteam.igiadventures.beans.ScoreFacadeLocal;
import com.approxteam.igiadventures.entities.Score;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author razikus
 */
@ApplicationScoped
public class Recognizer
{

    private ObjectMapper mapper = new ObjectMapper();
    
    @EJB
    private ScoreFacadeLocal scoreFacade;
    
    
    public String recognize(String what) throws IOException {
        System.out.println(what);
        Action act = mapper.readerWithView(Views.ActionView.class).forType(Action.class).readValue(what);
        
        if(act.getActionName().equals("ADD")) {
            act = mapper.readerWithView(Views.AddActionView.class).forType(Action.class).readValue(what);
            Score score = new Score();
            score.setNickname(act.getNickname());
            score.setScore(act.getScore());
            scoreFacade.create(score);
            Status status = Status.constructStatus(0, "OK");
            String ret = mapper.writeValueAsString(status);
            return ret;
        }
        else if(act.getActionName().equals("TOP")) {
            act = mapper.readerWithView(Views.TopActionView.class).forType(Action.class).readValue(what);
            List<Score> ret = scoreFacade.getXBest(act.getHowmuch());
            Status status = Status.constructStatus(1, "TOP", ret.toArray());
            String json = mapper.writeValueAsString(status);
            return json;
        }
        else {
            return "UNRECOGNIZED";
        }
    }
    
    
}

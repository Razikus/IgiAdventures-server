/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.approxteam.igiadventures.actions;

import com.fasterxml.jackson.annotation.JsonView;

/**
 *
 * @author razikus
 */
public class Action
{
    @JsonView(Views.ActionView.class)
    private String actionName;
    
    @JsonView(Views.TopActionView.class)
    private int howmuch;
    
    @JsonView(Views.AddActionView.class) 
    private String nickname;
    
    @JsonView(Views.AddActionView.class) 
    private double score;

    public String getActionName()
    {
        return actionName;
    }

    public String getNickname()
    {
        return nickname;
    }

    public double getScore()
    {
        return score;
    }

    public int getHowmuch()
    {
        return howmuch;
    }

    public void setHowmuch(int howmuch)
    {
        this.howmuch = howmuch;
    }

    @Override
    public String toString()
    {
        return "Action{" + "actionName=" + actionName + ", howmuch=" + howmuch + ", nickname=" + nickname + ", score=" + score + '}';
    }

    
    
    
    
}

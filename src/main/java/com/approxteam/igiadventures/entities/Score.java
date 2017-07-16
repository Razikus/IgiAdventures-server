/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.approxteam.igiadventures.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author razikus
 */
@Entity
@SequenceGenerator(name = "score_seq_generator", allocationSize = 20, initialValue = 1, sequenceName = "score_seq")
@XmlRootElement
public class Score implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "score_seq_generator")
    private Long id;
    
    @Column(nullable = false)
    private String nickname;
    
    @Column(nullable = false)
    private double score;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }

    @Override
    public String toString()
    {
        return "Score{" + "id=" + id + ", nickname=" + nickname + ", score=" + score + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.nickname);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Score other = (Score) obj;
        if (Double.doubleToLongBits(this.score) != Double.doubleToLongBits(other.score)) {
            return false;
        }
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}

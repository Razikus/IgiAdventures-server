/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.approxteam.igiadventures.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author razikus
 */
public class Status
{
    private static ObjectMapper mapper = new ObjectMapper();
    
    
    private int code;
    private String name;
    private List<Object> args = new ArrayList<>();

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Object> getArgs()
    {
        return args;
    }

    public void setArgs(List<Object> args)
    {
        this.args = args;
    }

    public String jsonify() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            return "Error";
        }
    }
    
    @Override
    public String toString()
    {
        return "Status{" + "code=" + code + ", name=" + name + '}';
    }
    
    public static Status constructStatus(int code, String name) {
        Status status = new Status();
        status.setCode(code);
        status.setName(name);
        return status;
    }
    
    public static Status constructStatus(int code, String name, Object[] objs) {
        Status status = new Status();
        status.setCode(code);
        status.setName(name);
        status.setArgs(Arrays.asList(objs));
        return status;
    }
    
}

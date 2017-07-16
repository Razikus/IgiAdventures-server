/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.approxteam.igiadventures;

import com.approxteam.igiadventures.actions.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author razikus
 */
@ApplicationScoped
@ServerEndpoint("/igisocket")
public class IgiWebSocket {
    
    
    @Inject
    private Recognizer recognizer;
    
    @Inject
    private IgiSessionHandler sessionHandler;
    
    @OnOpen
        public void open(Session session) {
            System.out.println(session.getRequestURI().toString());
            sessionHandler.addSession(session);
            session.getAsyncRemote().sendText(Status.constructStatus(3, "CONNECTED").jsonify());
            
    }   
    @OnClose
        public void close(Session session) {
            sessionHandler.removeSession(session);
    }   

    @OnError
        public void onError(Throwable error) {
    }

    @OnMessage
        public void handleMessage(String message, Session session) {
        try {
            session.getBasicRemote().sendText(recognizer.recognize(message));
        } catch (IOException ex) {
            session.getAsyncRemote().sendText("UNRECOGNIZED");
        }
    }
    
}

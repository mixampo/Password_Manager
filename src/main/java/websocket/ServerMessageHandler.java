package websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(
        value = "/chat/")
public class ServerMessageHandler {
    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println("[Connected] SessionID:" + session.getId());
        String message = String.format("[Broadcast] " + "[New client has joined with ID: ]: %s", session.getId());
        broadcast(message);
        sessions.add(session);
        System.out.println("[#sessions]: " + sessions.size());
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {

        System.out.println("[Session ID] : " + session.getId() + " [Received] : " + message);


        for (Session client : sessions){
            if(!client.equals(session)){
                client.getBasicRemote().sendText(message);
            }
        }
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) throws IOException {
        System.out.println("[Session ID] : " + session.getId() + "[Socket Closed: " + reason);
        sessions.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("[Session ID] : " + session.getId() + "[ERROR]: ");
        throwable.printStackTrace(System.err);
    }

    private static void broadcast(String s){
        System.out.println("[Broadcast] { " + s + " } to:");
        for (Session session : sessions){
            try {
                session.getBasicRemote().sendText(s);
                System.out.println("\t\t >> Client associated with server side session ID: " + session.getId());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("[End of Broadcast]");
    }
}

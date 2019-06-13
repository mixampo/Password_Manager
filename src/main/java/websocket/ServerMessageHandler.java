package websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(
        value = "/chat/{username}")
public class ServerMessageHandler {
    private String username;
    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        System.out.println("[Connected] SessionID:" + session.getId());
        this.username = username;
        String message = String.format("[New client has joined with username] : %s", username);
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
        String message = String.format("[Client has disconnected with username] : %s", username);
        broadcast(message);
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

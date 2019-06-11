package websocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;
import javax.websocket.server.ServerContainer;

public class WebsocketServer {
    public static void main(String[] args){
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8095);
        server.addConnector(connector);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        try {
            ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);
            wscontainer.addEndpoint(ServerMessageHandler.class);
            server.start();
            server.join();

        } catch (Throwable t){
            t.printStackTrace(System.err);
        }
    }
}

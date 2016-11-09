package Controller.html;

import com.sun.jersey.json.impl.provider.entity.JSONRootElementProvider;
import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by TH-221 on 08.11.2016.
 */

public class Server {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        server.start();
        Logger logger = LoggerFactory.getLogger(JSONRootElementProvider.App.class);

        logger.info("Server running");
        logger.info("Visit: http://localhost:9998/DocumentManagement");
        logger.info("Hit return to stop...");
        System.in.read();
        logger.info("Stopping server");
        server.stop(0);
        logger.info("Server stopped");
    }
}
package http;

import http.misc.FileHtmlPageProvider;
import http.misc.HtmlPageNames;

import java.io.*;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/DocumentManagement")
public class StartPage {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces({MediaType.TEXT_HTML})

    public InputStream viewHome() {
        return FileHtmlPageProvider.getInstance().GetHtmlStream(HtmlPageNames.startPage);
    }
}

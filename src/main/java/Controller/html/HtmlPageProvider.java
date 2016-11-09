package Controller.html;

import java.io.InputStream;

/**
 * Created by TH-221 on 08.11.2016.
 */
public interface HtmlPageProvider {
    public InputStream GetHtmlStream(String htmlName);
}

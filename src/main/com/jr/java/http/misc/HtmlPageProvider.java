package http.misc;

import java.io.InputStream;

public interface HtmlPageProvider {
    public InputStream GetHtmlStream(String htmlName);
}

package Controller.html;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by TH-221 on 08.11.2016.
 */
public class FileHtmlPageProvider implements HtmlPageProvider {

    private static FileHtmlPageProvider instance;

    public static synchronized FileHtmlPageProvider getInstance() {
        if (getInstance() == null) {
            instance = new FileHtmlPageProvider();
        }
        return instance;
    }


    @Override
    public InputStream GetHtmlStream(String htmlName) {
        File f = new File(getPageResourcePath(htmlName));
        try {
            return new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String getPageResourcePath(String page) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(page).getFile());
        return file.getPath();
    }
}

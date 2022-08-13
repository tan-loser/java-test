package parseXML;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Demo {

    @Test
    public void parseXMLdata ()  throws Exception{
        SAXReader saxReader = new SAXReader();

        InputStream is = Demo.class.getResourceAsStream("..\\demo\\data1.xml");
        Document document = saxReader.read(is);

        Element root = document.getRootElement();
        System.out.println(root.getName());

        List<Element> sonEles = root.elements("书");
        for (Element sonEle : sonEles) {
            System.out.println(sonEle.getName());
        }

        System.out.println(root.element("书").getName());

    }

}

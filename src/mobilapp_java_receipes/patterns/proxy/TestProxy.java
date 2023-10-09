package mobilapp_java_receipes.patterns.proxy;

import org.junit.Assert;
import org.junit.Test;

public class TestProxy {
    //Subject
    abstract static class Graphic {
        protected String fileName;

        abstract void draw();

        public String getFileName() {
            return fileName;
        }
    }

    //RealSubject
    static class Image extends Graphic {

        public Image(String fileName) {
            this.fileName = fileName;
        }

        //Request()
        public void draw() {
            System.out.println("draw " + fileName);
        }
    }

    //Proxy
    static class ImageProxy extends Graphic {
        private Image image;

        public ImageProxy(String fileName) {
            this.fileName = fileName;
        }

        public void draw() {
            getImage().draw();
        }

        private Image getImage() {
            if (image == null) {
                image = new Image(fileName);
            }
            return image;
        }
    }

    @Test
    public void test() {
        String fileName1 = "1.png";
        var proxy = new ImageProxy(fileName1);
        //operation without creating a RealSubject
        proxy.draw();

        Assert.assertEquals(fileName1,proxy.getFileName());

    }

}

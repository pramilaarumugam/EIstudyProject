package creational.factory;

public class Receipt implements Document {
    @Override
    public void showDocumentInfo() {
        System.out.println("This is a Receipt document.");
    }
}


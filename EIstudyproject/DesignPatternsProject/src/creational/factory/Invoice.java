package creational.factory;

public class Invoice implements Document {
    @Override
    public void showDocumentInfo() {
        System.out.println("This is an Invoice document.");
    }
}


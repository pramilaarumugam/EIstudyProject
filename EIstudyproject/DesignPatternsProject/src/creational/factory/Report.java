package creational.factory;

public class Report implements Document {
    @Override
    public void showDocumentInfo() {
        System.out.println("This is a Report document.");
    }
}


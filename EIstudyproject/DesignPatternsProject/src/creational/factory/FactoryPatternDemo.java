package creational.factory;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        DocumentFactory factory = new DocumentFactory();

        Document doc1 = factory.createDocument("invoice");
        Document doc2 = factory.createDocument("receipt");
        Document doc3 = factory.createDocument("report");

        if (doc1 != null) doc1.showDocumentInfo();
        if (doc2 != null) doc2.showDocumentInfo();
        if (doc3 != null) doc3.showDocumentInfo();
    }
}


package creational.factory;

public class DocumentFactory {

    public Document createDocument(String type) {
        if (type == null) return null;
        switch (type.toLowerCase()) {
            case "invoice":
                return new Invoice();
            case "receipt":
                return new Receipt();
            case "report":
                return new Report();
            default:
                System.out.println("Unknown document type: " + type);
                return null;
        }
    }
}


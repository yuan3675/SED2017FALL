import java.util.ArrayList;

public class Application {
    private ArrayList <Document> documents = new ArrayList<>();

    public void manageDocuments() {
        for (Document document : documents) {
            System.out.println(document.getClass().getName());
        }
    }
    public void createDocument(String type) {
        Document document = null;
        if (type.equals("Draw")) {
            DrawingDocumentCreator drawingDocumentCreator = new DrawingDocumentCreator();
            document = drawingDocumentCreator.createDocument();
        }
        else if (type.equals("Text")) {
            TextDocumentCreator textDocumentCreator = new TextDocumentCreator();
            document = textDocumentCreator.createDocument();
        }
        if (document != null) {
            documents.add(document);
        }
    }
}

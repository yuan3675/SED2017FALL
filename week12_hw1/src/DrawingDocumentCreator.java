public class DrawingDocumentCreator implements DocumentCreator {
    @Override
    public Document createDocument() {
        return new DrawingDocument();
    }
}

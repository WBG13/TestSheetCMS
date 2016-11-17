package core;

import java.util.List;

public interface IDocument {
    interface IDatabaseSession {
        void SaveDocument(IDocument document);
        List< IDocument > GetDocuments(DocumentType documentType, int limit, int offset);
        IDocument FindDocument(DocumentType documentType, String id);
    }
}

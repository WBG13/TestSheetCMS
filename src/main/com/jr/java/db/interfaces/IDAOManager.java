package db.interfaces;

import core.IDocument;

import java.util.List;

public interface IDAOManager<T extends IDocument> {
    void Create(T obj);

    T Read(String id);

    List<T> ReadAll(String query, int limit, int offset);

    void Update(T obj);

    void Delete(String id);
}

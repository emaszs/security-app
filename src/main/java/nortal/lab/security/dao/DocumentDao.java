package nortal.lab.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nortal.lab.security.entities.Document;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DocumentDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Document> findDocuments(final Long belongsToId) {
        return em.createQuery("from Document where ownerId = :id").setParameter("id", belongsToId).getResultList();
    }

    @Transactional
    public void save(final Document doc) {
        em.persist(doc);
    }

    @Transactional
    public Document getById(final Long id) {
        return em.find(Document.class, id);
    }
}

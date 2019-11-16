package steamdom.backend;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import steamdom.backend.model.Academic;
// 

@Singleton
public class AcademicRepositoryImpl implements AcademicRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public AcademicRepositoryImpl(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Academic save(@NotNull Academic academic) {
        entityManager.persist(academic);
        return academic;
    }

    @Override
    @Transactional
    public Academic update(@NotNull Academic academic) {
        return entityManager.merge(academic);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Academic> findAll() {
        String qlString = "SELECT m FROM Academic m";
        TypedQuery<Academic> query = entityManager.createQuery(qlString, Academic.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Academic findById(@NotNull Long id) {
        return entityManager.find(Academic.class, id);
    }

    @Override
    @Transactional
    public void deleteById(@NotNull Long id) {
        Academic academic = findById(id);

        if(academic != null) {
            entityManager.remove(academic);
        }
    }
}
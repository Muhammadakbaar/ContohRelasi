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

import steamdom.backend.model.Classes;

@Singleton
public class ClassesRepositoryImpl implements ClassesRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public ClassesRepositoryImpl(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Classes save(@NotNull Classes classes) {
        entityManager.persist(classes);
        return classes;
    }

    @Override
    @Transactional
    public Classes update(@NotNull Classes classes) {
        return entityManager.merge(classes);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Classes> findAll() {
        String qlString = "SELECT m FROM Classes m";
        TypedQuery<Classes> query = entityManager.createQuery(qlString, Classes.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Classes findById(@NotNull Long id) {
        return entityManager.find(Classes.class, id);
    }

    @Override
    @Transactional
    public void deleteById(@NotNull Long id) {
        Classes classes = findById(id);

        if(classes != null) {
            entityManager.remove(classes);
        }
    }
}

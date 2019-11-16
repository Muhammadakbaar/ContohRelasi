package steamdom.master.repository;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import java.util.List;
import java.util.Date;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import steamdom.master.model.Classes;

@Singleton
public class ClassesRepository implements ClassesRepositoryInf {
    @PersistenceContext
    private EntityManager manager;

    public ClassesRepository(@CurrentSession EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional(readOnly = true)
    public Long size() {
        Long count = manager.createQuery("select count(*) from Classes where deleted_at IS NULL", Long.class).getSingleResult();
        return count;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Classes> findAll(int page, int limit) {
        TypedQuery<Classes> query = manager
                .createQuery("from Classes where deleted_at IS NULL", Classes.class)
                .setFirstResult(page > 1 ? page * limit - limit : 0)
                .setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Classes findById(@NotNull Long id) {
        Classes query = manager.find(Classes.class, id);
        return query;
    }


    @Override
    @Transactional
    public boolean save(@NotNull Classes classes){
        try {
            manager.persist(classes);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    @Transactional 
    public boolean update(@NotNull Long id, String code, String name){
        try {
            Classes c = manager.find(Classes.class, id);

            if (name.equals("-")==false) c.setName(name);
            
            return true;
        } catch (Exception e){
            return false;
        }
            
    }

    @Override
    @Transactional
    public boolean destroy(@NotNull Long id){
        try {
            // Classes c = manager.find(Classes.class, id);
            // c.setDeleted_At(new Date());
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }


}

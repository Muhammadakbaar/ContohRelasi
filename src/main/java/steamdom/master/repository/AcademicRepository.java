package steamdom.master.repository;

import java.util.Date;
import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import steamdom.master.model.Academic;

@Singleton
public class AcademicRepository implements AcademicRepositoryInf {
    @PersistenceContext
    private EntityManager manager;

    // public AcademicRepository(@CurrentSession EntityManager manager) {
    //     this.manager = manager;
    // }

    @Override
    @Transactional(readOnly = true)
    public Long size() {
        Long count = manager.createQuery("select count(*) from Academic where deleted_at IS NULL", Long.class).getSingleResult();
        return count;
    }

    // @Override
    // @Transactional(readOnly = true)
    // public List<Academic> findAll(int page, int limit) {
    //     TypedQuery<Academic> query = manager
    //             .createQuery("from Classes where deleted_at IS NULL", Academic.class)
    //             .setFirstResult(page > 1 ? page * limit - limit : 0)
    //             .setMaxResults(limit);
    //     return query.getResultList();
    // }

    @Override
    @Transactional(readOnly = true)
    public Academic findById(@NotNull Long id) {
        Academic query = manager.find(Academic.class, id);
        return query;
    }

    @Override
    public List<Academic> findAll(int page, int limit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean save(@NotNull Academic academic) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(@NotNull Long id, int years_ac, int code_ac, String name_ac, int id_class, String name_class,
            String semester, int id_teacher_matapljrn, String name_teacher, String status) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean destroy(@NotNull Long id) {
        // TODO Auto-generated method stub
        return false;
    }
}

    // @Override
    // @Transactional
    // public boolean save(@NotNull Academic academic) {
    //     try {
    //         manager.persist(academic);
    //         return true;
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }

    // @Override
    // public boolean update(@NotNull Long id, int years_ac, int code_ac, String name_ac, int id_classes, String name_classes,
    //         String semester, int id_teacher_matapljrn, String name_teacher, String status) {
    //     try {
    //         Academic c = manager.find(Academic.class, id);
    //         if (id_classes !=0) c.setId_classes(id_classes);
    //         if (name_classes.equals("-")==false) c.setName_classes(name_classes);
    //         return true;
    //     } catch (Exception e){
    //         return false;
        // }
    // }
    // }

    // @Override
    // public boolean destroy(@NotNull Long id) {
    //     // TODO Auto-generated method stub
    //     return false;
    // }
// }

    // @Override
    // @Transactional
    // public boolean destroy(@NotNull Long id){
        // try {
        //     Academic c = manager.find(Academic.class, id);
        //     return true;
        // } catch (Exception e) {
        //     return false;
        // }
        
    // }

    

// }
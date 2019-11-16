package steamdom.master.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import steamdom.master.model.Academic;

public interface AcademicRepositoryInf {
    Long size();
    List<Academic> findAll(int page, int limit);
    Academic findById(@NotNull Long id);    
    boolean save(@NotNull Academic academic);
    boolean update(@NotNull Long id, int years_ac, int code_ac, String name_ac, int id_class, String name_class, String semester, 
        int id_teacher_matapljrn, String name_teacher, String status);
    boolean destroy(@NotNull Long id);

    
}
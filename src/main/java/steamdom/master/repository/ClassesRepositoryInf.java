package steamdom.master.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import steamdom.master.model.Classes;

public interface ClassesRepositoryInf {

    Long size();
    List<Classes> findAll(int page, int limit);
    Classes findById(@NotNull Long id);    
    boolean save(@NotNull Classes classes);
    boolean update(@NotNull Long id, String code, String name);
    boolean destroy(@NotNull Long id);
}

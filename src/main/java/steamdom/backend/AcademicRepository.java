package steamdom.backend;

import java.util.List;
import steamdom.backend.model.*;
import javax.validation.constraints.NotNull;


public interface AcademicRepository {
    // Materi save(@NotNull String kodeMateri, @NotNull String namaMateri);
    Academic save(@NotNull Academic academic);
    Academic update(@NotNull Academic academic);
    List<Academic> findAll();
    Academic findById(@NotNull Long id);
    void deleteById(@NotNull Long id);
}
package steamdom.backend;

import steamdom.backend.model.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface ClassesRepository {
    // Materi save(@NotNull String kodeMateri, @NotNull String namaMateri);
    Classes save(@NotNull Classes classes);
    Classes update(@NotNull Classes classes);
    List<Classes> findAll();
    Classes findById(@NotNull Long id);
    void deleteById(@NotNull Long id);
}
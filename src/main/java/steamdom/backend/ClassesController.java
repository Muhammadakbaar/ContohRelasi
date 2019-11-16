package steamdom.backend;

import steamdom.backend.model.Classes;
import steamdom.backend.model.ClassesResponse;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Delete;
import io.micronaut.validation.Validated;
import io.micronaut.http.MediaType;
import javax.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Controller("/classes")
@Validated
public class ClassesController{


    private ClassesRepository classesRepository;

    public ClassesController(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;

    }@Get("/")
    public String index() {

        try {
            List<Classes> classes = classesRepository.findAll();
            ClassesResponse response = new ClassesResponse("ok", "Data Classes", classes);

            return new Gson().toJson(response);
        } catch(Exception e) {
            String message = e.getMessage();
            ClassesResponse response = new ClassesResponse("error", message);
            return new Gson().toJson(response);
        }
    
    }
}
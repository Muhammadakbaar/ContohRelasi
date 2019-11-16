package steamdom.backend;

import steamdom.backend.model.Academic;
import steamdom.backend.model.AcademicResponse;

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
@Controller("/academic")
@Validated
public class AcademicController{


    private AcademicRepository academicRepository;

    public AcademicController(AcademicRepository academicRepository) {
        this.academicRepository = academicRepository;

    }@Get("/")
    public String index() {

        try {
            List<Academic> academic = academicRepository.findAll();
            AcademicResponse response = new AcademicResponse("ok", "Data Academic", academic);

            return new Gson().toJson(response);
        } catch(Exception e) {
            String message = e.getMessage();
            AcademicResponse response = new AcademicResponse("error", message);
            return new Gson().toJson(response);
        }
    }

   

}
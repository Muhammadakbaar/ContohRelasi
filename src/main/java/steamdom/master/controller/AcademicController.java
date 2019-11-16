package steamdom.master.controller;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import steamdom.master.model.Academic;
import steamdom.master.repository.AcademicRepositoryInf;

@Controller("/academic")
public class AcademicController{

    private AcademicRepositoryInf repository;

    AcademicController(AcademicRepositoryInf r){
        this.repository = r;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public String index(@QueryValue int page, @QueryValue int limit){
        List<Academic> academic = repository.findAll(page, limit);
        HashMap<String, Object> data = new HashMap<>();
        data.put("page", Math.ceil(repository.size() / limit));
        data.put("data", academic);
        return (new Gson()).toJson(data);
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String show(@PathVariable Long id) {
        return (new Gson()).toJson(repository.findById(id));
    }

    @Post(consumes=MediaType.APPLICATION_JSON)
    public String save(@Body Academic t) {
        HashMap<String, Object> data = new HashMap<>();
        if (repository.save(t)) {
            data.put("status", "ok");
        } else {
            data.put("status", "fail");
        }
        return (new Gson()).toJson(data);
    }

    // @Put(consumes=MediaType.APPLICATION_JSON)
    // public String update(@Body Academic c) {
    //     HashMap<String, Object> data = new HashMap<>();
    //     if (repository.update(c.getId(),c.getId_classes(), 
    //     c.getName_classes())) {
    //         data.put("status", "ok");
    //     } else {
    //         data.put("status", "fail");
    //     }
    //     return (new Gson()).toJson(data);
    // }

    // @Delete("/{id}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public String destroy(@PathVariable Long id) {
    //     HashMap<String, Object> data = new HashMap<>();
    //     if (repository.destroy(id)) {
    //         data.put("status", "ok");
    //     } else {
    //         data.put("status", "fail");
    //     }
    //     return (new Gson()).toJson(data);
    }


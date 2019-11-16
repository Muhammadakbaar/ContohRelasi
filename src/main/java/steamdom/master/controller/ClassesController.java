/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamdom.master.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.*;
import java.util.HashMap;
import java.util.List;

import steamdom.master.model.Classes;
import steamdom.master.repository.ClassesRepositoryInf;
import com.google.gson.*;


@Controller("/classes")
public class ClassesController {

    private ClassesRepositoryInf repository;

    ClassesController(ClassesRepositoryInf r) {
        this.repository = r;
    }
    
    @Get(produces = MediaType.APPLICATION_JSON)
    public String index(@QueryValue int page, @QueryValue int limit) {
        List<Classes> classes = repository.findAll(page, limit);
        HashMap<String, Object> data = new HashMap<>();
        data.put("page", Math.ceil(repository.size() / limit));
        data.put("data", classes);
        return (new Gson()).toJson(data);
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String show(@PathVariable Long id) {
        return (new Gson()).toJson(repository.findById(id));
    }

    @Post(consumes=MediaType.APPLICATION_JSON)
    public String save(@Body Classes t) {
        HashMap<String, Object> data = new HashMap<>();
        if (repository.save(t)) {
            data.put("status", "ok");
        } else {
            data.put("status", "fail");
        }
        return (new Gson()).toJson(data);
    }

    // @Put(consumes=MediaType.APPLICATION_JSON)
    // public String update(@Body Classes c) {
    //     HashMap<String, Object> data = new HashMap<>();
    //     if (repository.update(c.getId(), c.getCode(), c.getName())) {
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



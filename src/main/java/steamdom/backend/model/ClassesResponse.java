package steamdom.backend.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

// response materi
public class ClassesResponse {
    public String status;
    public String message;
    public ArrayList<Classes> data;

    public ClassesResponse(String status, String message, List<Classes> classes) {
        this.status = status;
        this.message = message;
        this.data = new ArrayList<Classes>();

        for(Classes item:classes) {
            this.data.add(item);
        }
    }

    public ClassesResponse(String status, String message, Classes classes) {
        this.status = status;
        this.message = message;

        this.data = new ArrayList<Classes>();

        if(classes != null) {
            this.data.add(classes);   
        }
    }

    public ClassesResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
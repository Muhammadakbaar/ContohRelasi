package steamdom.backend.model;

import java.util.List;

import java.util.ArrayList;
import steamdom.backend.model.Academic;

/**
 * Author : supi.core@gmail.com | github.com/sup1core
 */

public class AcademicResponse {
    public String status;
    public String message;
    public ArrayList<Academic> data;

    public AcademicResponse(String status, String message, List<Academic> academic) {
        this.status = status;
        this.message = message;
        this.data = new ArrayList<Academic>();

        for(Academic item:academic) {
            this.data.add(item);
        }
    }

    public AcademicResponse(String status, String message, Academic academic) {
        this.status = status;
        this.message = message;

        this.data = new ArrayList<Academic>();

        if(academic != null) {
            this.data.add(academic);   
        }
    }

    public AcademicResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
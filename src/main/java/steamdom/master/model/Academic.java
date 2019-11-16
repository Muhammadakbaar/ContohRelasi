package steamdom.master.model;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "academic")
public class Academic{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @ManyToOne
    @JoinColumn (name="name_classes")
    @JoinColumn (name="id_classes")
    private Classes classes;
    private String name_classes;
    private int id_classes;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // id_class | int 11
    public int getId_classes(){
        return id_classes;
    }

    public void setId_classes(int id_classes){
        this.id_classes = id_classes;
    }

    // name_class | varchar 255
    public String getName_classes(){
        return name_classes;
    }

    public void setName_classes(String name_classes){
        this.name_classes = name_classes;
    }

}
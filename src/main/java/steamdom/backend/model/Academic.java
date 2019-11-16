package steamdom.backend.model;

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
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@ManyToOne(optional=false)  
@JoinColumn(name = "id_classes", referencedColumnName="id", insertable = false, updatable = false)
private Classes classes;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}


}




    
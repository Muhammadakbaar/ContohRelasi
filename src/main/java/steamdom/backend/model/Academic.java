package steamdom.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "academic")
public class Academic{
    
@Id   
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

// @ManyToOne
// @JoinColumn(name = "id_classes", referencedColumnName="id", insertable = false, updatable = false)
// private Classes classes;
// private Long id_classes;

@NotNull(message = "Classes harus diisi.")
@Column(name = "name")
private String name;



public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
// public Long getId_classes() {
//     return id_classes;
// }

// public void setId_classes(Long id_classes) {
//     this.id_classes = id_classes;
// }
}




    
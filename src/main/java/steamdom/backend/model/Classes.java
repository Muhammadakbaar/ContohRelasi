
package steamdom.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "classes")
public class Classes {
    @OneToOne(optional=false)
    @JoinColumn (name="id_academic",referencedColumnName="id", insertable = false, updatable = false)
    private Academic academic;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Kode classes harus diisi.")
    private String id_academic;
    @NotNull(message = "Nama Kelas harus diisi.")
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
//
    public String getId_academic() {
        return id_academic;
    }

    public void setId_academic(String id_academic) {
        this.id_academic = id_academic;
    }
//

   
}

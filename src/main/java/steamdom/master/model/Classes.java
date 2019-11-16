/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamdom.master.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "classes")
public class Classes {
    
    public Classes(){

    }

    // public Classes(@NotNull String name){
    //     this.class_name = name;
    // }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany
    @JoinColumn(name = "id")
    private Long id;

    //
    @ManyToMany
    @JoinColumn (name="id_academic")
    private Academic academic;
    private String id_academic;
    //
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

package org.example;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Audited
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    private List<Articulo> articulos = new ArrayList<Articulo>();

    public Categoria() {

    }

    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }
}

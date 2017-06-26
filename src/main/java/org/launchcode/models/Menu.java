package org.launchcode.models;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

/**
 * Created by rebeccahubbard on 6/25/17.
 */
@Entity
public class Menu {

    public Menu(String name) {
        this.name = name;
    }

    public Menu() {

    }

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    private List<Cheese> cheeses;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Cheese item) {
        cheeses.add(item);
    }

}

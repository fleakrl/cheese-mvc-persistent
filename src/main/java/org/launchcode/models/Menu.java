package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by rebeccahubbard on 6/25/17.
 */
@Entity
public class Menu {

    public Menu(String name) {
        this.name = name;
    }

    public Menu(){

    }

    private String name;

   private Integer id;

   private List<Cheese> cheeses;


    public Integer getId() {
        return id;
    }

    @ManyToMany
    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Cheese item){
        cheeses.add(item);
    }

}

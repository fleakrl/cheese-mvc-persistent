package org.launchcode.models;

import javax.validation.constraints.NotNull;

/**
 * Created by rebeccahubbard on 6/26/17.
 */
public class AddMenuItemForm {

    public AddMenuItemForm(Menu menu, Iterable<Cheese> cheeses) {
        this.menu = menu;
        this.cheeses = cheeses;
    }

    public AddMenuItemForm(){

    }

    private Menu menu;
    private Iterable<Cheese> cheeses;

    @NotNull
    private Integer menuId;

    @NotNull
    private Integer cheeseId;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(Integer cheeseId) {
        this.cheeseId = cheeseId;
    }

    public Menu getMenu() {
        return menu;
    }

    public Iterable<Cheese> getCheeses() {
        return cheeses;
    }
}

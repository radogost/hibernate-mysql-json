package rg.hjson.entities;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Type(type = "rg.hjson.db.types.JsonType",
            parameters = {
                    @Parameter(
                            name = "classType",
                            value = "rg.hjson.entities.Dish"
                    )
            })
    @Column(name = "dish")
    private Dish dish;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long id) {
        this.menuId = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}

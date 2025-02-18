
package traditionalfeast.model;

public class FeastMenu {
    private String menuId;
    private String nameMenu;
    private String price;
    private String ingredients;

    public FeastMenu(String menuId, String nameMenu, String price, String ingredients) {
        this.menuId = menuId;
        this.nameMenu = nameMenu;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "FeastMenu{" + "menuId=" + menuId + ", nameMenu=" + nameMenu + ", price=" + price + ", ingredients=" + ingredients + '}';
    }
    
}

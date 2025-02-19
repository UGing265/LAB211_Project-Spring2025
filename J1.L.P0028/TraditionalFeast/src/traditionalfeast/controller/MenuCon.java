package traditionalfeast.controller;
import java.util.ArrayList;

import traditionalfeast.model.I_Menu;
import traditionalfeast.utils.InputUtils;

public class MenuCon extends ArrayList<String> implements I_Menu {

    public MenuCon() {
        super();
    }

    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public void showMenu() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        boolean result= false;
        result= InputUtils.confirmYesNo(welcome);
        return result;
    }

    @Override
    public int getChoice() {
        return InputUtils.getInt("Input your choice:", 1, this.size());
        }

}

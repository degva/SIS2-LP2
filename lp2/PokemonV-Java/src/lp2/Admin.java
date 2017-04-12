package lp2;

import javax.swing.DefaultListModel;

public class Admin extends User {

    public Admin(String username, String password, String name, String email, int pos_x, int pos_y, Direction direction, DefaultListModel<Item> bag) {
        super(username, password, name, email, pos_x, pos_y, direction, bag);
    }

    public void kick() {

    }

    public void addSpawn() {

    }
}

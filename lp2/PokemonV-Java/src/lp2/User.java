
package lp2;

import javax.swing.DefaultListModel;

enum Direction {
    Right,Left,Up,Down
}

public class User {
    protected String username;
    protected String password;
    protected String name;
    protected String email;
    protected int pos_x;
    protected int pos_y;
    protected Direction direction;
    protected DefaultListModel<Item> bag;

    public User(String username, String password, String name, String email, int pos_x, int pos_y, Direction direction, DefaultListModel<Item> bag) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.direction = direction;
        this.bag = bag;
    }
    
    
    public Boolean move(){
        return true;
    }
    public void login(){
        
    }
    public void logout(){
        
    }
    public void talk(){
        
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}

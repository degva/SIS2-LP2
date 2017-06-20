package com.grupox.pokemonv.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MapDA {
    /* Attributes */
    private Connection con;
    
    /* Constructors */
    public MapDA(){
    }
    
    /* Methods */
    private void openConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://50.62.209.73/inf282", "inf282", "inf282lp2");
    }
}

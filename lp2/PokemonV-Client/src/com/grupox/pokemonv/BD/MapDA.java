package com.grupox.pokemonv.BD;

import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Tile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapDA {
    /* Attributes */
    private Connection con;
    
    /* Constructors */
    public MapDA(){
    }
    
    /* Methods */
    public Map getMap(){
        Map map = null;
        try {
            openConnection();
            
            map = readMap();
            
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MapDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    private Map readMap() throws SQLException{
        Map map = new Map();
        Statement st = con.createStatement();
        String query = "SELECT * FROM MAP WHERE ID=1";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            map.setHeight(rs.getInt("height"));
            map.setHeight(rs.getInt("width"));
            break;
        }
        
        readTiles(map);
        
        return map;
    }
    
    private Tile[][] readTiles(Map map) throws SQLException{
        Tile[][] grid = new Tile[map.getWidth()][map.getHeight()];
        
        Statement st = con.createStatement();
        String query = "SELECT * FROM TILE WHERE MAP_ID=1";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            //Tile tile = 
            break;
        }
        
        return grid;
    }
    
    private void openConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://50.62.209.73/inf282", "inf282", "inf282lp2");
    }
    
    private void closeConnection() throws SQLException {
        con.close();
    }
}

package com.grupox.pokemonv.BD;

import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Tile;
import com.grupox.pokemonv.model.Player;
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
        String query = "SELECT * FROM MAP WHERE ID = 1;";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            map.setHeight(rs.getInt("height"));
            map.setWidth(rs.getInt("width"));
            break;
        }
        
        readTiles(map);
        
        return map;
    }
    
    private void readTiles(Map map) throws SQLException{
        map.setGrid( new Tile[map.getWidth()][map.getHeight()] );
        
        Statement st = con.createStatement();
        String query = "SELECT * FROM TILE WHERE MAP_ID=1";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            // Read
            int type = rs.getInt("TYPE");
            int user_id = rs.getInt("USER_ID");
            boolean item_enabled = rs.getBoolean("item_enabled");
            int x = rs.getInt("X");
            int y = rs.getInt("Y");
            
            // Set
            map.getGrid()[x][y] = new Tile(getType(type), getUser(user_id), item_enabled, map);
        }
    }
    
    private Player getUser(int id) throws SQLException{
        Player user = null;
        return user;
    }
    
    private void openConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282gx","inf282gx","m8h53r9A6xBfeOe6");
    }
    
    private void closeConnection() throws SQLException {
        con.close();
    }
    
    private Tile.Type getType(int id){
        Tile.Type type = Tile.Type.FLR01;
        switch (id){
            case 1:
                type = Tile.Type.FLR01;
                break;
            case 2:
                type = Tile.Type.FLR02;
                break;
            case 3:
                type = Tile.Type.FLR03;
                break;
            case 4:
                type = Tile.Type.SGN01;
                break;
            case 5:
                type = Tile.Type.GRA00;
                break;
            case 6:
                type = Tile.Type.GRA01;
                break;
            case 7:
                type = Tile.Type.GRA02;
                break;
            case 8:
                type = Tile.Type.GRA03;
                break;
            case 9:
                type = Tile.Type.GRA04;
                break;
            case 10:
                type = Tile.Type.GRA05;
                break;
            case 11:
                type = Tile.Type.GRA06;
                break;
            case 12:
                type = Tile.Type.GRA07;
                break;
            case 13:
                type = Tile.Type.GRA08;
                break;
            case 14:
                type = Tile.Type.GRA09;
                break;
            case 15:
                type = Tile.Type.SND01;
                break;
            case 16:
                type = Tile.Type.SND02;
                break;
            case 17:
                type = Tile.Type.SND03;
                break;
            case 18:
                type = Tile.Type.SND04;
                break;
            case 19:
                type = Tile.Type.SND05;
                break;
            case 20:
                type = Tile.Type.SND06;
                break;
            case 21:
                type = Tile.Type.SND07;
                break;
            case 22:
                type = Tile.Type.SND08;
                break;
            case 23:
                type = Tile.Type.SND09;
                break;
            case 24:
                type = Tile.Type.TRG01;
                break;
            case 25:
                type = Tile.Type.TRG02;
                break;
            case 26:
                type = Tile.Type.TRG03;
                break;
            case 27:
                type = Tile.Type.HO101;
                break;
            case 28:
                type = Tile.Type.HO102;
                break;
            case 29:
                type = Tile.Type.HO103;
                break;
            case 30:
                type = Tile.Type.HO104;
                break;
            case 31:
                type = Tile.Type.HO105;
                break;
            case 32:
                type = Tile.Type.HO106;
                break;
            case 33:
                type = Tile.Type.HO107;
                break;
            case 34:
                type = Tile.Type.HO108;
                break;
            case 35:
                type = Tile.Type.HO109;
                break;
            case 36:
                type = Tile.Type.HO110;
                break;
            case 37:
                type = Tile.Type.HO111;
                break;
            case 38:
                type = Tile.Type.HO112;
                break;
            default:
                type = Tile.Type.FLR01;
                break;
        }
        return type;
    }
}

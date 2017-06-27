package com.grupox.pokemonv.BD;

import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.model.Attack;
import com.grupox.pokemonv.model.Dialog;
import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.Pokeball;
import com.grupox.pokemonv.model.Pokemon;
import com.grupox.pokemonv.model.Potion;
import com.grupox.pokemonv.model.Renderable;
import com.grupox.pokemonv.model.Renderable.Direction;
import com.grupox.pokemonv.model.Tile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccess {
    /* Attributes */
    private final String HOSTNAME = "quilla.lab.inf.pucp.edu.pe";
    private final String USER = "inf282gx";
    private final String BD = "inf282gx";
    private final String PASSWORD = "m8h53r9A6xBfeOe6";
    
    /* Constructor */
    public DataAccess(){
    }
    
    /* Methods */
    
    /**
     * Returns a map with everything inside loaded.
     */
    public Map loadMap(int level, int player_id, InputHandler input, Game game){
        if (level != 1) return null;
        
        try {
            Map map = new Map();
            
            Connection con = openConnection();
            
            Statement st = con.createStatement();
            String query = "SELECT * FROM MAP WHERE ID = " + level;
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                map.setHeight(rs.getInt("height"));
                map.setWidth(rs.getInt("width"));
                map.setProbPokemon(rs.getFloat("prob_pokemon"));
                map.setProbItem(rs.getFloat("prob_item"));
                map.setGame(game);
                break;
            }
            
            loadTiles(map, player_id , input, con, level, game);
            
            closeConnection(con);

            return map;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getStackTrace());
            return null;
        }
    }
    
    public ArrayList<Pokemon> loadAllPokemons(){
        ArrayList<Pokemon> list = new ArrayList<>();
        try{
            Connection con = openConnection();
            
            Statement st = con.createStatement();
            String query = "SELECT p.*, a1.NAME AS NAME1, a1.POINTS AS POINTS1, a2.NAME AS NAME2, a2.POINTS AS POINTS2 " +
                           "FROM POKEMON p, ATTACK a1, ATTACK a2 WHERE p.DELETED=0 " + 
                           " AND p.ATTACK_1_ID = a1.ID AND p.ATTACK_2_ID = a2.ID AND p.ID != 5 AND p.ID!=6";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                Pokemon pk = readPokemon(rs);
                list.add(pk);
            }
            
            closeConnection(con);
            
        }catch(Exception ex){
            System.out.println(ex.getStackTrace());
        }
        return list;
    }
    
    private void loadTiles(Map map, int player_id, InputHandler input, Connection con, int level, Game game) throws SQLException{
        map.setGrid( new Tile[map.getWidth()][map.getHeight()] );
        
        Statement st = con.createStatement();
        String query = "SELECT * FROM TILE WHERE MAP_ID=" + level;
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            // Read
            String type = rs.getString("TYPE");
            int tile_player_id = rs.getInt("PLAYER_ID");
            boolean item_enabled = rs.getBoolean("item_enabled");
            int x = rs.getInt("X");
            int y = rs.getInt("Y");
            if(type.equals("TRW01")){
            }
            // Set
            Tile tile = new Tile(Tile.Type.valueOf(type), null, item_enabled, map);
            tile.setPlayer(loadPlayer(tile_player_id, player_id, input, con, tile, game));
//            map.getGrid()[x][y] = new Tile(Tile.getType(type), loadPlayer(tile_player_id, player_id, input, con, this, game), item_enabled, map);
            map.getGrid()[x][y] = tile;
        }
    }
    
    private Player loadPlayer(int tile_player_id, int logged_player_id, InputHandler input, Connection con, Tile tile, Game game) throws SQLException{
        if(tile_player_id == 0) return null;
        
        Statement st = con.createStatement();
        String query = "SELECT p.*, dBattle.CONTENT AS BATTLE_CONTENT, dDefeat.CONTENT AS DEFEAT_CONTENT " + 
                       "FROM PLAYER p, DIALOG dBattle, DIALOG dDefeat " +
                       " WHERE p.ID=" + tile_player_id + " AND p.BATTLE_DIALOG_ID = dBattle.ID and " +
                       " p.DEFEAT_DIALOG_ID = dDefeat.ID";
        ResultSet rs = st.executeQuery(query);
        
        Player.NPC_TYPE npcType = null;
        String defeatDialog = "";
        String battleDialog = "";
        boolean canBattle = false;
        Direction dir = Direction.DOWN;
        while(rs.next()){
            npcType = Player.NPC_TYPE.valueOf(rs.getString("NPC_TYPE"));
            defeatDialog = rs.getString("DEFEAT_CONTENT");
            battleDialog = rs.getString("BATTLE_CONTENT");
            canBattle = rs.getBoolean("CAN_BATTLE");
            dir = Direction.valueOf(rs.getString("DIRECTION"));
            break;
        }
        // I only want one player
        if(npcType == Player.NPC_TYPE.PLAYER && tile_player_id != logged_player_id){
            return null;
        }
        Player player;
        if(tile_player_id == logged_player_id){
            player = new Player(input);
            game.setPlayer(player);
        }else{
            player = new Player(null);
        }
        player.setId(tile_player_id);
        player.setTile(tile);
        player.setNpcType(npcType);
        player.setBattleDialog(new Dialog(battleDialog));
        player.setDefeatDialog(new Dialog(defeatDialog));
        player.setCanBattle(canBattle);
        player.setDirection(dir);
        
        player.setPokemons(loadPokemons(tile_player_id, con));
        loadItems(player, tile_player_id,con);
        
        return player;
    }
    
    private ArrayList<Pokemon> loadPokemons(int player_id, Connection con) throws SQLException{
        
        Statement sentencia = con.createStatement();
        String query =  "SELECT distinct p.ID, p.NAME, p.TYPE, p.DEFENSE_PTS, p.LIFE ,a1.NAME as NAME1, a1.POINTS as POINTS1, a2.NAME as NAME2, a2.POINTS as POINTS2 " + 
                        "FROM inf282gx.PLAYER_X_POKEMON pp, inf282gx.POKEMON p , inf282gx.ATTACK a1, inf282gx.ATTACK a2 " +
                        "where pp.PLAYER_ID = "+player_id+ " AND p.DELETED = 0 AND pp.DELETED = 0 AND pp.POKEMON_ID = p.ID AND a1.ID = p.ATTACK_1_ID AND a2.ID = p.ATTACK_2_ID " +
                        "order by pp.ORDER_POKEMON ";

        ResultSet rs = sentencia.executeQuery(query);
        
        ArrayList<Pokemon> listaPokemones = new ArrayList<Pokemon>();
        
        Pokemon.TypeP typeP = Pokemon.TypeP.Electric;
        while(rs.next()){
            listaPokemones.add(readPokemon(rs));
        }
        return listaPokemones;
    }
    
    private void loadItems(Player player, int tile_player_id, Connection con) throws SQLException{
        Statement st = con.createStatement();
        String query = "SELECT *" +
                        "FROM(" +
                        "SELECT distinct i.CATCH_PROB, pi.QUANTITY AS POKEBALL_QUANTITY " +
                        "FROM inf282gx.PLAYER_X_ITEM pi, inf282gx.ITEM i " +
                        "WHERE pi.ITEM_ID = i.ID AND pi.PLAYER_ID =" + tile_player_id + " AND i.ID = 2) pokeball, " +
                        "(" +
                        "SELECT distinct i.HP, pi.QUANTITY AS POTION_QUANTITY " +
                        "FROM inf282gx.PLAYER_X_ITEM pi, inf282gx.ITEM i " +
                        "WHERE pi.ITEM_ID = i.ID AND pi.PLAYER_ID = " + tile_player_id + " AND i.ID = 1) potion ";
        ResultSet rs = st.executeQuery(query);
        
        float catchProb = 0;
        int pokQuantity = 0, hp = 0, potQuantity = 0;
        while(rs.next()){
            catchProb = rs.getFloat("CATCH_PROB");
            pokQuantity = rs.getInt("POKEBALL_QUANTITY");
            
            hp = rs.getInt("HP");
            potQuantity = rs.getInt("POTION_QUANTITY");
            break;
        }
        player.setPokeballs(new Pokeball(catchProb, pokQuantity));
        player.setPotions(new Potion(hp, potQuantity));
    }
    
    private Pokemon readPokemon(ResultSet rs) throws SQLException{
        Pokemon.TypeP typeP = Pokemon.TypeP.Electric;
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        String type = rs.getString("TYPE");
        String attack1_name = rs.getString("NAME1");
        int attack1_pts = rs.getInt("POINTS1");
        String attack2_name = rs.getString("NAME2");
        int attack2_pts = rs.getInt("POINTS2");
        int defense_pts = rs.getInt("DEFENSE_PTS");
        int life = rs.getInt("LIFE");

        //para seleccionar el tipo de pokemon
        if(type.compareTo("Earth")==0) typeP = Pokemon.TypeP.Earth;
        if(type.compareTo("Water")==0 ) typeP = Pokemon.TypeP.Water;
        if(type.compareTo("Fire")==0 ) typeP = Pokemon.TypeP.Fire;
        if(type.compareTo("Wind")==0 ) typeP = Pokemon.TypeP.Wind;
        if(type.compareTo("Electric")==0 ) typeP = Pokemon.TypeP.Electric;

        return new Pokemon(id, new Attack(attack1_name, attack1_pts), new Attack(attack2_name, attack2_pts),
                                    defense_pts,life, name, typeP, false);
    }
    
    private Connection openConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://" + HOSTNAME + "/" + BD, USER, PASSWORD);
    }
    
    private void closeConnection(Connection con) throws SQLException{
        con.close();
    }
    
    public int verifyLogin(String username,String password){
        
        
        char character = '"';
        String sql= "SELECT * FROM PLAYER WHERE USERNAME = " + character + username + character
                + " AND PASSWORD = " + character + password + character;
        
        try{
            Connection connection = openConnection();
            Statement sentencia = connection.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            
            if(rs.next()){
                Game.player_id = rs.getInt("id");
                return 1;
            }else {
                return 0;
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            return 0;
        }
        
    }
    
    public void updateData(int level, int player_id, InputHandler input, Game game){
        try{
            Connection con = openConnection();
            String query =  "UPDATE inf282gx.MAP SET height="+
                            " WHERE ID="+String.valueOf(level)+
                            " and POKEMON_ID=";
            Statement sentencia = con.prepareStatement(query);
            int n = sentencia.executeUpdate(query);
            
        }
        catch(Exception e){
            
        }
    }
    
    
}

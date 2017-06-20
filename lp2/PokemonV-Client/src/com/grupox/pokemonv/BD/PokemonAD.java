/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.BD;

import static com.grupox.pokemonv.controller.PokemonBeltManager.indiceA;
import static com.grupox.pokemonv.controller.PokemonBeltManager.indiceB;
import com.grupox.pokemonv.model.Pokemon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alulab14
 */
public class PokemonAD {
    
    private ArrayList<Pokemon> listaPokemones;

    
    public PokemonAD(){
        //leerListPokemon(4);
    }
    public void leerListPokemon(int idUser){
        listaPokemones = new ArrayList<>();
        Pokemon.TypeP tipoE = Pokemon.TypeP.Earth;
        Pokemon.TypeP tipoF = Pokemon.TypeP.Fire;
        Pokemon.TypeP tipoWa = Pokemon.TypeP.Water;
        Pokemon.TypeP tipoWi = Pokemon.TypeP.Wind;
        try{
            //registrar el driver
            Class.forName("com.mysql.jdbc.Driver");
            //establecer la conexion
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282gx","inf282gx","m8h53r9A6xBfeOe6");
            System.out.println("la conexion se ha realizado");
            Statement sentencia = con.createStatement();
            String query =  "SELECT distinct p.ID, p.NAME, p.TYPE, p.ATTACK_PTS, p.DEFFENSE_PTS, p.LIFE \n" +
                            "FROM inf282gx.PLAYER_X_POKEMON pp, inf282gx.POKEMON p \n" +
                            "where pp.PLAYER_USER_ID = "+String.valueOf(idUser)+" AND p.DELETED = 0 AND pp.POKEMON_ID = p.ID\n"
                            + "order by pp.ORDER_POKEMON ";

            ResultSet rs = sentencia.executeQuery(query);
            while(rs.next()){

                String id = rs.getString("ID");
                String name = rs.getString("NAME");
                String type = rs.getString("TYPE");
                String attack_pts = rs.getString("ATTACK_PTS");
                String defense_pts = rs.getString("DEFFENSE_PTS");
                String life = rs.getString("LIFE");

                System.out.println(id+" "+attack_pts+" "+defense_pts+" "+name+" "+life+" "+type);
                Pokemon pok = new Pokemon(Integer.parseInt(id), Integer.parseInt(attack_pts), Integer.parseInt(defense_pts),Integer.parseInt(life), name, tipoE);
                listaPokemones.add(pok);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void intercambiarDA(Pokemon pokA, Pokemon pokB, int idUser){
        try{
        //registrar el driver
            Class.forName("com.mysql.jdbc.Driver");
            //establecer la conexion
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282gx","inf282gx","m8h53r9A6xBfeOe6");
            System.out.println("la conexion se ha realizado");
            
            System.out.println(indiceA);
            String query =  "UPDATE inf282gx.PLAYER_X_POKEMON SET ORDER_POKEMON="+String.valueOf(indiceA+1)
                            +" WHERE PLAYER_USER_ID="+String.valueOf(idUser)+
                            " and POKEMON_ID="+String.valueOf(pokB.id);
            Statement sentencia = con.prepareStatement(query);
            System.out.println(query);
            int n = sentencia.executeUpdate(query);
            
            System.out.println(indiceB);
            query = "UPDATE inf282gx.PLAYER_X_POKEMON SET ORDER_POKEMON="+String.valueOf(indiceB+1)
                    +" WHERE PLAYER_USER_ID="+String.valueOf(idUser)+
                    " and POKEMON_ID="+String.valueOf(pokA.id);
            
            n = sentencia.executeUpdate(query);
            System.out.println("Se itercambio!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public ArrayList<Pokemon> getListaPokemones(int idUser) {
        leerListPokemon(idUser);
        return listaPokemones;
    }
    
}

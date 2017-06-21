using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entidades;
using MySql.Data.MySqlClient;

namespace AccesoDatos
{
    public class PlayersPokemonDA
    {
        
        public PlayersPokemonDA()
        {

        }


        public int deletePokemonOfPlayer(int idpokemon, int idplayer)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE PLAYER_X_POKEMON SET DELETED = '1' "
                + "where POKEMON_ID = " + caracter + idpokemon + caracter + "AND PLAYER_USER_ID = " + caracter + idplayer + caracter ;

                cmd.Connection = conexion.conn;
                cmd.CommandText = sql;
                cmd.ExecuteNonQuery();
                conexion.cerrarConexion();
                return 1;
            }
            catch (Exception ex)
            {
                return 0;
            }
        }

        public int updatePlayersPokemon(int newidpokemon, int neworder, int newidplayer, int lastidpokemon, int lastidplayer, int lastorder)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE PLAYER_X_POKEMON SET POKEMON_ID = " + caracter + newidpokemon + caracter + ", ORDER_POKEMON = " + caracter + neworder + caracter + ", PLAYER_USER_ID = "
                    + caracter + newidplayer + caracter 
                + "where PLAYER_USER_ID = " + caracter + lastidplayer + caracter + "AND POKEMON_ID = " + caracter + lastidpokemon + caracter 
                + "AND ORDER_POKEMON = " + caracter + lastorder + caracter;

                cmd.Connection = conexion.conn;
                cmd.CommandText = sql;
                cmd.ExecuteNonQuery();
                conexion.cerrarConexion();
                return 1;
            }
            catch (Exception ex)
            {
                return 0;
            }
        }


        public int addPlayersPokemon(int playerid, int pokemonid, int order)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO PLAYER_X_POKEMON (PLAYER_USER_ID,POKEMON_ID,ORDER_POKEMON,DELETED)values('{playerid}','{pokemonid}', '{order}' , '{0}')";
                cmd.Connection = conexion.conn;
                cmd.CommandText = sql;
                cmd.ExecuteNonQuery();
                conexion.cerrarConexion();
                return 1;
            }
            catch (Exception ex)
            {
                return 0;
            }

        }

    }
}

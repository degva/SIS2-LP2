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
        


        public int deletePokemonOfPlayer(int idpokemon, int idplayer)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE PLAYER_X_POKEMON SET DELETED = '1' "
                + "where POKEMON_ID = " + character + idpokemon + character + "AND PLAYER_USER_ID = " + character + idplayer + character ;

                cmd.Connection = connection.conn;
                cmd.CommandText = sql;
                cmd.ExecuteNonQuery();
                connection.closeConnection();
                return 1;
            }
            catch (Exception ex)
            {
                return 0;
            }
        }

        public int updatePlayersPokemon(int newidpokemon, int neworder, int newidplayer, int lastidpokemon, int lastidplayer, int lastorder)
        {
            char character = '"';
            try
            {
                Connection connection = new Connection();

                if(newidplayer == lastidplayer)
                {

                    MySqlCommand cmd = new MySqlCommand();
                    string sql = "SELECT * FROM PLAYER_X_POKEMON WHERE PLAYER_USER_ID =" + character + newidplayer + character + "AND ORDER_POKEMON = " + character + neworder + character;
                    cmd.Connection = connection.conn;
                    cmd.CommandText = sql;
                    MySqlDataReader reader = cmd.ExecuteReader();

                    if (reader.HasRows)
                    {
                        
                    }
                    else
                    {
                        MySqlCommand cmd1 = new MySqlCommand();
                        string sql1 = "UPDATE PLAYER_X_POKEMON SET POKEMON_ID = " + character + newidpokemon + character + ", ORDER_POKEMON = " + character + neworder + character + ", PLAYER_USER_ID = "
                            + character + newidplayer + character
                        + "where PLAYER_USER_ID = " + character + lastidplayer + character + "AND POKEMON_ID = " + character + lastidpokemon + character
                        + "AND ORDER_POKEMON = " + character + lastorder + character;

                        cmd1.Connection = connection.conn;
                        cmd1.CommandText = sql1;
                        cmd1.ExecuteNonQuery();
                    }
                }else if(newidplayer != lastidplayer)
                {

                }

                
                connection.closeConnection();
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
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO PLAYER_X_POKEMON (PLAYER_USER_ID,POKEMON_ID,ORDER_POKEMON,DELETED)values('{playerid}','{pokemonid}', '{order}' , '{0}')";
                cmd.Connection = connection.conn;
                cmd.CommandText = sql;
                cmd.ExecuteNonQuery();
                connection.closeConnection();
                return 1;
            }
            catch (Exception ex)
            {
                return 0;
            }

        }

    }
}

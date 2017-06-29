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
        


        public int deletePokemonOfPlayer(int idpokemon, int idplayer, int order)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE PLAYER_X_POKEMON SET DELETED = '1' "
                + "where POKEMON_ID = " + character + idpokemon + character + "AND PLAYER_ID = " + character + idplayer + character 
                + "AND ORDER_POKEMON = " + character + order + character;

                cmd.Connection = connection.conn;
                cmd.CommandText = sql;
                cmd.ExecuteNonQuery();
                connection.closeConnection();
                return 1;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
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

                    connection = new Connection();
                    MySqlCommand cmd = new MySqlCommand();
                    string sql = "SELECT * FROM PLAYER_X_POKEMON WHERE PLAYER_ID =" + character + newidplayer + character + "AND ORDER_POKEMON = " + character + neworder + character;
                    cmd.Connection = connection.conn;
                    cmd.CommandText = sql;
                    MySqlDataReader reader = cmd.ExecuteReader();

                    if (reader.HasRows)
                    {

                        connection = new Connection();
                        MySqlCommand cmd2 = new MySqlCommand();
                        string sql2 = "UPDATE PLAYER_X_POKEMON SET ORDER_POKEMON = " + character + lastorder + character + ", PLAYER_ID = "
                            + character + lastidplayer + character
                        + "where PLAYER_ID = " + character + newidplayer + character
                        + "AND ORDER_POKEMON = " + character + neworder + character;

                        cmd2.Connection = connection.conn;
                        cmd2.CommandText = sql2;
                        cmd2.ExecuteNonQuery();

                    }
                    else
                    {
                        
                    }
                    connection = new Connection();
                    MySqlCommand cmd1 = new MySqlCommand();
                    string sql1 = "UPDATE PLAYER_X_POKEMON SET POKEMON_ID = " + character + newidpokemon + character + ", ORDER_POKEMON = " + character + neworder + character + ", PLAYER_ID = "
                        + character + newidplayer + character
                    + "where PLAYER_ID = " + character + lastidplayer + character + "AND POKEMON_ID = " + character + lastidpokemon + character
                    + "AND ORDER_POKEMON = " + character + lastorder + character;

                    cmd1.Connection = connection.conn;
                    cmd1.CommandText = sql1;
                    cmd1.ExecuteNonQuery();

                }
                else if(newidplayer != lastidplayer)
                {

                    connection = new Connection();
                    MySqlCommand cmd3 = new MySqlCommand();
                    string sql3 = "SELECT * FROM PLAYER_X_POKEMON WHERE PLAYER_ID =" + character + newidplayer + character + "AND ORDER_POKEMON = " + character + neworder + character;
                    cmd3.Connection = connection.conn;
                    cmd3.CommandText = sql3;
                    MySqlDataReader reader = cmd3.ExecuteReader();

                    if (reader.HasRows)
                    {
                        return 0;
                    }
                    else
                    {
                        connection = new Connection();
                        MySqlCommand cmd4 = new MySqlCommand();
                        string sql4 = "UPDATE PLAYER_X_POKEMON SET POKEMON_ID = " + character + newidpokemon + character + ", ORDER_POKEMON = " + character + neworder + character + ", PLAYER_ID = "
                            + character + newidplayer + character
                        + "where PLAYER_ID = " + character + lastidplayer + character + "AND POKEMON_ID = " + character + lastidpokemon + character
                        + "AND ORDER_POKEMON = " + character + lastorder + character;

                        cmd4.Connection = connection.conn;
                        cmd4.CommandText = sql4;
                        cmd4.ExecuteNonQuery();
                    }

                }


                connection.closeConnection();
                return 1;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return 0;
            }
        }


        public int addPlayersPokemon(int playerid, int pokemonid, int order, int deleted)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO PLAYER_X_POKEMON (PLAYER_ID,POKEMON_ID,ORDER_POKEMON,DELETED)values('{playerid}','{pokemonid}', '{order}' , '{deleted}')";
                cmd.Connection = connection.conn;
                cmd.CommandText = sql;
                cmd.ExecuteNonQuery();
                connection.closeConnection();
                return 1;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return 0;
            }

        }


        public int exist(int idplayer, int idpokemon)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM PLAYER_X_POKEMON WHERE PLAYER_ID =" + character + idplayer + character + "AND   POKEMON_ID = " + character + idpokemon + character;
                cmd.Connection = connection.conn;
                cmd.CommandText = sql;
                MySqlDataReader reader = cmd.ExecuteReader();

                if (reader.HasRows)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
                reader.Read();

                connection.closeConnection();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return 0;
            }
        }

    }
}

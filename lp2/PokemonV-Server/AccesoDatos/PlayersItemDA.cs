using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entidades;
using MySql.Data.MySqlClient;


namespace AccesoDatos
{
    public class PlayersItemDA
    {

        public int deleteItemOfPlayer(int iditem , int idplayer)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE PLAYER_X_ITEM SET QUANTITY = '0' "
                + "where ITEM_ID = " + character + iditem+ character + "AND PLAYER_ID = " + character + idplayer + character;

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

        public int updatePlayersItem(int newiditem, int newidplayer, int newquantity, int lastiditem, int lastidplayer)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE PLAYER_X_ITEM SET ITEM_ID = " + character + newiditem + character + ", PLAYER_ID = "
                    + character + newidplayer + character + ",QUANTITY = " + character + newquantity + character
                + "where PLAYER_ID = " + character + lastidplayer + character + "AND ITEM_ID = " + character + lastiditem + character;

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

        public int addPlayersItem(int playerid, int itemid, int quantity)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO PLAYER_X_ITEM (PLAYER_ID,ITEM_ID,QUANTITY)values('{playerid}','{itemid}', '{quantity}')";
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



        public int exist(int idplayer, int iditem)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM PLAYER_X_ITEM WHERE PLAYER_ID =" + character + idplayer + character + "AND   ITEM_ID = " + character + iditem + character;
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
                return 0;
            }
        }

    }
}

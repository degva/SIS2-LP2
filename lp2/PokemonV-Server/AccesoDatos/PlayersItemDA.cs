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
                string sql = "UPDATE PLAYER_X_ITEM SET DELETED = '1' "
                + "where ITEM_ID = " + character + iditem+ character + "AND PLAYER_USER_ID = " + character + idplayer + character;

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

        public int updatePlayersItem(int newiditem, int newidplayer, int lastiditem, int lastidplayer)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE PLAYER_X_ITEM SET ITEM_ID = " + character + newiditem + character + ", PLAYER_USER_ID = "
                    + character + newidplayer + character
                + "where PLAYER_USER_ID = " + character + lastidplayer + character + "AND ITEM_ID = " + character + lastiditem + character;

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

        public int addPlayersItem(int playerid, int itemid)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO PLAYER_X_ITEM (PLAYER_USER_ID,ITEM_ID,DELETED)values('{playerid}','{itemid}', '{0}')";
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

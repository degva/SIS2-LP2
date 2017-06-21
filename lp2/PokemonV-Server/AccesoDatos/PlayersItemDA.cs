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
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE PLAYER_X_ITEM SET DELETED = '1' "
                + "where ITEM_ID = " + caracter + iditem+ caracter + "AND PLAYER_USER_ID = " + caracter + idplayer + caracter;

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

        public int updatePlayersItem(int newiditem, int newidplayer, int lastiditem, int lastidplayer)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE PLAYER_X_ITEM SET ITEM_ID = " + caracter + newiditem + caracter + ", PLAYER_USER_ID = "
                    + caracter + newidplayer + caracter
                + "where PLAYER_USER_ID = " + caracter + lastidplayer + caracter + "AND ITEM_ID = " + caracter + lastiditem + caracter;

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

        public int addPlayersItem(int playerid, int itemid)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO PLAYER_X_ITEM (PLAYER_USER_ID,ITEM_ID,DELETED)values('{playerid}','{itemid}', '{0}')";
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

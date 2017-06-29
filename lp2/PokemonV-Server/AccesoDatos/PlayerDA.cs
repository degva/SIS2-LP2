using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entidades;
using MySql.Data.MySqlClient;

namespace AccesoDatos
{
    public class PlayerDA
    {

        public PlayerDA()
        {

        }

        public int addPlayer(Player play)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO PLAYER (NAME,USERNAME,PASSWORD,EMAIL,CAN_BATTLE,BATTLE_DIALOG_ID,DEFEAT_DIALOG_ID,NPC_TYPE,ISADMIN,DIRECTION,DELETED) values('{play.Name}'," +
                    $"              '{play.Username}' , '{play.Password}' , '{play.Email}' , '{play.Can_battle}' , '{play.Battle_dialog_id}' , '{play.Defeat_dialog_id}' , '{play.Npc_type}' , " +
                    $"                      , '{play.IsAdmin}' , '{play.Direction}'  , '{play.Deleted}')";
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


        public int deletePlayer(string cadena)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE PLAYER SET DELETED = '1' " + "where USERNAME = " + character + cadena + character ;

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




        public int updatePlayer(Player play, int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE PLAYER SET USERNAME = " + character + play.Username + character + ", PASSWORD = " + character + play.Password + character 
                    + ", EMAIL = " + character + play.Email + character  + ", NAME = " +character + play.Name + character 
                + "where ID = " + character + id + character;

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


        public int verifyRepeatUsername2(Player play, int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM PLAYER WHERE USERNAME=" + character + play.Username + character + "AND ID <> " + character + id + character ;
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

        public int verifyRepeatUsername(Player play)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM PLAYER WHERE USERNAME =" + character + play.Username + character;
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

        public int verifyRepeatemail(Player play)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM PLAYER WHERE EMAIL = " + character + play.Email + character;
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

        public int verifyRepeatemail2(Player play, int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM PLAYER WHERE EMAIL = " + character + play.Email + character + "AND ID <> " + character + id + character ;
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


        public int verifyID(int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM PLAYER WHERE ID =" + character + id + character +  "AND   ISADMIN = " + character + 0 + character;
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

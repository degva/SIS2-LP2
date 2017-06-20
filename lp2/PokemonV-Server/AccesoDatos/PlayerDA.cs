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
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO USER (NAME,USERNAME,PASSWORD,EMAIL,DELETED,ISADMIN)values('{play.Name}','{play.Username}', '{play.Password}' , '{play.Email}' , '{play.Deleted}'  , '{play.IsAdmin}')";
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


        public int addPlayer2(Player play)
        {
            try
            {

                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string caracter = "'";
                string sql1 = "SELECT * FROM USER WHERE USERNAME=" + caracter + play.Username + caracter;
                cmd.Connection = conexion.conn;
                cmd.CommandText = sql1;
                MySqlDataReader reader = cmd.ExecuteReader();
                reader.Read();

                int id = reader.GetInt32("ID");
                if (reader.HasRows)
                {
                    conexion.cerrarConexion();
                    conexion = new Connection();
                    MySqlCommand cmd1 = new MySqlCommand();
                    string sql2 = $"INSERT INTO PLAYER (USER_ID,LEVEL,EXPERIENCE)values('{id}' , '{1}'  , '{1}')";
                    cmd1.Connection = conexion.conn;
                    cmd1.CommandText = sql2;
                    cmd1.ExecuteNonQuery();
                }

                return 1;

            }
            catch(Exception exp)
            {
                return 0;
            }


        }

        public int deletePlayer(string cadena)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE USER SET DELETED = '1' "
                + "where USERNAME = " + caracter + cadena + caracter ;
                
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




        public int updatePlayer(Player play, int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE USER SET USERNAME = " + caracter + play.Username + caracter + ", PASSWORD = " + caracter + play.Password + caracter 
                    + ", EMAIL = " + caracter + play.Email + caracter  + ", NAME = " +caracter + play.Name + caracter 
                + "where ID = " + caracter + id + caracter;

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


        public int verifyRepeatUsername2(Player play, int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE USERNAME=" + caracter + play.Username + caracter + "AND ID <> " + caracter + id + caracter ;
                cmd.Connection = conexion.conn;
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

                conexion.cerrarConexion();
            }
            catch (Exception ex)
            {
                return 0;
            }
        }

        public int verifyRepeatUsername(Player play)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE USERNAME =" + caracter + play.Username + caracter;
                cmd.Connection = conexion.conn;
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

                conexion.cerrarConexion();
            }
            catch (Exception ex)
            {
                return 0;
            }
        }

        public int verifyRepeatemail(Player play)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE EMAIL = " + caracter + play.Email + caracter;
                cmd.Connection = conexion.conn;
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

                conexion.cerrarConexion();
            }
            catch (Exception ex)
            {
                return 0;
            }
        }

        public int verifyRepeatemail2(Player play, int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE EMAIL = " + caracter + play.Email + caracter + "AND ID <> " + caracter + id + caracter ;
                cmd.Connection = conexion.conn;
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

                conexion.cerrarConexion();
            }
            catch (Exception ex)
            {
                return 0;
            }
        }


    }

}

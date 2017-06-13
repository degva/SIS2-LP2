using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entidades;
using MySql.Data.MySqlClient;


namespace AccesoDatos
{
    public class UsuarioDA
    {

        public UsuarioDA()
        {

        }

        public int agregarUsuario(User u)
        {
            try
            {
                Conexion conexion = new Conexion();
                MySqlCommand cmd = new MySqlCommand();
                string sql = "INSERT INTO USER" +
                    "(PASSWORD,NAME,EMAIL)"
                    + "values" +
                    "('" + u.Password + "','" + u.Username + "', '" + u.Email + "')";
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


        public int verificarLogin(string username, string password)
        {
            try
            {
                Conexion conexion = new Conexion();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE NAME=" + caracter +  username + caracter + " AND PASSWORD= " +caracter +  password + caracter ;
                cmd.Connection = conexion.conn;
                cmd.CommandText = sql;
                MySqlDataReader reader = cmd.ExecuteReader();
                
                if(reader.HasRows)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
				reader.Read();            
                conexion.cerrarConexion();
            } catch (Exception ex)
            {
                return 0;
            }
        }
		
		
		 public int verificarUsuarioRepetido(User u)
        {
            try
            {
                Conexion conexion = new Conexion();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE NAME=" + caracter +  u.Username + caracter ;
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
            catch(Exception ex)
            {
                return 0;
            }
        }

        public int verificarCorreoRepetido(User u)
        {
            try
            {
                Conexion conexion = new Conexion();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE EMAIL =" + caracter + u.Password+ caracter;
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

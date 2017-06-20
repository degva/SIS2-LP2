using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entidades;
using MySql.Data.MySqlClient;


namespace AccesoDatos
{
    public class AdminDA
    {

        public AdminDA()
        {

        }

        public int addAdmin(Admin adm)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO USER (NAME,USERNAME,PASSWORD,EMAIL,DELETED,ISADMIN)values('{adm.Name}','{adm.Username}', '{adm.Password}' , '{adm.Email}' , '{adm.Deleted}'  , '{adm.IsAdmin}')";
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


        public int verifyLogin(string username, string password)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE USERNAME =" + caracter +  username + caracter + " AND PASSWORD= " +caracter +  password + caracter ;
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
		
		
		 public int verifyRepeatUsername(Admin adm)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE USERNAME =" + caracter + adm.Username + caracter ;
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

        public int verifyRepeatemail(Admin adm)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM USER WHERE EMAIL = " + caracter + adm.Email+ caracter;
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

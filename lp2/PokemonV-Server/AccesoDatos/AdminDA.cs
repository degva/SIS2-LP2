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
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO USER (NAME,USERNAME,PASSWORD,EMAIL,DELETED,ISADMIN)values('{adm.Name}','{adm.Username}', '{adm.Password}' , '{adm.Email}' , '{adm.Deleted}'  , '{adm.IsAdmin}')";
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

        public int addAdmin2(Admin adm)
        {
            try
            {

                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string character = "'";
                string sql1 = "SELECT * FROM USER WHERE USERNAME=" + character + adm.Username + character;
                cmd.Connection = connection.conn;
                cmd.CommandText = sql1;
                MySqlDataReader reader = cmd.ExecuteReader();
                reader.Read();

                int id = reader.GetInt32("ID");
                if (reader.HasRows)
                {
                    connection.closeConnection();
                    connection = new Connection();
                    MySqlCommand cmd1 = new MySqlCommand();
                    string sql2 = $"INSERT INTO ADMIN (USER_ID,PERMISSION_LEVEL)values('{id}' , '{5}')";
                    cmd1.Connection = connection.conn;
                    cmd1.CommandText = sql2;
                    cmd1.ExecuteNonQuery();
                }

                return 1;

            }
            catch (Exception exp)
            {
                return 0;
            }


        }

        public int verifyLogin(string username, string password)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM USER WHERE USERNAME =" + character +  username + character + " AND PASSWORD = " + character +  password + character + "AND ISADMIN = " + character + 1 + character;
                cmd.Connection = connection.conn;
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
                connection.closeConnection();
            } catch (Exception ex)
            {
                return 0;
            }
        }
		
		
		 public int verifyRepeatUsername(Admin adm)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM USER WHERE USERNAME =" + character + adm.Username + character ;
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
            catch(Exception ex)
            {
                return 0;
            }
        }

        public int verifyRepeatemail(Admin adm)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM USER WHERE EMAIL = " + character + adm.Email+ character;
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

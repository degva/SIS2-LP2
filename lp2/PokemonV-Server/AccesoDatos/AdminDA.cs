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
                string sql = $"INSERT INTO PLAYER (NAME,USERNAME,PASSWORD,EMAIL,NPC_TYPE,ISADMIN,DELETED)values('{adm.Name}','{adm.Username}', '{adm.Password}' , '{adm.Email}' , '{adm.Npc_type}' , '{adm.IsAdmin}'  , '{adm.Deleted}')";
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

        

        public int verifyLogin(string username, string password)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM PLAYER WHERE USERNAME =" + character +  username + character + " AND PASSWORD = " + character +  password + character + "AND ISADMIN = " + character + 1 + character;
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
                Console.WriteLine(ex.Message);
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
                string sql = "SELECT * FROM PLAYER WHERE USERNAME =" + character + adm.Username + character ;
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
                Console.WriteLine(ex.Message);
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
                string sql = "SELECT * FROM PLAYER WHERE EMAIL = " + character + adm.Email+ character;
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

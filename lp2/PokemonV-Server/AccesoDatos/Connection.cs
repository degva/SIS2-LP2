using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace AccesoDatos
{
    public class Connection
    {
        private string cad = "server = quilla.lab.inf.pucp.edu.pe ; user = inf282gx ; database = inf282gx ; port = 3306 ; password = m8h53r9A6xBfeOe6;";
        public MySqlConnection conn;

        public Connection()
        {
            try
            {
                conn = new MySqlConnection(cad);
                conn.Open();
				Console.WriteLine("Successful Connection");
                
            }catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
        public void closeConnection()
        {
            conn.Close();
        }
    }
}

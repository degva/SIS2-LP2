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
        private string cadena = "server = quilla.lab.inf.pucp.edu.pe ; user = inf282gx ; database = inf282gx ; port = 3306 ; password = m8h53r9A6xBfeOe6;";
        public MySqlConnection conn;

        public Connection()
        {
            try
            {
                conn = new MySqlConnection(cadena);
                conn.Open();
				Console.WriteLine("Se establecio la conexion");
                
            }catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
        public void cerrarConexion()
        {
            conn.Close();
        }
    }
}

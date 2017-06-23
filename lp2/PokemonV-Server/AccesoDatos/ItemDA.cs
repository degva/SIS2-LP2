using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entidades;
using MySql.Data.MySqlClient;

namespace AccesoDatos
{
    public class ItemDA
    {
        public ItemDA()
        {

        }

        public int addItem1 (Pokeball pokeball)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO ITEM (NAME,DESCRIPTION,ITEM_TYPE,CATCH_PROB,DELETED)values('{pokeball.Name}','{pokeball.Description}', '{pokeball.Type}' , '{pokeball.Catch_probability}' , '{0}')";
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

        public int addItem2(Potion pot)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO ITEM (NAME,DESCRIPTION,ITEM_TYPE,HP,DELETED)values('{pot.Name}','{pot.Description}', '{pot.Type}' , '{pot.HealthPoints}' , '{0}')";
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

        


        public int verifyRepeatName2(Item item)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM ITEM WHERE NAME=" + character + item.Name + character;
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


        public int deleteItem(int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE ITEM SET DELETED = '1' "
                + "where ID = " + character + id + character;

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


        public int verifyRepeatName(Item item , int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM ITEM WHERE NAME=" + character + item.Name + character + "AND ID <> " + character + id + character;
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

        public int updateItem1(Pokeball pok, int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE ITEM SET NAME = " + character + pok.Name + character + ", DESCRIPTION = " + character + pok.Description + character
                    + ", ITEM_TYPE = " + character + pok.Type + character + ", CATCH_PROB = " + character + pok.Catch_probability + character
                    + ",HP = " + character + null + character 
                + "where ID = " + character + id + character;

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

        public int updateItem2(Potion pot, int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE ITEM SET NAME = " + character + pot.Name + character + ", DESCRIPTION = " + character + pot.Description + character
                    + ", ITEM_TYPE = " + character + pot.Type + character + ", HP = " + character + pot.HealthPoints + character
                    + ",CATCH_PROB = " + character + null + character
                + "where ID = " + character + id + character;

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


        public int verifyID(int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM ITEM WHERE ID =" + character + id + character ;
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

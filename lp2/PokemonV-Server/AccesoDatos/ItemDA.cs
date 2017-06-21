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
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO ITEM (NAME,DESCRIPTION,ITEM_TYPE,CATCH_PROB,DELETED)values('{pokeball.Name}','{pokeball.Description}', '{pokeball.Type}' , '{pokeball.Catch_probability}' , '{0}')";
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

        public int addItem2(Potion pot)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO ITEM (NAME,DESCRIPTION,ITEM_TYPE,HP,DELETED)values('{pot.Name}','{pot.Description}', '{pot.Type}' , '{pot.HealthPoints}' , '{0}')";
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

        public int addItem3(Repellent repel)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO ITEM (NAME,DESCRIPTION,ITEM_TYPE,STEPS,DELETED)values('{repel.Name}','{repel.Description}', '{repel.Type}' , '{repel.Steps}' , '{0}')";
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


        public int verifyRepeatName2(Item item)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM ITEM WHERE NAME=" + caracter + item.Name + caracter;
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


        public int deleteItem(int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE ITEM SET DELETED = '1' "
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


        public int verifyRepeatName(Item item , int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM ITEM WHERE NAME=" + caracter + item.Name + caracter + "AND ID <> " + caracter + id + caracter;
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

        public int updateItem1(Pokeball pok, int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE ITEM SET NAME = " + caracter + pok.Name + caracter + ", DESCRIPTION = " + caracter + pok.Description + caracter
                    + ", ITEM_TYPE = " + caracter + pok.Type + caracter + ", CATCH_PROB = " + caracter + pok.Catch_probability + caracter
                    + ",STEPS = " + caracter + null + caracter + ",HP = " + caracter + null + caracter 
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

        public int updateItem2(Potion pot, int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE ITEM SET NAME = " + caracter + pot.Name + caracter + ", DESCRIPTION = " + caracter + pot.Description + caracter
                    + ", ITEM_TYPE = " + caracter + pot.Type + caracter + ", HP = " + caracter + pot.HealthPoints + caracter
                    + ",STEPS = " + caracter + null + caracter + ",CATCH_PROB = " + caracter + null + caracter
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


        public int updateItem3(Repellent repel, int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE ITEM SET NAME = " + caracter + repel.Name + caracter + ", DESCRIPTION = " + caracter + repel.Description + caracter
                    + ", ITEM_TYPE = " + caracter + repel.Type + caracter + ", STEPS = " + caracter + repel.Steps + caracter
                    + ",CATCH_PROB = " + caracter + null + caracter + ",HP = " + caracter + null + caracter
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
    }
}

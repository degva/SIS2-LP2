using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entidades;
using MySql.Data.MySqlClient;

namespace AccesoDatos
{
    public class PokemonDA
    {
        public PokemonDA()
        {

        }

        public int addPokemon(Pokemon pok)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO POKEMON (NAME,LIFE,ATTACK_PTS,DEFFENSE_PTS,TYPE,DELETED)values('{pok.Name}','{pok.Life}', '{pok.Attack_pts}' , '{pok.Defense_pts}' , '{pok.Type}' , '{pok.Deleted}')";
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

        public int deletePokemon(int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE POKEMON SET DELETED = '1' "
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

        public int verifyRepeatName(Pokemon pok, int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM POKEMON WHERE NAME=" + caracter + pok.Name + caracter + "AND ID <> " + caracter + id + caracter;
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


        public int updatePokemon(Pokemon pok, int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "UPDATE POKEMON SET NAME = " + caracter + pok.Name+ caracter + ", LIFE = " + caracter + pok.Life + caracter
                    + ", ATTACK_PTS = " + caracter + pok.Attack_pts + caracter + ", DEFFENSE_PTS = " + caracter + pok.Defense_pts + caracter
                    + ",TYPE = " + caracter + pok.Type + caracter 
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

        public int verifyRepeatName2(Pokemon pok)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM POKEMON WHERE NAME=" + caracter + pok.Name + caracter;
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

        public int verifyID(int id)
        {
            try
            {
                Connection conexion = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char caracter = '"';
                string sql = "SELECT * FROM POKEMON WHERE ID =" + caracter + id + caracter;
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

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
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                string sql = $"INSERT INTO POKEMON (ID,NAME,LIFE,DEFENSE_PTS,ATTACK_1_ID, ATTACK_2_ID,TYPE,DELETED)values('{pok.Id}','{pok.Name}','{pok.Life}', '{pok.Defense_pts}' , '{pok.Attack1_id}' , '{pok.Attack2_id}', '{pok.Type}' , '{pok.Deleted}')";
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

        public int deletePokemon(int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE POKEMON SET DELETED = '1' "
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

        public int verifyRepeatName(Pokemon pok, int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM POKEMON WHERE NAME=" + character + pok.Name + character + "AND ID <> " + character + id + character;
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


        public int updatePokemon(Pokemon pok, int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "UPDATE POKEMON SET NAME = " + character + pok.Name+ character + ", LIFE = " + character + pok.Life + character
                   + ", DEFENSE_PTS = " + character + pok.Defense_pts + character + ", ATTACK_1_ID = " + character + pok.Attack1_id + character
                   + ", ATTACK_2_ID = " + character + pok.Attack2_id+ character + ", TYPE = " + character + pok.Type + character 
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

        public int verifyRepeatName2(Pokemon pok)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM POKEMON WHERE NAME=" + character + pok.Name + character;
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

        public int verifyID(int id)
        {
            try
            {
                Connection connection = new Connection();
                MySqlCommand cmd = new MySqlCommand();
                char character = '"';
                string sql = "SELECT * FROM POKEMON WHERE ID =" + character + id + character;
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

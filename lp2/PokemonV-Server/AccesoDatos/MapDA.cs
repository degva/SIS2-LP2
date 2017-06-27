using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccesoDatos
{
    public class MapDA
    {
        private string route = "res/maps/main2.txt";
        private Connection connection;

        private int height=0, width=0;
        public MapDA() {
        }

        public void upload() {
            connection = new Connection();

            List<string> tileStrings = readFile();


            MySqlCommand cmd = new MySqlCommand();
            cmd.Connection = connection.conn;

            // Create map
            string sql = $"INSERT INTO MAP (ID, WIDTH,HEIGHT, PROB_POKEMON, PROB_ITEM)values('{1}','{width}','{height}','{0.1}', '{0.02}')";
            cmd.CommandText = sql;
            cmd.ExecuteNonQuery();

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    // Insert tile
                    //int tileType = getTileType(tileStrings[j * width + i]);
                    string type = tileStrings[j * width + i];

                    if (i == 13 && j == 38)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{4}','{1}','{1}')";
                    }
                    else if (i == 11 && j == 31)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{1}','{1}','{1}')";
                    }
                    else if (i == 26 && j == 11)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{5}','{1}','{1}')";
                    }
                    else if (i == 23 && j == 38) {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{2}','{1}','{1}')";
                    }
                    else if (i == 21 && j == 42)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{3}','{1}','{1}')";
                    }
                    else if (i == 22 && j == 42)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{10}','{1}','{1}')";
                    }
                    else if (i == 12 && j == 17)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{9}','{1}','{1}')";
                    }
                    else if (i == 27 && j == 14)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{6}','{1}','{1}')";
                    }
                    else if (i == 16 && j == 32)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{7}','{1}','{1}')";
                    }
                    else if (i == 16 && j == 45)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{8}','{1}','{1}')";
                    }
                    else if (i == 26 && j == 40)
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,player_id,item_enabled,map_id)values('{type}', '{i}', '{j}','{11}','{1}','{1}')";
                    }
                    else
                    {
                        sql = $"INSERT INTO TILE (TYPE, X,Y,item_enabled,map_id)values('{type}', '{i}', '{j}','{1}','{1}')";
                    }
                    
                    cmd.CommandText = sql;
                    cmd.ExecuteNonQuery();
                }
            }

            connection.closeConnection();
        }

        private List<string> readFile() {
            List<string> tileStrings = new List<string>();

            // Open file
            FileStream arch = new FileStream(route, FileMode.Open, FileAccess.Read);
            StreamReader reader = new StreamReader(arch);

            // Read file
            while (true)
            {
                string line = reader.ReadLine();
                if (line == null) break;

                string[] lines = line.Split(' ');
                if (height == 0) width = lines.Length;
                height++;

                foreach (string tileString in lines){
                    tileStrings.Add(tileString);
                }
            }

            return tileStrings;
        }

        private int getTileType(string type) {
            int i = 1;
            switch (type) {
                case "FLR01":
                    i = 1;
                    break;
                case "FLR02":
                    i = 2;
                    break;
                case "FLR03":
                    i = 3;
                    break;
                case "SGN01":
                    i = 4;
                    break;
                case "GRA00":
                    i = 5;
                    break;
                case "GRA01":
                    i = 6;
                    break;
                case "GRA02":
                    i = 7;
                    break;
                case "GRA03":
                    i = 8;
                    break;
                case "GRA04":
                    i = 9;
                    break;
                case "GRA05":
                    i = 10;
                    break;
                case "GRA06":
                    i = 11;
                    break;
                case "GRA07":
                    i = 12;
                    break;
                case "GRA08":
                    i = 13;
                    break;
                case "GRA09":
                    i = 14;
                    break;
                case "SND01":
                    i = 15;
                    break;
                case "SND02":
                    i = 16;
                    break;
                case "SND03":
                    i = 17;
                    break;
                case "SND04":
                    i = 18;
                    break;
                case "SND05":
                    i = 19;
                    break;
                case "SND06":
                    i = 20;
                    break;
                case "SND07":
                    i = 21;
                    break;
                case "SND08":
                    i = 22;
                    break;
                case "SND09":
                    i = 23;
                    break;
                case "TRG01":
                    i = 24;
                    break;
                case "TRG02":
                    i = 25;
                    break;
                case "TRG03":
                    i = 26;
                    break;
                case "HO101":
                    i = 27;
                    break;
                case "HO102":
                    i = 28;
                    break;
                case "HO103":
                    i = 29;
                    break;
                case "HO104":
                    i = 30;
                    break;
                case "HO105":
                    i = 31;
                    break;
                case "HO106":
                    i = 32;
                    break;
                case "HO107":
                    i = 33;
                    break;
                case "HO108":
                    i = 34;
                    break;
                case "HO109":
                    i = 35;
                    break;
                case "HO110":
                    i = 36;
                    break;
                case "HO111":
                    i = 37;
                    break;
                case "HO112":
                    i = 38;
                    break;
                default:
                    i = 1;
                    break;
            }
            return i;
        }
    }
}

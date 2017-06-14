package com.grupox.pokemonv.controller.manager;

import com.grupox.pokemonv.controller.*;
import com.grupox.pokemonv.controller.menu.BattleMenu;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.User;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Semaphore;
import javax.imageio.ImageIO;

public class BattleManager {

    private InputHandler input;
    private Game game;

    public enum State {
        BEGIN, PLAYER1, PLAYER2, FIRSTWON, SECONDWON, FIRSTLEFT, SECONDLEFT
    };

    public enum OptionS {
        BEGIN, REG_ATTACK, REG_GIVEUP, REG_BAG, WAIT
    }
    private State state;
    private OptionS optionPlayer;
    private Player player;
    private final String route1 = "res/battle/principal.png";
    private final String route2 = "res/battle/opuesto.png";
    private final String rutaFondo = "res/battle/fondoBatalla.png";
    private final String rutaHP1 = "res/battle/hpPrincipal.png";
    private final String rutaHP2 = "res/battle/hpOpuesto.png";

    private final int fondoAncho = 800;
    private final int fondoAlto = 600;
    private final int pokAncho1 = 130;
    private final int pokAncho2 = 130;
    private final int pokAlto1 = 100;
    private final int pokAlto2 = 80;
    private final int topOffset = 280;   // px
    private final int rightOffset = Game.WIDTH / 160;
    private BufferedImage pokemon1;
    private BufferedImage pokemon2;
    private BufferedImage imgFondo;
    private BufferedImage hp1;
    private BufferedImage hp2;
    private String lastMessage;
    private int vidaPok1;
    private int vidaPok2;

    private BattleMenu menu;
    private FileReader lector;
    private BufferedReader entrada;
    private String response;
    private boolean endBattle = false;

    public BattleManager(Player player, Game game) {
        //Loading the buffered images
        this.player = player;
        input = player.getInput();
        this.game = game;
        try {
            pokemon1 = ImageIO.read(new File(route1));
            pokemon2 = ImageIO.read(new File(route2));
            imgFondo = ImageIO.read(new File(rutaFondo));
            hp1 = ImageIO.read(new File(rutaHP1));
            hp2 = ImageIO.read(new File(rutaHP2));
            lector = new FileReader("res/battle/other1.txt");
            entrada = new BufferedReader(lector);
        } catch (Exception exp) {
        }
        state = State.BEGIN;
        optionPlayer = OptionS.BEGIN;
        menu = new BattleMenu(input, topOffset, rightOffset, game);
        vidaPok1 = vidaPok2 = 140;

    }

    public void tick() {
        if (state == State.PLAYER1 && optionPlayer == OptionS.REG_ATTACK) {
            //System.out.println("BattleManager: Se ha atacado, se ha dismuido su vida");
            vidaPok2 -= 20;
            state = State.PLAYER2;
        } else if (state == State.PLAYER1 && optionPlayer == OptionS.REG_GIVEUP) {
            //System.out.println("BattleManager: El usuario ha huido");
            //state = State.PLAYER2;
            endBattle = true;
            state = State.FIRSTLEFT;
        } else if (state == State.PLAYER1 && optionPlayer == OptionS.REG_BAG) {
            //System.out.println("BattleManager: Has usado la mochila");
            state = State.PLAYER2;
        }
        if (!endBattle) {
            switch (state) {
                case BEGIN:
                    state = State.PLAYER1;
                    break;
                case PLAYER1:
                    menu.tick();
                    break;
                case PLAYER2:
                    response = getOtherResponse();
                    if (response != null) {
                        if (response.equals("atacar")) {
                            vidaPok1 -= 20;
                            System.out.println("El usuario 2 realizo ATAQUE");
                        } else if (response.equals("huir")) {
                            System.out.println("El usuario 2 realizo HUIR");
                            state = State.SECONDLEFT;
                            //game.setState(Game.State.MAP); //Finaliza la batalla pokemon
                        } else if (response.equals("mochila")) {
                            System.out.println("El usuario 2 usó MOCHILA");
                            //Curar a su pokemon

                        }
                    }
                    if (state != State.SECONDLEFT) {
                        state = State.PLAYER1;
                        optionPlayer = OptionS.WAIT;
                    }

                    break;
            }
        }
    }

    public void render(Graphics2D g) {
        g.drawImage(imgFondo, 0, 0, fondoAncho, fondoAlto, null);
        //Load pokemon
        g.drawImage(pokemon1, 130, 180, pokAncho1, pokAlto1, null);
        g.drawImage(pokemon2, 450, 50, pokAncho2, pokAlto2, null);
        g.setColor(Color.red);
        g.fillRect(480, 208, 140, 20);
        g.setColor(Color.green);
        g.fillRect(480, 208, vidaPok1, 20);
        g.drawImage(hp1, 360, 145, 280, 110, null);

        Font.getInstance().drawString("MUDKIP", g, 450, 160);

        g.setColor(Color.red);
        g.fillRect(165, 85, 140, 20);
        g.setColor(Color.green);
        g.fillRect(165, 85, vidaPok2, 20);
        g.drawImage(hp2, 60, 30, 280, 110, null);

        Font.getInstance().drawString("ZIGZAGOON", g, 120, 40);

        //g.fillRect(330,180,230,10);
        if (state == State.PLAYER1) {
            menu.render(g);

        } else if (state == State.PLAYER2) {
            Font.getInstance().drawString("EL CONTRINCANTE ESTÁ DECIDIENDO!", g, 20, 300);
        }
        if (optionPlayer == OptionS.WAIT) {
            Font.getInstance().drawString(lastMessage, g, 20, 300);
        }
        if (state==State.FIRSTLEFT){
            Font.getInstance().drawString("TE HAS RETIRADO PERDIENDO LA BATALLA", g, 30, 300);
        }
        else if (state==State.SECONDLEFT){
            Font.getInstance().drawString("GANASTE LA BATALLA POR RETIRO DEL OTRO JUGADOR", g, 300, 300);
        }
    }

    /* */
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setMessage(String mes) {
        this.lastMessage = mes;
    }

    public void setOptionState(OptionS state) {
        this.optionPlayer = state;
    }

    public String getOtherResponse() {
        try {
            String aux = entrada.readLine();
            if (aux != null) {
                return aux;
            }
        } catch (Exception exp) {

        }
        return null;
    }

    public void registrarAtaque(int userId, double attackPoints) {
        //Guardar en el archivo
    }
}

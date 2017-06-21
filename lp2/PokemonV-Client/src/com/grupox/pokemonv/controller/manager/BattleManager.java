package com.grupox.pokemonv.controller.manager;

import com.grupox.pokemonv.controller.*;
import com.grupox.pokemonv.controller.menu.BattleMenu;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.Renderable;
import com.grupox.pokemonv.model.User;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BattleManager extends Renderable {

    private InputHandler input;
    private Game game;

    @Override
    public void render(Graphics2D g, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum State {
        P1_IDLE, P1_ATTACK, P1_BAG, P1_GIVEUP, P2_IDLE, P2_ATTACK, P2_BAG, P2_GIVEUP
    };
    private State state;
    private Player player;
    private Player player2;
    private BufferedImage currSprite2;
    private final String route1 = "res/battle/bulb_back1.png";
    private final String route2 = "res/battle/pika_front1.png";
    private final String rutaAni1 = "res/battle/bulb_back2.png";
    private final String rutaAni2 = "res/battle/bulb_back3.png";
    private final String rutaAniOp1 = "res/battle/pika_front2.png";
    private final String rutaAniOp2 = "res/battle/pika_front3.png";
    private final String rutaOpcion = "res/battle/fondoOpciones.png";

    HashMap<Integer, ArrayList<String>> mapPokemons;
    ArrayList<String> rutasPOK1;
    ArrayList<String> rutasPOK2;
    ArrayList<String> rutasPOK3;
    ArrayList<String> rutasPOK4;
    ArrayList<String> rutasPOK7;
    //key: ID POKEMON
    //value:RutasFront 0,1,2 , RutasBack = 3,4,5

    private final String rutaFondo = "res/battle/fondoBatalla.png";
    private final String rutaHP1 = "res/battle/hpPrincipal.png";
    private final String rutaHP2 = "res/battle/hpOpuesto.png";
    private boolean attack = false;
    private final int fondoAncho = 800;
    private final int fondoAlto = 600;
    private final int pokAncho1 = 150; // 130
    private final int pokAncho2 = 150;
    private final int pokAlto1 = 150; // 100
    private final int pokAlto2 = 150;
    private final int topOffset = 390;   // px
    private final int rightOffset = Game.WIDTH / 1000;
    private final double movePeriod = 0.2;
    private BufferedImage pokemon1;
    private Image pokemon1Attack;
    private BufferedImage pokemon2;
    private BufferedImage imgFondo;
    private BufferedImage hp1;
    private BufferedImage hp2;
    private BufferedImage animacion1;
    private BufferedImage animacion2;
    private BufferedImage animacionOp1;
    private BufferedImage animacionOp2;
    private BufferedImage fondoOpcion;
    private int NUM_TICKS_WAIT = 2;

    private String lastMessage;
    private int vidaPok1;
    private int vidaPok2;
    private Animation atk;
    private Animation idle;
    private Animation atkP2;
    private Animation idleP2;
    private double now;
    private double lastMove = 0;
    private int numTicks = 0;
    private BattleMenu menu;
    private FileReader lector;
    private BufferedReader entrada;
    private String response;
    private boolean endBattle = false;

    

    public BattleManager(Player player, Game game) {
        //Loading the buffered images
        super();
        linkRoutes();
        this.player = player;
        input = player.getInput();
        this.game = game;
        try {
            pokemon1 = ImageIO.read(new File(route1));
            //pokemon1Attack = new ImageIcon(route1Attack).getImage();
            pokemon2 = ImageIO.read(new File(route2));
            animacion1 = ImageIO.read(new File(rutaAni1));
            animacion2 = ImageIO.read(new File(rutaAni2));
            animacionOp1 = ImageIO.read(new File(rutaAniOp1));
            animacionOp2 = ImageIO.read(new File(rutaAniOp2));
            imgFondo = ImageIO.read(new File(rutaFondo));
            fondoOpcion = ImageIO.read(new File(rutaOpcion));
            hp1 = ImageIO.read(new File(rutaHP1));
            hp2 = ImageIO.read(new File(rutaHP2));
            lector = new FileReader("res/battle/other1.txt");
            entrada = new BufferedReader(lector);
        } catch (Exception exp) {
        }
        state = State.P1_IDLE;
        menu = new BattleMenu(input, topOffset, rightOffset, game);
        vidaPok1 = vidaPok2 = 140;
        loadBattleAnimation();
        atk = animations.get(findAnimation("attack"));
        atkP2 = animations.get(findAnimation("attackP2"));
        idle = animations.get(findAnimation("idlePok1"));
        idleP2 = animations.get(findAnimation("idleP2"));
        atk.play();
        atkP2.play();
        idle.play();
        idleP2.play();
    }

    public void startBattle(Player p1, Player p2) {
        this.player = p1;
        input = p1.getInput();

    }

    public void loadBattleAnimation() {
        //attack animation
        ArrayList<BufferedImage> attackImages = new ArrayList<>();
        attackImages.add(animacion1);
        attackImages.add(animacion2);
        Animation attackAnimation = new Animation("attack", attackImages, movePeriod);

        ArrayList<BufferedImage> idlePok1 = new ArrayList<>();
        idlePok1.add(pokemon1);
        Animation idleAnimation = new Animation("idlePok1", idlePok1, movePeriod);

        ArrayList<BufferedImage> attackImagesP2 = new ArrayList<>();
        attackImagesP2.add(animacionOp1);
        attackImagesP2.add(animacionOp2);
        Animation attackAnimationP2 = new Animation("attackP2", attackImagesP2, movePeriod);

        ArrayList<BufferedImage> idleP2 = new ArrayList<>();
        idleP2.add(pokemon2);
        Animation idleAnimationP2 = new Animation("idleP2", idleP2, movePeriod);

        animations.add(idleAnimation);
        animations.add(attackAnimation);
        animations.add(attackAnimationP2);
        animations.add(idleAnimationP2);

    }

    public void inicializeTicks() {
        numTicks = 0;
    }

    public void tick() {
        switch (state) {
            case P1_IDLE:
                menu.tick();
                currSprite = idle.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                break;
            case P1_ATTACK:
                //vidaPok2 -= 20; Corregir el automatico descuento de vida
                currSprite = atk.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.P2_IDLE;
                    System.out.println("Usuario 1 realizo un ataque");
                    numTicks = 0;
                    vidaPok2 -= 20;
                }
                break;
            case P1_BAG:
                break;
            case P1_GIVEUP:
                currSprite = idle.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    endBattle = true;
                }
                //state = State.FIRSTLEFT;
                break;
            case P2_IDLE:
                currSprite = idle.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                response = getOtherResponse();
                if (response != null) {
                    if (response.equals("atacar")) {
                        state = State.P2_ATTACK;
                    } else if (response.equals("huir")) {
                        System.out.println("El usuario 2 realizo HUIR");
                        state = State.P2_GIVEUP;
                        numTicks = 0;
                        //game.setState(Game.State.MAP); //Finaliza la batalla pokemon
                    } else if (response.equals("mochila")) {
                        System.out.println("El usuario 2 usó MOCHILA");
                        state = State.P2_BAG;
                    }
                }
                break;
            case P2_ATTACK:
                currSprite = idle.getCurrSprite();
                currSprite2 = atkP2.getCurrSprite();
                ;
                if (numTicks == NUM_TICKS_WAIT) { //Luego de 4 ticks, reiniciar el temporizador
                    state = State.P1_IDLE;
                    System.out.println("Usuario 2 realizo un ataque");
                    vidaPok1 -= 20;
                    numTicks = 0;
                }
                break;
            case P2_BAG:
                break;
            case P2_GIVEUP:
                currSprite = idle.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    endBattle = true;
                }
                break;
        }

        if ((state == State.P1_ATTACK) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P2_ATTACK) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P1_GIVEUP) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P2_GIVEUP) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if (endBattle) {
            game.setState(Game.State.MAP);
        }
    }

    public void render(Graphics2D g) {
        g.drawImage(imgFondo, 0, 0, fondoAncho, fondoAlto, null);

        g.drawImage(currSprite, 130, 290, pokAncho1, pokAlto1, null);
        g.drawImage(currSprite2, 480, 85, pokAncho2, pokAlto2, null);
        g.setColor(Color.red);
        g.fillRect(480, 208 + 125, 140, 20);
        g.setColor(Color.green);
        g.fillRect(480, 208 + 125, vidaPok1, 20);
        g.drawImage(hp1, 360, 145 + 125, 280, 110, null);
        Font.getInstance().drawString("BULBASAUR", g, 450, 160 + 125);

        g.setColor(Color.red);
        g.fillRect(165, 85 + 75, 140, 20);
        g.setColor(Color.green);
        g.fillRect(165, 85 + 75, vidaPok2, 20);
        g.drawImage(hp2, 60, 30 + 75, 280, 110, null);

        Font.getInstance().drawString("PIKACHU", g, 120, 40 + 75);

        //g.fillRect(330,180,230,10);
        switch (state) {
            case P1_IDLE:
                g.drawImage(fondoOpcion, 450 - 100, 425, 350 + 100, 171, null);
                menu.render(g);
                Font.getInstance().drawString("CHOOSE ONE OPTION", g, 30, 475);
                break;
            case P1_ATTACK:
                Font.getInstance().drawString("YOU ARE ATTACKING...", g, 30, 475);
                break;
            case P1_BAG:
                break;
            case P1_GIVEUP:
                Font.getInstance().drawString("YOU RAN AWAY, LOSING THE BATTLE", g, 30, 475);
                break;
            case P2_IDLE:
                break;
            case P2_ATTACK:
                Font.getInstance().drawString("YOUR OPONENT IS ATTACKING...", g, 30, 475);
                break;
            case P2_BAG:
                break;
            case P2_GIVEUP:
                Font.getInstance().drawString("YOU WON THE MATCH, THE OTHER PLAYER LEFT", g, 30, 475);
                break;
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

    public boolean getAttack() {
        return attack;
    }

    public void setAttack(boolean b) {
        attack = b;
    }
    
    public void linkRoutes() {
        mapPokemons = new HashMap<Integer, ArrayList<String>>();
        rutasPOK1 = new ArrayList<String>();
        rutasPOK2 = new ArrayList<String>();
        rutasPOK3 = new ArrayList<String>();
        rutasPOK4 = new ArrayList<String>();
        rutasPOK7 = new ArrayList<String>();
        
        rutasPOK1.add("res/battle/bulb_back1.png");
        rutasPOK1.add("res/battle/bulb_back2.png");
        rutasPOK1.add("res/battle/bulb_back3.png");
        rutasPOK1.add("res/battle/bulb_front1.png");
        rutasPOK1.add("res/battle/bulb_front2.png");
        rutasPOK1.add("res/battle/bulb_front3.png");
        
        rutasPOK2.add("res/battle/pika_back1.png");
        rutasPOK2.add("res/battle/pika_back2.png");
        rutasPOK2.add("res/battle/pika_back3.png");
        rutasPOK2.add("res/battle/pika_front1.png");
        rutasPOK2.add("res/battle/pika_front2.png");
        rutasPOK2.add("res/battle/pika_front3.png");
        
        rutasPOK3.add("res/battle/butt_back1.png");
        rutasPOK3.add("res/battle/butt_back2.png");
        rutasPOK3.add("res/battle/butt_back3.png");
        rutasPOK3.add("res/battle/butt_front1.png");
        rutasPOK3.add("res/battle/butt_front2.png");
        rutasPOK3.add("res/battle/butt_front3.png");
        
        rutasPOK4.add("res/battle/char_back1.png");
        rutasPOK4.add("res/battle/char_back2.png");
        rutasPOK4.add("res/battle/char_back3.png");
        rutasPOK4.add("res/battle/char_front1.png");
        rutasPOK4.add("res/battle/char_front2.png");
        rutasPOK4.add("res/battle/char_front3.png");
        
        rutasPOK7.add("res/battle/sq_back1.png");
        rutasPOK7.add("res/battle/sq_back2.png");
        rutasPOK7.add("res/battle/sq_back3.png");
        rutasPOK7.add("res/battle/sq_front1.png");
        rutasPOK7.add("res/battle/sq_front2.png");
        rutasPOK7.add("res/battle/sq_front3.png");
        
        mapPokemons.put(1, rutasPOK1); // ID:2->Pikachu
        mapPokemons.put(2, rutasPOK2); // ID:2->Pikachu
        mapPokemons.put(3, rutasPOK3); // ID:3->Butterfree
        mapPokemons.put(4, rutasPOK4); // ID:4->Charmander
        mapPokemons.put(7, rutasPOK7); // ID:7->Squirtle
    }
}

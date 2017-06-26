package com.grupox.pokemonv.controller.manager;

import com.grupox.pokemonv.controller.*;
import com.grupox.pokemonv.controller.menu.BattleMenu;
import com.grupox.pokemonv.controller.menu.TypeAttackMenuP1;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.Pokemon;
import com.grupox.pokemonv.model.Renderable;
import com.grupox.pokemonv.model.Player;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class BattleManager extends Renderable {

    private InputHandler input;
    private Game game;

    @Override
    public void render(Graphics2D g, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum State {
        P1_IDLE, P1_ATTACK_FIRST, P1_ATTACK_SECOND, P1_BAG, P1_GIVEUP,
        P2_IDLE, P2_ATTACK_FIRST, P2_ATTACK_SECOND, P2_BAG, P2_GIVEUP,
        P1_DEAD, P2_DEAD,
        TYPE_ATTACK_MENU
    };
    private State state;
    private Player player;
    private Player player2;
    private BufferedImage currSprite2;
    private String rutaP1_StaticPok;
    private String rutaP2_StaticPok;
    private String rutaP1_Normal1;
    private String rutaP1_Normal2;
    private String rutaP2_Normal1;
    private String rutaP2_Normal2;

    private String rutaP1_Super1;
    private String rutaP1_Super2;
    private String rutaP1_Super3;
    private String rutaP1_Super4;

    private String rutaP2_Super1;
    private String rutaP2_Super2;
    private String rutaP2_Super3;
    private String rutaP2_Super4;

    private String nombrePokPlayer1;
    private String nombrePokPlayer2;
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

    private BufferedImage imgPokemonStatic_P1;
    private BufferedImage imgPokemonStatic_P2;
    private BufferedImage imgBackgroundBattle;
    private BufferedImage imgBackgroundHP1;
    private BufferedImage imgBackgroundHP2;

    private BufferedImage imgForAnimP1_Normal1;
    private BufferedImage imgForAnimP1_Normal2;
    private BufferedImage imgForAnimP1_Super1;
    private BufferedImage imgForAnimP1_Super2;
    private BufferedImage imgForAnimP1_Super3;
    private BufferedImage imgForAnimP1_Super4;

    private BufferedImage imgForAnimP2_Normal1;
    private BufferedImage imgForAnimP2_Normal2;
    private BufferedImage imgForAnimP2_Super1;
    private BufferedImage imgForAnimP2_Super2;
    private BufferedImage imgForAnimP2_Super3;
    private BufferedImage imgForAnimP2_Super4;

    private BufferedImage fondoOpcion;
    private int NUM_TICKS_WAIT = 2;

    private int initialLifePok1, initialLifePok2;
    private int vidaPok1, vidaPok2, danio1_Pok1, danio2_Pok1, danio1_Pok2, danio2_Pok2;
    private Animation attackAnimP1Normal;
    private Animation attackAnimP1Super;
    private Animation idle;
    private Animation attackAnimP2Normal;
    private Animation attackAnimP2Super;
    private Animation idleP2;
    private int numTicks = 0;

    private BattleMenu menu;
    private TypeAttackMenuP1 attackMenu1;
    private String attack1_name, attack2_name, attack1_P2name, attack2_P2name;
    private FileReader lector;
    private BufferedReader entrada;
    private String response;
    private boolean endBattle = false;

    private int typeAttack = 0;
    int idPok1, idPok2;
    private boolean lastLife = false;

    public BattleManager(Game game) {
        //Loading the buffered images
        super();
        linkRoutes();
        this.game = game;
        try {
            imgBackgroundBattle = ImageIO.read(new File(rutaFondo));
            fondoOpcion = ImageIO.read(new File(rutaOpcion));
            imgBackgroundHP1 = ImageIO.read(new File(rutaHP1));
            imgBackgroundHP2 = ImageIO.read(new File(rutaHP2));
            lector = new FileReader("res/battle/other1.txt");
        } catch (Exception exp) {
        }
        entrada = new BufferedReader(lector);
    }

    public void establishRoutes(Pokemon pok1, Pokemon pok2) {
        idPok1 = pok1.id;
        idPok2 = pok2.id;
        //Rutas de las imagenes de los pokemones estaticos
        rutaP1_StaticPok = mapPokemons.get(idPok1).get(0);
        rutaP2_StaticPok = mapPokemons.get(idPok2).get(7);
        //Rutas de las imagenes para las animaciones: Normal ataque,Player 1
        rutaP1_Normal1 = mapPokemons.get(idPok1).get(1);
        rutaP1_Normal2 = mapPokemons.get(idPok1).get(2);
        //Rutas de las imagenes para las animaciones: Super ataque, Player 1
        rutaP1_Super1 = mapPokemons.get(idPok1).get(3);
        rutaP1_Super2 = mapPokemons.get(idPok1).get(4);
        rutaP1_Super3 = mapPokemons.get(idPok1).get(5);
        rutaP1_Super4 = mapPokemons.get(idPok1).get(6);

        //Rutas de las imagenes para las animaciones: Normal ataque,Player 2
        rutaP2_Normal1 = mapPokemons.get(idPok2).get(8);
        rutaP2_Normal2 = mapPokemons.get(idPok2).get(9);
        //FALTAN LAS RUTAS DE LAS DEMAS ANIMACIONES
        rutaP2_Super1 = mapPokemons.get(idPok2).get(10);
        rutaP2_Super2 = mapPokemons.get(idPok2).get(11);
        rutaP2_Super3 = mapPokemons.get(idPok2).get(12);
        rutaP2_Super4 = mapPokemons.get(idPok2).get(13);
    }

    public void startBattle(Player p1, Player p2) {
        player = p1;
        input = p1.getInput();
        attack1_name = p1.getPokemons().get(0).getAttack1().getName();
        attack2_name = p1.getPokemons().get(0).getAttack2().getName();
        initialLifePok1 = vidaPok1 = p1.getPokemons().get(0).getLife();
        danio1_Pok1 = p1.getPokemons().get(0).getAttack1().getPoints();
        danio2_Pok1 = p1.getPokemons().get(0).getAttack2().getPoints();

        attack1_P2name = p2.getPokemons().get(0).getAttack1().getName();
        attack2_P2name = p2.getPokemons().get(0).getAttack2().getName();
        initialLifePok2 = vidaPok2 = p2.getPokemons().get(0).getLife();
        danio1_Pok2 = p2.getPokemons().get(0).getAttack1().getPoints();
        danio2_Pok2 = p2.getPokemons().get(0).getAttack2().getPoints();
        establishRoutes(p1.getPokemons().get(0), p2.getPokemons().get(0)); //Obtiene el primer pokemon de cada uno
        try {
            imgPokemonStatic_P1 = ImageIO.read(new File(rutaP1_StaticPok));
            imgPokemonStatic_P2 = ImageIO.read(new File(rutaP2_StaticPok));

            imgForAnimP1_Normal1 = ImageIO.read(new File(rutaP1_Normal1));
            imgForAnimP1_Normal2 = ImageIO.read(new File(rutaP1_Normal2));

            imgForAnimP1_Super1 = ImageIO.read(new File(rutaP1_Super1));
            imgForAnimP1_Super2 = ImageIO.read(new File(rutaP1_Super2));
            imgForAnimP1_Super3 = ImageIO.read(new File(rutaP1_Super3));
            imgForAnimP1_Super4 = ImageIO.read(new File(rutaP1_Super4));

            imgForAnimP2_Normal1 = ImageIO.read(new File(rutaP2_Normal1));
            imgForAnimP2_Normal2 = ImageIO.read(new File(rutaP2_Normal2));

            imgForAnimP2_Super1 = ImageIO.read(new File(rutaP2_Super1));
            imgForAnimP2_Super2 = ImageIO.read(new File(rutaP2_Super2));
            imgForAnimP2_Super3 = ImageIO.read(new File(rutaP2_Super3));
            imgForAnimP2_Super4 = ImageIO.read(new File(rutaP2_Super4));
        } catch (Exception exp) {
        }
        state = State.P1_IDLE;
        menu = new BattleMenu(input, topOffset, rightOffset, game);
        attackMenu1 = new TypeAttackMenuP1(input, 420, Game.WIDTH / 3, attack1_name, attack2_name, game);

        loadBattleAnimation();
        attackAnimP1Normal = animations.get(findAnimation("attack"));
        attackAnimP1Super = animations.get(findAnimation("attackSuper"));

        attackAnimP2Normal = animations.get(findAnimation("attackP2"));
        attackAnimP2Super = animations.get(findAnimation("attackSuper2"));

        idle = animations.get(findAnimation("idlePok1"));
        idleP2 = animations.get(findAnimation("idleP2"));
        nombrePokPlayer1 = p1.getPokemons().get(0).getName();
        nombrePokPlayer2 = p2.getPokemons().get(0).getName();
        attackAnimP1Normal.play();
        attackAnimP1Super.play();

        attackAnimP2Normal.play();
        attackAnimP2Super.play();

        idle.play();
        idleP2.play();
    }

    public void loadBattleAnimation() {
        //attack animation
        ArrayList<BufferedImage> attackImages = new ArrayList<>();
        attackImages.add(imgForAnimP1_Normal1);
        attackImages.add(imgForAnimP1_Normal2);
        Animation attackAnimation = new Animation("attack", attackImages, movePeriod);

        ArrayList<BufferedImage> idlePok1 = new ArrayList<>();
        idlePok1.add(imgPokemonStatic_P1);
        Animation idleAnimation = new Animation("idlePok1", idlePok1, movePeriod);

        ArrayList<BufferedImage> attackImagesP2 = new ArrayList<>();
        attackImagesP2.add(imgForAnimP2_Normal1);
        attackImagesP2.add(imgForAnimP2_Normal2);
        Animation attackAnimationP2 = new Animation("attackP2", attackImagesP2, movePeriod);

        ArrayList<BufferedImage> idleP2 = new ArrayList<>();
        idleP2.add(imgPokemonStatic_P2);
        Animation idleAnimationP2 = new Animation("idleP2", idleP2, movePeriod);

        ArrayList<BufferedImage> attackSuperImagesP1 = new ArrayList<>();
        attackSuperImagesP1.add(imgForAnimP1_Super1);
        attackSuperImagesP1.add(imgForAnimP1_Super2);
        attackSuperImagesP1.add(imgForAnimP1_Super3);
        attackSuperImagesP1.add(imgForAnimP1_Super4);
        Animation attackSuperAnimationP1 = new Animation("attackSuper", attackSuperImagesP1, movePeriod);

        ArrayList<BufferedImage> attackSuperImagesP2 = new ArrayList<>();
        attackSuperImagesP2.add(imgForAnimP2_Super1);
        attackSuperImagesP2.add(imgForAnimP2_Super2);
        attackSuperImagesP2.add(imgForAnimP2_Super3);
        attackSuperImagesP2.add(imgForAnimP2_Super4);
        Animation attackSuperAnimationP2 = new Animation("attackSuper2", attackSuperImagesP2, movePeriod);

        animations.add(idleAnimation);
        animations.add(attackAnimation);
        animations.add(attackAnimationP2);
        animations.add(idleAnimationP2);
        animations.add(attackSuperAnimationP1);
        animations.add(attackSuperAnimationP2);
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
            case TYPE_ATTACK_MENU:
                attackMenu1.tick();
                break;
            case P1_ATTACK_FIRST:
                //vidaPok2 -= 20; Corregir el automatico descuento de vida
                currSprite = attackAnimP1Normal.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.P2_IDLE;
                    numTicks = 0;
                    vidaPok2 -= danio1_Pok1;
                    if (vidaPok2 <= 0) {
                        state = State.P2_DEAD;
                        player.setCanBattle(false);
                    }
                }
                break;
            case P1_ATTACK_SECOND:
                //Only the animations changes
                currSprite = attackAnimP1Super.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.P2_IDLE;
                    System.out.println("Usuario 1 realizo un ataque");
                    numTicks = 0;
                    vidaPok2 -= danio2_Pok1;
                    if (vidaPok2 <= 0) {
                        state = State.P2_DEAD;
                        player.setCanBattle(false);
                    }
                }
                break;
            case P1_DEAD:
                currSprite = idle.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    endBattle = true;
                }
                break;
            case P2_DEAD:
                currSprite = idle.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    endBattle = true;
                }
                break;
            case P1_BAG:
                endBattle = true;
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
                    if (response.equals("atacar1")) {
                        state = State.P2_ATTACK_FIRST;
                    } else if (response.equals("atacar2")) {
                        state = State.P2_ATTACK_SECOND;
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
            case P2_ATTACK_FIRST:
                currSprite = idle.getCurrSprite();
                currSprite2 = attackAnimP2Normal.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) { //Luego de 4 ticks, reiniciar el temporizador
                    state = State.P1_IDLE;
                    System.out.println("Usuario 2 realizo un ataque");
                    vidaPok1 -= danio1_Pok2;
                    numTicks = 0;
                    if (vidaPok1 <= 0) {
                        state = State.P1_DEAD;
                    }
                }
                break;
            case P2_ATTACK_SECOND:
                currSprite = idle.getCurrSprite();
                currSprite2 = attackAnimP2Super.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) { //Luego de 4 ticks, reiniciar el temporizador
                    state = State.P1_IDLE;
                    System.out.println("Usuario 2 realizo un ataque");
                    vidaPok1 -= danio2_Pok2;
                    numTicks = 0;
                    if (vidaPok1 <= 0) {
                        state = State.P1_DEAD;
                    }
                }
                break;
            case P2_BAG:
                endBattle = true;
                break;
            case P2_GIVEUP:
                currSprite = idle.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    endBattle = true;
                }
                break;
        }

        if ((state == State.P1_ATTACK_FIRST) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P1_ATTACK_SECOND) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P2_ATTACK_FIRST) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P2_ATTACK_SECOND) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P1_GIVEUP) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P2_GIVEUP) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P1_DEAD) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P2_DEAD) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if (endBattle) {
            game.setState(Game.State.MAP);
            endBattle = false;
            state = State.P1_IDLE;
        }
    }

    private int getRespectiveLife(int pok, int curLife, int reference) {
        int initial;
        if (pok == 1) {
            initial = initialLifePok1;
        } else {
            initial = initialLifePok2;
        }
        if (curLife <= 0) {
            return reference;
        }
        int rest = (reference * curLife) / initial;
        int result = reference - rest;
        return result;
    }

    public void render(Graphics2D g) {

        g.drawImage(imgBackgroundBattle, 0, 0, fondoAncho, fondoAlto, null);

        g.drawImage(currSprite, 130, 290, pokAncho1, pokAlto1, null);
        g.drawImage(currSprite2, 480, 85, pokAncho2, pokAlto2, null);
        g.setColor(Color.green);
        g.fillRect(480, 208 + 125, 140, 20);
        g.setColor(Color.red);
        g.fillRect(480, 208 + 125, getRespectiveLife(1, vidaPok1, 140), 20);

        g.drawImage(imgBackgroundHP1, 360, 145 + 125, 280, 110, null);
        Font.getInstance().drawString(nombrePokPlayer1, g, 450, 160 + 125);
        
        g.setColor(Color.green);
        g.fillRect(165, 85 + 75, 140, 20);
        g.setColor(Color.red);
        g.fillRect(165, 85 + 75, getRespectiveLife(2, vidaPok2, 140), 20);

        g.drawImage(imgBackgroundHP2, 60, 30 + 75, 280, 110, null);
        Font.getInstance().drawString(nombrePokPlayer2, g, 120, 40 + 75);

        //g.fillRect(330,180,230,10);
        switch (state) {
            case P1_IDLE:
                g.drawImage(fondoOpcion, 450 - 100, 425, 350 + 100, 171, null);
                menu.render(g);
                Font.getInstance().drawString("CHOOSE ONE OPTION", g, 30, 475);
                break;
            case TYPE_ATTACK_MENU:
                g.drawImage(fondoOpcion, 0, 425, 350 + 200, 171, null);
                attackMenu1.render(g);
                Font.getInstance().drawString("CHOOSE YOUR", g, 570, 460);
                Font.getInstance().drawString("ATTACK", g, 570, 525);
                break;
            case P1_ATTACK_FIRST:
                if (!endBattle)
                    Font.getInstance().drawString(nombrePokPlayer1 + " USED " + attack1_name, g, 30, 475);
                break;
            case P1_ATTACK_SECOND:
                if (!endBattle)
                    Font.getInstance().drawString(nombrePokPlayer1 + " USED " + attack2_name, g, 30, 475);
                break;
            case P1_BAG:
                Font.getInstance().drawString("YOU USED THE BAG", g, 30, 475);
                break;
            case P1_GIVEUP:
                Font.getInstance().drawString("YOU RAN AWAY, LOSING THE BATTLE", g, 30, 475);
                break;
            case P1_DEAD:
                Font.getInstance().drawString("YOU LOSE THE MATCH", g, 30, 475);
                break;
            case P2_IDLE:
                break;
            case P2_ATTACK_FIRST:
                if (!endBattle)
                    Font.getInstance().drawString(nombrePokPlayer2 + " USED " + attack1_P2name, g, 30, 475);
                break;
            case P2_ATTACK_SECOND:
                if (!endBattle)
                    Font.getInstance().drawString(nombrePokPlayer2 + " USED " + attack2_P2name, g, 30, 475);
                break;
            case P2_BAG:
                Font.getInstance().drawString("HE USED THE BAG", g, 30, 475);
                break;
            case P2_GIVEUP:
                Font.getInstance().drawString("YOU WON THE MATCH, THE OTHER PLAYER LEFT", g, 30, 475);
                break;
            case P2_DEAD:
                 Font.getInstance().drawString("YOU WIN THE MATCH!", g, 30, 475);
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
        rutasPOK1.add("res/battle/bulb_back4.png");
        rutasPOK1.add("res/battle/bulb_back5.png");
        rutasPOK1.add("res/battle/bulb_back6.png");
        rutasPOK1.add("res/battle/bulb_back7.png");
        rutasPOK1.add("res/battle/bulb_front1.png");
        rutasPOK1.add("res/battle/bulb_front2.png");
        rutasPOK1.add("res/battle/bulb_front3.png");
        rutasPOK1.add("res/battle/bulb_front4.png");
        rutasPOK1.add("res/battle/bulb_front5.png");
        rutasPOK1.add("res/battle/bulb_front6.png");
        rutasPOK1.add("res/battle/bulb_front7.png");

        rutasPOK2.add("res/battle/pika_back1.png");
        rutasPOK2.add("res/battle/pika_back2.png");
        rutasPOK2.add("res/battle/pika_back3.png");
        rutasPOK2.add("res/battle/pika_back4.png");
        rutasPOK2.add("res/battle/pika_back5.png");
        rutasPOK2.add("res/battle/pika_back6.png");
        rutasPOK2.add("res/battle/pika_back7.png");
        rutasPOK2.add("res/battle/pika_front1.png");
        rutasPOK2.add("res/battle/pika_front2.png");
        rutasPOK2.add("res/battle/pika_front3.png");
        rutasPOK2.add("res/battle/pika_front4.png");
        rutasPOK2.add("res/battle/pika_front5.png");
        rutasPOK2.add("res/battle/pika_front6.png");
        rutasPOK2.add("res/battle/pika_front7.png");

        rutasPOK3.add("res/battle/butt_back1.png");
        rutasPOK3.add("res/battle/butt_back2.png");
        rutasPOK3.add("res/battle/butt_back3.png");
        rutasPOK3.add("res/battle/butt_back4.png");
        rutasPOK3.add("res/battle/butt_back5.png");
        rutasPOK3.add("res/battle/butt_back6.png");
        rutasPOK3.add("res/battle/butt_back7.png");
        rutasPOK3.add("res/battle/butt_front1.png");
        rutasPOK3.add("res/battle/butt_front2.png");
        rutasPOK3.add("res/battle/butt_front3.png");
        rutasPOK3.add("res/battle/butt_front4.png");
        rutasPOK3.add("res/battle/butt_front5.png");
        rutasPOK3.add("res/battle/butt_front6.png");
        rutasPOK3.add("res/battle/butt_front7.png");

        rutasPOK4.add("res/battle/char_back1.png");
        rutasPOK4.add("res/battle/char_back2.png");
        rutasPOK4.add("res/battle/char_back3.png");
        rutasPOK4.add("res/battle/char_back4.png");
        rutasPOK4.add("res/battle/char_back5.png");
        rutasPOK4.add("res/battle/char_back6.png");
        rutasPOK4.add("res/battle/char_back7.png");
        rutasPOK4.add("res/battle/char_front1.png");
        rutasPOK4.add("res/battle/char_front2.png");
        rutasPOK4.add("res/battle/char_front3.png");
        rutasPOK4.add("res/battle/char_front4.png");
        rutasPOK4.add("res/battle/char_front5.png");
        rutasPOK4.add("res/battle/char_front6.png");
        rutasPOK4.add("res/battle/char_front7.png");

        rutasPOK7.add("res/battle/sq_back1.png");
        rutasPOK7.add("res/battle/sq_back2.png");
        rutasPOK7.add("res/battle/sq_back3.png");
        rutasPOK7.add("res/battle/sq_back4.png");
        rutasPOK7.add("res/battle/sq_back5.png");
        rutasPOK7.add("res/battle/sq_back6.png");
        rutasPOK7.add("res/battle/sq_back7.png");
        rutasPOK7.add("res/battle/sq_front1.png");
        rutasPOK7.add("res/battle/sq_front2.png");
        rutasPOK7.add("res/battle/sq_front3.png");
        rutasPOK7.add("res/battle/sq_front4.png");
        rutasPOK7.add("res/battle/sq_front5.png");
        rutasPOK7.add("res/battle/sq_front6.png");
        rutasPOK7.add("res/battle/sq_front7.png");

        mapPokemons.put(1, rutasPOK1); // ID:1->Bulbasaur
        mapPokemons.put(2, rutasPOK2); // ID:2->Pikachu
        mapPokemons.put(3, rutasPOK3); // ID:3->Butterfree
        mapPokemons.put(4, rutasPOK4); // ID:4->Charmander
        mapPokemons.put(7, rutasPOK7); // ID:7->Squirtle
    }

    public int getTypeAttack() {
        return typeAttack;
    }

    public void setTypeAttack(int typeAttack) {
        this.typeAttack = typeAttack;
    }

}

package com.grupox.pokemonv.controller.manager;

import com.grupox.pokemonv.controller.*;
import com.grupox.pokemonv.controller.menu.BagMenu;
import com.grupox.pokemonv.controller.menu.BattleMenu;
import com.grupox.pokemonv.controller.menu.DecisionBattleMenu;
import com.grupox.pokemonv.controller.menu.TypeAttackMenuP1;
import com.grupox.pokemonv.model.Pokemon;
import com.grupox.pokemonv.model.Renderable;
import com.grupox.pokemonv.model.Player;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class BattleManager extends Renderable {

    private InputHandler input;
    private Game game;
    private State state;
    private Player player;
    private Player player2;
    HashMap<Integer, ArrayList<String>> mapPokemons;
    
    private String rutaP1_StaticPok;
    private String rutaP2_StaticPok;
    private String rutaP1_Normal1;
    private String rutaP1_Normal2;
    private String rutaP2_Normal1;
    private String rutaP2_Normal2;
    
    private ArrayList<String> rutasP1_Super;
    private ArrayList<String> rutasP2_Super;

    private String nombrePokPlayer1;
    private String nombrePokPlayer2;
    
    private final String rutaOpcion = "res/battle/fondoOpciones.png";
    private final String rutaFondo = "res/battle/fondoBatalla.png";
    private final String rutaHP1 = "res/battle/hpPrincipal.png";
    private final String rutaHP2 = "res/battle/hpOpuesto.png";
    private final String rutaImgHeal = "res/battle/heal.png";
    
    private final int fondoAncho = 800;
    private final int fondoAlto = 600;
    private int pokAncho = 150;
    private int pokAlto = 150;
    private final int topOffset = 390;
    private final int rightOffset = Game.WIDTH / 1000;
    private final int topOffsetAttack = 390;
    private final int rightOffsetAttack = Game.WIDTH/2;
    
    private final double movePeriod = 0.2;

    private BufferedImage imgPokemonStatic_P1;
    private BufferedImage imgPokemonStatic_P2;
    private BufferedImage imgBackgroundBattle;
    private BufferedImage imgBackgroundHP1;
    private BufferedImage imgBackgroundHP2;
    private BufferedImage fondoOpcion;
    private BufferedImage imgHeal;
    private BufferedImage imgCapture;
     
    private BufferedImage imgForAnimP1_Normal1;
    private BufferedImage imgForAnimP1_Normal2;
    private BufferedImage imgForAnimP2_Normal1;
    private BufferedImage imgForAnimP2_Normal2;
   
    private ArrayList<BufferedImage> captureImages;
    private ArrayList<BufferedImage> imgsForAnimP1_Super;
    private ArrayList<BufferedImage> imgsForAnimP2_Super;
    
    /*IMPORTANT STUFF*/
    private int initialLifePok1, initialLifePok2;
    private int vidaPok1, vidaPok2, danio1_Pok1, danio2_Pok1, danio1_Pok2, danio2_Pok2;
    private Animation attackAnimP1Normal;
    private Animation attackAnimP1Super;
    private Animation idle;
    private Animation attackAnimP2Normal;
    private Animation attackAnimP2Super;
    private Animation idleP2;
    private Animation healAnimation1;
    private Animation healAnimation2;
    private Animation captureAnimation;
    private Pokemon pokLoad;
    //private Animation endCaptureAnimation;
    private int numTicks = 0;
    private int NUM_TICKS_WAIT = 2;
    /*END*/
    
    private BattleMenu menu;
    private TypeAttackMenuP1 attackMenu;
    private DecisionBattleMenu decisionMenu;
    private BagMenu bagMenu;
    private String attack1_name, attack2_name, attack1_P2name, attack2_P2name;
    private ArrayList<FileReader> archivosWild;
    private ArrayList<FileReader> archivosPlayer;
    private BufferedReader entrada;
    private String response;
    private boolean endBattle = false;
    private boolean battleAgainstPlayer;
    private int idPok1, idPok2;
    private int healEffect = 0;
    private boolean alreadyHealed = false;


    public enum State {
        P1_IDLE, P1_ATTACK_FIRST, P1_ATTACK_SECOND, P1_BAG, P1_GIVEUP,
        P2_IDLE, P2_ATTACK_FIRST, P2_ATTACK_SECOND, P2_BAG, P2_GIVEUP,
        P1_DEAD, P2_DEAD, P1_HEAL, P2_HEAL, P1_CAPTURE,POKEMON_CAPTURED,
        P1_ALREADY_HEALED,P1_NOT_ENOUGH_POKEBALLS,P1_NOT_ENOUGH_POTIONS,
        POKEMON_NOT_WEAK,MAKE_DECISION,YOU_CANT_CATCH,YOU_CANT_GIVEUP,
        TYPE_ATTACK_MENU, BAG_MENU
    };
    
    public BattleManager(Game game) {
        //Loading the buffered images
        super();
        linkRoutes();
        this.game = game;
        try {
            imgBackgroundBattle = ImageIO.read(new File(rutaFondo));
            fondoOpcion = ImageIO.read(new File(rutaOpcion));
            imgBackgroundHP1 = ImageIO.read(new File(rutaHP1));
            imgHeal = ImageIO.read(new File(rutaImgHeal));
            imgCapture = ImageIO.read(new File("res/battle/pokeballMini.png"));
            imgBackgroundHP2 = ImageIO.read(new File(rutaHP2));
            archivosWild = new ArrayList<>();
            archivosPlayer = new ArrayList<>();
            archivosWild.add(new FileReader("res/battle/other1.txt"));
            archivosWild.add(new FileReader("res/battle/other2.txt"));
            archivosPlayer.add(new FileReader("res/battle/other3.txt"));
            archivosPlayer.add(new FileReader("res/battle/other4.txt"));
        } catch (Exception exp) {
        }

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
        rutasP1_Super = new ArrayList<>();
        for (int i=3;i<=6;i++)
            rutasP1_Super.add(mapPokemons.get(idPok1).get(i));
        //Rutas de las imagenes para las animaciones: Normal ataque,Player 2
        rutaP2_Normal1 = mapPokemons.get(idPok2).get(8);
        rutaP2_Normal2 = mapPokemons.get(idPok2).get(9);
        
        rutasP2_Super = new ArrayList<>();
        for (int i=3+7;i<=6+7;i++)
            rutasP2_Super.add(mapPokemons.get(idPok2).get(i));
    }

    public void startBattle(Player p1, Player p2) {
        endBattle = false;
        player = p1;
        player2 = p2;
        numTicks = 0;
        input = p1.getInput();
        battleAgainstPlayer = true;
        animations.clear();
        Random r = new Random();
        int selected = r.nextInt(2);
        entrada = new BufferedReader(archivosPlayer.get(selected));
        attack1_name = p1.getPokemons().get(0).getAttack1().getName();
        attack2_name = p1.getPokemons().get(0).getAttack2().getName();
        initialLifePok1 = vidaPok1 = p1.getPokemons().get(0).getLife();
        danio1_Pok1 = p1.getPokemons().get(0).getAttack1().getPoints();
        danio2_Pok1 = p1.getPokemons().get(0).getAttack2().getPoints();
        
        pokLoad = p2.getPokemons().get(0);
        
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

            //for (int i =0;i<4;i++)
            imgsForAnimP1_Super = new ArrayList<>();
            for (int i=0;i<4;i++)
            imgsForAnimP1_Super.add(ImageIO.read(new File(rutasP1_Super.get(i)))) ;

            imgForAnimP2_Normal1 = ImageIO.read(new File(rutaP2_Normal1));
            imgForAnimP2_Normal2 = ImageIO.read(new File(rutaP2_Normal2));
            imgsForAnimP2_Super = new ArrayList<>();
             for (int i=0;i<4;i++)
            imgsForAnimP2_Super.add(ImageIO.read(new File(rutasP2_Super.get(i)))) ;
        } catch (Exception exp) {
        }
        state = State.P1_IDLE;
        menu = new BattleMenu(input, topOffset, rightOffset,battleAgainstPlayer, game);
        attackMenu = new TypeAttackMenuP1(input, topOffsetAttack, rightOffsetAttack, attack1_name, attack2_name, game);
        bagMenu = new BagMenu(player, 20, rightOffset,battleAgainstPlayer, game);
        captureImages = new ArrayList<>();
        loadCaptureAnimation();
        loadBattleAnimation();
        attackAnimP1Normal = animations.get(findAnimation("attack"));
        attackAnimP1Super = animations.get(findAnimation("attackSuper"));

        attackAnimP2Normal = animations.get(findAnimation("attackP2"));
        attackAnimP2Super = animations.get(findAnimation("attackSuper2"));

        idle = animations.get(findAnimation("idlePok1"));
        idleP2 = animations.get(findAnimation("idleP2"));

        healAnimation1 = animations.get(findAnimation("heal1"));
        healAnimation2 = animations.get(findAnimation("heal2"));
        nombrePokPlayer1 = p1.getPokemons().get(0).getName();
        nombrePokPlayer2 = p2.getPokemons().get(0).getName();
        
        attackAnimP1Normal.play();
        attackAnimP1Super.play();
        attackAnimP2Normal.play();
        attackAnimP2Super.play();
        healAnimation1.play();
        healAnimation2.play();
        captureAnimation.play();
        idle.play();
        idleP2.play();
    }
    public void startBattle(Player p1, Pokemon pokContricante) {
        player = p1;
        endBattle= false;
        animations.clear();
        numTicks = 0;
        input = p1.getInput();
        battleAgainstPlayer = false;
        Random r = new Random();
        int selected = r.nextInt(2);
        entrada = new BufferedReader(archivosWild.get(selected));
        attack1_name = p1.getPokemons().get(0).getAttack1().getName();
        attack2_name = p1.getPokemons().get(0).getAttack2().getName();
        initialLifePok1 = vidaPok1 = p1.getPokemons().get(0).getLife();
        danio1_Pok1 = p1.getPokemons().get(0).getAttack1().getPoints();
        danio2_Pok1 = p1.getPokemons().get(0).getAttack2().getPoints();
        
        pokLoad =pokContricante;
        
        attack1_P2name = pokContricante.getAttack1().getName();
        System.out.println(attack1_P2name);
        System.out.println(pokContricante.getName());
        attack2_P2name = pokContricante.getAttack2().getName();
        initialLifePok2 = vidaPok2 = pokContricante.getLife();
        danio1_Pok2 = pokContricante.getAttack1().getPoints();
        danio2_Pok2 = pokContricante.getAttack2().getPoints();
        establishRoutes(p1.getPokemons().get(0), pokContricante); //Obtiene el primer pokemon de cada uno
        try {
            imgPokemonStatic_P1 = ImageIO.read(new File(rutaP1_StaticPok));
            imgPokemonStatic_P2 = ImageIO.read(new File(rutaP2_StaticPok));

            imgForAnimP1_Normal1 = ImageIO.read(new File(rutaP1_Normal1));
            imgForAnimP1_Normal2 = ImageIO.read(new File(rutaP1_Normal2));

            //for (int i =0;i<4;i++)
            imgsForAnimP1_Super = new ArrayList<>();
            for (int i=0;i<4;i++){
                imgsForAnimP1_Super.add(ImageIO.read(new File(rutasP1_Super.get(i)))) ;
            }
            imgForAnimP2_Normal1 = ImageIO.read(new File(rutaP2_Normal1));
            imgForAnimP2_Normal2 = ImageIO.read(new File(rutaP2_Normal2));
            imgsForAnimP2_Super = new ArrayList<>();
             for (int i=0;i<4;i++)
            imgsForAnimP2_Super.add(ImageIO.read(new File(rutasP2_Super.get(i)))) ;
        } catch (Exception exp) {
        }
        state = State.P1_IDLE;
        menu = new BattleMenu(input, topOffset, rightOffset,battleAgainstPlayer, game);
        attackMenu = new TypeAttackMenuP1(input, topOffsetAttack, rightOffsetAttack, attack1_name, attack2_name, game);
        bagMenu = new BagMenu(player, 20, rightOffset,battleAgainstPlayer, game);
        decisionMenu = new DecisionBattleMenu(player, 425, Game.WIDTH / 1000, game);
        captureImages = new ArrayList<>();
        loadCaptureAnimation();
        loadBattleAnimation();
        attackAnimP1Normal = animations.get(findAnimation("attack"));
        attackAnimP1Super = animations.get(findAnimation("attackSuper"));

        attackAnimP2Normal = animations.get(findAnimation("attackP2"));
        attackAnimP2Super = animations.get(findAnimation("attackSuper2"));

        idle = animations.get(findAnimation("idlePok1"));
        idleP2 = animations.get(findAnimation("idleP2"));

        healAnimation1 = animations.get(findAnimation("heal1"));
        healAnimation2 = animations.get(findAnimation("heal2"));
        nombrePokPlayer1 = p1.getPokemons().get(0).getName();
        nombrePokPlayer2 = pokContricante.getName();
        
        attackAnimP1Normal.play();
        attackAnimP1Super.play();
        attackAnimP2Normal.play();
        attackAnimP2Super.play();
        healAnimation1.play();
        healAnimation2.play();
        captureAnimation.play();
        idle.play();
        idleP2.play();
    }
    public void loadCaptureAnimation() {
        String a;
        try {
            for (int i = 1; i <= 10; i++) {
                a = Integer.toString(i);
                BufferedImage img = ImageIO.read(new File("res/battle/pokeball" + a + ".png"));
                captureImages.add(img);
            }
            //BufferedImage 
        } catch (IOException ex) {
            Logger.getLogger(BattleManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        captureAnimation = new Animation("capture", captureImages, movePeriod);
        animations.add(captureAnimation);
        
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

        ArrayList<BufferedImage> healPok1 = new ArrayList<>();
        healPok1.add(imgPokemonStatic_P1);
        healPok1.add(imgHeal);
        Animation healAnimation_first = new Animation("heal1", healPok1, movePeriod);
        /*SEING*/
        ArrayList<BufferedImage> healPok2 = new ArrayList<>();
        healPok2.add(imgPokemonStatic_P2);
        healPok2.add(imgHeal);
        Animation healAnimation_second = new Animation("heal2", healPok2, movePeriod);

        ArrayList<BufferedImage> attackImagesP2 = new ArrayList<>();
        attackImagesP2.add(imgForAnimP2_Normal1);
        attackImagesP2.add(imgForAnimP2_Normal2);
        Animation attackAnimationP2 = new Animation("attackP2", attackImagesP2, movePeriod);

        ArrayList<BufferedImage> idleP2 = new ArrayList<>();
        idleP2.add(imgPokemonStatic_P2);
        Animation idleAnimationP2 = new Animation("idleP2", idleP2, movePeriod);

        ArrayList<BufferedImage> attackSuperImagesP1 = new ArrayList<>();
        for (int i=0;i<4;i++)
            attackSuperImagesP1.add(imgsForAnimP1_Super.get(i));
        Animation attackSuperAnimationP1 = new Animation("attackSuper", attackSuperImagesP1, movePeriod);

        ArrayList<BufferedImage> attackSuperImagesP2 = new ArrayList<>();
        for (int i=0;i<4;i++)
            attackSuperImagesP2.add(imgsForAnimP2_Super.get(i));
        Animation attackSuperAnimationP2 = new Animation("attackSuper2", attackSuperImagesP2, movePeriod);

        animations.add(idleAnimation);
        animations.add(attackAnimation);
        animations.add(attackAnimationP2);
        animations.add(idleAnimationP2);
        animations.add(attackSuperAnimationP1);
        animations.add(attackSuperAnimationP2);
        animations.add(healAnimation_first);
        animations.add(healAnimation_second);
    }
    public void tick() {
        switch (state) {
            case YOU_CANT_CATCH:
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.BAG_MENU;
                }
                break;
            case YOU_CANT_GIVEUP:
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.P1_IDLE;
                }
                break;
            case BAG_MENU:
                if (vidaPok1==initialLifePok1)
                    alreadyHealed = true;
                else alreadyHealed = false;
                bagMenu.tick();
                break;
            case P1_ALREADY_HEALED:
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.BAG_MENU;
                }
                break;
            case P1_NOT_ENOUGH_POKEBALLS:
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.BAG_MENU;
                }
                break;
            case P1_NOT_ENOUGH_POTIONS:
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.BAG_MENU;
                }
                break;
            case POKEMON_NOT_WEAK:
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.BAG_MENU;
                }
                break;
            case P1_HEAL:
                currSprite = healAnimation1.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.P2_IDLE;
                    if (vidaPok1 < initialLifePok1) //Si ha sufrido danio
                    {
                        if (healEffect > (initialLifePok1 - vidaPok1)) {
                            vidaPok1 = initialLifePok1;
                        } else {
                            vidaPok1 += healEffect;
                        }
                    }
                    numTicks = 0;
                }
                break;
            case P2_HEAL:
                currSprite = idle.getCurrSprite();
                currSprite2 = healAnimation2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.P1_IDLE;
                    if (vidaPok2 < initialLifePok2) //Si ha sufrido danio
                    {
                        if (healEffect > (initialLifePok2 - vidaPok2)) {
                            vidaPok2 = initialLifePok2;
                        } else {
                            vidaPok2 += healEffect;
                        }
                    }
                    numTicks = 0;
                }
                break;
            case P1_CAPTURE:
                currSprite = captureAnimation.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.POKEMON_CAPTURED;
                    player.getPokemons().add(pokLoad);
                    numTicks = 0 ;
                }
                break;
            case POKEMON_CAPTURED:
                currSprite = imgPokemonStatic_P1;
                currSprite2 = imgCapture;
                if (numTicks == NUM_TICKS_WAIT) {
                    endBattle=true;
                    if (battleAgainstPlayer) player2.setCanBattle(false);
                    //state = State.P1_IDLE;
                }
                break;
            case P1_IDLE:
                menu.tick();
                currSprite = idle.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                break;
            case TYPE_ATTACK_MENU:
                attackMenu.tick();
                break;
            case P1_ATTACK_FIRST:
                currSprite = attackAnimP1Normal.getCurrSprite();
                currSprite2 = idleP2.getCurrSprite();
                if (numTicks == NUM_TICKS_WAIT) {
                    state = State.P2_IDLE;
                    numTicks = 0;
                    vidaPok2 -= danio1_Pok1;
                    if (vidaPok2 <= 0) {
                        if(battleAgainstPlayer==false)
                           state = State.MAKE_DECISION;
                        else {
                            state = State.P2_DEAD;
                            player2.setCanBattle(false);
                        }
                    }
                }
                break;
            case MAKE_DECISION:
                decisionMenu.tick();
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
                        if(battleAgainstPlayer==false)
                           state = State.MAKE_DECISION;
                        else {
                            state = State.P2_DEAD;
                            player2.setCanBattle(false);
                        }
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
                    //state = State.P1_IDLE;
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
                    //state = State.P1_IDLE;
                }
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
                    } else if (response.equals("curarse")) {
                        System.out.println("El usuario 2 usó MOCHILA");
                        state = State.P2_HEAL;
                        numTicks = 0;
                        healEffect = 10;
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
                    //state = State.P1_IDLE;
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
        if ((state == State.P1_HEAL) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P2_HEAL) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P1_CAPTURE) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.POKEMON_CAPTURED) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P1_ALREADY_HEALED) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P1_NOT_ENOUGH_POKEBALLS) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.P1_NOT_ENOUGH_POTIONS) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.POKEMON_NOT_WEAK) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.YOU_CANT_CATCH) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        if ((state == State.YOU_CANT_GIVEUP) && (game.getNumTicks() == 58)) {
            numTicks++;
        }
        
        if (endBattle) {
            game.setState(Game.State.MAP);
            endBattle = false;
            state = State.P1_IDLE;
            try{
                entrada.close();
            }catch(Exception exp){
                System.out.println("El archivo no se cerro correctamente");
            }
        }
    }

    public int getRespectiveLife(int pok, int curLife, int reference) {
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
        if (state == State.P1_CAPTURE){
            g.drawImage(imgForAnimP1_Normal1, 130, 290, pokAncho, pokAlto, null);
            g.drawImage(currSprite, 0, 0, 800, 600, null);
            g.drawImage(currSprite2, 480, 85, pokAncho, pokAlto, null);
        }
        else if (state == State.POKEMON_CAPTURED){
            g.drawImage(currSprite, 130, 290, pokAncho, pokAlto, null);  
            g.drawImage(currSprite2, 500, 120, 72, 61, null);
        }
        else{
             g.drawImage(currSprite, 130, 290, pokAncho, pokAlto, null);   
             g.drawImage(currSprite2, 480, 85, pokAncho, pokAlto, null);
        }
        
        g.setColor(Color.green);
        g.fillRect(480+50, 208 + 125, 140, 20);
        g.setColor(Color.red);
        g.fillRect(480+50, 208 + 125, getRespectiveLife(1, vidaPok1, 140), 20);

        g.drawImage(imgBackgroundHP1, 360+50, 145 + 125, 280, 110, null);
        Font.getInstance().drawString(nombrePokPlayer1, g, 450+50, 160 + 125);
        
        g.setColor(Color.green);
        g.fillRect(165, 85 + 55, 140, 20);
        g.setColor(Color.red);
        g.fillRect(165, 85 + 55, getRespectiveLife(2, vidaPok2, 140), 20);
        
        g.drawImage(imgBackgroundHP2, 60, 30 + 55, 280, 110, null);
        Font.getInstance().drawString(nombrePokPlayer2, g, 120, 40 + 55);

        switch (state) {
            
            case P1_HEAL:
                break;
            case P2_HEAL:
                break;
            case P1_CAPTURE:
                Font.getInstance().drawString("YOU ARE CAPTURING "+nombrePokPlayer2, g, 30, 475);
                break;
            case POKEMON_CAPTURED:
                Font.getInstance().drawString("YOU'VE CAPTURED " + nombrePokPlayer2, g, 30, 475);
                break;
            case P1_IDLE:
                g.drawImage(fondoOpcion, 450 - 100, 425, 350 + 100, 171, null);
                menu.render(g);
                Font.getInstance().drawString("CHOOSE ONE OPTION", g, 30, 475);
                break;
            case TYPE_ATTACK_MENU:
                g.drawImage(fondoOpcion, 0, 425, 350 + 200, 171, null);
                attackMenu.render(g);
                Font.getInstance().drawString("CHOOSE YOUR", g, 570, 460);
                Font.getInstance().drawString("ATTACK", g, 570, 525);
                break;
            case BAG_MENU:
                bagMenu.render(g);
                Font.getInstance().drawString("CHOOSE WISELY..", g, 30, 475);
                break;
            case MAKE_DECISION:
                g.drawImage(fondoOpcion, 510, 460, 240, 85, null);
                Font.getInstance().drawString("WANT TO CAPTURE " + nombrePokPlayer2+ " ?", g, 30, 480);
                decisionMenu.render(g);
                break;
            case P1_ALREADY_HEALED:
                bagMenu.render(g);
                Font.getInstance().drawString("YOU'RE ALREADY HEALED..", g, 30, 475);
                break;
            case P1_NOT_ENOUGH_POKEBALLS:
                bagMenu.render(g);
                Font.getInstance().drawString("YOU DON'T HAVE ANY POKEBALLS.", g, 30, 460);
                Font.getInstance().drawString("THERE ARE SO MANY AROUND HERE...", g, 30, 525);
                //Font.getInstance().drawString("YOU DON'T HAVE ANY POKEBALLS. THERE ARE SO MANY AROUND HERE...", g, 30, 475);
                break;
            case YOU_CANT_CATCH:
                bagMenu.render(g);
                Font.getInstance().drawString("YOU CANT CATCH OTHER TRAINER'S POKEMON..", g, 30, 475);
                break;
            case YOU_CANT_GIVEUP:
                Font.getInstance().drawString("YOU CANT GIVE UP AGAINST OTHER TRAINER", g, 30, 475);
                break;
            case P1_NOT_ENOUGH_POTIONS:
                bagMenu.render(g);
                Font.getInstance().drawString("YOU DON'T HAVE ANY POTION. LOOK FOR ONE..", g, 30, 475);
                break;
            case POKEMON_NOT_WEAK:
                bagMenu.render(g);
                Font.getInstance().drawString(nombrePokPlayer2 + " IS NOT WEAK ENOUGH. TRY HARDER..", g, 30, 475);
                break;
            case P1_ATTACK_FIRST:
                if (!endBattle) {
                    Font.getInstance().drawString(nombrePokPlayer1 + " USED " + attack1_name, g, 30, 475);
                }
                break;
            case P1_ATTACK_SECOND:
                if (!endBattle) {
                    Font.getInstance().drawString(nombrePokPlayer1 + " USED " + attack2_name, g, 30, 475);
                }
                break;
            case P1_BAG:
                Font.getInstance().drawString("YOU USED THE BAG", g, 30, 475);
                break;
            case P1_GIVEUP:
                Font.getInstance().drawString("YOU'VE DECIDED TO LEAVE THE BATTLE..NOW, RUN..", g, 30, 475);
                break;
            case P1_DEAD:
                Font.getInstance().drawString(nombrePokPlayer2+ " DEFEATED YOU..", g, 30, 475);
                break;
            case P2_IDLE:
                break;
            case P2_ATTACK_FIRST:
                if (!endBattle) {
                    Font.getInstance().drawString(nombrePokPlayer2 + " USED " + attack1_P2name, g, 30, 475);
                }
                break;
            case P2_ATTACK_SECOND:
                if (!endBattle) 
                    Font.getInstance().drawString(nombrePokPlayer2 + " USED " + attack2_P2name, g, 30, 475);
                break;
            case P2_BAG:
                Font.getInstance().drawString("YOUR OPPONENT HAS JUST USED THE BAG", g, 30, 475);
                break;
            case P2_GIVEUP:
                if (battleAgainstPlayer)
                    Font.getInstance().drawString("YOUR OPPONENT RAN AWAY, SO.. YOU WON", g, 30, 475);
                else 
                    Font.getInstance().drawString("THE POKEMON HAS JUST ESCAPED...", g, 30, 475);
                
                break;
            case P2_DEAD:
                Font.getInstance().drawString("YOU'VE DEFEATED "+nombrePokPlayer2 , g, 30, 475);
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
        return "atacar2";
    }

    public void linkRoutes() {
        mapPokemons = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> rutasPOK1 = new ArrayList<>();
        ArrayList<String> rutasPOK2 = new ArrayList<>();
        ArrayList<String> rutasPOK3 = new ArrayList<>();
        ArrayList<String> rutasPOK4 = new ArrayList<>();
        ArrayList<String> rutasPOK7 = new ArrayList<>();
        /*BULBASAUR*/
        for (int i =1;i<=7;i++)
            rutasPOK1.add("res/battle/bulb_back"+Integer.toString(i)+".png");
        for (int i =1;i<=7;i++)
            rutasPOK1.add("res/battle/bulb_front"+Integer.toString(i)+".png");
        /*PIKACHU*/
        for (int i =1;i<=7;i++)
            rutasPOK2.add("res/battle/pika_back"+Integer.toString(i)+".png");
        for (int i =1;i<=7;i++)
            rutasPOK2.add("res/battle/pika_front"+Integer.toString(i)+".png");
        /*BUTTERFREE*/
        for (int i =1;i<=7;i++)
            rutasPOK3.add("res/battle/butt_back"+Integer.toString(i)+".png");
        for (int i =1;i<=7;i++)
            rutasPOK3.add("res/battle/butt_front"+Integer.toString(i)+".png");
        /*CHARMANDER*/
        for (int i =1;i<=7;i++)
            rutasPOK4.add("res/battle/char_back"+Integer.toString(i)+".png");
        for (int i =1;i<=7;i++)
            rutasPOK4.add("res/battle/char_front"+Integer.toString(i)+".png");
        /*SQUIRTLE*/
        for (int i =1;i<=7;i++)
            rutasPOK7.add("res/battle/sq_back"+Integer.toString(i)+".png");
        for (int i =1;i<=7;i++)
            rutasPOK7.add("res/battle/sq_front"+Integer.toString(i)+".png");

        mapPokemons.put(1, rutasPOK1); // ID:1->Bulbasaur
        mapPokemons.put(2, rutasPOK2); // ID:2->Pikachu
        mapPokemons.put(3, rutasPOK3); // ID:3->Butterfree
        mapPokemons.put(4, rutasPOK4); // ID:4->Charmander
        mapPokemons.put(7, rutasPOK7); // ID:7->Squirtle
    }
    /*Setters and Getters*/

    public int getHealEffect() {
        return healEffect;
    }

    public void setHealEffect(int healEffect) {
        this.healEffect = healEffect;
    }
    public void inicializeTicks() {
        numTicks = 0;
    }
    public void setInitialSpriteForBattle(){
        currSprite = imgForAnimP1_Normal1;
    }
    public boolean isAlreadyHealed() {
        return alreadyHealed;
    }

    public void setAlreadyHealed(boolean alreadyHealed) {
        this.alreadyHealed = alreadyHealed;
    }

    public int getVidaPok2() {
        return vidaPok2;
    }
    
    @Override
    public void render(Graphics2D g, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

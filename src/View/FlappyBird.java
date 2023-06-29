/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.Controller;
import Model.Modeller;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.ImageIcon;
import java.io.*;
import javax.swing.JButton;

import Sound.SoundPlayer;
import java.awt.Button;
//import static View.MenuHelp.BACK;

/**
 *
 * @author LinhNguyenDuc
 */
public class FlappyBird extends JFrame {
    public SoundPlayer fapSound , fallSound,getPointSound,themesong,zoomsong,clicksong;
    public static int WIDTH = 1500, HEIGHT = 800;
    public static Rectangle bird,map1,map2,map3,map4;
    public static ArrayList<Rectangle> columns;
    public Random random;
    public static int score,tick,yMotion;
    public static boolean start, end;
    public BackGround background;
    public static Modeller model;
    public static Controller control;
    public static int vk_space;
    public MenuManager menuManager;
    public View view;
    public static Button pause;
    public static int pause_int = 4;
    public static int a = 1;
    public FlappyBird() {
       
        pause = new Button("Pause");
        pause.setFont(new Font("Serif", 1, 20));
        add(pause);
        themesong = new SoundPlayer(new File ("themesong.wav"));
        clicksong = new SoundPlayer(new File("explosion.wav"));
        zoomsong = new SoundPlayer(new File("zoomsong.wav"));
        
        fapSound = new SoundPlayer(new File("fap.wav"));
        fallSound = new SoundPlayer((new File("fall.wav")));
        getPointSound = new SoundPlayer(new File("getpoint.wav"));
        control = new Controller(this);
        model = new Modeller(this);

        this.setSize(WIDTH,HEIGHT);
        this.setTitle("Game Flappy Bird");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        background = new BackGround();
        this.add(background);
        
        random = new Random();
        
        //set size bird
        bird = new Rectangle(WIDTH/3,HEIGHT/2-150, 50, 50);
        map1 = new Rectangle(0,HEIGHT - 150,WIDTH,150);
        map2 = new Rectangle(WIDTH,HEIGHT - 150,WIDTH,150);
        map3 = new Rectangle(0,0,WIDTH,HEIGHT);
        map4 = new Rectangle(WIDTH,0,WIDTH,HEIGHT);
        
        //khoi tao column
        columns = new ArrayList<>();
        model.addColumn(true);
        model.addColumn(true);
        model.addColumn(true);
        model.addColumn(true); 
    }

    //nhay
    public void jump() {
        this.model.jump();
    }
    
    static void repaint(Graphics g) throws IOException{
        BufferedImage img;
        pause.setBounds(50, 50, 80, 80);
        if(pause_int ==4) paintMap(g);
        else paintMapNoMove(g);
        if(pause_int ==4) paintGround(g);
        else paintGround1(g);

        if(vk_space == 0){
            img = ImageIO.read(new File("11.png"));
            g.drawImage(img, bird.x, bird.y, bird.width,bird.height,null);
        }
        else if(vk_space == 1){//bay len
            img = ImageIO.read(new File("12.png"));
            g.drawImage(img, bird.x, bird.y, bird.width,bird.height,null);
        }
        else{
            img = ImageIO.read(new File("10.png"));
            g.drawImage(img, bird.x, bird.y, bird.width,bird.height,null);
        }
        g.setColor(Color.black);
        g.setFont(new Font("Serif", 1, 50));

        if (!start){
            g.drawString("Click to start!",570,400);
            g.setFont(new Font("Dialog", 1, 20));
            g.drawString("Use keyboard spaces or click your mouse to jump up", 470, 450);
        }

        boolean check = false;
        for (Rectangle column : columns){
                paintColumn(g, column);
        }
        
        if (!end && start){//chua ket thuc hoac bat dau
            g.setColor(Color.black);
            g.setFont(new Font("Arial", 1, 100));
            g.drawString(String.valueOf(score), WIDTH/2-30, 100);
            if (pause_int == 0) {
                g.drawString("Game pause", WIDTH / 2 - 250, HEIGHT / 2 - 50);
                pause.setLabel("Resume");
            } else if (pause_int == 1) {
                g.drawString("1", WIDTH / 2 - 30, HEIGHT / 2 - 50);
                pause_int = 4;
                
            } else if (pause_int == 2) {
                g.drawString("2", WIDTH / 2 - 30, HEIGHT / 2 - 50);
                pause_int = 1;
            } else if (pause_int == 3) {
                g.drawString("3", WIDTH / 2 - 30, HEIGHT / 2 - 50);
                pause_int = 2;
                pause.setLabel("Pause");
            } if(pause_int==4) {
                control.timer.setDelay(20);
            }
        }
    }
    
    private static void paintColumn(Graphics g, Rectangle column) throws IOException {
        BufferedImage img;
        if(column.height>=150) img = ImageIO.read(new File("da2.png"));
        else img = ImageIO.read(new File("da1.png"));
        g.drawImage(img, column.x, column.y, column.width, column.height, null);

    }
    
    private static void paintGround(Graphics g) throws IOException {
        BufferedImage img;
        img = ImageIO.read(new File("ground.png"));
        g.drawImage(img, map1.x, map1.y, map1.width, map1.height, null);
        g.drawImage(img, map2.x, map2.y, map2.width, map2.height, null);
        map1.x -= 10;
        map2.x -= 10;
        if(map2.x == 0) map1.x =WIDTH;
        if(map1.x == 0) map2.x =WIDTH;
    }
   
    private static void paintGround1(Graphics g) throws IOException {
        BufferedImage img;
        img = ImageIO.read(new File("ground.png"));
        g.drawImage(img, map1.x, map1.y, map1.width, map1.height, null);
        g.drawImage(img, map2.x, map2.y, map2.width, map2.height, null);
        if(map2.x == 0) map1.x = WIDTH;
        if(map1.x == 0) map2.x = WIDTH;
    }
    
    private static void paintMapNoMove(Graphics g) throws IOException {
        BufferedImage img;
        img = ImageIO.read(new File("map4.png"));
        g.drawImage(img, map3.x, map3.y, map3.width, map3.height, null);
        g.drawImage(img, map4.x, map4.y, map4.width, map4.height, null);
        if(map4.x == 0) map3.x =WIDTH;
        if(map3.x == 0) map4.x =WIDTH;
    }
    
    private static void paintMap(Graphics g) throws IOException {
        BufferedImage img;
        img = ImageIO.read(new File("map4.png"));
        g.drawImage(img, map3.x, map3.y, map3.width, map3.height, null);
        g.drawImage(img, map4.x, map4.y, map4.width, map4.height, null);
        map3.x -= 5;
        map4.x -= 5;
        if(map4.x == 0) map3.x =WIDTH;
        if(map3.x == 0) map4.x =WIDTH;
    }
}

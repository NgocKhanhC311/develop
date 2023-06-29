/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import View.EndGame;
import View.FlappyBird;
import View.View;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author LinhNguyenDuc
 */
public class Controller implements ActionListener, MouseListener, KeyListener {

    private FlappyBird flappyBird;
    public Timer timer;
    private EndGame a;

    public Controller(FlappyBird flappyBird) {
        this.flappyBird = flappyBird;
        this.flappyBird.addMouseListener(this);
        //this.flappyBird.addKeyListener(this);
        this.flappyBird.pause.addKeyListener(this);
        this.flappyBird.pause.addMouseListener(this);
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        flappyBird.model.birdFly();
        flappyBird.repaint();
        if (flappyBird.end) {
            timer.stop();
            a = new EndGame(flappyBird.score, flappyBird, this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == flappyBird.pause) {
            if (!flappyBird.end && flappyBird.start) {
                if (flappyBird.pause_int == 4) {
                    flappyBird.pause_int = 0;
                    flappyBird.repaint();
                    timer.stop();
                } else if (flappyBird.pause_int == 0) {
                    flappyBird.pause_int = 3;
                    timer = new Timer(1000, this);
                    timer.start();
                }

            }

        }
        else {
            timer.setDelay(20);
            flappyBird.vk_space = 1;
            flappyBird.jump();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (flappyBird.pause_int == 0) {
                flappyBird.pause_int = 3;
                timer = new Timer(1000, this);
                timer.start();

            } else if (flappyBird.pause_int == 4) {
                timer.setDelay(20);
                flappyBird.jump();
                flappyBird.vk_space = 1;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            flappyBird.bird = new Rectangle(flappyBird.bird.x, flappyBird.bird.y, flappyBird.bird.width * 5/4, flappyBird.bird.height * 5/4);
            flappyBird.jump();
            flappyBird.vk_space = 1;
            flappyBird.zoomsong.play();
            flappyBird.a++;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (!flappyBird.end && flappyBird.start) {
                flappyBird.pause_int = 0;
                flappyBird.repaint();
                timer.stop();
            }
        }
    }
}

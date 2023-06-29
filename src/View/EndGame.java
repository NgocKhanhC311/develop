/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import Control.Controller;
import Sound.SoundMenu;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import View.View;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author LinhNguyenDuc
 */
public class EndGame extends JDialog {

    private JDialog dialog;
    private JLabel topic, guide, mark;
    private JButton yes, no;
    private FlappyBird flappyBird;
    private Controller controller;
    private MenuManager menuManager;

    public EndGame(int a, FlappyBird flappyBird, Controller controller ) {
        this.flappyBird = flappyBird;
        this.controller = controller;
        
        showDialog(a);
        dialog.setVisible(true);
    }

    public void showDialog(int a) {
        dialog = new JDialog(this);
        dialog.setLayout(null);

        topic = new JLabel("Your score", JLabel.CENTER);
        mark = new JLabel(String.valueOf(a), JLabel.CENTER);
        guide = new JLabel("Do you want to play again?", JLabel.CENTER);

        Font font = new Font("Dialog", Font.BOLD, 40);
        Font font1 = new Font("Dialog", Font.BOLD, 20);
        topic.setFont(font);
        mark.setFont(font);
        guide.setFont(font1);

        JPanel text = new JPanel(new GridLayout(3, 1));
        text.add(topic);
        text.add(mark);
        text.add(guide);
        text.setBounds(180, 20, 400, 200);
        
        ImageIcon Start1 = new ImageIcon(getClass().getResource("/image/menu/playagain.png"));
        ImageIcon Start2 = new ImageIcon(getClass().getResource("/image/menu/playagain1.png"));
        yes = new JButton(Start1);
        yes.setRolloverIcon(Start2);
        yes.setSize(Start1.getIconWidth(), Start1.getIconHeight());
        yes.setLocation(800/4-Start1.getIconWidth()/2, 250);
        yes.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        yes.setHorizontalAlignment(JButton.LEADING);
        yes.setBorderPainted(false);
        yes.setContentAreaFilled(false);
        dialog.add(yes);
        
        
        ImageIcon Exit1 = new ImageIcon(getClass().getResource("/image/menu/exxithuongdan.png"));
        ImageIcon Exit2 = new ImageIcon(getClass().getResource("/image/menu/exxithuongdan1.png"));
        no = new JButton(Exit1);
        no.setRolloverIcon(Exit2);
        no.setSize(Exit1.getIconWidth(), Exit1.getIconHeight());
        no.setLocation(600-Exit1.getIconWidth()/2, 250);
        no.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        no.setHorizontalAlignment(JButton.LEADING);
        no.setBorderPainted(false);
        no.setContentAreaFilled(false);
        dialog.add(no);
        //no.setHorizontalTextPosition(AbstractButton.CENTER);

        dialog.setSize(800, 500);

        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(true);

        dialog.add(yes);
        dialog.add(no);
        dialog.add(text);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                Clip clip = SoundMenu.getSound(getClass().getResource("/sound/shoot.wav"));
                clip.start();
                if (flappyBird.end) {
                    flappyBird.themesong.stop();
                    controller.timer.start();
                    flappyBird.jump();
                    flappyBird.themesong.play();
                    flappyBird.end = false;
                }
            }
        });
        
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                Clip clip = SoundMenu.getSound(getClass().getResource("/sound/shoot.wav"));
                clip.start();
                System.exit(0);
            }
        });
    }
//    public final Icon[] imgStart = {
//    new ImageIcon(getClass().getResource("/image/menu/playagain.png")),
//    new ImageIcon(getClass().getResource("/image/menu/playagain1.png")),};
//    
//    public final Icon[] imgExit = {
//    new ImageIcon(getClass().getResource("/image/menu/exxithuongdan.png")),
//    new ImageIcon(getClass().getResource("/image/menu/exxithuongdan1.png")),};
}

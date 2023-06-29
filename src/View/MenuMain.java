package View;

import javax.sound.sampled.Clip;
import javax.swing.*;
import Control.Controller;
import Sound.SoundMenu;

import Control.Controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuMain extends JPanel implements KeyListener {

    public JButton jbStart;
    public JButton jbHelp;
    public JButton jbExit;
    private MenuManager menuManager;
    private Controller controller;
    private FlappyBird flappyBird;
    public View view;

    public MenuMain(MenuManager menuManager) {
        setLayout(null);;
        ImageIcon Start1 = new ImageIcon(getClass().getResource("/image/menu/play2.png"));
        ImageIcon Start2 = new ImageIcon(getClass().getResource("/image/menu/play1.png"));
     
        jbStart = new JButton(Start1);
        jbStart.setRolloverIcon(Start2);
        jbStart.setSize(Start1.getIconWidth(), Start1.getIconHeight());
        jbStart.setLocation(120, 420);
        jbStart.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jbStart.setHorizontalAlignment(JButton.LEADING);
        jbStart.setBorderPainted(false);
        jbStart.setContentAreaFilled(false);
        add(jbStart);
        
        ImageIcon Help1 = new ImageIcon(getClass().getResource("/image/menu/helpMenu1.png"));
        ImageIcon Help2 = new ImageIcon(getClass().getResource("/image/menu/helpMenu2.png"));
        jbHelp = new JButton(Help1);
        jbHelp.setRolloverIcon(Help2);
        jbHelp.setSize(Help1.getIconWidth(), Help1.getIconHeight());
        jbHelp.setLocation(650, 420);
        jbHelp.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jbHelp.setHorizontalAlignment(JButton.LEADING);
        jbHelp.setBorderPainted(false);
        jbHelp.setContentAreaFilled(false);
        add(jbHelp);
        
        ImageIcon Exit1 = new ImageIcon(getClass().getResource("/image/menu/exit1.png"));
        ImageIcon Exit2 = new ImageIcon(getClass().getResource("/image/menu/exit2.png"));
        jbExit = new JButton(Exit1);
        jbExit.setRolloverIcon(Exit2);
        jbExit.setSize(Start1.getIconWidth(), Start1.getIconHeight());
        jbExit.setLocation(1200, 420);
        jbExit.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jbExit.setHorizontalAlignment(JButton.LEADING);
        jbExit.setBorderPainted(false);
        jbExit.setContentAreaFilled(false);
        add(jbExit);
        
        jbStart.addActionListener(this::actionPerformed);
        jbStart.setActionCommand(START);
        jbHelp.addActionListener(this::actionPerformed);
        jbHelp.setActionCommand(HELP);
        jbExit.addActionListener(this::actionPerformed);
        jbExit.setActionCommand(EXIT);
        this.menuManager = menuManager;

    }

    public MenuMain(View view) {
        this.view = view;
    }

    public static final String START = "start";
    public static final String HELP = "help";
    public static final String EXIT = "exit";


    public void actionPerformed(ActionEvent actionEvent) {
        String run = actionEvent.getActionCommand();
        switch (run) {
            case START: {
                Clip clip = SoundMenu.getSound(getClass().getResource("/sound/shoot.wav"));
                clip.start();
                menuManager.showContent(menuManager.MENU_GAME);
                break;
            }
            case HELP: {
                Clip clip = SoundMenu.getSound(getClass().getResource("/sound/shoot.wav"));
                clip.start();
                menuManager.showContent(menuManager.MENU_HELP);
                break;
            }
            case EXIT: {
                Clip clip = SoundMenu.getSound(getClass().getResource("/sound/shoot.wav"));
                clip.start();
                System.exit(0);
            }
        }
    }



    protected void paintComponent(Graphics graphics) {
        super.paintChildren(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        Image img = new ImageIcon(getClass().getResource("/image/Background.png")).getImage();
        graphics2D.drawImage(img, 0, 0, 1500, 800, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

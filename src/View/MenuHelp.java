package View;

import javax.sound.sampled.Clip;
import javax.swing.*;
import Sound.SoundMenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHelp extends JPanel implements ActionListener {

    private JButton jbBack;
    

    private MenuManager menuManager;

    public static final String BACK = "back";

    public MenuHelp(MenuManager menuManager) {
        setLayout(null);
        ImageIcon Back1 = new ImageIcon(getClass().getResource("/image/ExitMenuHelp.png"));
        ImageIcon Back2 = new ImageIcon(getClass().getResource("/image/ExitMenuHelp.png"));
        jbBack = new JButton(Back1);
        jbBack.setRolloverIcon(Back2);
        jbBack.setSize(Back1.getIconWidth(), Back2.getIconHeight());
        jbBack.setLocation(40, 600);
        jbBack.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jbBack.setHorizontalAlignment(JButton.LEADING);
        jbBack.setBorderPainted(false);
        jbBack.setContentAreaFilled(false);
        add(jbBack);
        jbBack.addActionListener(this);
        jbBack.setActionCommand(BACK);
        this.menuManager = menuManager;
    }

   
   

   

    protected void paintComponent(Graphics graphics) {
        super.paintChildren(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        Image img = new ImageIcon(getClass().getResource("/image/MenuHelp.png")).getImage();
        graphics2D.drawImage(img, 0, 0, View.W_FRAME, View.H_FRAME, null);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String run = actionEvent.getActionCommand();
        ;
        switch (run) {
            case BACK: {
                Clip clip = SoundMenu.getSound(getClass().getResource("/sound/shoot.wav"));
                clip.start();
                menuManager.showContent(menuManager.MENU_MAIN);
                break;
            }
            default:
                break;
        }
    }

}

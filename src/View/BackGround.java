/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author LinhNguyenDuc
 */
public class BackGround extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        try {
            FlappyBird.repaint(g);
        } catch (IOException ex) {
            //Logger.getLogger(BackGround.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

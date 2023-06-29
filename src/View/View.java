package View;


import javax.swing.*;

public class View extends JFrame {
    public static final int W_FRAME = 1500;
    public static final int H_FRAME = 800;
    private MenuMain menuMain ;
    private EndGame endgame;
    private FlappyBird flappyBird;
    
    

    MenuManager menuManager = new MenuManager(this);
 


    public View(){
        
        setTitle("Flappy Bird");
        setSize(W_FRAME,H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(menuManager);
        setVisible(true);
        
        
        
         
        
    }
}

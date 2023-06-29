package View;

import javax.swing.*;

import Control.Controller;
import java.awt.*;

public class MenuManager extends JPanel {

    public static final String MENU_GAME = "Menu Game";
    public static final String MENU_MAIN = "Menu Main";
    public static final String MENU_HELP = "Menu Help";
    private MenuHelp menuHelp;
    private MenuMain menuMain;
    private FlappyBird flappyBird;
    private View view;
    private Controller controller;
    CardLayout cardLayout;

    public MenuManager(View view) {

        this.view = view;
        menuMain = new MenuMain(this);
        menuHelp = new MenuHelp(this);
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        add(menuMain, MENU_MAIN);
        add(menuHelp, MENU_HELP);
        setFocusable(true);
    }

    public void showContent(String name) {
        switch (name) {
            case MENU_GAME: {
                flappyBird = new FlappyBird();
                this.view.dispose(); 
            }  
            case MENU_MAIN: {
                cardLayout.show(this, MENU_MAIN);
            }
            case MENU_HELP: {
                cardLayout.show(this, name);
            }
        }
    }
}

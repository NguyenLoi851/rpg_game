package main;

import game_state.GameStateManager;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Engine {
        private static GameStateManager gameStateManager;
        private static WindowManager windowManager;
        private static Timer timer;
        public static void init() {
            gameStateManager = new GameStateManager();
            windowManager = new WindowManager();
            timer = new Timer(20,new MainGameLoop());
        }
        public static void start(){
            
            windowManager.addPanel(new GameScreen());
            windowManager.addKeyListener(new Keyboard());
            windowManager.createWindow();
            timer.start();
            
        }
        private static class MainGameLoop implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent arg0){
                gameStateManager.Loop();
            }
        }
        private static class GameScreen extends JPanel {
            private static final long serialVersionUID = 1L;
            @Override
            protected void paintComponent(Graphics graphics){
                super.paintComponent(graphics);
                gameStateManager.Render(graphics);
                repaint();
            }
        }
    private static class Keyboard implements KeyListener {

        @Override
        public void keyPressed(KeyEvent key) {
            gameStateManager.KeyPressed(key.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent key) {
            gameStateManager.KeyReleased(key.getKeyCode());
        }

        @Override
        public void keyTyped(KeyEvent arg0) {}

    }
}

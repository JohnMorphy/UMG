package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{

    int windowWidth = 600;
    int windowHeight = 500;
    int leftMargin = 150;
    int topMargin = 50;
    int buttonWidth = 300;
    int buttonHeight = 100;

    JButton createCharacterButton;
    JButton exitButton;
    public Menu() {

        Font font = new Font("Serif", Font.BOLD, 20);
        createCharacterButton = new JButton("Create Character");
        createCharacterButton.setBounds( leftMargin, topMargin,buttonWidth,buttonHeight);
        createCharacterButton.setFont(font);


        exitButton = new JButton("Exit game");
        exitButton.setBounds(leftMargin,topMargin*2 + buttonHeight,buttonWidth,buttonHeight);
        exitButton.setFont(font);

        add(exitButton);
        add(createCharacterButton);

        this.setSize(windowWidth, windowHeight);
        this.setLayout(null);
        this.setVisible(true);


        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent action) {

                if (action.getSource() == exitButton) {
                    dispose();
                }

                if (action.getSource() == createCharacterButton) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new CharacterCreation();
                        }
                    });
                    dispose();
                }
            }
        };


        createCharacterButton.addActionListener(actionListener);
        exitButton.addActionListener(actionListener);
    }
}

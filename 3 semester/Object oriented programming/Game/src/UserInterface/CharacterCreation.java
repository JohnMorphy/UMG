package UserInterface;

import Exceptions.NoImageException;
import Gameplay.Fight;
import Gameplay.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCreation extends JFrame{

    int windowWidth = 550;
    int windowHeight = 600;

    final int initialLeftMargin = 50;
    final int initialTopMargin = 50;

    final int leftMarginBetweenObjects = 5;
    final int topMarginBetweenObjects = 5;
    int leftMargin;
    int topMargin;

    int fieldHeight;
    int fieldWidth;

    int fontSize = 15;

    JTextField characterName;
    JLabel nameLabel;

    JButton minusHealth;
    JButton plusHealth;
    JLabel maxHealthAmount;

    JButton minusStrength;
    JButton plusStrength;
    JLabel strengthAmount;

    JButton minusAgility;
    JButton plusAgility;
    JLabel agilityAmount;

    JButton minusIntelligence;
    JButton plusIntelligence;
    JLabel intelligenceAmount;

    JLabel remainingPoints;

    JLabel warriorImage;

    JButton saveCharacter;
    JButton loadCharacter;
    JButton fightButton;
    private ActionListener buttonActions;
    private ActionListener changeNameAction;

    private Hero hero;

    public JButton initializeJButton(int x, int y, int width, int height, Font font, String text) {
        JButton button = initializeJButton(x, y, width, height, text);
        button.setFont(font);
        return button;
    }

    public JButton initializeJButton(int x, int y, int width, int height, String text) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        Font font = new Font("Serif", Font.BOLD, fontSize);
        button.setFont(font);
        add(button);
        button.addActionListener(buttonActions);
        return button;
    }

    public JLabel initializeJLabel(int x, int y, int width, int height, Font font, String text) {
        JLabel label = initializeJLabel(x, y, width, height, text);
        label.setFont(font);
        return label;
    }

    public JLabel initializeJLabel(int x, int y, int width, int height, String text) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        Font font = new Font("Serif", Font.BOLD, fontSize);
        label.setFont(font);
        add(label);
        return label;
    }

    public JTextField initializeJTextField(int x, int y, int width, int height, String text,  Font font) {
        JTextField jTextField = initializeJTextField(x, y, width, height, text);
        jTextField.setFont(font);
        return jTextField;
    }

    public JTextField initializeJTextField(int x, int y, int width, int height, String text) {
        JTextField jTextField = new JTextField(text);
        jTextField.setBounds(x, y, width, height);
        Font font = new Font("Serif", Font.BOLD, fontSize);
        jTextField.setFont(font);
        add(jTextField);
        return jTextField;
    }

    public CharacterCreation() {

        hero = new Hero(5, 1, 1 ,1, "");

        Font font = new Font("Serif", Font.BOLD, fontSize);

        this.changeNameAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = characterName.getText();
                hero.setName(text);
                characterName.setText(hero.getName());
            }
        };

        this.buttonActions = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent action) {

                if(action.getSource() == minusHealth) {
                    if(hero.removeMaxHealth()){
                        maxHealthAmount.setText("Health: " + hero.getMaxHealth());
                        remainingPoints.setText("Remaining points: " + hero.getRemainingPoints());
                    }
                }

                if(action.getSource() == plusHealth) {
                    if(hero.addMaxHealth()){
                        maxHealthAmount.setText("Health: " + hero.getMaxHealth());
                        remainingPoints.setText("Remaining points: " + hero.getRemainingPoints());
                    }
                }

                if(action.getSource() == minusStrength) {
                    if(hero.removeStrength()){
                        strengthAmount.setText("Strength: " + hero.getStrength());
                        remainingPoints.setText("Remaining points: " + hero.getRemainingPoints());
                    }
                }

                if(action.getSource() == plusStrength) {
                    if(hero.addStrength()){
                        strengthAmount.setText("Strength: " + hero.getStrength());
                        remainingPoints.setText("Remaining points: " + hero.getRemainingPoints());
                    }
                }

                if(action.getSource() == minusAgility) {
                    if(hero.removeAgility()){
                        agilityAmount.setText("Agility: " + hero.getAgility());
                        remainingPoints.setText("Remaining points: " + hero.getRemainingPoints());
                    }
                }

                if(action.getSource() == plusAgility) {
                    if(hero.addAgility()){
                        agilityAmount.setText("Agility: " + hero.getAgility());
                        remainingPoints.setText("Remaining points: " + hero.getRemainingPoints());
                    }
                }

                if(action.getSource() == minusIntelligence) {
                    if(hero.removeIntelligence()){
                        intelligenceAmount.setText("Intelligence: " + hero.getIntelligence());
                        remainingPoints.setText("Remaining points: " + hero.getRemainingPoints());
                    }
                }

                if(action.getSource() == plusIntelligence) {
                    if(hero.addIntelligence()){
                        intelligenceAmount.setText("Intelligence: " + hero.getIntelligence());
                        remainingPoints.setText("Remaining points: " + hero.getRemainingPoints());
                    }
                }

                if(action.getSource() == fightButton) {
                    Fight.start();
                }

                if(action.getSource() == saveCharacter) {
                    
                }

                if(action.getSource() == loadCharacter) {

                }
            }
        };





        //name
        leftMargin = initialLeftMargin; topMargin = initialTopMargin;
        fieldWidth = 210; fieldHeight = 30;
        nameLabel = initializeJLabel(leftMargin, topMargin, fieldWidth, fieldHeight, "Name");

        topMargin += fieldHeight + topMarginBetweenObjects;
        fieldWidth = 210; fieldHeight = 30;
        characterName = initializeJTextField(leftMargin, topMargin, fieldWidth, fieldHeight, hero.getName());
        characterName.addActionListener(changeNameAction);

        //adding, and removing health + healthAmount in label
        topMargin += fieldHeight + topMarginBetweenObjects;
        fieldWidth = 50; fieldHeight = 50;
        minusHealth = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "-");

        leftMargin += fieldWidth + leftMarginBetweenObjects;
        fieldWidth = 100; fieldHeight = 50;
        maxHealthAmount = initializeJLabel(leftMargin, topMargin, fieldWidth, fieldHeight, "Health: " + hero.getMaxHealth());

        leftMargin += fieldWidth + leftMarginBetweenObjects;
        fieldWidth = 50; fieldHeight = 50;
        plusHealth = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "+");

        //adding, and removing strength + strengthAmount in label
        leftMargin = initialLeftMargin;
        topMargin += fieldHeight + topMarginBetweenObjects;
        fieldWidth = 50; fieldHeight = 50;
        minusStrength = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "-");

        leftMargin += fieldWidth + leftMarginBetweenObjects;
        fieldWidth = 100; fieldHeight = 50;
        strengthAmount = initializeJLabel(leftMargin, topMargin, fieldWidth, fieldHeight, "Strength: " + hero.getStrength());

        leftMargin += fieldWidth + leftMarginBetweenObjects;
        fieldWidth = 50; fieldHeight = 50;
        plusStrength = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "+");

        //adding, and removing agility + agilityAmount in label
        leftMargin = initialLeftMargin;
        topMargin += fieldHeight + topMarginBetweenObjects;
        fieldWidth = 50; fieldHeight = 50;
        minusAgility = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "-");

        leftMargin += fieldWidth + leftMarginBetweenObjects;
        fieldWidth = 100; fieldHeight = 50;
        agilityAmount = initializeJLabel(leftMargin, topMargin, fieldWidth, fieldHeight, "Agility: " + hero.getAgility());

        leftMargin += fieldWidth + leftMarginBetweenObjects;
        fieldWidth = 50; fieldHeight = 50;
        plusAgility = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "+");


        //adding, and removing intelligence + intelligenceAmount in label
        leftMargin = initialLeftMargin;
        topMargin += fieldHeight + topMarginBetweenObjects;
        int columnHeight = topMargin - initialTopMargin;
        fieldWidth = 50; fieldHeight = 50;
        minusIntelligence = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "-");

        leftMargin += fieldWidth + leftMarginBetweenObjects;
        fieldWidth = 100; fieldHeight = 50;
        intelligenceAmount = initializeJLabel(leftMargin, topMargin, fieldWidth, fieldHeight, "Intelligence: " + hero.getIntelligence());

        leftMargin += fieldWidth + leftMarginBetweenObjects;
        fieldWidth = 50; fieldHeight = 50;
        plusIntelligence = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "+");

        //remaining points label
        leftMargin = initialLeftMargin;
        topMargin += fieldHeight + topMarginBetweenObjects;
        fieldWidth = 210; fieldHeight = 50;
        remainingPoints = initializeJLabel(leftMargin, topMargin, fieldWidth, fieldHeight, "Remaining points: " + hero.getRemainingPoints());

        //character image
        leftMargin += fieldWidth + leftMarginBetweenObjects;
        topMargin = initialTopMargin + 30 + topMarginBetweenObjects;
        fieldWidth = 215; fieldHeight = columnHeight + 30 + topMarginBetweenObjects;
        warriorImage = initializeJLabel(leftMargin,  topMargin, fieldWidth, fieldHeight, "");

        try {
            ImageIcon image = new ImageIcon("./src/characterImage.JPG");
            if(image.getIconHeight() == -1) {
                throw (new NoImageException());
            }
            warriorImage.setIcon(image);
        } catch (NoImageException noImageException) {
            warriorImage.setText("No image found");
        }

        //saving & loading character buttons
        topMargin += fieldHeight + topMarginBetweenObjects;
        fieldWidth = 105; fieldHeight = 50;
        saveCharacter = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "Save Hero");

        leftMargin += fieldWidth + leftMarginBetweenObjects;
        fieldWidth = 105; fieldHeight = 50;
        loadCharacter = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "Load Hero");

        //fight button
        topMargin += fieldHeight + topMarginBetweenObjects;
        leftMargin = initialLeftMargin;
        fieldWidth = 430; fieldHeight = 50;
        fightButton = initializeJButton(leftMargin, topMargin, fieldWidth, fieldHeight, "Fight!");


        this.setSize(windowWidth, windowHeight);
        this.setLayout(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CharacterCreation();
            }
        });
    }
}

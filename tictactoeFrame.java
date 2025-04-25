package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Tic Tac Toe");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(400, 450);
            mainFrame.setLocationRelativeTo(null);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

            // Start Menu Panel
            JPanel startMenuPanel = new JPanel(new BorderLayout());
             JLabel title = new JLabel("Welcome to ANGEL vs DEVIL!", JLabel.CENTER);
              JButton startButton = new JButton("Start Game");
               startMenuPanel.add(title, BorderLayout.CENTER);
                startMenuPanel.add(startButton, BorderLayout.SOUTH);

            // Story Panel
            JPanel storyPanel = new JPanel(new BorderLayout());
             JTextArea storyText = new JTextArea(
                "Long ago, the realms of Angel and Devil were at peace...\n\n" +
                "Until one day, a Mysterious item called PRIMOGEM arrived.\n\n" +
                "This said primogem can give either the Angel,s and Devil eternal strength!\n\nAre you ready?"
            );
            storyText.setEditable(false);
             storyText.setWrapStyleWord(true);
              storyText.setLineWrap(true);
               storyText.setMargin(new Insets(10, 10, 10, 10));
                storyText.setFont(new Font("Serif", Font.PLAIN, 16));
            JButton continueButton = new JButton("Continue");
            storyPanel.add(new JScrollPane(storyText), BorderLayout.CENTER);
            storyPanel.add(continueButton, BorderLayout.SOUTH);

         
            TicTacToeFrame gameFrame = new TicTacToeFrame();
            mainPanel.add(startMenuPanel, "Start");
             mainPanel.add(storyPanel, "Story");
              mainPanel.add(gameFrame.getContentPane(), "Game");

            startButton.addActionListener(e -> cardLayout.show(mainPanel, "Story"));
            continueButton.addActionListener(e -> cardLayout.show(mainPanel, "Game"));

            mainFrame.add(mainPanel);
            mainFrame.setVisible(true);
            cardLayout.show(mainPanel, "Start"); 
        });
    }
}

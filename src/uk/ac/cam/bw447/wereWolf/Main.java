package uk.ac.cam.bw447.wereWolf;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        helperApp app = new helperApp();
    }


}

class helperApp extends JFrame{
    JPanel LabelPanel, buttonPanel;
    JButton startButton;
    int gameSize;
    JLabel startLabel;
    JLabel[] arrangementLabels;

    public helperApp(){
//        window = new JFrame();
        this.setSize(500,500);
        this.setTitle("双身份狼人杀发牌助手");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add a selection of game size in following version
        gameSize = 6;

        //initialise panel
        LabelPanel = new JPanel();
        LabelPanel.setLayout(new GridLayout(6,1));
        buttonPanel = new JPanel();

        //button to start game
        startButton = new JButton("Let's rock!");
//        window.add(startButton, BorderLayout.SOUTH);
        buttonPanel.add(startButton,BorderLayout.SOUTH);

        //label to show arrangement
        arrangementLabels = new JLabel[gameSize];
        for (int i = 0; i<gameSize;i++){
            arrangementLabels[i] = new JLabel("",JLabel.CENTER);
            arrangementLabels[i].setFont(new Font(arrangementLabels[0].getFont().getFontName(),Font.PLAIN,20));
            arrangementLabels[i].setForeground(Color.BLACK);
            arrangementLabels[i].setVisible(false);
            LabelPanel.add(arrangementLabels[i],BorderLayout.PAGE_END);
        }
        LabelPanel.setVisible(true);

         // label to give a welcome
        arrangementLabels[gameSize/2].setText("Ready?");
        arrangementLabels[gameSize/2].setVisible(true);

        this.add(buttonPanel,BorderLayout.SOUTH);
        this.add(LabelPanel,BorderLayout.CENTER);

        startButton.addActionListener(e -> {
            if (startButton.getText().equals("Let's rock!")) {
                startButton.setText("Clear");
                String[] s = GameForSixPlayers.start().toString().split("\n");
                for (int i = 0; i < gameSize; i++) {
                    arrangementLabels[i].setText(s[i]);
                    arrangementLabels[i].setVisible(true);
                    LabelPanel.setVisible(true);
                }
            }
            else {
                startButton.setText("Let's rock!");
                for (JLabel l : arrangementLabels){
                    l.setText("");
                }
                arrangementLabels[gameSize/2].setText("Ready?");

            }

        });

        this.setVisible(true);
    }
}






















//interface changeableString {
//    void switchMode();
//    @Override
//    String toString();
//}

//class titleString {
//    private changeableString state;
//    class englishMode implements changeableString{
//
//        @Override
//        public void switchMode() {
//            state = new chineseMode();
//        }
//
//        @Override
//        public String toString() {
//            return "Double Werewolf Helper";
//        }
//    }
//    class chineseMode implements changeableString{
//
//        @Override
//        public void switchMode() {
//            state = new englishMode();
//        }
//
//        @Override
//        public String toString() {
//            return "双身份狼人杀发牌助手";
//        }
//    }
//
//    @Override
//    public  String toString() {
//        throw new UnsupportedOperationException();
//    }
//}

package TTTre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.*;


/**
 *
 * @author 811001
 */


public class GameFrame extends JFrame implements ActionListener{
    private byte gameSize;
    private int row;
    private int col;
    TikTakToe game ;
 JButton[] btns = new JButton[9];
     JPanel panel = new JPanel();
     //
     boolean flag = false;
     int chance = 0;
    public void getGameSize() {
    }
 
    public void drawLine() {
    }
   //вынести массив в качестве поля класса
   
    GameFrame() {
        game = new TikTakToe();

        game.initializeBoard();
        System.out.println("Tic-Tac-Toe!");
        setSize(500, 350);
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    
        for (Integer i = 0; i < 9; i++) {

            btns[i] = new JButton("");
            btns[i].setPreferredSize(new Dimension(300, 100));
            panel.add(btns[i]);
        }
        for (int i = 0; i < 9; i++) {
       btns[i].addActionListener(this);

        }



        GridLayout mygrid = new GridLayout(3, 3, 1, 1);
        panel.setLayout(mygrid);

        add(panel, BorderLayout.NORTH);
        setVisible(true);

    }
    public void play(){

        System.out.println("Current board layout:");
        game.printBoard();
        System.out.println("Player " + game.getCurrentPlayerMark() + ", enter an empty row and column to place your mark!");
  
    }

    private int index;

    public int getIndex(){
        return index;
    }
    void setIndex(int k){
        index = k;
    }
    public static int btnPressed ( int i) {
        return i;
        
    }
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 for (int i = 0; i < 9; i++) {
            if (e.getSource() == btns[i]) {
                if (!flag) {
                      if (btns[i].getText() == "") {
                                  
                          btns[i].setText("X");
                        flag = true;
                        System.out.println("O turn");
                        row = (int)(i/3);
                        col = i % 3;
                        game.placeMark(row, col);
                      if (game.isBoardFull() && !game.checkForWin()){
                         System.out.println("Tie");
                      }
                        else
                        {
                            System.out.println("Current board layout:");
                            game.printBoard();
                            game.changePlayer();
                      //      System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Wins!");
                        }
                    if(game.checkForWin()){System.exit(0);}
                    }
                } else {
                  
                    if (btns[i].getText() == "") {
                        
                        btns[i].setText("O");
                        flag = false;
                        System.out.println("X turn");
                        row = (int)(i/3);
                        col = i % 3;
                        game.placeMark(row, col);
                
                        if (game.isBoardFull() && !game.checkForWin())
                              {
                                  System.out.println("Tie");
                              }
                              else
                              {
                                  System.out.println("Current board layout:");
                                  game.printBoard();
                                  game.changePlayer();
                            //      System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Wins!");
                              }

                    }
                      if(game.checkForWin()){System.exit(0);}
                }
            }
        }
    }

}
    

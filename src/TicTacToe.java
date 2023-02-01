import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Improvements needed:
 * 1.: check() method
 */

public class TicTacToe implements ActionListener {

    Random random = new Random();

    JFrame frame = new JFrame();

    JPanel title_panel = new JPanel();

    JPanel button_panel = new JPanel();

    JLabel textfield = new JLabel();

    JButton[] buttons = new JButton[9];

    boolean player1_turn;
    boolean AI_turn = true;
    boolean AI_steps = true;

    public int round = 0;



    TicTacToe(){
        frame.setTitle("TicTacToe v1.0 by BroCode & A_Fejes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(1250, 430);


        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        //textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setFont(new Font("Arial",Font.BOLD,55));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));



        for(int i=0;i<9;i++) {

            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        title_panel.add(textfield);

        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
       //drawGame();

    }

    private void firstTurn() {
        try {
            Thread.sleep(1000); // delay for TicTacToe title
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // ki kezd?
        player1_turn = true; //always X turn
        textfield.setText("X turn");
        /*
        if(random.nextInt(2) == 0){
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
        */
    }

    public void winCheck() { // this method should be developed!!!
        //all possible combinations must be checked:
    //check X win conditions:
        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") &&(buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(6,7,8);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
            xWins(0,3,6);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
            xWins(2,4,6);
        }

        //check O win conditions

        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(6,7,8);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
            oWins(0,3,6);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
            oWins(2,4,6);
        }

    }

    public void xWins(int a,int b,int c) {
        System.out.println("xWins");
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
        System.out.println("TEXTFIELD: "+textfield.getText());
        //disabledAllButtons();
    }

    public void oWins(int a,int b,int c) {
        System.out.println("oWins");
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
        //disabledAllButtons();
    }

    public void drawGame(){
        int counterXorO = 0;
        int counterColor = 0;
        for(int i=0;i<9;i++) {
            if ((buttons[i].getText() == "X") || (buttons[i].getText() == "O")) {
                counterXorO++;
            }
        }
        for(int i=0;i<9;i++) {
            if ((buttons[i].getBackground().equals(Color.GREEN))) {
                counterColor++;
            }
        }
        if(counterXorO == 9 && counterColor == 0){
            textfield.setText("Draw game");
        }

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        winCheck();
        drawGame();
        System.out.println("actionPerformed first X");
        //while (true) { //!(textfield.getText().equals("X wins"))
            for (int i = 0; i < 9; i++) {
                //int i = 0;

                if (e.getSource() == buttons[i]) {

                    if (player1_turn) {

                        if (buttons[i].getText() == "") {

                            buttons[i].setForeground(new Color(255, 0, 0)); //red X

                            buttons[i].setText("X");

                            player1_turn = false;

                            round++;
                            AI_steps = true;




                        }


                    }

                }
                /*
                else {

                    if(buttons[i].getText()=="") {

                        buttons[i].setForeground(new Color(0,0,255)); //blue O

                        buttons[i].setText("O");

                        player1_turn=true;

                        textfield.setText("X turn");

                        check();
                        drawGame();

                    }

                }
                */


            }
            //sleep(1000);
            if(!textfield.getText().equals("X wins")){

                textfield.setText("O turn");
                winCheck();
                drawGame();
                AITurn();
            }


        //
        //sleep(1000);


    }

    public void AITurn(){
        System.out.println("TEXTFIELD_AI: "+textfield.getText());
        winCheck();
        drawGame();
        System.out.println("Round in AITurn: " + round);
        if(TwoXOnTable()){
            System.out.println("AITurn_elso if");
            //check_O_CloseToWin();
            if(!(textfield.getText().equals("X wins")) || !(textfield.getText().equals("O wins"))) {
                System.out.println("bool AI_steps: "+AI_steps);
                check_X_CloseToWin();
                System.out.println("bool AI_steps: "+AI_steps);
                if(AI_steps) {
                    check_O_TwoStepsToWin();
                }
            }
        } else {
            if (/*!TwoXOnTable() &&*/ round == 1) {
                System.out.println("IDE beleptunk?");
                if (buttons[4].getText().equals("")) {
                    AIPushButton(4);
                } else {
                    System.out.println("first else in AITurn");
                    AIPushButton(1);
                }
            } else {
                System.out.println("second else in AITurn");
                // to do if two X on the table
                System.out.println("TEXTFIELD_AI_if: "+textfield.getText());
                if(!(textfield.getText().equals("X wins")) && !(textfield.getText().equals("O wins"))) {
                    System.out.println("true or false: "+(!(textfield.getText().equals("X wins")) || !(textfield.getText().equals("O wins"))));
                    //check_X_CloseToWin(); //*melyik legyen előbb??
                    check_O_CloseToWin();
                    System.out.println("bool AI_steps: "+AI_steps);
                    if(AI_steps) {
                        //check_O_CloseToWin();//*melyik legyen előbb??
                        check_X_CloseToWin();
                    }
                    if(AI_steps) {
                        //check_O_CloseToWin();//*melyik legyen előbb??
                        check_O_TwoStepsToWin();
                    }if(AI_steps){
                        for(int i=0;i<9;i++) {
                            if(buttons[i].getText().equals("")){
                                AIPushButton(i);
                                break;
                            }

                        }
                    }

                }
            }
        }
        System.out.println("----------------AITURN---"+round+"-------------");
    }

    //(check(0, 3, "X") && !(buttons[6].getText().equals("O"))) {//ilyesmi
    public boolean check(int i, int j, String XorO_orEmpty){
        if((buttons[i].getText() == XorO_orEmpty) && (buttons[j].getText() == XorO_orEmpty) /*&& !(buttons[6].getText().equals("O"))*/) {
            return true;
        } else {
            return false;
        }
    }

    public boolean check2(int i, int j, String XorO_orEmpty){
        if((buttons[i].getText() == XorO_orEmpty) && (buttons[j].getText() == XorO_orEmpty) /*&& !(buttons[6].getText().equals("O"))*/) {
            return true;
        } else {
            return false;
        }
    }


    public void check_O_CloseToWin(){
        System.out.println("check_O_CloseToWin");
        //rows:
        //row 1.:
        if (check(0, 1, "O") && !(buttons[2].getText().equals("X"))) {
            AIPushButton(2);
        }
        else if (check(2, 1, "O") && !(buttons[0].getText().equals("X"))) {
            AIPushButton(0);
        }
        else if (check(0, 2, "O") && !(buttons[1].getText().equals("X"))) {
            AIPushButton(1);
        }
        //row 2.:
        else if (check(3, 4, "O") && !(buttons[5].getText().equals("X"))) {
            AIPushButton(5);
        }
        else if (check(3, 5, "O") && !(buttons[4].getText().equals("X"))) {
            AIPushButton(4);
        }
        else if (check(4, 5, "O") && !(buttons[3].getText().equals("X"))) {
            AIPushButton(3);
        }
        //row 3.:
        else if (check(6, 7, "O") && !(buttons[8].getText().equals("X"))) {
            AIPushButton(8);
        }
        else if (check(6, 8, "O") && !(buttons[7].getText().equals("X"))) {
            AIPushButton(7);
        }
        else if (check(7, 8, "O") && !(buttons[6].getText().equals("X"))) {
            AIPushButton(6);
        }

        //columns:
        //column 1.:
        else if (check(0, 3, "O") && !(buttons[6].getText().equals("X"))) {
            AIPushButton(6);
        }
        else if (check(3, 6, "O") && !(buttons[0].getText().equals("X"))) {
            AIPushButton(0);
        }
        else if (check(0, 6, "O") && !(buttons[3].getText().equals("X"))) {
            AIPushButton(3);
        }
        //column 2.:
        else if (check(1, 4, "O") && !(buttons[7].getText().equals("X"))) {
            AIPushButton(7);
        }
        else if (check(4, 7, "O") && !(buttons[1].getText().equals("X"))) {
            AIPushButton(1);
        }
        else if (check(1, 7, "O") && !(buttons[4].getText().equals("X"))) {
            AIPushButton(4);
        }
        //column 3.:
        else if (check(2, 5, "O") && !(buttons[8].getText().equals("X"))) {
            AIPushButton(8);
        }
        else if (check(5, 8, "O") && !(buttons[2].getText().equals("X"))) {
            AIPushButton(2);
        }
        else if (check(2, 8, "O") && !(buttons[5].getText().equals("X"))) {
            AIPushButton(5);
        }

        //diagonals:
        //diagonal 1.:
        else if (check(0, 4, "O") && !(buttons[8].getText().equals("X"))) {
            AIPushButton(8);
        }
        else if (check(4, 8, "O") && !(buttons[0].getText().equals("X"))) {
            AIPushButton(0);
        }
        else if (check(0, 8, "O") && !(buttons[4].getText().equals("X"))) {
            AIPushButton(4);
        }
        //diagonals:
        //diagonal 2.:
        else if (check(2, 4, "O") && !(buttons[6].getText().equals("X"))) {
            AIPushButton(6);
        }
        else if (check(4, 6, "O") && !(buttons[2].getText().equals("X"))) {
            AIPushButton(2);
        }
        else if (check(6, 2, "O") && !(buttons[4].getText().equals("X"))) {
            AIPushButton(4);
        }/* else {
            check_O_TwoStepsToWin();
        }*/
        AI_turn = false;
    }

    public void check_O_TwoStepsToWin(){
        System.out.println("check_O_TwoStepsToWin");
        //rows:
        //row 1.:
        if (check(0, 1, "") && (buttons[2].getText().equals("O"))) {
            AIPushButton(1);
        }
        else if (check(2, 1, "") && (buttons[0].getText().equals("O"))) {
            AIPushButton(2);
        }
        else if (check(0, 2, "") && (buttons[1].getText().equals("O"))) {
            AIPushButton(2);
        }
        //row 2.:
        else if (check(3, 4, "") && (buttons[5].getText().equals("O"))) {
            AIPushButton(3);
        }
        else if (check(3, 5, "") && (buttons[4].getText().equals("O"))) {
            AIPushButton(5);
        }
        else if (check(4, 5, "") && (buttons[3].getText().equals("O"))) {
            AIPushButton(4);
        }
        //row 3.:
        else if (check(6, 7, "") && (buttons[8].getText().equals("O"))) {
            AIPushButton(7);
        }
        else if (check(6, 8, "") && (buttons[7].getText().equals("O"))) {
            AIPushButton(6);
        }
        else if (check(7, 8, "") && (buttons[6].getText().equals("O"))) {
            AIPushButton(8);
        }

        //columns:
        //column 1.:
        else if (check(0, 3, "") && (buttons[6].getText().equals("O"))) {
            AIPushButton(3);
        }
        else if (check(3, 6, "") && (buttons[0].getText().equals("O"))) {
            AIPushButton(6);
        }
        else if (check(0, 6, "") && (buttons[3].getText().equals("O"))) {
            AIPushButton(0);
        }
        //column 2.:
        else if (check(1, 4, "") && (buttons[7].getText().equals("O"))) {
            AIPushButton(1);
        }
        else if (check(4, 7, "") && (buttons[1].getText().equals("O"))) {
            AIPushButton(4);
        }
        else if (check(1, 7, "") && (buttons[4].getText().equals("O"))) {
            AIPushButton(7);
        }
        //column 3.:
        else if (check(2, 5, "") && (buttons[8].getText().equals("O"))) {
            AIPushButton(2);
        }
        else if (check(5, 8, "") && (buttons[2].getText().equals("O"))) {
            AIPushButton(5);
        }
        else if (check(2, 8, "") && (buttons[5].getText().equals("O"))) {
            AIPushButton(8);
        }

        //diagonals:
        //diagonal 1.:
        else if (check(0, 4, "") && (buttons[8].getText().equals("O"))) {
            AIPushButton(0);
        }
        else if (check(4, 8, "") && (buttons[0].getText().equals("O"))) {
            AIPushButton(4);
        }
        else if (check(0, 8, "") && (buttons[4].getText().equals("O"))) {
            AIPushButton(8);
        }
        //diagonals:
        //diagonal 2.:
        else if (check(2, 4, "") && (buttons[6].getText().equals("O"))) {
            AIPushButton(2);
        }
        else if (check(4, 6, "") && (buttons[2].getText().equals("O"))) {
            AIPushButton(4);
        }
        else if (check(6, 2, "") && (buttons[4].getText().equals("O"))) {
            AIPushButton(6);
        }
        AI_turn = false;
    }




    public void check_X_CloseToWin(){
        System.out.println("check_X_CloseToWin");
        //rows:
        //row 1.:
        if (check(0, 1, "X") && !(buttons[2].getText().equals("O"))) {
            System.out.println("ROW 1");
            AIPushButton(2);
        }
        else if (check(2, 1, "X")&& !(buttons[0].getText().equals("O"))) {
            AIPushButton(0);
        }
        else if (check(0, 2, "X")&& !(buttons[1].getText().equals("O"))) {
            AIPushButton(1);
        }
        //row 2.:
        else if (check(3, 4, "X")&& !(buttons[5].getText().equals("O"))) {
            System.out.println("row2");
            AIPushButton(5);
        }
        else if (check(3, 5, "X")&& !(buttons[4].getText().equals("O"))) {
            AIPushButton(4);
        }
        else if (check(4, 5, "X")&& !(buttons[3].getText().equals("O"))) {
            AIPushButton(3);
        }
        //row 3.:
        else if (check(6, 7, "X")&& !(buttons[8].getText().equals("O"))) {
            AIPushButton(8);
        }
        else if (check(6, 8, "X")&& !(buttons[7].getText().equals("O"))) {
            AIPushButton(7);
        }
        else if (check(7, 8, "X")&& !(buttons[6].getText().equals("O"))) {
            AIPushButton(6);
        }

        //columns:
        //column 1.:
        else if (check(0, 3, "X") && !(buttons[6].getText().equals("O"))) {//ilyesmi
            AIPushButton(6);
        }
        else if (check(3, 6, "X")&& !(buttons[0].getText().equals("O"))) {
            AIPushButton(0);
        }
        else if (check(0, 6, "X")&& !(buttons[3].getText().equals("O"))) {
            AIPushButton(3);
        }
        //column 2.:
        else if (check(1, 4, "X")&& !(buttons[7].getText().equals("O"))) {
            AIPushButton(7);
        }
        else if (check(4, 7, "X")&& !(buttons[1].getText().equals("O"))) {
            AIPushButton(1);
        }
        else if (check(1, 7, "X")&& !(buttons[4].getText().equals("O"))) {
            AIPushButton(4);
        }
        //column 3.:
        else if (check(2, 5, "X")&& !(buttons[8].getText().equals("O"))) {
            AIPushButton(8);
        }
        else if (check(5, 8, "X")&& !(buttons[2].getText().equals("O"))) {
            AIPushButton(2);
        }
        else if (check(2, 8, "X")&& !(buttons[5].getText().equals("O"))) {
            AIPushButton(5);
        }

        //diagonals:
        //diagonal 1.:
        else if (check(0, 4, "X")&& !(buttons[8].getText().equals("O"))) {
            System.out.println("diagonal1");
            AIPushButton(8);
        }
        else if (check(4, 8, "X")&& !(buttons[0].getText().equals("O"))) {
            AIPushButton(0);
        }
        else if (check(0, 8, "X")&& !(buttons[4].getText().equals("O"))) {
            AIPushButton(4);
        }
        //diagonals:
        //diagonal 2.:
        else if (check(2, 4, "X")&& !(buttons[6].getText().equals("O"))) {
            AIPushButton(6);
        }
        else if (check(4, 6, "X")&& !(buttons[2].getText().equals("O"))) {
            AIPushButton(2);
        }
        else if (check(6, 2, "X")&& !(buttons[4].getText().equals("O"))) {
            AIPushButton(4);
        }
        AI_turn = false;
    }

    //(check(0, 3, "X") && !(buttons[6].getText().equals("O"))) {//ilyesmi

    public void AIPushButton(int i){

            buttons[i].setForeground(new Color(0, 0, 255)); //blue O
            buttons[i].setText("O");
            //buttons[i].setEnabled(false);
            player1_turn = true;
            AI_steps = false;
            textfield.setText("X turn");
            System.out.println(i + "BUTTON");
             winCheck();
            drawGame();

    }

    public void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public boolean TwoXOnTable(){
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if(buttons[i].getText().equals("X")){
                counter++;
            }
        }
        return counter == 2; // ha 1 akkor false

    }
    public boolean TwoOOnTable(){
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if(buttons[i].getText().equals("O")){
                counter++;
            }
        }
        return counter > 1; // ha 1 akkor false

    }


    public boolean ThreeXOnTable(){
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if(buttons[i].getText().equals("X")){
                counter++;
            }
        }
        return counter > 2; // ha 1 akkor false

    }

    public boolean ThreeOOnTable(){
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if(buttons[i].getText().equals("O")){
                counter++;
            }
        }
        return counter > 2; // ha 1 akkor false

    }

    public void disabledAllButtons(){
        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void AITurn2(){//nem jo, csak "körbezárt" állapotra kék működnie
        System.out.println("AITurn2");
        //for(int i=0;i<8;i++) {
            if(buttons[4].getText().equals("O") && buttons[5].getText().equals("") && buttons[3].getText().equals("") && !(buttons[5].getText().equals("X"))){
                buttons[5].setForeground(new Color(0, 0, 255)); //blue O
                buttons[5].setText("O");
                //buttons[i].setEnabled(false);
                player1_turn = true;

                textfield.setText("X turn");
                //System.out.println(i + "Aiturn2_BUTTON");
                winCheck();
                drawGame();
            }

        //}
    }

    private void AITurn3() {//nem jo, csak "körbezárt" állapotra kék működnie
        System.out.println("AITurn3");
        //for(int i=0;i<5;i++) {
            if(buttons[4].getText().equals("O") && buttons[7].getText().equals("") && buttons[1].getText().equals("") && !(buttons[7].getText().equals("X"))){
                buttons[7].setForeground(new Color(0, 0, 255)); //blue O
                buttons[7].setText("O");
                //buttons[i].setEnabled(false);
                player1_turn = true;

                textfield.setText("X turn");
                //System.out.println(i + "Aiturn3_BUTTON");
                winCheck();
                drawGame();
            }

        //}
    }

}


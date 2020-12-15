package project.tictactoe;


//TIC TAK TOE java program for 2 players using Swing...

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Here is a class of TicTacToe
public class TicTacToe extends JFrame implements ActionListener  {
//Here all the buttons and menu variables are declared.
int x,y,i,j;
Boolean type,state;   

JMenu menu,submenu;
JMenuItem i1,i2,i3;

JButton b[] = new JButton[9];
JButton reset, exit;
JLabel l1;

Font ft = new Font("Arial",Font.BOLD,25);

//showButton shows all the 3 rows and 3 columns of buttons
public void showButton() {
    x=0;y=55;j=0;
    
    for(i=0;i<=8;i++,x+=100,j++) {
        b[i] = new JButton();
        
        if(j==3){j=0;y+=100;x=0;}
        
        b[i].setBounds(x, y, 100, 100);
        b[i].setFont(ft);
        add(b[i]);
        b[i].addActionListener(this);         
    }//end for loop      

    l1 = new JLabel("X Turn");//Here is the default level X
    l1.setBounds(110, 30, 100, 20);//(x,y,width,height)
    l1.setFont(ft);//more visible the X and O
    add(l1);     

}//end of showButton

//Constructor call and initialize all the variables
TicTacToe() {
    super("TicTacToe");
            
    JMenuBar mb = new JMenuBar();
    menu = new JMenu("Menu");
    submenu = new JMenu("Type");
    i1 = new JMenuItem("vs Friend");
    i2 = new JMenuItem("Reset");
    i3 = new JMenuItem("Exit");
    i1.addActionListener(this);
    i2.addActionListener(this);
    i3.addActionListener(this);
    submenu.add(i1);//submenu.add(i2);
    menu.add(submenu);menu.add(i2);menu.add(i3);
    mb.add(menu);
    add(mb);
    setJMenuBar(mb);
            
    showButton();//call the function for printing all 9 buttons
           
    state=true;type=true;// for identification of X or O and friend .
            
    setFont(ft);
    setLayout(null);
    setSize(319,430);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}//end of Tic_Tac_Toe constructor    

//check function checking the 3 conditions - win, loss and draw.
public void check() {        
    String[] str = new String[3];
    
    //for rows check
    j=0;
    for(i=0;i<3;i++){
        str[0] = b[0+j].getText();
        str[1] = b[1+j].getText();
        str[2] = b[2+j].getText();
        
        if(str[0]!="")
        if(str[0]==str[1] && str[0]==str[2]) {
            JOptionPane.showMessageDialog(TicTacToe.this,str[0] + " win!!");
            
            for(i=0;i<=8;i++)
                b[i].setEnabled(false);
            return;
        }           
        j+=3;
    }    

    //for columns
    j=0;
    for(i=0;i<3;i++){
        str[0] = b[0+j].getText();
        str[1] = b[3+j].getText();
        str[2] = b[6+j].getText();
        
        if(str[0]!="")
        if(str[0]==str[1] && str[0]==str[2]) {
            JOptionPane.showMessageDialog(TicTacToe.this,str[0] + " win!!");
            
            for(i=0;i<=8;i++)
                b[i].setEnabled(false);
            return;
        }            
        j+=1;
    }     

    //for Diagonals
    j=0;
    for(i=0;i<2;i++){
        str[0] = b[0+j].getText();
        str[1] = b[4].getText();
        str[2] = b[8-j].getText();
        
        if(str[0]!="")
        if(str[0]==str[1] && str[0]==str[2]) {
            JOptionPane.showMessageDialog(TicTacToe.this,str[0] + " win!!");
        
            for(i=0;i<=8;i++)
                b[i].setEnabled(false);
            return;
        }           
        j+=2;
    }        

    //for Draw
    j=0;
    for(i=0;i<=8;i++)
        if(b[i].getText()=="")
            j=1;
    if(j==0) {
       JOptionPane.showMessageDialog(TicTacToe.this,"Draw!!"); 
    }    

}// end of check   

//Here action performed by mouse on clicking on buttons
public void actionPerformed(ActionEvent e) {
    //Logic for Menu Bar
    if(e.getSource()==i1) { type = true;}
    else if(e.getSource()==i2) {
        for(i=0;i<=8;i++) {
            b[i].setText("");
            b[i].setEnabled(true);
        }   
    }
    else if(e.getSource()==i3) { System.exit(0);}        
    
    //Let type for, true = logic for friend and false = logic for computer.
    if(type==true) { //logic of friend
        
        for(i=0;i<=8;i++){
            if(e.getSource()==b[i]){
                if(b[i].getText()==""){
                    if(state==true){
                        b[i].setText("X");
                        b[i].setEnabled(false);
                        state = false;
                        l1.setText("O Turn");
                        check();
                    }
                    else{
                        b[i].setText("O");
                        b[i].setEnabled(false);
                        state = true;
                        l1.setText("X Turn");
                        check();
                    }
                }
            }
        }//end of for loop
       
    }//end of logic of friend        

}//end of actionPerformed

//Main function
public static void main(String args[]){
    new TicTacToe();
}

}//end of class Tic_Tac_Toe
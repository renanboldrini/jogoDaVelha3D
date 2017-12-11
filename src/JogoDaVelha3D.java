import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JogoDaVelha3D extends JPanel implements ActionListener {
    
	public static final int PAINEL = 3;
        
        private Mat3d mat = new Mat3d();
	
	private SingleBoard [] boards = new SingleBoard[PAINEL];
	private char currentPlayer = 'X';  
	
	class BoardButton extends JButton {
		public int row, col, plane;
		public BoardButton(int row, int col, int plane) {
			this.row = row;
			this.col = col;
			this.plane = plane;
			this.setText("   ");
		}
		public String toString() {
			return "(" + row + "," + col + "," + plane + ") ";
		}
	}
	
	class SingleBoard extends JPanel {
		public static final int ROWS = 3;
		public static final int COLS = 3;
		
		private BoardButton [] items = new BoardButton[ROWS*COLS];  
		
		public SingleBoard(int plane, ActionListener listener) {
			setLayout( new GridLayout( ROWS, COLS ) );
			for (int row=0; row<ROWS; row++) {
				for (int col=0; col<COLS; col++) {
					BoardButton b = new BoardButton(row, col, plane);
					b.addActionListener(listener);
					add(b );
					items[row*COLS+col] = b;
				}
			}
		}
		
		public char getValue(int row, int col) {
			String s = items[row*COLS+col].getText();
			return (s==null || s.length()==0) ? ' ' : s.charAt(0);
		}
		
		public void setValue(int row, int col, char val) {
			items[row*COLS+col].setText(String.valueOf(val));
		}

	}
	
	
	public JogoDaVelha3D() {
		setLayout( new GridLayout( 2, 2, 25, 25) );  //não mudei
		for(int panel=0; panel<PAINEL; panel++) {
			SingleBoard sb = new SingleBoard(panel, this);
			boards[panel] = sb;
			add(sb);
		}
	}
	
	public char getValue(int row, int col, int plane) {
		return boards[plane].getValue(row, col);
	}

	public void setValue(int row, int col, int plane, char val) {
		boards[plane].setValue(row, col, val);
	}

	
	public void actionPerformed(ActionEvent evt) {
		BoardButton b = (BoardButton)evt.getSource();
		setValue(b.row, b.col, b.plane, currentPlayer);
                char j = currentPlayer;
		b.setEnabled(false);
		currentPlayer = (currentPlayer=='X') ? 'O' : 'X';
		System.out.println(b );
                mat.setMatriz(b.row, b.col, b.plane, currentPlayer);
                
                if(mat.montaPossibilidades(currentPlayer)==true){
                    System.out.println("O JOGADOR --> " +j+ " <-- VENCEU");
                    System.exit(0);
                }
                
	}
	
	
	public static void jogo() {
		JFrame frm = new JFrame("J O G O   D A   V E L H A   3 D"); 
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(new BorderLayout());
		frm.getContentPane().add(new JogoDaVelha3D(), BorderLayout.CENTER);
		frm.pack();
		frm.setVisible(true);
	}
	
}
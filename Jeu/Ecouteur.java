import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class Ecouteur implements ActionListener {
    public static Player player1=new Player("Blue");
    public static Player player2=new Player("Red");;

	private Integer id;
	private int x;
	private int y;
	public static int totalMoves=0;
	public static Ecouteur lastClickeEcouteur;
    public static JButton button;
	String player11;
    String player22;
    public Ecouteur(Integer id,int x, int y,String ch1,String ch2){
		player11=ch1;
		player22=ch2;

        this.id=id;
		this.x=x;
		this.y=y;
    }
    public static boolean checkAdjacencyConstraint(Vector<Integer> vector,int clickedRow,int clickedCol,int id){
		int[][] grid = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
		System.out.println(clickedRow+" "+clickedCol);
		System.out.println("id:"+id);
        for (int row = clickedRow - 1; row <= clickedRow + 1; row++) {
            for (int col = clickedCol - 1; col <= clickedCol + 1; col++) {
				System.out.println(row+" "+col);
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == id) {
					System.out.println("acceptable");
                    return true;
                }
            }
        }
        
		System.out.println("refused");

        return false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source=(JButton) e.getSource();
        //JButton sourcetarget=(JButton) e.getSource();
        Ecouteur.totalMoves++;
					if(totalMoves<=6){
						if( (totalMoves%2) == 0){
							
							if((Ecouteur.player2.getPieces().contains(Ecouteur.this.id))||(Ecouteur.player1.getPieces().contains(Ecouteur.this.id))){
								Ecouteur.totalMoves--;
							}
							else{
								Ecouteur.this.player1.addPiecePhase1(Ecouteur.this.id);
                                source.setBackground(Color.RED);
								System.out.println(Ecouteur.this.player1.getPieces());
							}
							
						}
						else{
							if((Ecouteur.player2.getPieces().contains(Ecouteur.this.id))||(Ecouteur.player1.getPieces().contains(Ecouteur.this.id))){
								Ecouteur.totalMoves--;
							}
							else{
								Ecouteur.this.player2.addPiecePhase1(Ecouteur.this.id);
                                source.setBackground(Color.BLUE);
								System.out.println(Ecouteur.this.player2.getPieces());
							}
						}
					}
					else{
						//System.out.println(totalMoves);
						if((((totalMoves-7)%4) == 0)||(((totalMoves-7)%4) == 1)){
							if(((totalMoves-7)%4) == 0)
								{
									if(Ecouteur.player2.getPieces().contains(Ecouteur.this.id))
										{
											Ecouteur.lastClickeEcouteur=Ecouteur.this;
                                            Ecouteur.button=source;
											//Ecouteur.this.setText("clicked");
										}
									else
										Ecouteur.totalMoves--;
									
								}
							else{
									//System.out.println("player1 plays");
									if((Ecouteur.this.id==lastClickeEcouteur.id)||(Ecouteur.player2.getPieces().contains(Ecouteur.this.id))||(Ecouteur.player1.getPieces().contains(Ecouteur.this.id))||(!(checkAdjacencyConstraint(Ecouteur.player2.getPieces(), x, y,lastClickeEcouteur.id )))){
										Ecouteur.totalMoves-=2;
										//Ecouteur.lastClickeEcouteur.setText("");
									}
									else{
										
										Ecouteur.this.player2.addPiecesPhase2(Ecouteur.this.id, lastClickeEcouteur.id);
                                        button.setBackground(Color.WHITE);
                                        source.setBackground(Color.BLUE);
										//Ecouteur.lastClickeEcouteur.setText("");
										System.out.println(Ecouteur.this.player2.getPieces());
									}
									

								}
					
						}
						else{
							if(((totalMoves-7)%4) == 2)
								{
									//System.out.println("player2 clicks");
									if(Ecouteur.player1.getPieces().contains(Ecouteur.this.id)){
										Ecouteur.lastClickeEcouteur=Ecouteur.this;
                                        Ecouteur.button=source;
										//Ecouteur.this.setText("clicked");

									}
									else
										Ecouteur.totalMoves--;
									
									
								}
								else{
									//System.out.println("player2 plays");
									if((Ecouteur.this.id==lastClickeEcouteur.id)||(Ecouteur.player1.getPieces().contains(Ecouteur.this.id))||(Ecouteur.player2.getPieces().contains(Ecouteur.this.id))||(!(checkAdjacencyConstraint(Ecouteur.player2.getPieces(), x, y,lastClickeEcouteur.id)))){
										Ecouteur.totalMoves-=2;
										//Ecouteur.lastClickeEcouteur.setText("");
									}
									else{
										Ecouteur.this.player1.addPiecesPhase2(Ecouteur.this.id, lastClickeEcouteur.id);
                                        button.setBackground(Color.WHITE);
                                        //Ecouteur.lastClickeEcouteur.source.setBackground(Color.RED);
                                        source.setBackground(Color.RED);
										//Ecouteur.lastClickeEcouteur.setText("");
										System.out.println(Ecouteur.this.player1.getPieces());
									}
									
									System.out.println(Ecouteur.this.player1.getPieces());
									
								}
						}
					}

					if (player1.hasPlayerWon()) {
						
								


						WinnerInterface fenetre = new WinnerInterface(player22.toUpperCase()); // Créez une seule instance de FenetreJeu
						

						SwingUtilities.invokeLater(() -> {
							fenetre.afficherMessage(player22.toUpperCase()+" "+"a gagné");
						});

					}
					
					if (player2.hasPlayerWon()) {
						

						WinnerInterface fenetre = new WinnerInterface(player11.toUpperCase()); // Créez une seule instance de FenetreJeu


						SwingUtilities.invokeLater(() -> {
							fenetre.afficherMessage(player11.toUpperCase()+" "+"a gagné");
						});}
				
    }
    
}

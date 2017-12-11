
public class Mat3d {
    private Dimensao [][]matriz = new Dimensao[3][3];

    public Mat3d() {
        for(int i=0; i<matriz.length; i++){
           for(int j=0; j<matriz[i].length; j++){
              matriz[i][j]= new Dimensao();
           }
        }   
    }

    public char getMatriz(int l, int c, int d) {
        return matriz[l][c].getD(d);
    }

    public void setMatriz(int l, int c, int d, char j) {
        this.matriz[l][c].setD(j, d);
    }
    
    public boolean montaPossibilidades(char jogada){
	char [][]mat = new char[3][3];
        //popula
        for(int i=0; i<mat.length; i++){
           for(int j=0; j<mat[i].length; j++){
              mat[i][j]= 't';
           }
        }
	//escreve possibilidades
        for(int i=0; i<mat.length; i++){
           for(int j=0; j<mat[i].length; j++){   
              
               if(matriz[i][j].getD(0)==jogada && //venceu o jogo então retorna vencedor
                 matriz[i][j].getD(1)==jogada &&
                 matriz[i][j].getD(2)==jogada){
                  return true;                  
              }
               if(matriz[i][j].getD(0)==jogada ||
                 matriz[i][j].getD(1)==jogada ||
                 matriz[i][j].getD(2)==jogada){
                  mat[i][j] = jogada;
              }               
           } 
        }
        //verifica linhas
        for(int linha=0 ; linha<3 ; linha++){
            if(mat[linha][0]==jogada && mat[linha][1]==jogada && mat[linha][2]==jogada ){
                if(matriz[linha][0].getD(0)==jogada && matriz[linha][1].getD(0)==jogada && matriz[linha][2].getD(0)==jogada ||
                   matriz[linha][0].getD(1)==jogada && matriz[linha][1].getD(1)==jogada && matriz[linha][2].getD(1)==jogada ||
                   matriz[linha][0].getD(2)==jogada && matriz[linha][1].getD(2)==jogada && matriz[linha][2].getD(2)==jogada ||
                   matriz[linha][0].getD(0)==jogada && matriz[linha][1].getD(1)==jogada && matriz[linha][2].getD(2)==jogada ||
                   matriz[linha][0].getD(2)==jogada && matriz[linha][1].getD(1)==jogada && matriz[linha][2].getD(0)==jogada ){
                return true;
                }
            }
        }
        //verifica colunas
        for(int coluna=0 ; coluna<3 ; coluna++){
            if(mat[0][coluna] == jogada && mat[1][coluna] == jogada && mat[2][coluna] == jogada)
                if(matriz[0][coluna].getD(0)==jogada && matriz[1][coluna].getD(0)==jogada && matriz[2][coluna].getD(0)==jogada ||
                   matriz[0][coluna].getD(1)==jogada && matriz[1][coluna].getD(1)==jogada && matriz[2][coluna].getD(1)==jogada ||
                   matriz[0][coluna].getD(2)==jogada && matriz[1][coluna].getD(2)==jogada && matriz[2][coluna].getD(2)==jogada ||
                   matriz[0][coluna].getD(0)==jogada && matriz[1][coluna].getD(1)==jogada && matriz[2][coluna].getD(2)==jogada ||
                   matriz[0][coluna].getD(2)==jogada && matriz[1][coluna].getD(1)==jogada && matriz[2][coluna].getD(0)==jogada ){
                return true;
        }
        }
        //verifica diagonais 1
        if( mat[0][0]==jogada && mat[1][1]==jogada && mat[2][2]==jogada){
            if(matriz[0][0].getD(0)==jogada && matriz[1][1].getD(1)==jogada && matriz[2][2].getD(2)==jogada ||
               matriz[0][0].getD(2)==jogada && matriz[1][1].getD(1)==jogada && matriz[2][2].getD(0)==jogada ||
               matriz[0][0].getD(0)==jogada && matriz[1][1].getD(0)==jogada && matriz[2][2].getD(0)==jogada ||
               matriz[0][0].getD(1)==jogada && matriz[1][1].getD(1)==jogada && matriz[2][2].getD(1)==jogada ||
               matriz[0][0].getD(2)==jogada && matriz[1][1].getD(2)==jogada && matriz[2][2].getD(2)==jogada ){
                return true;
            }
        }

	//verifica diagonais 2	
        if(mat[0][2]==jogada && mat[1][1]==jogada && mat[2][0]==jogada){
            if(matriz[0][2].getD(0)==jogada && matriz[1][1].getD(1)==jogada && matriz[2][0].getD(2)==jogada ||
               matriz[0][2].getD(2)==jogada && matriz[1][1].getD(1)==jogada && matriz[2][0].getD(0)==jogada ||
               matriz[0][2].getD(0)==jogada && matriz[1][1].getD(0)==jogada && matriz[2][0].getD(0)==jogada ||
               matriz[0][2].getD(1)==jogada && matriz[1][1].getD(1)==jogada && matriz[2][0].getD(1)==jogada ||
               matriz[0][2].getD(2)==jogada && matriz[1][1].getD(2)==jogada && matriz[2][0].getD(2)==jogada ){
                return true;
            }
        }        
        
        return false;
	}
    
}

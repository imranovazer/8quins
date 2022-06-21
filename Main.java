

class Main {
    public static void main(String[] args) {
        
        //Here Just edit argument of board if you want to find solution for other dimension of board
        //AND Just Run code
        //Process may take a long time for high sized boards(we tryed till 29)
        /*-------->*/Board chess= new Board(5) ;//<------------------------
        //----------------------------------------
        //----------------------------------------
        //Do not touch belowe part
        Piece[] Quins = new Piece[chess.getSize()] ;
        //In this part we just created list of Pieces 
        for(int i=0;i<chess.getSize();i++)
        {
            Quins[i]=new Piece(i, chess) ;
        }
        chess.reorderBoard(Quins);    
    }
    
}
    
    
    
    
    

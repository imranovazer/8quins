public class Piece {
    private String label="X" ; 
    private  int x ; 
    private  int y ;
    boolean iFRemoved= true ; 
    boolean MoveAnyway =false;
    Board board ;

    /*This is constructor of our Pieces, firt argument determining the place of piece on the board on the column if
    the piece is going to spawn, there is no need to set row because our pieces will move only down not right or left*/
    
    Piece(int x,Board board )
    {
        this.x=x ;
        this.board=board ;
    }
    //If we delete the piece from board this will set boolean to True
    public void setIFremoved(boolean iFRemoved) 
    {
        this.iFRemoved=iFRemoved ;
    }
    boolean getIfREmoved()
    {
        return iFRemoved ;
    }
    int getX() //getter for cordinate
    {
        return this.x ;
    }
    int getY()
    {
        return this.y ;
    }
    //This is for if our piece is not attacked but we want move it down
    void setMoveAnyway(boolean MoveAnyway)
    {
        this.MoveAnyway=MoveAnyway ; 
    }
    public boolean getMoveAnyway()
    {
        return this.MoveAnyway ;
    }
    
    public void Spawn() //This method spawn piece on board
    {
        board.board[0][this.x] =this ;
        this.y=0 ;
    }
    void RemovePiece() //This methode Remove Piece from board
    {
        board.board[this.y][this.x] =null ;
    }
    public String getL() //This is getter fo Label of our Pieces here we used X
    {
        return this.label ;
    }
    public void MoveDown() //This methode move our piece down
    {
        RemovePiece();
        this.y=y+1 ;
        board.board[this.y][this.x] =this ;
    }
    boolean ifAttacked() //This method checking are there around any other piece
    {
        boolean ifAt= false ;
        //Horizontal check
        for(int i =0 ;i<board.getSize();i++)
        {
            if(i==this.x)
            {
                continue ;
            }
            if (board.board[this.y][i]!=null)
            {
                ifAt=true ;
            }   
        }
        //Vertical Check 
        for(int j =0 ;j<board.getSize();j++)
        {
            if(j==this.y)
            {
                continue ;
            }
            if (board.board[j][this.x]!=null)
            {
                ifAt=true ;
            }   
        }
        //Diogonal Check 
        for(int i = x+1, j = y+1; i <board.getSize() && j<board.getSize(); i++, j++)
        {
            if (board.board[j][i]!=null)
            {
                ifAt=true ;
            }   
        }
        for(int i = x-1, j = y-1; i >=0 && j>=0; i--, j--)
        {
            if (board.board[j][i]!=null)
            {
                ifAt=true ;
            }   
        }
        for(int i = x+1, j = y-1; i <board.getSize() && j>=0; i++, j--)
        {
            if (board.board[j][i]!=null)
            {
                ifAt=true ;
            }   
        }
        for(int i = x-1, j = y+1; i>=0 && j<board.getSize(); i--, j++)
        {
            if (board.board[j][i]!=null)
            {
                ifAt=true ;
            }   
        }
        return ifAt ;
        
    }
    
}

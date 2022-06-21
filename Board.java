
public class Board {
    private  int size ;
    public Piece[][] board ;
    Board(int size) //constructer of board
    {
        this.size=size ;
        this.board =new Piece[this.size][this.size ] ;
    }
    int getSize() //getter for size of board
    {
        return size ;
    }
    
    //this is method  which is going to change position of pieces for finding solution
    void reorderBoard(Piece[]list) 
    {
        int countPiece =0 ;
        label : 
        //This method will go throve array of pieces and make on them manupilations 
        for(int i =0; i<this.size;i++)
        {  
            if(list[i].getIfREmoved())
            {
                list[i].Spawn();
                countPiece++ ;
                list[i].setIFremoved(false);
            }

            for(int j=list[i].getY() ;j<this.size;j++)
            {
                
                if(list[i].ifAttacked() || list[i].getMoveAnyway())
                {
                    if(j!=this.size-1)
                    {
                        list[i].MoveDown();
                        list[i].setMoveAnyway(false);
                        
                    }
                    else if(j==this.size-1)
                    {
                        list[i].setIFremoved(true);
                        list[i].RemovePiece();
                        countPiece-- ;
                        list[i-1].setMoveAnyway(true);
                        i=i-2 ; //If we could'nt place this piece on the board we remove it and go to the previous one
                        
                    }
                }
                else if(!list[i].ifAttacked())
                {
                    break ;
                }  
            }
            
            if(countPiece==this.size)
            {
                System.out.println("SOLUTION FOUND FOR "+this.size+" x "+this.size+" BOARD");
                Pirint();
                break label ;
            }

        } 
    }

    //This Method printing our Board
    void Pirint()
    {
        for(int a=0 ;a<this.size;a++)
        {
            System.out.print("+---") ;
        }
        System.out.print("+\n") ;
        for (int i=0 ;i<this.size;i++)
        {
            for(int j=0 ;j<this.size;j++)
            {
               
                if(this.board[i][j]==null)
                {
                    System.out.print("|   ");
                    
                }
                else
                {
                   System.out.print("| "+this.board[i][j].getL()+" ");
                   
                }
            }
            System.out.print("|\n") ;
            for(int a=0 ;a<this.size;a++)
            {
                System.out.print("+---") ;
            }
            System.out.print("+\n") ;
        }
    }
    
    
}
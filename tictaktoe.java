// tictactoe game...
// this game for two players

import java.util.Scanner;
import java.util.Random;
class TikTacToe
{
    static char[][]  board;
    public TikTacToe()
    {
        board= new char[3][3];
        initBoard();
    }
    void initBoard()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0; j<board[i].length;j++)
            {
                board[i][j]=' ';
            }
        }
    }
static void dispBoard()
    {
        System.out.println("------------");
        for(int i=0;i<board.length;i++)
        {
            System.out.print("|");
            for(int j=0; j<board[i].length;j++)
            {
               System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("------------");
        }
    }
static void placemark(int row, int cols, char mark)
{
    if(row>=0 && row <=2 && cols>=0 && cols<=2)
    {
        board[row][cols]= mark;
    }
    else
    {
        System.out.println("invalid Input");
    }
}

static boolean checkColsWin()
{
    for(int j=0;j<=2;j++)
    {
        if(board[0][j] !=' ' &&  board[0][j]==board[1][j] && board[1][j]==board[2][j])
        {
            return true;
        }
    }
    return false;
}

static boolean checkRowWin()
{
    for(int i=0;i<=2;i++)
        {
            if(board[i][0] !=' ' &&   board[i][0]==board[i][1] && board[i][1]==board[i][2]){
                return true;
            }
        }
        return false;

}
static boolean checkDiagWin()
{
    if(board[0][0] !=' ' &&   board[0][0]==board[1][1] && board[1][1]== board[2][2]
    || board[0][2] !=' ' &&   board[0][2]== board[1][1] && board[1][1]==board[2][0] )
    {
        return true;
    }
    return false;
}
}
class HumanPlayer 
{
    String name;
    char mark;
    HumanPlayer(String name, char mark)
    {
        this.name=name;
        this.mark=mark;

    }
    void makeMove()
    {
        Scanner scan = new Scanner(System.in);
        int row;
        int cols;
        do
        {
        System.out.println("enter the row and cols");
        row = scan.nextInt();
        cols =scan.nextInt();
        }while(!isValidMove(row, cols));
        TikTacToe.placemark(row, cols, mark);
    }
     boolean isValidMove(int row, int cols)
    {
        if(row >=0 && row <=2 &&  
        cols >=0 && cols <=2)
        {
            if(TikTacToe.board[row][cols]==' ')
            {
                return true;
            }
        }
        return false;
    }
}
 class LaunchGame{
    public static void main(String[] args) {
        TikTacToe t= new TikTacToe();
        t.dispBoard();
        HumanPlayer p1= new HumanPlayer("neha", 'X');
        HumanPlayer p2= new HumanPlayer("shivam", 'O');

        HumanPlayer cp;
        cp=p1;
        while(true)
        {
            System.out.println(cp.name+" " +"turn");
        cp.makeMove();
        TikTacToe.dispBoard();
        if(TikTacToe.checkColsWin() || TikTacToe.checkRowWin() || TikTacToe.checkDiagWin() )
        {
            System.out.println(cp.name + "has won");
            break;
        }
        else{
            if(cp== p1)
            {
                cp= p2;
            }
            else
            {
                cp = p1;
            }
        }

        }
    }
}









// TicTacToe game...
// TicTacToe game play with AI Player...

/*import java.util.Scanner;
import java.util.Random;
class TikTacToe
{
    static char[][]  board;
    public TikTacToe()
    {
        board= new char[3][3];
        initBoard();
    }
    void initBoard()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0; j<board[i].length;j++)
            {
                board[i][j]=' ';
            }
        }
    }
static void dispBoard()
    {
        System.out.println("------------");
        for(int i=0;i<board.length;i++)
        {
            System.out.print("|");
            for(int j=0; j<board[i].length;j++)
            {
               System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("------------");
        }
    }
static void placemark(int row, int cols, char mark)
{
    if(row>=0 && row <=2 && cols>=0 && cols<=2)
    {
        board[row][cols]= mark;
    }
    else
    {
        System.out.println("invalid Input");
    }
}

static boolean checkColsWin()
{
    for(int j=0;j<=2;j++)
    {
        if(board[0][j] !=' ' &&  board[0][j]==board[1][j] && board[1][j]==board[2][j])
        {
            return true;
        }
    }
    return false;
}

static boolean checkRowWin()
{
    for(int i=0;i<=2;i++)
        {
            if(board[i][0] !=' ' &&   board[i][0]==board[i][1] && board[i][1]==board[i][2]){
                return true;
            }
        }
        return false;

}
static boolean checkDiagWin()
{
    if(board[0][0] !=' ' &&   board[0][0]==board[1][1] && board[1][1]== board[2][2]
    || board[0][2] !=' ' &&   board[0][2]== board[1][1] && board[1][1]==board[2][0] )
    {
        return true;
    }
    return false;
}


static boolean CheckDraw()
{
    for(int i=0; i<=2; i++)
    {
        for(int j=0; j<=2; j++)
        {
            if(board[i][j] == ' ')
            {
                return false;
            }
        }
    }
    return true;
}
}
abstract class Player
{
    String name;
    char mark;
    abstract void makeMove();
    boolean isValidMove(int row, int cols)
    {
        if(row >=0 && row <=2 &&  
        cols >=0 && cols <=2)
        {
            if(TikTacToe.board[row][cols]==' ')
            {
                return true;
            }
        }
        return false;
    }
}
class HumanPlayer extends Player
{
    // String name;
    // char mark;
    HumanPlayer(String name, char mark)
    {
        this.name=name;
        this.mark=mark;

    }
    void makeMove()
    {
        Scanner scan = new Scanner(System.in);
        int row;
        int cols;
        do
        {
        System.out.println("enter the row and cols");
        row = scan.nextInt();
        cols =scan.nextInt();
        }while(!isValidMove(row, cols));
        TikTacToe.placemark(row, cols, mark);
    }
     boolean isValidMove(int row, int cols)
    {
        if(row >=0 && row <=2 &&  
        cols >=0 && cols <=2)
        {
            if(TikTacToe.board[row][cols]==' ')
            {
                return true;
            }
        }
        return false;
    }
}
class AIPlayer extends Player
{

    AIPlayer(String name, char mark)
    {
        this.name=name;
        this.mark=mark;

    }
    void makeMove()
    {
        Scanner scan = new Scanner(System.in);
        int row;
        int cols;
        do
        {
            Random r= new Random();
            row = r.nextInt(3);
            cols = r.nextInt(3);
        }while(!isValidMove(row, cols));
        TikTacToe.placemark(row, cols, mark);
    }
    
}
class LaunchGame{
    public static void main(String[] args) {
        TikTacToe t= new TikTacToe();
        t.dispBoard();
        HumanPlayer p1= new HumanPlayer("neha", 'X');
        AIPlayer p2= new AIPlayer("AIPlayer", 'O');

        Player cp;
        cp=p1;
        while(true)
        {
            System.out.println(cp.name+" " +"turn");
        cp.makeMove();
        TikTacToe.dispBoard();
        if(TikTacToe.checkColsWin() || TikTacToe.checkRowWin() || TikTacToe.checkDiagWin() )
        {
            System.out.println(cp.name +" "+ "has won");
            break;
        }
        else if(TikTacToe.CheckDraw())
        {
            System.out.println("Game is draw");
            break;
        }
        else{
            if(cp== p1)
            {
                cp= p2;
            }
            else
            {
                cp = p1;
            }
        }

        }
    }
}*/
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
         ChessMatch match = new ChessMatch();
         while(true){
            UI.printBoard(match.getPieces());
            System.out.println();
            System.out.println("Source: ");
            ChessPosition source = UI.readChessPosition(sc);

            System.out.println();
            System.out.println("Target: ");
            ChessPosition target = UI.readChessPosition(sc);
            
            ChessPiece piece = match.performChessMove(source, target);
         }
    }

   
}

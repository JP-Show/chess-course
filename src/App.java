import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exception.ChessException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ChessMatch match = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while(!match.getCheckmate()){
        try {
            UI.clearScreen();
            UI.printMatch(match, captured);
            System.out.println();
            System.out.println("Source: ");
            ChessPosition source = UI.readChessPosition(sc);

            boolean[][] possibleMoves = match.possibleMoves(source);
            UI.clearScreen();
            UI.printBoard(match.getPieces(), possibleMoves);

            System.out.println();
            System.out.println("Target: ");
            ChessPosition target = UI.readChessPosition(sc);
            
            ChessPiece capturedPiece = match.performChessMove(source, target);
        
            if(capturedPiece != null) captured.add(capturedPiece);

            if(match.getPromoted() != null) {
                System.out.println("Enter piece ofr promotion (B, N, R or Q)");
                String type = sc.nextLine().toUpperCase();
                match.replacePromotedPiece(type);
                while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
                    System.out.println("Invalid value! Please enter B, N, R or Q");
                    type = sc.nextLine().toUpperCase();
                    
                }
            }
            

            }catch(ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(match, captured);
    }
}

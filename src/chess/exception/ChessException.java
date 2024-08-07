package chess.exception;

import boardgame.exception.BoardException;

public class ChessException extends BoardException{
    public ChessException(String msg){
        super(msg);
    }
    
}

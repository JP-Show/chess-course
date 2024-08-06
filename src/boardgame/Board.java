package boardgame;

import boardgame.exception.BoardException;

public class Board {
    
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1) 
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
      //method return a piece
    public Piece piece (int row, int column) {
        //verificar se existe a posição existe
        throwPositionExists(row, column);
        return pieces[row][column];
    }
    public Piece piece (Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;   
    }
    public boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
        
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }
    public boolean thereIsAPiece(Position position){
        throwPositionExists(position.getRow(), position.getColumn());

        return piece(position) != null;
    }
    private void throwPositionExists(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
    }
}

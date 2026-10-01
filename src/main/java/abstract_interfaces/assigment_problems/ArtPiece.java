package abstract_interfaces.assigment_problems;

public abstract class ArtPiece {

    private static int counter = 1000;
    private final String pieceId;

    public ArtPiece() {
        counter++;
        this.pieceId = "ART-" + counter;
    }

    public String getPieceId() {
        return pieceId;
    }

    public abstract String describe();
}

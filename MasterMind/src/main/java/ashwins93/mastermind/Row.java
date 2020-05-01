package ashwins93.mastermind;

public class Row {
    final Color[] positions;
    protected int matchedPositions;
    protected int matchedColors;

    public Row(Color[] positions, int matchedPositions, int matchedColors) {
        this.positions = positions;
        this.matchedPositions = matchedPositions;
        this.matchedColors = matchedColors;
    }

    public Color[] getPositions() {
        return positions;
    }

    public int getMatchedPositions() {
        return matchedPositions;
    }

    public void setMatchedPositions(int matchedPositions) {
        this.matchedPositions = matchedPositions;
    }

    public int getMatchedColors() {
        return matchedColors;
    }

    public void setMatchedColors(int matchedColors) {
        this.matchedColors = matchedColors;
    }
}

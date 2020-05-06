package ashwins93.mastermind;

import java.util.Arrays;

public class Row {
    public static final Row none = new Row(Guesser.none);
    final Color[] positions;
    protected int matchedPositions;
    protected int matchedColors;

    public Row(Color[] positions) {
        this.positions = Arrays.copyOf(positions, positions.length);
    }

    protected Row(Row cloneFrom) {
        this(cloneFrom.positions);
        setMatch(cloneFrom.matchedPositions, cloneFrom.matchedColors);
    }

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

    public void setMatch(int matchedPositions, int matchedColors) {
        if (matchedColors + matchedPositions > positions.length) {
            throw new IllegalArgumentException(
                    "Number of matches can not be more than the position.");
        }
        this.matchedColors = matchedColors;
        this.matchedPositions = matchedPositions;
    }

    public boolean guessMatches(Color[] guess) {
        return nrMatchingColors(guess) == matchedColors;
    }

    public int nrMatchingColors(Color[] guess) {
        int count = 0;
        for(int i = 0; i < guess.length; i++) {
            for(int j = 0; j < positions.length; j++) {
                if(i != j && guess[i] == positions[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int nrMatchingPositions(Color[] guess) {
        int count = 0;
        for(int i = 0; i < guess.length; i++) {
            if(guess[i] == positions[i]) {
                count++;
            }
        }
        return count;
    }

    public int nrOfColumns() {
        return positions.length;
    }
}

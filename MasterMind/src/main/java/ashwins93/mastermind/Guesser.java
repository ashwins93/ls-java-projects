package ashwins93.mastermind;

public abstract class Guesser {
    protected final Table table;
    private final ColorManager manager;
    protected final Color[] lastGuess;
    public static final Color[] none = new Color[]{Color.none};

    public Guesser(Table table) {
        this.table = table;
        this.manager = table.manager;
        this.lastGuess = new Color[table.nrColumns];
    }

    abstract protected void setFirstGuess();

    protected Color[] nextGuess() {
        if(lastGuess[0] == null) {
            setFirstGuess();
            return lastGuess;
        } else {
            return nextNonFirstGuess();
        }
    }

    private Color[] nextNonFirstGuess() {
        int i = 0;
        boolean guessFound = false;
        while(i < table.nrColumns && !guessFound) {
            if(manager.hasNextColor(lastGuess[i])) {
                lastGuess[i] = manager.nextColor(lastGuess[i]);
                guessFound = true;
            } else {
                lastGuess[i] = manager.firstColor();
                i++;
            }
        }
        if(guessFound) {
            return lastGuess;
        } else {
            return none;
        }
    }

    private boolean guessMatch(Color[] guess) {
        for (Row row : table.rows ) {
            if(!row.guessMatches(guess)) {
                return false;
            }
        }
        return true;
    }

    public Row guess() {
        Color[] guess = nextGuess();
        while(guess != none && !guessMatch(guess)) {
            guess = nextGuess();
        }
        if(guess == none) {
            return Row.none;
        }
        return new Row(guess);
    }

}

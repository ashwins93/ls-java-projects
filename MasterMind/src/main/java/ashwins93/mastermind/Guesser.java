package ashwins93.mastermind;

public abstract class Guesser {
    protected final Table table;
    private final ColorManager manager;
    protected final Color[] lastGuess;
    public static final Color[] none = new Color[]{Color.none};

    public Guesser(Table table, ColorManager manager, Color[] lastGuess) {
        this.table = table;
        this.manager = manager;
        this.lastGuess = lastGuess;
    }
}

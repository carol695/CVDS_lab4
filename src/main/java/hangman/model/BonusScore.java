package hangman.model;

public class BonusScore implements GameScore {
    @Override
    public int CalculateScore(int correctCount, int incorrectCount) {
        return 0;
    }
}

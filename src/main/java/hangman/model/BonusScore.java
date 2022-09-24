package hangman.model;

public class BonusScore implements GameScore {
    /**
     * @pre Inicia con 0 puntos, puntaje minimo 0 *
     * @pos Se bonifica con 5^numeroLetra, Se penaliza con -8 puntos cada letra incorrecta
     * @param correctCount numero de letras correctas
     * @param incorrectCount numero de letras incorrectas
     * @return Score,  si el score supera 500 puntos, el jugador obtiene como puntaje final 500.
     */

    @Override
    public int CalculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        if(correctCount < 0 || incorrectCount < 0) {throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);}
        int score = 0;
        if(correctCount > 0){ score += 10 * correctCount;}
        if(incorrectCount > 0){score -= 5 * incorrectCount;}
        if(score < 0){ score = 0;}
        return score;
    }
}

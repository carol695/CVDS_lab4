package hangman.model;

public class PowerScore implements GameScore {
    /**
     * @pre Inicia con 0 puntos, puntaje minimo 0
     * @pos Se bonifica con 10 puntos cada letra correcta, se penaliza con -5 puntos letra incorrecta
     * @param correctCount numero de filas
     * @param incorrectCount numero de columnas
     * @return Score
     */
    @Override
    public int CalculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        if(correctCount < 0 || incorrectCount < 0) {throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);}
        int score = 0;
        if(correctCount > 0){
            for(int x = 0; x < correctCount; x++){
                score += Math.pow(5,x+1);
            }
        }
        if(incorrectCount > 0 ){
            score -= 8 * incorrectCount;
        }
        if (score >= 500){ score = 500;}
        if (score < 0){score = 0;}
        return score;

    }
}

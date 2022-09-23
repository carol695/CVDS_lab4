package hangman.model;

public interface GameScore {

    /**
     * @pre  Puntaje minimo: 0; Puntaje Inicial: 0 a 100
     * @pos Calcular el puntaje final
     * @param correctCount: puntos gandados por carta correcta; incorrectCount: Puntos perdidos por cartas incorrectas
     * @throws GameScoreException: Parametros_invalidos : Recuento incorrecto
    */
    public int CalculateScore(int correctCount, int incorrectCount );
}

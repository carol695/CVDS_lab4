package hangman.model;



import org.junit.Assert;
import org.junit.Test;
public class GameScoreTest {

    @Test
    public void Dado_DosNumerosNegativos_Cuando_EsMenosDosYMenosTres_Entonces_retornaFalse() {
        GameScore game;
        try {
            game = new OriginalScore();
            game.CalculateScore(-2, -3);
            Assert.assertTrue(false);
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
        try {
            game = new PowerScore();
            game.CalculateScore(-2, -3);
            Assert.assertTrue(false);
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }

        try {
            game = new BonusScore();
            game.CalculateScore(-2, -3);
            Assert.assertTrue(false);
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void Dado_EnOriginalScore_Cuando_EsDiezYCero_Entonces_retornaCien() throws GameScoreException {
        GameScore game = new OriginalScore();
        int score = game.CalculateScore(10,0);
        Assert.assertTrue(score == 100);
    }//

    @Test
    public void Dado_EnOriginalScore_cuando_EsDosYOnce_Entonces_retornaCero() throws GameScoreException {
        GameScore game = new OriginalScore();
        int score = game.CalculateScore(2,11);
        Assert.assertTrue(score == 0);
    }

    @Test
    public void Dado_EnBonusScore_cuando_EsDiezYCero_Entonces_retornaCien() throws GameScoreException {
        GameScore game = new BonusScore();
        int score = game.CalculateScore(10,0);
        Assert.assertTrue(score == 100);
    }


    @Test
    public void Dado_EnBonusScore_Cuando_EsDiezYVeinte_Entonces_retornaCero() throws GameScoreException {
        GameScore game = new BonusScore();
        int score = game.CalculateScore(10,20);
        Assert.assertTrue(score == 0);
    }

    @Test
    public void Dado_EnPowerScore_Cuando_EsTresYCero_Entonces_retornaCientocincuentaycinco() throws GameScoreException {
        GameScore game = new PowerScore();
        int score = game.CalculateScore(3,0);
        Assert.assertTrue(score == 155);
    }

    @Test
    public void Dado_EnPowerScore_Cuando_EsCeroYUno_Entonces_retornaCero() throws GameScoreException {
        GameScore game = new PowerScore();
        int score = game.CalculateScore(0,1);
        Assert.assertTrue(score == 0);
    }



}

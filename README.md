### Escuela Colombiana de Ingeniería

### Procesos de Desarrollo de Software

### Desarrollo Dirigido por Pruebas + DIP + DI + Contenedores Livianos

## INTEGRANTES 

* Carol Tatiana Cely 
* Julian Andres Largo 

____________________________________

Para este taller se va a trabajar sobre el juego del ahorcado.

El sistema actual de puntuación del juego comienza en 100 puntos y va
descontando 10 puntos cada vez que se propone una letra incorrecta.

Algunos usuarios han propuesto diferentes esquemas para realizar la
puntuación, los cuales se describen a continuación:

* OriginalScore: 
    * Es el esquema actual, se inicia con 100 puntos.
    * No se bonifican las letras correctas.
    * Se penaliza con 10 puntos con cada letra incorrecta.
    * El puntaje minimo es 0.

* BonusScore: 
    * El juego inicia en 0 puntos.
    * Se bonifica con 10 puntos cada letra correcta.
    * Se penaliza con 5 puntos cada letra incorrecta.
    * El puntaje mínimo es 0
    
* PowerBonusScore:
    * El juego inicia en 0 puntos.
    * La $i-ésima$ letra correcta se bonifica con $5^i$.
    * Se penaliza con 8 puntos cada letra incorrecta.
    * El puntaje mínimo es 0
    * Si con las reglas anteriores sobrepasa 500 puntos, el puntaje es
      500.

Lo anterior, se traduce en el siguiente modelo, donde se aplica el
principio de inversión de dependencias:


![](img/model.png)


### Parte I

1. Clone el proyecto (no lo descargue!).

![image](https://user-images.githubusercontent.com/63822072/192019496-83126433-a69f-4b65-9d34-6fb64a3389fe.png)

   
2. A partir del código existente, implemente sólo los cascarones del
   modelo antes indicado.
   
   ### OriginalScore
   
 ![image](https://user-images.githubusercontent.com/63822072/192025340-dadc607f-5d8b-41aa-bac7-26a2256c1bfc.png)
 
   ### BonusScore

![image](https://user-images.githubusercontent.com/63822072/192025376-186e7a57-ff14-4add-a424-7c92f0f9a350.png)

   ### PowerScore

![image](https://user-images.githubusercontent.com/63822072/192025403-e55b348d-1f47-44b7-8a5a-53c808128381.png)


3. Haga la especificación de los métodos calculateScore (de las tres
   variantes de GameScore), a partir de las especificaciones
   generales dadas anteriormente. Recuerde tener en cuenta: @pre,
   @pos, @param, @throws.
   
   ![image](https://user-images.githubusercontent.com/63822072/192025496-4ec1fa15-6890-4b6e-ae2f-10b8b33e6481.png)


4. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "especificación métodos"
	```
	
![image](https://user-images.githubusercontent.com/63822072/192026178-d53bf614-3103-4485-ba04-1e582f88ef0f.png)


5. Actualice el archivo `pom.xml` e incluya las dependencias para la ultima versión de JUnit y la versión del compilador de Java a la versión 8 .

![image](https://user-images.githubusercontent.com/63822072/192026528-84d9931c-2a9c-4de5-94d6-58098a016b0e.png)

   
6. Teniendo en cuenta dichas especificaciones, en la clase donde se
   implementarán las pruebas (GameScoreTest), en los
   comentarios iniciales, especifique las clases de equivalencia para
   las tres variantes de GameScore, e identifique
   condiciones de frontera. 
   
### Se eligieron los siguientes casos 
   
CC = correctCount

IC = incorrectCount

Input = CC, IC

Invalid = CC < 0 || IC < 0

Invalid = Throws INVALID_PARAMETERS Exception

valid = CC > 0 & IC > 0

### Clases de equivalencia 

![image](https://user-images.githubusercontent.com/63822072/192068255-0eb8fc20-f4fd-4d04-b26a-ef4d2ca87386.png)

   
7. Para cada clase de equivalencia y condición de frontera, implemente
   una prueba utilizando JUnit.

![image](https://user-images.githubusercontent.com/63822072/192070288-e11a165c-88f6-4330-9878-87ef7306a55e.png)

![image](https://user-images.githubusercontent.com/63822072/192070298-c6aa7cd9-0a52-4d37-93d5-cc0544eec142.png)

![image](https://user-images.githubusercontent.com/63822072/192070310-aff5093d-4d93-4677-b8dc-fc1b24db2146.png)

8. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "implementación pruebas"
	```
![image](https://user-images.githubusercontent.com/63822072/192070363-3a6da7ea-9652-4174-bd54-4e48a2c47755.png)

![image](https://user-images.githubusercontent.com/63822072/192078684-cad57462-de83-44ac-84f9-6a561e036f8e.png)

 

9. Realice la implementación de los 'cascarones' realizados anteriormente.
   Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores
   se ejecutan satisfactoriamente.

![image](https://user-images.githubusercontent.com/63822072/192075313-36eb5009-44dc-46ec-9f42-7b66757bbd46.png)

![image](https://user-images.githubusercontent.com/63822072/192075409-202de755-612b-47ce-8056-f6e1285d53c4.png)

![image](https://user-images.githubusercontent.com/63822072/192075424-cbc4cdca-fae7-438c-82cc-d5ba4862a503.png)




10. Al finalizar haga un nuevo commit:

	```bash		
	git add .			
	git commit -m "implementación del modelo"
	```
	
	![image](https://user-images.githubusercontent.com/63822072/192075644-715a0681-9471-4da5-8248-0bb7efa849ed.png)


11. Para sincronizar el avance en el respositorio y NO PERDER el trabajo, use
    el comando de GIT para enviar los cambios:

```bash	
	git push <URL Repositorio>	
```


### Parte II

Actualmente se utiliza el patrón FactoryMethod
que desacopla la creación de los objetos para diseñar un juego
de ahorcado (revisar createGUIUsingFactoryMethod en SwingProject, el
constructor de la clase GUI y HangmanFactoryMethod).

En este taller se va a utilizar un contenedor liviano ([GoogleGuice](https://github.com/google/guice)) el cual soporta la inyección de las dependencias.

1. Utilizando el HangmanFactoryMethod (MétodoFabrica) incluya el
   OriginalScore a la configuración.
   
 ![image](https://user-images.githubusercontent.com/63822072/192077366-79d47687-2b8a-45d4-bf1d-787557dda158.png)

![image](https://user-images.githubusercontent.com/63822072/192077372-e8dbdc40-a8bc-4af7-951b-e7bc94f17d67.png)


Incorpore el Contenedor Liviano Guice dentro del proyecto:

![image](https://user-images.githubusercontent.com/63822072/192077386-1e53a859-41c3-4d27-a6e8-09e0ded66581.png)

* Revise las dependencias necesarias en el pom.xml.

![image](https://user-images.githubusercontent.com/63822072/192077411-b0a5fc09-2938-45cb-9b06-4812c5e9a456.png)

* Modifique la inyección de dependencias utilizando guice en lugar del
  método fábrica..
  
  ![image](https://user-images.githubusercontent.com/63822072/192077753-e80eb9eb-1dcf-4502-84c8-fcaa40c1fd00.png)

* Configure la aplicación de manera que desde el programa SwingProject
  NO SE CONSTRUYA el Score directamente, sino a través de Guice, asi
  mismo como las otras dependencias que se están inyectando mediante
  la fabrica.
* Mediante la configuración de la Inyección de
  Dependencias se pueda cambiar el comportamiento del mismo, por
  ejemplo:
	* Utilizar el esquema OriginalScore.
	* Utilizar el esquema BonusScore.
	* Utilizar el idioma francés.
    * Utilizar el diccionario francés.
	* etc...
* Para lo anterior, [puede basarse en el ejemplo dado como
  referencia](https://github.com/PDSW-ECI/LightweighContainers_DepenendecyInjectionIntro-WordProcessor).

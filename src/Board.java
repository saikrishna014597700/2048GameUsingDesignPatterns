import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.ArrayList;

/*
 * Board class: actor where most of the actions of the game is performed
 */
public class Board extends Actor {
    // Board manages pretty much everything that makes up the game (would you just
    // reduce it to gameplay) | if (getWorld ()! = null) exists in many places,
    // because otherwise older versions of Greenfoot may fail
    private Field[][] field; // Field array is declared: Current Positions of the numbers

    


    private LastState[][] lastState; // Last state is declared: Previous Posotions of the numbers    privae
    private LastScore lastScore;
    
    private NumberedBlock number; // Actor references are declared / initialized
    private Score scoreActor; // Score is declared for maintaining in current score
    private Highscore highScoreActor; // Highscore is declared for maintaining in highscore score of the game
    
    private ScoreShadow scoreShadowActor; // Shadow under the score
    private HighscoreShadow highScoreShadowActor; // Shadow under the highscore
    private GameOverText gameOverText = new GameOverText();
    private RatingDecorator ratingDecorator;

    private GameOverOverlay gameOverOverlay;
    private Button playButton = new Button(new GreenfootImage("play.png"), 240, 120);
    private Rating rating; 
    // private PlayButton playButton = new PlayButton(true);

    private int width;
    private int height;

    private int highscore = 0; // Simple variables are declared / initialized
    private int score = 0;
    private boolean debugMode;
    private boolean fieldInitialized = false;
    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    
    private boolean mkey=false;
    private boolean nkey=false;

    private MoveSubject move;

    private IGameState gameNotStartedState;
    private IGameState gamePausedState;
    private IGameState gameOverState;
    private IGameState gameRunningState;
    private IGameState currentState; 
    
    private boolean xkey=false;
    private boolean mousebtnsFlag=false;
    
    private upkey upkeybtn = new upkey(true);
    private downkey downkeybtn = new downkey(true);
    private rightkey rightkeybtn = new rightkey(true);
    private leftkey leftkeybtn = new leftkey(true);
    
    

    /*
     * Constructor of Board
     */
    public Board() // Constructor makes the "game preparations"
    {

        
        gameRunningState = new GameRunningState(this);
        gameNotStartedState = new GameNotStartedState(this);
        gamePausedState = new GamePausedState(this);
        gameOverState = new GameOverState(this);
        currentState = gameNotStartedState; //Current State is set to game "NotStartedState"
        field = new Field[4][4]; //Field 2D-Array size is specified for 4x4 game
        lastState = new LastState[4][4]; //Field 2D-Array size is specified for 4x4 game
        lastScore = new LastScore();

        
        debugMode=false;
       
        highscore=HighscoreObserver.getHighScore(); //Setting highscire from txt file
        fillField(); //Field and LastState initialized with initial values
        placeRandomField(); //One random value from 2 or 4 is assigned to one element in the field
        placeRandomField(); //One random value from 2 or 4 is assigned to one element in the field
        if(getWorld()!=null)
        {
            updateFieldVisuals(); //Board filled with Numbers' images
            printScore(currentState); 
        }
        
        


        

       
    }

    
       public void moveup()
	{
	          currentState.play();
	          storeState();
	          move = new UpMove(field);
	              
	          up = true;        
	         if(move.move())
	         {
	         updateFieldVisuals();
	         placeRandomField(); // Place any random value to the field array after every move  
	        }
	 }
	 
	  public void movedown()
	{
	          currentState.play();
	          storeState();
	          move = new DownMove(field);
	              
	          down = true;        
	         if(move.move())
	         {
	         updateFieldVisuals();
	         placeRandomField(); // Place any random value to the field array after every move  
	        }
	 }
	 
	  public void moveleft()
	{
	          currentState.play();
	          storeState();
	          move = new LeftMove(field);
	              
	          left = true;        
	         if(move.move())
	         {
	         updateFieldVisuals();
	         placeRandomField(); // Place any random value to the field array after every move  
	        }
	 }
	 
	  public void moveright()
	{
	          currentState.play();
	          storeState();
	          move = new RightMove(field);
	              
	          right = true;        
	         if(move.move())
	         {
	         updateFieldVisuals();
	         placeRandomField(); // Place any random value to the field array after every move  
	        }
	 }
    /*
     * act method of greenfoot
     */
    public void act() {

        boolean anyfieldMoved = false;

        if (getWorld() != null && !fieldInitialized) // try to load the visual interface until getWorld () does not make
                                                     // any more problems (otherwise it does because of Greenfoot)

        {
            updateFieldVisuals();
            fieldInitialized = true;
        }
        if (checkForMovableFields() && !(currentState == gameOverState || currentState == gamePausedState)) // Move and
                                                                                                            // add only
                                                                                                            // while the
                                                                                                            // game is
                                                                                                            // running
        {

            setAllMovedFalse();
            if (Greenfoot.isKeyDown("up") && !up) {

                currentState.play();
                storeState();
                move = new UpMove(field);
                anyfieldMoved = move.move();
                up = true;
            }

            if (Greenfoot.isKeyDown("down") && !down) {

                currentState.play();
                storeState();
                move = new DownMove(field);
                anyfieldMoved = move.move();
                down = true;
            }

            if (Greenfoot.isKeyDown("left") && !left) {

                currentState.play();
                storeState();
                move = new LeftMove(field);
                anyfieldMoved = move.move();
                left = true;
            }
            if (Greenfoot.isKeyDown("right") && !right) {

                currentState.play();
                storeState();
                move = new RightMove(field);
                anyfieldMoved = move.move();
                right = true;
            }
            if (Greenfoot.isKeyDown("m")&&!mkey)
            {
                RotationContext context = new RotationContext(new RotateClockwise());       
                field = context.executeStrategy(field); 
      
                updateFieldVisuals();
                mkey = true;          
            }
            if (Greenfoot.isKeyDown("n")&&!nkey)
            {
                RotationContext context = new RotationContext(new RotateAnticlockwise());       
                field = context.executeStrategy(field);
      
                updateFieldVisuals();
                nkey = true;         
            }
            if (Greenfoot.isKeyDown("x")&&!xkey)
            { 
                mousebtnsFlag = !mousebtnsFlag;
                
                if(mousebtnsFlag)  
                {
                getWorld().addObject(leftkeybtn, 360, 540);
                getWorld().addObject(rightkeybtn, 440, 540);
                getWorld().addObject(upkeybtn, 400, 500);
                getWorld().addObject(downkeybtn, 400, 580);  
                }
                else
                {
                getWorld().removeObject(leftkeybtn);
                getWorld().removeObject(rightkeybtn);
                getWorld().removeObject(upkeybtn);
                getWorld().removeObject(downkeybtn); 
                }
                
                xkey = true;  
            }
            if (anyfieldMoved) {
                updateFieldVisuals();
                placeRandomField(); // Place any random value to the field array after every move
            }

              printScore(currentState);
            
        }
        else if(currentState == gamePausedState) {
          //do nothing
        }
        else // Cancel the Game / Game Over

        {
            currentState = gameOverState;
            if (currentState == gameOverState) {
                showGameOverScreen();
                
            }

            printScore(currentState);
        }
        // Measures to ensure that only one input is taken per keystroke rather than
        // each tick
        if (!Greenfoot.isKeyDown("up")) {
            up = false;
        }
        if (!Greenfoot.isKeyDown("down")) {
            down = false;
        }
        if (!Greenfoot.isKeyDown("left")) {
            left = false;
        }
        if (!Greenfoot.isKeyDown("right")) {
            right = false;
        }
        if (!Greenfoot.isKeyDown("m"))
        {
            mkey=false;
        }
        if (!Greenfoot.isKeyDown("n"))
        {
            nkey=false;
        }
         if (!Greenfoot.isKeyDown("x"))
        {
            xkey=false;
        }
    }

    /*
     * Setting the current state of the Game
     * 
     * @param String gameState state to be set for the game
     */
    public void setState(String gameState) {

        switch (gameState) {
        case "Playing":
        case "Resumed":
            currentState = gameRunningState;
            break;
        case "Restarted":
            currentState = gameNotStartedState;
            break;
        case "Paused":
            currentState = gamePausedState;
            break;
        default:
            break;

        }

    }

    /*
     * Showing GameOver Overlay on Gameover
     */

    public void showGameOverScreen() 
    {
        
        if(getWorld()!=null)
        {
            for (int i=0; i<127;i=i+2)
            {

                gameOverOverlay = new GameOverOverlay(i);
                getWorld().addObject(gameOverOverlay, 0, 0);
                Greenfoot.delay(1);
                getWorld().removeObject(gameOverOverlay);
            }
            getWorld().addObject(gameOverOverlay, 0, 0);
            Greenfoot.delay(10);
            printScore(currentState);
            getWorld().addObject(gameOverText, 240, 60);
            //getWorld().addObject(playButton, 240, 420);
            //playButton.setCommand(new PlayCommand());
        }
    }

    /*
     * Show Numbers' Image according to Field 2D-Array
     */
    public void updateFieldVisuals() {
        getWorld().removeObjects(getWorld().getObjects(NumberedBlock.class));
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field.length; y++) {
                int currentValue = field[x][y].getValue();
                if (currentValue > 0) {
                    
                    /*
                     * Call Prototype blocks.
                     */
                        switch(currentValue)
                {
                case 2:
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock2");
                break;
                case 4: 
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock4");
                break;
                case 8: 
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock8");
                break;  
                case 16: 
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock16");
                break;
                case 32:
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock32");
                break;
                case 64: 
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock64");
                break;
                case 128: 
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock128");
                break;
                case 256: 
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock256");
                break;
                case 512: 
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock512");
                break;
                case 1024: 
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock1024");
                break;
                case 2048: 
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock2048");
                break;
                case 4096:
                number = NumberedBlockStore.getNumberedBlock("NumberedBlock4096");
                break;
                case 8192: 
                    number = NumberedBlockStore.getNumberedBlock("NumberedBlock8192");
                        break;
                } 
                    getWorld().addObject(number, x * 120 + 60, y * 120 + 60);
                }
            }
        }
    }

    /*
     * Show Animation or Transition on any move (left, right, up, down)
     * 
     * @param int pX row of the field's 2D-array
     * 
     * @param int pY column of the field's 2D-array
     * 
     * @param int pValue value to be assigned at [x][y] element of the field's
     * 2D-array
     */
    public void playPlaceAnimation(int pX, int pY, int pValue) {
        if (getWorld() != null) {
            //for (int i = 1; i < 120; i = i + 16) {
                //number = new Number(pValue, i);
                //getWorld().addObject(number, pX * 120 + 60, pY * 120 + 60);
                //Greenfoot.delay(1);
                //getWorld().removeObject(number);
            //}
            updateFieldVisuals();
        }
    }

    /*
     * public void addScore(int pAdd) //Addiert Score um pAdd { score=score+pAdd; }
     * public int getScore() //Getter wegen private { return score; }
     */

    /*
     * Printing current score and highscore
     * 
     * @param boolean gameOver whether gameOver state or not
     */

    public void printScore(IGameState currentState)
    {
        if(getWorld()!=null&&!(currentState == gameOverState)) //Game is running

        {
            getWorld().removeObject(scoreShadowActor); // Shows shadows (puts the strings in black underneath and offset
                                                       // to make the scores better match the theme of the game)
            getWorld().removeObject(highScoreShadowActor);
            scoreShadowActor = new ScoreShadow(ScoreObserver.getScore(), false);
            getWorld().addObject(scoreShadowActor, 242, 522);
            highScoreShadowActor = new HighscoreShadow(HighscoreObserver.getHighScore(), false);
            getWorld().addObject(highScoreShadowActor, 242, 562);

            getWorld().removeObject(scoreActor);
            getWorld().removeObject(highScoreActor);

            scoreActor = new Score(ScoreObserver.getScore(),false);
            getWorld().addObject(scoreActor,240,520);
            
            
            
            highScoreActor = new Highscore(HighscoreObserver.getHighScore(),false);
            getWorld().addObject(highScoreActor,240,560);
        }
        else if(getWorld()!=null&&(currentState == gameOverState)) //Game Over

        {
            getWorld().removeObject(scoreShadowActor); // Shows shadows (puts the strings in black underneath and offset
                                                       // to make the scores better match the theme of the game)
            getWorld().removeObject(highScoreShadowActor);

            scoreShadowActor = new ScoreShadow(ScoreObserver.getScore(),true);
            getWorld().addObject(scoreShadowActor,242,182);
            highScoreShadowActor = new HighscoreShadow(HighscoreObserver.getHighScore(),true);
            getWorld().addObject(highScoreShadowActor,242,302);
            
      
            
            getWorld().removeObject(scoreActor);
            getWorld().removeObject(highScoreActor);
            scoreActor = new Score(ScoreObserver.getScore(),true);
            
            getWorld().addObject(scoreActor,240,180);
            
           
            highScoreActor = new Highscore(HighscoreObserver.getHighScore(),true);
            getWorld().addObject(highScoreActor,240,300);
            
            
            rating = new Rating();
            getWorld().addObject(rating, 200, 240);
            //ratingDecorator =  new RatingDecorator();
            rating.display();
            if(HighscoreObserver.getHighScore() == ScoreObserver.getScore()){
                ratingDecorator = new HighRatingDecorator((IDecorator)rating);
                getWorld().addObject(ratingDecorator, 340, 240);
                
            } else {
                ratingDecorator = new LowRatingDecorator((IDecorator)rating);
                getWorld().addObject(ratingDecorator, 340, 240);
                
            }
            ratingDecorator.display();
            
        }
    }

    /*
     * Switching Debugging mode
     */
    public void switchDebugMode() {
        if (debugMode) {
            debugMode = false;
        } else {
            debugMode = true;
        }
    }

    /*
     * Set Initial Board for Testing by setting random value (2 or 4) to number of
     * fields
     * 
     * @param int pNumberOfFields Number of Fields to be initialized
     */
    public void setInitialBoardForTesting(int pNumberOfFields) // Erstellt ein Board mit "pNumberOfFields" Feldern
    {
        for (int i = 0; i < pNumberOfFields; i++) {
            placeRandomField();
        }
    }

    /*
     * Initialize the Field Array and LastState Array
     */
    public void fillField() {
        int x;
        int y;
        for (x = 0; x < field.length; x++) {
            for (y = 0; y < field.length; y++) {
                field[x][y] = new Field();
                lastState[x][y] = new LastState();
            }
        }
    }

    /*
     * Priniting out field array for debugging
     * 
     * @param boolean dontClearConsole Console should be cleared or not
     */
    public void printField(boolean dontClearConsole) {
        if (dontClearConsole) {
            System.out.println("_______");
            System.out.println();
        } else {
            System.out.print('\f');
        }
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                if (field[x][y].getValue() == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(field[x][y].getValue() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Score: " + ScoreObserver.getScore());
        if (!checkForMovableFields()) {
            System.out.println("Game Over!");
        }
    }

    /*
     * Placing random value (2 or 4) to one of the element of Field's 2D-array
     */
    public void placeRandomField() {
        boolean numberPlaced = false;
        boolean emptyFields = false;
        int xRandom = Greenfoot.getRandomNumber(4);
        int yRandom = Greenfoot.getRandomNumber(4);
        int x = 0;
        int y = 0;
        int placedValue = 2;
        for (x = 0; x < field.length; x++) // Checks if there are empty fields, so that no endless loop is created
        {
            for (y = 0; y < field.length; y++) {
                if (field[x][y].getValue() == 0) {
                    emptyFields = true;
                }
            }
        }
        if (emptyFields) // Place a field in a random empty space, if any
        {
            while (numberPlaced == false) {
                if (field[xRandom][yRandom].getValue() == 0) {
                    field[xRandom][yRandom].setRandomInitialValue();
                    placedValue = field[xRandom][yRandom].getValue();
                    numberPlaced = true;
                } else {
                    xRandom = Greenfoot.getRandomNumber(4);
                    yRandom = Greenfoot.getRandomNumber(4);
                }
            }
        }
        if (numberPlaced) // Plays the (not yet implemented) separate animation
        {
            playPlaceAnimation(xRandom, yRandom, placedValue);
        }
    }

    /*
     * Resetting each field's value to false before moving
     */
    public void setAllMovedFalse() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field.length; y++) {
                field[x][y].setMoved(false);
            }
        }
    }

    /*
     * Check Whether there is movable field or not
     * 
     * @return boolean movable field or not
     */
    public boolean checkForMovableFields() {
        int y;
        int x;
        boolean anyFieldsMovable = false;
        // UP
        for (y = 1; y < field.length; y++) {
            for (x = 0; x < field.length; x++) {
                if (field[x][y].getValue() != 0 && field[x][y - 1].getMoved() == false
                        && (field[x][y - 1].getValue() == field[x][y].getValue() || field[x][y - 1].getValue() == 0)) {
                    anyFieldsMovable = true;
                } else if (field[x][y].getValue() == 0) {
                    anyFieldsMovable = true;
                }
            }
        }
        // DOWN
        for (y = (field.length - 2); y >= 0; y--) {
            for (x = 0; x < field.length; x++) {
                if (field[x][y].getValue() != 0 && field[x][y + 1].getMoved() == false
                        && (field[x][y + 1].getValue() == field[x][y].getValue() || field[x][y + 1].getValue() == 0)) {
                    anyFieldsMovable = true;
                } else if (field[x][y].getValue() == 0) {
                    anyFieldsMovable = true;
                }
            }
        }
        // LEFT
        for (x = 1; x < field.length; x++) {
            for (y = 0; y < field.length; y++) {
                for (int xIn = 1; xIn < field.length; xIn++) {
                    if (field[x][y].getValue() != 0 && field[x - 1][y].getMoved() == false
                            && (field[x - 1][y].getValue() == field[x][y].getValue()
                                    || field[x - 1][y].getValue() == 0)) {
                        anyFieldsMovable = true;
                    } else if (field[x][y].getValue() == 0) {
                        anyFieldsMovable = true;
                    }
                }
            }
        }
        // RIGHT
        for (x = (field.length - 2); x >= 0; x--) {
            for (y = 0; y < field.length; y++) {
                for (int xIn = (field.length - 2); xIn >= 0; xIn--) {
                    if (field[x][y].getValue() != 0 && field[x + 1][y].getMoved() == false
                            && (field[x + 1][y].getValue() == field[x][y].getValue()
                                    || field[x + 1][y].getValue() == 0)) {
                        anyFieldsMovable = true;
                    } else if (field[x][y].getValue() == 0) {
                        anyFieldsMovable = true;
                    }
                }
            }
        }
        return anyFieldsMovable;
    }

    /*
     * Place value to specified element of Field's 2D-Array
     * 
     * @param int pX row of the field's 2D-array
     * 
     * @param int pY column of the field's 2D-array
     * 
     * @param int pValue value to be assigned at [x][y] element of the field's
     * 2D-array
     */
    public void placeSpecificField(int pX, int pY, int pValue) {
        field[pX][pY].setValue(pValue);
        updateFieldVisuals();
    }

    /*
     * Storing the current state before moving to any side
     */
    public void storeState() {
        
        lastScore.setValue(ScoreObserver.getScore());
        for (int i = 0; i < field.length; i++) {
            
            for (int j = 0; j < field.length; j++) {
                
                if (field[i][j].getValue() == 0) {
                    lastState[i][j].setValue(0);
                } else {
                    lastState[i][j].setValue(field[i][j].getValue());
                }
            }
        }
    }

    /*
     * Get Previous State of the Field's Array
     */
    public void undo() {
        // Get Memento here and store it in Field Array
        // Set Memento to false, so player can undo only once
        ScoreObserver.setScore(lastScore.getValue());
        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field.length; j++) {
                field[i][j].setValue(lastState[i][j].getValue());
            }
        }
        updateFieldVisuals();
    }
}

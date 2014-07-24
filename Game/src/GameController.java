
public class GameController {
	private static int runCounter = 0;
	//runStatus = false means computerRun
	private boolean runStatus = false;
	//mass with run results
	private static char[][] massGame = new char[3][3];
	public GameController() {
		//insert '_' at the beginning of the game
		for(int i = 0; i < massGame.length; i++){
			for(int j = 0; j < massGame[i].length; j ++)
				massGame[i][j] = '_';
		}
	}
	//check the position (free or not free)
	public static boolean isFree(int i, int j){
		if(massGame[i][j] == '_')
			return true;
		else
			return false;
	}
	public static void humanRun(int i_temp, int j_temp) {
		massGame[i_temp][j_temp] = 'O';
	}
	public static void computerRun(int i_temp, int j_temp) {
		massGame[i_temp][j_temp] = 'X';
	}
	//If there are no free cells
	public static boolean isOverRun(){
		int counter = 0;
		for(int i = 0; i < massGame.length; i++) {
			for(int j = 0; j < massGame[i].length; j++){
				if(massGame[i][j] == '_')
					counter ++;
			}
		}
		if(counter == 0)
			return true;
		else return false;
	}
	public static char isWinner() {
		//по горизонтали
		if( (massGame[0][0] == massGame[0][1] && massGame[0][1] == massGame[0][2] &&
				massGame[0][0] == massGame[0][2]))
			return massGame[0][0];
		if((massGame[1][0] == massGame[1][1] && massGame[1][1] == massGame[1][2] &&
				massGame[1][0] == massGame[1][2]))
			return massGame[1][0];
		if((massGame[2][0] == massGame[2][1] && massGame[2][1] == massGame[2][2] &&
				massGame[2][0] == massGame[2][2]))
			return massGame[2][0];
		//по вертикали
		if( (massGame[0][0] == massGame[1][0] && massGame[1][0] == massGame[2][0] &&
				massGame[0][0] == massGame[2][0]))
			return massGame[0][0];
		if((massGame[0][1] == massGame[1][1] && massGame[1][1] == massGame[2][1] &&
				massGame[0][1] == massGame[2][1]))
			return massGame[0][1];
		if((massGame[0][2] == massGame[1][2] && massGame[1][2] == massGame[2][2] &&
				massGame[0][2] == massGame[2][2]))
			return massGame[0][2];
		//по диагонали
		if(massGame[0][0] == massGame[1][1] && massGame[1][1] == massGame[2][2] && 
				massGame[0][0] == massGame[2][2])
			return massGame[0][0];
		if(massGame[0][2] == massGame[1][1] && massGame[1][1] == massGame[2][0] && 
				massGame[0][2] == massGame[2][0])
			return massGame[0][2];
		return '_';
	}
	public static int getRunCounter() {
		return runCounter;
	}

	public static void incrementCount(){
		runCounter ++;
	}
	public boolean getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(boolean runStatus) {
		this.runStatus = runStatus;
	}
}

import java.util.Arrays;


public class GameController {
	private static int runCounter = 0;
	//runStatus = false means computerRun
	private boolean runStatus = false;
	//mass with run results
	public static char[][] massGame = new char[MainDialog.getN()][MainDialog.getN()];
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
	//get O wins count
	public static int getOWinnerCounter(){
		int oWinnerCounter = 0;
		//horizontal checking
				for(int i = 0; i < massGame.length; i ++){
					for(int j = 1; j < massGame[i].length - 1; j++){
						if((massGame[i][j-1] == massGame[i][j]) && 
								(massGame[i][j] == massGame[i][j + 1]) &&
								massGame[i][j-1] == 'O')
							oWinnerCounter ++;
					}
				}
				//vertical checking
				for(int i = 1; i < massGame.length-1; i ++){
					for(int j = 0; j < massGame[i].length; j++){
						if((massGame[i-1][j] == massGame[i][j]) && 
								(massGame[i][j] == massGame[i+1][j]) &&
								massGame[i-1][j] == 'O')
							oWinnerCounter ++;
					}
				}
				//diagonal checking
				for(int i = 1; i < massGame.length - 1; i ++){
					for(int j = 1; j < massGame[i].length - 1; j++){
						//diagonal from left to right
						if((massGame[i-1][j-1] == massGame[i][j]) &&
								(massGame[i][j]	== massGame[i+1][j + 1]) &&
								massGame[i-1][j-1] == 'O')
							oWinnerCounter ++;
						//diagonal from right to left
						if((massGame[i-1][j + 1] == massGame[i][j]) &&
								(massGame[i][j]	== massGame[i+1][j - 1]) &&
								massGame[i-1][j + 1] == 'O')
							oWinnerCounter ++;

					}
				}
				return oWinnerCounter;
	}
	//get O wins count
		public static int getXWinnerCounter(){
			int xWinnerCounter = 0;
			//horizontal checking
					for(int i = 0; i < massGame.length; i ++){
						for(int j = 1; j < massGame[i].length - 1; j++){
							if((massGame[i][j-1] == massGame[i][j]) && 
									(massGame[i][j] == massGame[i][j + 1]) &&
									massGame[i][j-1] == 'X')
								xWinnerCounter ++;
						}
					}
					//vertical checking
					for(int i = 1; i < massGame.length-1; i ++){
						for(int j = 0; j < massGame[i].length; j++){
							if((massGame[i-1][j] == massGame[i][j]) && 
									(massGame[i][j] == massGame[i+1][j]) &&
									massGame[i-1][j] == 'X')
								xWinnerCounter ++;
						}
					}
					//diagonal checking
					for(int i = 1; i < massGame.length - 1; i ++){
						for(int j = 1; j < massGame[i].length - 1; j++){
							//diagonal from left to right
							if((massGame[i-1][j-1] == massGame[i][j]) &&
									(massGame[i][j]	== massGame[i+1][j + 1]) &&
									massGame[i-1][j-1] == 'X')
								xWinnerCounter ++;
							//diagonal from right to left
							if((massGame[i-1][j + 1] == massGame[i][j]) &&
									(massGame[i][j]	== massGame[i+1][j - 1]) &&
									massGame[i-1][j + 1] == 'X')
								xWinnerCounter ++;

						}
					}
					return xWinnerCounter;
		}
	//check massGame for winners
	public static char winner() {
		//horizontal checking
		for(int i = 0; i < massGame.length; i ++){
			for(int j = 1; j < massGame[i].length - 1; j++){
				if((massGame[i][j-1] == massGame[i][j]) && 
						(massGame[i][j] == massGame[i][j + 1]) )
					return massGame[i][j-1];
			}
		}
		//vertical checking
		for(int i = 1; i < massGame.length-1; i ++){
			for(int j = 0; j < massGame[i].length; j++){
				if((massGame[i-1][j] == massGame[i][j]) && 
						(massGame[i][j] == massGame[i+1][j]) )
					return massGame[i-1][j];
			}
		}
		//diagonal checking
		for(int i = 1; i < massGame.length - 1; i ++){
			for(int j = 1; j < massGame[i].length - 1; j++){
				//diagonal from left to right
				if((massGame[i-1][j-1] == massGame[i][j]) &&
						(massGame[i][j]	== massGame[i+1][j + 1]) )
					return massGame[i][j];
				//diagonal from right to left
				if((massGame[i-1][j + 1] == massGame[i][j]) &&
						(massGame[i][j]	== massGame[i+1][j - 1]) )
					return massGame[i][j];

			}
		}
		return '_';
	}
	
	//win analize
	public static boolean predictComputerWin(int i_temp, int j_temp) {
		massGame[i_temp][j_temp] = 'X';
		int oWinCounter = 0;
		//status for X which represents the ability of X to be the winner
		boolean xWinStatus = false;
		//predict next run of O
		for(int i = 0; i < massGame.length; i ++){
			for(int j = 0; j < massGame[i].length; j++){
				if(massGame[i][j] == '_'){
					massGame[i][j] = 'O';
					oWinCounter += getOWinnerCounter();
					massGame[i][j] = '_';
				}
			}
		}
		System.out.println("Counter: " + oWinCounter);
		if(oWinCounter > 1) {
			oWinCounter = 0;
			massGame[i_temp][j_temp] = '_';
			return true;
		}
		int xWinCounter = getXWinnerCounter();
		//if O may win
		if(oWinCounter == 1 && xWinCounter == 0) {
			oWinCounter = 0;
			massGame[i_temp][j_temp] = '_';
			return false;
		}
		//If O can't Win
		if(oWinCounter == 0){
			//check all runs for X (maybe X can win on next step)
			//***************
			massGame[i_temp][j_temp] = '_';
			for(int i = 0; i < massGame.length; i ++){
				for(int j = 0; j < massGame[i].length; j++){
					if(massGame[i][j] == '_'){
						massGame[i][j] = 'X';
						//if X is winner
						if(GameController.winner() == 'X' && i_temp == i && j_temp == j){
							xWinStatus = true;
						}
						massGame[i][j] = '_';
					}
				}
			}
			massGame[i_temp][j_temp] = 'X';
			if(xWinStatus == true){
				massGame[i_temp][j_temp] = '_';
				return true;
			}
			//if there are no wins of X or O
			else if((oWinCounter == 0 || oWinCounter > 1)  && xWinStatus == false){
				massGame[i_temp][j_temp] = '_';
				return true;
			}
			massGame[i_temp][j_temp] = '_';
			return false;
		}
		//if oWinCounter > 1 There is no chance to win for X
		else if(oWinCounter > 1) {
			oWinCounter = 0;
			massGame[i_temp][j_temp] = '_';
			return true;
		}
		oWinCounter = 0;
		massGame[i_temp][j_temp] = '_';
		return true;
			
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
	//clean run counter
	public static void cleanRunCounter() {
		runCounter = 0;
	}
}
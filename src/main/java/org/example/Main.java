package org.example;

import java.util.*;

public class Main {
    // Initialize ArrayLists to keep track of player and CPU positions
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        // Create the game board as a 2D array.
        char[][] gameBoard = {{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
        // Display the initial game board.
        printGameBoard(gameBoard);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter your placement(1-9) : ");
            int playerPos = scan.nextInt();

            // Check if the chosen position is already taken.
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
                System.out.println("position taken enter a correct ");
                playerPos = scan.nextInt();
            }
            // Place the player's piece on the board and record the position.
            placePiece(gameBoard,playerPos,"player");

            String result = checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;

            }
            Random rand = new Random();
            int cpuPos = rand.nextInt(9)+1;
            // Check if the randomly chosen CPU position is already taken.
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){

               cpuPos = rand.nextInt(9)+1;
            }

            // Place the CPU's piece on the board and record the position.
            placePiece(gameBoard,cpuPos,"cpu");
            printGameBoard(gameBoard);
             result = checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;

            }

        }


    }
    public static void printGameBoard(char[][] gameBoard){

        for (char[] row : gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }

    }
    public static void placePiece(char[][] gameBoard, int pos ,String user ){
        char symbol = ' ';
        if (user.equals("player")){
            symbol='x';
            playerPositions.add(pos);
        }
        else if(user.equals("cpu")){
            symbol='0';
            cpuPositions.add(pos);
        }
        switch (pos){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }
    public static String checkWinner(){
        // Define winning combinations as lists of positions.
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);
        List <List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
for (List l: winning){
    if(playerPositions.containsAll(l)){
        return "Congratulations you won ";
    }else if (cpuPositions.containsAll(l)){
        return"cpu wins !sorry :(";
    }else if(playerPositions.size()+cpuPositions.size()==9){
        return "cat";
    }

}
// Return an empty string if there is no winner yet.
        return "";
    }
}
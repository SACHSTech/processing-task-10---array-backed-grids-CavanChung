import processing.core.PApplet;

public class Sketch extends PApplet {

  // int variables declared
  int intCellWidth = 20;
  int intCellHeight = 20;
  int intMargin = 5;
  int intRowCount = 10;
  int intColumnCount = 10;
  int intScreenWidth = intCellWidth * intColumnCount + intMargin * (intColumnCount + 1);
  int intScreenHeight = intCellHeight * intRowCount + intMargin * (intColumnCount + 1);

  // 2d array
  int[][] intGrid = new int[10][10];
  
  
  // set screen width and height based on grid size using math
  public void settings() {
    size(intScreenWidth, intScreenHeight);
  }

  public void setup() {
    background(0);
   
    
  }

  public void draw() {

    // creates the grid
    for (int intRow = 0; intRow < intRowCount; intRow++){
      for (int intColumn = 0; intColumn < intColumnCount; intColumn++){
        
        if (intGrid[intRow][intColumn] == 1){
          fill(0, 255, 0);
        } 
        else if (intGrid[intRow][intColumn] == 0){
          fill(255);
        }

        rect(intMargin + intMargin * intColumn + intCellWidth * intColumn, intMargin + intMargin * intRow + intCellHeight * intRow, intCellWidth, intCellHeight);
      
      }
    }
    
  }

    /**
    * If mouse is pressed turn white squares to green squares with the surrounding tiles turning with it
    *
    * @param mousePressed
    * 
    */

  public void mousePressed(){

    int intGridRow = (int)(mouseY / (intMargin + intCellHeight));
    int intGridColumn = (int)(mouseX / (intMargin + intCellWidth));

    // changes square to green on mouse click
    if (intGrid[intGridRow][intGridColumn] == 0) {
      intGrid[intGridRow][intGridColumn] = 1;
    }
    else if (intGrid[intGridRow][intGridColumn] == 1){
      intGrid[intGridRow][intGridColumn] = 0; 
    }

    // green square top
    if (intGridRow > 0 && intGrid[intGridRow - 1][intGridColumn] == 0) {
      intGrid[intGridRow - 1][intGridColumn] = 1;
    }
    else if (intGridRow > 0 && intGrid[intGridRow - 1][intGridColumn] == 1) {
      intGrid[intGridRow - 1][intGridColumn] = 0;
    }

    // green square bottom
    if (intGridRow > 0 && intGrid[intGridRow + 1][intGridColumn] == 0) {
      intGrid[intGridRow + 1][intGridColumn] = 1;
    }
    else if (intGridRow > 0 && intGrid[intGridRow + 1][intGridColumn] == 1) {
      intGrid[intGridRow + 1][intGridColumn] = 0;
    }

     // green square left
    if (intGridRow > 0 && intGrid[intGridRow][intGridColumn - 1] == 0) {
      intGrid[intGridRow][intGridColumn - 1] = 1;
    }
    else if (intGridRow > 0 && intGrid[intGridRow][intGridColumn - 1] == 1) {
      intGrid[intGridRow][intGridColumn - 1] = 0;
    }

     // green square right
    if (intGridRow > 0 && intGrid[intGridRow][intGridColumn + 1] == 0) {
      intGrid[intGridRow][intGridColumn + 1] = 1;
    }
    else if (intGridRow > 0 && intGrid[intGridRow][intGridColumn + 1] == 1) {
      intGrid[intGridRow][intGridColumn + 1] = 0;
    }
    
  }
}

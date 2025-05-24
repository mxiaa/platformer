package gamelogic.tiles;


import java.awt.image.BufferedImage;


import gameengine.hitbox.RectHitbox;
import gamelogic.level.Level;


public class Gas extends Tile{
    private int intensity;
    public Gas(float x, float y, int size, BufferedImage image, Level level, int intensity) {
   	 super(x, y, size, image, false, level);
   	 this.intensity = intensity;
   	 this.hitbox = new RectHitbox(x*size , y*size, 0, 10, size, size);
    }
    public int getIntensity() {
   	 return intensity;
    }
    public void setIntensity(int intensity) {
   	 this.intensity = intensity;
    }
    public void update(float tslf, BufferedImage image) {
   	 super.update(tslf);
   	 super.setImage(image);
    }
 
	//precondition: Starting block must be empty
	//postcondition: Adds gas tiles until the requisite number of squares are filled or there is no more room 
	private void addGas(int col, int row, Map map, int numSquaresToFill, ArrayList<Gas> placedThisRound) {

		//adds a gas block at starting position
    Gas g = new Gas (col, row, tileSize, tileset.getImage("GasOne"), this, 0);
    map.addTile(col, row, g);
    placedThisRound.add(g);
    numSquaresToFill--;

    while(placedThisRound.size() > 0 && numSquaresToFill > 0){
        Gas current = placedThisRound.remove(0);
        int currRow = current.getRow();
        int currCol = current.getCol();


        // gas block Up
        if(currRow - 1 < map.getTiles().length && !map.getTiles()[currCol][currRow - 1].isSolid() && !(map.getTiles()[currCol][currRow - 1] instanceof Gas) && numSquaresToFill > 0){
            Gas uG = new Gas (currCol, currRow - 1, tileSize, tileset.getImage("GasOne"), this, 0);
            map.addTile(currCol, currRow - 1, uG);
            placedThisRound.add(uG);
            numSquaresToFill--;
        }

        // gas block Up-right
        if(currCol + 1 < map.getTiles().length && !map.getTiles()[currCol + 1][currRow - 1].isSolid() && !(map.getTiles()[currCol + 1][currRow - 1] instanceof Gas) && numSquaresToFill > 0){
            Gas rUG = new Gas (currCol + 1, currRow - 1, tileSize, tileset.getImage("GasOne"), this, 0);
            map.addTile(currCol + 1, currRow - 1, rUG);
            placedThisRound.add(rUG);
            numSquaresToFill--;
        }

        //  gas block Up-left
        if(currCol - 1 < map.getTiles().length && !map.getTiles()[currCol - 1][currRow - 1].isSolid() && !(map.getTiles()[currCol - 1][currRow - 1] instanceof Gas) && numSquaresToFill > 0){
            Gas lUG = new Gas (currCol - 1, currRow - 1, tileSize, tileset.getImage("GasOne"), this, 0);
            map.addTile(currCol - 1, currRow - 1, lUG);
            placedThisRound.add(lUG);
            numSquaresToFill--;
        }

        // gas block Right
        if(currCol + 1 < map.getTiles().length && !map.getTiles()[currCol + 1][currRow].isSolid() && !(map.getTiles()[currCol + 1][currRow] instanceof Gas) && numSquaresToFill > 0){
            Gas rG = new Gas (currCol + 1, currRow, tileSize, tileset.getImage("GasOne"), this, 0);
            map.addTile(currCol + 1, currRow, rG);
            placedThisRound.add(rG);
            numSquaresToFill--;
        }

        // gas block Left
        if(currCol - 1 < map.getTiles().length && !map.getTiles()[currCol - 1][currRow].isSolid() && !(map.getTiles()[currCol - 1][currRow] instanceof Gas) && numSquaresToFill > 0){
            Gas lG = new Gas (currCol - 1, currRow, tileSize, tileset.getImage("GasOne"), this, 0);
            map.addTile(currCol - 1, currRow, lG);
            placedThisRound.add(lG);
            numSquaresToFill--;
        }

        // gas block Down
        if(currRow + 1 < map.getTiles().length && !map.getTiles()[currCol][currRow + 1].isSolid() && !(map.getTiles()[currCol][currRow + 1] instanceof Gas) && numSquaresToFill > 0){
            Gas dG = new Gas (currCol, currRow + 1, tileSize, tileset.getImage("GasOne"), this, 0);
            map.addTile(currCol, currRow + 1, dG);
            placedThisRound.add(dG);
            numSquaresToFill--;
        }

        // gas block Down-right
        if(currRow + 1 < map.getTiles().length && !map.getTiles()[currCol + 1][currRow + 1].isSolid() && !(map.getTiles()[currCol + 1][currRow + 1] instanceof Gas) && numSquaresToFill > 0){
            Gas dRG = new Gas (currCol + 1, currRow + 1, tileSize, tileset.getImage("GasOne"), this, 0);
            map.addTile(currCol + 1, currRow + 1, dRG);
            placedThisRound.add(dRG);
            numSquaresToFill--;
        }

        // gas block Down-left
        if(currRow + 1 < map.getTiles().length && !map.getTiles()[currCol - 1][currRow + 1].isSolid() && !(map.getTiles()[currCol - 1][currRow + 1] instanceof Gas) && numSquaresToFill > 0){
            Gas dLG = new Gas (currCol - 1, currRow + 1, tileSize, tileset.getImage("GasOne"), this, 0);
            map.addTile(currCol - 1, currRow + 1, dLG);
            placedThisRound.add(dLG);
            numSquaresToFill--;
		}
		else {}
	}
    }
	
}

import java.util.Arrays;

public class RemoveIslandFromMatrix {
    public static void main(String[] args) {
        int[][] islandArray = {{1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 0, 0, 1, 0}, {1, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 1}};
        int[][] noIslandArray = removeIslands(islandArray);
        System.out.println(Arrays.deepToString(noIslandArray));
    }

    public static int[][] removeIslands(int[][] arrayWithIslands) {
        int[][] newArray = new int[arrayWithIslands.length][arrayWithIslands[0].length];//arrayWithIslands.clone();
        for (int y = 0; y < arrayWithIslands.length; y++) {
            for (int x = 0; x < arrayWithIslands[0].length; x++) {
                if (newArray[y][x] != 1 && arrayWithIslands[y][x] == 1) {
                    newArray[y][x] = checkForSupport(arrayWithIslands, newArray, y, x,"none") ? 1 : 0;
                }
            }
        }
        return newArray;
    }

    public static boolean checkForSupport(int[][] originalArray, int[][] modifiedArray, int y, int x,String directionFrom) {
        if (y == 0 || y == originalArray.length - 1 || x == 0 || x == originalArray[0].length - 1) {
            return true;
        }
        boolean hasSupport = false;
        if ((!directionFrom.equals("top")) && y - 1 >= 0 && originalArray[y - 1][x] == 1 && checkForSupport(originalArray, modifiedArray, y - 1, x,"bottom")) {
            hasSupport = true;
        }
        if ((!directionFrom.equals("bottom")) && y + 1 < originalArray.length && originalArray[y + 1][x] == 1 && checkForSupport(originalArray, modifiedArray, y + 1, x,"top")) {
            hasSupport = true;
        }
        if ((!directionFrom.equals("left")) && x - 1 >= 0 && originalArray[y][x - 1] == 1 && checkForSupport(originalArray, modifiedArray, y, x - 1,"right")) {
            hasSupport = true;
        }
        if ((!directionFrom.equals("right")) && x + 1 < originalArray[0].length && originalArray[y][x+1] == 1 && checkForSupport(originalArray, modifiedArray, y, x + 1,"left")) {
            hasSupport = true;
        }
        if (hasSupport) {
            modifiedArray[y][x] = 1;
            return true;
        }
        return false;
    }
}


import java.util.*;
import java.awt.*;
import java.util.List;
// A class representing the digital creation of a painting attempting to recreate the Mondrian 
// style of art, which consists of different rectangles inside of each other, colored differently
public class Mondrian {
    private int randomLine(int upper, int lower) { 
        if (lower == 0) {
            lower += 2; // to counter for border at beginning
        }
        int valRange = upper - lower - 20;
        int retVal = (int)(Math.random() * (valRange) + (lower + 11));
        return retVal;
    }
    private Color randomColor() {
        int randomNum = (int)(Math.random() * 4);
        if(randomNum == 0) {
            return Color.RED;
        } else if (randomNum == 1) {
            return Color.YELLOW;
        } else if (randomNum == 2) {
            return Color.CYAN;
        } else {
            return Color.WHITE;
        }
    }

    private void paintBasicMondrian(Color[][] pixels, int iStart, int iEnd, int jStart, int jEnd) {
        int height = iEnd - iStart;
        int width = jEnd - jStart;
        int canvasHeight = pixels.length;
        int canvasWidth = pixels[0].length;
        if(height >= canvasHeight / 4 && width >= canvasWidth / 4) {
            int iSplit = randomLine(iEnd, iStart);
            int jSplit = randomLine(jEnd, jStart);
            paintBasicMondrian(pixels, iStart, iSplit, jStart, jSplit);
            paintBasicMondrian(pixels, iSplit, iEnd, jStart, jSplit);
            paintBasicMondrian(pixels, iStart, iSplit, jSplit, jEnd);
            paintBasicMondrian(pixels, iSplit, iEnd, jSplit, jEnd);
        } else if (height >= canvasHeight / 4) {
            int iSplit = randomLine(iEnd, iStart);
            paintBasicMondrian(pixels, iStart, iSplit, jStart, jEnd);
            paintBasicMondrian(pixels, iSplit, iEnd, jStart, jEnd);
        } else if (width >= canvasWidth / 4) {
            int jSplit = randomLine(jEnd, jStart);
            paintBasicMondrian(pixels, iStart, iEnd, jStart, jSplit);
            paintBasicMondrian(pixels, iStart, iEnd, jSplit, jEnd);
        } else { // filling rect
            Color fillColor = randomColor();
            // for borders 
            if(iStart == 0) {
                iStart += 2;
            }
            if(jStart == 0) {
                jStart += 2;
            }
            for(int i = iStart; i < iEnd - 2; i ++) {
                for(int j = jStart; j < jEnd - 2; j++) {    
                    pixels[i][j] = fillColor;
                }
            }
        } 
    }

    public void paintBasicMondrian(Color[][] pixels) {
        paintBasicMondrian(pixels, 0, pixels.length - 1, 0, pixels[0].length - 1); 
    }

    private List<Integer> randomSplits(int startIJ, int endIJ) {
        List<Integer> splits = new ArrayList<>();
        splits.add(startIJ);
        int i = 0;
        int tempStart = startIJ;
        int tempEnd = randomLine(endIJ, startIJ);
        while(i < 4 && tempEnd < endIJ) {
            if(endIJ - tempEnd < 10) {
                tempEnd = endIJ;
            }
            splits.add(tempEnd);
            tempStart = tempEnd;
            tempEnd = randomLine(endIJ, tempEnd);
            i++;
        }
        if(!splits.contains(endIJ)) {
            splits.add(endIJ);
        }
        return splits;
    }

    private void paintComplexMondrian(Color[][] pixels, int iStart, int iEnd, int jStart, 
            int jEnd) {
        int height = iEnd - iStart;
        int width = jEnd - jStart;
        int canvasHeight = pixels.length;
        int canvasWidth = pixels[0].length;
        if(height >= canvasHeight / 4 && width >= canvasWidth / 4) {
            List<Integer> iSplits = randomSplits(iStart, iEnd);
            List<Integer> jSplits = randomSplits(jStart, jEnd);
            for(int i = 0; i < iSplits.size() - 1; i++) {
                for(int j = 0; j < jSplits.size() - 1; j++) {
                    paintComplexMondrian(pixels, iSplits.get(i), iSplits.get(i + 1),
                        jSplits.get(j), jSplits.get(j + 1));
                }
            }
        } else if (height >= canvasHeight / 4) {
            List<Integer> iSplits = randomSplits(iStart, iEnd);
            for(int i = 0; i < iSplits.size() - 1; i++) {
                paintComplexMondrian(pixels, iSplits.get(i), iSplits.get(i + 1), 
                    jStart, jEnd);
            }
        } else if (width >= canvasWidth / 4) {
            List<Integer> jSplits = randomSplits(jStart, jEnd);
            for(int j = 0; j < jSplits.size() - 1; j++) {
                paintComplexMondrian(pixels, iStart, iEnd, jSplits.get(j), 
                    jSplits.get(j + 1));
            }
        } else { // filling rect
            Color fillColor = randomColor();
            // for borders 
            if(iStart == 0) {
                iStart += 2;
            }
            if(jStart == 0) {
                jStart += 2;
            }
            for(int i = iStart; i < iEnd - 2; i ++) {
                for(int j = jStart; j < jEnd - 2; j++) {    
                    pixels[i][j] = fillColor;
                }
            }
        } 
    }

    public void paintComplexMondrian(Color[][] pixels) {
        paintComplexMondrian(pixels, 0, pixels.length - 1, 0, pixels[0].length - 1); 
    }
    
}
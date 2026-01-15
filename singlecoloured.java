import java.util.*;

class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        // Use a TreeMap to store the net "width" change at each Y-coordinate
        // Key: Y-coordinate, Value: The total width of squares starting/ending here
        TreeMap<Double, Double> events = new TreeMap<>();

        for (int[] s : squares) {
            double y = s[1], l = s[2];
            double area = l * l;
            totalArea += area;
            
            // At y, the total width of squares being "cut" increases by l
            events.put(y, events.getOrDefault(y, 0.0) + l);
            // At y + l, that width contribution ends
            events.put(y + l, events.getOrDefault(y + l, 0.0) - l);
        }

        double targetArea = totalArea / 2.0;
        double currentArea = 0;
        double currentWidth = 0;
        double prevY = events.firstKey();

        for (Map.Entry<Double, Double> entry : events.entrySet()) {
            double currY = entry.getKey();
            double dy = currY - prevY;
            double areaInInterval = dy * currentWidth;

            // If adding this entire vertical slice exceeds the target, 
            // the line must be within this interval.
            if (currentArea + areaInInterval >= targetArea) {
                double neededArea = targetArea - currentArea;
                return prevY + (neededArea / currentWidth);
            }

            currentArea += areaInInterval;
            currentWidth += entry.getValue(); // Update the active width for the next slice
            prevY = currY;
        }

        return prevY;
    }
}

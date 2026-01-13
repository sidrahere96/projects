import java.util.Arrays;

class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = Arrays.stream(squares)
            .mapToDouble(s -> (double) s[2] * s[2])
            .sum();

        double low = Arrays.stream(squares).mapToDouble(s -> s[1]).min().orElse(0);
        double high = Arrays.stream(squares).mapToDouble(s -> s[1] + s[2]).max().orElse(2e9);

        while (high - low > 1e-7) {
            double mid = low + (high - low) / 2.0;
            if (getAreaBelow(squares, mid) >= totalArea / 2.0) high = mid;
            else low = mid;
        }

        return high;
    }

    private double getAreaBelow(int[][] squares, double line) {
        return Arrays.stream(squares)
            .mapToDouble(s -> {
                double y = s[1], l = s[2], top = y + l;
                return line <= y ? 0 : line >= top ? l * l : l * (line - y);
            })
            .sum();
    }
}
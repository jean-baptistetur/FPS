package com.jad.juniafps;

public class Screen {
    private final int height;
    private final int width;
    private final char[][] pixels;


    public Screen(final int height, final int width) {
        this.height = height;
        this.width = width;
        this.pixels = new char[this.height][this.width];
    }

    public String toStr() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < this.height; row++) {
            for (int column = 0; column < this.width; column++) {
                stringBuilder.append(this.pixels[row][column]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void verticalLine(final int numColumn, final int rowStart, final int rowEnd, final char pixel) {
        for (int row = rowStart; row < rowEnd; row++) {
            this.pixels[this.height - row - 1][numColumn] = pixel;
        }
    }
}

int maximalRectangle(char[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;
    int[] heights = new int[cols];

    int maxArea = 0;
    for (char[] row: matrix) {
        for (int j = 0; j < row.length; j++) {
            heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
        }
        maxArea = Math.max(maxArea, largestRectangleArea(heights));
    }
    
    return maxArea;
}

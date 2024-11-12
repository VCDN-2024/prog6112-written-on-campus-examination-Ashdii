
package moviesalesreport;

public class MovieTickets implements IMovieTickets {

    // Calculate total sales for a movie from its monthly sales array
    @Override
    public int calculateTotalSales(int[] movieTicketSales) {
        int total = 0;
        for (int sales : movieTicketSales) {
            total += sales;
        }
        return total;
    }
//Title: Swig Calculator
         //Author: Geekforgeeks
         //Date: 2024
         //URL: https://www.geeksforgeeks.org/java-swing-simple-calculator/
         //Accessed: 12 November 2024

    // Determine the top-performing movie based on total sales
    @Override
    public String topMovie(String[] movies, int[] totalSales) {
        int maxSalesIndex = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[maxSalesIndex]) {
                maxSalesIndex = i;
            }
        }
        return movies[maxSalesIndex];
    }
}

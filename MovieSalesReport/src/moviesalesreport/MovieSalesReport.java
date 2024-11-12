package moviesalesreport;

public class MovieSalesReport {

    public static void main(String[] args) {
        String[] movies = {"Napoleon", "Oppenheimer"};
        // Declaring Arrays 
        int[][] ticketSales = {
            {3000, 1500, 1700}, // Sales for Napoleon
            {3500, 1200, 1600}  // Sales for Oppenheimer
        };
        // Online site
         //Title: Adding values into DataPoint array
         //Author: Stack Overflow
         //Date: 2024
         //URL: https://stackoverflow.com/questions/41403318/adding-values-into-datapoint-array-causing-the-application-crash-while-running
         //Accessed: 12 November 2024


        MovieTickets movieTickets = new MovieTickets();
        int[] totalSales = new int[movies.length];

        // Calculate total sales for each movie
        for (int i = 0; i < movies.length; i++) {
            totalSales[i] = movieTickets.calculateTotalSales(ticketSales[i]);
        }

        // Determine the top-performing movie
        String topMovie = movieTickets.topMovie(movies, totalSales);

        // Display sales report with formatted output
        System.out.println("MOVIE SALES REPORT - 2024");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "MOVIE", "JANUARY", "FEBRUARY", "MARCH");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < movies.length; i++) {
            System.out.printf("%-15s %10d %10d %10d\n", movies[i],
                    ticketSales[i][0], ticketSales[i][1], ticketSales[i][2]);
        }

        System.out.println();
        for (int i = 0; i < movies.length; i++) {
            System.out.printf("Total ticket sales for %-10s = %d tickets\n", movies[i], totalSales[i]);
        }

        System.out.println();
        System.out.printf("Top performing movie: %s with %d tickets\n", topMovie, 
                          totalSales[movies[0].equals(topMovie) ? 0 : 1]);
    }
}

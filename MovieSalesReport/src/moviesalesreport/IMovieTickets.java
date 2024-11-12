
package moviesalesreport;

public interface IMovieTickets {
    int calculateTotalSales(int[] movieTicketSales);
    String topMovie(String[] movies, int[] totalSales);
}

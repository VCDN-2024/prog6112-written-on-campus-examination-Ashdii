
package movieticketsales;

import movieticketsales.MovieTicketSales.Data;

public interface IMovieTickets {
    boolean validateData(Data data);
    double calculateTotal(String ticketCount, String ticketPrice);
}


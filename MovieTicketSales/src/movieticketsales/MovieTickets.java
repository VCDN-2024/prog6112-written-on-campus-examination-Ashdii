
package movieticketsales;

import movieticketsales.MovieTicketSales.Data;


    
public class MovieTickets implements IMovieTickets {
    private static final double VAT_RATE = 0.14;

    @Override
    public boolean validateData(Data data) {
        try {
            int count = Integer.parseInt(data.getTicketCount());
            double price = Double.parseDouble(data.getTicketPrice());
            return !data.getMovie().isEmpty() && count > 0 && price > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public double calculateTotal(String ticketCount, String ticketPrice) {
        int count = Integer.parseInt(ticketCount);
        double price = Double.parseDouble(ticketPrice);
        double total = count * price;
        return total + (total * VAT_RATE);
    }
}


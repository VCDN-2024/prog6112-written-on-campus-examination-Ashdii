/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package movieticketsales;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 27691
 */
public class IMovieTicketsTest {
    
    public IMovieTicketsTest() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidateData() {
    }

    @Test
    public void testCalculateTotal() {
    }

    public class IMovieTicketsImpl implements IMovieTickets {

        public boolean validateData(MovieTicketSales.Data data) {
            return false;
        }

        public double calculateTotal(String ticketCount, String ticketPrice) {
            return 0.0;
        }
    }
    
}

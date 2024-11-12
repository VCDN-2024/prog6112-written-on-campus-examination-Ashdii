/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package moviesalesreport;

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
    public void testCalculateTotalSales() {
    }

    @Test
    public void testTopMovie() {
    }

    public class IMovieTicketsImpl implements IMovieTickets {

        public int calculateTotalSales(int[] movieTicketSales) {
            return 0;
        }

        public String topMovie(String[] movies, int[] totalSales) {
            return "";
        }
    }
    
}

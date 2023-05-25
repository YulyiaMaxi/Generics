import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulssTest {
    @Test
    public void testCompareByPrice() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spg", 15000, 12, 14);

        Ticket ticket2 = new Ticket("Msc", "Spg", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spg", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spg", 11000, 1, 3);

        Ticket ticket6 = new Ticket("Prs", "Spg", 50000, 12, 14);

        int actual = ticket2.compareTo(ticket5);
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareByPrice2() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spg", 15000, 12, 14);

        Ticket ticket2 = new Ticket("Msc", "Spg", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spg", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spg", 11000, 1, 3);

        Ticket ticket6 = new Ticket("Prs", "Spg", 50000, 12, 14);

        int actual = ticket2.compareTo(ticket6);
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareByPrice3() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spg", 15000, 12, 14);

        Ticket ticket2 = new Ticket("Msc", "Spg", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spg", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spg", 15000, 1, 3);

        Ticket ticket6 = new Ticket("Prs", "Spg", 50000, 12, 14);

        int actual = ticket5.compareTo(ticket1);
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spb", 15000, 12, 14);

        Ticket ticket2 = new Ticket("Msc", "Spb", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spb", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spb", 15000, 1, 3);

        Ticket ticket6 = new Ticket("Prs", "Spb", 50000, 12, 14);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Msc", "Spb");
        Ticket[] expected = {ticket1, ticket5, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch2() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spb", 15000, 12, 14);

        Ticket ticket2 = new Ticket("Msc", "Spb", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spb", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spb", 15000, 1, 3);

        Ticket ticket6 = new Ticket("Prs", "Spb", 50000, 12, 14);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Prs", "Spb");
        Ticket[] expected = {ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch3() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spb", 15000, 12, 14);

        Ticket ticket2 = new Ticket("Msc", "Spb", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spb", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spb", 15000, 1, 3);

        Ticket ticket6 = new Ticket("Prs", "Spb", 50000, 12, 14);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Prs", "Ekb");
        Ticket[] expected ={}; // здесь именно пустой массив должен выйти, а не null
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareByTime() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spg", 15000, 12, 13);

        Ticket ticket2 = new Ticket("Msc", "Spg", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spg", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spg", 11000, 1, 4);

        Ticket ticket6 = new Ticket("Prs", "Spg", 50000, 12, 14);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        int actual = comparator.compare(ticket5, ticket1);
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testCompareByTime2() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spg", 15000, 12, 13);

        Ticket ticket2 = new Ticket("Msc", "Spg", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spg", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spg", 11000, 1, 4);

        Ticket ticket6 = new Ticket("Prs", "Spg", 50000, 12, 14);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        int actual = comparator.compare(ticket2, ticket5);
        int expected = -1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testCompareByTime3() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spg", 15000, 12, 13);

        Ticket ticket2 = new Ticket("Msc", "Spg", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spg", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spg", 11000, 1, 4);

        Ticket ticket6 = new Ticket("Prs", "Spg", 50000, 12, 14);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        int actual = comparator.compare(ticket6, ticket2);
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSearchAndSortByTime() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Msc", "Spb", 15000, 12, 13);

        Ticket ticket2 = new Ticket("Msc", "Spb", 16500, 8, 10);

        Ticket ticket3 = new Ticket("Ny", "Chi", 30000, 12, 13);

        Ticket ticket4 = new Ticket("Ekb", "Spb", 9000, 10, 12);

        Ticket ticket5 = new Ticket("Msc", "Spb", 15000, 1, 4);

        Ticket ticket6 = new Ticket("Prs", "Spb", 50000, 12, 14);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();//надо в тестах прописать компаратор

        Ticket[] actual = manager.searchAndSortByTime("Msc", "Spb", comparator);
        Ticket[] expected = {ticket1, ticket2, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }


}

package ru.netology.ComparableandComparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Сочи", 10000, 10, 13);
    Ticket ticket2 = new Ticket("Москва", "Сочи", 8000, 8, 11);
    Ticket ticket3 = new Ticket("Москва", "Пермь", 7000, 15, 17);
    Ticket ticket4 = new Ticket("Москва", "Сочи", 15000, 06, 10);
    Ticket ticket5 = new Ticket("Калининград", "Москва", 7000, 18, 23);

    @Test
    public void ShouldCompareTwoTicketmoreTest() {

        int actual = ticket1.compareTo(ticket2);
        int expected = 2000;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldCompareTwoTicketlessTest() {

        int actual = ticket3.compareTo(ticket2);
        int expected = -1000;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldCompareTwoTicketeQuallyTest() {

        int actual = ticket5.compareTo(ticket3);
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSerchTicketsRandom() {

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] actual = aviaSouls.search("Москва", "Сочи");
        Ticket[] expected = {ticket2, ticket1, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSerchTicketsNotFound() {

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] actual = aviaSouls.search("Калининград", "Сочи");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSerchTicketsOneFound() {

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] actual = aviaSouls.search("Калининград", "Москва");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSerchTicketAndSortIncreasing() {

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket3);


        Ticket[] expected = {ticket2, ticket1, ticket4};
        Ticket[] actual = aviaSouls.search("Москва", "Сочи");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSerchTicketAndSortDecreasing() {

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket5);


        Ticket[] expected = {ticket2, ticket1, ticket4};
        Ticket[] actual = aviaSouls.search("Москва", "Сочи");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldCompareTicketTimeComparatormore() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        int actual = ticketTimeComparator.compare(ticket5, ticket1);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldCompareTicketTimeComparatorless() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        int actual = ticketTimeComparator.compare(ticket3, ticket4);
        int expected = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldCompareTicketTimeComparatorequally() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        int actual = ticketTimeComparator.compare(ticket1, ticket2);
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSerchTicketAndSortByTime() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket5);
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket2, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Сочи", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
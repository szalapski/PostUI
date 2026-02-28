

package com.eviware.soapui.security.boundary;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;

import static org.junit.Assert.assertTrue;

public class DateBoundaryTest {

    DateTimeBoundary dateBoundary;
    String today;

    @Before
    public void setUp() throws Exception {
        today = DateTimeBoundary.simpleDateFormat.get().format(Calendar.getInstance().getTime());
        dateBoundary = new DateTimeBoundary();
    }

    @Test
    public void testOutOfBoundaryMinExclusive() throws ParseException {
        String outOfBoundaryDate = dateBoundary.outOfBoundary(Boundary.MIN_EXCLISIVE, today);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(DateTimeBoundary.simpleDateFormat.get().parse(outOfBoundaryDate));
        calendar2.setTime(DateTimeBoundary.simpleDateFormat.get().parse(today));
        assertTrue(calendar1.before(calendar2) || calendar1.equals(calendar2));
    }

    @Test
    public void testOutOfBoundaryMaxExclusive() throws ParseException {
        String outOfBoundaryDate = dateBoundary.outOfBoundary(Boundary.MAX_EXCLISIVE, today);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(DateTimeBoundary.simpleDateFormat.get().parse(outOfBoundaryDate));
        calendar2.setTime(DateTimeBoundary.simpleDateFormat.get().parse(today));
        assertTrue(calendar1.after(calendar2) || calendar1.equals(calendar2));
    }

    @Test
    public void testOutOfBoundaryMinInclusive() throws ParseException {
        String outOfBoundaryDate = dateBoundary.outOfBoundary(Boundary.MIN_INCLISIVE, today);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(DateTimeBoundary.simpleDateFormat.get().parse(outOfBoundaryDate));
        calendar2.setTime(DateTimeBoundary.simpleDateFormat.get().parse(today));
        assertTrue(calendar1.before(calendar2));
    }

    @Test
    public void testOutOfBoundaryMaxInclusive() throws ParseException {
        String outOfBoundaryDate = dateBoundary.outOfBoundary(Boundary.MAX_INCLISIVE, today);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(DateTimeBoundary.simpleDateFormat.get().parse(outOfBoundaryDate));
        calendar2.setTime(DateTimeBoundary.simpleDateFormat.get().parse(today));
        assertTrue(calendar1.after(calendar2));
    }

}

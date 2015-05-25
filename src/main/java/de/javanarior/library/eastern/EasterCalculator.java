/*
 * Copyright (C) 2015 Sven von Pluto - javanarior (a) gmail dot com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.javanarior.library.eastern;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calculate easter and feast days based on easter.
 */
public class EasterCalculator {

    private static final int OFFSET_SHROVE_MONDAY = -48;
    private static final int OFFSET_SHROVE_TUESDAY = -47;
    private static final int OFFSET_ASH_WEDNESDAY = -46;
    private static final int OFFSET_MAUNDY_THURSDAY = -3;
    private static final int OFFSET_GOOD_FRIDAY = -2;
    private static final int OFFSET_EASTER_MONDAY = 1;
    private static final int OFFSET_ASCENSION_DAY = 39;
    private static final int OFFSET_WHIT_SUNDAY = 49;
    private static final int OFFSET_WHIT_MONDAY = 50;
    private static final int OFFSET_CORPUS_CHRISTI = 60;

    /**
     * Returns the year of {@code date}.
     *
     * @param calendar
     *            - date to read year from
     * @return year
     */
    public static int yearOf(Calendar calendar) {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * Returns the year of {@code date}.
     *
     * @param date
     *            - date to read year from
     * @return year
     */
    public static int yearOf(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        return yearOf(calender);
    }

    /* Rosenmontag */
    /**
     * Calculates Shrove Monday in {@code year}.
     *
     * @param year
     *            - year of Shrove Monday
     * @return Shrove Monday
     */
    public Calendar shroveMonday(int year) {
        return calculate(year, OFFSET_SHROVE_MONDAY);
    }

    /* Fastnachtsdienstag */
    /**
     * Calculates Shrove Tuesday in {@code year}.
     *
     * @param year
     *            - year of Shrove Tuesday
     * @return Shrove Tuesday
     */
    public Calendar shroveTuesday(int year) {
        return calculate(year, OFFSET_SHROVE_TUESDAY);
    }

    /* Aschermittwoch */
    /**
     * Calculates Ash Wednesday in {@code year}.
     *
     * @param year
     *            - year of Ash Wednesday
     * @return Ash Wednesday
     */
    public Calendar ashWednesday(int year) {
        return calculate(year, OFFSET_ASH_WEDNESDAY);
    }

    /* Gründonnerstag */
    /**
     * Calculates Maundy Thursday in {@code year}.
     *
     * @param year
     *            - year of Maundy Thursday
     * @return Maundy Thursday
     */
    public Calendar maundyThursday(int year) {
        return calculate(year, OFFSET_MAUNDY_THURSDAY);
    }

    /* Karfreitag */
    /**
     * Calculates Good Friday in {@code year}.
     *
     * @param year
     *            - year of Good Friday
     * @return Good Friday
     */
    public Calendar goodFriday(int year) {
        return calculate(year, OFFSET_GOOD_FRIDAY);
    }

    /**
     * Calculates Easter Sunday in {@code year}.
     *
     * @param year
     *            - year of Easter Sunday
     * @return Easter Sunday
     */
    public Calendar easterSunday(int year) {
        GregorianCalendar easterSunday = internalEasterSunday(year);
        return easterSunday;
    }

    /**
     * Calculates Easter Monday in {@code year}.
     *
     * @param year
     *            - year of Easter Monday
     * @return Easter Monday
     */
    public Calendar easterMonday(int year) {
        return calculate(year, OFFSET_EASTER_MONDAY);
    }

    /* Christi Himmelfahrt */
    /**
     * Calculates Ascension Day in {@code year}.
     *
     * @param year
     *            - year of Ascension Day
     * @return Ascension Day
     */
    public Calendar ascensionDay(int year) {
        return calculate(year, OFFSET_ASCENSION_DAY);
    }

    /* Pfingstsonntag */
    /**
     * Calculates Whit Sunday in {@code year}.
     *
     * @param year
     *            - year of Whit Sunday
     * @return Whit Sunday
     */
    public Calendar whitSunday(int year) {
        return calculate(year, OFFSET_WHIT_SUNDAY);
    }

    /* Pfingstmontag */
    /**
     * Calculates Whit Monday in {@code year}.
     *
     * @param year
     *            - year of Whit Monday
     * @return Whit Monday
     */
    public Calendar whitMonday(int year) {
        return calculate(year, OFFSET_WHIT_MONDAY);
    }

    /* Fronleichnam */
    /**
     * Calculates Corpus Christi in {@code year}.
     *
     * @param year
     *            - year of Corpus Christi
     * @return Corpus Christi
     */
    public Calendar corpusChristi(int year) {
        return calculate(year, OFFSET_CORPUS_CHRISTI);
    }


    /* Buß- und Bettag, Buß- und Bettag: Mittwoch vor dem 23. November */
    /**
     * Calculates Penance Day in {@code year}.
     *
     * @param year
     *            - year of Penance Day
     * @return Penance Day
     */
    public Calendar penanceDay(int year) {
        Calendar penanceDay = Calendar.getInstance();
        /* CHECKSTYLE:OFF */
        penanceDay.set(year, Calendar.NOVEMBER, 23);
        /* CHECKSTYLE:ON */
        do {
            penanceDay.add(Calendar.DAY_OF_MONTH, -1);
        } while (penanceDay.get(Calendar.DAY_OF_WEEK) != Calendar.WEDNESDAY);
        return penanceDay;
    }





    private GregorianCalendar internalEasterSunday(int year) {
        int dateInMarch = OsterFormel.berechne(year);
        GregorianCalendar easterSunday = new GregorianCalendar();
        easterSunday.set(year, GregorianCalendar.MARCH, dateInMarch);
        return easterSunday;
    }

    private Calendar calculate(int year, int days) {
        GregorianCalendar newDate = internalEasterSunday(year);
        newDate.add(GregorianCalendar.DAY_OF_MONTH, days);
        newDate.setLenient(false);
        return newDate;
    }

}

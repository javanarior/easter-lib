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

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EasterCalculatorTest {

    private static final int YEAR_2015 = 2015;

    private EasterCalculator calculator;

    @BeforeMethod
    public void setUp() {
        this.calculator = new EasterCalculator();
    }

    @Test
    public void testYearOfCalendar() {
        Calendar year2015 = Calendar.getInstance();
        year2015.set(Calendar.YEAR, YEAR_2015);
        assertEquals(EasterCalculator.yearOf(year2015), 2015);
    }

    @Test
    public void testYearOfDate() {
        Calendar year2015 = Calendar.getInstance();
        year2015.set(Calendar.YEAR, YEAR_2015);
        assertEquals(EasterCalculator.yearOf(year2015.getTime()), 2015);
    }

    @Test
    public void testShroveMonday() {
        assertEquals(format(calculator.shroveMonday(YEAR_2015)), "2015-02-16");
    }

    @Test
    public void testShroveTuesday() {
        assertEquals(format(calculator.shroveTuesday(YEAR_2015)), "2015-02-17");
    }

    @Test
    public void testAshWednesday() {
        assertEquals(format(calculator.ashWednesday(YEAR_2015)), "2015-02-18");
    }

    @Test
        public void testMaundyThursday() {
            assertEquals(format(calculator.maundyThursday(YEAR_2015)), "2015-04-02");
        }

    @Test
    public void testGoodFriday() {
        assertEquals(format(calculator.goodFriday(YEAR_2015)), "2015-04-03");
    }

    @Test
    public void testEasterSunday() {
        assertEquals(format(calculator.easterSunday(YEAR_2015)), "2015-04-05");
    }

    @Test
    public void testEasterSunday2008() {
        assertEquals(format(calculator.easterSunday(2008)), "2008-03-23");
    }

    @Test
    public void testEasterMonday() {
        assertEquals(format(calculator.easterMonday(YEAR_2015)), "2015-04-06");
    }

    @Test
    public void testAscensionDay() {
        assertEquals(format(calculator.ascensionDay(YEAR_2015)), "2015-05-14");
    }

    @Test
    public void testWhitSunday() {
        assertEquals(format(calculator.whitSunday(YEAR_2015)), "2015-05-24");
    }

    @Test
    public void testWhitMonday() {
        assertEquals(format(calculator.whitMonday(YEAR_2015)), "2015-05-25");
    }

    @Test
    public void testCorpusChristi() {
        assertEquals(format(calculator.corpusChristi(YEAR_2015)), "2015-06-04");
    }

    @Test
    public void testPenanceDay() {
        assertEquals(format(calculator.penanceDay(YEAR_2015)), "2015-11-18");
    }

    @Test
    public void testPenanceDaySeedDateAtWednsday() {
        assertEquals(format(calculator.penanceDay(2016)), "2016-11-16");
    }

    private String format(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(calendar.getTime());
    }
}

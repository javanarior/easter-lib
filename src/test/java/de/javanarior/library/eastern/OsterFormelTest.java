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

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class OsterFormelTest {

    public void testBerechne2011() {
        Assert.assertEquals(OsterFormel.berechne(2011), 55);
    }

    public void testBerechne2008() {
        Assert.assertEquals(OsterFormel.berechne(2008), 23);
    }

    public void testBerechne1991() {
        Assert.assertEquals(OsterFormel.berechne(1991), 31);
    }

    public void testBerechne1989() {
        assertEquals(OsterFormel.berechne(1989), 26);
    }

    public void testBerechne1981() {
        assertEquals(OsterFormel.berechne(1981), 50);
    }

    public void testBerechne1954() {
        assertEquals(OsterFormel.berechne(1954), 49);
    }

    public void testSaekularzahl() {
        assertEquals(OsterFormel.saekularzahl(2011), 20);
    }

    public void testSaekularzahl81() {
        assertEquals(OsterFormel.saekularzahl(1981), 19);
    }

    public void testSaekulareMondschaltung81() {
        assertEquals(OsterFormel.saekulareMondschaltung(19), 24);
    }

    public void testSaekulareSonnenschaltung81() {
        assertEquals(OsterFormel.saekulareSonnenschaltung(19), -13);
    }

    public void testMondParameter81() {
        assertEquals(OsterFormel.mondParameter(1981), 5);
    }

    public void testKeimErsterVollmond81() {
        assertEquals(OsterFormel.keimErsterVollmond(5, 24), 29);
    }

    public void testKalendarischeKorrektur81() {
        assertEquals(OsterFormel.kalendarischeKorrektur(29, 5), 1);
    }

    public void testOsterGrenze81() {
        assertEquals(OsterFormel.osterGrenze(29, 1), 49);
    }

    public void testErstenSonntagImMaerz81() {
        assertEquals(OsterFormel.erstenSonntagImMaerz(1981, -13), 1);
    }

    public void testOsterEntfernungInTagen81() {
        assertEquals(OsterFormel.osterEntfernungInTagen(49, 1), 1);
    }

    public void testOstersonntagsAlsMaerzDatum81() {
        assertEquals(OsterFormel.ostersonntagsAlsMaerzDatum(49, 1), 50);
    }

}

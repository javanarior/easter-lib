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

/**
 * Calculate easter Sunday as date in march.
 * <ul>
 * <li>https://www.ptb.de/cms/fachabteilungen/abt4/fb-44/ag-441/darstellung-der-
 * gesetzlichen-zeit/wann-ist-ostern.html</li>
 * <li>http://de.wikipedia.org/wiki/Gau%C3%9Fsche_Osterformel#Eine_erg.C3.
 * A4nzte_Osterformel</li>
 * </ul>
 */
final class OsterFormel {

    /**
     * Utility class.
     */
    private OsterFormel() {
        /* Utility class */
    }

    static int berechne(int year) {
        int saekularzahl = saekularzahl(year);
        int saekulareMondschaltung = saekulareMondschaltung(saekularzahl);
        int saekulareSonnenschaltung = saekulareSonnenschaltung(saekularzahl);
        int mondParameter = mondParameter(year);
        int keimErsterVollmond = keimErsterVollmond(mondParameter, saekulareMondschaltung);
        int kalendarischeKorrektur = kalendarischeKorrektur(keimErsterVollmond, mondParameter);
        int ostergrenze = osterGrenze(keimErsterVollmond, kalendarischeKorrektur);
        int erstenSonntagImMaerz = erstenSonntagImMaerz(year, saekulareSonnenschaltung);
        int osterEntfernungInTagen = osterEntfernungInTagen(ostergrenze, erstenSonntagImMaerz);
        return ostersonntagsAlsMaerzDatum(ostergrenze, osterEntfernungInTagen);
    }

    static int saekularzahl(int year) {
        return toInt(year / 100);
    }

    static int saekulareMondschaltung(int saekularzahl) {
        return 15 + toInt((3 * saekularzahl + 3) / 4) - toInt((8 * saekularzahl + 13) / 25);
    }

    static int saekulareSonnenschaltung(int saekularzahl) {
        return 2 - toInt((3 * saekularzahl + 3) / 4);
    }

    static int mondParameter(int year) {
        return mod(year, 19);
    }

    static int keimErsterVollmond(int mondParameter, int saekulareMondschaltung) {
        return mod(19 * mondParameter + saekulareMondschaltung, 30);
    }

    static int kalendarischeKorrektur(int keimErsterVollmond, int mondParameter) {
        return toInt(keimErsterVollmond / 29) + (toInt(keimErsterVollmond / 28) - toInt(keimErsterVollmond / 29))
                        * toInt(mondParameter / 11);
    }

    static int osterGrenze(int keimErsterVollmond, int kalendarischeKorrektur) {
        return 21 + keimErsterVollmond - kalendarischeKorrektur;
    }

    static int erstenSonntagImMaerz(int year, int saekulareSonnenschaltung) {
        return 7 - mod(year + toInt(year / 4) + saekulareSonnenschaltung, 7);
    }

    static int osterEntfernungInTagen(int ostergrenze, int erstenSonntagImMaerz) {
        return 7 - mod(ostergrenze - erstenSonntagImMaerz, 7);
    }

    static int ostersonntagsAlsMaerzDatum(int ostergrenze, int osterEntfernungInTagen) {
        return ostergrenze + osterEntfernungInTagen;
    }

    private static int toInt(double fraction) {
        return (int)fraction;
    }

    private static int mod(int dividend, int divisor) {
        return dividend % divisor;
    }

}

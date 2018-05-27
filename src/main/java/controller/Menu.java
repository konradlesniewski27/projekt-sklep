package controller;

import model.Dron;
import model.Komputer;
import model.Produkt;
import model.Sklep;
import pliki.OperacjePlikowe;
import pliki.PlikiBinarne;
import pliki.PlikiJson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {
    public void wyswietlMenu() {



        Scanner scanner = new Scanner(System.in);
        //utworz pusty sklep
        // odczyt z pliku
        System.out.println("Podaj sposob zapisu pliku");
        System.out.println("1 - Json");
        System.out.println("2 - binarnie");

        String wyborPliku = scanner.nextLine();
        OperacjePlikowe pliki;

        switch (wyborPliku){
            case "1" :
                 pliki = new PlikiJson();
                break;
            case "2" :
                 pliki = new PlikiBinarne();
                break;
            default:
                pliki = new PlikiJson();
                break;
        }

      //  PlikiBinarne plikiBinarne = new PlikiBinarne();
        //PlikiJson pliki = new PlikiJson();
        Sklep sklep;
        try {
            sklep = pliki.wczytaj();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Blad, startujemy z nowym sklepem");
            sklep = new Sklep("www.emag.pl");
        }


        System.out.println("1 - dodaj komputer ");
        System.out.println("2 - usun ");
        System.out.println("3 - wyswietl liste produktow");
        System.out.println("4 - dodaj drona");
        System.out.println("5 - wyswietl posortowane cenowo");
        System.out.println("6 - wyswietl posortowane po nazwe");
        System.out.println("q - wyjdz");
        String wybor;

        do {
            System.out.println("Podaj wybor: ");
            wybor = scanner.nextLine();
            //wczytaj wybor uzytkownika


            switch (wybor) {
                case "1": {

                    System.out.println("Wybrales komputer - Podaj nazwe;");
                    String nazwa = scanner.nextLine();
                    System.out.println("podaj cene: ");
                    BigDecimal cena = scanner.nextBigDecimal();
                    //scanner.nextInt();
                    System.out.println("Podaj marke: ");
                    String marka = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("podaj ilosc ram: ");
                    int ram = scanner.nextInt();
                    scanner.nextLine();

                    Komputer komputer = new Komputer(nazwa, cena, marka, ram);


                    sklep.dodaj(komputer);


                    // wczytywanie informacji o komputerze
                    // stworzyć obiekt typu komputer
                    // wywołac metode dodaj komputer klasy sklep

                    break;
                }
                case "2":
                    System.out.println("Podaj id do usuniecia: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();

                    sklep.usun(id);
                    //wczytaj id do usuniecia
                    // wywolac metode usunKomputer klasy Sklep

                    break;
                case "3":
                    //wywyolac metode wyswietl klasy sklep
                    sklep.wyswietl();

                    break;

                case "4": {
                    System.out.println("Wybrales drona - Podaj nazwe;");
                    String nazwa = scanner.nextLine();
                    System.out.println("podaj cene: ");
                    BigDecimal cena = scanner.nextBigDecimal();
                    System.out.println("Podaj zasieg: ");
                    double zasieg = scanner.nextDouble();
                    System.out.println("Kamerka tak lub nie: ");
                    boolean czyMaKamere = scanner.nextBoolean();
                    scanner.nextLine();

                    Dron dron = new Dron(nazwa, cena, zasieg, czyMaKamere);

                    sklep.dodaj(dron);
                    break;
                }
                case "5" :
                    sklep.wyswietlPosortowaneCenowo();
                    break;
                case "6" :
                    sklep.wyswietlPosortowanePoNazwie();
                    break;
                case "q":
                case "Q":
                    System.out.println("Koniec");
                    // zapis do pliku
                    try{
                        pliki.zapisz(sklep);
                    } catch (Exception e) {
                        System.out.println("blad zapisu do pliku");
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Bład");
                    break;
            }


        } while (!wybor.equalsIgnoreCase("q"));
    }
}
package model;


import java.io.Serializable;
import java.util.*;

public class Sklep implements Serializable {

    //skladowe
    private Collection<Produkt> produktyy;
    private String nazwa;

    public Sklep() {}

    public Sklep(String nazwa){
        this.produktyy = new ArrayList<>();
        this.nazwa = nazwa;
    }


    //metody
    public void dodaj(Produkt produkt){
        produktyy.add(produkt);

    }

    public void usun(long id){
        Iterator<Produkt> iterator = produktyy.iterator();
        while(iterator.hasNext()) {
            Produkt produkt = iterator.next(); // pobieranie elementu z listy komputer
            if (produkt.getId() == id){
                iterator.remove();
            }

        }

    }

    public void wyswietl(){
        for (Produkt tmp : produktyy){
            System.out.println(tmp);
        }

    }

    public void wyswietlPosortowaneCenowo() {
        List<Produkt> kopiaProduktu = new ArrayList<>(produktyy);
        Collections.sort(kopiaProduktu);
        for ( Produkt tmp : kopiaProduktu){
            System.out.println(tmp);
        }
    }

    public void wyswietlPosortowanePoNazwie() {

        Comparator<Produkt> nazwaKomparator = new Comparator<Produkt>() {
            @Override
            public int compare(Produkt o1, Produkt o2) {
                if ( o1.nazwa.compareTo(o2.nazwa) < 0){
                    return  -1;
                }if (o1.nazwa.compareTo(o2.nazwa) > 0){
                    return  1;
                }else{
                    return  0;
                }
            }
        };

        List<Produkt> kopiaProduktu = new ArrayList<>(produktyy);
        Collections.sort(kopiaProduktu, nazwaKomparator);
        for (Produkt tmp : kopiaProduktu) {
            System.out.println(tmp);
        }

    }

    public Collection<Produkt> getProduktyy() {
        return produktyy;
    }

    public String getNazwa() {
        return nazwa;
    }
}


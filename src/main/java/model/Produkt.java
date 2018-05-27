package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.math.BigDecimal;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typ")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Komputer.class, name = "komputer"),
        @JsonSubTypes.Type(value = Dron.class, name = "dron")
}
)
public abstract class Produkt implements Comparable<Produkt>, Serializable {

    protected long id;
    protected String nazwa;
    protected BigDecimal cena;

    public Produkt() {}

    private static long generatorId = 0L;

    public Produkt(String nazwa, BigDecimal cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        generatorId++;
        this.id = generatorId;
    }

    public long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    @Override
    public int compareTo(Produkt o) {
        if(this.cena.compareTo(o.cena) < 0) {
            return  -1;
        }else if( this.cena.compareTo(o.cena) > 0){
            return 1;
        }else {
            return 0;
        }

    }
}

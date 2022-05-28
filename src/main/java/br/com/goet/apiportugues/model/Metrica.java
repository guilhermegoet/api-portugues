package br.com.goet.apiportugues.model;

public class Metrica {
    public int id;
    public String silaba;
    public String palavra;
    public String tipo;
    public boolean tonica;
    public boolean ehsilabaTonica;

    public Metrica(int id, String silaba, String palavra, String tipo, boolean tonica, boolean ehsilabaTonica) {
        this.id = id;
        this.silaba = silaba;
        this.palavra = palavra;
        this.tipo = tipo;
        this.tonica = tonica;
        this.ehsilabaTonica = ehsilabaTonica;
    }

    public Metrica() {

    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEhsilabaTonica() {
        return ehsilabaTonica;
    }

    public void setEhsilabaTonica(boolean ehsilabaTonica) {
        this.ehsilabaTonica = ehsilabaTonica;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSilaba() {
        return silaba;
    }

    public void setSilaba(String silaba) {
        this.silaba = silaba;
    }

    public boolean isTonica() {
        return tonica;
    }

    public void setTonica(boolean tonica) {
        this.tonica = tonica;
    }
}


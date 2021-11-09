package model; 


public abstract class Product{

    private String name;
    private String nameDirector;
    private String synopsis;
    private Date releaseDate;


    
    //constructor

    public Product(String name, String nameDirector, String synopsis, Date releaseDate){

        this.name=name;
        this.nameDirector=nameDirector;
        this.synopsis=synopsis;
        this.releaseDate=releaseDate;

    }

    //getters and setters

    public String getName(){

        return name;

    }

    public String getNameDirector(){

        return nameDirector;

    }

    public void setNameDirector(String nameDirector){

        this.nameDirector=nameDirector;

    }

    public String getSynopsis(){

        return nameDirector;

    }

    public void setSynopsis(String synopsis){

        this.synopsis=synopsis;

    }

    public Date getReleaseDate(){

        return releaseDate;

    }

    public abstract String exampleClase(int par);

    public String toString(){

        String result="Nombre: " + name +"\n"+
        "Nombre del director: " + nameDirector +"\n"+
        "Sinopsis: " + synopsis +"\n"+
        "Fecha de estreno: " + releaseDate+"\n";
        
        return result;
    }


}
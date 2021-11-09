package model; 


public class Movie extends Product{

    private String originalTitleName;
    private String producer;
    private int minAge;
    private String trailer;

    //relationship

    private Genre category;


    //constructor

    public Movie(String name, String nameDirector, String synopsis,String originalTitleName, String producer, int minAge, String trailer, Date releaseDate, Genre category){
       
        super(name, nameDirector, synopsis, releaseDate);

        this.originalTitleName=originalTitleName;
        this.producer=producer;
        this.minAge=minAge;
        this.trailer=trailer;
        this.category=category;
        

    }

    //getters and setters 

    public String getOriginalTitleName(){

        return originalTitleName;

    }

    public void setOriginalTitleName(String originalTitleName){

        this.originalTitleName=originalTitleName;

    }

    public String getProducer(){

        return producer;

    }

    public void setProducer(String producer){

        this.producer=producer;

    }

    public int getMinAge(){

        return minAge;

    }

    public void setMinAge(int minAge){

        this.minAge=minAge;

    }

    public String getTrailer(){

        return trailer;

    }

    public void setTailer(String trailer){

        this.trailer=trailer;

    }

    public Genre getCategory(){

        return category;

    }

    public void setCategory(Genre category){

        this.category=category;

    }


    @Override
    public String exampleClase(int par){
        return "Está es una pelicula "+par;
    }


    @Override
    public String toString(){

        String result =super.toString();

        result += "Nombre original: " + originalTitleName +"\n"+
        "Productor/a: " + producer +"\n"+
        "Edad minima permitida: " + minAge +"\n"+
        "Link trailer: " + trailer +"\n";

        return result;
    }

}
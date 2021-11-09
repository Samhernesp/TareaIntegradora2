package model; 


public class Season{

    private int numPublishedChapters;
    private int numProgramChapters;
    private String trailer;

    //relationship

    private Date releaseDate;

    // constructor

    public Season(int numProgramChapters,int numPublishedChapters,String trailer, Date releaseDate){

        this.numPublishedChapters=numPublishedChapters;
        this.numProgramChapters=numProgramChapters;
        this.trailer=trailer;
        this.releaseDate=releaseDate;

    }

    //getters and setters 

    public int getNumPublishedChapters(){

        return numPublishedChapters;

    }

    public void setNumPublishedChapters(int numPublishedChapters){

        this.numPublishedChapters=numPublishedChapters;

    }

    public int getNumProgramChapters(){

        return numProgramChapters;

    }

    public void setNumProgramChapters(int numProgramChapters){

        this.numProgramChapters=numProgramChapters;

    }

    public String getTrailer(){

        return trailer;

    }

    public void setTrailer(String trailer){

        this.trailer=trailer;

    }

    public Date getReleaseDate(){

        return releaseDate;

    }

    public void setReleaseDate(Date releaseDate){

        this.releaseDate=releaseDate;

    }

    public String toString(){

        String result = "Número de capitulos programados: " + numProgramChapters +"\n"+
        "Número de capitulos publicados: " + numPublishedChapters +"\n"+
        "Link trailer: " + trailer +"\n";
        return result;
    }


    
}
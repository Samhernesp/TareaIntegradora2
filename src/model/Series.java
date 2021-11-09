package model; 


public class Series extends Product{

    private String mainCharactersNames;
    private int cantSeason = 1;

    

    
    //relationship

    private Season[] season;
   
    private Censure censure;

    private final int numSeason=100;

    //constructor

    public Series(String name,String nameDirector, String synopsis, String mainCharactersNames, Censure censure, Date releaseDate,Season firstSeason){

        super(name, nameDirector, synopsis, releaseDate);
        this.mainCharactersNames=mainCharactersNames;
        this.censure=censure;
        season= new Season[numSeason];
        season[0]=firstSeason;

    }

    //getters and setters

    public String getMainCharactersNames(){

        return mainCharactersNames;

    }

    public void setMainCharactersNames(String mainCharactersNames){

       this.mainCharactersNames=mainCharactersNames;

    }

    public Censure getCensure(){

        return censure;

    }

    public void setCensure(Censure censure){

        this.censure=censure;

    }

    public int getCantSeason(){
        return cantSeason;
    }

    /**
	 * Descripcion: El método addSeason crea un nuevo objeto Season con los parametros correspondientes y lo guarda en la posicion cantSeason y suma uno a esta misma variable.</br>
	 * @param <numProgramChapters><int>
	 * @param <numPublishedChapters><int>
	 * @param <trailer><String>
	 * @param <date><Date>
	 * */

    public void addSeason(int numProgramChapters,int numPublishedChapters,String trailer,Date date){

        season[cantSeason]=new Season(numProgramChapters,numPublishedChapters,trailer,date);

        cantSeason++;

    }

    /**
	 * Descripcion: El método getSeason recorre el arreglo de temporadas y va guardando la informacion de cada temporada para luego retornarla</br>
	 * @return <result><String>
	 * */

    public String getSeason(){

        String result="";

        for (int i = 0; i <= cantSeason; i++) {

            if (season[i]!=null) {

                Season assis=season[i];

                result+="Temporada: "+(i+1)+"\n"+assis.toString();

            }
        }

        return result;

    }

    /**
	 * Descripcion: El método getLastSeason recorre inversamente el arreglo y retorna la primera posicion llena que encuentra, que es la ultima temporada de cada serie.</br>
	 * @return <result><String>
	 * */

    public String getLastSeason(){

        String result="";
        boolean flag=false;

        for (int i = cantSeason; i > -1 && !flag; i--) {

            if (season[i]!=null) {

                Season assis=season[i];
                result= "Ultima temporada: "+(i+1)+"\n"+ assis.toString()+"Fecha de estreno: "+assis.getReleaseDate()+"\n";
                flag=true;

            }
            

        }
        return result;

    }

    @Override
    public String exampleClase(int par){
        return "Está es una serie"+(par+10);
    }

    @Override
    public String toString(){

        String result =super.toString();

        result+= "Personajes principales: " + mainCharactersNames +"\n"+
        "Censura: " + censure +"\n";

        return result;
    } 

}
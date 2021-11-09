package model;


public class BlackSnail{

	private String nit; 
	private String address; 
	private String website; 
	private final int numSuscribers=50;
	private final int numProducts=85;

	//relationships

	private Suscriber[] suscribers;
	private Product[] catalog;


	//Methods

	public BlackSnail(String nit, String address, String website){

		this.nit = nit;
		this.address = address;
		this.website = website;

		suscribers = new Suscriber[numSuscribers];
		catalog = new Product[numProducts];

	}

	public String showExample(int par){
		
		String out = "";

		for (int i=0; i<numProducts; i++) {

			if (catalog[i]!=null) {

				out+= catalog[i].exampleClase(par);

			}
			
		}

		return out;

	}

	public String getNit(){

		return nit;

	}

	public void setNit(String nit){

		this.nit = nit;
	}

	public String getAddress(){

		return address;

	}

	public void setAddress(String address){

		this.address = address;
	}

	public String getWebsite(){

		return website;

	}

	public void setWebsite(String website){

		this.website = website;
	}

	public String toString(){

		return "Nit : " + nit + "\n" + 
		"Direccion : " + address + "\n" +
		"Sitio Web : " + website + "\n" ;

	}

	/**
	 * Descripcion: El método verifySuscriber evalua el valor retornado por hasSpaceSuscribers para determinar si hay espacio libre para crear suscriptores</br>
	 * @return <out><boolean>,retorna falso o verdadero si existe una posicion en el arreglo para colocar nuevos suscriptores.
	 * */

	public boolean verifySuscriber(){

		boolean out=false; 

		int res= hasSpaceSuscribers();

		if (res >= 0 ) {
			out= true;
		}

		return out;

	}

	/**
	 * Descripcion: El método hasSpaceSuscribers evalua todas las posiciones del arreglo para encontrar una que está vacia.</br>
	 * @return <space><int>,retorna una posicion vacia en la que se pueda crear un suscriptor.
	 * */

	public int hasSpaceSuscribers(){

		int space=-1;
		boolean flag=false;

		for (int i=0; i<numSuscribers && !flag ;i++ ) {

			if (suscribers[i]==null) {

				space=i;
				flag=true;
			}
			
		}

		return space;

	}

	/**
	 * Descripcion: El método hasSuscribers evalua todas las posiciones del arreglo para encontrar una que está vacia.</br>
	 * @return <flag><boolean>,retorna verdadero si se encuentran posiciones del arreglo que estén llenas, en caso contrario retorna falso.
	 * */

	public boolean hasSuscribers(){

		boolean flag=false;

		for (int i=0; i<numSuscribers && !flag ;i++ ) {

			if (suscribers[i]!=null) {

				flag=true;

			}
			
		}

		return flag;

	}

	/**
	 * Descripcion: El método addSuscribers toma la primera posicion vacia del arreglo y crea un nuevo objeto de clase Suscriber</br>
	 * @param <id><String>
	 * @param <name><String>
	 * @param <age><int>
	 * @param <consumeHours><int>
	 * @param <type><TypeClient>
	 * @param <state><State>
	 * */

	public void addSuscriber(String id, String name, int age, int consumeHours, TypeClient type, State state){

		int res= hasSpaceSuscribers();

		suscribers[res]= new Suscriber(id,name,age,consumeHours,type,state);

	}

	/**
	 * Descripcion: El método verifyId toma el valor de la posicion retornada en idExist para determinar si existe en el arreglo un id que corresponda con el que ingresa el usuario. </br>
	 * @param <iden><String>
	 * @return <out><boolean>, retorna verdadero si existe una posicion con un id que corresponda con el que ingresa el usuario. 
	 * */

	public boolean verifyId(String iden){

		boolean out=false; 

		int res= idExist(iden);

		if (res >= 0 ) {
			out= true;
		}

		return out;

	}

	/**
	 * Descripcion: El método idExist el valor del Id ingreado por el usuario y busca en el arreglo si algun id coincide con este. </br>
	 * @param <iden><String>
	 * @return <position><int>, retorna la posicion en la que exista un id que corresponda con el que ingresa el usuario. 
	 * */

	public int idExist(String iden){

		boolean flag=false;
		int position=-1;

		for (int i=0; i<numSuscribers && !flag ; i++) {

			if (suscribers[i]!=null) {
				if (suscribers[i].getId().equals(iden)) {
				
					position=i;
					flag=true;

				}
			}
			
		}

		return position;

	}

	/**
	 * Descripcion: El método disableSuscriber toma el Id que el usuario ingresa y en el arreglo modifica los valores de las variables type y state</br>
	 * @param <iden><String>
	 * @param <type><TypeClient>
	 * @param <state><State>
	 * */

	public void disableSuscriber(String iden, TypeClient type, State state){

		int position=idExist(iden);

		suscribers[position].setType(type);
		suscribers[position].setState(state);

	}

	/**
	 * Descripcion: El método activeSuscriber evalua todo el arreglo para buscar los usuarios con un estado ACTIVE para retornar la cantidad por cada tipo de cliente.</br>
	 * */

	public String activeSuscribers(){

		int normal=0;
		int platino=0;
		int oro=0;
		int diamante=0;
		int total=0;

		for (int i=0;i<numSuscribers ;i++ ) {

			if (suscribers[i]!=null) {

				if (suscribers[i].getState() == State.ACTIVE) {

					if (suscribers[i].getType() == TypeClient.NORMAL) {

						normal++;
						
					}else if (suscribers[i].getType() == TypeClient.PLATINUM) {

						platino++;
						
					}else if (suscribers[i].getType() == TypeClient.GOLD) {

						oro++;
						
					}else if (suscribers[i].getType() == TypeClient.DIAMOND) {

						diamante++;
						
					}
					
				}
				
			}
			
		}

		total= platino+normal+oro+diamante;

		return "La cantidad de susciprtores activos son: " + total +"\n"+
				"a. Normal: " + normal + "\n"+
				"b. Platino: " + platino + "\n"+
				"c. Oro: " + oro + "\n"+
				"d. Diamante: " + diamante;


	}


	/**
	 * Descripcion: El método bestSuscriber evalua todo el arreglo para encontrar un suscriptor que cumpla con ser menor de 18 y tiene la mayor cantidad de hora de consumo</br>
	 * @return <position><int>, retorna la posicion del suscriptor que cumpla la condicion de ser menor de 18 y tiene la mayor cantidad de hora de consumo
	 * */


	public int bestSuscriber(){

		int age=18;
		int hours=0;
		int position=-1;

		for (int i=0;i<numSuscribers ;i++ ) {

			if (suscribers[i]!=null) {

				if (suscribers[i].getAge() < age && hours < suscribers[i].getConsumeHours()) {

					hours = suscribers[i].getConsumeHours();
					position=i;

				}

			}
			
		}

		return position;

	}

	/**
	 * Descripcion: El método nameSuscriber evalua la posicion retornada por bestSuscriber para determinar si existe este suscriptor, y en caso tal retornar el nombre.</br>
	 * @return <res><String>, retorna el nombre del suscriptor que cumpla la condicion de ser menor de 18 y tiene la mayor cantidad de hora de consumo
	 * */

	public String nameSuscriber(){

		String res="";
		int position=bestSuscriber();

		if (position==-1) {

			res="No existe un suscriptor con esta descripcion.";
			
		}else{

			res= "El nombre del suscriptor es: "+suscribers[position].getName();

		}

		return res;

	}

	/**
	 * Descripcion: El método hasSpaceProduct verifica que haya un espacio libre en el arreglo de productos y retorna la primera posicion vacia.</br>
	 * @return <space><int>, es la primera posicion vacia encontrada en el arreglo, en caso de no haber es igual a -1
	 * */

	public int hasSpaceProduts(){

		int space=-1;
		boolean flag=false;

		for (int i=0; i<numProducts && !flag ;i++ ) {

			if (catalog[i]==null) {

				space=i;
				flag=true;
			}
			
		}

		return space;

	}

	/**
	 * Descripcion: El método hasNotProduct verifica si en el arreglo hay alguna posicion llena.</br>
	 * @return <flag><boolean>, retorna true en caso de encontrar una posicion llena, false si no encuentra ninguna.
	 * */

	public boolean hasNotProduct(){

		boolean flag=false;

		for (int i=0; i<numProducts && !flag ;i++ ) {

			if (catalog[i]!=null) {

				flag=true;

			}
			
		}

		return flag;

	}

	/**
	 * Descripcion: El método verifyNumProduct compara el valor retornado por hasSpaceProduct para retornar un boolean de acuerdo a este </br>
	 * @return <out> <boolean>, retorna true si el valor de hasSpaceProduct es mayor o igual a cero, en caso contrario retorna false
	 * */

	public boolean verifyNumProduct(){

		boolean out=false; 

		int res= hasSpaceProduts();

		if (res >= 0 ) {
			out= true;
		}

		return out;

	}

	/**
	 * Descripcion: El método addSerie crea un nuevo objeto Serie con los parametros correspondientes y lo guarda en la primera posicion vacia del arreglo</br>
 	 * @param <name><String>
	 * @param <nameDirector><String>
	 * @param <synopsis><String>
	 * @param <mainCharrectersNames><String>
	 * @param <censure><Censure>
	 * @param <day><int>
	 * @param <month><int>
	 * @param <year><int>
	 * @param <numProgramChapters><int>
	 * @param <numPublishedChapters><int>
	 * @param <trailer><String>
	 * */

	public void addSerie(String name,String nameDirector, String synopsis, String mainCharactersNames, Censure censure, int day,int month, int year, int numProgramChapters,int numPublishedChapters,String trailer) {

		int res=hasSpaceProduts();
		Date date= new Date(day, month, year);
		Season firstSeason= new Season(numProgramChapters,numPublishedChapters, trailer,date);
		catalog[res]=new Series(name,nameDirector, synopsis, mainCharactersNames, censure, date,firstSeason);

	}

	/**
	 * Descripcion: El método addMovie crea un nuevo objeto Movie con los parametros correspondientes y lo guarda en la primera posicion vacia del arreglo</br>
 	 * @param <name><String>
	 * @param <nameDirector><String>
	 * @param <synopsis><String>
	 * @param <originalTitleName><String>
	 * @param <producer><String>
	 * @param <minAge><int>
	 * @param <trailer><String>
	 * @param <day><int>
	 * @param <month><int>
	 * @param <year><int>
	 * @param <category><Genre>
	 * */

	public void addMovie(String name, String nameDirector, String synopsis, String originalTitleName, String producer, int minAge, String trailer, int day, int month, int year, Genre category) {

		int res=hasSpaceProduts();
		Date date= new Date(day, month, year);
		catalog[res]=new Movie( name, nameDirector, synopsis ,  originalTitleName , producer , minAge , trailer ,date, category);

	}

	/**
	 * Descripcion: El método nameProduct recorre el arreglo de productos verificando las posiciones llenas que tengan el nombre igual al ingresado </br>
	 * @param <name><String>
	 * @return <position><int>, retorna la posicion en la que el nombre ingresado es igual al del arreglo.
	 * */

	public int nameProduct(String name){

		int position=-1;

		for (int i=0;i<numProducts ;i++ ) {

			if (catalog[i]!=null) {


				if (catalog[i].getName().equalsIgnoreCase(name)) {

					position=i;

				}

			}

		}
			

		return position;

	}

	/**
	 * Descripcion: El método verifyNameProduct compara el valor retornado por nameProduct para retornar un boolean de acuerdo a este, para verificar si aun no existe un producto con el nombre ingresado.</br>
	 * @param <name><String>
	 * @return <out> <boolean>, retorna true si el valor de nameProduct igual a -1, en caso contrario retorna false
	 * */

	public boolean verifyNameProduct(String name){

		boolean res= false;
		int position= nameProduct(name);

		if (position==-1) {
			res=true;
		}
		return res;
	}

	/**
	 * Descripcion: El método getInfoProduct verifica que existe un producto con el nombre ingresado, y segun el id, retorna la informacion de la serie o pelicula requerida</br>
	 * @param <name><String>
	 * @param <id><int>
	 * @return <res><String>, retorna la informacion del producto consultado.
	 * */

	public String getInfoProduct(int id,String name){

		String res="";
		int position=nameProduct(name);

		if (position==-1) {

			res="No existe un producto con este nombre.";
			
		}else{

			if (id==1) {

				Series assis=(Series)catalog[position];
				res= assis.toString()+"------------------------\n"+assis.getSeason()+"------------------------\n";

			}else{

				Movie assis=(Movie)catalog[position];
				res= assis.toString();

			}
		

		}

		return res;

	}

	/**
	 * Descripcion: El método getCategoryMovie de acuerdo a la categoria elegida por el usuario busca en el arreglo de productos los que tengan esta categoria y retorna los nombres de cada pelicula</br>
	 * @param <num><int>
	 * @return <result><String>
	 * */

	public String getCategoryMovie(int num) {

		String catRomantic="";
		String catAction="";
		String catTerror="";
		String catComedy="";
		String catSuspense="";
		String result="";

		for (int i=0;i<numProducts ;i++ ) {

			if (catalog[i]!=null && catalog[i] instanceof Movie) {

				Movie assis=(Movie)catalog[i];
				if (assis.getCategory() == Genre.ROMANTIC) {

					catRomantic=catRomantic+"\n"+assis.getName();
						
				}else if (assis.getCategory() == Genre.ACTION) {

					catAction=catAction+"\n"+assis.getName();
						
				}else if (assis.getCategory() == Genre.TERROR) {

					catTerror=catTerror+"\n"+assis.getName();
						
				}else if (assis.getCategory() == Genre.COMEDY) {

					catComedy=catComedy+"\n"+assis.getName();
						
				}else if (assis.getCategory() == Genre.SUSPENSE) {

					catSuspense=catSuspense+"\n"+assis.getName();	

				}
			}		
		}

		switch(num){

			case 1:

			result=catRomantic;
				break;

			case 2:

			result=catAction;
				break;
			
			case 3:

			result=catTerror;
				break;
			
			case 4:

			result=catComedy;
				break;
			
			case 5:

			result=catSuspense;
				break;			
			}

			return result;

	}

	/**
	 * Descripcion: El método addSeason envia la informacion de la temporada a Series para crear un nueva temporada</br>
 	 * @param <name><String>
	 * @param <numProgramChapters><int>
	 * @param <numPublishedChapters><int>
	 * @param <trailer><String>
	 * @param <day><int>
	 * @param <month><int>
	 * @param <year><int>
	 * */

	public void addSeason(String name,int numProgramChapters,int numPublishedChapters, String trailer,int day,int month,int year){

		int position=nameProduct(name);
		Series assis= (Series)catalog[position];

		Date date = new Date(day,month,year);
		assis.addSeason(numProgramChapters,numPublishedChapters,trailer,date);

	}

	/**
	 * Descripcion: El método hasNotSerie recorre el arreglo de productos para encontrar si se ha creado al menos un objeto Series</br>
	 * @return <position><int>, retorna la posicion donde se encuentra la serie.
	 * */

	public int hasNotSerie(){

		boolean flag=false;
		int position=-1;

		for (int i=0; i<numProducts && !flag ;i++ ) {

			if (catalog[i]!=null && catalog[i] instanceof Series ) {

				position=i;
				flag=true;

			}
			
		}

		return position;

	}

	/**
	 * Descripcion:El método verifySerie compara el valor retornado por hasNotSerie para retornar un boolean de acuerdo a este, para verificar si se ha creado al menos una serie.</br>
	 * @return <out><boolean>
	 * */

	public boolean verifySerie(){

		boolean out=false; 

		int res= hasNotSerie();

		if (res >= 0 ) {
			out= true;
		}

		return out;

	}

	/**
	 * Descripcion: El método getSerie busca en todo el arreglo los objetos de tipo Series para ir guardando en una String para retornar la informacion de todas las series y de la ultima temporada de cada una.</br>
	 * @return <result><String>
	 * */

	public String getSeries() {

		String result="";

		for (int i = 0; i < numProducts; i++) {

			if (catalog[i]!=null && catalog[i] instanceof Series) {

				Series assis=(Series)catalog[i];
				result+=assis.toString()+"----------------------- \n"+assis.getLastSeason()+"------------------------\n";
				
			} 
			
		}

		return result;

	}
}

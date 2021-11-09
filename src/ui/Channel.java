package ui;

import java.util.Scanner;

import model.BlackSnail;
import model.TypeClient;
import model.State;
import model.Censure;
import model.Genre;


public class Channel{

	private BlackSnail myChannel;
	private Scanner sc; 


	public Channel() {
		sc= new Scanner(System.in);
	}

	public static void main(String[] args) {
		
		Channel bs= new Channel();
		
	
		System.out.println("Iniciando la aplicación");

		bs.blackSnail();
		
		int option=0;
		
		do{
			
			option= bs.showMenu();
			bs.executeOperation(option);
			
		}while (option!=0);
		
	}

	/**
	 * Descripcion: El método blackSnail pide al usuario los datos del Canal para crear un objeto tipo BlackSnail.</br>
	 * */

	public void blackSnail(){

		System.out.println("Ingresar los datos del Canal BlackSnail:");

		System.out.println("Ingrese el NIT del Canal");
		String nit= sc.nextLine();

		System.out.println("Ingrese la dirección del Canal");
		String address= sc.nextLine();

		System.out.println("Ingrese el link de la pagina web del Canal");
		String website= sc.nextLine();

		myChannel = new BlackSnail(nit,address,website);

	}

	/**
	 * Descripcion: El método showMenu pide al usuario que  ingrese un número del 0 al 4 de acuerdo con la opcion del menú</br>
	 * @return <option> <int>, hace referencia a la opcion que el usuario escoge en el menu, debe ser un número del 0 al 4
	 * */
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Menú principal, seleccione una opción\n" +
				"(1) Crear un nuevo suscriptor \n" +
				"(2) Desactivar un suscriptor \n" +
				"(3) Mostrar la cantidad de suscriptores activos \n"+
				"(4) Mostrar el nombre del suscriptor menor de edad con mayor cantidad de horas dispuesto a consumir\n"+
				"(5) Crear un nuevo producto\n"+
				"(6) Mostrar la informacion de un producto\n"+
				"(7) Mostrar listado de pelicula de una categoria\n"+
				"(8) Crear una nueva temporada de una serie\n"+
				"(9) Mostrar listado de series con su ultima temporada\n"+
				"(0) Para salir"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}

	/**
	 * Descripcion: El método executeOperation evalua la opcion que el usuario ingreso para enviarlo al método correspondiente</br>
	 * @param <operatiom> <int>,es el valor de la opcion que el usuario ingreso en el método anterior.
	 * */

	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Cerrando aplicación");
			break;
		case 1:
			createSuscriber() ;
			break;
		case 2:
			disableSuscriber() ;
			break;
		case 3:
			showActiveSuscribers();
			break;
		case 4:
			showBestSuscriber();
			break;
		case 5:
			createProduct();
			break;
		case 6:
			showProduct();
			break;
		case 7:
			showMovieList();
			break;
		case 8:
			createSeason();
			break;
		case 9:
			showSerieList();
			break;		
		default:
			System.out.println("Error, opción no válida");
		
		}
	}



	/**
	 * Descripcion: El método createSuscriber pide al usuario la informacion para crear un suscriptor y la envia al metodo addSuscriber</br>
	 * */

	public void createSuscriber(){

		if (myChannel.verifySuscriber()) {


			System.out.println("Ingrese el número de cédula del suscriptor");
			String id=sc.nextLine();

			System.out.println("Ingrese el nombre completo del suscriptor");
			String name=sc.nextLine();

			System.out.println("Ingrese la edad del suscriptor");
			int age=sc.nextInt();
			sc.nextLine();

			System.out.println("Ingrese cantidad de hora que está dispuesto a consumir");
			int consumeHours=sc.nextInt();
			sc.nextLine();

			TypeClient type=TypeClient.NORMAL;
			int num=0;
			
			while(num<1 || num>4){
				System.out.println("Digite el número de acuerdo al tipo de cliente:\n"+
				"1: Normal\n"+
				"2: PLatinum\n"+
				"3: Gold\n"+
				"4: Diamond");

				num = sc.nextInt();
				sc.nextLine();

				switch(num){

				case 1:

				type=TypeClient.NORMAL;
					break;

				case 2:

				type=TypeClient.PLATINUM;
					break;

				case 3:

				type=TypeClient.GOLD;
					break;

				case 4:

				type=TypeClient.DIAMOND;
					break;
				default:
					System.out.println("Error, opción no válida");

				}
			}

			State state=State.ACTIVE;

			myChannel.addSuscriber(id, name, age, consumeHours, type, state);

			System.out.println("El nuevo suscriptor se ha creado exitosamente.");
			
			
		}else{

			System.out.println("El número de suscriptores ha llegado a su limite.");

		}

	}

	/**
	 * Descripcion: El método disableSuscriber pide al usuario el id del suscriptor que desea desactivar y lo envia al método disableSuscriber</br>
	 * */

	public void disableSuscriber(){

		if (myChannel.hasSuscribers()) {
			
			System.out.println("Ingrese el Id del suscriptor al cual desea desactivar:");
			String iden= sc.nextLine();
	
			myChannel.idExist(iden);
	
			if (myChannel.verifyId(iden)) {
	
				TypeClient type=TypeClient.NORMAL;
				State state=State.INACTIVE;
	
				myChannel.disableSuscriber(iden,type,state);
	
				System.out.println("El suscriptor se ha desactivado con exito");
				
			}else{
	
				System.out.println("El número de cédula ingresado no corresponde con ningun suscriptor registrado");
	
			}

		}else{

			System.out.println("Aún no hay suscriptores registrados.");

		}

		

	}

	/**
	 * Descripcion: El método showActiveSuscribers muestra al usuario los suscriptores que tienen estado Activo de acuerdo a su tipo de cliente</br>
	 * */

	public void showActiveSuscribers(){

		if (myChannel.hasSuscribers()) {
			
			System.out.println(myChannel.activeSuscribers());

		}else{

			System.out.println("Aún no hay suscriptores registrados.");

		}

	}

	/**
	 * Descripcion: El método showBestSuscriber muestra al usuario el nombre del suscriptor que es menor de 18 y tiene la mayor cantidad de hora de consumo</br>
	 * */

	public void showBestSuscriber(){

		if (myChannel.hasSuscribers()) {

			
			myChannel.bestSuscriber();
			System.out.println(myChannel.nameSuscriber());

		}else{

			System.out.println("Aún no hay suscriptores registrados.");

		}

	}

	/**
	 * Descripcion: El método createProduct despues de llamar al método que verifica si hay espacio para crear productos, pide al usuario que  ingrese 1 o 2 de acuerdo con el producto que desea crear y lo envia al método correspondiente</br>
	 * */

	public void createProduct(){

		if (myChannel.verifyNumProduct()) {
			int option=0;

			while (option<1 || option>2) {

				System.out.println("Digite el número de acuerdo al producto que va a crear:\n"+
					"1: Pelicula\n"+
					"2: Serie");
				option= sc.nextInt();
				sc.nextLine();

				switch (option) {

					case 1:
						createMovie();
						break;

					case 2:
						createSerie();
						break;
				
					default:
					System.out.println("El número ingresado no es válido.");
						break;

				}
			}
		}else{

			System.out.println("El número de productos registrados ha llegado a su limite.");

		}

		
	}

	/**
	 * Descripcion: El método createSerie pide al usuario la informacion de la serie a crear y lo envia al método que crea el objeto en BlackSnail</br>
	 * */

	public void createSerie() {

		boolean res=false;
		String name="";
		while (res==false) {

			System.out.println("Ingrese el nombre de la serie.");
			name=sc.nextLine(); 

			if (myChannel.verifyNameProduct(name)) {
				res= true;
			}else{
				System.out.println("Ya se ha registrado un producto con ese nombre. Intente con otro nombre");
			}

		}

		System.out.println("Ingrese el nombre del director de la serie.");
		String nameDirector=sc.nextLine(); 

		System.out.println("Ingrese la sinopsis de la serie.");
		String synopsis=sc.nextLine(); 

		System.out.println("Ingrese el nombre de los personajes principales.");
		String mainCharactersNames=sc.nextLine(); 

		Censure censure= Censure.CENSURE;
			int num=0;
			
			while(num<1 || num>2){
				System.out.println("Digite el número de acuerdo al tipo de censura:\n"+
				"1: Censurado\n"+
				"2: No censurado");

				num = sc.nextInt();
				sc.nextLine();

				switch(num){

				case 1:

				censure=Censure.CENSURE;
					break;

				case 2:

				censure = Censure.NONCENSURE;
					break;

				default:
					System.out.println("Error, opción no válida");

				}
			}

		System.out.println("Ingrese la fecha del primer estreno:");	

		System.out.println("Ingrese el día:");
		int day=sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese el mes:");
		int month=sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese el año:");
		int year=sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese los datos de la primera temporada de la serie:");	

		System.out.println("Ingrese el número de capitulos programados:");
		int numProgramChapters=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Ingrese el número de capitulos publicados:");
		int numPublishedChapters=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Ingrese el trailer de la temporada:");
		String trailer=sc.nextLine();
		
		myChannel.addSerie(name, nameDirector, synopsis, mainCharactersNames, censure, day, month, year,numProgramChapters,numPublishedChapters, trailer);
		

	}

	/**
	 * Descripcion: El método createMovie pide al usuario la informacion de la pelicula a crear y lo envia al método que crea el objeto en BlackSnail</br>
	 * */

	public void createMovie() {

		boolean res=false;
		String name="";
		while (res == false) {

			System.out.println("Ingrese el nombre de la pelicula.");
			name=sc.nextLine(); 

			if (myChannel.verifyNameProduct(name)) {
				res= true;
			}else{
				System.out.println("Ya se ha registrado un producto con ese nombre. Intente con otro nombre");
			}

		}
		

		System.out.println("Ingrese el nombre del director de la serie.");
		String nameDirector=sc.nextLine(); 

		System.out.println("Ingrese la sinopsis de la serie.");
		String synopsis=sc.nextLine(); 

		System.out.println("Ingrese el nombre original de la pelicula.");
		String originalTitleName= sc.nextLine(); 

		System.out.println("Ingrese el nombre del productor");
		String producer=sc.nextLine();

		System.out.println("Ingrese la edad minima permitida");
		int minAge=sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese el link del trailer.");
		String trailer=sc.nextLine();

		System.out.println("Ingrese la fecha del estreno mundial.");	

		System.out.println("Ingrese el día.");
		int day=sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese el mes");
		int month=sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese el año.");
		int year=sc.nextInt();
		sc.nextLine();

		Genre category= Genre.ROMANTIC;
			int num=0;
			
			while(num<1 || num>5){
				System.out.println("Digite el número de acuerdo al género de la pelicula:\n"+
				"1: Romantico\n"+
				"2: Accion\n"+
				"3: Terror\n"+
				"4: Comedia\n"+
				"5: Suspenso");

				num = sc.nextInt();
				sc.nextLine();

				switch(num){

				case 1:

				category= Genre.ROMANTIC;
					break;

				case 2:

				category= Genre.ACTION;
					break;
				
				case 3:

				category= Genre.TERROR;
					break;
				
				case 4:

				category= Genre.COMEDY;
					break;
				
				case 5:

				category= Genre.SUSPENSE;
					break;

				default:
					System.out.println("Error, opción no válida");

				}
			}

		myChannel.addMovie(name,nameDirector,synopsis , originalTitleName ,producer , minAge , trailer , day, month, year, category);

	}

	/**
	 * Descripcion: El método showProduct llama al método que verifica si hay productos creados y pide al usuario que ingrese 1 o 2 según el producto a consultar para enviarlo al método correspondiente.</br>
	 * */

	public void showProduct(){

		if (myChannel.hasNotProduct()) {

			int option=0;
			while (option<1||option>2) {

				System.out.println("Ingrese el número de acuerdo al tipo de producto que desea consultar: \n"+
								"1:Pelicula\n"+
								"2:Serie");
				option=sc.nextInt();
				sc.nextLine();

				switch (option) {
					case 1:
						getMovie();
						break;

					case 2:
						getSerie();
						break;
				
					default:
					System.out.println("El número ingresado no es valido");
						break;
					}

			}

		}else{
			System.out.println("No hay productos creados para mostrar.");
		}

	
	}

	/**
	 * Descripcion: El método getSerie pide al usuario que ingrese el nombre de la serie y envia la informacion junto con un id a u método que verifica el nombre y retorna la informacion correspondiente para mostrarla. </br>
	 * */

	public void getSerie() {

		System.out.println("Ingrese el nombre de la serie que desea consultar");
		String name=sc.nextLine();

		int id=1;

		System.out.println(myChannel.getInfoProduct(id,name));


	}

	/**
	 * Descripcion: El método getMovie pide al usuario que ingrese el nombre de la pelicula y envia la informacion junto con un id a u método que verifica el nombre y retorna la informacion correspondiente para mostrarla</br>
	 * */

	public void getMovie() {

		System.out.println("Ingrese el nombre de la pelicula que desea consultar");
		String name=sc.nextLine();

		int id=2;

		System.out.println(myChannel.getInfoProduct(id,name));

	}

	/**
	 * Descripcion: El método showMovieList llama al método que verifica si hay producto creados, despues pide al usuario un número entre 1 y 5 de acuerdo a la categoría, y envia el número al método que retorna las peliculas correspondientes  </br>
	 * */

	public void showMovieList(){

		if (myChannel.hasNotProduct()) {

			int num=0;
			
			while(num<1 || num>5){

				System.out.println("Digite el número de acuerdo a las peliculas que desea ver según su categoría:\n"+
				"1: Romantico\n"+
				"2: Accion\n"+
				"3: Terror\n"+
				"4: Comedia\n"+
				"5: Suspenso");

				num = sc.nextInt();
				sc.nextLine();
				if (num<1 || num>5) {

					System.out.println("Opcion no valida.");
					
				}
			}

			System.out.println(myChannel.getCategoryMovie(num));

		}else{
			System.out.println("No hay productos creados para mostrar.");
		}

	}

	/**
	 * Descripcion: El método createSeason llama el metodo que verifica si hay series creadas, luego pide al usuario el nombre de la serie y la informacion de la temporada para luego enviarla al metodo que crea el objeto tenmporada</br>
	 * */

	public void createSeason(){

		if (myChannel.verifySerie()) {

			boolean res=false;

			String name="";
			
			while (res == false) {

				System.out.println("Ingrese el nombre de la serie a la que desea añadir la temporada.");
				name=sc.nextLine(); 

				if (myChannel.verifyNameProduct(name)) {
					System.out.println("No existe un producto con este nombre.Intente de nuevo");
				}else{
					res= true;
				}

			}

			System.out.println("Ingrese los datos de la una nueva temporada de la serie:");	

			System.out.println("Ingrese el número de capitulos programados:");
			int numProgramChapters=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Ingrese el número de capitulos publicados:");
			int numPublishedChapters=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Ingrese el trailer de la temporada:");
			String trailer=sc.nextLine();

			System.out.println("Ingrese la fecha de estreno.");	

			System.out.println("Ingrese el día.");
			int day=sc.nextInt();
			sc.nextLine();

			System.out.println("Ingrese el mes");
			int month=sc.nextInt();
			sc.nextLine();

			System.out.println("Ingrese el año.");
			int year=sc.nextInt();
			sc.nextLine();


			myChannel.addSeason(name,numProgramChapters,numPublishedChapters, trailer,day,month,year);

		}else{

			System.out.println("Aún no se ha creado ninguna serie.");

		}
	}

	/**
	 * Descripcion: El método showSerieList llama al metodo que verifica si hay series creadas y luego llama al metodo que retorna toda la informacion de las series y de la ultima temporada de cada una.</br>
	 * */

	public void showSerieList() {

		if (myChannel.verifySerie()) {

			System.out.println(myChannel.getSeries());
			
		}else{

			System.out.println("Aún no se ha creado ninguna serie.");

		}
		
	}

}
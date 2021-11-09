package model; 


public class Suscriber{

	private String id; 
	private String name;
	private int age; 
	private int consumeHours;

	//Relationship
	private TypeClient type; 
	private State state;

	//Methods

	public Suscriber(String id, String name, int age, int consumeHours, TypeClient type,State state){

		this.id=id;
		this.name=name;
		this.age=age;
		this.consumeHours=consumeHours;
		this.state=state;
		this.type=type;

	}

	// Getters and setters 

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id= id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name= name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age=age;
	}

	public int getConsumeHours(){
		return consumeHours;
	}

	public void setConsumeHours(int consumeHours){
		this.consumeHours=consumeHours;
	}

	public State getState(){
		return state;
	}

	public void setState(State state){
		this.state=state;
	}

	public TypeClient getType(){
		return type;
	}

	public void setType(TypeClient type){
		this.type=type;
	}

	//toString

	public String toString() {
		return "Suscriptor:\n"+
		"Numero de Cédula: "+ id +"\n"+
		"Nombre completo: "+ name +"\n"+
		"Edad: "+ age +"\n"+
		"Horas dispuesto a consumir: "+ consumeHours +"\n"+
		"Estado: "+ state +"\n"+
		"Tipo de cliente: "+ type;
	}

	
	
}


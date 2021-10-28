package in.conceptarchitect.app;

import in.conceptarchitect.animals.Animal;
import in.conceptarchitect.animals.Camel;
import in.conceptarchitect.animals.Cow;
import in.conceptarchitect.animals.Crocodile;
import in.conceptarchitect.animals.Dog;
import in.conceptarchitect.animals.Domestic;
import in.conceptarchitect.animals.Eagle;
import in.conceptarchitect.animals.Horse;
import in.conceptarchitect.animals.Hunter;
import in.conceptarchitect.animals.Panther;
import in.conceptarchitect.animals.Parrot;
import in.conceptarchitect.animals.Snake;
import in.conceptarchitect.animals.Tiger;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal [] animals= {
				new Tiger(),
				new Cow(),
				new Dog(),
				new Parrot(),
				new Camel(),
				new Eagle(),
				new Snake(),
				//new Animal(),
				//new Mammal(),
				new Horse(),
				//new Cat(),
				//new Reptile(),
				new Panther(),
				//new Bird(),
				new Crocodile(),
				new Cow()
		};

		
		//I can treat Dog,Cat, Parrot all as an Animal
		
		
		for(Animal animal: animals) {
			
			//if(animal instanceof Domestic)
			
			if(animal.isDomestic())
				System.out.print("******* ");
				
			System.out.println(animal);
			System.out.println("\t"+animal.move());
			System.out.println("\t"+animal.eat());
			System.out.println("\t"+animal.breed());
			
			
			//huntIfYouAreATiger(animal);
			huntIfYouAreAHunter(animal);
			
			
			System.out.println("\t"+animal.die());
			System.out.println();

		}
		
	}

	private static void huntIfYouAreAHunter(Animal animal) {
		// TODO Auto-generated method stub
		if(animal instanceof Hunter) {
			Hunter hunter=(Hunter) animal;
			System.out.println("\t"+hunter.hunt());
		}
		
	}

	private static void huntIfYouAreATiger(Animal animal) {
		if(animal instanceof Tiger) {
			Tiger tiger=(Tiger)animal;				
			System.out.println("\t"+tiger.hunt());	
		}
	}

}

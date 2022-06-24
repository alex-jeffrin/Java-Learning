class Motherboard {
	
    Motherboard(){
	    System.out.println("Mother board has been purchased...");
	}
	
}

class StorageDevice extends Motherboard{
	
    StorageDevice(){
        System.out.println("Storage devices has been purchased...");
    }
	
}

class PC extends StorageDevice{
	
    PC(){
        System.out.println("A new pc has been build");
    }
	
}

class OrderOfConstructor{
	
    public static void main (String args[]){
		
        System.out.println("This is a demonstration program for the order of constructors during inheritance:");
		
        PC myPC = new PC();
		
    }
}
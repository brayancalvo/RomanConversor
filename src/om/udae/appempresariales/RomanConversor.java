package om.udae.appempresariales;

public class RomanConversor {
	
	private int [] numbers;
	private String [] romans;
	private int temp;
	private final String error = "error";
	
	public RomanConversor(){
		
		int [] numbers = {1,4,5,9,10,40,50,90,100,400,500,900,1000 };		
		String [] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
		setNumbers(numbers);
		setRomans(romans);
		
	}
	
	public String turnit(String number){
		if(validaLetras(number)){
			return error;
		}
		
		StringBuilder romanNumber = new StringBuilder();			
		int numberAux = Integer.valueOf(number);
		int position = 0;
		while(numberAux > numbers[position]) {
			position++;
		}
		
		int max;
			
		if (!exist(numberAux)){			
			if (position == 0){
				max = numbers[position];
				romanNumber.append(romans[position]);
			}else{
				max = numbers[position-1];	
				romanNumber.append(romans[position-1]);
			}										
			temp =  numberAux - max ;
			String into = String.valueOf(temp); 
			into = turnit(into);
			romanNumber.append(into);	
		}else{
			romanNumber.append(romans[findPosition(numberAux)]);
			return romanNumber.toString();
		}							
		
		return romanNumber.toString();
		
	}	
	
	private boolean validaLetras(String number) {
		try{
			int num = Integer.valueOf(number);
		}catch(Exception e){
			return true;
		}
		return false;
	}

	private boolean exist(int number){
		for(int i=0;i<numbers.length;i++){
			if(number == numbers[i]){
				return true;
			}
		}
		
		return false;
	}
	
	private int findPosition(int number){
		for(int i=0;i<numbers.length;i++){
			if(number == numbers[i]){
				return i;
			}
		}
		
		return 0;
	}
		
	
	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public String[] getRomans() {
		return romans;
	}

	public void setRomans(String[] romans) {
		this.romans = romans;
	}


}

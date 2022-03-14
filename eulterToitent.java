import java.io.*;
import java.lang.*;

class eulerToitent{

	int checkIsPrime(int number){
		for(int i = 2;i<=Math.sqrt(number);i++){
			if(number%i==0){
				return 0;
			}
		}
		return 1;
	}
	
	void primeCoeff(int number){
		System.out.println("phi("+number+")="+(number-1)+"\n");
        for(int i=1;i<number;i++){
            System.out.print(i+"\t");
        }
	}
	
	void compositeCoeff(int number){
        int gcd=0;
		System.out.println();
		int temp = number,freq=0,numberPrimes = 1,expoN=1,expo_n=1;
		for(int i = 2;temp!=1;i++){
			while(temp%i==0){
				freq=freq+1;
				temp = temp/i;
				//System.out.print(i+"\t");
			}
			
			if(freq>1){
				for(int j = 0; j<freq;j++){
					expoN = expoN * i;
				}
				for(int k = 0;k<freq-1;k++){
					expo_n = expo_n * i;
				}
				numberPrimes = numberPrimes*(expoN-expo_n);
			}
			else if(freq==1){
				numberPrimes = numberPrimes*(i-1);
			}
			freq = 0;
			expoN = 1;
			expo_n = 1;
		}
		System.out.println("phi("+number+")="+numberPrimes+"\n");
        for(int n=1,k=0;n<number&&k<=numberPrimes;n++){
            for(int i = 1; i <= n && i <= number; i++)  
            {  
//returns true if both conditions are satisfied   
                if(n%i==0 && number%i==0)  
//storing the variable i in the variable gcd  
                    gcd = i;  
            }
            if(gcd==1){
                System.out.print(n+"\t");
                k++;
            } 
        }
	}

    public static void main(String[] args)throws IOException{
        System.out.println("Hello world");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the number");
        int number = Integer.parseInt(bf.readLine());
        eulerToitent t = new eulerToitent();
        int flag = t.checkIsPrime(number);
	//System.out.println(flag);
	if(flag == 1){
		t.primeCoeff(number);
	}
	else{
		t.compositeCoeff(number);
    	}
    }
}
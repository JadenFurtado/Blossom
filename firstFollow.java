
import java.io.*;
import java.util.*;

class firstFollow{
	int count, n = 0;
// Stores the final result
// of the First Sets
	char calc_first[][]= new char[11][100];
// Stores the final result
// of the Follow Sets
	char calc_follow[][]=new char[11][100];
	int m = 0;
// Stores the production rules
	char production[][]=new char[11][11];
	char f[] = new char[11], first[] = new char[11];
	int k;
	char ck;
	int e;
	
	//find first
	void findfirst(char c, int q1, int q2)
	{
	int j;
	
	// The case where we
	// encounter a Terminal
	if(!(Character.isUpperCase(c))) {
		first[n++] = c;
	}
	for(j = 0; j < count; j++)
	{
		if(production[j][0] == c)
		{
			if(production[j][2] == '#')
			{
				if(production[q1][q2] == '\0')
					first[n++] = '#';
				else if(production[q1][q2] != '\0'
						&& (q1 != 0 || q2 != 0))
				{
					// Recursion to calculate First of New
					// Non-Terminal we encounter after epsilon
					findfirst(production[q1][q2], q1, (q2+1));
				}
				else
					first[n++] = '#';
			}
			else if(!Character.isUpperCase(production[j][2]))
			{
				first[n++] = production[j][2];
			}
			else
			{
				// Recursion to calculate First of
				// New Non-Terminal we encounter
				// at the beginning
				findfirst(production[j][2], j, 3);
				}
			}
		}
	}
	
	//follow
	void follow(char c)
	{
	int i, j;
	
	// Adding "$" to the follow
	// set of the start symbol
	if(production[0][0] == c) {
		if(m<11){
		f[m++] = '$';
		}
	}
	for(i = 0; i < 10; i++)
	{
		for(j = 2;j < 10; j++)
		{
			if(production[i][j] == c)
			{
				if(production[i][j+1] != '\0')
				{
					// Calculate the first of the next
					// Non-Terminal in the production
					followfirst(production[i][j+1], i, (j+2));
				}
				
				if(production[i][j+1]=='\0' && c!=production[i][0])
				{
					// Calculate the follow of the Non-Terminal
					// in the L.H.S. of the production
					follow(production[i][0]);
				}
			}
		}
	  }
	}

	//follow first
	void followfirst(char c, int c1, int c2)
	{
	int k;
	
	// The case where we encounter
	// a Terminal
	if(!(Character.isUpperCase(c)))
		f[m++] = c;
	else
	{
		int i = 0, j = 1;
		for(i = 0; i < count; i++)
		{
			if(calc_first[i][0] == c)
				break;
		}
		
		//Including the First set of the
		// Non-Terminal in the Follow of
		// the original query
		while(calc_first[i][j] != '!')
		{
			if(calc_first[i][j] != '#')
			{
				f[m++] = calc_first[i][j];
			}
			else
			{
				if(production[c1][c2] == '\0')
				{
					// Case where we reach the
					// end of a production
					follow(production[c1][0]);
				}
				else
				{
					// Recursion to the next symbol
					// in case we encounter a "#"
					followfirst(production[c1][c2], c1, c2+1);
				}
			}
			j++;
		  }
		}
	}

	//main starts here
	public static void main(String[] args)throws IOException{
		//constructor
		firstFollow prod = new firstFollow();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int jm = 0;
	int km = 0;
	int i, choice;
	char c, ch;
	prod.count = 8;
	
	// The Input grammar
	//strcpy(production[0], "E=TR");
	String str = "E=TR";
  
        // Creating array of string length
        //char[] ch = new char[str.length()];
  
        // Copy character by character into array
    for (int op = 0; op < str.length(); op++) {
            prod.production[0][op] = str.charAt(op);
    }
	prod.production[0][str.length()]='\0';
	//strcpy(production[1], "R=+TR");
	str = "R=+TR";
  
        // Creating array of string length
        //char[] ch = new char[str.length()];
  
        // Copy character by character into array
    for (int op = 0; op < str.length(); op++) {
            prod.production[1][op] = str.charAt(op);
    }
	prod.production[1][str.length()]='\0';
	//strcpy(production[2], "R=#");
	str = "R=#";
  
        // Creating array of string length
        //char[] ch = new char[str.length()];
  
        // Copy character by character into array
    for (int op = 0; op < str.length(); op++) {
            prod.production[2][op] = str.charAt(op);
    }
	prod.production[2][str.length()]='\0';
	//strcpy(production[3], "T=FY");
	str = "T=FY";
  
        // Creating array of string length
        //char[] ch = new char[str.length()];
  
        // Copy character by character into array
    for (int op = 0; op < str.length(); op++) {
            prod.production[3][op] = str.charAt(op);
    }
	prod.production[3][str.length()]='\0';
	//strcpy(production[4], "Y=*FY");
	str = "Y=*FY";
  
        // Creating array of string length
        //char[] ch = new char[str.length()];
  
        // Copy character by character into array
    for (int op = 0; op < str.length(); op++) {
            prod.production[4][op] = str.charAt(op);
    }
	prod.production[4][str.length()]='\0';
	//strcpy(production[5], "Y=#");
	str = "Y=#";
  
        // Creating array of string length
        //char[] ch = new char[str.length()];
  
        // Copy character by character into array
    for (int op = 0; op < str.length(); op++) {
            prod.production[5][op] = str.charAt(op);
    }
	prod.production[5][str.length()]='\0';
	//strcpy(production[6], "F=(E)");
	str = "F=(E)";
  
        // Creating array of string length
        //char[] ch = new char[str.length()];
  
        // Copy character by character into array
    for (int op = 0; op < str.length(); op++) {
            prod.production[6][op] = str.charAt(op);
    }
	prod.production[6][str.length()]='\0';
	//strcpy(production[7], "F=i");
	str = "F=i";
  
        // Creating array of string length
        //char[] ch = new char[str.length()];
  
        // Copy character by character into array
    for (int op = 0; op < str.length(); op++) {
            prod.production[7][op] = str.charAt(op);
    }
	prod.production[7][str.length()]='\0';
	int kay;
	char done[]=new char[prod.count];
	int ptr = -1;
	
	// Initializing the calc_first array
	for(prod.k = 0; prod.k < prod.count; prod.k++) {
		for(kay = 0; kay < 100; kay++) {
			prod.calc_first[prod.k][kay] = '!';
		}
	}
	int point1 = 0, point2, xxx;
	
	for(prod.k = 0; prod.k < prod.count; prod.k++)
	{
		c = prod.production[prod.k][0];
		point2 = 0;
		xxx = 0;
		
		// Checking if First of c has
		// already been calculated
		for(kay = 0; kay <= ptr; kay++)
			if(c == done[kay])
				xxx = 1;
				
		if (xxx == 1)
			continue;
		
		// Function call
		prod.findfirst(c, 0, 0);
		ptr += 1;
		
		// Adding c to the calculated list
		done[ptr] = c;
		//printf("\n First(%c) = { ", c);
		System.out.println("First("+c+")={");
		prod.calc_first[point1][point2++] = c;
		
		// Printing the First Sets of the grammar
		for(i = 0 + jm; i < prod.n; i++) {
			int lark = 0, chk = 0;
			
			for(lark = 0; lark < point2; lark++) {
				
				if (prod.first[i] == prod.calc_first[point1][lark])
				{
					chk = 1;
					break;
				}
			}
			if(chk == 0)
			{
				System.out.println(prod.first[i]);
				prod.calc_first[point1][point2++] = prod.first[i];
			}
		}
		System.out.println("}");
		jm = prod.n;
		point1++;
	}
	System.out.println("");
	System.out.println("-----------------------------------------------\n");
	char donee[]=new char[prod.count];
	ptr = -1;
	
	// Initializing the calc_follow array
	for(prod.k = 0; prod.k < prod.count; prod.k++) {
		for(kay = 0; kay < 100; kay++) {
			prod.calc_follow[prod.k][kay] = '!';
		}
	}
	point1 = 0;
	int land = 0;
	for(prod.e = 0; prod.e < prod.count; prod.e++)
	{
		prod.ck = prod.production[prod.e][0];
		point2 = 0;
		xxx = 0;
		
		// Checking if Follow of ck
		// has already been calculated
		for(kay = 0; kay <= ptr; kay++)
			if(prod.ck == donee[kay])
				xxx = 1;
				
		if (xxx == 1)
			continue;
		land += 1;
		
		// Function call
		prod.follow(prod.ck);
		ptr += 1;
		
		// Adding ck to the calculated list
		donee[ptr] = prod.ck;
		System.out.println(" Follow("+prod.ck+") = { ");
		prod.calc_follow[point1][point2++] = prod.ck;
		
		// Printing the Follow Sets of the grammar
		for(i = 0 + km; i < prod.m; i++) {
			int lark = 0, chk = 0;
			for(lark = 0; lark < point2; lark++)
			{
				if (prod.f[i] == prod.calc_follow[point1][lark])
				{
					chk = 1;
					break;
				}
			}
			if(chk == 0)
			{
				System.out.println(prod.f[i]+", ");
				prod.calc_follow[point1][point2++] = prod.f[i];
			}
		}
		System.out.println(" }\n");
		km = prod.m;
		point1++;
		}
	}

}
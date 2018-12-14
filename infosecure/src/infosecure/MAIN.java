package infosecure;

import java.util.*;

public class MAIN {
	public static void main(String[] args)
	{
		StringBuffer mingt = new StringBuffer();
		String ming = new String();
		String mi = new String();
		Scanner input = new Scanner(System.in);
		mi = input.next();
		input.close();
		for(int i = 25; i>0;i--)
		{
			for(int j = 0; j<mi.length();j++)
			{
				char temp = mi.charAt(j);
				temp =(char) ((temp + i) % 91);
				if(temp < 65)
				{
					temp+=65;
				}
				System.out.print(temp);
				mingt.append(ming).insert(ming.length(),temp);
			}
			System.out.println();
		}
	}
}

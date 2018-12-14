package frequency;

import java.util.*;

public class MAIN 
{
	public static void main(String[] args)
	{
		alphafre af[] = new alphafre[26];
		AlphaFrequency AF[] = new AlphaFrequency[26];
		for(int i =0; i<26;i++)
		{
			af[i] = new alphafre();
			af[i].setLetter((char)('A'+i));
			AF[i] = new AlphaFrequency((char)('A'+i));
		}
		
		String mi = new String();
		Scanner input = new Scanner(System.in);
		mi = input.next();
		input.close();
		char temp = ' ';
		int no = 0;
		for(int i = 0;i<mi.length();i++)
		{
			temp = mi.charAt(i);
			no = temp - 65;
			af[no].freplus();		
		}
		for(int i =0;i<26;i++)
		{
			System.out.println(af[i].getLetter() + ":" + af[i].getFre(mi.length()) + "%");
		}
		//尝试明文密文字母1-1匹配
		for(int i = 0; i<25; i++)
		{
			for(int j =0;j<25-i;j++)
			{
				if(af[j].getFre(mi.length()) > af[j+1].getFre(mi.length()))	//密文字母频率大小排序 从小到大
				{
					alphafre tempaf = new alphafre();
					tempaf = af[j+1];
					af[j+1] = af[j];
					af[j] = tempaf;
				}
				if(AF[j].getFre() > AF[j+1].getFre())	//标准字母频率大小排序
				{
					AlphaFrequency tempAF = new AlphaFrequency();
					tempAF = AF[j+1];
					AF[j+1] = AF[j];
					AF[j] = tempAF;
				}			
			}
		}
		for(int i =0;i<26;i++)
		{
			System.out.print(i + "、明文：" + AF[i].getLetter() + "  ");
			System.out.println("密文：" + af[i].getLetter());
		}
		//替换密文
		//明文与密文按照由小到大对应顺序替换
/*		for(int i =0;i<26;i++)
		{
			af[i].setMingLetter(AF[i].getLetter());
		}*/
		//再以手推方式把特定的字母明密文对应
		for(int i =0;i<26;i++)
		{
			af[i].setMingLetter(af[i].getLetter());
		}
		//密文E->S,T->T,W->H,S->E,H->W
		af[23].setMingLetter('S');
		af[22].setMingLetter('T');
		af[15].setMingLetter('H');
		af[25].setMingLetter('E');
		af[9].setMingLetter('W');
		//第一行看出拆尼斯A->C,O->I,单词互换C->A,I->O
		af[16].setMingLetter('C');
		af[24].setMingLetter('I');
		af[17].setMingLetter('A');
		af[19].setMingLetter('O');
		
		//输出密钥
		System.out.println();
		System.out.println("***********************************************************************");
		System.out.println();
		for(int i =0;i<26;i++)
		{
			System.out.print(i + "、明文：" + af[i].getMingLetter() + "  ");
			System.out.println("密文：" + af[i].getLetter());
		}
		
		//输出明文
		int acc=0;
		for(int i = 0;i<mi.length();i++)
		{
			acc++;
			char tempc = mi.charAt(i);
			for(int j =0 ; j<26;j++)
			{
				if(tempc == af[j].getLetter())
				{
					System.out.print(af[j].getMingLetter());					
				}
			}
			if(acc % 100 == 0)
				System.out.println();
		}

	}
}

class alphafre
{
	private char miletter;		//密文字母
	private char mingletter;	//密文对应的明文字母
	private double fre;
	alphafre()
	{
		miletter = ' '; 
		fre = 0.0;
	}
	public void setLetter(char l)
	{
		miletter = l;
	}
	public char getLetter()
	{
		return miletter;
	}
	public void freplus()
	{
		fre++;
	}
	public double getFre(double amount)
	{
		return (fre/amount)*100;
	}
	public void setMingLetter(char l)
	{
		mingletter = l;
	}
	public char getMingLetter()
	{
		return mingletter;
	}
}

class AlphaFrequency
{
	private char letter;
	private double fre;
	AlphaFrequency()
	{
		letter = ' '; 
		fre = 0.0;
	}
	AlphaFrequency(char alp)
	{
		letter = alp;
		switch(alp)
		{
			case 'A':
				fre = 8.167;
				break;
			case 'B':
				fre = 1.492;
				break;
			case 'C':
				fre = 2.782;
				break;
			case 'D':
				fre = 4.253;
				break;
			case 'E':
				fre = 12.702;
				break;
			case 'F':
				fre = 2.228;
				break;
			case 'G':
				fre = 2.015;
				break;
			case 'H':
				fre = 6.094;
				break;
			case 'I':
				fre = 6.966;
				break;
			case 'J':
				fre = 0.153;
				break;
			case 'K':
				fre = 0.772;
				break;
			case 'L':
				fre = 4.025;
				break;
			case 'M':
				fre = 2.406;
				break;
			case 'N':
				fre = 6.749;
				break;
			case 'O':
				fre = 7.507;
				break;
			case 'P':
				fre = 1.929;
				break;
			case 'Q':
				fre = 0.095;
				break;
			case 'R':
				fre = 5.987;
				break;
			case 'S':
				fre = 6.327;
				break;
			case 'T':
				fre = 9.056;
				break;
			case 'U':
				fre = 2.758;
				break;
			case 'V':
				fre = 0.978;
				break;
			case 'W':
				fre = 2.360;
				break;
			case 'X':
				fre = 0.150;
				break;
			case 'Y':
				fre = 1.974;
				break;
			case 'Z':
				fre = 0.074;
				break;
		}
	}

	public char getLetter()
	{
		return letter;
	}
	public double getFre()
	{
		return fre;
	}

}
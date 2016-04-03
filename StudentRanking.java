/*

	Kumar Saarang Singh	
	Phone Number: (+91)9663587900
	Primary e-Mail: psarang29@gmail.com
	Secondary e-Mail: sarangsingh29@yahoo.com

	NOTE:
	The application is interactive with the user. There should not be any problem with the usage. In case
	of any difficulties, the input and output details are specified below.

	Input:
	1. The number of students that are to be ranked.
	2. For each student, enter the Name, Roll Number and 
	   marks (Maths, Science, Environmental Science, Language1, Language2),strictly in specified order.

	Output:
	The ranking of each student with the corresponding details.

	References:
	1. docs.oracle.com/javase 
	2. JAVA, The complete reference (Herbert Schildt)
	
*/



import java.util.*;

class Student
{
	private String name;
	private int roll;
	private double marks[];
	private double totalmarks;
	int rankinclass;

	public Student()
	{
		name="no-name";
		roll=-1;
		marks=new double[5];
		totalmarks=0;
		rankinclass=-1;
	}

	public Student(String name, int roll, double arr[])
	{
		this.name=name;
		this.roll=roll;
		this.marks=arr;
		rankinclass=-1;

		for(int i=0;i<arr.length;i++)
			totalmarks+=arr[i];
	}

	public void printdetails()
	{
		System.out.println("Rank #"+rankinclass);
		System.out.println("Name: "+name);
		System.out.println("Roll: "+roll);
		System.out.println("Total Marks: "+totalmarks);
		System.out.println("\nMarks: ");
		System.out.println("Maths: "+marks[0]);
		System.out.println("Science: "+marks[1]);
		System.out.println("Environmental Science: "+marks[2]);
		System.out.println("Language1: "+marks[3]);
		System.out.println("Language2: "+marks[4]);
	}

	public void setRank(int r)
	{
		rankinclass=r;
	}

	public int getRank()
	{
		return rankinclass;
	}

	public String getName()
	{
		return name;
	}

	public int getRoll()
	{
		return roll;
	}

	public double[] getAllMarksInArray()
	{
		return marks;
	}

	public double getTotalMarks()
	{
		return totalmarks;
	}

	public double getIndivMarks(String sub)
	{
		switch(sub)
		{
			case "Maths" : return marks[0];
			case "Science" : return marks[1];
			case "ES" : return marks[2];
			case "Lang1": return marks[3];
			case "Lang2": return marks[4];
			default: return -1;
		}
	}
}

class StudentGroup
{
	private Student[] arrOfStud;

	public StudentGroup(Student[] arr)
	{
		arrOfStud=arr;
		startRanking();
	}

	private void startRanking()
	{
		Student key;

		/*
			Criteria 1: Ranking on the basis of total marks.
		*/

		for(int i=1,j;i<arrOfStud.length;i++)
		{
			key=arrOfStud[i];
			for(j=i-1;j>=0 && arrOfStud[j].getTotalMarks()<key.getTotalMarks();j--)
			{
				arrOfStud[j+1]=arrOfStud[j];
			}
			arrOfStud[j+1]=key;
		}	

		for(int i=0;i<arrOfStud.length;i++)
		{
			arrOfStud[i].setRank(i);
		}	



		/*
			Criteria 2: Ranking on the basis of individual marks, following the priority order.
		*/

		for(int i=0;i<arrOfStud.length;i++)
		{
			if(i!=arrOfStud.length-1 && arrOfStud[i].getTotalMarks()!=arrOfStud[i+1].getTotalMarks())
			{
					continue;
			}
			else if(i==arrOfStud.length-1) break;

			else
			{
				int startpos=i,endpos=0;
				while(i!=arrOfStud.length-1 && arrOfStud[i].getTotalMarks()==arrOfStud[i+1].getTotalMarks())
					i++;
				endpos=i;

				for(int k=startpos;k<i;k++)
				{
					for(int m=k+1;m<=i;m++)
					{
						/*
						 	subandcomp(double[],double[]): 
						 	#This function takes two arrays and returns the value -1,0 or 1 depending upon the
						 	first different values encountered in the arrays. 
						 	#It is used to decide which student has higher marks, if any, in a higher priority subject.
						*/

						int temp=subandcomp(arrOfStud[k].getAllMarksInArray(),arrOfStud[m].getAllMarksInArray());
						if(temp<0)
						{
							Student tempholder=arrOfStud[k];
							arrOfStud[k]=arrOfStud[m];
							arrOfStud[m]=tempholder;
						}
						else if(temp==0)
						{
							/*
								Criteria 3: Ranking on the basis of lexicographic position of name.
							*/

							int val=(arrOfStud[k].getName().compareTo(arrOfStud[m].getName()));
							if(val>0)
							{
								Student tempholder=arrOfStud[k];
								arrOfStud[k]=arrOfStud[m];
								arrOfStud[m]=tempholder;
							}
						}
					}
				}
			}
		}

		for(int i=0;i<arrOfStud.length;i++)
			arrOfStud[i].setRank(i+1);
	}

	/*
		This function is used in startRanking() to decide which student has 
		higher marks, if any, in a higher priority subject.
	*/
	public int subandcomp(double arr1[], double arr2[])
	{
		int len=arr1.length;
		for(int i=0;i<len;i++)
		{
			double res=arr1[i]-arr2[i];
			if(res==0) continue;
			else if(res>0) return 1;
			else return -1;
		}
		return 0;
	}

	public void printer()
	{
		for(int i=0;i<arrOfStud.length;i++)
		{
			arrOfStud[i].printdetails();
			System.out.println("-------------------");
			System.out.println();
		}
	}
}

public class StudentRanking
{
	static StudentGroup sgrp;
	public static void main(String args[])
	{
		int num;
		System.out.print("Number of students: ");
		Scanner s=new Scanner(System.in);
		num=s.nextInt();
		System.out.println();
		System.out.println();
		Student arr[]=new Student[num];
		for(int i=0;i<num;i++)
		{
			System.out.println("\nDetails of Student: "+(i+1));
			System.out.print("\nName: ");
			s.nextLine();
			String name=s.nextLine();
			System.out.print("Roll: ");
			int roll=s.nextInt();
			double mrk[]=new double[5];
			System.out.print("Marks (in order): ");
			System.out.print("Maths,Science,ES,Lang1,Lang2: ");
			for(int j=0;j<5;j++)
				mrk[j]=s.nextDouble();
			arr[i]=new Student(name,roll,mrk);
		}
		sgrp=new StudentGroup(arr);
		System.out.println();
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Rank List: ");
		System.out.println("-------------------");	
		System.out.println();
		sgrp.printer();
	}
}
/** Author Nathan Kooy */
//received help from http://www.java-forums.org/new-java/25914-4x4-2d-array-card-game-need-solving.html


import java.util.*;

	
public class HW3ptwo //prompting user and calling the game methods
	{
	public static void main(String[] args){
	String pl="";
	Scanner keyboard=new Scanner(System.in);
	System.out.println("Enter the card coordinate for each card when requested");
	System.out.println();
	do
	{
	brd();
	System.out.println("you've won");
	System.out.println("Play again? Yes/No(Y/N)");
	pl=keyboard.next();
	}while (pl.equals("y")||pl.equals("Y"));
	System.out.println("Thank You for playing");
	}
	
	
	//print the board
	public static void brd(){
	int cards[][]=new int[4][4];
	boolean cs[][]=new boolean[4][4];
	
	cards=shuffle();//calling shuffle method to place cards
	System.out.println("  |  1 2 3 4 ");
	System.out.println("-------------");
	for(int i=0;i<4;++i)
	{
	System.out.print(" " +(i+1) +" | ");
	for(int j=0;j<4;++j)
	{
	System.out.print("* ");
	cs[i][j]=false;
	}
	System.out.println();
	}
	System.out.println();
	str(cs,cards);
	}
	
	
	//game starts here
	public static void str(boolean[][] cs,int[][] cards){
	boolean ov=false;
	Scanner keyboard=new Scanner(System.in);
	
	char rw0,rw1,cl0,cl1;
	int r1,c1;
	int r2=0,c2=0,tmr=5000;
	
	do
	{
	do
	{
	System.out.print("Please enter the first card coordinates"); //collecting first
	String rw=new String(keyboard.next());
	rw0=rw.charAt(0);cl0=rw.charAt(1);
	r1=Character.digit(rw0,5);c1=Character.digit(cl0,5);
	if(cs[r1-1][c1-1] == true)
	{
	System.out.println("This card is already flipped! Select another card.");
	}
	
	}while(cs[r1-1][c1-1]!= false);
	do
	{
	System.out.print("Please enter the second card coordinates:"); //collecting second card
	String rw11=new String(keyboard.next());
	rw1=rw11.charAt(0);cl1=rw11.charAt(1);
	r2=Character.digit(rw1,5);c2=Character.digit(cl1,5);

	}while((cs[r2-1][c2-1]!= false)||((r1==r2)&&(c1==c2))); // reprinting board with the flipped cards
	r1--;
	c1--;
	r2--;
	c2--;
	System.out.println();
	System.out.println(" | 1 2 3 4 ");
	System.out.println("---+---------");
	for (int r=0; r<4; r++)
	{
	System.out.print(" " +(r+1) +" | ");
	
	for (int c=0; c<4; c++)
	{
	
		if ((r==r1)&&(c==c1))
	{
	
			System.out.print(cards[r][c] +" ");
	}
	
		else if((r==r2)&&(c==c2))
	{
	
			System.out.print(cards[r][c] +" ");
	}
	
		else if (cs[r][c] == true)
	{
	
			System.out.print(cards[r][c] +" ");
	}
	else
	{
	System.out.print("* ");
	}
	}
	System.out.println();
	}
	System.out.println();
	if (cards[r1][c1]==cards[r2][c2]) // to keep the card flipped
	{
	System.out.println("Cards Matched!");
	
	cs[r1][c1] = true;
	cs[r2][c2] = true;
	}

	try
	{
	Thread.sleep(2000);
	
	}catch (InterruptedException ie)
	{
	System.out.println(ie.getMessage());
	}
	for (int b=0; b<=20; b++){
	System.out.println();
	}
	System.out.println(" | 1 2 3 4 ");
	System.out.println("---+---------");
	
	for (int r=0; r<4; r++) // reprint the board so a new guess can be made
	{
	System.out.print(" " +(r+1) +" | ");
	for (int c=0; c<4; c++)
	{
	if (cs[r][c] == true)
	{
	System.out.print(cards[r][c] +" ");
	}
	else
	{
	System.out.print("* ");
	}
	}
	System.out.println();
	}
	System.out.println();
	ov = true;
	for (int r=0; r<4; r++) // game will not end unless all cards are flipped
	{
	for (int c=0; c<4; c++)
	{
	if(cs[r][c]==false)
	{
	ov = false;
	c=5;
	}
	}
	if(ov == false)
	{
	r=5;
	}
	}
	} while(ov != true); // loop, the only way to get out is to finish the game!
	}
	
	
	
	//shuffle the cards
	public static int[][] shuffle(){
	int start[]={1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8};
	int cards[][]=new int[4][4];
	Random ran=new Random();
	int tmp,i;
	for (int s=0; s<=20; s++)
	{
	for (int x=0; x<16; x++) //randomize the card placements
	{
	i=ran.nextInt(100000)%15;
	tmp=start[x];
	start[x]=start[i];
	start[i]=tmp;
	}
	}
	i=0;
	
	for (int r=0; r<4; r++) // put values in cards here
	{
	for (int c=0; c<4; c++)
	{
	cards[r][c]=start[i];
	i=i+1;
	}
	}
	return cards;
	}
}


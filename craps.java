import javax.swing.JOptionPane;
public class craps
{
	public static void main(String[] args)
	{
		
		int bank = 1000;
		boolean continu = true;
		while (continu)
		{
			String con,
				   bet;
			int bet_x,
				co;

			bet = JOptionPane.showInputDialog("Enter how much you would like to bet");
			bet_x = Integer.parseInt (bet);

			while (bet_x <= 0 || bet_x > bank)
				{
					System.out.println("try again, enter bet amount");
					bet = JOptionPane.showInputDialog("Enter how much you would like to bet");
					bet_x = Integer.parseInt (bet);
				}
			int die_a,
				die_b,
				die_c,
				die_d,
				sum,
				counts;
					boolean plays = true;
					counts = 0 ;
					System.out.println("Begin. bank = "+bank+"");
					while (plays)
						{
							boolean pass = true;
							boolean dont_pass = true;
							String pass_x;
							int p;
							pass_x = JOptionPane.showInputDialog("Enter 1 to bet on pass line. Enter any other number to bet on don't pass line");
							p = Integer.parseInt (pass_x);
							if (p == 1)
							{
								pass = true;
								dont_pass = false;
							}
							else
							{
								pass = false;
								dont_pass = true;
							}
							while (pass)
							{
								die_a = 1 + (int) (Math.random() * 6);
								die_b = 1 + (int) (Math.random() * 6);
								sum = die_a + die_b;
								System.out.println(die_a+" "+die_b+"");
								counts = counts + 1;
								if (sum == 7 || sum == 11)
									{
										bank = bank + bet_x;
										System.out.println("win, bank = "+bank+"");
										pass = false;
										plays = false;
									} 
								else if (sum == 2 || sum == 3 || sum ==12)
									{
										bank = bank - bet_x;
										System.out.println("loss, bank = "+bank+"");
										pass = false;
										plays = false;
									} 
								else 
									{
									boolean on = true;
									int point = sum;
									System.out.println(""+sum+" is now 'point'");
									while (on)
										{
										die_c = 1 + (int) (Math.random() * 6);
										die_d = 1 + (int) (Math.random() * 6);
										sum = die_c + die_d;
										System.out.println(die_c+" "+die_d+"");
										counts = counts + 1;
										if (sum == point)
											{
												bank = bank + bet_x;
												System.out.println("win, bank = "+bank+"");
												on = false;
												pass = false;
												plays = false;
											}
										else if (sum == 7)
											{
												bank = bank - bet_x;
												System.out.println("loss, bank = "+bank+"");
												plays = false;
												pass = false;
												break;
											}
										else
											{
												System.out.println("roll again, bank = "+bank+"");
											}
										} //while(on)
									}//else
								}//while(pass)

									while (dont_pass)
									{
										die_a = 1 + (int) (Math.random() * 6);
										die_b = 1 + (int) (Math.random() * 6);
										sum = die_a + die_b;
										System.out.println(die_a+" "+die_b+"");
										counts = counts +1;
										if (sum == 7 || sum == 11)
											{
											bank = bank - bet_x;
											System.out.println("loss, bank = "+bank+"");
											dont_pass = false;
											plays = false;
											} 
										else if (sum == 2 || sum == 3 || sum ==12)
											{
											bank = bank + bet_x;
											System.out.println("win, bank = "+bank+"");
											dont_pass = false;
											plays = false;
											} 
										else 
											{
											boolean on = true;
											int point = sum;
											System.out.println(""+sum+" is now 'point'");
											while (on)
												{
												die_c = 1 + (int) (Math.random() * 6);
												die_d = 1 + (int) (Math.random() * 6);
												sum = die_c + die_d;
												System.out.println(die_c+" "+die_d+"");
												counts = counts + 1;
												if (sum == point)
													{
														bank = bank - bet_x;
														System.out.println("loss, bank = "+bank+"");
														on = false;
														dont_pass = false;
														plays = false;
													}
												else if (sum == 7)
													{
														bank = bank + bet_x;
														System.out.println("win, turn is over, bank = "+bank+"");
														plays = false;
														dont_pass = false;
														plays = false;
														break;
													}
												else
													{
													System.out.println("roll again, bank = "+bank+"");
													}
												}//while(on)
											}//else
									}//while(dont_pass)
						}//while(plays)
			if (bank != 0)
				{
				con = JOptionPane.showInputDialog("Enter 1 to keep playing. Enter any other number to stop playing.");
				co = Integer.parseInt (con);
				if (co == 1)
					{
						continu = true;
					}
					else
					{
						continu = false;
					}
				}
				else
				{
					continu = false;
				}
		}
		System.out.println("Thanks for playing");
		System.exit(0);
	}
}
import java.util.*;
import static java.lang.System.*;
import java.lang.reflect.Array;
public class MindnightDriver {
	public static void main(String[] args){
		String str = "";
		Scanner input = new Scanner(System.in);
		out.println("How many players?");
		int players = input.nextInt();
		String[] names = new String[players];
		out.println("Enter names:");
		for(int i = 0; i < names.length; i++)
			names[i] = input.next();
		String temp = "";
		for(int i = 0; i < names.length; i++){
			int x = (int)(Math.random()*players); 
			int y = (int)(Math.random()*players); 
			temp = names[x];
			names[x] = names[y];
			names[y] = temp;
		}
		Hacker[] roles = new Hacker[players];
		for(int i = 0; i < roles.length; i++){
			if(players % 2 == 0){
				if(i < Math.floor(((double)players) / 2 - 1))
					roles[i] = new Hacker(names[i], "");
				else
					roles[i] = new Hacker(names[i]);
			}
			else{ 
				if(i < Math.floor(((double)players) / 2))
					roles[i] = new Hacker(names[i], "");
				else
					roles[i] = new Hacker(names[i]);
			}
		}
		for(int i = 0; i < names.length; i++)
			out.println(roles[i].getName() + " -- " + roles[i].getRole());		
		Nodes[] nodes = new Nodes[5];
		int proposer = (int)(Math.random()*players); 
		int attempt = 1;
		int secured = 0, hacked = 0;
		int accept = 0;

		if(players == 5){
			boolean hammer = true;
			for(int i = 0; i < 6; i++){
				if(i == 5){
					hammer = false;
					out.println("Hacker win by default.");
					hacked++;
					break;
				}
				accept = proposal2(nodes, names, 0, proposer);
				if(proposer != players - 1)
					proposer++;
				else
					proposer = 0; 
				if(accept > players - accept)
					break;
			}
			if(hammer != false)
				str = secureOrHack(nodes, names, roles, secured, hacked, 0);
			if(str.equals("Secured")){
				secured++;
				out.println(str);
			}
			else{
				hacked++;
				out.println(str);
			}
			
			hammer = true;
			for(int i = 0; i < 6; i++){
				if(i == 5){
					hammer = false;
					out.println("Hacker win by default.");
					hacked++;
					break;
				}
				accept = proposal3(nodes, names, 1, proposer);
				if(proposer != players - 1)
					proposer++;
				else
					proposer = 0; 
				if(accept > players - accept)
					break;
			}
			if(hammer != false)
				str = secureOrHack(nodes, names, roles, secured, hacked, 1);
			if(str.equals("Secured")){
				secured++;
				out.println(str);
			}
			else{
				hacked++;
				out.println(str);
			}

			hammer = true;
			for(int i = 0; i < 6; i++){
				if(i == 5){
					hammer = false;
					out.println("Hacker win by default.");
					hacked++;
					break;
				}
				accept = proposal2(nodes, names, 2, proposer);
				if(proposer != players - 1)
					proposer++;
				else
					proposer = 0; 
				if(accept > players - accept)
					break;
			}
			if(hammer != false)
				str = secureOrHack(nodes, names, roles, secured, hacked, 2);
				if(str.equals("Secured")){
					secured++;
					out.println(str);
				}
				else{
					hacked++;
					out.println(str);
				}
			if(secured == 3)
				out.println("Agents win!");
			else if(hacked == 3)
				out.println("Hackers win!");
			
			else{
				hammer = true;
				for(int i = 0; i < 6; i++){
					if(i == 5){
						hammer = false;
						out.println("Hacker win by default.");
						hacked++;
						break;
					}
					accept = proposal3(nodes, names, 3, proposer);
					if(proposer != players - 1)
						proposer++;
					else
						proposer = 0; 
					if(accept > players - accept)
						break;
				}
				if(hammer != false)
					str = secureOrHack(nodes, names, roles, secured, hacked, 3);
					if(str.equals("Secured")){
						secured++;
						out.println(str);
					}
					else{
						hacked++;
						out.println(str);
					}
				if(secured == 3)
					out.println("Agents win!");
				else if(hacked == 3)
					out.println("Hackers win!");
				
				else{
					hammer = true;
					for(int i = 0; i < 6; i++){
						if(i == 5){
							hammer = false;
							out.println("Hacker win by default.");
							hacked++;
							break;
						}
						accept = proposal3(nodes, names, 4, proposer);
						if(proposer != players - 1)
							proposer++;
						else
							proposer = 0; 
						if(accept > players - accept)
							break;
					}
					if(hammer != false)
						str = secureOrHack(nodes, names, roles, secured, hacked, 4);
					if(str.equals("Secured")){
						secured++;
						out.println(str);
					}
					else{
						hacked++;
						out.println(str);
					}
					if(secured == 3)
						out.println("Agents win!");
					else
						out.println("Hackers win!");
				}
			}
		}
		if(players == 6)
		{
			boolean hammer = true;
			for(int i = 0; i < 6; i++){
				if(i == 5){
					hammer = false;
					out.println("Hacker win by default.");
					hacked++;
					break;
				}
				accept = proposal2(nodes, names, 0, proposer);
				if(proposer != players - 1)
					proposer++;
				else
					proposer = 0; 
				if(accept > players - accept)
					break;
			}
			if(hammer != false)
				str = secureOrHack(nodes, names, roles, secured, hacked, 0);
			if(str.equals("Secured")){
				secured++;
				out.println(str);
			}
			else{
				hacked++;
				out.println(str);
			}
			
			hammer = true;
			for(int i = 0; i < 6; i++){
				if(i == 5){
					hammer = false;
					out.println("Hacker win by default.");
					hacked++;
					break;
				}
				accept = proposal3(nodes, names, 1, proposer);
				if(proposer != players - 1)
					proposer++;
				else
					proposer = 0; 
				if(accept > players - accept)
					break;
			}
			if(hammer != false)
				str = secureOrHack(nodes, names, roles, secured, hacked, 1);
			if(str.equals("Secured")){
				secured++;
				out.println(str);
			}
			else{
				hacked++;
				out.println(str);
			}

			hammer = true;
			for(int i = 0; i < 6; i++){
				if(i == 5){
					hammer = false;
					out.println("Hacker win by default.");
					hacked++;
					break;
				}
				accept = proposal4(nodes, names, 2, proposer);
				if(proposer != players - 1)
					proposer++;
				else
					proposer = 0; 
				if(accept > players - accept)
					break;
			}
			if(hammer != false)
				str = secureOrHack(nodes, names, roles, secured, hacked, 2);
				if(str.equals("Secured")){
					secured++;
					out.println(str);
				}
				else{
					hacked++;
					out.println(str);
				}
			if(secured == 3)
				out.println("Agents win!");
			else if(hacked == 3)
				out.println("Hackers win!");
			
			else{
				hammer = true;
				for(int i = 0; i < 6; i++){
					if(i == 5){
						hammer = false;
						out.println("Hacker win by default.");
						hacked++;
						break;
					}
					accept = proposal3(nodes, names, 3, proposer);
					if(proposer != players - 1)
						proposer++;
					else
						proposer = 0; 
					if(accept > players - accept)
						break;
				}
				if(hammer != false)
					str = secureOrHack(nodes, names, roles, secured, hacked, 3);
					if(str.equals("Secured")){
						secured++;
						out.println(str);
					}
					else{
						hacked++;
						out.println(str);
					}
				if(secured == 3)
					out.println("Agents win!");
				else if(hacked == 3)
					out.println("Hackers win!");
				
				else{
					hammer = true;
					for(int i = 0; i < 6; i++){
						if(i == 5){
							hammer = false;
							out.println("Hacker win by default.");
							hacked++;
							break;
						}
						accept = proposal4(nodes, names, 4, proposer);
						if(proposer != players - 1)
							proposer++;
						else
							proposer = 0; 
						if(accept > players - accept)
							break;
					}
					if(hammer != false)
						str = secureOrHack(nodes, names, roles, secured, hacked, 4);
					if(str.equals("Secured")){
						secured++;
						out.println(str);
					}
					else{
						hacked++;
						out.println(str);
					}
					if(secured == 3)
						out.println("Agents win!");
					else
						out.println("Hackers win!");
				}
			}
		}
	}
	public static int proposal2(Nodes[] nodes, String[] names, int h, int p){
		VoteHistory node;
		String[] history = new String[names.length];
		Scanner input = new Scanner(System.in);
		out.println(names[p] + ", pick two");
		nodes[h] = new Nodes(input.next(), input.next());
		out.print(nodes[h] + "\nAccept?");
		int accept = 0;
		if(names.length == 5)
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next());
		else if(names.length == 6)
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next(), input.next());
		else if(names.length == 7)
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next(), input.next(), input.next());
		else
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next(), input.next(), input.next(), input.next());
		String split = node.Array();
		history = split.split(" ");
		for(int i = 0; i < names.length; i++){
			out.println(names[i] + " -- " + history[i]);
			if(history[i].equals("yes"))
				accept++;
		}
		return accept;
	}
	public static int proposal3(Nodes[] nodes, String[] names, int h, int p){
		VoteHistory node;
		String[] history = new String[names.length];
		Scanner input = new Scanner(System.in);
		out.println(names[p] + ", pick three");
		nodes[h] = new Nodes(input.next(), input.next(), input.next());
		out.print(nodes[h] + "\nAccept?");
		int accept = 0;
		if(names.length == 5)
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next());
		else if(names.length == 6)
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next(), input.next());
		else if(names.length == 7)
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next(), input.next(), input.next());
		else
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next(), input.next(), input.next(), input.next());
		String split = node.Array();
		history = split.split(" ");
		for(int i = 0; i < names.length; i++){
			out.println(names[i] + " -- " + history[i]);
			if(history[i].equals("yes"))
				accept++;
		}
		return accept;
	}
	public static int proposal4(Nodes[] nodes, String[] names, int h, int p){
		VoteHistory node;
		String[] history = new String[names.length];
		Scanner input = new Scanner(System.in);
		out.println(names[p] + ", pick four");
		nodes[h] = new Nodes(input.next(), input.next(), input.next(), input.next());
		out.print(nodes[h] + "\nAccept?");
		int accept = 0;
		if(names.length == 5)
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next());
		else if(names.length == 6)
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next(), input.next());
		else if(names.length == 7)
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next(), input.next(), input.next());
		else
			node = new VoteHistory(input.next(), input.next(), input.next(), input.next(), input.next(), input.next(), input.next(), input.next());
		String split = node.Array();
		history = split.split(" ");
		for(int i = 0; i < names.length; i++){
			out.println(names[i] + " -- " + history[i]);
			if(history[i].equals("yes"))
				accept++;
		}
		return accept;
	}
	public static String secureOrHack(Nodes[] nodes, String[] names, Hacker[] roles, int secured, int hacked, int n)
	{
		int f = 0;
		int hackers = 0;
		boolean vote = true;
		Scanner input = new Scanner(System.in);	
		out.print(nodes[n]);
		out.println(", secure or hack?");
		for(int i = 0; i < names.length; i++){
			if(nodes[n].getMem1().equals(names[i])){
				f = i;
				if(roles[f].getRole().equals("Hacker"))
					if(input.next().equals("hack")){
						hackers++;
						vote = false;
						hacked++;
					}
			}
			if(nodes[n].getMem2().equals(names[i])){
				f = i;
				if(roles[f].getRole().equals("Hacker"))
					if(input.next().equals("hack")){
						hackers++;
						vote = false;
						hacked++;
					}
			}
			if(nodes[n].getMem3().equals(names[i])){
				f = i;
				if(roles[f].getRole().equals("Hacker"))
					if(input.next().equals("hack")){
						hackers++;
						vote = false;
						hacked++;
					}
			}
			if(nodes[n].getMem4().equals(names[i])){
				f = i;
				if(roles[f].getRole().equals("Hacker"))
					if(input.next().equals("hack")){
						hackers++;
						vote = false;
						hacked++;
					}
			}
		}
		if(vote == true)
			return "Secured";
		else
			return "Hacked: " + hackers + " hacker(s) detected.";

	}
}

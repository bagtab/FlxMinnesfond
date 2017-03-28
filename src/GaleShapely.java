import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class GaleShapely{
	LinkedList<Man> free;		//will be used as a queue
	Man[] husband;
	Woman[] wife;
	Man[] men;
	Woman[] women;
	Man man;
	Woman woman;
	int n;
	String output = "";
	void init(String str) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(str));
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			System.out.println(s);
			if (s.contains("#")|| s.length() == 0){}
			else if(s.contains( "n=")){
				n = Integer.parseInt((s.split("\\D+"))[1]);
				husband = new Man[n];
				wife = new Woman[n];
				men = new Man[n];
				women = new Woman[n];
			}else if(s.split("\\s").length == 2){
				int d = Integer.parseInt(s.split("\\s")[0]);
				if(d%2 == 1){
					men[(d-1)/2] = new Man(s);
				}
				else{
					women[(d-1)/2] = new Woman(s);
				}
			}else{
				String[] tmp = s.split(":\\s");
				int d = Integer.parseInt(tmp[0]);
				if(d%2 == 1){
					men[(d-1)/2].setup(tmp[1]);
				}else{
					women[(d-1)/2].setup(tmp[1]);
				}
			}
		}
		
		sc.close();
	}
	public void algorithm(){
		free = new LinkedList<Man>();
		for(int i = 0; i < men.length; i++){
			free.add(men[i]);
		}
		while(!free.isEmpty()){
			man = free.poll();
			while(match()){
				
			}
		}
		for(int i = 0; i < wife.length; i++){
			System.out.println(men[i].name + " -- " + wife[men[i].getVal()].name);
			output += men[i].name + " -- " + wife[men[i].getVal()].name + "\n";
		}
	}
	private boolean match() {
		woman = man.pref[man.pointer];
		if(husband[woman.getVal()] == null){
			husband[woman.getVal()] = man;
			wife[man.getVal()] = woman;
			return false;
		}else{
			Man man2 = husband[woman.getVal()];
			if(woman.invers[man.getVal()] < woman.invers[man2.getVal()]){
				free.add(man2);
				husband[woman.getVal()] = man;
				wife[man.getVal()] = woman;
				return false;
			}
			else{
				man.pointer++;
				return true;
			}
		}
	}
	/*
	Efficient implementation. We describe an O(n 2) time implementation.
	Representing men and women.
	Assume men are named 1, …, n.
	Assume women are named 1', …, n'.
	Representing the matching.
	Maintain a list of free men (in a stack or queue).
	Maintain two arrays wife[m] and husband[w].
	- if m matched to w, then wife[m] = w and husband[w] = m
	set entry to 0 if unmatched
	*/
	private class Man{
/*		Men proposing.
		For each man, maintain a list of women, ordered by preference.
		For each man, maintain a pointer to woman in list for next proposal.*/
		Integer nbr;
		String name;
		Woman[] pref;
		int pointer;
		private Man(String s){
			String[] tmp = s.split("\\s");
			nbr = Integer.parseInt(tmp[0]);
			nbr/=2;
			name = tmp[1];
			men[nbr] = this;
			pref = new Woman[n];
		}
		Integer getVal(){
			return nbr;
		}
		void setup(String s){
			String[] data = s.split("\\D+");
			for(int i = 0; i < data.length; i++){
				pref[i] = women[(Integer.parseInt(data[i])- 1)/2];
			}
			pointer = 0;
		}
	}
	private class Woman{
/*		Women rejecting/accepting.
		Does woman w prefer man m to man m' ?
		For each woman, create inverse of preference list of men.
		Constant time access for each query after O(n) preprocessing.*/	
		Integer nbr;
		String name;
		Man[] pref;
		Integer[] invers;
		private Woman(String s){
			String[] tmp = s.split("\\s");
			nbr = Integer.parseInt(tmp[0]);
			nbr/=2;
			nbr--;
			name = tmp[1];
			women[nbr] = this;
			invers = new Integer[n];
			pref = new Man[n];
		}
		Integer getVal(){
			return nbr;
		}
		void setup(String s){
			String[] data = s.split("\\D");
			for(int i = 0; i < data.length; i++){
				pref[i] = men[(Integer.parseInt(data[i])- 1)/2];
			}
			for(int i = 0; i < pref.length; i++){
				invers[pref[i].getVal()] = i;
			}
		}
	}
/*	function stableMatching {
	    Initialize all m  M and w  W to free
	    while free man m who still has a woman w to propose to {
	       w = first woman on m’s list to whom m has not yet proposed
	       if w is free
	         (m, w) become engaged
	       else some pair (m', w) already exists
	         if w prefers m to m'
	            m becomes free
	           (m, w) become engaged 
	         else
	           (m, w) remain engaged
	    }
	}*/
}


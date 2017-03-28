import java.io.FileNotFoundException;

public class GS {
	public static void main(String[] args) throws FileNotFoundException{
		GaleShapely gs = new GaleShapely();
		String str = args[0] + ".txt";
//		String str = "sm-kt-p-4-in.txt";
		gs.init(str);
		gs.algorithm();
	}
}

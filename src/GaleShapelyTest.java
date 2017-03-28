import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

import org.junit.Test;

public class GaleShapelyTest {

	@Test
	public void test1() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-kt-p-4-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-kt-p-4-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test2() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-kt-p-5-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-kt-p-5-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test3() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-random-5-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-random-5-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test4() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-friends-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-friends-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test5() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-illiad-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-illiad-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test6() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-bbt-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-bbt-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test7() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-random-50-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-random-50-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test8() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-random-500-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-random-500-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test9() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-worst-5-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-worst-5-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test10() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-worst-50-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-worst-50-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
	@Test
	public void test11() throws FileNotFoundException {
		GaleShapely gs = new GaleShapely();
		String str = "sm-worst-500-in.txt";
		gs.init(str);
		gs.algorithm();
		File f = new File("sm-worst-500-out.txt");
		Scanner scanner = new Scanner( f);
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		assertEquals(text, gs.output);
	}
}

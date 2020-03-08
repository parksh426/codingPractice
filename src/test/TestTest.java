package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import main.*;

public class TestTest {

	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testSolution1() throws Exception{
		
		
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		String result = TestProgram.solution(participant, completion);
		System.out.println("[" + result + "]");
		assertEquals("leo", result);

		result = TestProgram.solution2(participant, completion);
		System.out.println("[" + result + "]");
		assertEquals("leo", result);
		
		result = TestProgram.solution3(participant, completion);
		System.out.println("[" + result + "]");
		assertEquals("leo", result);
		
		result = TestProgram.solution4(participant, completion);
		System.out.println("[" + result + "]");
		assertEquals("leo", result);
	}
}

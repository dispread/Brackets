package brackets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BracketsTest {
	
	@Test
	void test_invalid() {
		assert(Brackets.checkVariedBrackets("("			) == false);
		assert(Brackets.checkVariedBrackets("(()"		) == false);
		assert(Brackets.checkVariedBrackets("{}"		) == false);
		assert(Brackets.checkVariedBrackets("[]"		) == false);
		assert(Brackets.checkVariedBrackets("{[]}"	) == false);
		assert(Brackets.checkVariedBrackets("[(])"	) == false);
		assert(Brackets.checkVariedBrackets("{()}"	) == false);
		assert(Brackets.checkVariedBrackets("{[(])}") == false);
		assert(Brackets.checkVariedBrackets("()([])") == false);
		assert(Brackets.checkVariedBrackets("{{}}"	) == false);
		assert(Brackets.checkVariedBrackets("[[]]"	) == false);
		assert(Brackets.checkVariedBrackets("{[()}]") == false);
	}
	
	@Test
	void test_valid() {
		assert(Brackets.checkVariedBrackets("()") == true);
	}

}

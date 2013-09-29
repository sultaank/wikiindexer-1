/**
 * 
 */
package edu.buffalo.cse.ir.wikiindexer.tokenizer.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import edu.buffalo.cse.ir.wikiindexer.IndexerConstants;
import edu.buffalo.cse.ir.wikiindexer.tokenizer.TokenizerException;

/**
 * @author nikhillo
 *
 */
@RunWith(Parameterized.class)
public class WhitespaceRuleTest extends TokenizerRuleTest {

	public WhitespaceRuleTest(Properties props) {
		super(props, IndexerConstants.WHITESPACERULE);
	}
	
	@Test
	public void testRule() {
		if (rule == null) {
			fail("Rule not implemented");
		} else {
			try {
				assertArrayEquals(new Object[]{"Music","in","Bristol","Cub","Records","artists","Billy","Cotton","Band","Show" }, 
						runtest("Music in Bristol Cub","Records artists","Billy Cotton Band Show"));
				assertArrayEquals(new Object[]{"this","is","a","test" }, 
						runtest("this    is     a      test"));
				assertArrayEquals(new Object[]{"this","is","a","test" }, 
						runtest("    this is a test       "));
				assertArrayEquals(new Object[]{"this","is","a","test" }, 
						runtest("this "
								+ "is \r"
								+ "a \n test"));
				assertArrayEquals(new Object[]{"thisisatest" }, 
						runtest("thisisatest"));
			} catch (TokenizerException e) {
				
			}
		}
	}

}

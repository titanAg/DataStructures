//Kyle Orcutt

import org.junit.*;
import static org.junit.Assert.*;

public class TestTrie {
	
	LowerCaseTrie trie;
	
	@Before
	public void initialize() {
		trie = new LowerCaseTrie();
	}
	
	@org.junit.Test
	public void emptyTrieTest() {
		assertTrue(!trie.contains("expert"));
	}
	
	@org.junit.Test
	public void simpleTrieContains1() {
		trie.add("expert");
		trie.add("coder");
		trie.add("seven");
		trie.add("advance");
		trie.add("November");
		assertTrue(trie.contains("expert"));
		assertTrue(trie.contains("seven"));
		assertTrue(trie.contains("coder"));
		assertTrue(trie.contains("November"));
		assertTrue(trie.contains("advance"));
	}
	
	@org.junit.Test
	public void simpleTrieContains2() {
		trie.add("expert");
		trie.add("coder");
		trie.add("seven");
		trie.add("advance");
		trie.add("November");
		assertTrue(trie.contains("NOVEMBER"));
		assertTrue(trie.contains("EXPERT"));
		assertTrue(trie.contains("SEVEN"));
		assertTrue(trie.contains("ADVANCE"));
		assertTrue(trie.contains("CODER"));
	}
	
	@org.junit.Test
	public void prefixTest1() {
		trie.add("hope");
		trie.add("coder");
		trie.add("codes");
		trie.add("coded");
		trie.add("November");
		assertTrue(!trie.contains("code"));
		assertTrue(!trie.contains("c"));
		assertTrue(!trie.contains("cod"));
		assertTrue(!trie.contains("co"));
	}
	
	@org.junit.Test
	public void prefixTest2() {
		trie.add("expert");
		trie.add("coder");
		trie.add("code");
		trie.add("codes");
		trie.add("coded");
		assertTrue(trie.contains("code"));
		assertTrue(trie.contains("coded"));
		assertTrue(trie.contains("codes"));
		assertTrue(trie.contains("coder"));
	}
	
	@org.junit.Test
	public void prefixTest3() {
		trie.add("sing");
		trie.add("song");
		trie.add("wrong");
		trie.add("singing");
		trie.add("long");
		assertTrue(!trie.contains("ng"));
		assertTrue(!trie.contains("s"));
		assertTrue(!trie.contains("ing"));
		assertTrue(!trie.contains("ong"));
	}
	
	
	@org.junit.Test
	public void simpleRemoveTest1() {
		trie.add("expert");
		trie.add("coder");
		trie.add("seven");
		trie.add("advance");
		trie.add("November");
		trie.remove("seven");
		assertTrue(!trie.contains("seven"));
	}
	
	@org.junit.Test
	public void simpleRemoveTest2() {
		trie.add("expert");
		trie.add("coder");
		trie.add("seven");
		trie.add("advance");
		trie.add("November");
		trie.remove("expert");
		trie.remove("coder");
		trie.remove("seven");
		trie.remove("advance");
		trie.remove("November");
		assertTrue(!trie.contains("expert"));
		assertTrue(!trie.contains("seven"));
		assertTrue(!trie.contains("coder"));
		assertTrue(!trie.contains("November"));
		assertTrue(!trie.contains("advance"));
	}
	
	@org.junit.Test
	public void doubleWordTest1() {
		trie.add("code");
		trie.add("seven");
		trie.add("advance");
		trie.add("code");
		trie.remove("code");
		assertTrue(!trie.contains("code"));
	}
	
	@org.junit.Test
	public void doubleWordTest2() {
		trie.add("code");
		trie.add("seven");
		trie.add("advance");
		trie.add("code");
		trie.remove("code");
		assertTrue(!trie.contains("code"));
		trie.add("code");
		assertTrue(trie.contains("code"));
	}
	
	@org.junit.Test
	public void prefixRemovalTest1() {
		trie.add("cod");
		trie.add("coding");
		trie.add("coded");
		trie.add("coder");
		trie.remove("cod");
		assertTrue(!trie.contains("cod"));
	}
	
	@org.junit.Test
	public void prefixRemovalTest2() {
		trie.add("coding");
		trie.add("coded");
		trie.add("coder");
		trie.remove("cod");
		assertTrue(trie.contains("coding"));
		assertTrue(trie.contains("coder"));
		assertTrue(trie.contains("coded"));
	}
	
}

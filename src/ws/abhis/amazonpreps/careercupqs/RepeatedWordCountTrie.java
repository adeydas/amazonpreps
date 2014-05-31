/*
 * You are given very huge file , with each line containing a single word. We have to give the count and word which is repeated most.
 * List of words: http://abhis.ws/wp-content/uploads/2014/05/list_of_words.txt.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RepeatedWordCountTrie {
	
	public class TrieNode {
		private char letter; //for prefix
		private TrieNode[] links; //for child nodes
		private boolean fullWord; //flag
		
		public TrieNode(char letter, TrieNode[] links, boolean fullWord) {
			this.letter = letter;
			this.links = links;
			this.fullWord = fullWord;
		}
		
		public char getLetter() {
			return letter;
		}
		
		public TrieNode[] getLinks() {
			return links;
		}
		
		public boolean getIsFullWord() {
			return fullWord;
		}
	}

	private List<String> listOfWords = new ArrayList<String>();
	private TrieNode trie = null;

	private void readList() throws IOException {
		URL words = new URL(
				"http://abhis.ws/wp-content/uploads/2014/05/list_of_words.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				words.openStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			listOfWords.add(inputLine);
		in.close();
	}
	
	//Insert into trie
	private void trieInsert(TrieNode trie, char c, boolean isFullWord) {
		if (trie == null) {
			//start building the trie\
			TrieNode secondChild = new TrieNode(c, null, isFullWord);
			TrieNode[] links = {secondChild};
			TrieNode firstChild = new TrieNode('.', links, false);
			trie = firstChild;
			return;
		}
		
		//check for links
		TrieNode[] l = trie.getLinks();
		for (int i=0; i<l.length; i++) {
			if (l[i].getLetter() == c) {
				trieInsert(l[i], c, isFullWord);
			}
		}
		
		//insert
		if (!isFullWord) {
			TrieNode tn = new TrieNode(c, null, false);
			TrieNode[] links = trie.getLinks();
			links[links.length+1] = tn;
			trie = new TrieNode(trie.getLetter(), links, trie.getIsFullWord());
		} else {
			TrieNode tn1 = new TrieNode('\0', null, true);
			TrieNode[] ll = {tn1};
			TrieNode tn = new TrieNode(c, ll, false);
			TrieNode[] links = trie.getLinks();
			links[links.length+1] = tn;
			trie = new TrieNode(trie.getLetter(), links, trie.getIsFullWord());
		}
	}
	
	private void traverseAndFind(char c) {
		if (c == '\0') {
			
		}
	}
	
	public void init() throws IOException {
		readList();
		traverseAndFind('.');
	}
	
	public static void main(String[] args) throws IOException {
		RepeatedWordCountTrie obj = new RepeatedWordCountTrie();
		obj.init();
	}

}

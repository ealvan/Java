package Trie;

public class Trie {

	private TrieNode root;
	 
    public Trie() {
        root = new TrieNode();
    }
 
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index]=temp;
                p = temp;
            }else{
                p=p.arr[index];
            }
        }
        p.isEnd=true;
    } 
   
    public boolean buscar(String word) {
        TrieNode p = buscarNodo(word);
        if(p==null){
            return false;
        }else{
            if(p.isEnd)
                return true;
        }
 
        return false;
    }
    public void prefijas(String cadena){
    	
    	for(int i = 0; i < 26; i++){
    		
    	}
    }
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean empieza(String prefix) {
        TrieNode p = buscarNodo(prefix);
        if(p==null){
            return false;
        }else{
            return true;
        }
    }
 
   	
    public TrieNode delete(String word) {
        return remove(root, word, 0);
    }
	public boolean isEmpty(TrieNode node){
		for(int i = 0; i < node.arr.length; i++){
			if(node.arr[i] != null){
				return false;
			}
		}
		return true;
	}
    private TrieNode remove(TrieNode root, String key, int depth){
    	if(root == null){
    		return null;
    	}
    	if(depth == key.length()){
    		if(root.isEnd){
    			root.isEnd = false;
    		}
    		if(isEmpty(root)){
    			root = null;
    		}
    		return root;
    	}
    	int index = key.charAt(depth)-'a';
    	root.arr[index] = remove(root.arr[index],key, depth+1);
    	if(isEmpty(root) && root.isEnd == false){
    		root = null;
    	}
    	return root;
    }
   public void display(){
	   char[] str = new char[26];
	   display(root,str,0);
   }
   public boolean isLeafNode(TrieNode root){
	   return root.isEnd != false;
   }
   private void display(TrieNode root, char[] str, int level){
	   if(isLeafNode(root)){
		   str[level] = '\0';
		  System.out.println(str);   
	   }
	   int i = 0;
	   for( i = 0; i < root.arr.length; i++){
		   if(root.arr[i] != null){
			   str[level] = (char)(i+'a');
			   display(root.arr[i],str, level +1);
		   }
	   }
   }
}




























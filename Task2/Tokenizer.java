import java.util.ArrayList;

public class Tokenizer {
	public ArrayList<Token> tokens;
	
	public Tokenizer() {
		this.tokens = new ArrayList<Token>();
	}
	
	public void createTokens(String expr) throws Exception{
		String aux = "";
		char caractere;
		for(int i = 0; i<expr.length(); i++) {
			caractere = expr.charAt(i);
			if(Character.isDigit(caractere)) {
				aux += caractere;
			}else if(caractere == ' ') {
				if(!aux.equals("")) {
					this.tokens.add(new Token(TokenType.NUM, aux));
					aux = "";
				}
			}else if(caractere == '+') {
				this.tokens.add(new Token(TokenType.PLUS, "+"));
			}else if(caractere == '-') {
				this.tokens.add(new Token(TokenType.MINUS, "-"));
			}else if(caractere == '*') {
				this.tokens.add(new Token(TokenType.STAR, "*"));
			}else if(caractere == '/'){
				this.tokens.add(new Token(TokenType.SLASH, "/"));
			}else {
				throw new Exception("Error: Unexpected character: " + caractere);
			}
		}
	}
}

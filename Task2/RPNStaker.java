/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote;

/**
 *
 * @author Pichau
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

public class RpnStacker {
    private Stack<Double> stack;

    public RpnStacker(){
            stack = new Stack<Double>();
            }
    public static void main(String[] args) throws Exception{
        RpnStacker analize = new RpnStacker();
        Tokenizer tokenizer = new Tokenizer();
        String operacao = "";
        Double solucao;
        
        FileReader arquivostk = new FileReader("C:\\Users\\Pichau\\Desktop\\compiladores\\Calc1.stk");
        BufferedReader lendoArquivo = new BufferedReader(arquivostk);
        String line = lendoArquivo.readLine();
        while (line != null) {
            operacao += line + " ";
            line = lendoArquivo.readLine(); //
          }
        tokenizer.createTokens(operacao);
        solucao = analize.analizar(tokenizer.tokens);
        System.out.println(solucao);
   }


   private Double analizarOperador(String operacao){
            Double solucao = null;
            Double num1 = this.stack.pop();
            Double num2 = this.stack.pop();

            switch (operacao)
            {
                case "+":
                    solucao = num1 + num2;
                    break;
                case "-":
                    solucao = num1 - num2;
                    break;
                case "*":
                    solucao = num1 * num2;
                    break;
                case "/":
                    solucao = num1 / num2;
                    break;
            }
            return solucao;
        }
        
	public Double analizar(ArrayList<Token> tokens) throws Exception{
			for(int i = 0; i <tokens.size(); i++) {
				if(tokens.get(i).type == TokenType.NUM) {
					stack.push(Double.parseDouble(tokens.get(i).lexeme));
				}else {
					stack.push(analizarOperador(tokens.get(i).lexeme));
				}
			}
			return stack.pop();
        }

     
}

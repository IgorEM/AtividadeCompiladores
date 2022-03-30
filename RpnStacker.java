/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote;

/**
 *
 * @author Pichau
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Stack;


public class RpnStacker {
    private Stack<Integer> stack;

    public RpnStacker(){
            stack = new Stack<Integer>();
            }
    public static void main(String[] args) throws Exception{
        String operacao;
        int solucao;
        RpnStacker analize = new RpnStacker();
        operacao = "";
        FileReader arquivostk = new FileReader("C:\\Users\\Pichau\\Desktop\\compiladores\\Calc2.stk");
        BufferedReader lendoArquivo = new BufferedReader(arquivostk);
        String line = lendoArquivo.readLine();
        while (line != null) {
            operacao += line + " ";
            line = lendoArquivo.readLine(); 
          }
        solucao = analize.analizar(operacao);
        System.out.println(solucao);
   }
   private int analizarOperador(char operacao, int num1, int num2){
    int solucao = 0;

        switch (operacao)
        {   
        case '%':
            solucao = num1 % num2;
            break;
        case '*':
            solucao = num1 * num2;
            break;
        case '/':
            solucao = num1 / num2;
            break;
        case '+':
            solucao = num1 + num2;
            break;
        case '-':
            solucao = num1 - num2;
            break;
        
        }
        return solucao;
    }
	public int analizar(String expr){
            int num1, num2, solucao = 0;
            String simbolo;
            Scanner in = new Scanner(expr);

            while (in.hasNext())        
            {
                simbolo = in.next();          

                if (identSimbolo(simbolo))
                {
                    num2 = (stack.pop()).intValue();
                    num1 = (stack.pop()).intValue();
                    solucao = analizarOperador(simbolo.charAt(0), num1, num2);
                    stack.push(solucao);
                }
                else
                	stack.push(Integer.parseInt(simbolo));       
            }

            return solucao;
        }

    private boolean identSimbolo(String simbolo){
            return ( simbolo.equals("+") || simbolo.equals("-") ||
                     simbolo.equals("*") || simbolo.equals("/") || simbolo.equals("%") );

        }
    
}

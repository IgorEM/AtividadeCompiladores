# AtividadeCompiladores

Task 1

Roteiro:
- rever a Aula 07 sobre notacao posfixa [reverse polish notation]
- Implementar uma linguagem RPN stacker em Java usando uma pilha como estrutura de dados
- Programa le um arquivo com a expressao em RPN e avaliar

Exemplo de entrada:
10
10
+
Saida: 20

**Arquivo exemplo da linguagem em anexo

***OBS: Sugerido usar um repositorio git para a solucao e postar o link aqui... ou seja, coloca o link e finaliza a task!



![image](https://user-images.githubusercontent.com/50914198/160900246-ee780f7e-bd5b-46cb-be9f-0faaa331e42f.png)

![image](https://user-images.githubusercontent.com/50914198/160900489-9ab14709-52bd-4d92-ae99-bede13124b3c.png)


Task 2

Roteiro:
- rever a Aula 11 sobre introducao a analise lexica [scanning]
- evoluir o projeto da Task 01 para implementar uma feature de scanning:
   -- No geral, nosso Programa le um arquivo com a expressao em RPN e devolve a expressao avalliada
   -- a feature de scanning deve retornar uma lista de tokens
   -- a partir dessa lista de tokens que e realizada a interpretacao das expressoes com uma pilha
   -- a feature de scanning deve retornar um erro caso nao reconheca um "num" [numero] ou "op" [operator]

Exemplo de entrada [com sucesso]:
10
10
+
// a lista de tokens reconhecida [caso a imprima]
Token [type=NUM, lexeme=10]
Token [type=NUM, lexeme=10]
Token [type=PLUS, lexeme=+]

Saida: 20

Exemplo de entrada [com falha]:
10
s
+
Error: Unexpected character: s

*Obs: para implementacao da lista de tokens, a classe Token e TokenType em anexo devera servir de suporte para o [manual] scanning
**Obs: obviamente minimas alteracoes podem ser feitas [ex: adaptar o pacote das classes em anexo para seu projeto]

Task 3

Como mostrado na [Aula 18], a gramatica atual da nossa RPN eh a seguinte:

Expr = num
         |  Expr Expr op

op    = [+-/*]
num = [0-9]+

** Agora nossa linguagem dara suporte para variaveis (IDs), por conseguinte, temos a seguinte mudanca gramatical:

Expr = num
         |  id
         | Expr Expr op

op    = [+-/*]
num = [0-9]+
id = ... regra livre de identificadores a seu criterio

** Baseada na gramatica acima [incluindo ID expr], atualize o projeto Postfix para dar suporte ao uso de variaveis/ids.

** Exemplos de entrada: 
10 10 +      =  20
10 y +        =  20 [onde y foi entrado com valor 10] ou seja, [y->10]
10 w +       = w cannot be resolved [onde w nao foi entrado no mapeamento... ou seja, apenas temos o y [y->10]


*** Dica para passar o environment [contexto da declaracao de variaveis]
- Na classe Interpreter crie um construtor que receba um HashMap e inicialize um atributo com o ambiente de variaveis, ex:

public class Interpreter implements Expr.Visitor<Integer> {
  public final HashMap<String, String> env;
  public Interpreter(HashMap<String, String> env){this.env = env;}
  ...
}

- Depois disso, atualizar na classe Postfix na criacao do objeto interpretador:

private static final Interpreter interpreter = new Interpreter();

para:

private static final Interpreter interpreter = new Interpreter(new HashMap<String, String>());

- Depois, ainda na classe Postfix, atualizar o metodo run() com o ambiente de variaveis. Dados os exemplos acima, onde temos a variavel y, teriamos:

private static void run(String source) {
...
 interpreter.env.put("y", "10");

 System.out.println(interpreter.interp(expr));
...
}

********OBS: Para submeter o codigo, atualizar seu git com o projeto e postar o link; apos isso marcar essa task como submetida.

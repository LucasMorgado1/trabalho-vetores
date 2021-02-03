import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author lucasmorgado
 */ 
public class OperacoesVetores{
  
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    Random gerador = new Random();
    
    int opc, n = 0, cont = 0, valor;
    int v[] = null;
    
    
    
    
    while( true ){
      System.out.println("");
      System.out.println("1 - cria e preenche o vetor.");
      System.out.println("2 - imprime vetor.");
      System.out.println("3 - Verificar se um número está no vetor.");
      System.out.println("4 - Buscar o maior número armazenado no vetor.");
      System.out.println("5 - Calcular a média dos números pares armazenados no vetor.");
      System.out.println("6 - Calcular o percentual dos números ímpares armazenados no vetor.");
      System.out.println("7 - Buscar a maior diferença absoluta entre números armazenados no vetor.");
      System.out.println("8 - Verificar se dado um valor existe dois números em posições distintas que somados são iguais ao valor.");
      System.out.println("9 - sair.");
      opc = ler.nextInt();
      System.out.println("");
      //Opcao 1 - Inicializar o Vetor com numeros aleatorios
      if(opc == 1 ){
        System.out.println("1 - criar um vetor.");
        System.out.println("Digite N: ");
        n = ler.nextInt(); 
        v = new int [n];
        
        while(cont < n){
          v[cont] = gerador.nextInt(100);
          cont++;
        }
      }
      //Opcao 2 - Imprimir o Vetor
      
      if(opc == 2){
        cont = 0;
        System.out.println("2- imprimir o vetor.");
        while(cont < n){
          System.out.println("O "+cont+ " numero eh: "+v[cont]);
          cont++;
        }
      }
      //Verificar se um determinado número está contido no vetor
      if(opc == 3 ){
        System.out.println("Digite o elemento de busca: ");
        int x = ler.nextInt();
        //boolean resultado = busca(x, num)
        if(busca(x, v) == true)
          System.out.print("True");
        else
          System.out.print("-1");
      }
      
      if(opc == 4){
        int idxmaior = busca_maior(v);
        System.out.println("O maior numero eh: "+idxmaior);
      }
      if(opc == 5){
        int mp = mediaPar(v)/v.length;
        System.out.println("A media eh: "+mp);
      }
      if(opc == 6){
        float porcent = porcentImp(v);
        System.out.printf("A porcentagem eh: %.0f%s\n",porcent,"%");
      }
      if(opc == 7){
        int valorAb = diferenca_absoluta (v);
        System.out.println("A diferenca absoulta eh: "+valorAb);
      }
      if(opc == 8){
        int x;
        boolean soma;
        System.out.println("Qual o numero desejado para comparar? ");
          x = ler.nextInt();
        soma = doisSoma(v, x);
        if(soma == true)
          System.out.println("true");
          else
          System.out.println("false");
      }
      if(opc == 9){
        break;
      }
      
      
    }
  }
  //funcao para procurar se o numero dado pelo usuario esta dentro da funcao
  public static boolean busca (int x, int v[]){
    for(int i = 0; i < v.length; i++){
      if(v[i] == x){
        return true;
      }
    }
    return false;
  }
  //fim da funcao que procura o numero dado pelo usario dentro da funcao
  public static int mediaPar (int v[]){
    int par = 0;
    
    for(int i = 0; i < v.length; i++){
      if(v[i]%2 == 0){
        par =  par + v[i];
      }
    }
    return par;
  }
  //Funcao que busca o maior numero entre os vetores
  public static int busca_maior (int v[]){
    int maior = 0;
    
    for(int i = 0; i < v.length; i++){
      if(v[i] > maior){
        maior = v[i];
      }
    }
    return maior;
  }
  //Funcao que calcula a porcentagem dos numeros Impares
  public static float porcentImp (int v[]){
    float valor, impar = 0;
    
    for(int i = 0; i < v.length; i++){
      if(v[i]%2 != 0){
        impar++;
      }
    }
    valor = (impar*100)/v.length;
    return valor;
  }
  //Funcao que calcula a diferenca absoluta entre o maior valor e o menor
  public static int diferenca_absoluta (int v[]){
    int maior = 0, menor = 90, valorAbso;
    
    for(int i = 0; i < v.length; i++){
      if(v[i] > maior){
        maior = v[i];
      }
      if(v[i] < menor){
        menor = v[i];
      }
    }
    valorAbso = Math.abs(maior - menor);
    return valorAbso;
  }
  public static boolean doisSoma (int v[], int x){
    //i vai ser fixo, vai ser a comparacao
    int temp;
    for(int i = 0; i < v.length; i++ ){
      temp = v[i];
      for(int j = 0; j < v.length; j++){
        if(v[i] + v[j] == x && i != j)
          return true;
      }          
    }
    return false;
  }
}

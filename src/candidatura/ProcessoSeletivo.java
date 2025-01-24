package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
		
		//Para cada candidato dentro do array, vamos entrar em contato
		for (String candidato : candidatos) {
			//Adiciona o candidato a lista de selecionados
			entrandoContato(candidato);
		}

		imprimirSelecionados();
		selecaoCandidatos();
	
	}

	//Método para entrar em contato com o candidato
	static void entrandoContato(String candidato) {
		//Cria um objeto da classe Random
		int tentativasRealizadas = 1;
		//Cria um booleano para continuar tentando
		boolean continuarTentando = true;
		//Cria um booleano para verificar se atendeu
		boolean atendeu = false;
		
		//Enquanto continuar tentando for verdadeiro
		do{
			//Verifica no auxiliar se atendeu
			atendeu = atender();
			//Se atendeu ele para de tentar
			continuarTentando = !atendeu;
			//Se continuar tentando ele vai somar mais uma tentativa
			if(continuarTentando)
				tentativasRealizadas++;
			
			//Se não continuar tentando ele finaliza
			else 

					System.out.println(" CONTATO REALIZADO COM SUCESSO!! ");

			//Enquanto isso for verdadeiro e tentativas realizadas for menor que 3
		}while (continuarTentando && tentativasRealizadas < 3);
		
		//Se atendeu ele vai imprimir a quantidade de tentativas realizadas
		if(atendeu) 
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato + "NA" + tentativasRealizadas);
		//Se não atendeu ele vai imprimir que não conseguiu contato com o candidato e a quantidade de tentativas realizadas
		else 
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + 
			", NÚMERO MÁXIMO DE TENTAIVAS REALIZADAS " + tentativasRealizadas);
	}

	static void imprimirSelecionados() {
		//Imprime a lista de candidatos
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

		System.out.println("Imprimindo a lista de candidatos pelo índice do elemento");

		//Imprime a lista de candidatos pelo índice do elemento
		for(int indice=0; indice < candidatos.length; indice++) {
			//Imprime o índice do elemento e o nome do candidato
			System.out.println("O candidato n° " + (indice+1) + " é o " + candidatos[indice]);
		}

		//Para cada candidato na lista de candidatos
		for(String candidato: candidatos){
			//Imprime o nome do candidato
			System.out.println("O candidato selecionado foi: " + candidato);
		}
	}
	
	static void selecaoCandidatos() {

		//Array lista de candidatos
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
		//Quantidade de candidatos selecionados
		int candidatosSelecionados = 0;
		
		int candidatoAtual = 0;
		//Salario para compar com o salario pretendido
		double salarioBase = 2000;

		//Enquanto a quantidade de candidatos selecionados for menor que 5 
		//e o candidato atual for menor que a quantidade de candidatos
		while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			//Pega o nome do candidato atual
			String candidato = candidatos[candidatoAtual];
			//Pega o valor pretendido pelo candidato atual
			double salarioPretendido = valorPretendido();

			//Imprime o nome do candidato e o valor pretendido
			System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
			//Analisando o salário do candidato atual
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				//Incrementa a quantidade de candidatos selecionados
				candidatosSelecionados++;
			} else {
				//Imprime que o candidato não foi selecionado
				System.out.println("O candidato " + candidato + " não foi selecionado para a vaga");
			}
			//Proximo candidato
			candidatoAtual++;
		}
	}

	//Para fazer um salário aleatorio entre 1800 e 2200
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}

	//Método auxiliar para entrar em contato
	static boolean atender() {
		//Gera um número aleatório entre 0 e 2
		return new Random().nextInt(3)==1;
	}
	
	//Método principal para analisar os candidatos a partir do salario pretendido
	static void analisarCandidato (double salarioPretendido) {
		//Salario para comparação
		double salarioBase = 2000.0;
		//Se o salario base for maior que o salario pretendido
		if (salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
			
		//Se o salario base for igual ao salario pretendido	
		} else if (salarioBase == salarioPretendido) 
			System.out.println("Ligar para o candidato com contra proposta");
			
		else {
			System.out.println("Aguardando o resultado dos demais candidatos");
		}
	}
}

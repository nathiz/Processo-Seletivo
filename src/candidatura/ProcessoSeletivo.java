package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
		
		for (String candidato : candidatos) {
			entrandoContato(candidato);
		}

		imprimirSelecionados();
		selecaoCandidatos();
	
	}

	static void entrandoContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		//Faz isso
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

			//Enquanto isso for verdadeiro
		}while (continuarTentando && tentativasRealizadas < 3);
	
		if(atendeu) 
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato + "NA" + tentativasRealizadas);
		else 
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + 
			", NÚMERO MÁXIMO DE TENTAIVAS REALIZADAS " + tentativasRealizadas);
	}

	static void imprimirSelecionados() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

		System.out.println("Imprimindo a lista de candidatos pelo índice do elemento");

		for(int indice=0; indice < candidatos.length; indice++) {
			System.out.println("O candidato n° " + (indice+1) + " é o " + candidatos[indice]);
		}

		for(String candidato: candidatos){
			System.out.println("O candidato selecionado foi: " + candidato);
		}
	}
	
	static void selecaoCandidatos() {

		//Array lista de candidatos
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000;

		while (candidatosSelecionados < 5) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();

			System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
			//Analisando o salário do candidato atual
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			} else {
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
		return new Random().nextInt(3)==1;
	}
	
	
	static void analisarCandidato (double salarioPretendido) {
		double salarioBase = 2000.0;
		if (salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
			
		} else if (salarioBase == salarioPretendido) 
			System.out.println("Ligar para o candidato com contra proposta");
			
		else {
			System.out.println("Aguardando o resultado dos demais candidatos");
		}
	}
}

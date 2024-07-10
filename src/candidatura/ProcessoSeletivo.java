package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		selecaoCandidatos();
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

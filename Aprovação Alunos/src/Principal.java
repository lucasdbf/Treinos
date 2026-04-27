import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String[] nomeAlunos = new String[100];
		
		int[] frequenciaAlunos = new int[100];
		
		double[][] tabelaNotas = new double[100][4];
		
		String cadastrarProximo = "s";
		
		System.out.println("== SISTEMA DE DESEMPENHO ACADÊMICO ==\n");
		
			for(int i = 0; i < nomeAlunos.length && cadastrarProximo.equalsIgnoreCase("s"); i++) {
				System.out.println("Nome do aluno " + (i + 1) + ":");
				nomeAlunos[i] = input.nextLine();
				for(int j = 0; j < 4; j++) {
					System.out.println("Média " + (j+1) + ":");
					tabelaNotas[i][j] = input.nextDouble();
					input.nextLine();
				}
				System.out.println("Frequência do aluno " + (i+1) + ":");
				frequenciaAlunos[i] = input.nextInt();
				input.nextLine();
				System.out.println("\nVocê deseja cadastrar mais um aluno? (s/n)");
				cadastrarProximo = input.nextLine();
			}

		
		// Output
		
		for(int b = 0; b < nomeAlunos.length; b++) {
			if(nomeAlunos[b] != null) {
				System.out.printf("Aluno: %s%n", nomeAlunos[b]);
				System.out.printf("Média: %.1f%n", calcularMedia(tabelaNotas[b]));
				System.out.printf("Situação: %s%n%n", gerarSituacao(tabelaNotas[b], frequenciaAlunos[b]));
			}
		}

	}
	public static String gerarSituacao(double[] notas,int frequencia) {
		double mediaFinal = calcularMedia(notas);
		
		if (mediaFinal >= 7 && frequencia >= 75) return "APROVADO";
		else return "REPROVADO";
	}
	public static  double calcularMedia(double[] notas) {
		double somaMedias = 0;
		for(int a = 0; a < notas.length; a++) {
			somaMedias += notas[a];
		}
		return somaMedias / 4;
	}
}

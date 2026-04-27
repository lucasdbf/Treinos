import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Definição da Tabela de Dados (Nomes e Preços por faixa)
        String[] nomesPapel = {
            "Couchê Brilho ADC5420", "Couchê Brilho ADC6000", "BOPP Branco",
            "BOPP Transparente", "BOPP Metalizado", "Vinil Fasson Branco", "Vinil Fasson Transparente"
        };

        // Cada linha representa um papel. As colunas são os preços nas faixas: 
        // [0..20, 21..50, 51..100, 101..200, 201..300, 301..400, 401..500, +500]
        double[][] tabelaPrecos = {
            {6.4, 6.1, 5.7, 5.0, 4.3, 3.8, 3.5, 3.2},   // Opção 1
            {6.8, 6.5, 6.1, 5.3, 4.6, 4.0, 3.7, 3.4},   // Opção 2
            {9.5, 9.1, 8.5, 7.0, 6.0, 5.4, 4.8, 4.3},   // Opção 3
            {10.8, 10.3, 9.7, 7.9, 6.9, 6.1, 5.4, 4.9}, // Opção 4
            {11.2, 10.7, 10.0, 8.2, 7.1, 6.3, 5.6, 5.1},// Opção 5
            {15.6, 14.9, 13.9, 11.4, 9.9, 8.8, 7.8, 7.1},// Opção 6
            {15.6, 14.9, 13.9, 11.4, 9.9, 8.8, 7.8, 7.1} // Opção 7 (Igual a 6)
        };

        // 2. Coleta de Dados
        System.out.println("=== SISTEMA DE ORÇAMENTO ===");
        for (int i = 0; i < nomesPapel.length; i++) {
            System.out.printf("%d - %s%n", (i + 1), nomesPapel[i]);
        }
        int escolha = input.nextInt() - 1; // Subtrai 1 para alinhar com o índice do array (0 a 6)

        System.out.println("Qual a altura do rótulo (cm)?");
        double altura = input.nextDouble();
        System.out.println("Qual a largura do rótulo (cm)?");
        double largura = input.nextDouble();
        System.out.println("Quantos rótulos serão impressos?");
        int qntdRotulos = input.nextInt();

        // 3. Cálculos de Diagramação
        double rotulosPorFolha = calcularMelhorAproveitamento(altura, largura);
        double qntdFolhas = Math.ceil(qntdRotulos / rotulosPorFolha);

        // 4. Cálculo do Valor Final usando a função única
        double valorFinal = calcularPreco(tabelaPrecos[escolha], qntdFolhas);

        // 5. Saída de Dados
        System.out.println("\nDetalhes do orçamento:");
        System.out.println("  Tipo de papel: " + nomesPapel[escolha]);
        System.out.printf("  Tamanho do rótulo: %.2f x %.2f%n", largura, altura);
        System.out.printf("  Rótulos por folha: %.0f%n", rotulosPorFolha);
        System.out.printf("  Número de folhas: %.0f%n", qntdFolhas);
        System.out.printf("  ORÇAMENTO FINAL: R$ %.2f (Incluindo R$ 10,00 de diagramação)%n", valorFinal);
    }

    // Função para calcular valor final
    public static double calcularPreco(double[] precosPapel, double x) {
        if (x <= 0) return 0.0;
        
        double precoUnitario;
        if (x <= 20)       precoUnitario = precosPapel[0];
        else if (x <= 50)  precoUnitario = precosPapel[1];
        else if (x <= 100) precoUnitario = precosPapel[2];
        else if (x <= 200) precoUnitario = precosPapel[3];
        else if (x <= 300) precoUnitario = precosPapel[4];
        else if (x <= 400) precoUnitario = precosPapel[5];
        else if (x <= 500) precoUnitario = precosPapel[6];
        else               precoUnitario = precosPapel[7];

        return (precoUnitario * x) + 10.0; // Adiciona os 10 reais fixos
    }

    // Auxiliar para calcular aproveitamento
    public static double calcularMelhorAproveitamento(double h, double l) {
        double op1 = Math.floor(46.5 / h) * Math.floor(31.5 / l);
        double op2 = Math.floor(46.5 / l) * Math.floor(31.5 / h);
        return Math.max(op1, op2);
    }
}
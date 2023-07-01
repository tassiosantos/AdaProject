import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        double[] salarios = receberSalarios();
        for (double salarioBruto:salarios) {
            double inss = calcularInss(salarioBruto);
            double leao = calcularLeao(salarioBruto - inss);
            double salarioLiquido = calcularSalarioLiquido(salarioBruto,inss,leao);

            imprimirSalarios(salarioBruto,salarioLiquido,inss,leao);
        }


    }

public static double calcularInss(double salario){
    double taxa;
    double corrigir;
    if(salario<= 1212){
        taxa = 0.075;
        corrigir = 0;
    } else if ((1212.01 <= salario) && (salario <= 2427.35)) {
        taxa = 0.09;
        corrigir = 1212.0*(taxa - 0.075);
    }else if ((2427.36 <= salario) && (salario <= 3641.03)){
        taxa = 0.12;
        corrigir = 1212.0*(taxa - 0.075) + (2427.35-1212.01)*(taxa - 0.09);
    }else if ((3641.04 <= salario) && (salario <= 7087.22)){
        taxa = 0.14;
        corrigir = 1212.0*(taxa - 0.075) + (2427.35-1212.01)*(taxa - 0.09) + (3641.03-2427.36)*(taxa - 0.12);
    }else{
        taxa = 0.14;
        corrigir = (salario - 7087.22)*taxa + 1212.0*(taxa - 0.075) + (2427.35-1212.01)*(taxa - 0.09) + (3641.03-2427.36)*(taxa - 0.12) + (7087.22-3641.04)*(taxa - 0.14);

    }

    return salario*taxa - corrigir;
}

    public static double calcularLeao(double salario){
        double taxa;
        double corrigir;
        if(salario<= 1903.98){
            taxa = 0;
            corrigir = 0;
        } else if ((1903.99 <= salario) && (salario <= 2826.65)) {
            taxa = 0.075;
            corrigir = 1903.98*(taxa);
        }else if ((2826.66 <= salario) && (salario <= 3751.05)){
            taxa = 0.15;
            corrigir = 1903.98*(taxa) + (2826.65 - 1903.99)*(taxa - 0.075);
        }else if ((3751.06 <= salario) && (salario <= 4664.68)){
            taxa = 0.225;
            corrigir = 1903.98*(taxa) + (2826.65 - 1903.99)*(taxa - 0.075) + (3751.05 - 2826.66)*(taxa - 0.15);
        }else{
            taxa = 0.275;
            corrigir = 1903.98*(taxa) + (2826.65 - 1903.99)*(taxa - 0.075) + (3751.05 - 2826.66)*(taxa - 0.15) + (4664.68-3751.06)*(taxa - 0.225);
        }

        return salario*taxa - corrigir;
    }

    public static double calcularSalarioLiquido(double salarioBruto, double inss, double leao){
        return salarioBruto - inss - leao;
    }

    public static void imprimirSalarios(double salarioBruto, double salarioLiquido, double inss, double leao){
        System.out.println("========================================================");
        System.out.println("Salário bruto: " + salarioBruto);
        System.out.println("Quanto pagou ao INSS: " + inss);
        System.out.println("Quanto pagou de Imposto de Renda: " + leao);
        System.out.println("Salário líquido: " + salarioLiquido);
        System.out.println("========================================================");
        System.out.println();
    }

    public static double[] receberSalarios(){
        Scanner leitor = new Scanner(System.in);
        double[] salarios = new double[5];

        for (int x = 0; x<salarios.length;x++) {
            System.out.printf("Digite o salário bruto nº%d: %n",(x+1));
            salarios[x] = leitor.nextDouble();
        }
        return salarios;
    }



}
import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println("**** Aplicación Calculadora ****");
            mostrarMenu();

            int operacion;
            try {
                operacion = Integer.parseInt(console.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                continue;
            }

            if (operacion >= 1 && operacion <= 4) {
                ejecutarOperacion(operacion, console);
            } else if (operacion == 5) {
                System.out.println("Hasta pronto...");
                console.close(); // Cerramos el Scanner antes de salir
                break;
            } else {
                System.out.println("Opción errónea: " + operacion);
            }

            if (operacion != 5) {
                System.out.println();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicación
                4. División
                5. Salir
                """);
        System.out.print("Operación a realizar? ");
    }

    private static void ejecutarOperacion(int operacion, Scanner console) {
        System.out.print("Proporciona valor operando1: ");
        double operando1 = leerDouble(console);
        System.out.print("Proporciona valor operando2: ");
        double operando2 = leerDouble(console);
        double resultado;

        switch (operacion) {
            case 1 -> System.out.println("Resultado suma: " + (operando1 + operando2));
            case 2 -> System.out.println("Resultado resta: " + (operando1 - operando2));
            case 3 -> System.out.println("Resultado multiplicación: " + (operando1 * operando2));
            case 4 -> {
                if (operando2 != 0) {
                    System.out.println("Resultado división: " + (operando1 / operando2));
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                }
            }
            default -> System.out.println("Opción errónea: " + operacion);
        }
    }

    private static double leerDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Introduce un número decimal: ");
            }
        }
    }
}

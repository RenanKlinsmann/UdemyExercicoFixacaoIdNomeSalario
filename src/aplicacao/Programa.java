package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cadastro;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		List<Cadastro> list = new ArrayList<>();

		// leitura de dados

		System.out.print("Quantos funcionários serão registrados? ");

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println();

			System.out.println("Empregado #" + i + ": ");

			System.out.print("Id: ");

			int id = sc.nextInt();

			System.out.print("Nome: ");

			sc.nextLine();

			String nome = sc.nextLine();

			System.out.print("Salario: ");

			double salario = sc.nextDouble();

			list.add(new Cadastro(id, nome, salario));

		}

		// PART 2 - atualizaçao do salario do funcionario

		System.out.println();

		System.out.print("Digite a identificação do funcionário que terá aumento salarial: ");

		int id = sc.nextInt();

		Cadastro emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		if (emp == null) {

			System.out.println("Este ID não existe!");

		}

		else {

			System.out.print("Digite a Porcentagem: ");

			double porcentagem = sc.nextDouble();

			emp.aumentaSalario(porcentagem);

		}

		// PART 3 - lista de empregados:

		System.out.println();

		System.out.println("Lista de funcionários:");

		for (Cadastro obj : list) {

			System.out.println(obj);

		}

		sc.close();

	}

}

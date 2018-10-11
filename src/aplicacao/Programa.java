package aplicacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Produto;

public class Programa {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		String strCaminho = sc.nextLine();
		
		String produtos[] = null;
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(strCaminho))) {
			String linha = br.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				produtos = linha.split(",");
				linha = br.readLine();
				lista.add(produtos[0],Double.parseDouble(produtos[1]),Integer.parseInt(produtos[2]));
			}
			
			
		}
		catch (IOException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		finally {
			sc.close();
		}

	}

}

package aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Programa {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		List<Produto> lista = new ArrayList<>();
		
		System.out.print("Digite o caminho do arquivo> ");
		String sourceFileStr = sc.nextLine();
		
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		
		boolean sucesso = new File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\sumario.csv";
				
		try(BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String itemCsv = br.readLine();
			
			while (itemCsv != null) {
				String[] campos = itemCsv.split(",");
				String nome = campos[0];
				double preco = Double.parseDouble(campos[1]);
				int quantidade = Integer.parseInt(campos[2]);
				
				lista.add(new Produto(nome, preco, quantidade));
				
				itemCsv = br.readLine();			
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
				for (Produto item : lista) {
					bw.write(item.getNome() + ","+ String.format("%.2f",  item.total()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr + " CRIADO COM SUCESSO!");
			} 
			catch (IOException e) {
				System.out.println("Erro ao criar arquivo: "+ e.getMessage());
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

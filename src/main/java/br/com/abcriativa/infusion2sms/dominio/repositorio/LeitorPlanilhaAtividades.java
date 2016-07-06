package br.com.abcriativa.infusion2sms.dominio.repositorio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LeitorPlanilhaAtividades {

	
	public static void main(String[] args) {
		ler();
	}

	public static void ler() {
		
		String arquivoComCaminhoCompleto = 
				".//src//main//resources//planilhas//controle-atividades-por-perfil.xlsx";
		try {
			new LeitorPlanilhaAtividades().lerPlanilhaDeAtividades(arquivoComCaminhoCompleto);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void lerPlanilhaDeAtividades(final String arquivoComCaminhoCompleto) throws Exception {

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(arquivoComCaminhoCompleto);
		} catch (FileNotFoundException e) {
			throw new Exception(e.getCause());
		}

		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(inputStream);
		} catch (EncryptedDocumentException e) {
			throw new Exception(e.getCause());
		} catch (InvalidFormatException e) {
			throw new Exception(e.getCause());
		} catch (IOException e) {
			throw new Exception(e.getCause());
		}

		Sheet planilha = workbook.getSheetAt(0);
		for (Row row : planilha) {
			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}

		try {
			workbook.close();
		} catch (IOException e) {
			throw new Exception(e.getCause());
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			throw new Exception(e.getCause());
		}

	}

}

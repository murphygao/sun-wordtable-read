package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.suncht.wordread.model.WordTable;
import com.suncht.wordread.parser.WordTableParser;
import com.suncht.wordread.parser.WordTableParser.WordDocType;
import com.suncht.wordread.parser.strategy.LogicalTableStrategy;

public class OleObjectCellTest {
//	@Test
	public void testOleInCell() throws IOException {
		try(InputStream inputStream = WordXTableParserTest.class.getResourceAsStream("/嵌套附件01.docx");) {
			List<WordTable> tables = WordTableParser.create().transferStrategy(new LogicalTableStrategy())
					.memoryMappingVisitor(new MemoryMappingVisitorTest()).parse(inputStream, WordDocType.DOCX);
			for (WordTable wordTable : tables) {
				System.out.println(wordTable.format());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEmbedDocxInCell() throws IOException {
		try(InputStream inputStream = WordXTableParserTest.class.getResourceAsStream("/嵌套附件02.docx");) {
			List<WordTable> tables = WordTableParser.create().transferStrategy(new LogicalTableStrategy())
					.memoryMappingVisitor(new MemoryMappingVisitorTest()).parse(inputStream, WordDocType.DOCX);
			for (WordTable wordTable : tables) {
				System.out.println(wordTable.format());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

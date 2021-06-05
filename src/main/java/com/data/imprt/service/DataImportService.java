package com.data.imprt.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.data.imprt.entity.Book;
import com.data.imprt.model.DataImportResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author jasar
 *
 */
@Slf4j
@Service
public class DataImportService {

	@Autowired
	private BookService bookService;

	public DataImportResponse importData(MultipartFile fileUpload) {

		int offset = 1;
		int limit = 1000;
		long numberOfBooksImported = 0l;
		try {

			log.info("Reading the input file and parsing the csv file");
			/*
			 * CSVParser csvParser = new CSVParser(fileReader,
			 * CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
			 * );
			 */

			while (true) {

				//log.info("Reading file");
				BufferedReader fileReader = new BufferedReader(
						new InputStreamReader(fileUpload.getInputStream(), "UTF-8"));

				log.info("Reading records from {} to {}", offset, (offset + limit -1));
				List<Book> books = fileReader.lines().skip(offset).limit(limit).map(mapToBook)
						.collect(Collectors.toList());

				bookService.importBooks(books);
				numberOfBooksImported = numberOfBooksImported + books.size();

				if (books.size() < limit) {
					fileReader.close();
					break;
				}

				offset = offset + limit;

				fileReader.close();
			}

			Map<String, Object> details = new HashMap<>();
			details.put("numberOfBooksImported", numberOfBooksImported);
			return DataImportResponse.builder().status("SUCCESS")
					.message("Successfully imported all books to database.").details(details).build();

			/*
			 * List<Book> books = new ArrayList<Book>();
			 * 
			 * Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			 * 
			 * int i = 1; for (CSVRecord csvRecord : csvRecords) { Book book =
			 * Book.builder().bookId(Long.parseLong(csvRecord.get("BookId")))
			 * .author(csvRecord.get("Author")).description(csvRecord.get("Description"))
			 * .isbn(csvRecord.get("Isbn")).name(csvRecord.get("Name"))
			 * .price(Double.parseDouble(csvRecord.get("Price"))).type(csvRecord.get("Type")
			 * ).build(); books.add(book);
			 * 
			 * if(i == 10) { break; }
			 * 
			 * i++; }
			 * 
			 * log.info("Saving to database"); bookRepository.saveAll(books);
			 */

		} catch (Exception e) {
			log.info("Exception occured");
			e.printStackTrace();

			Map<String, Object> details = new HashMap<>();
			details.put("numberOfBooksImported", numberOfBooksImported);
			return DataImportResponse.builder().status("FAILED").message("Failed to import all books to database.")
					.details(details).build();
		}

	}

	private Function<String, Book> mapToBook = (line) -> {

		String[] lineData = line.split(",");

		Book book = Book.builder().bookId(Long.parseLong(lineData[0])).author(lineData[1]).description(lineData[2])
				.isbn(lineData[3]).name(lineData[4]).price(Double.parseDouble(lineData[5])).type(lineData[6]).build();

		return book;
	};

}

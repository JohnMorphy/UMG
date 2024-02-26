import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> fileNames = Arrays.asList(
                "berlin52.tsp", "kroA100.tsp", "kroA150.tsp", "kroA200.tsp",
                "kroB100.tsp", "kroB150.tsp", "kroB200.tsp",
                "kroC100.tsp", "kroD100.tsp", "kroE100.tsp"
        );
        String outputPath = "C:\\Users\\ThinkPad\\Desktop\\UniwersytetZajęcia\\Gdynia Maritime University\\5 semester\\Computational Intelligence\\Lab10_11_antColonyOptimisation\\Raport_Konspekt_10_11.xlsx";
        String folderPath = "C:\\Users\\ThinkPad\\Desktop\\UniwersytetZajęcia\\Gdynia Maritime University\\5 semester\\Computational Intelligence\\Lab10_11_antColonyOptimisation\\";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Wyniki ACO");

        int rowIdx = 0;
        Row headerRow = sheet.createRow(rowIdx++);
        for (int i = 0; i < fileNames.size(); i++) {
            headerRow.createCell(i).setCellValue(fileNames.get(i));
        }

        for (String fileName : fileNames) {
            List<Double> bestLengths = new ArrayList<>();
            double totalBestLength = 0;

            for (int i = 0; i < 10; i++) {
                List<City> cities = City.fetchCities(folderPath + fileName);
                AntColonyOptimizationMultithreading aco = new AntColonyOptimizationMultithreading(cities);
                aco.runOptimization();
                double bestLength = aco.getBestTourLength();
                bestLengths.add(bestLength);
                totalBestLength += bestLength;

                Row row = sheet.getRow(rowIdx + i);
                if (row == null) {
                    row = sheet.createRow(rowIdx + i);
                }
                Cell cell = row.createCell(fileNames.indexOf(fileName));
                cell.setCellValue(bestLength);
            }

            double averageBestLength = totalBestLength / 10;
            Row averageRow = sheet.getRow(rowIdx + 10);
            if (averageRow == null) {
                averageRow = sheet.createRow(rowIdx + 10);
            }
            averageRow.createCell(fileNames.indexOf(fileName)).setCellValue("Średnia: " + averageBestLength);

            rowIdx++;
        }

        try (FileOutputStream outputStream = new FileOutputStream(outputPath)) {
            workbook.write(outputStream);
        }
        workbook.close();
    }
}

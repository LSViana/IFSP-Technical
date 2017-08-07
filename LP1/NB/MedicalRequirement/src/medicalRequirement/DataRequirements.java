package medicalRequirement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public final class DataRequirements { 
   static Path filePath = Paths.get("Requirements.txt");
    static String separator = "\u0017";
    public static void fillRequirements(ArrayList<Requirement> source) {
        if (Files.exists(filePath)) {
            try {
                List<String> content = Files.readAllLines(filePath);
                for (String reqContent : content) {
                    String[] fields = reqContent.split(separator);
                    source.add(new Requirement(
                            fields[0],
                            fields[1],
                            Integer.parseInt(fields[2]),
                            Integer.parseInt(fields[3]),
                            fields[4],
                            LocalDate.parse(fields[5]),
                            Integer.parseInt(fields[6]),
                            Integer.parseInt(fields[7]),
                            LocalDate.parse(fields[8]),
                            fields[9],
                            fields[10])
                    );
                }
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(null, "Arquivo corrompido, não foi possível recuperar os dados!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Notamos que você não possui um arquivo de gravação, criamos um novo para você em: \n" + filePath.toString(), "Requerimentos Médicos", JOptionPane.INFORMATION_MESSAGE);
            try {
                Files.createFile(filePath);
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(null, "Algo falhou em nosso sistema, pedimos desculpa por isso!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
            }
        }
        //requirements.add(new Requirement("donegá", "1650296", 113, 1, "potato", LocalDate.now(), 0, 0, LocalDate.MIN, "", ""));
        //requirements.add(new Requirement("lucas viana", "654756xa", -1, 1, "asdadasdasd", LocalDate.now(), 0, 0, LocalDate.MAX, "", ""));
        //requirements.add(new Requirement("kevin shuichi", "1876asdas", 6578, 1, "sdoks", LocalDate.now(), 0, 0, LocalDate.now(), "", ""));
        //requirements.add(new Requirement("thayto", "aécio1687896", 987, 1, "OOOI? não entendi!", LocalDate.now(), 0, 0, LocalDate.MAX, "", ""));
    }

    public static void saveRequirements(ArrayList<Requirement> source) {

        try {
            Files.delete(filePath);
            Files.createFile(filePath);
            StringBuilder contentToWrite = new StringBuilder("");
            for (Requirement requirement : source) {
                contentToWrite.append(requirement.studentName).append(separator);
                contentToWrite.append(requirement.enrollment).append(separator);
                contentToWrite.append(requirement.classNumber).append(separator);
                contentToWrite.append(requirement.time).append(separator);
                contentToWrite.append(requirement.description).append(separator);
                contentToWrite.append(requirement.dateOcurrence).append(separator);
                contentToWrite.append(requirement.type).append(separator);
                contentToWrite.append(requirement.status).append(separator);
                contentToWrite.append(requirement.sentDate).append(separator);
                contentToWrite.append(requirement.obs).append(separator);
                contentToWrite.append(requirement.defer).append("\r\n");
            }
            Files.write(filePath, contentToWrite.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(null, "Algo falhou em nosso sistema, pedimos desculpa por isso!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }
}

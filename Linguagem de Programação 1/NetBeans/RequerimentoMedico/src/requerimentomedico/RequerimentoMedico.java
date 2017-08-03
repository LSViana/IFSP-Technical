package requerimentomedico;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

public class RequerimentoMedico {

    static ArrayList<Requirement> requirements;

    public static void main(String[] args) {
        requirements = new ArrayList<>();
        //
        OpenWindow();
    }

    static void OpenWindow() {
        int chosenOption = JOptionPane.showOptionDialog(null,
                "Selecione a opção desejada",
                "Requerimentos Médicos",
                JOptionPane.NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new String[]{"Setor Discente", "Setor Médico", "Setor Pedagógico"},
                requirements);
        switch (chosenOption) {
            case 0:
                // Setor Discente
                try {
                    Student();
                } catch (Exception e) {
                    //
                    System.out.println("Something went out wrong!");
                }
                break;
            case 1:
                // Setor Médico
                Medical();
                break;
            case 2:
                // Setor Pedagógico
                Pedagogical();
                break;
        }
    }

    static void Student() throws Exception {
        JTextField studentNameField = new JTextField();
        JSpinner enrollmentField = new JSpinner(new SpinnerNumberModel(1, 1, 9999999, 1));
            enrollmentField.setEditor(new JSpinner.NumberEditor(enrollmentField, "0000000"));
        JSpinner classNumberField = new JSpinner(new SpinnerNumberModel(1, 1, 9999999, 1));
            classNumberField.setEditor(new JSpinner.NumberEditor(classNumberField, "0000000"));
        JTextField descriptionField = new JTextField();
        JFormattedTextField dateField = new JFormattedTextField(new MaskFormatter("##/##/####"));
        JComboBox timeField = new JComboBox(new String[]{"Integral", "Matutino", "Vespertino", "Noturno"});
        ButtonGroup radioButtons = new ButtonGroup();
        JRadioButton isJustify = new JRadioButton("Justificativa");
        JRadioButton isAllowance = new JRadioButton("Abono");
        radioButtons.add(isJustify);
        radioButtons.add(isAllowance);
        //
        Object[] inputFields = {
            "Nome do Aluno", studentNameField,
            "Número de Prontuário", enrollmentField,
            "Número da Turma", classNumberField,
            "Período de Aula", timeField,
            "Data da Ocorrência", dateField,
            "Descrição da Ocorrência", descriptionField,
            isJustify, isAllowance
       };
        //
        isJustify.doClick();
        JOptionPane.showConfirmDialog(null,
                inputFields,
                "Requerimentos Médicos",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null);
        //
        String[] dateInsert = dateField.getText().split("/");
        for(String s : dateInsert)
        {
            if(s.equals(null) || !s.matches("[0-9]+"))
                OpenWindow();
                return;
        }
        requirements.add(new Requirement(studentNameField.getText(),
                (int) enrollmentField.getValue(),
                (int) classNumberField.getValue(),
                timeField.getSelectedIndex(),
                descriptionField.getText(),
                LocalDate.of(Integer.parseInt(dateInsert[2]), Integer.parseInt(dateInsert[1]), Integer.parseInt(dateInsert[0])),
                (isJustify.isSelected()) ? 0 : 1, 0, LocalDate.now(), ""));
        //
        System.out.println(requirements.get(0).classNumber);
        System.out.println(requirements.get(0).dateOcurrence);
        System.out.println(requirements.get(0).description);
        System.out.println(requirements.get(0).enrollment);
        System.out.println(requirements.get(0).sentDate);
        System.out.println(requirements.get(0).status);
        System.out.println(requirements.get(0).studentName);
        System.out.println(requirements.get(0).time);
        System.out.println(requirements.get(0).type);
        //
        OpenWindow();
    }

    static void Medical() {

    }

    static void Pedagogical() {

    }
}
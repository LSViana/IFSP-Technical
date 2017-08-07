package medicalRequirement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

public class MedicalRequirement {

    static ArrayList<Requirement> requirements;
    static JTable table;
    public static void main(String[] args) {
        requirements = new ArrayList<>();
        //
        DataRequirements.fillRequirements(requirements);
        //
        OpenWindow();
        //
        DataRequirements.saveRequirements(requirements);
    }

    static void OpenWindow() {
        int chosenOption = JOptionPane.showOptionDialog(null,
                "Selecione a opção desejada",
                "Requerimentos Médicos",
                JOptionPane.NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new String[]{"Setor Discente", "Setor Médico", "Setor de Coordenação", "Setor de Professores"},
                requirements);
        try {
            switch (chosenOption) {
                case 0:
                    // Setor Discente
                    Student();
                    break;
                case 1:
                    // Setor Médico
                    Medical();
                    break;
                case 2:
                    // Setor de Coordenação
                    Coordinator();
                    break;
                case 3:
                    // Setor de Professores
                    Professor();
                    break;
            }
        } catch (Exception e) {
            System.err.println("Something went out wrong.");
        }
    }

    static void Student() throws Exception {
        JOptionPane frame = new JOptionPane();
        // Components
        JTextField studentNameField = new JTextField();
        MaskFormatter enrollmentFormatter = new MaskFormatter("######A");
        enrollmentFormatter.setValidCharacters("0123456789xX");
        JFormattedTextField enrollmentField = new JFormattedTextField(enrollmentFormatter);
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
        // Opções
        JButton cancel = new JButton("Cancelar");
        cancel.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e)  {
               JOptionPane.getRootFrame().dispose();
           }
        });
        JButton send = new JButton("Enviar");
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder errorList = new StringBuilder();
                    if (studentNameField.getText().isEmpty()) {
                        errorList.append("O nome do estudante não pode estar vazio!\n");
                    }
                    if (enrollmentField.getText() == null || !enrollmentField.getText().matches("[0-9]{6}[a-zA-Z0-9]{1}")) {
                        errorList.append("O prontuário do estudante não pode estar vazio!\n");
                    }
                    if (classNumberField.getValue() == null || (!((int) classNumberField.getValue() > 0))) {
                        errorList.append("O nome do estudante não pode estar vazio!\n");
                    }
                    LocalDate occurrenceDate = null;
                    if (dateField.getValue() == null) {
                        errorList.append("O campo de data não pode estar vazio!\n");
                    } else {
                        String[] dateInsert = dateField.getText().split("/");
                        occurrenceDate = LocalDate.of(Integer.parseInt(dateInsert[2]), Integer.parseInt(dateInsert[1]), Integer.parseInt(dateInsert[0]));
                        LocalDate limitDate = LocalDate.now().minusDays(3);
                        if (LocalDate.now().isBefore(occurrenceDate)) {
                            errorList.append("A data inserida precisa ser anterior à data atual!\n");

                        }
                        if (occurrenceDate.compareTo(limitDate) < 0) {
                            errorList.append("A data inserida não pode estar há mais de 3 dias em relação à data atual!\n");
                        }
                    }
                    if (descriptionField.getText().isEmpty()) {
                        errorList.append("A descrição para o requerimento não pode estar vazio!\n");
                    }
                    if (!errorList.toString().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Os seguintes erros foram encontrados:\n" + errorList.toString(),
                                "Requerimentos Médicos",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        requirements.add(new Requirement(studentNameField.getText(),
                                enrollmentField.getText(),
                                (int) classNumberField.getValue(),
                                timeField.getSelectedIndex(),
                                descriptionField.getText(),
                                occurrenceDate,
                                (isJustify.isSelected()) ? 0 : 1, 0, LocalDate.now(), "[Sem descrição de atestado]", "[Sem descrição de indeferimento]"));
                        JOptionPane.getRootFrame().dispose();
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(
                            null, "Algo deu errado, pedimos desculpa!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
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
        Object[] options = {
            send, cancel
        };
        //
        isJustify.doClick();
        frame.showOptionDialog(null,
                inputFields,
                "Requerimentos Médicos",
                JOptionPane.NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                null);
        //
        OpenWindow();
    }

    static void Medical() {
        showRequirements(0);
        OpenWindow();
    }

    static void Coordinator() {
        // Creating components
        showRequirements(1);
        //
        OpenWindow();
    }

    static void Professor() {
        int userChoice = JOptionPane.showOptionDialog(null,
                new Object[]{"Selecione uma das seguintes opções"},
                "Requerimentos Médicos",
                JOptionPane.NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{
                    "Visualizar Atestados Indeferidos",
                    "Visualizar Atestados Deferidos"},
                null
        );
        if (userChoice == 0) {
            showRequirements(3);
        } else if (userChoice == 1) {
            showRequirements(2);
        }
        //
        OpenWindow();
    }

    // Common Methods
    static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static void showRequirements(int filter) {
        // Counting the requirements via filtering
        int counter = 0;
        ArrayList<Requirement> _requirements = new ArrayList<>();
        for (Requirement requirement : requirements) {
            if (requirement.status == filter) {
                _requirements.add(requirement);
                counter++;
            }
        }
        // Declaring components and their actions
        int counterInsertion = 0;
        String[] columnNames = {"Prontuário", "Nome", "N. da Turma", "Data de Ocorrência", "Descrição"};
        Object[][] cellData = new Object[counter][columnNames.length];
        table = new JTable(cellData, columnNames);
        JButton button = new JButton();
        if(filter == 2 || filter == 3) {
            columnNames = new String[] {"Prontuário", "Nome", "N. da Turma", "Data de Ocorrência", "Tipo de Justificativa" };
            table = new JTable(cellData, columnNames);
            //
            button.setEnabled(false);
        }
        else if (filter == 0) {
            button = new JButton("Criar Atestado");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // display/center the jdialog when the button is pressed
                    try {
                        Certificate(_requirements.get(table.getSelectedRow()));
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, "Escolha um requerimento antes de continuar!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        } else if (filter == 1) {
            button = new JButton("Determinar");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Determine(_requirements.get(table.getSelectedRow()));
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, "Escolha um requerimento antes de continuar!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }
        //
        for (int i = 0; i < requirements.size(); i++) {
            if (filter == 0) {
                if (requirements.get(i).status == filter) {
                    cellData[counterInsertion][0] = requirements.get(i).enrollment;
                    cellData[counterInsertion][1] = requirements.get(i).studentName;
                    cellData[counterInsertion][2] = requirements.get(i).classNumber;
                    cellData[counterInsertion][3] = requirements.get(i).dateOcurrence;
                    cellData[counterInsertion][4] = requirements.get(i).description;
                    counterInsertion++;
                }
            } else if (filter == 1) {
                if (requirements.get(i).status == filter) {
                    cellData[counterInsertion][0] = requirements.get(i).enrollment;
                    cellData[counterInsertion][1] = requirements.get(i).studentName;
                    cellData[counterInsertion][2] = requirements.get(i).classNumber;
                    cellData[counterInsertion][3] = requirements.get(i).dateOcurrence;
                    cellData[counterInsertion][4] = requirements.get(i).description;
                    counterInsertion++;
                }
            } else if (filter == 2) {
                if (requirements.get(i).status == filter) {
                    cellData[counterInsertion][0] = requirements.get(i).enrollment;
                    cellData[counterInsertion][1] = requirements.get(i).studentName;
                    cellData[counterInsertion][2] = requirements.get(i).classNumber;
                    cellData[counterInsertion][3] = requirements.get(i).dateOcurrence;
                    cellData[counterInsertion][4] = getTextType(requirements.get(i).type);
                    counterInsertion++;
                }
            } else if (filter == 3) {
                if (requirements.get(i).status == filter) {
                    cellData[counterInsertion][0] = requirements.get(i).enrollment;
                    cellData[counterInsertion][1] = requirements.get(i).studentName;
                    cellData[counterInsertion][2] = requirements.get(i).classNumber;
                    cellData[counterInsertion][3] = requirements.get(i).dateOcurrence;
                    cellData[counterInsertion][4] = getTextType(requirements.get(i).type);
                    counterInsertion++;
                }
            }
        }
        JScrollPane scrollPane = new JScrollPane(table);
        // Button to open the dialog
        

        // Creating the component container
        Object[] components = new Object[]{
            scrollPane,
            button
        };
        // Showing message
        JOptionPane.showOptionDialog(null, components, "Requerimentos Médicos", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{button}, null);
    }

    static void Determine(Requirement r) {
        JOptionPane frame = new JOptionPane();
        //
        JLabel enrollment = new JLabel("   Prontuário: " + r.enrollment);
        JLabel studentName = new JLabel("   Nome do Estudante: " + r.studentName);
        JLabel classNumber = new JLabel("   Número da Turma: " + Integer.toString(r.classNumber));
        JLabel dateOcurrence = new JLabel("   Data da Ocorrência: " + r.dateOcurrence.toString());
        JLabel description = new JLabel("   Descrição: " + r.description);
        JLabel sentDate = new JLabel("   Data de Atestação: " + r.sentDate.toString());
        JLabel certDescription = new JLabel("   " + r.obs.toString());
        JTextField defer = new JTextField();
        //
        Object[] components = new Object[]{
            "Descrição do Aluno: ",
            enrollment,
            studentName,
            classNumber,
            dateOcurrence,
            sentDate,
            "\nDescrição do Atestado: ", certDescription,
            "\nSe indeferir, justifique: ", defer
        };
        //
        JButton determine = new JButton("Deferir");
        determine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    r.status = 2;
                    JOptionPane.getRootFrame().dispose();
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "Escolha um requerimento antes de continuar!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Button to close
        JButton cancel = new JButton("Indeferir");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String deferReason = defer.getText();
                    if (!deferReason.isEmpty()) {
                        r.defer = deferReason;
                        r.status = 3;
                        JOptionPane.getRootFrame().dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Você não pode indeferir um atestado sem inserir uma descrição!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "Escolha um requerimento antes de continuar!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //
        Object[] options = new Object[]{
            determine, cancel
        };
        //
        frame.showOptionDialog(null, components, "Requerimentos Médicos", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
    }

    static void Certificate(Requirement r) {
        JOptionPane frame = new JOptionPane();
        //
        JLabel enrollment = new JLabel("Prontuário: " + r.enrollment);
        JLabel studentName = new JLabel("Nome do Estudante: " + r.studentName);
        JLabel classNumber = new JLabel("Número da Turma: " + Integer.toString(r.classNumber));
        JLabel dateOcurrence = new JLabel("Data da Ocorrência: " + r.dateOcurrence.toString());
        JLabel description = new JLabel("Descrição: " + r.description);
        JTextField obs = new JTextField();
        // Button to certificate (atestar)
        JButton certificate = new JButton("Atestado");
        certificate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String certReason = obs.getText();
                    if (!certReason.isEmpty()) {
                        r.status = 1;
                        r.obs = certReason;
                        r.sentDate = LocalDate.now();
                        JOptionPane.getRootFrame().dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Você não pode inserir um atestado sem inserir uma descrição!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "Escolha um requerimento antes de continuar!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Button to close
        JButton cancel = new JButton("Cancelar");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.getRootFrame().dispose();
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "Escolha um requerimento antes de continuar!", "Requerimentos Médicos", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //
        Object[] components = new Object[]{
            enrollment,
            studentName,
            classNumber,
            dateOcurrence,
            description,
            "\nDescrição de Atestado: ", obs
        };
        Object[] options = new Object[]{
            certificate, cancel
        };
        //
        frame.showOptionDialog(null, components, "Requerimentos Médicos", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
    }
    public static String getTextType(int type) {
        switch(type) {
            case 0:
                return "Justificativa";
            case 1:
                return "Abono";
//            case 2:
//                return "Deferido";
//            case 3:
//                return "Indeferido";
            default:
                return "Inválido";
        }
    }
}

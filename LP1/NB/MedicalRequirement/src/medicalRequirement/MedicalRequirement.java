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

    public static void fillRequirements() {
        requirements.add(new Requirement("donegá", "1650296", 113, 1, "potato", LocalDate.now(), 0, 0, LocalDate.MIN, "", ""));
        requirements.add(new Requirement("lucas viana", "654756xa", -1, 1, "asdadasdasd", LocalDate.now(), 0, 0, LocalDate.MAX, "", ""));
        requirements.add(new Requirement("kevin shuichi", "1876asdas", 6578, 1, "sdoks", LocalDate.now(), 0, 0, LocalDate.now(), "", ""));
        requirements.add(new Requirement("thayto", "aécio1687896", 987, 1, "OOOI? não entendi!", LocalDate.now(), 0, 0, LocalDate.MAX, "", ""));
    }

    public static void main(String[] args) {
        requirements = new ArrayList<>();
        //
        fillRequirements();
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
        for (String s : dateInsert) {
            if (!isNumber(s)) {
                OpenWindow();
                return;
            }
        }
        requirements.add(new Requirement(studentNameField.getText(),
                enrollmentField.getText(),
                (int) classNumberField.getValue(),
                timeField.getSelectedIndex(),
                descriptionField.getText(),
                LocalDate.of(Integer.parseInt(dateInsert[2]), Integer.parseInt(dateInsert[1]), Integer.parseInt(dateInsert[0])),
                (isJustify.isSelected()) ? 0 : 1, 0, LocalDate.now(), "", ""));
        //
        OpenWindow();
    }

    static void Medical() {
        showRequirements(0);
        //
        /*int userChoice = JOptionPane.showOptionDialog(null,
                new Object[]{"Selecione uma das seguintes opções"},
                "Requerimentos Médicos",
                JOptionPane.NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{
                    "Visualizar Requerimentos",},
                null
        );
        if (userChoice == 0) {
            showRequirements(0);
        }*/
        //
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
        }
        else if(userChoice == 1) {
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
        int counter = 0;
        ArrayList<Requirement> _requirements = new ArrayList<>();
        for (Requirement requirement : requirements) {
            if (requirement.status == filter) {
                _requirements.add(requirement);
                counter++;
            }
        }
        int counterInsertion = 0;
        String[] columnNames = {"Prontuário", "Nome", "N. da Turma", "Data de Ocorrência", "Descrição"};
        Object[][] cellData = new Object[counter][columnNames.length];
        JTable table = new JTable(cellData, columnNames);
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
                    cellData[counterInsertion][4] = requirements.get(i).description;
                    counterInsertion++;
                }
            }
            else if (filter == 3) {
                if (requirements.get(i).status == filter) {
                    cellData[counterInsertion][0] = requirements.get(i).enrollment;
                    cellData[counterInsertion][1] = requirements.get(i).studentName;
                    cellData[counterInsertion][2] = requirements.get(i).classNumber;
                    cellData[counterInsertion][3] = requirements.get(i).dateOcurrence;
                    cellData[counterInsertion][4] = requirements.get(i).description;
                    counterInsertion++;
                }
            }
        }
//        DefaultTableModel model = new DefaultTableModel(columnNames, requirements.size()) { public boolean isCellEditable(int row, int col) { return false; } };
//        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        // Button to open the dialog
        JButton button = new JButton();
        if (filter == 0) {
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
        } else if(filter == 1) {
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
        else {
            button.setEnabled(false);
        }

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
        JLabel enrollment = new JLabel("Prontuário: " + r.enrollment);
        JLabel studentName = new JLabel("Nome do Estudante: " + r.studentName);
        JLabel classNumber = new JLabel("Número da Turma: " + Integer.toString(r.classNumber));
        JLabel dateOcurrence = new JLabel("Data da Ocorrência: " + r.dateOcurrence.toString());
        JLabel description = new JLabel("Descrição: " + r.description);
        JLabel sentDate = new JLabel("Data de Atestação: " + r.sentDate.toString());
        JLabel doctorSign = new JLabel("Assinatura do Médico: Sim");
        JTextField defer = new JTextField();
        //
        Object[] components = new Object[]{
            enrollment,
            studentName,
            classNumber,
            dateOcurrence,
            sentDate,
            doctorSign,
            "\n\nSe indeferir, justifique: ", defer
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
                    r.defer = defer.getText();
                    r.status = 3;
                    JOptionPane.getRootFrame().dispose();
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
        JTextField obs = new JTextField();
        JLabel enrollment = new JLabel("Prontuário: " + r.enrollment);
        JLabel studentName = new JLabel("Nome do Estudante: " + r.studentName);
        JLabel classNumber = new JLabel("Número da Turma: " + Integer.toString(r.classNumber));
        JLabel dateOcurrence = new JLabel("Data da Ocorrência: " + r.dateOcurrence.toString());
        JLabel description = new JLabel("Descrição: " + r.description);
        // Button to certificate (atestar)
        JButton certificate = new JButton("Atestado");
        certificate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    r.status = 1;
                    r.obs = obs.getText();
                    r.sentDate = LocalDate.now();
                    JOptionPane.getRootFrame().dispose();
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
            "\nDescrição de Atestado: ", obs
        };
        Object[] options = new Object[]{
            certificate, cancel
        };
        //
        frame.showOptionDialog(null, components, "Requerimentos Médicos", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
    }
}

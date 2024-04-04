import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// Main class for the School Management Application with Swing GUI
public class SchoolManagementAppGUI extends JFrame implements ActionListener {
    private StudentManager studentManager = new StudentManager();
    private TeacherManager teacherManager = new TeacherManager();
    private final JTextField studentIdField;
    private JTextField studentNameField;
    private JTextField studentGenderField;
    private JTextField teacherIdField;
    private JTextField teacherNameField;
    private JTextField teacherSubjectField;
    private JTextField studentMarksField;
    private JTextArea outputArea;

    public SchoolManagementAppGUI() {
        setTitle("School Management Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdLabel.setBounds(20, 20, 80, 25);
        panel.add(studentIdLabel);

        studentIdField = new JTextField();
        studentIdField.setBounds(120, 20, 150, 25);
        panel.add(studentIdField);

        JLabel studentNameLabel = new JLabel("Student Name:");
        studentNameLabel.setBounds(20, 50, 100, 25);
        panel.add(studentNameLabel);

        studentNameField = new JTextField();
        studentNameField.setBounds(120, 50, 150, 25);
        panel.add(studentNameField);

        JLabel studentGenderLabel = new JLabel("Student Gender:");
        studentGenderLabel.setBounds(20, 80, 100, 25);
        panel.add(studentGenderLabel);

        studentGenderField = new JTextField();
        studentGenderField.setBounds(120, 80, 150, 25);
        panel.add(studentGenderField);

        JLabel studentMarksLabel = new JLabel("Student Marks:");
        studentMarksLabel.setBounds(20, 110, 100, 25);
        panel.add(studentMarksLabel);

        studentMarksField = new JTextField();
        studentMarksField.setBounds(120, 110, 150, 25);
        panel.add(studentMarksField);

        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.setBounds(20, 140, 150, 25);
        addStudentButton.addActionListener(this);
        panel.add(addStudentButton);

        JLabel teacherIdLabel = new JLabel("Teacher ID:");
        teacherIdLabel.setBounds(20, 180, 80, 25);
        panel.add(teacherIdLabel);

        teacherIdField = new JTextField();
        teacherIdField.setBounds(120, 180, 150, 25);
        panel.add(teacherIdField);

        JLabel teacherNameLabel = new JLabel("Teacher Name:");
        teacherNameLabel.setBounds(20, 210, 100, 25);
        panel.add(teacherNameLabel);

        teacherNameField = new JTextField();
        teacherNameField.setBounds(120, 210, 150, 25);
        panel.add(teacherNameField);

        JLabel teacherSubjectLabel = new JLabel("Teacher Subject:");
        teacherSubjectLabel.setBounds(20, 240, 100, 25);
        panel.add(teacherSubjectLabel);

        teacherSubjectField = new JTextField();
        teacherSubjectField.setBounds(120, 240, 150, 25);
        panel.add(teacherSubjectField);

        JButton addTeacherButton = new JButton("Add Teacher");
        addTeacherButton.setBounds(20, 270, 150, 25);
        addTeacherButton.addActionListener(this);
        panel.add(addTeacherButton);

        outputArea = new JTextArea();
        outputArea.setBounds(20, 310, 450, 80);
        panel.add(outputArea);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Student")) {
            String id = studentIdField.getText();
            String name = studentNameField.getText();
            String gender = studentGenderField.getText();
            int marks = Integer.parseInt(studentMarksField.getText()); // Convert marks to int
            Student student = new Student(); // Pass marks to the constructor
            studentManager.addStudent(student);
            outputArea.append("Student added successfully!\n");
        } else if (e.getActionCommand().equals("Add Teacher")) {
            String id = teacherIdField.getText();
            String name = teacherNameField.getText();
            String subject = teacherSubjectField.getText();
            var teacher = new Teacher(id, name, subject);
            teacherManager.addTeacher(teacher);
            outputArea.append("Teacher added successfully!\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SchoolManagementAppGUI app = new SchoolManagementAppGUI();
            app.setVisible(true);
        });
    }

    private class StudentManager {
        public <Student> void addStudent(Student student) {
        }
    }

    private class TeacherManager {
        public void addTeacher(Teacher teacher) {
        }
    }

    private class Student {
        public Student() {

        }
    }

    private class Teacher {
        public Teacher(String id, String name, String subject) {
        }
    }
}


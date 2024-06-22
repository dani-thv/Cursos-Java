package gestiondecursos;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Gestiondecursos {
    private List<Curso> cursos;
    private List<Profesor> profesores;

    public Gestiondecursos() {
        cursos = new ArrayList<>();
        profesores = new ArrayList<>();
        inicializarDatosPredeterminados();
    }

    // Método para inicializar datos predeterminados (profesores y cursos)
    private void inicializarDatosPredeterminados() {
        // Crear y agregar profesores predeterminados
        Profesor profesor1 = new Profesor("Juan", "Pérez");
        Profesor profesor2 = new Profesor("María", "González");
        Profesor profesor3 = new Profesor("Carlos", "Sánchez");
        Profesor profesor4 = new Profesor("Laura", "Martínez");
        Profesor profesor5 = new Profesor("Pedro", "López");

        profesores.add(profesor1);
        profesores.add(profesor2);
        profesores.add(profesor3);
        profesores.add(profesor4);
        profesores.add(profesor5);

        // Crear y agregar cursos predeterminados
        Curso curso1 = new Curso("Matemáticas", profesor1);
        Curso curso2 = new Curso("Historia", profesor2);
        Curso curso3 = new Curso("Programación", profesor3);
        Curso curso4 = new Curso("Biología", profesor4);
        Curso curso5 = new Curso("Literatura", profesor5);

        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);
    }

    // Método para abrir la ventana de agregar curso
    public void abrirVentanaAgregarCurso() {
        JFrame frame = new JFrame("Agregar Curso");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 182, 193));  // Fondo rosa claro
        
        JLabel labelNombreCurso = new JLabel("Nombre del Curso:");
        JTextField nombreCursoField = new JTextField(20);
        panel.add(labelNombreCurso);
        panel.add(nombreCursoField);

        JLabel labelProfesor = new JLabel("Profesor:");
        JComboBox<String> profesorComboBox = new JComboBox<>();
        for (Profesor profesor : profesores) {
            profesorComboBox.addItem(profesor.getNombreCompleto());
        }
        panel.add(labelProfesor);
        panel.add(profesorComboBox);

        JButton buttonAgregarCurso = new JButton("Agregar Curso");
        buttonAgregarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCurso = nombreCursoField.getText();
                String nombreProfesor = (String) profesorComboBox.getSelectedItem();
                Profesor profesorSeleccionado = buscarProfesor(nombreProfesor);

                if (nombreCurso.isEmpty() || nombreProfesor.isEmpty() || profesorSeleccionado == null) {
                    JOptionPane.showMessageDialog(frame, "Todos los campos deben estar completos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Curso curso = new Curso(nombreCurso, profesorSeleccionado);
                cursos.add(curso);

                JOptionPane.showMessageDialog(frame, "Curso agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Limpia los campos después de agregar el curso
                nombreCursoField.setText("");
            }
        });
        panel.add(buttonAgregarCurso);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para abrir la ventana de agregar profesor
    public void abrirVentanaAgregarProfesor() {
        JFrame frame = new JFrame("Agregar Profesor");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 182, 193));  // Fondo rosa claro
        
        JLabel labelNombre = new JLabel("Nombre:");
        JTextField nombreField = new JTextField(20);
        panel.add(labelNombre);
        panel.add(nombreField);

        JLabel labelApellido = new JLabel("Apellido:");
        JTextField apellidoField = new JTextField(20);
        panel.add(labelApellido);
        panel.add(apellidoField);

        JButton buttonAgregarProfesor = new JButton("Agregar Profesor");
        buttonAgregarProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();

                if (nombre.isEmpty() || apellido.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos los campos deben estar completos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Profesor profesor = new Profesor(nombre, apellido);
                profesores.add(profesor);

                JOptionPane.showMessageDialog(frame, "Profesor agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Limpia los campos después de agregar el profesor
                nombreField.setText("");
                apellidoField.setText("");
            }
        });
        panel.add(buttonAgregarProfesor);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para abrir la ventana de agregar estudiante
    public void abrirVentanaAgregarEstudiante() {
        JFrame frame = new JFrame("Agregar Estudiante");
        frame.setSize(270, 270);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 182, 193));  // Fondo rosa claro

        Font fuenteGrande = new Font("Arial", Font.BOLD, 16);

        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setFont(fuenteGrande);
        labelNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField nombreField = new JTextField(20);
        nombreField.setMaximumSize(new Dimension(300, 30));
        nombreField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelNombre);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(nombreField);

        JLabel labelApellido = new JLabel("Apellido:");
        labelApellido.setFont(fuenteGrande);
        labelApellido.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField apellidoField = new JTextField(20);
        apellidoField.setMaximumSize(new Dimension(300, 30));
        apellidoField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(labelApellido);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(apellidoField);

        JButton buttonAgregarEstudiante = new JButton("Agregar Estudiante");
        buttonAgregarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();

                if (nombre.isEmpty() || apellido.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos los campos deben estar completos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Estudiante estudiante = new Estudiante(nombre, apellido);

                // Mostrar ventana para seleccionar cursos
                JFrame frameSeleccionCurso = new JFrame("Seleccionar Curso");
                frameSeleccionCurso.setSize(400, 300);
                frameSeleccionCurso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel panelSeleccion = new JPanel();
                JLabel labelSeleccion = new JLabel("Seleccione el curso:");
                JComboBox<String> cursoComboBox = new JComboBox<>();
                for (Curso curso : cursos) {
                    cursoComboBox.addItem(curso.getNombre());
                }
                panelSeleccion.add(labelSeleccion);
                panelSeleccion.add(cursoComboBox);

                JButton buttonSeleccionarCurso = new JButton("Inscribir en Curso");
                buttonSeleccionarCurso.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nombreCurso = (String) cursoComboBox.getSelectedItem();
                        Curso cursoSeleccionado = buscarCurso(nombreCurso);

                        if (cursoSeleccionado != null) {
                            cursoSeleccionado.agregarEstudiante(estudiante);
                            JOptionPane.showMessageDialog(frameSeleccionCurso, "Estudiante inscrito correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            frameSeleccionCurso.dispose(); // Cierra la ventana de selección de curso
                            frame.dispose(); // Cierra la ventana de agregar estudiante
                        } else {
                            JOptionPane.showMessageDialog(frameSeleccionCurso, "Curso no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                panelSeleccion.add(buttonSeleccionarCurso);

                frameSeleccionCurso.add(panelSeleccion);
                frameSeleccionCurso.setVisible(true);
            }
        });
        panel.add(buttonAgregarEstudiante);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para abrir la ventana de horarios
    public void abrirVentanaHorarios() {
        JFrame frame = new JFrame("Horarios de Cursos");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        JTextArea textAreaHorarios = new JTextArea(20, 40);
        textAreaHorarios.setEditable(false);
        panel.add(textAreaHorarios);

        // Mostrar información de horarios de cada curso
        StringBuilder horarios = new StringBuilder();
        for (Curso curso : cursos) {
            horarios.append("Curso: ").append(curso.getNombre()).append("\n");
            horarios.append("Profesor: ").append(curso.getProfesor().getNombreCompleto()).append("\n");
            horarios.append("Estudiantes:\n");
            for (Estudiante estudiante : curso.getEstudiantes()) {
                horarios.append("- ").append(estudiante.getNombreCompleto()).append("\n");
            }
            horarios.append("\n");
        }
        textAreaHorarios.setText(horarios.toString());

        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para buscar un profesor por su nombre completo
    private Profesor buscarProfesor(String nombreCompleto) {
        for (Profesor profesor : profesores) {
            if (profesor.getNombreCompleto().equals(nombreCompleto)) {
                return profesor;
            }
        }
        return null;
    }

    // Método para buscar un curso por su nombre
    private Curso buscarCurso(String nombreCurso) {
        for (Curso curso : cursos) {
            if (curso
            .getNombre().equals(nombreCurso)) {
                return curso;
            }
        }
        return null;
    }

    // Clase principal que contiene el método main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Gestiondecursos gestiondecursos = new Gestiondecursos();
                gestiondecursos.crearInterfazGrafica();
            }
        });
    }

    // Método para crear la interfaz gráfica principal con un menú
    public void crearInterfazGrafica() {
        JFrame frame = new JFrame("Gestión de Cursos");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel y establecer el layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 182, 193));  // Establecer fondo rosa claro

        // Crear fuente grande
        Font fuenteGrande = new Font("Arial", Font.BOLD, 16);

        // Añadir espacio grande arriba
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Crear mensaje de bienvenida
        JLabel labelBienvenida = new JLabel("Bienvenido usuario, escoja una opción:");
        labelBienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelBienvenida.setFont(fuenteGrande);
        panel.add(labelBienvenida);

        // Añadir espacio entre el mensaje de bienvenida y la imagen
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Cargar imagen
        ImageIcon icon = new ImageIcon("C:\\Users\\Carla Daniela\\Downloads\\gestiondecursos_1\\src\\Imagen\\leon.png");  // Reemplaza con la ruta de tu imagen
        JLabel labelImagen = new JLabel(icon);
        labelImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelImagen);

        // Añadir espacio entre la imagen y los botones
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Crear y agregar botón Agregar Curso
        JButton buttonAgregarCurso = new JButton("Agregar Curso");
        buttonAgregarCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonAgregarCurso.setFont(fuenteGrande);
        buttonAgregarCurso.setBackground(new Color(173, 216, 230)); // Color azul claro
        buttonAgregarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarCurso();
            }
        });
        panel.add(buttonAgregarCurso);

        // Añadir espacio entre botones
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Crear y agregar botón Agregar Profesor
        JButton buttonAgregarProfesor = new JButton("Agregar Profesor");
        buttonAgregarProfesor.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonAgregarProfesor.setFont(fuenteGrande);
        buttonAgregarProfesor.setBackground(new Color(173, 216, 230)); // Color azul claro
        buttonAgregarProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarProfesor();
            }
        });
        panel.add(buttonAgregarProfesor);

        // Añadir espacio entre botones
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Crear y agregar botón Agregar Estudiante
        JButton buttonAgregarEstudiante = new JButton("Agregar Estudiante");
        buttonAgregarEstudiante.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonAgregarEstudiante.setFont(fuenteGrande);
        buttonAgregarEstudiante.setBackground(new Color(173, 216, 230)); // Color azul claro
        buttonAgregarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarEstudiante();
            }
        });
        panel.add(buttonAgregarEstudiante);

        // Añadir espacio entre botones
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Crear y agregar botón Ver Horarios
        JButton buttonHorarios = new JButton("Ver Horarios");
        buttonHorarios.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonHorarios.setFont(fuenteGrande);
        buttonHorarios.setBackground(new Color(173, 216, 230)); // Color azul claro
        buttonHorarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaHorarios();
            }
        });
        panel.add(buttonHorarios);

        // Agregar panel al frame y hacer visible
        frame.add(panel);
        frame.setVisible(true);
    }

}

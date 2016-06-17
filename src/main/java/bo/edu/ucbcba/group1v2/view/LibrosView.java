package bo.edu.ucbcba.group1v2.view;

import bo.edu.ucbcba.group1v2.controller.EditorialController;
import bo.edu.ucbcba.group1v2.controller.LibroController;
import bo.edu.ucbcba.group1v2.model.Editorial;
import bo.edu.ucbcba.group1v2.model.Libro;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.eclipse.persistence.exceptions.ValidationException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by Rebeca on 16/06/2016.
 */
public class LibrosView extends JDialog {
    private JPanel rootPanel;
    private JTextField nameField;
    private JButton buscarButton;
    private JTable resulTable;
    private JComboBox genBox;
    private JComboBox dirBox;
    private JComboBox filtroBox;
    private JButton editarButton;
    private JButton verButton;
    private JButton agregarPeliculaButton;
    private JButton agregarDirectorButton;
    private JButton eliminarButton;
    private JButton salirButton;


    private JTextField nameField1;
    private JTextField genField;
    private JTextField descField;
    private JTextField lanField;
    private JTextField isbn;
    private JTextField directorField;
    private JComboBox directorBox;


    private DefaultTableModel model;
    private LibroController movieController;
    private EditorialController directorController = new EditorialController();

    LibrosView(JFrame parent) {
        super(parent, "Libros", true);
        setContentPane(rootPanel);
        setSize(1600, 1400);
        pack();
        setResizable(false);
        movieController = new LibroController();
        populateTable();
        editarButton.setVisible(false);
        verButton.setVisible(false);
        eliminarButton.setVisible(false);
        agregarPeliculaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                launchAddMovieWindow();
                editarButton.setVisible(false);
                verButton.setVisible(false);
                eliminarButton.setVisible(false);
                populateTable();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                populateTable();
                editarButton.setVisible(false);
                verButton.setVisible(false);
                eliminarButton.setVisible(false);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
       /* registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //launchRegistrar();
            }
        });*/
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteElem();
                editarButton.setVisible(false);
                verButton.setVisible(false);
                eliminarButton.setVisible(false);
            }
        });


        resulTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                editarButton.setVisible(true);
                verButton.setVisible(true);
                eliminarButton.setVisible(true);
                //nameField1.setText((String) model.getValueAt(resulTable.getSelectedRow(), 0));
                //genField.setText((String) model.getValueAt(resulTable.getSelectedRow(), 1));
                //descField.setText((String) model.getValueAt(resulTable.getSelectedRow(), 2));
                //minuField.setText(String.valueOf((Integer) model.getValueAt(resulTable.getSelectedRow(), 3)));
                //lanField.setText(String.valueOf((Integer) model.getValueAt(resulTable.getSelectedRow(), 4)));
                //pesoField.setText((String) model.getValueAt(resulTable.getSelectedRow(), 5));
                //directorField.setText((String) model.getValueAt(resulTable.getSelectedRow(), 6));
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modificar();
                editarButton.setVisible(false);
                verButton.setVisible(false);
                eliminarButton.setVisible(false);
                populateTable();
            }
        });
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //  ver();
                editarButton.setVisible(false);
                verButton.setVisible(false);
                eliminarButton.setVisible(false);
            }
        });

        agregarDirectorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                launchAddDirectorWindow();
                populatefiltroBox();
                editarButton.setVisible(false);
                verButton.setVisible(false);
                eliminarButton.setVisible(false);
//                setVisible(true);
//                populatefiltroBox();
//                populateComboBox();
            }
        });

    }

    public LibrosView() {

        setContentPane(rootPanel);
        setSize(1600, 1400);
        pack();
        setResizable(true);

        movieController = new LibroController();
        populateTable();
        populatefiltroBox();
        populateComboBox();
        agregarPeliculaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                launchAddMovieWindow();
                populateTable();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                populateTable();
            }
        });
       /* registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //launchRegistrar();
            }
        });*/
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteElem();
            }
        });


        resulTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);

                nameField1.setText((String) model.getValueAt(resulTable.getSelectedRow(), 0));
                genField.setText((String) model.getValueAt(resulTable.getSelectedRow(), 1));
                descField.setText((String) model.getValueAt(resulTable.getSelectedRow(), 2));
                isbn.setText(String.valueOf((Integer) model.getValueAt(resulTable.getSelectedRow(), 3)));
                lanField.setText(String.valueOf((Integer) model.getValueAt(resulTable.getSelectedRow(), 4)));

                directorField.setText((String) model.getValueAt(resulTable.getSelectedRow(), 5));
            }
        });
        agregarDirectorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                launchAddDirectorWindow();
//                setVisible(true);
//                populatefiltroBox();
//                populateComboBox();
            }
        });
        resulTable.addMouseListener(new MouseAdapter() {
        });
    }


    private void populatefiltroBox() {
        List<Editorial> director = directorController.getAllDirectors();
        int itemCount = dirBox.getItemCount();

        for (int i = 0; i < itemCount; i++) {
            dirBox.removeItemAt(0);
        }
        dirBox.addItem("Todos");
        for (Editorial c : director) {
            dirBox.addItem(c.getName());
        }
    }

    private void populateComboBox() {
        List<Editorial> directors = directorController.getAllDirectors();
        for (Editorial c : directors) {
            directorBox.addItem(c);
        }
    }

    private void launchAddDirectorWindow() {
        NewEditor form = new NewEditor(this);
        form.setVisible(true);
    }

    private void launchAddMovieWindow() {
        AddLibro form = new AddLibro(this);
        form.setVisible(true);
    }

    private void Clean() {
        nameField1.setText("");
        genField.setText("");
        descField.setText("");
        lanField.setText("");
        // int p;
        // p = Integer.parseInt(Gbpeso);
        isbn.setText("");

        directorField.setText("");

    }

    private void modificar() {
        final String nom, genero, descrip, durac, lanz, isbn, direct, lugar;
        nom = ((String) model.getValueAt(resulTable.getSelectedRow(), 0));
        genero = ((String) model.getValueAt(resulTable.getSelectedRow(), 1));
        descrip = ((String) model.getValueAt(resulTable.getSelectedRow(), 2));
        // durac = (String.valueOf((Integer) model.getValueAt(resulTable.getSelectedRow(), 3)));
        lanz = (String.valueOf((Integer) model.getValueAt(resulTable.getSelectedRow(), 3)));
        isbn = (String.valueOf((Long) model.getValueAt(resulTable.getSelectedRow(), 4)));
        direct = ((String) model.getValueAt(resulTable.getSelectedRow(), 5));
        //  lugar = ((String) model.getValueAt(resulTable.getSelectedRow(), 7));
        UpdateLibro form = new UpdateLibro(this, nom, genero, descrip, lanz, isbn, direct);
        form.setVisible(true);

    }

    /* private void ver() {
         final String nom, genero, descrip, durac, lanz, peso, direct, lugar;
         nom = ((String) model.getValueAt(resulTable.getSelectedRow(), 0));
         genero = ((String) model.getValueAt(resulTable.getSelectedRow(), 1));
         descrip = ((String) model.getValueAt(resulTable.getSelectedRow(), 2));
         //durac = (String.valueOf((Integer) model.getValueAt(resulTable.getSelectedRow(), 3)));
         lanz = (String.valueOf((Integer) model.getValueAt(resulTable.getSelectedRow(), 3)));
        // peso = ((String) model.getValueAt(resulTable.getSelectedRow(), 5));
         direct = ((String) model.getValueAt(resulTable.getSelectedRow(), 4));
         //lugar = ((String) model.getValueAt(resulTable.getSelectedRow(), 7));
         VerMovieWindow formm = new VerMovieWindow(this, nom, genero, descrip,lanz,direct);
         formm.setVisible(true);
     }
 */
    private void launchUpdate() {
        try {

            movieController.update(nameField1.getText(),
                    genField.getText(),       // REGISTRA EL GENERO
                    descField.getText(),
                    lanField.getText(),
                    // minuField.getText(),
                    isbn.getText());

        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "error de formato", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(this, "Libro actualizado correctamente", "Realizado", JOptionPane.INFORMATION_MESSAGE);
        populateTable();
        Clean();

    }


    private void populateTable() {
//        String direc = (String) dirBox.getSelectedItem();
        String gen = (String) genBox.getSelectedItem();
        String ord = (String) filtroBox.getSelectedItem();
        //  if (direc == "Todos") direc = "";
        if (gen == "Todos") gen = "";
        List<Libro> elementos = movieController.BuscarLibros(nameField.getText(), gen, ord);
        model = new DefaultTableModel();
        // model.addColumn("Id");
        model.addColumn("Titulo");
        model.addColumn("Género");
        model.addColumn("Descripcion");
        // model.addColumn("Duración");
        model.addColumn("Lanzamiento");
        model.addColumn("ISBN");
        //model.addColumn("tip");
        model.addColumn("Director");
        //    model.addColumn("Directorio Portada");
        resulTable.setModel(model);

        for (Libro m : elementos) {
            Object[] row = new Object[8];
            // row[0] = m.getId();
            row[0] = m.getNombre();
            row[1] = m.getGenero();
            row[2] = m.getDescription();
            //row[3] = m.getDuracMinutos();
            row[3] = m.getLanzamiento();
            row[4] = m.getIsbn();
            //   row[5] = String.format("%s", m.getPeso());
            //row[6] = "Gbytes";
            row[5] = m.getEditorialName();
            // row[7] = m.getNomCover();
            model.addRow(row);
        }

    }

    public void deleteElem() {

        DefaultTableModel model = (DefaultTableModel) resulTable.getModel();
        String cod = (String) model.getValueAt(resulTable.getSelectedRow(), 0);
        movieController.delete(cod);
        JOptionPane.showMessageDialog(this, "Libro eliminada correctamente", "Realizado", JOptionPane.INFORMATION_MESSAGE);
        populateTable();


    }

    private void cancel() {
        setVisible(false);
        dispose();
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(13, 10, new Insets(30, 30, 30, 30), -1, -1));
        panel1.add(rootPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nameField = new JTextField();
        nameField.setText("");
        rootPanel.add(nameField, new GridConstraints(1, 0, 1, 9, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(395, 24), null, 0, false));
        buscarButton = new JButton();
        buscarButton.setText("Buscar");
        rootPanel.add(buscarButton, new GridConstraints(1, 9, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        resulTable = new JTable();
        rootPanel.add(resulTable, new GridConstraints(3, 0, 10, 9, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(500, 300), null, 0, false));
        final Spacer spacer1 = new Spacer();
        rootPanel.add(spacer1, new GridConstraints(8, 9, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        genBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Todos");
        defaultComboBoxModel1.addElement("Terror");
        defaultComboBoxModel1.addElement("Historieta");
        defaultComboBoxModel1.addElement("Policiaco");
        defaultComboBoxModel1.addElement("Infantil");
        defaultComboBoxModel1.addElement("Biográfica");
        defaultComboBoxModel1.addElement("Erotica");
        defaultComboBoxModel1.addElement("Autoayuda");
        defaultComboBoxModel1.addElement("Acción");
        defaultComboBoxModel1.addElement("Romántica");
        defaultComboBoxModel1.addElement("Comedia");
        defaultComboBoxModel1.addElement("Drama");
        defaultComboBoxModel1.addElement("Documental");
        defaultComboBoxModel1.addElement("Ficción");
        defaultComboBoxModel1.addElement("Cultural");
        genBox.setModel(defaultComboBoxModel1);
        rootPanel.add(genBox, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, -1), null, new Dimension(150, -1), 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Filtrar por:");
        rootPanel.add(label1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Ordenar por:");
        rootPanel.add(label2, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filtroBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Titulo");
        defaultComboBoxModel2.addElement("Género");
        defaultComboBoxModel2.addElement("Lanzamiento");
        filtroBox.setModel(defaultComboBoxModel2);
        rootPanel.add(filtroBox, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(150, -1), 0, false));
        editarButton = new JButton();
        editarButton.setText("Editar");
        rootPanel.add(editarButton, new GridConstraints(6, 9, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        verButton = new JButton();
        verButton.setText("Ver");
        rootPanel.add(verButton, new GridConstraints(7, 9, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        agregarPeliculaButton = new JButton();
        agregarPeliculaButton.setText("Agregar Pelicula");
        rootPanel.add(agregarPeliculaButton, new GridConstraints(2, 9, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        agregarDirectorButton = new JButton();
        agregarDirectorButton.setText("Agregar Director");
        rootPanel.add(agregarDirectorButton, new GridConstraints(3, 9, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        eliminarButton = new JButton();
        eliminarButton.setText("Eliminar");
        rootPanel.add(eliminarButton, new GridConstraints(5, 9, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        salirButton = new JButton();
        salirButton.setText("Salir");
        rootPanel.add(salirButton, new GridConstraints(10, 9, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Buscar por Titulo:");
        rootPanel.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }
}

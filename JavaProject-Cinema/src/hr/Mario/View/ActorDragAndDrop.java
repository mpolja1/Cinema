/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.Mario.View;


import hr.Mario.Dall.Repository;
import hr.Mario.Dall.RepositoryFactory;
import hr.Mario.Model.Movie;
import hr.Mario.Model.Person;
import hr.Mario.Model.PersonTransferable;
import hr.algebra.utils.MessageUtils;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

/**
 *
 * @author mario
 */
public class ActorDragAndDrop extends javax.swing.JPanel {

    private Repository repository;

    private List<Movie> listMovies;
    private List<Person> listAllActors;
    private List<Person> listMovieActors = new ArrayList<>();
    
    private Movie selectedMovie;

    private final DefaultListModel<Person> allActorsModel = new DefaultListModel<>();
    private final DefaultListModel<Person> actorModel = new DefaultListModel<>();

    public ActorDragAndDrop() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbMovies = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsMovieActors = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsAllActors = new javax.swing.JList<>();
        btnSaveActors = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        cbMovies.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMoviesItemStateChanged(evt);
            }
        });
        cbMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMoviesActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lsMovieActors);

        jLabel1.setText("Movies");

        jLabel2.setText("Movie actors");

        jLabel3.setText("All actors");

        jScrollPane2.setViewportView(lsAllActors);

        btnSaveActors.setText("Save actors");
        btnSaveActors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActorsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 833, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSaveActors, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(cbMovies, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(cbMovies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveActors)
                .addContainerGap(225, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void cbMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMoviesActionPerformed

        selectedMovie = (Movie) cbMovies.getSelectedItem();
        int idMovie = selectedMovie.getId();

        try {
            listMovieActors = repository.GetMovieActors(idMovie);
            listMovieActors.sort((Person a, Person b)-> a.getFullName().compareTo(b.getFullName()));
    
            loadMovieActorsModel();

        } catch (Exception ex) {
            Logger.getLogger(ActorDragAndDrop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbMoviesActionPerformed

    private void btnSaveActorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActorsActionPerformed
        if (listMovieActors.isEmpty()) {
             MessageUtils.showErrorMessage("Error", "add actors to movie ");
        }
      
        listMovieActors.forEach((actor) -> {
            try {
                
                repository.insertMovieActors(selectedMovie.getId(),actor.getId());
               
            } catch (Exception ex) {
                Logger.getLogger(ActorDragAndDrop.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
                actorModel.clear();
                MessageUtils.showInformationMessage("Success", "Successfully saved actors");
    }//GEN-LAST:event_btnSaveActorsActionPerformed

    private void cbMoviesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMoviesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMoviesItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveActors;
    private javax.swing.JComboBox<Movie> cbMovies;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Person> lsAllActors;
    private javax.swing.JList<Person> lsMovieActors;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initRepository();
            initMovies();
            initActors();
            iniDragNDrop();
        } catch (Exception ex) {
            Logger.getLogger(ActorDragAndDrop.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);

        }

    }

    private void initRepository() {

        repository = RepositoryFactory.GetRepository();
    }

    private void initMovies() throws Exception {

        DefaultComboBoxModel<Movie> movieModel = new DefaultComboBoxModel<>();
        listMovies = repository.GetMovies();

        Set<Movie> movies = new TreeSet<>(listMovies);
        movies.forEach(movieModel::addElement);
        cbMovies.setModel(movieModel);

    }

    private void initActors() throws Exception {
        allActorsModel.clear();
        listAllActors = repository.GetActors();

        Set<Person> setAllActors = new TreeSet<>(listAllActors);

        setAllActors.forEach(allActorsModel::addElement);
        lsAllActors.setModel(allActorsModel);

    }

    private void iniDragNDrop() {

        lsAllActors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsAllActors.setDragEnabled(true);
        lsAllActors.setTransferHandler(new ExportTransferHandler());

        lsMovieActors.setDropMode(DropMode.ON);
        lsMovieActors.setTransferHandler(new ImportTransferHandler());

    }

    private void loadMovieActorsModel() {
        actorModel.clear();
        listMovieActors.forEach(actorModel::addElement);
        lsMovieActors.setModel(actorModel);

    }

    private class ExportTransferHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        public Transferable createTransferable(JComponent c) {
            return new PersonTransferable(lsAllActors.getSelectedValue());
        }

    }

    private class ImportTransferHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(PersonTransferable.PERSON_FLAVOR);
        }

        @Override
        public boolean importData(TransferSupport support) {
            Transferable transferable = support.getTransferable();
            try {
                Person addTransferablePerson = (Person) transferable.getTransferData(PersonTransferable.PERSON_FLAVOR);
                if (listMovieActors.contains(addTransferablePerson)) {
                    MessageUtils.showErrorMessage("Error", "Actor is already in movie");
                  
                    return false;
                } else {
                    listMovieActors.add(addTransferablePerson);
                    loadMovieActorsModel();
                    return true;
                }
            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(ActorDragAndDrop.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }


    }

}
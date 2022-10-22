/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mario.view.model;

import hr.Mario.Model.Person;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mario
 */
public class ActorTableModel  extends AbstractTableModel{
    
     private static final String[] COLUMN_NAMES = {"Id","FirstName","LastName"};
    
    private List<Person> actors;

    public ActorTableModel(List<Person> actors) {
        this.actors = actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
         fireTableDataChanged();
    }
    
    
    

    @Override
    public int getRowCount() {
        
        return actors.size();
        
    }

    @Override
    public int getColumnCount() {
        
        return COLUMN_NAMES.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
          switch(columnIndex){
            case 0:
                return actors.get(rowIndex).getId();
            case 1:
                return actors.get(rowIndex).getFirstName();
            case 2:
                return actors.get(rowIndex).getLastName();
        
        }
        throw new RuntimeException("No such column");
        
    }
     @Override
    public String getColumnName(int column) {
        
        return COLUMN_NAMES[column];
     }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        
        switch(columnIndex){
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
}

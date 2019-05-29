/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook.application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author bangadam
 */
public class DokterTableModel extends AbstractTableModel{
    
    List<Dokter> listDokter=new ArrayList<Dokter>();
    private final String HEADER[]={"Id","Nama","Email","No. Telepon 1","No. Telepon 2"};
    
    public void setList(List<Dokter> listDokter){
        this.listDokter=listDokter;
    }
    
    public int getRowCount() {
        return listDokter.size();
    }
 
    public int getColumnCount() {
        return HEADER.length;
    }
    
    public String getColumnName(int column){
        return HEADER[column];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dokter Dokter=listDokter.get(rowIndex);
        
        switch(columnIndex){
            case 0:
            return Dokter.getId();
            
            case 1:
            return Dokter.getNama();
            
            case 2:
            return Dokter.getEmail();
                
            case 3:
            return Dokter.getNo_hp_1();
                
            case 4:
            return Dokter.getNo_hp_2();
                
            default:
            return null;
        }
    }   
}

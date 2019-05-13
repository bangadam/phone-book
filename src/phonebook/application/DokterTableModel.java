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
    private final String HEADER[]={"Nama","Alamat","No. Telepon 1","No. Telepon 2"};
    
    public void setList(List<Dokter> listDokter){
        this.listDokter=listDokter;
    }
    
    public void save(Dokter Dokter){
        listDokter.add(Dokter);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    public void edit(int index,Dokter Dokter){
        listDokter.set(index, Dokter);
        fireTableRowsUpdated(index, index);
    }
    
    public void delete(int index){
        listDokter.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    public Dokter findOne(int index){
        return listDokter.get(index);
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
            return Dokter.getNama();
            
            case 1:
            return Dokter.getAlamat();
                
            case 2:
            return Dokter.getNo_hp_1();
                
            case 3:
            return Dokter.getNo_hp_2();
                
            default:
            return null;
        }
    }   
}

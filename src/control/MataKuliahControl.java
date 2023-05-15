/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DosenDAO;
import dao.MataKuliahDAO;
import java.util.ArrayList;
import java.util.List;

import model.Dosen;
import model.MataKuliah;
import table.TableMataKuliah;

/**
 *
 * @author ALFA
 */
public class MataKuliahControl {
    private MataKuliahDAO mkDAO = new MataKuliahDAO();
    
    public void insertDataMataKuliah(MataKuliah mk){
        mkDAO.insertMataKuliah(mk);
    }
    
    public TableMataKuliah showDataDosen(String query){
        
        List<MataKuliah> list = mkDAO.showMataKuliah(query);
        
        return new TableMataKuliah(list);
        
        
    }
    
    
    
    public void updateDataDosen(MataKuliah mk){
        mkDAO.updateMataKuliah(mk);
    }
    
    public void deleteDataDosen(int id){
        mkDAO.deleteMataKuliah(id);
    }
}

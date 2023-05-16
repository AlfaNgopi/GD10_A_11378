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
    
    public TableMataKuliah showDataMataKuliah(String query){
        
        List<MataKuliah> list = mkDAO.showMataKuliah(query);
        
        return new TableMataKuliah(list);
        
        
    }
    
    
    
    public void updateDataMataKuliah(MataKuliah mk){
        mkDAO.updateMataKuliah(mk);
    }
    
    public void deleteDataMataKuliah(int id){
        mkDAO.deleteMataKuliah(id);
    }
}

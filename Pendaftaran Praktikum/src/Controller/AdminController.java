
package Controller;
import Entity.AslabEntity;
import Entity.DaftarprakEntity;
import Entity.PraktikanEntity;
import java.util.Date;
import java.util.ArrayList;
public class AdminController implements ControllerInterface{
    int indexLogin = 0;
    
    public AdminController(){
    
    }
    
    public void dataAslab(){
        String npmAslab [] = {"01","02","03","04","05","06","07"};
        String passwordAslab [] = {"01","02","03","04","05","06","07"};
        String namaAslab [] = {"Michael","Alan","Odil","Fitria","Sita","Eric","Fernanda"};
        String notelpAslab [] = {"01","02","03","04","05","06","07"};
        String tglLahirAslab [] = {"04/05/2000","01/12/2000","03/3/2000","23/06/2000","11/3/2000","13/9/2000","22/12/2000"};
        String laboratorium [] = {"RPL", "SO", "BASPROG", "BASPROG", "SO", "RPL", "RPL"};
        for (int i = 0; i<npmAslab.length; i++){
            AllObjectModel.aslabModel.insertAslab(new AslabEntity(npmAslab[i],passwordAslab[i],namaAslab[i],notelpAslab[i],
new Date(tglLahirAslab[i]), laboratorium[i]));
    }
}
    
    public void viewAslab(){
        AllObjectModel.aslabModel.view();
    }
    public void listPendaftarPraktikum(){
        AllObjectModel.daftarprakModel.view();
    }
    
    @Override
    public void login(String npm , String password){
        indexLogin = AllObjectModel.aslabModel.cekData(npm,password);
    }
    public AslabEntity aslabEntity07220() {
        return AllObjectModel.aslabModel.showDataAslab(indexLogin);
    }
    
    public void updateIsVerified(int index, int indexPrak, PraktikanEntity praktikanEntity) {
        AllObjectModel.daftarprakModel.updateIsVerified(index, new DaftarprakEntity(praktikanEntity, true, indexPrak));
    }

    public ArrayList<DaftarprakEntity>cekDaftarprakModel(){
return AllObjectModel.daftarprakModel.getDaftarprakArrayList();
}
    
}


    
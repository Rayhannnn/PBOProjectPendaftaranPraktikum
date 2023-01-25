
package Controller;
import Entity.DaftarprakEntity;
import Entity.PraktikanEntity;
import Entity.PraktikumEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class PraktikanController implements ControllerInterface{
    int indexLogin = 0;
    public PraktikanController(){
        
    }
    public PraktikanEntity getData(){
        return AllObjectModel.praktikanModel.getPraktikanEntityArrayList(indexLogin);
    }
    public void daftarPraktikum(int indexPraktikum , PraktikanEntity praktikanEntity , boolean isVerified){
        AllObjectModel.daftarprakModel.insertDataDaftarprak(new DaftarprakEntity(praktikanEntity, isVerified,indexPraktikum));
    }
    
    @Override
    public void login(String npm , String password){
        indexLogin = AllObjectModel.praktikanModel.cekData(npm,password);
    }
    
    public void insert(String npm , String password , String nama , String no_telp , Date tglLahir , String kelas){
        AllObjectModel.praktikanModel.insert(new PraktikanEntity(npm,password,nama,no_telp,tglLahir,kelas));
    }
    public PraktikanEntity PraktikanEntity(){
        return AllObjectModel.praktikanModel.getPraktikanEntityArrayList(indexLogin);
    }
    public int cekDaftarprak(String npm){
        int cek = AllObjectModel.daftarprakModel.cekData(npm, null);
        return cek;
    }
    public DaftarprakEntity showDaftarprak(int index){
        return AllObjectModel.daftarprakModel.showDaftarprak(index);
    }
    public DefaultTableModel daftarprak(){
        DefaultTableModel dtmdaftarprak = new DefaultTableModel();
        Object[] kolom ={"NPM","Nama","Password","No Telp","Tgl Lahir","Praktikum","Verified","Kelas"};
        dtmdaftarprak.setColumnIdentifiers(kolom);
        int size = AllObjectModel.daftarprakModel.alldataprak().size();
        String verif = null;
        for (int i=0;i<size;i++){
            if(AllObjectModel.daftarprakModel.alldataprak().get(i).isVerified()==false){
        verif = "no";
    }else{
        verif = "yes";
            }
    Object [] data = new Object[8];
    data[0] = AllObjectModel.daftarprakModel.alldataprak().get(i).getPraktikan().getNpm();
    data[1] = AllObjectModel.daftarprakModel.alldataprak().get(i).getPraktikan().getNama();
    data[2] = AllObjectModel.daftarprakModel.alldataprak().get(i).getPraktikan().getPassword();
    data[3] = AllObjectModel.daftarprakModel.alldataprak().get(i).getPraktikan().getTglLahir();
    data[4] = new SimpleDateFormat("dd-MM-yyyy").format(AllObjectModel.daftarprakModel.alldataprak().get(i).getPraktikan().getTglLahir());
    data[5] = PraktikumEntity.nama[AllObjectModel.daftarprakModel.alldataprak().get(i).getIndexPraktikum()];
    data[6] = verif;
    data[7] = AllObjectModel.daftarprakModel.alldataprak().get(i).getPraktikan().getKelas();
    dtmdaftarprak.addRow(data);
        }
    return dtmdaftarprak;
    }
}


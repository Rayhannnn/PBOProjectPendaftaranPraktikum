
package Model;
import Entity.DaftarprakEntity;
import Entity.PraktikumEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DaftarprakModel implements ModelInterfaces {
    private ArrayList<DaftarprakEntity> daftarprakArrayList;
    public DaftarprakModel(){
        daftarprakArrayList = new ArrayList<DaftarprakEntity>();
    }
    public void insertDataDaftarprak(DaftarprakEntity daftarprak){
        daftarprakArrayList.add(daftarprak);
    }
    public ArrayList<DaftarprakEntity> getDaftarprakArrayList(){
        return daftarprakArrayList;
    }
    public ArrayList<DaftarprakEntity>alldataprak(){
        return daftarprakArrayList;
    }
    
    public void view(){
        for(DaftarprakEntity daftarprak : daftarprakArrayList){
            System.out.println("===================================");
            System.out.println(" NPM : "+daftarprak.getPraktikan().getNpm()+"\n Nama : "+daftarprak.getPraktikan().getNama()+"\n Password : "+daftarprak
                    .getPraktikan().getPassword()+"\n No.Telp : "+daftarprak.getPraktikan().getNo_telp()+"\n Tanggal Lahir : "+new SimpleDateFormat
        ("dd-MM-yyyy").format(daftarprak.getPraktikan().getTglLahir())+"\n Praktikum : "+PraktikumEntity.nama[daftarprak.getIndexPraktikum()]+"\n isVerified : ");
            if (daftarprak.isVerified() == false){
                System.out.println("Belum Di Verifikasi Admin");
            }else{
                System.out.println("Telah Di Verifikasi");
            }
            System.out.println("====================================");
        }
    }
    @Override
    public int cekData(String npm, String password){
        int loop = 0;
        if(daftarprakArrayList.size()==0){
            loop = -1;
        }else{
        for(int i=0;i<daftarprakArrayList.size();i++){
            if(daftarprakArrayList.get(i).getPraktikan().getNpm().equals(npm)){
                loop = i;
                break;
            }else{
                loop = -2;
            }
            }
        }
        return loop;
    }
    public DaftarprakEntity showDaftarprak(int index){
        return daftarprakArrayList.get(index);
    }
    public void updateIsVerified(int index, DaftarprakEntity daftarprakEntity){
        daftarprakArrayList.set(index, daftarprakEntity);
    }
}

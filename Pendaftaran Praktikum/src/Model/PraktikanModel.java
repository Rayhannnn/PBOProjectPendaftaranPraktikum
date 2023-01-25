
package Model;
import Entity.PraktikanEntity;
import java.util.ArrayList;
public class PraktikanModel implements ModelInterfaces {
    private ArrayList<PraktikanEntity> praktikanEntityArrayList;
    
    public PraktikanModel(){
        praktikanEntityArrayList = new ArrayList<PraktikanEntity>();
    }
    public void insert(PraktikanEntity praktikanEntity){
        praktikanEntityArrayList.add(praktikanEntity);
    }
    @Override
    public void view(){
        for(PraktikanEntity praktikanEntity : praktikanEntityArrayList){
            System.out.println("===========================================");
            System.out.println(" NPM : "+praktikanEntity.getNpm()+"\n Nama : "+praktikanEntity.getNama()+"\n Password"+praktikanEntity.getPassword()+"\n no.telp"
            +praktikanEntity.getNo_telp()+"\n Tanggal Lahir"+praktikanEntity.getTglLahir());
            System.out.println("===========================================");
        }
    }
    @Override
    public int cekData(String npm, String password){
        int loop = 0;
        while(!praktikanEntityArrayList.get(loop).getNpm().equals(npm)&&!praktikanEntityArrayList.get(loop).getPassword().equals(password)){
            loop++;
        }
        return loop;
    }
    public PraktikanEntity getPraktikanEntityArrayList(int index){
        return praktikanEntityArrayList.get(index);
    }
}

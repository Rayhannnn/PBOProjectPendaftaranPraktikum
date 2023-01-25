
package Model;
import Entity.AslabEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AslabModel implements ModelInterfaces {
    private ArrayList<AslabEntity> aslabEntityArrayList;
    
public AslabModel(){
    aslabEntityArrayList = new ArrayList<AslabEntity>();
}
    public void insertAslab(AslabEntity aslab){
        aslabEntityArrayList.add(aslab);
    }
    @Override
public void view(){
    for(AslabEntity aslabEntity : aslabEntityArrayList){
        System.out.println(aslabEntity.getNpm());
        System.out.println(aslabEntity.getNama());
        System.out.println(aslabEntity.getPassword());
        System.out.println(aslabEntity.getNo_telp());
        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(aslabEntity.getTglLahir()));
        System.out.println();
    }
}
@Override
public int cekData(String npm, String password){
    int loop = 0;
    for(AslabEntity aslabEntity : aslabEntityArrayList){
        if(aslabEntity.getNpm().equals(npm) && aslabEntity.getPassword().equals(password)){
            break;
        }else{
            loop++;
        }
    }return loop;
}
public AslabEntity showDataAslab(int index){
    return aslabEntityArrayList.get(index);
}
}

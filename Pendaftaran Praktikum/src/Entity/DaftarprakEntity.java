
package Entity;

public class DaftarprakEntity {
    private PraktikanEntity praktikan;
    private boolean isVerified;
    private int IndexPraktikum;

    public DaftarprakEntity(PraktikanEntity praktikan, boolean isVerified, int IndexPraktikum) {
        this.praktikan = praktikan;
        this.isVerified = isVerified;
        this.IndexPraktikum = IndexPraktikum;
    }

    public PraktikanEntity getPraktikan() {
        return praktikan;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getIndexPraktikum() {
        return IndexPraktikum;
    }

    public void setIndexPraktikum(int IndexPraktikum) {
        this.IndexPraktikum = IndexPraktikum;
    }
}

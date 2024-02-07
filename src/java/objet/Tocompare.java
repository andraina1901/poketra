package objet;


public class Tocompare {
    String idmodel;
    String idmatiere_premiere;
    double tocompare;

    public Tocompare(String idmodel, String idmatiere_premiere, double tocompare) {
        this.idmodel = idmodel;
        this.idmatiere_premiere = idmatiere_premiere;
        this.tocompare = tocompare;
    }

    public Tocompare() {
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public String getIdmatiere_premiere() {
        return idmatiere_premiere;
    }

    public void setIdmatiere_premiere(String idmatiere_premiere) {
        this.idmatiere_premiere = idmatiere_premiere;
    }

    public double getTocompare() {
        return tocompare;
    }

    public void setTocompare(double tocompare) {
        this.tocompare = tocompare;
    }
}

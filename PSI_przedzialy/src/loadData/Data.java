/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadData;

/**
 *
 * @author admin
 */
public class Data {
    
    private double FFnumber;
    private double FSnumber;
    private double SFnumber;
    private double SSnumber;
    private int A;
    private int B;
    private int C;
    
    public Data(double FF, double FS, double SF, double SS){
        FFnumber = FF;
        FSnumber = FS;
        SFnumber = SF;
        SSnumber = SS;
    }
    
    public double getFFnumber() {
        return FFnumber;
    }

    public void setFFnumber(double FFnumber) {
        this.FFnumber = FFnumber;
    }

    public double getFSnumber() {
        return FSnumber;
    }

    public void setFSnumber(double FSnumber) {
        this.FSnumber = FSnumber;
    }

    public double getSFnumber() {
        return SFnumber;
    }

    public void setSFnumber(double SFnumber) {
        this.SFnumber = SFnumber;
    }

    public double getSSnumber() {
        return SSnumber;
    }

    public void setSSnumber(double SSnumber) {
        this.SSnumber = SSnumber;
    }

    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }

    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }

    public int getC() {
        return C;
    }

    public void setC(int C) {
        this.C = C;
    }
    
    public void addToA(){
        setA(getA() + 1);
    }
    
    public void addToB(){
        setB(getB() + 1);
    }
    
    public void addToC(){
        setC(getC() + 1);
    }
    
    @Override
    public String toString(){
        return getFFnumber() + " " + getFSnumber() + " " + getSFnumber() + " " + getSSnumber() + " " + getA() + " " + getB() + " " + getC();
    }
    
    public boolean porownanie(Data d){
        return ( (d.getFFnumber() == this.getFFnumber()) && (d.getFSnumber() == this.getFSnumber()) && (d.getSFnumber() == this.getSFnumber()) && (d.getSSnumber() == this.getSSnumber()) );
    }
    
    public boolean porownanieApro(Data d){
        return ( ((this.getFFnumber() >= d.getFFnumber()) && (this.getFSnumber() <= d.getFSnumber())) &&
                ((this.getSFnumber() >= d.getSFnumber()) && (this.getSSnumber() <= d.getSSnumber())) );
    }
    
}

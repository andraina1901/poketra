/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author P15A-56-jeremia
 */
public class MonDate implements Serializable{
    private Date date;
    private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss.SSS");
//    private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public MonDate(){
        date = new Date();
    }
    
    public MonDate(String date)throws Exception{
        this.setDate(date);
    }
    
    
    private Date getLaDate(){
        return this.date;
    }
    
    public void setDate(String date)throws Exception{
        this.date = formatDate.parse(date);
    }
    
    public void setDate(String date,String format)throws Exception{
        this.changeFormat(format);
        this.date = formatDate.parse(date);
    }
    
    public MonDate(String date,String format)throws Exception{
        this.changeFormat(format);
        this.setDate(date);
    }
    
    public int compareTo(MonDate date1){
        int result = this.date.compareTo(date1.getLaDate());
        return result;
    }
    
    public void changeFormat(String format){
        formatDate.applyPattern(format);
    }
    
    public String getDate(){
        return formatDate.format(this.date);
    }
    
    public String getDate(String format)throws Exception{
        this.changeFormat(format);
        return formatDate.format(this.date);
    }
    
    public String getDateLettre(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("en", "US"));
        String formattedDate = sdf.format(this.date);
        return formattedDate;
    }
    
    public void addNumberOfDay(int j){
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.date);
        cal.add(Calendar.DAY_OF_MONTH, j);
        this.date = cal.getTime();
    }
}

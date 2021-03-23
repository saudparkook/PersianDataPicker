package libjdate;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class tabdilatshamsi {

    private Calendar calendar;
    private int hy, hm, hd;
    ArrayList<Integer>listKabise=new ArrayList<>();

String[] FA_moon = {"\u0641\u0631\u0648\u0631\u062f\u06cc\u0646", // Farvardin
                "\u0627\u0631\u062f\u06cc\u200c\u0628\u0647\u0634\u062a", // Ordibehesht
                "\u062e\u0631\u062f\u0627\u062f", // Khordad
                "\u062a\u06cc\u0631", // Tir
                "\u0645\u0631\u062f\u0627\u062f", // Mordad
                "\u0634\u0647\u0631\u06cc\u0648\u0631", // Shahrivar
                "\u0645\u0647\u0631", // Mehr
                "\u0622\u0628\u0627\u0646", // Aban
                "\u0622\u0630\u0631", // Azar
                "\u062f\u06cc", // Dey
                "\u0628\u0647\u0645\u0646", // Bahman
                "\u0627\u0633\u0641\u0646\u062f" // Esfand
        };
    
  
    private final int[]kabise={
    1210,1214,1218,1222,1226,1230,1234,1238,1243,1247,1251,1255,1259,1263,1267,1271,1276,1280,1284,1288,1292,1296,
        1300,1304,1309,1313,1317,1321,1325,1329,1333,1337,1342,1346,1350,1354,1358,1362,1366,1370,1375,1379,1383,1387,1391,1395,1399,
        1403,1408,1412,1416,1420,1424,1428,1432,1436,1441,1445,1449,1453,1457,1461,1465,1469,1474,1478,1482,1486,1490,1494,1498,
        1502,1507
    
    };
int[]estesna={9 , 13 , 17 , 21 , 42 , 46 , 50 , 54 , 71 , 75 , 79 , 83 ,
    87 , 104 , 108 , 112 , 116 , 137 , 141 , 145 , 149 , 170 , 174 , 178
        , 182 , 203 , 207 , 211 , 215 , 236 , 240 , 244 , 269 , 273 ,
        277 , 302 , 306 , 310 , 331 , 335 , 339 , 343 , 364 , 368 ,
        372 , 397 , 401 , 405 , 430 , 434 , 438 , 463 , 467 , 471 ,
        475 , 496 , 500 , 504 , 529 , 533 , 537 , 558 , 562 , 566 ,
        570 , 591 , 595 , 599 , 603 , 624 , 628 , 632 , 661 , 665 ,
        690 , 694 , 698 , 723 , 727 , 731 , 756 , 760 , 789 , 793 ,
        822 , 826 , 855 , 859 , 888 , 921 , 954 , 983 , 987 , 1016 ,
        1049 , 1082 , 1115 , 1243};
    int[]estesna2={1276 , 1309 , 1342 , 1403 , 1436 , 1469 , 1474 , 1502,1531,1535,1564,1568,1597,1601};
    int[]zarib1={0,4,8,12,16,20,24,29,33,37,41,45,49,53,57,62,66,70,74,78,82,86,90,95,99,103,107,111,115,119,124};
    int[]zarib2={0,4,8,12,16,20,25,29,33,37,41,45,49,53,58,62,66,70,74,78,82,86,91,95,99,103,107,111,115,120,124};
     

private void SettKabisList(){
     
    ArrayList<String>lz1=new ArrayList<String>();
    ArrayList<String>lz2=new ArrayList<String>();
    for(int i=0;i<zarib1.length;i++){
    lz1.add(zarib1[i]+"");
    lz2.add(zarib2[i]+"");
    }
    int x=0;
        for(int i=1;i<1610;i++){
            x=i%128;

            if(i>473&&lz1.indexOf(x+"")>=0){
                String[]t={i+"",x+""};
                listKabise.add(i);
            }else if(i<474&&lz2.indexOf(x+"")>=0){
                String[]t={i+"",x+""};
                listKabise.add(i);
                
            }

        }
        
        for(int i=0;i<listKabise.size();i++){
            int lk=listKabise.get(i);
            int sal=lk;
        
            lk=Searcharray(sal, estesna,-1);
            listKabise.set(i, lk);
            sal=lk;
            lk=Searcharray(sal, estesna2,1);
            listKabise.set(i, lk);
       
           System.err.println(lk);

        }

       
    }

    public tabdilatshamsi() {
    
        calendar = new GregorianCalendar();
        hy = calendar.get(Calendar.YEAR);
        hm = calendar.get(Calendar.MONTH) + 1;
        hd = calendar.get(Calendar.DAY_OF_MONTH);
        SettKabisList();

       
        
        
    }
    
    private int Searcharray(int sal,int[]searched,int mohasebeh){
    int res=sal;
    for(int y=0;y<searched.length;y++){
        if(sal==searched[y]+mohasebeh){
        res=searched[y]; 
        break;
        }
        }
    return res;
    }
    
    
 public boolean kabiseShamsi(int sal){
     
     for(int i:listKabise){
     if(i==sal)
         return true;
     
     }
     return false;
     }
    public int[] emrozMiladi() {
        int[] a = {hy, hm, hd};
        return a;

    }
    public int[] emrozShamsi() {
         return gregorian_to_jalali(hy,hm,hd);
    }

    String DayofWeek(int week) {
        String w = null;
        switch (week) {
            case 3:
                w = "يکشنبه";
                break;
            case 4:
                w = "دوشنبه";
                break;
            case 5:
                w = "سه شنبه";
                break;
            case 6:
                w = "چهارشنبه";
                break;
            case 0:
                w = "پنجشنبه";
                break;
            case 1:
                w = "جمعه";
                break;
            case 2:
                w = "شنبه";
                break;
        }
        return w;
    }

   

    public String ForStringDay(int gy, int gm, int gd) {

        int m = gm;
        int d = gd;
        int res=0;
        int kt=0;
        int kf=0;
        for(int i=0;i<gy;i++){
            if(kabiseShamsi(i)==true){
                kt++;
            }else{
                kf++;
            }
        }

        kt=kt*366;
        kf=kf*365;
        if (m<=6){
            m=m*31;
        }else if(m>6&&m<12){
            m=(m*30)+7;
        }else if(m==12&&kabiseShamsi(gy)==true){
            m=(m*30)+7;
        }else if(m==12&&kabiseShamsi(gy)==false){
            m=(m*30)+7;
        }
        m=m-31;
        d=d-1;

        res=kf+kt+m+d;
        int sh=0;
        for(int i=1;i<=res;i++){
            sh++;
            if(sh>6){
                sh=0;
            }
        }



        return DayofWeek(sh);
    }




public int lengthofdaymon(int y,int m){
    int len=30;
    if(m<7){
    len=31;
    }else if(m>6&&m<12){
    len=30;
    }else {
        if(kabiseShamsi(y)){
        len=30;
        }else{
        len=29;  
        }
    }
    return len;
    }
    







/*
    void maxday() {
        if (m.getValue() < 7) {
            d.setMaxValue(31);
        } else if (m.getValue() > 6 && moh.kabiseShamsi(Integer.parseInt(ya[y.getValue() - 1])) == true) {
            d.setMaxValue(30);
        } else if (m.getValue() != 12 && m.getValue() > 6 && moh.kabiseShamsi(Integer.parseInt(ya[y.getValue() - 1])) == false) {
            d.setMaxValue(30);
        } else if (m.getValue() == 12 && moh.kabiseShamsi(Integer.parseInt(ya[y.getValue() - 1])) == false) {
            d.setMaxValue(29);
        }
    }
    */














    public static int[] gregorian_to_jalali(int gy, int gm, int gd){
        int[] g_d_m = {0,31,59,90,120,151,181,212,243,273,304,334};
        int jy;
        if(gy>1600){
            jy=979;
            gy-=1600;
        }else{
            jy=0;
            gy-=621;
        }
        int gy2 = (gm > 2)?(gy + 1):gy;
        int days = (365 * gy) + ((int)((gy2 + 3) / 4)) - ((int)((gy2 + 99) / 100)) + ((int)((gy2 + 399) / 400)) - 80 + gd + g_d_m[gm - 1];
        jy += 33 * ((int)(days / 12053));
        days %= 12053;
        jy += 4 * ((int)(days / 1461));
        days %= 1461;
        if(days > 365){
            jy+=(int)((days-1)/365);
            days=(days-1)%365;
        }
        int jm = (days < 186)?1 + (int)(days / 31):7 + (int)((days - 186) / 30);
        int jd = 1 + ((days < 186)?(days % 31):((days - 186) % 30));
        int[] out = {jy,jm,jd};
        return out;
    }


    public static int[] jalali_to_gregorian(int jy, int jm, int jd){
        int gy;
        if(jy>979){
            gy=1600;
            jy-=979;
        }else{
            gy=621;
        }
        int days = (365 * jy) + (((int)(jy / 33)) * 8) + ((int)(((jy % 33) + 3) / 4)) + 78 + jd + ((jm < 7)?(jm - 1) * 31:((jm - 7) * 30) + 186);
        gy += 400 * ((int)(days / 146097));
        days %= 146097;
        if(days > 36524){
            gy += 100 * ((int)(--days / 36524));
            days %= 36524;
            if (days >= 365)days++;
        }
        gy += 4 * ((int)(days / 1461));
        days %= 1461;
        if(days > 365){
            gy += (int)((days - 1) / 365);
            days = (days - 1) % 365;
        }
        int gd = days + 1;
        int[] sal_a = {0,31,((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0))?29:28,31,30,31,30,31,31,30,31,30,31};
        int gm;
        for(gm = 0;gm < 13;gm++){
            int v = sal_a[gm];
            if(gd <= v)break;
            gd -= v;
        }
        int[] out = {gy,gm,gd};
        return out;
    }










}

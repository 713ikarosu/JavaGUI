//package com.ikarosu.mypaintapp;
//
//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//
//public class MyOval extends MyDrawing{
//    public MyOval(int xpt, int ypt, int wpt, int hpt) { // 課題2-1の時は，x,y 以外は初期値を利用
//        super();
//        setLocation(xpt,ypt);
//        setSize(wpt,hpt);
//        // setLineColor(lcolor); // 線の色を指定
//        // setfillColor(fcolor); // 塗りつぶしの色を指定
//    }
//
//    public void draw(Graphics g) {
//        super.draw(g);
//
//        int x = getX();
//        int y = getY();
//        int w = getW();
//        int h = getH();
//
//        // 高さや横幅が負の時の為の処理
//        if (w < 0) {
//            x += w;
//            w *= -1;
//        } if (h < 0 ) {
//            y += h;
//            h *= -1;
//        }
//
//        Graphics2D g2 = (Graphics2D) g;
//        if(getShadow()){
//            int x2 = x+10;
//            int y2 = y+10;
//            g2.setStroke(new BasicStroke(getLineWidth()));
//            g2.setColor(Color.black);
//            g2.fillOval(x2, y2, w, h);
//            g2.setColor(Color.black);
//            g2.drawOval(x2, y2, w, h);
//        }
//        g2.setStroke(new BasicStroke(getLineWidth()));
//        g2.setColor(getFillColor());
//        g2.fillOval(x, y, w, h);
//        g2.setColor(getLineColor());
//        g2.drawOval(x, y, w, h);
//
//    }
//}

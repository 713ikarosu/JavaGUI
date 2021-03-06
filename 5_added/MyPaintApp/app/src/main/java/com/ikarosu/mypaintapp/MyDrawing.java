//package com.ikarosu.mypaintapp;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Rectangle;
//import java.awt.Shape;
//import java.io.Serializable;
//
//public class MyDrawing {
//    private int x, y, w, h; // X座標, Y座標, 幅, 高さ
//    private Color lineColor, fillColor; //線の色, 塗り色
//    private int lineWidth; // 線の太さ
//    boolean isSelected;
//    Shape region; // 包含判定用
//    final int SIZE = 7; // 選択表示短形に付く四角形の大きさ
//    private int len; //外接円の半径の長さ(多角形)
//
//    boolean isShadow = false; // 影の有無
//
//    public MyDrawing() {
//        x = y = 0;
//        w = h = 40;
//        len = 10;
//        lineColor = Color.black;
//        fillColor = Color.white;
//        lineWidth = 1;
//        setRegion();
//    }
//
//    public MyDrawing clone(){
//        MyDrawing result = null;
//
//        try {
//            result = (MyDrawing)super.clone();
//        } catch(CloneNotSupportedException cnse) {
//
//        }
//        return result;
//    }
//
//    public void draw(Graphics g) {
//        // 選択状態を表す四角形を描く
//        if(isSelected) {
//            g.setColor(Color.black);
//            g.fillRect(x+w/2-SIZE/2,y-SIZE/2,SIZE,SIZE);
//            g.fillRect(x-SIZE/2,y+h/2-SIZE/2,SIZE,SIZE);
//            g.fillRect(x+w/2-SIZE/2,y+h-SIZE/2,SIZE,SIZE);
//            g.fillRect(x+w-SIZE/2,y+h/2-SIZE/2,SIZE,SIZE);
//            g.fillRect(x-SIZE/2,y-SIZE/2,SIZE,SIZE);
//            g.fillRect(x+w-SIZE/2,y-SIZE/2,SIZE,SIZE);
//            g.fillRect(x-SIZE/2,y+h-SIZE/2,SIZE,SIZE);
//            g.fillRect(x+w-SIZE/2,y+h-SIZE/2,SIZE,SIZE);
//        }
//    }
//
//    public boolean getSelected(){
//        return isSelected;
//    }
//
//    public void setSelected(boolean isSelected) {
//        this.isSelected  = isSelected;
//    }
//
//    // 包含判定用のメソッド
//    public boolean contains(int x, int y) {
//        // MyDrawing を継承する子クラス内でそれぞれ定義する．
//        // 包含判定図形が短形ならば，例えば，
//        return region.contains(x,y);
//    }
//
//    public void setRegion(){
//        // MyDrawing を継承する子クラス内でそれぞれ定義する．
//        // 包含判定図形が短形ならば，例えば，
//        region = new Rectangle(x,y,w,h);
//    }
//
//    public void move(int dx, int dy) {
//        // オブジェクトを移動する処理を書く
//        this.x += dx;
//        this.y += dy;
//    }
//
//    public boolean getShadow(){ // 影の有無の取得
//        return isShadow;
//    }
//
//    public void setLocation(int x, int y) {
//        // オブジェクトの位置を変更する処理を書く
//        this.x = x;
//        this.y = y;
//    }
//
//    public void setSize(int w, int h) {
//        // オブジェクトのサイズを変更する処理を書く
//        this.w = w;
//        this.h = h;
//    }
//
//    public void setLen(int len){
//        this.len = len;
//    }
//
//    public int getX() {
//        // オブジェクトの X 位置を取得する処理を書く
//        return this.x;
//    }
//
//    public int getY() {
//        // オブジェクトの Y 位置を取得する処理を書く
//        return this.y;
//    }
//
//    public int getW() {
//        // オブジェクトの幅を取得する処理を書く
//        return this.w;
//    }
//
//    public int getH() {
//        // オブジェクトの高さを取得する処理を書く
//        return this.h;
//    }
//
//    public int getLen(){
//        // オブジェクトの辺の長さを取得する
//        return this.len;
//    }
//
//    public int getLineWidth() {
//        // 線の太さ
//        return this.lineWidth;
//    }
//
//    public void setLineWidth(int a) {
//        // 線の太さ を設定
//        this.lineWidth = a;
//    }
//
//    public void setLineColor(Color a) {
//        // lineColor を設定
//        this.lineColor = a;
//    }
//
//    public void setfillColor(Color b) {
//        // fillColor を設定
//        this.fillColor = b;
//    }
//
//    public Color getLineColor() {
//        // lineColor を取得
//        return lineColor;
//    }
//
//    public Color getFillColor() {
//        // fillColor を取得
//        return fillColor;
//    }
//
//    public void setAlpha(int a) {
//        Color temp = fillColor;
//        fillColor = new Color(temp.getRed(),temp.getGreen(),temp.getBlue(),a);
//    }
//}

//package com.ikarosu.mypaintapp;
//
//import javax.swing.JPanel;
//
//public class MyCanvas extends JPanel {
//    Mediator mediator;
//
//    public MyCanvas() {
//        this.mediator = new Mediator(this);
//        setBackground(Color.white);
//    }
//
//    public Mediator getMediator(){
//        return mediator;
//    }
//
//    public void paint(Graphics g){
//        super.paint(g);
//
//        Enumeration<MyDrawing> e = mediator.drawingsElements(); // クラスライブラリEnumerationで走査
//        while (e.hasMoreElements()){
//            MyDrawing d = e.nextElement();
//            d.draw(g);
//        }
//    }
//}

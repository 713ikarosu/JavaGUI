import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class FileStream extends MyDrawing {
  // transient protected Line2D.Double from, to;
  Vector v;
  MyImage myImage;

  public FileStream(){}

  // File入力
  public Vector fileInput(File file){
    try {
      FileInputStream fin = new FileInputStream(file);
      ObjectInputStream in = new ObjectInputStream(fin);

      v = (Vector)in.readObject();
      fin.close();
    } catch(Exception ex){
    }
    return v;
  }

  // File 出力
  public void fileOutput(Vector v,File file){
    try {
      FileOutputStream fout = new FileOutputStream(file);
      ObjectOutputStream out = new ObjectOutputStream(fout);

      out.writeObject(v);
      out.flush();

      fout.close();
    } catch(Exception ex){
    }
  }

  // 画像ファイル入力用
  public MyImage fileInput2(File file) {
	  try {
	      FileInputStream fin = new FileInputStream(file);
	      ObjectInputStream in = new ObjectInputStream(fin);

	      myImage = new MyImage((File)in.readObject());
	      fin.close();
	    } catch(Exception ex){
	    }
	    return myImage;
  }

  // private void writeObject(ObjectOutputStream out) {
  //   // フィールドの値をdouble型で書き出す
  //   // double型の場合は問題なくセーブできる
  //   out.writeDouble(from.x);
  //   out.writeDouble(from.y);
  //   out.writeDouble(to.x);
  //   out.writeDouble(to.y);
  // }
  //
  // private void readObject(ObjectInputStream in) {
  //   // 一旦double型で読み込み，その情報をもとにfrom, to を復元する
  //   double fromx = in.readDouble();
  //   double fromy = in.readDouble();
  //   double tox = in.readDouble();
  //   double toy = in.readDouble();
  //
  //   from = new Line2D.Double(fromx,fromy);
  //   to = new Line2D.Double(tox,toy);
  // }
}

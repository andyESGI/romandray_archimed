package ESGI.CinqAL.GabMirMoh.Function;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializDeserializ 
{
    public static Object deserialize(String str_fileName) throws IOException,ClassNotFoundException 
    {
        FileInputStream o_fis = new FileInputStream(str_fileName);
        ObjectInputStream o_ois = new ObjectInputStream(o_fis);
        Object obj = o_ois.readObject();
        o_ois.close();
        return obj;
    }
 
    public static void serialize(Object obj, String str_fileName)throws IOException 
    {
        FileOutputStream o_fos = new FileOutputStream(str_fileName);
        ObjectOutputStream o_oos = new ObjectOutputStream(o_fos);
        o_oos.writeObject(obj);
 
        o_fos.close();
    }

}

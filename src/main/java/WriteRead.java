import java.io.*;

public class WriteRead {


    public void outSerialize(Tree tree) {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Desktop\\forSerDes\\Tree" + tree.getHead().getData() + ".txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos))

        {
            oos.writeObject(tree);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            System.out.println("Исключение: " + e);
            throw new RuntimeException(e);
        }
    }

    public Tree inSerialize(int data) {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\forSerDes\\Tree.txt");
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            return new Tree((Tree) oin.readObject());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("load tree faild", e);

        } catch (IOException i) {
            throw new RuntimeException("load tree faild", i);

        } catch (ClassNotFoundException c) {
            throw new RuntimeException("load tree faild", c);
        }
    }
}
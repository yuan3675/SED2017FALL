import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Map<String, ListObject> listObjectMap = new HashMap<>();
        Map<String, SkipList> skipListMap = new HashMap<>();

        while((line = reader.readLine()) != null) {
            String[] info = line.split(" ");

            if (info[0].equals("Create")) {
                if(info[2].equals("List")) {
                    ListObject listObject = new ListObject();
                    listObjectMap.put(info[1], listObject);
                }
                else if (info[2].equals("SkipList")) {
                    SkipList skipList = new SkipList();
                    skipListMap.put(info[1], skipList);
                }
            }
            else if (info[0].equals("Add")) {
                if (listObjectMap.get(info[1]) == null) {
                    SkipList skipList = skipListMap.get(info[1]);
                    SkipNode skipNode = new SkipNode(info[2]);
                    skipList.getSkipNodes().add(skipNode);
                }
                else {
                    ListObject listObject = listObjectMap.get(info[1]);
                    StringObject stringObject = new StringObject(info[2]);
                    listObject.getStringObjectArrayList().add(stringObject);
                    listObject.addLength();
                }
            }
            else if (info[0].equals("Length")) {
                ListObject listObject = listObjectMap.get(info[1]);
                if (listObject != null) {
                    System.out.println(listObject.length);
                }
                else {
                    System.out.println("SkipList can not access length");
                }
            }
            else if (info[0].equals("Size")) {
                SkipList skipList = skipListMap.get(info[1]);
                if (skipList != null) {
                    System.out.println(skipList.getSize());
                }
                else {
                    System.out.println("List do not have method size");
                }
            }
            else if (info[0].equals("Get")) {
                ListObject listObject = listObjectMap.get(info[1]);
                if (listObject != null) {
                    System.out.println(listObject.get(Integer.parseInt(info[2])));
                }
                else {
                    System.out.println("SkipList do not have method get");
                }
            }
            else if (info[0].equals("GetNode")) {
                SkipList skipList = skipListMap.get(info[1]);
                if (skipList != null) {
                    System.out.println(skipList.getNode(Integer.parseInt(info[2])));
                }
                else {
                    System.out.println("List do not have method getNode");
                }
            }
            else if (info[0].equals("PrintOutList")) {
                if (listObjectMap.get(info[1]) == null) {
                    SkipList skipList = skipListMap.get(info[1]);
                    SListT slistT = new SListT();
                    slistT.traverse(skipList);
                }
                else {
                    ListObject listObject = listObjectMap.get(info[1]);
                    ListT listT = new ListT();
                    listT.traverse(listObject);
                }
            }
        }
    }
}

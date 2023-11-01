public class StringOperations {
    public static void main(String[] args) {
        StringBuffer strBuff = new StringBuffer("New characters");
        strBuff.append(" can be Appended (This will be deleted).");
        strBuff.insert(22,"Inserted and ");
        System.out.println(strBuff + "\nLength:" + strBuff.length());
        strBuff.delete(43,66);
        System.out.println(strBuff);
    }
}

/*
Output:
        New characters can be Inserted and Appended (This will be deleted).
        Length:67
        New characters can be Inserted and Appended.
*/

package course1.week1;

import common.NotFinished;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrey on 17/03/17.
 */
@NotFinished("Using BigInteger instead. Only one method not implemented here.")
public class MyNumber {

    public static MyNumber valueOf(String str) {
        //not treating leading zeros
        LinkedList<Byte> digits = new LinkedList<>();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                throw new NumberFormatException("Not a digit : " + c);
            }
            int digit = c - 48;
            digits.add((byte) digit);
        }
        return new MyNumber(digits);
    }

    final private List<Byte> digits;
    final private String stringValue;

    public MyNumber(List<Byte> digits) {
        this.digits = digits;
        this.stringValue = buildString();
    }

    public int getLength(){
        return digits.size();
    }

    public long toLong(){
        long res = 0;
        for (int i=0; i<digits.size(); i++) {
            res = res * 10 + digits.get(i);
        }
        return res;
    }

    public MyNumber subNumber(short from, short to) {
        validateIndices(from, to);
        return new MyNumber(digits.subList(from, to));
    }

    public MyNumber rightPadWithZeros(int n){
        LinkedList<Byte> newDigits = new LinkedList<>(digits);
        for (int i = 0; i < n; i++) {
            newDigits.add((byte)0);
        }
        return new MyNumber(newDigits);
    }

    @NotFinished("")
    public MyNumber add(MyNumber other){
        LinkedList<Byte> resDigits = new LinkedList<>();

//        resDigits.addFirst();

        return null;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }

    private String buildString(){
        StringBuilder sb = new StringBuilder();
        for (Byte digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    private void validateIndices(short from, short to) {
        if (from<0 || to>getLength()-1 || from>to) {
            throw new NumberFormatException("bad indices: from [" + from + "], to [" + to + "]");
        }
    }
}
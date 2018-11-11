package com.fit;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

public class ReaderWithCondition {
    Reader reader;

    public ReaderWithCondition(Reader reader){
        this.reader = reader;
    }
    public  char[] next() throws IOException{
        char[] result = null;
        while(true) {
            int currentChar;
            if ((currentChar = findExpectedCharacter()) == -1) {
                break;
            }
            if (Symbol.isVowel((char) currentChar)) {
                char[] temp = getCharacters();
                result = new char[temp.length + 1];
                System.arraycopy(temp, 0, result, 1, temp.length);
                result[0] = (char) currentChar;
                break;
            } else {
                skipCharacter();
            }
        }
        return result;
    }
    private int findExpectedCharacter() throws IOException{
        int currentChar;
        while((currentChar= reader.read())!=-1) {
            if (Character.isLetter(currentChar)) {
                return currentChar;
            }
        }
        return -1;
    }
    private void skipCharacter() throws IOException{
        int currentChar;
        while((currentChar= reader.read())!=-1) {
            if (!Character.isLetter(currentChar)) {
                break;
            }
        }
    }
    private char[] getCharacters() throws IOException{
        char[] result = new char[0];
        int currentChar;
        while((currentChar= reader.read())!=-1) {
            if (Character.isLetter(currentChar)) {
                result = Arrays.copyOf(result, result.length+1);
                result[result.length-1] = (char)currentChar;
            }
            else{
                break;
            }
        }
        return result;
    }
}

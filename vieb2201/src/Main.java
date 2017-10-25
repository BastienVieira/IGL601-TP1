import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> CompareFiles = new ArrayList<ArrayList<String>>();
        ArrayList<String> CompareSortie = new ArrayList<String>();

        try{

            File currentDirFile = new File("CompareSortie");
            String currentDir = currentDirFile.getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "\\";

            FileReader fileReader = new FileReader(currentDir + "CompareOriginal");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            CompareFiles.add(new ArrayList<String>());
            while (bufferedReader.ready()) {
                CompareFiles.get(0).add(bufferedReader.readLine());
            }
            fileReader = new FileReader(currentDir + "CompareA");
            bufferedReader = new BufferedReader(fileReader);
            CompareFiles.add(new ArrayList<String>());
            while (bufferedReader.ready()) {
                CompareFiles.get(1).add(bufferedReader.readLine());
            }
            fileReader = new FileReader(currentDir + "CompareB");
            bufferedReader = new BufferedReader(fileReader);
            CompareFiles.add(new ArrayList<String>());
            while (bufferedReader.ready()) {
                CompareFiles.get(2).add(bufferedReader.readLine());
            }

            int maxOfNums = Math.max(CompareFiles.get(0).size(), Math.max(CompareFiles.get(1).size(), CompareFiles.get(2).size()));

            for(int k=0; k < maxOfNums;k++){
                CompareSortie.add(new String());
            }

            for(int i=0; i < maxOfNums; i++){
                for (int j = 0 ; j < 3; j++){
                    if(CompareFiles.get(j).size() > i){
                        if(!CompareFiles.get(j).get(i).isEmpty()){
                            if (CompareSortie.get(i).isEmpty() || CompareSortie.get(i).equals(CompareFiles.get(j).get(i))){
                                CompareSortie.set(i,CompareFiles.get(j).get(i));
                            }
                            else if (!CompareSortie.get(i).equals(CompareFiles.get(j).get(i))){
                                //DO SOMETHING BECAUSE OF CONFLIT NEED USER ACTION
                            }
                        }
                    }
                }
            }

            FileWriter writer = new FileWriter(currentDir + "CompareSortie");
            for(String str: CompareSortie) {
                writer.write(str + "\n");
            }
            writer.close();

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        String line;
        try{
            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch(IOException e){
            System.err.println("입력 중 오류 발생 " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try{
                if (br != null) br.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
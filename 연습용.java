import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class 연습용{
    public static void main(String[] args) throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(inputStreamReader);
        BufferedWriter bw = new BufferedWriter(outputStreamWriter);
        String string;

        while ((string = br.readLine()) != null ){
            bw.write(string);
            bw.newLine();
        }
        bw.flush();
    }
}

//StringTokenizer는 언제 쓰는거임?? 
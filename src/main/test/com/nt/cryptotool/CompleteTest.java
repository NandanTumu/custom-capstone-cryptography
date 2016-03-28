package test.com.nt.cryptotool;

import com.nt.cryptotool.miscobjects.Task;
import com.nt.cryptotool.objects.Key;
import com.nt.cryptotool.objects.TargetFile;
import com.nt.cryptotool.utils.Decrypter;
import com.nt.cryptotool.utils.Encrypter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.*;

/**
 * Created by Nandan on 3/28/2016.
 */
public class CompleteTest {

    private Key key;
    private TargetFile targetFileEncrypt;
    private TargetFile targetFileDecrypt;
    private Encrypter encrypter;
    private Decrypter decrypter;

    @Before
    public void setUp() throws Exception {
        key = new Key("password");
    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testCompleteProgram() throws Exception {
        targetFileEncrypt = new TargetFile("C://Users/Nandan/Desktop/RoboRealm_Crash.log", Task.Encrypt);
        encrypter = new Encrypter(targetFileEncrypt,key);
        encrypter.encryptFile();

        targetFileDecrypt = new TargetFile(targetFileEncrypt.getTargetFile().getAbsolutePath(),Task.Decrypt);
        decrypter = new Decrypter(targetFileDecrypt,key);
        decrypter.decryptFile();
        /*for(byte b:encrypter.getResultant()){
            System.out.print(b);
        }
        System.out.print("\n");
        for(byte b:decrypter.getResultant()){
            System.out.print(b);
        }*/
        assertEquals(decrypter.getResultant().length,encrypter.getResultant().length);
    }
}
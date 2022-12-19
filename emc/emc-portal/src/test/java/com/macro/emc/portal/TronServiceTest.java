package com.macro.emc.portal;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tron.trident.utils.Base58Check;

import static org.tron.trident.core.ApiWrapper.toHex;


@SpringBootTest
public class TronServiceTest {

//    @Autowired
//    private TronService tronService;

    @Test
    public void getAddress() {
        //tronService.createAddress(100);
        System.out.println(toHex(Base58Check.base58ToBytes("23AuP4i7C6pBzesqbwTrGZzcngN8yhKixJWDLuYvB2KuEFy3YZ")));
        //tronService.createAddress(1);
    }

    @Test
    public void validAddress(){
        //TFzL3yHoAmPA3sXcDeQczHGn6gcv1C4444
        //TFzL3yHoAmPA3sXcDeQczHGn6gcv1C4444
        String rsaPri = "77fc51be0a949171ea204e6dd2263828c4e19ade16d01fe7b8b0e292edfbdf35";
        System.out.println(RSAEncrypt.encrypt(rsaPri));
        System.out.println(RSAEncrypt.decrypt("dR8MjXhmAPnuclMnfFsCp967+HTkw9XdqZmX52SsZ4PqHDBujCwXv66qcAhkHuedKcmuir93JmYIezV7m8VwvBkuyFhhF1yyhKp5cNe0ijoPDIPRzLVrW40PUbZeW/XqtX/w6mg8lp0todwTVwI2QFSUqALYH1e3xV8Xhc61WHg="));
    }
    //JKUEI+9cFIYaRggDNbple9tt1O2/c5bc/evX9P076jFe3lNe4+FljKA3nchf1bXTsp5xU2xp5HkeGc03/YrS/NbfdNXJfyPlt1w1i73RoQL/3HnnN88OK62ftdlMU0aP3azBJHWJhCH2yXDJcZ59dEsvZwdzzyQ69pgd+QjpcH8=
    //Qo7inVbNlJAqQJwhyCoYzlZf5S46DeP85XfdZip3GdBa7eAsLStyTfpwYIipYnuSp3jt1Sx1LOPxhSqvRtCHFmsnSdFx+BB+g9kq2ocTI8dfDUCgLPEPiY/3dXXwdgO9HjoJewxh8KiMfAvcDsVdcQBGzfDEsx9J1qUrivKEJmQ=
//    @Test
//    public void getToAddress(){
//        tronService.UpdateToAddress();
//    }
//
//    @Test
//    public void advert(){
//        tronService.advert(1,3,"slogan1","2022102715544382",24,"267923907414069248");
//    }
//
//    @Test
//    public void updateTxStatus(){
//        tronService.UpdateTxStatus();
//    }
//
//    @Test
//    public void updateNet(){
//        tronService.UpdateAddressFreeNet();
//    }
//
//    @Test
//    public void a(){
//        tronService.UpdateAddressBalance();
//    }
//
//    @Test
//    public void b(){
//        System.out.println(tronService.getAccount("TLZTmEpPS8QS9sHkSMoak7JVQbuqShYLY7"));
//    }
    //TC54jGUzJY7XAFGa1Sbk5MP829AUrSVjHs
    @Test
    public void send(){
        String from = "TPyBhKgetC7mZorjC1cUypFsYeoo1P5555";
        String to ="TFzYnqLcMv37HbiFiQpnbEGrcpn2iQCDCr";
        String pri = "dR8MjXhmAPnuclMnfFsCp967+HTkw9XdqZmX52SsZ4PqHDBujCwXv66qcAhkHuedKcmuir93JmYIezV7m8VwvBkuyFhhF1yyhKp5cNe0ijoPDIPRzLVrW40PUbZeW/XqtX/w6mg8lp0todwTVwI2QFSUqALYH1e3xV8Xhc61WHg=";
        //tronService.send(from,to,6L,pri);
    }

//    @Test
//    public void sendToMany(){
//        tronService.sendToMany();
//    }

}

package demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestWithData {

    @Test(dataProvider = "numeroPprovider")
    public void  suma(int numero){
        Assert.assertTrue(numero > 0);
        System.out.println("Numero: " + numero);
    }

    @DataProvider(name = "numeroPprovider")
    public  Object[][] methodNumeroProvider(){
        return  new Object[][]{
                {5}, {6}, {-6}
        };
    }
}

/**
 * Nombre Correo          Apellido
 * Laura Laura@creativa
 *
 *
 *
 *
 */
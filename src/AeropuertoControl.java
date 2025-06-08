import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class AeropuertoControl {
    private static void latencia() {
        try {
            TimeUnit.SECONDS.sleep(3); }
        catch(InterruptedException e){
        Thread.currentThread().interrupt();
        }
    }

    public static CompletableFuture<Boolean> verificarPista(){
        return CompletableFuture.supplyAsync(() -> {
            latencia(); boolean disponible = new Random().nextBoolean();
            System.out.println("Pista Disponible: " + disponible);
            return disponible;
        }).exceptionally(ex -> {
            return false;
        });
    }
    public static CompletableFuture<Boolean> verificarClima(){
        return CompletableFuture.supplyAsync(() -> {
            latencia(); boolean favorable = new Random().nextBoolean();
            System.out.println("Clima Favorable: " + favorable);
            return favorable;
        }).exceptionally(ex -> {
            return false;
        });
    }
    public static CompletableFuture<Boolean> verificarTraficoAereo(){
        return CompletableFuture.supplyAsync(() -> {
            latencia(); boolean despejado = new Random().nextBoolean();
            System.out.println("Tráfico Aéreo Despejado: " + despejado);
            return despejado;
        }).exceptionally(ex -> {
            return false;
        });
    }
    public static CompletableFuture<Boolean> verificarPersonalTierra(){
        return CompletableFuture.supplyAsync(() -> {
            latencia(); boolean disponible = new Random().nextBoolean();
            System.out.println("Personal disponible:    " + disponible);
            return disponible;
        }).exceptionally(ex -> {
            return false;
        });
    }
}
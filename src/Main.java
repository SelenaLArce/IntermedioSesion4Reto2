import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Verificando Condiciones Para Aterrizaje...");

        CompletableFuture<Boolean> pista = AeropuertoControl.verificarPista();
        CompletableFuture<Boolean> clima = AeropuertoControl.verificarClima();
        CompletableFuture<Boolean> trafico = AeropuertoControl.verificarTraficoAereo();
        CompletableFuture<Boolean> personal = AeropuertoControl.verificarPersonalTierra();

        CompletableFuture<Void> Verificaciones = CompletableFuture.allOf(pista,
                clima, trafico, personal);
        Verificaciones.thenRun(() -> {
            try {
                boolean pistaOk = pista.get();
                boolean climaOk = clima.get();
                boolean traficoOk = trafico.get();
                boolean personalOk = personal.get();
                if (pistaOk && climaOk && traficoOk && personalOk) {
                    System.out.println("Aterrizaje Autorizado: Todas las condiciones óptimas.");
                } else {
                    System.out.println("Aterrizaje Denegado: Condiciones no óptimas.");
                }
            } catch (Exception e) {
                System.out.println("Aterrizaje Denegado: Condiciones no óptimas.");
            }
        }).exceptionally(ex -> {
            System.out.println("Aterrizaje Denegado: Condiciones no óptimas.");
            return null;
        }).join();
    }
}
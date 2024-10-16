public class CentroGalactico extends Planeta {
    @Override
    public boolean visitar(Jugador jugador) { 
        
        setJugador(jugador);
        
        GameUtils.animarTexto("\nPreparando viaje");
        GameUtils.animarPuntos("...");
        GameUtils.mostrarBarraProgreso(4000); 
        GameUtils.animarTexto("\n¡Has llegado al centro galactico!\n");
        GameUtils.animarTexto("\n¡Felicidades, has ganado!\n");

        
        return true;
    }
}

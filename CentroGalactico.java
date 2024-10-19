public class CentroGalactico extends Planeta {
    
    public CentroGalactico(){
        setNamePlaneta("Centro Galactico");
    }

    /**
     * Nombre: visitar
     * 
     * Descripción: Método que permite al jugador visitar el Centro Galáctico. Despliega una secuencia animada que describe la llegada al centro galactico
     * 
     * Parámetros:
     * Jugador jugador - El jugador que está visitando el Centro Galáctico.
     * 
     * Retorno:
     * boolean - Retorna true al finalizar, indicando que el jugador ha completado la visita y ha terminado el juego.
     */
    @Override
    public boolean visitar(Jugador jugador) { 
        setJugador(jugador);

        System.out.println("\n---------------------------------------------");
        GameUtils.animarTexto("\nPreparando viaje al Centro Galáctico");
        GameUtils.animarPuntos("...\n");
        GameUtils.mostrarBarraProgreso(4000); 
        
       
        GameUtils.animarTexto("\n---------------------------------------------\n");
        GameUtils.animarTexto("\nUn destello brillante llena tu nave mientras te aproximas al centro del universo.\n");
        GameUtils.animarTexto("A medida que te acercas, las estrellas parecen desaparecer, absorbidas por una luz cegadora.\n");
        GameUtils.animarTexto("Finalmente, después de todo tu esfuerzo, de todos los planetas visitados y los recursos recolectados");
        GameUtils.animarPuntos("...");
        
        
        GameUtils.animarTexto("\n¡Has llegado al Centro Galáctico!\n");
        GameUtils.animarTexto("\nMientras te adentras en este lugar místico, sientes como si todo el universo estuviera a tus pies.\n");
        GameUtils.animarTexto("Es aquí, donde la historia del universo se conecta, donde cada átomo se entrelaza y el tiempo mismo se detiene.\n");
        GameUtils.animarTexto("Con tu energía renovada y tus habilidades perfeccionadas, te das cuenta de que este es solo el comienzo de algo aún mayor...\n");
        GameUtils.animarTexto("Pues es un sitio bastante peligroso");
        GameUtils.animarPuntos("...");
        
        GameUtils.animarTexto("\n---------------------------------------------\n");
        GameUtils.animarTexto("\n¡Felicidades, " + jugador.getNamePJ() + "!\n");
        GameUtils.animarTexto("¡Has logrado lo que pocos soñaron: conquistar las estrellas y desvelar los misterios del cosmos!\n");
        GameUtils.animarTexto("\nEl viaje ha concluido, pero tu leyenda será recordada por siempre...\n");
        GameUtils.animarTexto("\n¡Has ganado!\n");

        
        
        
        GameUtils.animarTexto("\n---------------------------------------------\n");
        GameUtils.animarTexto("\nFin de la exploración. Gracias por jugar.");
        GameUtils.animarPuntos("...");
        GameUtils.animarTexto("\nPara explorar el Centro Galactico favor comprar DLC No Java Sky: Centro Galactico. $50 usd\n\n");
        
        return true;
    }

}

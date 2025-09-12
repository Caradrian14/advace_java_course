package org.example.prueba_lectura3;
import java.util.*;

public class answer {
    public static void main(String[] args) {
        // Mapas de entrada
        Map<String, Integer> channelToSubscribers = new TreeMap<>();
        channelToSubscribers.put("JustForLaughs", 120_000);
        channelToSubscribers.put("JustForGags", 10_000);
        channelToSubscribers.put("ContemplationTechniques", 10_000);
        channelToSubscribers.put("A New Earth", 20_000);

        Map<String, String> channelToPublisher = new TreeMap<>();
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        // Mapa para almacenar el resultado: publisher -> total subscribers
        Map<String, Integer> publisherToSubscribers = new TreeMap<>();

        // 1. Usar forEach para llenar publisherToSubscribers
        channelToSubscribers.forEach((channel, subscribers) -> {
            String publisher = channelToPublisher.get(channel);
            publisherToSubscribers.merge(publisher, subscribers, Integer::sum);
        });

        // 2. Usar forEach para mostrar publisherToSubscribers
        System.out.println("Publisher to Subscribers:");
        publisherToSubscribers.forEach((publisher, subscribers) ->
                System.out.printf("publisher: %s; numSubscribers:%d%n", publisher, subscribers)
        );

        // 3. Calcular el publisher con más y menos suscriptores
        Map.Entry<String, Integer> maxEntry = Collections.max(publisherToSubscribers.entrySet(), Map.Entry.comparingByValue());
        Map.Entry<String, Integer> minEntry = Collections.min(publisherToSubscribers.entrySet(), Map.Entry.comparingByValue());

        System.out.printf("Publisher with most subscribers: %s %d%n", maxEntry.getKey(), maxEntry.getValue());
        System.out.printf("Publisher with fewest subscribers: %s %d%n", minEntry.getKey(), minEntry.getValue());
    }
}

package HASH;

import java.util.HashMap;
import java.util.Set;

public class HashTest {
    public static void main(String[] args) {
        Hash hash = new Hash();
        HashMap<String, String> trackList = hash.trackList();
        System.out.println("Lista de canciones:");
        for (String cancion : trackList.keySet()) {
            String artista = trackList.get(cancion);
            System.out.println("cancion: " + cancion); 
            System.out.println(" letra: " + artista);
        }
    }
}




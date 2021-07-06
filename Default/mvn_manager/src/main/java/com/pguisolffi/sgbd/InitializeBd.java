package com.pguisolffi.sgbd;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class InitializeBd {

    public InitializeBd() throws IOException {

        FileInputStream serviceAccount = new FileInputStream(
                "C:/Projetos/demo/src/main/java/com/example/credencialArquivos/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

        boolean hasBeenInitialized = false;
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        for (FirebaseApp app : firebaseApps) {
            if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                hasBeenInitialized = true;
                // finestayApp = app;
            }
        }

        if (!hasBeenInitialized)
            FirebaseApp.initializeApp(options);

    }

}
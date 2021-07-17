//package Default;
package com.pguisolffi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.pguisolffi.sgbd.Bd_Set;
import com.pguisolffi.sgbd.Bd_get;
import com.pguisolffi.sgbd.InitializeBd;

import javax.swing.JPanel;

//import com.pguisolffi.Configuracoes;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Mesa;
import com.pguisolffi.Telas.Tela_Principal;
import com.pguisolffi.Utilidades.MinhasThreads;

public class App {

    public static Firestore db;

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        // InitializeBd ini = new InitializeBd();
        // new Bd_Set().BD_Set_Manual();
        // Bd_get update = new Bd_get();
        // update.Get_ItensAtendimento();
        // PainelPrincipal pp = new PainelPrincipal();
        Tela_Principal tela_principal = new Tela_Principal();
        // MinhasThreads minha = new MinhasThreads("name da Thread");

    }
}

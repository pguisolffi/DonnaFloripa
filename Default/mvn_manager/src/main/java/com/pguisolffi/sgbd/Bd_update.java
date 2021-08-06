package com.pguisolffi.sgbd;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

public class Bd_update {

    public void BD_Update_Status_Atend_Delivery(int numeroPedido,String status)
                throws InterruptedException, ExecutionException, IOException {

        Firestore db = FirestoreClient.getFirestore();
        
        //CRIA REFERENCIA A BASE DE DADOS         
        CollectionReference baseAtendimento = db.collection("Atendimento");

        //BUSCA TODAS AS INFORMAÇÕES CONFORME A QUERY
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("pedido", numeroPedido);
        
        //GUARDA A INFORMAÇÃO COMPLETA DA QUERY
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        //CRIA UMA LISTA DE DOCUMENTOS RETORNADOS NA QUERY
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        //PARA CADA DOCUMENTO O SISTEMA ATUALIZA O STATUS
        for (int x = 0; x < documents.size(); x++ ) {

            documents.get(x).getReference().update("status", status);              
        }
    }

    public void BD_Update_Status_Atend_Mesa(int pedidoMesa,String status) throws InterruptedException, ExecutionException, IOException {

            Firestore db = FirestoreClient.getFirestore();

            //CRIA REFERENCIA A BASE DE DADOS         
            CollectionReference baseAtendimento = db.collection("Atendimento");

            //BUSCA TODAS AS INFORMAÇÕES CONFORME A QUERY
            com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("pedido", pedidoMesa).whereEqualTo("status", status.equals("Consumindo") ? "Preparando" : "Consumindo");

            //GUARDA A INFORMAÇÃO COMPLETA DA QUERY
            ApiFuture<QuerySnapshot> querySnapshot = query.get();

            //CRIA UMA LISTA DE DOCUMENTOS RETORNADOS NA QUERY
            List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

            //PARA CADA DOCUMENTO O SISTEMA ATUALIZA O STATUS
            for (int x = 0; x < documents.size(); x++ ) {

                documents.get(x).getReference().update("status", status);              
            }
    }

    public void BD_Update_dtFim_Atendimento(int numeroPedido,String datafinal)
    throws InterruptedException, ExecutionException, IOException {

        Firestore db = FirestoreClient.getFirestore();

        //CRIA REFERENCIA A BASE DE DADOS         
        CollectionReference baseAtendimento = db.collection("Atendimento");

        //BUSCA TODAS AS INFORMAÇÕES CONFORME A QUERY
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("pedido", numeroPedido);

        //GUARDA A INFORMAÇÃO COMPLETA DA QUERY
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        //CRIA UMA LISTA DE DOCUMENTOS RETORNADOS NA QUERY
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        //PARA CADA DOCUMENTO O SISTEMA ATUALIZA O STATUS
        for (int x = 0; x < documents.size(); x++ ) {

            documents.get(x).getReference().update("dtFim", datafinal);              
        }
    }
}
